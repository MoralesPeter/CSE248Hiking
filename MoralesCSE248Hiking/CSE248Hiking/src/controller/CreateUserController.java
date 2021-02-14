package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Admin;
import model.Hiker;
import model.User;
import model.UserStorage;

public class CreateUserController {
	private UserStorage userStorage = new UserStorage();
	private File userImage;
	
    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private PasswordField tfConfirmPassword;

    @FXML
    private TextField tfPhoneNumber;

    @FXML
    private CheckBox cbIsAdmin;

    @FXML
    private Button btnChooseFile;

    @FXML
    private TextField tfFilePath;

    @FXML
    private ImageView ivPhoto;

    @FXML
    private Button btnCreateUser;

    @FXML
    private Label lblError;
    
    public void initialize() throws FileNotFoundException, ClassNotFoundException, IOException {
    	userStorage.initialize();
    	if(Main.loggedIn != null) {
    		User u = userStorage.searchUser(Main.loggedIn);
    		if(u instanceof Admin) {
    			cbIsAdmin.setVisible(true);
    		}
    	}
    }
    
    public void fileChooser(ActionEvent e) {
    	Stage stage = (Stage)tfUsername.getScene().getWindow();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Choose an Image");
    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.png");
    	fileChooser.getExtensionFilters().add(extFilter);
    	File file = fileChooser.showOpenDialog(stage);
    	tfFilePath.setText(file.getPath());
    	BufferedImage img = null;
    	try {
    		img = ImageIO.read(file);
    	} catch (IOException ex) {
    		
    	}
    	//convert buffered image to javafx image
    	WritableImage wr = null;
		wr = new WritableImage(img.getWidth(), img.getHeight());
		PixelWriter pw = wr.getPixelWriter();
		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				pw.setArgb(x, y, img.getRGB(x, y));
			}
		}
    	ivPhoto.setImage(wr);
    	userImage = file;
    }
    
    public void createUser() throws FileNotFoundException, ClassNotFoundException, IOException {
    	if(tfUsername.getText().equals("") || tfPassword.getText().equals("") || tfFirstName.getText().equals("") || tfLastName.getText().equals("") || tfPhoneNumber.getText().equals("") || tfFilePath.getText().equals("")) {
    		lblError.setText("All fields are required.");
    	}
    	if(!userStorage.containsUser(tfUsername.getText())) {
    		if(tfPassword.getText().equals(tfConfirmPassword.getText())) {
    			if(tfPhoneNumber.getText().length() == 10 && tfPhoneNumber.getText().matches("^[0-9]+$")) {
    				if(cbIsAdmin.isPressed()) { //admin creation
        				Admin a = new Admin(tfUsername.getText(), tfPassword.getText(), tfFirstName.getText(), tfLastName.getText(), Long.parseLong(tfPhoneNumber.getText()), userImage);
        				userStorage.addUser(tfUsername.getText(), a);
        				userStorage.save();
        			} else { //hiker creation
        				Hiker h = new Hiker(tfUsername.getText(), tfPassword.getText(), tfFirstName.getText(), tfLastName.getText(), Long.parseLong(tfPhoneNumber.getText()), userImage);
        				userStorage.addUser(tfUsername.getText(), h);
        				userStorage.save();
        			}
    			} else {
    				lblError.setText("Invalid phone number");
    			}
    		} else {
    			lblError.setText("Passwords do not match.");
    		}
    	} else {
    		lblError.setText("Username already exists.");
    	}
    }
}

