/* 
	public class characterAttributesDefined implements interface contract
	characterAttributes & defines methods within characterAttributes 
*/

public class characterAttributesDefined implements characterAttributes
{
	// declare instance variables as private 
	private String name; 			// name 
	private int level;				// current level
	private int experience;			// experience total
	private int maxHP; 				// max hit points 
	private int currentHP;			// current hit points 
	private int attack;				// attack stat 
	private int defense;			// defense stat 
	private int magic;				// magic stat 
	private int stamina;			// stamina stat 
	private int dexterity;			// agility stat 
	private int critical;			// critical stat 
	private int hitChance;			// hit chance
	private int magicAttack;		// magic attack stat 
	private int magicDefense;		// magic defense stat 
	private int evasion;			// evasion stat 
	private int magicEvasion;		// magic evasion stat 
	private int luck;				// luck stat (hidden special stat)
	private int fireResistance;		// resist fire attacks
	private int waterResistance;	// resist water attacks
	private int iceResistance;		// resist ice attacks
	private int lightningResistance;// resist lightning attacks
	private int poisonResistance;	// resist poison attacks
	private int sonicResistance;	// resist sonic (sound-based) attacks
	private int energyResistance;	// resist energy (laser-based) attacks
	private int nanoResistance;		// resist nano (nanomachine-based) attacks
	
	public characterAttributesDefined(String name, int level, int experience,
		int maxHP, int currentHP, int attack, int defense, int magic, 
		int stamina, int dexterity, int critical, int hitChance, 
		int magicAttack, int magicDefense, int evasion, int magicEvasion, 
		int luck, int fireResistance, int waterResistance, int iceResistance, 
		int lightningResistance, int poisonResistance, int sonicResistance, 
		int energyResistance, int nanoResistance)
	{
		this.name = name;
		this.level = level;
		this.experience = experience;
		this.maxHP = maxHP;
		this.currentHP = currentHP;
		this.attack = attack;
		this.defense = defense;
		this.magic = magic;
		this.stamina = stamina;
		this.dexterity = dexterity;
		this.critical = critical;
		this.hitChance = hitChance;
		this.magicAttack = magicAttack;
		this.magicDefense = magicDefense;
		this.evasion = evasion;
		this.magicEvasion = magicEvasion;
		this.luck = luck;
		this.fireResistance = fireResistance;
		this.waterResistance = waterResistance;
		this.iceResistance = iceResistance;
		this.lightningResistance = lightningResistance;
		this.poisonResistance = poisonResistance;
		this.sonicResistance = sonicResistance;
		this.energyResistance = energyResistance;
		this.nanoResistance = nanoResistance; 
	}
	
	// method sets character's first name and last name 
	public void setName(String firstLastName)
	{
		name = firstLastName; 
	}
	
	// method retrieves character's first name and last name 
	public String getName()
	{
		return name; 
	} 
	
	// method sets max hit points
	public void setMaxHP(int maxHP) 
	{
		this.maxHP = maxHP; 
		
		if(maxHP < 0) 
		{
			maxHP = 0;
		}
		
		if(maxHP > 999)
		{
			maxHP = 999;
		}
	} 
	
	// method retrieves max hit points 
	public int getMaxHP()
	{
		return maxHP; 
	} 
	
	// method sets current hit points
	public void setCurrentHP( int currentHP )  
	{
		this.currentHP = currentHP;
		
		if(currentHP < 0) 
		{
			currentHP = 0; 
		}
		
		if(currentHP > maxHP) 
		{
			currentHP = maxHP; 
		}
	} 
	
	// method retrieves current hit points 
	public int getCurrentHP()
	{
		return currentHP; 
	} 
	
	// method sets character level 
	public void setLevel(int level)
	{
		this.level = level;
		
		if (level < 0) 
		{
			level = 0; 
		}
		else if(level > 99)
		{
			level = 99;
		}
	}
	
	// method retrieves character level
	public int getLevel()
	{
		return level; 
	} 
	
