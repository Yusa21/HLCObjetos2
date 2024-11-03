package Act4

import java.util.ArrayList

internal class Profesor(
    var nombre: String?,
    private val cursos: ArrayList<Curso?>?
) {
    fun asignarCurso(curso: Curso?) {
        cursos?.add(curso)
    }

    fun registrarEstudianteEnCurso(estudiante: Estudiante, curso: Curso?) {
        if (cursos?.contains(curso) == true) {
            estudiante.registrarCurso(curso)
            println("Estudiante registrado en el curso: " + curso)
        } else {
            println("El profesor no imparte este curso.")
        }
    }

    fun asignarCalificacion(estudiante: Estudiante, curso: Curso?, calificacion: Double) {
        if (cursos?.contains(curso) == true) {
            estudiante.agregarCalificacion(curso, calificacion)
            println("Calificación asignada: " + calificacion)
        } else {
            println("El profesor no imparte este curso.")
        }
    }

    override fun toString(): String {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", cursos=" + cursos +
                '}'
    }
}
