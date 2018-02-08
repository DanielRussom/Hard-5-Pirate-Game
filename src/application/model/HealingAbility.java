package application.model;

import java.util.Random;

public class HealingAbility extends Ability {

	public HealingAbility(String name, int power, int cooldown, int hitChance) {
		super(name, power, cooldown, hitChance);
	}

	@Override
	public void perform(Pirate user, Pirate target) {
		if(currentCooldown > 0) {
			return;
		}
		Random rand = new Random();
		int value = rand.nextInt(100);
		if(value > hitChance) {
		}
		//TODO Decide targetting method
		target.takeHeal(power);
		currentCooldown = cooldown;
	}

}
