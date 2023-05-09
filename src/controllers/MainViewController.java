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
    private HBox recentlyPlayedContainer; //Este es el slide donde se va a contener todas las canciones.


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Song song : Singleton.getSongsFound()) {
            try {
                //La siguiente linea añade un anchor pane al slide con la información de la canción.
                recentlyPlayedContainer.getChildren().add(this.generateTile(song));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * Este método se encarga de generar un tile (pieza, baldosa) con la información de la canción.
     * @param song
     * @return AnchorPane con el arte de la canción y su titulo, así como los compositores.
     * @throws IOException
     */
    private AnchorPane generateTile(Song song) throws IOException {
        FXMLLoader root = new FXMLLoader();
        root.setLocation(Objects.requireNonNull(getClass().getResource("../view/tile.fxml")));
        AnchorPane anchorPane = root.load();
        TileController tileController = root.getController();
        tileController.setData(song); //Ya una vez creada la plantilla (anchor pane) se le asigna la información de la canción mediante su respectivo controlador.
        return anchorPane;
    }

}
