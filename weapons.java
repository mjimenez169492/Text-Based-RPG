/*
	public class weapons extends public class genericItem & defines methods 
	related to equipable weapons that primarily increase attack and to 
	attack enemies
*/

public class weapons extends genericItem
{
	private int currentHP;			// item affects current HP per attack
	private int attack;				// item affects attack stat 
	private int magic;				// item affects magic stat 
	private int stamina;			// item affects stamina stat 
	private int dexterity;			// item affects dexterity stat 
	private int critical;			// item affects critical stat 
	private int hitChance;			// item affects hit chance stat 
	private int magicAttack;		// item affects hit chance stat 
	private String inflictStatus; 	// status item inflicts on enemy 
	
	public weapons(int itemID, String itemName, String itemType, int itemBuyPrice, 
		int itemSellPrice, int currentHP, int attack, int magic, int stamina, 
		int dexterity, int critical, int hitChance, int magicAttack, 
		String inflictStatus)
	{
		super(itemID, itemName, itemType, itemBuyPrice, itemSellPrice);
		
		this.currentHP = currentHP;
		this.attack = attack;
		this.magic = magic;
		this.stamina = stamina;
		this.dexterity = dexterity;
		this.critical = critical;
		this.hitChance = hitChance;
		this.magicAttack = magicAttack; 
		this.inflictStatus = inflictStatus;
	}
	
	// set HP value item takes/adds to character 
	public void setCurrentHP(int currentHP)
	{
		this.currentHP = currentHP;
	}
	
	// get HP value item takes/adds to character 
	public int getCurrentHP()
	{
		return currentHP;
	}
	
	// set attack value item takes/adds to character 
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	
	// get attack value item takes/adds to character 
	public int getAttack()
	{
		return attack;
	}
	
	// set magic value item takes/adds to character 
	public void setMagic(int magic)
	{
		this.magic = magic;
	}
	
	// get magic value item takes/adds to character 
	public int getMagic()
	{
		return magic;
	}
	
	// set stamina value item takes/adds to character 
	public void setStamina(int stamina)
	{
		this.stamina = stamina;
	}
	
	// get stamina value item takes/adds to character 
	public int getStamina()
	{
		return stamina;
	}
	
	// set dexterity value item takes/adds to character 
	public void setDexterity(int dexterity)
	{
		this.dexterity = dexterity;
	}
	
	// get dexterity value item takes/adds to character 
	public int getDexterity()
	{
		return dexterity;
	}
	
	// set critical value item takes/adds to character 
	public void setCritical(int critical)
	{
		this.critical = critical;
	}
	
	// get critical value item takes/adds to character 
	public int getCritical()
	{
		return critical;
	}
	
	// set hit chance value item takes/adds to character 
	public void setHitChance(int hitChance)
	{
		this.hitChance = hitChance;
	}
	
	// get hit chance value item takes/adds to character 
	public int getHitChance()
	{
		return hitChance;
	}
	
	// set magic attack value item takes/adds to character 
	public void setMagicAttack(int magicAttack)
	{
		this.magicAttack = magicAttack;
	}
	
	// get magic attack value item takes/adds to character 
	public int getMagicAttack()
	{
		return magicAttack;
	}
	
	// set status that item inflicts on enemy 
	public void setInflictStatus(String inflictStatus)
	{
		this.inflictStatus = inflictStatus;
	}
	
	// get status that item inflicts on enemy  
	public String getInflictStatus()
	{
		return inflictStatus;
	}
}