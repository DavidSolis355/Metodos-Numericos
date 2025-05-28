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