package Act3


fun main() {
    // Creamos hechizos de ejemplo
    val bolaDeFuego = Hechizo("Bola de Fuego", 40)

    val personaje1: Personaje = Guerrero("Organ", 100, 20)
    val personaje2: Personaje = Mago("Zacar", 80, 10, bolaDeFuego)

    var turnoPersonaje1 = true // Indica de quién es el turno

    println("--- Comienza el combate ---")

    while (personaje1.estaVivo() && personaje2.estaVivo()) {
        if (turnoPersonaje1) {
            println("\nTurno de " + personaje1.nombre)
            ejecutarAccion(personaje1, personaje2)
        } else {
            println("\nTurno de " + personaje2.nombre)
            ejecutarAccion(personaje2, personaje1)
        }
        turnoPersonaje1 = !turnoPersonaje1 // Alterna el turno
    }

    println("\n--- Fin del combate ---")
    if (personaje1.estaVivo()) {
        println(personaje1.nombre + " ha ganado el combate. Vida restante: " + personaje1.puntosVida)
    } else {
        println(personaje2.nombre + " ha ganado el combate. Vida restante: " + personaje2.puntosVida)
    }
}

private fun ejecutarAccion(atacante: Personaje, enemigo: Personaje) {
    if (atacante is Mago) {
        // Si el personaje es un Mago, preguntar si quiere lanzar un hechizo o atacar con el bastón
        print("¿Quieres lanzar un hechizo o atacar con el bastón? (h/b): ")
        val accion = readln()

        if (accion.equals("h", ignoreCase = true)) {
            atacante.lanzarHechizo(enemigo)
        } else {
            atacante.atacar(enemigo)
        }
    } else {
        // Si es un guerrero solo ataque
        atacante.atacar(enemigo)
    }
}



