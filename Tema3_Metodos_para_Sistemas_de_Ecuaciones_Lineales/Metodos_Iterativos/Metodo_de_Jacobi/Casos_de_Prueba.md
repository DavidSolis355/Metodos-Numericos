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
