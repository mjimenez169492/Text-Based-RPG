/* 
	public class partyInventory contains linked hashmaps and treemaps which are used 
	as a means of storing and sorting objects created from subclasses of superclass 
	genericObject respectively. 
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
		flexibility when it comes to organization since the objects in the HashMap that
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

import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class inventory 
{	
	private int inventoryGroupsLimit; 	// limits number of different object groups that
										// can exist in the inventory 
	private int objectGroupSizeLimit;	// limit number of objects that can be "stacked"
										// or held in a group in an inventory 
	private String objectName;			// holds the name of an object in the inventory 
	private int arrayListTotal;			// holds total number of objects in an object group 
	private int counter;				// denotes position of an object in the inventory
	private String convertCounter;		// convert the counter to String for formatting
	private int stringComparisonResult; // store result of string comparison (1, 0, -1)
	private int intComparisonResult;	// store result of an int comparison (1, 0, -1)
	private int specifiedSortChoice;	// value determines which class will be sorted 
										// in the selection sort method (accepts # 1-4)
	
	// object categories which object must belong to in order to be stored in inventory
	private String[] validobjectCategories = {"objects", "weapons", "armors", "accessories", "cores"}; 	
	
	// constructor initializes inventoryGroupsLimit and objectGroupSizeLimit for partyInventory 
	public inventory(int inventoryGroupsLimit, int objectGroupSizeLimit)
	{
		setInventoryGroupsLimit(inventoryGroupsLimit);
		setObjectGroupSizeLimit(objectGroupSizeLimit);
	}
	
	// create LinkedHashMap object objectInventory that will serve as an inventory for 
	// the game by storing objects collected; it has genericObject as its key (accepts 
	// objects created in subclasses of genericObject) and an array list that is of type 
	// genericObject as its value 
	LinkedHashMap<genericObject, ArrayList<genericObject>> objectInventory = 
		new LinkedHashMap<genericObject, ArrayList<genericObject>>();

	
	
	
	
	
	// START: LIMITING ASPECTS OF INVENTORY
	/*******************************************************************************/

	// set the number of different object groups that can exist in the inventory 
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
	
	// get the number of different object groups that can exist in the inventory 
	public int getInventoryGroupsLimit()
	{
		return inventoryGroupsLimit;
	}
	
	// set the object group size limit for the inventory 
	public void setObjectGroupSizeLimit(int objectGroupSizeLimit)
	{
		if(objectGroupSizeLimit < 0)
		{
			objectGroupSizeLimit = 0;
		}
		else if(objectGroupSizeLimit > 30)
		{
			objectGroupSizeLimit = 30;
		}
		
		this.objectGroupSizeLimit = objectGroupSizeLimit;
	}
	
	// get the object group size limit 
	public int getObjectGroupSizeLimit()
	{
		return objectGroupSizeLimit;
	}
	
	// END: LIMITING ASPECTS OF INVENTORY
	/*******************************************************************************/
	
	
	
	
	
	
	
	// START: OBJECT VALIDATION AND ADDING/REMOVING OBJECTS
	/*******************************************************************************/

	// method determines if object about to be added to the inventory is valid or not 
	public <T extends genericObject> boolean isObjectValid(T object) 
	{
		// boolean checks to see if object being added is valid 
		boolean validArgument = false;
		
		// proceed into if statement if object is not null 
		if(object != null)
		{
			// if object belongs to class listed below, assign validArgument with true
			// and return it else return validArgument which hold false 
			if(object.getClass() == items.class)
			{
				validArgument = true;
			}
			else if(object.getClass() == weapons.class)
			{
				validArgument = true;
			}
			else if(object.getClass() == armors.class)
			{
				validArgument = true;
			}
			else if(object.getClass() == accessories.class)
			{
				validArgument = true;
			}
			else if(object.getClass() == cores.class)
			{
				validArgument = true;
			}
			
			return validArgument;
		}
		else
		{
			// return boolean value held in variable 
			return validArgument;
		}
	}
	
		// note on usage of generics (sort of...): 
		// subclass method below has Vehicle as the superclass 
		// style: public <T extends Vehicle> void exampleMethod(Class<T> type)
		// where T is an object of Vehicle which allows use of superclass methods
	
	// method adds object to the inventory if it passes several checks 
	public <T extends genericObject> void addObject(T object)
	{
		// if object is valid, proceed into if statement 
		if(isObjectValid(object) == true)
		{
			/*
				The get(Object key) method is used to return the value to which 
				the specified key is mapped, or null if the hashmap contains no 
				mapping for the key.
			*/
			
			// check to see whether linked hashmap objectInventory contains mapping for 
			// key where mapping refers to whether an object group for object already 
			// exists as an array list and if it does then it will be retrieved 
			ArrayList<genericObject> objectGroup = objectInventory.get(object);
			
			// if object group limit is equal to the size of objectInventory, print out
			// statements saying why object could not be added else create new array
			// list for the object and put it into the objectInventory 
			if(objectInventory.size() == inventoryGroupsLimit)
			{
				// print statements saying that there are too many different object groups
				System.out.println("\n\n'" + object.getName() + "' could not be added to the party inventory!"); 
				System.out.println("The inventory cannot store more than " + inventoryGroupsLimit + " different object groups at a time!\n"); 				
			}
			else
			{
				// if no group with the object name exists already, add in a new group with 
				// the name of the object that is being added 
				if(objectGroup == null) 
				{
					// objectGroup array list of type String is created 
					objectGroup = new ArrayList<genericObject>();
					
					// insert object into linked hashmap with object as key and object group as value 
					objectInventory.put(object, objectGroup);
				}
			}
			
			// if-else statement determines object group capacity. Remove if-else to 
			// add as many objects as user wants (no object limit cap)
			if(objectGroup != null)
			{
				// if the objectGroup size is equal to objectGroupSizeLimit print out why 
				// object could not be added to an existing object group 
				if(objectGroup.size() == objectGroupSizeLimit)
				{
					// print statements saying that max number of objects for the group has been reached 
					System.out.println("\n\n'" + object.getName() + "' could not be added to the party inventory!"); 
					System.out.println("The inventory cannot store more than " + objectGroupSizeLimit + " " +object.getName()+"s at a time!\n"); 
				}
				else
				{			
					// increment object group size by 1 by adding object to array list 
					objectGroup.add(object);
				}
			}
		}	
	}
	
	// method removes the specified object from the inventory if it exists 
	public <T extends genericObject> void removeObject(T object)
	{
		/*
			The get(Object key) method is used to return the value to which 
			the specified key is mapped, or null if the hashmap contains no 
			mapping for the key.
		*/
			
		// check to see whether objectInventory contains mapping for key where mapping 
		// refers to whether an object group for the object already exists as an array 
		// list and if it does then it will be retrieved
		ArrayList<genericObject> objectGroup = objectInventory.get(object);
		
		// end method execution if object object group does not exist 
		if(objectGroup == null) return;
		
		// remove object from object group causing object group size to decrement by one 
		objectGroup.remove(object);

		// if object group contains no objects (it is empty), remove object group from 
		// objectInventory by removing its key and value 
		if(objectGroup.size() == 0)
		{
			objectInventory.remove(object, objectGroup);
		}
	}
	
	// END: OBJECT VALIDATION AND ADDING/REMOVING OBJECTS
	/*******************************************************************************/
	
	
	
	
	
	
	// START: PRINTING INVENTORY CONTENTS 
	/*******************************************************************************/
	
	// consider removing numbers on left side... 
	
	// prints contents of objectInventory like so: position #. objectName: # of objects 
	public void printInventory()
	{
		// initialize counter instance variable to 1 each time the method is called 
		counter = 1; 
		
		// if there is at least one object stores in objectInventory then enter the if 
		// statement else print out statement saying objectInventory is empty 
		if(objectInventory.size() != 0)
		{
			// enhanced for loop creates linked hashmap object objectInventoryCopy with 
			// a key and value type identical to the types of linked hashmap object 
			// objectInventory; objectInventoryCopy iterates through objectInventory and 
			// retrieves all entry sets (keys and values) of objectInventory 
			for(Map.Entry<genericObject, ArrayList<genericObject>> objectInventoryCopy : objectInventory.entrySet()) 
			{
				// store name of the inventory object object in String variable objectName			
				objectName = objectInventoryCopy.getKey().getName();
				
				// convert counter to String in order to format it
				convertCounter  = convertCounter.format("%d)", counter);
				
				// format String such that entry set keys are four spaces after number
				convertCounter  = convertCounter.format("%-4s", convertCounter);
				
				// format objectName such that the string is aligned 20 spaces to the left
				// using format modifier '-' with a specification of 20 before the s; if 
				// the modifier is not included, the string will default to the right 
				objectName = objectName.format("%s%-17s", convertCounter, objectName);
				
				// get and store object group size (number of objects in object group)
				arrayListTotal = objectInventoryCopy.getValue().size();
				
				// notify user about what is about to be printed 
				if(counter == 1)
				{
					System.out.println("Contents of party inventory...");
				}
				
				// if-else statement displays objectInventory along with a counter 
				// if remainder is 1, display object on left else display it on right 
				if(counter % 2 == 1)
				{
					System.out.printf("%s: %d", objectName, arrayListTotal);
						counter++;
				}
				else 
				{
					System.out.printf("\t%s: %d\n", objectName, arrayListTotal);
						counter++;
				}
			}
		}
		else
		{
			// print statement only if there are no objects in the inventory
			System.out.println("There are no objects stored in the party inventory.");
		}
		
		// print new line to improve readability 
		System.out.println();
	}
	
	// END: PRINTING INVENTORY CONTENTS 
	/*******************************************************************************/
	
	
	
	// Sorting Linked Hashmaps and TreeMaps...
	/*
		Sorting options for objects inventory 
			
			Customize:			player personally customizes object placement in inventory 
			Specific Sort:		sort inventory such that certain objects are sorted in ascending order
			  - objects
			  - weapons
			  - armors
			  - accessories
				- Name
				- Class						NOT IMPLEMENTED 
				- Category
				- Super Type
				- Sub Type
				- Use Speed					NOT IMPLEMENTED 
				- Buy Price
				- Sell Price;
				- Highest Quantity
				- Lowest Quantity
			General Sort:		sort all objects at once as desired in ascending order
			  - Name
			  - Class						NOT IMPLEMENTED 
			  - Category
			  - Super Type
			  - Sub Type
			  - Use Speed					NOT IMPLEMENTED 
			  - Buy Price
			  - Sell Price;
			  - Highest Quantity
			  - Lowest Quantity
	*/
	
	
	
	// START: CUSTOMIZE BY SWAPPING TWO ENTRY SETS
	/********************************************************************************/
	
	// method places objectInventory entry sets in linked hashmap object holdInventory 
	// and places entry sets meant to be swapped in linked hashmap object swapEntries
	
	public void selectEntries(LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory, 
		LinkedHashMap<genericObject, ArrayList<genericObject>> swapEntries, int entrySelected, int swapToPosition)
	{
		// assign counter to 1 to start counting from 1 or first entry 
		counter = 1;
		
		// enhanced for loop iterates through contents of objectInventory using linked
		// hashmap object objectInventoryCopy
		for(Map.Entry<genericObject, ArrayList<genericObject>> objectInventoryCopy : objectInventory.entrySet()) 
		{
			// store entries of objectInventory linked hashmap in linked hashmap holdInventory 
			holdInventory.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());				
			
			// if-else statement manages the storage of entry sets in linked hashmap swapEntries
			if(counter == entrySelected)
			{
				// store entry set selected for swapping in linked hashmap swapEntries
				swapEntries.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
			}
			else if(counter == swapToPosition)
			{
				// store entry set that will be swapped with desired entry set in linked hashmap swapEntries
				swapEntries.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
			}
			
			// increment counter variable 
			counter++;
		}
	}
	
	// method refills objectInventory with contents of linked hashmap holdInventory 
	// (which holds all entry sets objectInventory had before it was cleared) and 
	// linked hashmap swapEntries which holds the entry sets meant to be swapped 
	public void customizeRefill(LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory, 
		LinkedHashMap<genericObject, ArrayList<genericObject>> swapEntries, int entrySelected, int swapToPosition)
	{
		// assign counter to 1 to start counting from 1 or first entry
		counter = 1;
		
		// enhanced for loop creates linked hashmap object holdInventoryCopy to 
		// iterate through entry sets of linked hashmap holdInventory 
		for(Map.Entry<genericObject, ArrayList<genericObject>> holdInventoryCopy : holdInventory.entrySet())
		{
			// make swaps when counter reaches of the locations specified for swap
			if(counter == entrySelected)
			{
				// enhanced for loop creates linked hashmap object swapEntriesCopy
				// to iterate through entry sets of linked hashmap swapEntries
				for(Map.Entry<genericObject, ArrayList<genericObject>> swapEntriesCopy : swapEntries.entrySet())
				{
					// if swapEntriesCopy key does not match holdInventoryCopy key 
					// then put key and value stored in the entry set of swapEntriesCopy
					// in linked hashmap objectInventory 
					if(!holdInventoryCopy.getKey().equals(swapEntriesCopy.getKey()))
					{
						objectInventory.put(swapEntriesCopy.getKey(), swapEntriesCopy.getValue());
					}
				}
			}
			else if(counter == swapToPosition)
			{
				// enhanced for loop creates linked hashmap object swapEntriesCopy
				// to iterate through entry sets of linked hashmap swapEntries
				for(Map.Entry<genericObject, ArrayList<genericObject>> swapEntriesCopy : swapEntries.entrySet())
				{
					// if swapEntriesCopy key does not match holdInventoryCopy key 
					// then put key and value stored in the entry set of swapEntriesCopy
					// in linked hashmap objectInventory 
					if(!holdInventoryCopy.getKey().equals(swapEntriesCopy.getKey()))
					{
						objectInventory.put(swapEntriesCopy.getKey(), swapEntriesCopy.getValue());
					}
				}
			}
			else
			{
				// insert key and value of holdInventoryCopy into objectInventory
				objectInventory.put(holdInventoryCopy.getKey(), holdInventoryCopy.getValue());
			}
			
			// increment counter by one 
			counter++;
		}
	}
	
	// methods allows users to "customize" object positions on linked hashmap objectInventory
	// by allowing them to swap one entry set with another if possible 
	public void customizeInventory(int entrySelected, int swapToPosition)
	{
		// enter if statement only if there is more than one entry set in linked hashmap 
		// objectInventory since swapping the only entry set with itself is pretty silly 
		if(objectInventory.size() >  1)
		{			
			/*	Note: it would be silly to swap an entry set with itself so do nothing if
					  the user supplies arguments that are the same value */
			
			// if integers are not the same, enter if statement 
			if(entrySelected != swapToPosition)
			{
				// if entrySelected is within the bounds of the inventory, enter if statement  
				if(entrySelected >= 1 && entrySelected <= objectInventory.size())
				{
					// if swapToPosition is within the bounds of the inventory, enter if statement  
					if(swapToPosition >= 1 && swapToPosition <= objectInventory.size())
					{
						// linked hashmap object holdInventory stores objectInventory 
						// entry sets 
						LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
							new LinkedHashMap<genericObject, ArrayList<genericObject>>();
						
						// linked hashmap object swapEntries stores entry sets that the 
						// user wants to swap which are located at position entrySelected 
						// and swapToPosition 
						LinkedHashMap<genericObject, ArrayList<genericObject>> swapEntries = 
							new LinkedHashMap<genericObject, ArrayList<genericObject>>();
						
						// supply linked hashmaps created in customizeInventory() and 
						// int values passed to customizeInventory() to the method 
						// selectEntries()
						selectEntries(holdInventory, swapEntries, entrySelected, swapToPosition);
						
						// clear contents objectInventory in order to place entry sets of 
						// holdInventory and swapEntries in objectInventory later on 
						objectInventory.clear();
						
						// supply linked hashmaps created in customizeInventory() and 
						// int values passed to customizeInventory() to the method 
						// customizeRefill()
						customizeRefill(holdInventory, swapEntries, entrySelected, swapToPosition);
					}
				}
			}
		}
		// print new line to improve readability 
		System.out.println();
	}
	
	// END: CUSTOMIZE BY SWAPPING TWO ENTRY SETS
	/********************************************************************************/
	
	
	
	
	
	
	// START: COMPARATORS USED TO SORT TREEMAPS A CERTAIN WAY
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
	
	
	
	// START: METHODS USED BY COMPARATORS
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
	
	
	
	// END: METHODS USED BY COMPARATORS
	/*------------------------------------------------------------------------------*/
	
	
	
	// START: KEY COMPARATORS SORT BY ASCENDING ORDER
	/*------------------------------------------------------------------------------*/
	
	// custom TreeMap comparator sorts the objects of a TreeMap by name alphabetically
	public Comparator<genericObject> sortByName = new Comparator<genericObject>() 
	{
		// method compares the names of each object and sorts the objects such that
		// they are alphabetically ordered by name (ascending order from A to Z) 
		@Override 
		public int compare(genericObject objectOne, genericObject objectTwo) 
		{
			// return result of string comparison which will dictate TreeMap ordering
			return compareStrings(objectOne.getName(), objectTwo.getName());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by main class alphabetically
	public Comparator<genericObject> sortByMainClass = new Comparator<genericObject>() 
	{
		// method compares the main class of each object and sorts the objects such that
		// they are alphabetically ordered by class (ascending order from A to Z) 
		@Override 
		public int compare(genericObject objectOne, genericObject objectTwo) 
		{
			// return result of string comparison which will dictate TreeMap ordering
			return compareStrings(objectOne.getMainClass(), objectTwo.getMainClass());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by category alphabetically
	public Comparator<genericObject> sortByCategory = new Comparator<genericObject>() 
	{
		// method compares the category of each object and sorts the objects such that
		// they are ordered alphabetically by category name (ascending order from A to Z) 
		@Override 
		public int compare(genericObject objectOne, genericObject objectTwo) 
		{
			// return result of string comparison which will dictate TreeMap ordering
			return compareStrings(objectOne.getCategory(), objectTwo.getCategory());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by super type alphabetically
	public Comparator<genericObject> sortBySuperType = new Comparator<genericObject>() 
	{
		// method compares the super type of each object and sorts the objects such that
		// they are ordered alphabetically by super type (ascending order from A to Z)  
		@Override 
		public int compare(genericObject objectOne, genericObject objectTwo) 
		{
			// return result of string comparison which will dictate TreeMap ordering
			return compareStrings(objectOne.getSuperType(), objectTwo.getSuperType());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by sub type alphabetically
	public Comparator<genericObject> sortBySubType = new Comparator<genericObject>() 
	{
		// method compares the sub type of each object and sorts the objects such that
		// they are ordered alphabetically by sub type (ascending order from A to Z)  
		@Override 
		public int compare(genericObject objectOne, genericObject objectTwo) 
		{
			// return result of string comparison which will dictate TreeMap ordering
			return compareStrings(objectOne.getSubType(), objectTwo.getSubType());
		}
	}; 
		
	// custom TreeMap comparator sorts the objects of a TreeMap by highest buy price 
	public Comparator<genericObject> sortByUseSpeed = new Comparator<genericObject>() 
	{
		// method compares the use speed of each object and sorts the objects such that
		// they are ordered by use speed (ascending order with faster use objects on top)  
		@Override 
		public int compare(genericObject objectOne, genericObject objectTwo) 
		{
			// return result of int comparison which will dictate TreeMap ordering
			return compareIntegers(objectOne.getUseSpeed(), objectTwo.getUseSpeed());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by highest buy price 
	public Comparator<genericObject> sortByBuyPrice = new Comparator<genericObject>() 
	{
		// method compares the buy price of each object and sorts the objects such that
		// they are ordered by buy price (ascending order with expensive objects on top)  
		@Override 
		public int compare(genericObject objectOne, genericObject objectTwo) 
		{
			// return result of int comparison which will dictate TreeMap ordering
			return compareIntegers(objectOne.getBuyPrice(), objectTwo.getBuyPrice());
		}
	}; 
	
	// custom TreeMap comparator sorts the objects of a TreeMap by lowest sell price
	public Comparator<genericObject> sortBySellPrice = new Comparator<genericObject>() 
	{
		// method compares the sell price of each object and sorts the objects such that
		// they are ordered by sell price (ascending order with least expensive objects on top)  
		@Override 
		public int compare(genericObject objectOne, genericObject objectTwo) 
		{
			// return result of int comparison which will dictate TreeMap ordering
			return compareIntegers(objectOne.getSellPrice(), objectTwo.getSellPrice());
		}
	}; 
	
	// END: KEY COMPARATORS SORT BY ASCENDING ORDER
	/*------------------------------------------------------------------------------*/

	
	
	// START: VALUE COMPARATORS SORT BY ASCENDING ORDER
	/*------------------------------------------------------------------------------*/

	// USE ONLY FOR KEY-VALUE SWAP OPERATIONS 
	// custom TreeMap comparator sorts the objects of a TreeMap by highest quantity
	public Comparator<ArrayList<genericObject>> sortByHighestQuanity = new Comparator<ArrayList<genericObject>>() 
	{
		// method compares the size (quantity) of each array list and sorts them such 
		// that they are ordered by size (ascending order with highest quantity on top)  
		@Override 
		public int compare(ArrayList<genericObject> arrayListOne, ArrayList<genericObject> arrayListTwo) 
		{
			// return result of int comparison which will dictate TreeMap ordering
			return compareIntegers(arrayListOne.size(), arrayListTwo.size());
		}
	}; 
	
	// USE ONLY FOR KEY-VALUE SWAP OPERATIONS 
	// custom TreeMap comparator sorts the objects of a TreeMap by lowest quantity
	public Comparator<ArrayList<genericObject>> sortByLowestQuanity = new Comparator<ArrayList<genericObject>>() 
	{
		// method compares the size (quantity) of each array list and sorts them such 
		// that they are ordered by size (ascending order with lowest quantity on top)  
		@Override 
		public int compare(ArrayList<genericObject> arrayListOne, ArrayList<genericObject> arrayListTwo) 
		{
			// return result of int comparison which will dictate TreeMap ordering
			// multiply value of comparison by negative 1 (-1) to inverse the order
			// given by comparator sortByHighestQuanity to sort by lowest quantity
			return -1 * compareIntegers(arrayListOne.size(), arrayListTwo.size());
		}
	}; 
	
	// END: KEY COMPARATORS SORT BY ASCENDING ORDER
	/*------------------------------------------------------------------------------*/
	
	// END: COMPARATORS USED TO SORT TREEMAPS A CERTAIN WAY
	/********************************************************************************/
	
	
	
	
	
	
	// SORT: SPECIFIED SORT SORTS CERTAIN OBJECTS IN A PREDFINED WAY 
	/********************************************************************************/

	// START: METHODS USED THROUGHOUT SPECIFIED SORT
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
	
	// for specified sort, objects created in a subclass of genericObject superclass
	// will be filtered into a TreeMap and a linked hashmap according to the integer 
	// supplied such that objects from a certain class will be sorted while the other 
	// objects are left alone 
	public void sortBySpecifiedClass(TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy, 
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory, int choice)
	{
		// switch statement determines what class objects are stored and sorted in TreeMap
		// through the use of an enhanced for loop 
		switch(choice)
		{
			case 1: // sort objects from class items ONLY
				for(Map.Entry<genericObject, ArrayList<genericObject>> objectInventoryCopy : objectInventory.entrySet())
				{
					if(objectInventoryCopy.getKey().getClass() == items.class)
					{
						sortObjectsBy.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
					else
					{
						holdInventory.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
				}
					break;
			case 2: // sort objects from class weapons ONLY
				for(Map.Entry<genericObject, ArrayList<genericObject>> objectInventoryCopy : objectInventory.entrySet())
				{
					if(objectInventoryCopy.getKey().getClass() == weapons.class)
					{
						sortObjectsBy.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
					else
					{
						holdInventory.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
				}
					break;
			case 3: // sort objects from class armors ONLY
				for(Map.Entry<genericObject, ArrayList<genericObject>> objectInventoryCopy : objectInventory.entrySet())
				{
					if(objectInventoryCopy.getKey().getClass() == armors.class)
					{
						sortObjectsBy.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
					else
					{
						holdInventory.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
				}
					break;
			case 4: // sort objects from class accessories ONLY
				for(Map.Entry<genericObject, ArrayList<genericObject>> objectInventoryCopy : objectInventory.entrySet())
				{
					if(objectInventoryCopy.getKey().getClass() == accessories.class)
					{
						sortObjectsBy.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
					else
					{
						holdInventory.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
				}
					break;
			case 5: // sort objects from class cores ONLY
				for(Map.Entry<genericObject, ArrayList<genericObject>> objectInventoryCopy : objectInventory.entrySet())
				{
					if(objectInventoryCopy.getKey().getClass() == cores.class)
					{
						sortObjectsBy.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
					else
					{
						holdInventory.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
					}
				}
					break;
		}
	}
	
	// method fills contents of objectInventory with contents of sorted TreeMap followed 
	// by linked hashmap that holds all of the other entry sets once held in objectInventory
	public void specifiedRefill(TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy, 
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory)
	{
		// enhanced for loop places sorted entry sets from TreeMap into objectInventory first 
		for(Map.Entry<genericObject, ArrayList<genericObject>> sortObjectsByCopy : sortObjectsBy.entrySet())
		{
			objectInventory.put(sortObjectsByCopy.getKey(), sortObjectsByCopy.getValue());
		}
		
		// enhanced for loop places entry sets of linked hashmap back into objectInventory  
		for(Map.Entry<genericObject, ArrayList<genericObject>> holdInventoryCopy : holdInventory.entrySet())
		{
			objectInventory.put(holdInventoryCopy.getKey(), holdInventoryCopy.getValue());		
		}
	}
	
	// sort desired class objects, empty party inventory objectInventory, and put all 
	// contents of the TreeMap and linked hashmap back into objectInventory
	public void specifiedSort(TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy, 
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory, int choice)
	{
		// pass TreeMap, linked hashmap and, and the choice for what class objects will 
		// be sorted to method sortBySpecifiedClass
		sortBySpecifiedClass(sortObjectsBy, holdInventory, checkSelectionSortChoice(choice));
		
		// clear objectInventory in order to refill it with the sorted TreeMap entry sets 
		// first followed by the entry sets of holdInventory
		objectInventory.clear();
		
		// pass TreeMap and linked hashmap to method specifiedRefill() in order to fill 
		// objectInventory after the specified sort
		specifiedRefill(sortObjectsBy, holdInventory);
	}
	
	// method stores the key of one TreeMap as the value of the other TreeMap and the
	// value of the first TreeMap as the key of the second TreeMap
	public void specifiedSwapKeysAndValues(TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy, 
		TreeMap<ArrayList<genericObject>, genericObject> sortArrayListBy)
	{
		// enhanced for loop performs key/value swapping using TreeMap object sortObjectsByCopy
		for(Map.Entry<genericObject, ArrayList<genericObject>> sortObjectsByCopy : sortObjectsBy.entrySet())
		{
			sortArrayListBy.put(sortObjectsByCopy.getValue(), sortObjectsByCopy.getKey());
		}
	}
	
	// method refills objectInventory with contents of sorted TreeMap that contains the 
	// values of objectInventory as its keys and the keys as its values and the linked 
	// hashmap that stored the rest of the objects 
	public void specifiedRefillAfterSwap(TreeMap<ArrayList<genericObject>, genericObject> sortArrayListBy, 
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory)
	{
		// enhanced for loop places sorted entry sets from TreeMap into party inventory 
		// linked hashmap objectInventory by placing the value in the key slot and the 
		// key in the value slot 
		for(Map.Entry<ArrayList<genericObject>, genericObject> sortArrayListByCopy : sortArrayListBy.entrySet())
		{
			objectInventory.put(sortArrayListByCopy.getValue(), sortArrayListByCopy.getKey());
		}
		
		// enhanced for loop places the entry sets of a linked hashmap which originally 
		// belonged to the party inventory linked hashmap objectInventory  
		for(Map.Entry<genericObject, ArrayList<genericObject>> holdInventoryCopy : holdInventory.entrySet())
		{
			objectInventory.put(holdInventoryCopy.getKey(), holdInventoryCopy.getValue());		
		}
	}
	
	// sort desired class objects by their quantity, empty party inventory objectInventory, 
	// and put all contents of the TreeMap and linked hashmap back into objectInventory
	public void specifiedValueSort(TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy, 
		TreeMap<ArrayList<genericObject>, genericObject> sortArrayListBy,
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory, 
		int choice)
	{
		// pass TreeMap, linked hashmap and, and the choice for what class objects will 
		// be sorted to method sortBySpecifiedClass
		sortBySpecifiedClass(sortObjectsBy, holdInventory, checkSelectionSortChoice(choice));

		// swap keys with values and values with keys for each entry set and place them 
		// in TreeMap sortArrayListBy
		specifiedSwapKeysAndValues(sortObjectsBy, sortArrayListBy);
		
		// clear party inventory linked hashmap objectInventory in order to refill it the
		// sorted TreeMap entry sets first and followed by entry sets of holdInventory
		objectInventory.clear();
		
		// pass TreeMap and linked hashmap to method specifiedRefillAfterSwap()
		specifiedRefillAfterSwap(sortArrayListBy, holdInventory);
	}
	
	// END: METHODS USED THROUGHOUT SPECIFIED SORT
	/*------------------------------------------------------------------------------*/	
	
	
	
	// START: METHODS FOR SPECIFIED SORT OF KEYS
	/*------------------------------------------------------------------------------*/	
	
	// method sorts objects from class specified by supplied integer by name  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByName(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByName implemented at the end 
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByName);
		
		// linked hashmap object holdInventory stores all entry sets of objectInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class specified by supplied integer by class  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByClass(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByMainClass implemented at the end 
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByMainClass);
		
		// linked hashmap object holdInventory stores all entry sets of objectInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class specified by supplied integer by category  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByCategory(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByCategory implemented at the end 
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByCategory);
		
		// linked hashmap object holdInventory stores all entry sets of objectInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class specified by supplied integer by super type  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortBySuperType(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortBySuperType implemented at the end 
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortBySuperType);
		
		// linked hashmap object holdInventory stores all entry sets of objectInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class specified by supplied integer by sub type  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortBySubType(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortBySubType implemented at the end 
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortBySubType);
		
		// linked hashmap object holdInventory stores all entry sets of objectInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class specified by supplied integer by use speed 
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByUseSpeed(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByUseSpeed implemented at the end 
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByUseSpeed);
		
		// linked hashmap object holdInventory stores all entry sets of objectInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class specified by supplied integer by buy price  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByBuyPrice(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByBuyPrice implemented at the end 
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByBuyPrice);
		
		// linked hashmap object holdInventory stores all entry sets of objectInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort()
		specifiedSort(sortObjectsBy, holdInventory, specifiedSortChoice);
	}
	
	// method sorts objects from class specified by supplied integer by sell price  
	// and puts them at the top of the list (presents them first)
	public void specifiedSortBySellPrice(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortBySellPrice implemented at the end 
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortBySellPrice);
		
		// linked hashmap object holdInventory stores all entry sets of objectInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
		
		// pass TreeMap, linked hashmap, and the choice for what class objects will 
		// be sorted to method specifiedSort() 
		specifiedSort(sortObjectsBy, holdInventory, specifiedSortChoice);
	}
	
	// END: METHODS FOR SPECIFIED SORT OF KEYS
	/*------------------------------------------------------------------------------*/	
	
	
	
	// START: METHODS FOR SPECIFIED SORT OF VALUES (KEY AND VALUE SWAPPING)
	/*------------------------------------------------------------------------------*/	
	
	// method sorts objects from class (category) specified by integer by highest
	// quantity and puts them at the top of the list (presents them first)
	public void specifiedSortByHighestQuantity(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// linked hashmap object holdInventory stores all entry sets of objectInventory 
		// not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
				
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByName implemented at the end and 
		// is needed in order to store the objects in a way TreeMao will understand 
		// Note: TreeMap needed to use sortBySpecifiedClass() to separate class objects
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByName);		
		
		// TreeMap object sortArrayListBy will store the values of objectInventory as 
		// its key and the keys of objectInventory as its value and it will sort them 
		// using comparator sortByHighestQuanity
		TreeMap<ArrayList<genericObject>, genericObject> sortArrayListBy = 
			new TreeMap<ArrayList<genericObject>, genericObject>(sortByHighestQuanity);
		
		// pass both TreeMaps, the linked hashmap and, and the choice for what class 
		// objects will be sorted to method specifiedValueSort()
		specifiedValueSort(sortObjectsBy, sortArrayListBy, holdInventory, 
			checkSelectionSortChoice(choice));
	}
	
	// method sorts objects from class (category) specified by integer by lowest quantity
	// and puts them at the top of the list (presents them first)
	public void specifiedSortByLowestQuantity(int choice)
	{
		// assign argument to private instance variable specifiedSortChoice
		specifiedSortChoice = choice;
		
		// linked hashmap object holdInventory stores all entry sets of the party 
		// inventory hashmap objectInventory not stored in TreeMap sortObjectsBy
		LinkedHashMap<genericObject, ArrayList<genericObject>> holdInventory = 
			new LinkedHashMap<genericObject, ArrayList<genericObject>>();			
				
		// TreeMap object sortObjectsBy will ONLY hold objects from specified class 
		// sortObjectsBy has custom comparator sortByName implemented at the end and 
		// is needed in order to store the objects in a way TreeMao will understand 
		// Note: TreeMap needed to use sortBySpecifiedClass() to separate class objects
		TreeMap<genericObject, ArrayList<genericObject>> sortObjectsBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByName);		
		
		// TreeMap object sortArrayListBy will store the values of objectInventory as 
		// its key and the keys of objectInventory as its value and it will sort them 
		// using comparator sortByLowestQuanity
		TreeMap<ArrayList<genericObject>, genericObject> sortArrayListBy = 
			new TreeMap<ArrayList<genericObject>, genericObject>(sortByLowestQuanity);
		
		// pass both TreeMaps, the linked hashmap and, and the choice for what class 
		// objects will be sorted to method specifiedValueSort()
		specifiedValueSort(sortObjectsBy, sortArrayListBy, holdInventory, 
			checkSelectionSortChoice(choice));
	}
	
	// END: METHODS FOR SPECIFIED SORT OF VALUES
	/*------------------------------------------------------------------------------*/	
	
	// END SORT: SPECIFIED SORT
	/********************************************************************************/
	
	
	
	
	
	
	// SORT: GENERAL SORT SORTS ALL INVENTORY OBJECTS IN A PREDEFINED WAY
	/********************************************************************************/
	
	// START: METHODS USED THROUGHOUT GENERAL SORT
	/*------------------------------------------------------------------------------*/	
	
	// method fills TreeMap with keys and values of objectInventory
	public void fillTreeMapKeyValue(TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy)
	{
		// enhanced for loop creates linked hashmap object objectInventoryCopy that can
		// be used get the keys and values of each entry set of the objectInventory
		for(Map.Entry<genericObject, ArrayList<genericObject>> objectInventoryCopy : objectInventory.entrySet())
		{
			sortInventoryBy.put(objectInventoryCopy.getKey(), objectInventoryCopy.getValue());
		}
	}
	
	// method fills objectInventory with contents of the sorted TreeMap
	public void generalSortRefill(TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy)
	{
		// enhanced for loop creates linked hashmap object sortInventoryByCopy that can
		// be used get the keys and values of each entry set of the objectInventory
		for(Map.Entry<genericObject, ArrayList<genericObject>> sortInventoryByCopy : sortInventoryBy.entrySet())
		{
			objectInventory.put(sortInventoryByCopy.getKey(), sortInventoryByCopy.getValue());
		}
	}
	
	// fill objectInventory with contents of sorted TreeMap by placing value of TreeMap 
	// as the key for objectInventory and the key as the value for objectInventory
	/* Note: since method generalSwapKeysAndValues() swaps keys and values for TreeMap, 
			 this method "swaps back" keys and values before placement into objectInventory */
	public void generalSortSwapRefill(TreeMap<ArrayList<genericObject>, genericObject> sortInventoryBy)
	{
		// enhanced for loop performs key and value swapping for TreeMap 
		for(Map.Entry<ArrayList<genericObject>, genericObject> sortInventoryByCopy : sortInventoryBy.entrySet())
		{
			objectInventory.put(sortInventoryByCopy.getValue(), sortInventoryByCopy.getKey());
		}
	}
	
	// method calls other methods to sort all objects in objectInventory using TreeMap
	public void generalSort(TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy)
	{
		// fill empty TreeMap which will sort by rules established by comparator
		fillTreeMapKeyValue(sortInventoryBy);
		
		// clear linked hashmap to fill it in later 
		objectInventory.clear();
		
		// fill in inventory with contents of sorted TreeMap
		generalSortRefill(sortInventoryBy);
	}
	
	// method puts the key of objectInventory as the value for the TreeMap and value as
	// the key of the TreeMap 
	public void generalSwapKeysAndValues(TreeMap<ArrayList<genericObject>, 
		genericObject> sortInventoryBy)
	{
		// enhanced for loop performs key and value swapping for TreeMap 
		for(Map.Entry<genericObject, ArrayList<genericObject>> objectInventoryCopy : objectInventory.entrySet())
		{
			sortInventoryBy.put(objectInventoryCopy.getValue(), objectInventoryCopy.getKey());
		}		
	}
	
	// method calls other methods to sort by value 
	public void generalValueSort(TreeMap<ArrayList<genericObject>, 
		genericObject> sortInventoryBy)
	{
		// swap keys and values of objectInventory with TreeMap sortInventoryBy
		generalSwapKeysAndValues(sortInventoryBy);
		
		// clear objectInventory to fill with sorted TreeMap contents later 
		objectInventory.clear();
		
		// fill objectInventory with contents of sorted TreeMap sortInventoryBy
		generalSortSwapRefill(sortInventoryBy);
	}
	
	// END: METHODS USED THROUGHOUT GENERAL SORT
	/*------------------------------------------------------------------------------*/	

	
	
	// START: METHODS FOR GENERAL SORT OF KEYS
	/*------------------------------------------------------------------------------*/		
	
	// method sorts objects by name and puts them at the top of the list (presents them first)
	public void generalSortByName()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// name since it uses custom comparator sortByName at the end of it 
		TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByName);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by class and puts them at the top of the list (presents them first)
	public void generalSortByClass()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// class since it uses custom comparator sortByMainClass at the end of it 
		TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByMainClass);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by category and puts them at the top of the list (presents them first)
	public void generalSortByCategory()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// category since it uses custom comparator sortByCategory at the end of it 
		TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByCategory);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by super type and puts them at the top of the list (presents them first)
	public void generalSortBySuperType()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// super type since it uses custom comparator sortBySuperType at the end of it 
		TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortBySuperType);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by sub type and puts them at the top of the list (presents them first)
	public void generalSortBySubType()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// sub type since it uses custom comparator sortBySubType at the end of it 
		TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortBySubType);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by class and puts them at the top of the list (presents them first)
	public void generalSortByUseSpeed()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// class since it uses custom comparator sortByUseSpeed at the end of it 
		TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByUseSpeed);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by buy price and puts them at the top of the list (presents them first)
	public void generalSortByBuyPrice()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by 
		// buy price since it uses custom comparator sortBySubType at the end of it 
		TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortByBuyPrice);
		
		// pass TreeMap object sortInventoryBy to method generalSort()
		generalSort(sortInventoryBy);
	}
	
	// method sorts objects by sell price and puts them at the top of the list (presents them first)
	public void generalSortBySellPrice()
	{
		// TreeMap object sortInventoryBy will sort all objects in the inventory by buy price
		// since it uses custom comparator sortBySellPrice at the end of it 
		TreeMap<genericObject, ArrayList<genericObject>> sortInventoryBy = 
			new TreeMap<genericObject, ArrayList<genericObject>>(sortBySellPrice);
		
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
		TreeMap<ArrayList<genericObject>, genericObject> sortInventoryBy = 
			new TreeMap<ArrayList<genericObject>, genericObject>(sortByHighestQuanity);
		
		// pass TreeMap to method generalValueSort()
		generalValueSort(sortInventoryBy);
	}
	
	// method sorts all objects in the inventory by lowest quantity 
	public void generalSortByLowestQuantity()
	{	
		// TreeMap object sortInventoryBy sorts objects by highest quantity by using 
		// comparator sortByLowestQuanity
		TreeMap<ArrayList<genericObject>, genericObject> sortInventoryBy = 
			new TreeMap<ArrayList<genericObject>, genericObject>(sortByLowestQuanity);
		
		// pass TreeMap to method generalValueSort()
		generalValueSort(sortInventoryBy);
	}
	
	// END: METHODS FOR GENERAL SORT OF VALUES
	/*------------------------------------------------------------------------------*/	
	
	// END: GENERAL SORT 
	/********************************************************************************/
}