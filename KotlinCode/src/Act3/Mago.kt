package Act3

class Mago(nombre: String?, puntosVida: Int, puntosAtaque: Int, var hechizo: Hechizo) :
    Personaje(nombre, puntosVida, puntosAtaque) {

        fun lanzarHechizo(enemigo: Personaje) {
        if (hechizo == null) {
            println(nombre + " no tiene un hechizo preparado.")
        } else {
            println(nombre + " lanza el hechizo " + hechizo.nombre + " a " + enemigo.nombre)
            enemigo.recibirDanio(hechizo.poder)
        }
    }

    override fun atacar(enemigo: Personaje) {
        println(nombre + " ataca con su bastón a " + enemigo.nombre)
        enemigo.recibirDanio(puntosAtaque)
    }
}
