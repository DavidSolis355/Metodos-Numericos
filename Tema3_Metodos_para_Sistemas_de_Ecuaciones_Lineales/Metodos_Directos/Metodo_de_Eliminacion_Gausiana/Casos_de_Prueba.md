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
