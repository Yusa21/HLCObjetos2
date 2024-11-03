package Act2

class Habitacion(var numero: Int, var disponible: Boolean) {

    fun isDisponible(): Boolean {
        return disponible
    }

    fun ocupar() {
        disponible = false
    }

    fun liberar() {
        disponible = true
    }

    override fun toString(): String {
        return "Habitacion{" +
                "numero=" + numero + '\'' +
                ", disponible=" + disponible +
                '}'
    }
}

