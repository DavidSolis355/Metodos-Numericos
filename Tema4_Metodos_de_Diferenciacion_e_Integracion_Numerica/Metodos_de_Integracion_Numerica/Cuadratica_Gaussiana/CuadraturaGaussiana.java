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

    private static double evaluarFuncion(String expr) {

    }



}