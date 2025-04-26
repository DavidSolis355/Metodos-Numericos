## **Error de Truncamiento**

### **Definición**
El **error de truncamiento** es el error que ocurre cuando se detiene un proceso de cálculo de forma prematura, es decir, cuando se limita el número de términos en una serie infinita o el número de iteraciones en un algoritmo. Este tipo de error se produce cuando un valor se aproxima a un número real, pero se omiten términos adicionales que podrían mejorar la aproximación.

### **¿Para qué se usa?**
- Se usa para medir la precisión de los algoritmos que aproximan soluciones a problemas continuos (como en series de Taylor o integrales numéricas).
- Para analizar el impacto de truncar operaciones o procesos iterativos en los resultados finales.
- Para comparar diferentes métodos de aproximación y determinar cuán precisos son.

### **Fórmula**

En un proceso de aproximación de una función \( f(x) \) mediante una serie infinita, el error de truncamiento es la diferencia entre el valor exacto y la aproximación después de truncar la serie:

$$
\text{Error de Truncamiento} = |f(x) - P_n(x)|
$$

Donde:
- \( f(x) \) es el valor exacto,
- \( P_n(x) \) es la aproximación obtenida truncando la serie después del \( n \)-ésimo término.

### **Características**
- Es más grande cuando el número de términos truncados es alto.
- Es inherente a métodos que utilizan series de expansión, como la serie de Taylor.
- A menudo se puede reducir aumentando el número de términos en la serie o aumentando el número de iteraciones de un algoritmo.

### **Ejemplo**

Supón que aproximas \( e^x \) usando la serie de Taylor truncada en el tercer término:

$$
e^x \approx 1 + x + \frac{x^2}{2}
$$

Para \( x = 1 \), la aproximación es:

$$
e^1 \approx 1 + 1 + \frac{1^2}{2} = 2.5
$$

El valor exacto es:

$$
e^1 = 2.718281828
$$

Entonces, el error de truncamiento es:

$$
|2.718281828 - 2.5| = 0.218281828
$$

Este es el error de truncamiento debido a truncar la serie después del segundo término.

---
