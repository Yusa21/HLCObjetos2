package Act3;

public class Guerrero extends Personaje {

    public Guerrero(String nombre, int puntosVida, int puntosAtaque) {
        super(nombre, puntosVida, puntosAtaque);
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println(nombre + " ataca con fuerza a " + enemigo.getNombre());
        enemigo.recibirDanio(puntosAtaque);
    }
}

