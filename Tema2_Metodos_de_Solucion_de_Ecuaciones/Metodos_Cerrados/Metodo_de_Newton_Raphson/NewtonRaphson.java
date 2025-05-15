public class MetodoNewtonRaphson {

    public static void main(String[] args) {
        // Aproximación inicial, tolerancia y número máximo de iteraciones
        double x0 = 1.5;
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        // Llamar al método de Newton-Raphson
        newtonRaphson(x0, tolerancia, maxIteraciones);
    }

    /**
     * Derivada de la función.
     * Debe ser definida manualmente por el usuario.
     * @param x Valor de entrada
     * @return Resultado de f'(x)
     */
    public static double derivada(double x) {
        // Derivada de f(x) = 3x^2 - 1
        return 3 * Math.pow(x, 2) - 1;
    }

    /**
     * Función definida por el usuario.
     * Cambia esta función según el problema a resolver.
     * @param x Valor de entrada
     * @return Resultado de f(x)
     */
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^3 - x - 2
        return Math.pow(x, 3) - x - 2;
    }

    /**
     * Método que implementa la técnica de Newton-Raphson para encontrar una raíz de la función.
     * @param x0 Valor inicial (aproximación inicial de la raíz)
     * @param tol Tolerancia (error máximo permitido)
     * @param maxIter Número máximo de iteraciones permitidas
     */
    public static void newtonRaphson(double x0, double tol, int maxIter) {
        int iteracion = 0;
        double x = x0;

        while (iteracion < maxIter) {
            double fx = funcion(x);
            double dfx = derivada(x);

            // Evitar división por cero
            if (dfx == 0) {
                System.out.println("Derivada cero. No se puede continuar.");
                return;
            }

            // Calcular nueva aproximación
            double x1 = x - fx / dfx;

            // Imprimir detalles de la iteración
            System.out.printf("Iteración %d: x=%.6f, f(x)=%.6f%n", iteracion + 1, x1, funcion(x1));

            // Verificar si el error es menor que la tolerancia
            if (Math.abs(x1 - x) < tol) {
                System.out.printf("Raíz aproximada encontrada en x = %.6f con tolerancia %.6f%n", x1, tol);
                return;
            }

            x = x1;
            iteracion++;
        }

        System.out.printf("Se alcanzó el máximo de iteraciones. Última aproximación: x = %.6f%n", x);
    }
}