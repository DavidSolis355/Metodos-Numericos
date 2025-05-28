## **Método de Gauss-Seidel**

### **Definición**
El **método de Gauss-Seidel** es un método iterativo para resolver **sistemas de ecuaciones lineales**. Mejora progresivamente la aproximación de las soluciones utilizando los valores ya calculados en cada paso de la iteración.

### **¿Para qué se usa?**
- Para resolver **sistemas grandes** de ecuaciones lineales donde los métodos directos son muy costosos.
- Muy usado en **simulación numérica** e **ingeniería** (análisis de estructuras, flujo de fluidos, etc).

### **Método de Resolución (Procedimiento)**
Dado un sistema:

$$
\begin{align*}
a_{11}x_1 + a_{12}x_2 + a_{13}x_3 &= b_1 \\
a_{21}x_1 + a_{22}x_2 + a_{23}x_3 &= b_2 \\
a_{31}x_1 + a_{32}x_2 + a_{33}x_3 &= b_3
\end{align*}
$$

Se despeja cada variable:

$$
\begin{align*}
x_1 &= \frac{1}{a_{11}}(b_1 - a_{12}x_2 - a_{13}x_3) \\
x_2 &= \frac{1}{a_{22}}(b_2 - a_{21}x_1 - a_{23}x_3) \\
x_3 &= \frac{1}{a_{33}}(b_3 - a_{31}x_1 - a_{32}x_2)
\end{align*}
$$

**Iteración:**  
En cada paso, se usa el **valor actualizado** tan pronto esté disponible.

### **Características**
- Requiere que el sistema sea **diagonalmente dominante** o que **converja** para funcionar bien.
- **Más rápido** que métodos directos para grandes matrices dispersas.
- Fácil de implementar pero puede **no converger** si el sistema no cumple ciertas condiciones.

### **Ejemplo**

Resolver el sistema:

$$
\begin{align*}
4x_1 + x_2 + 2x_3 &= 4 \\
3x_1 + 5x_2 + x_3 &= 7 \\
x_1 + x_2 + 3x_3 &= 3
\end{align*}
$$

**Paso 1: Despejamos cada variable**

$$
\begin{align*}
x_1 &= \frac{1}{4}(4 - x_2 - 2x_3) \\
x_2 &= \frac{1}{5}(7 - 3x_1 - x_3) \\
x_3 &= \frac{1}{3}(3 - x_1 - x_2)
\end{align*}
$$

**Paso 2: Supongamos una primera aproximación inicial**

$$
x_1^{(0)} = 0, \quad x_2^{(0)} = 0, \quad x_3^{(0)} = 0
$$

**Iteración 1:**

$$
\begin{align*}
x_1^{(1)} &= \frac{1}{4}(4 - 0 - 0) = 1 \\
x_2^{(1)} &= \frac{1}{5}(7 - 3(1) - 0) = 0.8 \\
x_3^{(1)} &= \frac{1}{3}(3 - 1 - 0.8) = 0.4
\end{align*}
$$

**Iteración 2:**

$$
\begin{align*}
x_1^{(2)} &= \frac{1}{4}(4 - 0.8 - 2(0.4)) = 0.6 \\
x_2^{(2)} &= \frac{1}{5}(7 - 3(0.6) - 0.4) = 1.08 \\
x_3^{(2)} &= \frac{1}{3}(3 - 0.6 - 1.08) \approx 0.44
\end{align*}
$$

Se siguen realizando iteraciones hasta que los valores de \( x_1 \), \( x_2 \) y \( x_3 \) se estabilicen dentro de un error tolerado.

---

### [Codigo en Java](GaussSeidel.java)

