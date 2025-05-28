# Caso de prueba: Integración numérica por Cuadratura Gaussiana (2 puntos)

---

## Fórmula usada

La integral aproximada en el intervalo \([a,b]\) se calcula como:

$$
\int_a^b f(x) \, dx \approx \frac{b-a}{2} \left[ w_1 f\left( \frac{b-a}{2} x_1 + \frac{b+a}{2} \right) + w_2 f\left( \frac{b-a}{2} x_2 + \frac{b+a}{2} \right) \right]
$$

donde para 2 puntos:

$$
x_1 = -\frac{1}{\sqrt{3}}, \quad x_2 = \frac{1}{\sqrt{3}}, \quad w_1 = w_2 = 1
$$

---

## Datos de entrada

- Función:  
  \( f(x) = \exp(-x^2) \)
- Intervalo de integración:  
  \( a = 0 \)  
  \( b = 1 \)

---

## Salida de Consola


```java

INTEGRACIÓN NUMÉRICA (CUADRATURA GAUSSIANA)
Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)):
exp(-x^2)
Introduzca el límite inferior de integración (a):
0
Introduzca el límite superior de integración (b):
1

```

---

## Resultado esperado


```java

RESULTADO:
La integral de f(x) en el intervalo [0.0000, 1.0000] ≈ 0.746824132812
Fórmula utilizada: Cuadratura Gaussiana de 2 puntos


```

