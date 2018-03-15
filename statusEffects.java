/*
	public class statusEffects contains code relating to the construction of status
	effect objects which can affect the behavior or "status" of certain attributes
	of a character attributes 
*/

public class statusEffects
{
	private String statusName;				// name of status effect 
	private double statusPercent;			// percent status affects attribute/resistance of character
	private boolean statusPermanence;		// determine if status is permanent
	private int statusTurns; 				// how many turns a status effect lasts 
	private String statusCure;				// what cures a status effect 
	private boolean statusCureAfterBattle;	// determine whether a status is cured immediately after battle 
	
	private String statusAttributeOne;		// first attribute status affects 
	private String statusAttributeTwo;		// second attribute status affects 
	private String statusAttributeThree;	// third attribute status affects 
	private String statusResistanceOne;		// first resistance status affects 
	private String statusResistanceTwo;		// second resistance status affects 
	private String statusResistanceThree;	// third resistance status affects 
	
	// hold attributes that a character has 
	private String[] validAttributes = {"Max Hp", "Current Hp", "Attack", "Defense", 
		"Nano", "Stamina", "Dexterity", "Critical", "Accuracy", "Nano Attack", 
		"Nano Defense"};
	
	// hold resistances that a character has 
	private String[] validResistances = {"Fire Resistance", "Water Resistance", "Ice Resistance",
		"Electricity Resistance", "Poison Resistance", "Sonic Resistance", "Plasma Resistance",
		"Wind Resistance"};
	
	public statusEffects(String statusName, double statusPercent, boolean statusPermanence,
		int statusTurns, String statusCure, boolean statusCureAfterBattle, 
		String statusAttributeOne, String statusAttributeTwo, String statusAttributeThree,
		String statusResistanceOne, String statusResistanceTwo, String statusResistanceThree)
	{
		// Error: this.statusName = statusName;
		// issue is if get method is called after object creation, value is called 
		// without being appropriately checked with code found in the set methods 
		
		setStatusName(statusName);
		setStatusPercent(statusPercent);
		setStatusPermanence(statusPermanence);
		setStatusTurns(statusTurns);
		setStatusCure(statusCure);
		setStatusCureAfterBattle(statusCureAfterBattle);
		
		setStatusAttributeOne(statusAttributeOne);
		setStatusAttributeTwo(statusAttributeTwo);
		setStatusAttributeThree(statusAttributeThree);
		setStatusResistanceOne(statusResistanceOne);
		setStatusResistanceTwo(statusResistanceTwo);
		setStatusResistanceThree(statusResistanceThree);
	}
	
	public void setStatusName(String statusName)
	{
		if(statusName.length() > 12)
		{
			this.statusName = statusName.substring(0, 12);
		}
		else
		{
			this.statusName = statusName;
		}
	}
	
	public String getStatusName()
	{
		return statusName;
	}
	
	public void setStatusPercent(double statusPercent)
	{
		if(statusPercent < 0)
		{
			statusPercent = 0;
		}
		else if(statusPercent > 1.00)
		{
			statusPercent = 1.00;
		}
		
		this.statusPercent = statusPercent;
	}
	
	public double getStatusPercent()
	{
		return statusPercent;
	}
	
	public void setStatusPermanence(boolean state)
	{
		this.statusPermanence = statusPermanence;
	}
	
	public boolean getStatusPermanence()
	{
		return statusPermanence;
	}
	
	public void setStatusTurns(int statusTurns)
	{
		if(statusTurns < 1)
		{
			statusTurns = 1;
		}
		else if(statusTurns > 6)
		{
			statusTurns = 6;
		}
		
		this.statusTurns = statusTurns;
	}
	
	public int getStatusTurns()
	{
		return statusTurns;
	}
	
	public void setStatusCure(String statusCure)
	{
		this.statusCure = statusCure;
	}
	
	public String getStatusCure()
	{
		return statusCure;
	}
	
	public void setStatusCureAfterBattle(boolean statusCureAfterBattle)
	{
		this.statusCureAfterBattle = statusCureAfterBattle;
	}
	
	public boolean getStatusCureAfterBattle()
	{
		return statusCureAfterBattle;
	}
	
	public boolean isAttributeValid(String attribute)
	{
		boolean validArgument = false;
		
		if(attribute != null)
		{
			for(int i = 0; i < validAttributes.length; i++)
			{
				if(attribute.equals(validAttributes[i]))
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
	
	public void setStatusAttributeOne(String statusAttributeOne)
	{
		if(isAttributeValid(statusAttributeOne) == true)
		{
			this.statusAttributeOne = statusAttributeOne;
		}
	}
	
	public String getStatusAttributeOne()
	{
		return statusAttributeOne;
	}
	
	public void setStatusAttributeTwo(String statusAttributeTwo)
	{
		if(isAttributeValid(statusAttributeTwo) == true)
		{
			this.statusAttributeTwo = statusAttributeTwo;
		}
	}
	
	public String getStatusAttributeTwo()
	{
		return statusAttributeTwo;
	}
	
	public void setStatusAttributeThree(String statusAttributeThree)
	{
		if(isAttributeValid(statusAttributeThree) == true)
		{
			this.statusAttributeThree = statusAttributeThree;
		}
	}
	
	public String getStatusAttributeThree()
	{
		return statusAttributeThree;
	}
	
	public boolean isResistanceValid(String resistance)
	{
		boolean validArgument = false;
		
		if(resistance != null)
		{
			for(int i = 0; i < validResistances.length; i++)
			{
				if(resistance.equals(validResistances[i]))
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
	
	public void setStatusResistanceOne(String statusResistanceOne)
	{
		if(isResistanceValid(statusResistanceOne) == true)
		{
			this.statusResistanceOne = statusResistanceOne;
		}
	}
	
	public String getStatusResistanceOne()
	{
		return statusResistanceOne;
	}
	
	public void setStatusResistanceTwo(String statusResistanceTwo)
	{
		if(isResistanceValid(statusResistanceTwo) == true)
		{
			this.statusResistanceTwo = statusResistanceTwo;
		}
	}
	
	public String getStatusResistanceTwo()
	{
		return statusResistanceTwo;
	}
	
	public void setStatusResistanceThree(String statusResistanceThree)
	{
		if(isResistanceValid(statusResistanceThree) == true)
		{
			this.statusResistanceThree = statusResistanceThree;
		}
	}
	
	public String getStatusResistanceThree()
	{
		return statusResistanceThree;
	}
	
	/*
		public void setAttributesAffected(String status...array)
		{
			for(int i = 0; i < array.length; i++)
			{
				statusAttribute[i] = array[i];
			}
		}
	*/
	
	
}