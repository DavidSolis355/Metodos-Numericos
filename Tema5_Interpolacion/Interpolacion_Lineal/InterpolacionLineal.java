import java.util.Scanner;

public class InterpolacionLineal {
    public static void main(String[] args) {

    }

    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        // Fórmula de interpolación lineal
        return y0 + (x - x0) * (y1 - y0) / (x1 - x0);
    }
}