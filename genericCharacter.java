/* 
	public class characterAttributesDefined implements interface characterComponents 
	and defines the methods within it. Additional methods may need to be added later 
	on depending on whether all subclasses mus have access to them. Methods/objects
	within characterAttributesDefined can be used in subclasses only if they extend 
	the functionality of this class. 
*/

public class genericCharacter implements characterComponents
{
	private String title;				// title or "rank" that belongs to a character 
	private String name; 				// name of the character (max length 26 characters)	
	private int level;					// current level of the character 
	private String type; 				// denotes what type the character is (like human, machine, vampire, ect.)
	private int maxHp; 					// max hit points (life) a character has 
	private int currentHp;				// current hit points for a character 
	private int maxNano;				// max nanomachines points character can have for special skills  
	private int currentNano;			// current nanomachine points for a character 
	private int maxStamina;				// max stamina points a player can have for physical techniques  
	private int currentStamina;			// current stamina points for a character 
	private int attack;					// attack attribute which helps determine physical damage 
	private int defense;				// defense attribute that reduces physical damage taken 
	private int dexterity;				// dexterity attribute determines evasion, turns, and attack
	private int critical;				// critical attribute concerns chance of scoring a critical hit 
	private int accuracy;				// accuracy attribute determines chance to hit (vs enemy dexterity)
	private int nanoAttack;				// nano attack attribute determines damage nano skills do 
	private int nanoDefense;			// nano defense attribute reduces damange taken from nano skills 
	private int luck;					// luck attribute (hidden special attribute)
	private int fireResistance;			// reduces damage from fire attacks and chance of getting negative fire status 
	private int waterResistance;		// reduces damage from water attacks and chance of getting negative water status 
	private int iceResistance;			// reduces damage from ice attacks and chance of getting negative ice status 
	private int electricityResistance;	// reduces damage from elecrtical attacks and chance of getting negative electrical status 
	private int poisonResistance;		// reduces damage from poison attacks and chance of getting negative poison status 
	private int sonicResistance;		// reduces damage from sonic (sound-based) attacks and chance of getting negative sonic (sound-based) status 
	private int plasmaResistance;		// reduces damage from plasma (laser-based) attacks and chance of getting negative plasma (laser-based) status 
	private int windResistance;			// reduces damage from wind attacks and chance of getting negative wind status
	
	// unique character states that cannot be removed unlike status effects 
	private boolean bulletProof;		// determines whether bullets do damage or not 
	private boolean fragmentationProof;	// determines whether fragments (from explosions) do damage or not 
	
	// create object character object can use to call methods from statusEffectContainer
	private statusEffectContainer statusEffectHolder = new statusEffectContainer(); 
	
	// create object character object can use to call method from chain 
	private chain characterChain = new chain();
	
	// superclass constructor creates objects without needing arguments which is needed
	// to create objects using java.beans pattern instead of telescope pattern 
	public genericCharacter()
	{
		// empty constructor 
	}
	
	
	
	
	
	
	// START: CHARACTER TITLE, NAME, FULL NAME, LEVEL AND TYPE
	/*******************************************************************************/
	
	// method sets character's official title
	public void setTitle(String title)
	{
		if(title != null && !title.equals(""))
		{
			if(title.length() > 16)
			{
				title = title.substring(0, 16);
			}
			
			this.title = title; 
		}
		else
		{
			this.title = "Title";
		}
	}
	
	// method retrieves character's title
	public String getTitle()
	{
		return title; 
	} 
	
	// method sets character's first name and last name 
	public void setName(String name)
	{
		if(name != null && !name.equals(""))
		{
			if(name.length() > 12)
			{
				name = name.substring(0, 12);
			}
			
			this.name = name; 
		}
		else
		{
			this.name = "Name";
		}
	}
	
	// method retrieves character's first name and last name 
	public String getName()
	{
		return name; 
	} 
	
	// concatenates and returns the title and name of the character
	public String getFullName()
	{
		return getTitle() + " " + getName(); 
	}
	
	// method sets character's level 
	public void setLevel(int level)
	{
		if (level < 0) 
		{
			level = 0; 
		}
		else if(level > 99)
		{
			level = 99;
		}
		
		this.level = level;
	}
	
	// method gets character's level
	public int getLevel()
	{
		return level; 
	} 
	
	// method sets what type the character is (like human, machine, vampire, ect.)
	public void setType(String type)
	{
		if(type != null && !type.equals(""))
		{
			if(type.length() > 12)
			{
				type = type.substring(0, 12);
			}
			
			this.type = type; 
		}
		else
		{
			this.type = "Type";
		}
	}
	
