package game;

/**
 * A subclass of PortableItem that represents an Food.
 * 
 * @author Tan Song Shun
 *
 */
public class Food extends PortableItem{
	/**
	 * This is the constructor for the Food class. The super constructor is called and
	 * a new EatAction is added into the allowable actions so the food can be eaten.
	 * 
	 */
	public Food() {
		super("Food ", 'f');
		this.allowableActions.add(new EatAction(this));
		// TODO Auto-generated constructor stub
	}
	

}
