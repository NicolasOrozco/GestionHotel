package co.edu.uniquindio.poo.gestionhotel;

import java.util.LinkedList;

public class Hotel {
    public String nombre;
    public LinkedList<Cliente> clientes;
    public LinkedList<Habitacion> habitaciones;
    protected GestorServicios gestorServicios;
    protected GestorReservas gestorReservas;

    /**
     * Constructor público de la clase
     * @param nombre del hotel
     */
    public Hotel(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
        habitaciones = new LinkedList<>();
        this.gestorServicios = gestorServicios.getInstancia();
        this.gestorReservas = gestorReservas.getInstancia();
    }


    //--------------------CRUD Cliente---------------------//

    /**
     * Método para evitar la creación de clientes duplicados
     * @param dni del cliente a crear
     * @return centinela indicando si actualmente existe una
     * instancia del cliente
     */
    public boolean verificarCliente(String dni) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Método para agregar un nuevo cliente
     * @param cliente a agregar
     */
    public void agregarCliente(Cliente cliente) {
        try {

            if(cliente == null){
                throw new Exception("No se ingresó el cliente que se desea agregar");
                //ret
            }

            if(verificarCliente(cliente.getDni())){
                System.out.println("El cliente ya se encuentra registrado");
                return;
            }

            clientes.add(cliente);
            System.out.println("Cliente agregado exitosamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     *
     *
     * Aquí iría el método para obtener un empleado (Read), no estoy seguro si debería devolver el empleado o el
     * toString entonces por ahora quedó así
     *
     *
     *
     */

    /**
     * Método para actualizar los datos de un cliente
     * @param dni del cliente a actualizar
     * @param actualizado
     */
    public void actualizarCliente(String dni, Cliente actualizado) {
        try{
            boolean encontrado = false;

            if(actualizado == null){
                throw new Exception("Los da");
            }
            for (Cliente cliente : clientes) {
                if (cliente.getDni().equals(dni)) {
                    cliente.setNombre(actualizado.getNombre());
                    cliente.setDni(actualizado.getDni());
                    encontrado = true;
                    System.out.println("Cliente actualizado exitosamente");
                    break;
                }
            }
            if(!encontrado){
                System.out.println("El DNI ingresado no coincide con ningún cliente registrado");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para eliminar un cliente
     * @param dni del cliente a eliminar
     */
    public void eliminarCliente(String dni) {
        try{
            boolean encontrado = false;
            for (Cliente cliente : clientes) {
                if (cliente.getDni().equals(dni)) {
                    clientes.remove(cliente);
                    System.out.println("Cliente eliminado exitosamente");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                throw new Exception("El DNI ingresado no coincide con ningún cliente registrado");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //-----------------------------------------------------//


    //-------------------CRUD Habitación-------------------//

    /**
     * Método para evitar la creación de habitaciones duplicadas
     * @param numero de la habitación a agregar
     * @return centinela indicando si actualmente existe una
     * instancia del cliente
     */
    public boolean verificarHabitacion(String numero) {
        boolean centinela = false;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numero)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Método para agregar una nueva habitación
     * @param habitacion a agregar
     */
    public void agregarHabitacion(Habitacion habitacion) {
        try {
           if (verificarHabitacion(habitacion.getNumero())) {
                throw new Exception("Ya existe una habitación con esos datos en la base de datos");
            }
            habitaciones.add(habitacion);
            System.out.println("Habitación agregada exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     *
     *
     * Aquí iría el método para obtener una habitación (Read), no estoy seguro si debería devolver la habitación o el
     * toString entonces por ahora quedó así
     *
     *
     *
     */

    /**
     * Método para actualizar los datos de una habitación
     * @param numero de la habitación a actualizar
     * @param actualizada
     */
    public void actualizarHabitacion(String numero, Habitacion actualizada) {
        try{
            boolean encontrado = false;
            for (Habitacion habitacion : habitaciones) {
                if (habitacion.getNumero().equals(numero)) {
                    habitacion.setNumero(actualizada.getNumero());
                    habitacion.setPrecio(actualizada.getPrecio());
                    habitacion.setTipo(actualizada.getTipo());
                    habitacion.setDisponibilidad(actualizada.isDisponibilidad());
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                throw new Exception("El número de habitación ingresado no coincide con ningúna habitación registrada");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para eliminar una habitación
     * @param numero de la habitación a eliminar
     */
    public void eliminarHabitacion(String numero) {
        try{
            boolean encontrada = false;
            for (Habitacion habitacion : habitaciones) {
                if (habitacion.getNumero().equals(numero)) {
                    habitaciones.remove(habitacion);
                    System.out.println("Habitación eliminada exitosamente");
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                throw new Exception("El número de habitación ingresado no coincide con ningúna habitación registrada");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //-----------------------------------------------------//


    //-----------Getters y Setters de la clase-------------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public LinkedList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(LinkedList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public GestorServicios getGestorServicios() {
        return gestorServicios;
    }

    public void setGestorServicios(GestorServicios gestorServicios) {
        this.gestorServicios = gestorServicios;
    }

    public GestorReservas getGestorReservas() {
        return gestorReservas;
    }

    public void setGestorReservas(GestorReservas gestorReservas) {
        this.gestorReservas = gestorReservas;
    }
}
