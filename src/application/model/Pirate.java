package application.model;

public class Pirate {
	Ability[] abilities = new Ability[2];
	int maxHealth;
	int currentHealth;
	Pirate target;

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
		abilities[0] = new Ability("Attack", 10, 0, 100);
		abilities[1] = new Ability("Strong Attack", 20, 3, 100);
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
