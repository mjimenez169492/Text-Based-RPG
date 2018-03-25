/* 
	public class partyInventory contains a linked hashmaps and treemaps which are 
	used as a means of storing objects that are created from subclasses of superclass
	itemAttributesDefined. This means that the party inventory will contain items, 
	weapons, armors, and accessories
*/

/*
	In terms of organization, there are three options currently being considered and 
	they are: 1) TreeMap, 2) HashMap, and 3) LinkedHashMap. 
	
	
	
		import java.util.ArrayList;
		import java.util.TreeMap;
		import java.util.Map;
	
				key of type 	value of type
			TreeMap<String, ArrayList<String>> inventory = new TreeMap<String, ArrayList<String>>();
	
		TreeMap has O(log(n)) complexity which is slower than HashMap which has O(1) 
		complexity. TreeMap always keeps the elements in a sorted(increasing) order, 
		while the elements in a HashMap have no defined order. Ordering within TreeMap
		can be chanhed by the programmer if a sort method is created and implemented.
		
		
		
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.Map;
	
				key of type 	value of type
			HashMap<String, ArrayList<String>> inventory = new HashMap<String, ArrayList<String>>();

		The HashMap appears favorable for it allows a programmer to have a bit more
		flexibility when it comes to organization since the items in the HashMap that
		had their positions moved would not be sorted by increasing order afterwards
		as they would in a TreeMap. Hashmaps do not order by insertion order. 
	
	
	
		import java.util.ArrayList;
		import java.util.LinkedHashMap;
		import java.util.Map;
		
				key of type 	value of type
			LinkedHashMap<String, ArrayList<String>> inventory = new HashMap<String, ArrayList<String>>();
		
		Hash table and linked list implementation of Map interface, with predictable 
		iteration order. Implementation differs from HashMap in that it maintains a 
		doubly-linked list running through all its entries. This linked list defines 
		the iteration ordering, which is normally the order in which the keys were 
		inserted into the map (insertion-order). This technique is useful if a module 
		takes a map on input, copies it, and later returns results whose order is 
		determined by that of the copy. (Clients generally appreciate having things 
		returned in the same order they were presented.)
	
	Some handy HashMap/TreeMap/LinkedHashMap methods called by HashMap object inventory...
		
		inventory.entrySet()	displays a HashMap key and its corresponding value 
		inventory.keySet()		displays the 'key' within a HashMap
		inventory.values()		displays the 'value' within a HashMap
*/

