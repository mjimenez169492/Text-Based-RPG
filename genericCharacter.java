/* 
	public class genericCharacter extends class characterAttributesDefined
	& defines methods related to character exp, level style, and armor
*/

public class genericCharacter extends characterAttributesDefined
{
	// declare instance variables as private 
	private String bodyArmor; 		// body armor 
	private String legArmor; 		// leg armor 
	private String footArmor; 		// foot armor 
	private String accessory; 		// accessory 
	private int expScale;			// sets scale for exp per level 
	private int points; 			// sets points gained upon level up
	private boolean levelUpType;	// sets how a character levels up 
	//private String status; 		// sets character status 
	
	public genericCharacter(String name, int level, int experience,
		int maxHP, int currentHP, int attack, int defense, int magic, 
		int stamina, int dexterity, int critical, int hitChance, 
		int magicAttack, int magicDefense, int evasion, int magicEvasion, 
		int luck, int fireResistance, int waterResistance, int iceResistance, 
		int lightningResistance, int poisonResistance, int sonicResistance, 
		int energyResistance, int nanoResistance, String bodyArmor, 
		String legArmor, String footArmor, String accessory, int expScale, 
		int points, boolean levelUpType)
	{
		
		super(name, level, experience, maxHP, currentHP, attack, defense, magic, 
			stamina, dexterity, critical, hitChance, magicAttack, magicDefense, 
			evasion, magicEvasion, luck, fireResistance, waterResistance, 
			iceResistance, lightningResistance, poisonResistance, 
			sonicResistance, energyResistance, nanoResistance); 

		this.bodyArmor = bodyArmor;
		this.legArmor = legArmor;
		this.footArmor = footArmor;
		this.accessory = accessory;
		this.expScale = expScale;
		this.points = points;
		this.levelUpType = levelUpType;
	}
	
	// method sets character's body armor 
	public void setBodyArmor(String bodyArmor)
	{
		this.bodyArmor = bodyArmor; 
	}
	
	// method retrieves character's body armor 
	public String getBodyArmor()
	{
		return bodyArmor; 
	} 
	
	// method sets character's leg armor 
	public void setLegArmor(String legArmor)
	{
		this.legArmor = legArmor; 
	}
	
	// method retrieves character's body armor 
	public String getLegArmor()
	{
		return legArmor; 
	} 
	
	// method sets character's body armor 
	public void setFootArmor(String footArmor)
	{
		this.footArmor = footArmor; 
	}
	
	// method retrieves character's body armor 
	public String getFootArmor()
	{
		return footArmor; 
	} 
	
	// method sets character's accessory 
	public void setAccessory(String accessory)
	{
		this.accessory = accessory; 
	}
	
	// method retrieves character's accessory
	public String getAccessory()
	{
		return accessory; 
	} 
	
	// method sets int value that determines exp scale for character to gain level
	public void setExpScale(int expScale)
	{
		this.expScale = expScale; 
	}
	
	// method sets int value that determines exp scale for character to gain level
	public int getExpScale()
	{
		return expScale; 
	} 
	
	// method to set points gained upon level up which are used to increase stats 
	public void setPoints(int points)
	{
		this.points = points;
		
		if (points < 0) 
		{
			points = 0; 
		}
		else if(points > 999)
		{
			points = 999;
		}
	}
	
	// method to get points 
	public int getPoints()
	{
		return points;
	}

	// determines which level up option to use to level up character stats 
	// method to do so is from the increaseStats class 
	public void setLevelUpType(boolean levelUpType)
	{
		this.levelUpType = levelUpType;
	}
	
	public boolean getLevelUpType()
	{
		return levelUpType;
	}
	
	//private String status; 			// sets character status 
	
}