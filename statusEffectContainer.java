/*
	public class statusEffectContainer involves creating a "gauge" or "container" that 
	can hold status effects that the character may/may not be inflicted by throughout
	a battle or as a result of an event that occurs in the game 
*/
import java.util.LinkedHashSet;

public class statusEffectContainer
{
	// hold status effects that affect a character in linked hash map statusEffectHolder
	private LinkedHashSet<statusEffects> statusEffectHolder = new LinkedHashSet<statusEffects>();	
	
	private double sumOfAttributeEffects;		// stores sum of status effect object's effect on attributes 
	private double holdDouble;					// hold double value associated with status effect
	private int sumOfResistanceEffects;			// stores sum of status effect object's effect on resistance 
	private int holdInteger;					// hold integer value associated with status effect
	private String convertToDouble;				// temporarily stores double value as a string 
	private double roundToTwoDecimals;			// stores value of holdDouble up to two decimal places
	private double thousandthsPlace;			// stores thousandths place for a value 
	
	// constructor used to create status effect container object 
	public statusEffectContainer()
	{
		// empty constructor 
	}
	
	// add status effect object and store in linked hash set statusEffectHolder 
	public void addStatus(statusEffects status)
	{
		// enter if statement if status effect if it is not null 
		if(status != null)
		{
			statusEffectHolder.add(status);
		}
	}	
	
	// remove status effect from linked hash set statusEffectHolder by name 
	public void removeStatus(String statusName)
	{
		// enter if statement if status effect if it is not null 
		if(statusName != null)
		{
			for(statusEffects element : statusEffectHolder)
			{
				if(statusName.equals(element.getName()))
				{
					statusEffectHolder.remove(element);
				}
			}
		}
	}
	
	// print the contents of linked hash set statusEffectHolder on a single line 
	public void printStatusEffects()
	{
		// print statusEffectHolder contents there is at least one status effect object 
		if(statusEffectHolder.size() != 0)
		{
			// enhanced for loop prints out contents of statusEffectHolder
			for(statusEffects element : statusEffectHolder)
			{
				System.out.printf("%s ", element.getName());
			}
		}
	}
	
	// method decrements turn values of all status effects in statusEffectHolder by one 
	public void decrementTurns()
	{
		// enter if statement if statusEffectHolder has at least one status effect object 
		if(statusEffectHolder.size() != 0)
		{
			// enhanced for loop decrements turns of all status effect objects 
			for(statusEffects element : statusEffectHolder)
			{
				element.setTurns(element.getTurns() - 1);
			}
		}
	}
	
	// method removes status effect object if turns are 0 and if they are not "permanent"
	public void removeIfZeroTurns()
	{
		// enter if statement if statusEffectHolder has at least one status effect object 
		if(statusEffectHolder.size() != 0)
		{
			// enhanced for loop removes status effect objects if turns are zero and if not permanent
			for(statusEffects element : statusEffectHolder)
			{
				if(element.getTurns() == 0)
				{
					if(element.getPermanence() == false)
					{
						statusEffectHolder.remove(element);
					}
				}
			}
		}		
	}
	
	// method removes status effect objects meant to be removed after character is knocked out ("Ko")
	public void removeAfterKo()
	{
		// enter if statement if statusEffectHolder has at least one status effect object 
		if(statusEffectHolder.size() != 0)
		{
			// enhanced for loop removes status effect objects meant to be removed after character knock out
			for(statusEffects element : statusEffectHolder)
			{
				if(element.getRemoveAfterKo() == true)
				{
					statusEffectHolder.remove(element);
				}
			}
		}	
	}
	
	// method removes status effects which are supposed to be removed after battle 
	public void removeAfterBattle()
	{
		// enter if statement if statusEffectHolder has at least one status effect object 
		if(statusEffectHolder.size() != 0)
		{
			// enhanced for loop removes status effect objects after battle 
			for(statusEffects element : statusEffectHolder)
			{
				if(element.getRemoveAfterBattle() == true)
				{
					statusEffectHolder.remove(element);
				}
			}
		}	
	}
	
	// method rounds value to two decimals based on hundredths position
	public double roundHundredths(double value)
	{
		// turn double into a String that holds the double up to two decimal places 
		convertToDouble = String.format("%.2f", value);
		
		// parse double out of String and store in variable roundToTwoDecimals
		roundToTwoDecimals = Double.parseDouble(convertToDouble);
		
		// if-else statement accounts for positive or negative double supplied to method 
		if(value >= 0)
		{		
			// store difference of original double and double parsed from String 
			thousandthsPlace = value - roundToTwoDecimals;
			
			// assign thousandthsPlace with value from method checkThousandthsPlace()
			thousandthsPlace = checkThousandthsPlace(thousandthsPlace);
			
			// add value of thousandthsPlace to variable roundToTwoDecimals
			roundToTwoDecimals += thousandthsPlace;
		}
		else
		{
			// multiply value and roundToTwoDecimals by -1 to make them positive and 
			// then subtract value by roundToTwoDecimals 
			thousandthsPlace = (-1 * value) - (-1 * roundToTwoDecimals);
			
			// assign thousandthsPlace with value from method checkThousandthsPlace()
			thousandthsPlace = checkThousandthsPlace(thousandthsPlace);
			
			// subtract roundToTwoDecimals by value of thousandthsPlace 
			roundToTwoDecimals -= thousandthsPlace;
		}
		
		// return values stored in roundToTwoDecimals 
		return roundToTwoDecimals;
	}
	
