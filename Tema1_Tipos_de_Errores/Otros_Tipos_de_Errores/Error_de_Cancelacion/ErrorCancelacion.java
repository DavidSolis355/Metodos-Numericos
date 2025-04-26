public class ErrorCancelacion {

    public static void calcularCancelacion(double a, double b) {
        double resultadoExacto = a - b;
        double resultadoAproximado = (float) a - (float) b; // Simulamos pérdida de precisión

        double errorCancelacion = Math.abs(resultadoExacto - resultadoAproximado);

        System.out.println("Resultado Exacto (double): " + resultadoExacto);
        System.out.println("Resultado Aproximado (float): " + resultadoAproximado);
        System.out.println("Error por Cancelación: " + errorCancelacion);
    }

    public static void main(String[] args) {
        double a = 1234567.89;
        double b = 1234567.88;
    }

}