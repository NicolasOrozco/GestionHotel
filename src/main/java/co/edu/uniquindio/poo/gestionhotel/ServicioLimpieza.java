package co.edu.uniquindio.poo.gestionhotel;

public class ServicioLimpieza extends Servicio implements Consumible{
    public ServicioLimpieza(String id) {
        super(id);
    }
    @Override
    public void servicioHabitacion() {
        System.out.println("Se está realizando la limpieza de la habitación.");
    }

    @Override
    public void consumir() {
        System.out.println("Se ha consumido el servicio de limpieza.");
    }
}
