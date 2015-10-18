# language: es
Característica: Sumar monedas

Escenario: Sumar monedas de tipos diferentes
Dado las monedas "UY$" 100 y "USD" 1
Y el tipo de cambio entre "USD" y "UY$" de 28
Cuando las sumo
Entonces el resultado es "UY$" 128

Escenario: Sumar monedas del mismo tipo
Dado las monedas "UY$" 100 y "UY$" 150
Cuando las sumo
Entonces el resultado es "UY$" 250   