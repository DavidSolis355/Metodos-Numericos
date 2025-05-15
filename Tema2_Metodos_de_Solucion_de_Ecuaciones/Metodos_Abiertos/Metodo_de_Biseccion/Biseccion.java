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
}
