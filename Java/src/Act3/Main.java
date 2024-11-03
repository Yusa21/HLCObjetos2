package Act3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creamos hechizos de ejemplo
        Hechizo bolaDeFuego = new Hechizo("Bola de Fuego", 40);

        Personaje personaje1 = new Guerrero("Organ", 100, 20);
        Personaje personaje2 = new Mago("Zacar", 80, 10, bolaDeFuego);

        Scanner scanner = new Scanner(System.in);
        boolean turnoPersonaje1 = true;  // Indica de quién es el turno

        System.out.println("--- Comienza el combate ---");

        while (personaje1.estaVivo() && personaje2.estaVivo()) {
            if (turnoPersonaje1) {
                System.out.println("\nTurno de " + personaje1.getNombre());
                ejecutarAccion(personaje1, personaje2, scanner);
            } else {
                System.out.println("\nTurno de " + personaje2.getNombre());
                ejecutarAccion(personaje2, personaje1, scanner);
            }
            turnoPersonaje1 = !turnoPersonaje1;  // Alterna el turno
        }

        System.out.println("\n--- Fin del combate ---");
        if (personaje1.estaVivo()) {
            System.out.println(personaje1.getNombre() + " ha ganado el combate. Vida restante: " + personaje1.getPuntosVida());
        } else {
            System.out.println(personaje2.getNombre() + " ha ganado el combate. Vida restante: " + personaje2.getPuntosVida());
        }

        scanner.close();
    }

    private static void ejecutarAccion(Personaje atacante, Personaje enemigo, Scanner scanner) {
        if (atacante instanceof Mago) {
            // Si el personaje es un Mago, preguntar si quiere lanzar un hechizo o atacar con el bastón
            System.out.print("¿Quieres lanzar un hechizo o atacar con el bastón? (h/b): ");
            String accion = scanner.nextLine();

            if (accion.equalsIgnoreCase("h")) {
                ((Mago) atacante).lanzarHechizo(enemigo);
            } else {
                atacante.atacar(enemigo);
            }
        } else {
            // Si es un guerrero solo ataque
            atacante.atacar(enemigo);
        }
    }
}


