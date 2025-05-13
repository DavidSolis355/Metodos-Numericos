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

     // Método para predecir los valores de y usando la recta de regresión y = mx + b
    public static double[] predecir(double[] x, double m, double b) {
        double[] yPred = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            yPred[i] = m * x[i] + b;
        }
        return yPred;
    }
     public static void main(String[] args) {
        // Datos de ejemplo (valores de x y y)
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 5, 4, 5};
        
        // Calcular la pendiente y la intersección
        double[] resultados = calcularMinimosCuadrados(x, y);
        double m = resultados[0];
        double b = resultados[1];
        
        // Mostrar la ecuación de la recta ajustada
        System.out.println("Ecuación de la recta de regresión: y = " + m + "x + " + b);
        
        // Predecir los valores de y usando la recta de regresión
        double[] yPred = predecir(x, m, b);
        
        // Mostrar las predicciones
        System.out.println("Valores predichos de y:");
        for (int i = 0; i < yPred.length; i++) {
            System.out.println("x = " + x[i] + ", Predicción y = " + yPred[i]);
        }
    }
}
