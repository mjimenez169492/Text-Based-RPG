import java.util.Scanner;
import java.util.Random;

public class increaseStats
{
	private int points = 0;
	private int pointHolder = 0;
	private int totalPoints = 0;
	private String nowOrLater; 
	private String statPick;
	private int choice; 
	private int temp = 0;
	private int decreasePoints = 0;
	private int increasePoints = 0;
	private int newValue = 0;	
	private String morePointsToStat;
	
	public void allocateStatPoints(genericCharacter character)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Stats increased!\n"); 
		
		System.out.println("Previous stats:");
		increasableStatsTable(character);

		randStatsUp(character);

		System.out.println("New stats:");
		increasableStatsTable(character);
		
		pointHolder = statPoints(character); 

		character.setPoints(character.getPoints() + pointHolder);
		
		System.out.println(character.getName()+" gained "+pointHolder+" stat points!\n");
		System.out.println("Total stat points: "+character.getPoints());
		System.out.println("Stat points are used to improve character stats upon level up."); 
		
		System.out.print("Press 'y' to use stat points now. Press 'n' to save points for later: ");
		
		nowOrLater = sc.nextLine();
		
		while(!nowOrLater.equals("y") && !nowOrLater.equals("Y") && !nowOrLater.equals("n") && !nowOrLater.equals("N"))
		{
			System.out.print("Please press 'y' or 'n' to continue: ");
			
			nowOrLater = sc.nextLine();
		}
		
