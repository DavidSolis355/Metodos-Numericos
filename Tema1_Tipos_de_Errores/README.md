# Errores en Métodos Numéricos

## Introducción

En el estudio de los métodos numéricos, uno de los conceptos más fundamentales es el de **error numérico**. Este surge debido a que, en la práctica, la mayoría de los cálculos se realizan de forma aproximada, ya sea por limitaciones del sistema de cómputo o por simplificaciones en el modelo matemático. Comprender los distintos tipos de errores es esencial para interpretar correctamente los resultados obtenidos mediante algoritmos numéricos.

## ¿Qué es un error numérico?

Un **error numérico** es la diferencia entre el valor exacto de una cantidad matemática y el valor que obtenemos mediante un proceso de cálculo aproximado. Este error es inevitable en la mayoría de los casos y puede originarse por diversas razones, como el uso de decimales limitados, fórmulas aproximadas o cálculos iterativos.

## Tipos de errores

Entre los errores más comunes que se presentan en métodos numéricos están:

- **[Error Relativo](Error_Relativo_y_Absoluto/Error_Relativo)**: Diferencia directa entre el valor verdadero y el aproximado.
    
- **[Error Absoluto](Error_Relativo_y_Absoluto/Error_Absoluto)**: Error absoluto dividido por el valor verdadero.

- **[Error de Cancelación](Otros_Tipos_de_Errores/Error_de_Cancelacion)**: Pérdida de cifras significativas al restar dos números muy cercanos.

- **[Error de Redondeo](Otros_Tipos_de_Errores/Error_de_Redondeo)**: Error introducido al redondear un número a un número limitado de cifras decimales.

- **[Error de Truncamiento](Otros_Tipos_de_Errores/Error_de_Truncamiento)**: Error que se produce al eliminar parte de la expansión decimal sin redondear.

- **[Error de Convergencia](Otros_Tipos_de_Errores/Error_de_Convergencia/)**: Diferencia entre iteraciones sucesivas en métodos iterativos, usado para estimar el progreso hacia la solución.

## Conceptos clave

- **Cifras significativas**: Dígitos válidos en un número que contribuyen a su precisión.
- **Precisión**: Cercanía de un valor a su valor verdadero.
- **Exactitud**: Nivel de coincidencia entre el valor medido y el valor real.
- **Estabilidad numérica**: Capacidad de un algoritmo para controlar el crecimiento de errores internos.

## Importancia de estudiar los errores

Estudiar los errores es importante porque permite:

- Evaluar la **confiabilidad de los resultados** obtenidos numéricamente.
- Diseñar algoritmos más **precisos y estables**.
- Estimar si un método **converge** correctamente hacia una solución.
- Determinar cuántas **iteraciones o cifras** son necesarias para alcanzar una precisión deseada.
- Tomar decisiones fundamentadas al usar modelos matemáticos en ingeniería, física, economía, etc.

Comprender la naturaleza de los errores y su comportamiento permite aplicar los métodos numéricos de forma efectiva y consciente, asegurando que los resultados obtenidos sean útiles en la práctica real.

---

> Este documento forma parte de una serie de materiales dedicados a los fundamentos de los métodos numéricos y los tipos de errores más comunes en su estudio.
