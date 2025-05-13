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

        // Sumar los términos necesarios
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }
        
        // Calcular los coeficientes m (pendiente) y b (intersección)
        double m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double b = (sumY - m * sumX) / n;
        
        // Mostrar los resultados
        System.out.println("\nRESULTADOS:");
        System.out.printf("Pendiente (m) = %.4f%n", m);
        System.out.printf("Intersección (b) = %.4f%n", b);
        System.out.println("La ecuación de la recta ajustada es: y = " + m + "x + " + b);
        
        // Predicciones para algunos valores de x (si es necesario)
        System.out.println("\nRealizando predicciones para valores de x:");
        System.out.print("Introduzca un valor de x para predecir y: ");
        double xNuevo = scanner.nextDouble();
        double yPredicho = m * xNuevo + b;
        System.out.printf("Para x = %.4f, la predicción de y es: %.4f%n", xNuevo, yPredicho);
        
        scanner.close();
    }
}