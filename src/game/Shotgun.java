package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

public class Shotgun extends WeaponItem{
	private int ranged_damage=45;
	public static final int RANGE=3;
	public Shotgun() {
		super("shotgun", 's', 18, "smacks");
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
	public int ranged_damage() {
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
	public void setTarget(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor target() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_aim_turns(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int aim_turns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void use_ammo(Actor actor) {
		if(actor.get_shotgun_ammo()>0) {
			int count=actor.get_shotgun_ammo()-1;
			actor.set_shotgun_ammo(count);
		}
	}

	@Override
	public int range() {
		return RANGE;
	}

	@Override
	public Boolean isGun() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String secondary_verb() {
		// TODO Auto-generated method stub
		return "blasts";
	}

	

}
