package entities;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BuilderTest {

	//TEST
	public HBox figures() {
		HBox hb = new HBox();
		hb.setSpacing(50);
		Circle c1 = new Circle(50,50,50,Color.RED);
		Circle c2 = new Circle(20,20,20);
		c2.setFill(Color.BLUE);
		Rectangle r1 = new Rectangle(30,40,Color.GREEN);
		hb.getChildren().addAll(c1,c2,r1);
		return hb;
	}
	
	public HBox labelText(String labTxt) {
		HBox hb = new HBox();
		Label label = new Label(labTxt);
		TextField tf = new TextField();
		hb.getChildren().addAll(label,tf);
		hb.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		hb.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(0), Insets.EMPTY)));
		return hb;
	}
	
	public HBox button(String btnTxt) {
		HBox hb = new HBox();
		javafx.scene.control.Button btn = new javafx.scene.control.Button(btnTxt);
		hb.getChildren().add(btn);
		return hb;
	}
	
	public VBox txtButton(String labTxt,String btnTxt) {
		VBox vb = new VBox();
		HBox txt = labelText(labTxt);
		HBox btn = button(btnTxt);
		txt.setPadding(new Insets(30,20,30,20));
		btn.setPadding(new Insets(50,0,0,150));
		vb.getChildren().addAll(txt,btn);
		return vb;
	}
	
	
	
}
