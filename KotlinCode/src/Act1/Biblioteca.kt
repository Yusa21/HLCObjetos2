package Act1

import java.util.ArrayList

class Biblioteca {
    private val libros: MutableList<Libro>
    private val usuarios: MutableList<Usuario>

    init {
        libros = ArrayList<Libro>()
        usuarios = ArrayList<Usuario>()
    }

    fun agregarLibro(libro: Libro) {
        libros.add(libro)
        println("Libro agregado: " + libro.titulo)
    }

    fun registrarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        println("Usuario registrado: " + usuario.nombre)
    }

    fun prestarLibro(titulo: String?, usuarioId: Int) {
        val libro = buscarLibro(titulo)
        val usuario = buscarUsuario(usuarioId)

        if (libro == null) {
            println("El libro " + titulo + " no existe en la biblioteca.")
            return
        }

        if (usuario == null) {
            println("El usuario con ID " + usuarioId + " no está registrado.")
            return
        }

        if (libro.isPrestado()) {
            println("El libro " + titulo + " ya está prestado.")
        } else {
            libro.prestar()
            println("El libro " + titulo + " ha sido prestado a " + usuario.nombre)
        }
    }

    fun devolverLibro(titulo: String?) {
        val libro = buscarLibro(titulo)

        if (libro == null) {
            println("El libro " + titulo + " no existe en la biblioteca.")
            return
        }

        if (!libro.isPrestado()) {
            println("El libro " + titulo + " no está prestado.")
        } else {
            libro.devolver()
            println("El libro " + titulo + " ha sido devuelto.")
        }
    }

    private fun buscarLibro(titulo: String?): Libro? {
        for (libro in libros) {
            if (libro.titulo.equals(titulo, ignoreCase = true)) {
                return libro
            }
        }
        return null
    }

    private fun buscarUsuario(id: Int): Usuario? {
        for (usuario in usuarios) {
            if (usuario.id == id) {
                return usuario
            }
        }
        return null
    }
}

