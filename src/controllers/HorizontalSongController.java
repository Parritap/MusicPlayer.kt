package  controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.logic.data.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class HorizontalSongController {

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

    private Song song;

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
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(song.getPath()));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

}
