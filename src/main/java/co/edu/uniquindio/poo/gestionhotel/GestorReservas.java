package co.edu.uniquindio.poo.gestionhotel;

import java.time.LocalDate;
import java.util.LinkedList;

public class GestorReservas {

    private static GestorReservas instancia;
    public LinkedList<Reserva> reservas;

    /**
     * Constructor privado para evitar la instanciación directa.
     * Inicia con una lista de reservas vacía.
     */
    private GestorReservas() {
        reservas = new LinkedList<>();
    }

    /**
     * Obtiene la única instancia de GestorReservas.
     * @return instancia única de GestorReservas.
     */
    public static GestorReservas getInstancia() {
        if (instancia == null) {
            instancia = new GestorReservas();
        }
        return instancia;
    }
    //-------------------Cruds Reservas--------------------//

    public boolean verificarReserva(String dniCliente, String numeroHabitacion, LocalDate fechaEntrada) {
        boolean verificado = false;
        for(Reserva reserva : reservas){
            if(reserva.getCliente().getDni().equals(dniCliente) && reserva.getHabitacion().getNumero().equals(numeroHabitacion) && reserva.getFechaEntrada().equals(fechaEntrada)){
                verificado = true;
            }
        }
        return verificado;
    }

    public void agregarReserva(Reserva reserva){
        try {
            if (verificarReserva(reserva.getCliente().getDni(), reserva.getHabitacion().getNumero(),reserva.getFechaEntrada())) {
                throw new Exception("Ya existe una reserva con esos datos");
            }
            reservas.add(reserva);
            System.out.println("Reserva agregada con éxito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarReservas(String dniCliente, String numeroHabitacion, Reserva actualizada){
        try{
            boolean encontrado = false;
            for(Reserva reserva: reservas)
            {
                if(reserva.getCliente().getDni().equals(dniCliente) && reserva.getHabitacion().getNumero().equals(numeroHabitacion)){
                    reserva.setFechaEntrada(actualizada.getFechaEntrada());
                    reserva.setFechaSalida(actualizada.getFechaSalida());
                    reserva.setCliente(actualizada.getCliente());
                    reserva.setHabitacion(actualizada.getHabitacion());
                    System.out.println("Reserva actualizada");
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                System.out.println("Reserva no encontrada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarReserva(String dniCliente, String numeroHabitacion){
        try{
            boolean verificado = false;
            for(Reserva reserva: reservas){
                if(reserva.getCliente().getDni().equals(dniCliente)&&reserva.getHabitacion().getNumero().equals(numeroHabitacion)){
                    reservas.remove(reserva);
                    System.out.println("Reserva eliminada con exito");
                    verificado = true;
                    break;
                }
            }
            if(!verificado){
                System.out.println("Reserva no encontrada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //-----------Getters y Setters de la clase-------------//

    public void setInstancia(GestorReservas instancia) {
        this.instancia = instancia;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }
}
