/*
	public class armors extends public class genericObject and defines methods related 
	to creating armors that can be used to increase defenses/resistances of the wearer
*/
import java.security.SecureRandom;

public class armors extends genericObject
{
	private int maxHp;							// armor effect on character's max HP 
	private int defense;						// armor effect on character's defense stat 
	private int nano;							// armor effect on character's nano stat 
	private int stamina;						// armor effect on character's stamina stat 
	private int dexterity;						// armor effect on character's dexterity stat 
	private int nanoDefense;					// armor effect on character's magic attack stat 
	
	private int fireResistance;					// armor resistance to fire attacks
	private int waterResistance;				// armor resistance to water attacks
	private int iceResistance;					// armor resistance to ice attacks
	private int electricityResistance;			// armor resistance to electricity attacks
	private int poisonResistance;				// armor resistance to poison attacks
	private int sonicResistance;				// armor resistance to sonic (sound-based) attacks
	private int plasmaResistance;				// armor resistance to plasma (laser-based) attacks
	private int windResistance;					// armor resistance to wind (wind-based) attacks
	
	// hold valid types for a armor slot 
	private String[] validSlotTypes = {"Max Hp", "Defense", "Nano", "Stamina", 
		"Dexterity", "Nano Defense", "Fire Resistance", "Water Resistance", 
		"Ice Resistance", "Electricity Resistance", "Poison Resistance", 
		"Sonic Resistance", "Plasma Resistance", "Wind Resistance", 
		"Any Armor Core"};
	
	// slot types can be altered for a large price if desired 
	// cores can be transferred across armor 
	// cores run out over time with use and they are replaceable 
	
	private String slotOneType;					// store what type of slot that slot one is 
	private cores slotOneCore;					// stores core in the specified armor slot 
	private String slotTwoType;					// store what type of slot that slot two is 
	private cores slotTwoCore;					// stores core in the specified armor slot 
	
	// armor power with cores supplied 
	private int coreSum;						// stores sum of core points in sumOfCores()
	private int totalMaxHp;						// armor max hp with Max Hp core supplied
	private int totalDefense;					// armor defense with Defense core supplied
	private int totalNano;						// armor nano with Nano core supplied
	private int totalStamina;					// armor stamina with Stamina core supplied
	private int totalDexterity;					// armor dexterity with Dexterity core supplied
	private int totalNanoDefense;				// armor nano defense with Nano Defense core supplied
	
	// armor resistance with cores supplied 
	private int totalFireResistance;			// armor resistance with core supplied
	private int totalWaterResistance;			// armor resistance with core supplied
	private int totalIceResistance;				// armor resistance with core supplied
	private int totalElectricityResistance;		// armor resistance with core supplied
	private int totalPoisonResistance;			// armor resistance with core supplied
	private int totalSonicResistance;			// armor resistance with core supplied
	private int totalPlasmaResistance;			// armor resistance with core supplied
	private int totalWindResistance;			// armor resistance with core supplied	
	
	// create armors with nothing supplied to super constructor due to too many parameters
	// objects created through this constructor can be customized further by calling set 
	// methods within this class
	public armors()
	{
		// empty constructor 
	}
	
	
	
	
	
	
	// START: ARMOR ATTRIBUTES
	/*******************************************************************************/

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
	
	// set max Hp value armor takes/adds to character 
	public void setMaxHp(int maxHp)
	{
		this.maxHp = validAttribute(maxHp);
	}
	
	// get max Hp value armor takes/adds to character 
	public int getMaxHp()
	{
		return maxHp;
	}
	
	// set defense value armor takes/adds to character 
	public void setDefense(int defense)
	{
		this.defense = validAttribute(defense);
	}
	
	// get defense value armor takes/adds to character 
	public int getDefense()
	{
		return defense;
	}
	
	// set nano value armor takes/adds to character 
	public void setNano(int nano)
	{
		this.nano = validAttribute(nano);
	}
	
	// get nano value armor takes/adds to character 
	public int getNano()
	{
		return nano;
	}
	
	// set stamina value armor takes/adds to character 
	public void setStamina(int stamina)
	{
		this.stamina = validAttribute(stamina);
	}
	
	// get stamina value armor takes/adds to character 
	public int getStamina()
	{
		return stamina;
	}
	
	// set dexterity value armor takes/adds to character 
	public void setDexterity(int dexterity)
	{
		this.dexterity = validAttribute(dexterity);
	}
	
	// get dexterity value armor takes/adds to character 
	public int getDexterity()
	{
		return dexterity;
	}
	
	// set nano defense value armor takes/adds to character 
	public void setNanoDefense(int nanoDefense)
	{
		this.nanoDefense = validAttribute(nanoDefense);
	}
	
	// get nano defense value armor takes/adds to character 
	public int getNanoDefense()
	{
		return nanoDefense;
	}
	
	// END: ARMOR ATTRIBUTES
	/*******************************************************************************/
	
	
	
	
	
	
	// START: ARMOR RESISTANCES
	/*******************************************************************************/
	
