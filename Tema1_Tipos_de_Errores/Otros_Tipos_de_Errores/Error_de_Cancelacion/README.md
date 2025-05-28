## **Cancelación**

### **Definición**
La **cancelación** es un fenómeno numérico que ocurre cuando se restan dos números muy cercanos entre sí, lo que puede provocar una gran pérdida de cifras significativas y afectar la precisión del resultado.

### **¿Para qué se usa (o por qué es importante)?**
- Es importante detectarla para evitar errores graves en cálculos numéricos.
- Se analiza al implementar algoritmos que involucren restas de números similares.
- Ayuda a elegir métodos alternativos más estables y precisos.

### **¿Qué causa la cancelación?**
Cuando se realiza una resta entre dos valores que son casi iguales, la parte significativa del resultado puede perderse debido a limitaciones del número de dígitos que puede representar una computadora.

### **Explicación con fórmula**

Supón que tienes dos valores muy cercanos:

$$
a = 123456.789 \quad \text{y} \quad b = 123456.780
$$

Entonces:

$$
a - b = 123456.789 - 123456.780 = 0.009
$$

Aunque ambos números tienen 9 cifras significativas, el resultado solo tiene una, lo cual implica pérdida de precisión.

### **Características**
- Ocurre comúnmente en operaciones de resta entre números grandes con diferencias pequeñas.
- Aumenta el **error relativo** del resultado.
- Puede deteriorar la estabilidad numérica de un algoritmo.
- No hay una fórmula directa para evitarla, pero puede mitigarse reestructurando el cálculo.

### **Ejemplo**

Supón que quieres evaluar la siguiente expresión:

$$
f(x) = \frac{1 - \cos(x)}{x^2}
$$

Para valores pequeños de \( x \), como \( x = 0.0001 \), el resultado de \( 1 - \cos(x) \) implica una cancelación, ya que \( \cos(x) \) es muy cercano a 1. En lugar de usar esa forma, se puede usar una equivalente más estable:

$$
f(x) = \frac{2\sin^2(x/2)}{x^2}
$$

Esta versión reduce el efecto de la cancelación.

---

### [Codigo en Java](ErrorCancelacion.java)

```java

// Clase que ejemplifica el error por cancelación en operaciones numéricas
public class ErrorCancelacion {

    /**
     * Calcula y muestra el error por cancelación al restar dos números muy cercanos.
     * Se simula la pérdida de precisión al realizar la operación usando float en lugar de double.
     *
     * @param a  primer número (mayor)
     * @param b  segundo número (ligeramente menor que 'a')
     */
    public static void calcularCancelacion(double a, double b) {

        // Resultado exacto utilizando doble precisión (double)
        double resultadoExacto = a - b;

        // Resultado exacto utilizando doble precisión (double)
        double resultadoAproximado = (float) a - (float) b; // Simulamos pérdida de precisión

        // Cálculo del error por cancelación como la diferencia entre ambos resultados
        double errorCancelacion = Math.abs(resultadoExacto - resultadoAproximado);

        // Impresión de los resultados para comparar
        System.out.println("Resultado Exacto (double): " + resultadoExacto);
        System.out.println("Resultado Aproximado (float): " + resultadoAproximado);
        System.out.println("Error por Cancelación: " + errorCancelacion);
    }

    public static void main(String[] args) {

        // Se definen dos números muy cercanos para provocar cancelación
        double a = 1234567.89;
        double b = 1234567.88;

        // Se llama al método que calcula e imprime el error por cancelación
        calcularCancelacion(a, b);

    }

}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de Prueba – Error por Cancelación

Este documento contiene tres casos de prueba para comprobar cómo afecta la cancelación numérica al usar `float` en lugar de `double`.

- ✅ 2 casos válidos que ilustran el error.
- ❌ 1 caso con comportamiento inesperado.

---

## Caso de Prueba 1 – Números muy cercanos

**Entrada:**

- `a = 1234567.89`
- `b = 1234567.88`

**Descripción:**

Simula pérdida de precisión al restar números cercanos usando float.

**Resultado Esperado:**

- Resultado Exacto ≈ 0.01
- Resultado Aproximado (float) ≠ 0.01 (menor precisión)
- Error Cancelación ≠ 0

**Resultado de Consola:**

Resultado Exacto (double): 0.010000000009313226
Resultado Aproximado (float): 0.0
Error por Cancelación: 0.010000000009313226

---

## Caso de Prueba 2 – Diferencia aún más pequeña

**Entrada:**

- `a = 1000000.000001`
- `b = 1000000.000000`

**Descripción:**

Diferencia extremadamente pequeña provoca una mayor pérdida de precisión al convertir a float.

**Resultado Esperado:**

- Resultado Exacto ≈ 0.000001
- Resultado Aproximado (float) = 0.0
- Error Cancelación ≈ 0.000001

**Resultado de Consola:**

Resultado Exacto (double): 1.00000761449337E-6
Resultado Aproximado (float): 0.0
Error por Cancelación: 1.00000761449337E-6

---

## Caso de Prueba 3 – Entrada inválida (NaN)

**Entrada:**

- `a = Double.NaN`
- `b = 1234.56`

**Descripción:**

Ingresar un valor `NaN` (Not a Number) como entrada para `a` provoca resultados indefinidos.

**Resultado Esperado:**

- Resultado Exacto = NaN
- Resultado Aproximado = NaN
- Error Cancelación = NaN

**Resultado de Consola:**

Main.java:38: error: class expected
        double a = double.NaN;
                          ^
1 error

