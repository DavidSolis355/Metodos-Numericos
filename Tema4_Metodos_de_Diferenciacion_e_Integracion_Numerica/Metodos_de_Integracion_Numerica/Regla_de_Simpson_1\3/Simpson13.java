import java.util.Scanner;
import java.util.function.Function;

public class Simpson13 {

    // Método principal que ejecuta la integración numérica utilizando la regla de Simpson 1/3.
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Mensaje de bienvenida
        System.out.println("INTEGRACIÓN NUMÉRICA (REGLA DE SIMPSON 1/3)");
        System.out.println("---------------------------------------------");
        
        // Solicitar al usuario la función matemática a integrar
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();

        // Crear una expresión funcional que evalúa la función en términos de x
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));
        
        // Solicitar los límites de integración
        System.out.println("Introduzca el límite inferior de integración (a): ");
        double a = scanner.nextDouble();
        
        System.out.println("Introduzca el límite superior de integración (b): ");
        double b = scanner.nextDouble();

        // Solicitar el número de subintervalos
        System.out.println("Introduzca el número de subintervalos (n): ");
        int n = scanner.nextInt();
        
        // Asegurar que el número de subintervalos sea par
        if (n % 2 != 0) {
            System.out.println("El número de subintervalos debe ser par. Incrementando en 1.");
            n++;
        }

        // Calcular la integral usando la regla de Simpson 1/3
        double integral = simpson13(f, a, b, n);
        
        // Mostrar el resultado
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Regla de Simpson 1/3");
    }

    // Método que aplica la regla de Simpson 1/3 para la integración numérica
    private static double simpson13(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n;
        
        double suma = f.apply(a) + f.apply(b);
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 == 0) {
                suma += 2 * f.apply(x);
            } else {
                suma += 4 * f.apply(x);
            }
        }
        
        return h / 3 * suma;
    }
    
    // Método para evaluar la función proporcionada por el usuario (parser de expresiones)
    private static double evaluarFuncion(String expr) {
        try {
            return new Object() {
                int pos = -1, ch;
               
                // Método para avanzar en la expresión
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }
               
                // Método para comer (descartar) un carácter específico
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
               
                // Método principal de análisis que devuelve el valor de la expresión
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                // Método que analiza expresiones (sumas y restas)
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                // Método que analiza términos (multiplicación, división, y potenciación)
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
               
                // Método que analiza factores (números, funciones y paréntesis)
                double parseFactor() {
                    if (eat('+')) return parseFactor();
                    if (eat('-')) return -parseFactor();
                    double x;
                    int startPos = this.pos;
                    if (eat('(')) {
                        x = parseExpression();
                        eat(')');
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(expr.substring(startPos, this.pos));
                    } else if (ch >= 'a' && ch <= 'z') {
                        while (ch >= 'a' && ch <= 'z') nextChar();
                        String func = expr.substring(startPos, this.pos);
                        x = parseFactor();
                        switch (func) {
                            case "sqrt": x = Math.sqrt(x); break;
                            case "sin": x = Math.sin(x); break;
                            case "cos": x = Math.cos(x); break;
                            case "tan": x = Math.tan(x); break;
                            case "log": x = Math.log(x); break;
                            case "exp": x = Math.exp(x); break;
                            default: throw new RuntimeException("Función desconocida: " + func);
                        }
                    } else {
                        throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    }
                    return x;
                }
            }.parse();
        } catch (Exception e) {
            throw new RuntimeException("Error al evaluar la función: " + e.getMessage());
        }
    }
}