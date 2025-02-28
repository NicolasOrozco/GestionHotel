package co.edu.uniquindio.poo.gestionhotel;

import java.time.LocalDate;

public class Reserva {

    private LocalDate fechaEntrada, fechaSalida;
    private Cliente cliente;
    private Habitacion habitacion;

    /**
     * Constructor público de la clase
     * @param fechaEntrada
     * @param fechaSalida
     * @param cliente
     * @param habitacion
     */
    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Cliente cliente, Habitacion habitacion) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

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
}
