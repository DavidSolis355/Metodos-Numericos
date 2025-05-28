## **Método de la Secante**

### **Definición**
El **método de la secante** es un método numérico iterativo para encontrar raíces de funciones no lineales. A diferencia de Newton-Raphson, no requiere derivadas, sino que usa una aproximación basada en una **recta secante** que pasa por dos puntos anteriores.

### **¿Para qué se usa?**
- Para **hallar raíces** de funciones cuando no se tiene la derivada o no es fácil calcularla.
- Es útil cuando se quiere **evitar el uso de derivadas**.
- Aplicado en problemas de física, ingeniería y finanzas donde las funciones son complejas.

### **Fórmula**

Dado dos valores iniciales \( x_0 \) y \( x_1 \), la fórmula iterativa es:

$$
x_{n+1} = x_n - f(x_n) \cdot \frac{x_n - x_{n-1}}{f(x_n) - f(x_{n-1})}
$$

Donde:
- \( f(x) \) es la función.
- \( x_n \) y \( x_{n-1} \) son aproximaciones anteriores.

### **Características**
- No requiere derivadas.
- Puede ser más rápido que bisección, pero **menos estable**.
- Su **convergencia es superlineal**, más rápida que bisección pero más lenta que Newton-Raphson.
- Requiere **dos valores iniciales** cercanos a la raíz.

### **Ejemplo**

Supón que queremos encontrar la raíz de:

$$
f(x) = x^2 - 4
$$

Tomamos dos valores iniciales:

- \( x_0 = 3 \), \( f(x_0) = 5 \)
- \( x_1 = 2.5 \), \( f(x_1) = 2.25 \)

Aplicamos la fórmula:

1. 
$$
x_2 = 2.5 - \frac{2.25 \cdot (2.5 - 3)}{2.25 - 5} 
= 2.5 - \frac{-1.125}{-2.75} \approx 2.0909
$$

2. Luego, con \( x_1 = 2.5 \) y \( x_2 = 2.0909 \), se sigue iterando.

Después de varias iteraciones, el valor se acerca a la raíz \( x = 2 \).

---

### [Codigo en Java](Secante.java)

```java

public class MetodoSecante {

    public static void main(String[] args) {
        double x0 = 0.0;         // Primera aproximación inicial
        double x1 = 1.0;         // Segunda aproximación inicial
        double tolerancia = 1e-6; // Tolerancia deseada
        int maxIter = 100;        // Máximo número de iteraciones

        // Llamar al método de la secante
        secante(x0, x1, tolerancia, maxIter);
    }

    /**
     * Función f(x) a la cual se le quiere encontrar la raíz.
     * @param x Valor de entrada
     * @return Valor de la función en x
     */
    public static double f(double x) {
        // Ejemplo: f(x) = x^2 - 3x + 2
        return Math.pow(x, 2) - 3 * x + 2;
    }

    /**
     * Método de la Secante para encontrar una raíz de f(x) = 0.
     *
     * @param x0 Primera aproximación inicial
     * @param x1 Segunda aproximación inicial
     * @param tol Tolerancia deseada
     * @param maxIter Número máximo de iteraciones permitidas
     */
    public static void secante(double x0, double x1, double tol, int maxIter) {
        double f0 = f(x0);
        double f1 = f(x1);
        int iteracion = 1;

        while (iteracion <= maxIter) {
            // Calcular nueva aproximación usando la fórmula de la secante
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            double error = Math.abs(x2 - x1);

            // Mostrar información de la iteración
            System.out.printf("Iteración %d: x=%.6f, error=%.6f%n", iteracion, x2, error);

            // Verificar si el error es menor que la tolerancia
            if (error < tol) {
                System.out.printf("Raíz aproximada encontrada en x = %.6f con tolerancia %.6f%n", x2, tol);
                return;
            }

            // Actualizar valores para la siguiente iteración
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f(x1);
            iteracion++;
        }

        System.out.printf("Se alcanzó el máximo de iteraciones. Última aproximación: x = %.6f%n", x1);
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de Prueba para el Método de la Secante

Este documento muestra casos de prueba para el **método de la secante** implementado en Java. Incluye un caso donde el método converge correctamente y otro donde falla o diverge.

---

# ✅ Caso de Prueba Válido - Método de la Secante

**Descripción:**  
Se aplica el método de la secante a la función `f(x) = x² - 3x + 2`, que tiene raíces reales en `x = 1` y `x = 2`.

**Parámetros de entrada:**
- `x0 = 0.0`
- `x1 = 1.0`
- `tolerancia = 1e-6`
- `maxIter = 100`

**Justificación:**  
El intervalo inicial está cerca de la raíz `x = 1`, y la función es continua y derivable en el dominio.

**Resultado esperado (salida parcial):**

Iteración 1: x=2.000000, error=1.000000
Iteración 2: x=1.000000, error=1.000000
Iteración 3: x=1.000000, error=0.000000
Raíz aproximada encontrada en x = 1.000000 con tolerancia 0.000001

---

# ❌ Caso de Prueba Inválido - Método de la Secante

**Descripción:**  
Se intenta aplicar el método con dos puntos iniciales donde `f(x0) = f(x1)`, lo cual genera división por cero en la fórmula de la secante.

**Parámetros de entrada:**
- `x0 = 1.0`
- `x1 = 1.0`
- `tolerancia = 1e-6`
- `maxIter = 100`

**Justificación:**  
Si `x0 == x1`, entonces `f(x1) - f(x0) = 0`, lo que causa una división por cero.

**Resultado esperado (salida parcial):**

Exception in thread "main" java.lang.ArithmeticException: / by zero
at MetodoSecante.secante(MetodoSecante.java:X)


### [Hoja de EXCEL](Secante.xlsx)
