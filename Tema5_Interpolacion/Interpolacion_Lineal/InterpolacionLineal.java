import java.util.Scanner;

public class InterpolacionLineal {
    public static void main(String[] args) {
         // Crear un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

    }

    /**
     * Método para calcular el valor de y usando la interpolación lineal.
     * 
     * @param x0 el primer valor conocido de x
     * @param y0 el valor correspondiente de y para x0
     * @param x1 el segundo valor conocido de x
     * @param y1 el valor correspondiente de y para x1
     * @param x el valor de x para el cual se quiere estimar y
     * @return el valor estimado de y
     */
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        // Fórmula de interpolación lineal
        return y0 + (x - x0) * (y1 - y0) / (x1 - x0);
    }
}