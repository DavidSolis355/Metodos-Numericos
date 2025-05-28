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



```
