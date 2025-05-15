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
}