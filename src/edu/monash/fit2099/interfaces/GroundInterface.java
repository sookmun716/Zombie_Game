package edu.monash.fit2099.interfaces;

/**
 * This interface provides the ability to add methods to Ground, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface GroundInterface {
	/**
	 * Method that is used to determine whether a Ground Object can be used to plant crops
	 * @return true if the ground can be used to plant crops and false otherwise
	 */
	public Boolean canPlant();
	/**
	 * Method that is used to determine whether a Crop can be fertilised
	 * @return true if the crop can be fertilised and false otherwise, if the Ground Object is not a Crop it will return null.
	 */
	public Boolean isFertilised();
	/**
	 * Method used to fertilise a crop, the ripeTurns will be incremented by 10.
	 */
	public void fertilise();
	/**
	 *Method that is used to determine whether a Crop is ripe
	 * @return true if the crop is ripe and false otherwise, if the Ground Object is not a Crop it will return null.
	 */
	public Boolean isRipe();
}
