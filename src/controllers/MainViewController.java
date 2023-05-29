package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.logic.SongsSearcher;

public class MainViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox centrePane;

    @FXML
    private Label likedSongs;

    @FXML
    private TextField txtSearchSong;

    @FXML
    void initialize() {

        txtSearchSong.textProperty().bindBidirectional(SongsSearcher.songNameSearchProperty());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../view/likedSongs.fxml"));
        try {
            VBox likedSongsView = fxmlLoader.load();
            this.centrePane.getChildren().add(likedSongsView);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
