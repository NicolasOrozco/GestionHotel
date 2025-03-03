package co.edu.uniquindio.poo.gestionhotel.model;

import java.util.LinkedList;

public class Hotel {
    public String nombre;
    public LinkedList<Cliente> clientes;
    public LinkedList<Habitacion> habitaciones;
    protected GestorServicios gestorServicios;
    protected GestorReservas gestorReservas;

    /**
     * Constructor público de la clase
     *
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
     * Método para buscar un cliente por su DNI.
     *
     * @param dni DNI del cliente a buscar.
     * @return Cliente encontrado o null si no existe.
     */
    public Cliente buscarCliente(String dni) {
        if (dni == null) {
            throw new IllegalArgumentException("El DNI no puede ser nulo.");
        }

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }

        return null;
    }

    /**
     * Método para agregar un nuevo cliente.
     *
     * @param cliente Cliente a agregar.
     */
    public void agregarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("No se ingresó el cliente que se desea agregar.");
        }

        if (buscarCliente(cliente.getDni()) != null) {
            System.out.println("El cliente ya se encuentra registrado.");
            return;
        }

        clientes.add(cliente);
        System.out.println("Cliente agregado exitosamente.");
    }

    /**
     * Método para actualizar los datos de un cliente.
     *
     * @param dni         DNI del cliente a actualizar.
     * @param actualizado Cliente con los nuevos datos.
     */
    public void actualizarCliente(String dni, Cliente actualizado) {
        if (actualizado == null) {
            throw new IllegalArgumentException("Los datos del cliente actualizado no pueden ser nulos.");
        }

        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            cliente.setDni(actualizado.getDni());
            cliente.setNombre(actualizado.getNombre());
            System.out.println("Cliente actualizado exitosamente.");
        } else {
            System.out.println("No existe un cliente con el DNI ingresado.");
        }
    }

    /**
     * Método para eliminar un cliente.
     *
     * @param dni DNI del cliente a eliminar.
     */
    public void eliminarCliente(String dni) {
        if (dni == null) {
            throw new IllegalArgumentException("El DNI no puede ser nulo.");
        }

        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("No existe un cliente con el DNI ingresado.");
        }
    }

    //-----------------------------------------------------//

    //-------------------CRUD Habitación-------------------//

    /**
     * Método para buscar una habitación por su número.
     *
     * @param numero Número de la habitación a buscar.
     * @return Habitación encontrada o null si no existe.
     */
    public Habitacion buscarHabitacion(String numero) {
        if (numero == null) {
            throw new IllegalArgumentException("El número de la habitación no puede ser nulo.");
        }

        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numero)) {
                return habitacion;
            }
        }

        return null;
    }

    /**
     * Método para agregar una nueva habitación.
     *
     * @param habitacion Habitación a agregar.
     */
    public void agregarHabitacion(Habitacion habitacion) {
        if (habitacion == null) {
            throw new IllegalArgumentException("No se ingresó la habitación que se desea agregar.");
        }

        if (buscarHabitacion(habitacion.getNumero()) != null) {
            System.out.println("La habitación ya se encuentra registrada.");
            return;
        }

        habitaciones.add(habitacion);
        System.out.println("Habitación agregada exitosamente.");
    }

    /**
     * Método para actualizar los datos de una habitación.
     *
     * @param numero      Número de la habitación a actualizar.
     * @param actualizada Habitación con los nuevos datos.
     */
    public void actualizarHabitacion(String numero, Habitacion actualizada) {
        if (actualizada == null) {
            throw new IllegalArgumentException("Los datos de la habitación actualizada no pueden ser nulos.");
        }

        Habitacion habitacion = buscarHabitacion(numero);
        if (habitacion != null) {
            habitacion.setNumero(actualizada.getNumero());
            habitacion.setTipo(actualizada.getTipo());
            habitacion.setPrecio(actualizada.getPrecio());
            System.out.println("Habitación actualizada exitosamente.");
        } else {
            System.out.println("No existe una habitación con el número ingresado.");
        }
    }

    /**
     * Método para eliminar una habitación.
     *
     * @param numero Número de la habitación a eliminar.
     */
    public void eliminarHabitacion(String numero) {
        if (numero == null) {
            throw new IllegalArgumentException("El número de la habitación no puede ser nulo.");
        }

        Habitacion habitacion = buscarHabitacion(numero);
        if (habitacion != null) {
            habitaciones.remove(habitacion);
            System.out.println("Habitación eliminada exitosamente.");
        } else {
            System.out.println("No existe una habitación con el número ingresado.");
        }
    }

    //-----------------------------------------------------//

        //-----------Getters y Setters de la clase-------------//

        public String getNombre () {
            return nombre;
        }

        public void setNombre (String nombre){
            this.nombre = nombre;
        }

        public LinkedList<Cliente> getClientes () {
            return clientes;
        }

        public void setClientes (LinkedList < Cliente > clientes) {
            this.clientes = clientes;
        }

        public LinkedList<Habitacion> getHabitaciones () {
            return habitaciones;
        }

        public void setHabitaciones (LinkedList < Habitacion > habitaciones) {
            this.habitaciones = habitaciones;
        }

        public GestorServicios getGestorServicios () {
            return gestorServicios;
        }

        public void setGestorServicios (GestorServicios gestorServicios){
            this.gestorServicios = gestorServicios;
        }

        public GestorReservas getGestorReservas () {
            return gestorReservas;
        }

        public void setGestorReservas (GestorReservas gestorReservas){
            this.gestorReservas = gestorReservas;
        }
    }