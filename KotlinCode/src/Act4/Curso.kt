package Act4

internal class Curso(var nombreCurso: String?, var codigoCurso: String?) {

    override fun toString(): String {
        return nombreCurso + " (" + codigoCurso + ")"
    }
}