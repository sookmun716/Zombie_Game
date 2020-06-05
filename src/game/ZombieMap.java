package game;

import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.GroundFactory;

public class ZombieMap extends GameMap {
	private Boolean inMap= false;
	private Random random=new Random(); 
	private MamboMarie mambo_marie=new MamboMarie();
	private Boolean mambo_dead=false;
	
	public ZombieMap(GroundFactory groundFactory, List<String> lines) {
		super(groundFactory, lines);
	}
	
	@Override
	public void tick() {
		super.tick();
		if(random.nextInt(101)>=95 && !inMap && !mambo_dead) {
			this.addActor(mambo_marie, this.at(this.heights.min(), this.widths.min()));
			inMap=true;
			System.out.println(mambo_marie+" spawns on the map!");
		}
		
		if(!mambo_marie.isConscious()) {
			mambo_dead=true;
		}
		
		if(mambo_marie.isConscious()&&mambo_marie.get_turn_count()==30) {
			mambo_marie.set_turn_count();
			this.removeActor(mambo_marie);
			inMap=false;
			System.out.println("Mambo Marie vanished from the map!");
			
		}
	}



}
