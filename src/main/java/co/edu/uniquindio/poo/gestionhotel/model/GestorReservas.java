package co.edu.uniquindio.poo.gestionhotel.model;

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

    //-------------------CRUD Reservas--------------------//

    /**
     * Método para buscar una reserva por su id.
     *
     * @param id de la reserva
     * @return Reserva encontrada o null si no existe.
     */
    public Reserva buscarReserva(String id) {

        if (id == null) {
            throw new IllegalArgumentException("No se ingresó un id valido.");
        }

        for (Reserva reserva : reservas) {
            if(reserva.getId().equals(id)) {
                return reserva;
            }

        }

        return null;
    }

    /**
     * Método para agregar una nueva reserva.
     *
     * @param reserva Reserva a agregar.
     */
    public void agregarReserva(Reserva reserva) {

        if (reserva == null) {
            throw new IllegalArgumentException("No se ingresó la reserva que se desea agregar.");
        }

        if(buscarReserva(reserva.getId()) != null) {
            System.out.println("Ya existe un servicio con ese id.");
        }

        reservas.add(reserva);
        System.out.println("Reserva agregada exitosamente.");

        /**if (buscarReserva(reserva.getFechaEntrada(), reserva.getCliente().getDni(), reserva.getHabitacion().getNumero()) != null) {
            System.out.println("La habitación ya se encuentra registrada.");
            return;
        }*/

    }

    /**
     * Método para actualizar los datos de una reserva.
     *
     * @praam id de la reserva
     * @param actualizada Reserva con los nuevos datos.
     */
    public void actualizarReserva(String id, Reserva actualizada) {

        if (actualizada == null) {
            throw new IllegalArgumentException("Los datos de la reserva actualizada no pueden ser nulos.");
        }

        Reserva reserva = buscarReserva(id);
        if (reserva != null) {
            reserva.setFechaEntrada(actualizada.getFechaEntrada());
            reserva.setFechaSalida(actualizada.getFechaSalida());
            reserva.setCliente(actualizada.getCliente());
            reserva.setHabitacion(actualizada.getHabitacion());
            System.out.println("Reserva actualizada exitosamente.");
        } else {
            System.out.println("No existe una reserva con los datos ingresados.");
        }
    }

    /**
     * Método para eliminar una reserva.
     *
     * @param id de la reserva
     */
    public void eliminarReserva(String id) {

        if (id == null) {
            throw new IllegalArgumentException("El id ingresado no puede ser nulos.");
        }

        Reserva reserva = buscarReserva(id);
        if (reserva != null) {
            reservas.remove(reserva);
            System.out.println("Reserva eliminada exitosamente.");
        } else {
            System.out.println("No existe una reserva con los datos ingresados.");
        }
    }

    //-----------------------------------------------------//

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

    @Override
    public String toString() {
        return "GestorReservas{" +
                "reservas=" + reservas +
                '}';
    }

    //-----------------------------------------------------//

}
