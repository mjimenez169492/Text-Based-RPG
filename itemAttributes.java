/*
	interface itemAttributes contains abstract methods concerning generic 
	items that must be implemented by a class that implements this interface
*/

interface itemAttributes
{
	// sets ID for item 
	void setItemID(int itemID);
	
	// gets ID for item
	int getItemID();
	
	// sets name for item 
	void setItemName(String itemName);
	
	// gets name for item
	String getItemName();
	
	// sets type for item 
	void setItemType(String itemType);
	
	// gets type for item
	String getItemType();
	
	// sets buy price for item 
	void setItemBuyPrice(int itemBuyPrice);
	
	// gets buy price for item
	int getItemBuyPrice();
	
	// sets sell price for item 
	void setItemSellPrice(int itemSellPrice);
	
	// gets sell price for item
	int getItemSellPrice();

}