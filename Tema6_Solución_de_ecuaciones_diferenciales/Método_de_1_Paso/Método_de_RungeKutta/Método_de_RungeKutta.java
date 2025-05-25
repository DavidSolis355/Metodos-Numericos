public class RungeKutta {
    
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
