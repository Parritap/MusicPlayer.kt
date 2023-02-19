package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.logic.Singleton;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //  Singleton singleton = Singleton.INSTANCE;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/sample.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Spotify");
        stage.setScene(scene);
        stage.show();
    }
}
