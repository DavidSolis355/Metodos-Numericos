# Casos de Prueba para el Método de Regla Falsa (Falsa Posición)

Este documento contiene casos de prueba para el método numérico de **regla falsa** implementado en Java. Cada caso incluye una descripción, configuración del problema y resultado esperado.

---

## Método: `reglaFalsa(a, b, tol, maxIter)`

### ✅ Caso de prueba válido (funciona correctamente)

**Descripción:**  
Encuentra la raíz de la función `f(x) = x³ - x - 2` en el intervalo `[1, 2]`.

**Parámetros:**
- `a = 1`
- `b = 2`
- `tol = 1e-6`
- `maxIter = 100`

**Justificación:**  
`f(1) = -2`, `f(2) = 4`, como `f(a) * f(b) < 0`, se cumple el cambio de signo, por lo que hay una raíz en el intervalo.

**Resultado esperado (parcial):**



---

### ❌ Caso de prueba inválido (no debe funcionar)

**Descripción:**  
Se intenta aplicar el método en un intervalo donde no hay cambio de signo.

**Modificaciones al código:**
```java
double a = 2;
double b = 3;
```

**Justificación:**
'f(2) = 4, f(3) = 22', ambos valores son positivos, por lo tanto 'f(a) * f(b) > 0'. El método no es aplicable.

**Resultado esperado:**