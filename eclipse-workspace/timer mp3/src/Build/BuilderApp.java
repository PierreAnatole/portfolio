package Build;


import java.util.regex.Pattern;

import MusicPlayer.MusicPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class BuilderApp {
	
	 private int timeSeconds;
	 private Timeline timeline;
	 private Label timerLabel = new Label();
	 private String musicToPlay;
	 private MusicPlayer musicPlayer = new MusicPlayer();
	 
	public VBox buildAll() {
		// ######################## create elements ##################	
		VBox page = new VBox();
		
		// drag target
		Label label = new Label("drop mp3 file here");
	    Label dropped = new Label("");
	    VBox dragTarget = new VBox();
	    dragTarget.getChildren().addAll(label,dropped);
	    
	    // Timer
	    HBox timers = new HBox();
	    Label labHeure = new Label("hours");
	    TextArea heure = new TextArea("0");
	    Label labMinute = new Label("minutes");
	    TextArea minute = new TextArea("0");
	    Label labSecond = new Label("seconds");
	    TextArea second = new TextArea("0");
	    timers.getChildren().addAll(labHeure,heure,labMinute,minute,labSecond,second);
	    
	    // launch button
	    HBox boxButton = new HBox();
	    Button btnLaunch = new Button("launch timer");
	    Button btnStop = new Button("stop timer & music");
	    boxButton.getChildren().addAll(btnLaunch,btnStop);
	    
	    // Affichage timer
	    timerLabel.setText(seconds2Time(timeSeconds));
	    
	    // Volume slider
	    Slider volumeSlider = new Slider();
	    volumeSlider.setMin(0);
	    volumeSlider.setMax(100);
	    volumeSlider.setValue(50);
	    volumeSlider.setOrientation(Orientation.VERTICAL);
	    HBox timerSlider = new HBox();
	    timerSlider.getChildren().addAll(timerLabel,volumeSlider);
	    
	    // Assemblage de la page
	    page.getChildren().addAll(dragTarget,timers,boxButton,timerSlider);
	    
	    // ######################## Style ##################################
	    dragTarget.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
	    dragTarget.setMargin(dragTarget, new Insets(50,50,50,50));
	    dragTarget.setAlignment(Pos.CENTER);
	    dragTarget.setPrefHeight(300);
	    dragTarget.setSpacing(15);
	    dragTarget.setBackground(new Background(new BackgroundFill(Color.rgb(220, 255, 255), new CornerRadii(0), Insets.EMPTY)));
	    
	    timers.setSpacing(5);
	    timers.setAlignment(Pos.CENTER);
	    heure.setPrefSize(80,0);
	    minute.setPrefSize(80,0);
	    second.setPrefSize(80,0);
	    HBox.setMargin(heure, new Insets(0,25,0,0));
	    HBox.setMargin(minute, new Insets(0,25,0,0));
	    HBox.setMargin(second, new Insets(0,25,0,0));
	    
	    boxButton.setSpacing(5);
	    boxButton.setAlignment(Pos.CENTER);
	    boxButton.setPadding(new Insets(30,0,0,0));
	    
	    timerSlider.setAlignment(Pos.CENTER_RIGHT);
	    timerLabel.setStyle("-fx-font-size: 4em;");
	    HBox.setMargin(timerLabel,  new Insets(0,195,0,0));
	    HBox.setMargin(volumeSlider,  new Insets(0,15,10,0));
	    volumeSlider.setPrefHeight(80);

	    
	    

	    page.setBackground(new Background(new BackgroundFill(Color.rgb(245, 245, 245), new CornerRadii(0), Insets.EMPTY)));
	    page.setAlignment(Pos.CENTER);
	    
	    
	    // ##################### Scripts #######################################
	    
	    // Drag and drop area
	    dragTarget.setOnDragOver(new EventHandler<DragEvent>() { // Allow to drop on the area
	    	@Override
	        public void handle(DragEvent event) {
	    		if (event.getGestureSource() != dragTarget && event.getDragboard().hasFiles()) {
	                   /* allow for both copying and moving, whatever user chooses */
	                   event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	    		}
	    		event.consume();
	        }
	    });
	    
	    dragTarget.setOnDragDropped(new EventHandler<DragEvent>() { // Executed instructions on drop
	    	@Override
	    	public void handle(DragEvent event) {
	    		Dragboard db = event.getDragboard();
	    		boolean success = false;
	    		if (db.hasFiles()) { // Instructions on drop
	    			String pathToPlay = removeSqBrackets(db.getFiles().toString());
	    			dropped.setText(removePath(pathToPlay));
	    			musicToPlay=pathToPlay;
	    			success = true;
	    		}
	    		/* let the source know whether the string was successfully 
	    		* transferred and used */
	    		event.setDropCompleted(success);
	    		event.consume();
	    	}
	    });
	    
	    // launch timer
	    btnLaunch.setOnAction(new EventHandler<ActionEvent>() {
	    	
            @SuppressWarnings("unchecked")
			public void handle(ActionEvent event) { // Launch button on click
            	if (timeline != null) {
                    timeline.stop(); // If the timeline is already in use, stop it
                }
                timeSeconds = time2Seconds(heure, minute, second); // Init time value from the 3 textArea
                timerLabel.setText(seconds2Time(timeSeconds)); // update timerLabel
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE); // Neverending timeline
                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),new EventHandler() { // KeyFrame event handler
                	@Override
                	public void handle(Event arg0) {
                		if (timeSeconds <= 0) { // If timer reach 0
                			musicPlayer.stop(); // if a music is already playing stop it
                			if(musicToPlay!=null) {
                				musicPlayer.setFilename(musicToPlay);
                			}
                			musicPlayer.play(); // Play the music
                			timeline.stop(); // stop the timer
                		} else { // if the timer didn't reach 0
                			timeSeconds--; // update timeSeconds
                			timerLabel.setText(seconds2Time(timeSeconds)); // update timerLabel
                		}
                	}
                }));
                timeline.playFromStart(); // Starts the timer
            };
	    });
	    
	    // stop timer and music
	    btnStop.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(timeline!=null) {
					timeline.stop();
				}
				musicPlayer.stop();
			}
	    });
	    
	    // Volume slider
	    volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
        		double newVolume = Double.valueOf(newValue.intValue())/100;
        		musicPlayer.setVolume(newVolume);
        	}
        });
	    
	    
	    return page;
	}
	
	
	
	

	
	
	
	// Utils
	private String removeSqBrackets(String path) {
		return(path.substring(1, path.length()-1));
	}
	
	private String seconds2Time(int totalSeconds) {
		int seconds = totalSeconds%60;
		int minutes = (totalSeconds/60)%60;
		int heures = totalSeconds/60/60;
		String strSeconds = seconds<10 ? "0"+String.valueOf(seconds) : String.valueOf(seconds);
		String strMinutes = minutes<10 ? "0"+String.valueOf(minutes) : String.valueOf(minutes);
		String strHeures = String.valueOf(heures);
		return(strHeures+":"+strMinutes+":"+strSeconds);
	}
	
	private int time2Seconds(TextArea h,TextArea m,TextArea s) {
		int hours;
		if (h.getText().equals("")) {
			hours=0;
		} else {
			hours = Integer.valueOf(h.getText());
		}
		
		int minutes;
		if (m.getText().equals("")) {
			minutes=0;
		} else {
			minutes = Integer.valueOf(m.getText());
		}
		
		int seconds;
		if (s.getText().equals("")) {
			seconds=0;
		} else {
			seconds = Integer.valueOf(s.getText());
		}
		
		int total = seconds + 60*minutes + 60*60*hours;
		return total;
		
	}
	
	private String removePath(String path) {
		String[] segments = path.split(Pattern.quote("\\"));
		String lastPart = segments[segments.length-1];
		
		String[] segments2 = lastPart.split(Pattern.quote("."));
		String noExt = segments2[0];
		return noExt;
	}

}
