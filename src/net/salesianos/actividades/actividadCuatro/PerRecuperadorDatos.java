package net.salesianos.actividades.actividadCuatro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase Mesa con serialización
class Mesa implements Serializable {
    private String color;
    private int numPatas;

    public Mesa(String color, int numPatas) {
        this.color = color;
        this.numPatas = numPatas;
    }

    @Override
    public String toString() {
        return String.format("Mesa {Color: %s, Patas: %d}", color, numPatas);
    }
}

public class PerRecuperadorDatos {

    private static final String ARCHIVO = "ficheros/mesas.dat";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear nueva mesa");
            System.out.println("2. Mostrar todas las mesas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearMesa();
                    break;
                case 2:
                    mostrarMesas();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void crearMesa() {
        System.out.print("Ingrese el color de la mesa: ");
        String color = scanner.nextLine();

        System.out.print("Ingrese el número de patas: ");
        int patas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Mesa nuevaMesa = new Mesa(color, patas);
        guardarMesa(nuevaMesa);
        System.out.println("✔ Mesa guardada correctamente.");
    }

    private static void guardarMesa(Mesa mesa) {
        List<Mesa> mesas = cargarMesas();
        mesas.add(mesa);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(mesas);
        } catch (IOException e) {
            System.err.println("✖ Error al guardar la mesa: " + e.getMessage());
        }
    }

    private static void mostrarMesas() {
        List<Mesa> mesas = cargarMesas();

        if (mesas.isEmpty()) {
            System.out.println("No hay mesas almacenadas.");
        } else {
            System.out.println("\n--- MESAS ALMACENADAS ---");
            mesas.forEach(System.out::println);
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Mesa> cargarMesas() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists())
            return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Mesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("✖ Error al cargar las mesas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
