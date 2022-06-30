package test;
	
import entitites.BuilderApp;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class ApplicationTest extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,500,350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			BuilderApp builder = new BuilderApp();
			root.setTop(builder.buildAll());

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
