package test;

import Exception.NotGeometricShapeException;
import entities.BuilderListener;
import interfaces.Figures;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class ListenerExample extends Application{

	@Override
	public void start(Stage primaryStage) {
		
        try {
        	BorderPane root = new BorderPane();
        	Scene scene = new Scene(root, 800, 600);
        	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        	primaryStage.setScene(scene);

        	// création d'une instance de Horizontal box une boite qui contient que des
        	// eléments dont l'alignment est horizontal
            HBox hbTop = new HBox();

            // je posistionne ma hbTop en haut
            root.setTop(hbTop);
            Label NameLabel = new Label("name of the figure");

            // padding pour notre label N
            NameLabel.setPadding(new Insets(7));

            // Création d'un objet (champ qui va contenir le nom) instance de la classe
            // Texfield

            TextField nameField = new TextField();
            nameField.setPadding(new Insets(7));

            Button btAdd = new Button("add");
            Button btRemove = new Button("delete");
            Button btView = new Button("View");
            // ajout des éléments à ma HBOX

            hbTop.getChildren().addAll(NameLabel, nameField, btAdd, btRemove, btView);

            // Espacer mes elmts ajoutés
            hbTop.setSpacing(10);

            // Création d'une VBox en instanciant

            VBox vb = new VBox();
            vb.setPadding(new Insets(8));

            ListView<String> list = new ListView<>();

            list.getItems().addAll("Rectangle", "square", "triangle", "circle");

            vb.getChildren().add(list);

            btAdd.setOnAction(e -> {
            	String nom = nameField.getText();
            	
            	try {
            		BuilderListener.lookupInFigures(nom);
            		list.getItems().add(nom);
				} catch (NotGeometricShapeException exc) {
					System.out.println(exc.getMessage());
				}
            });

            btRemove.setOnAction(e -> {
            	list.getItems().remove(list.getSelectionModel().getSelectedItem());
            });
            
            btView.setOnAction(e -> {
            	System.out.println(list.getSelectionModel().getSelectedItem());
            });
            
            
            root.setCenter(list);
            primaryStage.show();
            primaryStage.centerOnScreen();
            

        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
