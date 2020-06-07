package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

public class Shotgun extends WeaponItem{
	private int ranged_damage=45;
	
	public Shotgun() {
		super("shotgun", 's', 18, "bash");
	}
	
	@Override
	public void tick(Location currentLocation, Actor actor) {
		super.allowableActions.clear();
		super.allowableActions.add(new BlastMenuAction(this));
		
	}
	
	@Override
	public void tick(Location currentLocation) {
		super.allowableActions.clear();
		
	}
	
	@Override
	public int getRangedDamage() {
		// TODO Auto-generated method stub
		return ranged_damage;
	}
	
	@Override
	public String craft(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String craftDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isFood() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isWeapon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeMap(GameMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTarget(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_aim_turns(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_aim_turns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void use_ammo(Actor actor) {
		int count=actor.get_shotgun_ammo()-1;
		actor.set_shotgun_ammo(count);
	}

	

}
