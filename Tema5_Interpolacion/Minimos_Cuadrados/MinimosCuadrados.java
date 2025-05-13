public class MetodoMinimosCuadrados {

    // Método para calcular la pendiente (m) y la intersección (b) usando el método de mínimos cuadrados
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        int n = x.length;
        
        // Sumar los valores de x, y, x^2, y*x
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }
        
        // Calcular la pendiente (m) y la intersección (b) usando las fórmulas de mínimos cuadrados
        double m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double b = (sumY - m * sumX) / n;
        
        // Retornar los valores de m (pendiente) y b (intersección)
        return new double[]{m, b};
    }

}
