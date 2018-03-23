/* 
	public class partyInventory contains 4 hashmaps which are meant to store items,
	weapons, armors, and accessories respectively. Every hashmap contains methods
	which manage how an item is added, removed, and displayed. 
	
	In terms of organization, there are two options currently being considered and 
	they are: 1) TreeMap, and 2) HashMap. 
	
		import java.util.ArrayList;
		import java.util.TreeMap;
		import java.util.Map;
	
					key 	value
			TreeMap<String, ArrayList<String>> inventory = new TreeMap<String, ArrayList<String>>();
	
		TreeMap has O(log(n)) complexity which is slower than HashMap which has O(1) 
		complexity. TreeMap always keeps the elements in a sorted(increasing) order, 
		while the elements in a HashMap have no defined order. Ordering within TreeMap
		can be chanhed by the programmer if a sort method is created and implemented.
	
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.Map;
	
					key 	value
			HashMap<String, ArrayList<String>> inventory = new HashMap<String, ArrayList<String>>();

		The HashMap appears favorable for it allows a programmer to have a bit more
		flexibility when it comes to organization since the items in the HashMap that
		had their positions moved would not be sorted by increasing order afterwards
		as they would in a TreeMap. Since sorting or item movement would likely ease 
		game development, a HashMap is, at this time, the more favorable of the two. 
	
	Some handy HashMap methods called by HashMap object inventory...
		
		inventory.entrySet()	displays a HashMap key and its corresponding value 
		inventory.keySet()		displays the 'key' within a HashMap
		inventory.values()		displays the 'value' within a HashMap
*/

//import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import java.util.TreeMap;

// create universal inventory that accepts items, weapons, armors, and accessories 
// create methods to add objects, remove objects, and print out all or some objects
// change genericItem 		->	 	itemAttributesDefined

public class partyInventory 
{	
	private int inventoryGroupsLimit = 2; 	// limits number of different item groups that
											// can exist in the inventory 			(put 2)
	private int itemGroupSizeLimit = 2;		// limit number of items that can be "stacked"
											// or held in a group in an inventory 	(put 2) 
	private String objectName;				// hold the name of an object in the inventory 
	
	
	
	private int counter;				  // denotes position of an item in the inventory
	private int arrayListTotal;			  // holds total number of items in an item group 
	
	// item categories which object must belong to in order to be stored in inventory
	private String[] validItemCategories = {"items", "weapons", "armors", "accessories"}; 	
	
	// set the number of different item groups that can exist in the inventory 
	public void setInventoryGroupsLimit(int inventoryGroupsLimit)
	{
		if(inventoryGroupsLimit < 0)
		{
			inventoryGroupsLimit = 0;
		}
		else if(inventoryGroupsLimit > 30)
		{
			inventoryGroupsLimit = 30;
		}
		
		this.inventoryGroupsLimit = inventoryGroupsLimit;
	}
	
	// get the number of different item groups that can exist in the inventory 
	public int getInventoryGroupsLimit()
	{
		return itemGroupSizeLimit;
	}
	
	// set the item group size limit for the inventory 
	public void setItemGroupSizeLimit(int itemGroupSizeLimit)
	{
		if(itemGroupSizeLimit < 0)
		{
			itemGroupSizeLimit = 0;
		}
		else if(itemGroupSizeLimit > 30)
		{
			itemGroupSizeLimit = 30;
		}
		
		this.itemGroupSizeLimit = itemGroupSizeLimit;
	}
	
	// get the item group size limit 
	public int getItemGroupSizeLimit()
	{
		return itemGroupSizeLimit;
	}
	
	// constructor creates partyInventory object which can call methods related to 
	// managing the party inventory 
	public partyInventory()
	{
		// constructor with no body
	}
	
	// create hashmap object that will serve as an inventory that will store items 
	// Hashmap has a key of type itemAttributesDefined and an array list of type 
	// itemAttributesDefined as its value
	HashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventory = 
		new HashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();
	
	// generic method where object created in a subclass of itemAttributesDefined is 
	// treated as an object to be added to the inventory if it is valid 
	public <T extends itemAttributesDefined> boolean isObjectValid(T object) 
	{
		// boolean checks to see if object being added is valid 
		boolean validArgument = false;
		
		// proceed into if statement if object is not null 
		if(object != null)
		{
			// proceed into if statement if item category of the object is not null 
			if(object.getItemCategory() != null)
			{
				// enhanced for loop traverses array and adds item to inventory if 
				// object category matches one of the categories specified in array
				for(String element : validItemCategories)
				{
					if(object.getItemCategory().equals(element))
					{
						validArgument = true;
					}
				}
				// return boolean value held in variable 
				return validArgument;
			}
			else
			{
				// return boolean value held in variable 
				return validArgument;
			}
		}
		else
		{
			// return boolean value held in variable 
			return validArgument;
		}
	}
	
