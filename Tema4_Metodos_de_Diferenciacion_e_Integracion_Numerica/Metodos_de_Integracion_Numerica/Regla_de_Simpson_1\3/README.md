## **Método de la Regla de Simpson de 1/3**

### **Definición**
La **regla de Simpson de 1/3** es un método numérico para aproximar la integral definida de una función. Esta regla se basa en aproximar la función a integrar por un polinomio de segundo grado (una parábola) sobre el intervalo de integración. La regla de Simpson de 1/3 utiliza tres puntos para construir la parábola: los puntos finales del intervalo y el punto medio. Es más precisa que la regla del trapecio, ya que considera la curvatura de la función.

### **¿Para qué se usa?**
- Para **aproximar integrales** de funciones cuando no se pueden obtener soluciones exactas analíticamente.
- Se utiliza cuando se desea una aproximación con **mayor precisión** que otros métodos como la regla del trapecio.
- Comúnmente utilizada en problemas de **ingeniería** y **ciencias aplicadas** donde las funciones a integrar son suaves y se desea obtener una buena aproximación en un intervalo determinado.

### **Método de Resolución (Procedimiento)**
La fórmula general de la regla de Simpson de 1/3 para la integral definida de una función \( f(x) \) en el intervalo \( [a, b] \) es:

$$
I \approx \frac{b - a}{6} \left[ f(a) + 4f\left(\frac{a + b}{2}\right) + f(b) \right]
$$

Si se divide el intervalo \( [a, b] \) en \( n \) subintervalos (debe ser un número par), la fórmula generalizada es:

$$
I \approx \frac{h}{3} \left[ f(x_0) + 4 \sum_{i=1, 3, 5, \dots}^{n-1} f(x_i) + 2 \sum_{i=2, 4, 6, \dots}^{n-2} f(x_i) + f(x_n) \right]
$$

donde:
- \( h = \frac{b - a}{n} \) es el tamaño de los subintervalos.
- \( x_0 = a \), \( x_n = b \), y los \( x_i \) son los puntos intermedios en el intervalo \( [a, b] \).

### **Características**
- **Mayor precisión** que la regla del trapecio y otros métodos de primer orden.
- **Requiere que \( n \) sea par** (para dividir el intervalo en subintervalos iguales de manera correcta).
- **Rápida convergencia**: cuanto mayor es el número de subintervalos, más precisa es la aproximación.
- **Uso común en integrales de funciones suaves** y bien comportadas.

### **Ejemplo**

Queremos aproximar la integral de \( f(x) = \sin(x) \) en el intervalo \( [0, \pi] \) usando la regla de Simpson de 1/3 con \( n = 2 \) subintervalos (es decir, tres puntos: \( x_0, x_1, x_2 \)).

1. **Determinar el tamaño del subintervalo**:

   El intervalo es \( [0, \pi] \), y \( n = 2 \), por lo que:

   $$ h = \frac{\pi - 0}{2} = \frac{\pi}{2} $$

2. **Evaluar la función en los puntos \( x_0 \), \( x_1 \), y \( x_2 \)**:

   Los puntos \( x_0 = 0 \), \( x_1 = \frac{\pi}{2} \), y \( x_2 = \pi \).

   Evaluamos la función \( f(x) = \sin(x) \) en estos puntos:
   - \( f(x_0) = \sin(0) = 0 \)
   - \( f(x_1) = \sin\left(\frac{\pi}{2}\right) = 1 \)
   - \( f(x_2) = \sin(\pi) = 0 \)

3. **Aplicar la fórmula de la regla de Simpson de 1/3**:

   La fórmula para la aproximación es:

   $$ I \approx \frac{h}{3} \left[ f(x_0) + 4f(x_1) + f(x_2) \right] $$

   Sustituyendo los valores:

   $$ I \approx \frac{\pi}{2} \times \frac{1}{3} \left[ 0 + 4(1) + 0 \right] $$

   $$ I \approx \frac{\pi}{6} \times 4 = \frac{2\pi}{3} $$

**Resultado:**
La integral aproximada de \( \sin(x) \) en el intervalo \( [0, \pi] \) usando la regla de Simpson de 1/3 es:

$$ I \approx \frac{2\pi}{3} \approx 2.0944 $$

Este valor es una aproximación bastante precisa de la integral exacta, que es \( \int_0^\pi \sin(x) dx = 2 \).

---

### [Codigo en Java](Simpson13.java)

```java

import java.util.Scanner;
import java.util.function.Function;

public class Simpson13 {

    // Método principal que ejecuta la integración numérica utilizando la regla de Simpson 1/3.
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Mensaje de bienvenida
        System.out.println("INTEGRACIÓN NUMÉRICA (REGLA DE SIMPSON 1/3)");
        System.out.println("---------------------------------------------");
        
        // Solicitar al usuario la función matemática a integrar
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();

        // Crear una expresión funcional que evalúa la función en términos de x
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));
        
        // Solicitar los límites de integración
        System.out.println("Introduzca el límite inferior de integración (a): ");
        double a = scanner.nextDouble();
        
        System.out.println("Introduzca el límite superior de integración (b): ");
        double b = scanner.nextDouble();

        // Solicitar el número de subintervalos
        System.out.println("Introduzca el número de subintervalos (n): ");
        int n = scanner.nextInt();
        
        // Asegurar que el número de subintervalos sea par
        if (n % 2 != 0) {
            System.out.println("El número de subintervalos debe ser par. Incrementando en 1.");
            n++;
        }

        // Calcular la integral usando la regla de Simpson 1/3
        double integral = simpson13(f, a, b, n);
        
        // Mostrar el resultado
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Regla de Simpson 1/3");
    }

    // Método que aplica la regla de Simpson 1/3 para la integración numérica
    private static double simpson13(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n;
        
        double suma = f.apply(a) + f.apply(b);
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 == 0) {
                suma += 2 * f.apply(x);
            } else {
                suma += 4 * f.apply(x);
            }
        }
        
        return h / 3 * suma;
    }
    
    // Método para evaluar la función proporcionada por el usuario (parser de expresiones)
    private static double evaluarFuncion(String expr) {
        try {
            return new Object() {
                int pos = -1, ch;
               
                // Método para avanzar en la expresión
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }
               
                // Método para comer (descartar) un carácter específico
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
               
                // Método principal de análisis que devuelve el valor de la expresión
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                // Método que analiza expresiones (sumas y restas)
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                // Método que analiza términos (multiplicación, división, y potenciación)
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
               
                // Método que analiza factores (números, funciones y paréntesis)
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
// Los comentarios en el código son como cartas en botellas: Muchas veces nadie los lee, y si están mal escritos, causan más confusión que ayuda. A veces, el código sin comentarios es más claro. Esto es absurdo?

```

### [Caso de Prueba](Casos_de_Prueba) 

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

