public class MetodoSecante {

    public static void main(String[] args) {
        double x0 = 0.0;         // Primera aproximación inicial
        double x1 = 1.0;         // Segunda aproximación inicial
        double tolerancia = 1e-6; // Tolerancia deseada
        int maxIter = 100;        // Máximo número de iteraciones

        // Llamar al método de la secante
        secante(x0, x1, tolerancia, maxIter);
    }

}