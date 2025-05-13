import java.util.Scanner;
import java.util.function.Function;

public class Diferenciacion5Puntos {

     // Método principal que ejecuta la diferenciación numérica usando el método de 5 puntos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        // Mensaje de introducción al usuario
        System.out.println("DIFERENCIACIÓN NUMÉRICA (MÉTODO DE 5 PUNTOS)");
        System.out.println("---------------------------------------------");
       
        // Solicita al usuario la función a evaluar
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));
       
        // Convierte la cadena de la función a una expresión evaluable
        System.out.println("Introduzca el punto donde calcular la derivada (x0): ");
        double x0 = scanner.nextDouble();
       
        // Solicita al usuario el punto donde calcular la derivada
        System.out.println("Introduzca el tamaño del paso (h): ");
        double h = scanner.nextDouble();

        // Solicita al usuario el tamaño del paso
        double derivada = (-f.apply(x0 + 2*h) + 8*f.apply(x0 + h) - 8*f.apply(x0 - h) + f.apply(x0 - 2*h)) / (12 * h);

        // Muestra el resultado de la derivada aproximada
        System.out.println("\nRESULTADO:");
        System.out.printf("f'(%.4f) ≈ %.12f%n", x0, derivada);
        System.out.println("Fórmula utilizada: [-f(x+2h) + 8f(x+h) - 8f(x-h) + f(x-2h)] / (12h)");
    }

    // Método que evalúa una cadena de expresión matemática y devuelve el resultado
    private static double evaluarFuncion(String expr) {
        try {
            return new Object() {
                int pos = -1, ch;
               
                // Método para leer el siguiente carácter de la expresión
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }
               
                // Método para "comer" caracteres que son esperados
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
               
                 // Método principal que inicia el proceso de análisis de la expresión
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                // Método que maneja expresiones (sumas y restas)
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                // Método que maneja términos (multiplicación, división y potencias)
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
                
                // Método que maneja factores (números, funciones, paréntesis)
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