## **Método de Cuadratura Gaussiana**

### **Definición**
La **cuadratura gaussiana** es un método numérico utilizado para aproximar la integral definida de una función. Se basa en la idea de aproximar la integral como una suma ponderada de los valores de la función en puntos específicos, llamados nodos o puntos de Gauss, dentro del intervalo de integración. Este método es más preciso que otros métodos tradicionales como el de los trapecios o Simpson, ya que utiliza un número reducido de puntos para obtener una aproximación de alta precisión.

### **¿Para qué se usa?**
- Para **aproximar integrales** de funciones, especialmente cuando la integral no tiene una solución analítica sencilla o cuando los métodos clásicos no son eficientes.
- Es ampliamente utilizado en la **computación científica**, en **simulaciones numéricas** y en la **resolución de ecuaciones diferenciales** por el método de elementos finitos.
- Ideal para integrales con funciones complejas o cuando se requiere una **alta precisión** en un número limitado de puntos.

### **Método de Resolución (Procedimiento)**
La fórmula básica de la cuadratura gaussiana para una integral definida de la forma:

$$
I = \int_a^b f(x) \, dx
$$

es aproximada por la suma ponderada de los valores de \( f(x) \) en los nodos \( x_i \) correspondientes, multiplicados por los pesos \( w_i \):

$$
I \approx \sum_{i=1}^{n} w_i f(x_i)
$$

donde:
- \( x_i \) son los puntos de Gauss, que son las raíces de los polinomios de Legendre en el intervalo \( [-1, 1] \).
- \( w_i \) son los pesos correspondientes a esos puntos.
  
Para un intervalo general \( [a, b] \), la fórmula se transforma de la siguiente manera:

$$
I \approx \frac{b-a}{2} \sum_{i=1}^{n} w_i f\left( \frac{b-a}{2} x_i + \frac{a+b}{2} \right)
$$

### **Características**
- **Alta precisión:** Con pocos puntos, la cuadratura gaussiana puede lograr una precisión superior a otros métodos de integración.
- **No requiere conocimiento de la derivada:** Al basarse en la evaluación de la función en puntos específicos, no es necesario conocer su derivada.
- **Eficiencia computacional:** Aunque puede requerir más cálculos por punto en comparación con otros métodos, el número reducido de puntos necesarios compensa el coste computacional.
- **Ideal para funciones suaves:** Funciona particularmente bien cuando la función integrada es suave y bien comportada en el intervalo de integración.

### **Ejemplo**

Queremos aproximar la integral de \( f(x) = e^{-x^2} \) en el intervalo \( [0, 1] \) usando cuadratura gaussiana con 2 puntos (es decir, \( n = 2 \)).

1. **Obtenemos los puntos de Gauss y los pesos correspondientes** para \( n = 2 \). Para el intervalo \( [-1, 1] \), los puntos y pesos son:
   - \( x_1 = -\frac{1}{\sqrt{3}} \approx -0.577 \), \( x_2 = \frac{1}{\sqrt{3}} \approx 0.577 \)
   - \( w_1 = w_2 = 1 \)

2. **Transformamos el intervalo \( [0, 1] \) a \( [-1, 1] \)** utilizando la relación de cambio de variable:
   
   Para la integral de \( f(x) \) en \( [0, 1] \), la transformación es:
   $$ x = \frac{b-a}{2} t + \frac{a+b}{2} $$
   donde \( t \) está en \( [-1, 1] \) y \( a = 0 \), \( b = 1 \), por lo que:
   $$ x = \frac{1-0}{2} t + \frac{1+0}{2} = \frac{t+1}{2} $$

3. **Evaluamos la integral usando la fórmula de cuadratura gaussiana**:
   
   La integral aproximada es:
   $$ I \approx \frac{1}{2} \sum_{i=1}^{2} w_i f\left( \frac{1}{2}(x_i + 1) \right) $$

   Sustituyendo los valores de \( x_1 \), \( x_2 \), y \( w_1 \), \( w_2 \):

   $$ I \approx \frac{1}{2} \left[ 1 \cdot e^{-(0.577)^2} + 1 \cdot e^{-(0.577)^2} \right] $$

   Evaluamos:

   $$ I \approx \frac{1}{2} \left[ e^{-0.333} + e^{-0.333} \right] \approx \frac{1}{2} [0.716 + 0.716] = 0.716 $$

**Resultado:** La integral aproximada es \( I \approx 0.716 \), que es una buena aproximación del valor real de la integral de \( e^{-x^2} \) en el intervalo \( [0, 1] \).

---

