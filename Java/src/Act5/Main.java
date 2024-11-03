package Act5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Proyecto> proyectos = new ArrayList<>();

    public static void main(String[] args) {
        inicializarDatosEjemplo();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listarProyectos();
                    break;
                case 2:
                    crearNuevoProyecto();
                    break;
                case 3:
                    agregarTareaAProyecto();
                    break;
                case 4:
                    marcarTareaComoCompletada();
                    break;
                case 5:
                    listarTareasDeProyecto();
                    break;
                case 6:
                    listarUsuarios();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== GESTOR DE TAREAS ===");
        System.out.println("1. Listar proyectos");
        System.out.println("2. Crear nuevo proyecto");
        System.out.println("3. Agregar tarea a proyecto");
        System.out.println("4. Marcar tarea como completada");
        System.out.println("5. Listar tareas de un proyecto");
        System.out.println("6. Listar usuarios");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void inicializarDatosEjemplo() {
        // Crear usuarios de ejemplo
        Usuario juan = new Usuario("Juan", "juan@email.com");
        Usuario ana = new Usuario("Ana", "ana@email.com");
        usuarios.add(juan);
        usuarios.add(ana);

        // Crear proyecto de ejemplo
        Proyecto proyectoWeb = juan.crearProyecto("Desarrollo Web");
        proyectos.add(proyectoWeb);

        // Crear tareas de ejemplo
        Tarea tarea1 = new Tarea("Diseñar interfaz", "Crear mockups de la interfaz", ana, "2024-12-01");
        Tarea tarea2 = new Tarea("Implementar backend", "Desarrollar API REST", juan, "2024-12-15");
        proyectoWeb.agregarTarea(tarea1);
        proyectoWeb.agregarTarea(tarea2);
    }

    private static void listarProyectos() {
        System.out.println("\nLista de Proyectos:");
        for (int i = 0; i < proyectos.size(); i++) {
            Proyecto p = proyectos.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() +
                    " (Propietario: " + p.getPropietario().getNombre() + ")");
        }
    }

    private static void crearNuevoProyecto() {
        System.out.println("\nCrear Nuevo Proyecto");
        System.out.print("Nombre del proyecto: ");
        String nombreProyecto = scanner.nextLine();

        listarUsuarios();
        System.out.print("Seleccione el número del propietario: ");
        int indiceUsuario = scanner.nextInt() - 1;

        if (indiceUsuario >= 0 && indiceUsuario < usuarios.size()) {
            Usuario propietario = usuarios.get(indiceUsuario);
            Proyecto nuevoProyecto = propietario.crearProyecto(nombreProyecto);
            proyectos.add(nuevoProyecto);
            System.out.println("Proyecto creado exitosamente");
        } else {
            System.out.println("Usuario no válido");
        }
    }

    private static void agregarTareaAProyecto() {
        listarProyectos();
        System.out.print("Seleccione el número del proyecto: ");
        int indiceProyecto = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer

        if (indiceProyecto >= 0 && indiceProyecto < proyectos.size()) {
            System.out.print("Nombre de la tarea: ");
            String nombreTarea = scanner.nextLine();
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();
            System.out.print("Fecha límite (YYYY-MM-DD): ");
            String fechaLimite = scanner.nextLine();

            listarUsuarios();
            System.out.print("Seleccione el número del responsable: ");
            int indiceResponsable = scanner.nextInt() - 1;

            if (indiceResponsable >= 0 && indiceResponsable < usuarios.size()) {
                Tarea nuevaTarea = new Tarea(nombreTarea, descripcion,
                        usuarios.get(indiceResponsable), fechaLimite);
                proyectos.get(indiceProyecto).agregarTarea(nuevaTarea);
                System.out.println("Tarea agregada exitosamente");
            } else {
                System.out.println("Responsable no válido");
            }
        } else {
            System.out.println("Proyecto no válido");
        }
    }

    private static void marcarTareaComoCompletada() {
        listarProyectos();
        System.out.print("Seleccione el número del proyecto: ");
        int indiceProyecto = scanner.nextInt() - 1;

        if (indiceProyecto >= 0 && indiceProyecto < proyectos.size()) {
            Proyecto proyecto = proyectos.get(indiceProyecto);
            List<Tarea> tareas = proyecto.listarTareas();

            System.out.println("\nTareas del proyecto:");
            for (int i = 0; i < tareas.size(); i++) {
                Tarea t = tareas.get(i);
                System.out.println((i + 1) + ". " + t.getNombre() +
                        (t.estaCompletada() ? " (Completada)" : " (Pendiente)"));
            }

            System.out.print("Seleccione el número de la tarea a completar: ");
            int indiceTarea = scanner.nextInt() - 1;

            if (indiceTarea >= 0 && indiceTarea < tareas.size()) {
                tareas.get(indiceTarea).marcarComoCompletada();
                System.out.println("Tarea marcada como completada");
            } else {
                System.out.println("Tarea no válida");
            }
        } else {
            System.out.println("Proyecto no válido");
        }
    }

    private static void listarTareasDeProyecto() {
        listarProyectos();
        System.out.print("Seleccione el número del proyecto: ");
        int indiceProyecto = scanner.nextInt() - 1;

        if (indiceProyecto >= 0 && indiceProyecto < proyectos.size()) {
            Proyecto proyecto = proyectos.get(indiceProyecto);
            System.out.println("\nTareas del proyecto " + proyecto.getNombre() + ":");

            List<Tarea> tareas = proyecto.listarTareas();
            for (int i = 0; i < tareas.size(); i++) {
                Tarea t = tareas.get(i);
                System.out.println((i + 1) + ". " + t.getNombre() +
                        " (Responsable: " + t.getResponsable().getNombre() + ")" +
                        " - " + (t.estaCompletada() ? "Completada" : "Pendiente"));
            }
        } else {
            System.out.println("Proyecto no válido");
        }
    }

    private static void listarUsuarios() {
        System.out.println("\nLista de Usuarios:");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            System.out.println((i + 1) + ". " + u.getNombre());
        }
    }
}

