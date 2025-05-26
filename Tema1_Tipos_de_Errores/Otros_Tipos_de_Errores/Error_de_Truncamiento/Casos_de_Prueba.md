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


---

## ✅ Caso de Prueba 2 – Truncar a 2 decimales

**Entrada:**

- `valorOriginal = 2.7182818`
- `decimales = 2`

**Resultado Esperado:**

Valor truncado: `2.71`  
Error: `|2.7182818 - 2.71| = 0.0082818`

**Resultado de Consola:**


---

## ❌ Caso de Prueba 3 – Error con decimales negativos

**Entrada:**

- `valorOriginal = 1.2345`
- `decimales = -3`

**Descripción:**

Los decimales negativos generan un `factor = 10^(-3) = 0.001`, provocando resultados inesperados o comportamiento inválido en truncamiento.

**Resultado de Consola:**