//import java.util.Iterator;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class partyInventory 
{	
	private int inventoryGroupsLimit; 	// limits number of different item groups that
										// can exist in the inventory 			(put 2)
	private int itemGroupSizeLimit;		// limit number of items that can be "stacked"
										// or held in a group in an inventory 	(put 2) 
	private String objectName;			// hold the name of an object in the inventory 
	private int arrayListTotal;			// holds total number of items in an item group 
	private int counter;				// denotes position of an item in the inventory
	private int stringComparisonResult; // store result of string comparison (1, 0, -1)
	private int intComparisonResult;	// store result of an int comparison (1, 0, -1)
	private int specifiedSortChoice;	// value determines which class will be sorted 
										// in the selection sort method (accepts # 1-4)
	
	// item categories which object must belong to in order to be stored in inventory
	private String[] validItemCategories = {"items", "cores", "weapons", "armors", "accessories"}; 	
	
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
		
	// constructor initializes inventoryGroupsLimit and itemGroupSizeLimit for partyInventory 
	public partyInventory(int inventoryGroupsLimit, int itemGroupSizeLimit)
	{
		setInventoryGroupsLimit(inventoryGroupsLimit);
		setItemGroupSizeLimit(itemGroupSizeLimit);
	}
	
	// create LinkedHashMap object itemInventory that will serve as an inventory for 
	// the game by storing the objects collected; it has itemAttributesDefined as its
	// key (accepts only objects created in subclasses of itemAttributesDefined) and 
	// an array list of type itemAttributesDefined as its value 
	LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventory = 
		new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();
	
	// method determines if object about to be added to the inventory is valid or not 
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
					// assign validArgument if object category matches element in array
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
	
		// note on usage of generics (sort of): 
		// subclass method below has Vehicle as the superclass 
		// style: public <T extends Vehicle> void exampleMethod(Class<T> type)
		// where T is an object of Vehicle which allows use of superclass methods
	
	// method adds object to the inventory if it passes several checks 
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
			
			// check to see whether linked hashmap itemInventory contains mapping for 
			// key where mapping refers to whether an item group for object already 
			// exists as an array list and if it does then it will be retrieved 
			ArrayList<itemAttributesDefined> itemGroup = itemInventory.get(object);
			
			// if item group limit is equal to the size of itemInventory, print out
			// statements saying why object could not be added else create new array
			// list for the object and put it into the itemInventory 
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
			
		// check to see whether itemInventory contains mapping for key where mapping 
		// refers to whether an item group for the object already exists as an array 
		// list and if it does then it will be retrieved
		ArrayList<itemAttributesDefined> itemGroup = itemInventory.get(object);
		
		// end method execution if object item group does not exist 
		if(itemGroup == null) return;
		
		// remove item from item group causing item group size to decrement by one 
		itemGroup.remove(object);

		// if item group contains no objects (it is empty), remove item group from 
		// itemInventory by removing its key and value 
		if(itemGroup.size() == 0)
		{
			itemInventory.remove(object, itemGroup);
		}
	}
	
	/*
		Alternative method for hashmap iteration
		
		Iterator it = itemInventory.entrySet().iterator();
		
		while (it.hasNext()) 
		{
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}
	*/
	
	// prints contents of itemInventory like so: position #. itemName: # of items 
	public void printInventory()
	{
		// initialize counter instance variable to 1 each time the method is called 
		counter = 1; 
		
		// if there is at least one object stores in itemInventory then enter the if 
		// statement else print out statement saying itemInventory is empty 
		if(itemInventory.size() !=  0)
		{
			// enhanced for loop creates linked hashmap object itemInventoryCopy with 
			// a key and value type identical to the types of linked hashmap object 
			// itemInventory; itemInventoryCopy iterates through itemInventory and 
			// retrieves all entry sets (keys and values) of itemInventory 
			for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet()) 
			{
				// store name of the inventory item object in String variable objectName			
				objectName = itemInventoryCopy.getKey().getItemName();
				
				// format objectName such that the string is aligned 20 spaces to the left
				// using format modifier '-' with a specification of 20 before the s; if 
				// the modifier is not included, the string will default to the right 
				objectName = objectName.format("%-20s", objectName);
				
				// get and store item group size (number of objects in item group)
				arrayListTotal = itemInventoryCopy.getValue().size();
				
				// notify user about what is about to be printed 
				if(counter  == 1)
				{
					System.out.println("Contents of party inventory...");
				}
				
				// if-else statement displays itemInventory along with a counter 
				// if remainder is 1, display item on left otherwise display it on the right 
				if(counter % 2 == 1)
				{
					System.out.printf("(%d).\t%s: %d\t", counter, objectName, arrayListTotal);
						counter++;
				}
				else 
				{
					System.out.printf("\t(%d).\t%s: %d\n", counter, objectName, arrayListTotal);
						counter++;
				}
			}
		}
		else
		{
			// print statement only if there are no items in the inventory
			System.out.println("There are no items stored in the party inventory.");
		}
		
		// print new line to improve readability 
		System.out.println();
	}
	
	// Sorting Linked Hashmaps and TreeMaps...
	/*
		Sorting options for items inventory 
			
			Customize:			player personally customizes item placement in inventory 
			Specified Sort:		sort inventory such that certain objects are at the top of the list 
			  - items
			  - weapons
			  - armors
			  - accessories
				- itemId									NOT IMPLEMENTED 
				- itemName
				- itemCategory
				- itemSuperType
				- itemSubType
				- itemBuyPrice
				- itemSellPrice);
				- highestQuantity
				- lowestQuantity
			General Sort:		sort all objects at once as desired 
			  - itemId			sort by item Id				NOT IMPLEMENTED 
			  - itemName		sort by item name 
			  - itemCategory	sort by category that item belongs to 	
			  - itemSuperType	sort by item superType (group)
			  - itemSubType		sort by item subType (sub group)
			  - itemBuyPrice	sort by most expensive items to buy 
			  - itemSellPrice	sort by items that sell for the most
			  - highestQuantity	sort items by quantity with the most being at the top (or front)
			  - lowestQuantity	sort items by quantity with the least being at the top (or front)
	*/
	
	// START: CUSTOMIZE 
	// SWAP POSITIONS OF TWO ENTRY SETS IN INVENTORY IF SUPPLIED POSITIONS ARE VALID
	/********************************************************************************/
	
	// method places itemInventory entry sets in linked hashmap object holdItemInventory 
	// and places entry sets meant to be swapped in linked hashmap object swapEntries
	public void customizeSwapInventoryContents(LinkedHashMap<itemAttributesDefined, 
		ArrayList<itemAttributesDefined>> holdItemInventory, LinkedHashMap<itemAttributesDefined, 
		ArrayList<itemAttributesDefined>> swapEntries, int entrySelected, int swapToPosition)
	{
		// assign counter to 1 to start counting from 1 or first entry 
		counter = 1;
		
		// enhanced for loop iterates through contents of itemInventory using linked
		// hashmap object itemInventoryCopy
		for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet()) 
		{
			// store entries of itemInventory linked hashmap in linked hashmap holdItemInventory 
			holdItemInventory.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());				
			
			// if-else statement manages the storage of entry sets in linked hashmap swapEntries
			if(counter == entrySelected)
			{
				// store entry set selected for swapping in linked hashmap swapEntries
				swapEntries.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
			}
			else if(counter == swapToPosition)
			{
				// store entry set that will be swapped with desired entry set in linked hashmap swapEntries
				swapEntries.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
			}
			
			// increment counter variable 
			counter++;
		}
	}
	
	// method fills itemInventory with contents of linked hashmap holdItemInventory 
	// (which holds all the entry sets itemInventory had before it was cleared) and 
	// linked hashmap swapEntries which holds the entry sets meant to be swapped 
	public void customizeFillItemInventory(LinkedHashMap<itemAttributesDefined, 
		ArrayList<itemAttributesDefined>> holdItemInventory, LinkedHashMap<itemAttributesDefined, 
		ArrayList<itemAttributesDefined>> swapEntries, int entrySelected, int swapToPosition)
	{
		// assign counter to 1 to start counting from 1 or first entry
		counter = 1;
		
		// enhanced for loop creates linked hashmap object holdItemInventoryCopy to 
		// iterate through entry sets of linked hashmap holdItemInventory 
		for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventoryCopy : holdItemInventory.entrySet())
		{
			// make swaps when counter reaches of the locations specified for swap
			if(counter == entrySelected)
			{
				// enhanced for loop creates linked hashmap object swapEntriesCopy
				// to iterate through entry sets of linked hashmap swapEntries
				for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> swapEntriesCopy : swapEntries.entrySet())
				{
					// if swapEntriesCopy key does not match holdItemInventoryCopy key 
					// then put key and value stored in the entry set of swapEntriesCopy
					// in linked hashmap itemInventory 
					if(!holdItemInventoryCopy.getKey().equals(swapEntriesCopy.getKey()))
					{
						itemInventory.put(swapEntriesCopy.getKey(), swapEntriesCopy.getValue());
					}
				}
			}
			else if(counter == swapToPosition)
			{
				// enhanced for loop creates linked hashmap object swapEntriesCopy
				// to iterate through entry sets of linked hashmap swapEntries
				for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> swapEntriesCopy : swapEntries.entrySet())
				{
					// if swapEntriesCopy key does not match holdItemInventoryCopy key 
					// then put key and value stored in the entry set of swapEntriesCopy
					// in linked hashmap itemInventory 
					if(!holdItemInventoryCopy.getKey().equals(swapEntriesCopy.getKey()))
					{
						itemInventory.put(swapEntriesCopy.getKey(), swapEntriesCopy.getValue());
					}
				}
			}
			else
			{
				// insert key and value of holdItemInventoryCopy into itemInventory
				itemInventory.put(holdItemInventoryCopy.getKey(), holdItemInventoryCopy.getValue());
			}
			
			// increment counter by one 
			counter++;
		}
	}
	
	// methods allows users to "customize" object positions on linked hashmap itemInventory
	// by allowing them to swap one entry set with another if possible 
	public void customizeInventory(int entrySelected, int swapToPosition)
	{
		/*	Note: it would be silly to swap an entry set with itself so do nothing if
				  the user supplies arguments that are the same value */
		
		// if integers are not the same, enter if statement 
		if(entrySelected != swapToPosition)
		{
			// if entrySelected is within the bounds of the inventory, enter if statement  
			if(entrySelected >= 1 && entrySelected <= itemInventory.size())
			{
				// if swapToPosition is within the bounds of the inventory, enter if statement  
				if(swapToPosition >= 1 && swapToPosition <= itemInventory.size())
				{
					// enter if statement only if there is more than one entry set in 
					// linked hashmap itemInventory since swapping the only entry set 
					// with itself is pretty silly 
					if(itemInventory.size() >  1)
					{
						// linked hashmap object holdItemInventory stores itemInventory 
						// entry sets 
						LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory = 
							new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();
						
						// linked hashmap object swapEntries stores entry sets that the 
						// user wants to swap which are located at position entrySelected 
						// and swapToPosition 
						LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> swapEntries = 
							new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();
						
						// supply linked hashmaps created in customizeInventory() and 
						// int values passed to customizeInventory() to the method 
						// customizeSwapInventoryContents()
						customizeSwapInventoryContents(holdItemInventory, swapEntries, entrySelected, swapToPosition);
						
						// clear contents itemInventory in order to place entry sets of 
						// holdItemInventory and swapEntries in itemInventory later on 
						itemInventory.clear();
						
						// supply linked hashmaps created in customizeInventory() and 
						// int values passed to customizeInventory() to the method 
						// customizeFillItemInventory()
						customizeFillItemInventory(holdItemInventory, swapEntries, entrySelected, swapToPosition);
					}
				}
			}
		}
		// print new line to improve readability 
		System.out.println();
	}
	
	// END: CUSTOMIZE
	/********************************************************************************/
	
	
	
	
	
	
	// START: COMPARATORS
	// COLLECTION OF COMPARATORS USED TO SORT TREEMAPS A CERTAIN WAY
	/********************************************************************************/

	/*	Notes on Comparator library: 
		
			Has comparison function, which imposes a total ordering on some collection 
			of objects. Comparators can be passed to a sort method (such as the method 
			Collections.sort or Arrays.sort) to allow precise control over sort order. 
			Comparators can also be used to control the order of some data structures 
			(such as sorted sets or sorted maps), or to provide some form of ordering 
			for collections of objects that don't have a natural ordering. Ordering 
			imposed by comparator c on a set of elements S is said to be consistent 
			with equals if and only if c.compare(e1, e2)==0 has same boolean value as e1.equals(e2) 
			for every e1 and e2 in S. 
			
			To create a custom comparator: 
			Override existing comparator 
			Comparator must have the same type as the key in TreeMap 
			Comparator must end with a semicolon symbol (;)
				SORTING is done by key NOT by value */
	
	// START: COMPARATORS: KEY COMPARATORS 
	// SORT TREEMAPS BY KEY ACCORDING TO RULE ESTABLISHED BY COMPARATOR 
	/*------------------------------------------------------------------------------*/
	
	// compare two strings and determine whether they are the same or different regardless
	// of case (i.e. "example" would be considered the same as "Example") 
	// method used in comparators for TreeMaps involving string comparison between keys
	public int compareStrings(String argumentOne, String arguementTwo)
	{
		// code compares names without regard to case and stores result of comparison 
		// (1, 0, -1) in variable stringComparisonResult (1, -1 is different & 0 is same)
		stringComparisonResult = String.CASE_INSENSITIVE_ORDER.compare(argumentOne, arguementTwo);
		
		// if strings are identical, set stringComparisonResult to 1 in order to place 
		// entry after the entry it is being compared to since order does not matter 
		// as they are the same String wise 
		if(stringComparisonResult == 0)
		{
			// if stringComparisonResult was not changed here, the key of the entry 
			// that is being compared to the key of entry that exists in the TreeMap 
			// would "merge/disappear" or not be added to the TreeMap along with its 
			// value resulting in data loss 
			stringComparisonResult = 1;
		}
		
		// return value held in stringComparisonResult
		return stringComparisonResult;
	}
	
	// compare int values and return whether they are the same or different 
	// method used in comparators for TreeMaps involving int comparison between keys
	public int compareIntegers(int argumentOne, int arguementTwo)
	{
		// place arguementTwo after argumentOne if it is less than argumentOne else 
		// put arguementTwo above argumentOne 
		if (argumentOne >= arguementTwo)
		{
			intComparisonResult = -1;
		} 
		else
		{
			intComparisonResult = 1;
		}
		
		// return value held in intComparisonResult
		return intComparisonResult;
	}
	
	// why compareTo() is not used...
	// compareTo() method sorts by: number, Uppercase, lowercase -> 1Apple, Apple, Bee, apple
		
	// custom TreeMap comparator sorts the objects of a TreeMap by name alphabetically
	public Comparator<itemAttributesDefined> sortByName = new Comparator<itemAttributesDefined>() 
	{
		// method compares the names of each object and sorts the objects such that
		// they are alphabetically ordered by name (ascending order from A to Z) 
		@Override 
		public int compare(itemAttributesDefined objectOne, itemAttributesDefined objectTwo) 
		{
			// return result of string comparison which will dictate TreeMap ordering
			return compareStrings(objectOne.getItemName(), objectTwo.getItemName());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by category alphabetically
	public Comparator<itemAttributesDefined> sortByCategory = new Comparator<itemAttributesDefined>() 
	{
		// method compares the category of each object and sorts the objects such that
		// they are ordered alphabetically by category name (ascending order from A to Z) 
		@Override 
		public int compare(itemAttributesDefined objectOne, itemAttributesDefined objectTwo) 
		{
			// return result of string comparison which will dictate TreeMap ordering
			return compareStrings(objectOne.getItemCategory(), objectTwo.getItemCategory());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by super type alphabetically
	public Comparator<itemAttributesDefined> sortBySuperType = new Comparator<itemAttributesDefined>() 
	{
		// method compares the super type of each object and sorts the objects such that
		// they are ordered alphabetically by super type (ascending order from A to Z)  
		@Override 
		public int compare(itemAttributesDefined objectOne, itemAttributesDefined objectTwo) 
		{
			// return result of string comparison which will dictate TreeMap ordering
			return compareStrings(objectOne.getItemSuperType(), objectTwo.getItemSuperType());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by sub type alphabetically
	public Comparator<itemAttributesDefined> sortBySubType = new Comparator<itemAttributesDefined>() 
	{
		// method compares the sub type of each object and sorts the objects such that
		// they are ordered alphabetically by sub type (ascending order from A to Z)  
		@Override 
		public int compare(itemAttributesDefined objectOne, itemAttributesDefined objectTwo) 
		{
			// return result of string comparison which will dictate TreeMap ordering
			return compareStrings(objectOne.getItemSubType(), objectTwo.getItemSubType());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by highest buy price 
	public Comparator<itemAttributesDefined> sortByBuyPrice = new Comparator<itemAttributesDefined>() 
	{
		// method compares the buy price of each object and sorts the objects such that
		// they are ordered by buy price (ascending order with expensive objects on top)  
		@Override 
		public int compare(itemAttributesDefined objectOne, itemAttributesDefined objectTwo) 
		{
			// return result of int comparison which will dictate TreeMap ordering
			return compareIntegers(objectOne.getItemBuyPrice(), objectTwo.getItemBuyPrice());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by lowest sell price
	public Comparator<itemAttributesDefined> sortBySellPrice = new Comparator<itemAttributesDefined>() 
	{
		// method compares the sell price of each object and sorts the objects such that
		// they are ordered by sell price (ascending order with least expensive objects on top)  
		@Override 
		public int compare(itemAttributesDefined objectOne, itemAttributesDefined objectTwo) 
		{
			// return result of int comparison which will dictate TreeMap ordering
			return compareIntegers(objectOne.getItemSellPrice(), objectTwo.getItemSellPrice());
		}
	}; 
	
	// USE ONLY FOR KEY-VALUE SWAP OPERATIONS 
	// custom TreeMap comparator sorts the objects of a TreeMap by highest quantity
	public Comparator<ArrayList<itemAttributesDefined>> sortByHighestQuanity = new Comparator<ArrayList<itemAttributesDefined>>() 
	{
		// method compares the size (quantity) of each array list and sorts them such 
		// that they are ordered by size (ascending order with highest quantity on top)  
		@Override 
		public int compare(ArrayList<itemAttributesDefined> arrayListOne, ArrayList<itemAttributesDefined> arrayListTwo) 
		{
			// return result of int comparison which will dictate TreeMap ordering
			return compareIntegers(arrayListOne.size(), arrayListTwo.size());
		}
	}; 
	
	// USE ONLY FOR KEY-VALUE SWAP OPERATIONS 
	// custom TreeMap comparator sorts the objects of a TreeMap by lowest quantity
	public Comparator<ArrayList<itemAttributesDefined>> sortByLowestQuanity = new Comparator<ArrayList<itemAttributesDefined>>() 
	{
		// method compares the size (quantity) of each array list and sorts them such 
		// that they are ordered by size (ascending order with lowest quantity on top)  
		@Override 
		public int compare(ArrayList<itemAttributesDefined> arrayListOne, ArrayList<itemAttributesDefined> arrayListTwo) 
		{
			// return result of int comparison which will dictate TreeMap ordering
			// multiply value of comparison by negative 1 (-1) to inverse the order
			// given by comparator sortByHighestQuanity to sort by lowest quantity
			return -1 * compareIntegers(arrayListOne.size(), arrayListTwo.size());
		}
	}; 
	
	// END: COMPARATORS: KEY COMPARATORS 
	/*------------------------------------------------------------------------------*/

	// END: COMPARATORS
	/********************************************************************************/
	
	
	
	
	
	
	// SORT: SPECIFIED SORT
	// SORT  SPECIFIED CLASS OBJECTS ONLY BY NAME, CATEGORY, SUPER TYPE, SUB TYPE, 
	// 		 BUY PRICE, SELL PRICE, HIGHEST QUANTITY, AND LOWEST QUANTITY
	/********************************************************************************/

	// START: METHODS USED THROUGHOUT SPECIFIED SORT
	// METHODS ARE USED TO REDUCE DUPLICATE CODE AND TO ISOLATE ERRORS THEY MAY CAUSE
	/*------------------------------------------------------------------------------*/	

	// return an integer that is within the specified bounds as indicated below
	public int checkSelectionSortChoice(int choice)
	{
		// if-else checks the integer that is supplied andif it is not valid then the 
		// value of their choice is altered to be within the specified bounds 
		if(choice < 1)
		{
			choice = 1;
		}
		else if(choice > 5)
		{
			choice = 5;
		}
		
		// return users choice after it was checked
		return choice;
	}
	
	// for specified sort, objects from the items, weapons, armors, and accessories
	// classes will need to be filtered into a TreeMap and a linked hashmap such 
	// that objects from a certain class as sorted while others are left alone and
	// this is done by having a switch statement put the desired class objects in 
	// the TreeMap and linked hashmap according to the integer supplied 
	public void sortObjectsByClass(TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy, 
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory, int choice)
	{
		// switch statement determines what class objects are stored and sorted in TreeMap
		// through the use of an enhanced for loop 
		switch(choice)
		{
			case 1: // sort objects from class items ONLY
				for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet())
				{
					if(itemInventoryCopy.getKey().getClass() == items.class)
					{
						sortObjectsBy.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
					else
					{
						holdItemInventory.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
				}
					break;
			case 2: // sort objects from class weapons ONLY
				for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet())
				{
					if(itemInventoryCopy.getKey().getClass() == weapons.class)
					{
						sortObjectsBy.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
					else
					{
						holdItemInventory.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
				}
					break;
			case 3: // sort objects from class armors ONLY
				for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet())
				{
					if(itemInventoryCopy.getKey().getClass() == armors.class)
					{
						sortObjectsBy.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
					else
					{
						holdItemInventory.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
				}
					break;
			case 4: // sort objects from class accessories ONLY
				for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet())
				{
					if(itemInventoryCopy.getKey().getClass() == accessories.class)
					{
						sortObjectsBy.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
					else
					{
						holdItemInventory.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
				}
					break;
			case 5: // sort objects from class cores ONLY
				for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet())
				{
					if(itemInventoryCopy.getKey().getClass() == cores.class)
					{
						sortObjectsBy.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
					else
					{
						holdItemInventory.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
					}
				}
					break;
		}
	}
	
	// method fills contents of itemInventory with contents of sorted TreeMap followed 
	// by linked hashmap that holds all of the other entry sets once held in itemInventory
	public void specifiedFillItemInventory(TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy, 
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory)
	{
		// enhanced for loop places sorted entry sets from TreeMap into itemInventory first 
		for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsByCopy : sortObjectsBy.entrySet())
		{
			itemInventory.put(sortObjectsByCopy.getKey(), sortObjectsByCopy.getValue());
		}
		
		// enhanced for loop places entry sets of linked hashmap back into itemInventory  
		for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventoryCopy : holdItemInventory.entrySet())
		{
			itemInventory.put(holdItemInventoryCopy.getKey(), holdItemInventoryCopy.getValue());		
		}
	}
	
	// sort desired class objects, empty party inventory itemInventory, and put all 
	// contents of the TreeMap and linked hashmap back into itemInventory
	public void specifiedSort(TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy, 
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory, int choice)
	{
		// pass TreeMap, linked hashmap and, and the choice for what class objects will 
		// be sorted to method sortObjectsByClass
		sortObjectsByClass(sortObjectsBy, holdItemInventory, checkSelectionSortChoice(choice));
		
		// clear itemInventory in order to refill it with the sorted TreeMap entry sets 
		// first followed by the entry sets of holdItemInventory
		itemInventory.clear();
		
		// pass TreeMap and linked hashmap to method specifiedFillItemInventory() to 
		// fill itemInventory after the specified sort
		specifiedFillItemInventory(sortObjectsBy, holdItemInventory);
	}
	
	// method stores the key of one TreeMap as the value of the other TreeMap and the
	// value of the first TreeMap as the key of the second TreeMap
	public void specifiedSwapKeysAndValues(TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy, 
		TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined> sortArrayListBy)
	{
		// enhanced for loop performs key/value swapping using TreeMap object sortObjectsByCopy
		for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsByCopy : sortObjectsBy.entrySet())
		{
			sortArrayListBy.put(sortObjectsByCopy.getValue(), sortObjectsByCopy.getKey());
		}
	}
	
	// method refills itemInventory with contents of sorted TreeMap that contains the 
	// values of itemInventory as its keys and the keys as its values and the linked 
	// hashmap that stored the rest of the objects 
	public void specifiedRefillItemInventory(TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined> sortArrayListBy, 
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory)
	{
		// enhanced for loop places sorted entry sets from TreeMap into party inventory 
		// linked hashmap itemInventory by placing the value in the key slot and the 
		// key in the value slot 
		for(Map.Entry<ArrayList<itemAttributesDefined>, itemAttributesDefined> sortArrayListByCopy : sortArrayListBy.entrySet())
		{
			itemInventory.put(sortArrayListByCopy.getValue(), sortArrayListByCopy.getKey());
		}
		
		// enhanced for loop places the entry sets of a linked hashmap which originally 
		// belonged to the party inventory linked hashmap itemInventory  
		for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventoryCopy : holdItemInventory.entrySet())
		{
			itemInventory.put(holdItemInventoryCopy.getKey(), holdItemInventoryCopy.getValue());		
		}
	}
	
	// sort desired class objects by their quantity, empty party inventory itemInventory, 
	// and put all contents of the TreeMap and linked hashmap back into itemInventory
	public void specifiedValueSort(TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy, 
		TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined> sortArrayListBy,
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory, 
		int choice)
	{
		// pass TreeMap, linked hashmap and, and the choice for what class objects will 
		// be sorted to method sortObjectsByClass
		sortObjectsByClass(sortObjectsBy, holdItemInventory, checkSelectionSortChoice(choice));

		// swap keys with values and values with keys for each entry set and place them 
		// in TreeMap sortArrayListBy
		specifiedSwapKeysAndValues(sortObjectsBy, sortArrayListBy);
		
		// clear party inventory linked hashmap itemInventory in order to refill it the
		// sorted TreeMap entry sets first and followed by entry sets of holdItemInventory
		itemInventory.clear();
		
		// pass TreeMap and linked hashmap to method specifiedRefillItemInventory()
		specifiedRefillItemInventory(sortArrayListBy, holdItemInventory);
	}
	
	// END: METHODS USED THROUGHOUT SPECIFIED SORT
	/*------------------------------------------------------------------------------*/	
	
	
	
	// START: METHODS FOR SPECIFIED SORT OF KEYS
	// METHODS CONTAIN CODE WHICH SORT CERTAIN CLASS OBJECTS OF THE PARTY INVENTORY 
	/*------------------------------------------------------------------------------*/	
	
	// method sorts objects from class (category) specified by integer by name  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByName(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByName implemented at the end 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortByName);
		
		// linked hashmap object holdItemInventory stores all entry sets of itemInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory = 
			new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdItemInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class (category) specified by integer by category  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByCategory(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByCategory implemented at the end 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortByCategory);
		
		// linked hashmap object holdItemInventory stores all entry sets of itemInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory = 
			new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdItemInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class (category) specified by integer by super type  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortBySuperType(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortBySuperType implemented at the end 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortBySuperType);
		
		// linked hashmap object holdItemInventory stores all entry sets of itemInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory = 
			new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdItemInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class (category) specified by integer by sub type  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortBySubType(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortBySubType implemented at the end 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortBySubType);
		
		// linked hashmap object holdItemInventory stores all entry sets of itemInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory = 
			new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdItemInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class (category) specified by integer by buy price  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByBuyPrice(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByBuyPrice implemented at the end 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortByBuyPrice);
		
		// linked hashmap object holdItemInventory stores all entry sets of itemInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory = 
			new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdItemInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class (category) specified by integer by sell price  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortBySellPrice(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortBySellPrice implemented at the end 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortBySellPrice);
		
		// linked hashmap object holdItemInventory stores all entry sets of itemInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory = 
			new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort() 
		specifiedSort(sortObjectsBy, holdItemInventory, specifiedSortChoice);
	}
	
	// END: METHODS FOR SPECIFIED SORT OF KEYS
	/*------------------------------------------------------------------------------*/	
	
	
	
	// START: METHODS FOR SPECIFIED SORT OF VALUES
	// METHODS INVOLVE KEY AND VALUE SWAPPING ALLOWING FOR SORTING BY QUANTITY 
	/*------------------------------------------------------------------------------*/	
	
	// method sorts objects from class (category) specified by integer by highest
	// quantity and puts them at the top of the list (presents them first)
	public void specifiedSortByHighestQuantity(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// linked hashmap object holdItemInventory stores all entry sets of itemInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory = 
			new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();			
				
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByName implemented at the end and 
		// is needed in order to store the objects in a way TreeMao will understand 
		// Note: TreeMap needed to use sortObjectsByClass() to separate class objects
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortByName);		
		
		// TreeMap object sortArrayListBy will store the values of itemInventory as 
		// its key and the keys of itemInventory as its value and it will sort them 
		// using comparator sortByHighestQuanity
		TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined> sortArrayListBy = 
			new TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined>(sortByHighestQuanity);
		
		// pass both TreeMaps, the linked hashmap and, and the choice for what class 
		// objects will be sorted to method specifiedValueSort()
		specifiedValueSort(sortObjectsBy, sortArrayListBy, holdItemInventory, 
			checkSelectionSortChoice(choice));
	}
	
	// method sorts objects from class (category) specified by integer by lowest quantity
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByLowestQuantity(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// linked hashmap object holdItemInventory stores all entry sets of the party 
		// inventory hashmap itemInventory not stored in TreeMap sortObjectsBy
		LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> holdItemInventory = 
			new LinkedHashMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>();			
				
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByName implemented at the end and 
		// is needed in order to store the objects in a way TreeMao will understand 
		// Note: TreeMap needed to use sortObjectsByClass() to separate class objects
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortObjectsBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortByName);		
		
		// TreeMap object sortArrayListBy will store the values of itemInventory as 
		// its key and the keys of itemInventory as its value and it will sort them 
		// using comparator sortByLowestQuanity
		TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined> sortArrayListBy = 
			new TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined>(sortByLowestQuanity);
		
		// pass both TreeMaps, the linked hashmap and, and the choice for what class 
		// objects will be sorted to method specifiedValueSort()
		specifiedValueSort(sortObjectsBy, sortArrayListBy, holdItemInventory, 
			checkSelectionSortChoice(choice));
	}
	
	// END: METHODS FOR SPECIFIED SORT OF VALUES
	/*------------------------------------------------------------------------------*/	
	
	// END SORT: SPECIFIED SORT
	/********************************************************************************/
	
	
	
	
	
	
	// SORT: GENERAL SORT 
	// SORT ALL OBJECTS IN THE INVENTORY AT ONCE ACCORDING TO COMPARATOR SUPPLIED 
	/********************************************************************************/
	
	// START: METHODS USED THROUGHOUT GENERAL SORT
	// METHODS ARE USED TO REDUCE DUPLICATE CODE AND TO ISOLATE ERRORS THEY MAY CAUSE
	/*------------------------------------------------------------------------------*/	
	
	// method fills TreeMap with keys and values of itemInventory
	public void fillTreeMapKeyValue(TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryBy)
	{
		// enhanced for loop creates linked hashmap object itemInventoryCopy that can
		// be used get the keys and values of each entry set of the itemInventory
		for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet())
		{
			sortInventoryBy.put(itemInventoryCopy.getKey(), itemInventoryCopy.getValue());
		}
	}
	
	// method fills itemInventory with contents of the sorted TreeMap
	public void generalFillInventory(TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryBy)
	{
		// enhanced for loop creates linked hashmap object sortInventoryByCopy that can
		// be used get the keys and values of each entry set of the itemInventory
		for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryByCopy : sortInventoryBy.entrySet())
		{
			itemInventory.put(sortInventoryByCopy.getKey(), sortInventoryByCopy.getValue());
		}
	}
	
	// fill itemInventory with contents of sorted TreeMap by placing value of TreeMap 
	// as the key for itemInventory and the key as the value for itemInventory
	public void generalFillItemInventory(TreeMap<ArrayList<itemAttributesDefined>, 
		itemAttributesDefined> sortInventoryBy)
	{
		// enhanced for loop performs key and value swapping for TreeMap 
		for(Map.Entry<ArrayList<itemAttributesDefined>, itemAttributesDefined> sortInventoryByCopy : sortInventoryBy.entrySet())
		{
			itemInventory.put(sortInventoryByCopy.getValue(), sortInventoryByCopy.getKey());
		}
	}
	
	// method calls other methods to sort all objects in itemInventory using TreeMap
	public void generalSort(TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryBy)
	{
		// fill empty TreeMap which will sort by rules established by comparator
		fillTreeMapKeyValue(sortInventoryBy);
		
		// clear linked hashmap to fill it in later 
		itemInventory.clear();
		
		// fill in inventory with contents of sorted TreeMap
		generalFillInventory(sortInventoryBy);
	}
	
	// method puts the key of itemInventory as the value for the TreeMap and value as
	// the key of the TreeMap 
	public void generalSwapKeysAndValues(TreeMap<ArrayList<itemAttributesDefined>, 
		itemAttributesDefined> sortInventoryBy)
	{
		// enhanced for loop performs key and value swapping for TreeMap 
		for(Map.Entry<itemAttributesDefined, ArrayList<itemAttributesDefined>> itemInventoryCopy : itemInventory.entrySet())
		{
			sortInventoryBy.put(itemInventoryCopy.getValue(), itemInventoryCopy.getKey());
		}		
	}
	
	// method calls other methods to sort by value 
	public void generalValueSort(TreeMap<ArrayList<itemAttributesDefined>, 
		itemAttributesDefined> sortInventoryBy)
	{
		// swap keys and values of itemInventory with TreeMap sortInventoryBy
		generalSwapKeysAndValues(sortInventoryBy);
		
		// clear itemInventory to fill with sorted TreeMap contents later 
		itemInventory.clear();
		
		// fill itemInventory with contents of sorted TreeMap sortInventoryBy
		generalFillItemInventory(sortInventoryBy);
	}
	
	// END: METHODS USED THROUGHOUT GENERAL SORT
	/*------------------------------------------------------------------------------*/	

	
	
	// START: METHODS FOR GENERAL SORT OF KEYS
	// METHODS SORT ALL OBJECTS IN INVENTORY ACCORDING TO COMPARATOR OF TREEMAP
	/*------------------------------------------------------------------------------*/		
	
	// method sorts objects by name and puts them at the top of the list (presents them first)
	public void generalSortByName()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// name since it uses custom comparator sortByName at the end of it 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortByName);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by category and puts them at the top of the list (presents them first)
	public void generalSortByCategory()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// category since it uses custom comparator sortByCategory at the end of it 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortByCategory);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by super type and puts them at the top of the list (presents them first)
	public void generalSortBySuperType()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// super type since it uses custom comparator sortBySuperType at the end of it 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortBySuperType);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by sub type and puts them at the top of the list (presents them first)
	public void generalSortBySubType()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// sub type since it uses custom comparator sortBySubType at the end of it 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortBySubType);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by buy price and puts them at the top of the list (presents them first)
	public void generalSortByBuyPrice()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// buy price since it uses custom comparator sortBySubType at the end of it 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortByBuyPrice);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by sell price and puts them at the top of the list (presents them first)
	public void generalSortBySellPrice()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by buy price
		// since it uses custom comparator sortBySellPrice at the end of it 
		TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>> sortInventoryBy = 
			new TreeMap<itemAttributesDefined, ArrayList<itemAttributesDefined>>(sortBySellPrice);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// END: METHODS FOR GENERAL SORT OF KEYS
	/*------------------------------------------------------------------------------*/	
	
	
	
	// START: METHODS FOR GENERAL SORT OF VALUES
	// METHODS INVOLVE KEY AND VALUE SWAPPING ALLOWING FOR SORTING BY QUANTITY 
	/*------------------------------------------------------------------------------*/	

	// method sorts all objects in the inventory by highest quantity 
	public void generalSortByHighestQuantity()
	{	
		// TreeMap object sortInventoryBy sorts objects by highest quantity by using 
		// comparator sortByHighestQuanity
		TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined> sortInventoryBy = 
			new TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined>(sortByHighestQuanity);
		
		// pass TreeMap to method generalValueSort()
		generalValueSort(sortInventoryBy);
	}
	
	// method sorts all objects in the inventory by lowest quantity 
	public void generalSortByLowestQuantity()
	{	
		// TreeMap object sortInventoryBy sorts objects by highest quantity by using 
		// comparator sortByLowestQuanity
		TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined> sortInventoryBy = 
			new TreeMap<ArrayList<itemAttributesDefined>, itemAttributesDefined>(sortByLowestQuanity);
		
		// pass TreeMap to method generalValueSort()
		generalValueSort(sortInventoryBy);
	}
	
	// END: METHODS FOR GENERAL SORT OF VALUES
	/*------------------------------------------------------------------------------*/	
	
	// END: GENERAL SORT 
	/********************************************************************************/
}
