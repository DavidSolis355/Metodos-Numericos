public class ErrorTruncamiento {

    public static double truncar(double valor, int decimales) {
        double factor = Math.pow(10, decimales);
        return Math.floor(valor * factor) / factor;
    }

    public static double calcularErrorTruncamiento(double valorOriginal, double valorTruncado) {
        return Math.abs(valorOriginal - valorTruncado);
    }

    public static void main(String[] args) {
        double valorOriginal = 3.14159265;
        int decimales = 4;

    }
}
