/*
	public class cores extends public class genericObject. This class is used for the 
	creation of "cores" which can be added to weapons, armors, and accessories so long 
	as the core slot types of the object is the same type as the core. 
*/

public class cores extends genericObject
{
	// holds what type of core the core is and its size and tier 
	private String coreType, coreSize, coreTier;
	
	// hold valid types that a core can be assigned 
	private String[] coreTypes = {"Max Hp", "Current Hp", "Attack", "Defense", 
		"Nano", "Stamina", "Dexterity", "Critical", "Accuracy", "Nano Attack", 
		"Nano Defense", "Fire Resistance", "Water Resistance", "Ice Resistance", 
		"Electricity Resistance", "Poison Resistance", "Sonic Resistance", 
		"Plasma Resistance", "Wind Resistance"};
	
	// hold valid sizes for a core 
	private String[] coreSizes = {"Small", "Medium", "Large"};
	
	// hold valid tiers for a core 
	private String[] coreTiers = {"Tier 1", "Tier 2", "Tier 3"};
	
	// hold max value a core can hold and the current value held within a core
	private double maxCorePoints, currentCorePoints = 0.0;
	
	// create cores with nothing supplied to super constructor due to too many parameters
	// objects created through this constructor can be customized further by calling set 
	// methods within this class
	public cores()
	{
		// empty constructor 
	}
	
	
	
	
	
	
	// START: CORE ATTRIBUTES
	/*******************************************************************************/

