## **Método de Eliminación Gaussiana**

### **Definición**
La **eliminación gaussiana** es un método algorítmico para resolver sistemas de ecuaciones lineales. Consiste en transformar el sistema original en un sistema triangular superior, facilitando así la obtención de las soluciones mediante sustitución hacia atrás.

### **¿Para qué se usa?**
- Para **resolver sistemas de ecuaciones lineales** de forma sistemática.
- Para **calcular determinantes** y **matrices inversas**.
- Ampliamente utilizado en álgebra lineal aplicada en ingeniería, ciencias y computación.

### **Método de Resolución (Procedimiento)**
1. **Formar la matriz aumentada** del sistema.
2. **Aplicar operaciones elementales** (intercambiar filas, multiplicar una fila por un escalar, sumar múltiplos de filas) para obtener ceros debajo de la diagonal principal.
3. **Obtener una matriz triangular superior**.
4. **Resolver el sistema por sustitución hacia atrás**.

**Forma general:**

$$
\begin{align*}
a_{11}x_1 + a_{12}x_2 + \cdots + a_{1n}x_n &= b_1 \\
a_{21}x_1 + a_{22}x_2 + \cdots + a_{2n}x_n &= b_2 \\
\vdots \quad\quad\quad\quad\quad\quad\quad\quad\quad\quad &\vdots \\
a_{n1}x_1 + a_{n2}x_2 + \cdots + a_{nn}x_n &= b_n
\end{align*}
$$

Se transforma en:

$$
\begin{align*}
a'_{11}x_1 + a'_{12}x_2 + \cdots + a'_{1n}x_n &= b'_1 \\
\quad\quad a'_{22}x_2 + \cdots + a'_{2n}x_n &= b'_2 \\
\quad\quad\quad\quad \ddots \quad\quad\quad\quad &= \vdots \\
\quad\quad\quad\quad\quad\quad\quad a'_{nn}x_n &= b'_n
\end{align*}
$$

Luego se resuelve:

$$
x_n = \frac{b'_n}{a'_{nn}}
$$
y así sucesivamente hacia atrás.

### **Características**
- **Determinista:** siempre llega a una solución (si existe y es única).
- **Simple de programar.**
- Puede verse afectado por problemas de **estabilidad numérica** (requiriendo pivotaje).
- Necesita aproximadamente \( \frac{2}{3}n^3 \) operaciones para un sistema de \( n \) incógnitas.

### **Ejemplo**

Resolver el siguiente sistema:

$$
\begin{align*}
2x + 3y - z &= 5 \\
4x + 4y - 3z &= 3 \\
-2x + 3y + 2z &= 7
\end{align*}
$$

**Paso 1: Matriz aumentada**

$$
\left[
\begin{array}{ccc|c}
2 & 3 & -1 & 5 \\
4 & 4 & -3 & 3 \\
-2 & 3 & 2 & 7
\end{array}
\right]
$$

**Paso 2: Hacer ceros debajo del pivote en la primera columna**

Operaciones:

- Fila 2: \( F_2 \leftarrow F_2 - 2F_1 \)
- Fila 3: \( F_3 \leftarrow F_3 + F_1 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
2 & 3 & -1 & 5 \\
0 & -2 & -1 & -7 \\
0 & 6 & 1 & 12
\end{array}
\right]
$$

**Paso 3: Hacer ceros debajo del pivote en la segunda columna**

Operación:

- Fila 3: \( F_3 \leftarrow F_3 + 3F_2 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
2 & 3 & -1 & 5 \\
0 & -2 & -1 & -7 \\
0 & 0 & -2 & -9
\end{array}
\right]
$$

**Paso 4: Sustitución hacia atrás**

- De la tercera fila:

$$
-2z = -9 \quad \Rightarrow \quad z = 4.5
$$

- De la segunda fila:

$$
-2y - (1)(4.5) = -7 \quad \Rightarrow \quad -2y = -2.5 \quad \Rightarrow \quad y = 1.25
$$

- De la primera fila:

$$
2x + 3(1.25) - 4.5 = 5 \quad \Rightarrow \quad 2x + 3.75 - 4.5 = 5 \quad \Rightarrow \quad 2x - 0.75 = 5
$$

$$
2x = 5.75 \quad \Rightarrow \quad x = 2.875
$$

**Solución:**

$$
x = 2.875, \quad y = 1.25, \quad z = 4.5
$$

---
