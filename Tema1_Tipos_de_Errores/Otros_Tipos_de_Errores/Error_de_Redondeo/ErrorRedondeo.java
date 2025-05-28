// Clase que demuestra cómo calcular el error de redondeo al limitar decimales
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ErrorRedondeo {

     /**
     * Redondea un número decimal al número de decimales especificado.
     * Utiliza BigDecimal para asegurar un redondeo preciso y controlado.
     *
     * @param valor      número original a redondear
     * @param decimales  cantidad de decimales a conservar
     * @return           valor redondeado como double
     */
    public static double redondear(double valor, int decimales) {
        BigDecimal bd = new BigDecimal(valor);
        bd = bd.setScale(decimales, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

     /**
     * Calcula el error de redondeo como la diferencia absoluta
     * entre el valor original y el valor redondeado.
     *
     * @param valorOriginal    el valor antes del redondeo
     * @param valorRedondeado  el valor después del redondeo
     * @return                 el error de redondeo
     */
    public static double calcularErrorRedondeo(double valorOriginal, double valorRedondeado) {
        return Math.abs(valorOriginal - valorRedondeado);
    }

    public static void main(String[] args) {

        // Valor original que será redondeado
        double valorOriginal = 3.14159265;

        // Número de decimales deseados
        int decimales = 4;

        // Se redondea el valor original
        double valorRedondeado = redondear(valorOriginal, decimales);

        // Se calcula el error causado por el redondeo
        double errorRedondeo = calcularErrorRedondeo(valorOriginal, valorRedondeado);

        // Se muestran los resultados en consola
        System.out.println("Valor original: " + valorOriginal);
        System.out.println("Valor redondeado: " + valorRedondeado);
        System.out.println("Error de Redondeo: " + errorRedondeo);
    }
}