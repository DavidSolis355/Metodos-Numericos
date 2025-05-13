import java.util.Scanner;

public class RegresionLineal {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("REGRESIÓN LINEAL - MÉTODO DE MÍNIMOS CUADRADOS");
        System.out.println("--------------------------------------------");
        
        // Solicitar el número de puntos de datos
        System.out.println("Introduzca el número de puntos de datos:");
        int n = scanner.nextInt();
        
        // Arrays para almacenar los valores de x e y
        double[] x = new double[n];
        double[] y = new double[n];
        
        // Leer los datos de entrada (valores de x e y)
        System.out.println("Introduzca los valores de x e y:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + (i+1) + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + (i+1) + "]: ");
            y[i] = scanner.nextDouble();
        }
        
        // Cálculos necesarios para el método de mínimos cuadrados
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
    }
}