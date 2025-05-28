## **Error de Truncamiento**

### **Definición**
El **error de truncamiento** es el error que ocurre cuando se detiene un proceso de cálculo de forma prematura, es decir, cuando se limita el número de términos en una serie infinita o el número de iteraciones en un algoritmo. Este tipo de error se produce cuando un valor se aproxima a un número real, pero se omiten términos adicionales que podrían mejorar la aproximación.

### **¿Para qué se usa?**
- Se usa para medir la precisión de los algoritmos que aproximan soluciones a problemas continuos (como en series de Taylor o integrales numéricas).
- Para analizar el impacto de truncar operaciones o procesos iterativos en los resultados finales.
- Para comparar diferentes métodos de aproximación y determinar cuán precisos son.

### **Fórmula**

En un proceso de aproximación de una función \( f(x) \) mediante una serie infinita, el error de truncamiento es la diferencia entre el valor exacto y la aproximación después de truncar la serie:

$$
\text{Error de Truncamiento} = |f(x) - P_n(x)|
$$

Donde:
- \( f(x) \) es el valor exacto,
- \( P_n(x) \) es la aproximación obtenida truncando la serie después del \( n \)-ésimo término.

### **Características**
- Es más grande cuando el número de términos truncados es alto.
- Es inherente a métodos que utilizan series de expansión, como la serie de Taylor.
- A menudo se puede reducir aumentando el número de términos en la serie o aumentando el número de iteraciones de un algoritmo.

### **Ejemplo**

Supón que aproximas \( e^x \) usando la serie de Taylor truncada en el tercer término:

$$
e^x \approx 1 + x + \frac{x^2}{2}
$$

Para \( x = 1 \), la aproximación es:

$$
e^1 \approx 1 + 1 + \frac{1^2}{2} = 2.5
$$

El valor exacto es:

$$
e^1 = 2.718281828
$$

Entonces, el error de truncamiento es:

$$
|2.718281828 - 2.5| = 0.218281828
$$

Este es el error de truncamiento debido a truncar la serie después del segundo término.

---

### [Codigo en Java](ErrorTruncamiento.java)

```java

// Clase que ejemplifica cómo calcular el error de truncamiento al limitar decimales sin redondear
public class ErrorTruncamiento {

    /**
     * Trunca un número decimal al número de decimales especificado sin redondear.
     * Utiliza la función Math.floor para eliminar los decimales restantes.
     *
     * @param valor      número original a truncar
     * @param decimales  cantidad de decimales a conservar
     * @return           valor truncado como double
     */
    public static double truncar(double valor, int decimales) {
        double factor = Math.pow(10, decimales); // Calcula el factor de escala según los decimales deseados
        return Math.floor(valor * factor) / factor; // Aplica truncamiento eliminando decimales extra
    }

     /**
     * Calcula el error de truncamiento como la diferencia absoluta
     * entre el valor original y el truncado.
     *
     * @param valorOriginal   el valor antes del truncamiento
     * @param valorTruncado   el valor después del truncamiento
     * @return                el error de truncamiento
     */
    public static double calcularErrorTruncamiento(double valorOriginal, double valorTruncado) {
        return Math.abs(valorOriginal - valorTruncado);
    }

    public static void main(String[] args) {

        // Valor original a truncar
        double valorOriginal = 3.14159265;

        // Número de decimales que se desea conservar
        int decimales = 4;

        // Se trunca el valor original
        double valorTruncado = truncar(valorOriginal, decimales);

        // Se calcula el error ocasionado por el truncamiento
        double errorTruncamiento = calcularErrorTruncamiento(valorOriginal, valorTruncado);

        // Se imprimen los resultados para comparación
        System.out.println("Valor original: " + valorOriginal);
        System.out.println("Valor truncado: " + valorTruncado);
        System.out.println("Error de Truncamiento: " + errorTruncamiento);
    }
}


```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de Prueba – Error de Truncamiento

Este documento contiene tres casos de prueba para evaluar el funcionamiento del truncamiento de decimales sin redondear, junto con el cálculo del error de truncamiento.

- ✅ 2 casos correctos
- ❌ 1 caso con entrada inválida (decimales negativos)

---

## ✅ Caso de Prueba 1 – Truncar a 4 decimales

**Entrada:**

- `valorOriginal = 3.14159265`
- `decimales = 4`

**Resultado Esperado:**

Valor truncado: `3.1415`  
Error: `|3.14159265 - 3.1415| = 9.265e-5`

**Resultado de Consola:**

Valor original: 3.14159265
Valor truncado: 3.1415
Error de Truncamiento: 9.265000000005342E-5

---

## ✅ Caso de Prueba 2 – Truncar a 2 decimales

**Entrada:**

- `valorOriginal = 2.7182818`
- `decimales = 2`

**Resultado Esperado:**

Valor truncado: `2.71`  
Error: `|2.7182818 - 2.71| = 0.0082818`

**Resultado de Consola:**

Valor original: 2.7182818
Valor truncado: 2.71
Error de Truncamiento: 0.008281799999999885

---

## ❌ Caso de Prueba 3 – Error con decimales negativos

**Entrada:**

- `valorOriginal = 1.2345`
- `decimales = -3`

**Descripción:**

Los decimales negativos generan un `factor = 10^(-3) = 0.001`, provocando resultados inesperados o comportamiento inválido en truncamiento.

**Resultado de Consola:**

Valor original: 1.2345
Valor truncado: 1000.0
Error de Truncamiento: 998.7655