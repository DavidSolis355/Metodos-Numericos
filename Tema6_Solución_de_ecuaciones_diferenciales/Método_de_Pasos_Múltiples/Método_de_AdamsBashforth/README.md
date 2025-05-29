# Método de Adams-Bashforth de 4 Pasos

## Introducción

El método de Adams-Bashforth es un método numérico explícito de pasos múltiples utilizado para resolver ecuaciones diferenciales ordinarias (EDO). A diferencia de los métodos de un paso como Runge-Kutta, utiliza varios valores anteriores de la derivada para calcular el siguiente valor, aumentando la precisión.

En particular, el método de 4 pasos usa los valores de las derivadas en los 4 puntos previos para calcular el siguiente valor.

---

## Fórmulas del Método Adams-Bashforth de 4 Pasos

Dado el problema:

$$
\frac{dy}{dx} = f(x, y)
$$

con condición inicial

$$
y(x_0) = y_0
$$

El método aproxima el valor \( y_{n+1} \) usando:

$$
y_{n+1} = y_n + \frac{h}{24} \left( 55 f_n - 59 f_{n-1} + 37 f_{n-2} - 9 f_{n-3} \right)
$$

donde:

- \( h \) es el tamaño del paso.
- \( f_n = f(x_n, y_n) \) es la derivada evaluada en el punto \( (x_n, y_n) \).

---

## Pasos iniciales

Para comenzar, se necesitan los primeros 3 valores de \( y \) calculados con otro método de un paso, típicamente Runge-Kutta de 4to orden.

---

## Ventajas

- Mayor precisión que métodos simples como Euler.
- Buen balance entre eficiencia y precisión.
- Adecuado para problemas donde se puede reutilizar cálculos anteriores.

---

## Desventajas

- Método explícito, puede ser inestable para pasos muy grandes.
- Requiere almacenar y usar varios valores anteriores.
- Necesita un método de inicio para calcular los primeros valores.

---

## Ejemplo de uso

Resolver la EDO:

$$
\frac{dy}{dx} = x + y
$$

con condición inicial \( y(0) = 1 \), usando tamaño de paso \( h=0.1 \) y calculando 10 pasos.

---

## Código de ejemplo en Java

El código implementa:

- Función \( f(x,y) = x + y \).
- Cálculo de los primeros 3 valores usando Runge-Kutta 4.
- Aplicación del método Adams-Bashforth de 4 pasos para el resto.

---

## Notas finales

- Elegir un tamaño de paso adecuado es clave para la estabilidad y precisión.
- Se pueden implementar variantes implícitas o métodos de pasos múltiples de orden diferente.

### [Codigo en Java](Método_de_AdamsBashforth.java)

```java

public class AdamsBashforth {

    /**
     * Define la función f(x, y) = dy/dx de la EDO.
     * En este ejemplo, f(x, y) = x + y (puedes cambiarla según el problema).
     *
     * @param x Variable independiente
     * @param y Valor actual de la función
     * @return Valor de la derivada en (x, y)
     */
    public static double f(double x, double y) {
        return x + y;
    }

    /**
     * Método de Runge-Kutta 4to orden para calcular los primeros 3 valores,
     * necesarios para iniciar el método de Adams-Bashforth de 4 pasos.
     *
     * @param x Valor actual de x.
     * @param y Valor actual de y.
     * @param h Tamaño del paso.
     * @return Aproximación de y en x + h.
     */
    public static double rungeKuttaStep(double x, double y, double h) {
        double k1 = f(x, y);
        double k2 = f(x + h / 2.0, y + h / 2.0 * k1);
        double k3 = f(x + h / 2.0, y + h / 2.0 * k2);
        double k4 = f(x + h, y + h * k3);
        return y + (h / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
    }

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


```

### [Caso de Prueba](Casos_de_Prueba) 

## Caso de Prueba - Adams-Bashforth de 4 Pasos

### **Ejercicio**
Aproximar la solución de la EDO:

\[
\frac{dy}{dx} = x + y, \quad y(0) = 1
\]

Usando el método de **Adams-Bashforth de 4 pasos**, con tamaño de paso \( h = 0.1 \), y generando los primeros tres valores con el método de Runge-Kutta de 4to orden.

---

### **Entrada en consola**
*(No requiere entrada del usuario; condiciones iniciales están en el código)*

---

### **Salida en consola**
```java
x	 y (Adams-Bashforth 4 pasos)
0.10	 1.110341
0.20	 1.242805
0.30	 1.399717
0.40	 1.583615
0.50	 1.797424
0.60	 2.044368
0.70	 2.328003
0.80	 2.652336
0.90	 3.021772
1.00	 3.441230

```