package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * A tree that starts as a sapling and grows into a large tree.
 * 
 * @author ram
 *
 */
public class Tree extends Ground {
	private int age = 0;

	public Tree() {
		super('+');
	}

	@Override
	public void tick(Location location) {
		super.tick(location);

		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 20)
			displayChar = 'T';
	}


	@Override
	public Boolean canPlant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isFertilised() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isRipe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fertilise() {
		// TODO Auto-generated method stub
		
	}
}