	// returns an int that is within the range specified in validResistance
	public int validResistance(int resistance)
	{
		if(resistance < -100)
		{
			resistance = -100;
		}
		else if(resistance > 100)
		{
			resistance = 100;
		}
		
		return resistance;
	}
	
	// set fire resistance value armor takes/adds to character 
	public void setFireResistance(int fireResistance)
	{
		this.fireResistance = validResistance(fireResistance);
	}
	
	// get fire resistance value armor takes/adds to character 
	public int getFireResistance()
	{
		return fireResistance;
	}
	
	// set water resistance value armor takes/adds to character 
	public void setWaterResistance(int waterResistance)
	{
		this.waterResistance = validResistance(waterResistance);
	}
	
	// set water resistance value armor takes/adds to character 
	public int getWaterResistance()
	{
		return waterResistance;
	}
	
	// set ice resistance value armor takes/adds to character 
	public void setIceResistance(int iceResistance)
	{
		this.iceResistance = validResistance(iceResistance);
	}
	
	// get ice resistance value armor takes/adds to character 
	public int getIceResistance()
	{
		return iceResistance;
	}
	
	// set electricity resistance value armor takes/adds to character 
	public void setElectricityResistance(int electricityResistance)
	{
		this.electricityResistance = validResistance(electricityResistance);
	}
	
	// get electricity resistance value armor takes/adds to character 
	public int getElectricityResistance()
	{
		return electricityResistance;
	}
	
	// set poison resistance value armor takes/adds to character 
	public void setPoisonResistance(int poisonResistance)
	{
		this.poisonResistance = validResistance(poisonResistance);
	}
	
	// get poison resistance value armor takes/adds to character 
	public int getPoisonResistance()
	{
		return poisonResistance;
	}
	
	// set sonic resistance value armor takes/adds to character 
	public void setSonicResistance(int sonicResistance)
	{
		this.sonicResistance = validResistance(sonicResistance);
	}
	
	// get sonic resistance value armor takes/adds to character 
	public int getSonicResistance()
	{
		return sonicResistance;
	}
	
	// set plasma resistance value armor takes/adds to character 
	public void setPlamsaResistance(int plasmaResistance)
	{
		this.plasmaResistance = validResistance(plasmaResistance);
	}
	
	// get plasma resistance value armor takes/adds to character 
	public int getPlasmaResistance()
	{
		return plasmaResistance;
	}
	
	// set wind resistance value armor takes/adds to character 
	public void setWindResistance(int windResistance)
	{
		this.windResistance = validResistance(windResistance);
	}
	
	// get wind resistance value armor takes/adds to character 
	public int getWindResistance()
	{
		return windResistance;
	}
	
	// END: ARMOR RESISTANCES
	/*******************************************************************************/
	
	
	
	/*
		8 options
			1	50% Null (no slot)
			2	6	Max Hp		51-56
			3	10	Defense 	57-66
			4	6	Nano 		67-72
			5	7	Stamina 	73-79
			6	8	Dexterity 	80-87
			7	9	Nano Def 	88-96
			8	4	Any 		97-100
			
	private String[] validSlotTypes = {null, "Max Hp", "Defense", "Nano", "Stamina", 
		"Dexterity", "Nano Defense", "Any Armor Core"};
			
	*/
	
	
	
