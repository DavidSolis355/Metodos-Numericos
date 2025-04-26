# **Métodos de Solución de Sistemas de Ecuaciones Lineales**

## **Introducción**
Los **sistemas de ecuaciones lineales** son conjuntos de ecuaciones donde las variables aparecen solo con exponentes de uno. Resolver estos sistemas es una tarea fundamental en áreas como ingeniería, física, computación y matemáticas aplicadas.

Cuando los métodos algebraicos tradicionales se vuelven imprácticos, se utilizan **métodos numéricos** para obtener soluciones aproximadas de manera eficiente. Estos métodos pueden dividirse en dos grandes categorías:

- **Métodos Directos**
- **Métodos Iterativos**

En este proyecto, se abordarán varios de los métodos más utilizados para resolver sistemas de ecuaciones lineales.

---

## **Conceptos Básicos**
- **Sistema de ecuaciones lineales:** Conjunto de ecuaciones de la forma \( Ax = b \), donde \( A \) es una matriz de coeficientes, \( x \) es el vector de incógnitas y \( b \) es el vector de constantes.
- **Matriz aumentada:** Representación compacta que incluye los coeficientes y las constantes en una sola matriz.
- **Error relativo:** Medida para evaluar la cercanía entre aproximaciones sucesivas en métodos iterativos.

---

## **Importancia de Resolver Sistemas de Ecuaciones Lineales**
- Son fundamentales para modelar y resolver problemas del mundo real.
- Permiten el análisis y simulación de sistemas físicos, económicos y de ingeniería.
- Los métodos numéricos ofrecen soluciones rápidas y aproximadas para sistemas grandes donde los métodos exactos serían ineficientes.

---

## **Métodos Abordados**

### **Métodos Directos**
Estos métodos encuentran la solución en un número finito de operaciones (en teoría, sin iteraciones).

#### **Eliminación Gaussiana**
- Transforma el sistema a una forma triangular superior mediante operaciones elementales.
- Se resuelve luego por sustitución hacia atrás.

#### **Método de Gauss-Jordan**
- Variante de la eliminación gaussiana.
- Lleva la matriz a una forma diagonal o identidad.
- Da la solución directamente sin necesidad de sustitución.

---

### **Métodos Iterativos**
Estos métodos generan una secuencia de aproximaciones sucesivas hasta alcanzar una solución con el error deseado.

#### **Método de Jacobi**
- Calcula nuevas aproximaciones usando únicamente valores de la iteración anterior.
- Requiere que la matriz sea diagonalmente dominante para garantizar convergencia.

#### **Método de Gauss-Seidel**
- Similar a Jacobi, pero utiliza de inmediato los valores recién calculados en cada paso.
- Generalmente converge más rápido que Jacobi bajo las mismas condiciones.

---

## **Notas Finales**
- **Métodos Directos** son eficientes para sistemas pequeños o moderados y ofrecen soluciones exactas (en teoría).
- **Métodos Iterativos** son más adecuados para sistemas grandes, dispersos o cuando se requiere una solución aproximada rápidamente.
- La elección del método depende del tamaño del sistema, la precisión requerida y las características de la matriz de coeficientes.

---
