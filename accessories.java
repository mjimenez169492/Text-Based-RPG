/*
	public class accessories extends public class genericObject and defines methods related 
	to creating accessories that can be used to increase the attributes of the wearer
	as well as defend the wearer from a variable number of status effects 
	
	Note on imported libraries: 
	
		Import SecureRandom to get numbers that are more random than from Random class 
		
		Import LinkedHashSet to create a hash set which maintains the insertion order 
		of something (like arrays). Linked Hash Sets do not add objects if they are 
		not "unique" (if value to be added to hash set is already in the set then the 
		duplicate will not be added to the set). The elements in Linked Hash Sets are 
		ordered by insertion order. Note that entries are maintained in a linked list 
		meaning objects can be added with .add()
		
		Import ArrayList and List to have a list which keeps track of status effects
		that belong to a particular accessory. Since the number of status effects an
		accessory can resist is not known, it would be best to use an array list in 
		order hold Strings passed through the use of a var args (variable arguments)
		at the end of the constructor (which is the only place it would be valid)
*/

import java.security.SecureRandom;
import java.util.LinkedHashSet;  
import java.util.ArrayList;

public class accessories extends genericObject
{	
	private double expMultiplier;			// accessory effect on character's experience  
	private int maxHp;						// accessory effect on character's max HP 
	private int currentHp;					// accessory effect on character's current hp 
	private int attack;						// accessory effect on character's attack stat 
	private int defense;					// accessory effect on character's defense stat 
	private int nano;						// accessory effect on character's nano stat 
	private int stamina;					// accessory effect on character's stamina stat 
	private int dexterity;					// accessory effect on character's dexterity stat 
	private int critical;					// accessory effect on character's critical stat 
	private int accuracy;					// accessory effect on character's accuracy stat 
	private int nanoAttack;					// accessory effect on character's nano attack stat 
	private int nanoDefense;				// accessory effect on character's nano defense stat 	

	// hold valid types for an accessory slot 
	private String[] validSlotTypes = {"Max Hp", "Current Hp", "Attack", 
		"Defense", "Nano", "Stamina", "Dexterity", "Critical", "Accuracy", 
		"Nano Attack", "Nano Defense", "Any Accessory Core"};
	
	// create an array list that will hold various Strings supplied to var args
	private ArrayList<String> statusAccessoryResists = new ArrayList<String>();
	
	// slot types can be altered for a large price if desired 
	// cores can be transferred across armor 
	// cores run out over time with use and they are replaceable 
	
	private String slotOneType;				// store what type of slot that slot one is 
	private cores slotOneCore;				// stores core in the specified accessory slot 
	
	private int coreSum;					// stores sum of core points in sumOfCores()
	private int totalMaxHp;					// accessory Max Hp with Max Hp core applied 
	private int totalCurrentHp;				// accessory Current Hp with Current Hp core applied 
	private int totalAttack;				// accessory Attack with Attack core applied 
	private int totalDefense;				// accessory Defense with Defense core applied 
	private int totalNano;					// accessory Nano with Nano core applied 
	private int totalStamina;				// accessory Stamina with Stamina core applied 
	private int totalDexterity;				// accessory Dexterity with Dexterity core applied 
	private int totalCritical;				// accessory Critical with Critical core applied 
	private int totalAccuracy;				// accessory Accuracy with Accuracy core applied 
	private int totalNanoAttack;			// accessory Nano Attack with Nano Attack cores applied
	private int totalNanoDefense;			// accessory Nano Defense with Nano Defense cores applied
	
	// create accessories with nothing supplied to super constructor due to too many parameters
	// objects created through this constructor can be customized further by calling set 
	// methods within this class
	public accessories()
	{
		// empty constructor 
	}
	
	// create accessories that only have a var args which can allows the wearer to resist
	// a variables number of status effects nothing supplied to super constructor due to too many parameters
	public accessories(String...array)
	{
		varArgsToLinkedHashSet(array);
	}
	
	
	
	
	
	
	// START: ACCESSORY EFFECTS ON ATTRIBUTES
	/*******************************************************************************/

	// set experience value accessory affects character experience by
	public void setExpMultiplier(double expMultiplier)
	{
		if(expMultiplier < 1)
		{
			expMultiplier = 1;
		}
		else if(expMultiplier > 3)
		{
			expMultiplier = 3;
		}
		
		this.expMultiplier = expMultiplier;
	}
	
	// get experience value accessory affects character experience by
	public double getExpMultiplier()
	{
		return expMultiplier; 
	} 
	
