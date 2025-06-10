## PROG-UD7-Ficheritos

## Gestión de Ficheros en Java

Este proyecto contiene ejercicios para practicar operaciones con archivos en Java, como lectura, escritura, serialización y fusión de contenido.

📋 Actividades

1. Guardar Texto Formateado
   Clase: Actividad1

Qué hace :

Pide un texto de mínimo 30 caracteres.

Lo convierte a MAYÚSCULAS y reemplaza espacios por \_.

Guarda el resultado en ficheros/actividad1.txt.

2. Mostrar Códigos Decimales de Caracteres
   Clase: Actividad2

Qué hace:

Crea un archivo con un texto de ejemplo.

Muestra cada carácter con su código ASCII (ej: H_72).

3. Fusionar Archivos
   Clase: Actividad3

Qué hace:

Combina el contenido de actividad1.txt y actividad2.txt.

Guarda el resultado en ficheros/actividad3.txt con un formato específico.

4. Guardar y Recuperar Objetos (Mesas)
   Clase: Actividad4

Qué hace:

Menú interactivo para:

Crear mesas (color, número de patas).

Mostrar todas las mesas guardadas.

Los datos se guardan en ficheros/mesas.dat (serialización).

⚙️ Cómo Ejecutar
Clona el repositorio.

Asegúrate de tener Java instalado.

Compila y ejecuta cada actividad desde tu IDE favorito o con:

bash
javac -d bin src/actividadX/\*.java
java -cp bin actividadX.ActividadX
(Reemplaza X por el número de actividad).

📂 Archivos Generados
actividad1.txt: Texto en mayúsculas y sin espacios.

actividad2.txt: Texto de ejemplo para leer caracteres.

actividad3.txt: Fusión de los dos archivos anteriores.

mesas.dat: Datos de mesas en formato binario.

🔹 Notas
Requisitos: Java 8+.

Carpeta ficheros: Se crea automáticamente al ejecutar el código.

Serialización: La clase Mesa implementa Serializable para guardar objetos.

🎯 Objetivo: Aprender a manejar archivos en Java (texto y binarios) con ejercicios prácticos.
