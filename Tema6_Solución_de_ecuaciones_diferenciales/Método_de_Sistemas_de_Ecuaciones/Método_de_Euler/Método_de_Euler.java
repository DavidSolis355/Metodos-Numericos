public class MetodoEuler {

    public static void main(String[] args) {

        // Condiciones iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y (y(x0) = y0)
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos a calcular

        // Imprimimos la cabecera
        System.out.println("Método de Euler para resolver EDOs");
        System.out.printf("%-10s %-15s %-15s\n", "Paso", "x", "y");

        // Imprimimos la condición inicial
        System.out.printf("%-10d %-15.6f %-15.6f\n", 0, x0, y0);

        // Aplicamos el método de Euler
        for (int i = 1; i <= n; i++) {
            // Calculamos el nuevo valor de y usando Euler: y_{n+1} = y_n + h*f(x_n, y_n)
            y0 = y0 + h * f(x0, y0);
            // Avanzamos al siguiente valor de x
            x0 = x0 + h;
            // Imprimimos el paso actual
            System.out.printf("%-10d %-15.6f %-15.6f\n", i, x0, y0);
        }
    }
}