## **Error de Convergencia**

### **Definición**
El **error de convergencia** se refiere a la diferencia entre la solución exacta y la solución obtenida por un método iterativo después de un número determinado de iteraciones. Este error tiende a disminuir conforme el método se acerca a la solución correcta.

### **¿Para qué se usa?**
- Para medir el grado de aproximación de un método iterativo a la solución real.
- Para decidir cuándo detener un algoritmo numérico (criterio de paro).
- Para analizar la velocidad con la que un método alcanza resultados precisos.

### **Fórmula**

Si:
- \( x \) es el valor exacto,
- \( x_n \) es el valor aproximado en la iteración \( n \),

Entonces el error de convergencia es:

$$
\text{Error de Convergencia} = |x - x_n|
$$

Cuando no se conoce el valor exacto, se puede usar la diferencia entre dos iteraciones consecutivas:

$$
\text{Error de Convergencia Aproximado} = |x_n - x_{n-1}|
$$

### **Características**
- Disminuye conforme aumenta el número de iteraciones (si el método converge).
- Si no disminuye, el método **no converge** o es inestable.
- Permite establecer un **criterio de tolerancia** para detener iteraciones.
- Está presente en métodos como bisección, Newton-Raphson, punto fijo, etc.

### **Ejemplo**

Supón que estás usando el método de Newton-Raphson para encontrar la raíz de una función, y en la iteración 4 tienes:


- \( x_3 = 1.5000 \)
- \( x_4 = 1.4975 \)


Entonces el error de convergencia aproximado es:

$$
|x_4 - x_3| = |1.4975 - 1.5000| = 0.0025
$$

Si se define una tolerancia de 0.001, todavía se necesitan más iteraciones.

---

### [Codigo en Java](ErrorConvergencia.java)

```java

// Clase que permite calcular el error de convergencia entre iteraciones numéricas
public class ErrorConvergencia {

     /**
     * Calcula el error de convergencia entre dos iteraciones consecutivas.
     * Este error se usa comúnmente en métodos numéricos para determinar si se ha alcanzado una solución aceptable.
     *
     * @param iteracionActual     valor actual de la iteración
     * @param iteracionAnterior   valor anterior de la iteración
     * @return                    diferencia absoluta entre ambas iteraciones
     */
    public static double calcularErrorConvergencia(double iteracionActual, double iteracionAnterior) {
        return Math.abs(iteracionActual - iteracionAnterior);
    }

    public static void main(String[] args) {

        // Valor de la iteración anterior (por ejemplo, xₙ₋₁)
        double xAnterior = 1.5000;

        // Valor de la iteración actual (por ejemplo, xₙ)
        double xActual = 1.4975;

        // Se calcula el error de convergencia entre ambas iteraciones
        double errorConvergencia = calcularErrorConvergencia(xActual, xAnterior);

        // Se imprime el resultado del error de convergencia
        System.out.println("Error de Convergencia: " + errorConvergencia);

    }

}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de Prueba – Error de Convergencia

Este documento contiene tres casos de prueba para comprobar el cálculo del error de convergencia entre dos iteraciones numéricas consecutivas.

- ✅ 2 casos válidos que ilustran convergencia.
- ❌ 1 caso con comportamiento extremo (Infinity).

---

## ✅ Caso de Prueba 1 – Iteraciones cercanas

**Entrada:**

- `iteracionAnterior = 1.5000`
- `iteracionActual = 1.4975`

**Resultado Esperado:**

Error de convergencia: `|1.4975 - 1.5000| = 0.0025`

**Resultado de Consola:**

Error de Convergencia: 0.0025000000000000577

---

## ✅ Caso de Prueba 2 – Mayor diferencia

**Entrada:**

- `iteracionAnterior = 2.0000`
- `iteracionActual = 1.0000`

**Resultado Esperado:**

Error de convergencia: `|1.0000 - 2.0000| = 1.0`

**Resultado de Consola:**

Error de Convergencia: 1.0

---

## ❌ Caso de Prueba 3 – Valores extremos

**Entrada:**

- `iteracionAnterior = Double.MAX_VALUE`
- `iteracionActual = -Double.MAX_VALUE`

**Descripción:**

Cálculo de la diferencia entre valores máximos opuestos provoca un resultado de infinito.

**Resultado Esperado:**

Diferencia: `|(-1.7976931348623157E308) - (1.7976931348623157E308)|` = ∞

**Resultado de Consola:**

Error de Convergencia: Infinity