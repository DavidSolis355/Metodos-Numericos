### **Método de Bisección**

### **Definición**
El **método de bisección** es un algoritmo numérico utilizado para encontrar raíces reales de funciones continuas. Se basa en el teorema del valor intermedio, el cual garantiza que si una función cambia de signo en un intervalo, entonces existe al menos una raíz dentro de ese intervalo.

### **¿Para qué se usa?**
- Para **encontrar soluciones (raíces)** reales de ecuaciones no lineales.
- Es útil cuando se tiene un **intervalo conocido** donde la función cambia de signo.
- Sirve como **método inicial confiable** en combinación con otros métodos más rápidos.

### **Fórmula**

Si:

- $f(a) \cdot f(b) < 0$, hay una raíz en $[a, b]$
- $c = \frac{a + b}{2}$ es el punto medio

Entonces:

- Si $f(a) \cdot f(c) < 0$, la raíz está en $[a, c]$
- Si $f(c) \cdot f(b) < 0$, la raíz está en $[c, b]$

Se repite el proceso dividiendo el intervalo sucesivamente hasta que se cumple una **tolerancia** deseada.

### **Características**
- Es un método **lento pero seguro**.
- Siempre converge si $f$ es continua y $f(a) \cdot f(b) < 0$.
- No requiere derivadas ni conocimientos adicionales de la función.
- La **convergencia es lineal**.
- Funciona bien para encontrar **una única raíz**, pero no todas las raíces.

### **Ejemplo**

Supón que quieres encontrar una raíz de la función:

$$
f(x) = x^2 - 4
$$

Sabes que:
- $f(1) = -3$
- $f(3) = 5$

Entonces $f(1) \cdot f(3) < 0$, por lo tanto hay una raíz en $[1, 3]$. Aplicando la fórmula:

1. $c_1 = \frac{1 + 3}{2} = 2$
2. $f(2) = 0$

Se encontró la raíz exacta en la primera iteración, $x = 2$. En otros casos, se necesita continuar iterando.

---

### [Codigo en Java](Biseccion.java)

```java
public class Biseccion {

    public static void main(String[] args) {
        // Definir intervalo [a, b], tolerancia y número máximo de iteraciones
        double a = 1;
        double b = 2;
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        // Llamar al método de bisección
        biseccion(a, b, tolerancia, maxIteraciones);
    }

    /**
     * Define la función f(x) cuyo valor se desea encontrar igual a cero.
     * Aquí puedes cambiar la función según tu problema específico.
     * @param x Valor de entrada
     * @return Resultado de f(x)
     */
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^3 - x - 2
        return Math.pow(x, 3) - x - 2;
    }

    /**
     * Método que implementa la técnica de Bisección para encontrar la raíz de una función.
     * @param a Límite inferior del intervalo
     * @param b Límite superior del intervalo
     * @param tol Tolerancia (error máximo permitido)
     * @param maxIter Número máximo de iteraciones permitidas
     */
    public static void biseccion(double a, double b, double tol, int maxIter) {
        double fa = funcion(a);
        double fb = funcion(b);

        // Verificar que exista al menos una raíz en el intervalo [a, b]
        if (fa * fb >= 0) {
            System.out.println("No se puede aplicar el método de bisección: f(a) * f(b) ≥ 0");
            return;
        }

        int iteracion = 0;
        double c = a;

        // Repetir hasta alcanzar la tolerancia o agotar el número de iteraciones
        while ((b - a) / 2 > tol && iteracion < maxIter) {
            c = (a + b) / 2; // Calcular el punto medio
            double fc = funcion(c);

            // Imprimir detalles de la iteración actual
            System.out.printf("Iteración %d: a=%.6f, b=%.6f, c=%.6f, f(c)=%.6f%n", iteracion + 1, a, b, c, fc);

            // Verificar si se encontró la raíz exacta
            if (fc == 0.0) {
                break;
            }

            // Reemplazar el extremo del intervalo que mantiene el cambio de signo
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }

            iteracion++;
        }

        // Imprimir resultado final
        System.out.printf("Raíz aproximada encontrada en x = %.6f con tolerancia %.6f%n", c, tol);
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

### Casos de Prueba para el Método de Bisección

Este documento contiene casos de prueba para el método numérico de **bisección** implementado en Java. Cada caso incluye una breve descripción, configuración del problema y resultado esperado.

---

### ✅ Caso de prueba válido (funciona correctamente)

**Descripción:**  
Encuentra la raíz de la función `f(x) = x³ - x - 2` en el intervalo `[1, 2]`.

**Parámetros:**
- `a = 1`
- `b = 2`
- `tol = 1e-6`
- `maxIter = 100`

**Justificación:**  
`f(1) = -2`, `f(2) = 4`, como `f(a) * f(b) < 0`, existe al menos una raíz en el intervalo.

**Resultado esperado (parcial):**

Iteración 1: a=1.000000, b=2.000000, c=1.500000, f(c)=-0.125000
...
Raíz aproximada encontrada en x = 1.521379 con tolerancia 0.000001

---

### ❌ Caso de prueba inválido (no debe funcionar)

**Descripción:**  
Se intenta aplicar el método en un intervalo donde `f(a)` y `f(b)` tienen el mismo signo.

**Modificaciones al código:**
```java
double a = 2;
double b = 3;
```

**Justificación:**
'f(2) = 4, f(3) = 22, como f(a) * f(b) > 0', no hay cambio de signo, por lo tanto no se puede aplicar el método.

**Resultado esperado:**

No se puede aplicar el método de bisección: f(a) * f(b) ≥ 0

### [Hoja de EXCEL](Biseccion.xlsx)