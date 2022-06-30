package application;

import java.lang.System.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ProgramController {
	
	@FXML
	TextField textFieldName;
	@FXML
	ListView<String>listNames;
	@FXML
	Button buttAdd;
	@FXML
	Button buttRemove;
	@FXML
	Button buttCross;
	
	public ProgramController()  {
		
	}
	
	public void addName() {
		String nameString = textFieldName.getText();
		listNames.getItems().add(nameString);
	}
	
	public void removeName() {
		String toDelete = listNames.getSelectionModel().getSelectedItem();
		listNames.getItems().remove(toDelete);
	}

	public void crossName() {
		String toCross = listNames.getSelectionModel().getSelectedItem();
		int index = listNames.getItems().indexOf(toCross);
		listNames.getItems().get(index);


	}
}
