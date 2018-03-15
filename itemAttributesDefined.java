/*
	public class itemAttributesDefined implements itemAttributes and the methods in 
	it. File contains methods relating to item ID, item name, item type and item 
	buy/sell price 
*/

public class itemAttributesDefined implements itemAttributes 
{
	private int itemId;				// item identifiable by  unique ID
	private String itemName;		// item name 
	private String itemCategory;	// item category 
	private String[] itemCategories = {"items", "weapons", "armors", "accessories"}; // array holds item catgeoires 
	private String itemSuperType;	// super type item category for other item types
	private String itemSubType;		// item that is a sub type of super type item
	private int itemBuyPrice;		// money needed to buy item 
	private int itemSellPrice;		// money gotten by selling item 
	
	public itemAttributesDefined(int itemId, String itemName, String itemCategory,
		String itemSuperType, String itemSubType, int itemBuyPrice, int itemSellPrice)
	{
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemSuperType = itemSuperType;
		this.itemSubType = itemSubType;
		this.itemBuyPrice = itemBuyPrice;
		this.itemSellPrice = itemSellPrice;
	}
	
	// sets item ID for item (check against overflow)
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
		
		if(itemId < 0)
		{
			itemId = 0;
		}
		else if(itemId > 500)
		{
			itemId = 500;
		}
	}
	
	// gets item ID for item
	public int getItemId()
	{
		return itemId;
	}
	
	// sets name for item 
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	
	// gets name for item
	public String getItemName()
	{
		return itemName;
	}
	
	// sets super type for item (item belongs to a specified category. gun)
	public void setItemSuperType(String itemSuperType)
	{
		this.itemSuperType = itemSuperType;
	}
	
	// gets super type for item
	public String getItemSuperType()
	{
		return itemSuperType;
	}
	
	// sets category for item 
	public void setItemCategory(String itemCategory)
	{
		this.itemCategory = itemCategory;	
	}
	
	// gets category item belongs to 
	public String getItemCategory()
	{
		return itemCategory;
	}
	
	// sets sub type for item (items in a a specified category. pistol is a gun)
	public void setItemSubType(String itemSubType)
	{
		this.itemSubType = itemSubType;
	}
	
	// gets sub type for item 
	public String getItemSubType()
	{
		return itemSubType;
	}
	
	// sets buy price for item 
	public void setItemBuyPrice(int itemBuyPrice)
	{
		this.itemBuyPrice = itemBuyPrice;
		
		if(itemBuyPrice < 0)
		{
			itemBuyPrice = 0;
		}
		else if(itemBuyPrice > 50000)
		{
			itemBuyPrice = 50000;
		}
	}
	
	// gets buy price for item
	public int getItemBuyPrice()
	{
		return itemBuyPrice;
	}
	
	// sets sell price for item 
	public void setItemSellPrice(int itemSellPrice)
	{
		this.itemSellPrice = itemSellPrice;
		
		if(itemSellPrice < 0)
		{
			itemSellPrice = 0;
		}
		else if(itemSellPrice > 50000)
		{
			itemSellPrice = 50000;
		}
	}
	
	// gets sell price for item
	public int getItemSellPrice()
	{
		return itemSellPrice;
	}
}