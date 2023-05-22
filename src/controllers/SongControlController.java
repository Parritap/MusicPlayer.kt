package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import model.logic.SongsPlayer;
import model.logic.data.Song;

import java.net.URL;
import java.util.ResourceBundle;

public class SongControlController {

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
    private Label songCurrentTIme;

    @FXML
    private ImageView songImageView;

    @FXML
    private Label songNameLbl;

    @FXML
    private Slider songProgressSlider;

    @FXML
    private ImageView stateSongImageView;

    @FXML
    private ImageView volumeImageView;

    public void playSong(Song song) {

        setearDatos(song);
        SongsPlayer.playSong(song);
        cambiarEstadoReproduciendo();

    }

    private void cambiarEstadoReproduciendo() {
    }

    private void setearDatos(Song song) {
        
    }
}

