public class DiferenciacionTresPuntos {

    public static void main(String[] args) {
        if (puntos.length != 3) {
            throw new IllegalArgumentException("Debe haber exactamente 3 puntos.");
        }

        double derivada = (puntos[2] - puntos[0]) / (2 * h);

        return derivada;
    }

    public static double derivadaTresPuntos(double[] puntos, double h) {
        double h = 0.1; 
        
        double[] puntos = {1, 1.0, 1.21};  

        double derivada = derivadaTresPuntos(puntos, h);

        System.out.println("La derivada aproximada es: " + derivada);
    }
}