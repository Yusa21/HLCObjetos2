package Act2;

public class Habitacion {
    private int numero;
    private boolean disponible;

    public Habitacion(int numero, boolean disponible) {
        this.numero = numero;
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void ocupar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}

