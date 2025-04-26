## **Error de Redondeo**

### **Definición**
El **error de redondeo** es la diferencia entre el valor numérico exacto y su representación aproximada debido a la limitación de cifras significativas que puede manejar un sistema de cómputo. Ocurre cuando se recortan o ajustan decimales para adaptarse al formato del sistema.

### **¿Para qué se usa?**
- Para analizar la precisión de resultados computacionales.
- Para entender cómo afecta la limitación de cifras significativas al resultado final.
- Para evaluar si un algoritmo es sensible a pequeños errores en los datos.

### **Fórmula**

Si:
- \( x \) es el valor exacto,
- \( x~ \) es el valor redondeado,

Entonces el error de redondeo es:

$$
\text{Error de Redondeo} = |x - \tilde{x}|
$$

### **Características**
- Es inevitable en los sistemas digitales debido a la representación finita de números reales.
- Se acumula en algoritmos con muchas operaciones.
- Es más notorio cuando se trabaja con números muy pequeños o muy grandes.
- Puede afectar la estabilidad de algunos métodos numéricos.

### **Ejemplo**

Supón que el número exacto es:

$$
x = 3.14159265
$$

Y lo redondeas a 4 cifras decimales:

$$
\tilde{x} = 3.1416
$$

Entonces el error de redondeo es:

$$
|3.14159265 - 3.1416| = 0.00000735
$$

Este pequeño error puede acumularse si se usa muchas veces en un cálculo.

---
