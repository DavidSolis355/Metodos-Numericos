## **Método de Eliminación Gaussiana**

### **Definición**
La **eliminación gaussiana** es un método algorítmico para resolver sistemas de ecuaciones lineales. Consiste en transformar el sistema original en un sistema triangular superior, facilitando así la obtención de las soluciones mediante sustitución hacia atrás.

### **¿Para qué se usa?**
- Para **resolver sistemas de ecuaciones lineales** de forma sistemática.
- Para **calcular determinantes** y **matrices inversas**.
- Ampliamente utilizado en álgebra lineal aplicada en ingeniería, ciencias y computación.

### **Método de Resolución (Procedimiento)**
1. **Formar la matriz aumentada** del sistema.
2. **Aplicar operaciones elementales** (intercambiar filas, multiplicar una fila por un escalar, sumar múltiplos de filas) para obtener ceros debajo de la diagonal principal.
3. **Obtener una matriz triangular superior**.
4. **Resolver el sistema por sustitución hacia atrás**.

**Forma general:**

$$
\begin{align*}
a_{11}x_1 + a_{12}x_2 + \cdots + a_{1n}x_n &= b_1 \\
a_{21}x_1 + a_{22}x_2 + \cdots + a_{2n}x_n &= b_2 \\
\vdots \quad\quad\quad\quad\quad\quad\quad\quad\quad\quad &\vdots \\
a_{n1}x_1 + a_{n2}x_2 + \cdots + a_{nn}x_n &= b_n
\end{align*}
$$

Se transforma en:

$$
\begin{align*}
a'_{11}x_1 + a'_{12}x_2 + \cdots + a'_{1n}x_n &= b'_1 \\
\quad\quad a'_{22}x_2 + \cdots + a'_{2n}x_n &= b'_2 \\
\quad\quad\quad\quad \ddots \quad\quad\quad\quad &= \vdots \\
\quad\quad\quad\quad\quad\quad\quad a'_{nn}x_n &= b'_n
\end{align*}
$$

Luego se resuelve:

$$
x_n = \frac{b'_n}{a'_{nn}}
$$
y así sucesivamente hacia atrás.

### **Características**
- **Determinista:** siempre llega a una solución (si existe y es única).
- **Simple de programar.**
- Puede verse afectado por problemas de **estabilidad numérica** (requiriendo pivotaje).
- Necesita aproximadamente \( \frac{2}{3}n^3 \) operaciones para un sistema de \( n \) incógnitas.

### **Ejemplo**

Resolver el siguiente sistema:

$$
\begin{align*}
2x + 3y - z &= 5 \\
4x + 4y - 3z &= 3 \\
-2x + 3y + 2z &= 7
\end{align*}
$$

**Paso 1: Matriz aumentada**

$$
\left[
\begin{array}{ccc|c}
2 & 3 & -1 & 5 \\
4 & 4 & -3 & 3 \\
-2 & 3 & 2 & 7
\end{array}
\right]
$$

**Paso 2: Hacer ceros debajo del pivote en la primera columna**

Operaciones:

- Fila 2: \( F_2 \leftarrow F_2 - 2F_1 \)
- Fila 3: \( F_3 \leftarrow F_3 + F_1 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
2 & 3 & -1 & 5 \\
0 & -2 & -1 & -7 \\
0 & 6 & 1 & 12
\end{array}
\right]
$$

**Paso 3: Hacer ceros debajo del pivote en la segunda columna**

Operación:

- Fila 3: \( F_3 \leftarrow F_3 + 3F_2 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
2 & 3 & -1 & 5 \\
0 & -2 & -1 & -7 \\
0 & 0 & -2 & -9
\end{array}
\right]
$$

**Paso 4: Sustitución hacia atrás**

- De la tercera fila:

$$
-2z = -9 \quad \Rightarrow \quad z = 4.5
$$

- De la segunda fila:

$$
-2y - (1)(4.5) = -7 \quad \Rightarrow \quad -2y = -2.5 \quad \Rightarrow \quad y = 1.25
$$

- De la primera fila:

$$
2x + 3(1.25) - 4.5 = 5 \quad \Rightarrow \quad 2x + 3.75 - 4.5 = 5 \quad \Rightarrow \quad 2x - 0.75 = 5
$$

$$
2x = 5.75 \quad \Rightarrow \quad x = 2.875
$$

**Solución:**

$$
x = 2.875, \quad y = 1.25, \quad z = 4.5
$$

---

### [Codigo en Java](EliminacionGaussiana.java)

