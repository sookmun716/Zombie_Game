package game;

/**
 * A subclass of Human that represents an farmer.
 * 
 * @author Tan Song Shun
 *
 */
public class Farmer extends Human {
	/**
	 * This is the constructor for the Farmer class, the three behaviours is added
	 * into the behaviour ArrayList when the Farmer is instantiated.
	 * 
	 * @param name String that represents a Farmer's name.
	 * 
	 */
	protected Farmer(String name) {
		super(name, 'F', 50);
		this.behaviour.add(1, new PlantBehaviour());
		this.behaviour.add(2, new FertiliseBehaviour());
		this.behaviour.add(3, new HarvestBehaviour());
	}

}
