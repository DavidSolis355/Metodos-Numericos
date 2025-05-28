# Casos de prueba para el método de Eliminación Gaussiana

Este documento contiene dos casos de prueba para el programa de eliminación gaussiana: uno donde el sistema tiene solución y otro donde no la tiene (por ser un sistema incompatible o tener determinante cero).

---

## Formato para matrices en Markdown

Las matrices se muestran usando notación LaTeX encerrada entre dobles signos de dólar `$$ ... $$` para que se visualicen como fórmulas matemáticas.

Ejemplo:

$$
\begin{bmatrix}
1 & 2 & 3 \\
4 & 5 & 6 \\
7 & 8 & 9 \\
\end{bmatrix}
$$

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

---

## Caso 2: Sistema incompatible (sin solución)

### Matriz aumentada (sistema 3x3)

$$
\left[
\begin{array}{ccc|c}
1 & -2 & 3 & 4 \\
2 & -4 & 6 & 5 \\
-1 & 2 & -3 & -4 \\
\end{array}
\right]
$$

### Descripción

- Sistema con filas proporcionales en los coeficientes pero con términos independientes distintos.
- El sistema no tiene solución (incompatible).
- El método de eliminación gaussiana detectará filas nulas con término independiente no nulo o división por cero en la diagonal.