	// method gets what type the character is (like human, machine, vampire, ect.)
	public String getType()
	{
		return type; 
	} 
	
	// END: CHARACTER TITLE, NAME, FULL NAME, LEVEL AND TYPE
	/*******************************************************************************/
	
	
	
	
	
	
	// START: CHARACTER GAUGES
	/*******************************************************************************/

	// method validates value supplied as the max value for a gauge (cap at 999)
	public int validateMaxGauges(int gauge)
	{
		if(gauge < 0) 
		{
			gauge = 0;
		}
		else if(gauge > 999)
		{
			gauge = 999;
		}
		
		return gauge;
	}
	
	// method validate value of current gauge 
	public int validateCurrentGauges(int current, int max)
	{
		if(current < 0) 
		{
			current = 0;
		}
		else if(current > max)
		{
			current = max;
		}
		
		return current;
	}
	
	// method sets max hit points
	public void setMaxHp(int maxHp) 
	{
		this.maxHp = validateMaxGauges(maxHp); 
	} 
	
	// method retrieves max hit points 
	public int getMaxHp()
	{
		return maxHp; 
	} 
	
	// method sets current hit points
	public void setCurrentHp(int currentHp)  
	{
		this.currentHp = validateCurrentGauges(currentHp, maxHp);
	} 
	
	// method retrieves current hit points 
	public int getCurrentHp()
	{
		return currentHp; 
	} 
	
	// method sets max nano
	public void setMaxNano(int maxNano) 
	{
		this.maxNano = validateMaxGauges(maxNano); 
	} 
	
	// method retrieves max nano
	public int getMaxNano()
	{
		return maxNano; 
	} 
	
	// method sets current nano points
	public void setCurrentNano(int currentNano)  
	{
		this.currentNano = validateCurrentGauges(currentNano, maxNano);
	} 
	
	// method retrieves current nano points   
	public int getCurrentNano()
	{
		return currentNano; 
	} 
	
	// method sets max stamina
	public void setMaxStamina(int maxStamina) 
	{
		this.maxStamina = validateMaxGauges(maxStamina); 
	} 
	
	// method retrieves max stamina
	public int getMaxStamina()
	{
		return maxStamina; 
	} 
	
	// method sets current stamina points
	public void setCurrentStamina(int currentStamina)  
	{
		this.currentStamina = validateCurrentGauges(currentStamina, maxStamina);
	} 
	
	// method retrieves current stamina
	public int getCurrentStamina()
	{
		return currentStamina; 
	} 
	
	// START: CHARACTER GAUGES
	/*******************************************************************************/

	
	
	
	
	// START: ADDITIONAL CHARACTER ATTRIBUTES
	/*******************************************************************************/

	// method ensures that value passed to attribute is within a valid range and returns it
	public int validateAttribute(int attribute)
	{
		if(attribute < 0) 
		{
			attribute = 0; 
		}
		else if(attribute > 256)
		{
			attribute = 256;
		}
		
		return attribute;
	}
	
	// method sets character attack  
	public void setAttack(int attack)
	{
		this.attack = validateAttribute(attack);
	}
	
	// method retrieves character attack  
	public int getAttack()
	{
		return attack; 
	} 
	
	// method sets character defense  
	public void setDefense(int defense)
	{
		this.defense = validateAttribute(defense);
	}
	
	// method retrieves character defense  
	public int getDefense()
	{
		return defense; 
	} 
	
	// method sets character dexterity  
	public void setDexterity(int dexterity)
	{
		this.dexterity = validateAttribute(dexterity);
	}
	
	// method retrieves character dexterity  
	public int getDexterity()
	{
		return dexterity; 
	} 
	
	// method sets character critical  
	public void setCritical(int critical)
	{
		this.critical = validateAttribute(critical);
	}
	
	// method retrieves character critical  
	public int getCritical()
	{
		return critical; 
	} 
	
	// method sets character attack accuracy
	public void setAccuracy(int accuracy)
	{
		this.accuracy = validateAttribute(accuracy);
	}
	
	// method retrieves character attack accuracy
	public int getAccuracy()
	{
		return accuracy; 
	} 
	
	// method sets character nanomachine attack  
	public void setNanoAttack(int nanoAttack)
	{
		this.nanoAttack = validateAttribute(nanoAttack);
	}
	
	// method retrieves character nanomachine attack  
	public int getNanoAttack()
	{
		return nanoAttack; 
	} 
	
