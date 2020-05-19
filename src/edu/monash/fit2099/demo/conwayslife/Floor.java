package edu.monash.fit2099.demo.conwayslife;

import edu.monash.fit2099.engine.Ground;

public class Floor extends Ground {

	public Floor() {
		super('.');
		addCapability(Status.DEAD);
	}


	@Override
	public Boolean canPlant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isFertilised() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isRipe() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void fertilise() {
		// TODO Auto-generated method stub
		
	}
}
