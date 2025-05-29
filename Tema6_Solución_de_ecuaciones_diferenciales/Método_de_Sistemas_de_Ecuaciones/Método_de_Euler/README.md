# Método de Euler

## Introducción

El **Método de Euler** es uno de los métodos numéricos más simples para resolver ecuaciones diferenciales ordinarias (EDOs) de primer orden. Se basa en una aproximación lineal utilizando la derivada conocida en un punto para estimar el valor de la función en el siguiente punto.

Este método pertenece a los **métodos de un solo paso**, y aunque es simple, puede acumular errores rápidamente si se usa con un paso grande o por muchas iteraciones.

---

## Fundamento Matemático

Dada una ecuación diferencial de la forma:

$$
\frac{dy}{dx} = f(x, y), \quad y(x_0) = y_0
$$

El Método de Euler estima el valor de \( y \) en el siguiente punto \( x+h \) mediante:

$$
y_{n+1} = y_n + h \cdot f(x_n, y_n)
$$

donde:
- \( h \) es el tamaño del paso.
- \( x_n \) y \( y_n \) son los valores actuales.
- \( y_{n+1} \) es el valor estimado en el siguiente punto.

---

## Ventajas

- Fácil de entender e implementar.
- Requiere pocos cálculos por iteración.

---

## Desventajas

- Baja precisión si el tamaño de paso no es suficientemente pequeño.
- Puede ser inestable para ciertos tipos de ecuaciones.
- Acumula errores rápidamente a lo largo de la integración.

---

## Ejemplo

Resolver la ecuación:

$$
\frac{dy}{dx} = x + y, \quad y(0) = 1
$$

Con un tamaño de paso \( h = 0.1 \) y \( n = 10 \) pasos, el resultado aproximado se obtiene aplicando la fórmula iterativamente.

---

## Aplicaciones

- Problemas simples de dinámica.
- Modelos de crecimiento o decaimiento.
- Como base para comprender métodos más avanzados (como Runge-Kutta).

---

## Notas Finales

- Aunque no es el más preciso, el Método de Euler es una excelente introducción a la solución numérica de EDOs.
- Para obtener mejores resultados, se recomienda usar pasos pequeños o considerar métodos más avanzados.

### [Codigo en Java](.java)

```java

public class MetodoEuler {

    // Definimos la función f(x, y) que representa la derivada dy/dx
    // En este caso puedes cambiar la función por la que necesites resolver
    public static double f(double x, double y) {
        return x + y; // Ejemplo: dy/dx = x + y
    }

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

```

### [Caso de Prueba](Casos_de_Prueba) 

## Caso de Prueba - Método de Euler

### **Ejercicio**
Aproximar la solución de la EDO:

\[
\frac{dy}{dx} = x + y, \quad y(0) = 1
\]

Usando el **método de Euler** con un tamaño de paso \( h = 0.1 \), durante 10 pasos.

---

### **Entrada en consola**
*(No requiere entrada del usuario; condiciones iniciales están en el código)*

### **Salida en consola**
```java
Método de Euler para resolver EDOs
Paso       x               y              
0          0.000000        1.000000       
1          0.100000        1.100000       
2          0.200000        1.220000       
3          0.300000        1.362000       
4          0.400000        1.528200       
5          0.500000        1.721020       
6          0.600000        1.943122       
7          0.700000        2.197434       
8          0.800000        2.487177       
9          0.900000        2.815895       
10         1.000000        3.187485

```