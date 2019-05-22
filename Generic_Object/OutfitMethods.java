package Generic_Object;

/*
    OutfitMethods concerns managing aspects common amongst equippable outfits such 
    as the ability to equip Cores objects and boost the object's durability values. 
    
    Note on Cores objects and outfits: 
        If desired, players can add/remove/alter slot types tied to outfits. Cores 
        can also be transferred across outfits so long as slot/core types match if
        the player has enough funds or if certain conditions are met. 
*/

import Commonly_Used_Methods.StaticMethods;
import java.util.HashSet;
import java.util.Arrays;

public class OutfitMethods extends GenericObject
{
    // variables concerning max gauges 
    private double maxHealth, maxNano, maxStamina;
    
    // attributes tied to object 
    private double attack, defense, dexterity, critical, accuracy, nanoAttack, 
        nanoDefense, luck;
    
    // denotes regeneration/degeneration rates for following gauges on per turn basis 
    private double currentHealthRegeneration, currentStaminaRegeneration, 
        currentNanoRegeneration; 
    
    // level-up related variables which are directly multiplied with values and rounded down 
    private double expMultiplier, expGrowthRateBonus, skillPointBonus;
    
    // max durability denoting how much damage outfit can take before breaking 
    private double maxDurability;
    
    // current durability for outfit which lowers attributes the lower it is before outfit breaks at 0 
    private double currentDurability;
    
    // stores name of subclass object belongs to 
    private String subclassName;
    
    // stores "Any _ Core" slot type for outfit based on subclassName 
    private String anyCoreType;
        
    // variables store type of core a slot can take 
    private String slotOneType, slotTwoType, slotThreeType, slotFourType, 
        slotFiveType, slotSixType, slotSevenType;

    // variables store Cores object in specified slot 
    private Core slotOneCore, slotTwoCore, slotThreeCore, slotFourCore, 
        slotFiveCore, slotSixCore, slotSevenCore;

    // denotes how many slots an outfit can have at any one time (can be expanded)
    private int maxNumberOfOutfitSlots;
    
    
    
    // START: OUTFIT MAX GAUGES
    /*******************************************************************************/

    public double validateMaxGauges(double maxGauge)
    {
        if(maxGauge < 0) 
        {
            maxGauge = 0;
        }
        else if(maxGauge > 9999)
        {
            maxGauge = 9999;
        }

        return maxGauge;
    }

    public void setMaxHealth(double maxHealth) 
    {
        this.maxHealth = validateMaxGauges(maxHealth); 
    } 

    public double getMaxHealth()
    {
        return maxHealth; 
    } 

    public void setMaxStamina(double maxStamina) 
    {
        this.maxStamina = validateMaxGauges(maxStamina); 
    } 

    public double getMaxStamina()
    {
        return maxStamina; 
    } 
    
    public void setMaxNano(double maxNano) 
    {
        this.maxNano = validateMaxGauges(maxNano); 
    } 

    public double getMaxNano()
    {
        return maxNano; 
    } 

    // END: OUTFIT MAX GAUGES
    /*******************************************************************************/


    
    // START: OUTFIT ATTRIBUTES
    /*******************************************************************************/

    public double validateAttribute(double attribute)
    {
        if(attribute < 0) 
        {
            attribute = 0; 
        }
        else if(attribute > 999)
        {
            attribute = 999;
        }

        return attribute;
    }

    public void setAttack(double attack)
    {
        this.attack = validateAttribute(attack);
    }

    public double getAttack()
    {
        return attack; 
    } 

    public void setDefense(double defense)
    {
        this.defense = validateAttribute(defense);
    }

    public double getDefense()
    {
        return defense; 
    } 

    public void setDexterity(double dexterity)
    {
        this.dexterity = validateAttribute(dexterity);
    }

    public double getDexterity()
    {
        return dexterity; 
    } 

    public void setCritical(double critical)
    {
        this.critical = validateAttribute(critical);
    }

    public double getCritical()
    {
        return critical; 
    } 

    public void setAccuracy(double accuracy)
    {
        this.accuracy = validateAttribute(accuracy);
    }

    public double getAccuracy()
    {
        return accuracy; 
    } 

    public void setNanoAttack(double nanoAttack)
    {
        this.nanoAttack = validateAttribute(nanoAttack);
    }

    public double getNanoAttack()
    {
        return nanoAttack; 
    } 

    public void setNanoDefense(double nanoDefense)
    {
        this.nanoDefense = validateAttribute(nanoDefense);
    }

    public double getNanoDefense()
    {
        return nanoDefense; 
    } 

    public void setLuck(double luck)
    {
        this.luck = validateAttribute(luck);
    }

