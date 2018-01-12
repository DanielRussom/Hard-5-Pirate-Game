package application.model;

import java.util.Random;

public class Ability {
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

	public void perform(Pirate user) {
		if(currentCooldown < 0) {
			System.out.println("Cooldown!");
			return;
		}
		Random rand = new Random();
		int value = rand.nextInt(100);
		if(value > hitChance) {
			System.out.println("Missed!");
		}
		//TODO Decide targetting method
		user.getTarget().takeHit(power);
		currentCooldown = cooldown;
	}
	
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
}
