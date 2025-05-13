// Clase que ejemplifica cómo calcular el error de truncamiento al limitar decimales sin redondear
public class ErrorTruncamiento {

    /**
     * Trunca un número decimal al número de decimales especificado sin redondear.
     * Utiliza la función Math.floor para eliminar los decimales restantes.
     *
     * @param valor      número original a truncar
     * @param decimales  cantidad de decimales a conservar
     * @return           valor truncado como double
     */
    public static double truncar(double valor, int decimales) {
        double factor = Math.pow(10, decimales); // Calcula el factor de escala según los decimales deseados
        return Math.floor(valor * factor) / factor; // Aplica truncamiento eliminando decimales extra
    }

     /**
     * Calcula el error de truncamiento como la diferencia absoluta
     * entre el valor original y el truncado.
     *
     * @param valorOriginal   el valor antes del truncamiento
     * @param valorTruncado   el valor después del truncamiento
     * @return                el error de truncamiento
     */
    public static double calcularErrorTruncamiento(double valorOriginal, double valorTruncado) {
        return Math.abs(valorOriginal - valorTruncado);
    }

    public static void main(String[] args) {

        // Valor original a truncar
        double valorOriginal = 3.14159265;

        // Número de decimales que se desea conservar
        int decimales = 4;

        // Se trunca el valor original
        double valorTruncado = truncar(valorOriginal, decimales);

        // Se calcula el error ocasionado por el truncamiento
        double errorTruncamiento = calcularErrorTruncamiento(valorOriginal, valorTruncado);

        // Se imprimen los resultados para comparación
        System.out.println("Valor original: " + valorOriginal);
        System.out.println("Valor truncado: " + valorTruncado);
        System.out.println("Error de Truncamiento: " + errorTruncamiento);
    }
}
