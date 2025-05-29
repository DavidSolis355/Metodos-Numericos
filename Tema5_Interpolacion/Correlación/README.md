# **Métodos de Interpolación y Regresión**

## **Correlación**

### **Introducción**

La **correlación** es un concepto estadístico que mide la fuerza y la dirección de la relación lineal entre dos variables. En el contexto de los métodos numéricos, la correlación se utiliza para analizar el grado en que dos variables están relacionadas, lo cual es útil en muchas áreas como la estadística, la economía, la ingeniería, la biología, entre otras.

### **¿Qué es la Correlación?**

La **correlación** se refiere a una medida cuantitativa que nos indica si dos variables están relacionadas entre sí de forma directa o inversa. Esta relación se puede cuantificar mediante el **coeficiente de correlación**, que es un valor entre -1 y 1:

- **+1**: Correlación positiva perfecta. A medida que una variable aumenta, la otra también lo hace de manera proporcional.
- **-1**: Correlación negativa perfecta. A medida que una variable aumenta, la otra disminuye de manera proporcional.
- **0**: No hay correlación. Las dos variables no están relacionadas de manera lineal.

La fórmula del **coeficiente de correlación de Pearson** \( r \) se calcula como:

\[
r = \frac{n\sum xy - \sum x \sum y}{\sqrt{(n\sum x^2 - (\sum x)^2)(n\sum y^2 - (\sum y)^2)}}
\]

Donde:
- \( x \) y \( y \) son los valores de las dos variables.
- \( n \) es el número de datos.

### **Importancia de la Correlación en Métodos Numéricos**

La **correlación** es fundamental en la estadística y la regresión, ya que permite determinar el grado en que una variable puede predecir a otra. En muchos problemas, la **correlación** se utiliza para entender la relación entre diferentes factores y tomar decisiones informadas.

En los métodos numéricos, la correlación se aplica en el análisis de datos, especialmente en la **regresión lineal** y la **predicción** de comportamientos de variables dependientes.

### **Cálculo del Coeficiente de Correlación**

Para calcular el coeficiente de correlación entre dos variables \( x \) y \( y \), se puede usar la siguiente fórmula:

\[
r = \frac{\sum_{i=1}^n (x_i - \bar{x})(y_i - \bar{y})}{\sqrt{\sum_{i=1}^n (x_i - \bar{x})^2 \sum_{i=1}^n (y_i - \bar{y})^2}}
\]

Donde:
- \( x_i \) y \( y_i \) son los valores de las variables.
- \( \bar{x} \) y \( \bar{y} \) son las medias de las variables \( x \) y \( y \), respectivamente.

### **Métodos de Correlación en Métodos Numéricos**

Existen varios métodos para calcular la correlación y examinar la relación entre dos variables. Los métodos más comunes incluyen:

1. **Correlación de Pearson**: Evalúa la relación lineal entre dos variables.
2. **Correlación de Spearman**: Mide la relación monotónica entre dos variables.
3. **Correlación de Kendall**: Es otra forma de medir la relación entre dos variables, basándose en los rangos.

En este proyecto, nos centraremos en el **coeficiente de correlación de Pearson**, que es el más utilizado en la práctica.

### **Aplicaciones Prácticas de la Correlación**

La **correlación** tiene diversas aplicaciones en áreas como:

- **Análisis de datos**: Identificar patrones entre variables.
- **Economía**: Estudiar la relación entre variables económicas como el ingreso y el gasto.
- **Ingeniería**: Relacionar variables de un sistema para entender su comportamiento.
- **Ciencias sociales**: Analizar el impacto de diferentes factores en fenómenos sociales.

---

## **Próximos Pasos**

Una vez que comprendamos el concepto de **correlación**, podemos utilizar esta medida para hacer **predicciones** y **modelos estadísticos** más complejos, como la **regresión lineal**.

---

## **Notas Finales**

- La **correlación** es una herramienta poderosa para entender las relaciones entre variables.
- Es importante entender que la **correlación** no implica causalidad. Es decir, dos variables pueden estar correlacionadas sin que una cause la otra.
- En el contexto de los métodos numéricos, la **correlación** ayuda a establecer modelos y tomar decisiones basadas en datos.

---

### [Codigo en Java](Correlacion.java)

```java

import java.util.Scanner;

public class Correlacion {
    public static void main(String[] args) {
         // Crear el objeto Scanner para leer los datos desde el teclado
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el número de elementos en los conjuntos de datos
        System.out.println("Ingrese el número de elementos en los conjuntos de datos:");
        int n = scanner.nextInt();
        
        // Crear dos arreglos para almacenar los valores de x e y
        double[] x = new double[n];
        double[] y = new double[n];

        // Leer los valores de los conjuntos de datos x y y
        System.out.println("Ingrese los valores del conjunto de datos x:");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }
        
        System.out.println("Ingrese los valores del conjunto de datos y:");
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }

        // Llamar al método para calcular el coeficiente de correlación de Pearson
        double r = calcularCorrelacion(x, y, n);

        // Mostrar el resultado de la correlación
        System.out.printf("El coeficiente de correlación de Pearson es: %.4f%n", r);
        
        // Cerrar el scanner
        scanner.close();
    }

    /**
     * Este método calcula el coeficiente de correlación de Pearson entre dos conjuntos de datos.
     * 
     * @param x Arreglo con los valores del conjunto de datos x.
     * @param y Arreglo con los valores del conjunto de datos y.
     * @param n El número de elementos en cada conjunto de datos.
     * @return El coeficiente de correlación de Pearson.
     */
    public static double calcularCorrelacion(double[] x, double[] y, int n) {
        // Calcular las medias de los conjuntos de datos x y y
        double mediaX = calcularMedia(x, n);
        double mediaY = calcularMedia(y, n);

        // Variables para los sumatorios de la fórmula
        double sumatoriaXY = 0;
        double sumatoriaX2 = 0;
        double sumatoriaY2 = 0;

        // Calcular las sumas necesarias para el coeficiente de correlación
        for (int i = 0; i < n; i++) {
            sumatoriaXY += (x[i] - mediaX) * (y[i] - mediaY);
            sumatoriaX2 += Math.pow(x[i] - mediaX, 2);
            sumatoriaY2 += Math.pow(y[i] - mediaY, 2);
        }

        // Calcular el coeficiente de correlación de Pearson
        return sumatoriaXY / Math.sqrt(sumatoriaX2 * sumatoriaY2);
    }

     /**
     * Este método calcula la media de un conjunto de datos.
     * 
     * @param datos Arreglo con los valores del conjunto de datos.
     * @param n El número de elementos en el conjunto de datos.
     * @return La media del conjunto de datos.
     */
    public static double calcularMedia(double[] datos, int n) {
        double suma = 0;

        // Sumar todos los valores de los datos
        for (int i = 0; i < n; i++) {
            suma += datos[i];
        }

        // Calcular la media
        return suma / n;
    }
}

```

### [Caso de Prueba](Casos_de_Prueba)

## Caso de Prueba - Método de Correlación

### **Ejercicio**

Calcular el coeficiente de correlación de Pearson para los siguientes conjuntos de datos:

- \( x = \{ 1, 2, 3, 4, 5 \} \)
- \( y = \{ 2, 4, 6, 8, 10 \} \)

---

### **Entrada en consola**
 
```java

Ingrese el número de elementos en los conjuntos de datos:
5
Ingrese los valores del conjunto de datos x:
1
2
3
4
5
Ingrese los valores del conjunto de datos y:
2
4
6
8
10

```
---

### **Salida en consola**
 
```java

El coeficiente de correlación de Pearson es: 1.0000

```
