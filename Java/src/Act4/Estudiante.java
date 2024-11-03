package Act4;

import java.util.HashMap;
import java.util.Map;

class Estudiante {
    private String nombre;
    private int id;
    private Map<Curso, Double> calificaciones;

    public Estudiante(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.calificaciones = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void registrarCurso(Curso curso) {
        if (!calificaciones.containsKey(curso)) {
            calificaciones.put(curso, null);
        }
    }

    public void agregarCalificacion(Curso curso, double calificacion) {
        if (calificaciones.containsKey(curso)) {
            calificaciones.put(curso, calificacion);
        } else {
            System.out.println("El estudiante no está registrado en este curso.");
        }
    }

    public double calcularPromedio() {
        double suma = 0.0;
        int contador = 0;
        for (Double calificacion : calificaciones.values()) {
            if (calificacion != null) {
                suma += calificacion;
                contador++;
            }
        }
        if(contador < 0){
            return 0;
        }else{
            return  suma / contador;
        }

    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", promedio=" + calcularPromedio() +
                '}';
    }
}
