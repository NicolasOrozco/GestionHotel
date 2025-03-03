package co.edu.uniquindio.poo.gestionhotel.app;

import co.edu.uniquindio.poo.gestionhotel.model.*;
import java.util.Scanner;

class MenuClientes {
    private Scanner scanner;
    private Hotel hotel;

    public MenuClientes(Hotel hotel) {
        this.hotel = hotel;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion=-1;
        do {
            System.out.print("""
        
        ==========================================
        |     MENÚ DE GESTIÓN DE CLIENTES        |
        ==========================================
        | 1. Lista de Clientes                   |
        | 2. Buscar Cliente por ID               |
        | 3. Crear Cliente                       |
        | 4. Modificar Cliente                   |
        | 5. Eliminar Cliente                    |
        | 6. Volver al Menú Principal            |
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
                    mostrarListaClientes();
                    break;
                case 2:
                    buscarClientePorId();
                    break;
                case 3:
                    crearCliente();
                    break;
                case 4:
                    modificarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }while(opcion!= 6);
    }

    private void mostrarListaClientes(){
        System.out.println("\n--- Lista de Clientes---");
        for(Cliente cliente: hotel.getClientes()){
            System.out.println(cliente.toString());
        }
            }

    private Cliente ingresarCliente(){
        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el DNI: ");
        String dni = scanner.nextLine();

        return new Cliente(nombre, dni);

    }

    private void buscarClientePorId(){
        System.out.println("Ingrese el DNI del Cliente: ");
        System.out.println(hotel.buscarCliente(scanner.nextLine()).toString());

    }

    private void crearCliente(){
        hotel.agregarCliente(ingresarCliente());
    }

    private void modificarCliente(){
        System.out.println("Ingrese el DNI del Cliente: ");
        String dni = scanner.nextLine();

        Cliente clienteModificar=hotel.buscarCliente(dni);
        if (clienteModificar == null){
            System.out.println("El Cliente no existe");
            return;
        }

        hotel.actualizarCliente(dni,ingresarCliente());
        System.out.println("El Cliente se ha modificado correctamente");

    }

    private void eliminarCliente(){
        System.out.println("Ingrese el DNI del Cliente: ");
        String dni = scanner.nextLine();

        hotel.eliminarCliente(dni);
        System.out.println("El Cliente se eliminado correctamente");
    }
}
