package application.view;

import java.util.ArrayList;

import application.GameController;
import application.model.Pirate;
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
	
	ArrayList<Button> actionButtons = new ArrayList<Button>();
	
	@FXML 
	public void performFirstAbility() {
		Pirate player = GameController.getInstance().getPlayer();
		player.setSelectedAbility(0);
		player.performAttack();
	}
	
	@FXML 
	public void performSecondAbility() {
		Pirate player = GameController.getInstance().getPlayer();
		player.setSelectedAbility(1);
		player.performAttack();
		
	}
	
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
	
	public void initAbilityButtons() {
		actionButtons.add(actionButton1);
		actionButtons.add(actionButton2);
		
	}

	/**
	 * @return the actionButtons
	 */
	public ArrayList<Button> getActionButtons() {
		return actionButtons;
	}
}