    public double getLuck()
    {
        return luck; 
    } 

    // END: OUTFIT ATTRIBUTES
    /*******************************************************************************/

    
    
    // START: OUTFIT REGENERATION (CURRENT GAUGE += (MAX GAUGE * REGENERATION))
    /*******************************************************************************/
    
    public double accessoryGaugeEffect(double effect)
    {
        if(effect < -1.0)
        {
            effect = 1.0;
        }
        else if (effect > 1.0)
        {
            effect = 1.0;
        }
        
        return effect;
    }
    
    public void setCurrentHealthRegeneration(double currentHealthRegeneration)
    {
        this.currentHealthRegeneration = accessoryGaugeEffect(currentHealthRegeneration);
    }
    
    public double getCurrentHealthRegeneration()
    {
        return currentHealthRegeneration;
    }
    
    public void setCurrentStaminaRegeneration(double currentStaminaRegeneration)
    {
        this.currentStaminaRegeneration = accessoryGaugeEffect(currentStaminaRegeneration);
    }
    
    public double getCurrentStaminaRegeneration()
    {
        return currentStaminaRegeneration;
    }
    
    public void setCurrentNanoRegeneration(double currentNanoRegeneration)
    {
        this.currentNanoRegeneration = accessoryGaugeEffect(currentNanoRegeneration);
    }
    
    public double getCurrentNanoRegeneration()
    {
        return currentNanoRegeneration;
    }
    
    // END: OUTFIT REGENERATION (CURRENT GAUGE += (MAX GAUGE * REGENERATION))
    /*******************************************************************************/

    
    
    // START: EFFECTS ON LEVELING MECHANICS
    /*******************************************************************************/
    
    public void setExpMultiplier(double expMultiplier)
    {
        this.expMultiplier = lowerUpperBounds(0.0, 3.0, expMultiplier);
    }
    
    public double getExpMultiplier()
    {
        return expMultiplier;
    }
    
    public void setExpGrowthRateBonus(double expGrowthRateBonus)
    {
        this.expGrowthRateBonus = lowerUpperBounds(0.0, 2.5, expGrowthRateBonus);
    }
    
    public double getGrowthExpRateBonus()
    {
        return expGrowthRateBonus;
    }
    
    public void setSkillPointBonus(double skillPointBonus)
    {
        this.skillPointBonus = lowerUpperBounds(0.0, 1.75, skillPointBonus);
    }
    
    public double getSkillPointBonus()
    {
        return skillPointBonus;
    }
    
    // END: EFFECTS ON LEVELING MECHANICS
    /*******************************************************************************/
    
    
    
    // START: DURABILITY METHODS
    /*******************************************************************************/		

    public void setMaxDurability(double maxDurability)
    {
        this.maxDurability = lowerUpperBounds(0, 500, maxDurability);
    }
    
    public double getMaxDurability()
    {
        return maxDurability;
    }

    public void setCurrentDurability(double currentDurability)
    {
        this.currentDurability = lowerUpperBounds(0, getMaxDurability(), currentDurability);
    }
    
    public double getCurrentDurability()
    {
        return currentDurability;
    }

    public double getDurabilityValue()
    {
        return lowerUpperBounds(0.33, 1.0, (getCurrentDurability() / getMaxDurability()));
    }
    
    // END: DURABILITY METHODS 
    /*******************************************************************************/		

    

    // START: SUBCLASS NAME 
    /*******************************************************************************/

    public enum SubclassNames
    {
        WEAPON("Weapon"), ARMOR("Armor"), ACCESSORY("Accessory");
        
        private String subclassNames;
        
        SubclassNames(String subclassNames)
        {
            this.subclassNames = subclassNames;
        }
        
        public String getEnumAsString()
        {
            return subclassNames;
        }
    }
    
    public void setSubclassName(String subclassName)
    {
        this.subclassName = SubclassNames.valueOf(StaticMethods.stringToEnum(subclassName)).getEnumAsString();
    }
    
    public String getSubclassNameString()
    {
        return subclassName;
    }
    
    public SubclassNames getSubclassNameEnum()
    {
        return SubclassNames.valueOf(StaticMethods.stringToEnum(subclassName));
    }
        
    // END: SUBCLASS NAME 
    /*******************************************************************************/

    
    
    // START: ANY CORE TYPE FOR SLOTS OF OUTFIT
    /*******************************************************************************/
    
    // get "Any _ Core" slot type as String based on subclass name passed 
    public enum AnyCoreTypeBySubclassNames
    {
        WEAPONS("Any Weapon Core"), ARMORS("Any Armor Core"), ACCESSORIES("Any Accessory Core"),
        CORES("Any Core");
        
