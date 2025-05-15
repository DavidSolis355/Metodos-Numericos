public class MetodoSecante {

    public static void main(String[] args) {
        double x0 = 0.0;         // Primera aproximación inicial
        double x1 = 1.0;         // Segunda aproximación inicial
        double tolerancia = 1e-6; // Tolerancia deseada
        int maxIter = 100;        // Máximo número de iteraciones

        // Llamar al método de la secante
        secante(x0, x1, tolerancia, maxIter);
    }

    /**
     * Función f(x) a la cual se le quiere encontrar la raíz.
     * @param x Valor de entrada
     * @return Valor de la función en x
     */
    public static double f(double x) {
        // Ejemplo: f(x) = x^2 - 3x + 2
        return Math.pow(x, 2) - 3 * x + 2;
    }
}