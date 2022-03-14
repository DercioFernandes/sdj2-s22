package dk.via.session4.exercise4_1;

import dk.via.session4.exercise4_1.model.UserModel;
import dk.via.session4.exercise4_1.model.UserModelManager;
import dk.via.session4.exercise4_1.view.ViewHandler;
import dk.via.session4.exercise4_1.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        UserModel model = new UserModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}