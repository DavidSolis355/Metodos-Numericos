# Ejemplo de ejecución: Diferenciación Numérica (Método de 5 Puntos)

---

## Fórmula utilizada

La derivada se aproxima mediante la siguiente fórmula:

$$
f'(x_0) \approx \frac{-f(x_0+2h) + 8f(x_0+h) - 8f(x_0-h) + f(x_0-2h)}{12h}
$$

---

## Datos usados para este caso de prueba

- **Función**:  
  $$  f(x) = \exp(x) \cdot \cos(x)  $$
- **Punto**:  
  $$ x_0 = 0.5 $$
- **Paso**:  
  $$ h = 0.1 $$

---

### Salida en Consola

```java

DIFERENCIACIÓN NUMÉRICA (MÉTODO DE 5 PUNTOS)
Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)):
exp(x)*cos(x)
Introduzca el punto donde calcular la derivada (x0):
0.5
Introduzca el tamaño del paso (h):
0.1

yaml
Copiar
Editar

---

## Resultado esperado (impresión del programa)

RESULTADO:
f'(0.5000) ≈ 0.325208029197
Fórmula utilizada: [-f(x+2h) + 8f(x+h) - 8f(x-h) + f(x-2h)] / (12h)

```


