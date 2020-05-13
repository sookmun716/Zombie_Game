package game;

import edu.monash.fit2099.engine.*;

public abstract class WeaponItems extends Item implements Weapon{
	
	private int damage;
	private String verb;
	
	public WeaponItems(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, true);
		this.damage = damage;
		this.verb = verb;
	}
	
	public int damage() {
		return damage;
	}

	public String verb() {
		return verb;
	}
}