        private String anyCoreTypeBySubclassNames;
        
        AnyCoreTypeBySubclassNames(String anyCoreTypeBySubclassNames)
        {
            this.anyCoreTypeBySubclassNames = anyCoreTypeBySubclassNames;
        }
        
        public String getEnumAsString()
        {
            return anyCoreTypeBySubclassNames;
        }
    }
    
    // setting "Any _ Core" slot type means slot can store any core the subclass 
    // (denoted by subclassName) considers valid (regular slots have types which
    // can ONLY equip a core that has the exact same type as the slot) 
    public void setAnyCoreSlotType()
    {
        // Note: slots/cores can have "Any Core" (in either case accept the core)
        anyCoreType = AnyCoreTypeBySubclassNames.valueOf(StaticMethods.stringToEnum(subclassName)).getEnumAsString();
    }
    
    public String getAnyCoreSlotTypeString()
    {
        return anyCoreType;
    }
    
    public AnyCoreTypeBySubclassNames getAnyCoreSlotTypeEnum()
    {
        return AnyCoreTypeBySubclassNames.valueOf(StaticMethods.stringToEnum(anyCoreType));
    }
    
    // END: ANY CORE TYPE FOR SLOTS OF OUTFIT
    /*******************************************************************************/
    
    
    
    // START: GENERICOBJECT SUBCLASS STRING VALIDATION AND ENUM RETRIEVAL 
    /*******************************************************************************/
    
    // WEAPONS SUBCLASS
    
    public enum WeaponSlotCoreTypes
    {
        MAX_STAMINA("Max Stamina"), MAX_NANO("Max Nano"), ATTACK("Attack"), DEXTERITY
        ("Dexterity"), CRITICAL("Critical"), ACCURACY("Accuracy"), NANO_ATTACK("Nano Attack"), 
        ANY_WEAPON_CORE("Any Weapon Core");
            
        private String weaponSlotCoreTypes;
        
        WeaponSlotCoreTypes(String weaponSlotCoreTypes)
        {
            this.weaponSlotCoreTypes = weaponSlotCoreTypes;
        }
        
        public String getEnumAsString()
        {
            return weaponSlotCoreTypes;
        }
    }
    
    public String getWeaponSlotCoreTypeString(String argument)
    {
        return WeaponSlotCoreTypes.valueOf(StaticMethods.stringToEnum(argument)).getEnumAsString();
    }
    
    public WeaponSlotCoreTypes getWeaponSlotCoreTypeEnum(String argument)
    {
        return WeaponSlotCoreTypes.valueOf(StaticMethods.stringToEnum(argument));
    }
    
    public static String[] weaponSlotCoreTypeValueStrings()
    {
        String[] array = new String[WeaponSlotCoreTypes.values().length];
        
        for(int i = 0; i < WeaponSlotCoreTypes.values().length; i++)
        {
            array[i] = WeaponSlotCoreTypes.values()[i].getEnumAsString();
        }

        return array;
    }
    
    // WEAPONS SUBCLASS
    
    
    // ARMORS SUBCLASS
    
    // Note: aside from attribute core/slot types, resistances also have slot/core types 
    public enum ArmorSlotCoreTypes
    {
        // slot/core types 
        MAX_HEALTH("Max Health"), MAX_STAMINA("Max Stamina"), MAX_NANO("Max Nano"), 
        DEFENSE("Defense"), DEXTERITY("Dexterity"), NANO_DEFENSE("Nano Defense"),
        ANY_ARMOR_CORE("Any Armor Core"),
        
        // current health status effects 
	ABLAZE("Ablaze"), BLEED("Bleed"), TOXIC("Toxic"),
	
	// attribute status effects 
	ATTACK_DOWN("Attack Down"), DEFENSE_DOWN("Defense Down"), SHUTDOWN("Shutdown"), 
	DEXTERITY_DOWN("Dexterity Down"), CRITICAL_DOWN("Critical Down"), ACCURACY_DOWN
	("Accuracy Down"), BLIND("Blind"), NANO_ATTACK_DOWN("Nano Attack Down"), 
	NANO_DEFENSE_DOWN("Nano Defense Down"),
	
	// behavior status effects 
	CONFUSED("Confused"), ENAMORED("Enamored"), BERSERK("Berserk"),
	
	// turn behavior status effects 
	FLINCHED("Flinched"), STUNNED("Stunned"), SCARED("Scared"), BOUND("Bound"), 
	SLEEP("Sleep"), TRANCED("Tranced"), SHOCKED("Shocked"), SLOWED("Slowed"), 
	STOPPED("Stopped"),
	
