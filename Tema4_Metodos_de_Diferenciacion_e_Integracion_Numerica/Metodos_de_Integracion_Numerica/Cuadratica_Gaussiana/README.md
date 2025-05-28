## **Método de Cuadratura Gaussiana**

### **Definición**
La **cuadratura gaussiana** es un método numérico utilizado para aproximar la integral definida de una función. Se basa en la idea de aproximar la integral como una suma ponderada de los valores de la función en puntos específicos, llamados nodos o puntos de Gauss, dentro del intervalo de integración. Este método es más preciso que otros métodos tradicionales como el de los trapecios o Simpson, ya que utiliza un número reducido de puntos para obtener una aproximación de alta precisión.

### **¿Para qué se usa?**
- Para **aproximar integrales** de funciones, especialmente cuando la integral no tiene una solución analítica sencilla o cuando los métodos clásicos no son eficientes.
- Es ampliamente utilizado en la **computación científica**, en **simulaciones numéricas** y en la **resolución de ecuaciones diferenciales** por el método de elementos finitos.
- Ideal para integrales con funciones complejas o cuando se requiere una **alta precisión** en un número limitado de puntos.

### **Método de Resolución (Procedimiento)**
La fórmula básica de la cuadratura gaussiana para una integral definida de la forma:

$$
I = \int_a^b f(x) \, dx
$$

es aproximada por la suma ponderada de los valores de \( f(x) \) en los nodos \( x_i \) correspondientes, multiplicados por los pesos \( w_i \):

$$
I \approx \sum_{i=1}^{n} w_i f(x_i)
$$

donde:
- \( x_i \) son los puntos de Gauss, que son las raíces de los polinomios de Legendre en el intervalo \( [-1, 1] \).
- \( w_i \) son los pesos correspondientes a esos puntos.
  
Para un intervalo general \( [a, b] \), la fórmula se transforma de la siguiente manera:

$$
I \approx \frac{b-a}{2} \sum_{i=1}^{n} w_i f\left( \frac{b-a}{2} x_i + \frac{a+b}{2} \right)
$$

### **Características**
- **Alta precisión:** Con pocos puntos, la cuadratura gaussiana puede lograr una precisión superior a otros métodos de integración.
- **No requiere conocimiento de la derivada:** Al basarse en la evaluación de la función en puntos específicos, no es necesario conocer su derivada.
- **Eficiencia computacional:** Aunque puede requerir más cálculos por punto en comparación con otros métodos, el número reducido de puntos necesarios compensa el coste computacional.
- **Ideal para funciones suaves:** Funciona particularmente bien cuando la función integrada es suave y bien comportada en el intervalo de integración.

### **Ejemplo**

Queremos aproximar la integral de \( f(x) = e^{-x^2} \) en el intervalo \( [0, 1] \) usando cuadratura gaussiana con 2 puntos (es decir, \( n = 2 \)).

1. **Obtenemos los puntos de Gauss y los pesos correspondientes** para \( n = 2 \). Para el intervalo \( [-1, 1] \), los puntos y pesos son:
   - \( x_1 = -\frac{1}{\sqrt{3}} \approx -0.577 \), \( x_2 = \frac{1}{\sqrt{3}} \approx 0.577 \)
   - \( w_1 = w_2 = 1 \)

2. **Transformamos el intervalo \( [0, 1] \) a \( [-1, 1] \)** utilizando la relación de cambio de variable:
   
   Para la integral de \( f(x) \) en \( [0, 1] \), la transformación es:
   $$ x = \frac{b-a}{2} t + \frac{a+b}{2} $$
   donde \( t \) está en \( [-1, 1] \) y \( a = 0 \), \( b = 1 \), por lo que:
   $$ x = \frac{1-0}{2} t + \frac{1+0}{2} = \frac{t+1}{2} $$

