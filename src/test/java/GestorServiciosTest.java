import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.gestionhotel.model.*;

public class GestorServiciosTest {

    private GestorServicios gestorServicios;
    private Servicio dummyService;

    @BeforeEach
    public void setup() {
        gestorServicios = GestorServicios.getInstancia();
        if (gestorServicios.buscarServicio("dummy") != null) {
            gestorServicios.eliminarServicio("dummy");
        }
        dummyService = new Servicio("dummy") {
            @Override
            public void consumir() {
            }
        };
    }

    @Test
    public void testAgregarYBuscarServicio() {
        gestorServicios.agregarServicio(dummyService);
        Servicio buscado = gestorServicios.buscarServicio("dummy");
        assertNotNull(buscado, "El servicio debería haberse agregado y encontrarse.");
        assertEquals("dummy", buscado.getId(), "El id del servicio debe coincidir.");
    }

    @Test
    public void testActualizarServicio() {
        gestorServicios.agregarServicio(dummyService);
        Servicio updatedService = new Servicio("dummy_updated") {
            @Override
            public void consumir() { }
        };
        gestorServicios.actualizarServicio("dummy", updatedService);
        Servicio buscado = gestorServicios.buscarServicio("dummy_updated");
        assertNotNull(buscado, "El servicio actualizado debe encontrarse con el nuevo id.");
        assertEquals("dummy_updated", buscado.getId(), "El id del servicio debe haber sido actualizado.");
        // El id antiguo ya no debe existir
        assertNull(gestorServicios.buscarServicio("dummy"), "El servicio con el id antiguo no debe existir.");
    }

    @Test
    public void testEliminarServicio() {
        gestorServicios.agregarServicio(dummyService);
        gestorServicios.eliminarServicio("dummy");
        assertNull(gestorServicios.buscarServicio("dummy"), "El servicio debe haber sido eliminado.");
    }
}