	// method sets character nanomachine defense  
	public void setNanoDefense(int nanoDefense)
	{
		this.nanoDefense = validateAttribute(nanoDefense);
	}
	
	// method retrieves character nanomachine defense  
	public int getNanoDefense()
	{
		return nanoDefense; 
	} 
	
	// method sets character luck  
	public void setLuck(int luck)
	{
		this.luck = validateAttribute(luck);
	}
	
	// method retrieves character luck  
	public int getLuck()
	{
		return luck; 
	} 
	
	// END: CHARACTER ATTRIBUTES
	/*******************************************************************************/
	
	
	
	
	
	
	// START: CHARACTER RESISTANTCES
	/*******************************************************************************/
	
	// method ensures that value passed to resistance is within a valid range and returns it
	public int validateResistance(int resistance)
	{
		if(resistance < -100) 
		{
			resistance = 0; 
		}
		else if(resistance > 100)
		{
			resistance = 100;
		}
		
		return resistance;
	}
	
	// method to set fire resistance
	public void setFireResistance(int fireResistance)
	{
		this.fireResistance = validateResistance(fireResistance);
	}
	
	// method to get fire resistance 
	public int getFireResistance()
	{
		return fireResistance;
	}
	
	// method to set water resistance
	public void setWaterResistance(int waterResistance)
	{
		this.waterResistance = validateResistance(waterResistance);
	}
	
	// method to get water resistance
	public int getWaterResistance()
	{
		return waterResistance;
	}
	
	// method to set ice resistance
	public void setIceResistance(int iceResistance)
	{
		this.iceResistance = validateResistance(iceResistance);
	}
	
	// method to get ice resistance
	public int getIceResistance()
	{
		return iceResistance;
	}
	
	// method to set electricity resistance
	public void setElectricityResistance(int electricityResistance)
	{
		this.electricityResistance = validateResistance(electricityResistance);
	}
	
	// method to get electricity resistance
	public int getElectricityResistance()
	{
		return electricityResistance;
	}
	
	// method to set poison resistance
	public void setPoisonResistance(int poisonResistance)
	{
		this.poisonResistance = validateResistance(poisonResistance);
	}
	
	// method to get poison resistance
	public int getPoisonResistance()
	{
		return poisonResistance;
	}
	
	// method to set sonic resistance
	public void setSonicResistance(int sonicResistance)
	{
		this.sonicResistance = validateResistance(sonicResistance);
	}
	
	// method to get sonic resistance
	public int getSonicResistance()
	{
		return sonicResistance;
	}
	
	// method to set plasma resistance
	public void setPlasmaResistance(int plasmaResistance)
	{
		this.plasmaResistance = validateResistance(plasmaResistance);
	}
	
	// method to get plasma (laser-base) resistance
	public int getPlasmaResistance()
	{
		return plasmaResistance;
	}
	
	// method to set wind resistance
	public void setWindResistance(int windResistance)
	{
		this.windResistance = validateResistance(windResistance);
	}
	
	// method to get wind resistance
	public int getWindResistance()
	{
		return windResistance;
	}
	
	// END: CHARACTER RESISTANTCES
	/*******************************************************************************/
	
	
	
	
	
	
	// START: UNIQUE CHARACTER STATES
	/*******************************************************************************/

	// set whether character is bullet proof (immune to bullets) or not 
	public void setBulletProof(boolean bulletProof)
	{
		this.bulletProof = bulletProof;
	}
	
	// get whether character is bullet proof or not 
	public boolean getBulletProof()
	{
		return bulletProof;
	}
	
	// set whether character is fragmentation proof (immune to explosion fragments) or not 
	public void setFragmentationProof(boolean fragmentationProof)
	{
		this.fragmentationProof = fragmentationProof;
	}
	
	// get whether character is fragmentation proof 
	public boolean getFragmentationProof()
	{
		return fragmentationProof;
	}
	
	// END: UNIQUE CHARACTER STATES
	/*******************************************************************************/
	
	
	
	
	
	
	// START: RETURN OBJECTS THAT CALL METHODS  FROM OTHER CLASSES 
	/*******************************************************************************/
	
	// return object from statusEffectContainer which allows one to call methods from it 
	public statusEffectContainer getStatusEffectGauge()
	{
		return statusEffectHolder;
	}
	
	// return object from chain which allows one to call methods from it 
	public chain getChain()
	{
		return characterChain;
	}
	
	// END: RETURN OBJECTS THAT CALL METHODS FOR CHARACTER FROM OTHER CLASSES 
	/*******************************************************************************/
}