public class Biseccion {

    public static void main(String[] args) {
        // Definir intervalo [a, b], tolerancia y número máximo de iteraciones
        double a = 1;
        double b = 2;
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        // Llamar al método de bisección
        biseccion(a, b, tolerancia, maxIteraciones);
    }

    /**
     * Define la función f(x) cuyo valor se desea encontrar igual a cero.
     * Aquí puedes cambiar la función según tu problema específico.
     * @param x Valor de entrada
     * @return Resultado de f(x)
     */
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^3 - x - 2
        return Math.pow(x, 3) - x - 2;
    }

    public static void biseccion(double a, double b, double tol, int maxIter) {
        double fa = funcion(a);
        double fb = funcion(b);

        // Verificar que exista al menos una raíz en el intervalo [a, b]
        if (fa * fb >= 0) {
            System.out.println("No se puede aplicar el método de bisección: f(a) * f(b) ≥ 0");
            return;
        }

        int iteracion = 0;
        double c = a;

        // Repetir hasta alcanzar la tolerancia o agotar el número de iteraciones
        while ((b - a) / 2 > tol && iteracion < maxIter) {
            c = (a + b) / 2; // Calcular el punto medio
            double fc = funcion(c);

            // Imprimir detalles de la iteración actual
            System.out.printf("Iteración %d: a=%.6f, b=%.6f, c=%.6f, f(c)=%.6f%n", iteracion + 1, a, b, c, fc);

            // Verificar si se encontró la raíz exacta
            if (fc == 0.0) {
                break;
            }

            // Reemplazar el extremo del intervalo que mantiene el cambio de signo
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }

            iteracion++;
        }

        // Imprimir resultado final
        System.out.printf("Raíz aproximada encontrada en x = %.6f con tolerancia %.6f%n", c, tol);
    }
}
