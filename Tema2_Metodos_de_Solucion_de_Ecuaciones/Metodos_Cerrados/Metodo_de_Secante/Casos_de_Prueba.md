# Casos de Prueba para el Método de la Secante

Este documento muestra casos de prueba para el **método de la secante** implementado en Java. Incluye un caso donde el método converge correctamente y otro donde falla o diverge.

---

# ✅ Caso de Prueba Válido - Método de la Secante

**Descripción:**  
Se aplica el método de la secante a la función `f(x) = x² - 3x + 2`, que tiene raíces reales en `x = 1` y `x = 2`.

**Parámetros de entrada:**
- `x0 = 0.0`
- `x1 = 1.0`
- `tolerancia = 1e-6`
- `maxIter = 100`

**Justificación:**  
El intervalo inicial está cerca de la raíz `x = 1`, y la función es continua y derivable en el dominio.

**Resultado esperado (salida parcial):**


---

# ❌ Caso de Prueba Inválido - Método de la Secante

**Descripción:**  
Se intenta aplicar el método con dos puntos iniciales donde `f(x0) = f(x1)`, lo cual genera división por cero en la fórmula de la secante.

**Parámetros de entrada:**
- `x0 = 1.0`
- `x1 = 1.0`
- `tolerancia = 1e-6`
- `maxIter = 100`

**Justificación:**  
Si `x0 == x1`, entonces `f(x1) - f(x0) = 0`, lo que causa una división por cero.

**Resultado esperado (salida parcial):**


