package game;

public class Farmer extends Human{

	protected Farmer(String name) {
		super(name, 'F',50);
		this.behaviour.add(0,new PlantBehaviour());
		this.behaviour.add(1,new FertiliseBehaviour());
		this.behaviour.add(2,new HarvestBehaviour());
	}
	
	
}
