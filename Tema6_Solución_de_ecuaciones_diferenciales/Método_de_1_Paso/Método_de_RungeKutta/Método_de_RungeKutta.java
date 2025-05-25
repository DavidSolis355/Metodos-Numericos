public class RungeKutta {
    
    /**
     * Implementa un paso del método RK4 para avanzar de (x, y) a (x + h, y_{n+1}).
     *
     * @param x Valor actual de la variable independiente.
     * @param y Valor actual de la función.
     * @param h Tamaño del paso.
     * @return Aproximación de y en x + h.
     */
    public static double rungeKuttaStep(double x, double y, double h) {
        // Calcula k1 = f(x_n, y_n)
        double k1 = f(x, y);
        
        // Calcula k2 = f(x_n + h/2, y_n + h/2 * k1)
        double k2 = f(x + h / 2.0, y + h / 2.0 * k1);
        
        // Calcula k3 = f(x_n + h/2, y_n + h/2 * k2)
        double k3 = f(x + h / 2.0, y + h / 2.0 * k2);
        
        // Calcula k4 = f(x_n + h, y_n + h * k3)
        double k4 = f(x + h, y + h * k3);
        
        // Calcula el siguiente valor y_{n+1} usando la fórmula de RK4
        double yNext = y + (h / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
        
        return yNext;
    }

    public static void main(String[] args) {
        // Condiciones iniciales
        double x0 = 0.0;    // Valor inicial de x
        double y0 = 1.0;    // Valor inicial de y (condición inicial y(x0) = y0)
        double h = 0.1;     // Tamaño del paso
        int n = 10;         // Número de pasos a calcular
        
        System.out.println("x\t y (RK4 Aproximado)");
        System.out.printf("%.2f\t %.6f%n", x0, y0);
        
        double x = x0;
        double y = y0;
        
        // Ciclo para calcular y mostrar los valores aproximados en cada paso
        for (int i = 1; i <= n; i++) {
            // Calcula y_{n+1} usando RK4
            y = rungeKuttaStep(x, y, h);
            
            // Avanza x al siguiente paso
            x = x + h;
            
            // Muestra el resultado
            System.out.printf("%.2f\t %.6f%n", x, y);
        }
    }
}
