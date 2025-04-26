## **Método de la Regla Falsa**

### **Definición**
El **método de la regla falsa** (también llamado método de la falsa posición) es un procedimiento numérico para encontrar raíces de funciones continuas. Al igual que el método de bisección, se basa en el teorema del valor intermedio, pero en lugar de usar el punto medio, calcula un punto de intersección entre la recta que une los extremos del intervalo.

### **¿Para qué se usa?**
- Para encontrar **raíces reales** de ecuaciones no lineales.
- Para obtener una **mejor aproximación** que la bisección en algunas funciones.
- Para resolver problemas donde se conoce un intervalo con cambio de signo.

### **Fórmula**

Si:
- $f(a) \cdot f(b) < 0$, hay una raíz en $[a, b]$

Entonces el nuevo punto $x$ se calcula como:

$$
x = b - \frac{f(b) \cdot (b - a)}{f(b) - f(a)}
$$

Este punto reemplaza a $a$ o $b$ según el signo de $f(x)$, manteniendo el intervalo donde se conserva el cambio de signo.

### **Características**
- Basado en **interpolación lineal**.
- Converge más rápido que la bisección en muchos casos.
- No siempre tiene **convergencia garantizada** si la función es muy asimétrica.
- Requiere que $f$ sea continua en el intervalo.

### **Ejemplo**

Encuentra la raíz de:

$$
f(x) = x^2 - 4
$$

Sabemos que:
- $f(1) = -3$
- $f(3) = 5$

Aplicamos la fórmula:

$$
x = 3 - \frac{5 \cdot (3 - 1)}{5 - (-3)} = 3 - \frac{10}{8} = 1.75
$$

Evaluamos $f(1.75) = (1.75)^2 - 4 = -0.9375$

Como $f(1) \cdot f(1.75) < 0$, la raíz está entre $[1, 1.75]$. Se repite el proceso hasta cumplir con la tolerancia deseada.

---
