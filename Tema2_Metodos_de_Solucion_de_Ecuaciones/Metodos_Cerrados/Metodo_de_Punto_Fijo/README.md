## **Método de Punto Fijo**

### **Definición**
El **método de punto fijo** es un algoritmo iterativo que se utiliza para encontrar las raíces de una ecuación de la forma \( f(x) = 0 \). En este método, la ecuación se reescribe de manera que \( x = g(x) \), y luego se itera sobre \( x_n \) para encontrar un punto fijo, es decir, un valor \( x \) tal que \( g(x) = x \).

### **¿Para qué se usa?**
- Para **encontrar raíces** de ecuaciones no lineales.
- Ideal cuando la función se puede **reescribir como una función iterativa**.
- Utilizado en la resolución de ecuaciones en matemáticas aplicadas y ciencias computacionales.

### **Fórmula**

Dada una ecuación \( f(x) = 0 \), se reescribe como:

$$
x = g(x)
$$

El valor de \( x \) se actualiza iterativamente usando la fórmula:

$$
x_{n+1} = g(x_n)
$$

Donde:
- \( g(x) \) es la forma reescrita de la función \( f(x) = 0 \).
- \( x_n \) es la aproximación en la iteración \( n \).

### **Características**
- Convergencia depende de que la función \( g(x) \) cumpla ciertas condiciones (como que \( |g'(x)| < 1 \)).
- Puede **no converger** si \( g(x) \) no cumple las condiciones necesarias.
- La convergencia es **lineal**, lo que puede ser más lento que otros métodos como Newton-Raphson.

### **Ejemplo**

Supón que quieres encontrar la raíz de:

$$
f(x) = x^2 - 4
$$

Reescribimos como:

$$
g(x) = \sqrt{4 + x}
$$

Elegimos un valor inicial, por ejemplo \( x_0 = 1 \).

Aplicamos la fórmula iterativa:

1. \( x_1 = g(1) = \sqrt{4 + 1} = \sqrt{5} \approx 2.2361 \)
2. \( x_2 = g(2.2361) = \sqrt{4 + 2.2361} \approx 2.5495 \)
3. \( x_3 = g(2.5495) = \sqrt{4 + 2.5495} \approx 2.6564 \)

El valor comienza a acercarse a la raíz de \( 2 \) a medida que se repiten las iteraciones.

---

### [Codigo en Java](PuntoFijo.java)

```java

public class MetodoPuntoFijo {

    public static void main(String[] args) {
        double x0 = 0.5;         // Valor inicial
        double tolerancia = 1e-6; // Tolerancia deseada
        int maxIter = 100;        // Número máximo de iteraciones

        // Llamada al método de Punto Fijo
        puntoFijo(x0, tolerancia, maxIter);
    }

    /**
     * Función g(x) tal que x = g(x).
     * Esta función debe cumplir con las condiciones de convergencia del método.
     * @param x Valor de entrada
     * @return Resultado de g(x)
     */
    public static double g(double x) {
        // Ejemplo: para f(x) = x^2 - 3x + 2, se puede usar g(x) = (x^2 + 2)/3
        return (Math.pow(x, 2) + 2) / 3;
    }

    /**
     * Método de Punto Fijo para encontrar una raíz de la ecuación f(x) = 0
     * transformándola en x = g(x).
     *
     * @param x0 Valor inicial (aproximación inicial)
     * @param tol Tolerancia deseada (error máximo permitido)
     * @param maxIter Número máximo de iteraciones
     */
    public static void puntoFijo(double x0, double tol, int maxIter) {
        int iteracion = 0;
        double x = x0;

        while (iteracion < maxIter) {
            double x1 = g(x);  // Aplicar la función g(x)
            double error = Math.abs(x1 - x);  // Calcular el error

            // Imprimir valores de la iteración
            System.out.printf("Iteración %d: x=%.6f, error=%.6f%n", iteracion + 1, x1, error);

            // Verificar si el error es menor que la tolerancia
            if (error < tol) {
                System.out.printf("Raíz aproximada encontrada en x = %.6f con tolerancia %.6f%n", x1, tol);
                return;
            }

            x = x1;
            iteracion++;
        }

        System.out.printf("Se alcanzó el máximo de iteraciones. Última aproximación: x = %.6f%n", x);
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de Prueba para el Método de Punto Fijo

Este documento contiene casos de prueba para el método numérico de **Punto Fijo** implementado en Java. Se muestra un caso exitoso y uno fallido con la configuración correspondiente.

---

## Método: `puntoFijo(x0, tol, maxIter)`

### ✅ Caso de prueba válido (converge correctamente)

**Descripción:**  
Se busca una raíz de la función `f(x) = x² - 3x + 2`, reescrita como `x = g(x) = (x² + 2)/3`.

**Parámetros:**
- `x0 = 0.5`
- `tol = 1e-6`
- `maxIter = 100`

**Justificación:**  
La función `g(x)` está bien construida y cumple con la condición de convergencia local (`|g'(x)| < 1`) en el intervalo cercano a la raíz.

**Resultado esperado (parcial):**

Iteración 1: x=0.583333, error=0.083333
...
Iteración 17: x=1.000000, error=0.000000
Raíz aproximada encontrada en x = 1.000000 con tolerancia 0.000001


---

### ❌ Caso de prueba inválido (no converge)

**Descripción:**  
Se utiliza una función `g(x)` que no cumple con la condición de convergencia (|g′(x)| > 1), por lo tanto, el método no se aproxima a una raíz.

**Modificaciones sugeridas al código:**
```java
public static double g(double x) {
    // g(x) no converge: por ejemplo, g(x) = x^2 + 1
    return Math.pow(x, 2) + 1;
}

**Parámetros:**

- 'x0 = 0.5'
- 'tol = 1e-6'
- 'maxIter = 100'

**Justificación:**
La función 'g(x) = x² + 1' tiene derivada 'g(x) = 2x,' que para 'x=0.5 da 1.0', pero rápidamente crece por encima de 1. Esto hace que el método diverja.

**Resultado esperado:**

Iteración 1: x=1.250000, error=0.750000
Iteración 2: x=2.562500, error=1.312500
...
Se alcanzó el máximo de iteraciones. Última aproximación: x = valor grande


### [Hoja de EXCEL](Punto_Fijo.xlsx)
