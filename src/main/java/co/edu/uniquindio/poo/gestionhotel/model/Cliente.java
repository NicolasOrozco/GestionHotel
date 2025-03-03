package co.edu.uniquindio.poo.gestionhotel.model;

import java.util.LinkedList;

public class Cliente {

    private String nombre;
    private String dni;
    private LinkedList<Reserva> reservas;

    /**
     * Constructor público de la clase
     * @param nombre del cliente
     * @param dni del cliente
     */
    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        reservas = new LinkedList<>();
    }

    //-----------Getters y Setters de la clase-------------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", reservas=" + reservas +
                '}';
    }
}
