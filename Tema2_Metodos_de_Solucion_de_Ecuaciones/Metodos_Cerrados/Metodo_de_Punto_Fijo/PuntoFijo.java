public class MetodoPuntoFijo {

    public static void main(String[] args) {
        double x0 = 0.5;         // Valor inicial
        double tolerancia = 1e-6; // Tolerancia deseada
        int maxIter = 100;        // Número máximo de iteraciones

        // Llamada al método de Punto Fijo
        puntoFijo(x0, tolerancia, maxIter);
    }

    
}