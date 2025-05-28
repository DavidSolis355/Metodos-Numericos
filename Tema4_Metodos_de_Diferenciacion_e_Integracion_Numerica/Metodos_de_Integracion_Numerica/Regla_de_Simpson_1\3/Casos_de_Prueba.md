# Caso de prueba: Integración numérica con la regla de Simpson 1/3

---

## Fórmula usada

La integral aproximada en \([a,b]\) usando \(n\) subintervalos (pares):

$$
\int_a^b f(x) dx \approx \frac{h}{3} \left[ f(a) + f(b) + 4 \sum_{\text{impares}} f(x_i) + 2 \sum_{\text{pares}} f(x_i) \right]
$$

donde \(h = \frac{b - a}{n}\) y \(x_i = a + i h\).

---

## Datos de entrada

- Función:  
  \( f(x) = \sin(x) \)
- Intervalo:  
  \( a = 0 \)  
  \( b = \pi \approx 3.141592653589793 \)
- Número de subintervalos:  
  \( n = 10 \) (par)

---

## Entrada en consola


```java

INTEGRACIÓN NUMÉRICA (REGLA DE SIMPSON 1/3)
Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)):
sin(x)
Introduzca el límite inferior de integración (a):
0
Introduzca el límite superior de integración (b):
3.141592653589793
Introduzca el número de subintervalos (n):
10

```

## Resultado esperado

```java

RESULTADO:
La integral de f(x) en el intervalo [0.0000, 3.1416] ≈ 2.000000000000
Fórmula utilizada: Regla de Simpson 1/3

```
