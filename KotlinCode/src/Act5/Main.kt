package Act5

import java.util.ArrayList

fun main(args: Array<String>) {
    val usuarios: MutableList<Usuario> = ArrayList()
    val proyectos: MutableList<Proyecto> = ArrayList()

    inicializarDatosEjemplo(usuarios, proyectos)

    var opcion: Int
    do {
        mostrarMenu()
        opcion = readln().toIntOrNull() ?: -1

        when (opcion) {
            1 -> listarProyectos(proyectos)
            2 -> crearNuevoProyecto(usuarios, proyectos)
            3 -> agregarTareaAProyecto(usuarios, proyectos)
            4 -> marcarTareaComoCompletada(proyectos)
            5 -> listarTareasDeProyecto(proyectos)
            6 -> listarUsuarios(usuarios)
            0 -> println("¡Hasta luego!")
            else -> println("Opción no válida")
        }
    } while (opcion != 0)
}

private fun mostrarMenu() {
    println("\n=== GESTOR DE TAREAS ===")
    println("1. Listar proyectos")
    println("2. Crear nuevo proyecto")
    println("3. Agregar tarea a proyecto")
    println("4. Marcar tarea como completada")
    println("5. Listar tareas de un proyecto")
    println("6. Listar usuarios")
    println("0. Salir")
    print("Seleccione una opción: ")
}

private fun inicializarDatosEjemplo(usuarios: MutableList<Usuario>, proyectos: MutableList<Proyecto>) {
    // Crear usuarios de ejemplo
    val juan = Usuario("Juan", "juan@email.com", null)
    val ana = Usuario("Ana", "ana@email.com", null)
    usuarios.add(juan)
    usuarios.add(ana)

    // Crear proyecto de ejemplo
    val proyectoWeb = juan.crearProyecto("Desarrollo Web")
    proyectos.add(proyectoWeb)

    // Crear tareas de ejemplo
    val tarea1 = Tarea("Diseñar interfaz", "Crear mockups de la interfaz", ana, "2024-12-01",false)
    val tarea2 = Tarea("Implementar backend", "Desarrollar API REST", juan, "2024-12-15", false)
    proyectoWeb.agregarTarea(tarea1)
    proyectoWeb.agregarTarea(tarea2)
}

private fun listarProyectos(proyectos: List<Proyecto>) {
    println("\nLista de Proyectos:")
    for (i in proyectos.indices) {
        val proyecto = proyectos[i]
        println("${i + 1}. ${proyecto.nombre} (Propietario: ${proyecto.propietario?.nombre})")
    }
}

private fun crearNuevoProyecto(usuarios: List<Usuario>, proyectos: MutableList<Proyecto>) {
    println("\nCrear Nuevo Proyecto")
    print("Nombre del proyecto: ")
    val nombreProyecto = readln()

    listarUsuarios(usuarios)
    print("Seleccione el número del propietario: ")
    val indiceUsuario = readln().toIntOrNull() ?: 0
    val indiceAjustado = indiceUsuario - 1

    if (indiceAjustado in 0 until usuarios.size) {
        val propietario = usuarios[indiceAjustado]
        val nuevoProyecto = propietario.crearProyecto(nombreProyecto)
        proyectos.add(nuevoProyecto)
        println("Proyecto creado exitosamente")
    } else {
        println("Usuario no válido")
    }
}

private fun agregarTareaAProyecto(usuarios: List<Usuario>, proyectos: List<Proyecto>) {
    listarProyectos(proyectos)
    print("Seleccione el número del proyecto: ")
    val indiceProyecto = readln().toIntOrNull() ?: 0
    val indiceProyectoAjustado = indiceProyecto - 1

    if (indiceProyectoAjustado in 0 until proyectos.size) {
        print("Nombre de la tarea: ")
        val nombreTarea = readln()
        print("Descripción: ")
        val descripcion = readln()
        print("Fecha límite (YYYY-MM-DD): ")
        val fechaLimite = readln()

        listarUsuarios(usuarios)
        print("Seleccione el número del responsable: ")
        val indiceResponsable = readln().toIntOrNull() ?: 0
        val indiceResponsableAjustado = indiceResponsable - 1

        if (indiceResponsableAjustado in 0 until usuarios.size) {
            val nuevaTarea = Tarea(
                nombreTarea, descripcion,
                usuarios[indiceResponsableAjustado], fechaLimite, false)
            proyectos[indiceProyectoAjustado].agregarTarea(nuevaTarea)
            println("Tarea agregada exitosamente")
        } else {
            println("Responsable no válido")
        }
    } else {
        println("Proyecto no válido")
    }
}

private fun marcarTareaComoCompletada(proyectos: List<Proyecto>) {
    listarProyectos(proyectos)
    print("Seleccione el número del proyecto: ")
    val indiceProyecto = readln().toIntOrNull() ?: 0
    val indiceProyectoAjustado = indiceProyecto - 1

    if (indiceProyectoAjustado in 0 until proyectos.size) {
        val proyecto = proyectos[indiceProyectoAjustado]
        val tareas = proyecto.listarTareas()

        println("\nTareas del proyecto:")
        for (i in tareas.indices) {
            val tarea = tareas[i]
            println("${i + 1}. ${tarea?.nombre} ${if (tarea?.estaCompletada() == true) "(Completada)" else "(Pendiente)"}")
        }

        print("Seleccione el número de la tarea a completar: ")
        val indiceTarea = readln().toIntOrNull() ?: 0
        val indiceTareaAjustado = indiceTarea - 1

        if (indiceTareaAjustado in 0 until tareas.size) {
            tareas[indiceTareaAjustado]?.marcarComoCompletada()
            println("Tarea marcada como completada")
        } else {
            println("Tarea no válida")
        }
    } else {
        println("Proyecto no válido")
    }
}

private fun listarTareasDeProyecto(proyectos: List<Proyecto>) {
    listarProyectos(proyectos)
    print("Seleccione el número del proyecto: ")
    val indiceProyecto = readln().toIntOrNull() ?: 0
    val indiceProyectoAjustado = indiceProyecto - 1

    if (indiceProyectoAjustado in 0 until proyectos.size) {
        val proyecto = proyectos[indiceProyectoAjustado]
        println("\nTareas del proyecto ${proyecto.nombre}:")

        val tareas = proyecto.listarTareas()
        for (i in tareas.indices) {
            val tarea = tareas[i]
            println("${i + 1}. ${tarea?.nombre} (Responsable: ${tarea?.responsable?.nombre}) - ${if (tarea?.estaCompletada() == true) "Completada" else "Pendiente"}")
        }
    } else {
        println("Proyecto no válido")
    }
}

private fun listarUsuarios(usuarios: List<Usuario>) {
    println("\nLista de Usuarios:")
    for (i in usuarios.indices) {
        val usuario = usuarios[i]
        println("${i + 1}. ${usuario.nombre}")
    }
}