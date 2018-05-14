/* 
	public class character extends public class characterAttributesDefined. It defines 
	methods essential for creating a playable character or a character that the player 
	is meant to control in the game such as allowing players to equip characters with
	outfits like weapons, armors, and accessories. 
*/

public class characters extends genericCharacter
{
	// make method for "rank" or "title" which makes them immune to certain things or 
	// have certain moves/move sets
	
	// remove() methods to return item to inventory should be equip menu functionality
	
	private int experience;					// experience total for the character 
	private int expScale;					// sets scale for exp growth per level 
	
	// instance variables store outfits or objects equipped to a character
	private weapons weapon;					// weapon that a character can wield
	private armors bodyArmor; 				// armor that covers the body 
	private armors legArmor; 				// armor that covers the legs (pants, ect.)
	private armors footArmor; 				// armor that covers feet (shoes, boots, ect.)
	private accessories accessoryOne; 		// accessory slot one  
	private accessories accessoryTwo;		// accessory slot two 
	
	// variable stores integer value tied to attribute of an object that can be equipped
	private int holdEquipValue = 0;
	
	// instance variables represent choices that can be made in method effectOnGauges()
	private final int one = 1; 				
	private final int two = 2; 				 
	private final int three = 3; 			
	private final int four = 4; 				
	private final int five = 5; 				 
	private final int six = 6; 				
	
	// instance variables refer to the total value for an attribute or resistance with 
	// weapons/armors/accessories taken into account when applicable along with the 
	// attribute/resistance value of the character object 
	
	private int maxHpWithOutfits; 				// max hit points with armor and accessory max hp applied
	private int currentHp;						// current hit points 
	private int maxNanoWithOutfits; 			// max nano attributes with weapon, armor and accessory applied
	private int currentNano;					// nanomachine attributes 
	private int maxStaminaWithOutfits;			// max stamina attributes with armor and accessory applied
	private int currentStamina;					// stamina attributes
	private int attackWithOutfits;				// attack attributes with weapon and accessory attack applied
	private int defenseWithOutfits;				// defense attributes with armor and accessory defense applied 
	private int dexterityWithOutfits;			// dexterity attributes wth weapon, armor, and accessory applied 
	private int criticalWithOutfits;			// critical attributes with weapon and accessory applied 
	private int accuracyWithOutfits;			// accuracy attributes with weapon and accessory applied 
	private int nanoAttackWithOutfits;			// nano attack attributes with weapon and accessory applied 
	private int nanoDefenseWithOutfits;			// nano defense attributes with armor and accessory applied 
	
	// character resistance and the armor effect are applied only 
	private int fireResistanceWithOutfits;			// fire resistance with armor applied 
	private int waterResistanceWithOutfits;			// water resistance with armor applied 
	private int iceResistanceWithOutfits;			// ice resistance with armor applied 
	private int electricityResistanceWithOutfits;	// electricity resistance with armor applied 
	private int poisonResistanceWithOutfits;		// poison resistance with armor applied 
	private int sonicResistanceWithOutfits;			// sonic resistance with armor applied 
	private int plasmaResistanceWithOutfits;		// plasma resistance with armor applied 
	private int windResistanceWithOutfits;			// wind resistance with armor applied 
	
	// constructor takes no arguments and calls empty superclass constructor 
	public characters()
	{
		super();
	}
	
	
	
	
	
	
	// START: CHARACTER LEVELING  
	/*******************************************************************************/
	
	// method sets character's total experience
	public void setExperience(int experience)
	{
		if (experience < 0) 
		{
			experience = 0; 
		}
		else if(experience > 32000000)
		{
			experience = 32000000;
		}
		
		this.experience = experience;
	}
	
	// method gets character's total experience
	public int getExperience()
	{
		return experience; 
	} 
	
	// method sets exp scale which determines exp growth rate for character per level 
	public void setExpScale(int expScale)
	{
		if(expScale % 33 == 0 && expScale <= 256)
		{
			if(expScale < 0)
			{
				expScale = 0;
			}
			else if(expScale > 264)
			{
				expScale = 264;
			}
		}
		else
		{
			expScale = 264;
		}
		
		this.expScale = expScale; 
	}
	
	// method gets exp scale for character 
	public int getExpScale()
	{
		return expScale; 
	} 
	
