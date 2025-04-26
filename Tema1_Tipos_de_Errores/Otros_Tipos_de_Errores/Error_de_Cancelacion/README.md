## **Cancelación**

### **Definición**
La **cancelación** es un fenómeno numérico que ocurre cuando se restan dos números muy cercanos entre sí, lo que puede provocar una gran pérdida de cifras significativas y afectar la precisión del resultado.

### **¿Para qué se usa (o por qué es importante)?**
- Es importante detectarla para evitar errores graves en cálculos numéricos.
- Se analiza al implementar algoritmos que involucren restas de números similares.
- Ayuda a elegir métodos alternativos más estables y precisos.

### **¿Qué causa la cancelación?**
Cuando se realiza una resta entre dos valores que son casi iguales, la parte significativa del resultado puede perderse debido a limitaciones del número de dígitos que puede representar una computadora.

### **Explicación con fórmula**

Supón que tienes dos valores muy cercanos:

$$
a = 123456.789 \quad \text{y} \quad b = 123456.780
$$

Entonces:

$$
a - b = 123456.789 - 123456.780 = 0.009
$$

Aunque ambos números tienen 9 cifras significativas, el resultado solo tiene una, lo cual implica pérdida de precisión.

### **Características**
- Ocurre comúnmente en operaciones de resta entre números grandes con diferencias pequeñas.
- Aumenta el **error relativo** del resultado.
- Puede deteriorar la estabilidad numérica de un algoritmo.
- No hay una fórmula directa para evitarla, pero puede mitigarse reestructurando el cálculo.

### **Ejemplo**

Supón que quieres evaluar la siguiente expresión:

$$
f(x) = \frac{1 - \cos(x)}{x^2}
$$

Para valores pequeños de \( x \), como \( x = 0.0001 \), el resultado de \( 1 - \cos(x) \) implica una cancelación, ya que \( \cos(x) \) es muy cercano a 1. En lugar de usar esa forma, se puede usar una equivalente más estable:

$$
f(x) = \frac{2\sin^2(x/2)}{x^2}
$$

Esta versión reduce el efecto de la cancelación.

---