		if(nowOrLater.equals("y") || nowOrLater.equals("Y"))
		{
			pickIncreasableStat(character);
		}
		else if(nowOrLater.equals("n") || nowOrLater.equals("N"))
		{
			System.out.println("\nLeaving level up menu...");
		}
	}
	
	public void randStatsUp(genericCharacter character)
	{
		Random rand = new Random();

		int i = rand.nextInt(10) + 1;
		
		character.setMaxHP(character.getMaxHP() + (rand.nextInt(6) + 3));
		character.setAttack(character.getAttack() + rand.nextInt(5) + 1);
		character.setDefense(character.getDefense() + rand.nextInt(5) + 1);
		character.setMagic(character.getMagic() + rand.nextInt(5) + 2);
		character.setStamina(character.getStamina() + rand.nextInt(6) + 3);
		character.setDexterity(character.getDexterity() + rand.nextInt(4) + 1);
		character.setHitChance(character.getHitChance() + rand.nextInt(4) + 1);
		character.setMagicAttack(character.getMagicAttack() + rand.nextInt(4) + 1);
		character.setMagicDefense(character.getMagicDefense() + rand.nextInt(4) + 1);
		
		character.setEvasion(character.getEvasion() + rand.nextInt(2) + 1);
		character.setMagicEvasion(character.getMagicEvasion() + rand.nextInt(2) + 1);
				
		if(i == 0 || i == 10)
		{
			character.setCritical(character.getCritical() + rand.nextInt(2));
		}
		else if(i == 7)
		{
			character.setLuck(character.getLuck() + rand.nextInt(2));
		}
	}
	
	public int statPoints(genericCharacter character)
	{
		Random rand = new Random(); 
		
		if(character.getLevel() < 25)
		{
			points = rand.nextInt(((int)(character.getLuck()/2) + 1)) + 2;
		}
		else if(character.getLevel() >= 25 && character.getLevel() < 50)
		{
			points = rand.nextInt((int)(character.getLuck()/1.5)) + 2;
		}
		else if(character.getLevel() >= 50 && character.getLevel() < 75)
		{
			points = rand.nextInt(character.getLuck()) + 2; 
		}
		else if(character.getLevel() >= 75 && character.getLevel() < 99)
		{
			points = rand.nextInt((int)(character.getLuck()/0.5)) + 2; 
		}
		else if(character.getLevel() == 99)
		{
			points = (character.getLuck() * character.getLuck()) + 10; 
		}
		return points;
	}

	public void increasableStatsTable(genericCharacter character)
	{
		System.out.println("\nStats for "+character.getName());
		System.out.println("1. Max HP:  "+character.getMaxHP()+"	   5. Stamina:	 "+character.getStamina()+" 	 9. Magic Attack:     "+character.getMagicAttack());
		System.out.println("2. Attack:  "+character.getAttack()+"	   6. Dexterity: "+character.getDexterity()+"	10. Magic Defense:    "+character.getMagicDefense());
		System.out.println("3. Defense: "+character.getDefense()+"	   7. Critical:	 "+character.getCritical()+"	11. Physical Evasion: "+character.getEvasion());
		System.out.println("4. Magic:   "+character.getMagic()+"	   8. Hit:    	 "+character.getHitChance()+"	12. Magic Evasion:    "+character.getMagicEvasion()+"\n");
	}

	public void pointsPerStat()
	{
		System.out.println("Increasing a stat requires using a certain amount of stat points!");
		System.out.println("1 stat point:  Max HP, Attack, Defense, Magic, Stamina");
		System.out.println("2 stat points: Dexterity, Hit, Magic Attack, Magic Defense");
		System.out.println("3 stat points: Critical, Physical Evasion, Magic Evasion\n");	
	}
	
	public void pickIncreasableStat(genericCharacter character)
	{
		Scanner sc = new Scanner(System.in);
		
		increasableStatsTable(character);
		
		pointsPerStat();
		
		System.out.print("Press an integer listed above to increase a stat (Ex: 1 upgrades Max HP): ");
		
		statPick = sc.nextLine();

		// make method with cases that recursively call this method and have it have a parameter with an argument of int points 
		
		while(!statPick.equals("1") && !statPick.equals("2") && !statPick.equals("3") && !statPick.equals("4") &&
			!statPick.equals("5") && !statPick.equals("6") && !statPick.equals("7") && !statPick.equals("8") &&
			!statPick.equals("9") && !statPick.equals("10") && !statPick.equals("11") && !statPick.equals("12"))
		{
			System.out.println("Please select a stat to increase by pressing the appropriate number.");
			
			statPick = sc.nextLine();
		}
		
		choice = Integer.parseInt(statPick);
		
		statIncreased(character, choice);
	}
	
	public void statIncreased(genericCharacter character, int choice)
	{
		switch(choice)
		{
			case 1: // maxHP
				System.out.println("\nIncrease Max HP selected!");
				System.out.println(character.getName()+"'s Max HP stat: "+character.getMaxHP());
					temp = character.getMaxHP();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(newValue > temp)
				{
					character.setMaxHP(newValue);
						System.out.println(character.getName()+"'s Max HP stat increased from "+temp+" to "+character.getMaxHP()+"!");
							character.setPoints(character.getPoints() - decreasePoints);		
				}
				else
				{
					System.out.println(character.getName()+"'s Max HP stat did not change.");
				}								
					break;
			case 2: // attack
				System.out.println("\nIncrease Attack selected!");
				System.out.println(character.getName()+"'s Attack stat: "+character.getAttack());
					temp = character.getAttack();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(newValue > temp)
				{
					character.setAttack(newValue);
						System.out.println(character.getName()+"'s Attack stat increased from "+temp+" to "+character.getAttack()+"!");
							character.setPoints(character.getPoints() - decreasePoints);	
				}
				else
				{
					System.out.println(character.getName()+"'s Attack stat did not change.");
				}			
					break;
			case 3: // defense
				System.out.println("\nIncrease Defense selected!");
				System.out.println(character.getName()+"'s Defense stat: "+character.getDefense());
					temp = character.getDefense();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(newValue > temp)
				{
					character.setDefense(newValue);
						System.out.println(character.getName()+"'s Defense stat increased from "+temp+" to "+character.getDefense()+"!");
							character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Defense stat did not change.");
				}	
					break;
			case 4: // magic
				System.out.println("\nIncrease Magic selected!");
				System.out.println(character.getName()+"'s Magic stat: "+character.getMagic());
					temp = character.getMagic();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(newValue > temp)
				{
					character.setMagic(newValue);
						System.out.println(character.getName()+"'s Magic stat increased from "+temp+" to "+character.getMagic()+"!");
							character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Magic stat did not change.");
				}	
					break;
			case 5: // stamina
				System.out.println("\nIncrease Stamina selected!");
				System.out.println(character.getName()+"'s Stamina stat: "+character.getStamina());
					temp = character.getStamina();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 

				if(newValue > temp)
				{
					character.setStamina(newValue);
						System.out.println(character.getName()+"'s Stamina stat increased from "+temp+" to "+character.getStamina()+"!");
							character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Stamina stat did not change.");
				}	
					break;
			case 6: // dexterity 
				System.out.println("\nIncrease Dexterity selected!");
				System.out.println(character.getName()+"'s Dexterity stat: "+character.getDexterity());
					temp = character.getDexterity();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(increasePoints != 0 && (increasePoints % 2 == 0))
				{
					character.setDexterity(newValue);
						System.out.println(character.getName()+"'s Dexterity stat increased from "+temp+" to "+character.getDexterity()+"!");
							character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Dexterity stat did not change.");
				}	
					break;
			case 7: // critical
				System.out.println("\nIncrease Critical selected!");
				System.out.println(character.getName()+"'s Critical stat: "+character.getCritical());
					temp = character.getCritical();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(increasePoints != 0 && (increasePoints % 3 == 0))
				{
					character.setCritical(newValue);
						System.out.println(character.getName()+"'s Critical stat increased from "+temp+" to "+character.getCritical()+"!");
							character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Critical stat did not change.");
				}	
					break;
			case 8: // hit 
				System.out.println("\nIncrease Hit selected!");
				System.out.println(character.getName()+"'s Hit Chance stat: "+character.getHitChance());
					temp = character.getHitChance();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(increasePoints != 0 && (increasePoints % 2 == 0))
				{
					character.setHitChance(newValue);
					System.out.println(character.getName()+"'s Hit Chance stat increased from "+temp+" to "+character.getHitChance()+"!");
						character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Hit Chance stat did not change.");
				}	
					break;
			case 9: // m. attack
				System.out.println("\nIncrease Magic Attack selected!");
				System.out.println(character.getName()+"'s Magic Attack stat: "+character.getMagicAttack());
					temp = character.getMagicAttack();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(increasePoints != 0 && (increasePoints % 2 == 0))
				{
					character.setMagicAttack(newValue);
						System.out.println(character.getName()+"'s Magic Attack stat increased from "+temp+" to "+character.getMagicAttack()+"!");
							character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Magic Attack stat did not change.");
				}	
					break;
			case 10: // m. defense
				System.out.println("\nIncrease Magic Defense selected!");
				System.out.println(character.getName()+"'s Magic Defense stat: "+character.getMagicDefense());
					temp = character.getMagicDefense();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(increasePoints != 0 && (increasePoints % 2 == 0))
				{
					character.setMagicDefense(newValue);
						System.out.println(character.getName()+"'s Magic Defense stat increased from "+temp+" to "+character.getMagicDefense()+"!");
							character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Magic Defense stat did not change.");
				}	
					break;
			case 11: // evasion
				System.out.println("\nIncrease Physical Evasion selected!");
				System.out.println(character.getName()+"'s Evasion stat: "+character.getEvasion());
					temp = character.getEvasion();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(increasePoints != 0 && (increasePoints % 3 == 0))
				{
					character.setEvasion(newValue);
						System.out.println(character.getName()+"'s Evasion stat increased from "+temp+" to "+character.getEvasion()+"!");
							character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Evasion stat did not change.");
				}	
					break;
			case 12: // m. evasion 
				System.out.println("\nIncrease Magic Evasion selected!");
				System.out.println(character.getName()+"'s Magic Evasion stat: "+character.getMagicEvasion());
					temp = character.getMagicEvasion();
					increasePoints = increaseStat(character);
					decreasePoints = increasePoints;
				newValue = temp + increasePoints; 
				
				if(increasePoints != 0 && (increasePoints % 3 == 0))
				{
					character.setMagicEvasion(newValue);
					System.out.println(character.getName()+"'s Magic Evasion stat increased from "+temp+" to "+character.getMagicEvasion()+"!");
						character.setPoints(character.getPoints() - decreasePoints);
				}
				else
				{
					System.out.println(character.getName()+"'s Magic Evasion stat did not change.");
				}	
					break;
		}
		
		addPointsOrLeave(character);
	}
	
	// if statement in case to exit upgrade stats stuff or continue upgrading stats by recursively calling method pickIncreasableStat
	// method determine points to upgrade stat 
	public int increaseStat(genericCharacter character)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Total stat points: "+character.getPoints());
		System.out.print("Enter points to increase stat by (enter 0 to escape): ");
		
		// You don't have to parseInt or worry about NumberFormatException. 
		// Note that since hasNextXXX methods doesn't advance past any input, 
		// you may have to call next() if you want to skip past the "garbage" 
		while (!sc.hasNextInt()) sc.next();
		{
			choice = sc.nextInt();
		}

		if(choice < 0)
		{
			System.out.println("Error! A stat cannot be increased by negative points!\n");
				increaseStat(character);
		}
		else if(choice > character.getPoints())
		{
			System.out.println("Error! Stat cannot be increased by points that exceed total point value!\n");
				increaseStat(character);
		}
		return choice;
	}	
	
	public void addPointsOrLeave(genericCharacter character)
	{
		Scanner sc = new Scanner(System.in);
		
		if(character.getPoints() != 0)
		{
			System.out.println("\nRemaining stat points: "+character.getPoints());
			System.out.println("Would you like to add more points to a stat?");
			System.out.print("Press 'y' to add use more stat points. Press 'n' to end level up process: ");
			
			morePointsToStat = sc.nextLine();
			
			while(!morePointsToStat.equals("y") && !morePointsToStat.equals("Y") && !morePointsToStat.equals("n") && !morePointsToStat.equals("N"))
			{
				System.out.println("Please press 'y' or 'n' to continue.");
			
				morePointsToStat = sc.nextLine();
			}
			
			if(morePointsToStat.equals("y") || morePointsToStat.equals("Y"))
			{
				pickIncreasableStat(character);
			}
			else if(morePointsToStat.equals("n") || morePointsToStat.equals("N"))
			{
				System.out.println("\nLeaving level up menu...");
			}
		}
		else
		{
			System.out.println("\nLeaving level up menu...");
		}		
	}
}