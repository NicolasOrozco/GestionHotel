import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.gestionhotel.model.*;

public class HotelTest {

    private Hotel hotel;

    @BeforeEach
    public void setup() {
        hotel = new Hotel("Hotel Test");
        hotel.getClientes().clear();
        hotel.getHabitaciones().clear();
    }

    // --- Tests para Clientes ---

    @Test
    public void testAgregarYBuscarCliente() {
        Cliente cliente = new Cliente("Juan Perez", "12345678");
        hotel.agregarCliente(cliente);
        Cliente buscado = hotel.buscarCliente("12345678");
        assertNotNull(buscado, "El cliente debería haberse agregado y encontrarse.");
        assertEquals("Juan Perez", buscado.getNombre(), "El nombre del cliente debe coincidir.");
    }

    @Test
    public void testActualizarCliente() {
        Cliente cliente = new Cliente("Juan Perez", "12345678");
        hotel.agregarCliente(cliente);
        Cliente actualizado = new Cliente("Juan Garcia", "87654321");
        hotel.actualizarCliente("12345678", actualizado);
        // Se espera que el cliente actualizado ahora tenga el nuevo DNI y nombre
        Cliente buscado = hotel.buscarCliente("87654321");
        assertNotNull(buscado, "El cliente actualizado debe encontrarse con el nuevo DNI.");
        assertEquals("Juan Garcia", buscado.getNombre(), "El nombre debe haber sido actualizado.");
        // Además, el antiguo DNI ya no debe existir
        assertNull(hotel.buscarCliente("12345678"), "El DNI antiguo no debería existir.");
    }

    @Test
    public void testEliminarCliente() {
        Cliente cliente = new Cliente("Juan Perez", "12345678");
        hotel.agregarCliente(cliente);
        hotel.eliminarCliente("12345678");
        assertNull(hotel.buscarCliente("12345678"), "El cliente debe haber sido eliminado.");
    }

    // --- Tests para Habitaciones ---

    @Test
    public void testAgregarYBuscarHabitacion() {
        Habitacion habitacion = new Habitacion("101", tipoHabitacion.SIMPLE, 100.0);
        hotel.agregarHabitacion(habitacion);
        Habitacion buscada = hotel.buscarHabitacion("101");
        assertNotNull(buscada, "La habitación debería haberse agregado y encontrarse.");
        assertEquals(100.0, buscada.getPrecio(), "El precio de la habitación debe coincidir.");
    }

    @Test
    public void testActualizarHabitacion() {
        Habitacion habitacion = new Habitacion("101", tipoHabitacion.SIMPLE, 100.0);
        hotel.agregarHabitacion(habitacion);
        Habitacion actualizada = new Habitacion("101A", tipoHabitacion.DOBLE, 150.0);
        hotel.actualizarHabitacion("101", actualizada);
        Habitacion buscada = hotel.buscarHabitacion("101A");
        assertNotNull(buscada, "La habitación actualizada debe encontrarse con el nuevo número.");
        assertEquals(tipoHabitacion.DOBLE, buscada.getTipo(), "El tipo de habitación debe haber cambiado a DOBLE.");
        // El número original ya no debe existir
        assertNull(hotel.buscarHabitacion("101"), "La habitación con el número antiguo no debería existir.");
    }

    @Test
    public void testEliminarHabitacion() {
        Habitacion habitacion = new Habitacion("101", tipoHabitacion.SIMPLE, 100.0);
        hotel.agregarHabitacion(habitacion);
        hotel.eliminarHabitacion("101");
        assertNull(hotel.buscarHabitacion("101"), "La habitación debe haber sido eliminada.");
    }
}
