package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

public class SniperRifle extends WeaponItem {
	private int aim_turns=0;
	private Actor target;
	private GameMap map;
	private int ranged_damage=40;
	
	public SniperRifle(GameMap map) {
		super("sniper rifle", 'S', 15, "clubs");
		this.map=map;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick(Location currentLocation, Actor actor) {
		//change map if actor went to another map
		if(currentLocation.map()!=map) {
			map=currentLocation.map();
		}
		
		try {
			if(aim_turns>=1&&actor.damaged()) {
				reset();
				System.out.println(actor+" concentration was broken due to receiving damage!");
			}
		}
		catch(NullPointerException e){
			return;
		}
		
		try {
			if(aim_turns>=1&&actor.get_lastAction().isSniperAction());
		}
		catch(NullPointerException e){
			reset();
			System.out.println(actor+" concentration was broken due to taking an action other than aiming and firing.");
		}
		
		super.allowableActions.clear();
		super.allowableActions.add(new TargetMenuAction(this));
	}
	
	@Override
	public void tick(Location currentLocation) {
		//change map if actor went to another map
		if(currentLocation.map()!=map) {
			map=currentLocation.map();
		}
		super.allowableActions.clear();
		//broken concentration if sniper is dropped. 
		reset();
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
		return null;
	}

	@Override
	public Boolean isWeapon() {
		return true;
	}

	@Override
	public void changeMap(GameMap map) {
		this.map=map;
		
	}
	
	@Override
	public void setTarget(Actor actor) {
		target=actor;
	}
	
	@Override
	public Actor getTarget() {
		return target;
	}
	
	@Override
	public void set_aim_turns(int count) {
		aim_turns=count;
	}
	
	@Override
	public int get_aim_turns() {
		return aim_turns;
	}
	
	@Override
	public void reset() {
		aim_turns=0;
		target=null;
	}

	@Override
	public int getRangedDamage() {
		return ranged_damage;
	}

	@Override
	public void use_ammo(Actor actor) {
		int count=actor.get_sniper_ammo()-1;
		actor.set_sniper_ammo(count);
	}
}
