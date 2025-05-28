## Error Relativo

### Definición
El **error relativo** es una medida que indica qué tan grande es el error en comparación con el valor verdadero o exacto. Se expresa como una fracción o porcentaje y ayuda a entender la precisión de un resultado numérico.

### ¿Para qué se usa?
Se utiliza para:
- Comparar errores entre diferentes mediciones.
- Evaluar la precisión de los métodos numéricos.
- Determinar la validez de un resultado aproximado.

### Fórmula

Si se tiene:
- Valor verdadero: `x`
- Valor aproximado: `x_aprox`

Entonces el error relativo se calcula como:

$$
\text{Error Relativo} = \left| \frac{x - x_{\text{aprox}}}{x} \right|
$$

También puede expresarse como porcentaje:

$$
\text{Error Relativo (\%)} = \left| \frac{x - x_{\text{aprox}}}{x} \right| \times 100
$$

### Características
- No depende de las unidades del valor medido.
- Es útil cuando se comparan errores de diferentes magnitudes.
- Es más informativo que el error absoluto cuando el valor exacto es muy grande o muy pequeño.
- Siempre se expresa como valor positivo.

### Ejemplo

Supón que el valor verdadero de una raíz cuadrada es `4.000` y el valor aproximado obtenido con un método numérico es `3.920`.

$$
\text{Error Relativo} = \left| \frac{4.000 - 3.920}{4.000} \right| = \left| \frac{0.080}{4.000} \right| = 0.02
$$

$$
\text{Error Relativo (\%)} = 0.02 \times 100 = 2\%
$$

Por lo tanto, el resultado tiene un error relativo del **2%**.

---

### [Codigo en Java](ErrorRelativo.java)

```java

// Clase que contiene métodos para calcular el error relativo
public class ErrorRelativo {

    /**
     * Calcula el error relativo entre un valor verdadero y uno aproximado.
     * El error relativo se define como el valor absoluto de la diferencia
     * entre ambos valores, dividido entre el valor verdadero.
     *
     * @param valorVerdadero   el valor real o exacto
     * @param valorAproximado  el valor estimado o calculado
     * @return                 el error relativo (valor entre 0 y 1)
     */
    public static double calcularErrorRelativo(double valorVerdadero, double valorAproximado) {
        return Math.abs((valorVerdadero - valorAproximado) / valorVerdadero);
    }

    public static void main(String[] args) {
        // Valor verdadero del dato (por ejemplo, un resultado teórico)
        double valorVerdadero = 4.000;

        // Valor aproximado obtenido (por ejemplo, de una medición o cálculo)
        double valorAproximado = 3.920;

        // Se calcula el error relativo entre los dos valores
        double errorRelativo = calcularErrorRelativo(valorVerdadero, valorAproximado);

        // Se imprime el error relativo como valor decimal
        System.out.println("Error Relativo: " + errorRelativo);

        // Se imprime el error relativo como porcentaje
        System.out.println("Error Relativo (%): " + (errorRelativo * 100) + "%");
    }

}

```

### [Caso de Prueba](Casos_de_Prueba) 

# Casos de Prueba – Método de Error Relativo

Este archivo contiene tres casos de prueba para verificar el funcionamiento del método `calcularErrorRelativo()`:

- ✅ 2 casos válidos.
- ❌ 1 caso que provoca un error.

---

## Caso de Prueba 1 – Diferencia pequeña

**Entrada:**

- Valor verdadero: `100.0`
- Valor aproximado: `99.5`

**Descripción:**

El valor aproximado es muy cercano al verdadero. El error debe ser pequeño.

**Resultado Esperado:**

`0.005` o `0.5%`

**Resultado de Consola:**

Error Relativo: 0.005
Error Relativo (%): 0.5%

---

## Caso de Prueba 2 – Error total (valor aproximado = 0)

**Entrada:**

- Valor verdadero: `50.0`
- Valor aproximado: `0.0`

**Descripción:**

El valor aproximado es cero. El error relativo será `1.0` o `100%`.

**Resultado Esperado:**

`1.0` o `100.0%`

**Resultado de Consola:**

Error Relativo: 1.0
Error Relativo (%): 100.0%


---

## ❌ Caso de Prueba 3 – División por cero

**Entrada:**

- Valor verdadero: `0.0`
- Valor aproximado: `1.5`

**Descripción:**

El valor verdadero es cero, lo que provocará una división por cero en el cálculo del error relativo.

**Resultado Esperado:**

Excepción o `Infinity` según la JVM.

**Resultado de Consola:**

Error Relativo: Infinity
Error Relativo (%): Infinity%

