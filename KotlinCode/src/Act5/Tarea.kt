package Act5

internal class Tarea(
    var nombre: String?,
    var descripcion: String?,
    var responsable: Usuario?,
    var fechaLimite: String?,
    var completada: Boolean?
) {

    fun marcarComoCompletada() {
        this.completada = true
    }

    fun estaCompletada(): Boolean? {
        return completada
    }
}
