# Método de Adams-Bashforth de 4 Pasos

## Introducción

El método de Adams-Bashforth es un método numérico explícito de pasos múltiples utilizado para resolver ecuaciones diferenciales ordinarias (EDO). A diferencia de los métodos de un paso como Runge-Kutta, utiliza varios valores anteriores de la derivada para calcular el siguiente valor, aumentando la precisión.

En particular, el método de 4 pasos usa los valores de las derivadas en los 4 puntos previos para calcular el siguiente valor.

---

## Fórmulas del Método Adams-Bashforth de 4 Pasos

Dado el problema:

$$
\frac{dy}{dx} = f(x, y)
$$

con condición inicial

$$
y(x_0) = y_0
$$

El método aproxima el valor \( y_{n+1} \) usando:

$$
y_{n+1} = y_n + \frac{h}{24} \left( 55 f_n - 59 f_{n-1} + 37 f_{n-2} - 9 f_{n-3} \right)
$$

donde:

- \( h \) es el tamaño del paso.
- \( f_n = f(x_n, y_n) \) es la derivada evaluada en el punto \( (x_n, y_n) \).

---

## Pasos iniciales

Para comenzar, se necesitan los primeros 3 valores de \( y \) calculados con otro método de un paso, típicamente Runge-Kutta de 4to orden.

---

## Ventajas

- Mayor precisión que métodos simples como Euler.
- Buen balance entre eficiencia y precisión.
- Adecuado para problemas donde se puede reutilizar cálculos anteriores.

---

## Desventajas

- Método explícito, puede ser inestable para pasos muy grandes.
- Requiere almacenar y usar varios valores anteriores.
- Necesita un método de inicio para calcular los primeros valores.

---

## Ejemplo de uso

Resolver la EDO:

$$
\frac{dy}{dx} = x + y
$$

con condición inicial \( y(0) = 1 \), usando tamaño de paso \( h=0.1 \) y calculando 10 pasos.

---

## Código de ejemplo en Java

El código implementa:

- Función \( f(x,y) = x + y \).
- Cálculo de los primeros 3 valores usando Runge-Kutta 4.
- Aplicación del método Adams-Bashforth de 4 pasos para el resto.

---

## Notas finales

- Elegir un tamaño de paso adecuado es clave para la estabilidad y precisión.
- Se pueden implementar variantes implícitas o métodos de pasos múltiples de orden diferente.