	// method sets character experience total
	public void setExperience(int experience)
	{
		this.experience = experience;
		
		if (experience < 0) 
		{
			experience = 0; 
		}
		else if(experience > 99999999)
		{
			experience = 99999999;
		}
	}
	
	// method retrieves character experience total
	public int getExperience()
	{
		return experience; 
	} 
	
	// method sets character attack stat 
	public void setAttack(int attack)
	{
		this.attack = attack;
		
		if(attack < 0) 
		{
			attack = 0; 
		}
		else if(attack > 999)
		{
			attack = 999;
		}
	}
	
	// method retrieves character attack stat 
	public int getAttack()
	{
		return attack; 
	} 
	
	// method sets character defense stat 
	public void setDefense(int defense)
	{
		this.defense = defense;
		
		if (defense < 0) 
		{
			defense = 0; 
		}
		else if(defense > 999)
		{
			defense = 999;
		}
	}
	
	// method retrieves character defense stat 
	public int getDefense()
	{
		return defense; 
	} 
	
	// method sets character magic stat 
	public void setMagic(int magic)
	{
		this.magic = magic;
		
		if (magic < 0) 
		{
			magic = 0; 
		}
		else if(magic > 999)
		{
			magic = 999;
		}
	}
	
	// method retrieves character stamina stat 
	public int getMagic()
	{
		return magic; 
	} 
	
	// method sets character stamina stat 
	public void setStamina(int stamina)
	{
		this.stamina = stamina;
		
		if (stamina < 0) 
		{
			stamina = 0; 
		}
		else if(stamina > 999)
		{
			stamina = 999;
		}
	}
	
	// method retrieves character stamina stat 
	public int getStamina()
	{
		return stamina; 
	} 
	
	// method sets character dexterity stat 
	public void setDexterity(int dexterity)
	{
		this.dexterity = dexterity;
		
		if (dexterity < 0) 
		{
			dexterity = 0; 
		}
		else if(dexterity > 999)
		{
			dexterity = 999;
		}
	}
	
	// method retrieves character dexterity stat 
	public int getDexterity()
	{
		return dexterity; 
	} 
	
	// method sets character critical stat 
	public void setCritical(int critical)
	{
		this.critical = critical;
		
		if (critical < 0) 
		{
			critical = 0; 
		}
		else if(critical > 999)
		{
			critical = 999;
		}
	}
	
	// method retrieves character critical stat 
	public int getCritical()
	{
		return critical; 
	} 
	
	// method sets character attack hit chance
	public void setHitChance(int hitChance)
	{
		this.hitChance = hitChance;
		
		if(hitChance < 0) 
		{
			hitChance = 0; 
		}
		else if(hitChance > 999)
		{
			hitChance = 999;
		}
	}
	
	// method retrieves character attack hit chance
	public int getHitChance()
	{
		return hitChance; 
	} 
	
	// method sets character magic attack stat 
	public void setMagicAttack(int magicAttack)
	{
		this.magicAttack = magicAttack;
		
		if (magicAttack < 0) 
		{
			magicAttack = 0; 
		}
		else if(magicAttack > 999)
		{
			magicAttack = 999;
		}
	}
	
	// method retrieves character magic attack stat 
	public int getMagicAttack()
	{
		return magicAttack; 
	} 
	
	// method sets character magic defense stat 
	public void setMagicDefense(int magicDefense)
	{
		this.magicDefense = magicDefense;
		
		if (magicDefense < 0) 
		{
			magicDefense = 0; 
		}
		else if(magicDefense > 999)
		{
			magicDefense = 999;
		}
	}
	
	// method retrieves character magic defense stat 
	public int getMagicDefense()
	{
		return magicDefense; 
	} 
	
	// method sets character evasion stat 
	public void setEvasion(int evasion)
	{
		this.evasion = evasion;
		
		if (evasion < 0) 
		{
			evasion = 0; 
		}
		else if(evasion > 999)
		{
			evasion = 999;
		}
	}
	
	// method retrieves character evasion stat 
	public int getEvasion()
	{
		return evasion; 
	} 
	
