package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.UserStorage;
import model.Utilities;

public class LogInController {
	private UserStorage userStorage = new UserStorage();
	
    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField tfPassword;
    
    @FXML
    private Label lblWarning;
    
    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnCreateUser;
    
    public void authenticate(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException {
    	userStorage.initialize();
    	if(tfUsername.getText() == null || tfPassword.getText() == null) {
    		lblWarning.setText("Invalid Username or Password");
    	}
    	if(Utilities.authenticateUser(tfUsername.getText(), tfPassword.getText(), userStorage)) {;
    		//open main window
    		Main.loggedIn = tfUsername.getText();
    		openTrailView();
    	} else {
    		lblWarning.setText("Invalid Username or Password");
    	}
    }
    
    public void openTrailView() {
    	//close log in window, open trail view window
    	Stage primaryStage = (Stage)tfUsername.getScene().getWindow();
    			
    	try {
    		URL url = getClass().getClassLoader().getResource("view/TrailView.fxml");
    		Parent root = FXMLLoader.load(url);
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
    		stage.setTitle("Trails");
    		stage.setScene(scene);
    		stage.show();
    	    primaryStage.close();

    	} catch (IOException e) {
    	    e.printStackTrace();
    	}
    }
    
    public void openCreateUser(ActionEvent e) {
    	//close log in window, open trail view window
    	Stage primaryStage = (Stage)tfUsername.getScene().getWindow();
    			
    	try {
    		URL url = getClass().getClassLoader().getResource("view/CreateUser.fxml");
    		Parent root = FXMLLoader.load(url);
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
    		stage.setTitle("Create User");
    		stage.setScene(scene);
    		stage.show();
    	    primaryStage.close();

    	} catch (IOException ex) {
    	    ex.printStackTrace();
    	}
    }
}