package game;

import edu.monash.fit2099.engine.Ground;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

	public Dirt() {
		super('.');
	}

	@Override
	public Boolean canPlant() {
		// TODO Auto-generated method stub
		return true;
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
