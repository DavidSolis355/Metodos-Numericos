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


---

## ✅ Caso de Prueba 2 – Mayor diferencia

**Entrada:**

- `iteracionAnterior = 2.0000`
- `iteracionActual = 1.0000`

**Resultado Esperado:**

Error de convergencia: `|1.0000 - 2.0000| = 1.0`

**Resultado de Consola:**


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

