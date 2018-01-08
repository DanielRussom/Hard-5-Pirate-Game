package application;

import application.model.Pirate;
import application.view.GameDisplayController;

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
	 * Sets up the game
	 */
	public void setup() {
		//TODO Tidy - Make more dynamic
		gameDisplayController.setActionButton1Text(player.getAbilityByIndex(0).getName());
		gameDisplayController.setActionButton2Text(player.getAbilityByIndex(1).getName());
		gameDisplayController.updatePlayerHealth(player.getMaxHealth(), player.getCurrentHealth());
		gameDisplayController.updateEnemyHealth(enemy.getMaxHealth(), enemy.getCurrentHealth());
	}

	/**
	 * @param gameDisplayController the gameDisplayController to set
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
	 * @param player the player to set
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
	 * @param enemy the enemy to set
	 */
	public void setEnemy(Pirate enemy) {
		this.enemy = enemy;
	}
	
	
}
