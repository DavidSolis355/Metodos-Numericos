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

