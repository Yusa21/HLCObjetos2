package Act4

import java.util.Scanner

fun main(args: Array<String>) {

    val estudiantes = ArrayList<Estudiante>()
    val cursos = ArrayList<Curso>()
    val profesores = ArrayList<Profesor>()

    // Crear cursos de ejemplo
    val matematicas = Curso("Matemáticas", "MAT101")
    val historia = Curso("Historia", "HIS201")
    cursos.add(matematicas)
    cursos.add(historia)

    // Crear estudiantes de ejemplo
    val estudiante1 = Estudiante("Juan Pérez", 1,null)
    val estudiante2 = Estudiante("Ana López", 2, null )
    estudiantes.add(estudiante1)
    estudiantes.add(estudiante2)

    // Crear profesor y asignar cursos
    val profesor = Profesor("Carlos Rodríguez", null)
    profesor.asignarCurso(matematicas)
    profesor.asignarCurso(historia)
    profesores.add(profesor)

    var opcion: Int
    do {
        mostrarMenu()
        opcion = readln().toInt()

        when (opcion) {
            1 -> registrarEstudianteEnCurso( estudiantes, cursos, profesores)
            2 -> asignarCalificacion(estudiantes, cursos, profesores)
            3 -> mostrarPromediosEstudiantes(estudiantes)
            4 -> println("Saliendo del sistema...")
            else -> println("Opción no válida. Intente de nuevo.")
        }
    } while (opcion != 4)
}

private fun mostrarMenu() {
    println("\nMenú de Gestión Escolar")
    println("1. Registrar estudiante en un curso")
    println("2. Asignar calificación a un estudiante")
    println("3. Mostrar promedios de estudiantes")
    println("4. Salir")
    print("Seleccione una opción: ")
}

private fun registrarEstudianteEnCurso(
    estudiantes: List<Estudiante>,
    cursos: List<Curso>,
    profesores: List<Profesor>
) {
    if (estudiantes.isEmpty() || cursos.isEmpty() || profesores.isEmpty()) {
        println("Error: No hay suficientes datos para realizar el registro.")
        return
    }

    println("Seleccione el estudiante:")
    estudiantes.forEachIndexed { index, estudiante ->
        println("${index + 1}. ${estudiante.nombre}")
    }
    val estudianteIndex = (readln().toInt() - 1).takeIf { it in estudiantes.indices } ?: return

    println("Seleccione el curso:")
    cursos.forEachIndexed { index, curso ->
        println("${index + 1}. ${curso.nombreCurso}")
    }
    val cursoIndex = (readln().toInt() - 1).takeIf { it in cursos.indices } ?: return

    println("Seleccione el profesor:")
    profesores.forEachIndexed { index, profesor ->
        println("${index + 1}. ${profesor.nombre}")
    }
    val profesorIndex = (readln().toInt() - 1).takeIf { it in profesores.indices } ?: return

    val profesor = profesores[profesorIndex]
    val estudiante = estudiantes[estudianteIndex]
    val curso = cursos[cursoIndex]

    profesor.registrarEstudianteEnCurso(estudiante, curso)
}

private fun asignarCalificacion(
    estudiantes: List<Estudiante>,
    cursos: List<Curso>,
    profesores: List<Profesor>
) {
    if (estudiantes.isEmpty() || cursos.isEmpty() || profesores.isEmpty()) {
        println("Error: No hay suficientes datos para asignar calificaciones.")
        return
    }

    println("Seleccione el estudiante:")
    estudiantes.forEachIndexed { index, estudiante ->
        println("${index + 1}. ${estudiante.nombre}")
    }
    val estudianteIndex = (readln().toInt() - 1).takeIf { it in estudiantes.indices } ?: return

    println("Seleccione el curso:")
    cursos.forEachIndexed { index, curso ->
        println("${index + 1}. ${curso.nombreCurso}")
    }
    val cursoIndex = (readln().toInt() - 1).takeIf { it in cursos.indices } ?: return

    print("Ingrese la calificación (0-10): ")
    val calificacion = readln().toDouble()
    if (calificacion !in 0.0..10.0) {
        println("Error: La calificación debe estar entre 0 y 10")
        return
    }

    val estudiante = estudiantes[estudianteIndex]
    val curso = cursos[cursoIndex]


}
 private fun mostrarPromediosEstudiantes(estudiantes: List<Estudiante>) {
    if (estudiantes.isEmpty()) {
        println("No hay estudiantes registrados.")
        return
    }

    println("\nPromedios de estudiantes:")
    estudiantes.forEach { estudiante ->
        println(estudiante)
    }
}

