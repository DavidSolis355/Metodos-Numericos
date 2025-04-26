## **Método de Gauss-Jordan**

### **Definición**
El **método de Gauss-Jordan** es una extensión de la eliminación gaussiana que transforma la matriz aumentada de un sistema lineal en una **matriz identidad**, resolviendo directamente el sistema sin necesidad de sustitución hacia atrás.

### **¿Para qué se usa?**
- Para **resolver sistemas de ecuaciones lineales**.
- Para **hallar inversas** de matrices.
- Para **determinar la dependencia lineal** entre vectores.

### **Método de Resolución (Procedimiento)**
1. **Formar la matriz aumentada** del sistema.
2. **Aplicar operaciones elementales** para obtener:
   - Unos en la diagonal principal.
   - Ceros en todas las posiciones fuera de la diagonal.
3. **Leer directamente la solución** del sistema.

**Forma general del objetivo:**

$$
\left[
\begin{array}{ccc|c}
1 & 0 & 0 & x_1 \\
0 & 1 & 0 & x_2 \\
0 & 0 & 1 & x_3
\end{array}
\right]
$$

### **Características**
- **Más laborioso** que la eliminación gaussiana simple.
- El sistema queda **totalmente reducido**, sin necesidad de sustitución hacia atrás.
- Ideal para **programación computacional** cuando se requiere solución automática y directa.

### **Ejemplo**

Resolver el siguiente sistema:

$$
\begin{align*}
x + 2y + z &= 9 \\
2x + 3y + 3z &= 21 \\
y + 2z &= 8
\end{align*}
$$

**Paso 1: Matriz aumentada**

$$
\left[
\begin{array}{ccc|c}
1 & 2 & 1 & 9 \\
2 & 3 & 3 & 21 \\
0 & 1 & 2 & 8
\end{array}
\right]
$$

**Paso 2: Hacer ceros debajo y encima del primer pivote (1 en la posición (1,1))**

Operaciones:

- Fila 2: \( F_2 \leftarrow F_2 - 2F_1 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
1 & 2 & 1 & 9 \\
0 & -1 & 1 & 3 \\
0 & 1 & 2 & 8
\end{array}
\right]
$$

**Paso 3: Hacer 1 el pivote de la segunda fila (posición (2,2))**

- Fila 2: \( F_2 \leftarrow -F_2 \)

$$
\left[
\begin{array}{ccc|c}
1 & 2 & 1 & 9 \\
0 & 1 & -1 & -3 \\
0 & 1 & 2 & 8
\end{array}
\right]
$$

**Paso 4: Hacer ceros en las otras posiciones de la segunda columna**

- Fila 1: \( F_1 \leftarrow F_1 - 2F_2 \)
- Fila 3: \( F_3 \leftarrow F_3 - F_2 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
1 & 0 & 3 & 15 \\
0 & 1 & -1 & -3 \\
0 & 0 & 3 & 11
\end{array}
\right]
$$

**Paso 5: Hacer 1 el pivote de la tercera fila (posición (3,3))**

- Fila 3: \( F_3 \leftarrow \frac{1}{3}F_3 \)

$$
\left[
\begin{array}{ccc|c}
1 & 0 & 3 & 15 \\
0 & 1 & -1 & -3 \\
0 & 0 & 1 & \frac{11}{3}
\end{array}
\right]
$$

**Paso 6: Hacer ceros en las otras posiciones de la tercera columna**

- Fila 1: \( F_1 \leftarrow F_1 - 3F_3 \)
- Fila 2: \( F_2 \leftarrow F_2 + F_3 \)

Nueva matriz:

$$
\left[
\begin{array}{ccc|c}
1 & 0 & 0 & 4 \\
0 & 1 & 0 & \frac{2}{3} \\
0 & 0 & 1 & \frac{11}{3}
\end{array}
\right]
$$

### **Solución directa**

$$
x = 4, \quad y = \frac{2}{3}, \quad z = \frac{11}{3}
$$

---
