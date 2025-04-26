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

    }

    private static double evaluarFuncion(String expr) {

    }
}