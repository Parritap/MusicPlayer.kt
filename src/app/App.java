package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import model.logic.Singleton;

import java.io.IOException;

@Getter
@Setter
public class App extends Application {

    private static Stage currentStage;


    public static void main(String[] args) {
        Singleton.getInstance();
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/mainView.fxml"));
        BorderPane root = loader.load();
        agregarReproductor(root); //Agrega la barra de reproduccion que se encuentra en la parte inferior de la pantalla.
        Scene scene = new Scene(root);
        stage.setTitle("Spotify");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
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

    public static void loadScene(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource(fxmlPath));
        try {
            Pane root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            App.currentStage = newStage;
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
