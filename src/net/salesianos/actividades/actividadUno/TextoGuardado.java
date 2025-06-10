package net.salesianos.actividades.actividadUno;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextoGuardado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String texto;

        // a) Crear un fichero
        File archivo = new File("ficheros/actividadUno.txt");

        // b) Solicitar texto con longitud mínima de 30 caracteres
        do {
            System.out.print("Introduce un texto (mínimo 30 caracteres): ");
            texto = scanner.nextLine();

            if (texto.length() < 30) {
                System.out.println("Te faltan " + (30 - texto.length()) + " caracteres.");
            }
        } while (texto.length() < 30);

        // c) Formatear texto (mayúsculas y espacios por barrabajas)
        String textoFormateado = texto.toUpperCase().replace(" ", "_");

        // d) Guardar texto formateado en el fichero
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(textoFormateado);
            System.out.println("Texto guardado en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
