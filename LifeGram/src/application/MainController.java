//This class allows me to create scenes, stages, user active buttons, etc for the "main menu" of this project.w
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	Button cTracker;
	@FXML
	Button sTracker;
	
	// Lets the user switch to the Calorie Tracker scene
	public void switchTOcTracker(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("cTracker.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
	
	// Lets the user switch to the Sleep Tracker scene
	public void switchTOsTracker(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("sTracker.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
}

