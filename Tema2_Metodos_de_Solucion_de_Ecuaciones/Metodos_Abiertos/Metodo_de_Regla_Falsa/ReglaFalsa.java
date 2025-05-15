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
    
}