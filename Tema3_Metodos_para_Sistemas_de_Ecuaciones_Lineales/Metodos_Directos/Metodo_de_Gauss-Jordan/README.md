## **Método de Gauss-Jordan**

### **Definición**
El **método de Gauss-Jordan** es una extensión de la eliminación gaussiana que transforma la matriz aumentada de un sistema lineal en una **matriz identidad**, resolviendo directamente el sistema sin necesidad de sustitución hacia atrás.

### **¿Para qué se usa?**
- Para **resolver sistemas de ecuaciones lineales**.
- Para **hallar inversas** de matrices.
- Para **determinar la dependencia lineal** entre vectores.

### **Método de Resolución (Procedimiento)**
1. **Formar la matriz aumentada** del sistema.
2. **Aplicar operaciones elementales** para obtener:
   - Unos en la diagonal principal.
   - Ceros en todas las posiciones fuera de la diagonal.
3. **Leer directamente la solución** del sistema.

**Forma general del objetivo:**

$$
\left[
\begin{array}{ccc|c}
1 & 0 & 0 & x_1 \\
0 & 1 & 0 & x_2 \\
0 & 0 & 1 & x_3
\end{array}
\right]
$$

### **Características**
- **Más laborioso** que la eliminación gaussiana simple.
- El sistema queda **totalmente reducido**, sin necesidad de sustitución hacia atrás.
- Ideal para **programación computacional** cuando se requiere solución automática y directa.

### **Ejemplo**

Resolver el siguiente sistema:

$$
\begin{align*}
x + 2y + z &= 9 \\
2x + 3y + 3z &= 21 \\
y + 2z &= 8
\end{align*}
$$

**Paso 1: Matriz aumentada**

$$
\left[
\begin{array}{ccc|c}
1 & 2 & 1 & 9 \\
2 & 3 & 3 & 21 \\
0 & 1 & 2 & 8
\end{array}
\right]
$$

**Paso 2: Hacer ceros debajo y encima del primer pivote (1 en la posición (1,1))**

Operaciones:

- Fila 2: \( F_2 \leftarrow F_2 - 2F_1 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
1 & 2 & 1 & 9 \\
0 & -1 & 1 & 3 \\
0 & 1 & 2 & 8
\end{array}
\right]
$$

**Paso 3: Hacer 1 el pivote de la segunda fila (posición (2,2))**

- Fila 2: \( F_2 \leftarrow -F_2 \)

$$
\left[
\begin{array}{ccc|c}
1 & 2 & 1 & 9 \\
0 & 1 & -1 & -3 \\
0 & 1 & 2 & 8
\end{array}
\right]
$$

**Paso 4: Hacer ceros en las otras posiciones de la segunda columna**

- Fila 1: \( F_1 \leftarrow F_1 - 2F_2 \)
- Fila 3: \( F_3 \leftarrow F_3 - F_2 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
1 & 0 & 3 & 15 \\
0 & 1 & -1 & -3 \\
0 & 0 & 3 & 11
\end{array}
\right]
$$

**Paso 5: Hacer 1 el pivote de la tercera fila (posición (3,3))**

- Fila 3: \( F_3 \leftarrow \frac{1}{3}F_3 \)

$$
\left[
\begin{array}{ccc|c}
1 & 0 & 3 & 15 \\
0 & 1 & -1 & -3 \\
0 & 0 & 1 & \frac{11}{3}
\end{array}
\right]
$$

**Paso 6: Hacer ceros en las otras posiciones de la tercera columna**

- Fila 1: \( F_1 \leftarrow F_1 - 3F_3 \)
- Fila 2: \( F_2 \leftarrow F_2 + F_3 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
1 & 0 & 0 & 4 \\
0 & 1 & 0 & \frac{2}{3} \\
0 & 0 & 1 & \frac{11}{3}
\end{array}
\right]
$$

### **Solución directa**

$$
x = 4, \quad y = \frac{2}{3}, \quad z = \frac{11}{3}
$$

---

### [Codigo en Java](GaussJordan.java)

