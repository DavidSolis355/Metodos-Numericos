import java.util.Scanner;

public class InterpolacionLineal {
    public static void main(String[] args) {
         // Crear un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Interpolación Lineal");
        System.out.println("---------------------");

        // Entrada de los dos puntos conocidos (x0, y0) y (x1, y1)
        System.out.println("Introduzca el valor de x0:");
        double x0 = scanner.nextDouble();
        System.out.println("Introduzca el valor de y0:");
        double y0 = scanner.nextDouble();

        System.out.println("Introduzca el valor de x1:");
        double x1 = scanner.nextDouble();
        System.out.println("Introduzca el valor de y1:");
        double y1 = scanner.nextDouble();

        // Entrada del valor para el cual se quiere estimar y
        System.out.println("Introduzca el valor de x para el cual desea estimar y:");
        double x = scanner.nextDouble();

        // Calcular el valor de y usando la fórmula de interpolación lineal
        double y = interpolar(x0, y0, x1, y1, x);

        // Mostrar el resultado
        System.out.printf("El valor estimado de y en x = %.2f es: %.4f%n", x, y);
    }

    /**
     * Método para calcular el valor de y usando la interpolación lineal.
     * 
     * @param x0 el primer valor conocido de x
     * @param y0 el valor correspondiente de y para x0
     * @param x1 el segundo valor conocido de x
     * @param y1 el valor correspondiente de y para x1
     * @param x el valor de x para el cual se quiere estimar y
     * @return el valor estimado de y
     */
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        // Fórmula de interpolación lineal
        return y0 + (x - x0) * (y1 - y0) / (x1 - x0);
    }
}