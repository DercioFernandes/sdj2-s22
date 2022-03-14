package dk.via.session4.exercise4_2;

import dk.via.session4.exercise4_2.model.Model;
import dk.via.session4.exercise4_2.model.ModelManager;
import dk.via.session4.exercise4_2.view.ViewHandler;
import dk.via.session4.exercise4_2.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}