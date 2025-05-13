import java.util.Scanner;

public class InterpolacionPolinomial {
    public static void main(String[] args) {

    }

     /**
     * Método que calcula la interpolación polinómica de Lagrange.
     *
     * @param x Arreglo con los valores de x.
     * @param y Arreglo con los valores de y.
     * @param valorX El valor de x en el que se desea interpolar.
     * @param n El número de puntos.
     * @return El valor interpolado en valorX.
     */
    public static double interpolacionLagrange(double[] x, double[] y, double valorX, int n) {
        double resultado = 0.0;

        // Aplicar la fórmula de Lagrange
        for (int i = 0; i < n; i++) {
            double term = y[i];

            // Calcular el término correspondiente al punto i
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    term *= (valorX - x[j]) / (x[i] - x[j]);
                }
            }

            // Sumar el término al resultado final
            resultado += term;
        }

        return resultado;
    }
}