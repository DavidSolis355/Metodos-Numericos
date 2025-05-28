## **Método de la Regla Falsa**

### **Definición**
El **método de la regla falsa** (también llamado método de la falsa posición) es un procedimiento numérico para encontrar raíces de funciones continuas. Al igual que el método de bisección, se basa en el teorema del valor intermedio, pero en lugar de usar el punto medio, calcula un punto de intersección entre la recta que une los extremos del intervalo.

### **¿Para qué se usa?**
- Para encontrar **raíces reales** de ecuaciones no lineales.
- Para obtener una **mejor aproximación** que la bisección en algunas funciones.
- Para resolver problemas donde se conoce un intervalo con cambio de signo.

### **Fórmula**

Si:
- $f(a) \cdot f(b) < 0$, hay una raíz en $[a, b]$

Entonces el nuevo punto $x$ se calcula como:

$$
x = b - \frac{f(b) \cdot (b - a)}{f(b) - f(a)}
$$

Este punto reemplaza a $a$ o $b$ según el signo de $f(x)$, manteniendo el intervalo donde se conserva el cambio de signo.

### **Características**
- Basado en **interpolación lineal**.
- Converge más rápido que la bisección en muchos casos.
- No siempre tiene **convergencia garantizada** si la función es muy asimétrica.
- Requiere que $f$ sea continua en el intervalo.

### **Ejemplo**

Encuentra la raíz de:

$$
f(x) = x^2 - 4
$$

Sabemos que:
- $f(1) = -3$
- $f(3) = 5$

Aplicamos la fórmula:

$$
x = 3 - \frac{5 \cdot (3 - 1)}{5 - (-3)} = 3 - \frac{10}{8} = 1.75
$$

Evaluamos $f(1.75) = (1.75)^2 - 4 = -0.9375$

Como $f(1) \cdot f(1.75) < 0$, la raíz está entre $[1, 1.75]$. Se repite el proceso hasta cumplir con la tolerancia deseada.

---

### [Codigo en Java](.java)

```java

public class MetodoReglaFalsa {

    public static void main(String[] args) {
        // Intervalo inicial, tolerancia y máximo de iteraciones
        double a = 1;
        double b = 2;
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        // Llamar al método de Regla Falsa
        reglaFalsa(a, b, tolerancia, maxIteraciones);
    }

    /**
     * Función definida por el usuario.
     * Cambiar esta función según el problema específico a resolver.
     * @param x Valor de entrada
     * @return Resultado de f(x)
     */
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^3 - x - 2
        return Math.pow(x, 3) - x - 2;
    }

    /**
     * Método que implementa la técnica de la Regla Falsa (Falsa Posición) para encontrar una raíz de la función.
     * @param a Límite inferior del intervalo
     * @param b Límite superior del intervalo
     * @param tol Tolerancia (error máximo permitido)
     * @param maxIter Número máximo de iteraciones permitidas
     */
    public static void reglaFalsa(double a, double b, double tol, int maxIter) {
        double fa = funcion(a);
        double fb = funcion(b);

        // Verificar que haya al menos una raíz en el intervalo
        if (fa * fb >= 0) {
            System.out.println("No se puede aplicar el método: f(a) * f(b) ≥ 0");
            return;
        }

        int iteracion = 0;
        double c = a;

        while (iteracion < maxIter) {
            // Calcular la intersección de la recta secante con el eje x
            c = b - fb * (b - a) / (fb - fa);
            double fc = funcion(c);

            // Imprimir detalles de la iteración
            System.out.printf("Iteración %d: a=%.6f, b=%.6f, c=%.6f, f(c)=%.6f%n", iteracion + 1, a, b, c, fc);

            // Verificar si se encontró una raíz exacta
            if (Math.abs(fc) < tol) {
                break;
            }

            // Actualizar los extremos del intervalo según el signo de f(c)
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }

            iteracion++;
        }

        // Mostrar el resultado final
        System.out.printf("Raíz aproximada encontrada en x = %.6f con tolerancia %.6f%n", c, tol);
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de Prueba para el Método de Regla Falsa (Falsa Posición)

Este documento contiene casos de prueba para el método numérico de **regla falsa** implementado en Java. Cada caso incluye una descripción, configuración del problema y resultado esperado.

---

## Método: `reglaFalsa(a, b, tol, maxIter)`

### ✅ Caso de prueba válido (funciona correctamente)

**Descripción:**  
Encuentra la raíz de la función `f(x) = x³ - x - 2` en el intervalo `[1, 2]`.

**Parámetros:**
- `a = 1`
- `b = 2`
- `tol = 1e-6`
- `maxIter = 100`

**Justificación:**  
`f(1) = -2`, `f(2) = 4`, como `f(a) * f(b) < 0`, se cumple el cambio de signo, por lo que hay una raíz en el intervalo.

**Resultado esperado (parcial):**

Iteración 1: a=1.000000, b=2.000000, c=1.333333, f(c)=-0.962963
...
Raíz aproximada encontrada en x = 1.521380 con tolerancia 0.000001

---

### ❌ Caso de prueba inválido (no debe funcionar)

**Descripción:**  
Se intenta aplicar el método en un intervalo donde no hay cambio de signo.

**Modificaciones al código:**
```java
double a = 2;
double b = 3;
```

**Justificación:**
'f(2) = 4, f(3) = 22', ambos valores son positivos, por lo tanto 'f(a) * f(b) > 0'. El método no es aplicable.

**Resultado esperado:**

No se puede aplicar el método: f(a) * f(b) ≥ 0

### [Hoja de EXCEL](Regla_Falsa.xlsx)
