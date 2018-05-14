/* 
	public class enemies extends public class genericCharacter. It defines methods 
	essential for creating an enemy or a character that the player can defeat over 
	the course of the game such as a list of items dropped by an enemy.
*/
import java.util.ArrayList;

public class enemies extends genericCharacter
{	
	// declare instance variables as private 	
	private boolean boss;				// player party can escape if enemy is not a boss enemy 
	private int preventFlee;			// stores chance enemy has at stopping character from fleeing 
	
	private String[] armorPiercingScale = {"None", "Very Light", "Light", "Medium",
		"Heavy", "Very Heavy", "Impenetrable"};
		
	private String bodyArmorRating;		// stores armor rating for enemy body armor 
	private String legArmorRating;		// stores armor rating for enemy leg armor 
	private String footArmorRating;		// stores armor rating for enemy foot armor 
	
	private String altState = "(Alt)";	// state meant to be appended in front of full name of enemy 
	private boolean alt;				// determines whether enemy increases in strength 
	private int altChance;				// "enemy" becomes "enemy (alt)" is number if <= altChance 
	private double altBoost;			// denotes value enemy will be improved by 
	
	private int enemyExp;				// exp character receives for beatig enemy 
	private int maxHp;					// max hp that enemy has 
	private double enemyMoney;			// money enemy drops
	
	// array list holds objects enemy can drop upon defeat 
	private ArrayList<genericObject> itemDrops = new ArrayList<genericObject>();
	
	// array list holds objects that can be stolen from the enemy 
	private ArrayList<genericObject> stealableItems = new ArrayList<genericObject>();
	
	// constructor takes no arguments and calls empty superclass constructor 
	public enemies()
	{
		super();
	}
	
	
	
	
	
	
	// START: FLEE MECHANICS  
	/*******************************************************************************/

	// sets whether enemy being faced is a boss or not (characters cannot flee bosses)
	public void setBoss(boolean boss)
	{
		this.boss = boss;
	}
	
	// gets whether enemy being faced is a boss or not 
	public boolean getBoss()
	{
		return boss;
	}
	
	// set how likely the enemy can prevent a character from fleeing 
	public void setPreventFlee(int preventFlee)
	{
		if(preventFlee < 0)
		{
			preventFlee = 0;
		}
		else if(preventFlee > 100)
		{
			preventFlee = 100;
		}
		
		this.preventFlee = preventFlee;
	}
	
	// get how likely the enemy can prevent a character from fleeing 
	public int getPreventFlee()
	{
		return preventFlee;
	}
	
	// END: FLEE MECHANICS  
	/*******************************************************************************/
	
	
	
	
	
	
	// START: ENEMY ARMOR RATING  
	/*******************************************************************************/

	// set armor rating that enemy has for their body armor 
	public void setBodyArmorRating(String bodyArmorRating)
	{
		// enter if statement if supplied argument is not null 
		if(bodyArmorRating != null)
		{
			// enhanced for loop compares argument to contents of array and assigns the 
			// argument to the instance variable if it is valid before exiting method
			for(String element : armorPiercingScale)
			{
				if(element.equals(bodyArmorRating))
				{
					this.bodyArmorRating = bodyArmorRating;
						return;
				}
			}
		}
	}
	
	// get armor rating that enemy has for their body armor 
	public String getBodyArmorRating()
	{
		return bodyArmorRating; 
	}

	// set armor rating that enemy has for their leg armor 
	public void setLegArmorRating(String legArmorRating)
	{
		// enter if statement if supplied argument is not null 
		if(legArmorRating != null)
		{
			// enhanced for loop compares argument to contents of array and assigns the 
			// argument to the instance variable if it is valid before exiting method
			for(String element : armorPiercingScale)
			{
				if(element.equals(legArmorRating))
				{
					this.legArmorRating = legArmorRating;
						return;
				}
			}
		}
	}
	
	// get armor rating that enemy has for their leg armor 
	public String getLegArmorRating()
	{
		return legArmorRating; 
	}
	
	// set armor rating that enemy has for their foot armor 
	public void setFootArmorRating(String footArmorRating)
	{
		// enter if statement if supplied argument is not null 
		if(footArmorRating != null)
		{
			// enhanced for loop compares argument to contents of array and assigns the 
			// argument to the instance variable if it is valid before exiting method
			for(String element : armorPiercingScale)
			{
				if(element.equals(footArmorRating))
				{
					this.footArmorRating = footArmorRating;
						return;
				}
			}
		}
	}
	
	// get armor rating that enemy has for their foot armor 
	public String getFootArmorRating()
	{
		return footArmorRating; 
	}
	
