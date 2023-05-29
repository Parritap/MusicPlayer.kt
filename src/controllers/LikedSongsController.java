package controllers;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.logic.Singleton;
import model.logic.SongsSearcher;
import model.logic.data.Song;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LikedSongsController  implements Initializable {

    StringProperty songNameSearch = new SimpleStringProperty();

    @FXML
    private VBox vBox_songsHolder;

    private static int songNumber = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        songNameSearch.bindBidirectional(SongsSearcher.songNameSearchProperty());
        songNameSearch.addListener( (observableValue, lastString, newString) -> {

            System.out.println("hola");

            vBox_songsHolder.getChildren().clear();

            for (Song song : SongsSearcher.obtenerCancionesConCoincidencia(newString)) {

                try {
                    vBox_songsHolder.getChildren().add(this.addSongPane(song));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        for (Song song : Singleton.getSongsFound()) {

            try {
                vBox_songsHolder.getChildren().add(this.addSongPane(song));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public AnchorPane addSongPane(Song song) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("../view/horizontalSong.fxml"));
        AnchorPane anchorPane =  fxmlloader.load();
        HorizontalSongController horizontalSongController = fxmlloader.getController();
        horizontalSongController.setData(song, String.valueOf(songNumber));
        songNumber++;
        return anchorPane;
    }

}