	// END: CHARACTER LEVELING  
	/*******************************************************************************/
	
	
	
	
	
	
	// START: CHARACTER OUTFITS
	/*******************************************************************************/
	
	// method sets character's weapon 
	public void setWeapon(weapons weapon)
	{
		if(weapon != null)
		{
			this.weapon = weapon; 
		}
	}
	
	// method gets character's weapon
	public weapons getWeapon()
	{
		return weapon; 
	} 
	
	// method sets character's body armor 
	public void setBodyArmor(armors bodyArmor)
	{
		if(bodyArmor != null)
		{
			if(bodyArmor.getCategory().equals("Body Armor"))
			{
				this.bodyArmor = bodyArmor; 
			}
		}
	}
	
	// method gets character's body armor 
	public armors getBodyArmor()
	{
		return bodyArmor; 
	} 
	
	// method sets character's leg armor 
	public void setLegArmor(armors legArmor)
	{
		if(legArmor != null)
		{
			if(legArmor.getCategory().equals("Leg Armor"))
			{
				this.legArmor = legArmor; 
			}
		}
	}
	
	// method gets character's body armor 
	public armors getLegArmor()
	{
		return legArmor; 
	} 
	
	// method sets character's body armor 
	public void setFootArmor(armors footArmor)
	{
		if(footArmor != null)
		{
			if(footArmor.getCategory().equals("Foot Armor"))
			{
				this.footArmor = footArmor; 
			}
		}
	}
	
	// method gets character's body armor 
	public armors getFootArmor()
	{
		return footArmor; 
	} 
	
	// method sets character's first accessory 
	public void setAccessoryOne(accessories accessoryOne)
	{
		if(accessoryOne != null)
		{
			this.accessoryOne = accessoryOne; 
		}
	}
	
	// method gets character's first accessory
	public accessories getAccessoryOne()
	{
		return accessoryOne; 
	} 
	
	// method sets character's second accessory 
	public void setAccessoryTwo(accessories accessoryTwo)
	{
		if(accessoryTwo != null)
		{
			this.accessoryTwo = accessoryTwo; 
		}
	}
	
	// method gets character's second accessory
	public accessories getAccessoryTwo()
	{
		return accessoryTwo; 
	} 
	
	// return array containing armors character has equipped
	public armors[] getCharacterArmors()
	{
		armors[] characterArmors = {getBodyArmor(), getLegArmor(), getFootArmor()};
			return characterArmors;
	}
	
	// return array containing accessories character has equipped
	public accessories[] getCharacterAccessories()
	{
		accessories[] characterAccessories = {getAccessoryOne(), getAccessoryTwo()};
			return characterAccessories;
	}
	
	// END: CHARACTER OUTFITS
	/*******************************************************************************/

	
	
	/* "WithOutfits" methods return sum of an attribute/resistance by adding together the 
	   character's attribute/resistance and weapon/armor/accessory effect on said attribute
	   where applicable along with the effect provided by the cores equipped on them */ 
	
	// add checks for attribute/resistance by "checking" them being they are returned 
	
	
	
	// START: CALCULATING IMPACT OF CHARACTER OUTFITS ON CHARACTER
	/*******************************************************************************/
	
