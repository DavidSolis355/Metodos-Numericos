# **Métodos de Solución de Ecuaciones**

## **Introducción**
Los **métodos de solución de ecuaciones** son técnicas numéricas utilizadas para encontrar valores que satisfacen una ecuación de la forma \( f(x) = 0 \). Estos métodos son esenciales cuando no es posible encontrar soluciones exactas de manera analítica, ya sea por la complejidad de la función o por limitaciones prácticas.

En este proyecto, se abordarán cinco métodos fundamentales:
- Método de Bisección
- Método de Regla Falsa
- Método de Newton-Raphson
- Método de Punto Fijo
- Método de la Secante

Cada uno tiene diferentes características, ventajas y limitaciones que los hacen adecuados para distintos tipos de problemas.

---

## **Conceptos Básicos**
- **Raíz de una función:** Es el valor de \( x \) que satisface \( f(x) = 0 \).
- **Iteración:** Proceso de aproximar el valor de la raíz a través de repeticiones sucesivas.
- **Criterio de paro:** Condición que define cuándo detener las iteraciones (por ejemplo, cuando el error es suficientemente pequeño).

---

## **Importancia de los Métodos Numéricos en la Solución de Ecuaciones**
- Permiten encontrar soluciones cuando no es posible resolver analíticamente.
- Son fundamentales en áreas como ingeniería, física, finanzas y computación.
- Ofrecen procedimientos sistemáticos para aproximarse a la raíz deseada.
- Pueden ser aplicados a funciones complicadas o problemas reales donde las soluciones exactas no existen.

---

## **Métodos Abordados**

### **Método de Bisección**
- Divide el intervalo a la mitad en cada iteración.
- Garantiza convergencia si la función cambia de signo.
- Convergencia lenta pero segura.

### **Método de Regla Falsa**
- Similar a bisección, pero utiliza una línea secante entre los extremos.
- Más rápido que la bisección en muchos casos.
- Puede atascarse si la función es muy inclinada en uno de los extremos.

### **Método de Newton-Raphson**
- Usa la derivada de la función para aproximar la raíz.
- Convergencia rápida si la aproximación inicial es buena.
- Requiere que la función sea derivable y la derivada no sea cero cerca de la raíz.

### **Método de Punto Fijo**
- Reescribe la ecuación en la forma \( x = g(x) \).
- Itera aplicando la función \( g \).
- Convergencia depende de las propiedades de \( g(x) \).

### **Método de la Secante**
- No requiere derivadas.
- Utiliza dos aproximaciones iniciales y una línea secante.
- Convergencia superlineal, más rápido que bisección pero menos que Newton-Raphson.

---

## **Notas Finales**
Cada método tiene su propio campo de aplicación dependiendo de:
- La forma de la función.
- La necesidad de precisión.
- La facilidad de derivar la función o no.

La correcta elección del método puede significar una solución más rápida y precisa.

---