```java

import java.util.Scanner;
import java.util.Random;

// Clase que implementa el método de eliminación gaussiana para resolver sistemas de ecuaciones lineales
public class EliminacionGaussiana
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        // Solicita al usuario el tamaño del sistema (número de ecuaciones y variables)
        System.out.print("Introduce el tamaño de la matriz");
        int orden = sc.nextInt();
        
        // Genera aleatoriamente una matriz aumentada de tamaño [orden x (orden + 1)]
        double[][] matriz = generarMatriz(orden);
        
        // Proceso de eliminación hacia adelante
        for(int j = 0; j < orden; j++)
        {
            for(int i = 0; j < orden; i++)
            {
                if (i > j) 
                {
                    // Calcula el factor de eliminación
                    double division = matriz[i][j] / matriz[j][j];
                    System.out.printf("Haciendo cero el elemento en fila %d, columna %d (usando fila %d):\n", i + 1, j + 1, j + 1);
                    System.out.printf("Factor de eliminacion = %.3f\n", division);

                    // Resta la fila j multiplicada por el factor a la fila i
                    for (int k = 0; k < orden + 1; k++) 
                    {
                        matriz[i][k] = matriz[i][k] - division * matriz[j][k];
                    }

                    // Muestra el estado actual de la matriz después de la eliminación
                    mostrarMatriz(matriz, orden);  
                }
            }    
        }
        
        // Sustitución hacia atrás para obtener la solución del sistema
        double[] x = new double[orden];
        
        System.out.println("Resolviendo por sustitucion hacia atras:");
        for (int i = orden - 1; i >= 0; i--) 
        {
            double suma = 0;
            // Suma de los términos ya resueltos
            for (int j = i + 1; j < orden; j++) 
            {
                suma += matriz[i][j] * x[j];
            }
            // Calcula el valor de la variable actual
            x[i] = (matriz[i][orden] - suma) / matriz[i][i];
            System.out.printf("x%d = %.3f\n", i, x[i]);
        }
        
        // Muestra la solución final del sistema
        System.out.println("\nSolucion final:");
        for (int i = 0; i < orden; i++) 
        {
            System.out.printf("x%d = %.3f\n", i, x[i]);
        }
        
        sc.close();
    }
        
    /**
     * Genera una matriz aumentada aleatoria de tamaño n x (n+1)
     *
     * @param orden número de ecuaciones (y variables)
     * @return matriz aumentada con coeficientes aleatorios entre -5 y 4
     */
    public static double[][] generarMatriz(int orden)
    {
        Random rand = new Random();
        double[][] matriz = new double[orden][orden+1];
        
        for(int i = 0; i < orden; i++)
        {
            for (int j = 0; j < orden + 1; j ++)
            {
                matriz[i][j] = rand.nextInt(10) - 5;
            }
        }
        
        return matriz;
    }

    /**
     * Muestra por consola la matriz aumentada con formato
     *
     * @param matriz matriz aumentada a imprimir
     * @param orden  número de ecuaciones (filas)
     */
    public static void mostrarMatriz(double[][] matriz, int orden)
    {
        for (int i = 0; i < orden; i++) 
        {
            String linea = "| ";
            for (int j = 0; j < orden + 1; j++) 
            {
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

# Casos de prueba para el método de Eliminación Gaussiana

Este documento contiene dos casos de prueba para el programa de eliminación gaussiana: uno donde el sistema tiene solución y otro donde no la tiene (por ser un sistema incompatible o tener determinante cero).

---

## Caso 1: Sistema compatible (tiene solución)

### Matriz aumentada (sistema 3x3)

$$
\left[
\begin{array}{ccc|c}
2 & 1 & -1 & 8 \\
-3 & -1 & 2 & -11 \\
-2 & 1 & 2 & -3 \\
\end{array}
\right]
$$

### Descripción

- Sistema de 3 ecuaciones con 3 incógnitas.
- Matriz no singular, determinante distinto de cero.
- El método de eliminación gaussiana debe converger a una solución única.

### Resultados de Consola:

Haciendo cero el elemento en fila 2, columna 1 (usando fila 1):
Factor de eliminacion = -1.500
| 2.000 1.000 -1.000 8.000 |
| 0.000 0.500 0.500 1.000 |
| -2.000 1.000 2.000 -3.000 |

Haciendo cero el elemento en fila 3, columna 1 (usando fila 1):
Factor de eliminacion = -1.000
| 2.000 1.000 -1.000 8.000 |
| 0.000 0.500 0.500 1.000 |
| 0.000 2.000 1.000 5.000 |

Haciendo cero el elemento en fila 3, columna 2 (usando fila 2):
Factor de eliminacion = 4.000
| 2.000 1.000 -1.000 8.000 |
| 0.000 0.500 0.500 1.000 |
| 0.000 0.000 -1.000 1.000 |

Resolviendo por sustitucion hacia atras:
x2 = 1.000
x1 = 2.000
x0 = 3.000

Solucion final:
x0 = 3.000
x1 = 2.000
x2 = 1.000


