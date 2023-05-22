package  controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.logic.SongsPlayer;
import model.logic.data.Song;

import javax.sound.sampled.*;
import java.io.IOException;

public class HorizontalSongController {

    private Song song;

    @FXML
    private Label lbl_album;

    @FXML
    private Label lbl_date;

    @FXML
    private Label lbl_number;

    @FXML
    private Label lbl_title;

    @FXML
    private ImageView songImage;

    public void setData(Song song, String number){
        this.song = song;
        songImage.setImage(song.getImageFromArtWork());
        lbl_title.setText(song.getTitle());
        lbl_album.setText(song.getAlbum());
        lbl_date.setText(song.getYear());
        lbl_number.setText(number);
    }

    @FXML
    void playSong(MouseEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        SongsPlayer.playSong(song);
    }
}
