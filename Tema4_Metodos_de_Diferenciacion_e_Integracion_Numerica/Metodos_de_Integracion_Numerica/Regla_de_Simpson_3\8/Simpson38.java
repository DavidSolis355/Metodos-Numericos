import java.util.Scanner;
import java.util.function.Function;

public class Simpson38 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("INTEGRACIÓN NUMÉRICA (REGLA DE SIMPSON 3/8)");
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
        
        if (n % 3 != 0) {
            System.out.println("El número de subintervalos debe ser múltiplo de 3. Ajustando n.");
            n = (n / 3) * 3;
        }
        
        double integral = simpson38(f, a, b, n);
        
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Regla de Simpson 3/8");
    }

    private static double simpson38(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n;

        double suma = f.apply(a) + f.apply(b);
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 3 == 0) {
                suma += 2 * f.apply(x); 
            } else {
                suma += 3 * f.apply(x);
            }
        }
        
        return 3 * h / 8 * suma;
    }

    private static double evaluarFuncion(String expr) {

    }
}