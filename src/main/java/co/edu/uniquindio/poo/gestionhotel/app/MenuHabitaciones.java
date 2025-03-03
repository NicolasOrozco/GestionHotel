package co.edu.uniquindio.poo.gestionhotel.app;

import co.edu.uniquindio.poo.gestionhotel.model.*;

import java.util.Scanner;

class MenuHabitaciones {
    private final Hotel hotel;
    static Scanner scanner = new Scanner(System.in);

    public MenuHabitaciones(Hotel hotel) {
        this.hotel = hotel;
    }

    public void mostrarMenu() {
        int opcion=-1;

        do {
            System.out.print("""
        
        ==========================================
        |     MENÚ DE GESTIÓN DE HABITACIONES    |
        ==========================================
        | 1. Lista de Habitaciones               |
        | 2. Crear Habitación                    |
        | 3. Modificar Habitación                |
        | 4. Eliminar Habitación                 |
        | 5. Volver al Menú Principal            |
        ==========================================
        
        Seleccione una opción:""");



            System.out.println("Ingrese una opcion: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next();
                continue;
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    mostrarListaHabitaciones();
                    break;
                case 2:
                    crearHabitacion();
                    break;
                case 3:
                    modificarHabitacion();
                    break;
                case 4:
                    eliminarHabitacion();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal....");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }

    private void mostrarListaHabitaciones() {
        System.out.println("\n--- Lista Habitaciones ---");
        for(Habitacion habitacion: hotel.getHabitaciones()){
            System.out.println(habitacion.toString());
        }
    }

    private Habitacion ingresarHabitacion() {
        System.out.println("Ingrese el numero del habitacion: ");
        String numero  = scanner.nextLine();
        System.out.println("Ingrese el tipo de habitacion (SIMPLE, DOBLE, SUITE): ");
        tipoHabitacion  tipo = tipoHabitacion.valueOf(scanner.nextLine());
        System.out.println("Ingrese el precio de la habitacion");
        double precio = scanner.nextDouble();
        return  new Habitacion(numero, tipo, precio );
    }

    private void crearHabitacion(){
        hotel.agregarHabitacion(ingresarHabitacion());
        System.out.println("Habitacion añadida exitosamente");
    }

    private void modificarHabitacion(){
        System.out.println("Ingrese el numero de la habitacion a modificar: ");
        String numero = scanner.nextLine();
        Habitacion habitacionAModificar = hotel.buscarHabitacion(numero);

        if(habitacionAModificar == null){
            System.out.println("Habitacion no encontrada");
            return;
        }
        System.out.println("Ingrese los nuevos atributos de la habitacion ");
        hotel.actualizarHabitacion(numero, ingresarHabitacion());
        System.out.println("Habitacion modificada exitosamente");
    }


    private void eliminarHabitacion(){
        System.out.println("Ingrese el numero de la habitacion: ");
        String numero = scanner.nextLine();

        hotel.eliminarHabitacion(numero);
        System.out.println("Habitacion eliminada exitosamente");

    }

}
