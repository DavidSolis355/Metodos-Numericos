public class ErrorConvergencia {

    public static double calcularErrorConvergencia(double iteracionActual, double iteracionAnterior) {
        return Math.abs(iteracionActual - iteracionAnterior);
    }

    public static void main(String[] args) {
        double xAnterior = 1.5000;
        double xActual = 1.4975;

         double errorConvergencia = calcularErrorConvergencia(xActual, xAnterior);

        System.out.println("Error de Convergencia: " + errorConvergencia);

    }

}