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
	}
	
	public int getripeTurns() {
		return ripeTurns;
	}
	
	//did not specify parameter because this method is only called when farmer is 
	//fertilizing the crop
	public void setRipeTurns() {
		ripeTurns+=10;
	}
	
	public Boolean isFertilised(){
		return isFertilised;
	}
	
	public void setFertilised() {
		isFertilised=true;
	}
	
}
