/*
	public class accessories extends public class genericItem & defines methods 
	related to equipable accessories which can either increase or decrease stats 
	once equipped 
	
	accessories
		rings
		necklaces
		gloves
		capes
		shields
		head
*/
import java.util.Random;

public class accessories extends itemAttributesDefined
{	
	private double accessoryExp;				// accessory effect on character's experience  
	private int accessoryMaxHp;					// accessory effect on character's max HP 
	private int accessoryCurrentHp;				// accessory effect on character's current hp 
	private int accessoryAttack;				// accessory effect on character's attack stat 
	private int accessoryDefense;				// accessory effect on character's defense stat 
	private int accessoryNano;					// accessory effect on character's nano stat 
	private int accessoryStamina;				// accessory effect on character's stamina stat 
	private int accessoryDexterity;				// accessory effect on character's dexterity stat 
	private int accessoryCritical;				// accessory effect on character's critical stat 
	private int accessoryAccuracy;				// accessory effect on character's accuracy stat 
	private int accessoryNanoAttack;			// accessory effect on character's nano attack stat 
	private int accessoryNanoDefense;			// accessory effect on character's nano defense stat 	
	
	// hold status that accessories can resist
	private String[] resistAttributeStatus = {"Attack Down", "Defense Down", "Nano Down", 
		"Stamina Down", "Dexterity Down", "Critical Down", "Accuracy Down", "Nano Attack Down",
		"Nano Defense Down"}; 
	
	// hold accessory status resistances 
	private String[] resistResistanceStatus = {"Dry", "Wet", "Cold", "Conductive", 
		"Sickness", "Hypersensitive", "Coated", "Lightweight"};
	
	// hold behavior that accessories can resist 
	private String[] resistBehavior = {"Enamore", "Infatuate"};
	
	// hold turn statuses that accessories can resist 
	private String[] resistNegativeTurnStatus = {"Stun", "Sleep", "Shock", "Slow",
		"Stop", "Slime"};	
	
	// flatten arrays concerning accessory resistances into one array 
	private String[] holdResistStatus [] = {resistAttributeStatus, 
		resistResistanceStatus, resistBehavior, resistNegativeTurnStatus};

	// hold valid types for an accessory slot 
	private String[] validSlotTypes = {null, "Max Hp", "Current Hp", "Attack", 
		"Defense", "Nano", "Stamina", "Dexterity", "Critical", "Accuracy", 
		"Nano Attack", "Nano Defense", "Any Accessory Core"};

	// accessories can resist up to three status ailments at a time 
	private String resistStatusOne; 		// hold first status accessory resists
	private String resistStatusTwo; 		// hold second status accessory resists
	private String resistStatusThree; 		// hold third status accessory resists
	
	// slot types can be altered for a large price if desired 
	// cores can be transferred across armor 
	// cores run out over time with use and they are replaceable 
	
	private boolean randomSlots;	// determines whether all slot types should be randomized 
	private String slotOneType;		// store what type of slot that slot one is 
	private core slotOneCore;		// stores core in the specified accessory slot 
	
	public accessories(int itemId, String itemName, String itemCategory, 
		String itemSuperType, String itemSubType, int itemBuyPrice, 
		int itemSellPrice, double accessoryExp, int accessoryMaxHp,
		int accessoryCurrentHp, int accessoryAttack, int accessoryDefense, 
		int accessoryNano, int accessoryStamina, int accessoryDexterity,
		int accessoryCritical, int accessoryAccuracy, int accessoryNanoAttack, 
		int accessoryNanoDefense, Boolean randomSlots)
	{
		// supply arguments to superclass constructor 
		super(itemId, itemName, itemCategory, itemSuperType, itemSubType, itemBuyPrice, itemSellPrice);
		
		setAccessoryExp(accessoryExp);
		setAccessoryMaxHp(accessoryMaxHp);
		setAccessoryCurrentHp(accessoryCurrentHp);
		setAccessoryAttack(accessoryAttack);
		setAccessoryDefense(accessoryDefense);
		setAccessoryNano(accessoryNano);
		setAccessoryStamina(accessoryStamina);
		setAccessoryDexterity(accessoryDexterity);
		setAccessoryCritical(accessoryCritical);
		setAccessoryAccuracy(accessoryAccuracy);
		setAccessoryNanoAttack(accessoryNanoAttack);
		setAccessoryNanoDefense(accessoryNanoDefense);
		setRandomSlots(randomSlots);
		randomizeSlotTypes(getRandomSlots());
		
		
		
	}
	
