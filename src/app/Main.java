package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        // Singleton.getInstance();
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/mainView.fxml"));
        BorderPane root = loader.load();

        agregarReproductor(root);

        Scene scene = new Scene(root);
        stage.setTitle("Spotify");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {
            System.exit(0);
        });
    }

    private void agregarReproductor(BorderPane root) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/songControl.fxml"));

        try {
            HBox songsControlView = loader.load();
            root.setBottom(songsControlView);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
