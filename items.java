/*
	public class items extends public class genericItem & defines methods 
	related to using items designed to function differently
*/

public class items extends itemAttributesDefined
{
	private String itemUsage;				// how item is used by character (consumable, throwable, ect.)
	private String itemTarget;				// who/what an item targets (user, party, enemy, enemies)
	private String gaugeItemAffects;		// which gauge item affects 
	private int itemPoints; 				// points needed for calculations using item
	private statusEffects statusItemAdds;	// status effect that item adds to character 
	private String statusItemRemoves; 		// status effect that item removes from character
	
	// details how items can be used in the game 
	private String[] usage = {"Consumable", "Throwable", "Field", "Key Item", "Unusable", null};
	
	// details the target for an item being used 
	private String[] target = {"Self", "Ally", "Party", "Enemy", "Enemies", "Any", "Any Group", null};
	
	// details which gauge or gauges are recovered when an item is used 
	private String[] gaugeRecovery = {"Hp", "Sp", "Np", "HpSp", "HpNp", "SpNp", "RAG", null};
	
		/* Long form of: gaugeRecovery 
			
			private String[] gaugeRecovery = {"Current Hp", "Stamina", "Nano", "Current Hp & Stamina", 
				"Current Hp & Nano", "Stamina & Nano", "Recover All Gauges"};
		*/
	
	// Note: Status should be removed through String comparison NOT object comparison 
	// 		 since objects may not be identical. Status object should be held within 
	// 		 an item object instead of being a String so that status effect methods 
	// 		 can be called as necessary 
	
	// status that affects Current Hp which item can remove 
	private String[] hpStatus = {"KO", "Ablaze", "Bleed", "Poison"};
	
	// status that affects character behavior in battle which item can remove 
	private String[] behavior = {"Confuse", "Enamor", "Infatuate", "Berserk"};
	
	// status that affects turn behavior negatively which item can remove 
	private String[] turnBehavior = {"Stun", "Sleep", "Shock", "Slow",
		"Stop", "Slime"};	
	
	// status that affects one or many resistances negatively which item can remove 
	// status effect 'Nullify Negative Status Effects' removes all negative status  
	// effects that hinders the player in some way 
	private String[] specialStatus = {"Dry", "Wet",	"Cold", "Conductive", "Sickness",
		"Hypersensitive", "Coated", "Lightweight", "Nullify Negative Status Effects"}; 	
	
	// status that affects an attributes negatively which item can remove 
	private String[] attributeDown = {"Attack Down", "Defense Down", "Nano Down", 
		"Stamina Down", "Dexterity Down", "Critical Down", "Accuracy Down", "Nano Attack Down",
		"Nano Defense Down"}; 
	
	// status that affects a resistance negatively which item can remove 
	private String[] resistanceDown = {"Fire Resistance Down", "Water Resistance Down", 
		"Ice Resistance Down", "Electricity Resistance Down", "Poison Resistance Down", 
		"Sonic Resistance Down", "Plasma Resistance Down", "Wind Resistance Down", "None"};
	
	private String[] holdStatusItemRemoves [] = {hpStatus, behavior, turnBehavior, 
		specialStatus, attributeDown, resistanceDown};
	
	public items(int itemId, String itemName, String itemCategory, String itemSuperType, 
		String itemSubType, int itemBuyPrice, int itemSellPrice, String itemUsage, 
		String itemTarget, String gaugeItemAffects, int itemPoints, statusEffects statusItemAdds,
		String statusItemRemoves) 
		{
			super(itemId, itemName, itemCategory, itemSuperType, itemSubType, itemBuyPrice, itemSellPrice);
		
			setItemUsage(itemUsage);
			setItemTarget(itemTarget);
			setGaugeItemAffects(gaugeItemAffects);
			setItemPoints(itemPoints);
			setStatusItemAdds(statusItemAdds);	
			setStatusItemRemoves(statusItemRemoves);
		}
	
	// set how item is used by character (Consumable, Throwable, ect.)
	public void setItemUsage(String itemUsage)
	{
		boolean validArgument = false;
		
		if(itemUsage != null)
		{
			for(int i = 0; i < usage.length; i++)
			{
				if(itemUsage.equals(usage[i]))
				{
					validArgument = true;
				}
			}
			
			if(validArgument == true)
			{
				this.itemUsage = itemUsage;
			}
		}
		else
		{
			this.itemUsage = null;
		}
	}
	
	// get how item is used by character 
	public String getItemUsage()
	{
		return itemUsage;
	}
	
	// set who/what an item targets (Self, Party, ect.)
	public void setItemTarget(String itemTarget)
	{
		boolean validArgument = false;
		
		if(itemTarget != null)
		{
			for(int i = 0; i < target.length; i++)
			{
				if(itemTarget.equals(target[i]))
				{
					validArgument = true;
				}
			}
			
			if(validArgument == true)
			{
				this.itemTarget = itemTarget;
			}
		}
		else
		{
			this.itemTarget = null;
		}
	}
	
	// get who/what an item targets 
	public String getItemTarget()
	{
		return itemTarget;
	}
	
	// set gauge item affects (Hp, Sp, ect.)
	public void setGaugeItemAffects(String gaugeItemAffects)
	{
		boolean validArgument = false;
		
		if(gaugeItemAffects != null)
		{
			for(int i = 0; i < gaugeRecovery.length; i++)
			{
				if(gaugeItemAffects.equals(gaugeRecovery[i]))
				{
					validArgument = true;
				}
			}
			
			if(validArgument == true)
			{
				this.gaugeItemAffects = gaugeItemAffects;
			}
		}
		else
		{
			this.gaugeItemAffects = null;
		}
	}
	
	// get gauge item affects
	public String getGaugeItemAffects()
	{
		return gaugeItemAffects;
	}
	
	// set points for an item 
	public void setItemPoints(int itemPoints)
	{
		if(itemPoints < 0)
		{
			itemPoints = 0;
		}
		else if(itemPoints > 1000)
		{
			itemPoints = 1000;
		}
		
		this.itemPoints = itemPoints;
	}
	
	// gets points for the item  
	public int getItemPoints()
	{
		return itemPoints;
	}
	
	// set status effect item adds 
	public void setStatusItemAdds(statusEffects statusItemAdds)
	{
		if(statusItemAdds != null)
		{
			this.statusItemAdds = statusItemAdds;
		}
	}
	
	// get status effect item adds 
	public statusEffects getStatusItemAdds()
	{
		return statusItemAdds;
	}
	
	// set property (status) that item removes 
	public void setStatusItemRemoves(String statusItemRemoves)
	{
		boolean validArgument = false;
		
		if(statusItemRemoves != null)
		{
			for(String[] array : holdStatusItemRemoves)
			{
				if(statusItemAdds.equals(array))
				{
					validArgument = true;
				}
			}
			
			if(validArgument == true)
			{
				this.statusItemAdds = statusItemAdds;
			}
		}
		else
		{
			this.statusItemAdds = null;
		}
	}

	// get property (status) that item removes 
	public String getStatusItemRemoves()
	{
		return statusItemRemoves;
	}	
	
}
