import java.util.Scanner;
import java.util.Random;

public class GaussJordan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el tamaño de la matriz: ");
        int orden = sc.nextInt();
        
        double[][] matriz = generarMatriz(orden);
        
        System.out.println("\nMatriz inicial:");
        mostrarMatriz(matriz, orden);

        for (int i = 0; i < orden; i++) {
            double pivote = matriz[i][i];
            if (pivote == 0) {
                System.out.println("Error: pivote cero.");
                return;
            }
            System.out.printf("\nNormalizando fila %d (dividir entre %.3f):\n", i + 1, pivote);
            for (int j = 0; j < orden + 1; j++) {
                matriz[i][j] /= pivote;
            }
            mostrarMatriz(matriz, orden);
            
            for (int k = 0; k < orden; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    System.out.printf("Haciendo cero el elemento en fila %d, columna %d (usando fila %d):\n", k + 1, i + 1, i + 1);
                    for (int j = 0; j < orden + 1; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                    mostrarMatriz(matriz, orden);
                }
            }
        }
        
        System.out.println("Solución final:");
        for (int i = 0; i < orden; i++) {
            System.out.printf("x%d = %.3f\n", i, matriz[i][orden]);
        }
        
        sc.close();
    }

    public static double[][] generarMatriz(int orden) {

    }

    public static void mostrarMatriz(double[][] matriz, int orden) {

    }
}