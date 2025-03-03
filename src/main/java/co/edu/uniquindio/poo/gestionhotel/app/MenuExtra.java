package co.edu.uniquindio.poo.gestionhotel.app;

import co.edu.uniquindio.poo.gestionhotel.model.Hotel;

import java.util.Scanner;

public class MenuExtra {
    static Scanner scanner = new Scanner(System.in);
    private final Hotel hotel;

    public MenuExtra(Hotel hotel) {
        this.hotel = hotel;
    }

    public void mostrarMenu() {
        int opcion=-1;
        do {
            System.out.print("""
        
        ==========================================
        |              OPCIONES EXTRA            |
        ==========================================
        | 1. Contar habitaciones                 |
        | 2. Calcular porcentaje de ocupación    |
        | 3. Obtener habitación más barata       |
        | 4. Volver al Menú Principal            |
        ==========================================
        
        Seleccione una opción:""");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next();
                continue;
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    contarHabitaciones();
                    break;
                case 2:
                    calcularPorcentajeOcupacion();
                    break;
                case 3:
                    obtenerHabitacionMasBarataDisponible();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }while(opcion!= 4);
    }

    public void contarHabitaciones(){
        System.out.println("Actualmente hay " + hotel.contarHabitacionesDisponibles() + " habitaciones disponibles");
    }

    public void calcularPorcentajeOcupacion(){
        System.out.println("El porcentaje de ocupación del hotel es de " + hotel.calcularPorcentajeOcupacion() + "%");
    }

    public void obtenerHabitacionMasBarataDisponible(){
        if(hotel.obtenerHabitacionMasBarataDisponible() == null){
            System.out.println("No hay habitaciones disponibles");
            return;
        }
        System.out.println("La habitación más barata disponible es la número " + hotel.obtenerHabitacionMasBarataDisponible().getNumero());
    }
}
