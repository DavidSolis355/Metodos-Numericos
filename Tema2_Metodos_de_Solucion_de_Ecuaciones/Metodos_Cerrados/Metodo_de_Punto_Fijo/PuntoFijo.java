public class MetodoPuntoFijo {

    public static void main(String[] args) {
        double x0 = 0.5;         // Valor inicial
        double tolerancia = 1e-6; // Tolerancia deseada
        int maxIter = 100;        // Número máximo de iteraciones

        // Llamada al método de Punto Fijo
        puntoFijo(x0, tolerancia, maxIter);
    }

    /**
     * Función g(x) tal que x = g(x).
     * Esta función debe cumplir con las condiciones de convergencia del método.
     * @param x Valor de entrada
     * @return Resultado de g(x)
     */
    public static double g(double x) {
        // Ejemplo: para f(x) = x^2 - 3x + 2, se puede usar g(x) = (x^2 + 2)/3
        return (Math.pow(x, 2) + 2) / 3;
    }
}