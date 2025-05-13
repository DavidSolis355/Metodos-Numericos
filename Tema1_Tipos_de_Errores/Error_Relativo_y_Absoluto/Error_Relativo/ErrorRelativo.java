// Clase que contiene métodos para calcular el error relativo
public class ErrorRelativo {

    /**
     * Calcula el error relativo entre un valor verdadero y uno aproximado.
     * El error relativo se define como el valor absoluto de la diferencia
     * entre ambos valores, dividido entre el valor verdadero.
     *
     * @param valorVerdadero   el valor real o exacto
     * @param valorAproximado  el valor estimado o calculado
     * @return                 el error relativo (valor entre 0 y 1)
     */
    public static double calcularErrorRelativo(double valorVerdadero, double valorAproximado) {
        return Math.abs((valorVerdadero - valorAproximado) / valorVerdadero);
    }

    public static void main(String[] args) {
        // Valor verdadero del dato (por ejemplo, un resultado teórico)
        double valorVerdadero = 4.000;

        // Valor aproximado obtenido (por ejemplo, de una medición o cálculo)
        double valorAproximado = 3.920;

        // Se calcula el error relativo entre los dos valores
        double errorRelativo = calcularErrorRelativo(valorVerdadero, valorAproximado);

        // Se imprime el error relativo como valor decimal
        System.out.println("Error Relativo: " + errorRelativo);

        // Se imprime el error relativo como porcentaje
        System.out.println("Error Relativo (%): " + (errorRelativo * 100) + "%");
    }

}