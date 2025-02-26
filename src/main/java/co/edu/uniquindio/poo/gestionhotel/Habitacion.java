package co.edu.uniquindio.poo.gestionhotel;

public class Habitacion {
    private String nombre;
    private tipoHabitacion tipo;
    private double precio;
    private boolean disponibilidad;

    public Habitacion(String nombre, tipoHabitacion tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        disponibilidad = true;
    }
}
