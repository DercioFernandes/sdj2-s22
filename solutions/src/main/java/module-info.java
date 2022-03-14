module dk.via {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dk.via.session4.exercise4_1.view to javafx.fxml;
    opens dk.via.session4.exercise4_1 to javafx.fxml;
    opens dk.via.session4.exercise4_2.view to javafx.fxml;
    opens dk.via.session4.exercise4_2 to javafx.fxml;
    opens dk.via.session4.exercise4_3.view to javafx.fxml;
    opens dk.via.session4.exercise4_3 to javafx.fxml;

    exports dk.via.session4.exercise4_1;
    exports dk.via.session4.exercise4_2;
    exports dk.via.session4.exercise4_3;
}