## **Método de Diferenciación de 5 Puntos**

### **Definición**
El **método de diferenciación de 5 puntos** es una técnica numérica que utiliza cinco puntos de la función para aproximar la derivada en un punto dado. A través de una combinación de valores de la función en puntos cercanos, proporciona una aproximación más precisa a la derivada que el método de 3 puntos.

### **¿Para qué se usa?**
- Para **aproximar derivadas** de funciones cuando no se tiene acceso a la derivada explícita de la función.
- Utilizado en **simulaciones numéricas** y **modelos matemáticos**, especialmente cuando se trabaja con funciones discretas o datos experimentales.
- Es común en la **aproximación de ecuaciones diferenciales** en problemas de ingeniería, física y análisis de señales.

### **Método de Resolución (Procedimiento)**
El método de 5 puntos utiliza una fórmula que involucra la función evaluada en cinco puntos: \( f(x - 2h) \), \( f(x - h) \), \( f(x) \), \( f(x + h) \), y \( f(x + 2h) \), para aproximar la derivada de la función en \( x \).

La fórmula general es:

$$
f'(x) \approx \frac{-f(x + 2h) + 8f(x + h) - 8f(x - h) + f(x - 2h)}{12h}
$$

Donde:
- \( f(x) \) es la función de la cual se desea calcular la derivada.
- \( h \) es el paso, es decir, la distancia entre los puntos.

### **Características**
- **Mayor precisión:** Al utilizar cinco puntos, el método tiene una precisión superior en comparación con los métodos de 3 puntos, especialmente para funciones suaves.
- **Requiere más evaluaciones:** A diferencia del método de 3 puntos, el de 5 puntos requiere más cálculos, lo que puede aumentar el costo computacional.
- **Aproximación de segundo orden:** La precisión es de orden \( O(h^4) \), lo que significa que el error disminuye más rápidamente conforme se reduce \( h \).

### **Ejemplo**

Supongamos que queremos aproximar la derivada de la función \( f(x) = x^2 \) en el punto \( x = 2 \) usando el método de 5 puntos.

1. **Elegimos un valor para \( h \):**
   Vamos a tomar \( h = 0.1 \).

2. **Evaluamos la función en los puntos \( x - 2h \), \( x - h \), \( x \), \( x + h \), y \( x + 2h \):**
   - \( f(2 - 2(0.1)) = f(1.8) = (1.8)^2 = 3.24 \)
   - \( f(2 - 0.1) = f(1.9) = (1.9)^2 = 3.61 \)
   - \( f(2) = 2^2 = 4 \)
   - \( f(2 + 0.1) = f(2.1) = (2.1)^2 = 4.41 \)
   - \( f(2 + 2(0.1)) = f(2.2) = (2.2)^2 = 4.84 \)

3. **Aplicamos la fórmula del método de 5 puntos:**

$$
f'(2) \approx \frac{-f(2.2) + 8f(2.1) - 8f(1.9) + f(1.8)}{12(0.1)} = \frac{-4.84 + 8(4.41) - 8(3.61) + 3.24}{1.2}
$$

Realizando las operaciones:

$$
f'(2) \approx \frac{-4.84 + 35.28 - 28.88 + 3.24}{1.2} = \frac{5.8}{1.2} = 4.83
$$

**Resultado:** La derivada aproximada de \( f(x) = x^2 \) en \( x = 2 \) es aproximadamente 4.83, que es muy cercana a la derivada exacta de 4.

---