	// nullify status effects 
	NULLIFY_STATUS_EFFECTS("Nullify Status Effects");
        
        private String armorSlotCoreTypes;
        
        ArmorSlotCoreTypes(String armorSlotCoreTypes)
        {
            this.armorSlotCoreTypes = armorSlotCoreTypes;
        }
        
        public String getEnumAsString()
        {
            return armorSlotCoreTypes;
        }
    }
    
    public String getArmorSlotCoreTypeString(String argument)
    {
        return ArmorSlotCoreTypes.valueOf(StaticMethods.stringToEnum(argument)).getEnumAsString();
    }
    
    public ArmorSlotCoreTypes getArmorSlotCoreTypeEnum(String argument)
    {
        return ArmorSlotCoreTypes.valueOf(StaticMethods.stringToEnum(argument));
    }
    
    public static String[] armorSlotCoreTypeValueStrings()
    {
        String[] array = new String[ArmorSlotCoreTypes.values().length];
        
        for(int i = 0; i < ArmorSlotCoreTypes.values().length; i++)
        {
            array[i] = ArmorSlotCoreTypes.values()[i].getEnumAsString();
        }

        return array;
    }
    
    // ARMORS SUBCLASS
    
    
    // ACCESSORIES SUBCLASS
    
    public enum AccessorySlotCoreTypes
    {
        MAX_HEALTH("Max Health"), MAX_STAMINA("Max Stamina"), MAX_NANO("Max Nano"), 
        ATTACK("Attack"), DEFENSE("Defense"), DEXTERITY("Dexterity"), CRITICAL("Critical"), 
        ACCURACY("Accuracy"), NANO_ATTACK("Nano Attack"), NANO_DEFENSE("Nano Defense"), 
        LUCK("Luck"), ANY_ACCESSORY_CORE("Any Accessory Core"); 
        
        private String accessorySlotCoreTypes;
        
        AccessorySlotCoreTypes(String accessorySlotCoreTypes)
        {
            this.accessorySlotCoreTypes = accessorySlotCoreTypes;
        }
        
        public String getEnumAsString()
        {
            return accessorySlotCoreTypes;
        }
    }

    public String getAccessorySlotCoreTypeString(String argument)
    {
        return AccessorySlotCoreTypes.valueOf(StaticMethods.stringToEnum(argument)).getEnumAsString();
    }
    
    public AccessorySlotCoreTypes getAccessorySlotCoreTypeEnum(String argument)
    {
        return AccessorySlotCoreTypes.valueOf(StaticMethods.stringToEnum(argument));
    }
    
    public static String[] accessorySlotCoreTypeValueStrings()
    {
        String[] array = new String[AccessorySlotCoreTypes.values().length];
        
        for(int i = 0; i < AccessorySlotCoreTypes.values().length; i++)
        {
            array[i] = AccessorySlotCoreTypes.values()[i].getEnumAsString();
        }

        return array;
    }
    
    // ACCESSORIES SUBCLASS
    
    // END: GENERICOBJECT SUBCLASS STRING VALIDATION AND ENUM RETRIEVAL 
    /*******************************************************************************/

    
    // START: VALIDATING SUPPLIED SLOT TYPE AGAINST ACCEPTED SLOT TYPES 
    /*******************************************************************************/
    
    public String validateSlotCoreType(String slotCoreType)
    {
        if(slotCoreType != null)
        {
            switch(getSubclassNameEnum())
            {
                case WEAPON:
                    slotCoreType = getWeaponSlotCoreTypeString(slotCoreType);
                        break;
                case ARMOR: 
                    slotCoreType = getArmorSlotCoreTypeString(slotCoreType);
                        break;
                case ACCESSORY: 
                    slotCoreType = getAccessorySlotCoreTypeString(slotCoreType);
                        break;
            }
        }

        return slotCoreType;
    }
    
    public boolean stringExists(String[] array, String argument)
    {
        boolean result = false;
        
        for(String element : array)
        {
            if(element.equals(argument))
            {
                result = true;
            }
        }
        
        return result;
    }
    
    public boolean coreTypeValidForSubclassName(String coreType)
    { 
        boolean result = false;
    
        if(coreType != null)
        {
            switch(getSubclassNameEnum())
            {
                case WEAPON:
                    result = stringExists(weaponSlotCoreTypeValueStrings(), coreType);
                        break;
                case ARMOR: 
                    result = stringExists(armorSlotCoreTypeValueStrings(), coreType);
                        break;
                case ACCESSORY: 
                    result = stringExists(accessorySlotCoreTypeValueStrings(), coreType);
                        break;
            }
        }
        
        return result;
    }
    