	// END: ENEMY ARMOR RATING  
	/*******************************************************************************/
	
	
	
	
	
	
	// START: ALT SPONTANEOUS POWER UP MECHANIC 
	/*******************************************************************************/
	
	// get string holding "(Alt)" which can be appended to the start of the enemy name
	public String getAltState()
	{
		return altState;
	}
	
	// set whether enemy has entered powered up state called "(Alt)" 
	public void setAlt(boolean alt)
	{
		this.alt = alt;
	}
	
	// get whether enemy has entered powered up state called "(Alt)" 
	public boolean getAlt()
	{
		return alt;
	}
	
	// set chance out of 100 that enemy has at attaining "(Alt)" state
	/* Note: chance concerns range from 0 to number supplied to method */
	public void setAltChance(int altChance)
	{
		if(altChance < 0)
		{
			altChance = 0;
		}
		else if(altChance > 100)
		{
			altChance = 100;
		}
		
		this.altChance = altChance;
	}
	
	// get chance out of 100 that enemy has at attaining "(Alt)" state
	public int getAltChance()
	{
		return altChance;
	}
	
	// set boost to enemy characteristics if "(Alt)" state is achieved 
	public void setAltBoost(double altBoost)
	{
		if(altBoost < 1.0)
		{
			altBoost = 1.0;
		}
		else if(altBoost > 3.0)
		{
			altBoost = 3.0;
		}
		
		this.altBoost = altBoost;
	}
	
	// get boost to enemy characteristics if "(Alt)" state is achieved 
	public double getAltBoost()
	{
		return altBoost;
	}
	
	// END: ALT SPONTANEOUS POWER UP MECHANIC
	/*******************************************************************************/
	
	
	
	
	
	
	// START: ADDITIONAL ENEMY FEATURES
	/*******************************************************************************/
	
	// method sets experience character gains after enemy is defeated 
	public void setEnemyExp(int enemyExp)
	{
		if (enemyExp < 0) 
		{
			enemyExp = 0; 
		}
		else if(enemyExp > 50000)
		{
			enemyExp = 50000;
		}
		
		this.enemyExp = enemyExp;
	}
	
	public int getEnemyExp()
	{
		return enemyExp;
	}
		
	// override set method from superclass to suit public class genericEnemy
	// method sets enemy's max hit points 
	@Override
	public void setMaxHp(int maxHp) 
	{
		if(maxHp < 0) 
		{
			maxHp = 0;
		}
		else if(maxHp > 999999)
		{
			maxHp = 999999;
		}
		
		this.maxHp = maxHp;
	} 
	
	// override get method from superclass to suit public class genericEnemy
	// method gets enemy's max hit points 
	@Override
	public int getMaxHp() 
	{
		return maxHp;
	} 
	
	// method sets money that enemy drops upon defeat 
	public void setEnemyMoney(double enemyMoney)
	{
		if(enemyMoney < 0)
		{
			enemyMoney = 0;
		}
		else if(enemyMoney < 100000.0)
		{
			enemyMoney = 100000.0;
		}
		
		this.enemyMoney = enemyMoney; 
	}
	
	// method retrieves money that enemy drops upon defeat 
	public double getEnemyMoney()
	{
		return enemyMoney; 
	} 
	
	// method adds object to itemDrops array list if it is valid and if itemDrops does
	// not already contain four objects 
	public <T extends genericObject> void addItemDrop(T object)
	{		
		if(itemDrops.size() != 4)
		{
			if(object != null)
			{
				itemDrops.add(object);
			}
		}
	}
	
	// method removes object if it exists within the array list 
	public <T extends genericObject> void removeItemDrop(T object)
	{
		if(object != null)
		{
			if(itemDrops.contains(object))
			{
				itemDrops.remove(object);
			}
		}
	}
	
	// method returns itemDrops array list 
	public ArrayList<genericObject> getItemDrops()
	{
		return itemDrops;
	}
	
	// method adds object to stealableItems array list if it is valid and if 
	// stealableItems does not already contain two objects 
	public <T extends genericObject> void addStealableItem(T object)
	{		
		if(stealableItems.size() != 2)
		{
			if(object != null)
			{
				stealableItems.add(object);
			}
		}
	}
	
	// method removes object if it exists within the array list 
	public <T extends genericObject> void removeStealableItem(T object)
	{
		if(object != null)
		{
			if(stealableItems.contains(object))
			{
				stealableItems.remove(object);
			}
		}
	}
	
	// method returns stealableItems array list 
	public ArrayList<genericObject> getStealableItems()
	{
		return stealableItems;
	}
	
	// END: ADDITIONAL ENEMY FEATURES
	/*******************************************************************************/
}