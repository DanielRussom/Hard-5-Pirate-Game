package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameDisplayController {
	@FXML
	Button actionButton1;
	@FXML
	Button actionButton2;
	@FXML
	Label playerHealth;
	@FXML
	Label enemyHealth;
	
	
	public void setActionButton1Text(String text) {
		actionButton1.setText(text);
	}
	
	public Button getActionButton1() {
		return actionButton1;
	}
	
	public void setActionButton2Text(String text) {
		actionButton2.setText(text);
	}
	
	public void updatePlayerHealth(int maxHealth, int currentHealth) {
		playerHealth.setText(currentHealth + "/" + maxHealth);
	}
	
	public void updateEnemyHealth(int maxHealth, int currentHealth) {
		enemyHealth.setText(currentHealth + "/" + maxHealth);
	}
}
