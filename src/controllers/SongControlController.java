package controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.TimeStringConverter;
import model.logic.Singleton;
import model.logic.SongsPlayer;
import model.logic.data.Song;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;


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

    private AtomicBoolean isStopped = new AtomicBoolean();
    @FXML
    private ImageView stateSongImageView;

    @FXML
    private ImageView volumeImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        stateSongImageView.setOnMouseClicked(mouseEvent -> {

            synchronized (isStopped) {

                isStopped.set(!Singleton.getInstance().getAudioClip().isRunning());

                if ( !isStopped.get() ) {
                    SongsPlayer.pauseCurrentSong();
                    //isStopped = true;
                } else {
                    SongsPlayer.continueCurrentSong();
                    //isStopped = false;
                }

            }

        });

        songProgressSlider.maxProperty().bind(SongsPlayer.currentSong.durationProperty());

        IntegerProperty progress = SongsPlayer.currentSong.progressProperty();
        songProgressSlider.valueProperty().bind(progress);
        songProgressSlider.valueProperty().addListener((observableValue, number, newValue) -> {

            songCurrentTime.textProperty().set( "%02d:%02d".formatted(
                    (newValue.intValue() - (newValue.intValue() % 60)) / 60,
                    newValue.intValue() % 60
            ));
        });

        songNameLbl.textProperty().bind(SongsPlayer.currentSong.titleProperty());
        songImageView.imageProperty().bind(SongsPlayer.currentSong.imageProperty());
        songAuthorLbl.textProperty().bind(SongsPlayer.currentSong.artistProperty());

    }
}

