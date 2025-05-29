# **Interpolación Lineal**

## **Introducción**

La **Interpolación Lineal** es uno de los métodos más sencillos y rápidos para estimar un valor entre dos puntos conocidos en un conjunto de datos. Este método asume que los puntos de datos están distribuidos de manera que se pueda aproximar una función desconocida mediante una línea recta entre los dos puntos cercanos. Es útil cuando se tiene un conjunto pequeño de datos y se desea estimar valores intermedios de manera eficiente.

## **Fórmula de Interpolación Lineal**

La fórmula básica para la interpolación lineal entre dos puntos \( (x_0, y_0) \) y \( (x_1, y_1) \) es:

\[
f(x) = f(x_0) + \frac{(x - x_0)}{(x_1 - x_0)} \cdot (f(x_1) - f(x_0))
\]

Donde:
- \( f(x) \) es el valor estimado de la función en el punto \( x \),
- \( x_0 \) y \( x_1 \) son los puntos conocidos de la variable independiente \( x \),
- \( f(x_0) \) y \( f(x_1) \) son los valores de la función en esos puntos.

### **Explicación**

- Se toma un segmento de la recta que conecta los dos puntos más cercanos y se usa esa recta para estimar el valor en un punto \( x \) intermedio.
- La fórmula calcula una **pendiente** entre los dos puntos conocidos y luego la usa para encontrar el valor de la función en \( x \).

### **Ventajas de la Interpolación Lineal**
- **Fácil de implementar**: Este método es muy simple y rápido, ideal para usar cuando se tienen pocos datos.
- **Bajo costo computacional**: Debido a su simplicidad, es muy eficiente en términos de recursos computacionales.
- **Adecuado para datos que muestran una relación casi lineal**: Si los datos están cerca de una línea recta, este método es altamente preciso.

### **Desventajas de la Interpolación Lineal**
- **Precisión limitada**: No es adecuado para datos que siguen una curva o patrón no lineal. Si los datos no son lineales, la estimación será imprecisa.
- **No es aplicable para grandes cantidades de puntos**: Si se tienen muchos puntos dispersos, el método de interpolación lineal no será eficaz para capturar el comportamiento general de los datos.

---

## **Aplicaciones Comunes**
- **Estimación de valores desconocidos**: Cuando se necesitan valores intermedios en un conjunto de datos experimentales.
- **Gráficos y visualización de datos**: Utilizado para suavizar los datos y mostrar una curva más continua entre los puntos dados.
- **Simulación y modelado**: En campos como la física y la ingeniería, la interpolación lineal se utiliza para estimar el comportamiento de sistemas en tiempo real o en puntos no medidos.

---

## **Notas Finales**
La interpolación lineal es un método básico pero efectivo para estimaciones rápidas cuando se conoce un conjunto pequeño de datos. Aunque sus aplicaciones son limitadas en comparación con métodos más complejos, su simplicidad y eficiencia lo convierten en una herramienta útil en muchos contextos.

---

### [Codigo en Java](InterpolacionLineal.java)

```java

import java.util.Scanner;

public class InterpolacionLineal {
    public static void main(String[] args) {
         // Crear un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Interpolación Lineal");
        System.out.println("---------------------");

        // Entrada de los dos puntos conocidos (x0, y0) y (x1, y1)
        System.out.println("Introduzca el valor de x0:");
        double x0 = scanner.nextDouble();
        System.out.println("Introduzca el valor de y0:");
        double y0 = scanner.nextDouble();

        System.out.println("Introduzca el valor de x1:");
        double x1 = scanner.nextDouble();
        System.out.println("Introduzca el valor de y1:");
        double y1 = scanner.nextDouble();

        // Entrada del valor para el cual se quiere estimar y
        System.out.println("Introduzca el valor de x para el cual desea estimar y:");
        double x = scanner.nextDouble();

        // Calcular el valor de y usando la fórmula de interpolación lineal
        double y = interpolar(x0, y0, x1, y1, x);

        // Mostrar el resultado
        System.out.printf("El valor estimado de y en x = %.2f es: %.4f%n", x, y);
    }

    /**
     * Método para calcular el valor de y usando la interpolación lineal.
     * 
     * @param x0 el primer valor conocido de x
     * @param y0 el valor correspondiente de y para x0
     * @param x1 el segundo valor conocido de x
     * @param y1 el valor correspondiente de y para x1
     * @param x el valor de x para el cual se quiere estimar y
     * @return el valor estimado de y
     */
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        // Fórmula de interpolación lineal
        return y0 + (x - x0) * (y1 - y0) / (x1 - x0);
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

## Caso de Prueba - Interpolación Lineal

### **Ejercicio**

Calcular el valor estimado de \( y \) usando interpolación lineal para los siguientes puntos y valor de \( x \):

- \( (x_0, y_0) = (1, 2) \)
- \( (x_1, y_1) = (3, 6) \)
- Valor a estimar: \( x = 2 \)

---

### **Entrada en consola**

```java
Interpolación Lineal
---------------------
Introduzca el valor de x0:
1
Introduzca el valor de y0:
2
Introduzca el valor de x1:
3
Introduzca el valor de y1:
6
Introduzca el valor de x para el cual desea estimar y:
2
```

### **Salida en consola**

```java

El valor estimado de y en x = 2.00 es: 4.0000

```