public class AdamsBashforth {

    public static void main(String[] args) {
        // Condiciones iniciales
        double x0 = 0.0;      // valor inicial de x
        double y0 = 1.0;      // valor inicial de y
        double h = 0.1;       // tamaño del paso
        int n = 10;           // número total de pasos que queremos calcular

        // Arrays para almacenar valores de x, y y f(x,y)
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        double[] fValues = new double[n + 1];  // almacenará f(x_i, y_i)

        // Inicialización con las condiciones iniciales
        x[0] = x0;
        y[0] = y0;
        fValues[0] = f(x0, y0);

        System.out.println("x\t y (Adams-Bashforth 4 pasos)");

        // Calcular los primeros 3 valores usando RK4 para iniciar el método de pasos múltiples
        for (int i = 1; i < 4; i++) {
            x[i] = x[i - 1] + h;
            y[i] = rungeKuttaStep(x[i - 1], y[i - 1], h);
            fValues[i] = f(x[i], y[i]);
            System.out.printf("%.2f\t %.6f%n", x[i], y[i]);
        }

        // Aplicar el método Adams-Bashforth de 4 pasos a partir del cuarto punto
        for (int i = 4; i <= n; i++) {
            x[i] = x[i - 1] + h;

            // Fórmula Adams-Bashforth 4 pasos:
            // y_{n+1} = y_n + (h/24) * [55f_n - 59f_{n-1} + 37f_{n-2} - 9f_{n-3}]
            y[i] = y[i - 1] + (h / 24.0) * (55 * fValues[i - 1] - 59 * fValues[i - 2] + 37 * fValues[i - 3] - 9 * fValues[i - 4]);

            // Calcular f(x_i, y_i) para el nuevo valor
            fValues[i] = f(x[i], y[i]);

            // Mostrar resultado
            System.out.printf("%.2f\t %.6f%n", x[i], y[i]);
        }
    }

}
