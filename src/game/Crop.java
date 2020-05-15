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
		if(ripeTurns==20)this.displayChar='!';
	}
	
	public int getripeTurns() {
		return ripeTurns;
	}
	
	public void fertilise() {
		ripeTurns+=10;
		isFertilised=true;
		this.displayChar='|';
		if(ripeTurns==20)this.displayChar='!';
	}
	
	public Boolean isFertilised(){
		return isFertilised;
	}
	
	
}
