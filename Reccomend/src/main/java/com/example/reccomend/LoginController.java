package com.example.reccomend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordBox;

    @FXML
    private TextField usernameBox;

    @FXML
    private RadioButton newUserButton;

    @FXML
    private Label welcomeLabel;

    public void switchToMovieSelect (ActionEvent event) throws IOException {
        Parent root;
    }

    @FXML
    void LoginController(ActionEvent event) throws IOException {
        // Initial login
        login login = new login();
        sortMovies movies = new sortMovies();
        Parent root;
        String username = usernameBox.getText().toString();
        String password = passwordBox.getText().toString();

        login.setUsername(username);
        login.setPassword(password);

if (login.isValidUser(username,password)==true && newUserButton.isSelected()==false ) {
    root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
            Stage window = (Stage) loginButton.getScene().getWindow();
            window.setScene(new Scene(root));
}  else if (login.isValidUser(username,password)==false && newUserButton.isSelected()==true){
    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                Stage window = (Stage) loginButton.getScene().getWindow();
                window.setScene(new Scene(root));
} else {
    welcomeLabel.setText("Sign in error");
}
//        if (newUserButton.isSelected()) {
//            // switch to movie selection screen
//            if (login.isExistingUser(username, password) == true) {
//                welcomeLabel.setText("Existing user...");
//            } else {
//                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//
//                Stage window = (Stage) loginButton.getScene().getWindow();
//                window.setScene(new Scene(root));
//            }
//        } else if(newUserButton.isSelected()==false) {
//
//        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
//            Stage window = (Stage) loginButton.getScene().getWindow();
//            window.setScene(new Scene(root));
//        }
    }

}
