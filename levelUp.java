/* 
	public class levelUp contains information regarding the 
	'level up' or increase in strength of a character once 
	enough experience points are acquired 
*/ 

public class levelUp
{
	// instance variable used specifically for exp calculations  
	private int holdNextLevel;
	private int toNextLevel;
	private int exp = 21; 
	private int nextLevelExp;
	
	// error in code. level up once if large exp acquired. Need wole loop to increment?
	public void levelUp(genericCharacter character)
	{
		increaseStats stats = new increaseStats();
		
		holdNextLevel = correctLevel(character);
		
		if(holdNextLevel > character.getLevel())
		{
			while(holdNextLevel != character.getLevel())
			{
				character.setLevel(character.getLevel() + 1);
					System.out.println("\nLevel up!\n"); 
						showExpAndLevel(character);
							stats.allocateStatPoints(character);
			}
		}
		else
		{
			toNextLevel = expNeeded(character) - character.getExperience();
				System.out.println("\n"+character.getName()+"'s current exp: "+character.getExperience()+"/"+expNeeded(character));
					System.out.println("\nExp needed for next level: "+toNextLevel+"\n"); 
		}
	}
	
	// determine experience needed for next level 
	public void showExpAndLevel(genericCharacter character)
	{
		int i = expNeeded(character);
		nextLevelExp = i - character.getExperience();
		
		System.out.println("Character:  "+character.getName()+"	Total EXP:  "+character.getExperience()+"/"+i+" EXP");
		System.out.println("Level:	    "+character.getLevel()+"				Next Level: "+nextLevelExp+" EXP\n");
	}
	
	// method correctLevel is the reverse of method expNeeded
	// finds correct level for character based on experience value 	
	public int correctLevel(genericCharacter character)
	{
		int i = 0;
		
		while(character.getExperience() != exp)
		{
			int expCalculation = (int)(exp * 1.63) - (int)(exp/1.86) + 34;
			
			exp = expCalculation;	
			
			if(exp > character.getExperience())
			{
				break;
			}
			
			i++;
		}
		
		return i;
	}
	
	// determine experience needed for next level 
	public int expNeeded(genericCharacter character)
	{
		int i = 0;
		
		while(exp <= character.getExperience())
		{
			int expCalculation = (int)(exp * 1.63) - (int)(exp/1.86) + 34;

			exp = expCalculation; 
			
			i++;
		}
		
		return exp;
	}
}
















/* 
	public class levelUp contains information regarding the 
	'level up' or increase in strength of a character once 
	enough experience points are acquired 


import java.util.HashMap;
import java.util.Map;

public class levelUp
{
	// instance variable used specifically for exp calculations  
	private int exp = 21; 
	
	// method levels up a character 
	public void levelUp(genericCharacter character)
	{
		// hash map with integer key and integer value 
		HashMap<Integer, Integer> expMap = new HashMap<>();
		expMap.put(expNeeded(character, exp), correctLevel(character.getExperience(), exp));
				
		// check for level up and display character level 
		// level up character if character experience is greater than needed experience for level
		if(character.getExperience() >= expMap.get(expNeeded(character, exp))) 
		{   
			character.setLevel(correctLevel(character.getExperience(), exp));
			System.out.println("lvl: "+character.getLevel());
		}
		else // display characer level if level requirement not met 
		{
			character.setLevel(correctLevel(character.getExperience(), exp));
			System.out.println("lvl: "+character.getLevel());
		}
	}
	
	// determine experience needed for next level 
	public int expNeeded(genericCharacter character, int charExp)
	{
		int i = 0;
		
		int originalExp = character.getExperience();
		
		while(i <= character.getLevel())
		{
			int expCalculation = (int)(charExp * 1.63) - (int)(charExp/1.86) + 34;

			charExp = expCalculation; 

			character.setExperience(charExp);
			
			i++;
		}
		
		int experienceNeeded = character.getExperience();
		
		character.setExperience(originalExp);
		
		return experienceNeeded;
	}
	
	// method correctLevel is the reverse of method expNeeded
	// finds correct level for character based on experience value 	
	public int correctLevel(int levelExp, int charExp)
	{
		int i = 0;
		
		while(levelExp != charExp)
		{
			int expCalculation = (int)(charExp * 1.63) - (int)(charExp/1.86) + 34;
			
			charExp = expCalculation;	
			
			if(charExp > levelExp)
			{
				break;
			}
			
			i++;
		}
		return i;
	}
}
*/