/*
	public class items extends public class genericObject and defines methods related 
	to creating items with unique effects on aspects of the user as well as how to use 
	such items 
*/

public class items extends genericObject
{
	private String usage;				// how item is used by character (consumable, throwable, ect.)
	private String target;				// who/what an item targets (user, party, enemy, enemies)
	private String gaugeAffected;		// which gauge item affects (hp, np, sp)
	private int points; 				// points needed for calculations using item
	private statusEffects statusAdded;	// status effect that item adds to character 
	private String statusRemoved; 		// status effect that item removes from character
	
	/*	Usage Types: 
			Consumable:	items can be used by party members 
			Throwable:	items can be thrown by party members 
			Field: 		items exclusively meant to be used outside of battle
			Unusable:	items that cannot be used in any way */
	
	// details how items can be used in the game 
	private String[] validUsageTypes = {"Consumable", "Throwable", "Field", "Unusable"};
	
	// details the target for an item being used 
	private String[] validTargetTypes = {"Self", "Any", "Any Group"};
	
	/* Long form of: gauges 
		  private String[] gauges = {"Current Hp", "Stamina", "Nano", "Current Hp & Stamina", 
			  "Current Hp & Nano", "Stamina & Nano", "Recover All Gauges"}; */
	
	// details which gauge/gauges are recovered when an item is used 
	private String[] validGaugeTypes = {"Hp", "Sp", "Np", "HpSp", "HpNp", "SpNp", "RAG"};
	
	// create items objects with nothing supplied to them; objects created using this 
	// constructor can be customized further by calling set methods within this class 
	public items() 
	{
		// empty constructor 
	}
	
	
	
	
	
	
	// START: USAGE, TARGET, GAUGE AFFECTED, AND POINTS
	/*******************************************************************************/
	
	// set how item is used by character (Consumable, Throwable, ect.)
	public void setUsage(String usage)
	{
		if(usage != null)
		{
			for(String element : validUsageTypes)
			{
				if(usage.equals(element))
				{
					this.usage = usage;
						return;
				}
			} 
		}
	}
	
	// get how item is used by character 
	public String getUsage()
	{
		return usage;
	}
	
	// set who/what an item targets (Self, Party, ect.)
	public void setTarget(String target)
	{
		if(target != null)
		{
			for(String element : validTargetTypes)
			{
				if(target.equals(element))
				{
					this.target = target;
						return;
				}
			} 
		}
	}
	
	// get who/what an item targets 
	public String getTarget()
	{
		return target;
	}
	
	// set gauge item affects (Hp, Sp, ect.)
	public void setGaugeAffected(String gaugeAffected)
	{
		if(gaugeAffected != null)
		{
			for(String element : validGaugeTypes)
			{
				if(gaugeAffected.equals(element))
				{
					this.gaugeAffected = gaugeAffected;
						return;
				}
			} 
		}
	}
	
	// get gauge that item affects
	public String getGaugeAffected()
	{
		return gaugeAffected;
	}
	
	// set points that an item affects gauges by 
	public void setPoints(int points)
	{
		this.points = checkBounds(points, 0, 1000);
	}
	
	// gets points for the item  
	public int getPoints()
	{
		return points;
	}
	
	// END: USAGE, TARGET, GAUGE AFFECTED, AND POINTS
	/*******************************************************************************/
	
	
	
	
	
	
	// START: ITEMS ADDING AND REMOVING STATUS
	/*******************************************************************************/
	
	// set status effect item adds 
	public void setStatusItemAdds(statusEffects statusAdded)
	{
		if(statusAdded != null)
		{
			this.statusAdded = statusAdded;
		}
	}
	
	// get status effect item adds 
	public statusEffects getStatusItemAdds()
	{
		return statusAdded;
	}
	
	// set property (status) that item removes 
	public void setStatusItemRemoves(String statusRemoved)
	{
		if(statusRemoved != null)
		{
			for(String[] array : removeStatusEffects.getNegativeStatusEffects())
			{
				for(String element : array)
				{
					if(statusRemoved.equals(element))
					{
						this.statusRemoved = statusRemoved;
							return;
					}
				}
			}
		}
	}

	// get property (status) that item removes 
	public String getStatusItemRemoves()
	{
		return statusRemoved;
	}	
	
	// END: ITEMS ADDING AND REMOVING STATUS
	/*******************************************************************************/
}
