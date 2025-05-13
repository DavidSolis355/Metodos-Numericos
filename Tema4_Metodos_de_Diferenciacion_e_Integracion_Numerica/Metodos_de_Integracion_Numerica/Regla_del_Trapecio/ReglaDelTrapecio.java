import java.util.Scanner;
import java.util.function.Function;

public class ReglaDelTrapecio {

    public static void main(String[] args) {
        // Inicialización de la entrada de datos desde la consola
        Scanner scanner = new Scanner(System.in);
        
        // Mensaje inicial explicando el propósito del programa
        System.out.println("INTEGRACIÓN NUMÉRICA (REGLA DEL TRAPECIO)");
        System.out.println("---------------------------------------------");
        
        // Solicita al usuario ingresar la función matemática que se desea integrar
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));

        // Define la función a evaluar usando una expresión matemática que depende de 'x'
        System.out.println("Introduzca el límite inferior de integración (a): ");
        double a = scanner.nextDouble();
        
        // Solicita al usuario los límites de integración y el número de subintervalos
        System.out.println("Introduzca el límite superior de integración (b): ");
        double b = scanner.nextDouble();
        
        // Calcula la integral usando la regla del trapecio
        System.out.println("Introduzca el número de subintervalos (n): ");
        int n = scanner.nextInt();
        
        double integral = trapecio(f, a, b, n);
        
        // Muestra el resultado de la integración
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Regla del Trapecio");
    }

     /**
     * Método que aplica la regla del trapecio para calcular la integral de la función
     * entre los límites 'a' y 'b' usando 'n' subintervalos.
     * 
     * @param f  La función a integrar
     * @param a  El límite inferior de integración
     * @param b  El límite superior de integración
     * @param n  El número de subintervalos
     * @return   El valor aproximado de la integral
     */
    private static double trapecio(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n;
        
        double suma = (f.apply(a) + f.apply(b)) / 2.0;

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += f.apply(x);
        }

        return h * suma;
    }

     /**
     * Método que evalúa una función matemática representada como una cadena de texto.
     * La función puede contener operaciones aritméticas estándar, así como funciones
     * matemáticas comunes (sqrt, sin, cos, log, exp).
     * 
     * @param expr La cadena que representa la función a evaluar
     * @return     El valor de la función evaluada
     */
    private static double evaluarFuncion(String expr) {
        try {
            return new Object() {
                int pos = -1, ch;

                // Avanza al siguiente carácter en la expresión
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }
               
                // Consume un carácter específico
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
               
                // Inicia la evaluación de la expresión
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                // Analiza expresiones aritméticas de suma y resta
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                // Analiza expresiones de multiplicación, división y potenciación
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
                // Analiza números, paréntesis y funciones matemáticas
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