## **Método de la Regla del Trapecio**

### **Definición**
La **regla del trapecio** es un método numérico utilizado para aproximar la integral definida de una función. Este método estima el área bajo una curva dividiendo el intervalo de integración en subintervalos, y aproximando la función por líneas rectas (formando trapecios) sobre cada subintervalo. A partir de la suma de las áreas de los trapecios, se obtiene la aproximación de la integral.

### **¿Para qué se usa?**
- Para **aproximar integrales** de funciones cuando no es posible calcular la integral exacta de manera analítica.
- Se utiliza comúnmente en **simulaciones numéricas** y en problemas donde se necesita una aproximación rápida y sencilla de la integral.
- Es especialmente útil cuando la función es suave y bien comportada en el intervalo de integración.

### **Método de Resolución (Procedimiento)**
La fórmula general de la regla del trapecio para la integral definida de una función \( f(x) \) en el intervalo \( [a, b] \) es:

$$
I \approx \frac{b - a}{2} \left[ f(a) + f(b) \right]
$$

Este es el caso para un único trapecio. Si se divide el intervalo \( [a, b] \) en \( n \) subintervalos (es decir, se utiliza \( n+1 \) puntos), la fórmula se generaliza como sigue:

$$
I \approx \frac{h}{2} \left[ f(x_0) + 2 \sum_{i=1}^{n-1} f(x_i) + f(x_n) \right]
$$

donde:
- \( h = \frac{b - a}{n} \) es el tamaño de los subintervalos.
- \( x_0 = a \), \( x_n = b \), y los \( x_i \) son los puntos intermedios en el intervalo \( [a, b] \).

### **Características**
- **Simplicidad**: Es un método sencillo de implementar y entender.
- **Aproximación razonable**: Aunque no siempre es el más preciso, la regla del trapecio ofrece una aproximación razonablemente buena para muchas funciones.
- **Precisión limitada**: El error en la aproximación disminuye a medida que aumentamos el número de subintervalos \( n \), pero no es tan preciso como otros métodos como la cuadratura gaussiana.

### **Ejemplo**

Queremos aproximar la integral de \( f(x) = \sin(x) \) en el intervalo \( [0, \pi] \) usando la regla del trapecio con 2 subintervalos (es decir, \( n = 2 \)).

1. **Determinar el tamaño del subintervalo**:

   El intervalo es \( [0, \pi] \), por lo que:

   $$ h = \frac{\pi - 0}{2} = \frac{\pi}{2} $$

2. **Evaluar la función en los puntos \( x_0 \), \( x_1 \), y \( x_2 \)**:

   Los puntos \( x_0 = 0 \), \( x_1 = \frac{\pi}{2} \), y \( x_2 = \pi \).

   Evaluamos la función \( f(x) = \sin(x) \) en estos puntos:
   - \( f(x_0) = \sin(0) = 0 \)
   - \( f(x_1) = \sin\left(\frac{\pi}{2}\right) = 1 \)
   - \( f(x_2) = \sin(\pi) = 0 \)

3. **Aplicar la fórmula de la regla del trapecio**:

   La fórmula para la aproximación es:

   $$ I \approx \frac{h}{2} \left[ f(x_0) + 2f(x_1) + f(x_2) \right] $$

   Sustituyendo los valores:

   $$ I \approx \frac{\pi}{2} \times \frac{1}{2} \left[ 0 + 2(1) + 0 \right] $$

   $$ I \approx \frac{\pi}{4} \times 2 = \frac{\pi}{2} $$

**Resultado:**
La integral aproximada de \( \sin(x) \) en el intervalo \( [0, \pi] \) usando la regla del trapecio con 2 subintervalos es:

$$ I \approx \frac{\pi}{2} \approx 1.5708 $$

Este valor es una aproximación razonable de la integral exacta, que es \( \int_0^\pi \sin(x) dx = 2 \).

---

### [Codigo en Java](ReglaDelTrapecio.java)

```java

import java.util.Scanner;
import java.util.function.Function;

public class ReglaDelTrapecio {

    public static void main(String[] args) {
        // Inicialización de la entrada de datos desde la consola
        Scanner scanner = new Scanner(System.in);
        
        // Mensaje inicial explicando el propósito del programa
        System.out.println("INTEGRACIÓN NUMÉRICA (REGLA DEL TRAPECIO)");
        System.out.println("---------------------------------------------");
        
        // Solicita al usuario ingresar la función matemática que se desea integrar
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));

        // Define la función a evaluar usando una expresión matemática que depende de 'x'
        System.out.println("Introduzca el límite inferior de integración (a): ");
        double a = scanner.nextDouble();
        
        // Solicita al usuario los límites de integración y el número de subintervalos
        System.out.println("Introduzca el límite superior de integración (b): ");
        double b = scanner.nextDouble();
        
        // Calcula la integral usando la regla del trapecio
        System.out.println("Introduzca el número de subintervalos (n): ");
        int n = scanner.nextInt();
        
        double integral = trapecio(f, a, b, n);
        
        // Muestra el resultado de la integración
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Regla del Trapecio");
    }

     /**
     * Método que aplica la regla del trapecio para calcular la integral de la función
     * entre los límites 'a' y 'b' usando 'n' subintervalos.
     * 
     * @param f  La función a integrar
     * @param a  El límite inferior de integración
     * @param b  El límite superior de integración
     * @param n  El número de subintervalos
     * @return   El valor aproximado de la integral
     */
    private static double trapecio(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n;
        
        double suma = (f.apply(a) + f.apply(b)) / 2.0;

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += f.apply(x);
        }

        return h * suma;
    }

     /**
     * Método que evalúa una función matemática representada como una cadena de texto.
     * La función puede contener operaciones aritméticas estándar, así como funciones
     * matemáticas comunes (sqrt, sin, cos, log, exp).
     * 
     * @param expr La cadena que representa la función a evaluar
     * @return     El valor de la función evaluada
     */
    private static double evaluarFuncion(String expr) {
        try {
            return new Object() {
                int pos = -1, ch;

                // Avanza al siguiente carácter en la expresión
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }
               
                // Consume un carácter específico
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
               
                // Inicia la evaluación de la expresión
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                // Analiza expresiones aritméticas de suma y resta
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                // Analiza expresiones de multiplicación, división y potenciación
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
                // Analiza números, paréntesis y funciones matemáticas
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

```

### [Caso de Prueba](Casos_de_Prueba) 

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

