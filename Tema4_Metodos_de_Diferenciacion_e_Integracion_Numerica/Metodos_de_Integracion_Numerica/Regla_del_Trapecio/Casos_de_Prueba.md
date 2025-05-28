# Caso de prueba: Integración numérica usando la Regla del Trapecio

---

## Fórmula usada

La integral aproximada en \([a,b]\) usando \(n\) subintervalos:

$$
\int_a^b f(x) dx \approx h \left[\frac{f(a) + f(b)}{2} + \sum_{i=1}^{n-1} f(a + i h) \right]
$$

donde \(h = \frac{b - a}{n}\).

---

## Datos de entrada

- Función:  
  \( f(x) = \cos(x) \)
- Intervalo:  
  \( a = 0 \)  
  \( b = \frac{\pi}{2} \approx 1.57079632679 \)
- Número de subintervalos:  
  \( n = 4 \)

---

## Entrada simulada en consola

```java

Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)):
cos(x)
Introduzca el límite inferior de integración (a):
0
Introduzca el límite superior de integración (b):
1.57079632679
Introduzca el número de subintervalos (n):
4

```

---

## Resultado esperado

```java

RESULTADO:
La integral de f(x) en el intervalo [0.0000, 1.5708] ≈ 0.998570731821
Fórmula utilizada: Regla del Trapecio

```

