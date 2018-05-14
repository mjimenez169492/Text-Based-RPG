/*
	public class genericObject implements objectComponents and defines the methods in 
	it. Class will serve as superclass for future classes concerning object creation. 
*/

public class genericObject implements objectComponents 
{
	private String name;			// name of the object 
	private String mainClass;		// name of the class object belongs to
	private String category;		// object category that object belongs to 
	private String superType;		// name of a particular object group in category
	private String subType;			// object belongs object group in a particular category 
	private int durability;			// durability for object that decreases object attributes the lower it goes
	private int useSpeed;			// dictates how fast a character can use an object 
	private int buyPrice;			// money needed to buy the object 
	private int sellPrice;			// money received by selling the object 
	
	// superclass constructor has nothing supplied to it 
	public genericObject()
	{
		// empty constructor 
	}
	
	
	
	
	
	
	// START: CLASSIFICATION BY STRING
	/*******************************************************************************/
	
	// returns true if the string is not null and not ""
	public boolean validateString(String argument)
	{
		return ((argument != null && !argument.equals("")) == true);	
	}
	
	// trims the supplied String if it is too long 
	public String trimString(String argument)
	{
		if(argument.length() > 16)
		{ 
			argument = argument.substring(0, 16);
		}
		
		return argument;
	}
	
	// sets name for object 
	public void setName(String name)
	{
		if(validateString(name))
		{
			this.name = trimString(name);
		}
		else
		{
			this.name = "Object Name";
		}
	}
	
	// gets name for object
	public String getName()
	{
		return name;
	}
	
	// sets class for object 
	public void setMainClass(String mainClass)
	{
		if(validateString(mainClass))
		{
			this.mainClass = trimString(mainClass);
		}
		else
		{
			this.mainClass = "Class";
		}
	}
	
	// gets class object belongs to 
	public String getMainClass()
	{
		return mainClass;
	}
	
	// sets category for object 
	public void setCategory(String category)
	{
		if(validateString(category))
		{
			this.category = trimString(category);
		}
		else
		{
			this.category = "Category";
		}
	}
	
	// gets category object belongs to 
	public String getCategory()
	{
		return category;
	}
	
	// sets super type for object (object belongs to a specified category. gun)
	public void setSuperType(String superType)
	{
		if(validateString(superType))
		{
			this.superType = trimString(superType);
		}
		else
		{
			this.superType = "Super Type";
		}
	}
	
	// gets super type for object (object belongs to a specified category. gun)
	public String getSuperType()
	{
		return superType;
	}
	
	// sets sub type for object such that object belongs to a group in a specific group of objects 
	public void setSubType(String subType)
	{
		if(validateString(subType))
		{
			this.subType = trimString(subType);
		}
		else
		{
			this.subType = "Sub Type";
		}
	}
	
	// gets sub type for object such that object belongs to a group in a specific group of objects 
	public String getSubType()
	{
		return subType;
	}
	
	// END: CLASSIFICATION BY STRING
	/*******************************************************************************/
	
	
	
	
	
	
	// START: CLASSIFICATION BY INTEGER
	/*******************************************************************************/
	
	// method checks whether supplied argument is within a desired bounds 
	public int checkBounds(int argument, int lowerBounds, int upperBounds)
	{
		if(argument < lowerBounds)
		{
			argument = lowerBounds;
		}
		else if(argument > upperBounds)
		{
			argument = upperBounds;
		}
		
		return argument;
	}
	
	// sets durability for object 
	public void setDurability(int durability)
	{
		this.durability = checkBounds(durability, 0, 500);
	}
	
	// gets durability for object
	public int getDurability()
	{
		return durability;
	}
	
	// sets how fast the character can use the object 
	public void setUseSpeed(int useSpeed)
	{
		this.useSpeed = checkBounds(useSpeed, -300, 300);
	}
	
	// gets how fast the character can use the object 
	public int getUseSpeed()
	{
		return useSpeed;
	}
	
	// sets buy price for object 
	public void setBuyPrice(int buyPrice)
	{
		this.buyPrice = checkBounds(buyPrice, 0, 50000);
	}
	
	// gets buy price for object
	public int getBuyPrice()
	{
		return buyPrice;
	}
	
	// sets sell price for object 
	public void setSellPrice(int sellPrice)
	{
		this.sellPrice = checkBounds(sellPrice, 0, 50000);
	}
	
	// gets sell price for object
	public int getSellPrice()
	{
		return sellPrice;
	}
	
	// END: CLASSIFICATION BY INTEGER
	/*******************************************************************************/
}
