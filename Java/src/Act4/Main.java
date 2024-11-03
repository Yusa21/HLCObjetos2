package Act4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<Curso> cursos = new ArrayList<>();
    private static ArrayList<Profesor> profesores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear cursos de ejemplo
        Curso matematicas = new Curso("Matemáticas", "MAT101");
        Curso historia = new Curso("Historia", "HIS201");
        cursos.add(matematicas);
        cursos.add(historia);

        // Crear estudiantes de ejemplo
        Estudiante estudiante1 = new Estudiante("Juan Pérez", 1);
        Estudiante estudiante2 = new Estudiante("Ana López", 2);
        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);

        // Crear profesor y asignar cursos
        Profesor profesor = new Profesor("Carlos Rodríguez");
        profesor.asignarCurso(matematicas);
        profesor.asignarCurso(historia);
        profesores.add(profesor);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarEstudianteEnCurso();
                case 2 -> asignarCalificacion();
                case 3 -> mostrarPromediosEstudiantes();
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú de Gestión Escolar");
        System.out.println("1. Registrar estudiante en un curso");
        System.out.println("2. Asignar calificación a un estudiante");
        System.out.println("3. Mostrar promedios de estudiantes");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }


    private static void registrarEstudianteEnCurso() {
        System.out.println("Seleccione el estudiante:");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
        }
        int estudianteIndex = scanner.nextInt() - 1;

        System.out.println("Seleccione el curso:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombreCurso());
        }
        int cursoIndex = scanner.nextInt() - 1;

        System.out.println("Seleccione el profesor:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println((i + 1) + ". " + profesores.get(i).getNombre());
        }
        int profesorIndex = scanner.nextInt() - 1;

        Profesor profesor = profesores.get(profesorIndex);
        Estudiante estudiante = estudiantes.get(estudianteIndex);
        Curso curso = cursos.get(cursoIndex);

        profesor.registrarEstudianteEnCurso(estudiante, curso);
    }

    private static void asignarCalificacion() {
        System.out.println("Seleccione el estudiante:");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
        }
        int estudianteIndex = scanner.nextInt() - 1;

        System.out.println("Seleccione el curso:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombreCurso());
        }
        int cursoIndex = scanner.nextInt() - 1;

        System.out.print("Ingrese la calificación: ");
        double calificacion = scanner.nextDouble();

        Estudiante estudiante = estudiantes.get(estudianteIndex);
        Curso curso = cursos.get(cursoIndex);

        for (Profesor profesor : profesores) {
            if (profesor != null) {
                profesor.asignarCalificacion(estudiante, curso, calificacion);
                return;
            }
        }
        System.out.println("Error: No se encontró un profesor que imparta este curso.");
    }

    private static void mostrarPromediosEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