```java

import java.util.Scanner;
import java.util.Random;

// Clase que implementa el método de Gauss-Seidel para resolver sistemas de ecuaciones lineales
public class GaussSeidel {

     // Método principal que ejecuta el algoritmo de Gauss-Seidel
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         // Solicita al usuario el tamaño de la matriz (número de ecuaciones y variables)
        System.out.print("Introduce el tamaño de la matriz: ");
        int orden = sc.nextInt();

        // Genera aleatoriamente una matriz aumentada de tamaño [orden x (orden + 1)]
        double[][] matriz = generarMatriz(orden);
        
        // Muestra la matriz inicial
        System.out.println("\nMatriz inicial:");
        mostrarMatriz(matriz, orden);

        // Aproximaciones iniciales de las variables (todas en 0)
        double[] x = new double[orden]; // Aproximaciones iniciales (todas en 0)
        double tolerancia = 1e-6;
        int iteracionesMax = 100;
        int iteracion = 0;
        boolean converge = false;

        // Iteraciones del método de Gauss-Seidel
        while (!converge && iteracion < iteracionesMax) {
            double[] xAnterior = x.clone();
            System.out.printf("\nIteración %d:\n", iteracion + 1);

            // Actualización de las variables
            for (int i = 0; i < orden; i++) {
                double suma = 0;
                for (int j = 0; j < orden; j++) {
                    if (j != i) {
                        suma += matriz[i][j] * x[j];
                    }
                }
                x[i] = (matriz[i][orden] - suma) / matriz[i][i];
                System.out.printf("x%d = %.6f\n", i, x[i]);
            }
             // Comprobación de convergencia (si la diferencia es menor que la tolerancia)
            converge = true;
            for (int i = 0; i < orden; i++) {
                if (Math.abs(x[i] - xAnterior[i]) > tolerancia) {
                    converge = false;
                    break;
                }
            }
            iteracion++;
        }

        // Muestra la solución final si la convergencia se alcanzó
        if (converge) {
            System.out.println("\nSolución encontrada:");
            for (int i = 0; i < orden; i++) {
                System.out.printf("x%d = %.6f\n", i, x[i]);
            }
        } else {
            System.out.println("\nNo se alcanzó la convergencia en " + iteracionesMax + " iteraciones.");
        }
        // Cierra el scanner
        sc.close();
    }

    /**
     * Genera una matriz aumentada aleatoria de tamaño n x (n+1).
     * La matriz contiene coeficientes aleatorios entre -5 y 4.
     * Además, asegura que los pivotes no sean cero para la estabilidad numérica.
     *
     * @param orden número de ecuaciones (y variables)
     * @return matriz aumentada generada aleatoriamente
     */
    public static double[][] generarMatriz(int orden) {
        Random rand = new Random();
        double[][] matriz = new double[orden][orden + 1];

        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden + 1; j++) {
                matriz[i][j] = rand.nextInt(10) - 5; // Números entre -5 y 4
            }
            // Asegurar que los pivotes no sean 0 para estabilidad
            if (matriz[i][i] == 0) {
                matriz[i][i] = rand.nextInt(5) + 1;
            }
        }

        return matriz;
    }

    /**
     * Muestra la matriz aumentada en consola con formato.
     *
     * @param matriz la matriz a mostrar
     * @param orden  el número de ecuaciones (filas) de la matriz
     */
    public static void mostrarMatriz(double[][] matriz, int orden) {
        for (int i = 0; i < orden; i++) {
            String linea = "| ";
            for (int j = 0; j < orden + 1; j++) {
                linea += String.format("%8.3f", matriz[i][j]) + " ";
            }
            linea += "|";
            System.out.println(linea);
        }
        System.out.println();
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de prueba para el método de Gauss-Seidel

---

## Matriz aumentada (orden 3)

Usamos esta matriz manualmente para asegurar convergencia:

$$
\left[
\begin{array}{ccc|c}
4 & 1 & 2 & 4 \\
3 & 5 & 1 & 7 \\
1 & 1 & 3 & 3 \\
\end{array}
\right]
$$

---

## Modificaciones necesarias en el código

Reemplazar el método `generarMatriz()` por:

```java
public static double[][] generarMatriz(int orden) {
    return new double[][] {
        {4, 1, 2, 4},
        {3, 5, 1, 7},
        {1, 1, 3, 3}
    };
}
```

### Salida en consola

```java

Introduce el tamaño de la matriz: 3

Matriz inicial:
|    4.000    1.000    2.000    4.000 |
|    3.000    5.000    1.000    7.000 |
|    1.000    1.000    3.000    3.000 |

Iteración 1:
x0 = 1.000000
x1 = 0.800000
x2 = 0.400000

Iteración 2:
x0 = 0.600000
x1 = 0.800000
x2 = 0.533333

Iteración 3:
x0 = 0.533333
x1 = 0.866667
x2 = 0.533333

Iteración 4:
x0 = 0.533333
x1 = 0.866667
x2 = 0.533333

Solución encontrada:
x0 = 0.533333  
x1 = 0.866667  
x2 = 0.533333

```
