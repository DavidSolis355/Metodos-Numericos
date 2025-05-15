public class MetodoReglaFalsa {

    public static void main(String[] args) {
        // Intervalo inicial, tolerancia y máximo de iteraciones
        double a = 1;
        double b = 2;
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        // Llamar al método de Regla Falsa
        reglaFalsa(a, b, tolerancia, maxIteraciones);
    }

    /**
     * Función definida por el usuario.
     * Cambiar esta función según el problema específico a resolver.
     * @param x Valor de entrada
     * @return Resultado de f(x)
     */
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^3 - x - 2
        return Math.pow(x, 3) - x - 2;
    }

    /**
     * Método que implementa la técnica de la Regla Falsa (Falsa Posición) para encontrar una raíz de la función.
     * @param a Límite inferior del intervalo
     * @param b Límite superior del intervalo
     * @param tol Tolerancia (error máximo permitido)
     * @param maxIter Número máximo de iteraciones permitidas
     */
    public static void reglaFalsa(double a, double b, double tol, int maxIter) {
        double fa = funcion(a);
        double fb = funcion(b);

        // Verificar que haya al menos una raíz en el intervalo
        if (fa * fb >= 0) {
            System.out.println("No se puede aplicar el método: f(a) * f(b) ≥ 0");
            return;
        }

        int iteracion = 0;
        double c = a;

        while (iteracion < maxIter) {
            // Calcular la intersección de la recta secante con el eje x
            c = b - fb * (b - a) / (fb - fa);
            double fc = funcion(c);

            // Imprimir detalles de la iteración
            System.out.printf("Iteración %d: a=%.6f, b=%.6f, c=%.6f, f(c)=%.6f%n", iteracion + 1, a, b, c, fc);

            // Verificar si se encontró una raíz exacta
            if (Math.abs(fc) < tol) {
                break;
            }

            // Actualizar los extremos del intervalo según el signo de f(c)
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }

            iteracion++;
        }

        // Mostrar el resultado final
        System.out.printf("Raíz aproximada encontrada en x = %.6f con tolerancia %.6f%n", c, tol);
    }
}