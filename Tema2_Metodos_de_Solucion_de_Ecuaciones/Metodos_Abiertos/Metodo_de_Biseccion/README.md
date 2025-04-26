## **Método de Bisección**

### **Definición**
El **método de bisección** es un algoritmo numérico utilizado para encontrar raíces reales de funciones continuas. Se basa en el teorema del valor intermedio, el cual garantiza que si una función cambia de signo en un intervalo, entonces existe al menos una raíz dentro de ese intervalo.

### **¿Para qué se usa?**
- Para **encontrar soluciones (raíces)** reales de ecuaciones no lineales.
- Es útil cuando se tiene un **intervalo conocido** donde la función cambia de signo.
- Sirve como **método inicial confiable** en combinación con otros métodos más rápidos.

### **Fórmula**

Si:

- $f(a) \cdot f(b) < 0$, hay una raíz en $[a, b]$
- $c = \frac{a + b}{2}$ es el punto medio

Entonces:

- Si $f(a) \cdot f(c) < 0$, la raíz está en $[a, c]$
- Si $f(c) \cdot f(b) < 0$, la raíz está en $[c, b]$

Se repite el proceso dividiendo el intervalo sucesivamente hasta que se cumple una **tolerancia** deseada.

### **Características**
- Es un método **lento pero seguro**.
- Siempre converge si $f$ es continua y $f(a) \cdot f(b) < 0$.
- No requiere derivadas ni conocimientos adicionales de la función.
- La **convergencia es lineal**.
- Funciona bien para encontrar **una única raíz**, pero no todas las raíces.

### **Ejemplo**

Supón que quieres encontrar una raíz de la función:

$$
f(x) = x^2 - 4
$$

Sabes que:
- $f(1) = -3$
- $f(3) = 5$

Entonces $f(1) \cdot f(3) < 0$, por lo tanto hay una raíz en $[1, 3]$. Aplicando la fórmula:

1. $c_1 = \frac{1 + 3}{2} = 2$
2. $f(2) = 0$

Se encontró la raíz exacta en la primera iteración, $x = 2$. En otros casos, se necesita continuar iterando.

---
