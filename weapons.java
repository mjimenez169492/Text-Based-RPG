/*
	public class weapons extends public class genericItem & defines methods 
	related to equipable weapons that primarily increase attack and to 
	attack enemies
*/
import java.util.Random;

public class weapons extends itemAttributesDefined
{
	private int weaponHp;			// weapon effect on character's current HP per attack
	private int weaponAttack;		// weapon effect on character's attack stat 
	private int weaponNano;			// weapon effect on character's nano stat 
	private int weaponStamina;		// weapon effect on character's stamina stat 
	private int weaponDexterity;	// weapon effect on character's dexterity stat 
	private int weaponCritical;		// weapon effect on character's critical stat 
	private int weaponAccuracy;		// weapon effect on character's accuracy stat 
	private int weaponNanoAttack;	// weapon effect on character's nano attack stat 
	private String inflictStatus; 	// status effect weapon inflicts on the enemy 
	
	// hold weapon status that inflicts KO on the enemy
	private String[] inflictKO = {"KO", "Freeze"};
	
	// hold weapon status that inflicts damage to enemy hp 
	private String[] inflictHpStatus = {"Ablaze", "Bleed", "Poison"};
	
	// hold status that weapon can inflict on an enemy
	private String[] inflictAttributeStatus = {"Attack Down", "Defense Down", "Nano Down", 
		"Stamina Down", "Dexterity Down", "Critical Down", "Accuracy Down", "Nano Attack Down",
		"Nano Defense Down"}; 
	
	// hold weapon status that inflicts affects enemy attributes 
	private String[] inflictResistanceStatus = {"Dry", "Wet", "Cold", "Conductive", 
		"Sickness", "Hypersensitive", "Coated", "Lightweight"};
	
	// hold weapon status that affects enemy behavior 
	private String[] inflictBehavior = {"Enamore", "Infatuate"};
	
	// hold weapon status that affects enemy turn status 
	private String[] inflictNegativeTurnStatus = {"Stun", "Sleep", "Shock", "Slow",
		"Stop", "Slime"};	
	
	// flatten arrays that inflict status on an enemy into one array 
	private String[] holdInflictStatus [] = {inflictKO, inflictHpStatus, inflictAttributeStatus, 
		inflictResistanceStatus, inflictBehavior, inflictNegativeTurnStatus};

	// hold valid types for a weapon slot 
	private String[] validSlotTypes = {null, "Current Hp", "Attack", "Nano", "Stamina", 
		"Dexterity", "Critical", "Accuracy", "Nano Attack", "Any Weapon Core"};
	
	// slot types can be altered for a large price if desired 
	// cores can be transferred across weapons 
	// cores run out over time with use and they are replaceable 
	
	private boolean randomSlots;	// determines whether all slot types should be randomized 
	private String slotOneType;		// store what type of slot that slot one is 
	private core slotOneCore;		// stores core in the specified weapon slot 
	private String slotTwoType;		// store what type of slot that slot two is 
	private core slotTwoCore;		// stores core in the specified weapon slot 
	private String slotThreeType;	// store what type of slot that slot three is 
	private core slotThreeCore;		// stores core in the specified weapon slot 
	private String slotFourType;	// store what type of slot that slot four is 
	private core slotFourCore;		// stores core in the specified weapon slot 
	private String slotFiveType;	// store what type of slot that slot five is 
	private core slotFiveCore;		// stores core in the specified weapon slot 
	
	// constructor allows for the creation of a weapon 
	public weapons(int itemId, String itemName, String itemCategory, String itemSuperType, 
		String itemSubType, int itemBuyPrice, int itemSellPrice, int weaponHp, int weaponAttack, 
		int weaponNano, int weaponStamina, int weaponDexterity, int weaponCritical, 
		int weaponAccuracy, int weaponNanoAttack, String inflictStatus, Boolean randomSlots)
	{
		// supply arguments to superclass constructor 
		super(itemId, itemName, itemCategory, itemSuperType, itemSubType, itemBuyPrice, itemSellPrice);
		
		setWeaponHp(weaponHp);
		setWeaponAttack(weaponAttack);
		setWeaponNano(weaponNano);
		setWeaponStamina(weaponStamina);
		setWeaponDexterity(weaponDexterity);
		setWeaponCritical(weaponCritical);
		setWeaponAccuracy(weaponAccuracy);
		setWeaponNanoAttack(weaponNanoAttack);
		setInflictStatus(inflictStatus);
		setRandomSlots(randomSlots);	
		randomizeSlotTypes(getRandomSlots());
	}
	
	// set Hp value weapon takes/adds to character 
	public void setWeaponHp(int weaponHp)
	{
		if(weaponHp < -500)
		{
			weaponHp = -500;
		}
		else if(weaponHp > 500)
		{
			weaponHp = 500;
		}
		
		this.weaponHp = weaponHp;
	}
	
	// get Hp value weapon takes/adds to character 
	public int getWeaponHp()
	{
		return weaponHp;
	}
	
	// set attack value weapon takes/adds to character 
	public void setWeaponAttack(int weaponAttack)
	{
		if(weaponAttack < -500)
		{
			weaponAttack = -500;
		}
		else if(weaponAttack > 500)
		{
			weaponAttack = 500;
		}
		
		this.weaponAttack = weaponAttack;

	}
	
