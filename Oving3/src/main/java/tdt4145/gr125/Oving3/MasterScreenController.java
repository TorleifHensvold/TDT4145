package tdt4145.gr125.Oving3;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MasterScreenController {
	
	
	//HashMap input is a String and a Pane-view. Every controller shares the same instance of the MasterScreenController-object
	//You can use the String-input as a Key, that points at the Pane-view. This makes switching scenes easy.
	
    private HashMap<String, Pane> screenMap = new HashMap<String, Pane>();
    private Scene main;
    private Stage stage;

    
    	//Sets stage.
    public MasterScreenController(Scene scene,Stage stage) {
        this.main = scene;
        this.stage = stage;
    }

    
    
    //method for adding Pane-views. Input is Pane name, and Pane-object.
    protected void addScreen(String name, Pane pane){
         screenMap.put(name, pane);
    }
    
    //method for removing Pane-views. Input is String name. Deletes correspondning Pane.
    protected void removeScreen(String name){
        screenMap.remove(name);
    }
    
    //Activate new Pane-views. Input is String --> Same as constructor String. Calls Pane which points at String-key.
    public void activate(String name){
        main.setRoot(screenMap.get(name));
        stage.setTitle("Test");
        stage.setScene(main);
        stage.show();
    }
}