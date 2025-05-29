# **Interpolación Polinómica**

## **Introducción**

La **Interpolación Polinómica** es un método numérico utilizado para aproximar una función desconocida mediante un polinomio que pasa exactamente por un conjunto de puntos dados. Esta técnica es útil cuando se tienen puntos de datos discretos y se desea encontrar una función continua que pase por estos puntos. El polinomio resultante puede ser de grado \( n-1 \), donde \( n \) es el número de puntos de datos.

### **Métodos de Interpolación**

Existen diferentes métodos para calcular la interpolación polinómica, siendo los más comunes:

- **Interpolación de Lagrange**: Un método basado en la construcción de polinomios de Lagrange para cada punto dado.
- **Interpolación de Newton**: Utiliza un enfoque iterativo basado en diferencias divididas para construir un polinomio de interpolación.

En este proyecto, nos enfocaremos en la **Interpolación Polinómica de Lagrange**, que es una forma directa de interpolación y no requiere la resolución de sistemas de ecuaciones.

---

## **Teoría**

La **Interpolación Polinómica de Lagrange** busca construir un polinomio \( P(x) \) que pase por un conjunto de puntos dados \( (x_0, y_0), (x_1, y_1), \dots, (x_n, y_n) \), de tal manera que:

\[
P(x) = \sum_{i=0}^{n} L_i(x) y_i
\]

Donde \( L_i(x) \) son los **polinomios de Lagrange**, definidos como:

\[
L_i(x) = \prod_{\substack{0 \leq j \leq n \\ j \neq i}} \frac{x - x_j}{x_i - x_j}
\]

Cada polinomio de Lagrange \( L_i(x) \) es igual a 1 en \( x_i \) y 0 en todos los demás puntos \( x_j \) (para \( j \neq i \)).

El polinomio \( P(x) \) resultante es único para un conjunto dado de puntos, y garantiza que la función interpolante pase por todos los puntos proporcionados.

---

## **Importancia de la Interpolación Polinómica**

- **Aproximación precisa**: La interpolación polinómica permite obtener una función continua que se ajusta exactamente a los puntos de datos.
- **Aplicaciones**: Se utiliza en gráficos computacionales, estimación de datos, análisis de señales, y en la resolución de problemas donde no se dispone de una fórmula explícita para la función subyacente.
- **Desventajas**: Para grandes conjuntos de datos, el polinomio resultante puede volverse de alto grado, lo que puede ocasionar oscilaciones indeseadas (fenómeno de **sobreajuste**). Es importante considerar técnicas adicionales como la **Interpolación de Splines** para evitar estos problemas.

---

## **Método Abordado**

### **Interpolación de Lagrange**
La interpolación polinómica de Lagrange es útil cuando se desea construir un polinomio que pase exactamente por un conjunto de puntos. En este método, los polinomios de Lagrange se utilizan para construir el polinomio interpolante, sumando cada uno de ellos multiplicado por su correspondiente valor \( y_i \).

#### **Fórmula General:**

El polinomio de interpolación de Lagrange se puede escribir como:

\[
P(x) = \sum_{i=0}^{n} L_i(x) y_i
\]

donde \( L_i(x) \) es el polinomio de Lagrange para el punto \( i \), y \( y_i \) es el valor de la función en el punto \( x_i \).

---

## **Conclusión**

La interpolación polinómica es una herramienta poderosa para obtener aproximaciones de funciones basadas en datos discretos. Aunque el método de Lagrange es sencillo y directo, puede ser ineficiente para grandes conjuntos de datos debido al aumento en el grado del polinomio. En estos casos, se deben considerar métodos alternativos o técnicas de suavizado, como las **splines cúbicas**.

Este enfoque de interpolación es ideal para conjuntos pequeños o medianos de datos, y su simplicidad lo hace adecuado para situaciones donde se requiere una solución rápida y exacta a los puntos dados.

---

### [Codigo en Java](InterpolacionPolinomial.java)

```java

import java.util.Scanner;

public class InterpolacionPolinomial {
    public static void main(String[] args) {
        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.println("Interpolación Polinómica (Método de Lagrange)");
        System.out.println("------------------------------------------------");

        // Leer el número de puntos de datos
        System.out.println("Introduce el número de puntos:");
        int n = scanner.nextInt();

        // Arreglos para almacenar las coordenadas x y y
        double[] x = new double[n];
        double[] y = new double[n];

        // Leer los puntos (x, y) del usuario
        System.out.println("Introduce los puntos (x, y):");
        for (int i = 0; i < n; i++) {
            System.out.print("Punto " + (i + 1) + " - x" + (i + 1) + ": ");
            x[i] = scanner.nextDouble();
            System.out.print("Punto " + (i + 1) + " - y" + (i + 1) + ": ");
            y[i] = scanner.nextDouble();
        }

        // Leer el valor de x en el que se desea calcular el valor interpolado
        System.out.println("Introduce el valor de x en el que deseas interpolar:");
        double valorX = scanner.nextDouble();

        // Calcular el valor interpolado usando la fórmula de Lagrange
        double resultado = interpolacionLagrange(x, y, valorX, n);

        // Mostrar el resultado
        System.out.printf("El valor interpolado en x = %.2f es: %.5f%n", valorX, resultado);
    }

     /**
     * Método que calcula la interpolación polinómica de Lagrange.
     *
     * @param x Arreglo con los valores de x.
     * @param y Arreglo con los valores de y.
     * @param valorX El valor de x en el que se desea interpolar.
     * @param n El número de puntos.
     * @return El valor interpolado en valorX.
     */
    public static double interpolacionLagrange(double[] x, double[] y, double valorX, int n) {
        double resultado = 0.0;

        // Aplicar la fórmula de Lagrange
        for (int i = 0; i < n; i++) {
            double term = y[i];

            // Calcular el término correspondiente al punto i
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    term *= (valorX - x[j]) / (x[i] - x[j]);
                }
            }

            // Sumar el término al resultado final
            resultado += term;
        }

        return resultado;
    }
}

```

### [Caso de Prueba](Casos_de_Prueba.md) 

## Caso de Prueba - Interpolación Polinómica (Lagrange)

### **Ejercicio**

Calcular el valor interpolado en \( x = 2.5 \) usando interpolación polinómica de Lagrange para los puntos:

- \( (1, 1) \)
- \( (2, 4) \)
- \( (3, 9) \)

---

### **Entrada en consola**

```java
Interpolación Polinómica (Método de Lagrange)
------------------------------------------------
Introduce el número de puntos:
3
Introduce los puntos (x, y):
Punto 1 - x1: 1
Punto 1 - y1: 1
Punto 2 - x2: 2
Punto 2 - y2: 4
Punto 3 - x3: 3
Punto 3 - y3: 9
Introduce el valor de x en el que deseas interpolar:
2.5
```

### **Salida en consola**

```java

El valor interpolado en x = 2.50 es: 6.25000

```
