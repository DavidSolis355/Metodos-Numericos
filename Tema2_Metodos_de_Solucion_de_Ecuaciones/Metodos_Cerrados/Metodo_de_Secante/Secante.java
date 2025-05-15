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

    /**
     * Método de la Secante para encontrar una raíz de f(x) = 0.
     *
     * @param x0 Primera aproximación inicial
     * @param x1 Segunda aproximación inicial
     * @param tol Tolerancia deseada
     * @param maxIter Número máximo de iteraciones permitidas
     */
    public static void secante(double x0, double x1, double tol, int maxIter) {
        double f0 = f(x0);
        double f1 = f(x1);
        int iteracion = 1;

        while (iteracion <= maxIter) {
            // Calcular nueva aproximación usando la fórmula de la secante
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            double error = Math.abs(x2 - x1);

            // Mostrar información de la iteración
            System.out.printf("Iteración %d: x=%.6f, error=%.6f%n", iteracion, x2, error);

            // Verificar si el error es menor que la tolerancia
            if (error < tol) {
                System.out.printf("Raíz aproximada encontrada en x = %.6f con tolerancia %.6f%n", x2, tol);
                return;
            }

            // Actualizar valores para la siguiente iteración
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f(x1);
            iteracion++;
        }

        System.out.printf("Se alcanzó el máximo de iteraciones. Última aproximación: x = %.6f%n", x1);
    }
}