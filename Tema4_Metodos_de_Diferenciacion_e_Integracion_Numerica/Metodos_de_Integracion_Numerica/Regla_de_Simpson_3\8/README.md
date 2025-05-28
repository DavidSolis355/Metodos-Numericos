## **Método de la Regla de Simpson de 3/8**

### **Definición**
La **regla de Simpson de 3/8** es una extensión del método de Simpson de 1/3, utilizada para aproximar la integral definida de una función. En lugar de usar tres puntos (como en Simpson de 1/3), este método utiliza cuatro puntos: los puntos finales del intervalo y dos puntos intermedios. La regla de Simpson de 3/8 es particularmente útil cuando se desea una aproximación más precisa en intervalos con una mayor complejidad en la función.

### **¿Para qué se usa?**
- Para **aproximar integrales** de funciones, especialmente cuando se tiene un intervalo más grande o una mayor complejidad en la forma de la función.
- Se utiliza cuando se desea una **aproximación más precisa** que la proporcionada por la regla de Simpson de 1/3.
- Es adecuada para **funciones suaves** donde se requiere una mayor precisión en la integral.

### **Método de Resolución (Procedimiento)**
La fórmula general de la regla de Simpson de 3/8 para la integral definida de una función \( f(x) \) en el intervalo \( [a, b] \) es:

$$
I \approx \frac{3h}{8} \left[ f(a) + 3f\left( \frac{a + b}{3} \right) + 3f\left( \frac{2a + b}{3} \right) + f(b) \right]
$$

Donde:
- \( h = \frac{b - a}{3} \) es el tamaño de los subintervalos, que en este caso es de 3 subintervalos.

Si se divide el intervalo \( [a, b] \) en \( n \) subintervalos, siendo \( n \) múltiplo de 3 (es decir, \( n = 3m \)), la fórmula generalizada es:

$$
I \approx \frac{3h}{8} \left[ f(x_0) + 3 \sum_{i=1, 3, 5, \dots}^{n-2} f(x_i) + 3 \sum_{i=2, 4, 6, \dots}^{n-1} f(x_i) + f(x_n) \right]
$$

donde:
- \( x_0 = a \), \( x_n = b \), y los \( x_i \) son los puntos intermedios en el intervalo \( [a, b] \).

### **Características**
- **Requiere que el número de subintervalos \( n \) sea múltiplo de 3.**
- **Mayor precisión** que la regla de Simpson de 1/3, debido a la utilización de más puntos intermedios.
- **Eficaz para funciones suaves** y bien comportadas, proporcionando una excelente aproximación en muchos casos.
- Utiliza **cuatro puntos** en cada subintervalo, lo que hace que sea más precisa que otros métodos de aproximación.

### **Ejemplo**

Queremos aproximar la integral de \( f(x) = \cos(x) \) en el intervalo \( [0, \pi] \) usando la regla de Simpson de 3/8 con \( n = 3 \) subintervalos (es decir, cuatro puntos: \( x_0, x_1, x_2, x_3 \)).

1. **Determinar el tamaño del subintervalo**:

   El intervalo es \( [0, \pi] \), y \( n = 3 \), por lo que:

   $$ h = \frac{\pi - 0}{3} = \frac{\pi}{3} $$

2. **Evaluar la función en los puntos \( x_0, x_1, x_2, x_3 \)**:

   Los puntos \( x_0 = 0 \), \( x_1 = \frac{\pi}{3} \), \( x_2 = \frac{2\pi}{3} \), y \( x_3 = \pi \).

   Evaluamos la función \( f(x) = \cos(x) \) en estos puntos:
   - \( f(x_0) = \cos(0) = 1 \)
   - \( f(x_1) = \cos\left(\frac{\pi}{3}\right) = \frac{1}{2} \)
   - \( f(x_2) = \cos\left(\frac{2\pi}{3}\right) = -\frac{1}{2} \)
   - \( f(x_3) = \cos(\pi) = -1 \)

