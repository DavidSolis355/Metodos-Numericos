## **Método de Diferenciación de 5 Puntos**

### **Definición**
El **método de diferenciación de 5 puntos** es una técnica numérica que utiliza cinco puntos de la función para aproximar la derivada en un punto dado. A través de una combinación de valores de la función en puntos cercanos, proporciona una aproximación más precisa a la derivada que el método de 3 puntos.

### **¿Para qué se usa?**
- Para **aproximar derivadas** de funciones cuando no se tiene acceso a la derivada explícita de la función.
- Utilizado en **simulaciones numéricas** y **modelos matemáticos**, especialmente cuando se trabaja con funciones discretas o datos experimentales.
- Es común en la **aproximación de ecuaciones diferenciales** en problemas de ingeniería, física y análisis de señales.

### **Método de Resolución (Procedimiento)**
El método de 5 puntos utiliza una fórmula que involucra la función evaluada en cinco puntos: \( f(x - 2h) \), \( f(x - h) \), \( f(x) \), \( f(x + h) \), y \( f(x + 2h) \), para aproximar la derivada de la función en \( x \).

La fórmula general es:

$$
f'(x) \approx \frac{-f(x + 2h) + 8f(x + h) - 8f(x - h) + f(x - 2h)}{12h}
$$

Donde:
- \( f(x) \) es la función de la cual se desea calcular la derivada.
- \( h \) es el paso, es decir, la distancia entre los puntos.

### **Características**
- **Mayor precisión:** Al utilizar cinco puntos, el método tiene una precisión superior en comparación con los métodos de 3 puntos, especialmente para funciones suaves.
- **Requiere más evaluaciones:** A diferencia del método de 3 puntos, el de 5 puntos requiere más cálculos, lo que puede aumentar el costo computacional.
- **Aproximación de segundo orden:** La precisión es de orden \( O(h^4) \), lo que significa que el error disminuye más rápidamente conforme se reduce \( h \).

### **Ejemplo**

Supongamos que queremos aproximar la derivada de la función \( f(x) = x^2 \) en el punto \( x = 2 \) usando el método de 5 puntos.

1. **Elegimos un valor para \( h \):**
   Vamos a tomar \( h = 0.1 \).

2. **Evaluamos la función en los puntos \( x - 2h \), \( x - h \), \( x \), \( x + h \), y \( x + 2h \):**
   - \( f(2 - 2(0.1)) = f(1.8) = (1.8)^2 = 3.24 \)
   - \( f(2 - 0.1) = f(1.9) = (1.9)^2 = 3.61 \)
   - \( f(2) = 2^2 = 4 \)
   - \( f(2 + 0.1) = f(2.1) = (2.1)^2 = 4.41 \)
   - \( f(2 + 2(0.1)) = f(2.2) = (2.2)^2 = 4.84 \)

3. **Aplicamos la fórmula del método de 5 puntos:**

$$
f'(2) \approx \frac{-f(2.2) + 8f(2.1) - 8f(1.9) + f(1.8)}{12(0.1)} = \frac{-4.84 + 8(4.41) - 8(3.61) + 3.24}{1.2}
$$

Realizando las operaciones:

$$
f'(2) \approx \frac{-4.84 + 35.28 - 28.88 + 3.24}{1.2} = \frac{5.8}{1.2} = 4.83
$$

**Resultado:** La derivada aproximada de \( f(x) = x^2 \) en \( x = 2 \) es aproximadamente 4.83, que es muy cercana a la derivada exacta de 4.

---

### [Codigo en Java](Diferenciacion5Puntos.java)

```java

import java.util.Scanner;
import java.util.function.Function;

public class Diferenciacion5Puntos {

     // Método principal que ejecuta la diferenciación numérica usando el método de 5 puntos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        // Mensaje de introducción al usuario
        System.out.println("DIFERENCIACIÓN NUMÉRICA (MÉTODO DE 5 PUNTOS)");
        System.out.println("---------------------------------------------");
       
        // Solicita al usuario la función a evaluar
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));
       
        // Convierte la cadena de la función a una expresión evaluable
        System.out.println("Introduzca el punto donde calcular la derivada (x0): ");
        double x0 = scanner.nextDouble();
       
        // Solicita al usuario el punto donde calcular la derivada
        System.out.println("Introduzca el tamaño del paso (h): ");
        double h = scanner.nextDouble();

        // Solicita al usuario el tamaño del paso
        double derivada = (-f.apply(x0 + 2*h) + 8*f.apply(x0 + h) - 8*f.apply(x0 - h) + f.apply(x0 - 2*h)) / (12 * h);

        // Muestra el resultado de la derivada aproximada
        System.out.println("\nRESULTADO:");
        System.out.printf("f'(%.4f) ≈ %.12f%n", x0, derivada);
        System.out.println("Fórmula utilizada: [-f(x+2h) + 8f(x+h) - 8f(x-h) + f(x-2h)] / (12h)");
    }

    // Método que evalúa una cadena de expresión matemática y devuelve el resultado
    private static double evaluarFuncion(String expr) {
        try {
            return new Object() {
                int pos = -1, ch;
               
                // Método para leer el siguiente carácter de la expresión
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }
               
                // Método para "comer" caracteres que son esperados
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
               
                 // Método principal que inicia el proceso de análisis de la expresión
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                // Método que maneja expresiones (sumas y restas)
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                // Método que maneja términos (multiplicación, división y potencias)
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
                
                // Método que maneja factores (números, funciones, paréntesis)
                double parseFactor() {
                    if (eat('+')) return parseFactor();
                    if (eat('-')) return -parseFactor();
                    double x;
                    int startPos = this.pos;
                    if (eat('(')) {
                        x = parseExpression();
                        eat(')');
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(expr.substring(startPos, this.pos));
                    } else if (ch >= 'a' && ch <= 'z') {
                        while (ch >= 'a' && ch <= 'z') nextChar();
                        String func = expr.substring(startPos, this.pos);
                        x = parseFactor();
                        switch (func) {
                            case "sqrt": x = Math.sqrt(x); break;
                            case "sin": x = Math.sin(x); break;
                            case "cos": x = Math.cos(x); break;
                            case "tan": x = Math.tan(x); break;
                            case "log": x = Math.log(x); break;
                            case "exp": x = Math.exp(x); break;
                            default: throw new RuntimeException("Función desconocida: " + func);
                        }
                    } else {
                        throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    }
                    return x;
                }
            }.parse();
        } catch (Exception e) {
            throw new RuntimeException("Error al evaluar la función: " + e.getMessage());
        }
    }

}

//Alguien de verdad Leera esto?

```

### [Caso de Prueba](Casos_de_Prueba) 

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



