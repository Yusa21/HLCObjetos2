package Act5;

import java.util.ArrayList;
import java.util.List;

class Proyecto {
    private String nombre;
    private List<Tarea> tareas;
    private Usuario propietario;

    public Proyecto(String nombre, Usuario propietario) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.remove(tarea);
    }

    public List<Tarea> listarTareas() {
        return new ArrayList<>(tareas);
    }

    public List<Tarea> listarTareasCompletadas() {
        List<Tarea> tareasCompletadas = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.estaCompletada()) {
                tareasCompletadas.add(tarea);
            }
        }
        return tareasCompletadas;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario getPropietario() {
        return propietario;
    }
}

