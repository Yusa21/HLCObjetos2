package Act2

class Reserva(var cliente: Cliente, var habitacion: Habitacion) {

    override fun toString(): String {
        return "Reserva{" +
                "cliente=" + cliente.nombre +
                ", habitacion=" + habitacion.numero +
                '}'
    }
}

