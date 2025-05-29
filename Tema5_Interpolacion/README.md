# **Métodos de Interpolación**

## **Introducción**
La **interpolación** es una técnica numérica que permite estimar el valor de una función desconocida a partir de un conjunto de puntos conocidos. En lugar de derivar una fórmula exacta, se construye una función que pase por todos los puntos dados, con el objetivo de realizar predicciones o aproximaciones intermedias.

Estos métodos son fundamentales en áreas como ingeniería, análisis de datos, física y economía, donde se cuenta con valores experimentales o simulados, pero no con una expresión matemática explícita.

---

## **Conceptos Básicos**
- **Interpolación:** Estimación de valores dentro del rango de datos conocidos.
- **Ajuste de curvas:** Aproximación de una función que se acerque a los datos dados, aunque no necesariamente pase por todos ellos.
- **Error de interpolación:** Diferencia entre el valor real y el estimado debido a la forma del modelo usado.
- **Modelo de regresión:** Función que representa la tendencia general de los datos, basada en mínimos cuadrados.

---

## **Importancia de la Interpolación**
- Permite trabajar con datos experimentales donde la función es desconocida.
- Útil para generar predicciones en simulaciones, gráficas y análisis de comportamiento.
- Ayuda en la compresión de datos y en el llenado de valores faltantes.

---

## **Métodos Abordados**

### **Interpolación Lineal**

#### **[Interpolación Lineal](/Tema5_Interpolacion/Interpolacion_Lineal)**
- Utiliza dos puntos cercanos para estimar valores intermedios con una línea recta.
- Método directo, rápido y fácil de implementar.
- Adecuado para datos que se aproximan a una relación lineal.

---

### **Correlación**

#### **[Correlación](/Tema5_Interpolacion/Correlación)**
- Mide la relación entre dos variables.
- No genera una función interpolante, pero evalúa la fuerza de la relación lineal.
- Su coeficiente varía entre -1 (relación negativa) y 1 (positiva).

---

### **Regresión**

#### **[Regresión](/Tema5_Interpolacion/Regresión)**
- Ajusta una función a los datos sin necesidad de que pase por todos los puntos.
- Se usa comúnmente la regresión lineal, pero también puede ser polinómica, exponencial, etc.
- Minimiza el error cuadrático entre los puntos y la función ajustada.

---

### **Interpolación Polinómica**

#### **[Interpolación Polinómica](/Tema5_Interpolacion/Interpolación_Polinómica)**
- Utiliza un polinomio de grado \( n-1 \) para pasar por \( n \) puntos.
- Métodos comunes: interpolación de Lagrange y de Newton.
- Precisa para pocos puntos, pero puede volverse inestable con muchos datos (oscilaciones).

---

### **Método de Mínimos Cuadrados**

#### **[Mínimos Cuadrados](/Tema5_Interpolacion/Minimos_Cuadrados)**
- Encuentra una función que minimice el error cuadrático entre los puntos y la curva ajustada.
- Útil cuando los datos tienen ruido o no siguen una tendencia exacta.
- Ampliamente utilizado en ciencia de datos, modelado y análisis estadístico.

---

## **Notas Finales**
- **Interpolación lineal** es ideal para cálculos rápidos con baja complejidad.
- **Correlación** y **regresión** ayudan a entender y modelar relaciones en datos reales.
- **Interpolación polinómica** es precisa pero debe usarse con cuidado para evitar inestabilidades.
- El **método de mínimos cuadrados** es clave para ajustar modelos en presencia de errores o ruido.

---

