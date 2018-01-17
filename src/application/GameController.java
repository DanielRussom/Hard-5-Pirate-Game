package application;

import java.util.ArrayList;

import application.model.Ability;
import application.model.Pirate;
import application.view.GameDisplayController;
import javafx.scene.control.Button;

public class GameController {
	private static GameController instance;
	private GameDisplayController gameDisplayController;

	private Pirate player;

	private Pirate enemy;

	/**
	 * 
	 */
	private GameController() {
		player = new Pirate();
		enemy = new Pirate();
	}

	/**
	 * Gets singleton instance of this class
	 * 
	 * @return instance - instance of class.
	 */
	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	/**
	 * Handles refreshing the action button display
	 */
	public void refreshButtons() {
		ArrayList<Button> actionButtons = gameDisplayController.getActionButtons();
		for (int i = 0; i < actionButtons.size(); i++) {
			Ability currentAbility = player.getAbilityByIndex(i);
			Button current = actionButtons.get(i);
			// Hides the action button if there aren't enough abilities
			if (currentAbility == null) {
				current.setVisible(false);
				continue;
			}
			// Displays current ability text on current button
			current.setVisible(true);
			current.setText(currentAbility.getName());
			// Updates the tooltip of the ability
			current.getTooltip().setText(currentAbility.tooltipMessage());
			// Disables the ability if it is on cooldown
			current.setDisable(currentAbility.getCurrentCooldown() > 0);
		}
	}

	/**
	 * Sets up the game
	 */
	public void setup() {
		// TODO Tidy - Make more dynamic
		gameDisplayController.initAbilityButtons();
		refreshButtons();
		// TODO Change this if multiple targets are added
		// Default targets
		player.setTarget(enemy);
		enemy.setTarget(player);
		// Updates health labels
		gameDisplayController.updatePlayerHealth(player.getMaxHealth(), player.getCurrentHealth());
		gameDisplayController.updateEnemyHealth(enemy.getMaxHealth(), enemy.getCurrentHealth());
	}

	/**
	 * @param gameDisplayController
	 *            the gameDisplayController to set
	 */
	public void setGameDisplayController(GameDisplayController gameDisplayController) {
		this.gameDisplayController = gameDisplayController;
	}

	/**
	 * @return the player
	 */
	public Pirate getPlayer() {
		return player;
	}

	/**
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(Pirate player) {
		this.player = player;
	}

	/**
	 * @return the enemy
	 */
	public Pirate getEnemy() {
		return enemy;
	}

	/**
	 * @param enemy
	 *            the enemy to set
	 */
	public void setEnemy(Pirate enemy) {
		this.enemy = enemy;
	}

}
