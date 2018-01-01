/*
	public class items extends public class genericItem & defines methods 
	related to using items designed to function differently
*/

/*
	item types
		items
			consumable 
			throwable (weapons) 
			unusable 
			key items
				"quest" items that cannot be sold

	temp stat increases for set # of turns pending!!!
*/

public class items extends genericItem
{
	private String itemUsage;			// how item is used by character (consumable, throwable, none)
	private String itemAffects;			// who/what an item targets (user, party, enemy, enemies)
	private String statAffected;		// what stat item affects (damage, recover HP, MP, SP, status)
	private int itemPoints; 			// points needed for calculations with item
	private String statusItemRemoves; 	// status that item removes
	
	public items(int itemID, String itemName, String itemType, int itemBuyPrice, 
		int itemSellPrice, String itemUsage, String itemAffects, String statAffected,
		int itemPoints, String statusItemRemoves)
	{
		super(itemID, itemName, itemType, itemBuyPrice, itemSellPrice);
		
		this.itemUsage = itemUsage;
		this.itemAffects = itemAffects;
		this.statAffected = statAffected;
		this.itemPoints = itemPoints;
		this.statusItemRemoves = statusItemRemoves;
	}
	
	// set how item is used by character (consumable, throwable, none)
	public void setItemUsage(String itemUsage)
	{
		this.itemUsage = itemUsage;
	}
	
	// get how item is used by character (consumable, throwable, none)
	public String getItemUsage()
	{
		return itemUsage;
	}
	
	// set who/what an item targets (user, party, enemy, enemies)
	public void setItemAffects(String itemAffects)
	{
		this.itemAffects = itemAffects;
	}
	
	// get who/what an item targets (user, party, enemy, enemies)
	public String getItemAffects()
	{
		return itemAffects;
	}
	
	// set what item affects (damage, recover HP, MP, SP, cure status)
	public void setStatAffected(String statAffected)
	{
		this.statAffected = statAffected;
	}
	
	// get what item affects (damage, recover HP, MP, SP, cure status)
	public String getStatAffected()
	{
		return statAffected;
	}
	
	// set points to assign to item  
	public void setItemPoints(int itemPoints)
	{
		this.itemPoints = itemPoints;
	}
	
	// gets points assigned to item  
	public int getItemPoints()
	{
		return itemPoints;
	}
	
	// set property (status) that item removes 
	public void setStatusItemRemoves(String statusItemRemoves)
	{
		this.statusItemRemoves = statusItemRemoves;
	}
	
	// get property (status) that item removes 
	public String getStatusItemRemoves()
	{
		return statusItemRemoves;
	}	
}