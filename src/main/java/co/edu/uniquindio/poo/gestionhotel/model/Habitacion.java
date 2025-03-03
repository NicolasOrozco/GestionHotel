package co.edu.uniquindio.poo.gestionhotel.model;

public class Habitacion {

    private String numero;
    private tipoHabitacion tipo;
    private double precio;
    private boolean disponibilidad;

    /**
     * Constructor público de la clase
     * @param numero numero de la habitacion
     * @param tipo tipo de habitacion
     * @param precio precio de la habitacion
     */
    public Habitacion(String numero, tipoHabitacion tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        disponibilidad = true;
    }

    //-----------Getters y Setters de la clase-------------//

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public tipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(tipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}
