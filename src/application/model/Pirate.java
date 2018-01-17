package application.model;

import application.GameController;

public class Pirate {
	Ability[] abilities = new Ability[4];
	int maxHealth;
	int currentHealth;
	Pirate target;
	Ability selectedAbility;

	/**
	 * @return the selectedAbility
	 */
	public Ability getSelectedAbility() {
		return selectedAbility;
	}

	/**
	 * Sets the selected ability by index in abilities array
	 * 
	 * @param selectedAbilityIndex
	 *            - the index of the ability to set
	 */
	public void setSelectedAbility(int selectedAbilityIndex) {
		this.selectedAbility = abilities[selectedAbilityIndex];
	}

	/**
	 * @param selectedAbility
	 *            the selectedAbility to set
	 */
	public void setSelectedAbility(Ability selectedAbility) {
		this.selectedAbility = selectedAbility;
	}

	/**
	 * @return the target
	 */
	public Pirate getTarget() {
		return target;
	}

	/**
	 * @param target
	 *            the target to set
	 */
	public void setTarget(Pirate target) {
		this.target = target;
	}

	/**
	 * Default Pirate constructor with preset abilities
	 */
	public Pirate() {
		abilities[0] = new DamagingAbility("Attack", 10, 0, 100);
		abilities[1] = new DamagingAbility("Strong Attack", 20, 3, 100);
		abilities[2] = new HealingAbility("Heal", 25, 4, 100);
		maxHealth = 100;
		currentHealth = maxHealth;
	}

	/**
	 * @param abilities
	 *            - List of abilities
	 */
	public Pirate(Ability[] abilities) {
		this.abilities = abilities;
	}

	public void performAttack() {
		selectedAbility.perform(this, target);
		GameController.getInstance().refreshButtons();
		decrementCooldowns();
	}
	
	/**
	 * Reduces current health after being attacked
	 * 
	 * @param power
	 *            - Power of received attack
	 */
	public void takeHit(int power) {
		System.out.println("Hit!");
		currentHealth -= power;
		if (currentHealth < 0) {
			currentHealth = 0;
		}
		System.out.println(currentHealth + "/" + maxHealth);
	}

	// TODO performTurn()?
	/**
	 * Decrements all active cooldowns
	 */
	public void decrementCooldowns() {
		for (Ability current : abilities) {
			if(current == null) {
				continue;
			}
			if (current.currentCooldown > 0) {
				current.currentCooldown -= 1;
				System.out.println(current.getName() + current.currentCooldown);
			}
		}
	}

	/**
	 * Returns ability in passed in index loction
	 * 
	 * @param index
	 *            - index of ability within abilities array
	 * @return ability
	 */
	public Ability getAbilityByIndex(int index) {
		return abilities[index];
	}

	/**
	 * @return the abilities
	 */
	public Ability[] getAbilities() {
		return abilities;
	}

	/**
	 * @return the maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param maxHealth
	 *            the maxHealth to set
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * @return the currentHealth
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * @param currentHealth
	 *            the currentHealth to set
	 */
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
}
