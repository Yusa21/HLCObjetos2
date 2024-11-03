package Act5;

class Tarea {
    private String nombre;
    private String descripcion;
    private boolean completada;
    private Usuario responsable;
    private String fechaLimite;

    public Tarea(String nombre, String descripcion, Usuario responsable, String fechaLimite) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = false;
        this.responsable = responsable;
        this.fechaLimite = fechaLimite;
    }

    public void marcarComoCompletada() {
        this.completada = true;
    }

    public boolean estaCompletada() {
        return completada;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }
}