    /* core validation requirements 
        -if core has core type "Any Core" or slot type is "Any Core" 
         then store core in slot 
        -compare core type against slot type and if there is a 
         match then equip core else reject core 
        -if slot type is "Any _ Core" then accept any core
         that object CAN have if core is valid (see subclassName) */
    
    public Core validateCore(Core core, String slotType)
    {
        Core holdCore = null;
        
        if(core != null && slotType != null)
        {
            if(core.getCoreType().equals("Any Core") || slotType.equals("Any Core"))
            {
                holdCore = core;
            }
            else if(core.getCoreType().equals(slotType))
            {
                holdCore = core;
            }
            else if(coreTypeValidForSubclassName(core.getCoreType()))
            {
                holdCore = core;
            }
        }
        
        return holdCore;
    }

    // END: VALIDATING SUPPLIED SLOT TYPE AGAINST ACCEPTED SLOT TYPES 
    /*******************************************************************************/


    
    // START: SLOT TYPES AND SLOT CORES WITH VALIDATION
    /*******************************************************************************/
    
    public void setSlotOneType(String slotOneType)
    {
        this.slotOneType = validateSlotCoreType(slotOneType);
    }

    public String getSlotOneType()
    {
        return slotOneType;
    }

    public void setSlotOneCore(Core slotOneCore)
    {
        this.slotOneCore = validateCore(slotOneCore, slotOneType);		
    }

    public Core getSlotOneCore()
    {
        return slotOneCore;
    }

    public void setSlotTwoType(String slotTwoType)
    {
        this.slotTwoType = validateSlotCoreType(slotTwoType);
    }

    public String getSlotTwoType()
    {
        return slotTwoType;
    }

    public void setSlotTwoCore(Core slotTwoCore)
    {
        this.slotTwoCore = validateCore(slotTwoCore, slotTwoType);
    }

    public Core getSlotTwoCore()
    {
        return slotTwoCore;
    }

    public void setSlotThreeType(String slotThreeType)
    {
        this.slotThreeType = validateSlotCoreType(slotThreeType);
    }

    public String getSlotThreeType()
    {
        return slotThreeType;
    }

    public void setSlotThreeCore(Core slotThreeCore)
    {
        this.slotThreeCore = validateCore(slotThreeCore, slotThreeType);
    }

    public Core getSlotThreeCore()
    {
        return slotThreeCore;
    }

    public void setSlotFourType(String slotFourType)
    {
        this.slotFourType = validateSlotCoreType(slotFourType);
    }

    public String getSlotFourType()
    {
        return slotFourType;
    }

    public void setSlotFourCore(Core slotFourCore)
    {
        this.slotFourCore = validateCore(slotFourCore, slotFourType);
    }

    public Core getSlotFourCore()
    {
        return slotFourCore;
    }

    public void setSlotFiveType(String slotFiveType)
    {
        this.slotFiveType = validateSlotCoreType(slotFiveType);
    }

    public String getSlotFiveType()
    {
        return slotFiveType;
    }

    public void setSlotFiveCore(Core slotFiveCore)
    {
        this.slotFiveCore = validateCore(slotFiveCore, slotFiveType);
    }

    public Core getSlotFiveCore()
    {
        return slotFiveCore;
    }
    
    public void setSlotSixType(String slotSixType)
    {
        this.slotSixType = validateSlotCoreType(slotSixType);
    }

    public String getSlotSixType()
    {
        return slotSixType;
    }

    public void setSlotSixCore(Core slotSixCore)
    {
        this.slotFiveCore = validateCore(slotSixCore, slotSixType);
    }

    public Core getSlotSixCore()
    {
        return slotSixCore;
    }
    
    public void setSlotSevenType(String slotSevenType)
    {
        this.slotSevenType = validateSlotCoreType(slotSevenType);
    }

    public String getSlotSevenType()
    {
        return slotSevenType;
    }

    public void setSlotSevenCore(Core slotFiveCore)
    {
        this.slotFiveCore = validateCore(slotSevenCore, slotSevenType);
    }

    public Core getSlotSevenCore()
    {
        return slotSevenCore;
    }
    
    // END: SLOT TYPES AND SLOT CORES WITH VALIDATION
    /*******************************************************************************/
    
    
    
    // START: EXISTING SLOT TYPES AND SLOT CORES 
    /*******************************************************************************/

    // COMMON METHODS
    
    public void setMaxNumberOfOutfitSlots(int maxNumberOfOutfitSlots)
    {
        this.maxNumberOfOutfitSlots = maxNumberOfOutfitSlots;
    }

    public int getMaxNumberOfOutfitSlots()
    {
        return maxNumberOfOutfitSlots;
    }
    
    // COMMON METHODS 
    
    
    // EXISTING SLOT TYPES
    
