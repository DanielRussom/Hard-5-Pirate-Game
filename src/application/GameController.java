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
	private ArrayList<Pirate> activePlayers = new ArrayList<Pirate>();
	private int turnNumber = 0;
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
	 * Checks to see if the game is over
	 * 
	 * @return if the game is over
	 */
	public boolean checkForGameOver() {
		if (player.getCurrentHealth() == 0) {
			System.out.println("You died!");
			return true;
		}
		if (enemy.getCurrentHealth() == 0) {
			System.out.println("You win!");
			return true;
		}
		return false;
	}

	/**
	 * Handles starting the next player's turn
	 */
	public void handleNextTurn() {
		updateHealth();
		if (checkForGameOver()) {
			return;
		}
		refreshButtons();
		// Increments turn counter
		turnNumber += 1;
		if (turnNumber >= activePlayers.size()) {
			turnNumber = 0;
		}
		if (activePlayers.get(turnNumber).equals(player)) {
		} else {
			// TODO
			activePlayers.get(turnNumber).performComputerTurn();
			activePlayers.get(turnNumber).performAttack();
		}
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
			// Updates the tooltip of the ability
			current.getTooltip().setText(currentAbility.tooltipMessage());
			// Disables the ability if it is on cooldown
			if (currentAbility.getCurrentCooldown() > 0) {
				current.setDisable(true);
				current.setText(currentAbility.getName() + "\n(" + currentAbility.getCurrentCooldown() + ")");
			} else {
				current.setDisable(false);
				current.setText(currentAbility.getName());
			}
		}
	}

	/**
	 * Sets up the game
	 */
	public void setup() {
		// TODO Tidy - Make more dynamic
		gameDisplayController.initAbilityButtons();
		refreshButtons();
		activePlayers.add(player);
		activePlayers.add(enemy);
		gameDisplayController.setPlayerName(player.getName());
		gameDisplayController.setEnemyName(enemy.getName());
		// TODO Change this if multiple targets are added
		// Default targets
		player.setTarget(enemy);
		enemy.setTarget(player);
		turnNumber = 0;
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

	/**
	 * Updates the health display of active players
	 */
	public void updateHealth() {
		gameDisplayController.updatePlayerHealth(player.getMaxHealth(), player.getCurrentHealth());
		gameDisplayController.updateEnemyHealth(enemy.getMaxHealth(), enemy.getCurrentHealth());

	}

}
