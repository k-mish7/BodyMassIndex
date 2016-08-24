package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

	Player player;
	MenuItem open;
	Menu file;
	MenuBar menuBar;
	FileChooser fileChooser;
	Scene scene;

	@Override
	public void start(Stage primaryStage) {

		open = new MenuItem("Open");
		file = new Menu("File");
		menuBar = new MenuBar();

		file.getItems().add(open);
		menuBar.getMenus().add(file);

		fileChooser = new FileChooser();

		open.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				player.mediaPlayer.pause();
				player.mediaBar.playButton.setText(">");
				File file = fileChooser.showOpenDialog(primaryStage);
				if (file != null) {

					try {

						player = new Player(file.toURI().toURL().toExternalForm());
						player.setTop(menuBar);
						scene = new Scene(player, Screen.getPrimary().getVisualBounds().getWidth(),
								Screen.getPrimary().getVisualBounds().getHeight(), Color.BLACK);
						primaryStage.setScene(scene);
						primaryStage.setMinHeight(480);
						primaryStage.setMinWidth(720);

						primaryStage.setMaximized(true);
						primaryStage.show();

					} catch (MalformedURLException e) {

						e.printStackTrace();
					}
				}
			}
		});

		player = new Player("file:///C:/Users/Kuldeep/Desktop/Marvel_Marathon/Viren.mp4");
		player.setTop(menuBar);
		scene = new Scene(player, Screen.getPrimary().getVisualBounds().getWidth(),
				Screen.getPrimary().getVisualBounds().getHeight(), Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(480);
		primaryStage.setMinWidth(720);

		primaryStage.setMaximized(true);

		primaryStage.show();

		primaryStage.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub

				player.mediaView.setFitWidth((double) newValue);
			}
		});

		primaryStage.heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub

				player.mediaView.setFitHeight((double) newValue);
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}
