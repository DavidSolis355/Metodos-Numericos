## **Método de Punto Fijo**

### **Definición**
El **método de punto fijo** es un algoritmo iterativo que se utiliza para encontrar las raíces de una ecuación de la forma \( f(x) = 0 \). En este método, la ecuación se reescribe de manera que \( x = g(x) \), y luego se itera sobre \( x_n \) para encontrar un punto fijo, es decir, un valor \( x \) tal que \( g(x) = x \).

### **¿Para qué se usa?**
- Para **encontrar raíces** de ecuaciones no lineales.
- Ideal cuando la función se puede **reescribir como una función iterativa**.
- Utilizado en la resolución de ecuaciones en matemáticas aplicadas y ciencias computacionales.

### **Fórmula**

Dada una ecuación \( f(x) = 0 \), se reescribe como:

$$
x = g(x)
$$

El valor de \( x \) se actualiza iterativamente usando la fórmula:

$$
x_{n+1} = g(x_n)
$$

Donde:
- \( g(x) \) es la forma reescrita de la función \( f(x) = 0 \).
- \( x_n \) es la aproximación en la iteración \( n \).

### **Características**
- Convergencia depende de que la función \( g(x) \) cumpla ciertas condiciones (como que \( |g'(x)| < 1 \)).
- Puede **no converger** si \( g(x) \) no cumple las condiciones necesarias.
- La convergencia es **lineal**, lo que puede ser más lento que otros métodos como Newton-Raphson.

### **Ejemplo**

Supón que quieres encontrar la raíz de:

$$
f(x) = x^2 - 4
$$

Reescribimos como:

$$
g(x) = \sqrt{4 + x}
$$

Elegimos un valor inicial, por ejemplo \( x_0 = 1 \).

Aplicamos la fórmula iterativa:

1. \( x_1 = g(1) = \sqrt{4 + 1} = \sqrt{5} \approx 2.2361 \)
2. \( x_2 = g(2.2361) = \sqrt{4 + 2.2361} \approx 2.5495 \)
3. \( x_3 = g(2.5495) = \sqrt{4 + 2.5495} \approx 2.6564 \)

El valor comienza a acercarse a la raíz de \( 2 \) a medida que se repiten las iteraciones.

---
