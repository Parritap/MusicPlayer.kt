package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    MainViewController mainViewController;
    BorderPane mainView;

    @FXML
    private VBox centrePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../view/likedSongs.fxml"));
        try {
            VBox likedSongsView = fxmlLoader.load();
            LikedSongsController likedSongsController = fxmlLoader.getController();
            likedSongsController.setMainViewController(this);
            likedSongsController.initialize(url, resourceBundle);
            this.centrePane.getChildren().add(likedSongsView);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMainView(BorderPane root) {
        this.mainView = mainView;
    }
}
