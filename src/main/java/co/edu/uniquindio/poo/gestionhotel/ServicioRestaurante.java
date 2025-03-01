package co.edu.uniquindio.poo.gestionhotel;



public class ServicioRestaurante extends Servicio implements Consumible{
    public ServicioRestaurante(String id) {
        super(id);
    }
    @Override
    public void servicioHabitacion() {
        System.out.println("Se está preparando la comida en el restaurante.");
    }

    @Override
    public void consumir() {
        System.out.println("Se ha consumido el servicio de restaurante.");
    }
}
