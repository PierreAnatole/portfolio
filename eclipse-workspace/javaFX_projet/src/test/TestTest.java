package test;

import entities.BuilderTest;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TestTest extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Initialisation de base (on lie le borderPane à la scene)
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// ajout des boites
			BuilderTest boxes = new BuilderTest();
			root.setCenter(boxes.txtButton("Label text","Cliquez moi"));
			
			// affichage et paramètrages
			primaryStage.setTitle("test box");
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(false); // True pour afficher en plein ecran.
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
