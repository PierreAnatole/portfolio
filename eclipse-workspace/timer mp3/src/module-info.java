module son {
	requires javafx.controls;
	requires javafx.media;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
