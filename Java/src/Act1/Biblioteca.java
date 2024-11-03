package Act1;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public void prestarLibro(String titulo, int usuarioId) {
        Libro libro = buscarLibro(titulo);
        Usuario usuario = buscarUsuario(usuarioId);

        if (libro == null) {
            System.out.println("El libro " + titulo + " no existe en la biblioteca.");
            return;
        }

        if (usuario == null) {
            System.out.println("El usuario con ID " + usuarioId + " no está registrado.");
            return;
        }

        if (libro.isPrestado()) {
            System.out.println("El libro " + titulo + " ya está prestado.");
        } else {
            libro.prestar();
            System.out.println("El libro " + titulo + " ha sido prestado a " + usuario.getNombre());
        }
    }

    public void devolverLibro(String titulo) {
        Libro libro = buscarLibro(titulo);

        if (libro == null) {
            System.out.println("El libro " + titulo + " no existe en la biblioteca.");
            return;
        }

        if (!libro.isPrestado()) {
            System.out.println("El libro " + titulo + " no está prestado.");
        } else {
            libro.devolver();
            System.out.println("El libro " + titulo + " ha sido devuelto.");
        }
    }

    private Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    private Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}

