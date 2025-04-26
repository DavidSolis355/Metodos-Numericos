public class DiferenciacionTresPuntos {

    public static void main(String[] args) {

    }

    public static double derivadaTresPuntos(double[] puntos, double h) {
        double h = 0.1; 
        
        double[] puntos = {1, 1.0, 1.21};  

        double derivada = derivadaTresPuntos(puntos, h);

        System.out.println("La derivada aproximada es: " + derivada);
    }
}