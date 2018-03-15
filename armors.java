/*
	public class armor extends public class genericItem & defines methods 
	regarding equipable armor primarily used to increase defense & endure 
	more attacks before falling
	
	armor
		body
		legs
		feet
*/
import java.util.Random;

public class armors extends itemAttributesDefined
{
	private int armorMaxHp;					// armor effect on character's max HP 
	private int armorDefense;				// armor effect on character's defense stat 
	private int armorNano;					// armor effect on character's nano stat 
	private int armorStamina;				// armor effect on character's stamina stat 
	private int armorDexterity;				// armor effect on character's dexterity stat 
	private int armorNanoDefense;			// armor effect on character's magic attack stat 
	
	private int armorFireResistance;		// armor resistance to fire attacks
	private int armorWaterResistance;		// armor resistance to water attacks
	private int armorIceResistance;			// armor resistance to ice attacks
	private int armorElectricityResistance;	// armor resistance to electricity attacks
	private int armorPoisonResistance;		// armor resistance to poison attacks
	private int armorSonicResistance;		// armor resistance to sonic (sound-based) attacks
	private int armorPlasmaResistance;		// armor resistance to plasma (laser-based) attacks
	private int armorWindResistance;		// armor resistance to wind (wind-based) attacks
	private String statusArmorResisted; 	// status effect armor resists
	
	// hold status that armor resists
	private String[] resistHpStatus = {"Ablaze", "Bleed", "Poison"};
	
	// hold valid types for a armor slot 
	private String[] validSlotTypes = {null, "Max Hp", "Defense", "Nano", "Stamina", 
		"Dexterity", "Nano Defense", "Any Armor Core"};
	
	// slot types can be altered for a large price if desired 
	// cores can be transferred across armor 
	// cores run out over time with use and they are replaceable 
	
	private boolean randomSlots;	// determines whether all slot types should be randomized 
	private String slotOneType;		// store what type of slot that slot one is 
	private core slotOneCore;		// stores core in the specified armor slot 
	private String slotTwoType;		// store what type of slot that slot two is 
	private core slotTwoCore;		// stores core in the specified armor slot 
	
	public armors(int itemId, String itemName, String itemCategory, String itemSuperType, 
		String itemSubType, int itemBuyPrice, int itemSellPrice, int armorMaxHp, int armorDefense, 
		int armorNano, int armorStamina, int armorDexterity, int armorNanoDefense, int armorFireResistance, 
		int armorWaterResistance, int armorIceResistance, int armorElectricityResistance, 
		int armorPoisonResistance, int armorSonicResistance, int armorPlasmaResistance, 
		int armorWindResistance, Boolean randomSlots)
	{
		// supply arguments to superclass constructor 
		super(itemId, itemName, itemCategory, itemSuperType, itemSubType, itemBuyPrice, itemSellPrice);
		
		setArmorMaxHp(armorMaxHp);
		setArmorDefense(armorDefense);
		setArmorNano(armorNano);
		setArmorStamina(armorStamina);
		setArmorDexterity(armorDexterity);
		setArmorNanoDefense(armorNanoDefense);
		setArmorFireResistance(armorFireResistance);
		setArmorWaterResistance(armorWaterResistance);
		setArmorIceResistance(armorIceResistance);
		setArmorElectricityResistance(armorElectricityResistance);
		setArmorPoisonResistance(armorPoisonResistance);
		setArmorSonicResistance(armorSonicResistance);
		setArmorPlamsaResistance(armorPlasmaResistance);
		setArmorWindResistance(armorWindResistance);
		setRandomSlots(randomSlots);
		randomizeSlotTypes(getRandomSlots());
	}
	
	// set max Hp value armor takes/adds to character 
	public void setArmorMaxHp(int armorMaxHp)
	{
		if(armorMaxHp < -500)
		{
			armorMaxHp = -500;
		}
		else if(armorMaxHp > 500)
		{
			armorMaxHp = 500;
		}
		
		this.armorMaxHp = armorMaxHp;
	}
	
	// get max Hp value armor takes/adds to character 
	public int getArmorMaxHP()
	{
		return armorMaxHp;
	}
	
