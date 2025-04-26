import java.util.Scanner;
import java.util.Random;

public class EliminacionGaussiana
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el tamaño de la matriz");
        int orden = sc.nextInt();
        
        double[][] matriz = generarMatriz(orden);
        
        for(int j = 0; j < orden; j++)
        {
            for(int i = 0; j < orden; i++)
            {
                if (i > j) 
                {
                    double division = matriz[i][j] / matriz[j][j];
                    System.out.printf("Haciendo cero el elemento en fila %d, columna %d (usando fila %d):\n", i + 1, j + 1, j + 1);
                    System.out.printf("Factor de eliminacion = %.3f\n", division);
                    for (int k = 0; k < orden + 1; k++) 
                    {
                        matriz[i][k] = matriz[i][k] - division * matriz[j][k];
                    }
                    mostrarMatriz(matriz, orden);  
                }
            }    
        }
        
        double[] x = new double[orden];
        
        System.out.println("Resolviendo por sustitucion hacia atras:");
        for (int i = orden - 1; i >= 0; i--) 
        {
            double suma = 0;
            for (int j = i + 1; j < orden; j++) 
            {
                suma += matriz[i][j] * x[j];
            }
            x[i] = (matriz[i][orden] - suma) / matriz[i][i];
            System.out.printf("x%d = %.3f\n", i, x[i]);
        }
        
        System.out.println("\nSolucion final:");
        for (int i = 0; i < orden; i++) 
        {
            System.out.printf("x%d = %.3f\n", i, x[i]);
        }
        
        sc.close();
    }
        

    public static double[][] generarMatriz(int orden)
    {


    }

    public static void mostrarMatriz(double[][] matriz, int orden)
    {
        
    }


}
