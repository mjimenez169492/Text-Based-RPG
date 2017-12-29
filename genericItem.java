/*
	public class items implements itemAttributes and the methods within
	it. File contains methods relating to item ID, item name, and item
	price for a generic item 	
*/

public class genericItem implements itemAttributes 
{
	private int itemID;
	private String itemName;
	private String itemType;
	private int itemBuyPrice;
	private int itemSellPrice;
	
	public genericItem(int itemID, String itemName, String itemType, int itemBuyPrice, int itemSellPrice)
	{
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemBuyPrice = itemBuyPrice;
		this.itemSellPrice = itemSellPrice;
	}
	
	// sets ID for item 
	public void setItemID(int itemID)
	{
		this.itemID = itemID;		
	}
	
	// gets ID for item
	public int getItemID()
	{
		return itemID;
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
	
	// sets type for item 
	public void setItemType(String itemType)
	{
		this.itemType = itemType;
	}
	
	// gets type for item
	public String getItemType()
	{
		return itemType;
	}
	
	// sets buy price for item 
	public void setItemBuyPrice(int itemBuyPrice)
	{
		this.itemBuyPrice = itemBuyPrice;
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
	}
	
	// gets sell price for item
	public int getItemSellPrice()
	{
		return itemSellPrice;
	}
}