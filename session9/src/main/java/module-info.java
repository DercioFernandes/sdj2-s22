module dk.via {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dk.via.mvvm.view to javafx.fxml;
    opens dk.via.mvvm to javafx.fxml;

    exports dk.via.mvvm.view;
    exports dk.via.mvvm.viewmodel;
    exports dk.via.mvvm.model;
    exports dk.via.mvvm;
}