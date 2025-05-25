# Método de Runge-Kutta de 4to Orden (RK4)

## Introducción

El método de Runge-Kutta de 4to orden es un método numérico muy popular para resolver ecuaciones diferenciales ordinarias (EDO). Ofrece una buena precisión y estabilidad sin ser demasiado complejo.

Este método calcula varias pendientes (derivadas) intermedias en cada paso para obtener una mejor aproximación del valor siguiente, comparado con métodos más simples como Euler.

---

## Fórmulas del Método RK4

Para una EDO de la forma:

$$
\frac{dy}{dx} = f(x, y)
$$

Con condición inicial:

$$
y(x_0) = y_0
$$

Se calcula el siguiente valor \(y_{n+1}\) usando:

$$
\begin{aligned}
k_1 &= f(x_n, y_n) \\
k_2 &= f\left(x_n + \frac{h}{2}, y_n + \frac{h}{2} k_1 \right) \\
k_3 &= f\left(x_n + \frac{h}{2}, y_n + \frac{h}{2} k_2 \right) \\
k_4 &= f(x_n + h, y_n + h k_3) \\
y_{n+1} &= y_n + \frac{h}{6} (k_1 + 2k_2 + 2k_3 + k_4)
\end{aligned}
$$

Donde:

- \(h\) es el tamaño del paso.
- \(x_n, y_n\) son los valores actuales de la variable independiente y dependiente.
- \(y_{n+1}\) es la aproximación del siguiente valor de la función.

---

## Ventajas

- Alta precisión para un costo computacional razonable.
- Más estable que el método de Euler.
- Amplio uso en problemas científicos e ingeniería.

---

## Desventajas

- Requiere cuatro evaluaciones de la función por paso.
- Implementación ligeramente más compleja que métodos de un paso simples.

---

## Ejemplo de Uso

Resolver la EDO:

$$
\frac{dy}{dx} = x + y
$$

Con condición inicial \(y(0) = 1\), y tamaño de paso \(h=0.1\).

