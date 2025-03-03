package co.edu.uniquindio.poo.gestionhotel.app;

import co.edu.uniquindio.poo.gestionhotel.model.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();
    }
}

class MenuPrincipal {
    private final MenuReservas menuReservas;
    private final MenuClientes menuClientes;
    private final MenuHabitaciones menuHabitaciones;
    private final MenuServicios menuServicios;
    private final MenuExtra menuExtra;

    public MenuPrincipal() {
        Hotel hotel = new Hotel("Hotel");
        //Datos de prueba
        Habitacion habitacion1 = new Habitacion("101", tipoHabitacion.SIMPLE, 90000);
        Habitacion habitacion2 = new Habitacion("102", tipoHabitacion.DOBLE, 120000);
        Habitacion habitacion3 = new Habitacion("103", tipoHabitacion.SUITE, 200000);
        Habitacion habitacion4 = new Habitacion("104", tipoHabitacion.SIMPLE, 95000);
        Habitacion habitacion5 = new Habitacion("105", tipoHabitacion.DOBLE, 125000);
        hotel.agregarHabitacion(habitacion1);
        hotel.agregarHabitacion(habitacion2);
        hotel.agregarHabitacion(habitacion3);
        hotel.agregarHabitacion(habitacion4);
        hotel.agregarHabitacion(habitacion5);

        Cliente cliente1 = new Cliente("Raul","001");
        Cliente cliente2 = new Cliente("Robinson Eduardo","002");
        Cliente cliente3 = new Cliente("Roberta","003");
        hotel.agregarCliente(cliente1);
        hotel.agregarCliente(cliente2);
        hotel.agregarCliente(cliente3);


        this.menuReservas = new MenuReservas(hotel);
        this.menuClientes = new MenuClientes(hotel);
        this.menuHabitaciones = new MenuHabitaciones(hotel);
        this.menuServicios = new MenuServicios(hotel);
        this.menuExtra = new MenuExtra(hotel);
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion=-1;

        do {
            System.out.print("""
        
        ==========================================
        |       BIENVENIDO AL MENÚ PRINCIPAL      |
        ==========================================
        | 1. Gestión de Reservas                 |
        | 2. Gestión de Clientes                 |
        | 3. Gestión de Habitaciones             |
        | 4. Gestión de Servicios                |
        | 5. Funciones extra                     |
        | 6. Salir                               |
        ==========================================
        
        Seleccione una opción:""");



            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next();
                continue;
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuReservas.mostrarMenu();
                    break;
                case 2:
                    menuClientes.mostrarMenu();
                    break;
                case 3:
                    menuHabitaciones.mostrarMenu();
                    break;
                case 4:
                    menuServicios.mostrarMenu();
                    break;
                case 5:
                    menuExtra.mostrarMenu();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
