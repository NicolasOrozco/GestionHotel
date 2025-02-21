module co.edu.uniquindio.poo.gestionhotel {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.gestionhotel to javafx.fxml;
    exports co.edu.uniquindio.poo.gestionhotel;
}