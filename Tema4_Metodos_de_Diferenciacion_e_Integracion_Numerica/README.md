# **Métodos de Diferenciación e Integración Numérica**

## **Introducción**
En el análisis de funciones y datos reales, muchas veces no se dispone de una fórmula exacta para derivar o integrar. Es aquí donde los **métodos numéricos** resultan esenciales para obtener aproximaciones útiles y precisas.

Los **métodos de diferenciación e integración numérica** permiten calcular derivadas e integrales de funciones conocidas solo en puntos discretos, mediante fórmulas que utilizan evaluaciones puntuales y ponderaciones específicas.

Estos métodos son ampliamente utilizados en ingeniería, física, estadística y simulaciones computacionales, especialmente cuando el tratamiento analítico es inviable.

---

## **Conceptos Básicos**
- **Diferenciación numérica:** Aproximación de la derivada de una función usando valores conocidos de dicha función.
- **Integración numérica:** Cálculo aproximado del área bajo una curva definida por una función, mediante sumas ponderadas de valores de la función.
- **Paso o intervalo \( h \):** Distancia entre los puntos discretos usados en las fórmulas.
- **Error de truncamiento:** Diferencia entre el valor exacto y la aproximación numérica debido a la omisión de términos en una expansión.

---

## **Importancia de estos Métodos**
- Útiles cuando no se puede obtener una derivada o integral exacta.
- Facilitan cálculos computacionales sobre grandes volúmenes de datos.
- Permiten resolver problemas reales basados en observaciones experimentales o simuladas.

---

## **Métodos Abordados**

### **Diferenciación Numérica**

#### **[Método de los 3 puntos](/Tema4_Metodos_de_Diferenciacion_e_Integracion_Numerica/Metodos_de_Diferenciacion_Numerica/Metodo_de_los_3_Puntos/)**
- Utiliza tres puntos consecutivos para aproximar derivadas.
- Hay fórmulas para derivada hacia adelante, hacia atrás y centrada.
- Adecuado para puntos internos y extremos de una tabla de datos.

#### **[Método de los 5 puntos](/Tema4_Metodos_de_Diferenciacion_e_Integracion_Numerica/Metodos_de_Diferenciacion_Numerica/Metodo_de_los_5_Puntos/)**
- Utiliza cinco puntos para obtener una derivada más precisa.
- Solo aplica a puntos interiores del dominio.
- Reduce el error en comparación con el método de 3 puntos.

---

### **Integración Numérica**

#### **[Método del Trapecio](/Tema4_Metodos_de_Diferenciacion_e_Integracion_Numerica/Metodos_de_Integracion_Numerica/Regla_del_Trapecio)**
- Aproxima el área bajo la curva mediante trapecios.
- Simple y eficiente, aunque menos preciso que Simpson para funciones curvas.
- Puede aplicarse a múltiples subintervalos (regla compuesta).

#### **[Método de Simpson 1/3](/Tema4_Metodos_de_Diferenciacion_e_Integracion_Numerica/Metodos_de_Integracion_Numerica/Regla_de_Simpson_1\3/)**
- Usa parábolas (polinomios de segundo grado) para ajustar la curva.
- Requiere un número par de subintervalos.
- Más preciso que el método del trapecio para funciones suaves.

#### **[Método de Simpson 3/8](/Tema4_Metodos_de_Diferenciacion_e_Integracion_Numerica/Metodos_de_Integracion_Numerica/Regla_de_Simpson_3\8/)**
- Usa tres segmentos y un polinomio cúbico.
- Apto cuando el número de subintervalos no es múltiplo de 2 pero sí de 3.
- Mayor precisión en algunos casos respecto al 1/3.

#### **[Cuadratura Gaussiana](/Tema4_Metodos_de_Diferenciacion_e_Integracion_Numerica/Metodos_de_Integracion_Numerica/Cuadratica_Gaussiana)**
- Integra funciones usando puntos y pesos óptimos.
- No requiere que los puntos estén equidistantes.
- Muy eficiente y preciso, especialmente con pocos puntos.

---

## **Notas Finales**
- Elegir el método adecuado depende de la forma de la función, la cantidad de datos y la precisión deseada.
- Métodos como **Simpson y Gaussiana** ofrecen alta precisión con menos evaluaciones.
- En cambio, **trapecio y métodos de puntos** son simples y robustos, ideales para datos experimentales o cálculos rápidos.

---
