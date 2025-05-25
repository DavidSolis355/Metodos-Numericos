public class RungeKutta {
    
    public static void main(String[] args) {
        double x0 = 0.0;    // valor inicial de x
        double y0 = 1.0;    // valor inicial de y (condición inicial)
        double x = 0.1;     // valor de x donde queremos la solución
        double h = 0.01;    // tamaño del paso

        double resultado = rungeKutta(x0, y0, x, h);
        System.out.printf("El valor aproximado de y en x=%.2f es %.6f%n", x, resultado);
    }


}
