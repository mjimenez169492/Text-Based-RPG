/*
	public class armor extends public class genericItem & defines methods 
	regarding equipable armor primarily used to increase defense & endure 
	more attacks before falling
	
	armor
		body
		legs
		feet
*/

public class armors extends genericItem
{
	// armor affects 
	private int maxHP;				// maxHP 
	private int defense;			// defense stat 
	private int magic;				// magic stat 
	private int stamina;			// stamina stat 
	private int dexterity;			// dexterity stat 
	private int critical;			// critical stat 
	private int magicDefense;		// magic attack stat 
	private int evasion;			// magic defense stat 
	private int magicEvasion;		// magic evasion  stat 	
	private int fireResistance;		// resistance to fire attacks
	private int waterResistance;	// resistance to water attacks
	private int iceResistance;		// resistance to ice attacks
	private int lightningResistance;// resistance to lightning attacks
	private int poisonResistance;	// resistance to poison attacks
	private int sonicResistance;	// resistance to sonic (sound-based) attacks
	private int energyResistance;	// resistance to energy (laser-based) attacks
	private int nanoResistance;		// resistance to nano (nanomachine-based) attacks
	
	public armors(int itemID, String itemName, String itemType, int itemBuyPrice, 
		int itemSellPrice, int maxHP, int defense, int magic, int stamina, 
		int dexterity, int critical, int magicDefense, int evasion, 
		int magicEvasion, int fireResistance, int waterResistance, 
		int iceResistance, int lightningResistance, int poisonResistance,
		int sonicResistance, int energyResistance, int nanoResistance)
	{
		super(itemID, itemName, itemType, itemBuyPrice, itemSellPrice);
		
		this.maxHP = maxHP;
		this.defense = defense;
		this.magic = magic;
		this.stamina = stamina;
		this.dexterity = dexterity;
		this.critical = critical;
		this.magicDefense = magicDefense;
		this.evasion = evasion; 
		this.magicEvasion = magicEvasion;
		this.fireResistance = fireResistance;
		this.waterResistance = waterResistance;
		this.iceResistance = iceResistance;
		this.lightningResistance = lightningResistance;
		this.poisonResistance = poisonResistance;
		this.sonicResistance = sonicResistance;
		this.energyResistance = energyResistance;
		this.nanoResistance = nanoResistance; 
	}
	
	// set HP value armor takes/adds to character 
	public void setMaxHP(int maxHP)
	{
		this.maxHP = maxHP;
	}
	
	// get HP value armor takes/adds to character 
	public int getMaxHP()
	{
		return maxHP;
	}
	
	// set defense value armor takes/adds to character 
	public void setDefense(int defense)
	{
		this.defense = defense;
	}
	
	// get defense value armor takes/adds to character 
	public int getDefense()
	{
		return defense;
	}
	
	// set magic value armor takes/adds to character 
	public void setMagic(int magic)
	{
		this.magic = magic;
	}
	
	// get magic value armor takes/adds to character 
	public int getMagic()
	{
		return magic;
	}
	
	// set stamina value armor takes/adds to character 
	public void setStamina(int stamina)
	{
		this.stamina = stamina;
	}
	
	// get stamina value armor takes/adds to character 
	public int getStamina()
	{
		return stamina;
	}
	
	// set dexterity value armor takes/adds to character 
	public void setDexterity(int dexterity)
	{
		this.dexterity = dexterity;
	}
	
	// get dexterity value armor takes/adds to character 
	public int getDexterity()
	{
		return dexterity;
	}
	
	// set critical value armor takes/adds to character 
	public void setCritical(int critical)
	{
		this.critical = critical;
	}
	
	// get critical value armor takes/adds to character 
	public int getCritical()
	{
		return critical;
	}
	
	// set magic defense value armor takes/adds to character 
	public void setMagicDefense(int magicDefense)
	{
		this.magicDefense = magicDefense;
	}
	
	// get magic defense value armor takes/adds to character 
	public int getMagicDefense()
	{
		return magicDefense;
	}
	
	// set evasion value armor takes/adds to character 
	public void setEvasion(int evasion)
	{
		this.evasion = evasion;
	}
	
	// get evasion value armor takes/adds to character 
	public int getEvasion()
	{
		return evasion;
	}
	
	// set magic evasion value armor takes/adds to character 
	public void setMagicEvasion(int magicEvasion)
	{
		this.magicEvasion = magicEvasion;
	}
	
	// get magic evasion value armor takes/adds to character 
	public int getMagicEvasion()
	{
		return magicEvasion;
	}
	
	// set fire resistance value armor takes/adds to character 
	public void setFireResistance(int fireResistance)
	{
		this.fireResistance = fireResistance;
	}
	
	// get fire resistance value armor takes/adds to character 
	public int getFireResistance()
	{
		return fireResistance;
	}
	
	// set water resistance value armor takes/adds to character 
	public void setWaterResistance(int waterResistance)
	{
		this.waterResistance = waterResistance;
	}
	
	// set water resistance value armor takes/adds to character 
	public int getWaterResistance()
	{
		return waterResistance;
	}
	
	// set ice resistance value armor takes/adds to character 
	public void setIceResistance(int iceResistance)
	{
		this.iceResistance = iceResistance;
	}
	
	// get ice resistance value armor takes/adds to character 
	public int getIceResistance()
	{
		return iceResistance;
	}
	
	// set lightning resistance value armor takes/adds to character 
	public void setLightningResistance(int lightningResistance)
	{
		this.lightningResistance = lightningResistance;
	}
	
	// set lightning resistance value armor takes/adds to character 
	public int getLightningResistance()
	{
		return lightningResistance;
	}
	
	// set poison resistance value armor takes/adds to character 
	public void setPoisonResistance(int poisonResistance)
	{
		this.poisonResistance = poisonResistance;
	}
	
	// get poison resistance value armor takes/adds to character 
	public int getPoisonResistance()
	{
		return poisonResistance;
	}
	
	// set sonic resistance value armor takes/adds to character 
	public void setSonicResistance(int sonicResistance)
	{
		this.sonicResistance = sonicResistance;
	}
	
	// get sonic resistance value armor takes/adds to character 
	public int getSonicResistance()
	{
		return sonicResistance;
	}
	
	// set energy resistance value armor takes/adds to character 
	public void setEnergyResistance(int energyResistance)
	{
		this.energyResistance = energyResistance;
	}
	
	// get energy resistance value armor takes/adds to character 
	public int getEnergyResistance()
	{
		return energyResistance;
	}
	
	// set nano resistance value armor takes/adds to character 
	public void setNanoResistance(int nanoResistance)
	{
		this.nanoResistance = nanoResistance;
	}
	
	// get nano resistance value armor takes/adds to character 
	public int getNanoResistance()
	{
		return nanoResistance;
	}
}