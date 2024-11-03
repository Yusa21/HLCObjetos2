package Act2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Habitacion> habitaciones = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();

    public static void main(String[] args) {
        // Crea habitaciones y clientes de ejemplo
        habitaciones.add(new Habitacion(101, true));
        habitaciones.add(new Habitacion(102, true));
        habitaciones.add(new Habitacion(103, true));

        clientes.add(new Cliente("Juan Pérez", 1));
        clientes.add(new Cliente("Ana García", 2));
        clientes.add(new Cliente("Carlos López", 3));

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú de Reservas de Hotel ---");
            System.out.println("1. Crear reserva");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Listar reservas activas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearReserva(scanner);
                    break;

                case 2:
                    cancelarReserva(scanner);
                    break;

                case 3:
                    listarReservasActivas();
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    private static void crearReserva(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Ingrese el número de la habitación: ");
        int numeroHabitacion = scanner.nextInt();

        Cliente cliente = buscarCliente(idCliente);
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        if (habitacion == null || !habitacion.isDisponible()) {
            System.out.println("Habitación no disponible.");
            return;
        }

        habitacion.ocupar();
        Reserva reserva = new Reserva(cliente, habitacion);
        reservas.add(reserva);
        System.out.println("Reserva realizada: " + reserva);
    }

    private static void cancelarReserva(Scanner scanner) {
        System.out.print("Ingrese el número de la habitación para cancelar la reserva: ");
        int numeroHabitacion = scanner.nextInt();

        Reserva reserva = buscarReservaPorHabitacion(numeroHabitacion);

        if (reserva == null) {
            System.out.println("No hay reservas activas para esta habitación.");
            return;
        }

        reserva.getHabitacion().liberar();
        reservas.remove(reserva);
        System.out.println("Reserva cancelada para la habitación " + numeroHabitacion);
    }

    private static void listarReservasActivas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas activas.");
        } else {
            System.out.println("Reservas activas:");
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    private static Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    private static Habitacion buscarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    private static Reserva buscarReservaPorHabitacion(int numeroHabitacion) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getNumero() == numeroHabitacion) {
                return reserva;
            }
        }
        return null;
    }
}
