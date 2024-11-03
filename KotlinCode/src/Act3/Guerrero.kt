package Act3

class Guerrero(nombre: String?, puntosVida: Int, puntosAtaque: Int) : Personaje(nombre, puntosVida, puntosAtaque) {
    override fun atacar(enemigo: Personaje) {
        println(nombre + " ataca con fuerza a " + enemigo.nombre)
        enemigo.recibirDanio(puntosAtaque)
    }


}

