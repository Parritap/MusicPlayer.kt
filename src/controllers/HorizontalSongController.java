package  controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.logic.data.Song;

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


    public void setData(Song song, String number){
        lbl_title.setText(song.getTitle());
        lbl_album.setText(song.getAlbum());
        lbl_date.setText(song.getYear());
        lbl_number.setText(number);
    }

}
