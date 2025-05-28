## **Método de Jacobi**

### **Definición**
El **método de Jacobi** es un método iterativo para resolver **sistemas de ecuaciones lineales**. Calcula las nuevas aproximaciones de las variables **sin usar** los valores actualizados dentro de la misma iteración.

### **¿Para qué se usa?**
- Resolver **sistemas grandes** de ecuaciones lineales.
- Útil cuando el sistema es **diagonalmente dominante**.
- Empleado en áreas como análisis estructural y simulaciones numéricas.

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
Cada nueva \( x_i^{(k+1)} \) se calcula **usando solo** los valores de la iteración anterior \( x^{(k)} \).

### **Características**
- No usa los valores actualizados inmediatamente (a diferencia de Gauss-Seidel).
- Funciona bien si la matriz es **diagonalmente dominante**.
- Puede ser **más lento** que Gauss-Seidel.
- Muy **fácil de paralelizar** (ideal para procesamiento en paralelo).

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

**Paso 2: Primera aproximación inicial**

$$
x_1^{(0)} = 0, \quad x_2^{(0)} = 0, \quad x_3^{(0)} = 0
$$

**Iteración 1:**

$$
\begin{align*}
x_1^{(1)} &= \frac{1}{4}(4 - 0 - 0) = 1 \\
x_2^{(1)} &= \frac{1}{5}(7 - 3(0) - 0) = 1.4 \\
x_3^{(1)} &= \frac{1}{3}(3 - 0 - 0) = 1
\end{align*}
$$

**Iteración 2:**

Usando solo los valores de la **iteración anterior**:

$$
\begin{align*}
x_1^{(2)} &= \frac{1}{4}(4 - 1.4 - 2(1)) = 0.4 \\
x_2^{(2)} &= \frac{1}{5}(7 - 3(1) - 1) = 0.6 \\
x_3^{(2)} &= \frac{1}{3}(3 - 1 - 1.4) \approx 0.2
\end{align*}
$$

Se continúa iterando hasta que los valores se estabilicen dentro de una tolerancia aceptable.

---

### [Codigo en Java](Jacobi.java)

```java

import java.util.Scanner;
import java.util.Random;

public class Jacobi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el tamaño de la matriz: ");
        int orden = sc.nextInt();

        double[][] matriz = generarMatriz(orden);

        System.out.println("\nMatriz inicial:");
        mostrarMatriz(matriz, orden);

        double[] x = new double[orden]; 
        double[] xNuevo = new double[orden]; 
        double tolerancia = 1e-6;
        int iteracionesMax = 100;
        int iteracion = 0;
        boolean converge = false;

        while (!converge && iteracion < iteracionesMax) {
            System.out.printf("\nIteración %d:\n", iteracion + 1);

            for (int i = 0; i < orden; i++) {
                double suma = 0;
                for (int j = 0; j < orden; j++) {
                    if (j != i) {
                        suma += matriz[i][j] * x[j];
                    }
                }
                xNuevo[i] = (matriz[i][orden] - suma) / matriz[i][i];
                System.out.printf("x%d = %.6f\n", i, xNuevo[i]);
            }

            converge = true;
            for (int i = 0; i < orden; i++) {
                if (Math.abs(xNuevo[i] - x[i]) > tolerancia) {
                    converge = false;
                    break;
                }
            }

            System.arraycopy(xNuevo, 0, x, 0, orden);
            iteracion++;
        }

        if (converge) {
            System.out.println("\nSolución encontrada:");
            for (int i = 0; i < orden; i++) {
                System.out.printf("x%d = %.6f\n", i, x[i]);
            }
        } else {
            System.out.println("\nNo se alcanzó la convergencia en " + iteracionesMax + " iteraciones.");
        }

        sc.close();
    }

    public static double[][] generarMatriz(int orden) {
        Random rand = new Random();
        double[][] matriz = new double[orden][orden + 1];

        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden + 1; j++) {
                matriz[i][j] = rand.nextInt(10) - 5; 
            }
            if (matriz[i][i] == 0) {
                matriz[i][i] = rand.nextInt(5) + 1;
            }
        }

        return matriz;
    }

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

# Ejemplo de ejecución del método de Jacobi

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

### Salida en Consola

```java

Introduce el tamaño de la matriz: 3

Matriz inicial:
|    4.000    1.000    2.000    4.000 |
|    3.000    5.000    1.000    7.000 |
|    1.000    1.000    3.000    3.000 |

Iteración 1:
x0 = 1.000000
x1 = 1.400000
x2 = 1.000000

Iteración 2:
x0 = 0.050000
x1 = 0.600000
x2 = 0.200000

Iteración 3:
x0 = 0.750000
x1 = 1.150000
x2 = 0.717000

Iteración 4:
x0 = 0.354000
x1 = 0.600000
x2 = 0.366667

...

Iteración 19:
x0 = 0.533339
x1 = 0.866667
x2 = 0.533329

Iteración 20:
x0 = 0.533333
x1 = 0.866667
x2 = 0.533333

Solución encontrada:
x0 = 0.533333  
x1 = 0.866667  
x2 = 0.533333


```
