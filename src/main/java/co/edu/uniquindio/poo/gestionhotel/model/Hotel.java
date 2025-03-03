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
     * Metodo para buscar un cliente por su DNI.
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
     * Metodo para agregar un nuevo cliente.
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
     * Metodo para actualizar los datos de un cliente.
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
     * Metodo para eliminar un cliente.
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
     * Metodo para buscar una habitación por su número.
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
     * Metodo para agregar una nueva habitación.
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
     * Metodo para actualizar los datos de una habitación.
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
     * Metodo para eliminar una habitación.
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

    //------------Métodos adicionales del taller-----------//
    /**
     * Cuenta el número de habitaciones disponibles en el hotel.
     * @return Número de habitaciones que no están ocupadas.
     */
    public int contarHabitacionesDisponibles() {
        int disponibles = 0;
        for (Habitacion hab : habitaciones) {
            if (hab.isDisponibilidad()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    /**
     * Calcula el porcentaje de ocupación del hotel.
     * @return Porcentaje de habitaciones ocupadas en el hotel.
     */
    public double calcularPorcentajeOcupacion() {
        if (habitaciones.isEmpty()) {
            return 0.0;
        }
        int ocupadas = 0;
        for (Habitacion hab : habitaciones) {
            if (!hab.isDisponibilidad()) {
                ocupadas++;
            }
        }
        return (ocupadas * 100.0) / habitaciones.size();
    }

    /**
     * Obtiene la habitación más barata disponible en el hotel.
     * @return La habitación con el menor precio por noche que no esté ocupada, o null si no hay disponibles.
     */
    public Habitacion obtenerHabitacionMasBarataDisponible() {
        Habitacion masBarata = null;
        for (Habitacion hab : habitaciones) {
            if (hab.isDisponibilidad()) {
                if (masBarata == null || hab.getPrecio() < masBarata.getPrecio()) {
                    masBarata = hab;
                }
            }
        }
        return masBarata;
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

    //-----------------------------------------------------//

    }