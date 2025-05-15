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

}