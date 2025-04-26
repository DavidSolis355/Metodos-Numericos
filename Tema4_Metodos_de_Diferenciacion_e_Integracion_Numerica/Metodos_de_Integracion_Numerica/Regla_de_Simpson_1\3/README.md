## **Método de la Regla de Simpson de 1/3**

### **Definición**
La **regla de Simpson de 1/3** es un método numérico para aproximar la integral definida de una función. Esta regla se basa en aproximar la función a integrar por un polinomio de segundo grado (una parábola) sobre el intervalo de integración. La regla de Simpson de 1/3 utiliza tres puntos para construir la parábola: los puntos finales del intervalo y el punto medio. Es más precisa que la regla del trapecio, ya que considera la curvatura de la función.

### **¿Para qué se usa?**
- Para **aproximar integrales** de funciones cuando no se pueden obtener soluciones exactas analíticamente.
- Se utiliza cuando se desea una aproximación con **mayor precisión** que otros métodos como la regla del trapecio.
- Comúnmente utilizada en problemas de **ingeniería** y **ciencias aplicadas** donde las funciones a integrar son suaves y se desea obtener una buena aproximación en un intervalo determinado.

### **Método de Resolución (Procedimiento)**
La fórmula general de la regla de Simpson de 1/3 para la integral definida de una función \( f(x) \) en el intervalo \( [a, b] \) es:

$$
I \approx \frac{b - a}{6} \left[ f(a) + 4f\left(\frac{a + b}{2}\right) + f(b) \right]
$$

Si se divide el intervalo \( [a, b] \) en \( n \) subintervalos (debe ser un número par), la fórmula generalizada es:

$$
I \approx \frac{h}{3} \left[ f(x_0) + 4 \sum_{i=1, 3, 5, \dots}^{n-1} f(x_i) + 2 \sum_{i=2, 4, 6, \dots}^{n-2} f(x_i) + f(x_n) \right]
$$

donde:
- \( h = \frac{b - a}{n} \) es el tamaño de los subintervalos.
- \( x_0 = a \), \( x_n = b \), y los \( x_i \) son los puntos intermedios en el intervalo \( [a, b] \).

### **Características**
- **Mayor precisión** que la regla del trapecio y otros métodos de primer orden.
- **Requiere que \( n \) sea par** (para dividir el intervalo en subintervalos iguales de manera correcta).
- **Rápida convergencia**: cuanto mayor es el número de subintervalos, más precisa es la aproximación.
- **Uso común en integrales de funciones suaves** y bien comportadas.

### **Ejemplo**

Queremos aproximar la integral de \( f(x) = \sin(x) \) en el intervalo \( [0, \pi] \) usando la regla de Simpson de 1/3 con \( n = 2 \) subintervalos (es decir, tres puntos: \( x_0, x_1, x_2 \)).

1. **Determinar el tamaño del subintervalo**:

   El intervalo es \( [0, \pi] \), y \( n = 2 \), por lo que:

   $$ h = \frac{\pi - 0}{2} = \frac{\pi}{2} $$

2. **Evaluar la función en los puntos \( x_0 \), \( x_1 \), y \( x_2 \)**:

   Los puntos \( x_0 = 0 \), \( x_1 = \frac{\pi}{2} \), y \( x_2 = \pi \).

   Evaluamos la función \( f(x) = \sin(x) \) en estos puntos:
   - \( f(x_0) = \sin(0) = 0 \)
   - \( f(x_1) = \sin\left(\frac{\pi}{2}\right) = 1 \)
   - \( f(x_2) = \sin(\pi) = 0 \)

3. **Aplicar la fórmula de la regla de Simpson de 1/3**:

   La fórmula para la aproximación es:

   $$ I \approx \frac{h}{3} \left[ f(x_0) + 4f(x_1) + f(x_2) \right] $$

   Sustituyendo los valores:

   $$ I \approx \frac{\pi}{2} \times \frac{1}{3} \left[ 0 + 4(1) + 0 \right] $$

   $$ I \approx \frac{\pi}{6} \times 4 = \frac{2\pi}{3} $$

**Resultado:**
La integral aproximada de \( \sin(x) \) en el intervalo \( [0, \pi] \) usando la regla de Simpson de 1/3 es:

$$ I \approx \frac{2\pi}{3} \approx 2.0944 $$

Este valor es una aproximación bastante precisa de la integral exacta, que es \( \int_0^\pi \sin(x) dx = 2 \).

---

