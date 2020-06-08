package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class MamboMarie extends ZombieActor{
	private Behaviour[] behaviours={
		new ChantBehaviour(),
		new WanderBehaviour()
		};
	private int turn_count=0;
	public static final int CHANT_ROUND=10;
	public MamboMarie() {
		super("Mambo Marie", 'M', 200, ZombieCapability.UNDEAD);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getHp() {
		// TODO Auto-generated method stub
		return super.hitPoints;
	}

	@Override
	public int getMaxHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dropArm(int Arm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropLeg(int Leg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getArm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set_sniper_ammo(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_sniper_ammo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set_shotgun_ammo(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_shotgun_ammo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turn_count+=1;
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();	
	}

	@Override
	public int get_turn_count() {
		// TODO Auto-generated method stub
		return turn_count;
	}
	
	public void set_turn_count() {
		turn_count=0;
	}

	@Override
	public Action get_lastAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_previous_health() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean damaged() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String isDead(GameMap map) {
		 if (!this.isConscious()) {
				Corpse corpse = new Corpse(this);
				map.locationOf(this).addItem(corpse);
				
				Actions dropActions = new Actions();
				for (Item item : this.getInventory())
					dropActions.add(item.getDropAction());
				for (Action drop : dropActions)		
					drop.execute(this, map);
				map.removeActor(this);	
				
				return System.lineSeparator() + this + " is killed.";
		}
		 return "";
			
	}

	@Override
	public int chant_round() {
		// TODO Auto-generated method stub
		return CHANT_ROUND;
	}

}
