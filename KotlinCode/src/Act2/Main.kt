package Act2

import java.util.ArrayList

class SistemaReservas {
    private val habitaciones: MutableList<Habitacion> = ArrayList()
    private val clientes: MutableList<Cliente> = ArrayList()
    private val reservas: MutableList<Reserva> = ArrayList()

    init {
        // Crea habitaciones y clientes de ejemplo
        habitaciones.add(Habitacion(101, true))
        habitaciones.add(Habitacion(102, true))
        habitaciones.add(Habitacion(103, true))

        clientes.add(Cliente("Juan Pérez", 1))
        clientes.add(Cliente("Ana García", 2))
        clientes.add(Cliente("Carlos López", 3))
    }

    fun iniciar() {
        var continuar = true

        while (continuar) {
            println("\n--- Menú de Reservas de Hotel ---")
            println("1. Crear reserva")
            println("2. Cancelar reserva")
            println("3. Listar reservas activas")
            println("4. Salir")
            print("Seleccione una opción: ")

            when (readln().toIntOrNull()) {
                1 -> crearReserva()
                2 -> cancelarReserva()
                3 -> listarReservasActivas()
                4 -> {
                    println("Saliendo del sistema...")
                    continuar = false
                }
                else -> println("Opción inválida. Intente de nuevo.")
            }
        }
    }

    private fun crearReserva() {
        print("Ingrese el ID del cliente: ")
        val idCliente = readln().toIntOrNull() ?: return println("ID inválido")
        print("Ingrese el número de la habitación: ")
        val numeroHabitacion = readln().toIntOrNull() ?: return println("Número de habitación inválido")

        val cliente = buscarCliente(idCliente)
        val habitacion = buscarHabitacion(numeroHabitacion)

        if (cliente == null) {
            println("Cliente no encontrado.")
            return
        }

        if (habitacion == null || !habitacion.isDisponible()) {
            println("Habitación no disponible.")
            return
        }

        habitacion.ocupar()
        val reserva = Reserva(cliente, habitacion)
        reservas.add(reserva)
        println("Reserva realizada: $reserva")
    }

    private fun cancelarReserva() {
        print("Ingrese el número de la habitación para cancelar la reserva: ")
        val numeroHabitacion = readln().toIntOrNull() ?: return println("Número de habitación inválido")

        val reserva = buscarReservaPorHabitacion(numeroHabitacion)

        if (reserva == null) {
            println("No hay reservas activas para esta habitación.")
            return
        }

        reserva.habitacion.liberar()
        reservas.remove(reserva)
        println("Reserva cancelada para la habitación $numeroHabitacion")
    }

    private fun listarReservasActivas() {
        if (reservas.isEmpty()) {
            println("No hay reservas activas.")
        } else {
            println("Reservas activas:")
            for (reserva in reservas) {
                println(reserva)
            }
        }
    }

    private fun buscarCliente(id: Int): Cliente? {
        return clientes.find { it.id == id }
    }

    private fun buscarHabitacion(numero: Int): Habitacion? {
        return habitaciones.find { it.numero == numero }
    }

    private fun buscarReservaPorHabitacion(numeroHabitacion: Int): Reserva? {
        return reservas.find { it.habitacion.numero == numeroHabitacion }
    }
}

fun main(args: Array<String>) {
    val sistema = SistemaReservas()
    sistema.iniciar()
}