	// method determines tenths place position for the supplied double based off the 
	// digit at thousandths place position 
	public double checkThousandthsPlace(double argument)
	{
		// if-else statement checks argument and adjusts it if not in bounds 
		if(argument < 0.005)
		{
			argument = 0.000;
		}
		else if(argument >= 0.005)
		{
			argument = 0.010;
		}
		
		// return argument after it was checked 
		return argument;
	}
	
	// method returns sum of doubles associated with attribute status object affects 
	// Ex: status object "Pain" affects two attributes: Current Hp and Current Hp so 
	// 	   sum up their double values (%6 and %8 or 0.06 and 0.08) and return that 
	public double getSumOfAttributeEffects(String attribute)
	{
		// initialize variable to 0.0 each time method is called  
		sumOfAttributeEffects = 0.0;
		
		// enter if statement if attribute supplied is not null 
		if(attribute != null)
		{
			// enter if statement if statusEffectHolder has at least one status effect object 
			if(statusEffectHolder.size() != 0)
			{
				// enhanced for loop retrieves sum of status effects effects on attribute 
				for(statusEffects element : statusEffectHolder)
				{
					sumOfAttributeEffects += effectOnAttribute(element.getAttributeOne(),
											 attribute, element.getAttributeOnePercent());
					
					sumOfAttributeEffects += effectOnAttribute(element.getAttributeTwo(),
											 attribute, element.getAttributeTwoPercent());
					
					sumOfAttributeEffects += effectOnAttribute(element.getAttributeThree(),
											 attribute, element.getAttributeThreePercent());
				}
			}	
		}
		
		// return value stored in sumOfAttributeEffects after rounding
		return roundHundredths(sumOfAttributeEffects);
	}
	
	// method returns the effect a status effect on an attribute 
	public double effectOnAttribute(String statusAttribute, String attribute, double statusPercent)
	{
		// reset holdDouble to 0 each time method is called
		holdDouble = 0.0;
		
		// enter if statement if status effect attribute is not null 
		if(statusAttribute != null)
		{	
			// if status effect attribute matches attribute then store double in holdDouble
			// else if status effect attribute matches "All_Attributes" then store double in holdDouble
			if(statusAttribute.equals(attribute))
			{
				holdDouble = statusPercent;
			}
			else if(statusAttribute.equals("All_Attributes"))
			{
				holdDouble = statusPercent;
			}
		}
		
		// return value stored in double variable
		return holdDouble;
	}
	
	// method returns sum of integers associated with resistance status object affects 
	// Ex: status object "a" affects two resistances: ice resistance and ice resistance 
	// 	   so sum up int values tied to each (10 and 30) and return that 
	public double getSumOfResistanceEffects(String resistance)
	{
		// initialize variable to 0 each time method is called  
		sumOfResistanceEffects = 0;
		
		// enter if statement if resistance supplied is not null 
		if(resistance != null)
		{
			// enter if statement if statusEffectHolder has at least one status effect object 
			if(statusEffectHolder.size() != 0)
			{
				// enhanced for loop retrieves sum of status' effects on resistance 
				for(statusEffects element : statusEffectHolder)
				{
					sumOfResistanceEffects += effectOnResistance(element.getResistanceOne(),
											  resistance, element.getResistanceOneEffect());

					sumOfResistanceEffects += effectOnResistance(element.getResistanceTwo(),
											  resistance, element.getResistanceTwoEffect());

					
					sumOfResistanceEffects += effectOnResistance(element.getResistanceThree(),
											  resistance, element.getResistanceThreeEffect());
				}
			}	
		}
		
		// return value stored in sumOfResistanceEffects 
		return sumOfResistanceEffects;
	}
	
	// method returns the effect a status effect on a resistance 
	public double effectOnResistance(String statusAttribute, String attribute, int statusEffect)
	{
		// reset holdInteger to 0 each time method is called
		holdInteger = 0;
		
		// enter if statement if status effect attribute is not null 
		if(statusAttribute != null)
		{
			// if status effect attribute matches attribute then store int in holdInteger
			// else if status effect attribute matches "All_Attributes" then store int in holdInteger
			if(statusAttribute.equals(attribute))
			{
				holdInteger = statusEffect;
			}
			else if(statusAttribute.equals("All_Resistances"))
			{
				holdInteger = statusEffect;
			}	
		}
		
		// return value stored in int variable
		return holdInteger;
	}
}