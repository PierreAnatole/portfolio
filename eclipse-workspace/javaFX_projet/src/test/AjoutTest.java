package test;

import entities.BuilderAjout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class AjoutTest extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Initialisation de base (on lie le borderPane à la scene)
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// ajout des boites
			BuilderAjout boxes = new BuilderAjout();
			root.setCenter(boxes.LabelsText("Ajout d'utilisateur","envoi","Nom :","Prenom :","Adresse :","Telephone :"));
			
			// affichage et paramètrages
			primaryStage.setTitle("ajout test");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.centerOnScreen(); // Centre la fenêtre
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
