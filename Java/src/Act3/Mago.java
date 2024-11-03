package Act3;

public class Mago extends Personaje {
    private Hechizo hechizo;

    public Mago(String nombre, int puntosVida, int puntosAtaque, Hechizo hechizo) {
        super(nombre, puntosVida, puntosAtaque);
        this.hechizo = hechizo;
    }

    public void lanzarHechizo(Personaje enemigo) {
        if (hechizo == null) {
            System.out.println(nombre + " no tiene un hechizo preparado.");
        } else {
            System.out.println(nombre + " lanza el hechizo " + hechizo.getNombre() + " a " + enemigo.getNombre());
            enemigo.recibirDanio(hechizo.getPoder());
        }
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println(nombre + " ataca con su bastón a " + enemigo.getNombre());
        enemigo.recibirDanio(puntosAtaque);
    }
}
