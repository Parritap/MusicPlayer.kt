package controllers;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.logic.Singleton;
import model.logic.Utils;

public class LoginController {

    App app = Singleton.getInstance().getApp();

    @FXML
    private Label lblFaliedSesion;

    @FXML
    private Label lblIngresaContrasenia;

    @FXML
    private Label lblIngresaCorreo;

    @FXML
    private CheckBox rememberUser;

    @FXML
    private TextField txtEmailUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void login(ActionEvent event) {
        app.loadScene(Utils.pathMainView);
    }

    @FXML
    void signUp(MouseEvent event) {

    }

    @FXML
    void verifyEmail(KeyEvent event) {

    }

    @FXML
    void verifyPassword(KeyEvent event) {

    }

}
