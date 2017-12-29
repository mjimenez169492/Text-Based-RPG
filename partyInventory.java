/* 
	Consider a weight based system 
	define max weight before inventory affects combat by slowing party down
		max weight: 100
	
	armor
		body
		legs
		feet
	
	accessories
		rings
		necklaces
		gloves***
		capes
		shields
		head***
*/
import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;
import java.util.TreeMap;

public class partyInventory
{	
	// TreeMap has O(log(n)) complexity which is slower than HashMap which has 
	// O(1) complexity
	// TreeMap always keeps the elements in a sorted(increasing) order, while 
	// the elements in a HashMap have no order. TreeMaps take the time to sort 
	// the keys and values placed inside them in a predefined or defined order 
	// with the later depending on whether a programmer makes their own method 
	// to sort the TreeMap
	
	TreeMap<String, ArrayList<String>> inventory = new TreeMap<String, ArrayList<String>>();
//	HashMap<String, ArrayList<String>> inventory = new HashMap<String, ArrayList<String>>();
	
	public void add(genericItem item)
	{
		ArrayList<String> itemGroup = inventory.get(item.getItemName());
		if(itemGroup == null) // add a new group, if none exist, yet
		{
			itemGroup = new ArrayList<String>();
			inventory.put(item.getItemName(), itemGroup);
		}
		itemGroup.add(item.getItemName());

		// displays item name followed by how many 'copies' there are of the item
			// System.out.println(inventory.entrySet());
		
		// displays item names or 'keys' in hashmap inventory 
			// System.out.println(inventory.keySet());
		
		// displays number of items or 'values' stored in itemGroup 
			// System.out.println(inventory.values());
		
		//System.out.println(inventory.keySet());
	}
	
	public void remove(genericItem item)
	{
		ArrayList<String> itemGroup = inventory.get(item.getItemName());
		if(itemGroup == null) return;
		itemGroup.remove(item.getItemName());
		// remove an empty group
		if(itemGroup.size() == 0)
		{
			inventory.remove(item.getItemName(), itemGroup);
		}
	}
	
	// need to find way to display contents of hashmap inventory like so:
	// itemName, quantity #
	public void printInventory()
	{
		for (ArrayList<String> e : itemGroup.values()) {
			for (int i = 0; i < e.size(); i++) {
				if (e.get(i)!=null) {
					System.out.println(e.get(i));
				}
			}
		}
	}
	
	
	
	
	
}















































