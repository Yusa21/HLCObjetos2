package Act4;

import java.util.ArrayList;

class Profesor {
    private String nombre;
    private ArrayList<Curso> cursos;

    public Profesor(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
    }

    public void asignarCurso(Curso curso) {
        cursos.add(curso);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void registrarEstudianteEnCurso(Estudiante estudiante, Curso curso) {
        if (cursos.contains(curso)) {
            estudiante.registrarCurso(curso);
            System.out.println("Estudiante registrado en el curso: " + curso);
        } else {
            System.out.println("El profesor no imparte este curso.");
        }
    }

    public void asignarCalificacion(Estudiante estudiante, Curso curso, double calificacion) {
        if (cursos.contains(curso)) {
            estudiante.agregarCalificacion(curso, calificacion);
            System.out.println("Calificación asignada: " + calificacion);
        } else {
            System.out.println("El profesor no imparte este curso.");
        }
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