	// START: ARMOR SLOT TYPES AND SLOT CORES
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
		if(holdInt <= 18)
		{
			holdSlotType = null;
		}
		else if(holdInt <= 22)
		{
			holdSlotType = "Fire Resistance";
		}
		else if(holdInt <= 26)
		{
			holdSlotType = "Water Resistance";
		}
		else if(holdInt <= 30)
		{
			holdSlotType = "Ice Resistance";
		}
		else if(holdInt <= 34)
		{
			holdSlotType = "Electricity Resistance";
		}
		else if(holdInt <= 38)
		{
			holdSlotType = "Poison Resistance";
		}
		else if(holdInt <= 42)
		{
			holdSlotType = "Sonic Resistance";
		}
		else if(holdInt <= 46)
		{
			holdSlotType = "Plasma Resistance";
		}
		else if(holdInt <= 50)
		{
			holdSlotType = "Wind Resistance";
		}
		else if(holdInt <= 56)
		{
			holdSlotType = "Max Hp";
		}
		else if(holdInt <= 66)
		{
			holdSlotType = "Defense";
		}
		else if(holdInt <= 72)
		{
			holdSlotType = "Nano";
		}
		else if(holdInt <= 79)
		{
			holdSlotType = "Stamina";
		}
		else if(holdInt <= 87)
		{
			holdSlotType = "Dexterity";
		}
		else if(holdInt <= 96)
		{
			holdSlotType = "Nano Defense";
		}
		else if(holdInt <= 100)
		{
			holdSlotType = "Any Armor Core";
		}
		// return slot type 
		return holdSlotType;
	}
	
	// randomize slot types for a armor 
	public void randomizeSlotTypes(Boolean randomSlots)
	{
		// if boolean variable is true, set slot types for all five slots randomly 
		if(randomSlots == true)
		{
			setSlotOneType(determineSlotType());
			setSlotTwoType(determineSlotType());
		}
	}
	
	// determine whether the supplied string is valid 
	public boolean isSlotTypeValid(String slotType)
	{
		// variable will be set to true is argument is valid 
		boolean validArgument = false;
		
		if(slotType != null)
		{
			// for loop compares string against elements in array 
			for(String element : validSlotTypes)
			{
				// if supplied string matches element in the array, assign boolean with true 
				if(slotType.equals(element))
				{
					validArgument = true;
						break;
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
	
	// determine whether the supplied armor core is valid 
	public boolean isCoreTypeValid(cores core)
	{
		// variable will be set to true is argument is valid 
		boolean validArgument = false;
		
		if(core != null)
		{
			// for loop compares core type against elements in array 
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
	
	// set the type for armor slot one 
	public void setSlotOneType(String slotOneType)
	{
		if(isSlotTypeValid(slotOneType) == true)
		{
			this.slotOneType = slotOneType;
		}
	}
	
	// get armor slot type 
	public String getSlotOneType()
	{
		return slotOneType;
	}
	
	// set core into armor slot if it is the same type as the slot 
	public void setSlotOneCore(cores slotOneCore)
	{
		if(getSlotOneType() != null)
		{
			if(isCoreTypeValid(slotOneCore) == true)
			{
				if(getSlotOneType().equals("Any Armor Core"))
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
	
	// remove core one from armor
	public void removeArmorCoreOne()
	{
		slotOneCore = null;
	}
	
	// set the type for armor slot two
	public void setSlotTwoType(String slotTwoType)
	{
		if(isSlotTypeValid(slotTwoType) == true)
		{
			this.slotTwoType = slotTwoType;
		}
	}
	
	// get armor slot type 
	public String getSlotTwoType()
	{
		return slotTwoType;
	}
	
	// set core into armor slot if it is the same type as the slot 
	public void setSlotTwoCore(cores slotTwoCore)
	{
		if(getSlotTwoType() != null)
		{
			if(isCoreTypeValid(slotTwoCore) == true)
			{
				if(getSlotTwoType().equals("Any Armor Core"))
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
	
	// set the type for armor slot two 
	public cores getSlotTwoCore()
	{
		return slotTwoCore;
	}
	
	// remove core two from armor
	public void removeArmorCoreTwo()
	{
		slotTwoCore = null;
	}
	
	// return an array containing all possible cores a piece of armor can have 
	public cores[] getArmorCores()
	{
		cores[] armorCores = {getSlotOneCore(), getSlotTwoCore()};
			return armorCores;
	}
	
	// END: ARMOR SLOT TYPES AND SLOT CORES
	/*******************************************************************************/

	
	
	
	
	
	// START: TOTAL ARMOR ATTRIBUTES AND RESISTANCES WITH CORES SUPPLIED
	/*******************************************************************************/

	// NEED remove methods for: weapons, armors, accessories... 
	// assign null for now since need access to inventory for proper removal 
	
	// add points of cores if cores have same type as that specified by argument type 
	public int addSumOfCores(String type)
	{
		// enhanced for loop iterates through all cores object can have 
		for(cores element : getArmorCores())
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
	
	public int getTotalNanoDefense()
	{
		return totalNanoDefense = getNanoDefense() + addSumOfCores("Nano Defense");
	}
	
							// resistance "getTotal" methods 
	
	public int getTotalFireResistance()
	{
		return totalFireResistance = getFireResistance() + addSumOfCores("Fire Resistance");
	}
	
	public int getTotalWaterResistance()
	{
		return totalWaterResistance = getWaterResistance() + addSumOfCores("Water Resistance");
	}
	
	public int getTotalIceResistance()
	{
		return totalIceResistance = getIceResistance() + addSumOfCores("Ice Resistance");
	}
	
	public int getTotalElectricityResistance()
	{
		return totalElectricityResistance = getElectricityResistance() + addSumOfCores("Electricity Resistance");
	}
	
	public int getTotalPoisonResistance()
	{
		return totalPoisonResistance = getPoisonResistance() + addSumOfCores("Poison Resistance");
	}
	
	public int getTotalSonicResistance()
	{
		return totalSonicResistance = getSonicResistance() + addSumOfCores("Sonic Resistance");
	}
	
	public int getTotalPlasmaResistance()
	{
		return totalPlasmaResistance = getPlasmaResistance() + addSumOfCores("Plasma Resistance");
	}
	
	public int getTotalWindResistance()
	{
		return totalWindResistance = getWindResistance() + addSumOfCores("Wind Resistance");
	}
	
	// END: TOTAL ARMOR ATTRIBUTES AND RESISTANCES WITH CORES SUPPLIED
	/*******************************************************************************/
}
