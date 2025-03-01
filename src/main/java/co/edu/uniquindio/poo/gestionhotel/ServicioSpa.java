package co.edu.uniquindio.poo.gestionhotel;

public class ServicioSpa extends Servicio implements Consumible{
    public ServicioSpa(String id) {
        super(id);
    }
    @Override
    public void servicioHabitacion() {
        System.out.println("Se ha rializado el servicio de Spa.");
    }

    @Override
    public void consumir() {
        System.out.println("Consumido el servicio de Spa.");
    }
}
