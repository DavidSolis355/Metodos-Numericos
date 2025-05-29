# **Método de Mínimos Cuadrados**

## **Introducción**

El **Método de Mínimos Cuadrados** es una técnica matemática utilizada para encontrar la mejor aproximación de una función a un conjunto de datos empíricos. Este método se utiliza comúnmente para ajustar un modelo de datos en situaciones donde los datos no siguen una relación exacta, pero se desea encontrar una línea o curva que minimice el error cuadrático entre los valores observados y los valores predichos.

El método de mínimos cuadrados tiene aplicaciones en diversos campos, como estadística, ingeniería, física, economía, y más. En su forma más simple, se usa para la **regresión lineal**, donde se busca la recta que mejor se ajusta a los puntos de datos.

---

## **Objetivo del Método**

El principal objetivo del **Método de Mínimos Cuadrados** es minimizar la suma de los cuadrados de las diferencias entre los valores observados y los valores estimados. El modelo de regresión lineal se puede representar como:

\[
y = mx + b
\]

Donde:
- \( y \) es el valor predicho,
- \( x \) es el valor de entrada,
- \( m \) es la pendiente de la recta (coeficiente de regresión),
- \( b \) es la intersección o término constante (intercepto).

El objetivo es encontrar los valores de \( m \) y \( b \) que minimicen la siguiente función de error:

\[
E = \sum_{i=1}^{n} \left( y_i - (m x_i + b) \right)^2
\]

Donde \( (x_i, y_i) \) son los puntos de datos.

---

## **Aplicaciones del Método de Mínimos Cuadrados**

- **Ajuste de datos experimentales**: Se utiliza para ajustar modelos a datos reales en ciencia e ingeniería.
- **Predicción de tendencias**: En economía y finanzas, se emplea para predecir tendencias futuras basadas en datos pasados.
- **Análisis de regresión**: Usado en estadística para modelar la relación entre variables dependientes e independientes.

---

## **Descripción del Método**

El **Método de Mínimos Cuadrados** se basa en la minimización de la suma de los errores cuadráticos. En la regresión lineal, se derivan fórmulas explícitas para obtener los coeficientes de la recta (pendiente \( m \) e intersección \( b \)):

\[
m = \frac{n\sum{x_i y_i} - \sum{x_i}\sum{y_i}}{n\sum{x_i^2} - (\sum{x_i})^2}
\]
\[
b = \frac{\sum{y_i} - m\sum{x_i}}{n}
\]

Donde:
- \( n \) es el número de puntos de datos,
- \( x_i \) y \( y_i \) son los valores de los datos.

Estas fórmulas nos permiten calcular de manera eficiente los parámetros de la recta de ajuste.

---

## **Beneficios del Método de Mínimos Cuadrados**

- **Simplicidad y eficacia**: Es un método sencillo que puede ser implementado con facilidad en muchos lenguajes de programación.
- **Ajuste óptimo**: Proporciona el mejor ajuste posible cuando los datos presentan un patrón lineal.
- **Versatilidad**: Puede ser extendido a modelos no lineales y otras aplicaciones como la regresión polinómica o multivariable.

---

## **Métodos Abordados en este Proyecto**

En este proyecto, se abordará la implementación del método de **Mínimos Cuadrados** para el ajuste de una **recta lineal** a un conjunto de puntos de datos. El objetivo es calcular la recta que mejor se ajusta a los datos minimizando el error cuadrático.

El código correspondiente a la implementación del **Método de Mínimos Cuadrados** para una regresión lineal se proporcionará más adelante, permitiendo realizar el ajuste de datos y obtener los parámetros \( m \) (pendiente) y \( b \) (intersección) de la recta.

---

## **Conclusión**

El **Método de Mínimos Cuadrados** es una herramienta poderosa en el análisis de datos que permite realizar un ajuste preciso de modelos a conjuntos de datos empíricos. Es fundamental en muchas áreas de la ciencia y la ingeniería, y proporciona una base para comprender y predecir relaciones entre variables.

---

### [Codigo en Java](MinimosCuadrados.java)

```java

public class MetodoMinimosCuadrados {

    // Método para calcular la pendiente (m) y la intersección (b) usando el método de mínimos cuadrados
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        int n = x.length;
        
        // Sumar los valores de x, y, x^2, y*x
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }
        
        // Calcular la pendiente (m) y la intersección (b) usando las fórmulas de mínimos cuadrados
        double m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double b = (sumY - m * sumX) / n;
        
        // Retornar los valores de m (pendiente) y b (intersección)
        return new double[]{m, b};
    }

     // Método para predecir los valores de y usando la recta de regresión y = mx + b
    public static double[] predecir(double[] x, double m, double b) {
        double[] yPred = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            yPred[i] = m * x[i] + b;
        }
        return yPred;
    }
     public static void main(String[] args) {
        // Datos de ejemplo (valores de x y y)
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 5, 4, 5};
        
        // Calcular la pendiente y la intersección
        double[] resultados = calcularMinimosCuadrados(x, y);
        double m = resultados[0];
        double b = resultados[1];
        
        // Mostrar la ecuación de la recta ajustada
        System.out.println("Ecuación de la recta de regresión: y = " + m + "x + " + b);
        
        // Predecir los valores de y usando la recta de regresión
        double[] yPred = predecir(x, m, b);
        
        // Mostrar las predicciones
        System.out.println("Valores predichos de y:");
        for (int i = 0; i < yPred.length; i++) {
            System.out.println("x = " + x[i] + ", Predicción y = " + yPred[i]);
        }
    }
}

```

### [Caso de Prueba](Casos_de_Prueba.md) 

## Caso de Prueba - Método de Mínimos Cuadrados

### **Ejercicio**

Calcular la recta de regresión (pendiente \( m \) e intersección \( b \)) para los puntos:

- \( (1, 2) \)
- \( (2, 4) \)
- \( (3, 5) \)
- \( (4, 4) \)
- \( (5, 5) \)

y predecir los valores de \( y \) usando la recta ajustada.

---

### **Entrada en consola**

```java
// En este caso, los datos están definidos en el código, no se ingresa nada por consola.
```

### **Salida en consola**

```java

Ecuación de la recta de regresión: y = 0.6x + 2.2
Valores predichos de y:
x = 1, Predicción y = 2.8
x = 2, Predicción y = 3.4
x = 3, Predicción y = 4.0
x = 4, Predicción y = 4.6
x = 5, Predicción y = 5.2

```

