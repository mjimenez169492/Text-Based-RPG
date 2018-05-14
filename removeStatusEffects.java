/*
	public class removeStatusEffects contains String arrays that contain status effects
	which can be removed through the use of items or skills. File was created in order 
	to make public class statusEffects more readable and to help programmers understand
	the responsibilities of public class statusEffects and removeStatusEffects instead 
	of throwing everything about status effects into one class 
*/

public class removeStatusEffects
{
	/*****************************************************************************************/
	
	// Note: Status should be removed through String comparison NOT object comparison 
	// 		 since objects may not be identical. Status object should be held within 
	// 		 an item object instead of being a String so that status effect methods 
	// 		 can be called as necessary 
	
	// status that affects Current Hp which item can remove 
	private static String[] hpStatus = {"KO", "Ablaze", "Bleed", "Poison", "Toxic"};
	
	// status that affects character behavior in battle which item can remove 
	private static String[] behavior = {"Confused", "Enamored", "Infatuated", "Berserk"};
	
	// status that affects turn behavior negatively which item can remove 
	private static String[] turnBehavior = {"Stunned", "Sleep", "Shocked", "Slowed", "Stopped"};	
	
	// status that affects one or many resistances negatively which item can remove 
	// status effect 'Nullify Negative Status Effects' removes all negative status  
	// effects that hinders the player in some way 
	private static String[] specialStatus = {"Dry", "Wet", "Cold", "Conductive", "Sickness",
		"Hypersensitive", "Coated", "Lightweight"}; 	
	
	// status that affects an attributes negatively which item can remove 
	private static String[] attributeDown = {"Attack Down", "Defense Down", "Nano Down", 
		"Stamina Down", "Dexterity Down", "Critical Down", "Accuracy Down", "Nano Attack Down",
		"Nano Defense Down"}; 
	
	// status that affects a resistance negatively which item can remove 
	private static String[] resistanceDown = {"Fire Resistance Down", "Water Resistance Down", 
		"Ice Resistance Down", "Electricity Resistance Down", "Poison Resistance Down", 
		"Sonic Resistance Down", "Plasma Resistance Down", "Wind Resistance Down", "None"};
	
	// hold status effects of previous arrays 
	private static String[] holdNegativeStatusEffects [] = {hpStatus, behavior, 
		turnBehavior, specialStatus, attributeDown, resistanceDown};
	
	/*****************************************************************************************/
	
	public static String[][] getNegativeStatusEffects()
	{
		return holdNegativeStatusEffects;
	}
	
}