/*
	public class weapons extends public class genericObject and defines methods related 
	to creating weapons that can be used to primarily increase the attack of the wielder
	
	Note: java library SecureRandom ensures that numbers selected are more random 
 		  than java.util.Random() at the cost of taking more time to select random 
 		  numbers (ideal for games reliant on RNG) 
*/

import java.security.SecureRandom;

public class weapons extends genericObject
{
	private int currentHp;					// weapon effect on character's current HP per attack
	private int attack;						// weapon effect on character's attack stat 
	private int nano;						// weapon effect on character's nano stat 
	private int dexterity;					// weapon effect on character's dexterity stat 
	private int critical;					// weapon effect on character's critical stat 
	private int accuracy;					// weapon effect on character's accuracy stat 
	private int nanoAttack;					// weapon effect on character's nano attack stat 
	private statusEffects inflictStatus;	// status effect weapon inflicts on the enemy 
	
	// hold valid types for a weapon slot 
	private String[] validSlotTypes = {"Current Hp", "Attack", "Nano", "Stamina", 
		"Dexterity", "Critical", "Accuracy", "Nano Attack", "Any Weapon Core"};
	
	// slot types can be altered for a large price if desired 
	// cores can be transferred across weapons 
	// cores run out over time with use and they are replaceable 
	
	//private boolean randomSlots;			// determines whether all slot types should be randomized 
	private String slotOneType;				// store what type of slot that slot one is 
	private cores slotOneCore;				// stores core in the specified weapon slot 
	private String slotTwoType;				// store what type of slot that slot two is 
	private cores slotTwoCore;				// stores core in the specified weapon slot 
	private String slotThreeType;			// store what type of slot that slot three is 
	private cores slotThreeCore;			// stores core in the specified weapon slot 
	private String slotFourType;			// store what type of slot that slot four is 
	private cores slotFourCore;				// stores core in the specified weapon slot 
	private String slotFiveType;			// store what type of slot that slot five is 
	private cores slotFiveCore;				// stores core in the specified weapon slot 
	
	// weapon power with cores supplied 
	private int coreSum;					// stores sum of core points in sumOfCores()
	private int totalAttack;				// weapon attack with Attack cores supplied
	private int totalNano;					// weapon nano with Nano cores supplied
	private int totalDexterity;				// weapon dexterity with Dexterity cores supplied
	private int totalCritical;				// weapon critical with Critical cores supplied
	private int totalAccuracy;				// weapon accuracy with Accuracy cores supplied
	private int totalNanoAttack;			// weapon nano attack with Nano Attack cores supplied
	
	// create weapons with nothing supplied to super constructor due to too many parameters
	// objects created through this constructor can be customized further by calling set 
	// methods within this class
	public weapons()
	{
		// empty constructor 
	}
	
	
	
	
	
	
	// START: WEAPON ATTRIBUTES
	/*******************************************************************************/
	
	// returns an int that is within the range specified in validAttribute
	public int validAttribute(int value)
	{
		if(value < -500)
		{
			value = -500;
		}
		else if(value > 500)
		{
			value = 500;
		}
		
		return value;
	}
	
	// set Hp value weapon takes/adds to character 
	public void setCurrentHp(int currentHp)
	{
		this.currentHp = validAttribute(currentHp);
	}
	
	// get Hp value weapon takes/adds to character 
	public int getcurrentHp()
	{
		return currentHp;
	}
	
	// set attack value weapon takes/adds to character 
	public void setAttack(int attack)
	{		
		this.attack = validAttribute(attack);
	}
	
	// get attack value weapon takes/adds to character 
	public int getAttack()
	{
		return attack;
	}
	
	// set nano value weapon takes/adds to character 
	public void setNano(int nano)
	{
		this.nano = validAttribute(nano);
	}
	
	// get nano value weapon takes/adds to character 
	public int getNano()
	{
		return nano;
	}
	
