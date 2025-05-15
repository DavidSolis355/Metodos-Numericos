public class MetodoNewtonRaphson {

    public static void main(String[] args) {
        // Aproximación inicial, tolerancia y número máximo de iteraciones
        double x0 = 1.5;
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        // Llamar al método de Newton-Raphson
        newtonRaphson(x0, tolerancia, maxIteraciones);
    }

    
}