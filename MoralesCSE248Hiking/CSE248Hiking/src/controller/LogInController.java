package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.UserStorage;
import model.Utilities;

public class LogInController {
	private UserStorage userStorage = new UserStorage();
	
    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnCreateUser;
    
    @FXML
    public void authenticate(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException {
    	userStorage.initialize();
    	if(tfUsername.getText() == null || tfPassword.getText() == null) {
    		System.out.println("Invalid Username or Password");
    	}
    	if(Utilities.authenticateUser(tfUsername.getText(), tfPassword.getText(), userStorage)) {;
    		//open main window
    		Main.loggedIn = tfUsername.getText();
    		System.out.println("You're winner!");
    	} else {
    		System.out.println("Invalid Username or Password");
    	}
    }
}