	// method sets character magic evasion stat 
	public void setMagicEvasion(int magicEvasion)
	{
		this.magicEvasion = magicEvasion;
		
		if (magicEvasion < 0) 
		{
			magicEvasion = 0; 
		}
		else if(magicEvasion > 999)
		{
			magicEvasion = 999;
		}
	}
	
	// method retrieves character magic evasion stat 
	public int getMagicEvasion()
	{
		return magicEvasion; 
	} 
	
	// method sets character luck stat 
	public void setLuck(int luck)
	{
		this.luck = luck;
		
		if (luck < 0) 
		{
			luck = 0; 
		}
		else if(luck > 99)
		{
			luck = 99;
		}
	}
	
	// method retrieves character luck stat 
	public int getLuck()
	{
		return luck; 
	} 
	
	// method to set fire resistance
	public void setFireResistance(int fireResistance)
	{
		this.fireResistance = fireResistance;
		
		if (fireResistance < -100) 
		{
			fireResistance = -100; 
		}
		else if(fireResistance > 100)
		{
			fireResistance = 100;
		}
	}
	
	// method to get fire resistance 
	public int getFireResistance()
	{
		return fireResistance;
	}
	
	// method to set water resistance
	public void setWaterResistance(int waterResistance)
	{
		this.waterResistance = waterResistance;
		
		if (waterResistance < -100) 
		{
			waterResistance = -100; 
		}
		else if(waterResistance > 100)
		{
			waterResistance = 100;
		}
	}
	
	// method to get water resistance
	public int getWaterResistance()
	{
		return waterResistance;
	}
	
	// method to set ice resistance
	public void setIceResistance(int iceResistance)
	{
		this.iceResistance = iceResistance;
		
		if (iceResistance < -100) 
		{
			iceResistance = -100; 
		}
		else if(iceResistance > 100)
		{
			iceResistance = 100;
		}
	}
	
	// method to get ice resistance
	public int getIceResistance()
	{
		return iceResistance;
	}
	
	// method to set lightning resistance
	public void setLightningResistance(int lightningResistance)
	{
		this.lightningResistance = lightningResistance;
		
		if (lightningResistance < -100) 
		{
			lightningResistance = -100; 
		}
		else if(lightningResistance > 100)
		{
			lightningResistance = 100;
		}
	}
	
	// method to get lightning resistance
	public int getLightningResistance()
	{
		return lightningResistance;
	}
	
	// method to set poison resistance
	public void setPoisonResistance(int poisonResistance)
	{
		this.poisonResistance = poisonResistance;
		
		if (poisonResistance < -100) 
		{
			poisonResistance = -100; 
		}
		else if(poisonResistance > 100)
		{
			poisonResistance = 100;
		}
	}
	
	// method to get poison resistance
	public int getPoisonResistance()
	{
		return poisonResistance;
	}
	
	// method to set sonic resistance
	public void setSonicResistance(int sonicResistance)
	{
		this.sonicResistance = sonicResistance;
		
		if (sonicResistance < -100) 
		{
			sonicResistance = -100; 
		}
		else if(sonicResistance > 100)
		{
			sonicResistance = 100;
		}
	}
	
	// method to get sonic resistance
	public int getSonicResistance()
	{
		return sonicResistance;
	}
	
	// method to set energy resistance
	public void setEnergyResistance(int energyResistance)
	{
		this.energyResistance = energyResistance;
		
		if (energyResistance < -100) 
		{
			energyResistance = -100; 
		}
		else if(energyResistance > 100)
		{
			energyResistance = 100;
		}
	}
	
	// method to get energy resistance
	public int getEnergyResistance()
	{
		return energyResistance;
	}
	
	// method to set nano resistance
	public void setNanoResistance(int nanoResistance)
	{
		this.nanoResistance = nanoResistance;
		
		if (nanoResistance < -100) 
		{
			nanoResistance = -100; 
		}
		else if(nanoResistance > 100)
		{
			nanoResistance = 100;
		}
	}
	
	// method to get nano resistance
	public int getNanoResistance()
	{
		return nanoResistance;
	}
}