	// set defense value armor takes/adds to character 
	public void setArmorDefense(int armorDefense)
	{
		if(armorDefense < -500)
		{
			armorDefense = -500;
		}
		else if(armorDefense > 500)
		{
			armorDefense = 500;
		}
		
		this.armorDefense = armorDefense;
	}
	
	// get defense value armor takes/adds to character 
	public int getArmorDefense()
	{
		return armorDefense;
	}
	
	// set nano value armor takes/adds to character 
	public void setArmorNano(int armorNano)
	{
		if(armorNano < -500)
		{
			armorNano = -500;
		}
		else if(armorNano > 500)
		{
			armorNano = 500;
		}
		
		this.armorNano = armorNano;
	}
	
	// get nano value armor takes/adds to character 
	public int getArmorNano()
	{
		return armorNano;
	}
	
	// set stamina value armor takes/adds to character 
	public void setArmorStamina(int armorStamina)
	{
		if(armorStamina < -500)
		{
			armorStamina = -500;
		}
		else if(armorStamina > 500)
		{
			armorStamina = 500;
		}
		
		this.armorStamina = armorStamina;
	}
	
	// get stamina value armor takes/adds to character 
	public int getArmorStamina()
	{
		return armorStamina;
	}
	
	// set dexterity value armor takes/adds to character 
	public void setArmorDexterity(int armorDexterity)
	{
		if(armorDexterity < -500)
		{
			armorDexterity = -500;
		}
		else if(armorDexterity > 500)
		{
			armorDexterity = 500;
		}
		
		this.armorDexterity = armorDexterity;
	}
	
	// get dexterity value armor takes/adds to character 
	public int getArmorDexterity()
	{
		return armorDexterity;
	}
	
	// set nano defense value armor takes/adds to character 
	public void setArmorNanoDefense(int armorNanoDefense)
	{
		if(armorNanoDefense < -500)
		{
			armorNanoDefense = -500;
		}
		else if(armorNanoDefense > 500)
		{
			armorNanoDefense = 500;
		}
		
		this.armorNanoDefense = armorNanoDefense;
	}
	
	// get nano defense value armor takes/adds to character 
	public int getArmorNanoDefense()
	{
		return armorNanoDefense;
	}
	
	// set fire resistance value armor takes/adds to character 
	public void setArmorFireResistance(int armorFireResistance)
	{
		if(armorFireResistance < -100)
		{
			armorFireResistance = -100;
		}
		else if(armorFireResistance > 100)
		{
			armorFireResistance = 100;
		}
		
		this.armorFireResistance = armorFireResistance;
	}
	
	// get fire resistance value armor takes/adds to character 
	public int getArmorFireResistance()
	{
		return armorFireResistance;
	}
	
	// set water resistance value armor takes/adds to character 
	public void setArmorWaterResistance(int armorWaterResistance)
	{
		if(armorWaterResistance < -100)
		{
			armorWaterResistance = -100;
		}
		else if(armorWaterResistance > 100)
		{
			armorWaterResistance = 100;
		}
		
		this.armorWaterResistance = armorWaterResistance;
	}
	
	// set water resistance value armor takes/adds to character 
	public int getArmorWaterResistance()
	{
		return armorWaterResistance;
	}
	
	// set ice resistance value armor takes/adds to character 
	public void setArmorIceResistance(int armorIceResistance)
	{
		if(armorIceResistance < -100)
		{
			armorIceResistance = -100;
		}
		else if(armorIceResistance > 100)
		{
			armorIceResistance = 100;
		}
		
		this.armorIceResistance = armorIceResistance;
	}
	
	// get ice resistance value armor takes/adds to character 
	public int getArmorIceResistance()
	{
		return armorIceResistance;
	}
	
	// set electricity resistance value armor takes/adds to character 
	public void setArmorElectricityResistance(int armorElectricityResistance)
	{
		if(armorElectricityResistance < -100)
		{
			armorElectricityResistance = -100;
		}
		else if(armorElectricityResistance > 100)
		{
			armorElectricityResistance = 100;
		}
		
		this.armorElectricityResistance = armorElectricityResistance;
	}
	
	// get electricity resistance value armor takes/adds to character 
	public int getArmorElectrictyResistance()
	{
		return armorElectricityResistance;
	}
	
