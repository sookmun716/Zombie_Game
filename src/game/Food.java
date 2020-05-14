package game;

public class Food extends PortableItem{
	private int healAmount=25;
	public Food() {
		super("Food ", 'f');
		this.allowableActions.add(new EatAction(this));
		// TODO Auto-generated constructor stub
	}
	
	public int healAmount() {
		return healAmount;
	}

}
