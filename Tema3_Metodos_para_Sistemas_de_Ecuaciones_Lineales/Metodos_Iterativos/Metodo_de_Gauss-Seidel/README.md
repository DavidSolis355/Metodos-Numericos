## **Método de Gauss-Seidel**

### **Definición**
El **método de Gauss-Seidel** es un método iterativo para resolver **sistemas de ecuaciones lineales**. Mejora progresivamente la aproximación de las soluciones utilizando los valores ya calculados en cada paso de la iteración.

### **¿Para qué se usa?**
- Para resolver **sistemas grandes** de ecuaciones lineales donde los métodos directos son muy costosos.
- Muy usado en **simulación numérica** e **ingeniería** (análisis de estructuras, flujo de fluidos, etc).

### **Método de Resolución (Procedimiento)**
Dado un sistema:

$$
\begin{align*}
a_{11}x_1 + a_{12}x_2 + a_{13}x_3 &= b_1 \\
a_{21}x_1 + a_{22}x_2 + a_{23}x_3 &= b_2 \\
a_{31}x_1 + a_{32}x_2 + a_{33}x_3 &= b_3
\end{align*}
$$

Se despeja cada variable:

$$
\begin{align*}
x_1 &= \frac{1}{a_{11}}(b_1 - a_{12}x_2 - a_{13}x_3) \\
x_2 &= \frac{1}{a_{22}}(b_2 - a_{21}x_1 - a_{23}x_3) \\
x_3 &= \frac{1}{a_{33}}(b_3 - a_{31}x_1 - a_{32}x_2)
\end{align*}
$$

**Iteración:**  
En cada paso, se usa el **valor actualizado** tan pronto esté disponible.

### **Características**
- Requiere que el sistema sea **diagonalmente dominante** o que **converja** para funcionar bien.
- **Más rápido** que métodos directos para grandes matrices dispersas.
- Fácil de implementar pero puede **no converger** si el sistema no cumple ciertas condiciones.

### **Ejemplo**

Resolver el sistema:

$$
\begin{align*}
4x_1 + x_2 + 2x_3 &= 4 \\
3x_1 + 5x_2 + x_3 &= 7 \\
x_1 + x_2 + 3x_3 &= 3
\end{align*}
$$

**Paso 1: Despejamos cada variable**

$$
\begin{align*}
x_1 &= \frac{1}{4}(4 - x_2 - 2x_3) \\
x_2 &= \frac{1}{5}(7 - 3x_1 - x_3) \\
x_3 &= \frac{1}{3}(3 - x_1 - x_2)
\end{align*}
$$

**Paso 2: Supongamos una primera aproximación inicial**

$$
x_1^{(0)} = 0, \quad x_2^{(0)} = 0, \quad x_3^{(0)} = 0
$$

**Iteración 1:**

$$
\begin{align*}
x_1^{(1)} &= \frac{1}{4}(4 - 0 - 0) = 1 \\
x_2^{(1)} &= \frac{1}{5}(7 - 3(1) - 0) = 0.8 \\
x_3^{(1)} &= \frac{1}{3}(3 - 1 - 0.8) = 0.4
\end{align*}
$$

**Iteración 2:**

$$
\begin{align*}
x_1^{(2)} &= \frac{1}{4}(4 - 0.8 - 2(0.4)) = 0.6 \\
x_2^{(2)} &= \frac{1}{5}(7 - 3(0.6) - 0.4) = 1.08 \\
x_3^{(2)} &= \frac{1}{3}(3 - 0.6 - 1.08) \approx 0.44
\end{align*}
$$

Se siguen realizando iteraciones hasta que los valores de \( x_1 \), \( x_2 \) y \( x_3 \) se estabilicen dentro de un error tolerado.

---
