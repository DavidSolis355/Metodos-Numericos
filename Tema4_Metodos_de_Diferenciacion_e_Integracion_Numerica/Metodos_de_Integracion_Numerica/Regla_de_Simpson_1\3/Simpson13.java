import java.util.Scanner;
import java.util.function.Function;

public class Simpson13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("INTEGRACIÓN NUMÉRICA (REGLA DE SIMPSON 1/3)");
        System.out.println("---------------------------------------------");
        
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));
        
        System.out.println("Introduzca el límite inferior de integración (a): ");
        double a = scanner.nextDouble();
        
        System.out.println("Introduzca el límite superior de integración (b): ");
        double b = scanner.nextDouble();

        System.out.println("Introduzca el número de subintervalos (n): ");
        int n = scanner.nextInt();
        
        if (n % 2 != 0) {
            System.out.println("El número de subintervalos debe ser par. Incrementando en 1.");
            n++;
        }
        
        double integral = simpson13(f, a, b, n);
        
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Regla de Simpson 1/3");
    }

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

    private static double evaluarFuncion(String expr) {
        try {
            return new Object() {
                int pos = -1, ch;
               
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }
               
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
               
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
               
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