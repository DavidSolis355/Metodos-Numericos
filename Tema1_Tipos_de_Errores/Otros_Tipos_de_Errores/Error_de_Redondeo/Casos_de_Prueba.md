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


---

## ✅ Caso de Prueba 2 – Redondeo a 2 decimales

**Entrada:**

- `valorOriginal = 2.7182818`
- `decimales = 2`

**Resultado Esperado:**

Valor redondeado: `2.72`  
Error de redondeo: `|2.7182818 - 2.72| = 0.0017182`

**Resultado de Consola:**


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