    public String[] getAllOutfitSlotTypes()
    {
        String[] allSlots = {getSlotOneType(), getSlotTwoType(), getSlotThreeType(),
            getSlotFourType(), getSlotFiveType(), getSlotSixType(), getSlotSevenType()};
                return allSlots;
    }
    
    public int getNumberOfExistingSlotTypes()
    {
        int numberOfExistingSlots = 0;
        
        for(String element : getAllOutfitSlotTypes())
        {
            if(element != null)
            {
                numberOfExistingSlots++;
            }
        }
        
        return numberOfExistingSlots;
    }
    
    public String[] addElementsToFirstArray(int arraySize, String[] array)
    {
        String[] newArray = new String[arraySize];
        
        int counter = 0;
        
        for(String element : array)
        {
            if(element != null)
            {
                newArray[counter] = element;
                    counter++;
            }
        }
        
        return newArray;
    }
    
    public String[] filterNullAndNoCharacters(String[] array)
    {
        String[] cleanedArray = Arrays.stream(array).filter(s -> (s != null && 
            s.length() > 0)).toArray(String[]::new);
                return cleanedArray;
    }
    
    public String[] getExistingSlotTypes()
    {
        return filterNullAndNoCharacters(addElementsToFirstArray(maxNumberOfOutfitSlots, 
            getAllOutfitSlotTypes()));
    }
    
    // EXISTING SLOT TYPES
    
    
    // EXISTING SLOT CORES
    
    public Core[] getAllOutfitSlotCores()
    {
        Core[] allSlotCores = {getSlotOneCore(), getSlotTwoCore(), getSlotThreeCore(), 
            getSlotFourCore(), getSlotFiveCore(), getSlotSixCore(), getSlotSevenCore()};
                return allSlotCores;
    }
    
    public int getNumberOfExistingCores()
    {
        int numberOfExistingCores = 0;
        
        for(Core element : getAllOutfitSlotCores())
        {
            if(element != null)
            {
                numberOfExistingCores++;
            }
        }
        
        return numberOfExistingCores;
    } 
    
    public Core[] addElementsToFirstArray(int arraySize, Core[] array)
    {
        Core[] newArray = new Core[arraySize];
        
        int counter = 0;
        
        for(Core element : array)
        {
            if(element != null)
            {
                newArray[counter] = element;
                    counter++;
            }
        }
        
        return newArray;
    }
    
    public Core[] filterNull(Core[] array)
    {
        Core[] cleanedArray = Arrays.stream(array).filter(s -> (s != null)).
            toArray(Core[]::new);
                return cleanedArray;
    }
    
    public Core[] getExistingCores()
    {
        return filterNull(addElementsToFirstArray(maxNumberOfOutfitSlots, 
            getAllOutfitSlotCores()));
    }
    
    // EXISTING SLOT CORES 
    
    // END: SETTING MAX NUMBER OF SLOT TYPES ALLOWED AND RETURNING CORES     
    // EXISTING SLOT CORES 
    
    // END: SETTING MAX NUMBER OF SLOT TYPES ALLOWED AND RETURNING CORES 
    /*******************************************************************************/

 
    
    // START: CORE PENALTY CALCULATION
    /*******************************************************************************/
    
    public Core.CoreSizes getCoreSizeEnum(String size)
    {
        Core.CoreSizes sizeEnum = null;
        
        if(size != null)
        {
            sizeEnum = Core.CoreSizes.valueOf(StaticMethods.stringToEnum(size));
        }
        
        return sizeEnum;
    }
    
    public Core.CoreTiers getCoreTierEnum(String tier)
    {
        Core.CoreTiers result = null;
        
        if(tier != null)
        {
            result = Core.CoreTiers.valueOf(StaticMethods.stringToEnum(tier));
        }
        
        return result;
    }
    
    /* returns HashSet filled with Strings representing core types from Cores array 
       Note: HashSet, like other "Set" imports, stores "unique" values which means 
             that copies/duplicates of a value that already exists within the "Set"
             will not be added. HashSet does not maintain any kind of ordering for 
             its contents unlike LinkedHashSet which does so at a performance cost. */
    public HashSet<String> getUniqueTypesOfEquippedCores()
    {
        HashSet<String> typesOfEquippedCores = new HashSet<>();

        for(Core element : getExistingCores())
        {
            if(element != null && element.getCoreType() != null)
            {
                typesOfEquippedCores.add(element.getCoreType());
            }
        }
        
        return typesOfEquippedCores;
    }
    
