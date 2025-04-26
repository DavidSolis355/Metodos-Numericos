## **Método de Jacobi**

### **Definición**
El **método de Jacobi** es un método iterativo para resolver **sistemas de ecuaciones lineales**. Calcula las nuevas aproximaciones de las variables **sin usar** los valores actualizados dentro de la misma iteración.

### **¿Para qué se usa?**
- Resolver **sistemas grandes** de ecuaciones lineales.
- Útil cuando el sistema es **diagonalmente dominante**.
- Empleado en áreas como análisis estructural y simulaciones numéricas.

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
Cada nueva \( x_i^{(k+1)} \) se calcula **usando solo** los valores de la iteración anterior \( x^{(k)} \).

### **Características**
- No usa los valores actualizados inmediatamente (a diferencia de Gauss-Seidel).
- Funciona bien si la matriz es **diagonalmente dominante**.
- Puede ser **más lento** que Gauss-Seidel.
- Muy **fácil de paralelizar** (ideal para procesamiento en paralelo).

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

**Paso 2: Primera aproximación inicial**

$$
x_1^{(0)} = 0, \quad x_2^{(0)} = 0, \quad x_3^{(0)} = 0
$$

**Iteración 1:**

$$
\begin{align*}
x_1^{(1)} &= \frac{1}{4}(4 - 0 - 0) = 1 \\
x_2^{(1)} &= \frac{1}{5}(7 - 3(0) - 0) = 1.4 \\
x_3^{(1)} &= \frac{1}{3}(3 - 0 - 0) = 1
\end{align*}
$$

**Iteración 2:**

Usando solo los valores de la **iteración anterior**:

$$
\begin{align*}
x_1^{(2)} &= \frac{1}{4}(4 - 1.4 - 2(1)) = 0.4 \\
x_2^{(2)} &= \frac{1}{5}(7 - 3(1) - 1) = 0.6 \\
x_3^{(2)} &= \frac{1}{3}(3 - 1 - 1.4) \approx 0.2
\end{align*}
$$

Se continúa iterando hasta que los valores se estabilicen dentro de una tolerancia aceptable.

---
