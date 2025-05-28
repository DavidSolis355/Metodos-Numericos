# Casos de Prueba para el Método de Bisección

Este documento contiene casos de prueba para el método numérico de **bisección** implementado en Java. Cada caso incluye una breve descripción, configuración del problema y resultado esperado.

---

### ✅ Caso de prueba válido (funciona correctamente)

**Descripción:**  
Encuentra la raíz de la función `f(x) = x³ - x - 2` en el intervalo `[1, 2]`.

**Parámetros:**
- `a = 1`
- `b = 2`
- `tol = 1e-6`
- `maxIter = 100`

**Justificación:**  
`f(1) = -2`, `f(2) = 4`, como `f(a) * f(b) < 0`, existe al menos una raíz en el intervalo.

**Resultado esperado (parcial):**



---

### ❌ Caso de prueba inválido (no debe funcionar)

**Descripción:**  
Se intenta aplicar el método en un intervalo donde `f(a)` y `f(b)` tienen el mismo signo.

**Modificaciones al código:**
```java
double a = 2;
double b = 3;
```

**Justificación:**
'f(2) = 4, f(3) = 22, como f(a) * f(b) > 0', no hay cambio de signo, por lo tanto no se puede aplicar el método.

**Resultado esperado:**