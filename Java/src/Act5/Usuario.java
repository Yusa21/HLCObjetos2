package Act5;

import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nombre;
    private String email;
    private List<Proyecto> proyectos;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.proyectos = new ArrayList<>();
    }

    public Proyecto crearProyecto(String nombreProyecto) {
        Proyecto proyecto = new Proyecto(nombreProyecto, this);
        proyectos.add(proyecto);
        return proyecto;
    }

    public List<Proyecto> getProyectos() {
        return new ArrayList<>(proyectos);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}

