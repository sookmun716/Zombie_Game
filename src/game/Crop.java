package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class Crop extends Ground{
	private int ripeTurns=0;
	private Boolean isFertilised=false;
	
	public Crop() {
		super('^');
	}
	
	@Override
	public void tick(Location location) {
		ripeTurns+=1;
		//Change display character if crop is ripe
		if(ripeTurns==20)super.displayChar='!';
	}
	
	public int getripeTurns() {
		return ripeTurns;
	}
	
	public void fertilise() {
		ripeTurns+=10;
		isFertilised=true;
	}
	
	public Boolean isFertilised(){
		return isFertilised;
	}
	
	
}
