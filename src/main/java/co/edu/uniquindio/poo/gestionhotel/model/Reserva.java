package co.edu.uniquindio.poo.gestionhotel.model;

import java.time.LocalDate;

public class Reserva {

    private String id;
    private LocalDate fechaEntrada, fechaSalida;
    private Cliente cliente;
    private Habitacion habitacion;

    /**
     * Constructor público de la clase
     * @param id
     * @param fechaEntrada
     * @param fechaSalida
     * @param cliente
     * @param habitacion
     */
    public Reserva(String id, LocalDate fechaEntrada, LocalDate fechaSalida, Cliente cliente, Habitacion habitacion) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.habitacion = habitacion;
        habitacion.setDisponibilidad(false);
    }
    /*
    * Metodo para ajustar la disponibilidad de la habitacion dependiendo de la fecha
    * */

    //-----------Getters y Setters de la clase-------------//

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @Override
    public String toString() {
        return "Reserva{" +
                "fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", cliente=" + cliente +
                ", habitacion=" + habitacion +
                ", id='" + id +
                '}';
    }
}
