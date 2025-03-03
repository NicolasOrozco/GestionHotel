package co.edu.uniquindio.poo.gestionhotel.model;

public class ServicioRestaurante extends Servicio implements Consumible{

    public ServicioRestaurante(String id) {
        super(id);
    }

    @Override
    public void consumir() {
        System.out.println("Se ha consumido el servicio de restaurante.");
    }
}
