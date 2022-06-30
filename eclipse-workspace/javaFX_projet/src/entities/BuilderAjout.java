package entities;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BuilderAjout {
	
	/**
	 * Crée une TextField et son label associé à sa gauche.
	 * 
	 * @param labTxt Le contenu du label
	 * @return L'horizontal Box contenant un label et un TextField.
	 */
	public HBox HorizontalLabelText(String labTxt) {
		HBox hb = new HBox();
		Label label = new Label(labTxt);
		TextField tf = new TextField();
		hb.getChildren().addAll(label,tf);
		hb.setSpacing(20);
		return hb;
	}
	
	/**
	 * Crée une colonne de labels+textfield avec un titre au dessus.
	 * 
	 * @param title Le titre
	 * @param btnTxt Le nom du bouton à ajouter à la fin.
	 * @param labTxt Les noms des labels des textfields à ajouter.
	 * 
	 * @return La Vertical Box Correspondante.
	 */
	public VBox LabelsText(String title, String btnTxt, String... labTxt) {
		VBox vb = new VBox();
		Text t = new Text(title);
		vb.getChildren().add(t);
		vb.setAlignment(Pos.CENTER);
		for (String label : labTxt) {
			HBox hb =HorizontalLabelText(label);
			hb.setPadding(new Insets(0,0,0,30));
			vb.getChildren().add(hb);
		}
		javafx.scene.control.Button btn = new javafx.scene.control.Button(btnTxt);
		vb.getChildren().add(btn);
		vb.setSpacing(50);
		return vb;
	}
}