		// style: public <T extends Vehicle> void exampleMethod(Class<T> type)
	
	// method adds a subclass object of superclass itemAttributesDefined to inventory 
	public <T extends itemAttributesDefined> void addObject(T object)
	{
		// if object is valid, proceed into if statement 
		if(isObjectValid(object) == true)
		{
			/*
				The get(Object key) method is used to return the value to which 
				the specified key is mapped, or null if the hashmap contains no 
				mapping for the key.
			*/
			
			// check to see whether hashmap contains a mapping for key 
			// in this case, mapping refers to whether an item group for the object
			// already exists as an array list and if it does then it will be retrieved
			// Note: initial size of the array list was not set which is okay 
			ArrayList<itemAttributesDefined> itemGroup = itemInventory.get(object);
			
			// if the size of the inventory is equal to the item group limit, print out
			// statements regarding why object could be added else create a new array
			// list for the object and add it to the hashmap 
			if(itemInventory.size() == inventoryGroupsLimit)
			{
				// print statements saying that there are too many different item groups
				System.out.println("\n\n'" + object.getItemName() + "' could not be added to the party inventory!"); 
				System.out.println("The inventory cannot store more than " + inventoryGroupsLimit + " different item groups at a time!\n"); 				

			}
			else
			{
				// if no group with the item name exists already, add in a new group with 
				// the name of the item that is being added 
				if(itemGroup == null) 
				{
					// itemGroup array list of type String is created 
					itemGroup = new ArrayList<itemAttributesDefined>();
					
					// insert object into hashmap with object as key and item group as value 
					itemInventory.put(object, itemGroup);
				}
			}
			
			// if-else statement determines item group capacity. Remove if-else to 
			// add as many items as user wants (no item limit cap)
			if(itemGroup != null)
			{
				// if the itemGroup size is equal to itemGroupSizeLimit print out why 
				// object could not be added to an existing item group 
				if(itemGroup.size() == itemGroupSizeLimit)
				{
					// print statements saying that max number of items for the group has been reached 
					System.out.println("\n\n'" + object.getItemName() + "' could not be added to the party inventory!"); 
					System.out.println("The inventory cannot store more than " + itemGroupSizeLimit + " " +object.getItemName()+"s at a time!\n"); 
				}
				else
				{			
					// increment item group size by 1 by adding object to array list 
					itemGroup.add(object);
				}
			}
		}	
	}
	
	// method removes the specified object from the inventory if it exists 
	public <T extends itemAttributesDefined> void removeObject(T object)
	{
		/*
			The get(Object key) method is used to return the value to which 
			the specified key is mapped, or null if the hashmap contains no 
			mapping for the key.
		*/
			
		// check to see whether hashmap contains a mapping for key 
		// in this case, mapping refers to whether an item group for the object
		// already exists as an array list and if it does then it will be retrieved
		// Note: initial size of the array list was not set which is okay 
		ArrayList<itemAttributesDefined> itemGroup = itemInventory.get(object);
		
		// end method execution if object item group does not exist 
		if(itemGroup == null) return;
		
		// remove item from item group causing item group size to decrement by one 
		itemGroup.remove(object);

		// if item group contains no objects (it is empty), remove item group from 
		// the item inventory hashmap by removing its key and value 
		if(itemGroup.size() == 0)
		{
			itemInventory.remove(object, itemGroup);
		}
	}
	
