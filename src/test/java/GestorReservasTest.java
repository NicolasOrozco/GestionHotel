import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import co.edu.uniquindio.poo.gestionhotel.model.*;
import java.time.LocalDate;

public class GestorReservasTest {

    private GestorReservas gestorReservas;
    private Cliente cliente;
    private Habitacion habitacion;
    private Reserva reserva;

    @BeforeEach
    public void setup() {
        gestorReservas = GestorReservas.getInstancia();
        gestorReservas.getReservas().clear();
        cliente = new Cliente("Ana Gomez", "11111111");
        habitacion = new Habitacion("202", tipoHabitacion.SIMPLE, 80.0);
        reserva = new Reserva("res1", LocalDate.now(), LocalDate.now().plusDays(2), cliente, habitacion);
    }

    @Test
    public void testAgregarYBuscarReserva() {
        gestorReservas.agregarReserva(reserva);
        Reserva buscada = gestorReservas.buscarReserva("res1");
        assertNotNull(buscada, "La reserva debería haberse agregado y encontrarse.");
        assertEquals("res1", buscada.getId(), "El id de la reserva debe coincidir.");
    }

    @Test
    public void testActualizarReserva() {
        gestorReservas.agregarReserva(reserva);
        Reserva actualizada = new Reserva("res1", LocalDate.now().plusDays(1), LocalDate.now().plusDays(3), cliente, habitacion);
        gestorReservas.actualizarReserva("res1", actualizada);
        Reserva buscada = gestorReservas.buscarReserva("res1");
        assertEquals(LocalDate.now().plusDays(1), buscada.getFechaEntrada(), "La fecha de entrada debe actualizarse.");
        assertEquals(LocalDate.now().plusDays(3), buscada.getFechaSalida(), "La fecha de salida debe actualizarse.");
    }

    @Test
    public void testEliminarReserva() {
        gestorReservas.agregarReserva(reserva);
        gestorReservas.eliminarReserva("res1");
        assertNull(gestorReservas.buscarReserva("res1"), "La reserva debe haber sido eliminada.");
    }
}
