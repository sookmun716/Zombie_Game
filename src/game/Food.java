package game;

public class Food extends PortableItem{
	public Food() {
		super("Food ", 'f');
		this.allowableActions.add(new EatAction(this));
		// TODO Auto-generated constructor stub
	}
	

}
