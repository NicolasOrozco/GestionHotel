package co.edu.uniquindio.poo.gestionhotel;

import java.util.LinkedList;

public class GestorServicios {

    private static GestorServicios instancia;
    private LinkedList<Servicio> servicios;

    /**
     * Constructor privado para evitar la instanciación directa.
     * Inicia con una lista de servicios vacía.
     */
    private GestorServicios() {
        servicios = new LinkedList<>();
    }

    /**
     * Obtiene la única instancia de GestorServicios.
     * @return instancia única de GestorServicios.
     */
    public static GestorServicios getInstancia() {
        if (instancia == null) {
            instancia = new GestorServicios();
        }
        return instancia;
    }

    //-----------Getters y Setters de la clase-------------//

    public void setInstancia(GestorServicios instancia) {
        this.instancia = instancia;
    }

    public LinkedList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(LinkedList<Servicio> servicios) {
        this.servicios = servicios;
    }
}