	// set dexterity value weapon takes/adds to character 
	public void setDexterity(int dexterity)
	{
		this.dexterity = validAttribute(dexterity);
	}
	
	// get dexterity value weapon takes/adds to character 
	public int getDexterity()
	{
		return dexterity;
	}
	
	// set critical value weapon takes/adds to character 
	public void setCritical(int critical)
	{
		this.critical = validAttribute(critical);
	}
	
	// get critical value weapon takes/adds to character 
	public int getCritical()
	{
		return critical;
	}
	
	// set accuracy value weapon takes/adds to character 
	public void setAccuracy(int accuracy)
	{
		this.accuracy = validAttribute(accuracy);
	}
	
	// get hit chance value weapon takes/adds to character 
	public int getAccuracy()
	{
		return accuracy;
	}
	
	// set magic attack value weapon takes/adds to character 
	public void setNanoAttack(int nanoAttack)
	{
		this.nanoAttack = validAttribute(nanoAttack);
	}
	
	// get magic attack value weapon takes/adds to character 
	public int getNanoAttack()
	{
		return nanoAttack;
	}
	
	// END: WEAPON ATTRIBUTES
	/*******************************************************************************/

	
	
	
	
	
	// START: STATUS WEAPON INFLICTS
	/*******************************************************************************/

	// set status that weapon inflicts on enemy 
	public void setInflictStatus(statusEffects inflictStatus)
	{
		if(inflictStatus != null)
		{
			this.inflictStatus = inflictStatus;
		}
	}
	
	// get status that weapon inflicts on enemy  
	public statusEffects getInflictStatus()
	{
		return inflictStatus;
	}
	
	// END: STATUS WEAPON INFLICTS
	/*******************************************************************************/
	
	
	
	/*
		10 options
			1	50% Null (no slot)
			2	5	Current Hp	51-55
			3	8	Attack 		56-63
			4	6	Nano 		64-69
			5	5	Stamina 	70-74
			6	7	Dexterity 	75-81
			7	4	Critical 	82-85
			8	5	Accuracy 	86-90
			9	6	Nano Attack 91-96
			10	4	Any 		97-100
	*/
	
	
	