	// get attack value weapon takes/adds to character 
	public int getWeaponAttack()
	{
		return weaponAttack;
	}
	
	// set nano value weapon takes/adds to character 
	public void setWeaponNano(int weaponNano)
	{
		if(weaponNano < -500)
		{
			weaponNano = -500;
		}
		else if(weaponNano > 500)
		{
			weaponNano = 500;
		}
		
		this.weaponNano = weaponNano;
	}
	
	// get nano value weapon takes/adds to character 
	public int getWeaponNano()
	{
		return weaponNano;
	}
	
	// set stamina value weapon takes/adds to character 
	public void setWeaponStamina(int weaponStamina)
	{
		if(weaponStamina < -500)
		{
			weaponStamina = -500;
		}
		else if(weaponStamina > 500)
		{
			weaponStamina = 500;
		}
		
		this.weaponStamina = weaponStamina;
	}
	
	// get stamina value weapon takes/adds to character 
	public int getWeaponStamina()
	{
		return weaponStamina;
	}
	
	// set dexterity value weapon takes/adds to character 
	public void setWeaponDexterity(int weaponDexterity)
	{
		if(weaponDexterity < -500)
		{
			weaponDexterity = -500;
		}
		else if(weaponDexterity > 500)
		{
			weaponDexterity = 500;
		}
		
		this.weaponDexterity = weaponDexterity;
	}
	
	// get dexterity value weapon takes/adds to character 
	public int getWeaponDexterity()
	{
		return weaponDexterity;
	}
	
	// set critical value weapon takes/adds to character 
	public void setWeaponCritical(int weaponCritical)
	{
		if(weaponCritical < -500)
		{
			weaponCritical = -500;
		}
		else if(weaponCritical > 500)
		{
			weaponCritical = 500;
		}
		
		this.weaponCritical = weaponCritical;
	}
	
	// get critical value weapon takes/adds to character 
	public int getWeaponCritical()
	{
		return weaponCritical;
	}
	
	// set accuracy value weapon takes/adds to character 
	public void setWeaponAccuracy(int weaponAccuracy)
	{
		if(weaponAccuracy < -500)
		{
			weaponAccuracy = -500;
		}
		else if(weaponAccuracy > 500)
		{
			weaponAccuracy = 500;
		}
		
		this.weaponAccuracy = weaponAccuracy;
	}
	
	// get hit chance value weapon takes/adds to character 
	public int getWeaponAccuracy()
	{
		return weaponAccuracy;
	}
	
	// set magic attack value weapon takes/adds to character 
	public void setWeaponNanoAttack(int weaponNanoAttack)
	{
		if(weaponNanoAttack < -500)
		{
			weaponNanoAttack = -500;
		}
		else if(weaponNanoAttack > 500)
		{
			weaponNanoAttack = 500;
		}
		
		this.weaponNanoAttack = weaponNanoAttack;
	}
	
	// get magic attack value weapon takes/adds to character 
	public int getWeaponNanoAttack()
	{
		return weaponNanoAttack;
	}
	
	public boolean isStatusValid(String status)
	{
		boolean validArgument = false;
		
		if(status != null)
		{
			for(String[] array : holdInflictStatus)
			{
				if(inflictStatus != null && inflictStatus.equals(array))
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
	
	// set status that weapon inflicts on enemy 
	public void setInflictStatus(String inflictStatus)
	{
		if(isStatusValid(inflictStatus) == true)
		{
			this.inflictStatus = inflictStatus;
		}
		else
		{
			this.inflictStatus = null;
		}
	}
	
	// get status that weapon inflicts on enemy  
	public String getInflictStatus()
	{
		return inflictStatus;
	}
	
	// set whether random slots are generated for a weapon
	public void setRandomSlots(boolean randomSlots)
	{
		this.randomSlots = randomSlots;
	}
	
	// return random slots option for weapons 
	public boolean getRandomSlots()
	{
		return randomSlots;
	}
	
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
			
		8 options
			1	50% Null (no slot)
			2	6	Current Hp	51-56
			3	10	defense	 	57-66
			4	6	Nano 		67-72
			5	7	Stamina 	73-79
			6	8	Dexterity 	80-87
			7	9	Nano Def 	88-96
			8	4	Any 		97-100	
			
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
	
	// randomize slot types for a weapon 
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
	
	// determine whether the supplied weapon core is valid 
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
	public void setSlotOneCore(core slotOneCore)
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
	public core getSlotOneCore()
	{
		return slotOneCore;
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
	public void setSlotTwoCore(core slotTwoCore)
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
	
	// set the type for weapon slot two 
	public core getSlotTwoCore()
	{
		return slotTwoCore;
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
	public void setSlotThreeCore(core slotThreeCore)
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
	
	// set the type for weapon slot three 
	public core getSlotThreeCore()
	{
		return slotThreeCore;
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
	public void setSlotFourCore(core slotFourCore)
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
	
	// set the type for weapon slot four 
	public core getSlotFourCore()
	{
		return slotFourCore;
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
	public void setSlotFiveCore(core slotFiveCore)
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
	
	// set the type for weapon slot five 
	public core getSlotFiveCore()
	{
		return slotFiveCore;
	}
}
