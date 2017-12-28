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
}
