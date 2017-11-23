/* 
	public class genericCharacter implements interface contract
	characterAttributes & defines methods in characterAttributes
*/

public class genericCharacter implements characterAttributes
{
	// declare instance variables as private 
	private String tempName; 	// temporary name for string formatting
	private String name; 		// formatted name 
	private int maxHP; 			// max hit points 
	private int currentHP;		// current hit points 
	private int attack;			// attack stat 
	private int defense;		// defense stat 
	private int magic;			// magic stat 
	private int stamina;		// stamina stat 
	private int dexterity;		// agility stat 
	private int critical;		// critical stat 
	private int hit;			// hit chance
	private int miss;			// miss chance 
	private int magicAttack;	// magic attack stat 
	private int magicDefense;	// magic defense stat 
	private int evasion;		// evasion stat 
	private int magicEvasion;	// magic evasion stat 
	private int luck;			// luck stat (hidden special stat)
	private int experience;		// experience total
	private int level;			// current level
	private int points;			// current stat points

	// method sets character's first name and last name 
	public void setName(String firstLastname)
	{
		tempName = firstLastname;
		
		// String.format(format, String) below displays string 
		// characters from 1 to 22 
		name =  tempName.format("%1.22s", firstLastname);
	}
	
	// method retrieves character's first name and last name 
	public String getName()
	{
		return name; 
	} 
	
	// method sets max hit points
	public void setMaxHP(int maxHitPoints) 
	{
		maxHP = maxHitPoints; 
		
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
	public void setCurrentHP( int currentHitPoints )  
	{
		currentHP = currentHitPoints;
		
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
	
		// method sets character luck stat 
	public void setLevel(int charlevel)
	{
		level = charlevel;
		
		if (level < 0) 
		{
			level = 0; 
		}
		else if(level > 99)
		{
			level = 99;
		}
	}
	
	// method retrieves character luck stat 
	public int getLevel()
	{
		return level; 
	} 
	
	// PLACEHOLDER VALUE
	// method sets character experience total
	public void setExperience(int charExperience)
	{
		experience = charExperience;
		
		if (experience < 0) 
		{
			experience = 0; 
		}
		else if(experience > 2670059)
		{
			experience = 2670059;
		}
	}
	
	// method retrieves character luck stat 
	public int getExperience()
	{
		return experience; 
	} 
	
	// method sets character attack stat 
	public void setAttack(int charAttack)
	{
		attack = charAttack;
		
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
	public void setDefense(int charDefense)
	{
		defense = charDefense;
		
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
	public void setMagic(int charMagic)
	{
		magic = charMagic;
		
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
	public void setStamina(int charStamina)
	{
		stamina = charStamina;
		
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
	public void setDexterity(int charDexterity)
	{
		dexterity = charDexterity;
		
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
	public void setCritical(int charCritical)
	{
		critical = charCritical;
		
		if (critical < 0) 
		{
			critical = 0; 
		}
		else if(critical > 99)
		{
			critical = 99;
		}
	}
	
	// method retrieves character critical stat 
	public int getCritical()
	{
		return critical; 
	} 
	
	// method sets character attack hit chance
	public void setHitChance(int hitchance)
	{
		hit = hitchance;
		
		if(hit < 0) 
		{
			hit = 0; 
		}
		else if(hit > 999)
		{
			hit = 999;
		}
	}
	
	// method retrieves character attack hit chance
	public int getHitChance()
	{
		return hit; 
	} 
	
	// method sets character magic attack stat 
	public void setMagicAttack(int charMagicAttack)
	{
		magicAttack = charMagicAttack;
		
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
	public void setMagicDefense(int charMagicDefense)
	{
		magicDefense = charMagicDefense;
		
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
	public void setEvasion(int charEvasion)
	{
		evasion = charEvasion;
		
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
	public void setMagicEvasion(int charMagicEvasion)
	{
		magicEvasion = charMagicEvasion;
		
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
	public void setLuck(int charLuck)
	{
		luck = charLuck;
		
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
	
	// method to set points gained upon level up which are used to increase stats 
	public void setPoints(int charPoints)
	{
		points = charPoints;
		
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
	
}