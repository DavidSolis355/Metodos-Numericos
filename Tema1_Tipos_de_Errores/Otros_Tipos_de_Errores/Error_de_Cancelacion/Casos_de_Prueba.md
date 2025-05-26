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

