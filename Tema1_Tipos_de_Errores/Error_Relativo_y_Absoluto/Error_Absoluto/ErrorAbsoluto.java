// Clase que contiene métodos para calcular el error absoluto
public class ErrorAbsoluto {

    /**
     * Calcula el error absoluto entre un valor verdadero y un valor aproximado.
     * El error absoluto se define como el valor absoluto de la diferencia entre ambos valores.
     *
     * @param valorVerdadero   el valor real o exacto
     * @param valorAproximado  el valor estimado o calculado
     * @return                 el error absoluto
     */
    public static double calcularErrorAbsoluto(double valorVerdadero, double valorAproximado) {
        return Math.abs(valorVerdadero - valorAproximado);
    }

    public static void main(String[] args) {

        // Valor verdadero del dato (por ejemplo, un resultado teórico)
        double valorVerdadero = 4.000;

        // Valor aproximado obtenido (por ejemplo, de una medición o cálculo)
        double valorAproximado = 3.920;

        // Se calcula el error absoluto entre los dos valores
        double errorAbsoluto = calcularErrorAbsoluto(valorVerdadero, valorAproximado);

        // Se imprime el resultado del error absoluto en consola
        System.out.println("Error Absoluto: " + errorAbsoluto);
    }
}
