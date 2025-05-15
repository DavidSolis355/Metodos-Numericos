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

    public static void puntoFijo(double x0, double tol, int maxIter) {
        int iteracion = 0;
        double x = x0;

        while (iteracion < maxIter) {
            double x1 = g(x);  // Aplicar la función g(x)
            double error = Math.abs(x1 - x);  // Calcular el error

            // Imprimir valores de la iteración
            System.out.printf("Iteración %d: x=%.6f, error=%.6f%n", iteracion + 1, x1, error);

            // Verificar si el error es menor que la tolerancia
            if (error < tol) {
                System.out.printf("Raíz aproximada encontrada en x = %.6f con tolerancia %.6f%n", x1, tol);
                return;
            }

            x = x1;
            iteracion++;
        }

        System.out.printf("Se alcanzó el máximo de iteraciones. Última aproximación: x = %.6f%n", x);
    }
}