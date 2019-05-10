package Generic_Object;

/*
    GenericObject serves as a superclass for future classes that extend it (known 
    as subclasses). Methods within this class are primarily used for defining the
    overall use of an object in the game world. 
*/

public class GenericObject 
{
    private String name;               	// name of object 
    private String briefDescription;    // brief description denoting use 
    private String mainClass;		// name of class object belongs to
    private String category;		// category object belongs to 
    private String superType;		// object group within category
    private String subType;		// grouping within object group of a category 
    private double useSpeed;		// speed value (multiplied against user dexterity)
    private double buyPrice;		// money needed to buy object 
    private double sellPrice;		// money received by selling object 
    private double stealRate; 		// rate (out of 100) denoting object steal chance 	
    private double pilferRate;          // rate (out of 100) denoting object pilfer chance
    private double dropRate; 		// rate (out of 100) denoting object drop chance 
    
    
    
    // START: CLASSIFICATION BY STRING
    /*******************************************************************************/
    
    // validates and returns supplied String up to character length specified
    public String validateStringLength(String argument, int characterLength) 
    {
        if(argument != null && !argument.equals(""))
        {
            if(argument.length() > characterLength)
            { 
                argument = argument.substring(0, characterLength);
            }
        }

        return argument;
    }

    // sets name for object 
    public void setName(String name)
    {
        this.name = validateStringLength(name, 26);
    }

    // gets name for object
    public String getName()
    {
        return name;
    }

    // sets a brief description for object 
    public void setBriefDescription(String briefDescription)
    {
        this.briefDescription = validateStringLength(briefDescription, 140);
    }
    
    // gets a brief description for object 
    public String getBriefDescription()
    {
        return briefDescription;
    }

    // sets class object belongs to
    public void setMainClass(String mainClass)
    {
        this.mainClass = validateStringLength(mainClass, 16);
    }

    // gets class object belongs to 
    public String getMainClass()
    {
        return mainClass;
    }

    // sets category for object 
    public void setCategory(String category)
    {
        this.category = validateStringLength(category, 16);
    }

    // gets category object belongs to 
    public String getCategory()
    {
        return category;
    }

    // sets super type for object such that objects belong to a group within a category
    public void setSuperType(String superType)
    {
        this.superType = validateStringLength(superType, 16);
    }

    // gets super type for object such that objects belong to a group within a category
    public String getSuperType()
    {
        return superType;
    }
    
    // sets sub type for object such that object belongs to a group in a specific group of objects 
    public void setSubType(String subType)
    {
        this.subType = validateStringLength(subType, 16);
    }

    // gets sub type for object such that object belongs to a group in a specific group of objects 
    public String getSubType()
    {
        return subType;
    }
    
    // END: CLASSIFICATION BY STRING
    /*******************************************************************************/



    // START: ATTRIBUTE ASSIGNMENT
    /*******************************************************************************/

    // checks whether supplied argument is within a desired bounds 
    public int lowerUpperBounds(int lowerBounds, int upperBounds, int argument)
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

    /* Note: lowerUpperBounds() is overloaded to account for doubles */
    // checks whether supplied argument is within a desired bounds 
    public double lowerUpperBounds(double lowerBounds, double upperBounds, double argument)
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

    // sets how fast character can use object (value is multiplied against userr dexterity)
    public void setUseSpeed(double useSpeed)
    {
        this.useSpeed = lowerUpperBounds(0.0, 1.5, useSpeed);
    }

    // gets how fast character can use use object 
    public double getUseSpeed()
    {
        return useSpeed;
    }

    // sets buy price for object 
    public void setBuyPrice(int buyPrice)
    {
        this.buyPrice = lowerUpperBounds(0, 50000, buyPrice);
    }

    // gets buy price for object
    public double getBuyPrice()
    {
        return buyPrice;
    }

    // sets sell price for object 
    public void setSellPrice(int sellPrice)
    {
        this.sellPrice = lowerUpperBounds(0, 50000, sellPrice);
    }

    // gets sell price for object
    public double getSellPrice()
    {
        return sellPrice;
    }

    // sets steal rate for object 
    public void setStealRate(int stealRate)
    {
        this.stealRate = lowerUpperBounds(0, 100, stealRate);
    }

    // gets steal rate for object
    public double getStealRate()
    {
        return stealRate;
    }
    
    // sets pilfer rate for object 
    public void setPilferRate(int pilferRate)
    {
        this.pilferRate = lowerUpperBounds(0, 100, pilferRate);
    }

    // gets pilfer rate for object
    public double getPilferRate()
    {
        return pilferRate;
    }
    
    // sets drop rate for object 
    public void setDropRate(int dropRate)
    {
        this.dropRate = lowerUpperBounds(0, 100, dropRate);
    }

    // gets drop rate for object
    public double getDropRate()
    {
        return dropRate;
    }

    // END: ATTRIBUTE ASSIGNMENT 
    /*******************************************************************************/
}