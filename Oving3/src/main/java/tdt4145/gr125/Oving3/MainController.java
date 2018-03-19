package tdt4145.gr125.Oving3;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class MainController extends Application 
{

	public startScreenController startController;
//	public registrationScreenController registrationController;
    public MasterScreenController screenController;
    public Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		//Stage is the root level object of the UI, screenController controls which scene is going to show on the stage.
		this.stage = primaryStage;
	    screenController = new MasterScreenController(new Scene(new AnchorPane()),stage);
	    
	  //Loading the FXML-file, injecting the screenController into the constructor of the controllers.
	    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("StartPane.fxml"));
	    screenController.addScreen("LoginScreen",(Pane)loader1.load());
	    startScreenController controller1 = loader1.getController();
	    controller1.setScreenController(screenController);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
