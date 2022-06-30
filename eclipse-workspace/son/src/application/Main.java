package application;
	
import Build.BuilderApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Timer mp3");
	
			BuilderApp builder = new BuilderApp();
			VBox page = builder.buildAll();
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Scene scene = new Scene(page,600,600);
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
