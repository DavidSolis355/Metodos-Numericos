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

