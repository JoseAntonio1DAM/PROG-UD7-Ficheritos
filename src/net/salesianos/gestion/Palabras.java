package net.salesianos.gestion;

import java.util.Scanner;

public class Palabras {
    public void solicitarTexto() {
        Scanner scanner = new Scanner(System.in);
        String texto;
        final int MINIMO = 30;

        do {
            System.out.print("Introduce un texto (mínimo 30 caracteres): ");
            texto = scanner.nextLine();

            int longitud = texto.length();

            if (longitud < MINIMO) {
                int faltan = MINIMO - longitud;
                System.out.println("Faltan " + faltan + " caracteres. Intenta de nuevo.\n");
            }

        } while (texto.length() < MINIMO);

        System.out.println("¡Texto aceptado! Tiene " + texto.length() + " caracteres. y es "
                + texto.toUpperCase().replace(" ", "_"));
    }
}
