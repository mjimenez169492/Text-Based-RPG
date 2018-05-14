/*
	interface objectComponents contains abstract methods relating to object creation 
	which must be defined by a class that implements this interface.
*/

interface objectComponents
{	
	// sets name for object 
	void setName(String name);
	
	// gets name for object
	String getName();
	
	// sets class that object belongs to
	void setMainClass(String mainClass);
	
	// gets class that object belongs to
	String getMainClass();
	
	// sets category object belongs to 
	void setCategory(String category);
	
	// gets category object belongs to 
	String getCategory();
	
	// sets super type for object such that object belongs to a specific group of objects 
	void setSuperType(String superType);
	
	// gets super type for object
	String getSuperType();
	
	// sets sub type for object such that object belongs to a group in a specific group of objects 
	public void setSubType(String subType);
	
	// gets sub type for object 
	public String getSubType();
	
	// sets durability for object 
	void setDurability(int durability);
	
	// gets durability for object
	int getDurability();
	
	// sets how fast the character can use the object 
	void setUseSpeed(int useSpeed);
	
	// gets how fast the character can use the object 
	int getUseSpeed();
	
	// sets buy price for object 
	void setBuyPrice(int buyPrice);
	
	// gets buy price for object
	int getBuyPrice();
	
	// sets sell price for object 
	void setSellPrice(int sellPrice);
	
	// gets sell price for object
	int getSellPrice();
}