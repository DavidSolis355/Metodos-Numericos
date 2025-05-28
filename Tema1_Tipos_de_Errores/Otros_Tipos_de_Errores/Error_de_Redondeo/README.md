## **Error de Redondeo**

### **Definición**
El **error de redondeo** es la diferencia entre el valor numérico exacto y su representación aproximada debido a la limitación de cifras significativas que puede manejar un sistema de cómputo. Ocurre cuando se recortan o ajustan decimales para adaptarse al formato del sistema.

### **¿Para qué se usa?**
- Para analizar la precisión de resultados computacionales.
- Para entender cómo afecta la limitación de cifras significativas al resultado final.
- Para evaluar si un algoritmo es sensible a pequeños errores en los datos.

### **Fórmula**

Si:
- \( x \) es el valor exacto,
- \( x~ \) es el valor redondeado,

Entonces el error de redondeo es:

$$
\text{Error de Redondeo} = |x - \tilde{x}|
$$

### **Características**
- Es inevitable en los sistemas digitales debido a la representación finita de números reales.
- Se acumula en algoritmos con muchas operaciones.
- Es más notorio cuando se trabaja con números muy pequeños o muy grandes.
- Puede afectar la estabilidad de algunos métodos numéricos.

### **Ejemplo**

Supón que el número exacto es:

$$
x = 3.14159265
$$

Y lo redondeas a 4 cifras decimales:

$$
\tilde{x} = 3.1416
$$

Entonces el error de redondeo es:

$$
|3.14159265 - 3.1416| = 0.00000735
$$

Este pequeño error puede acumularse si se usa muchas veces en un cálculo.

---

### [Codigo en Java](ErrorRedondeo.java)

```java

// Clase que demuestra cómo calcular el error de redondeo al limitar decimales
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ErrorRedondeo {

     /**
     * Redondea un número decimal al número de decimales especificado.
     * Utiliza BigDecimal para asegurar un redondeo preciso y controlado.
     *
     * @param valor      número original a redondear
     * @param decimales  cantidad de decimales a conservar
     * @return           valor redondeado como double
     */
    public static double redondear(double valor, int decimales) {
        BigDecimal bd = new BigDecimal(valor);
        bd = bd.setScale(decimales, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

     /**
     * Calcula el error de redondeo como la diferencia absoluta
     * entre el valor original y el valor redondeado.
     *
     * @param valorOriginal    el valor antes del redondeo
     * @param valorRedondeado  el valor después del redondeo
     * @return                 el error de redondeo
     */
    public static double calcularErrorRedondeo(double valorOriginal, double valorRedondeado) {
        return Math.abs(valorOriginal - valorRedondeado);
    }

    public static void main(String[] args) {

        // Valor original que será redondeado
        double valorOriginal = 3.14159265;

        // Número de decimales deseados
        int decimales = 4;

        // Se redondea el valor original
        double valorRedondeado = redondear(valorOriginal, decimales);

        // Se calcula el error causado por el redondeo
        double errorRedondeo = calcularErrorRedondeo(valorOriginal, valorRedondeado);

        // Se muestran los resultados en consola
        System.out.println("Valor original: " + valorOriginal);
        System.out.println("Valor redondeado: " + valorRedondeado);
        System.out.println("Error de Redondeo: " + errorRedondeo);
    }
}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de Prueba – Error de Redondeo

Este documento muestra tres casos de prueba para verificar el cálculo del error por redondeo usando `BigDecimal` en Java.

- ✅ 2 casos correctos
- ❌ 1 caso con entrada inválida (decimales negativos)

---

## ✅ Caso de Prueba 1 – Redondeo a 4 decimales

**Entrada:**

- `valorOriginal = 3.14159265`
- `decimales = 4`

**Resultado Esperado:**

Valor redondeado: `3.1416`  
Error de redondeo: `|3.14159265 - 3.1416| = 7.35E-6`

**Resultado de Consola:**

Valor original: 3.14159265
Valor redondeado: 3.1416
Error de Redondeo: 7.349999999970034E-6

---

## ✅ Caso de Prueba 2 – Redondeo a 2 decimales

**Entrada:**

- `valorOriginal = 2.7182818`
- `decimales = 2`

**Resultado Esperado:**

Valor redondeado: `2.72`  
Error de redondeo: `|2.7182818 - 2.72| = 0.0017182`

**Resultado de Consola:**

Valor original: 2.7182818
Valor redondeado: 2.72
Error de Redondeo: 0.001718199999999927

---

## ❌ Caso de Prueba 3 – Error por decimales negativos

**Entrada:**

- `valorOriginal = 1.2345`
- `decimales = -2`

**Descripción:**

El uso de una escala negativa en `BigDecimal.setScale()` lanza una excepción.

**Resultado Esperado:**

Lanzará una excepción: `java.lang.ArithmeticException` o `java.lang.IllegalArgumentException`

**Resultado de Consola:**

Exception in thread "main" java.lang.IllegalArgumentException: Scale must be non-negative
at java.math.BigDecimal.setScale(BigDecimal.java:...)