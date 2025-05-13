// Clase que ejemplifica el error por cancelación en operaciones numéricas
public class ErrorCancelacion {

    /**
     * Calcula y muestra el error por cancelación al restar dos números muy cercanos.
     * Se simula la pérdida de precisión al realizar la operación usando float en lugar de double.
     *
     * @param a  primer número (mayor)
     * @param b  segundo número (ligeramente menor que 'a')
     */
    public static void calcularCancelacion(double a, double b) {

        // Resultado exacto utilizando doble precisión (double)
        double resultadoExacto = a - b;

        // Resultado exacto utilizando doble precisión (double)
        double resultadoAproximado = (float) a - (float) b; // Simulamos pérdida de precisión

        // Cálculo del error por cancelación como la diferencia entre ambos resultados
        double errorCancelacion = Math.abs(resultadoExacto - resultadoAproximado);

        // Impresión de los resultados para comparar
        System.out.println("Resultado Exacto (double): " + resultadoExacto);
        System.out.println("Resultado Aproximado (float): " + resultadoAproximado);
        System.out.println("Error por Cancelación: " + errorCancelacion);
    }

    public static void main(String[] args) {

        // Se definen dos números muy cercanos para provocar cancelación
        double a = 1234567.89;
        double b = 1234567.88;

        // Se llama al método que calcula e imprime el error por cancelación
        calcularCancelacion(a, b);

    }

}