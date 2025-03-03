package co.edu.uniquindio.poo.gestionhotel.model;

import java.util.LinkedList;

public class Habitacion {

    private String numero;
    private tipoHabitacion tipo;
    private double precio;
    private boolean disponibilidad;
    private LinkedList<Servicio> servicios;

    /**
     * Constructor público de la clase
     * @param numero
     * @param tipo
     * @param precio
     */
    public Habitacion(String numero, tipoHabitacion tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        disponibilidad = true;
        servicios = new LinkedList<>();
    }

    //-----------Getters y Setters de la clase-------------//

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public tipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(tipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public LinkedList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(LinkedList<Servicio> servicios) {
        this.servicios = servicios;
    }
}
