//This class controls the calorie tracker interface. Allowing the user to add to a userList updating the list every time the user adds something from the pre-made list of food.
//Also calculates the amount of calories the user has consumed that day.

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class cTrackerController implements Initializable{

	private Stage stage;
	private Scene scene;
	
	@FXML
	Button Add;
	
	@FXML
	Button Remove;
	
	@FXML
	Button Home;
	
	@FXML
	Button reset;
	
	@FXML
	ListView<String> AddOptions;
	
	@FXML
	ListView<String> CurrInventory;
	
	@FXML
	TextField tCalories;
	
	
	// When the home button is pressed it will take you back to the main scene
	public void switchToMain(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
	
	// The function is a helper function it load a file into a array list
	public ArrayList<String> loadItems(String fileName) throws IOException {
		ArrayList<String> itemList = new ArrayList<String>();
		String text = "";
		FileReader readFile = new FileReader(fileName);
		BufferedReader buff = new BufferedReader(readFile);
		while((text = buff.readLine()) != null) {
			itemList.add(text);	
		}
		buff.close();
		return itemList;
	}
	
	// The is a fucntion that run as soon as the scene is pulled up and it is where all the needed information is loaded into the List views  
	public void initialize(URL arg0, ResourceBundle arg1) {	
		
		int calCount = 0;
		
		try {
			AddOptions.getItems().addAll(loadItems("OptionInventory.txt"));
			CurrInventory.getItems().addAll(loadItems("userCurrInventory.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			for(String s: loadItems("userCurrInventory.txt")) {
				String[] list = s.split(" ");
				
				calCount += Integer.parseInt(list[list.length-2]);
			}
			tCalories.setText("" + calCount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// lets the reset button do what is it suppose to do
	public void resetCurrInventory(ActionEvent event) throws IOException{
		FileWriter fw = new FileWriter("userCurrInventory.txt", false);
		fw.close();
	   	CurrInventory.getItems().clear();
	   	CurrInventory.getItems().addAll(loadItems("userCurrInventory.txt"));
	   	int calCount = 0;
	   	for(String s: loadItems("userCurrInventory.txt")) {
			String[] list = s.split(" ");
			
			calCount += Integer.parseInt(list[list.length-2]);
		}
		tCalories.setText("" + calCount);
	}
	
	// Lets the user use the add button
	public void addItem(ActionEvent event) throws IOException {
		String selectedItem = AddOptions.getSelectionModel().getSelectedItem();
		
		if(selectedItem == null) {
			System.out.println("No Item selested");
			return;
		}
		
		FileWriter fw = new FileWriter("userCurrInventory.txt",true);
	    BufferedWriter bw = new BufferedWriter(fw);

	    bw.write(selectedItem);
	    bw.newLine();
	    bw.close();
		
        // Updating the list view and Total Calories
        CurrInventory.getItems().clear();
	   	CurrInventory.getItems().addAll(loadItems("userCurrInventory.txt"));
	   	int calCount = 0;
	   	for(String s: loadItems("userCurrInventory.txt")) {
			String[] list = s.split(" ");
			
			calCount += Integer.parseInt(list[list.length-2]);
		}
		tCalories.setText("" + calCount);
	   	
	}
	
	// Lets the user remove items from the curr Inventory
	public void removeItem(ActionEvent event) throws IOException {
		
		ArrayList<String> itemList = new ArrayList<String>();
		String selectedItem = CurrInventory.getSelectionModel().getSelectedItem();
		
		itemList = loadItems("userCurrInventory.txt");
	    
	    for(int i = 0; i < itemList.size(); i++) {
	    	if(itemList.get(i).equals(selectedItem)) {
	    		itemList.remove(i);
	    		break;
	    	}
	    }
	    
		FileWriter fw = new FileWriter("userCurrInventory.txt", false);
	    BufferedWriter bw = new BufferedWriter(fw);
	    
	    for(int i = 0; i < itemList.size(); i++) {
	    	bw.write(itemList.get(i));
	    	bw.newLine();
	    }
	    bw.close();
	    
        CurrInventory.getItems().clear();
	   	CurrInventory.getItems().addAll(loadItems("userCurrInventory.txt"));
	   	int calCount = 0;
	   	for(String s: loadItems("userCurrInventory.txt")) {
			String[] list = s.split(" ");
			
			calCount += Integer.parseInt(list[list.length-2]);
		}
		tCalories.setText("" + calCount);
	    
	    
		
	}


}
