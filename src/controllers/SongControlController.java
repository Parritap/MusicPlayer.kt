package controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;
import model.logic.SongsPlayer;
import model.logic.data.Song;

import java.net.URL;
import java.util.ResourceBundle;


public class SongControlController implements Initializable {

    @FXML
    private ImageView favoriteImageView;

    @FXML
    private ImageView nextSongImageView;

    @FXML
    private ImageView previousSongImageView;

    @FXML
    private ImageView randomSongImageView;

    @FXML
    private ImageView restartSongImageView;

    @FXML
    private Label songAuthorLbl;

    @FXML
    private Label songCurrentTime;

    @FXML
    private ImageView songImageView;

    @FXML
    private Label songNameLbl;

    @FXML
    private Slider songProgressSlider;

    private boolean isStopped = false;
    @FXML
    private ImageView stateSongImageView;

    @FXML
    private ImageView volumeImageView;

    public void playSong(Song song) {

        setearDatos(song);

        // not implemented yet, function in class "HorizontalSongController"
        //SongsPlayer.playSong(song);

        cambiarEstadoReproduciendo();

    }

    private void cambiarEstadoReproduciendo() {
    }

    private void setearDatos(Song song) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        stateSongImageView.setOnMouseClicked(mouseEvent -> {

            if ( !isStopped ) {
                SongsPlayer.pauseCurrentSong();
                isStopped = true;
            } else {
                SongsPlayer.continueCurrentSong();
                isStopped = false;
            }

        });

        songProgressSlider.maxProperty().bind(SongsPlayer.currentSong.durationProperty());
        songProgressSlider.valueProperty().bindBidirectional(SongsPlayer.currentSong.progressProperty());
        songCurrentTime.textProperty().bind(SongsPlayer.currentSong.progressProperty().asString());
        songNameLbl.textProperty().bind(SongsPlayer.currentSong.titleProperty());
        songImageView.imageProperty().bind(SongsPlayer.currentSong.imageProperty());
        songAuthorLbl.textProperty().bind(SongsPlayer.currentSong.artistProperty());

    }
}

