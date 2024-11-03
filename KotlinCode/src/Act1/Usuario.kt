package Act1


class Usuario(var nombre: String?, var id: Int) {

    override fun toString(): String {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}'
    }
}

