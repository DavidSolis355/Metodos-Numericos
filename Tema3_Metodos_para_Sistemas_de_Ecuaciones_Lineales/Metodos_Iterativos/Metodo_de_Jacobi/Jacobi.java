import java.util.Scanner;
import java.util.Random;

public class Jacobi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el tamaño de la matriz: ");
        int orden = sc.nextInt();

        double[][] matriz = generarMatriz(orden);

        System.out.println("\nMatriz inicial:");
        mostrarMatriz(matriz, orden);

        double[] x = new double[orden]; 
        double[] xNuevo = new double[orden]; 
        double tolerancia = 1e-6;
        int iteracionesMax = 100;
        int iteracion = 0;
        boolean converge = false;

        while (!converge && iteracion < iteracionesMax) {
            System.out.printf("\nIteración %d:\n", iteracion + 1);

            for (int i = 0; i < orden; i++) {
                double suma = 0;
                for (int j = 0; j < orden; j++) {
                    if (j != i) {
                        suma += matriz[i][j] * x[j];
                    }
                }
                xNuevo[i] = (matriz[i][orden] - suma) / matriz[i][i];
                System.out.printf("x%d = %.6f\n", i, xNuevo[i]);
            }

            converge = true;
            for (int i = 0; i < orden; i++) {
                if (Math.abs(xNuevo[i] - x[i]) > tolerancia) {
                    converge = false;
                    break;
                }
            }

            System.arraycopy(xNuevo, 0, x, 0, orden);
            iteracion++;
        }

        if (converge) {
            System.out.println("\nSolución encontrada:");
            for (int i = 0; i < orden; i++) {
                System.out.printf("x%d = %.6f\n", i, x[i]);
            }
        } else {
            System.out.println("\nNo se alcanzó la convergencia en " + iteracionesMax + " iteraciones.");
        }

        sc.close();
    }

    public static double[][] generarMatriz(int orden) {
        Random rand = new Random();
        double[][] matriz = new double[orden][orden + 1];

        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden + 1; j++) {
                matriz[i][j] = rand.nextInt(10) - 5; 
            }
            if (matriz[i][i] == 0) {
                matriz[i][i] = rand.nextInt(5) + 1;
            }
        }

        return matriz;
    }

    public static void mostrarMatriz(double[][] matriz, int orden) {
        
    }
}


