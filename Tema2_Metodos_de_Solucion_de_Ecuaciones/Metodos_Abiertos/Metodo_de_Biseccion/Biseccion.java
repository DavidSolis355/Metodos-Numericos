public class Biseccion {

    public static void main(String[] args) {
        // Definir intervalo [a, b], tolerancia y número máximo de iteraciones
        double a = 1;
        double b = 2;
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        // Llamar al método de bisección
        biseccion(a, b, tolerancia, maxIteraciones);
    }

    /**
     * Define la función f(x) cuyo valor se desea encontrar igual a cero.
     * Aquí puedes cambiar la función según tu problema específico.
     * @param x Valor de entrada
     * @return Resultado de f(x)
     */
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^3 - x - 2
        return Math.pow(x, 3) - x - 2;
    }

}
