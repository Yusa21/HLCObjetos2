package Act1

fun main() {
    val biblioteca = Biblioteca()
    var continuar = true

    while (continuar) {
        println("\n--- Menú de Biblioteca ---")
        println("1. Agregar libro")
        println("2. Registrar usuario")
        println("3. Prestar libro")
        println("4. Devolver libro")
        println("5. Salir")
        print("Seleccione una opción: ")

        val opcion = readln().toInt()


        when (opcion) {
            1 -> {
                print("Ingrese el título del libro: ")
                val tituloLibro = readln()
                print("Ingrese el autor del libro: ")
                val autorLibro = readln()
                val nuevoLibro = Libro(tituloLibro, autorLibro, false)
                biblioteca.agregarLibro(nuevoLibro)
            }

            2 -> {
                print("Ingrese el nombre del usuario: ")
                val nombreUsuario = readln()
                print("Ingrese el ID del usuario: ")
                val idUsuario = readln().toInt()
                val nuevoUsuario = Usuario(nombreUsuario, idUsuario)
                biblioteca.registrarUsuario(nuevoUsuario)
            }

            3 -> {
                print("Ingrese el título del libro a prestar: ")
                val tituloPrestar = readln()
                print("Ingrese el ID del usuario que lo solicita: ")
                val idPrestar = readln().toInt()
                biblioteca.prestarLibro(tituloPrestar, idPrestar)
            }

            4 -> {
                print("Ingrese el título del libro a devolver: ")
                val tituloDevolver = readln()
                biblioteca.devolverLibro(tituloDevolver)
            }

            5 -> {
                println("Saliendo del sistema...")
                continuar = false
            }

            else -> println("Opción inválida. Intente de nuevo.")
        }
    }
}