	// returns an int that is within the range specified in validAttribute
	public int validAttribute(int attribute)
	{
		if(attribute < -500)
		{
			attribute = -500;
		}
		else if(attribute > 500)
		{
			attribute = 500;
		}
		
		return attribute;
	}
	
	// set max hp value accessory takes/adds to character 
	public void setMaxHp(int maxHp) 
	{
		this.maxHp = validAttribute(maxHp); 
	} 
	
	// get max hp value accessory takes/adds to character 
	public int getMaxHp()
	{
		return maxHp; 
	} 
	
	// set current HP value accessory takes/adds to character 
	public void setCurrentHp(int currentHp)
	{	
		this.currentHp = validAttribute(currentHp);
	}
	
	// get current HP value accessory takes/adds to character 
	public int getCurrentHp()
	{
		return currentHp; 
	} 
	
	// set attack value accessory takes/adds to character 
	public void setAttack(int attack)
	{
		this.attack = validAttribute(attack);
	}
	
	// get attack value accessory takes/adds to character 
	public int getAttack()
	{
		return attack; 
	} 
	
	// set defense value accessory takes/adds to character 
	public void setDefense(int defense)
	{
		this.defense = validAttribute(defense);
	}
	
	// get defense value accessory takes/adds to character 
	public int getDefense()
	{
		return defense; 
	} 
	
	// set nano value accessory takes/adds to character 
	public void setNano(int nano)
	{
		this.nano = validAttribute(nano);
	}
	
	// get nano value accessory takes/adds to character 
	public int getNano()
	{
		return nano; 
	} 
	
	// set stamina value accessory takes/adds to character 
	public void setStamina(int stamina)
	{
		this.stamina = validAttribute(stamina);
	}
	
	// get stamina value accessory takes/adds to character 
	public int getStamina()
	{
		return stamina; 
	} 
	
	// set dexterity value accessory takes/adds to character 
	public void setDexterity(int dexterity)
	{
		this.dexterity = validAttribute(dexterity);
	}
	
	// get dexterity value accessory takes/adds to character 
	public int getDexterity()
	{
		return dexterity; 
	} 
	
	// set critical value accessory takes/adds to character 
	public void setCritical(int critical)
	{
		this.critical = validAttribute(critical);
	}
	
	// get critical value accessory takes/adds to character 
	public int getCritical()
	{
		return critical; 
	} 
	
	// set accuracy value accessory takes/adds to character 
	public void setAccuracy(int accuracy)
	{
		this.accuracy = validAttribute(accuracy);
	}
	
	// get accuracy value accessory takes/adds to character 
	public int getAccuracy()
	{
		return accuracy; 
	} 
	
	// set nano attack value accessory takes/adds to character 
	public void setNanoAttack(int nanoAttack)
	{
		this.nanoAttack = validAttribute(nanoAttack);
	}
	
	// get nano attack value accessory takes/adds to character 
	public int getNanoAttack()
	{
		return nanoAttack; 
	} 
	
	// set nano defense value accessory takes/adds to character 
	public void setNanoDefense(int nanoDefense)
	{
		this.nanoDefense = validAttribute(nanoDefense);
	}
	
	// get nano defense value accessory takes/adds to character 
	public int getNanoDefense()
	{
		return nanoDefense; 
	} 
	
	// END: ACCESSORY EFFECTS ON ATTRIBUTES
	/*******************************************************************************/
	
	
	
	/*
		8 options
			1	40% Null (no slot)
			2	5	Max Hp
			3	5	Current Hp
			4	5	Attack
			5	5	Defense
			6	5	Nano
			7	5	Stamina
			8	5	Dexterity
			9	5	Critical
			10	5	Accuracy
			11	5	Nano Attack
			12	5	Nano Defense
			13	5	Any Core Type 
	*/
	
	
	
	// START: ACCESSORY SLOT TYPES AND SLOT CORES
	/*******************************************************************************/