	// set poison resistance value armor takes/adds to character 
	public void setArmorPoisonResistance(int armorPoisonResistance)
	{
		if(armorPoisonResistance < -100)
		{
			armorPoisonResistance = -100;
		}
		else if(armorPoisonResistance > 100)
		{
			armorPoisonResistance = 100;
		}
		
		this.armorPoisonResistance = armorPoisonResistance;
	}
	
	// get poison resistance value armor takes/adds to character 
	public int getArmorPoisonResistance()
	{
		return armorPoisonResistance;
	}
	
	// set sonic resistance value armor takes/adds to character 
	public void setArmorSonicResistance(int armorSonicResistance)
	{
		if(armorSonicResistance < -100)
		{
			armorSonicResistance = -100;
		}
		else if(armorSonicResistance > 100)
		{
			armorSonicResistance = 100;
		}
		
		this.armorSonicResistance = armorSonicResistance;
	}
	
	// get sonic resistance value armor takes/adds to character 
	public int getSonicResistance()
	{
		return armorSonicResistance;
	}
	
	// set plasma resistance value armor takes/adds to character 
	public void setArmorPlamsaResistance(int armorPlasmaResistance)
	{
		if(armorPlasmaResistance < -100)
		{
			armorPlasmaResistance = -100;
		}
		else if(armorPlasmaResistance > 100)
		{
			armorPlasmaResistance = 100;
		}
		
		this.armorPlasmaResistance = armorPlasmaResistance;
	}
	
	// get plasma resistance value armor takes/adds to character 
	public int getArmorPlasmaResistance()
	{
		return armorPlasmaResistance;
	}
	
	// set wind resistance value armor takes/adds to character 
	public void setArmorWindResistance(int armorWindResistance)
	{
		if(armorWindResistance < -100)
		{
			armorWindResistance = -100;
		}
		else if(armorWindResistance > 100)
		{
			armorWindResistance = 100;
		}
		
		this.armorWindResistance = armorWindResistance;
	}
	
	// get wind resistance value armor takes/adds to character 
	public int getArmorWindResistance()
	{
		return armorWindResistance;
	}
	
	// set whether random slots are generated for armor
	public void setRandomSlots(boolean randomSlots)
	{
		this.randomSlots = randomSlots;
	}
	
	// return random slots option for armor 
	public boolean getRandomSlots()
	{
		return randomSlots;
	}
	
	// set status that armor resists 
	public void setStatusArmorResists(String statusArmorResisted)
	{
		if(statusArmorResisted != null)
		{
			boolean validArgument = false;
			
			for(int i = 0; i < resistHpStatus.length; i++)
			{
				if(statusArmorResisted.equals(resistHpStatus[i]))
				{
					validArgument = true;
				}
			}
			
			if(validArgument == true)
			{
				this.statusArmorResisted = statusArmorResisted;
			}
		}
	}
	
	// get status that armor resists  
	public String getStatusArmorResists()
	{
		return statusArmorResisted;
	}
	
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
	
	// returns a String that was selected randomly
	public String determineSlotType()
	{
		// create random object to call random methods 
		Random rand = new Random();
		
		// int variable will hold a random number form 1 to 100
		int holdInt = rand.nextInt(100 + 1);
		
		// initialize holdSlotType meant to be assigned a String for slot type 
		String holdSlotType = null;
		
		// portion of if else statement executes depending on value of variable 
		if(holdInt <= 50)
		{
			holdSlotType = "None";
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
			for(int i = 0; i < validSlotTypes.length; i++)
			{
				// if supplied string matches element in the array, assign boolean with true 
				if(slotType.equals(validSlotTypes[i]))
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
	
	// determine whether the supplied armor core is valid 
	public boolean isCoreTypeValid(core core)
	{
		// variable will be set to true is argument is valid 
		boolean validArgument = false;
		
		if(core != null)
		{
			// for loop compares core type against elements in array 
			for(int i = 0; i < validSlotTypes.length; i++)
			{
				// if supplied string matches element in the array, assign boolean with true 
				if(core.getCoreType().equals(validSlotTypes[i]))
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
	public void setSlotOneCore(core slotOneCore)
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
	public core getSlotOneCore()
	{
		return slotOneCore;
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
	public void setSlotTwoCore(core slotTwoCore)
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
	public core getSlotTwoCore()
	{
		return slotTwoCore;
	}
}
