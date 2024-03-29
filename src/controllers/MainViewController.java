package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.logic.Singleton;
import model.logic.SongsSearcher;
import model.logic.data.User;

public class MainViewController implements Initializable {

    @FXML
    private Button name;

    @FXML
    private VBox centrePane;

    @FXML
    private Label likedSongs;

    @FXML
    private TextField txtSearchSong;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setUserData();

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

    /**
     * Obtiene la data del usuario que se loguee para mostrarla en la vista.
     */
    private void setUserData() {
        User user = Singleton.getInstance().getCurrentUser();
        name.setText(user.getNickname());

    }
}
