import java.util.Scanner;
import java.util.Random;

// Clase que implementa el método de Gauss-Jordan para resolver sistemas de ecuaciones lineales
public class GaussJordan {

    // Método principal para ejecutar el algoritmo de Gauss-Jordan
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Solicita al usuario el tamaño del sistema (número de ecuaciones y variables)
        System.out.print("Introduce el tamaño de la matriz: ");
        int orden = sc.nextInt();
        
        // Genera aleatoriamente una matriz aumentada de tamaño [orden x (orden + 1)]
        double[][] matriz = generarMatriz(orden);
        
        // Muestra la matriz inicial
        System.out.println("\nMatriz inicial:");
        mostrarMatriz(matriz, orden);

        // Proceso de eliminación de Gauss-Jordan
        for (int i = 0; i < orden; i++) {
            // Elige el pivote (elemento diagonal)
            double pivote = matriz[i][i];

            // Verifica si el pivote es cero, lo cual causaría una división por cero
            if (pivote == 0) {
                System.out.println("Error: pivote cero.");
                return;
            }
            // Normaliza la fila dividiendo por el pivote
            System.out.printf("\nNormalizando fila %d (dividir entre %.3f):\n", i + 1, pivote);
            for (int j = 0; j < orden + 1; j++) {
                matriz[i][j] /= pivote;
            }
            // Muestra el estado de la matriz después de la normalización
            mostrarMatriz(matriz, orden);
            
            // Elimina los elementos debajo y encima del pivote para hacer la matriz diagonal
            for (int k = 0; k < orden; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    System.out.printf("Haciendo cero el elemento en fila %d, columna %d (usando fila %d):\n", k + 1, i + 1, i + 1);
                    for (int j = 0; j < orden + 1; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                    // Muestra el estado de la matriz después de la eliminación
                    mostrarMatriz(matriz, orden);
                }
            }
        }
        
        // Muestra la solución final, que estará en la última columna de la matriz
        System.out.println("Solución final:");
        for (int i = 0; i < orden; i++) {
            System.out.printf("x%d = %.3f\n", i, matriz[i][orden]);
        }
        
        // Cierra el escáner
        sc.close();
    }

    /**
     * Genera una matriz aumentada aleatoria de tamaño n x (n+1).
     * La matriz contiene coeficientes aleatorios entre -5 y 4.
     *
     * @param orden número de ecuaciones (y variables)
     * @return matriz aumentada generada aleatoriamente
     */
    public static double[][] generarMatriz(int orden) {
        Random rand = new Random();
        double[][] matriz = new double[orden][orden + 1];
        
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden + 1; j++) {
                matriz[i][j] = rand.nextInt(10) - 5;
            }
        }
        
        return matriz;
    }

     /**
     * Muestra la matriz aumentada en consola con formato
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
        // Imprime una línea vacía para separar las matrices
        System.out.println();
    }
}