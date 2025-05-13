import java.util.Scanner;
import java.util.function.Function;

public class CuadraturaGaussiana {
    // Instanciación de Scanner para leer la entrada del usuario
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Mensaje introductorio y descripción del método de cuadratura gaussiana
        System.out.println("INTEGRACIÓN NUMÉRICA (CUADRATURA GAUSSIANA)");
        System.out.println("---------------------------------------------");
        
        // Solicita al usuario que ingrese la función matemática
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));
        
        // Se crea una función anónima para evaluar la expresión con el valor de 'x'
        System.out.println("Introduzca el límite inferior de integración (a): ");
        double a = scanner.nextDouble();
        
        // Solicita los límites de integración
        System.out.println("Introduzca el límite superior de integración (b): ");
        double b = scanner.nextDouble();
        
        // Calcula la integral usando la cuadratura gaussiana de 2 puntos
        double integral = gauss2Puntos(f, a, b);
        
        // Muestra el resultado de la integral calculada
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Cuadratura Gaussiana de 2 puntos");
    }

    /**
     * Método que implementa la cuadratura gaussiana de 2 puntos para la integración numérica.
     * 
     * @param f Función matemática a integrar.
     * @param a Límite inferior de integración.
     * @param b Límite superior de integración.
     * @return Valor aproximado de la integral en el intervalo [a, b].
     */
    private static double gauss2Puntos(Function<Double, Double> f, double a, double b) {
        double[] puntos = { -Math.sqrt(1.0 / 3), Math.sqrt(1.0 / 3) };
        double[] pesos = { 1.0, 1.0 }; 
        
        double c1 = (b - a) / 2.0;
        double c2 = (b + a) / 2.0;
        
        double resultado = 0.0;
        for (int i = 0; i < puntos.length; i++) {
            double x = c1 * puntos[i] + c2;
            resultado += pesos[i] * f.apply(x);
        }
        
        return c1 * resultado;
    }

    /**
     * Método para evaluar una expresión matemática representada como un String.
     * 
     * @param expr Expresión matemática que contiene la variable 'x'.
     * @return El valor numérico resultante de la evaluación de la expresión.
     */
    private static double evaluarFuncion(String expr) {
         try {
            return new Object() {
                int pos = -1, ch;
                
                // Método para avanzar al siguiente carácter en la expresión
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }
               
                // Método para consumir un carácter específico
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
               
                // Método principal que inicia el proceso de evaluación
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                 // Método para analizar una expresión matemática con operadores básicos
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                // Método para analizar los términos (productos y divisiones)
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
               
                // Método para analizar factores (números y funciones)
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