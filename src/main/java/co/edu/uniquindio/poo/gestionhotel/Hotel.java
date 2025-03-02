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
     * Método para evitar la creación de clientes duplicados
     *
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
     *
     * @param cliente a agregar
     */
    public void agregarCliente(Cliente cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException("No se ingresó el cliente que se desea agregar");
        }

        if (verificarCliente(cliente.getDni())) {
            System.out.println("El cliente ya se encuentra registrado");
            return;
        }

        clientes.add(cliente);
        System.out.println("Cliente agregado exitosamente");

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
     *
     * @param dni         del cliente a actualizar
     * @param actualizado
     */
    public void actualizarCliente(String dni, Cliente actualizado) {
        if (actualizado == null) {
            throw new IllegalArgumentException("Los datos del cliente actualizado no pueden ser nulos");
        }
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                eliminarCliente(dni);
                agregarCliente(cliente);
                System.out.println("Cliente actualizado exitosamente");
                return;
            }
        }
        System.out.println("El DNI ingresado no coincide con ningún cliente registrado");
    }

    /**
     * Método para eliminar un cliente
     *
     * @param dni del cliente a eliminar
     */
    public void eliminarCliente(String dni) {
        //retorna true si al menos algún cliente fue eliminado
        boolean eliminado = clientes.removeIf(cliente -> cliente.getDni().equals(dni));
        if (eliminado) {
                System.out.println("Cliente eliminado exitosamente");
        } else {
            System.out.println("El DNI ingresado no coincide con ningún cliente registrado");
        }
    }


        //-------------------CRUD Habitación-------------------//

        /**
         * Método para evitar la creación de habitaciones duplicadas
         * @param numero de la habitación a agregar
         * @return centinela indicando si actualmente existe una
         * instancia del cliente
         */
        public boolean verificarHabitacion (String numero){
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
        public void agregarHabitacion (Habitacion habitacion) {
            if (habitacion == null) {
                throw new IllegalArgumentException("No se ingreso la habitacion que se desea agregar");
            }
            if (verificarHabitacion(habitacion.getNumero())) {
                System.out.println("El habitacion ya se encuentra registrada");
            }
            habitaciones.add(habitacion);
            System.out.println("Habitación agregada exitosamente");
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
        public void actualizarHabitacion (String numero, Habitacion actualizada){
            if (actualizada == null) {
                throw new IllegalArgumentException("Los datos de la habitacion actualizada no pueden ser nulos");
            }
            for (Habitacion habitacion : habitaciones){
                if (habitacion.getNumero().equals(numero)){
                    eliminarHabitacion(numero);
                    agregarHabitacion(habitacion);
                    System.out.println("Habitacion actualizada exitosamente");
                    return;
                }
            }
        }

        /**
         * Método para eliminar una habitación
         * @param numero de la habitación a eliminar
         */
        public void eliminarHabitacion (String numero){
            boolean eliminado = habitaciones.removeIf (habitacion -> habitacion.getNumero().equals(numero));
            if (eliminado) {
                System.out.println("La habitacion se ha eliminado exitosamente");
            } else {
                System.out.println("El codigo ingresado no coincide con ninguna habitacion");
            }
        }


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