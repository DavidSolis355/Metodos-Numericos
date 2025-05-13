// Clase que permite calcular el error de convergencia entre iteraciones numéricas
public class ErrorConvergencia {

     /**
     * Calcula el error de convergencia entre dos iteraciones consecutivas.
     * Este error se usa comúnmente en métodos numéricos para determinar si se ha alcanzado una solución aceptable.
     *
     * @param iteracionActual     valor actual de la iteración
     * @param iteracionAnterior   valor anterior de la iteración
     * @return                    diferencia absoluta entre ambas iteraciones
     */
    public static double calcularErrorConvergencia(double iteracionActual, double iteracionAnterior) {
        return Math.abs(iteracionActual - iteracionAnterior);
    }

    public static void main(String[] args) {

        // Valor de la iteración anterior (por ejemplo, xₙ₋₁)
        double xAnterior = 1.5000;

        // Valor de la iteración actual (por ejemplo, xₙ)
        double xActual = 1.4975;

        // Se calcula el error de convergencia entre ambas iteraciones
        double errorConvergencia = calcularErrorConvergencia(xActual, xAnterior);

        // Se imprime el resultado del error de convergencia
        System.out.println("Error de Convergencia: " + errorConvergencia);

    }

}