package application;

import java.io.IOException;

import application.model.Pirate;
import application.view.GameDisplayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane rootLayout;
	private GameDisplayController gameDisplayController;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Pirate Game");

		showGameDisplay();
		GameController gameController = GameController.getInstance();
		Pirate player = gameController.getPlayer();
		//TODO Tidy - Make more dynamic - Move to Game Controller?
		gameDisplayController.setActionButton1Text(player.getAbilityByIndex(0).getName());
		gameDisplayController.setActionButton2Text(player.getAbilityByIndex(1).getName());
	}

	/**
	 * Initializes the root layout.
	 */
	public void showGameDisplay() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GameDisplay.fxml"));
			rootLayout = (AnchorPane) loader.load();
			gameDisplayController = loader.getController();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return primaryStage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
