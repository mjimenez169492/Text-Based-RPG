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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// create inventories for: items, weapons, armors, and accessories with add, remove, 
// and print inventory methods 

public class partyInventory 
{		
	// instance variables 
	private int inventoryLimit; 
	//private int weaponLimit = 5;		\ 	
	//private int armorLimit = 15; 		 | --> consider separate variables to manage
	//private int accessoryLimit = 20; 	/	   limits in other inventories
	private String key;
	private int counter;
	private int total;
	
	// create hashmap inventory that will exclusively store items 
	HashMap<String, ArrayList<String>> itemsInventory = new HashMap<String, ArrayList<String>>();
	
	// method adds item to items inventory 
	public void addItem(items item)
	{
		// set item limit for item inventory 
		inventoryLimit = 15;
		
		// create item group array list and assign it the name of the item to be 
		// added to the hashmap 
		ArrayList<String> itemGroup = itemsInventory.get(item.getItemName());

		// if no group with the item name exists already, add in a new group with 
		// the name of the item that is being added 
		if(itemGroup == null) 
		{
			itemGroup = new ArrayList<String>();
			
			// insert item name as key and the itemgroup as its value 
			itemsInventory.put(item.getItemName(), itemGroup);
		}
		
		// if-else statement determines item group capacity. Remove if-else to 
		// add as many items as user wants 
		if(itemGroup.size() < inventoryLimit)
		{
			itemGroup.add(item.getItemName());
		}
		else
		{
			System.out.println("\n\nItem '" + item.getItemName() + "' could not be added to the items inventory!"); 
			System.out.println("Inventory items cannot store more than " + inventoryLimit + " " +item.getItemName()+"s at a time!\n"); 
		}
	}
	
	// method removes item from inventory 
	public void removeItem(items item)
	{
		// item group object created and assigned key belonging to item that will
		// be removed
		ArrayList<String> itemGroup = itemsInventory.get(item.getItemName());
		
		// end method execution if item from item group does not exist 
		if(itemGroup == null) return;
		
		// remove item from item group causing the item group size to decrement 
		// by one 
		itemGroup.remove(item.getItemName());

		// if item group contains no items (i.e. empty), remove the item group
		// from the item inventory hashmap by removing its key and value 
		if(itemGroup.size() == 0)
		{
			itemsInventory.remove(item.getItemName(), itemGroup);
		}
	}
	
	// prints contents of hashmap inventory like so: itemName: # of items 
	public void printItemsInventory()
	{
		// initialize counter instance variable to 0 each time the method 
		// printItemsInventory() is called 
		counter = 0; 
		
		// for loop creates hashmap object to access info in itemsInventory hashmap
		// it traverses itemsInventory hashmap until all entries are accounted for 
		for(Map.Entry<String, ArrayList<String>> itemsInventoryCopy : itemsInventory.entrySet()) 
		{
			// get key for current inventory item 
			// key is the name of the item in the hashmap 
			key = itemsInventoryCopy.getKey();
			
			// format key so that key can only contain a 16 character string 
			key = key.format("%1.16s", key);
			
			// format key so that string is written 16 spaces from start position 
			// format modifier '-' alligns string to the left instead of right
			key = key.format("%-16s", key);
			
			// get and store value associated with key 
			// value is the item group 
			ArrayList<String> value = itemsInventoryCopy.getValue();
			
			// get size of item group (number of items inside item group)
			total = value.size();
			
			// notify player about what is about to be printed 
			if(counter  == 0)
			{
				System.out.println("Contents of items inventory...");
			}
			
			// if-else statement displays list 
			// if remainder is 0, display item on left otherwise display item on 
			// the right 
			if(counter % 2 == 0)
			{
				System.out.print(key + ": " + total);
					counter++;
			}
			else 
			{
				System.out.print("\t" + key + ": " + total + "\n");
					counter++;
			}
		}
		
		// print new line to improve readability 
		System.out.print("\n");
	}
}
