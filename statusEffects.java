/*
	public class statusEffects contains code relating to the construction of status
	effect objects which can affect poistively or negatively effect the behavior of
	a character in battle or the attributes/resistances of the character.
*/

public class statusEffects
{
	private String name;					// name of status effect 
	private int turns; 						// how many turns a status effect lasts 
	private boolean permanence;				// determine if status is permanent
	private boolean removeAfterKo;			// determines if status effect should be removed upon character knock out ("Ko")
	private boolean removeAfterBattle;		// determine whether a status is cured immediately after battle 
	
	private String attributeOne;			// first attribute status affects 
	private double attributeOnePercent;		// percent added/removed from first attribute 
	
	private String attributeTwo;			// second attribute status affects 
	private double attributeTwoPercent;		// percent added/removed from second attribute 
	
	private String attributeThree;			// third attribute status affects 
	private double attributeThreePercent;	// percent added/removed from third attribute 
	
	private String resistanceOne;			// first resistance status affects 
	private int resistanceOneEffect;		// integer value added/removed from first resistance 
	
	private String resistanceTwo;			// second resistance status affects 
	private int resistanceTwoEffect; 		// integer value added/removed from second resistance 
	
	private String resistanceThree;			// third resistance status affects 
	private int resistanceThreeEffect; 		// integer value added/removed from third resistance 
	
	// hold attributes that a character/enemy has 
	private String[] validAttributes = {"Current Hp", "Attack", "Defense", "Nano", "Stamina", 
		"Dexterity", "Critical", "Accuracy", "Nano Attack", "Nano Defense", "All_Attributes"};
	
	// hold resistances that a character/enemy has 
	private String[] validResistances = {"Fire Resistance", "Water Resistance", "Ice Resistance", 
		"Electricity Resistance", "Poison Resistance", "Sonic Resistance", "Plasma Resistance", 
		"Wind Resistance", "All_Resistances"};	
	
	// constructor allows for the creation of status effect object 
	public statusEffects()
	{
		// empty constructor 
	}
	
	
	
	
	
	
	// START: STATUS EFFECT OBJECT ATTRIBUTES
	/********************************************************************************/

	// set the name for a status effect (trim name if it is too long)
	public void setName(String name)
	{
		if(name != null)
		{
			if(name.length() > 16)
			{
				this.name = name.substring(0, 16);
			}
			else
			{
				this.name = name;
			}
		}
	}

	// get the name of a status effect 
	public String getName()
	{
		return name;
	}
	
	// set whether or not status can be removed 
	public void setPermanence(boolean permanence)
	{
		this.permanence = permanence;
	}
	
	// get state of status permanence
	public boolean getPermanence()
	{
		return permanence;
	}

	// set how many turns a status effect lasts 
	public void setTurns(int turns)
	{
		if(turns < 0)
		{
			turns = 0;
		}
		else if(turns > 8)
		{
			turns = 8;
		}
		
		this.turns = turns;
	}
	
	// get how many turns a status effect lasts 
	public int getTurns()
	{
		return turns;
	}
	
	// set whether status effect is removed after character is knocked out
	public void setRemoveAfterKo(boolean removeAfterKo)
	{
		this.removeAfterKo = removeAfterKo;
	}
	
	// get whether status effect is removed after character is knocked out
	public boolean getRemoveAfterKo()
	{
		return removeAfterKo;
	}
	
	// set whether status effect is removed after battle or not 
	public void setRemoveAfterBattle(boolean removeAfterBattle)
	{
		this.removeAfterBattle = removeAfterBattle;
	}
	
	// get whether status effect is removed after battle or not 
	public boolean getRemoveAfterBattle()
	{
		return removeAfterBattle;
	}
	
	// END: STATUS EFFECT OBJECT ATTRIBUTES
	/********************************************************************************/
	
	
	
	
	
	
	// START: STATUS EFFECT OBJECT EFFECT ON ATTRIBUTES 
	/********************************************************************************/
	
	// alter the double supplied as argument if it is outside the bounds specified 
	// within method validDouble and return the double after the if-else statement 
	public double validDouble(double value)
	{
		if(value < -1.00)
		{
			value = -1.00;
		}
		else if(value > 1.00)
		{
			value = 1.00;
		}
		
		return value;
	}
	
	// determine whether the supplied attribute name is valid 
	public boolean isAttributeValid(String attribute)
	{
		boolean validArgument = false;
		
		if(attribute != null)
		{
			for(String element : validAttributes)
			{
				if(attribute.equals(element))
				{
					validArgument = true;
				}
			}
			return validArgument;
		}
		else 
		{
			return validArgument;
		}
	}
	
	// set the first attribute affected by the status effect 
	public void setAttributeOne(String attributeOne)
	{
		if(isAttributeValid(attributeOne) == true)
		{
			this.attributeOne = attributeOne;
		}
	}
	
	// get the first attribute affected by the status effect 
	public String getAttributeOne()
	{
		return attributeOne;
	}
	
