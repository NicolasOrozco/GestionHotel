package co.edu.uniquindio.poo.gestionhotel.app;

import co.edu.uniquindio.poo.gestionhotel.model.*;

import java.util.Scanner;

public class MenuServicios {
    private Scanner scanner;
    private Hotel hotel;

    public MenuServicios(Hotel hotel) {
        this.hotel =hotel;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(){
        int opcion=-1;
        do {
            System.out.print("""
        
        ==========================================
        |             MENÚ DE SERVICIOS          |
        ==========================================
        | 1. Pedir Servicio de Limpieza          |
        | 2. Pedir Servicio de Restaurante       |
        | 3. Pedir Servicio de Spa               |
        | 4. Volver al Menú Principal            |
        ==========================================
        
        Ingresa una opción:""");



            if (!scanner.hasNextInt()) {
                System.out.println("Entrada invalida. Debe ingresar un numero.");
                scanner.next();
                continue;
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    pedirServicioLimpieza();
                    break;
                case 2:
                    pedirServicioRestaurante();
                    break;
                case 3:
                    pedirServicioSpa();
                case 4:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida. Debe ingresar un numero.");

            }
        }while(opcion!=4);
    }

    public void pedirServicioLimpieza(){
        hotel.getGestorServicios().buscarServicio("Servicio limpieza").consumir();
    }

    public void pedirServicioRestaurante(){
        hotel.getGestorServicios().buscarServicio("Servicio restaurante").consumir();
    }

    public void pedirServicioSpa(){
        hotel.getGestorServicios().buscarServicio("Servicio spa").consumir();
    }


}
