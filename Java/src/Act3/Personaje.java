package Act3;

public abstract class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected int puntosAtaque;

    public Personaje(String nombre, int puntosVida, int puntosAtaque) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.puntosAtaque = puntosAtaque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida < 0) puntosVida = 0;
        System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida);
    }

    public abstract void atacar(Personaje enemigo);

    public boolean estaVivo() {
        return puntosVida > 0;
    }
}

