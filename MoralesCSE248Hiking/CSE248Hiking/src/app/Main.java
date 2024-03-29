package app;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.HikedTrail;
import model.Trail;

public class Main extends Application {
	public static String loggedIn;
	public static Trail selectedTrail;
	public static HikedTrail selectedHike;
	public static int selectedTrailID;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		URL url = getClass().getClassLoader().getResource("view/LogIn.fxml");
		Parent root = FXMLLoader.load(url);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Log In");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
