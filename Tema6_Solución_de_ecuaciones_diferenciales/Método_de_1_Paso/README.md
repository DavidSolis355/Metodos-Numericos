# Método de 1 Paso para Ecuaciones Diferenciales

## Introducción

Los métodos de un paso resuelven ecuaciones diferenciales aproximando la solución en puntos discretos utilizando únicamente la información del paso actual. Son sencillos de implementar y ampliamente usados para problemas donde la precisión moderada es suficiente.

En este tema veremos dos métodos importantes de un paso:

- Método de Euler
- Método de Runge-Kutta de 4to orden (RK4)

---

## Conceptos Básicos

- **Paso (h):** Tamaño del incremento en la variable independiente \(x\).
- **Pendiente:** Derivada de la función evaluada en un punto, utilizada para estimar la siguiente aproximación.
- **Condición inicial:** Valor conocido de la función \(y\) en el punto \(x_0\).

---

## Métodos

### 1. Método de Euler

El método más sencillo que aproxima la solución utilizando la pendiente en el punto actual:

$$
y_{n+1} = y_n + h f(x_n, y_n)
$$

Donde:

- \(y_n\) es la aproximación actual.
- \(h\) es el tamaño del paso.
- \(f(x_n, y_n)\) es la función que define la derivada \(\frac{dy}{dx}\).

**Ventajas:**

- Fácil de entender y programar.
- Requiere solo una evaluación de función por paso.

**Desventajas:**

- Precisión baja.
- Puede ser inestable para valores grandes de \(h\).

---

### 2. Método de Runge-Kutta de 4to orden (RK4)

Método más avanzado que calcula pendientes intermedias para mejorar la precisión:

$$
\begin{aligned}
k_1 &= f(x_n, y_n) \\
k_2 &= f\left(x_n + \frac{h}{2}, y_n + \frac{h}{2} k_1 \right) \\
k_3 &= f\left(x_n + \frac{h}{2}, y_n + \frac{h}{2} k_2 \right) \\
k_4 &= f(x_n + h, y_n + h k_3) \\
y_{n+1} &= y_n + \frac{h}{6} (k_1 + 2 k_2 + 2 k_3 + k_4)
\end{aligned}
$$

**Ventajas:**

- Alta precisión con pasos moderados.
- Más estable que Euler para problemas rígidos.

**Desventajas:**

- Requiere cuatro evaluaciones de la función por paso.
- Más complejo de implementar que Euler.

---

## Ejemplo de Uso

Supongamos resolver la EDO:

$$
\frac{dy}{dx} = x + y
$$

Con condición inicial \(y(0) = 1\), paso \(h = 0.1\), para encontrar \(y\) en \(x=0.1\) usando:

- **Euler:**

$$
y_1 = y_0 + h f(x_0, y_0) = 1 + 0.1 (0 + 1) = 1.1
$$

- **RK4:**

$$
\begin{aligned}
k_1 &= f(0,1) = 1 \\
k_2 &= f(0.05, 1 + 0.05 \cdot 1) = f(0.05, 1.05) = 1.1 \\
k_3 &= f(0.05, 1 + 0.05 \cdot 1.1) = f(0.05, 1.055) = 1.105 \\
k_4 &= f(0.1, 1 + 0.1 \cdot 1.105) = f(0.1, 1.1105) = 1.2105 \\
y_1 &= 1 + \frac{0.1}{6} (1 + 2 \cdot 1.1 + 2 \cdot 1.105 + 1.2105) = 1.1103
\end{aligned}
$$

---

## Notas Finales

- El método de Euler es adecuado para problemas sencillos o para iniciar otros métodos.
- RK4 es una opción estándar cuando se requiere buena precisión sin gran complejidad.
- Siempre elegir un tamaño de paso \(h\) adecuado para equilibrar precisión y costo computacional.


