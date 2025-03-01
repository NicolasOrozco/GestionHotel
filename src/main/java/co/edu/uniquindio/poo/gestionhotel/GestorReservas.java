package co.edu.uniquindio.poo.gestionhotel;

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
    public boolean verificarReserva(String dniCliente, String numeroHabitacion){
        boolean verificado = false;
        for(Reserva reserva : reservas){
            if(reserva.getCliente().getDni().equals(dniCliente)&&reserva.getHabitacion().getNumero().equals(numeroHabitacion)){
                verificado = true;
            }
        }
        return verificado;
    }
    public void agregarReserva(Reserva reserva){
        try {
            if (verificarReserva(reserva.getCliente().getDni(), reserva.getHabitacion().getNumero())) {
            }
            reservas.add(reserva);
            System.out.println("Reserva agregada con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void actualizarReservas(String dniCliente, String numeroHabitacion, Habitacion actualizada){
        try{
            boolean verificado = false;
            for(Reserva reserva: reservas)
            {
                if(reserva.getCliente().getDni().equals(dniCliente)&&reserva.getHabitacion().getNumero().equals(numeroHabitacion)){
                    reserva.setFechaEntrada(actualizada.getFechaEntrada());
                    reserva.setFechaSalida(actualizada.getFechaSalida());
                    reserva.setCliente(actualizada.getCliente());
                    reserva.setHabitacion(actualizada.getHabitacion());
                    verificado = true;
                }
            }
            if(!verificado){
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
