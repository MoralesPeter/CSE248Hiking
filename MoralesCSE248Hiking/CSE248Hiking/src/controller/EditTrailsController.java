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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Trail;
import model.TrailStorage;

public class EditTrailsController {
	
	private Trail t;
	private TrailStorage trailStorage = new TrailStorage();
	
    @FXML
    private TextField tfName;

    @FXML
    private TextField tfTrailHead;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfElevationGain;

    @FXML
    private ComboBox<String> cbDifficulty;

    @FXML
    private ComboBox<String> cbType;

    @FXML
    private Button btnSaveTrail;

    @FXML
    private Button btnCreateTrail;

    @FXML
    private Button btnBack;
    
    @FXML
    private CheckBox cbIsEnabled;
    
    @FXML
    private Label lblError;
    
    public void initialize() throws FileNotFoundException, ClassNotFoundException, IOException {
    	trailStorage.initialize();
    	t = Main.selectedTrail;
    	cbDifficulty.getItems().add("Easy");
    	cbDifficulty.getItems().add("Moderate");
    	cbDifficulty.getItems().add("Hard");
    	cbType.getItems().add("Loop");
    	cbType.getItems().add("Out and back");
    	cbType.getItems().add("Point-to-point");
    	tfName.setText(t.getName());
    	tfTrailHead.setText(t.getTrailHead());
    	tfLength.setText(t.getLength() + "");
    	tfElevationGain.setText(t.getElevationGain() + "");
    	cbDifficulty.getSelectionModel().select(t.getDifficulty());
    	cbType.getSelectionModel().select(t.getType());
    }
    
    public void createTrail(ActionEvent event) throws FileNotFoundException, IOException {
    	if(tfName.getText().equals("") || tfTrailHead.getText().equals("") || tfLength.getText().equals("") ||
    		tfElevationGain.getText().equals("") || cbDifficulty.getSelectionModel() == null || cbType.getSelectionModel() == null) {
    			lblError.setText("All fields must be filled out.");
    			return;
    	}
    	if(!tfLength.getText().matches("\\d+(\\.\\d+)?")) {
    		lblError.setText("Invalid length format");
    		return;
    	}
    	if(!tfElevationGain.getText().matches("\\d+(\\.\\d+)?")) {
    		lblError.setText("Invalid elevation gain format");
    		return;
    	}
    	int difficulty = cbDifficulty.getSelectionModel().getSelectedIndex();
    	int type = cbType.getSelectionModel().getSelectedIndex();
    	boolean isEnabled = false;
    	if(cbIsEnabled.isSelected()) {
    		isEnabled = true;
    	} else {
    		isEnabled = false;
    	}
    	Trail newTrail = new Trail(tfName.getText(), tfTrailHead.getText(), Double.parseDouble(tfLength.getText()),
    			Double.parseDouble(tfElevationGain.getText()), difficulty, type, isEnabled);
    	trailStorage.addTrail(newTrail);
    	trailStorage.save();
    	Main.selectedTrail = newTrail;
    	openRecordHike();
    }

    public void saveTrail(ActionEvent event) throws FileNotFoundException, IOException {
    	if(tfName.getText().equals("") || tfTrailHead.getText().equals("") || tfLength.getText().equals("") ||
        		tfElevationGain.getText().equals("") || cbDifficulty.getSelectionModel() == null || cbType.getSelectionModel() == null) {
        			lblError.setText("All fields must be filled out.");
        			return;
        	}
        	if(!tfLength.getText().matches("\\d+(\\.\\d+)?")) {
        		lblError.setText("Invalid length format");
        		return;
        	}
        	if(!tfElevationGain.getText().matches("\\d+(\\.\\d+)?")) {
        		lblError.setText("Invalid elevation gain format");
        		return;
        	}
        	int difficulty = cbDifficulty.getSelectionModel().getSelectedIndex();
        	int type = cbType.getSelectionModel().getSelectedIndex();
        	boolean isEnabled = false;
        	if(cbIsEnabled.isSelected()) {
        		isEnabled = true;
        	} else {
        		isEnabled = false;
        	}
        	
        	t.setName(tfName.getText());
        	t.setTrailHead(tfTrailHead.getText());
        	t.setLength(Double.parseDouble(tfLength.getText()));
        	t.setElevationGain(Double.parseDouble(tfElevationGain.getText()));
        	t.setDifficulty(difficulty);
        	t.setType(type);
        	t.setEnabled(isEnabled);
        	trailStorage.deleteTrail(t.getUniqueID());
        	trailStorage.addTrail(t);
        	trailStorage.save();
        	openRecordHike();
    }
    
    public void openRecordHike(ActionEvent event) {
    	//close edit trails window, open record hike window
    	Stage primaryStage = (Stage)tfName.getScene().getWindow();
    	
    	try {
    		URL url = getClass().getClassLoader().getResource("view/RecordHike.fxml");
    		Parent root = FXMLLoader.load(url);
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
    		stage.setTitle("Record Hike");
    		stage.setScene(scene);
    		stage.show();
    	    primaryStage.close();

    	} catch (IOException ex) {
    	    ex.printStackTrace();
    	}
    }
    
    public void openRecordHike() {
    	//close edit trails window, open record hike window
    	Stage primaryStage = (Stage)tfName.getScene().getWindow();
    	
    	try {
    		URL url = getClass().getClassLoader().getResource("view/RecordHike.fxml");
    		Parent root = FXMLLoader.load(url);
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
    		stage.setTitle("Record Hike");
    		stage.setScene(scene);
    		stage.show();
    	    primaryStage.close();

    	} catch (IOException ex) {
    	    ex.printStackTrace();
    	}
    }

}
