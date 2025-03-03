package co.edu.uniquindio.poo.gestionhotel.model;

public class ServicioSpa extends Servicio implements Consumible{

    public ServicioSpa(String id) {
        super(id);
    }

    @Override
    public void consumir() {
        System.out.println("Consumido el servicio de Spa.");
    }

}
