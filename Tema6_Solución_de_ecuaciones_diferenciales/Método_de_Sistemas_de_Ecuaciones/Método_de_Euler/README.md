# Método de Euler

## Introducción

El **Método de Euler** es uno de los métodos numéricos más simples para resolver ecuaciones diferenciales ordinarias (EDOs) de primer orden. Se basa en una aproximación lineal utilizando la derivada conocida en un punto para estimar el valor de la función en el siguiente punto.

Este método pertenece a los **métodos de un solo paso**, y aunque es simple, puede acumular errores rápidamente si se usa con un paso grande o por muchas iteraciones.

---

## Fundamento Matemático

Dada una ecuación diferencial de la forma:

$$
\frac{dy}{dx} = f(x, y), \quad y(x_0) = y_0
$$

El Método de Euler estima el valor de \( y \) en el siguiente punto \( x+h \) mediante:

$$
y_{n+1} = y_n + h \cdot f(x_n, y_n)
$$

donde:
- \( h \) es el tamaño del paso.
- \( x_n \) y \( y_n \) son los valores actuales.
- \( y_{n+1} \) es el valor estimado en el siguiente punto.

---

## Ventajas

- Fácil de entender e implementar.
- Requiere pocos cálculos por iteración.

---

## Desventajas

- Baja precisión si el tamaño de paso no es suficientemente pequeño.
- Puede ser inestable para ciertos tipos de ecuaciones.
- Acumula errores rápidamente a lo largo de la integración.

---

## Ejemplo

Resolver la ecuación:

$$
\frac{dy}{dx} = x + y, \quad y(0) = 1
$$

Con un tamaño de paso \( h = 0.1 \) y \( n = 10 \) pasos, el resultado aproximado se obtiene aplicando la fórmula iterativamente.

---

## Aplicaciones

- Problemas simples de dinámica.
- Modelos de crecimiento o decaimiento.
- Como base para comprender métodos más avanzados (como Runge-Kutta).

---

## Notas Finales

- Aunque no es el más preciso, el Método de Euler es una excelente introducción a la solución numérica de EDOs.
- Para obtener mejores resultados, se recomienda usar pasos pequeños o considerar métodos más avanzados.
