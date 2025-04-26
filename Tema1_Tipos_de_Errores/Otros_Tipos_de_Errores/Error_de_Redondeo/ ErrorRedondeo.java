import java.math.BigDecimal;
import java.math.RoundingMode;

public class ErrorRedondeo {

    public static double redondear(double valor, int decimales) {
        BigDecimal bd = new BigDecimal(valor);
        bd = bd.setScale(decimales, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    

    public static void main(String[] args) {
        double valorOriginal = 3.14159265;
        int decimales = 4;
    }


}