	// set experience value accessory affects character experience by
	public void setAccessoryExp(double accessoryExp)
	{
		if(accessoryExp < 0)
		{
			accessoryExp = 0;
		}
		else if(accessoryExp > 3)
		{
			accessoryExp = 3;
		}
		
		this.accessoryExp = accessoryExp;
	}
	
	// get experience value accessory affects character experience by
	public double getAccessoryExp()
	{
		return accessoryExp; 
	} 
	
	// set max hp value accessory takes/adds to character 
	public void setAccessoryMaxHp(int accessoryMaxHp) 
	{
		if(accessoryMaxHp < 0)
		{
			accessoryMaxHp = 0;
		}
		else if(accessoryMaxHp > 500)
		{
			accessoryMaxHp = 500;
		}
		
		this.accessoryMaxHp = accessoryMaxHp; 
	} 
	
	/*
	oathkeeper Sinclair
	Heather Van Der Lind
	Envoy of the End 
	The End 
	Nero of the downtrodden  l
	He that is Here but not there
	Queen of the Western Isles
	*/
	
	// get max hp value accessory takes/adds to character 
	public int getAccessoryMaxHp()
	{
		return accessoryMaxHp; 
	} 
	
	// set current HP value accessory takes/adds to character 
	public void setAccessoryCurrentHp(int accessoryCurrentHp)
	{	
		if(accessoryCurrentHp < 0)
		{
			accessoryCurrentHp = 0;
		}
		else if(accessoryCurrentHp > 500)
		{
			accessoryCurrentHp = 500;
		}
		
		this.accessoryCurrentHp = accessoryCurrentHp;
	}
	
	// get current HP value accessory takes/adds to character 
	public int getAccessoryCurrentHp()
	{
		return accessoryCurrentHp; 
	} 
	
	// set attack value accessory takes/adds to character 
	public void setAccessoryAttack(int accessoryAttack)
	{
		if(accessoryAttack < 0)
		{
			accessoryAttack = 0;
		}
		else if(accessoryAttack > 500)
		{
			accessoryAttack = 500;
		}
		
		this.accessoryAttack = accessoryAttack;
	}
	
	// get attack value accessory takes/adds to character 
	public int getAccessoryAttack()
	{
		return accessoryAttack; 
	} 
	
	
	// set defense value accessory takes/adds to character 
	public void setAccessoryDefense(int accessoryDefense)
	{
		if(accessoryDefense < 0)
		{
			accessoryDefense = 0;
		}
		else if(accessoryDefense > 500)
		{
			accessoryDefense = 500;
		}
		
		this.accessoryDefense = accessoryDefense;
	}
	
	// get defense value accessory takes/adds to character 
	public int getAccessoryDefense()
	{
		return accessoryDefense; 
	} 
	
	// set nano value accessory takes/adds to character 
	public void setAccessoryNano(int accessoryNano)
	{
		if(accessoryNano < 0)
		{
			accessoryNano = 0;
		}
		else if(accessoryNano > 500)
		{
			accessoryNano = 500;
		}
		
		this.accessoryNano = accessoryNano;
	}
	
	// get nano value accessory takes/adds to character 
	public int getAccessoryNano()
	{
		return accessoryNano; 
	} 
	
	// set stamina value accessory takes/adds to character 
	public void setAccessoryStamina(int accessoryStamina)
	{
		if(accessoryStamina < 0)
		{
			accessoryStamina = 0;
		}
		else if(accessoryStamina > 500)
		{
			accessoryStamina = 500;
		}
		
		this.accessoryStamina = accessoryStamina;
	}
	
	// get stamina value accessory takes/adds to character 
	public int getAccessoryStamina()
	{
		return accessoryStamina; 
	} 
	
	// set dexterity value accessory takes/adds to character 
	public void setAccessoryDexterity(int accessoryDexterity)
	{
		if(accessoryDexterity < 0)
		{
			accessoryDexterity = 0;
		}
		else if(accessoryDexterity > 500)
		{
			accessoryDexterity = 500;
		}
		
		this.accessoryDexterity = accessoryDexterity;
	}
	
	// get dexterity value accessory takes/adds to character 
	public int getAccessoryDexterity()
	{
		return accessoryDexterity; 
	} 
	