	// set what type a core is 
	public void setCoreType(String coreType)
	{
		if(coreType != null)
		{
			// for loop determines whether core type matches element in coreTypes array 
			for(String element : coreTypes)
			{
				// if core type is valid then assign boolean with true 
				if(coreType.equals(element))
				{
					this.coreType = coreType;
						break;
				}
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
			// for loop determines whether core size matches element in coreSizes array 
			for(String element : coreSizes)
			{
				// if core size is valid then assign boolean with true 
				if(coreSize.equals(element))
				{
					this.coreSize = coreSize;
						break;
				}
			}
		}
	}
	
	// get core size of core
	public String getCoreSize()
	{
		return coreSize;
	}
	
	// set tier that core belongs to 
	public void setCoreTier(String coreTier)
	{
		if(coreTier != null)
		{
			// for loop determines whether core tier matches element in coreTier array 
			for(String element : coreTiers)
			{
				// if core tier is valid then assign boolean with true 
				if(coreTier.equals(element))
				{
					this.coreTier = coreTier;
						break;
				}
			}
		}
	}
	
	// get the tier for a core 
	public String getCoreTier()
	{
		return coreTier;
	}
	
	// END: CORE ATTRIBUTES
	/*******************************************************************************/

	
	
	
	
	
	// START: CORE POINTS
	/*******************************************************************************/

	// maxCorePoints are returned based on the core size and core tier 
	public double getMaxCorePoints()
	{
		// if core size and core tier are not null then enter if statement else 
		// assign maxCorePoints with 0 
		if(getCoreSize() != null && getCoreTier() != null)
		{
			if(getCoreSize().equals("Small"))
			{
				if(getCoreTier().equals("Tier 1"))
				{
					maxCorePoints = 10.00;
				}
				else if(getCoreTier().equals("Tier 2"))
				{
					maxCorePoints = 15.00;
				}
				else if(getCoreTier().equals("Tier 3"))
				{
					maxCorePoints = 20.00;
				}
			}
			else if(getCoreSize().equals("Medium"))
			{
				if(getCoreTier().equals("Tier 1"))
				{
					maxCorePoints = 25.00;
				}
				else if(getCoreTier().equals("Tier 2"))
				{
					maxCorePoints = 30.00;
				}
				else if(getCoreTier().equals("Tier 3"))
				{
					maxCorePoints = 35.00;
				}
			}
			else if(getCoreSize().equals("Large"))
			{
				if(getCoreTier().equals("Tier 1"))
				{
					maxCorePoints = 40.00;
				}
				else if(getCoreTier().equals("Tier 2"))
				{
					maxCorePoints = 45.00;
				}
				else if(getCoreTier().equals("Tier 3"))
				{
					maxCorePoints = 50.00;
				}
			}
		}
		return maxCorePoints;
	}
	
	// set currentCorePoints based off of maxCorePoints
	public void setCurrentCorePoints(double currentCorePoints)
	{
		if(currentCorePoints < 0.00)
		{
			currentCorePoints = 0.00;
		}
		else if(currentCorePoints > getMaxCorePoints())
		{
			currentCorePoints = maxCorePoints;
		}
		
		this.currentCorePoints = maxCorePoints;
	}
	
	// get currentCorePoints for the core 
	public double getCurrentCorePoints()
	{
		return currentCorePoints;
	}
	
	// END: CORE POINTS
	/*******************************************************************************/

	
	
	
	
	
	// START: CORE PENALTY CALCULATION
	/*******************************************************************************/

	// determine penalty for object that has multiple cores affecting an attribute or 
	// resistance at once based on several factors related to the equipped cores 
	public static double corePenalty(cores[] coreArray, String coreType)
	{
		if(coreArray != null)
		{
			if(coreType != null)
			{
				// store cores (if there are any) in an array 
				// length determined by length of array containing the cores 
				cores[] cores = new cores[coreArray.length];
				
				// hold the number of cores that have the same coreType as supplied coreType
				// each core has a base penalty of 3% 
				double typeTotal = 0.03;
				
				// hold the number of cores that match one of three sizes 
				// Small penalty = 2%; Medium penalty = 5%; Large penalty = 7%;
				double smallTotal= 0.02;
				double mediumTotal = 0.05;
				double largeTotal = 0.07;
				
				// hold the number of cores that match one of three tiers 
				// Tier 1 penalty = 2%; Tier 2 penalty = 4%; Tier 3 penalty = 6%;
				double tierOneTotal = 0.02; 
				double tierTwoTotal = 0.04; 
				double tierThreeTotal = 0.06; 
				
				// hold total core penalty for the weapon 
				double corePenalty = 0.0;
				
				// store all weapon cores (if there are any) in array cores 
				storeCores(cores, coreArray);
				
				// count and store how many cores have the coreType specified 
				typeTotal *= sameCoreType(cores, coreType);
				
				// store cores of the same coreType that match the size specified in variable
				// and multiply the value by the penalty associated with the size 
				smallTotal *= sameCoreSize(cores, coreType, "Small");
				mediumTotal *= sameCoreSize(cores, coreType, "Medium");
				largeTotal *= sameCoreSize(cores, coreType, "Large");
				
				// store cores of the same coreType that match the tier specified in variable
				// and multiply the value by the penalty associated with the tier 
				tierOneTotal *= sameCoreTier(cores, coreType, "Tier 1");
				tierTwoTotal *= sameCoreTier(cores, coreType, "Tier 2");
				tierThreeTotal *= sameCoreTier(cores, coreType, "Tier 3");
				
				// calculate core penalty which is the sum of all cores, sizes, and tiers 
				return corePenalty = typeTotal + smallTotal + mediumTotal + largeTotal + 
					tierOneTotal + tierTwoTotal + tierThreeTotal;
			}
			else
			{
				return 0.00;
			}
		}
		else
		{
			return 0.00;
		}
	}
	
	// places copies of item's cores inside of array at specified position
	// if core does not exist (is null) then insert a null at the position instead
	// declared static in order to be called in static method corePenalty 
	public static void storeCores(cores[] cores, cores[] coreArray)
	{
		for(int i = 0; i < coreArray.length; i++)
		{
			if(coreArray[i] != null)
			{
				cores[i] = coreArray[i];
			}
			else
			{
				cores[i] = null;
			}
		}
	}
	
	// count the number of cores that have the same coreType as the supplied coreType
	// declared static in order to be called in static method corePenalty 
	public static double sameCoreType(cores[] cores, String coreType)
	{
		double counter = 0;
		
		for(cores element : cores)
		{
			if(element != null)
			{
				if(coreType.equals(element.getCoreType()))
				{
					counter++;
				}
			}
		}
		
		return counter;
	}
	
	// count the number of cores that have the same coreSize as supplied argument
	// declared static in order to be called in static method corePenalty 
	public static double sameCoreSize(cores[] cores, String coreType, String coreSize)
	{
		double counter = 0;
		
		for(cores element : cores)
		{
			if(element != null)
			{
				if(coreType.equals(element.getCoreType()))
				{
					if(coreSize.equals(element.getCoreSize()))
					{
						counter++;
					}
				}
			}
		}
		
		return counter;
	}
	
	// count the number of cores that have the same coreTier as supplied argument
	// declared static in order to be called in static method corePenalty 
	public static double sameCoreTier(cores[] cores, String coreType, String coreTier)
	{
		double counter = 0;
		
		for(cores element : cores)
		{
			if(element != null)
			{
				if(coreType.equals(element.getCoreType()))
				{
					if(coreTier.equals(element.getCoreTier()))
					{
						counter++;
					}
				}
			}
		}
		
		return counter;
	}
	
	// END: CORE PENALTY CALCULATION
	/*******************************************************************************/
}