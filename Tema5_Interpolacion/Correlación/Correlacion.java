import java.util.Scanner;

public class Correlacion {
    public static void main(String[] args) {
         // Crear el objeto Scanner para leer los datos desde el teclado
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el número de elementos en los conjuntos de datos
        System.out.println("Ingrese el número de elementos en los conjuntos de datos:");
        int n = scanner.nextInt();
        
        // Crear dos arreglos para almacenar los valores de x e y
        double[] x = new double[n];
        double[] y = new double[n];

        // Leer los valores de los conjuntos de datos x y y
        System.out.println("Ingrese los valores del conjunto de datos x:");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }
        
        System.out.println("Ingrese los valores del conjunto de datos y:");
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }

        // Llamar al método para calcular el coeficiente de correlación de Pearson
        double r = calcularCorrelacion(x, y, n);

        // Mostrar el resultado de la correlación
        System.out.printf("El coeficiente de correlación de Pearson es: %.4f%n", r);
        
        // Cerrar el scanner
        scanner.close();
    }

    /**
     * Este método calcula el coeficiente de correlación de Pearson entre dos conjuntos de datos.
     * 
     * @param x Arreglo con los valores del conjunto de datos x.
     * @param y Arreglo con los valores del conjunto de datos y.
     * @param n El número de elementos en cada conjunto de datos.
     * @return El coeficiente de correlación de Pearson.
     */
    public static double calcularCorrelacion(double[] x, double[] y, int n) {
        // Calcular las medias de los conjuntos de datos x y y
        double mediaX = calcularMedia(x, n);
        double mediaY = calcularMedia(y, n);

        // Variables para los sumatorios de la fórmula
        double sumatoriaXY = 0;
        double sumatoriaX2 = 0;
        double sumatoriaY2 = 0;

        // Calcular las sumas necesarias para el coeficiente de correlación
        for (int i = 0; i < n; i++) {
            sumatoriaXY += (x[i] - mediaX) * (y[i] - mediaY);
            sumatoriaX2 += Math.pow(x[i] - mediaX, 2);
            sumatoriaY2 += Math.pow(y[i] - mediaY, 2);
        }

        // Calcular el coeficiente de correlación de Pearson
        return sumatoriaXY / Math.sqrt(sumatoriaX2 * sumatoriaY2);
    }

     /**
     * Este método calcula la media de un conjunto de datos.
     * 
     * @param datos Arreglo con los valores del conjunto de datos.
     * @param n El número de elementos en el conjunto de datos.
     * @return La media del conjunto de datos.
     */
    public static double calcularMedia(double[] datos, int n) {
        double suma = 0;

        // Sumar todos los valores de los datos
        for (int i = 0; i < n; i++) {
            suma += datos[i];
        }

        // Calcular la media
        return suma / n;
    }
}