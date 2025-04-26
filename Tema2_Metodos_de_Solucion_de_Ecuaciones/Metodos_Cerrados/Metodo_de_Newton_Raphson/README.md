## **Método de Newton-Raphson**

### **Definición**
El **método de Newton-Raphson** es un método numérico iterativo utilizado para encontrar raíces de funciones reales. Se basa en la aproximación de la función mediante su **tangente** en un punto inicial y usa derivadas para mejorar la estimación en cada paso.

### **¿Para qué se usa?**
- Para **encontrar raíces** de funciones no lineales de forma rápida.
- Ideal cuando se requiere **alta precisión** en pocas iteraciones.
- Se usa ampliamente en ingeniería, física, informática, y matemáticas aplicadas.

### **Fórmula**

Dado un valor inicial $x_0$, la fórmula iterativa es:

$$
x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}
$$

Donde:
- $f(x)$ es la función,
- $f'(x)$ es su derivada,
- $x_n$ es la aproximación en la iteración $n$.

### **Características**
- Convergencia **rápida** si el valor inicial está cerca de la raíz.
- Requiere que $f(x)$ sea **derivable**.
- Puede **divergir** si la derivada es cero o si se elige mal el valor inicial.
- Tiene **convergencia cuadrática** en condiciones ideales.

### **Ejemplo**

Supón que quieres encontrar la raíz de:

$$
f(x) = x^2 - 4
$$

Entonces:

- $f'(x) = 2x$
- Elegimos $x_0 = 3$

Aplicamos la fórmula:

1. $x_1 = 3 - \frac{3^2 - 4}{2 \cdot 3} = 3 - \frac{5}{6} = 2.1667$
2. $x_2 = 2.1667 - \frac{(2.1667)^2 - 4}{2 \cdot 2.1667} \approx 2.0064$
3. $x_3 = 2.0064 - \frac{(2.0064)^2 - 4}{2 \cdot 2.0064} \approx 2.0000$

Después de pocas iteraciones, se alcanza una raíz muy cercana a $2$.

---
