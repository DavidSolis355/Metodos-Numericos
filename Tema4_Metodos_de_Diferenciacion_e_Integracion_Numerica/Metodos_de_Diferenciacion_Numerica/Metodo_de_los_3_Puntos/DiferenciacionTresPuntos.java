public class DiferenciacionTresPuntos {

    // Método principal que calcula la derivada aproximada usando la fórmula de tres puntos
    public static void main(String[] args) {

        // Verifica que la longitud del arreglo de puntos sea exactamente 3
        if (puntos.length != 3) {
            throw new IllegalArgumentException("Debe haber exactamente 3 puntos.");
        }
        // Calcula la derivada utilizando la fórmula de tres puntos
        double derivada = (puntos[2] - puntos[0]) / (2 * h);

        // Devuelve el valor de la derivada
        return derivada;
    }

    /**
     * Calcula la derivada aproximada de una función en un punto utilizando la fórmula de tres puntos.
     *
     * @param puntos arreglo que contiene tres puntos consecutivos de la función (p0, p1, p2)
     * @param h      el paso entre los puntos (la diferencia entre los puntos consecutivos)
     * @return       la derivada aproximada en el punto medio entre p0 y p2
     */
    public static double derivadaTresPuntos(double[] puntos, double h) {
        // Valor de h (tamaño del paso) que se utilizará en el cálculo de la derivada
        double h = 0.1; 
        
        // Definición de los puntos que se usarán para aproximar la derivada
        double[] puntos = {1, 1.0, 1.21};  

        // Llama al método de derivadaTresPuntos para calcular la derivada
        double derivada = derivadaTresPuntos(puntos, h);

        // Muestra el resultado de la derivada aproximada
        System.out.println("La derivada aproximada es: " + derivada);
    }
}