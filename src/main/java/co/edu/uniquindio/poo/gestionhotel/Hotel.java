package co.edu.uniquindio.poo.gestionhotel;

import java.util.LinkedList;

public class Hotel {
    public String nombre;
    public LinkedList<Cliente> clientes;
    public LinkedList<Habitacion> habitaciones;
    protected GestorServicios gestorServicios;
    protected GestorReservas gestorReservas;

    /**
     * Constructor público de la clase
     * @param nombre del hotel
     */
    public Hotel(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
        habitaciones = new LinkedList<>();
        this.gestorServicios = gestorServicios.getInstancia();
        this.gestorReservas = gestorReservas.getInstancia();
    }

    //-----------Getters y Setters de la clase-------------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public LinkedList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(LinkedList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public GestorServicios getGestorServicios() {
        return gestorServicios;
    }

    public void setGestorServicios(GestorServicios gestorServicios) {
        this.gestorServicios = gestorServicios;
    }

    public GestorReservas getGestorReservas() {
        return gestorReservas;
    }

    public void setGestorReservas(GestorReservas gestorReservas) {
        this.gestorReservas = gestorReservas;
    }
}
