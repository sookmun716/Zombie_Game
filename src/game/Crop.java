package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class Crop extends Ground{
	private int ripeTurns=0;
	
	public Crop() {
		super('^');
	}
	
	@Override
	public void tick(Location location) {
		ripeTurns+=1;
		//Change display character if crop is ripe
		if(ripeTurns==20){
			this.displayChar='!';
			System.out.println("Crop at "+location.x()+','+location.y()+" is ripe.");
		}
	}

	@Override
	public void setDisplayChar(char display) {
		if(display!='|' || display!='!') {
			return;
		}
		this.displayChar=display;
	}
	
}
