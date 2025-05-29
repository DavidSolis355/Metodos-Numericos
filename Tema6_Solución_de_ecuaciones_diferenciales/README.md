# **Métodos Numéricos para Ecuaciones Diferenciales Ordinarias (EDO)**

## **Introducción**
Las **Ecuaciones Diferenciales Ordinarias (EDO)** modelan fenómenos donde una variable depende de la tasa de cambio de otra. Dado que muchas EDO no pueden resolverse de forma exacta, se utilizan **métodos numéricos** para obtener soluciones aproximadas.

Estos métodos calculan soluciones paso a paso, permitiendo obtener valores estimados de la función en puntos discretos, y son ampliamente usados en ingeniería, física, biología y simulaciones computacionales.

---

## **Conceptos Básicos**
- **EDO (Ecuación Diferencial Ordinaria):** Relación entre una función desconocida y sus derivadas respecto a una sola variable independiente.
- **Solución numérica:** Estimación del valor de la función usando algoritmos iterativos.
- **Tamaño de paso (h):** Intervalo entre los valores de la variable independiente donde se calcula la solución.
- **Error global/local:** Diferencia acumulada entre la solución exacta y la aproximada.

---

## **Importancia de Resolver EDO Numéricamente**
- Las soluciones analíticas no siempre existen o son complejas de obtener.
- Permite modelar fenómenos reales con precisión controlada.
- Facilita simulaciones y predicciones computacionales.

---

## **Métodos Abordados**

### **Método de Euler**

#### **[Método de Euler](/Tema6_Solución_de_ecuaciones_diferenciales/Método_de_Sistemas_de_Ecuaciones/Método_de_Euler)**
- Método explícito de un solo paso.
- Calcula la próxima aproximación usando la pendiente en el punto actual.
- **Fórmula:**  
  \[
  y_{n+1} = y_n + h \cdot f(x_n, y_n)
  \]
- Es simple y rápido, pero puede ser inexacto si \( h \) no es pequeño.

---

### **Método de Runge-Kutta de 4to Orden**

#### **[Runge-Kutta 4](/Tema6_Solución_de_ecuaciones_diferenciales/Método_de_1_Paso/Método_de_RungeKutta)**
- Método de un solo paso y alta precisión.
- Calcula la pendiente promedio usando 4 evaluaciones intermedias.
- **Fórmula general:**
  \[
  y_{n+1} = y_n + \frac{h}{6}(k_1 + 2k_2 + 2k_3 + k_4)
  \]
  Donde:
  \[
  \begin{aligned}
  k_1 &= f(x_n, y_n) \\
  k_2 &= f(x_n + h/2, y_n + h/2 \cdot k_1) \\
  k_3 &= f(x_n + h/2, y_n + h/2 \cdot k_2) \\
  k_4 &= f(x_n + h, y_n + h \cdot k_3)
  \end{aligned}
  \]
- Excelente balance entre precisión y velocidad de cálculo.

---

### **Método de Adams-Bashforth de 4 Pasos**

#### **[Adams-Bashforth](/Tema6_Solución_de_ecuaciones_diferenciales/Método_de_Pasos_Múltiples/Método_de_AdamsBashforth)**
- Método explícito de múltiples pasos.
- Usa los valores de \( f(x, y) \) de puntos anteriores para predecir el siguiente.
- **Fórmula:**
  \[
  y_{n+1} = y_n + \frac{h}{24}(55f_n - 59f_{n-1} + 37f_{n-2} - 9f_{n-3})
  \]
- Requiere valores iniciales obtenidos con otro método (generalmente Runge-Kutta).
- Muy eficiente para grandes cálculos con pasos pequeños.

---

## **Comparación Rápida**

| Método          | Tipo       | Precisión | Ventajas                       | Desventajas                    |
|----------------|------------|-----------|--------------------------------|--------------------------------|
| Euler           | Un paso    | Baja      | Simple y fácil de implementar  | Poca precisión                  |
| Runge-Kutta 4   | Un paso    | Alta      | Preciso sin pasos anteriores   | Más cálculos por iteración     |
| Adams-Bashforth| Multipasos | Alta      | Rápido en iteraciones largas   | Requiere valores previos        |

---

## **Notas Finales**
- El método de **Euler** es útil para introducción o problemas simples.
- **Runge-Kutta 4** es el estándar para soluciones precisas sin complicaciones.
- **Adams-Bashforth** es excelente cuando se tienen valores previos y se busca eficiencia computacional.

---

