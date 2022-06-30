package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ColorPickerTest extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			VBox page = new VBox();
            page.setSpacing(50);
            root.setTop(page);
            Rectangle rectangle = new Rectangle();
            rectangle.setFill(Color.WHITE);
            rectangle.setWidth(100);
            rectangle.setHeight(70);
            ColorPicker picker = new ColorPicker();
            page.getChildren().addAll(rectangle,picker);
             picker.setOnAction(e -> {
                 rectangle.setFill(picker.getValue());               
             });
			
			
			primaryStage.setTitle("Couleurs");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
