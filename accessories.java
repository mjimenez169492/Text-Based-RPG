/*
	public class accessories extends public class genericItem & defines methods 
	related to equipable accessories which can either increase or decrease stats 
	once equipped 
	
	accessories
		rings
		necklaces
		gloves***
		capes
		shields
		head***
*/

public class accessories extends genericItem
{
	// accessory affects...
	private int experience;			// experience received 
	private int maxHP;				// maxHP 
	private int attack;				// attack stat 
	private int defense;			// defense stat 
	private int magic;				// magic stat 
	private int stamina;			// stamina stat 
	private int dexterity;			// dexterity stat 
	private int critical;			// critical stat 
	private int hitChance;			// hit chance stat 
	private int magicAttack;		// magic attack stat 
	private int magicDefense;		// magic defense stat 
	private int evasion;			// magic defense stat 
	private int magicEvasion;		// magic evasion  stat 	
	private int luck;				// luck stat (hidden special stat)
	private int fireResistance;		// resistance to fire attacks
	private int waterResistance;	// resistance to water attacks
	private int iceResistance;		// resistance to ice attacks
	private int lightningResistance;// resistance to lightning attacks
	private int poisonResistance;	// resistance to poison attacks
	private int sonicResistance;	// resistance to sonic (sound-based) attacks
	private int energyResistance;	// resistance to energy (laser-based) attacks
	private int nanoResistance;		// resistance to nano (nanomachine-based) attacks
	
