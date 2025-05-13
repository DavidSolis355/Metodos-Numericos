import java.util.Scanner;

public class InterpolacionPolinomial {
    public static void main(String[] args) {
        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.println("Interpolación Polinómica (Método de Lagrange)");
        System.out.println("------------------------------------------------");

        // Leer el número de puntos de datos
        System.out.println("Introduce el número de puntos:");
        int n = scanner.nextInt();

        // Arreglos para almacenar las coordenadas x y y
        double[] x = new double[n];
        double[] y = new double[n];

        // Leer los puntos (x, y) del usuario
        System.out.println("Introduce los puntos (x, y):");
        for (int i = 0; i < n; i++) {
            System.out.print("Punto " + (i + 1) + " - x" + (i + 1) + ": ");
            x[i] = scanner.nextDouble();
            System.out.print("Punto " + (i + 1) + " - y" + (i + 1) + ": ");
            y[i] = scanner.nextDouble();
        }

        // Leer el valor de x en el que se desea calcular el valor interpolado
        System.out.println("Introduce el valor de x en el que deseas interpolar:");
        double valorX = scanner.nextDouble();

        // Calcular el valor interpolado usando la fórmula de Lagrange
        double resultado = interpolacionLagrange(x, y, valorX, n);

        // Mostrar el resultado
        System.out.printf("El valor interpolado en x = %.2f es: %.5f%n", valorX, resultado);
    }

     /**
     * Método que calcula la interpolación polinómica de Lagrange.
     *
     * @param x Arreglo con los valores de x.
     * @param y Arreglo con los valores de y.
     * @param valorX El valor de x en el que se desea interpolar.
     * @param n El número de puntos.
     * @return El valor interpolado en valorX.
     */
    public static double interpolacionLagrange(double[] x, double[] y, double valorX, int n) {
        double resultado = 0.0;

        // Aplicar la fórmula de Lagrange
        for (int i = 0; i < n; i++) {
            double term = y[i];

            // Calcular el término correspondiente al punto i
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    term *= (valorX - x[j]) / (x[i] - x[j]);
                }
            }

            // Sumar el término al resultado final
            resultado += term;
        }

        return resultado;
    }
}