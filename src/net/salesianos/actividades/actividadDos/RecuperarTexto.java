package net.salesianos.actividades.actividadDos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RecuperarTexto {
    public static void main(String[] args) {
        // a) Crear fichero y escribir texto
        File archivo = new File("ficheros/actividadDos");
        String textoOriginal = "Hola, pibe."; // Texto de ejemplo

        // Escribir el texto en el fichero
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(textoOriginal);
            System.out.println("Fichero creado en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
            return;
        }

        // b) Leer el fichero y mostrar cada carácter con su código decimal
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            StringBuilder resultado = new StringBuilder();

            while ((linea = reader.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    char caracter = linea.charAt(i);
                    int codigoDecimal = (int) caracter;
                    resultado.append(caracter).append("_").append(codigoDecimal);

                    // Agregar coma separadora (excepto después del último carácter)
                    if (i < linea.length() - 1) {
                        resultado.append(", ");
                    }
                }
            }

            System.out.println("Resultado:");
            System.out.println(resultado.toString());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
