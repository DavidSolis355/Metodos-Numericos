## **Método de la Regla del Trapecio**

### **Definición**
La **regla del trapecio** es un método numérico utilizado para aproximar la integral definida de una función. Este método estima el área bajo una curva dividiendo el intervalo de integración en subintervalos, y aproximando la función por líneas rectas (formando trapecios) sobre cada subintervalo. A partir de la suma de las áreas de los trapecios, se obtiene la aproximación de la integral.

### **¿Para qué se usa?**
- Para **aproximar integrales** de funciones cuando no es posible calcular la integral exacta de manera analítica.
- Se utiliza comúnmente en **simulaciones numéricas** y en problemas donde se necesita una aproximación rápida y sencilla de la integral.
- Es especialmente útil cuando la función es suave y bien comportada en el intervalo de integración.

### **Método de Resolución (Procedimiento)**
La fórmula general de la regla del trapecio para la integral definida de una función \( f(x) \) en el intervalo \( [a, b] \) es:

$$
I \approx \frac{b - a}{2} \left[ f(a) + f(b) \right]
$$

Este es el caso para un único trapecio. Si se divide el intervalo \( [a, b] \) en \( n \) subintervalos (es decir, se utiliza \( n+1 \) puntos), la fórmula se generaliza como sigue:

$$
I \approx \frac{h}{2} \left[ f(x_0) + 2 \sum_{i=1}^{n-1} f(x_i) + f(x_n) \right]
$$

donde:
- \( h = \frac{b - a}{n} \) es el tamaño de los subintervalos.
- \( x_0 = a \), \( x_n = b \), y los \( x_i \) son los puntos intermedios en el intervalo \( [a, b] \).

### **Características**
- **Simplicidad**: Es un método sencillo de implementar y entender.
- **Aproximación razonable**: Aunque no siempre es el más preciso, la regla del trapecio ofrece una aproximación razonablemente buena para muchas funciones.
- **Precisión limitada**: El error en la aproximación disminuye a medida que aumentamos el número de subintervalos \( n \), pero no es tan preciso como otros métodos como la cuadratura gaussiana.

### **Ejemplo**

Queremos aproximar la integral de \( f(x) = \sin(x) \) en el intervalo \( [0, \pi] \) usando la regla del trapecio con 2 subintervalos (es decir, \( n = 2 \)).

1. **Determinar el tamaño del subintervalo**:

   El intervalo es \( [0, \pi] \), por lo que:

   $$ h = \frac{\pi - 0}{2} = \frac{\pi}{2} $$

2. **Evaluar la función en los puntos \( x_0 \), \( x_1 \), y \( x_2 \)**:

   Los puntos \( x_0 = 0 \), \( x_1 = \frac{\pi}{2} \), y \( x_2 = \pi \).

   Evaluamos la función \( f(x) = \sin(x) \) en estos puntos:
   - \( f(x_0) = \sin(0) = 0 \)
   - \( f(x_1) = \sin\left(\frac{\pi}{2}\right) = 1 \)
   - \( f(x_2) = \sin(\pi) = 0 \)

3. **Aplicar la fórmula de la regla del trapecio**:

   La fórmula para la aproximación es:

   $$ I \approx \frac{h}{2} \left[ f(x_0) + 2f(x_1) + f(x_2) \right] $$

   Sustituyendo los valores:

   $$ I \approx \frac{\pi}{2} \times \frac{1}{2} \left[ 0 + 2(1) + 0 \right] $$

   $$ I \approx \frac{\pi}{4} \times 2 = \frac{\pi}{2} $$

**Resultado:**
La integral aproximada de \( \sin(x) \) en el intervalo \( [0, \pi] \) usando la regla del trapecio con 2 subintervalos es:

$$ I \approx \frac{\pi}{2} \approx 1.5708 $$

Este valor es una aproximación razonable de la integral exacta, que es \( \int_0^\pi \sin(x) dx = 2 \).

---