	// returns a String that was selected randomly
	public String determineSlotType()
	{
		// create random object to call random methods 
		SecureRandom secureRand = new SecureRandom();
		
		// int variable will hold a random number form 1 to 100
		int holdInt = secureRand.nextInt(100 + 1);
		
		// initialize holdSlotType meant to be assigned a String for slot type 
		String holdSlotType = null;
		
		// portion of if else statement executes depending on value of variable 
		if(holdInt <= 40)
		{
			holdSlotType = "None";
		}
		else if(holdInt <= 45)
		{
			holdSlotType = "Max Hp";
		}
		else if(holdInt <= 50)
		{
			holdSlotType = "Current Hp";
		}
		else if(holdInt <= 55)
		{
			holdSlotType = "Attack";
		}
		else if(holdInt <= 60)
		{
			holdSlotType = "Defense";
		}
		else if(holdInt <= 65)
		{
			holdSlotType = "Nano";
		}
		else if(holdInt <= 70)
		{
			holdSlotType = "Stamina";
		}
		else if(holdInt <= 75)
		{
			holdSlotType = "Dexterity";
		}
		else if(holdInt <= 80)
		{
			holdSlotType = "Critical";
		}
		else if(holdInt <= 85)
		{
			holdSlotType = "Accuracy";
		}
		else if(holdInt <= 90)
		{
			holdSlotType = "Nano Attack";
		}
		else if(holdInt <= 95)
		{
			holdSlotType = "Nano Defense";
		}
		else if(holdInt <= 100)
		{
			holdSlotType = "Any Accessory Core";
		}
		// return slot type 
		return holdSlotType;
	}
	
	// randomize slot type for accessories
	public void randomizeSlotTypes(Boolean randomSlots)
	{
		// if boolean variable is true, set slot types for all five slots randomly 
		if(randomSlots == true)
		{
			setSlotOneType(determineSlotType());
		}
	}
	
	// determine whether the supplied string is valid 
	public boolean isSlotTypeValid(String slotType)
	{
		// variable will be set to true is argument is valid 
		boolean validArgument = false;
		
		if(slotType !=null)
		{
			// enhanced for loop compares supplied string against array elements
			for(String element : validSlotTypes)
			{
				// if supplied string matches element in the array, assign boolean with true 
				if(slotType.equals(element))
				{
					validArgument = true;
				}
			}
			return validArgument;
		}
		else
		{
			// return value held in boolean
			return validArgument;
		}
	}
	
	// determine whether the supplied accessory core is valid 
	public boolean isCoreTypeValid(cores core)
	{
		// variable will be set to true is argument is valid 
		boolean validArgument = false;
		
		if(core != null)
		{
			// for loop compares supplied core core type against array elements
			for(String element : validSlotTypes)
			{
				// if supplied string matches element in the array, assign boolean with true 
				if(core.getCoreType().equals(element))
				{
					validArgument = true;
				}
			}
			return validArgument;
		}
		else
		{
			// return value held in boolean
			return validArgument;
		}
	}
	
	// set the type for accessory slot one 
	public void setSlotOneType(String slotOneType)
	{
		if(isSlotTypeValid(slotOneType) == true)
		{
			this.slotOneType = slotOneType;
		}
	}
	
	// get accessory slot type 
	public String getSlotOneType()
	{
		return slotOneType;
	}
	
	// set core into accessory slot if it is the same type as the slot 
	public void setSlotOneCore(cores slotOneCore)
	{
		if(getSlotOneType() != null)
		{
			// must check for null 
			if(isCoreTypeValid(slotOneCore) == true)
			{
				// check if core matches slot type 
				if(getSlotOneType().equals("Any Accessory Core"))
				{
					this.slotOneCore = slotOneCore;
				}
				else if(slotOneCore.getCoreType().equals(getSlotOneType()))
				{
					this.slotOneCore = slotOneCore;
				}
			}
		}
	}
	
	// get the core set in slot one 
	public cores getSlotOneCore()
	{
		return slotOneCore;
	}
	
	// consider adding more cores to accessories...
	// return an array containing all possible cores an accessory can have 
	public cores[] getAccessoryCores()
	{
		cores[] accessoryCores = {getSlotOneCore()};
			return accessoryCores;
	}
	
	// END: ACCESSORY SLOT TYPES AND SLOT CORES
	/*******************************************************************************/
	
	
	
	
	
	
	// START: STATUS ACCESSORY NEGATES OR RESISTS
	/*******************************************************************************/

	// create an array list that can hold up to six elements from an array 
	public void varArgsToArrayList(String[] array)
	{
		// pass array to varArgsToLinkedHashSet() to cause it to return a linked hash
		// set which will have its contents passed to the array list instance variable 
		setStatusesAccessoryResists(varArgsToLinkedHashSet(array));
	}
	
	// check whether the status supplied as an argument is valid 
	public boolean isResistStatusValid(String resistStatus)
	{
		boolean validArgument = false;
		
		if(resistStatus != null)
		{
			for(String[] array : removeStatusEffects.getNegativeStatusEffects())
			{
				for(String element : array)
				{
					if(resistStatus.equals(element))
					{
						validArgument = true;
					}
				}
			}
			return validArgument;
		}
		else
		{
			return validArgument;
		}
	}
	