3. **Aplicar la fórmula de la regla de Simpson de 3/8**:

   La fórmula para la aproximación es:

   $$ I \approx \frac{3h}{8} \left[ f(x_0) + 3f(x_1) + 3f(x_2) + f(x_3) \right] $$

   Sustituyendo los valores:

   $$ I \approx \frac{3\pi}{9} \left[ 1 + 3\left(\frac{1}{2}\right) + 3\left(-\frac{1}{2}\right) + (-1) \right] $$

   $$ I \approx \frac{\pi}{3} \left[ 1 + \frac{3}{2} - \frac{3}{2} - 1 \right] $$

   $$ I \approx \frac{\pi}{3} \times 0 = 0 $$

**Resultado:**
La integral aproximada de \( \cos(x) \) en el intervalo \( [0, \pi] \) usando la regla de Simpson de 3/8 es:

$$ I \approx 0 $$

Este resultado es exacto, ya que la integral exacta de \( \cos(x) \) en el intervalo \( [0, \pi] \) es \( \int_0^\pi \cos(x) \, dx = 0 \).

---

### [Codigo en Java](Simpson38.java)

```java

import java.util.Scanner;
import java.util.function.Function;

public class Simpson38 {

    // Método principal que ejecuta la integración
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("INTEGRACIÓN NUMÉRICA (REGLA DE SIMPSON 3/8)");
        System.out.println("---------------------------------------------");
        
        // Solicitamos la función al usuario, usando 'x' como variable
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));
        
        // Solicitamos los límites de integración y el número de subintervalos
        System.out.println("Introduzca el límite inferior de integración (a): ");
        double a = scanner.nextDouble();
        
        System.out.println("Introduzca el límite superior de integración (b): ");
        double b = scanner.nextDouble();
        
        System.out.println("Introduzca el número de subintervalos (n): ");
        int n = scanner.nextInt();
        
        // Aseguramos que el número de subintervalos sea múltiplo de 3
        if (n % 3 != 0) {
            System.out.println("El número de subintervalos debe ser múltiplo de 3. Ajustando n.");
            n = (n / 3) * 3;
        }
        
        // Calculamos la integral utilizando la regla de Simpson 3/8
        double integral = simpson38(f, a, b, n);
        
        // Mostramos el resultado
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Regla de Simpson 3/8");
    }

    // Método que implementa la regla de Simpson 3/8 para calcular la integral
    private static double simpson38(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n;

        // Inicializamos la suma con los extremos a y b
        double suma = f.apply(a) + f.apply(b);
        
        // Sumamos los términos intermedios
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 3 == 0) {
                suma += 2 * f.apply(x); 
            } else {
                suma += 3 * f.apply(x);
            }
        }
        // Aplicamos la fórmula de Simpson 3/8
        return 3 * h / 8 * suma;
    }

    // Método que evalúa la función ingresada por el usuario
    private static double evaluarFuncion(String expr) {
        try {
            return new Object() {
                int pos = -1, ch;
               
                // Método para obtener el siguiente carácter de la expresión
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }

                // Método para consumir un carácter específico
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
               
                 // Método que inicia la evaluación de la expresión
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                // Método para procesar la expresión (sumas y restas)
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                // Método para procesar los términos (multiplicación, división, potenciación)
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
               
                // Método para procesar los factores (números, funciones)
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
// Alguien saqueme de aqui porfavor, me quiero dar de baja de la carrera

```

### [Caso de Prueba](Casos_de_Prueba) 

# Caso de prueba: Integración numérica con la regla de Simpson 3/8

---

## Fórmula usada

La integral aproximada en \([a,b]\) usando \(n\) subintervalos (múltiplo de 3):

$$
\int_a^b f(x) dx \approx \frac{3h}{8} \left[ f(a) + f(b) + 3 \sum_{\substack{i=1 \\ i \not\equiv 0 (mod\,3)}}^{n-1} f(x_i) + 2 \sum_{\substack{i=3 \\ i \equiv 0 (mod\,3)}}^{n-3} f(x_i) \right]
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
  \( n = 9 \) (múltiplo de 3)

---

## Entrada en consola


```java

INTEGRACIÓN NUMÉRICA (REGLA DE SIMPSON 3/8)
Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)):
sin(x)
Introduzca el límite inferior de integración (a):
0
Introduzca el límite superior de integración (b):
3.141592653589793
Introduzca el número de subintervalos (n):
9

```

## Resultado esperado

```java

RESULTADO:
La integral de f(x) en el intervalo [0.0000, 3.1416] ≈ 2.000000000000
Fórmula utilizada: Regla de Simpson 3/8

```
