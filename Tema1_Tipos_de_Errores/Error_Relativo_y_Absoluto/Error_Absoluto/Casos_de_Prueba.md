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



---

## ✅ Caso de Prueba 2 – Valores iguales (sin error)

**Entrada:**

- Valor verdadero: `3.1416`
- Valor aproximado: `3.1416`

**Descripción:**

Ambos valores son idénticos, por lo tanto, el error absoluto debe ser `0`.

**Resultado Esperado:**

`0.0`

**Resultado de Consola:**



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