	// set percent that the first attribute is affected by due to the status effect 
	public void setAttributeOnePercent(double attributeOnePercent)
	{
		this.attributeOnePercent = validDouble(attributeOnePercent);
	}
	
	// get percent that the first attribute is affected by due to the status effect 
	public double getAttributeOnePercent()
	{
		return attributeOnePercent;
	}
	
	// set the second attribute affected by the status effect 
	public void setAttributeTwo(String attributeTwo)
	{
		if(isAttributeValid(attributeTwo) == true)
		{
			this.attributeTwo = attributeTwo;
		}
	}
	
	// get the second attribute affected by the status effect 
	public String getAttributeTwo()
	{
		return attributeTwo;
	}
	
	// set percent that the second attribute is affected by due to the status effect 
	public void setAttributeTwoPercent(double attributeTwoPercent)
	{
		this.attributeTwoPercent = validDouble(attributeTwoPercent);
	}
	
	// get percent that the second attribute is affected by due to the status effect 
	public double getAttributeTwoPercent()
	{
		return attributeTwoPercent;
	}
	
	// set the third attribute affected by the status effect 
	public void setAttributeThree(String attributeThree)
	{
		if(isAttributeValid(attributeThree) == true)
		{
			this.attributeThree = attributeThree;
		}
	}
	
	// get the third resistance affected by the status effect 
	public String getAttributeThree()
	{
		return attributeThree;
	}
	
	// set percent that the third attribute is affected by due to the status effect 
	public void setAttributeThreePercent(double attributeThreePercent)
	{
		this.attributeThreePercent = validDouble(attributeThreePercent);
	}
	
	// get percent that the third attribute is affected by due to the status effect 
	public double getAttributeThreePercent()
	{
		return attributeThreePercent;
	}
	
	// END: STATUS EFFECT OBJECT EFFECT ON ATTRIBUTES 
	/********************************************************************************/
	
	
	
	
	
	
	// START: STATUS EFFECT OBJECT EFFECT ON RESISTANCE 
	/********************************************************************************/
	
	// determine whether the resistance supplied as an argument is valid or not
	public boolean isResistanceValid(String resistance)
	{
		boolean validArgument = false;
		
		if(resistance != null)
		{
			for(String element : validResistances)
			{
				if(resistance.equals(element))
				{
					validArgument = true;
				}
			}
			return validArgument;
		}
		else 
		{
			return validArgument;
		}
	}
	
	// alter the integer supplied as argument if it is outside the bounds specified 
	// within method validInteger and return the int after the if-else statement 
	public int validInteger(int value)
	{
		if(value < -100)
		{
			value = -100;
		}
		else if(value > 100)
		{
			value = 100;
		}
		
		return value;
	}
	
	
	// set the first resistance affected by the status effect 
	public void setResistanceOne(String resistanceOne)
	{
		if(isResistanceValid(resistanceOne) == true)
		{
			this.resistanceOne = resistanceOne;
		}
	}
	
	// get the first resistance affected by the status effect 
	public String getResistanceOne()
	{
		return resistanceOne;
	}
	
	// set integer value that the first resistance is affected by due to status effect 
	public void setResistanceOneEffect(int resistanceOneEffect)
	{
		this.resistanceOneEffect = validInteger(resistanceOneEffect);
	}
	
	// get integer value that the first resistance is affected by due to status effect 
	public int getResistanceOneEffect()
	{
		return resistanceOneEffect;
	}
	
	// set the second resistance affected by the status effect 
	public void setResistanceTwo(String resistanceTwo)
	{
		if(isResistanceValid(resistanceTwo) == true)
		{
			this.resistanceTwo = resistanceTwo;
		}
	}
	
	// set the second resistance affected by the status effect 
	public String getResistanceTwo()
	{
		return resistanceTwo;
	}
	
	// set integer value that the second resistance is affected by due to status effect 
	public void setResistanceTwoEffect(int resistanceTwoEffect)
	{
		this.resistanceTwoEffect = validInteger(resistanceTwoEffect);
	}
	
	// set integer value that the second resistance is affected by due to status effect 
	public int getResistanceTwoEffect()
	{
		return resistanceTwoEffect;
	}
	
	// set the third resistance affected by the status effect 
	public void setResistanceThree(String resistanceThree)
	{
		if(isResistanceValid(resistanceThree) == true)
		{
			this.resistanceThree = resistanceThree;
		}
	}
	
	// get the third resistance affected by the status effect 
	public String getResistanceThree()
	{
		return resistanceThree;
	}
	
	// set integer value that the third resistance is affected by due to status effect 
	public void setResistanceThreeEffect(int resistanceThreeEffect)
	{
		this.resistanceThreeEffect = validInteger(resistanceThreeEffect);
	}
	
	// get integer value that the third resistance is affected by due to status effect 
	public int getResistanceThreeEffect()
	{
		return resistanceThreeEffect;
	}
	
	// END: STATUS EFFECT OBJECT EFFECT ON ATTRIBUTES 
	/********************************************************************************/
}
