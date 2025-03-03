package co.edu.uniquindio.poo.gestionhotel.model;

public class ServicioLimpieza extends Servicio implements Consumible{

    public ServicioLimpieza(String id) {
        super(id);
    }

    @Override
    public void consumir() {
        System.out.println("Se ha consumido el servicio de limpieza.");
    }

}