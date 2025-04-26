import java.math.BigDecimal;
import java.math.RoundingMode;

public class ErrorRedondeo {

    public static double redondear(double valor, int decimales) {
        BigDecimal bd = new BigDecimal(valor);
        bd = bd.setScale(decimales, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double calcularErrorRedondeo(double valorOriginal, double valorRedondeado) {
        return Math.abs(valorOriginal - valorRedondeado);
    }

    public static void main(String[] args) {
        double valorOriginal = 3.14159265;
        int decimales = 4;

        double valorRedondeado = redondear(valorOriginal, decimales);
        double errorRedondeo = calcularErrorRedondeo(valorOriginal, valorRedondeado);

        System.out.println("Valor original: " + valorOriginal);
        System.out.println("Valor redondeado: " + valorRedondeado);
        System.out.println("Error de Redondeo: " + errorRedondeo);
    }

    

}