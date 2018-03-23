/*
	public class core extends public class itemAttributesDefined and defines methods
	within it. This class is used for the creation of "cores" which can be added to
	some types of weapons and armors in order to improve them 
*/

public class core extends itemAttributesDefined
{
	
	
		/*
	add check for multiple cores based off sizes 
		small: 	lose 20% of max points per turn 
		medium: lose 15% of max points per turn 
		large: 	lose 10% of max points per turn 
	
	add penalty for having multiple cores of the same type
		for small: 	2% per core (one core: 20% per turn, two cores: 22% per turn (2% per extra core), ect.)
		for medium: 4% per core (one core: 15% per turn, two cores: 19%% per turn (4% per extra core), ect.)
		for large: 	6% per core (one core: 10% per turn, two cores: 16% per turn (6% per extra core), ect.)
		*/
	
	
	// holds what type of core the core is 
	private String coreType;
	
	// hold valid types that a core can be assigned 
	private String[] coreTypes = {"Max Hp", "Current Hp", "Attack", "Defense", 
		"Nano", "Stamina", "Dexterity", "Critical", "Accuracy", "Nano Attack", 
		"Nano Defense"};
	
	// hold core size 
	private String coreSize = null;
	
	// hold valid sizes for a core 
	private String[] coreSizes = {"Small", "Medium", "Large"};
	
	// hold the tier a core belongs to 
	private String coreTier = null;
	
	// hold valid tiers for a core 
	private String[] coreTiers = {"Tier 1", "Tier 2", "Tier 3"};
	
	// hold max value a core can hold 
	private int maxCorePoints = 0;
	
	// hold the current value held within a core 
	private int currentCorePoints = 0;
	
	// constructor allows for creation of a core which can be added to weapons/armor/ect. 
	public core(int itemId, String itemName, String itemCategory, String itemSuperType, 
		String itemSubType, int itemBuyPrice, int itemSellPrice, String coreType, 
		String coreSize, String coreTier)
	{
		// supply arguments to superclass constructor 
		super(itemId, itemName, itemCategory, itemSuperType, itemSubType, itemBuyPrice, itemSellPrice);
		
		setCoreType(coreType);
		setCoreSize(coreSize);
		setCoreType(coreTier);
		setMaxCorePoints(this.coreSize, this.coreTier);
		setCurrentCorePoints(getMaxCorePoints());
	}
	
	
	// check for null outside of loop 
	// if blah is not null then execute everything else...
	
	// set what type a core is 
	public void setCoreType(String coreType)
	{
		if(coreType != null)
		{
			// boolean meant to check if an argument is valid 
			boolean validArgument = false;
			
			// for loop determines whether core type matches element in coreTypes array 
			for(int i = 0; i < coreTypes.length; i++)
			{
				// if core type is valid then assign boolean with true 
				if(coreType.equals(coreTypes[i]))
				{
					validArgument = true;
				}
			}
			
			// assign core type with argument if it is valid else assign it with null 
			if(validArgument == true)
			{
				this.coreType = coreType;
			}
		}
	}
	
	// get type for a core 
	public String getCoreType()
	{
		return coreType;
	}
	
	// set the size for a core 
	public void setCoreSize(String coreSize)
	{
		if(coreSize != null)
		{
			// boolean meant to check if an argument is valid 
			boolean validArgument = false;
			
			// for loop determines whether core size matches element in coreSizes array 
			for(int i = 0; i < coreSizes.length; i++)
			{
				// if core size is valid then assign boolean with true 
				if(coreSize.equals(coreSizes[i]))
				{
					validArgument = true;
				}
			}
			
			// assign core size with argument if it is valid else assign it with null 
			if(validArgument == true)
			{
				this.coreSize = coreSize;
			}
		}
	}
	
	// get core size of core
	public String getCoreSize()
	{
		return coreSize;
	}
	
	// set tier that core belongs to 
	public void setCoreTier(String tier)
	{
		if(tier != null)
		{
			// boolean meant to check if an argument is valid 
			boolean validArgument = false;
			
			// for loop determines whether core tier matches element in coreTier array 
			for(int i = 0; i < coreTiers.length; i++)
			{
				// if core tier is valid then assign boolean with true 
				if(tier.equals(coreTiers[i]))
				{
					validArgument = true;
				}
			}
			
			// assign core tier with argument if it is valid else assign it with null 
			if(validArgument == true)
			{
				this.coreTier = coreTier;
			}
		}
	}
	
	// get the tier for a core 
	public String getCoreTier()
	{
		return coreTier;
	}
	
	// maxCorePoints are set based on the core size and core tier 
	// small cores have points ranging: 10, 15, 20 
	// medium cores have points ranging: 25, 30, 35 
	// large cores have points ranging: 40, 45, 50 
	public void setMaxCorePoints(String coreSize, String coreTier)
	{
		// if core size and core tier are not null then enter if statement else 
		// assign maxCorePoints with 0 
		if(coreSize != null && coreTier != null)
		{
			if(coreSize.equals("Small"))
			{
				if(coreTier.equals("Tier 1"))
				{
					this.maxCorePoints = 10;
				}
				else if(coreTier.equals("Tier 2"))
				{
					this.maxCorePoints = 15;
				}
				else if(coreTier.equals("Tier 3"))
				{
					this.maxCorePoints = 20;
				}
			}
			else if(coreSize.equals("Medium"))
			{
				if(coreTier.equals("Tier 1"))
				{
					this.maxCorePoints = 25;
				}
				else if(coreTier.equals("Tier 2"))
				{
					this.maxCorePoints = 30;
				}
				else if(coreTier.equals("Tier 3"))
				{
					this.maxCorePoints = 35;
				}
			}
			else if(coreSize.equals("Large"))
			{
				if(coreTier.equals("Tier 1"))
				{
					this.maxCorePoints = 40;
				}
				else if(coreTier.equals("Tier 2"))
				{
					this.maxCorePoints = 45;
				}
				else if(coreTier.equals("Tier 3"))
				{
					this.maxCorePoints = 50;
				}
			}
		}
	}
	
	// return maxCorePoints for core 
	public int getMaxCorePoints()
	{
		return maxCorePoints;
	}
	
	// set currentCorePoints based off of maxCorePoints
	public void setCurrentCorePoints(int maxCorePoints)
	{
		this.currentCorePoints = maxCorePoints;
		
		if(currentCorePoints < 0)
		{
			currentCorePoints = 0;
		}
		else if(currentCorePoints > maxCorePoints)
		{
			currentCorePoints = maxCorePoints;
		}
	}
	
	// get currentCorePoints for the core 
	public int getCurrentCorePoints()
	{
		return currentCorePoints;
	}
}









