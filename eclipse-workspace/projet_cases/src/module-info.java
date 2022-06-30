module projet_cases {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	
	opens test to javafx.graphics, javafx.fxml;
}
