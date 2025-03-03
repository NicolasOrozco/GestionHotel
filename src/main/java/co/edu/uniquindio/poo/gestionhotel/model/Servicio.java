package co.edu.uniquindio.poo.gestionhotel.model;

public abstract class Servicio {
    String id;
    public Servicio(String id) {
        this.id = id;
    }
    public abstract void servicioHabitacion();

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
