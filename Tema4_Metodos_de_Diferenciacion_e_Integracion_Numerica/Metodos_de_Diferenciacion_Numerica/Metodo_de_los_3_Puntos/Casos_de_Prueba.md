# Ejemplo de ejecución del método de Diferenciación de Tres Puntos

---

## Fórmula utilizada

La fórmula de tres puntos centrados para calcular la derivada aproximada es:

$$
f'(x) \approx \frac{f(x+h) - f(x-h)}{2h}
$$

---

## Datos usados en el ejemplo

Usamos los siguientes valores:

- Arreglo de puntos: `puntos = {1, 1.0, 1.21}`  
  (esto representa: \( f(x-h) = 1 \), \( f(x) = 1.0 \), \( f(x+h) = 1.21 \))
- Paso entre puntos: `h = 0.1`

---

## Reemplazo en el código

Cambiar dentro del método `main` el bloque de código a:

```java
double h = 0.1; 
double[] puntos = {1, 1.0, 1.21};  
double derivada = derivadaTresPuntos(puntos, h);
System.out.println("La derivada aproximada es: " + derivada);
```

### Resultado esperado


```java

La derivada aproximada es: 1.05

```