	// set critical value accessory takes/adds to character 
	public void setAccessoryCritical(int accessoryCritical)
	{
		if(accessoryCritical < 0)
		{
			accessoryCritical = 0;
		}
		else if(accessoryCritical > 500)
		{
			accessoryCritical = 500;
		}
		
		this.accessoryCritical = accessoryCritical;
	}
	
	// get critical value accessory takes/adds to character 
	public int getAccessoryCritical()
	{
		return accessoryCritical; 
	} 
	
	// set accuracy value accessory takes/adds to character 
	public void setAccessoryAccuracy(int accessoryAccuracy)
	{
		if(accessoryAccuracy < 0)
		{
			accessoryAccuracy = 0;
		}
		else if(accessoryAccuracy > 500)
		{
			accessoryAccuracy = 500;
		}
		
		this.accessoryAccuracy = accessoryAccuracy;
	}
	
	// get accuracy value accessory takes/adds to character 
	public int getAccessoryAccuracy()
	{
		return accessoryAccuracy; 
	} 
	
	// set nano attack value accessory takes/adds to character 
	public void setAccessoryNanoAttack(int accessoryNanoAttack)
	{
		if(accessoryNanoAttack < 0)
		{
			accessoryNanoAttack = 0;
		}
		else if(accessoryNanoAttack > 500)
		{
			accessoryNanoAttack = 500;
		}
		
		this.accessoryNanoAttack = accessoryNanoAttack;
	}
	
	// get nano attack value accessory takes/adds to character 
	public int getAccessoryNanoAttack()
	{
		return accessoryNanoAttack; 
	} 
	
	// set nano defense value accessory takes/adds to character 
	public void setAccessoryNanoDefense(int accessoryNanoDefense)
	{
		if(accessoryNanoDefense < 0)
		{
			accessoryNanoDefense = 0;
		}
		else if(accessoryNanoDefense > 500)
		{
			accessoryNanoDefense = 500;
		}
		
		this.accessoryNanoDefense = accessoryNanoDefense;
	}
	
	// get nano defense value accessory takes/adds to character 
	public int getAccessoryNanoDefense()
	{
		return accessoryNanoDefense; 
	} 
	
	// set whether random slots are generated for a accessory
	public void setRandomSlots(boolean randomSlots)
	{
		this.randomSlots = randomSlots;
	}
	
	// return random slots option for accessories 
	public boolean getRandomSlots()
	{
		return randomSlots;
	}
	
	// check whether the status supplied as an argument is valid 
	public boolean isResistStatusValid(String resistStatus)
	{
		boolean validArgument = false;
		
		if(resistStatus != null)
		{
			for(int i = 0; i < holdResistStatus.length; i++)
			{
				if(resistStatus.equals(holdResistStatus[i]))
				{
					validArgument = true;
				}
			}
			return validArgument;
		}
		else
		{
			return validArgument;
		}
	}
	
	// set first status that accessory resists 
	public void setResistStatusOne(String resistStatusOne)
	{
		if(isResistStatusValid(resistStatusOne) == true)
		{
			this.resistStatusOne = resistStatusOne;
		}
	}
	
	// get first status that accessory resists  
	public String getResistStatusOne()
	{
		return resistStatusOne;
	}
	
	// set second status that armor resists 
	public void setResistStatusTwo(String resistStatusTwo)
	{
		if(isResistStatusValid(resistStatusTwo) == true)
		{
			this.resistStatusTwo = resistStatusTwo;
		}
	}
	
	// get second status that armor resists  
	public String getResistStatusTwo()
	{
		return resistStatusTwo;
	}
	
	// set third status that armor resists 
	public void setResistStatusThree(String resistStatusThree)
	{
		if(isResistStatusValid(resistStatusThree) == true)
		{
			this.resistStatusThree = resistStatusThree;
		}
	}
	
	// get third status that armor resists  
	public String getResistStatusThree()
	{
		return resistStatusThree;
	}
	
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
			// for loop compares string against elements in array 
			for(int i = 0; i < validSlotTypes.length; i++)
			{
				// if supplied string matches element in the array, assign boolean with true 
				if(slotType.equals(validSlotTypes[i]))
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
	public void setSlotOneCore(core slotOneCore)
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
	public core getSlotOneCore()
	{
		return slotOneCore;
	}
}
