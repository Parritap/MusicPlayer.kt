package controllers;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.logic.Controller;
import model.logic.Exceptions.FieldException;
import model.logic.Exceptions.ModelException;
import model.logic.Singleton;
import model.logic.UserHandler;
import model.logic.data.User;

import javax.swing.*;

public class RegisterController implements Controller {

    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;


    @FXML
    void registrarUsuario(ActionEvent event) {
        // Orden: name > email > password > nickname
        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String nickname = txtUserName.getText();

        if (UserHandler.userExisits(email)) {
            JOptionPane.showMessageDialog(null, "El usuario ya existe");
            return;
        }

        try {
            //Creamos el usuario y lo seteamos al Singleton.
            Singleton.getInstance().setCurrentUser(UserHandler.createUser(name, email, password, nickname));

        } catch (FieldException fieldException) {
            JOptionPane.showMessageDialog(null, "Existe algún campo vacío o nulo");
        } catch (ModelException e) {
            JOptionPane.showMessageDialog(null, "El usuario ya existe");
        }
    }
}
