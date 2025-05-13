import java.util.Scanner;

public class Correlacion {
    public static void main(String[] args) {

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
}