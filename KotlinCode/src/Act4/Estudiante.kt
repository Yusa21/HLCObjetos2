package Act4

import java.util.HashMap

internal class Estudiante(var nombre: String?,
                          var id: Int,
                          var calificaciones: MutableMap<Curso?, Double?>?) {

    fun registrarCurso(curso: Curso?) {
        calificaciones?.containsKey(curso)?.let {
            if (!it) {
                calificaciones?.put(curso, null)
            }
        }
    }

    fun agregarCalificacion(curso: Curso?, calificacion: Double) {
        if (calificaciones?.containsKey(curso) == true) {
            calificaciones?.put(curso, calificacion)
        } else {
            println("El estudiante no está registrado en este curso.")
        }
    }

    fun calcularPromedio(): Double {
        var suma = 0.0
        var contador = 0
        for (calificacion in calificaciones?.values!!) {
            if (calificacion != null) {
                suma += calificacion
                contador++
            }
        }
        if (contador < 0) {
            return 0.0
        } else {
            return suma / contador
        }
    }

    override fun toString(): String {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", promedio=" + calcularPromedio() +
                '}'
    }
}