    public double countNumberOfSameCoreTypeCores(String coreType)
    {
        double counter = 0;

        for(Core element : getExistingCores())
        {
            if(element != null)
            {
                if(coreType.equals(element.getCoreType()))
                {
                    counter++;
                }
            }
        }

        return counter;
    }
    
    public double countDesiredCoresBySize(String coreType, String size)
    {
        double counter = 0;

        for(Core element : getExistingCores())
        {
            if(element != null)
            {
                if(coreType.equals(element.getCoreType()))
                {
                    if(getCoreTierEnum(size) == getCoreTierEnum(element.getCoreType()))
                    {
                        counter++;
                    }
                }
            }
        }
        
        return counter;
    }

    public double countDesiredCoresByTier(String coreType, String tier)
    {
        double counter = 0;

        for(Core element : getExistingCores())
        {
            if(element != null) 
            {
                if(coreType.equals(element.getCoreType()))
                {
                    if(getCoreTierEnum(tier) == getCoreTierEnum(element.getCoreTier()))
                    {
                        counter++;
                    }
                }
            }
        }
        
        return counter;
    }
    
    // calculate core penalty incurred for outfit that has cores equipped 
    // Note: penalty is meant to be subtracted from cores current points AFTER it 
    //       it is directly multipled against cores max points (avoids small #'s)
    public double corePenaltyCalculation(String typeOfCore)
    {
        double totalCorePenalty = 0;

        if(typeOfCore != null && getExistingCores() != null && getExistingCores().length >= 1)
        {
            // variable denoting penalty based on type, size, and tier 
            double typePenaltySum, sizePenaltySum, tierPenaltySum;
    
            // variables hold the penalty for a core based on its size 
            double verySmallPenalty, smallPenalty, mediumPenalty, largePenalty, 
                veryLargePenalty; 

            // variables hold the penalty for a core based on its tier 
            double tierOnePenalty, tierTwoPenalty, tierThreePenalty, tierFourPenalty, 
                tierFivePenalty; 
            
            // assigns default penalty for core regardless of type 
            typePenaltySum = 0.03; 
            
            // store penalty for all cores that have specified type 
            typePenaltySum *= countNumberOfSameCoreTypeCores(typeOfCore);

            // penalty incurred as a result of core size 
            verySmallPenalty = 0.012; smallPenalty = 0.026; mediumPenalty = 0.045; 
                largePenalty = 0.063; veryLargePenalty = 0.81; 

            // store penalty for the number of Cores that have the specified size 
            verySmallPenalty *= countDesiredCoresBySize(typeOfCore, "Very Small");
            smallPenalty *= countDesiredCoresBySize(typeOfCore, "Small");
            mediumPenalty *= countDesiredCoresBySize(typeOfCore, "Medium");
            largePenalty *= countDesiredCoresBySize(typeOfCore, "Large");
            veryLargePenalty *= countDesiredCoresBySize(typeOfCore, "Very Large");

            // store sum of size penalty for cores 
            sizePenaltySum = verySmallPenalty + smallPenalty + mediumPenalty + 
                largePenalty + veryLargePenalty;
            
            // penalty incurred as a result of core tier 
            tierOnePenalty = 0.007; tierTwoPenalty = 0.023; tierThreePenalty = 0.035; 
                tierFourPenalty = 0.047; tierFivePenalty = 0.058; 
            
            // store penalty for the number of Cores that have the specified tier 
            tierOnePenalty *= countDesiredCoresByTier(typeOfCore, "Tier 1");
            tierTwoPenalty *= countDesiredCoresByTier(typeOfCore, "Tier 2");
            tierThreePenalty *= countDesiredCoresByTier(typeOfCore, "Tier 3");
            tierFourPenalty *= countDesiredCoresByTier(typeOfCore, "Tier 4");
            tierFivePenalty *= countDesiredCoresByTier(typeOfCore, "Tier 5");

            // store sum of tier penalty for cores 
            tierPenaltySum = tierOnePenalty + tierTwoPenalty + tierThreePenalty + 
                tierFourPenalty + tierFivePenalty;
            
            // assign totalCorePenalty with sum of all penalty values representing total core penalty
            totalCorePenalty = typePenaltySum + sizePenaltySum + tierPenaltySum;
        }

        return totalCorePenalty; 
    }
    
    // apply core penalty to all cores equipped to outfit 
    // Note: HALVE PENALTY FOR SPECIAL CORES FOR NOW...
    public void applyCorePenalty()
    {
        for(String element : getUniqueTypesOfEquippedCores())
        {
            for(Core core : getExistingCores())
            {
                if(core != null)
                {
                    if(!core.getSpecialCoreState())
                    {
                        if(element.equals(core.getCoreType()))
                        {
                            core.setCurrentCorePoints(core.getCurrentCorePoints() - 
                                (core.getMaxCorePoints() * corePenaltyCalculation(element)));
                        }
                    }
                    else
                    {
                        core.setCurrentCorePoints(core.getCurrentCorePoints() - ((core.
                            getMaxCorePoints() * corePenaltyCalculation(element)) / 2.35));
                    }
                }                
            }
        }
    }

