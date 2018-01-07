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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
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
	 * @param power the power to set
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
	 * @param cooldown the cooldown to set
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
	 * @param currentCooldown the currentCooldown to set
	 */
	public void setCurrentCooldown(int currentCooldown) {
		this.currentCooldown = currentCooldown;
	}
}
