import java.util.Scanner;
import java.util.function.Function;

public class CuadraturaGaussiana {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("INTEGRACIÓN NUMÉRICA (CUADRATURA GAUSSIANA)");
        System.out.println("---------------------------------------------");
        
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));
        
        System.out.println("Introduzca el límite inferior de integración (a): ");
        double a = scanner.nextDouble();
        
        System.out.println("Introduzca el límite superior de integración (b): ");
        double b = scanner.nextDouble();
        
        double integral = gauss2Puntos(f, a, b);
        
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Cuadratura Gaussiana de 2 puntos");
    }

    private static double gauss2Puntos(Function<Double, Double> f, double a, double b) {

    }

    private static double evaluarFuncion(String expr) {

    }



}