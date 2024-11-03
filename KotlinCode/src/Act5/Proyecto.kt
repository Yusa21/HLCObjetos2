package Act5

import java.util.ArrayList

internal class Proyecto(var nombre: String?,
                        var propietario: Usuario?,
                        var tareas: MutableList<Tarea>?) {

    fun agregarTarea(tarea: Tarea?) {
        tareas?.add(tarea!!)
    }

    fun eliminarTarea(tarea: Tarea?) {
        tareas?.remove(tarea)
    }

    fun listarTareas(): MutableList<Tarea?> {
        return ArrayList<Tarea?>(tareas)
    }

    fun listarTareasCompletadas(): MutableList<Tarea?> {
        val tareasCompletadas: MutableList<Tarea?> = ArrayList<Tarea?>()
        if (tareas != null) {
            for (tarea in tareas) {
                if (tarea.estaCompletada() == true) {
                    tareasCompletadas.add(tarea)
                }
            }
        }
        return tareasCompletadas
    }
}

