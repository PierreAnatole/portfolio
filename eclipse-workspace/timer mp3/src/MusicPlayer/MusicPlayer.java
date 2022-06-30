package MusicPlayer;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {
	
	private String filename;
	private Media sound; 
	private MediaPlayer mediaPlayer;
	private boolean isPlaying=false;
	
	public void setFilename(String filename) {
		this.filename = filename;
		this.sound = new Media(new File(filename).toURI().toString());
		this.mediaPlayer = new MediaPlayer(sound);
		this.mediaPlayer.setVolume(0.5);
	}
	
	public void play() {
		if(filename!=null) {
			mediaPlayer.play();
			this.isPlaying=true;
		}
	}
	
	public void stop() {
		if(isPlaying) {
			mediaPlayer.stop();
		}
		this.isPlaying=false;
	}
	
	public void setVolume(double volume) {
		if(isPlaying) {
			mediaPlayer.setVolume(volume);
		}
	}
	
}
