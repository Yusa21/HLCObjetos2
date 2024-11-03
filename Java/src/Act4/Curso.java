package Act4;

class Curso {
    private String nombreCurso;
    private String codigoCurso;

    public Curso(String nombreCurso, String codigoCurso) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    @Override
    public String toString() {
        return nombreCurso + " (" + codigoCurso + ")";
    }
}