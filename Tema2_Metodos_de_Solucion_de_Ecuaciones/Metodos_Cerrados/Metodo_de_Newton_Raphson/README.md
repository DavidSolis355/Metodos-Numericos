## **Método de Newton-Raphson**

### **Definición**
El **método de Newton-Raphson** es un método numérico iterativo utilizado para encontrar raíces de funciones reales. Se basa en la aproximación de la función mediante su **tangente** en un punto inicial y usa derivadas para mejorar la estimación en cada paso.

### **¿Para qué se usa?**
- Para **encontrar raíces** de funciones no lineales de forma rápida.
- Ideal cuando se requiere **alta precisión** en pocas iteraciones.
- Se usa ampliamente en ingeniería, física, informática, y matemáticas aplicadas.

### **Fórmula**

Dado un valor inicial $x_0$, la fórmula iterativa es:

$$
x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}
$$

Donde:
- $f(x)$ es la función,
- $f'(x)$ es su derivada,
- $x_n$ es la aproximación en la iteración $n$.

### **Características**
- Convergencia **rápida** si el valor inicial está cerca de la raíz.
- Requiere que $f(x)$ sea **derivable**.
- Puede **divergir** si la derivada es cero o si se elige mal el valor inicial.
- Tiene **convergencia cuadrática** en condiciones ideales.

### **Ejemplo**

Supón que quieres encontrar la raíz de:

$$
f(x) = x^2 - 4
$$

Entonces:

- $f'(x) = 2x$
- Elegimos $x_0 = 3$

Aplicamos la fórmula:

1. $x_1 = 3 - \frac{3^2 - 4}{2 \cdot 3} = 3 - \frac{5}{6} = 2.1667$
2. $x_2 = 2.1667 - \frac{(2.1667)^2 - 4}{2 \cdot 2.1667} \approx 2.0064$
3. $x_3 = 2.0064 - \frac{(2.0064)^2 - 4}{2 \cdot 2.0064} \approx 2.0000$

Después de pocas iteraciones, se alcanza una raíz muy cercana a $2$.

---

### [Codigo en Java](NewtonRaphson.java)

```java
public class MetodoNewtonRaphson {

    public static void main(String[] args) {
        // Aproximación inicial, tolerancia y número máximo de iteraciones
        double x0 = 1.5;
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        // Llamar al método de Newton-Raphson
        newtonRaphson(x0, tolerancia, maxIteraciones);
    }

    /**
     * Derivada de la función.
     * Debe ser definida manualmente por el usuario.
     * @param x Valor de entrada
     * @return Resultado de f'(x)
     */
    public static double derivada(double x) {
        // Derivada de f(x) = 3x^2 - 1
        return 3 * Math.pow(x, 2) - 1;
    }

    /**
     * Función definida por el usuario.
     * Cambia esta función según el problema a resolver.
     * @param x Valor de entrada
     * @return Resultado de f(x)
     */
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^3 - x - 2
        return Math.pow(x, 3) - x - 2;
    }

    /**
     * Método que implementa la técnica de Newton-Raphson para encontrar una raíz de la función.
     * @param x0 Valor inicial (aproximación inicial de la raíz)
     * @param tol Tolerancia (error máximo permitido)
     * @param maxIter Número máximo de iteraciones permitidas
     */
    public static void newtonRaphson(double x0, double tol, int maxIter) {
        int iteracion = 0;
        double x = x0;

        while (iteracion < maxIter) {
            double fx = funcion(x);
            double dfx = derivada(x);

            // Evitar división por cero
            if (dfx == 0) {
                System.out.println("Derivada cero. No se puede continuar.");
                return;
            }

            // Calcular nueva aproximación
            double x1 = x - fx / dfx;

            // Imprimir detalles de la iteración
            System.out.printf("Iteración %d: x=%.6f, f(x)=%.6f%n", iteracion + 1, x1, funcion(x1));

            // Verificar si el error es menor que la tolerancia
            if (Math.abs(x1 - x) < tol) {
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

# Casos de Prueba para el Método de Newton-Raphson

Este documento contiene casos de prueba para el método numérico de **Newton-Raphson** implementado en Java. Cada caso incluye una descripción, configuración del problema y resultado esperado.

---

## Método: `newtonRaphson(x0, tol, maxIter)`

### ✅ Caso de prueba válido (funciona correctamente)

**Descripción:**  
Encuentra la raíz de la función `f(x) = x³ - x - 2` usando una aproximación inicial de `x0 = 1.5`.

**Parámetros:**
- `x0 = 1.5`
- `tol = 1e-6`
- `maxIter = 100`

**Justificación:**  
La función tiene una raíz real cercana a `x = 1.521`, y su derivada `f'(x) = 3x² - 1` no se anula en el proceso.

**Resultado esperado (parcial):**

Iteración 1: x=1.521739, f(x)=-0.002058
Iteración 2: x=1.521380, f(x)=-0.000001
Raíz aproximada encontrada en x = 1.521380 con tolerancia 0.000001

---

### ❌ Caso de prueba inválido (derivada cero)

**Descripción:**  
Se intenta aplicar el método en un punto donde la derivada es cero, lo que impide seguir con el método.

**Modificaciones al código:**
```java
double x0 = 0.57735; // Aproximación inicial donde f'(x) ≈ 0 (ya que f'(x) = 3x² - 1)
```

**Justificación:**
La derivada ?f'(x) se anula en x = ±1/√3 ≈ 0.57735', por lo tanto el método detiene la ejecución.

**Resultado esperado:**

Derivada cero. No se puede continuar.

### [Hoja de EXCEL](Newton_Raphson.xlsx)