	// method stores array elements from var args in constructor to a linked hash set 
	// and returns it based on number of elements that exist in the array 
	public LinkedHashSet<String> varArgsToLinkedHashSet(String[] array)
	{
		// create linked hash set object of type String that will only store unique values  
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		
		// iterate through array contents differently depending on length of array 
		if(array.length < 6)
		{
			// enhanced for loop adds elements to linkedHashSet if it is not null and 
			// if it is valid 
			for(String element : array)
			{
				if(element != null)
				{
					if(isResistStatusValid(element) == true)
					{
						linkedHashSet.add(element);
					}
				}
			}
		}
		else
		{
			// enhanced for loop adds elements to linkedHashSet if it is not null and 
			// if it is valid and break loop in case linkedHashSet has six elements 
			for(String element : array)
			{
				if(element != null)
				{
					if(linkedHashSet.size() == 6)
					{
						break;
					}
					else if(isResistStatusValid(element) == true)
					{
						linkedHashSet.add(element);
					}
				}
			}
		}
		
		// return linked hash set 
		return linkedHashSet;
	}
	
	// set contents of array list instance variable by passing contents of linked hash set 
	public void setStatusesAccessoryResists(LinkedHashSet<String> set)
	{
		// enhanced for loop iterates through linked hash set and places elements in 
		// it into the instance variable array list 
		for(String element : set)
		{
			statusAccessoryResists.add(element);
		}
	}
	
	// get the contents of the array list (need to iterate through it like an array)
	public ArrayList<String> getStatusesAccessoryResists()
	{
		return statusAccessoryResists;
	}
	
	// END: STATUS ACCESSORY NEGATES OR RESISTS
	/*******************************************************************************/

	
	
	
	
	
	// START: TOTAL ACCESSORY ATTRIBUTES WITH CORES SUPPLIED
	/*******************************************************************************/

	// NEED remove methods for: weapons, armors, accessories... 
	// assign null for now since need access to inventory for proper removal 
	
	// add points of cores if cores have same type as that specified by argument type 
	public int addSumOfCores(String type)
	{
		// enhanced for loop iterates through all cores object can have 
		for(cores element : getAccessoryCores())
		{
			// if element is not null, compare core types against argument type and if 
			// they match then add the value (as an integer) to coreSum
			if(element != null)
			{
				if(element.getCoreType().equals(type))
				{
					// casting is okay here since only int values are needed
					coreSum += (int) element.getCurrentCorePoints();
				}
			}
		}
		
		// return value held in value
		return coreSum;
	}
	
	/*
		Note on "getTotal" methods below: 
			methods get total value for a object (like attack, nano, ect.) by adding 
			object's power and core points together only if the cores are the same 
			type as the String supplied as argument (if "Attack" is supplied then 
			add the current core points of the cores with core type "Attack") 
	*/
	
							// attribute "getTotal" methods 
	
	public int getTotalMaxHp()
	{
		return totalMaxHp = getMaxHp() + addSumOfCores("Max Hp");
	}
	
	public int getTotalCurrentHp()
	{
		return totalCurrentHp = getCurrentHp() + addSumOfCores("Current Hp");
	}
	
	public int getTotalAttack()
	{
		return totalAttack = getAttack() + addSumOfCores("Attack");
	}
	
	public int getTotalDefense()
	{
		return totalDefense = getDefense() + addSumOfCores("Defense");
	}
	
	public int getTotalNano()
	{
		return totalNano = getNano() + addSumOfCores("Nano");
	}
	
	public int getTotalStamina()
	{
		return totalStamina = getStamina() + addSumOfCores("Stamina");
	}
	
	public int getTotalDexterity()
	{
		return totalDexterity = getDexterity() + addSumOfCores("Dexterity");
	}
	
	public int getTotalCritical()
	{
		return totalCritical = getCritical() + addSumOfCores("Critical");
	}
	
	public int getTotalAccuracy()
	{
		return totalAccuracy = getAccuracy() + addSumOfCores("Accuracy");
	}
	
	public int getTotalNanoAttack()
	{
		return totalNanoAttack = getNanoAttack() + addSumOfCores("Nano Attack");
	}
	
	public int getTotalNanoDefense()
	{
		return totalNanoDefense = getNanoDefense() + addSumOfCores("Nano Defense");
	}
	
	// END: TOTAL ACCESSORY ATTRIBUTES WITH CORES SUPPLIED
	/*******************************************************************************/
}
