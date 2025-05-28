# Casos de Prueba para el Método de Newton-Raphson

Este documento contiene casos de prueba para el método numérico de **Newton-Raphson** implementado en Java. Cada caso incluye una descripción, configuración del problema y resultado esperado.

---

## Método: `newtonRaphson(x0, tol, maxIter)`

### ✅ Caso de prueba válido (funciona correctamente)

**Descripción:**  
Encuentra la raíz de la función `f(x) = x³ - x - 2` usando una aproximación inicial de `x0 = 1.5`.

**Parámetros:**
- `x0 = 1.5`
- `tol = 1e-6`
- `maxIter = 100`

**Justificación:**  
La función tiene una raíz real cercana a `x = 1.521`, y su derivada `f'(x) = 3x² - 1` no se anula en el proceso.

**Resultado esperado (parcial):**

Iteración 1: x=1.521739, f(x)=-0.002058
Iteración 2: x=1.521380, f(x)=-0.000001
Raíz aproximada encontrada en x = 1.521380 con tolerancia 0.000001

---

### ❌ Caso de prueba inválido (derivada cero)

**Descripción:**  
Se intenta aplicar el método en un punto donde la derivada es cero, lo que impide seguir con el método.

**Modificaciones al código:**
```java
double x0 = 0.57735; // Aproximación inicial donde f'(x) ≈ 0 (ya que f'(x) = 3x² - 1)
```

**Justificación:**
La derivada ?f'(x) se anula en x = ±1/√3 ≈ 0.57735', por lo tanto el método detiene la ejecución.

**Resultado esperado:**

Derivada cero. No se puede continuar.