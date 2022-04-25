//This class controls the sleep tracker interface. Controlling the user input and storing the users data and calculating the average amount of sleep.

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class sTrackerController implements Initializable{

	
	private Stage stage;
	private Scene scene;
	
	int dayCount = 0;
	int weekCount = 0;
	
	@FXML
	Button Home;
	
	@FXML
	Button add;
	
	@FXML
	Button resetDays;
	
	@FXML
	Button resetWeeks;
	
	@FXML
	Label AvgHours;
	
	@FXML
	TextField hrsToAdd;
	
	@FXML
	ListView<String> dayList;
	
	@FXML
	ListView<String> weekList;
	
	// Lets the user switch back to the main scene
	public void switchToMain(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}

	// Helper function that load teh content of a file in to a Array List and returns it
	public ArrayList<String> loadHrs(String fileName) throws IOException {
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
	
	// This run when the scene is loaded and it populates all the necessary information
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		double Hours = 0;
		
		try 
			{
				dayList.getItems().addAll(loadHrs("DayList.txt"));
				weekList.getItems().addAll(loadHrs("WeekList.txt"));
			} 
		catch (IOException e) 
			{
				e.printStackTrace();
			}
	
		try {
				dayCount = 0;
		for(String s: loadHrs("DayList.txt")) 
			{
				String[] list = s.split(" ");
				dayCount++;
				Hours += Double.parseDouble(list[list.length-2]);
			}
			
			if(Hours > 0) Hours /= dayCount;
			else Hours = 0.0;
			
			AvgHours.setText("" + String.format("%.1f", Hours) + " hrs");
			
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	// Resets the "dayList"
	public void resetDayList(ActionEvent event) throws IOException{
		FileWriter fw = new FileWriter("DayList.txt", false);
		fw.close();
	   	dayList.getItems().clear();
	   	dayList.getItems().addAll(loadHrs("DayList.txt"));
	   	
	   	double Hours = 0;
	   	dayCount = 0;
		for(String s: loadHrs("DayList.txt")) {
			String[] list = s.split(" ");
			dayCount++;
			Hours += Double.parseDouble(list[list.length-2]);
		}
		if(Hours > 0) Hours /= dayCount;
		else Hours = 0.0;
		
		AvgHours.setText("" + String.format("%.1f", Hours) + " hrs");
	   	
	}
	
	// resets the "weekList"
	public void resetWeekList(ActionEvent event) throws IOException {
		FileWriter fw = new FileWriter("WeekList.txt", false);
		fw.close();
	   	weekList.getItems().clear();
	   	weekList.getItems().addAll(loadHrs("WeekList.txt"));
	}
	
	// This updates the "weekList" the number of day exceeds 7
	public void updateWeekList() throws IOException {
		weekCount++;
		String weeksAvgHrs = AvgHours.getText();
		
		FileWriter fw = new FileWriter("WeekList.txt",true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    
	    bw.write("Week " + weekCount + ": " + weeksAvgHrs);
	    bw.newLine();
	    bw.close();
	    weekList.getItems().clear();
	   	weekList.getItems().addAll(loadHrs("WeekList.txt"));
	}
	
	// This function is for the add button and it add more days to the "dayList"
	public void addHrs(ActionEvent event) throws IOException {
		String toAdd = hrsToAdd.getText();
		
		if(toAdd.equals("")) {
			System.out.println("No Item selested");
			return;
		}
		
		if(dayCount == 7) {
			updateWeekList();
			resetDayList(event);
			dayCount = 0;
		}
		
		FileWriter fw = new FileWriter("DayList.txt",true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    
	    dayCount++;
	    bw.write("Day " + dayCount + ": " + toAdd + " hrs");
	    bw.newLine();
	    bw.close();
	    
	    dayList.getItems().clear();
	   	dayList.getItems().addAll(loadHrs("DayList.txt"));
	    
	    double Hours = 0;
	   	dayCount = 0;
		for(String s: loadHrs("DayList.txt")) {
			String[] list = s.split(" ");
			dayCount++;
			Hours += Double.parseDouble(list[list.length-2]);
		}
		Hours /= dayCount;
		AvgHours.setText("" + String.format("%.1f", Hours) + " hrs");
		
		hrsToAdd.setText("");
	}			
}