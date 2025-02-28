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