		// method returns the effect armors and accessories have on a gauge like hp, nano, or stamina
	public int armorAccessoryEffect(int choice, int gauge)
	{
		// enhanced for loop adds effect of armor (if armor is equipped) to a certain gauge
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				gauge += armorAccessorySwitch(choice, element);
			}
		}
		
		// enhanced for loop adds effect of accessory (if accessory is equipped) to a certain gauge
		for(accessories element : getCharacterAccessories())
		{
			if(element != null)
			{
				gauge += armorAccessorySwitch(choice, element);
			}
		}
		
		// return gauge after adding effect outfits had on gauge 
		return gauge;
	}
	
	// overloaded method returns desired value from equipped armors 
	public int armorAccessorySwitch(int choice, armors object)
	{		
		// switch returns a value tied to armor object based on choice value 
		switch(choice)
		{
			case 1:
				holdEquipValue = object.getTotalMaxHp();
					break;
			case 2:
				holdEquipValue = object.getTotalNano();
					break;
			case 3:
				holdEquipValue = object.getTotalStamina();
					break;
			case 4:
				holdEquipValue = object.getTotalDefense();
					break;
			case 5:
				holdEquipValue = object.getTotalDexterity();
					break;
			case 6:
				holdEquipValue = object.getTotalNanoDefense();
					break;
		}
		
		// return the value stored in variable holdEquipValue
		return holdEquipValue;
	}
	
	// overloaded method return desired value from equipped accessories 
	public int armorAccessorySwitch(int choice, accessories object)
	{		
		// switch returns a value tied to accessory object based on choice value 
		switch(choice)
		{
			case 1:
				holdEquipValue = object.getTotalMaxHp();
					break;
			case 2:
				holdEquipValue = object.getTotalNano();
					break;
			case 3:
				holdEquipValue = object.getTotalStamina();
					break;
			case 4:
				holdEquipValue = object.getTotalDefense();
					break;
			case 5:
				holdEquipValue = object.getTotalDexterity();
					break;
			case 6:
				holdEquipValue = object.getTotalNanoDefense();
					break;
		}
		
		// return the value stored in variable holdEquipValue
		return holdEquipValue;
	}
	
		// method returns the effect armors and accessories have on a attribute 
	public int effectOnAttributes(int choice, int attribute)
	{
		// add total critical of weapon (if weapon is equipped) to instance variable 
		if(weapon != null)
		{
			attribute += weaponAccessorySwitch(choice, weapon);
		}
		
		// enhanced for loop adds effect of accessory (if accessory is equipped) to a certain gauge
		for(accessories element : getCharacterAccessories())
		{
			if(element != null)
			{
				attribute += weaponAccessorySwitch(choice, element);
			}
		}
		
		// return attribute after adding effect outfits had on attribute 
		return attribute;
	}
	
	// overloaded method returns desired value from equipped armors 
	public int weaponAccessorySwitch(int choice, weapons object)
	{		
		// switch returns a value tied to armor object based on choice value 
		switch(choice)
		{
			case 1:
				holdEquipValue = object.getTotalAttack();
					break;
			case 2:
				holdEquipValue = object.getTotalCritical();
					break;
			case 3:
				holdEquipValue = object.getTotalAccuracy();
					break;
			case 4:
				holdEquipValue = object.getTotalNanoAttack();
					break;
		}
		
		// return the value stored in variable holdEquipValue
		return holdEquipValue;
	}
	
	// overloaded method return desired value from equipped accessories 
	public int weaponAccessorySwitch(int choice, accessories object)
	{		
		// switch returns a value tied to accessory object based on choice value 
		switch(choice)
		{
			case 1:
				holdEquipValue = object.getTotalAttack();
					break;
			case 2:
				holdEquipValue = object.getTotalCritical();
					break;
			case 3:
				holdEquipValue = object.getTotalAccuracy();
					break;
			case 4:
				holdEquipValue = object.getTotalNanoAttack();
					break;
		}
		
		// return the value stored in variable holdEquipValue
		return holdEquipValue;
	}	
	
	// method returns the effect that all outfits have on specific attributes
	public int allOutfitsEffect(int choice, int attribute)
	{
		// add total nano of weapon (if weapon is equipped) to instance variable 
		if(weapon != null)
		{
			attribute += allOutfitsSwitch(choice, weapon);;
		}
		
		// enhanced for loop adds effect of armor (if armor is equipped) to a certain gauge
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				attribute += allOutfitsSwitch(choice, element);
			}
		}
		
		// enhanced for loop adds effect of accessory (if accessory is equipped) to a certain gauge
		for(accessories element : getCharacterAccessories())
		{
			if(element != null)
			{
				attribute += allOutfitsSwitch(choice, element);
			}
		}
		
		// return attribute after adding effect all outfits had on attribute 
		return attribute;
	}
	
	// overloaded method returns desired value from equipped weapon 
	public int allOutfitsSwitch(int choice, weapons object)
	{		
		// switch returns a value tied to weapon object based on choice value 
		switch(choice)
		{
			case 1:
				holdEquipValue = object.getTotalNano();
					break;
			case 2:
				holdEquipValue = object.getTotalDexterity();
					break;
		}
		
		// return the value stored in variable holdEquipValue
		return holdEquipValue;
	}
	
	// overloaded method returns desired value from equipped armors 
	public int allOutfitsSwitch(int choice, armors object)
	{		
		// switch returns a value tied to armor object based on choice value 
		switch(choice)
		{
			case 1:
				holdEquipValue = object.getTotalNano();
					break;
			case 2:
				holdEquipValue = object.getTotalDexterity();
					break;
		}
		
		// return the value stored in variable holdEquipValue
		return holdEquipValue;
	}
	
	// overloaded method returns desired value from equipped accessories 
	public int allOutfitsSwitch(int choice, accessories object)
	{		
		// switch returns a value tied to accessory object based on choice value 
		switch(choice)
		{
			case 1:
				holdEquipValue = object.getTotalNano();
					break;
			case 2:
				holdEquipValue = object.getTotalDexterity();
					break;
		}
		
		// return the value stored in variable holdEquipValue
		return holdEquipValue;
	}	
	
	// END: CALCULATING IMPACT OF CHARACTER OUTFITS ON CHARACTER
	/*******************************************************************************/
	
	
	
	
	
	
	// START: CHARACTER GAUGES WITH OUTFITS
	/*******************************************************************************/
	
	// method ensures that values passed for max gauge is within a valid range
	public int validateWithOutfits(int gauge)
	{
		if(gauge < 0)
		{
			gauge = 0;
		}
		else if(gauge > 9999)
		{
			gauge = 9999;
		}
		
		return gauge;
	}	
	
	// method adjusts gauges for hp, nano, and stamina after an outfit is equipped/removed
	public int adjustGauge(int current, int max)
	{
		if(current > max)
		{
			current = max;
		}
		
		return current;
	}
	
	// method returns max hp for character which may have changed due to outfits 
	public int getMaxHpWithOutfits()
	{
		// assign instance variable maxHpWithOutfits with max hp of character 
		maxHpWithOutfits = getMaxHp();
		
		// assign instance variable with sum of armor and accessory effects for max hp
		maxHpWithOutfits += armorAccessoryEffect(one, maxHpWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(maxHpWithOutfits);
	}
	
	@Override
	// method overrides superclass method setCurrentHp()
	// method accepts values from range of 0 to the value specified by getMaxHpWithOutfits()
	// and this check must be performed each time current hp is set since the outfits
	// worn by a character can change max hp depending on player actions 
	public void setCurrentHp(int currentHp)
	{
		// assign instance variable with value validated using superclass method validateCurrentGauges()
		this.currentHp = validateCurrentGauges(currentHp, getMaxHpWithOutfits());
	}
	
	// method adjusts current hp when armor/accessory that affects max hp is removed
	public void adjustCurrentHp()
	{
		// instance variable is assigned value from method adjustGauge()
		currentHp = adjustGauge(currentHp, getMaxHpWithOutfits());
	}
	
	// method returns max nano for character which may have changed due to outfits 
	public int getMaxNanoWithOutfits()
	{
		// assign instance variable maxNanoWithOutfits with nano of character 
		maxNanoWithOutfits = getMaxNano();
		
		// assign instance variable with sum of all outfit effect effects for nano
		maxNanoWithOutfits += allOutfitsEffect(one, maxNanoWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(maxNanoWithOutfits);
	}
	
	@Override
	// method overrides superclass method setCurrentNano()
	// method accepts values from range of 0 to the value specified by getMaxNanoWithOutfits()
	// and this check must be performed each time current nano is set since the outfits
	// worn by a character can change max nano depending on player actions 
	public void setCurrentNano(int currentNano)
	{
		// assign instance variable with value validated using superclass method validateCurrentGauges()
		this.currentNano = validateCurrentGauges(currentNano, getMaxNanoWithOutfits());
	}
	
	// method adjusts current nano when armor/accessory that affects max nano is removed
	public void adjustCurrentNano()
	{
		// instance variable is assigned value from method adjustGauge()
		currentNano = adjustGauge(currentNano, getMaxNanoWithOutfits());
	}
	
	// method returns max stamina for character which may have changed due to outfits 
	public int getMaxStaminaWithOutfits()
	{
		// assign instance variable maxStaminaWithOutfits with stamina of character 
		maxStaminaWithOutfits = getMaxStamina();
		
		// assign instance variable with sum of armor and accessory effects for stamina
		maxStaminaWithOutfits += armorAccessoryEffect(three, maxStaminaWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(maxStaminaWithOutfits);
	}
	
	@Override
	// method overrides superclass method setCurrentStamina()
	// method accepts values from range of 0 to the value specified by getMaxStaminaWithOutfits()
	// and this check must be performed each time current stamina is set since the outfits
	// worn by a character can change max stamina depending on player actions 
	public void setCurrentStamina(int currentStamina)
	{
		// assign instance variable with value validated using superclass method validateCurrentGauges()
		this.currentStamina = validateCurrentGauges(currentStamina, getMaxHpWithOutfits());
	}
	
	// method adjusts current stamina when armor/accessory that affects max stamina is removed
	public void adjustCurrentStamina()
	{
		// instance variable is assigned value from method adjustGauge()
		currentStamina = adjustGauge(currentStamina, getMaxStaminaWithOutfits());
	}
	
	// END: CHARACTER GAUGES WITH OUTFITS
	/*******************************************************************************/

	
	
	
	
	
	// START: CHARACTER ATTRIBUTES WITH OUTFITS
	/*******************************************************************************/
	
	// method returns attack for character which may have changed due to outfits 
	public int getAttackWithOutfits()
	{
		// assign instance variable attackWithOutfits with attack of character 
		attackWithOutfits = getAttack();
		
		// assign instance variable with sum of weapon and accessory effects for attack
		attackWithOutfits += effectOnAttributes(one, attackWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(attackWithOutfits);
	}
	
	// method returns defense for character which may have changed due to outfits 
	public int getDefenseWithOutfits()
	{
		// assign instance variable defenseWithOutfits with defense of character 
		defenseWithOutfits = getDefense();
		
		// assign instance variable with sum of armor and accessory effects for defense
		defenseWithOutfits += armorAccessoryEffect(four, defenseWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(defenseWithOutfits);
	}
	
	// method returns dexterity for character which may have changed due to outfits 
	public int getDexterityWithOutfits()
	{
		// assign instance variable dexterityWithOutfits with dexterity of character 
		dexterityWithOutfits = getDexterity();
		
		// assign instance variable with sum of all outfit effect effects for dexterity
		dexterityWithOutfits += allOutfitsEffect(two, dexterityWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(dexterityWithOutfits);
	}
	
	// method returns critical for character which may have changed due to outfits 
	public int getCriticalWithOutfits()
	{
		// assign instance variable criticalWithOutfits with critical of character 
		criticalWithOutfits = getCritical();
		
		// assign instance variable with sum of weapon and accessory effects for critical
		criticalWithOutfits += effectOnAttributes(two, criticalWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(criticalWithOutfits);
	}
	
	// method returns accuracy for character which may have changed due to outfits 
	public int getAccuracyWithOutfits()
	{
		// assign instance variable accuracyWithOutfits with accuracy of character 
		accuracyWithOutfits = getAccuracy();
		
		// assign instance variable with sum of weapon and accessory effects for critical
		accuracyWithOutfits += effectOnAttributes(three, accuracyWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(accuracyWithOutfits);
	}
	
	// method returns nano attack for character which may have changed due to outfits 
	public int getNanoAttackWithOutfits()
	{
		// assign instance variable nanoAttackWithOutfits with nano attack of character 
		nanoAttackWithOutfits = getNanoAttack();
		
		// assign instance variable with sum of weapon and accessory effects for critical
		nanoAttackWithOutfits += effectOnAttributes(four, nanoAttackWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(nanoAttackWithOutfits);
	}
	
	// method returns nano defense for character which may have changed due to outfits 
	public int getNanoDefenseWithOutfits()
	{
		// assign instance variable nanoDefenseWithOutfits with nano defense of character 
		nanoDefenseWithOutfits = getNanoDefense();
		
		// assign instance variable with sum of armor and accessory effects for nano defense
		nanoDefenseWithOutfits += armorAccessoryEffect(five, nanoDefenseWithOutfits);
		
		// return instance variable after it has been checked 
		return validateWithOutfits(nanoDefenseWithOutfits);
	}

	// END: CHARACTER ATTRIBUTES WITH OUTFITS
	/*******************************************************************************/

	
	
	
	
	
	// START: CHARACTER RESISTANCES WITH OUTFITS 
	/*******************************************************************************/
	
	// method returns fire resistance for character which may have changed due to outfits 
	public int getFireResistanceWithOutfits()
	{
		// assign instance variable fireResistanceWithOutfits with fire resistance of character 
		fireResistanceWithOutfits = getFireResistance();
		
		// enhanced for loop adds total fire resistance effect of armor (if armor is 
		// equipped) to instance variable 
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				fireResistanceWithOutfits += element.getTotalFireResistance();
			}
		}
		
		// return instance variable after it has been checked 
		return validateResistance(fireResistanceWithOutfits);
	}
	
	// method returns water resistance for character which may have changed due to outfits 
	public int getWaterResistanceWithOutfits()
	{
		// assign instance variable waterResistanceWithOutfits with water resistance of character 
		waterResistanceWithOutfits = getWaterResistance();
		
		// enhanced for loop adds total water resistance effect of armor (if armor is 
		// equipped) to instance variable 
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				waterResistanceWithOutfits += element.getTotalWaterResistance();
			}
		}
		
		// return instance variable after it has been checked 
		return validateResistance(waterResistanceWithOutfits);
	}
	
	// method returns ice resistance for character which may have changed due to outfits 
	public int getIceResistanceWithOutfits()
	{
		// assign instance variable iceResistanceWithOutfits with ice resistance of character 
		iceResistanceWithOutfits = getIceResistance();
		
		// enhanced for loop adds total ice resistance effect of armor (if armor is 
		// equipped) to instance variable 
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				iceResistanceWithOutfits += element.getTotalIceResistance();
			}
		}
		
		// return instance variable after it has been checked 
		return validateResistance(iceResistanceWithOutfits);
	}
	
	// method returns electricity resistance for character which may have changed due to outfits 
	public int getElectricityResistanceWithOutfits()
	{
		// assign instance variable electricityResistanceWithOutfits with electricity resistance of character 
		electricityResistanceWithOutfits = getElectricityResistance();
		
		// enhanced for loop adds total electricity resistance effect of armor (if armor is 
		// equipped) to instance variable 
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				electricityResistanceWithOutfits += element.getTotalElectricityResistance();
			}
		}
		
		// return instance variable after it has been checked 
		return validateResistance(electricityResistanceWithOutfits);
	}
	
	// method returns poison resistance for character which may have changed due to outfits 
	public int getPoisonResistanceWithOutfits()
	{
		// assign instance variable poisonResistanceWithOutfits with poison resistance of character 
		poisonResistanceWithOutfits = getPoisonResistance();
		
		// enhanced for loop adds total poison resistance effect of armor (if armor is 
		// equipped) to instance variable 
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				poisonResistanceWithOutfits += element.getTotalPoisonResistance();
			}
		}
		
		// return instance variable after it has been checked 
		return validateResistance(poisonResistanceWithOutfits);
	}
	
	// method returns sonic resistance for character which may have changed due to outfits 
	public int getSonicResistanceWithOutfits()
	{
		// assign instance variable sonicResistanceWithOutfits with sonic resistance of character 
		sonicResistanceWithOutfits = getSonicResistance();
		
		// enhanced for loop adds total sonic resistance effect of armor (if armor is 
		// equipped) to instance variable 
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				poisonResistanceWithOutfits += element.getTotalSonicResistance();
			}
		}
		
		// return instance variable after it has been checked 
		return validateResistance(sonicResistanceWithOutfits);
	}
	
	// method returns plasma resistance for character which may have changed due to outfits 
	public int getPlasmaResistanceWithOutfits()
	{
		// assign instance variable plasmaResistanceWithOutfits with plasma resistance of character 
		plasmaResistanceWithOutfits = getPlasmaResistance();
		
		// enhanced for loop adds total plasma resistance effect of armor (if armor is 
		// equipped) to instance variable 
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				plasmaResistanceWithOutfits += element.getTotalPlasmaResistance();
			}
		}
		
		// return instance variable after it has been checked 
		return validateResistance(plasmaResistanceWithOutfits);
	}
	
	// method returns wind resistance for character which may have changed due to outfits 
	public int getWindResistanceWithOutfits()
	{
		// assign instance variable windResistanceWithOutfits with wind resistance of character 
		windResistanceWithOutfits = getWindResistance();
		
		// enhanced for loop adds total wind resistance effect of armor (if armor is 
		// equipped) to instance variable 
		for(armors element : getCharacterArmors())
		{
			if(element != null)
			{
				windResistanceWithOutfits += element.getTotalWindResistance();
			}
		}
		
		// return instance variable after it has been checked 
		return validateResistance(windResistanceWithOutfits);
	}
	
	// END: CHARACTER RESISTANCES WITH OUTFITS 
	/*******************************************************************************/
}