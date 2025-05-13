# **Interpolación Polinómica**

## **Introducción**

La **Interpolación Polinómica** es un método numérico utilizado para aproximar una función desconocida mediante un polinomio que pasa exactamente por un conjunto de puntos dados. Esta técnica es útil cuando se tienen puntos de datos discretos y se desea encontrar una función continua que pase por estos puntos. El polinomio resultante puede ser de grado \( n-1 \), donde \( n \) es el número de puntos de datos.

### **Métodos de Interpolación**

Existen diferentes métodos para calcular la interpolación polinómica, siendo los más comunes:

- **Interpolación de Lagrange**: Un método basado en la construcción de polinomios de Lagrange para cada punto dado.
- **Interpolación de Newton**: Utiliza un enfoque iterativo basado en diferencias divididas para construir un polinomio de interpolación.

En este proyecto, nos enfocaremos en la **Interpolación Polinómica de Lagrange**, que es una forma directa de interpolación y no requiere la resolución de sistemas de ecuaciones.

---

## **Teoría**

La **Interpolación Polinómica de Lagrange** busca construir un polinomio \( P(x) \) que pase por un conjunto de puntos dados \( (x_0, y_0), (x_1, y_1), \dots, (x_n, y_n) \), de tal manera que:

\[
P(x) = \sum_{i=0}^{n} L_i(x) y_i
\]

Donde \( L_i(x) \) son los **polinomios de Lagrange**, definidos como:

\[
L_i(x) = \prod_{\substack{0 \leq j \leq n \\ j \neq i}} \frac{x - x_j}{x_i - x_j}
\]

Cada polinomio de Lagrange \( L_i(x) \) es igual a 1 en \( x_i \) y 0 en todos los demás puntos \( x_j \) (para \( j \neq i \)).

El polinomio \( P(x) \) resultante es único para un conjunto dado de puntos, y garantiza que la función interpolante pase por todos los puntos proporcionados.

---

## **Importancia de la Interpolación Polinómica**

- **Aproximación precisa**: La interpolación polinómica permite obtener una función continua que se ajusta exactamente a los puntos de datos.
- **Aplicaciones**: Se utiliza en gráficos computacionales, estimación de datos, análisis de señales, y en la resolución de problemas donde no se dispone de una fórmula explícita para la función subyacente.
- **Desventajas**: Para grandes conjuntos de datos, el polinomio resultante puede volverse de alto grado, lo que puede ocasionar oscilaciones indeseadas (fenómeno de **sobreajuste**). Es importante considerar técnicas adicionales como la **Interpolación de Splines** para evitar estos problemas.

---

## **Método Abordado**

### **Interpolación de Lagrange**
La interpolación polinómica de Lagrange es útil cuando se desea construir un polinomio que pase exactamente por un conjunto de puntos. En este método, los polinomios de Lagrange se utilizan para construir el polinomio interpolante, sumando cada uno de ellos multiplicado por su correspondiente valor \( y_i \).

#### **Fórmula General:**

El polinomio de interpolación de Lagrange se puede escribir como:

\[
P(x) = \sum_{i=0}^{n} L_i(x) y_i
\]

donde \( L_i(x) \) es el polinomio de Lagrange para el punto \( i \), y \( y_i \) es el valor de la función en el punto \( x_i \).

---

## **Conclusión**

La interpolación polinómica es una herramienta poderosa para obtener aproximaciones de funciones basadas en datos discretos. Aunque el método de Lagrange es sencillo y directo, puede ser ineficiente para grandes conjuntos de datos debido al aumento en el grado del polinomio. En estos casos, se deben considerar métodos alternativos o técnicas de suavizado, como las **splines cúbicas**.

Este enfoque de interpolación es ideal para conjuntos pequeños o medianos de datos, y su simplicidad lo hace adecuado para situaciones donde se requiere una solución rápida y exacta a los puntos dados.
