import java.util.Scanner;
import java.util.Random;

// Clase que implementa el método de Gauss-Seidel para resolver sistemas de ecuaciones lineales
public class GaussSeidel {

     // Método principal que ejecuta el algoritmo de Gauss-Seidel
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         // Solicita al usuario el tamaño de la matriz (número de ecuaciones y variables)
        System.out.print("Introduce el tamaño de la matriz: ");
        int orden = sc.nextInt();

        // Genera aleatoriamente una matriz aumentada de tamaño [orden x (orden + 1)]
        double[][] matriz = generarMatriz(orden);
        
        // Muestra la matriz inicial
        System.out.println("\nMatriz inicial:");
        mostrarMatriz(matriz, orden);

        // Aproximaciones iniciales de las variables (todas en 0)
        double[] x = new double[orden]; // Aproximaciones iniciales (todas en 0)
        double tolerancia = 1e-6;
        int iteracionesMax = 100;
        int iteracion = 0;
        boolean converge = false;

        // Iteraciones del método de Gauss-Seidel
        while (!converge && iteracion < iteracionesMax) {
            double[] xAnterior = x.clone();
            System.out.printf("\nIteración %d:\n", iteracion + 1);

            // Actualización de las variables
            for (int i = 0; i < orden; i++) {
                double suma = 0;
                for (int j = 0; j < orden; j++) {
                    if (j != i) {
                        suma += matriz[i][j] * x[j];
                    }
                }
                x[i] = (matriz[i][orden] - suma) / matriz[i][i];
                System.out.printf("x%d = %.6f\n", i, x[i]);
            }
             // Comprobación de convergencia (si la diferencia es menor que la tolerancia)
            converge = true;
            for (int i = 0; i < orden; i++) {
                if (Math.abs(x[i] - xAnterior[i]) > tolerancia) {
                    converge = false;
                    break;
                }
            }
            iteracion++;
        }

        // Muestra la solución final si la convergencia se alcanzó
        if (converge) {
            System.out.println("\nSolución encontrada:");
            for (int i = 0; i < orden; i++) {
                System.out.printf("x%d = %.6f\n", i, x[i]);
            }
        } else {
            System.out.println("\nNo se alcanzó la convergencia en " + iteracionesMax + " iteraciones.");
        }
        // Cierra el scanner
        sc.close();
    }

    /**
     * Genera una matriz aumentada aleatoria de tamaño n x (n+1).
     * La matriz contiene coeficientes aleatorios entre -5 y 4.
     * Además, asegura que los pivotes no sean cero para la estabilidad numérica.
     *
     * @param orden número de ecuaciones (y variables)
     * @return matriz aumentada generada aleatoriamente
     */
    public static double[][] generarMatriz(int orden) {
        Random rand = new Random();
        double[][] matriz = new double[orden][orden + 1];

        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden + 1; j++) {
                matriz[i][j] = rand.nextInt(10) - 5; // Números entre -5 y 4
            }
            // Asegurar que los pivotes no sean 0 para estabilidad
            if (matriz[i][i] == 0) {
                matriz[i][i] = rand.nextInt(5) + 1;
            }
        }

        return matriz;
    }

    /**
     * Muestra la matriz aumentada en consola con formato.
     *
     * @param matriz la matriz a mostrar
     * @param orden  el número de ecuaciones (filas) de la matriz
     */
    public static void mostrarMatriz(double[][] matriz, int orden) {
        for (int i = 0; i < orden; i++) {
            String linea = "| ";
            for (int j = 0; j < orden + 1; j++) {
                linea += String.format("%8.3f", matriz[i][j]) + " ";
            }
            linea += "|";
            System.out.println(linea);
        }
        System.out.println();
    }
}