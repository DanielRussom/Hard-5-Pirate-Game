package application.model;

public class Ability {
	String name;
	int power;
	int cooldown;
	int currentCooldown;
	/**
	 * @param name - Name
	 * @param power - Attack Power
	 */
	public Ability(String name, int power, int cooldown) {
		this.name = name;
		this.power = power;
		this.cooldown = cooldown;
	}
}
