package application.model;

public class Pirate {
	Ability[] abilities = new Ability[2];

	/**
	 * Default Pirate constructor with preset abilities
	 */
	public Pirate() {
		abilities[0] = new Ability("Attack", 10, 0);
		abilities[1] = new Ability("Strong Attack", 20, 3);
	}

	/**
	 * @param abilities
	 *            - List of abilities
	 */
	public Pirate(Ability[] abilities) {
		this.abilities = abilities;
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

}
