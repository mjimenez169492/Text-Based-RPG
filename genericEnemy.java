/* 
	public class genericEnemy extends public class genericCharacter
	and uses some of the methods there for creating an enemy object
*/

public class genericEnemy extends characterAttributesDefined
{
	// declare instance variables as private 
	private int enemyExp;
	private int maxHP;
	private int money;				// money enemy drops
	private String dropOne;			// first enemy drop
	private String dropTwo;			// second enemy drop
	private String dropThree;		// third enemy drop
	private String stealableItem;	// enemy item that can be stolen

	public genericEnemy(String name, int level, int enemyExp,
		int maxHP, int currentHP, int attack, int defense, int magic, 
		int stamina, int dexterity, int critical, int hitChance, 
		int magicAttack, int magicDefense, int evasion, int magicEvasion, 
		int luck, int fireResistance, int waterResistance, int iceResistance, 
		int lightningResistance, int poisonResistance, int sonicResistance, 
		int energyResistance, int nanoResistance, int money, String dropOne, 
		String dropTwo, String dropThree, String stealableItem)
	{
		super(name, level, enemyExp, maxHP, currentHP, attack, defense, magic, 
			stamina, dexterity, critical, hitChance, magicAttack, magicDefense, 
			evasion, magicEvasion, luck, fireResistance, waterResistance, 
			iceResistance, lightningResistance, poisonResistance, 
			sonicResistance, energyResistance, nanoResistance); 
		
		this.money = money;
		this.dropOne = dropOne;
		this.dropTwo = dropTwo;
		this.dropThree = dropThree;
		this.stealableItem = stealableItem;
	}
	
	@Override
	// override set method version since no changes were made to get method
	// method sets experience gained after enemy is defeated
	public void setExperience(int enemyExp)
	{
		this.enemyExp = enemyExp;
		
		if (enemyExp < 0) 
		{
			enemyExp = 0; 
		}
		else if(enemyExp > 50000)
		{
			enemyExp = 50000;
		}
	}
	
	@Override
	// override set method version since no changes were made to get method
	// method sets enemy max hit points
	public void setMaxHP(int maxHP) 
	{
		this.maxHP = maxHP; 
		
		if(maxHP < 0) 
		{
			maxHP = 0;
		}
		
		if(maxHP > 999999)
		{
			maxHP = 999999;
		}
	} 
	
	// method sets money that enemy drops upon defeat 
	public void setEnemyMoney(int money)
	{
		this.money = money; 
	}
	
	// method retrieves money that enemy drops upon defeat 
	public int getEnemyMoney()
	{
		return money; 
	} 
	
	// method sets first item that enemy can drop upon defeat 
	public void setEnemyDropOne(String dropOne)
	{
		this.dropOne = dropOne; 
	}
	
	// method retrieves first item that enemy can drop upon defeat 
	public String getEnemyDropOne()
	{
		return dropOne; 
	} 
	
	// method sets second item that enemy can drop upon defeat 
	public void setEnemyDropTwo(String dropTwo)
	{
		this.dropTwo = dropTwo; 
	}
	
	// method retrieves second item that enemy can drop upon defeat 
	public String getEnemyDropTwo()
	{
		return dropTwo; 
	} 
	
	// method sets third item that enemy can drop upon defeat 
	public void setEnemyDropThree(String dropThree)
	{
		this.dropThree = dropThree; 
	}
	
	// method retrieves third item that enemy can drop upon defeat 
	public String getEnemyDropThree()
	{
		return dropThree; 
	} 
	
	// method sets item that can be stolen from an enemy 
	public void setStealableItem(String stealableItem)
	{
		this.stealableItem = stealableItem; 
	}
	
	// method retrieves item that can be stolen from an enemy 
	public String getStealableItem()
	{
		return stealableItem; 
	} 
}
	