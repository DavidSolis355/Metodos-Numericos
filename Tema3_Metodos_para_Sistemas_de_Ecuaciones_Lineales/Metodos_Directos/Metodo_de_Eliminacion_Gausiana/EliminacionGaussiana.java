import java.util.Scanner;
import java.util.Random;

// Clase que implementa el método de eliminación gaussiana para resolver sistemas de ecuaciones lineales
public class EliminacionGaussiana
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        // Solicita al usuario el tamaño del sistema (número de ecuaciones y variables)
        System.out.print("Introduce el tamaño de la matriz");
        int orden = sc.nextInt();
        
        // Genera aleatoriamente una matriz aumentada de tamaño [orden x (orden + 1)]
        double[][] matriz = generarMatriz(orden);
        
        // Proceso de eliminación hacia adelante
        for(int j = 0; j < orden; j++)
        {
            for(int i = 0; j < orden; i++)
            {
                if (i > j) 
                {
                    // Calcula el factor de eliminación
                    double division = matriz[i][j] / matriz[j][j];
                    System.out.printf("Haciendo cero el elemento en fila %d, columna %d (usando fila %d):\n", i + 1, j + 1, j + 1);
                    System.out.printf("Factor de eliminacion = %.3f\n", division);

                    // Resta la fila j multiplicada por el factor a la fila i
                    for (int k = 0; k < orden + 1; k++) 
                    {
                        matriz[i][k] = matriz[i][k] - division * matriz[j][k];
                    }

                    // Muestra el estado actual de la matriz después de la eliminación
                    mostrarMatriz(matriz, orden);  
                }
            }    
        }
        
        // Sustitución hacia atrás para obtener la solución del sistema
        double[] x = new double[orden];
        
        System.out.println("Resolviendo por sustitucion hacia atras:");
        for (int i = orden - 1; i >= 0; i--) 
        {
            double suma = 0;
            // Suma de los términos ya resueltos
            for (int j = i + 1; j < orden; j++) 
            {
                suma += matriz[i][j] * x[j];
            }
            // Calcula el valor de la variable actual
            x[i] = (matriz[i][orden] - suma) / matriz[i][i];
            System.out.printf("x%d = %.3f\n", i, x[i]);
        }
        
        // Muestra la solución final del sistema
        System.out.println("\nSolucion final:");
        for (int i = 0; i < orden; i++) 
        {
            System.out.printf("x%d = %.3f\n", i, x[i]);
        }
        
        sc.close();
    }
        
    /**
     * Genera una matriz aumentada aleatoria de tamaño n x (n+1)
     *
     * @param orden número de ecuaciones (y variables)
     * @return matriz aumentada con coeficientes aleatorios entre -5 y 4
     */
    public static double[][] generarMatriz(int orden)
    {
        Random rand = new Random();
        double[][] matriz = new double[orden][orden+1];
        
        for(int i = 0; i < orden; i++)
        {
            for (int j = 0; j < orden + 1; j ++)
            {
                matriz[i][j] = rand.nextInt(10) - 5;
            }
        }
        
        return matriz;
    }

    /**
     * Muestra por consola la matriz aumentada con formato
     *
     * @param matriz matriz aumentada a imprimir
     * @param orden  número de ecuaciones (filas)
     */
    public static void mostrarMatriz(double[][] matriz, int orden)
    {
        for (int i = 0; i < orden; i++) 
        {
            String linea = "| ";
            for (int j = 0; j < orden + 1; j++) 
            {
                linea += String.format("%8.3f", matriz[i][j]) + " ";
            }
            linea += "|";
            System.out.println(linea);
        }
        System.out.println();
    }
}
