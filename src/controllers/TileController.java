package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.logic.data.Song;


public class TileController {

    @FXML
    private Text details;

    @FXML
    private ImageView img;

    @FXML
    private Label title;

    public void setData (Song song){
        title.setText(song.getTitle());
        ImageView.
    }
}
