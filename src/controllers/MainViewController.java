package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.logic.Singleton;
import model.logic.data.Song;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private HBox favoriteContainer;

    @FXML
    private HBox recentlyPlayedContainer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Song s : Singleton.INSTANCE.getSongsFound()
        ) {
            try {
                recentlyPlayedContainer.getChildren().add(generateTile(s));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    private AnchorPane generateTile(Song song) throws IOException {
        FXMLLoader root = new FXMLLoader();
        root.setLocation(Objects.requireNonNull(getClass().getResource("../view/tile.fxml")));
        AnchorPane anchorPane = root.load();
        TileController tileController = root.getController();
        tileController.setData(song);
        return anchorPane;
    }

}
