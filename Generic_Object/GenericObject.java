package Generic_Object;

/*
    GenericObject serves as a superclass for future classes that extend it (known 
    as subclasses). Methods within this class are primarily used for defining the
    overall use of an object in the game world. 
*/

import Commonly_Used_Methods.StaticMethods;

public class GenericObject 
{
    private String name;               	// name of object 
    private String briefDescription;    // brief description denoting use 
    private String mainClass;		// name of class that object belongs to
    private String category;		// category object belongs to 
    private String superType;		// object group within category
    private String subType;		// grouping within object group of a category 
    private double useSpeed;		// speed value (multiplied against user dexterity)
    private double buyPrice;		// money needed to buy object 
    private double sellPrice;		// money received by selling object 
    private double stealRate; 		// rate (out of 100) denoting object steal chance 	
    private double pilferRate;          // rate (out of 100) denoting object pilfer chance
    private double dropRate; 		// rate (out of 100) denoting object drop chance 
    
    
    
    // START: COMMONLY USED METHODS
    /*******************************************************************************/

    public String hardcodedStringLength(String argument) 
    {
        if(argument != null && !argument.equals(""))
        {
            if(argument.length() > 26)
            { 
                argument = argument.substring(0, 25);
            }
        }

        return argument;
    }
    
    public String customStringLength(String argument, int characterLength) 
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
    
    // END: COMMONLY USED METHODS
    /*******************************************************************************/

    
    
    // START: CLASSIFICATION BY STRING
    /*******************************************************************************/
    
    public void setName(String name)
    {
        this.name = hardcodedStringLength(name);
    }

    public String getName()
    {
        return name;
    }

    public void setBriefDescription(String briefDescription)
    {
        this.briefDescription = customStringLength(briefDescription, 50);
    }
    
    public String getBriefDescription()
    {
        return briefDescription;
    }

    public enum MainClasses
    {
        ITEM("Item"), CORE("Core"), WEAPON("Weapon"), ARMOR("Armor"), 
        ACCESSORY("Accessory");
        
        private String mainClass;
        
        MainClasses(String mainClass)
        {
            this.mainClass = mainClass;
        }
        
        public String getEnumAsString()
        {
            return mainClass;
        }
    }
    
    public void setMainClass(String mainClass)
    {
        this.mainClass = MainClasses.valueOf(StaticMethods.stringToEnum(mainClass)).getEnumAsString();
    }
    
    public String getMainClassString()
    {
        return MainClasses.valueOf(StaticMethods.stringToEnum(mainClass)).getEnumAsString();
    }
    
    public MainClasses getMainClassEnum()
    {
        return MainClasses.valueOf(StaticMethods.stringToEnum(mainClass));
    }

    public void setCategory(String category)
    {
        this.category = hardcodedStringLength(category);
    }

    public String getCategory()
    {
        return category;
    }

    public void setSuperType(String superType)
    {
        this.superType = hardcodedStringLength(superType);
    }

    public String getSuperType()
    {
        return superType;
    }
    
    public void setSubType(String subType)
    {
        this.subType = hardcodedStringLength(subType);
    }

    public String getSubType()
    {
        return subType;
    }
    
    // END: CLASSIFICATION BY STRING
    /*******************************************************************************/



    // START: ATTRIBUTE ASSIGNMENT
    /*******************************************************************************/

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

    public void setUseSpeed(double useSpeed)
    {
        this.useSpeed = lowerUpperBounds(0.0, 1.5, useSpeed);
    }

    public double getUseSpeed()
    {
        return useSpeed;
    }

    public void setBuyPrice(double buyPrice)
    {
        this.buyPrice = lowerUpperBounds(0, 50000.0, buyPrice);
    }

    public double getBuyPrice()
    {
        return buyPrice;
    }

    public void setSellPrice(double sellPrice)
    {
        this.sellPrice = lowerUpperBounds(0, 50000.0, sellPrice);
    }

    public double getSellPrice()
    {
        return sellPrice;
    }

    public void setStealRate(double stealRate)
    {
        this.stealRate = lowerUpperBounds(0, 100.0, stealRate);
    }

    public double getStealRate()
    {
        return stealRate;
    }
    
    public void setPilferRate(double pilferRate)
    {
        this.pilferRate = lowerUpperBounds(0, 100.0, pilferRate);
    }

    public double getPilferRate()
    {
        return pilferRate;
    }
    
    public void setDropRate(double dropRate)
    {
        this.dropRate = lowerUpperBounds(0, 100.0, dropRate);
    }

    public double getDropRate()
    {
        return dropRate;
    }

    // END: ATTRIBUTE ASSIGNMENT 
    /*******************************************************************************/
}