	// START: WEAPON SLOT TYPES AND SLOT CORES
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
		if(holdInt <= 50)
		{
			holdSlotType = "None";
		}
		else if(holdInt <= 55)
		{
			holdSlotType = "Current Hp";
		}
		else if(holdInt <= 63)
		{
			holdSlotType = "Attack";
		}
		else if(holdInt <= 69)
		{
			holdSlotType = "Nano";
		}
		else if(holdInt <= 74)
		{
			holdSlotType = "Stamina";
		}
		else if(holdInt <= 81)
		{
			holdSlotType = "Dexterity";
		}
		else if(holdInt <= 85)
		{
			holdSlotType = "Critical";
		}
		else if(holdInt <= 90)
		{
			holdSlotType = "Accuracy";
		}
		else if(holdInt <= 96)
		{
			holdSlotType = "Nano Attack";
		}
		else if(holdInt <= 100)
		{
			holdSlotType = "Any Weapon Core";
		}
		// return slot type 
		return holdSlotType;
	}
	
	// randomize slot types for a weapon if true is supplied 
	public void randomizeSlotTypes(Boolean randomSlots)
	{
		// if boolean variable is true, set slot types for all five slots randomly 
		if(randomSlots == true)
		{
			setSlotOneType(determineSlotType());
			setSlotTwoType(determineSlotType());
			setSlotThreeType(determineSlotType());
			setSlotFourType(determineSlotType());
			setSlotFiveType(determineSlotType());
		}
	}
	
	// determine whether the supplied string is valid 
	public boolean isSlotTypeValid(String slotType)
	{
		// variable will be set to true is argument is valid 
		boolean validArgument = false;
		
		// enter if statement if String supplied is not null 
		if(slotType != null)
		{
			// enhanced for loop compares string against elements in array 
			for(String element : validSlotTypes)
			{
				// if supplied string matches element in the array, assign boolean with true 
				if(slotType.equals(element))
				{
					validArgument = true;
				}
			}
			// return value held in boolean
			return validArgument;
		}
		else
		{
			return validArgument;
		}
	}
	
	// determine whether the supplied weapon core is valid 
	public boolean isCoreTypeValid(cores core)
	{
		// variable will be set to true is argument is valid 
		boolean validArgument = false;
		
		// enter if statement if core supplied is not null 
		if(core != null)
		{
			// enhanced for loop compares core type against elements in array 
			for(String element : validSlotTypes)
			{
				// if supplied string matches element in the array, assign boolean with true 
				if(core.getCoreType().equals(element))
				{
					validArgument = true;
				}
			}
			// return value held in boolean
			return validArgument;
		}
		else
		{
			return validArgument;
		}
	}
	
	// set the type for weapon slot one 
	public void setSlotOneType(String slotOneType)
	{
		if(isSlotTypeValid(slotOneType) == true)
		{
			this.slotOneType = slotOneType;
		}
	}
	
	// get weapon slot type 
	public String getSlotOneType()
	{
		return slotOneType;
	}
	
	// set core into weapon slot if it is the same type as the slot 
	public void setSlotOneCore(cores slotOneCore)
	{
		if(getSlotOneType() != null)
		{
			// must check for null 
			if(isCoreTypeValid(slotOneCore) == true)
			{
				// check if core matches slot type 
				if(getSlotOneType().equals("Any Weapon Core"))
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
	
	// remove core one from weapon
	public void removeWeaponCoreOne()
	{
		slotOneCore = null;
	}
	
	// set the type for weapon slot two
	public void setSlotTwoType(String slotTwoType)
	{
		if(isSlotTypeValid(slotTwoType) == true)
		{
			this.slotTwoType = slotTwoType;
		}
	}
	
	// get weapon slot type 
	public String getSlotTwoType()
	{
		return slotTwoType;
	}
	
	// set core into weapon slot if it is the same type as the slot 
	public void setSlotTwoCore(cores slotTwoCore)
	{
		if(getSlotTwoType() != null)
		{
			// must check for null 
			if(isCoreTypeValid(slotTwoCore) == true)
			{
				// check if core matches slot type 
				if(getSlotTwoType().equals("Any Weapon Core"))
				{
					this.slotTwoCore = slotTwoCore;
				} 
				else if(slotTwoCore.getCoreType().equals(getSlotTwoType()))
				{
					this.slotTwoCore = slotTwoCore;
				}
			}
		}
	}
	
	// get the core set in slot two 
	public cores getSlotTwoCore()
	{
		return slotTwoCore;
	}
	
	// remove core two from weapon
	public void removeWeaponCoreTwo()
	{
		slotTwoCore = null;
	}
	
	// set the type for weapon slot three
	public void setSlotThreeType(String slotThreeType)
	{
		if(isSlotTypeValid(slotThreeType) == true)
		{
			this.slotThreeType = slotThreeType;
		}
	}
	
	// get weapon slot type 
	public String getSlotThreeType()
	{
		return slotThreeType;
	}
	
	// set core into weapon slot if it is the same type as the slot 
	public void setSlotThreeCore(cores slotThreeCore)
	{
		if(getSlotThreeType() != null)
		{
			// must check for null 
			if(isCoreTypeValid(slotThreeCore) == true)
			{
				// check if core matches slot type 
				if(getSlotThreeType().equals("Any Weapon Core"))
				{
					this.slotThreeCore = slotThreeCore;
				}
				else if(slotThreeCore.getCoreType().equals(getSlotThreeType()))
				{
					this.slotThreeCore = slotThreeCore;
				}
			}
		}
	}
	
	// get the core set in slot three 
	public cores getSlotThreeCore()
	{
		return slotThreeCore;
	}
	
	// remove core three from weapon
	public void removeWeaponCoreThree()
	{
		slotThreeCore = null;
	}
	
	// set the type for weapon slot four
	public void setSlotFourType(String slotFourType)
	{
		if(isSlotTypeValid(slotFourType) == true)
		{
			this.slotFourType = slotFourType;
		}
	}
	
	// get weapon slot type 
	public String getSlotFourType()
	{
		return slotFourType;
	}
	
	// set core into weapon slot if it is the same type as the slot 
	public void setSlotFourCore(cores slotFourCore)
	{
		if(getSlotFourType() != null)
		{
			// must check for null 
			if(isCoreTypeValid(slotFourCore) == true)
			{
				// check if core matches slot type 
				if(getSlotFourType().equals("Any Weapon Core"))
				{
					this.slotFourCore = slotFourCore;
				} 
				else if(slotFourCore.getCoreType().equals(getSlotFourType()))
				{
					this.slotFourCore = slotFourCore;
				}
			}
		}
	}
	
	// get the core set in slot four 
	public cores getSlotFourCore()
	{
		return slotFourCore;
	}
	
	// remove core four from weapon
	public void removeWeaponFourOne()
	{
		slotFourCore = null;
	}
	
	// set the type for weapon slot five
	public void setSlotFiveType(String slotFiveType)
	{
		if(isSlotTypeValid(slotFiveType) == true)
		{
			this.slotFiveType = slotFiveType;
		}
	}
	
	// get weapon slot type 
	public String getSlotFiveType()
	{
		return slotFiveType;
	}
	
	// set core into weapon slot if it is the same type as the slot 
	public void setSlotFiveCore(cores slotFiveCore)
	{
		if(getSlotFiveType() != null)
		{
			// must check for null 
			if(isCoreTypeValid(slotFiveCore) == true)
			{
				// check if core matches slot type 
				if(getSlotFiveType().equals("Any Weapon Core"))
				{
					this.slotFiveCore = slotFiveCore;
				} 
				else if(slotFiveCore.getCoreType().equals(getSlotFiveType()))
				{
					this.slotFiveCore = slotFiveCore;
				}
			}
		}
	}
	
	// get the core set in slot five 
	public cores getSlotFiveCore()
	{
		return slotFiveCore;
	}
	
	// remove core five from weapon
	public void removeWeaponCoreFive()
	{
		slotFiveCore = null;
	}
	
	// return an array containing all possible cores a weapon can have 
	public cores[] getWeaponCores()
	{
		cores[] weaponCores = {getSlotOneCore(), getSlotTwoCore(), 
			getSlotThreeCore(), getSlotFourCore(), getSlotFiveCore()};
				return weaponCores;
	}
	
	// END: WEAPON SLOT TYPES AND SLOT CORES
	/*******************************************************************************/
	
	
	
	
	
	
	// START: TOTAL WEAPON ATTRIBUTES WITH CORES SUPPLIED
	/*******************************************************************************/
	
	// NEED remove methods for: weapons, armors, accessories... 
	// assign null for now since need access to inventory for proper removal 
	
	// add points of cores if cores have same type as that specified by argument type 
	public int addSumOfCores(String type)
	{
		// enhanced for loop iterates through all cores object can have 
		for(cores element : getWeaponCores())
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
	
	/*  Note on "getTotal" methods below: 
			methods get total value for a object (like attack, nano, ect.) by adding 
			object's power and core points together only if the cores are the same 
			type as the String supplied as argument (if "Attack" is supplied then 
			add the current core points of the cores with core type "Attack") */
	
							// attribute "getTotal" methods 
	
	public int getTotalAttack()
	{
		return totalAttack = getAttack() + addSumOfCores("Attack");
	}
	
	public int getTotalNano()
	{
		return totalNano = getNano() + addSumOfCores("Nano");
	}
	
	public int getTotalDexterity()
	{
		return totalDexterity = getDexterity() +  addSumOfCores("Dexterity");
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
	
	// END: TOTAL WEAPON ATTRIBUTES WITH CORES SUPPLIED
	/*******************************************************************************/
}
