package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {

	Media media;
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	Pane pane;
	MediaBar mediaBar;

	public Player(String file) {

		media = new Media(file);
		mediaPlayer = new MediaPlayer(media);
		mediaView = new MediaView(mediaPlayer);
		pane = new Pane();

		pane.getChildren().add(mediaView);

		setCenter(pane);
		setCenter(mediaView);

		mediaBar = new MediaBar(mediaPlayer);
		setBottom(mediaBar);
		

		setStyle("-fx-background-color: #000000");

		mediaPlayer.play();
	}

}
