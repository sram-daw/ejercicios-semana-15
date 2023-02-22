# Ejercicios semana 15 PROGRAMACIÓN: La liga

## Anotaciones previas
Vamos a hacer un ejercicio en el que practicaremos un poco el uso de listas
dinámicas, herencia, interfaces, etc. El ejercicio es un poco más abierto que
de costumbre, pero es necesario comenzar a enfrentarse a estos ejercicios.
Es recomendable realizar un diagrama de clases y de flujo previa a la
implementación.

## Ejercicio
Se solicita crear un programa que simule una liga de fútbol por jornadas.
El programa debe mostrar un menú con las siguientes opciones:
- Crear nueva liga. Debe pedir un nombre para la liga y rellenar con
equipos la liga (22 equipos)
- Jugar liga. Solo debe permitirlo si una liga está creada. Este abrirá un
submenú:
  - Siguiente jornada. Simula 11 partidos
  - Consultar tabla. Muestra, en orden de puntuación descendente,
  los equipos.
  - Pausar liga. Devuelve al menú anterior.
  - Eliminar liga actual. Solicitará confirmación del usuario y elimina todos
  los datos de la liga actual. Solo debe poder hacerse si hay una liga
  creada.
  - Salir. Termina el programa.

  **Varias especificaciones:**
- Los equipos se enfrentan entre ellos 2 veces, ida y vuelta. No se
enfrentará un equipo contra sí mismo.
- De cada equipo se solicita tener información de:
  - Partidos jugados
  - Goles a favor
  - Goles en contra
  - Victorias
  - Derrotas
  - Empates
  - Puntuación
- No se calculará una victoria o derrota, si no que se calcularán los goles
que mete cada equipo y se comparará entre ellos quien metió más
goles o si hay empate.
- Se debe crear una interfaz para “liga”, con una clase “liga_futbol”
para especificar la liga de fútbol.
- Métodos comunes podrían ser “calcular jornada”, por ejemplo.
- Se debe crear una interfaz “equipo”, con una clase “equipo_futbol”
para especificar que se trata de un equipo de fútbol.
- Se puede incluso añadir una clase abstracta en vez de una
interfaz si se cree conveniente.
- La liga debe contener un array de equipos.