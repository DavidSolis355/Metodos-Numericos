public class ErrorRelativo {

    public static double calcularErrorRelativo(double valorVerdadero, double valorAproximado) {
        return Math.abs((valorVerdadero - valorAproximado) / valorVerdadero);
    }

    public static void main(String[] args) {
        double valorVerdadero = 4.000;
        double valorAproximado = 3.920;

        double errorRelativo = calcularErrorRelativo(valorVerdadero, valorAproximado);

        System.out.println("Error Relativo: " + errorRelativo);
        System.out.println("Error Relativo (%): " + (errorRelativo * 100) + "%");
    }

}