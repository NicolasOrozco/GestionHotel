package co.edu.uniquindio.poo.gestionhotel.model;

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
        ServicioLimpieza servicioLimpieza = new ServicioLimpieza("Servicio limpieza");
        ServicioRestaurante servicioRestaurante = new ServicioRestaurante("Servicio restaurante");
        ServicioSpa servicioSpa = new ServicioSpa("Servicio spa");
        servicios.add(servicioLimpieza);
        servicios.add(servicioRestaurante);
        servicios.add(servicioSpa);
    }

    /**
     * Obtiene la única instancia de GestorServicios.
     *
     * @return instancia única de GestorServicios.
     */
    public static GestorServicios getInstancia() {
        if (instancia == null) {
            instancia = new GestorServicios();
        }
        return instancia;
    }

    //---------------------CRUD Servicio-------------------//

    /**
     * Método para buscar un servicio por su id.
     *
     * @param id del servicio a buscar.
     * @return Servicio encontrado o null si no existe.
     */
    public Servicio buscarServicio(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id del servicio no puede ser nulo.");
        }

        for (Servicio servicio : servicios) {
            if (servicio.getId().equals(id)) {
                return servicio;
            }
        }

        return null;
    }

    /**
     * Método para agregar un nuevo servicio.
     *
     * @param servicio a agregar.
     */
    public void agregarServicio(Servicio servicio) {
        if (servicio == null) {
            throw new IllegalArgumentException("No se ingresó el servicio que se desea agregar.");
        }

        if (buscarServicio(servicio.getId()) != null) {
            System.out.println("El servicio ya se encuentra registrado.");
            return;
        }

        servicios.add(servicio);
        System.out.println("Servicio agregado exitosamente.");
    }

    /**
     * Método para actualizar los datos de un servicio.
     *
     * @param id      Id del servicio a actualizar.
     * @param actualizado Servicio con los nuevos datos.
     */
    public void actualizarServicio(String id, Servicio actualizado) {
        if (actualizado == null) {
            throw new IllegalArgumentException("Los datos del servicio actualizado no pueden ser nulos.");
        }

        Servicio servicio = buscarServicio(id);
        if (servicio != null) {
            servicio.setId(actualizado.getId());
            System.out.println("Servicio actualizado exitosamente.");
        } else {
            System.out.println("No existe un servicio con el id ingresado.");
        }
    }

    /**
     * Método para eliminar un servicio.
     *
     * @param id del servicio a eliminar.
     */
    public void eliminarServicio(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id del servicio no puede ser nulo.");
        }

        Servicio servicio = buscarServicio(id);
        if (servicio != null) {
            servicios.remove(servicio);
            System.out.println("Servicio eliminado exitosamente.");
        } else {
            System.out.println("No existe un servicio con el id ingresado.");
        }
    }

    //-----------------------------------------------------//

    //-----------Getters y Setters de la clase-------------//

    public void setInstancia (GestorServicios instancia){
            this.instancia = instancia;
        }

    public LinkedList<Servicio> getServicios () {
            return servicios;
        }

    public void setServicios (LinkedList < Servicio > servicios) {
            this.servicios = servicios;
        }

    //-----------------------------------------------------//

}