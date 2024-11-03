package Act1


class Libro(var titulo: String?, var autor: String?, var prestado: Boolean) {

    fun isPrestado(): Boolean {
        return prestado
    }

    fun prestar() {
        prestado = true
    }

    fun devolver() {
        prestado = false
    }

    override fun toString(): String {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", prestado=" + prestado +
                '}'
    }
}