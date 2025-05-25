# Método de Sistemas de Ecuaciones para Ecuaciones Diferenciales

## Introducción

En muchos problemas reales, las ecuaciones diferenciales aparecen como sistemas de ecuaciones acopladas en lugar de ecuaciones individuales. El **Método de Sistemas de Ecuaciones** aborda la solución numérica de estas EDOs múltiples simultáneamente.

Este método transforma un sistema de ecuaciones diferenciales en un sistema de ecuaciones algebraicas que se pueden resolver iterativamente para aproximar la solución en distintos puntos.

---

## Conceptos Básicos

- Un sistema de ecuaciones diferenciales puede expresarse como:

  $$
  \begin{cases}
    \frac{dy_1}{dx} = f_1(x, y_1, y_2, ..., y_m) \\
    \frac{dy_2}{dx} = f_2(x, y_1, y_2, ..., y_m) \\
    \vdots \\
    \frac{dy_m}{dx} = f_m(x, y_1, y_2, ..., y_m)
  \end{cases}
  $$

- Las condiciones iniciales son:

  $$
  y_i(x_0) = y_{i0}, \quad i=1,2,...,m
  $$

- Los métodos numéricos para sistemas se basan en extender los métodos de un solo paso o múltiples a vectores de variables.

---

## Métodos comunes para sistemas

- **Runge-Kutta para sistemas**: Se aplican los pasos de Runge-Kutta considerando cada ecuación del sistema simultáneamente.
  
- **Métodos de Euler para sistemas**: Extensión directa del método de Euler a vectores.

- **Métodos de pasos múltiples**: Como Adams-Bashforth o Adams-Moulton adaptados para sistemas.

---

## Ventajas

- Permite resolver problemas con múltiples variables dependientes y ecuaciones acopladas.
- Flexible para sistemas lineales y no lineales.
- Puede integrarse con otros métodos para mayor precisión.

---

## Desventajas

- Mayor complejidad computacional comparado con ecuaciones individuales.
- Requiere manejo cuidadoso del almacenamiento y cálculo de vectores y matrices.
- Estabilidad y precisión dependen de la elección del método y paso.

---

## Ejemplo típico

Resolver el sistema:

$$
\begin{cases}
\frac{dy}{dx} = z \\
\frac{dz}{dx} = -y
\end{cases}
$$

con condiciones iniciales \( y(0)=0 \), \( z(0)=1 \).

---

## Aplicaciones

- Modelado de sistemas físicos acoplados (por ejemplo, sistemas mecánicos, circuitos eléctricos).
- Problemas en biología, química y economía donde varias variables evolucionan conjuntamente.
- Solución de sistemas dinámicos y control.

---

## Notas Finales

- Para sistemas grandes o rígidos, se prefieren métodos especializados.
- Implementar correctamente el manejo de vectores es clave para la eficiencia.
- Es posible combinar con métodos adaptativos para mejorar la precisión.
