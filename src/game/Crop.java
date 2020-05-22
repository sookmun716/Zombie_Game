package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * A subclass of Ground that represents an crop.
 * 
 * @author Tan Song Shun
 *
 */
public class Crop extends Ground{
	private int ripeTurns=0;
	private Boolean fertilised=false;
	private Boolean isRipe=false;
	/**
	 * This is the constructor for the Crop class, the super constructor is
	 * called to instantiate the object.
	 * 
	 */
	public Crop() {
		super('^');
	}
	
	/**
	 * This method overrides the tick method from Corpse class and is called in every
	 * turn, in this case it increments the ripeTurns each time the method is called, 
	 * and the display character will be changed if ripeTurns more than or equals 20 to represent that a crop
	 * is ripe
	 * 
	 * @param location Location of the Crop.
	 * 
	 **/
	@Override
	public void tick(Location location) {
		ripeTurns+=1;
		//Change display character if crop is ripe
		if(ripeTurns>=20 && !isRipe){
			this.displayChar='!';
			//set fertilised to true because ripe crops should not be fertilised
			fertilised=true;
			isRipe=true;
			System.out.println("Crop at "+location.x()+','+location.y()+" is ripe.");
		}
	}
	
	@Override
	public Boolean canPlant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isFertilised() {
		// TODO Auto-generated method stub
		return fertilised;
	}
	
	@Override
	public Boolean isRipe() {
		return isRipe;
	}

	@Override
	public void fertilise() {
		ripeTurns+=10;
		fertilised=true;
		this.displayChar='|';
	}
	
}
