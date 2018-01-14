package application.model;

import java.util.Random;

import application.GameController;

public class DamagingAbility extends Ability {

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
	public DamagingAbility(String name, int power, int cooldown, int hitChance) {
		super(name, power, cooldown, hitChance);
	}

	public void perform(Pirate user, Pirate target) {
		if (currentCooldown > 0) {
			System.out.println("Cooldown!");
			return;
		}
		Random rand = new Random();
		int value = rand.nextInt(100);
		if (value > hitChance) {
			System.out.println("Missed!");
		}
		// TODO Decide targetting method
		target.takeHit(power);
		currentCooldown = cooldown;
	}
}
