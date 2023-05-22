package app;

import controllers.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.logic.Singleton;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        Singleton.getInstance();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/mainView.fxml"));
        BorderPane root = loader.load();
        MainViewController mainViewController = loader.getController();

        mainViewController.setMainView(root);

        Scene scene = new Scene(root);
        stage.setTitle("Spotify");
        stage.setScene(scene);
        stage.show();
    }

}
