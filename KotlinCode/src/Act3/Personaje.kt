package Act3

abstract class Personaje(var nombre: String?, var puntosVida: Int, var puntosAtaque: Int) {

    fun recibirDanio(danio: Int) {
        puntosVida -= danio
        if (puntosVida < 0) puntosVida = 0
        println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida)
    }

    abstract fun atacar(enemigo: Personaje)

    fun estaVivo(): Boolean {
        return puntosVida > 0
    }
}

