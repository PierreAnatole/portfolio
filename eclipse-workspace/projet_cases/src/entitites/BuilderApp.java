package entitites;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class BuilderApp {
	
	public VBox buildAll() {
		VBox page = new VBox();
		
		// Creation de la zone de texte et sa zone d'affichage (saisieAff)
		Label label = new Label("Tapez votre texte");
		HBox affichage = new HBox(); // Zone d'affichage
		Text texte = new Text("");
		
		affichage.getChildren().add(texte);
		TextField saisie = new TextField();
		VBox saisieAff = createSaisie(label,saisie,affichage); // Zone de texte + son label + zone d'affichage
		
		// Creation de la checkbox (choix)
		CheckBox fondCheck = new CheckBox("Couleur du fond");
		CheckBox texteCheck = new CheckBox("Couleur du texte");
		CheckBox casseCheck = new CheckBox("casse");
		VBox choix = createCheckBox("Choix", fondCheck,texteCheck,casseCheck);
		
		// Creation de la ligne zone de texte + checkbox (zoneTxtCheck)
		HBox zoneTxtCheck = new HBox();
		zoneTxtCheck.getChildren().addAll(saisieAff,choix);
		
		// Creation du bouton radio pour le fond(fondRadio)
		ToggleGroup fondGroup = new ToggleGroup();
		RadioButton fondRouge = new RadioButton("Rouge");
		RadioButton fondVert = new RadioButton("Vert");
		RadioButton fondBleu = new RadioButton("Bleu");
		final VBox fondRadio = createRadio("Fond", fondGroup, fondRouge,fondVert,fondBleu);
		
		// Creation du bouton radio pour le texte(texteRadio)
		ToggleGroup texteGroup = new ToggleGroup();
		RadioButton texteRouge = new RadioButton("Rouge");
		RadioButton texteVert = new RadioButton("Vert");
		RadioButton texteBleu = new RadioButton("Bleu");
		final VBox texteRadio = createRadio("texte", texteGroup, texteRouge,texteVert,texteBleu);
		
		// Creation du bouton radio pour la casse(casseRadio)
		ToggleGroup casseGroup = new ToggleGroup();
		RadioButton casseMin = new RadioButton("minuscule");
		RadioButton casseMaj = new RadioButton("MAJUSCULE");
		final VBox casseRadio = createRadio("casse", casseGroup, casseMin, casseMaj);
		
		
		// Creation de la ligne contenant les 3 sélécteur radio(radios)
		HBox radios = new HBox();
		radios.getChildren().addAll(fondRadio,texteRadio,casseRadio);

		// Assemblage de la page
		page.getChildren().addAll(zoneTxtCheck,radios);
		
		// Placements
		page.setSpacing(50);
		page.setPadding(new Insets(30,15,30,15));
		zoneTxtCheck.setSpacing(46);
		affichage.setPadding(new Insets(20,0,20,10));
		affichage.setBackground(new Background(new BackgroundFill(Color.rgb(244,244,244), new CornerRadii(0), Insets.EMPTY)));
		choix.setSpacing(10);
		radios.setSpacing(40);
		
		// Scripts
		// Changement du texte
		saisie.textProperty().addListener((obs,oldValue,newValue)->{
			// modification de la casse à chaque nouveau caractère.
		    texte.setText(changeToCorrectCasse(newValue, casseGroup)); 
		    
		    // Modification de l'etat des checkbox et radios à chaque changement dans le champ texte.
		    checkBoxRadioActivation(oldValue,newValue,choix,fondRadio,texteRadio,casseRadio,fondCheck,texteCheck,casseCheck);
		});
		
		// Disable des radios avec les checkbox
		// Toggle de chaque champs quand on clique sur la checkbox correspondante.
		fondCheck.setOnAction(e -> toggleRadio(fondRadio));
		texteCheck.setOnAction(e -> toggleRadio(texteRadio));
		casseCheck.setOnAction(e -> toggleRadio(casseRadio));
		
		// radio couleur de fond
		fondGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			  public void changed(ObservableValue<? extends Toggle> changed, Toggle oldVal, Toggle newVal) {
			    // Cast new to RadioButton.
			    RadioButton rb = (RadioButton)newVal;
			    String newValue = rb.getText();
			    switchBGColor(affichage, newValue); //Modification du fond en fonction de la nouvelle valeur du bouton radio.
			  }
		});
		
		// radio couleur de texte
		texteGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			  public void changed(ObservableValue<? extends Toggle> changed, Toggle oldVal, Toggle newVal) {
			    // Cast new to RadioButton.
			    RadioButton rb = (RadioButton)newVal;
			    String newValue = rb.getText();
			    switchTextColor(texte, newValue); //Modification du texte en fonction de la nouvelle valeur du bouton radio.
			  }
		});
		
		// radio casse
		casseGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			  public void changed(ObservableValue<? extends Toggle> changed, Toggle oldVal, Toggle newVal) {
			    // Cast new to RadioButton.
			    RadioButton rb = (RadioButton)newVal;
			    String newValue = rb.getText();
			    switchCasse(texte, newValue); //Modification de la casse en fonction de la nouvelle valeur du bouton radio.
			  }
		});
		

		return page;
	}


	
	
	private VBox createCheckBox(String labTxt, CheckBox... checks) {
		VBox vb = new VBox();
		Label label = new Label(labTxt);
		vb.getChildren().add(label);
		for (CheckBox checkBox : checks) {
			vb.getChildren().add(checkBox);
		}
		// Placements
		vb.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		vb.setPadding(new Insets(5));
		vb.setDisable(true);
		return vb;
	}
	
	private VBox createSaisie( Label label, TextField textField, HBox affichage) {
		VBox vb = new VBox();
		vb.getChildren().addAll(label,textField,affichage);
		return  vb;
	}
	
	private VBox createRadio(String labTxt, ToggleGroup toggleGroup, RadioButton... buttons) {
		VBox vb = new VBox();
		Label label = new Label(labTxt);
		vb.getChildren().add(label);
		for (RadioButton radioButton : buttons) {
			radioButton.setToggleGroup(toggleGroup);
			vb.getChildren().add(radioButton);
		}
		// Placements
		vb.setDisable(true);
		vb.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		vb.setPadding(new Insets(5));
		vb.setSpacing(10);
		return vb;
	}
	
	/**
	 * Change l'etat du bouton : désactivé si il était activé et vice versa.
	 * 
	 * @param button Le bouton sur lequel modifier l'etat.
	 */
	private void toggleRadio(VBox button) {
		if (button.isDisabled()) {
			button.setDisable(false);
		} else {
			button.setDisable(true);
		}
	}
	
	/**
	 * Change la couleur du fond en fonction de la valeur recupérée dans la checkbox.
	 * 
	 * @param affichage Le background à modifier
	 * @param value La valeur correspondant à la checkbox : Rouge, Vert ou Bleu.
	 */
	private void switchBGColor (HBox affichage, String value){
		switch (value) {
		case "Rouge":
			affichage.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(0), Insets.EMPTY)));
			break;
		case "Vert":
			affichage.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), Insets.EMPTY)));
			break;
		case "Bleu":
			affichage.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(0), Insets.EMPTY)));
			break;
		default:
			break;
		}
	}
	
	/**
	 * Change la couleur du texte en fonction de la valeur recupérée dans la checkbox.
	 * 
	 * @param texte Le texte à modifier
	 * @param value La valeur correspondant à la checkbox : Rouge, Vert ou Bleu.
	 */
	private void switchTextColor(Text texte, String value) {
		switch (value) {
		case "Rouge":
			texte.setFill(Color.RED);
			break;
		case "Vert":
			texte.setFill(Color.GREEN);
			break;
		case "Bleu":
			texte.setFill(Color.BLUE);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Modifie la casse du texte d'après la value choisie en paramètre. value est égale à minuscule ou MAJUSCULE.
	 * 
	 * @param texte le texte à modifier.
	 * @param value la valeur, minuscule ou MAJUSCULE
	 */
	private void switchCasse(Text texte, String value) {
		switch (value) {
		case "minuscule":
			texte.setText(texte.getText().toLowerCase());
			break;
		case "MAJUSCULE":
			texte.setText(texte.getText().toUpperCase());
			break;
		default:
			break;
		}
	}
	

	/**
	 * Change la casse du texte d'aprèes la checkbox. Si aucune casse n'est selectionné, le texte reste tel quel.
	 * Si MAJUSCULE est selectionné le texte renvoyé sera passé en majuscule.
	 * Si minuscule est selectionné le texte renvoyé sera passé en minuscule.
	 * 
	 * @param text Le texte à modifier
	 * @param selectedCasse La checkbox ou récuperer la casse.
	 * @return Le texte modifié si besoin.
	 */
	private String changeToCorrectCasse(String text, ToggleGroup selectedCasse) {
		String casse="";
		if (selectedCasse.getSelectedToggle() != null) {
			RadioButton rb = (RadioButton) selectedCasse.getSelectedToggle();
			casse=rb.getText();
		} // la casse correspond a minuscule ou majuscule. Si aucun des deux n'est selectionné, elle correspond à ""
		switch (casse) {
		case "": // Si aucune casse n'est selectionné, on effectue aucun traitement.
			return text;
		case "minuscule": // Si la casse selectionnée est minuscule, on passe le texte en minuscule.
			return text.toLowerCase();
		case "MAJUSCULE": // Si la casse selectionnée est majuscule, on passe le texte en majuscule.
			return text.toUpperCase();
		default:
			break;
		}
		return null;
	}
	
	/**
	 * Gère les activations de la checkbox en fonction du nouveau texte.
	 * Si le texte devient vide, les checkbox et radios sont désactivées.
	 * Si le texte n'est plus vide, la checkbox est réactivée et chaque radio est réactivé en fonction de la checkbox.
	 * Si le texte n'etait pas vide et le reste, aucun traitement n'est effectué.
	 * 
	 * @param oldValue L'ancienne valeur du texte.
	 * @param newValue La nouvelle valeur du texte.
	 * @param choix La checkbox
	 * @param fondRadio Le champ radio du fond.
	 * @param texteRadio Le champ radio du texte.
	 * @param casseRadio Le champ radio de la casse.
	 * @param fondCheck La checkbox correspondant à l'activation du fond.
	 * @param texteCheck La checkbox correspondant à l'activation du texte.
	 * @param casseCheck La checkbox correspondant à l'activation de la casse.
	 */
	private void checkBoxRadioActivation(String oldValue, String newValue, VBox choix, VBox fondRadio, VBox texteRadio, VBox casseRadio, CheckBox fondCheck, CheckBox texteCheck, CheckBox casseCheck) {
		if (newValue.equals("")) { // Si le texte est de nouveau vide :
			choix.setDisable(true); // On desactive tous les champs
			fondRadio.setDisable(true);
			texteRadio.setDisable(true);
			casseRadio.setDisable(true);
		}
		if (oldValue.equals("")) { // Si le texte n'est plus vide :
			choix.setDisable(false); // On reactive les checkbox
			if (fondCheck.isSelected()) { // On reactive chaque champ encore selectionnés par les checkbox
				fondRadio.setDisable(false);
			}
			if (texteCheck.isSelected()) {
				texteRadio.setDisable(false);
			}
			if (casseCheck.isSelected()) {
				casseRadio.setDisable(false);
			}
		}
		
	}
	
	
}
