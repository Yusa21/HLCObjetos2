package Act5

internal class Usuario(var nombre: String?,
                       var email: String?,
                       var proyectos: MutableList<Proyecto?>?) {

    fun crearProyecto(nombreProyecto: String): Proyecto {
        val proyecto = Proyecto(nombreProyecto, this, null)
        proyectos?.add(proyecto)
        return proyecto
    }
}

