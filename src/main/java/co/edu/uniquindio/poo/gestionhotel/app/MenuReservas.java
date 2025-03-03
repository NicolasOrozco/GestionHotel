package co.edu.uniquindio.poo.gestionhotel.app;

import co.edu.uniquindio.poo.gestionhotel.model.*;
import java.util.Scanner;
import java.time.LocalDate;

public class MenuReservas {
    static Scanner scanner = new Scanner(System.in);
    private final Hotel hotel;

    public MenuReservas(Hotel hotel) {
        this.hotel = hotel;
    }

    public void mostrarMenu() {
        int opcion=-1;
        do {
            System.out.print("""
        
        ==========================================
        |       MENÚ DE GESTIÓN DE RESERVAS       |
        ==========================================
        | 1. Lista de Reservas                   |
        | 2. Crear Reserva                       |
        | 3. Modificar Reserva                   |
        | 4. Eliminar Reserva                    |
        | 5. Volver al Menú Principal            |
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
                    mostrarListaReservas();
                    break;
                case 2:
                    crearReserva();
                    break;
                case 3:
                    modificarReserva();
                    break;
                case 4:
                    eliminarReserva();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 5);
    }


    private void mostrarListaReservas() {
        System.out.println("Lista de Reservas:");
        for(Reserva reserva: hotel.getGestorReservas().getReservas()){
            System.out.println(reserva);
        }
    }

    private Reserva ingresarReserva(){
        System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        LocalDate fechaEntrada = LocalDate.parse(scanner.nextLine());

        System.out.println("Ingrese la fecha de salida (YYYY-MM-DD): ");
        LocalDate fechaSalida = LocalDate.parse(scanner.nextLine());

        System.out.println("Ingrese el DNI del Cliente: ");
        Cliente cliente = hotel.buscarCliente(scanner.nextLine());

        System.out.println("Ingrese el número de la habitación: ");
        Habitacion habitacion = hotel.buscarHabitacion(scanner.nextLine());

        System.out.println("Ingrese el ID de la reserva: ");
        String id = scanner.nextLine();
        return new Reserva(id, fechaEntrada, fechaSalida, cliente, habitacion);
    }
    private void crearReserva() {
        hotel.getGestorReservas().agregarReserva(ingresarReserva());
        System.out.println("Reserva añadida exitosamente.");
    }

    private void modificarReserva() {
        System.out.println("Ingrese el ID de la reserva a modificar: ");
        String id = scanner.nextLine();
        Reserva reservaModificar = hotel.getGestorReservas().buscarReserva(id);

        if (reservaModificar == null) {
            System.out.println("Reserva no encontrada.");
            return;
        }
        System.out.println("Ingrese los nuevos atributos de la reserva ");
        hotel.getGestorReservas().actualizarReserva(id, ingresarReserva());

        System.out.println("Reserva modificada exitosamente.");
    }

    private void eliminarReserva() {
        System.out.println("Ingrese el ID de la reserva a eliminar: ");
        String id = scanner.nextLine();

        hotel.getGestorReservas().eliminarReserva(id);
        System.out.println("Reserva eliminada exitosamente.");
    }
}
