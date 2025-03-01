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
     *
     * @return instancia única de GestorServicios.
     */
    public static GestorServicios getInstancia() {
        if (instancia == null) {
            instancia = new GestorServicios();
        }
        return instancia;
    }

    //---------------------CRUD SERVICIO-------------------//
    public boolean verificarServicio(Servicio servicio) {
        return servicios.contains(servicio);
    }

    public void agregarServicio(Servicio servicio) {
        if (!verificarServicio(servicio)) {
            servicios.add(servicio);
        } else {
            System.out.println("El servicio ya existe");
        }
    }

    public void actualizarServicio(Class<? extends Servicio> tipoServicio, Servicio servicioActualizado, String id) {
        try {
            boolean existe = false;
            for (Servicio servicio : servicios) {
                if (servicio.getId().equals(id) && servicio.getClass().equals(tipoServicio)) {
                    servicio = servicioActualizado;
                    existe = true;
                    System.out.println("Servicio actualizado exitosamente");
                    break;
                }
            }
            if (!existe) {
                throw new Exception("Servicio no encontrado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void eliminarServicio(String id) {
        try{
            boolean existe = false;
            for(Servicio servicio : servicios){
                if(servicio.getId().equals(id)){
                    servicios.remove(servicio);
                    System.out.println("Servicio eliminado exitosamente");
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                throw new Exception("Servicio no encontrado");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
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
    }

