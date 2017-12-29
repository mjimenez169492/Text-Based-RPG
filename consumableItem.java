/*
	public class consumableItems extends public class genericItem and uses
	some but not all functionalities of that class
*/

/*
	have methods to get 
		object hp and add hp to it
		object magic and add magic to it
		object stamina and add stamina to it
		
		
	temp stat increases for set # of turns pending!!!
*/

public class consumableItem extends genericItem
{
	private int itemID;
	private String itemName;
	private int itemBuyPrice;
	private int itemSellPrice;
	
	private int temp;
	
	// note: super keyword passes arguments of subclass constructor to the parent
	// class (superclass) constructor (superclass constructor)
	public consumableItem(int itemID, String itemName, String itemType, int itemBuyPrice, int itemSellPrice)
	{
		super(itemID, itemName, itemType, itemBuyPrice, itemSellPrice);
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
	
	// sets health character recovers by using item 
	public int healthItemRecovers(int healthRecovery, genericCharacter character)
	{
		temp = healthRecovery;
		return character.getCurrentHP() + temp;
	}
	
	// sets magic character recovers by using item 
	public int magicItemRecovers(int magicRecovery, genericCharacter character)
	{
		temp = magicRecovery;
		return character.getCurrentHP() + temp;
	}
	
	// sets stamina character recovers by using item 
	public int staminaItemRecovers(int staminaRecovery, genericCharacter character)
	{
		temp = staminaRecovery;
		return character.getCurrentHP() + temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}