# **Métodos Numéricos: Regresión**

## **Introducción**
La **regresión** es una técnica estadística utilizada para modelar la relación entre una variable dependiente \( y \) y una o más variables independientes \( x_1, x_2, ..., x_n \). En el contexto de los métodos numéricos, la regresión se emplea principalmente para encontrar una función que se ajuste lo mejor posible a un conjunto de datos observados.

El propósito de la regresión es predecir valores de \( y \) a partir de nuevas observaciones de \( x \), lo que la convierte en una herramienta útil en áreas como la economía, la biología, la ingeniería y la ciencia de datos.

### **Tipos de Regresión**
- **Regresión Lineal Simple:** Es el caso más sencillo, donde se ajusta una línea recta a los datos, con una sola variable independiente \( x \).
- **Regresión Lineal Múltiple:** Se emplea cuando se tienen varias variables independientes y se ajusta un plano o hiperplano a los datos.
- **Regresión No Lineal:** En este caso, la relación entre \( y \) y \( x \) no se ajusta a una línea recta, sino a una función más compleja.

---

## **Regresión Lineal**
En este proyecto nos centraremos en la **regresión lineal simple**, donde buscamos ajustar una recta de la forma:

\[
y = mx + b
\]

donde:
- \( y \) es la variable dependiente,
- \( x \) es la variable independiente,
- \( m \) es la pendiente de la recta,
- \( b \) es la intersección con el eje \( y \) (la ordenada al origen).

Para obtener los coeficientes \( m \) y \( b \), utilizamos el método de **mínimos cuadrados**, que minimiza la suma de los errores cuadráticos entre las predicciones y los valores observados.

---

## **Método de Mínimos Cuadrados**
El método de **mínimos cuadrados** busca minimizar la función de error cuadrático medio (ECM), que se define como:

\[
S = \sum_{i=1}^n (y_i - (mx_i + b))^2
\]

donde:
- \( y_i \) es el valor observado,
- \( x_i \) es el valor de la variable independiente,
- \( m \) es la pendiente de la recta,
- \( b \) es la intersección con el eje \( y \).

Para minimizar esta función, calculamos las derivadas parciales respecto a \( m \) y \( b \) y las igualamos a cero, lo que nos da las ecuaciones necesarias para encontrar los coeficientes óptimos de la recta.

---

## **Importancia de la Regresión**
- **Predicción**: La regresión permite hacer predicciones basadas en datos existentes.
- **Modelado de relaciones**: Ayuda a entender cómo las variables están relacionadas entre sí.
- **Análisis de tendencias**: Es útil para encontrar tendencias y patrones dentro de los datos.

---

## **Métodos Abordados**

### **Regresión Lineal Simple**
Se ajusta una línea recta a un conjunto de datos utilizando el método de mínimos cuadrados para encontrar la pendiente \( m \) y la intersección \( b \).

---

## **Notas Finales**
La **regresión lineal** es uno de los métodos más básicos pero poderosos en el análisis de datos. Se usa ampliamente en la investigación científica y el análisis de datos de la industria para inferir relaciones entre variables y hacer predicciones basadas en modelos lineales.

Este tema será abordado con ejemplos prácticos y algoritmos que puedes implementar en diversos lenguajes de programación.

---

## **Referencias**
1. Weisberg, S. (2005). "Applied Linear Regression." Wiley-Interscience.
2. Seber, G. A. F., & Lee, A. J. (2003). "Linear Regression Analysis." Wiley-Interscience.

---

### [Codigo en Java](Regresion.java)

```java

import java.util.Scanner;

public class RegresionLineal {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("REGRESIÓN LINEAL - MÉTODO DE MÍNIMOS CUADRADOS");
        System.out.println("--------------------------------------------");
        
        // Solicitar el número de puntos de datos
        System.out.println("Introduzca el número de puntos de datos:");
        int n = scanner.nextInt();
        
        // Arrays para almacenar los valores de x e y
        double[] x = new double[n];
        double[] y = new double[n];
        
        // Leer los datos de entrada (valores de x e y)
        System.out.println("Introduzca los valores de x e y:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + (i+1) + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + (i+1) + "]: ");
            y[i] = scanner.nextDouble();
        }
        
        // Cálculos necesarios para el método de mínimos cuadrados
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        // Sumar los términos necesarios
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }
        
        // Calcular los coeficientes m (pendiente) y b (intersección)
        double m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double b = (sumY - m * sumX) / n;
        
        // Mostrar los resultados
        System.out.println("\nRESULTADOS:");
        System.out.printf("Pendiente (m) = %.4f%n", m);
        System.out.printf("Intersección (b) = %.4f%n", b);
        System.out.println("La ecuación de la recta ajustada es: y = " + m + "x + " + b);
        
        // Predicciones para algunos valores de x (si es necesario)
        System.out.println("\nRealizando predicciones para valores de x:");
        System.out.print("Introduzca un valor de x para predecir y: ");
        double xNuevo = scanner.nextDouble();
        double yPredicho = m * xNuevo + b;
        System.out.printf("Para x = %.4f, la predicción de y es: %.4f%n", xNuevo, yPredicho);
        
        scanner.close();
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

## Caso de Prueba - Regresión Lineal (con Entrada del Usuario)

### **Ejercicio**

Calcular la ecuación de la recta de regresión lineal a partir de un conjunto de puntos dados por el usuario, y realizar una predicción de \( y \) para un valor específico de \( x \).

---

### **Entrada en consola**

```java
Introduzca el número de puntos de datos:
5
Introduzca los valores de x e y:
x[1]: 1
y[1]: 2
x[2]: 2
y[2]: 4
x[3]: 3
y[3]: 5
x[4]: 4
y[4]: 4
x[5]: 5
y[5]: 5

Realizando predicciones para valores de x:
Introduzca un valor de x para predecir y: 
6
```

### **Salida en consola**

```java

RESULTADOS:
Pendiente (m) = 0.6000
Intersección (b) = 2.2000
La ecuación de la recta ajustada es: y = 0.6x + 2.2

Realizando predicciones para valores de x:
Para x = 6.0000, la predicción de y es: 5.8000

```

