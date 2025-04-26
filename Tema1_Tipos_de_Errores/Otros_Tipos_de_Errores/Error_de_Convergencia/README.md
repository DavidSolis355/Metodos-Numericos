## **Error de Convergencia**

### **Definición**
El **error de convergencia** se refiere a la diferencia entre la solución exacta y la solución obtenida por un método iterativo después de un número determinado de iteraciones. Este error tiende a disminuir conforme el método se acerca a la solución correcta.

### **¿Para qué se usa?**
- Para medir el grado de aproximación de un método iterativo a la solución real.
- Para decidir cuándo detener un algoritmo numérico (criterio de paro).
- Para analizar la velocidad con la que un método alcanza resultados precisos.

### **Fórmula**

Si:
- \( x \) es el valor exacto,
- \( x_n \) es el valor aproximado en la iteración \( n \),

Entonces el error de convergencia es:

$$
\text{Error de Convergencia} = |x - x_n|
$$

Cuando no se conoce el valor exacto, se puede usar la diferencia entre dos iteraciones consecutivas:

$$
\text{Error de Convergencia Aproximado} = |x_n - x_{n-1}|
$$

### **Características**
- Disminuye conforme aumenta el número de iteraciones (si el método converge).
- Si no disminuye, el método **no converge** o es inestable.
- Permite establecer un **criterio de tolerancia** para detener iteraciones.
- Está presente en métodos como bisección, Newton-Raphson, punto fijo, etc.

### **Ejemplo**

Supón que estás usando el método de Newton-Raphson para encontrar la raíz de una función, y en la iteración 4 tienes:


- \( x_3 = 1.5000 \)
- \( x_4 = 1.4975 \)


Entonces el error de convergencia aproximado es:

$$
|x_4 - x_3| = |1.4975 - 1.5000| = 0.0025
$$

Si se define una tolerancia de 0.001, todavía se necesitan más iteraciones.

---
