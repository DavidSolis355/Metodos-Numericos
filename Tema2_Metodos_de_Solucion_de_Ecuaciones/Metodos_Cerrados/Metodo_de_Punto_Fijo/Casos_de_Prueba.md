# Casos de Prueba para el Método de Punto Fijo

Este documento contiene casos de prueba para el método numérico de **Punto Fijo** implementado en Java. Se muestra un caso exitoso y uno fallido con la configuración correspondiente.

---

## Método: `puntoFijo(x0, tol, maxIter)`

### ✅ Caso de prueba válido (converge correctamente)

**Descripción:**  
Se busca una raíz de la función `f(x) = x² - 3x + 2`, reescrita como `x = g(x) = (x² + 2)/3`.

**Parámetros:**
- `x0 = 0.5`
- `tol = 1e-6`
- `maxIter = 100`

**Justificación:**  
La función `g(x)` está bien construida y cumple con la condición de convergencia local (`|g'(x)| < 1`) en el intervalo cercano a la raíz.

**Resultado esperado (parcial):**

Iteración 1: x=0.583333, error=0.083333
...
Iteración 17: x=1.000000, error=0.000000
Raíz aproximada encontrada en x = 1.000000 con tolerancia 0.000001


---

### ❌ Caso de prueba inválido (no converge)

**Descripción:**  
Se utiliza una función `g(x)` que no cumple con la condición de convergencia (|g′(x)| > 1), por lo tanto, el método no se aproxima a una raíz.

**Modificaciones sugeridas al código:**
```java
public static double g(double x) {
    // g(x) no converge: por ejemplo, g(x) = x^2 + 1
    return Math.pow(x, 2) + 1;
}

**Parámetros:**

- 'x0 = 0.5'
- 'tol = 1e-6'
- 'maxIter = 100'

**Justificación:**
La función 'g(x) = x² + 1' tiene derivada 'g(x) = 2x,' que para 'x=0.5 da 1.0', pero rápidamente crece por encima de 1. Esto hace que el método diverja.

**Resultado esperado:**

Iteración 1: x=1.250000, error=0.750000
Iteración 2: x=2.562500, error=1.312500
...
Se alcanzó el máximo de iteraciones. Última aproximación: x = valor grande
