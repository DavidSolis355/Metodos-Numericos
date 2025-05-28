## **Método de Diferenciación de 3 Puntos**

### **Definición**
El **método de diferenciación de 3 puntos** es una técnica numérica utilizada para aproximar la derivada de una función en un punto. Este método utiliza tres puntos cercanos para calcular la derivada mediante una aproximación basada en diferencias finitas.

### **¿Para qué se usa?**
- Para **aproximar derivadas** de funciones cuando no se dispone de una expresión algebraica simple de la derivada.
- Utilizado en **simulaciones numéricas** y **modelos matemáticos** cuando se trabaja con funciones discretizadas o datos experimentales.
- Es común en análisis de señales y en métodos de solución numérica de ecuaciones diferenciales.

### **Método de Resolución (Procedimiento)**
El método de 3 puntos utiliza una fórmula que emplea tres valores consecutivos de la función, \( f(x - h) \), \( f(x) \), y \( f(x + h) \), para aproximar la derivada en \( x \).

La fórmula general es:

$$
f'(x) \approx \frac{f(x + h) - f(x - h)}{2h}
$$

Donde:
- \( f(x) \) es la función de la cual se quiere calcular la derivada.
- \( h \) es el paso, es decir, la distancia entre los puntos.

### **Características**
- **Sencillez:** Es fácil de implementar y no requiere derivadas explícitas de la función.
- **Precisión:** La precisión depende del tamaño de \( h \); con un \( h \) pequeño, se obtiene una mejor aproximación, pero hay que considerar problemas de redondeo para valores demasiado pequeños.
- **Requiere tres puntos de datos:** La fórmula necesita evaluar la función en tres puntos cercanos a \( x \).

### **Ejemplo**

Supongamos que queremos aproximar la derivada de la función \( f(x) = x^2 \) en el punto \( x = 2 \) usando el método de 3 puntos.

1. **Elegimos un valor para \( h \):**
   Vamos a tomar \( h = 0.1 \).

2. **Evaluamos la función en los puntos \( x - h \), \( x \), y \( x + h \):**
   - \( f(2 - 0.1) = f(1.9) = (1.9)^2 = 3.61 \)
   - \( f(2) = 2^2 = 4 \)
   - \( f(2 + 0.1) = f(2.1) = (2.1)^2 = 4.41 \)

3. **Aplicamos la fórmula del método de 3 puntos:**

$$
f'(2) \approx \frac{f(2.1) - f(1.9)}{2(0.1)} = \frac{4.41 - 3.61}{0.2} = \frac{0.8}{0.2} = 4
$$

**Resultado:** La derivada aproximada de \( f(x) = x^2 \) en \( x = 2 \) es 4, que es la derivada exacta.

---

### [Codigo en Java](DiferenciacionTresPuntos.java)

```java

public class DiferenciacionTresPuntos {

    // Método principal que calcula la derivada aproximada usando la fórmula de tres puntos
    public static void main(String[] args) {

        // Verifica que la longitud del arreglo de puntos sea exactamente 3
        if (puntos.length != 3) {
            throw new IllegalArgumentException("Debe haber exactamente 3 puntos.");
        }
        // Calcula la derivada utilizando la fórmula de tres puntos
        double derivada = (puntos[2] - puntos[0]) / (2 * h);

        // Devuelve el valor de la derivada
        return derivada;
    }

    /**
     * Calcula la derivada aproximada de una función en un punto utilizando la fórmula de tres puntos.
     *
     * @param puntos arreglo que contiene tres puntos consecutivos de la función (p0, p1, p2)
     * @param h      el paso entre los puntos (la diferencia entre los puntos consecutivos)
     * @return       la derivada aproximada en el punto medio entre p0 y p2
     */
    public static double derivadaTresPuntos(double[] puntos, double h) {
        // Valor de h (tamaño del paso) que se utilizará en el cálculo de la derivada
        double h = 0.1; 
        
        // Definición de los puntos que se usarán para aproximar la derivada
        double[] puntos = {1, 1.0, 1.21};  

        // Llama al método de derivadaTresPuntos para calcular la derivada
        double derivada = derivadaTresPuntos(puntos, h);

        // Muestra el resultado de la derivada aproximada
        System.out.println("La derivada aproximada es: " + derivada);
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Ejemplo de ejecución del método de Diferenciación de Tres Puntos

---

## Fórmula utilizada

La fórmula de tres puntos centrados para calcular la derivada aproximada es:

$$
f'(x) \approx \frac{f(x+h) - f(x-h)}{2h}
$$

---

## Datos usados en el ejemplo

Usamos los siguientes valores:

- Arreglo de puntos: `puntos = {1, 1.0, 1.21}`  
  (esto representa: \( f(x-h) = 1 \), \( f(x) = 1.0 \), \( f(x+h) = 1.21 \))
- Paso entre puntos: `h = 0.1`

---

## Reemplazo en el código

Cambiar dentro del método `main` el bloque de código a:

```java
double h = 0.1; 
double[] puntos = {1, 1.0, 1.21};  
double derivada = derivadaTresPuntos(puntos, h);
System.out.println("La derivada aproximada es: " + derivada);
```

### Resultado esperado


```java

La derivada aproximada es: 1.05

```
