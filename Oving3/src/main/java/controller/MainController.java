package controller;


import java.net.URL;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class MainController extends Application 
{
	
/*	@FXML public void initialize()
	{
		System.out.println("Application has started.");
	}
*/	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// Create a path to the StartPane.fxml
		URL startPanePath = getClass().getResource("/view/Main.fxml"); 
		
		// Create the FXMLLoader with the URL of the StartPane.fxml
		FXMLLoader loader = new FXMLLoader(startPanePath);
		
		// Create the Pane
		AnchorPane root = loader.load();
		
		//Create the Scene
		Scene scene = new Scene(root);
		// Set the Scene to the Stage
		primaryStage.setScene(scene);
		// Set the Title to the stage
		primaryStage.setTitle("StartScreen");
		// Display the Stage
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