	// prints contents of hashmap inventory like so: position # itemName: # of items 
	public <T extends itemAttributesDefined> void printInventory()
	{
		// initialize counter instance variable to 0 each time the method is called 
		counter = 1; 
		
		/*
		
		Iterator it = itemInventory.entrySet().iterator();
		
		while (it.hasNext()) 
		{
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}
		
		*/
		
		// if there is at least one object stores in the party inventory then enter 
		// the if statement else print out statement saying inventory is empty 
		if(itemInventory.size() !=  0)
		{
			// for loop creates hashmap object itemInventoryCopy with itemAttributesDefined
			// as its key and an array list of type itemAttributesDefined as its value which 
			// is identical to the types of hashmap object itemInventory 
			// itemInventoryCopy iterates across itemInventory and retrieves all of the entry 
			// sets (keys and values) of hashmap itemInventory 
			for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet()) 
			{
				// store name of the inventory item object in String variable objectName			
				objectName = itemInventoryCopy.getKey().getItemName();
				
				// format objectName such that the string is aligned 20 spaces to the left
				// using format modifier '-' with a specification of 20 before the s; if 
				// the modifier is not included, the string will default to the right 
				objectName = objectName.format("%-20s", objectName);
				
				// store array list associated with object key in array list object value
				ArrayList<itemAttributesDefined> value = itemInventoryCopy.getValue();
				
				// get the size of the item group (number of items inside of item group)
				arrayListTotal = value.size();
				
				// notify player about what is about to be printed 
				if(counter  == 1)
				{
					System.out.println("Contents of party inventory...");
				}
				
				// if-else statement displays the party inventory 
				// if remainder is 1, display item on left otherwise display it on the right 
				if(counter % 2 == 1)
				{
					System.out.printf("(%d). %s: %d", counter, objectName, arrayListTotal);
						counter++;
				}
				else 
				{
					System.out.printf("\t(%d). %s: %d\n", counter, objectName, arrayListTotal);
						counter++;
				}
			}
		}
		else
		{
			System.out.println("There are no items stored in the party inventory.");
		}
		
		// print new line to improve readability 
		System.out.println();
	}
	
	
	/*
		items class 
			private String[] usage = {"consumable", "throwable", "field", "unusable", "key item"};

	
		Customization options for items inventory (sort alphabetically)
			
			Customize:	player personally customizes item placement in inventory 
			Specific Sort
			  - example1
			  - example2
			  - example3
			General Sort 
			  - example1
			  - example2
			  - example3
			
			(Specific Sort)
			exclusive to "items" class only 
				Consumable:	items that can be used by party members 
				Throwable:	items that can be thrown at an enemy 
				Unusable:	items that cannot be used in any way 
				Key Item:	items that play an important role in the story; cannot be sold
				Field: 		items exclusively meant to be used outside of battle 
			
			(General Sort)
			Name: 			sort by item name 
			Most: 			sort items by quantity with the most being at the top (or front)
			Least: 			sort items by quantity with the least being at the top (or front)
			Category: 		sort by category that item belongs to 			
			Super Type: 	sort by item superType (group)
			Sub Type: 		sort by item subType (sub group)
			Buy Price: 		sort by most expensive items to buy 
			Sell Price: 	sort by items that sell for the most 
						
	*/
	
	// method below must be updated or removed
	
	
	/*
	
	// method where only inventory items of a desired item type are printed 
	public void printDesiredItems(String desiredType) 
	{
		// initialize counter instance variable to 0 each time the method 
		// printWeaponsOnly() is called 
		counter = 0; 
		
		// for loop creates hashmap object to access info in itemInventory hashmap
		// it traverses itemInventory hashmap until all entries are accounted for 
		for(Map.Entry<String, ArrayList<String>> itemInventoryCopy : itemInventory.entrySet()) 
		{
			
			if(keyType(itemInventoryCopy.getKey()).equals(desiredType))
			{
				// get key for current inventory item 
				// key is the name of the item in the hashmap 
				key = itemInventoryCopy.getKey();
			
				// format key so that string is written 20 spaces from start position 
				// format modifier '-' alligns string to the left instead of right
				key = key.format("%-20s", key);
			
				// get and store value associated with key 
				// value is the item group 
				ArrayList<String> value = itemInventoryCopy.getValue();
			
				// get size of item group (number of items inside item group)
				total = value.size();
			
				// notify player about what is about to be printed 
				if(counter  == 0)
				{
					System.out.println("Contents of weapons inventory...");
				}
			
				// if-else statement displays list 
				// if remainder is 0, display item on left otherwise display on right 
				if(counter % 2 == 0)
				{
					System.out.print(counter + ". " + key + ": " + total);
						counter++;
				}
				else 
				{
					System.out.print("\t" + counter + ". " + key + ": " + total + "\n");
						counter++;
				}
			}
		}
		
		// print new line to improve readability 
		System.out.print("\n");
	}
	
	// method returns the type of an item key type which is shown in the first 
	// 4 characters of the key name 
	public String keyType(String key) 
	{
		return key.substring(0, 4);
	}
	
	*/
	
}
