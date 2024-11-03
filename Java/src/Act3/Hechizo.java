package Act3;

public class Hechizo {
    private String nombre;
    private int poder;

    public Hechizo(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoder() {
        return poder;
    }

    @Override
    public String toString() {
        return nombre + " (poder: " + poder + ")";
    }
}

