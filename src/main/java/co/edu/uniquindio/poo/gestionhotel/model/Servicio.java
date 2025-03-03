package co.edu.uniquindio.poo.gestionhotel.model;

public abstract class Servicio implements Consumible{
    String id;

    /**
     * Método constructor de la clase servicio
     * @param id id del servicio
     */
    public Servicio(String id) {
        this.id = id;
    }

    @Override
    public void consumir(){}

    //-----------Getters y Setters de la clase-------------//

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    //-----------------------------------------------------//

}
