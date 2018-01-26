package application.model;

public abstract class Ability {
	String name;
	int power;
	int cooldown;
	int currentCooldown;
	int hitChance;

	/**
	 * 
	 * @param name
	 *            - Name
	 * @param power
	 *            - Attack Power
	 * @param cooldown
	 *            - Cooldown
	 * @param hitChance
	 *            - Chance to Hit
	 */
	public Ability(String name, int power, int cooldown, int hitChance) {
		this.name = name;
		this.power = power;
		this.cooldown = cooldown;
		this.hitChance = hitChance;
	}

	/**
	 * Performs an ability
	 * 
	 * @param user
	 *            - Pirate using the ability
	 * @param target
	 *            - Target of the ability
	 */
	abstract public void perform(Pirate user, Pirate target);

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @param power
	 *            the power to set
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * @return the cooldown
	 */
	public int getCooldown() {
		return cooldown;
	}

	/**
	 * @param cooldown
	 *            the cooldown to set
	 */
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	/**
	 * @return the currentCooldown
	 */
	public int getCurrentCooldown() {
		return currentCooldown;
	}

	/**
	 * @param currentCooldown
	 *            the currentCooldown to set
	 */
	public void setCurrentCooldown(int currentCooldown) {
		this.currentCooldown = currentCooldown;
	}

	/**
	 * Generates the ability tooltip message
	 * 
	 * @return - tooltip message
	 */
	public String tooltipMessage() {
		String message = "";
		message = name + "\n";
		message += "Cooldown: TEST\n";
		message += "Power:" + power + "\n";
		message += "Hit Chance:" + hitChance + "%";
		return message;

	}
}
