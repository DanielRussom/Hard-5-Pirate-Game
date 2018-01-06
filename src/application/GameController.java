package application;

import application.model.Pirate;

public class GameController {
	private static GameController instance;
	
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
