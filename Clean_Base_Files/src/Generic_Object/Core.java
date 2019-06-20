package Generic_Object;

import Commonly_Used_Methods.StaticMethods;

/*
    Cores extends GenericObject and defines methods related to creation of cores.
    "Cores" objects can be equipped to an outfit (weapons/armors/accessories) if 
    said outfit has a slot type that accepts the core based on core's core type.
    If type for core is "Any Core" then core is equipped regardless of core type.
    Cores have max points and current points where max points denotes max output
    that core can supply upon initial use and current points denotes the current
    output of core which degrades with core use. Current core points are added to
    outfit value that the core type corresponds to (core type "Nano" boosts nano).
    
    Note on Enum classes: 
        valueOf() throws Illegal Argument Exception if argument passed
        does not exist within the enum class Exactly as it is in class
    Ex: enum class Example, which is uppercase like class names are, has 
        HATS as an enum. Supplying Example.valueOf() with String that do 
        not exist in Example such as hats (like Example.valueOf("hats"))
        is considered illegal since HATS and hats are different. However
        if HATS is supplied (like Example.valueOf("HATS")) the valueOf()
        method will execute as intended 
*/

public class Core extends GenericObject
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
    public Core()
    {
        // empty constructor 
    }


    
    // START: CORE CATEGORY, SUPERTYPE, AND SUBTYPE
    /*******************************************************************************/

    public enum CoreCategory
    { 
        STANDARD("Standard"), SPECIAL("Special");
        
        private String coreCategory;
        
        CoreCategory(String coreCategory)
        {
            this.coreCategory = coreCategory;
        }
        
        public String getEnumAsString()
        {
            return coreCategory;
        }
    } 
    
    public void setCoreCategory(String argument)
    {
        super.setCategory(CoreCategory.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public CoreCategory getCoreCategoryEnum()
    {
        return CoreCategory.valueOf(StaticMethods.stringToEnum(super.getCategory()));
    }
    
    public enum CoreSuperTypes 
    {
        ATTRIBUTE("Attribute"), RESISTANCE("Resistance"), OTHER("Other");
        
        private String coreSuperType;
        
        CoreSuperTypes(String coreSuperType)
        {
            this.coreSuperType = coreSuperType;
        }
        
        public String getEnumAsString()
        {
            return coreSuperType;
        }
    } 
    
    public void setCoreSuperType(String argument)
    {
        super.setSuperType(CoreSuperTypes.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public CoreSuperTypes getCoreSuperTypeEnum()
    {
        return CoreSuperTypes.valueOf(StaticMethods.stringToEnum(super.getSuperType()));
    }
    
    public enum CoreSubTypes 
    {
        // attributes 
        MAX_HEALTH("Max Health"), MAX_STAMINA("Max Stamina"), MAX_NANO("Max Nano"), 
        ATTACK("Attack"), DEFENSE("Defense"), DEXTERITY("Dexterity"), CRITICAL("Critical"), 
        ACCURACY("Accuracy"), NANO_ATTACK("Nano Attack"), NANO_DEFENSE("Nano Defense"), 
        LUCK("Luck"),
        
        // enchantments
        FIRE("Fire"), WATER("Water"), ICE("Ice"), ELECTRICITY("Electricity"), 
        POISON("Poison"), SONIC("Sonic"), PLASMA("Plasma"), WIND("Wind"),
        
        // unique
        ABLAZE("Ablaze"), BLEED("Bleed"), TOXIC("Toxic"),
        
        // attribute
        ATTACK_DOWN("Attack Down"), DEFENSE_DOWN("Defense Down"), SHUTDOWN("Shutdown"), 
        DEXTERITY_DOWN("Dexterity Down"), CRITICAL_DOWN("Critical Down"), ACCURACY_DOWN
        ("Accuracy Down"), BLIND("Blind"), NANO_ATTACK_DOWN("Nano Attack Down"), 
        NANO_DEFENSE_DOWN("Nano Defense Down"),
		
        // behavior
        CONFUSED("Confused"), ENAMORED("Enamored"), BERSERK("Berserk"),
		
        // turn behavior
        FLINCHED("Flinched"), STUNNED("Stunned"), SCARED("Scared"), BOUND("Bound"), 
        SLEEP("Sleep"), TRANCED("Tranced"), SHOCKED("Shocked"), SLOWED("Slowed"), 
        STOPPED("Stopped"),
		
        // nullify
        NULLIFY_STATUS_EFFECTS("Nullify Status Effects"),
        
        // unique (WORK IN PROGRESS...)
        SECOND_CHANCE("Second Chance");
        
        private String coreSubType;
        
        CoreSubTypes(String coreSubType)
        {
            this.coreSubType = coreSubType;
        }
        
        public String getEnumAsString()
        {
            return coreSubType;
        }
    } 
    
    public void setCoreSubType(String argument)
    {
        super.setSubType(CoreSubTypes.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public CoreSubTypes getCoreSubTypeEnum()
    {
        return CoreSubTypes.valueOf(StaticMethods.stringToEnum(super.getSubType()));
    }
    
    // END: ITEN CATEGORY, SUPERTYPE, AND SUBTYPE
    /*******************************************************************************/

    
    
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
    
    // if NOT a special core, then supply super.getSubType() 
    public void setCoreType(String coreType)
    {
        if(specialCoreState && coreType != null)
        {
            this.coreType = coreType;
        }
        else if(!specialCoreState && coreType != null)
        {
            this.coreType = getSubType();
        }
    }
    
    public String getCoreType()
    {
        return coreType;
    }
    
    public enum CoreSizes
    {
        VERY_SMALL("Very Small"), SMALL("Small"), MEDIUM("Medium"), LARGE("Large"), 
        VERY_LARGE("Very Large");
        
        private String coreSizes;
        
        CoreSizes(String coreSizes)
        {
            this.coreSizes = coreSizes;
        }
        
        public String getEnumAsString()
        {
            return coreSizes;
        }
    }
    
    public void setCoreSize(String coreSize)
    {
        this.coreSize = CoreSizes.valueOf(StaticMethods.stringToEnum(coreSize)).getEnumAsString();
    }

    public String getCoreSizeString()
    {
        return coreSize;
    }
    
    public CoreSizes getCoreSizeEnum()
    {
        return CoreSizes.valueOf(StaticMethods.stringToEnum(coreSize));
    }

    public enum CoreTiers
    {
        TIER_1("Tier 1"), TIER_2("Tier 2"), TIER_3("Tier 3"), TIER_4("Tier 4"), 
        TIER_5("Tier 5");
        
        private String coreTiers;
        
        CoreTiers(String coreTiers)
        {
            this.coreTiers = coreTiers;
        }
        
        public String getEnumAsString()
        {
            return coreTiers;
        }
    }
    
    public void setCoreTier(String coreTier)
    {
        this.coreTier = CoreTiers.valueOf(StaticMethods.stringToEnum(coreTier)).getEnumAsString();
    }

    public String getCoreTierString()
    {
        return coreTier;
    }
    
    public CoreTiers getCoreTierEnum()
    {
        return CoreTiers.valueOf(StaticMethods.stringToEnum(coreTier));
    }

    // END: CORE ATTRIBUTES
    /*******************************************************************************/


    
    // START: CORE POINTS
    /*******************************************************************************/

    public double getMaxPointsForCoreSize()
    {
        double points = 0;
        
        switch(getCoreSizeEnum())
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
        
        switch(getCoreTierEnum())
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
