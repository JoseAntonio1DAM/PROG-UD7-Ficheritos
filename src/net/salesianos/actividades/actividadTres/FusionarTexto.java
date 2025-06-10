package net.salesianos.actividades.actividadTres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FusionarTexto {
    public static void main(String[] args) {
        // a) Crear archivo para esta actividad
        Path archivoTres = Paths.get("ficheros/actividadTres.txt");
        try {
            Files.createFile(archivoTres);
            System.out.println("Archivo creado: " + archivoTres.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
            return;
        }

        // Fusionar contenido de actividad1.txt y actividad2.txt
        Path archivoUno = Paths.get("ficheros/actividad1.txt");
        Path archivoDos = Paths.get("ficheros/actividad2.txt");
        try {
            // Leer contenidos
            String contenidoUno = Files.readString(archivoUno);
            String contenidoDos = Files.readString(archivoDos);
            // Escribir estructura fusionada
            String estructuraFusionada = "- Contenido del Fichero Uno: " + contenidoUno + "\n" +
                    "- Contenido del Fichero Dos: " + contenidoDos + "\n";
            Files.writeString(archivoTres, estructuraFusionada, StandardOpenOption.WRITE);
            // c) Añadir firma
            String firma = "\nFirma: Fusionado por Actividad 3";
            Files.writeString(archivoTres, firma, StandardOpenOption.APPEND);
            System.out.println("✔ Contenidos fusionados en: " + archivoTres.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("✖ Error al fusionar archivos: " + e.getMessage());
        }
    }
}
