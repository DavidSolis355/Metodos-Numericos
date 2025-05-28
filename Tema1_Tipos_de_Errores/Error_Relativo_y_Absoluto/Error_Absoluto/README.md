## Error Absoluto

### Definición
El **error absoluto** es la diferencia en valor absoluto entre el valor verdadero y el valor aproximado. Nos indica cuánto se ha desviado la estimación respecto al valor real.

### ¿Para qué se usa?
Se usa para:
- Medir la precisión de una estimación o cálculo.
- Evaluar la diferencia real (en unidades) entre un valor exacto y uno aproximado.
- Determinar la magnitud del error sin considerar su dirección (positivo o negativo).

### Fórmula

Si se tiene:
- Valor verdadero: `x`
- Valor aproximado: `x_aprox`

Entonces el error absoluto se calcula como:

$$
\text{Error Absoluto} = \left| x - x_{\text{aprox}} \right|
$$

### Características
- Siempre es un número positivo o cero.
- Se expresa en las mismas unidades que los valores medidos.
- No es útil para comparar errores entre valores de diferentes magnitudes.
- Es una medida directa de la discrepancia entre el valor real y el estimado.

### Ejemplo

Si el valor exacto es `4.000` y el valor aproximado es `3.920`, entonces:

$$
\text{Error Absoluto} = \left| 4.000 - 3.920 \right| = 0.080
$$

Por lo tanto, el resultado tiene un error absoluto de **0.080 unidades**.

---

### [Codigo en Java](ErrorAbsoluto.java)

```java
    // Clase que contiene métodos para calcular el error absoluto
    public class ErrorAbsoluto {

    /**
     * Calcula el error absoluto entre un valor verdadero y un valor aproximado.
     * El error absoluto se define como el valor absoluto de la diferencia entre ambos valores.
     *
     * @param valorVerdadero   el valor real o exacto
     * @param valorAproximado  el valor estimado o calculado
     * @return                 el error absoluto
     */
        public static double calcularErrorAbsoluto(double valorVerdadero, double valorAproximado) {
            return Math.abs(valorVerdadero - valorAproximado);
        }

        public static void main(String[] args) {

            // Valor verdadero del dato (por ejemplo, un resultado teórico)
            double valorVerdadero = 4.000;

            // Valor aproximado obtenido (por ejemplo, de una medición o cálculo)
            double valorAproximado = 3.920;

            // Se calcula el error absoluto entre los dos valores
            double errorAbsoluto = calcularErrorAbsoluto(valorVerdadero, valorAproximado);

            // Se imprime el resultado del error absoluto en consola
            System.out.println("Error Absoluto: " + errorAbsoluto);
        }
    }
```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de Prueba – Método de Error Absoluto

Este archivo contiene tres casos de prueba para verificar el funcionamiento del método `calcularErrorAbsoluto()`:

- **2 casos exitosos (funcionan correctamente).**
- **1 caso con error (entrada inválida o comportamiento inesperado).**

---

## Caso de Prueba 1 – Diferencia positiva

**Entrada:**

- Valor verdadero: `10.5`
- Valor aproximado: `8.2`

**Descripción:**

Calcula la diferencia entre dos valores numéricos donde el valor aproximado es menor al valor verdadero.

**Resultado Esperado:**

`2.3`

**Resultado de Consola:**

Error Absoluto: 2.3000000000000007

---

## Caso de Prueba 2 – Valores iguales (sin error)

**Entrada:**

- Valor verdadero: `3.1416`
- Valor aproximado: `3.1416`

**Descripción:**

Ambos valores son idénticos, por lo tanto, el error absoluto debe ser `0`.

**Resultado Esperado:**

`0.0`

**Resultado de Consola:**

Error Absoluto: 0.0

---

## Caso de Prueba 3 – Entrada no numérica (error en ejecución)

**Entrada:**

- Valor verdadero: `"pi"` (String)
- Valor aproximado: `3.14`

**Descripción:**

El valor verdadero se proporciona como una cadena de texto en lugar de un número, lo que debería generar un error de compilación.

**Resultado Esperado:**

Error de compilación: *incompatible types: String cannot be converted to double*

**Resultado de Consola:**

Main.java:26: error: cannot find symbol
        double valorVerdadero = pi;
                                ^
  symbol:   variable pi
  location: class Main
1 error