```java

import java.util.Scanner;
import java.util.Random;

// Clase que implementa el método de Gauss-Jordan para resolver sistemas de ecuaciones lineales
public class GaussJordan {

    // Método principal para ejecutar el algoritmo de Gauss-Jordan
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Solicita al usuario el tamaño del sistema (número de ecuaciones y variables)
        System.out.print("Introduce el tamaño de la matriz: ");
        int orden = sc.nextInt();
        
        // Genera aleatoriamente una matriz aumentada de tamaño [orden x (orden + 1)]
        double[][] matriz = generarMatriz(orden);
        
        // Muestra la matriz inicial
        System.out.println("\nMatriz inicial:");
        mostrarMatriz(matriz, orden);

        // Proceso de eliminación de Gauss-Jordan
        for (int i = 0; i < orden; i++) {
            // Elige el pivote (elemento diagonal)
            double pivote = matriz[i][i];

            // Verifica si el pivote es cero, lo cual causaría una división por cero
            if (pivote == 0) {
                System.out.println("Error: pivote cero.");
                return;
            }
            // Normaliza la fila dividiendo por el pivote
            System.out.printf("\nNormalizando fila %d (dividir entre %.3f):\n", i + 1, pivote);
            for (int j = 0; j < orden + 1; j++) {
                matriz[i][j] /= pivote;
            }
            // Muestra el estado de la matriz después de la normalización
            mostrarMatriz(matriz, orden);
            
            // Elimina los elementos debajo y encima del pivote para hacer la matriz diagonal
            for (int k = 0; k < orden; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    System.out.printf("Haciendo cero el elemento en fila %d, columna %d (usando fila %d):\n", k + 1, i + 1, i + 1);
                    for (int j = 0; j < orden + 1; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                    // Muestra el estado de la matriz después de la eliminación
                    mostrarMatriz(matriz, orden);
                }
            }
        }
        
        // Muestra la solución final, que estará en la última columna de la matriz
        System.out.println("Solución final:");
        for (int i = 0; i < orden; i++) {
            System.out.printf("x%d = %.3f\n", i, matriz[i][orden]);
        }
        
        // Cierra el escáner
        sc.close();
    }

    /**
     * Genera una matriz aumentada aleatoria de tamaño n x (n+1).
     * La matriz contiene coeficientes aleatorios entre -5 y 4.
     *
     * @param orden número de ecuaciones (y variables)
     * @return matriz aumentada generada aleatoriamente
     */
    public static double[][] generarMatriz(int orden) {
        Random rand = new Random();
        double[][] matriz = new double[orden][orden + 1];
        
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden + 1; j++) {
                matriz[i][j] = rand.nextInt(10) - 5;
            }
        }
        
        return matriz;
    }

     /**
     * Muestra la matriz aumentada en consola con formato
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
        // Imprime una línea vacía para separar las matrices
        System.out.println();
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Caso de prueba para el método de Gauss-Jordan 

---

## Matriz aumentada inicial (orden 3)

$$
\left[
\begin{array}{ccc|c}
2 & 1 & -1 & 8 \\
-3 & -1 & 2 & -11 \\
-2 & 1 & 2 & -3 \\
\end{array}
\right]
$$

---

## Salida esperada en consola

```java

Introduce el tamaño de la matriz: 3

Matriz inicial:
| 2.000 1.000 -1.000 8.000 |
| -3.000 -1.000 2.000 -11.000 |
| -2.000 1.000 2.000 -3.000 |

Normalizando fila 1 (dividir entre 2.000):
| 1.000 0.500 -0.500 4.000 |
| -3.000 -1.000 2.000 -11.000 |
| -2.000 1.000 2.000 -3.000 |

Haciendo cero el elemento en fila 2, columna 1 (usando fila 1):
| 1.000 0.500 -0.500 4.000 |
| 0.000 0.500 0.500 1.000 |
| -2.000 1.000 2.000 -3.000 |

Haciendo cero el elemento en fila 3, columna 1 (usando fila 1):
| 1.000 0.500 -0.500 4.000 |
| 0.000 0.500 0.500 1.000 |
| 0.000 2.000 1.000 5.000 |

Normalizando fila 2 (dividir entre 0.500):
| 1.000 0.500 -0.500 4.000 |
| 0.000 1.000 1.000 2.000 |
| 0.000 2.000 1.000 5.000 |

Haciendo cero el elemento en fila 1, columna 2 (usando fila 2):
| 1.000 0.000 -1.500 3.000 |
| 0.000 1.000 1.000 2.000 |
| 0.000 2.000 1.000 5.000 |

Haciendo cero el elemento en fila 3, columna 2 (usando fila 2):
| 1.000 0.000 -1.500 3.000 |
| 0.000 1.000 1.000 2.000 |
| 0.000 0.000 -1.000 1.000 |

Normalizando fila 3 (dividir entre -1.000):
| 1.000 0.000 -1.500 3.000 |
| 0.000 1.000 1.000 2.000 |
| 0.000 0.000 1.000 -1.000 |

Haciendo cero el elemento en fila 1, columna 3 (usando fila 3):
| 1.000 0.000 0.000 1.500 |
| 0.000 1.000 1.000 2.000 |
| 0.000 0.000 1.000 -1.000 |

Haciendo cero el elemento en fila 2, columna 3 (usando fila 3):
| 1.000 0.000 0.000 1.500 |
| 0.000 1.000 0.000 3.000 |
| 0.000 0.000 1.000 -1.000 |

Solución final:
x0 = 1.500
x1 = 3.000
x2 = -1.000

```
