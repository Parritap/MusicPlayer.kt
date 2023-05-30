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
import model.logic.Controller;
import model.logic.Singleton;
import model.logic.Utils;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Getter
@Setter
public class App extends Application {

    private Scene scene;
    private Stage stage;

    public static void main(String[] args) throws Exception {
        Singleton.getInstance();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Singleton.getInstance().setApp(this);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(Utils.pathRegisterView));
        Pane root = loader.load();
        Scene scene = new Scene(root);
        this.stage = stage;
        this.scene = scene;
        stage.setTitle("Spotify");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

        stage.setOnCloseRequest(windowEvent -> {
            System.exit(0);
        });
    }

    private void agregarReproductor(Pane root) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/songControl.fxml"));

        try {
            BorderPane borderpane = (BorderPane) root;
            HBox songsControlView = loader.load();
            borderpane.setBottom(songsControlView);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadScene(String pathToView) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(pathToView));
            Pane root = fxmlLoader.load();
            if (pathToView.equals(Utils.pathMainView)) agregarReproductor(root);
            this.scene = new Scene(root);
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserDataInMainView() {
        
    }
}