	public accessories(int itemID, String itemName, String itemType, 
		int itemBuyPrice, int itemSellPrice, int experience, int maxHP,
		int attack, int defense, int magic, int stamina, int dexterity,
		int critical, int hitChance, int magicAttack, int magicDefense, 
		int evasion, int magicEvasion, int luck, int fireResistance,
		int waterResistance, int iceResistance, int lightningResistance, 
		int poisonResistance, int sonicResistance, int  energyResistance,
		int nanoResistance)
	{
		super(itemID, itemName, itemType, itemBuyPrice, itemSellPrice);
		
		this.experience = experience;
		this.maxHP = maxHP;
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

	// set max hp value accessory takes/adds to character 
	public void setMaxHP(int maxHP) 
	{
		this.maxHP = maxHP; 
	} 
	
	// get max hp value accessory takes/adds to character 
	public int getMaxHP()
	{
		return maxHP; 
	} 
	
	// set experience value accessory affects character experience by
	public void setExperience(int experience)
	{
		this.experience = experience;
	}
	
	// get experience value accessory affects character experience by
	public int getExperience()
	{
		return experience; 
	} 
	
	// set attack value accessory takes/adds to character 
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	
	// get attack value accessory takes/adds to character 
	public int getAttack()
	{
		return attack; 
	} 
	
	// set defense value accessory takes/adds to character 
	public void setDefense(int defense)
	{
		this.defense = defense;
	}
	
	// get defense value accessory takes/adds to character 
	public int getDefense()
	{
		return defense; 
	} 
	
	// set magic value accessory takes/adds to character 
	public void setMagic(int magic)
	{
		this.magic = magic;
	}
	
	// get magic value accessory takes/adds to character 
	public int getMagic()
	{
		return magic; 
	} 
	
	// set stamina value accessory takes/adds to character 
	public void setStamina(int stamina)
	{
		this.stamina = stamina;
	}
	
	// get stamina value accessory takes/adds to character 
	public int getStamina()
	{
		return stamina; 
	} 
	
	// set dexterity value accessory takes/adds to character 
	public void setDexterity(int dexterity)
	{
		this.dexterity = dexterity;
	}
	
	// get dexterity value accessory takes/adds to character 
	public int getDexterity()
	{
		return dexterity; 
	} 
	
	// set critical value accessory takes/adds to character 
	public void setCritical(int critical)
	{
		this.critical = critical;
	}
	
	// get critical value accessory takes/adds to character 
	public int getCritical()
	{
		return critical; 
	} 
	
	// set hit chance value accessory takes/adds to character 
	public void setHitChance(int hitChance)
	{
		this.hitChance = hitChance;
	}
	
	// get hit chance value accessory takes/adds to character 
	public int getHitChance()
	{
		return hitChance; 
	} 
	
	// set magic attack value accessory takes/adds to character 
	public void setMagicAttack(int magicAttack)
	{
		this.magicAttack = magicAttack;
	}
	
	// get magic attack value accessory takes/adds to character 
	public int getMagicAttack()
	{
		return magicAttack; 
	} 
	
	// set magic defense value accessory takes/adds to character 
	public void setMagicDefense(int magicDefense)
	{
		this.magicDefense = magicDefense;
	}
	
	// get magic defense value accessory takes/adds to character 
	public int getMagicDefense()
	{
		return magicDefense; 
	} 
	
	// set evasion value accessory takes/adds to character 
	public void setEvasion(int evasion)
	{
		this.evasion = evasion;
	}
	
	// get evasion value accessory takes/adds to character 
	public int getEvasion()
	{
		return evasion; 
	} 
	
	// set magic evasion value accessory takes/adds to character 
	public void setMagicEvasion(int magicEvasion)
	{
		this.magicEvasion = magicEvasion;
	}
	
	// get magic evasion value accessory takes/adds to character 
	public int getMagicEvasion()
	{
		return magicEvasion; 
	} 
	
	// set luck value accessory takes/adds to character 
	public void setLuck(int luck)
	{
		this.luck = luck;
	}
	
	// get luck value accessory takes/adds to character 
	public int getLuck()
	{
		return luck; 
	} 
	
	// set fire resistance value accessory takes/adds to character 
	public void setFireResistance(int fireResistance)
	{
		this.fireResistance = fireResistance;
	}
	
	// get fire resistance value accessory takes/adds to character 
	public int getFireResistance()
	{
		return fireResistance;
	}
	
	// set water resistance value accessory takes/adds to character 
	public void setWaterResistance(int waterResistance)
	{
		this.waterResistance = waterResistance;
	}
	
	// get water resistance value accessory takes/adds to character 
	public int getWaterResistance()
	{
		return waterResistance;
	}
	
	// set ice resistance value accessory takes/adds to character 
	public void setIceResistance(int iceResistance)
	{
		this.iceResistance = iceResistance;
	}
	
	// get ice resistance value accessory takes/adds to character 
	public int getIceResistance()
	{
		return iceResistance;
	}
	
	// set lightning resistance value accessory takes/adds to character 
	public void setLightningResistance(int lightningResistance)
	{
		this.lightningResistance = lightningResistance;
	}
	
	// get lightning resistance value accessory takes/adds to character 
	public int getLightningResistance()
	{
		return lightningResistance;
	}
	
	// set poison resistance value accessory takes/adds to character 
	public void setPoisonResistance(int poisonResistance)
	{
		this.poisonResistance = poisonResistance;
	}
	
	// get poison resistance value accessory takes/adds to character 
	public int getPoisonResistance()
	{
		return poisonResistance;
	}
	
	// set sonic resistance value accessory takes/adds to character 
	public void setSonicResistance(int sonicResistance)
	{
		this.sonicResistance = sonicResistance;
	}
	
	// get sonic resistance value accessory takes/adds to character 
	public int getSonicResistance()
	{
		return sonicResistance;
	}
	
	// set energy resistance value accessory takes/adds to character 
	public void setEnergyResistance(int energyResistance)
	{
		this.energyResistance = energyResistance;
	}
	
	// get energy resistance value accessory takes/adds to character 
	public int getEnergyResistance()
	{
		return energyResistance;
	}
	
	// set nano resistance value accessory takes/adds to character 
	public void setNanoResistance(int nanoResistance)
	{
		this.nanoResistance = nanoResistance;
	}
	
	// get nano resistance value accessory takes/adds to character 
	public int getNanoResistance()
	{
		return nanoResistance;
	}
}