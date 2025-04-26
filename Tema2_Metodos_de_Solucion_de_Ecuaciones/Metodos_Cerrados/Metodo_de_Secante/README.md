## **Método de la Secante**

### **Definición**
El **método de la secante** es un método numérico iterativo para encontrar raíces de funciones no lineales. A diferencia de Newton-Raphson, no requiere derivadas, sino que usa una aproximación basada en una **recta secante** que pasa por dos puntos anteriores.

### **¿Para qué se usa?**
- Para **hallar raíces** de funciones cuando no se tiene la derivada o no es fácil calcularla.
- Es útil cuando se quiere **evitar el uso de derivadas**.
- Aplicado en problemas de física, ingeniería y finanzas donde las funciones son complejas.

### **Fórmula**

Dado dos valores iniciales \( x_0 \) y \( x_1 \), la fórmula iterativa es:

$$
x_{n+1} = x_n - f(x_n) \cdot \frac{x_n - x_{n-1}}{f(x_n) - f(x_{n-1})}
$$

Donde:
- \( f(x) \) es la función.
- \( x_n \) y \( x_{n-1} \) son aproximaciones anteriores.

### **Características**
- No requiere derivadas.
- Puede ser más rápido que bisección, pero **menos estable**.
- Su **convergencia es superlineal**, más rápida que bisección pero más lenta que Newton-Raphson.
- Requiere **dos valores iniciales** cercanos a la raíz.

### **Ejemplo**

Supón que queremos encontrar la raíz de:

$$
f(x) = x^2 - 4
$$

Tomamos dos valores iniciales:

- \( x_0 = 3 \), \( f(x_0) = 5 \)
- \( x_1 = 2.5 \), \( f(x_1) = 2.25 \)

Aplicamos la fórmula:

1. 
$$
x_2 = 2.5 - \frac{2.25 \cdot (2.5 - 3)}{2.25 - 5} 
= 2.5 - \frac{-1.125}{-2.75} \approx 2.0909
$$

2. Luego, con \( x_1 = 2.5 \) y \( x_2 = 2.0909 \), se sigue iterando.

Después de varias iteraciones, el valor se acerca a la raíz \( x = 2 \).

---
