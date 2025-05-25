# Métodos de Solución de Ecuaciones Diferenciales

## Introducción

La solución numérica de ecuaciones diferenciales es fundamental para resolver problemas donde no es posible obtener una solución analítica exacta. Estos métodos aproximan la solución evaluando valores discretos en pasos específicos.

En este tema, exploraremos diferentes métodos para resolver ecuaciones diferenciales:

- Método de 1 Paso
- Método de Pasos Múltiples
- Método de Sistemas de Ecuaciones

---

## Conceptos Básicos

- **Ecuación diferencial ordinaria (EDO):** Una ecuación que involucra funciones desconocidas y sus derivadas.
- **Condiciones iniciales:** Valores conocidos de la función y/o sus derivadas en un punto específico, necesarios para comenzar el método numérico.
- **Paso (h):** Tamaño del incremento en la variable independiente para aproximar la solución.

---

## Métodos de Solución de Ecuaciones Diferenciales

### 1. Método de 1 Paso

Los métodos de un paso calculan el valor siguiente usando solo información del punto actual.

#### Método de Euler

Es el método más simple y consiste en aproximar la pendiente en el punto actual y avanzar un paso:

$$
y_{n+1} = y_n + h f(x_n, y_n)
$$

**Ventajas:**

- Fácil de implementar.
- Requiere poco cálculo.

**Desventajas:**

- Baja precisión.
- Puede ser inestable para pasos grandes.

#### Método de Runge-Kutta de 4to orden (RK4)

Mejora la precisión calculando varias pendientes intermedias:

$$
\begin{aligned}
k_1 &= f(x_n, y_n) \\
k_2 &= f\left(x_n + \frac{h}{2}, y_n + \frac{h}{2}k_1\right) \\
k_3 &= f\left(x_n + \frac{h}{2}, y_n + \frac{h}{2}k_2\right) \\
k_4 &= f(x_n + h, y_n + h k_3) \\
y_{n+1} &= y_n + \frac{h}{6}(k_1 + 2k_2 + 2k_3 + k_4)
\end{aligned}
$$

**Ventajas:**

- Alta precisión.
- Estabilidad mejor que Euler.

**Desventajas:**

- Más cálculos por paso.

---

### 2. Método de Pasos Múltiples

Estos métodos usan valores de pasos anteriores para calcular el siguiente valor, logrando mayor eficiencia.

#### Método de Adams-Bashforth (explícito)

Ejemplo de fórmula para 4 pasos:

$$
y_{n+1} = y_n + \frac{h}{24} (55 f_n - 59 f_{n-1} + 37 f_{n-2} - 9 f_{n-3})
$$

Donde \(f_n = f(x_n, y_n)\).

**Ventajas:**

- Menos evaluaciones por paso que RK4.
- Bueno para problemas suaves.

**Desventajas:**

- Necesita valores iniciales de otros métodos.
- Puede ser inestable si no se usa correctamente.

#### Método de Adams-Moulton (implícito)

Ejemplo para 3 pasos:

$$
y_{n+1} = y_n + \frac{h}{24} (9 f_{n+1} + 19 f_n - 5 f_{n-1} + f_{n-2})
$$

Este método es implícito y requiere resolver una ecuación para \(y_{n+1}\).

---

### 3. Método de Sistemas de Ecuaciones

Cuando la ecuación diferencial es un sistema de ecuaciones acopladas, se aplican métodos que trabajan con vectores y matrices.

Ejemplo para un sistema:

$$
\frac{d\mathbf{y}}{dx} = \mathbf{f}(x, \mathbf{y})
$$

Donde

$$
\mathbf{y} = \begin{bmatrix} y_1 \\ y_2 \\ \vdots \\ y_m \end{bmatrix}, \quad \mathbf{f} = \begin{bmatrix} f_1(x, \mathbf{y}) \\ f_2(x, \mathbf{y}) \\ \vdots \\ f_m(x, \mathbf{y}) \end{bmatrix}
$$

Se pueden aplicar los métodos mencionados (Euler, Runge-Kutta, etc.) para cada componente vectorial.

---

## Notas Finales

- Los métodos de 1 paso son simples pero pueden ser menos precisos o estables.
- Los métodos de pasos múltiples requieren más información inicial, pero son más eficientes.
- Para sistemas de ecuaciones, es crucial manejar las variables de forma vectorial.
- La elección del método depende de la precisión requerida y la naturaleza del problema.