public class ErrorAbsoluto {

    public static double calcularErrorAbsoluto(double valorVerdadero, double valorAproximado) {
        return Math.abs(valorVerdadero - valorAproximado);
    }

    public static void main(String[] args) {
        double valorVerdadero = 4.000;
        double valorAproximado = 3.920;

        double errorAbsoluto = calcularErrorAbsoluto(valorVerdadero, valorAproximado);

        System.out.println("Error Absoluto: " + errorAbsoluto);
    }
}
