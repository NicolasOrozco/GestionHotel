module co.edu.uniquindio.poo.gestionhotel {


    opens co.edu.uniquindio.poo.gestionhotel to javafx.fxml;
    exports co.edu.uniquindio.poo.gestionhotel.app;
    exports co.edu.uniquindio.poo.gestionhotel.model;
    opens co.edu.uniquindio.poo.gestionhotel.model to javafx.fxml;
}