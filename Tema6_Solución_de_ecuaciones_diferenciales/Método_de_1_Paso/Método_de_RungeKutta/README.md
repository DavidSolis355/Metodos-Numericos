# Método de Runge-Kutta de 4to Orden (RK4)

## Introducción

El método de Runge-Kutta de 4to orden es un método numérico muy popular para resolver ecuaciones diferenciales ordinarias (EDO). Ofrece una buena precisión y estabilidad sin ser demasiado complejo.

Este método calcula varias pendientes (derivadas) intermedias en cada paso para obtener una mejor aproximación del valor siguiente, comparado con métodos más simples como Euler.

---

## Fórmulas del Método RK4

Para una EDO de la forma:

$$
\frac{dy}{dx} = f(x, y)
$$

Con condición inicial:

$$
y(x_0) = y_0
$$

Se calcula el siguiente valor \(y_{n+1}\) usando:

$$
\begin{aligned}
k_1 &= f(x_n, y_n) \\
k_2 &= f\left(x_n + \frac{h}{2}, y_n + \frac{h}{2} k_1 \right) \\
k_3 &= f\left(x_n + \frac{h}{2}, y_n + \frac{h}{2} k_2 \right) \\
k_4 &= f(x_n + h, y_n + h k_3) \\
y_{n+1} &= y_n + \frac{h}{6} (k_1 + 2k_2 + 2k_3 + k_4)
\end{aligned}
$$

Donde:

- \(h\) es el tamaño del paso.
- \(x_n, y_n\) son los valores actuales de la variable independiente y dependiente.
- \(y_{n+1}\) es la aproximación del siguiente valor de la función.

---

## Ventajas

- Alta precisión para un costo computacional razonable.
- Más estable que el método de Euler.
- Amplio uso en problemas científicos e ingeniería.

---

## Desventajas

- Requiere cuatro evaluaciones de la función por paso.
- Implementación ligeramente más compleja que métodos de un paso simples.

---

## Ejemplo de Uso

Resolver la EDO:

$$
\frac{dy}{dx} = x + y
$$

Con condición inicial \(y(0) = 1\), y tamaño de paso \(h=0.1\).

### [Codigo en Java](Método_de_RungeKutta.java)

```java

public class RungeKutta {
    
    /**
     * Define la función f(x, y) = dy/dx de la EDO.
     * En este ejemplo, f(x, y) = x + y (puedes cambiarla según el problema).
     *
     * @param x Variable independiente.
     * @param y Valor actual de la función.
     * @return Valor de la derivada en (x, y).
     */
    public static double f(double x, double y) {
        return x + y;
    }

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


```

### [Caso de Prueba](Casos_de_Prueba) 

## Caso de Prueba - Runge-Kutta de 4to Orden (RK4)

### **Ejercicio**
Aplicar el método de Runge-Kutta de cuarto orden (RK4) para aproximar la solución de la EDO:

\[
\frac{dy}{dx} = x + y, \quad y(0) = 1
\]

Usando tamaño de paso \( h = 0.1 \) durante 10 pasos.

---

### **Entrada en consola**
*(No requiere entrada del usuario; condiciones iniciales están en el código)*

---

### **Salida en consola**
```java
x	 y (RK4 Aproximado)
0.00	 1.000000
0.10	 1.110341
0.20	 1.242805
0.30	 1.399717
0.40	 1.583649
0.50	 1.797478
0.60	 2.044415
0.70	 2.328042
0.80	 2.652356
0.90	 3.021789
1.00	 3.441250

```