    // END: CORE PENALTY CALCULATION
    /*******************************************************************************/
    
    
    
    // START: TOTAL FOR ATTRIBUTES WITH CORES SUPPLIED
    /*******************************************************************************/
    
    public double addSumOfCoresForCoreType(String coreType)
    {
        double coreSum = 0.0;
        
        if(coreType != null)
        {
            for(Core element : getExistingCores())
            {
                if(element != null)
                {
                    if(coreType.equals(element.getCoreType()))
                    {
                        coreSum +=  element.getCurrentCorePoints();
                    }
                }
            }
        }
        
        return coreSum;
    }

    public double outfitDurabilityEffect(double value, double durability)
    {
        // Note: if accounts for resistances, if-else for resistances and attributes 
        if(value < 0)
        {
            value = (-1 * value) - ((1.0 - durability) * value);
        }
        else
        {
            value -= ((1.0 - durability) * value);
        }

        return value;
    }
    
    /*  Note on "total" methods below: 
            methods get total value for a object (like attack, nano, ect.) by adding 
            object's power and core points together only if the cores are the same 
            type as the String supplied as argument (if "Attack" is supplied then 
            add the current core points of cores with core type "Attack" to value) */
    
    public double totalOutfitValue(double stat, String statName)
    {
        return outfitDurabilityEffect((stat + addSumOfCoresForCoreType(statName)), 
            getDurabilityValue());
    }
    
    // END: TOTAL FOR ATTRIBUTES WITH CORES SUPPLIED    
    /*******************************************************************************/
    
    
    
    // START: TOTAL ATTRIBUTES 
    /*******************************************************************************/

    // MAX GAUGES
	
    public double getTotalMaxHealth()
    {
        return totalOutfitValue(getMaxHealth(), "Max Health");
    }
    
    public double getTotalMaxStamina()
    {
        return totalOutfitValue(getMaxStamina(), "Stamina");
    }
	
    public double getTotalMaxNano()
    {
        return totalOutfitValue(getMaxNano(), "Nano"); 
    }
	
    // MAX GAUGES
	
	
    // TYPICAL ATTRIBUTES 
    
    public double getTotalAttack()
    {
        return totalOutfitValue(getAttack(), "Attack"); 
    }

	public double getTotalDefense()
    {
        return totalOutfitValue(getDefense(), "Defense");
    }

    public double getTotalDexterity()
    {
        return totalOutfitValue(getDexterity(), "Dexterity"); 
    }

    public double getTotalCritical()
    {
        return totalOutfitValue(getCritical(), "Critical"); 
    }

    public double getTotalAccuracy()
    {
        return totalOutfitValue(getAccuracy(), "Accuracy"); 
    }
	
    public double getTotalNanoAttack()
    {
        return totalOutfitValue(getNanoAttack(), "Nano Attack"); 
    }
	
    public double getTotalNanoDefense()
    {
        return totalOutfitValue(getNanoDefense(), "Nano Defense");
    }
	
    // TYPICAL ATTRIBUTES 

    // END: TOTAL ATTRIBUTES 
    /*******************************************************************************/
    
    
    
    // START: GETTING ALL TOTAL ATTRIBUTES
    /*******************************************************************************/

    public double[] getAllTotalAttributes()
    {
        double[] allTotalAttributes = {getTotalMaxHealth(), getTotalMaxStamina(),
            getTotalMaxNano(), getTotalAttack(), getTotalDefense(), getTotalDexterity(),
            getTotalCritical(), getTotalAccuracy(), getTotalNanoAttack(), getTotalNanoDefense()};
                return allTotalAttributes;
    }
    
    public Object[] getAllTotalAttributesWithNames()
    {
        Object[] allTotalAttributes = {"Max Health", getTotalMaxHealth(), "Max Stamina", 
            getTotalMaxStamina(), "Max Nano", getTotalMaxNano(), "Attack", getTotalAttack(), 
            "Defense", getTotalDefense(), "Dexterity", getTotalDexterity(), "Critical", 
            getTotalCritical(), "Accuracy", getTotalAccuracy(), "Nano Attack", getTotalNanoAttack(), 
            "Nano Defense", getTotalNanoDefense()};
                return allTotalAttributes;
    }
    
    // START: WEAPON ENCHANTMENT
    /*******************************************************************************/
}
