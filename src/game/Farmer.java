package game;

public class Farmer extends Human{

	protected Farmer(String name) {
		super(name, 'F',50);
		super.behaviour.add(0,new PlantBehaviour());
	}
	
	
}