3. **Evaluamos la integral usando la fórmula de cuadratura gaussiana**:
   
   La integral aproximada es:
   $$ I \approx \frac{1}{2} \sum_{i=1}^{2} w_i f\left( \frac{1}{2}(x_i + 1) \right) $$

   Sustituyendo los valores de \( x_1 \), \( x_2 \), y \( w_1 \), \( w_2 \):

   $$ I \approx \frac{1}{2} \left[ 1 \cdot e^{-(0.577)^2} + 1 \cdot e^{-(0.577)^2} \right] $$

   Evaluamos:

   $$ I \approx \frac{1}{2} \left[ e^{-0.333} + e^{-0.333} \right] \approx \frac{1}{2} [0.716 + 0.716] = 0.716 $$

**Resultado:** La integral aproximada es \( I \approx 0.716 \), que es una buena aproximación del valor real de la integral de \( e^{-x^2} \) en el intervalo \( [0, 1] \).

---

### [Codigo en Java](CuadraturaGaussiana.java)

```java

import java.util.Scanner;
import java.util.function.Function;

public class CuadraturaGaussiana {
    // Instanciación de Scanner para leer la entrada del usuario
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Mensaje introductorio y descripción del método de cuadratura gaussiana
        System.out.println("INTEGRACIÓN NUMÉRICA (CUADRATURA GAUSSIANA)");
        System.out.println("---------------------------------------------");
        
        // Solicita al usuario que ingrese la función matemática
        System.out.println("Introduzca la función (use 'x' como variable, ej: exp(x)*cos(x)): ");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> f = x -> evaluarFuncion(funcionStr.replace("x", String.valueOf(x)));
        
        // Se crea una función anónima para evaluar la expresión con el valor de 'x'
        System.out.println("Introduzca el límite inferior de integración (a): ");
        double a = scanner.nextDouble();
        
        // Solicita los límites de integración
        System.out.println("Introduzca el límite superior de integración (b): ");
        double b = scanner.nextDouble();
        
        // Calcula la integral usando la cuadratura gaussiana de 2 puntos
        double integral = gauss2Puntos(f, a, b);
        
        // Muestra el resultado de la integral calculada
        System.out.println("\nRESULTADO:");
        System.out.printf("La integral de f(x) en el intervalo [%.4f, %.4f] ≈ %.12f%n", a, b, integral);
        System.out.println("Fórmula utilizada: Cuadratura Gaussiana de 2 puntos");
    }

    /**
     * Método que implementa la cuadratura gaussiana de 2 puntos para la integración numérica.
     * 
     * @param f Función matemática a integrar.
     * @param a Límite inferior de integración.
     * @param b Límite superior de integración.
     * @return Valor aproximado de la integral en el intervalo [a, b].
     */
    private static double gauss2Puntos(Function<Double, Double> f, double a, double b) {
        double[] puntos = { -Math.sqrt(1.0 / 3), Math.sqrt(1.0 / 3) };
        double[] pesos = { 1.0, 1.0 }; 
        
        double c1 = (b - a) / 2.0;
        double c2 = (b + a) / 2.0;
        
        double resultado = 0.0;
        for (int i = 0; i < puntos.length; i++) {
            double x = c1 * puntos[i] + c2;
            resultado += pesos[i] * f.apply(x);
        }
        
        return c1 * resultado;
    }

    /**
     * Método para evaluar una expresión matemática representada como un String.
     * 
     * @param expr Expresión matemática que contiene la variable 'x'.
     * @return El valor numérico resultante de la evaluación de la expresión.
     */
    private static double evaluarFuncion(String expr) {
         try {
            return new Object() {
                int pos = -1, ch;
                
                // Método para avanzar al siguiente carácter en la expresión
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
               
                // Método principal que inicia el proceso de evaluación
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char)ch);
                    return x;
                }
               
                 // Método para analizar una expresión matemática con operadores básicos
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
               
                // Método para analizar los términos (productos y divisiones)
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else if (eat('^')) x = Math.pow(x, parseFactor());
                        else return x;
                    }
                }
               
                // Método para analizar factores (números y funciones)
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

// Te odiamos un poquito y te amamos Efren <3

```

### [Caso de Prueba](Casos_de_Prueba) 

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



