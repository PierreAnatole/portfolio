package entities;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
		
		// Creation de la zone d'affichage.
		HBox affichage = new HBox();
		
		
		// Creation de la zone gérant la couleur rouge.
		Slider sliderRouge = new Slider();
		Label labelRouge = new Label("Rouge");
		HBox affRouge = new HBox();
		Text texteRouge = new Text("128");
		HBox zoneRouge = createSliderZone(labelRouge,sliderRouge,affRouge,texteRouge);
		
		// Creation de la zone gérant la couleur vert.
		Slider sliderVert = new Slider();
		Label labelVert = new Label("Vert    ");
		HBox affVert = new HBox();
		Text texteVert = new Text("128");
		HBox zoneVert = createSliderZone(labelVert,sliderVert,affVert,texteVert);
		
		// Creation de la zone gérant la couleur bleu.
		Slider sliderBleu = new Slider();
		Label labelBleu = new Label("Bleu   ");
		HBox affBleu = new HBox();
		Text texteBleu = new Text("128");
		HBox zoneBleu = createSliderZone(labelBleu,sliderBleu,affBleu,texteBleu);
		
		// Creation de la page
		page.getChildren().addAll(affichage,zoneRouge,zoneVert,zoneBleu);
		
		// Style
		page.setSpacing(30);
		affichage.setPadding(new Insets(50,55,50,5));
		affichage.setAlignment(Pos.CENTER);
		affichage.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		affichage.setBackground(new Background(new BackgroundFill(Color.rgb(128, 128, 128), new CornerRadii(0), Insets.EMPTY)));
	    affRouge.setBackground(new Background(new BackgroundFill(Color.rgb(128, 0, 0), new CornerRadii(0), Insets.EMPTY)));
	    affVert.setBackground(new Background(new BackgroundFill(Color.rgb(0, 128, 0), new CornerRadii(0), Insets.EMPTY)));
	    affBleu.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 128), new CornerRadii(0), Insets.EMPTY)));
		
		// Scripts
		// Listener pour le slider rouge
        sliderRouge.valueProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
					// à chaque déplacement du slider rouge :
					int newRed = newValue.intValue(); // On récupère la nouvelle valeur du slider
					texteRouge.textProperty().setValue(String.valueOf(newRed)); // On change la valeur du texte à droite.
					setRGB(affRouge, newRed, 0, 0); // On change la valeur rouge du RGB avec la nouvelle valeur.
					int[] oldRGB = getRGB(affichage); // On récupère les valeurs RGB de l'affichage principal.
					setRGB(affichage, newRed, oldRGB[1], oldRGB[2]); // On change la valeur du rouge de l'affichage principal, en gardant l'ancienne valeur du vert et du bleu.
				}
        });
        
        // Listener pour le slider vert
        sliderVert.valueProperty().addListener(new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
        		int newGreen = newValue.intValue(); 
        		texteVert.textProperty().setValue(String.valueOf(newGreen)); 
        		setRGB(affVert, 0, newGreen, 0);
        		int[] oldRGB = getRGB(affichage);
        		setRGB(affichage, oldRGB[0], newGreen, oldRGB[2]);
        	}
        });
        
     // Listener pour le slider bleu
        sliderBleu.valueProperty().addListener(new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
        		int newBlue = newValue.intValue();
        		texteBleu.textProperty().setValue(String.valueOf(newBlue));
        		setRGB(affBleu, 0, 0, newBlue);
        		int[] oldRGB = getRGB(affichage);
        		setRGB(affichage, oldRGB[0], oldRGB[1], newBlue);
        	}
        });

		return page;
	}
	
	private HBox createSliderZone(Label label,Slider slider,HBox affichage, Text text) {
		HBox hb = new HBox();
		slider.setMin(0);
	    slider.setMax(255);
	    slider.setValue(128);
        
        // Style
	    slider.setShowTickLabels(true);
	    affichage.setPadding(new Insets(10,70,30,30));
	    affichage.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
	    hb.setSpacing(10);
	    hb.setPadding(new Insets(0,0,0,30));
	    hb.getChildren().setAll(label,slider,affichage,text);
		return hb;
	}
	
	/**
	 * Récupère les valeurs RGB de l'affichage principal.
	 * 
	 * @param affichage La HBox sur laquelle récuperer les valeurs RGB
	 * @return Un array d'int de taille 3 contenant les valeurs RGB 0 et 255 : [rouge,vert,bleu].
	 */
	private int[] getRGB(HBox affichage) {
		int[] rgb = new int[3];
		// On récupère la chaine de caractère hexadécimale correspondant au RGB sous la forme 0x808080ff pour 80,80,80.(hexadecimal).
		String hex = (affichage.getBackground().getFills().get(0).getFill().toString());
		String red = hex.substring(2,4); // On récupère le premier champ hexadécimal correspondant au rouge.
		String green = hex.substring(4,6); // On récupère le deuxième champ hexadécimal correspondant au vert.
		String blue = hex.substring(6,8); // On récupère le troisième champ hexadécimal correspondant au bleu.
		
		// On converti chaque champs en int (0-255) et on l'ajoute dans l'array.
		rgb[0]=Integer.parseInt(red, 16); 
		rgb[1]=Integer.parseInt(green, 16);
		rgb[2]=Integer.parseInt(blue, 16);
		return rgb;
	}
	
	/**
	 * Modifie les valeurs RGB d'un HBox passé en paramètre. r, g et b correspondent au nombre entre 0 et 255 correspondant à chaque couleur RGB.
	 * 
	 * @param affichage L'affichage sur lequel modifier la couleur.
	 * @param r La nouvelle valeur de rouge
	 * @param g La nouvelle valeur de vert.
	 * @param b La nouvelle valeur de bleu.
	 */
	private void setRGB(HBox affichage, int r, int g, int b) {
		affichage.setBackground(new Background(new BackgroundFill(Color.rgb(r, g, b), new CornerRadii(0), Insets.EMPTY)));
	}
}
