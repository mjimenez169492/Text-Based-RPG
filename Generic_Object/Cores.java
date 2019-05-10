package Generic_Object;

import Universally_Used_Methods.StaticMethods;

/*
    Cores extends GenericObject and defines methods related to creation of cores.
    "Cores" objects can be equipped to an outfit (weapons/armors/accessories) if 
    said outfit has a slot type that accepts the core based on core's core type.
    If type for core is "Any Core" then core is equipped regardless of core type.
    Cores have max points and current points where max points denotes max output
    that core can supply upon initial use and current points denotes the current
    output of core which degrades with core use. Current core points are added to
    outfit value that the core type corresponds to (core type "Nano" boosts nano).
*/

public class Cores extends GenericObject
{
    // denote whether core is considered special or not (MUST BE DONE FIRST)
    boolean specialCoreState;
    
    // holds what type of core the core is, core size, core tier, and if String is valid  
    private String coreType, coreSize, coreTier;

    // hold max value a core can hold and the current value held within a core
    private double maxCorePoints, currentCorePoints;

    // create Cores with nothing supplied to super constructor due to too many parameters
    // objects created through this constructor can be customized further by calling set 
    // methods within this class
    public Cores()
    {
        // empty constructor 
    }


    
    // START: CORE ATTRIBUTES
    /*******************************************************************************/
    
    // Note: "Special" cores are cores that typically grant advantages in battle 
    public void setSpecialCoreState(boolean specialCoreState)
    {
        this.specialCoreState = specialCoreState;
    }
    
    public boolean getSpecialCoreState()
    {
        return specialCoreState;
    }
    
    public void setCoreType(String coreType)
    {
        if(!specialCoreState)
        {
            this.coreType = StaticMethods.getStatAsValidString(getSubType());
        }
        else
        {
            this.coreType = coreType;
        }        
    }

    public String getCoreType()
    {
        return coreType;
    }
    
    public enum ValidCoreSizes
    {
        VERY_SMALL, SMALL, MEDIUM, LARGE, VERY_LARGE;
    }
    
    public String validateCoreSize(String size)
    {
        if(size != null)
        {
            switch(ValidCoreSizes.valueOf(StaticMethods.stringToEnum(size)))
            {
                case VERY_SMALL:
                    size = "Very Small";
                        break;
                case SMALL:
                    size = "Small";
                        break;
                case MEDIUM:
                    size = "Medium";
                        break;
                case LARGE:
                    size = "Large";
                        break;
                case VERY_LARGE:
                    size = "Very Large";
                        break;
            }
        }
        
        return size;
    }

    public void setCoreSize(String coreSize)
    {
        this.coreSize = validateCoreSize(coreSize);
    }

    public String getCoreSize()
    {
        return coreSize;
    }

    public enum ValidCoreTiers
    {
        TIER_1, TIER_2, TIER_3, TIER_4, TIER_5;
    }
    
    // fix here!!!
    
    public String validateCoreTier(String tier)
    {
        if(tier != null)
        {
            switch(ValidCoreTiers.valueOf(StaticMethods.stringToEnum(tier)))
            {
                case TIER_1:
                    tier = "Tier 1";
                        break;
                case TIER_2:
                    tier = "Tier 2";
                        break;
                case TIER_3:
                    tier = "Tier 3";
                        break;
                case TIER_4:
                    tier = "Tier 4";
                        break;
                case TIER_5:
                    tier = "Tier 5";
                        break;
            }
        }
        
        return tier;
    }

    public void setCoreTier(String coreTier)
    {
        this.coreTier = validateCoreTier(coreTier);
    }

    public String getCoreTier()
    {
        return coreTier;
    }

    // END: CORE ATTRIBUTES
    /*******************************************************************************/


    
    // START: CORE POINTS
    /*******************************************************************************/

    public double getMaxPointsForCoreSize()
    {
        double points = 0;
        
        switch(ValidCoreSizes.valueOf(StaticMethods.stringToEnum(coreSize)))
        {
            case VERY_SMALL:
                points = 5.0;
                    break;
            case SMALL:
                points = 15.0;
                    break;
            case MEDIUM:
                points = 25.0;
                    break;
            case LARGE:
                points = 35.0;
                    break;
            case VERY_LARGE:
                points = 45.0;
                    break;
        }
        
        return points;
    }
    
    public double getMaxPointsForCoreTier()
    {
        double points = 0;
        
        switch(ValidCoreTiers.valueOf(StaticMethods.stringToEnum(coreTier)))
        {
            case TIER_1:
                points = 2.0;
                    break;
            case TIER_2:
                points = 6.0;
                    break;
            case TIER_3:
                points = 10.0;
                    break;
            case TIER_4:
                points = 12.0;
                    break;
            case TIER_5:
                points = 16.0;
                    break;
        }
        
        return points;
    }
    
    public void setMaxCorePoints()
    {
        maxCorePoints = getMaxPointsForCoreSize() + getMaxPointsForCoreTier();
    }

    public double getMaxCorePoints()
    {
        return maxCorePoints; 
    }
    
    public void setCurrentCorePoints(double currentCorePoints)
    {
        if(currentCorePoints < 0.00)
        {
            currentCorePoints = 0.00;
        }
        else if(currentCorePoints > maxCorePoints)
        {
            currentCorePoints = maxCorePoints;
        }

        this.currentCorePoints = currentCorePoints;
    }

    public double getCurrentCorePoints()
    {
        return currentCorePoints;
    }

    // END: CORE POINTS
    /*******************************************************************************/
}