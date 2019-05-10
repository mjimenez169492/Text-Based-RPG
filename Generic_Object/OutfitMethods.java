package Generic_Object;

/*
    OutfitMethods concerns managing aspects common amongst equippable outfits such 
    as the ability to equip Cores objects and boost the object's durability values. 
    
    Note on Cores objects and outfits: 
        If desired, players can add/remove/alter slot types tied to outfits. Cores 
        can also be transferred across outfits so long as slot/core types match if
        the player has enough funds or if certain conditions are met. 
*/

import Generic_Object.Cores;
import Generic_Object.GenericObject;
import Universally_Used_Methods.StaticMethods;
import java.util.HashMap;
import java.util.HashSet;

public class OutfitMethods extends GenericObject
{
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
    private Cores slotOneCore, slotTwoCore, slotThreeCore, slotFourCore, 
        slotFiveCore, slotSixCore, slotSevenCore;

    // denotes how many slots an outfit can have at any one time (can be expanded)
    private int maxNumberOfSlots;
    

    
    // START: DURABILITY METHODS
    /*******************************************************************************/		

    // sets max durability for outfit 
    public void setMaxDurability(double maxDurability)
    {
        this.maxDurability = lowerUpperBounds(0, 500, maxDurability);
    }
    
    // gets max durability for outfit 
    public double getMaxDurability()
    {
        return maxDurability;
    }

    // sets current durability for outfit 
    public void setCurrentDurability(double currentDurability)
    {
        this.currentDurability = lowerUpperBounds(0, getMaxDurability(), currentDurability);
    }
    
    // gets current durability for outfit 
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

    

    // START: SUBCLASS NAME AND ADDITTIONAL SUBCLASS METHODS 
    /*******************************************************************************/

    // enum class containing valid subclasses of GenericObject and OutfitMethods 
    public enum ValidSubclassNames
    {
        WEAPONS, ARMORS, ACCESSORIES;
    }
    
    // determines whether String passed matches one of the valid subclass names 
    // as specified within enum class ValidSubclassNames and returns the result 
    // as a String 
    public String getSubclassNameAsValidString(String argument)
    {
        /* Note: valueOf() throws Illegal Argument Exception if argument passed
               does not exist within the enum class Exactly as it is in class
           Ex: enum class Example, which is uppercase like class names are, has 
               HATS as an enum. Supplying Example.valueOf() with String that do 
               not exist in Example such as hats (like Example.valueOf("hats"))
               is considered illegal since HATS and hats are different. However
               if HATS is supplied (like Example.valueOf("HATS")) the valueOf()
               method will execute as intended */
        switch(ValidSubclassNames.valueOf(StaticMethods.stringToEnum(argument)))
        {
            case WEAPONS: 
                argument = "Weapons";
                    break; 
            case ARMORS: 
                argument = "Armors";
                    break; 
            case ACCESSORIES: 
                argument = "Accessories";
                    break;
        }
        
        return argument;
    }
    
    // determines whether String passed matches one of the valid subclass names 
    // as specified within enum class ValidSubclassNames and returns the result 
    // as an enum from ValidSubclassNames 
    public ValidSubclassNames getSubclassNameAsEnumUsingString(String argument)
    {
        ValidSubclassNames type = ValidSubclassNames.valueOf(StaticMethods.stringToEnum(argument));        
                return type;
    }
    
    // sets name of subclass outfit belongs to (done within constructor of subclass)
    public void setSubclassName(String subclassName)
    {
        this.subclassName = getSubclassNameAsValidString(subclassName);
    }
    
    // gets name of subclass oufit belongs to 
    public String getSubclassName()
    {
        return subclassName;
    }
        
    // END: SUBCLASS NAME AND ADDITTIONAL SUBCLASS METHODS 
    /*******************************************************************************/

    
    
    // START: ANY CORE TYPE FOR SLOTS OF OUTFIT
    /*******************************************************************************/
    
    // enum class containing "Any _ Core" types for slot which can accept cores that
    // subclass (based on subclass name) considers valid 
    // Note: slots/cores can have "Any Core" albeit rarely (in either case accept core)
    public enum ValidAnyCoreTypes
    {
        ANY_WEAPON_CORE, ANY_ARMOR_CORE, ANY_ACCESSORY_CORE, ANY_CORE;
    }
    
    // returns String reprsenting "Any _ Core" for slot type based on subclass 
    // outfit belongs to (use with getAnyCoreTypeAsStringBasedOnSubclassName())
    public String getAnyCoreTypeString(String argument)
    {
        switch(ValidAnyCoreTypes.valueOf(StaticMethods.stringToEnum(argument)))
        {
            case ANY_WEAPON_CORE: 
                argument = "Any Weapon Core";
                    break; 
            case ANY_ARMOR_CORE: 
                argument = "Any Armor Core";
                    break; 
            case ANY_ACCESSORY_CORE: 
                argument = "Any Accessory Core";
                    break;
            case ANY_CORE: 
                argument = "Any Core";
                    break;
        }
        
        return argument;
    }
    
    // return ValidAnyCoreSlotTypes enum of "Any _ Core" based on String passed 
    public ValidAnyCoreTypes getAnyCoreTypeEnumUsingString(String argument)
    {
        ValidAnyCoreTypes type = ValidAnyCoreTypes.valueOf(StaticMethods.stringToEnum(argument));
                return type;
    }
    
    // setting "Any _ Core" slot type means slot can store any core the subclass 
    // (denoted by subclassName) considers valid (regular slots have types which
    // can ONLY equip a core that has the exact same type as the slot) 
    public void setAnyCoreSlotType()
    {
        anyCoreType = getAnyCoreTypeString(getAnyCoreTypeAsStringBasedOnSubclassName(
            subclassName));  
    }

    public String getAnyCoreSlotType()
    {
        return anyCoreType;
    }
    
    // get "Any _ Core" slot type as String based on subclass name passed 
    public String getAnyCoreTypeAsStringBasedOnSubclassName(String argument)
    {
        switch(ValidSubclassNames.valueOf(StaticMethods.stringToEnum(argument)))
        {
            case WEAPONS: 
                argument = "Any Weapon Core";
                    break; 
            case ARMORS: 
                argument = "Any Armor Core";
                    break; 
            case ACCESSORIES: 
                argument = "Any Accessory Core";
                    break;
        }
        
        return argument;
    }
    
    // get "Any _ Core" slot type as enum of ValidAnyCoreSlotTypes based on subclass name passed 
    public ValidAnyCoreTypes getAnyCoreTypeAsEnumBasedOnSubclassName(String argument)
    {
        ValidAnyCoreTypes result = null;
        
        switch(ValidSubclassNames.valueOf(StaticMethods.stringToEnum((argument))))
        {
            case WEAPONS: 
                result = ValidAnyCoreTypes.ANY_WEAPON_CORE;
                    break; 
            case ARMORS: 
                result = ValidAnyCoreTypes.ANY_ARMOR_CORE;
                    break; 
            case ACCESSORIES: 
                result = ValidAnyCoreTypes.ANY_ACCESSORY_CORE;
                    break;
        }
        
        return result;
    }
    
    // END: ANY CORE TYPE FOR SLOTS OF OUTFIT
    /*******************************************************************************/
    
    
    
    // START: GENERICOBJECT SUBCLASSES STRINGAND VALIDATION AND ENUM RETRIEVAL 
    /*******************************************************************************/
    
    // START: WEAPONS SUBCLASS
    
    // enum class denoting valid slot types and core types for Weapons objects 
    public enum ValidWeaponSlotCoreTypes
    {
        MAX_STAMINA, MAX_NANO, ATTACK, DEXTERITY, CRITICAL, ACCURACY, NANO_ATTACK, 
            ANY_WEAPON_CORE;
    }
    
    // returns String form of ValidWeaponSlotCoreTypes enum passed (if MAX_STAMINA 
    // is passed as argument for parameter ValidWeaponSlotCoreTypes then result is 
    // the String "Max Stamina") 
    public static String getWeaponSlotCoreTypeStringUsingEnum(ValidWeaponSlotCoreTypes argument)
    {
        String result = null; 
        
        switch(argument)
        {
            case MAX_STAMINA:
                result = "Max Stamina";
                    break;
            case MAX_NANO: 
                result = "Max Nano";
                    break;
            case ATTACK:
                result = "Attack";
                    break;
            case DEXTERITY:
                result = "Dexterity";
                    break;
            case CRITICAL:
                result = "Critical";
                    break;
            case ACCURACY:
                result = "Accuracy";
                    break;
            case ANY_WEAPON_CORE:
                result = "Any Weapon Core";
                    break;
        }
        
        return result;
    }
    
    // returns array of enum values for ValidWeaponSlotCoreTypes as array of Strings 
    public static String[] validWeaponSlotCoreTypesAsStrings()
    {
        String[] array = new String[StaticMethods.getNumberOfEnumElements(
            ValidWeaponSlotCoreTypes.values())];
        
        for(int i = 0; i < ValidWeaponSlotCoreTypes.values().length; i++)
        {
            array[i] = getWeaponSlotCoreTypeStringUsingEnum(
                ValidWeaponSlotCoreTypes.values()[i]);
        }

        return array;
    }
    
    // returns ValidWeaponSlotCoreTypes enum form of String passed so long as String is valid 
    public static ValidWeaponSlotCoreTypes getWeaponSlotCoreTypesEnumUsingString(String argument)
    {
        ValidWeaponSlotCoreTypes result = null;
        
        if(StaticMethods.isStringValid(validWeaponSlotCoreTypesAsStrings(), argument))
        {   
            result = ValidWeaponSlotCoreTypes.valueOf(StaticMethods.stringToEnum(argument));
        }
        
        return result;
    }
    
    // HashMap creation and population through static means 
    private static final HashMap<ValidWeaponSlotCoreTypes, String> weaponSlotCoreTypesHashMap 
        = new HashMap<ValidWeaponSlotCoreTypes, String>();
        static 
        {
            for (ValidWeaponSlotCoreTypes validWeaponType : ValidWeaponSlotCoreTypes.values()) 
            {
                weaponSlotCoreTypesHashMap.put(validWeaponType, 
                    getWeaponSlotCoreTypeStringUsingEnum(validWeaponType));
            }
        }
    
    // return valid weapon slot/core type as String based on String passed 
    public static String getWeaponSlotCoreTypeAsString(String argument) 
    {
        return weaponSlotCoreTypesHashMap.get(getWeaponSlotCoreTypesEnumUsingString(argument));
    }
    
    // return valid weapon slot/core type as Enum based on String passed 
    public static ValidWeaponSlotCoreTypes getWeaponSlotCoreTypeAsEnum(String argument) 
    {
        ValidWeaponSlotCoreTypes result = null;
        
        for(ValidWeaponSlotCoreTypes key : weaponSlotCoreTypesHashMap.keySet())
        {
            if(key == getWeaponSlotCoreTypesEnumUsingString(argument))
            {
                result = key;
                    break;
            }
        }
        
        return result;
    } 
        
    // END: WEAPONS SUBCLASS
    
    
    // START: ARMORS SUBCLASS
    
    // enum class denoting valid slot/core types for Armors objects 
    // Note: aside from attribute core/slot types, resistances also have slot/core types 
    public enum ValidArmorSlotCoreTypes
    {
        MAX_HEALTH, MAX_STAMINA, MAX_NANO, DEFENSE, DEXTERITY, NANO_DEFENSE,
            ANY_ARMOR_CORE;
    }
    
    // returns String form of ValidArmorSlotCoreTypes enum passed (if MAX_STAMINA 
    // is passed as argument for parameter ValidArmorSlotCoreTypes then result is 
    // the String "Max Stamina") 
    public static String getArmorSlotCoreTypeStringUsingEnum(ValidArmorSlotCoreTypes argument)
    {
        String result = null;
        
        switch(argument)
        {
            case MAX_HEALTH:
                result = "Max Health";
                    break;
            case MAX_STAMINA: 
                result = "Max Stamina";
                    break;
            case MAX_NANO:
                result = "Max Nano";
                    break;
            case DEFENSE:
                result = "Defense";
                    break;
            case DEXTERITY:
                result = "Dexterity";
                    break;
            case NANO_DEFENSE:
                result = "Nano Defense";
                    break;
            case ANY_ARMOR_CORE:
                result = "Any Armor Core";
                    break;
        }
        
        return result;
    }
    
    // returns array of enum values for ValidArmorSlotCoreTypes as array of Strings 
    public static String[] validArmorSlotCoreTypesValuesAsStrings()
    {
        String[] array = new String[StaticMethods.getNumberOfEnumElements(ValidArmorSlotCoreTypes.values())];
        
        for(int i = 0; i < ValidArmorSlotCoreTypes.values().length; i++)
        {
            array[i] =  getArmorSlotCoreTypeStringUsingEnum(ValidArmorSlotCoreTypes.values()[i]);
        }

        return array;
    }
    
    // returns ValidArmorSlotCoreTypes enum form of String passed so long as String is valid 
    public static ValidArmorSlotCoreTypes getArmorSlotCoreTypeEnumUsingString(String argument)
    {
        ValidArmorSlotCoreTypes result = null;
        
        if(StaticMethods.isStringValid(validArmorSlotCoreTypesValuesAsStrings(), argument))
        {
            result = ValidArmorSlotCoreTypes.valueOf(StaticMethods.stringToEnum(argument));
        }
        
        return result;
    }
    
    // HashMap creation and population through static means 
    private static final HashMap<ValidArmorSlotCoreTypes, String> armorSlotCoreTypeHashMap =
        new HashMap<ValidArmorSlotCoreTypes, String>();
        static 
        {
            for (ValidArmorSlotCoreTypes validArmorSlotCoreType : ValidArmorSlotCoreTypes.values()) 
            {
                armorSlotCoreTypeHashMap.put(validArmorSlotCoreType, 
                    getArmorSlotCoreTypeStringUsingEnum(validArmorSlotCoreType));
            }
        }
    
    // return valid weapon slot/core type as String based on String passed 
    public static String getArmorSlotCoreTypeAsString(String argument) 
    {
        return armorSlotCoreTypeHashMap.get(getArmorSlotCoreTypeEnumUsingString(argument));
    }

    // return valid weapon slot/core type as Enum based on String passed 
    public static ValidArmorSlotCoreTypes getArmorSlotCoreTypeAsEnum(String argument) 
    {
        ValidArmorSlotCoreTypes result = null;
        
        for(ValidArmorSlotCoreTypes key : armorSlotCoreTypeHashMap.keySet())
        {
            if(key == getArmorSlotCoreTypeEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 
    
    // START: ARMORS SUBCLASS
    
    
    // START: ACCESSORIES SUBCLASS
    
    // enum class denoting valid slot/core types for Accessories objects 
    public enum ValidAccessorySlotCoreTypes
    {
        MAX_HEALTH, MAX_STAMINA, MAX_NANO, ATTACK, DEFENSE, DEXTERITY, 
            CRITICAL, ACCURACY, NANO_ATTACK, NANO_DEFENSE, LUCK, 
            ANY_ACCESSORY_CORE; 
    }

    // returns String form of ValidAccessorySlotCoreTypes enum passed (if MAX_STAMINA 
    // is passed as argument for parameter ValidAccessorySlotCoreTypes then result is 
    // the String "Max Stamina") 
    public static String getAccessorySlotCoreTypeStringUsingEnum(
        ValidAccessorySlotCoreTypes argument)
    {
        String result = null;
        
        switch(argument)
        {
            case MAX_HEALTH:
                result = "Max Health";
                    break;
            case MAX_STAMINA: 
                result = "Max Stamina";
                    break;
            case MAX_NANO:
                result = "Max Nano";
                    break;
            case ATTACK:
                result = "Attack";
                    break;
            case DEFENSE:
                result = "Defense";
                    break;
            case DEXTERITY:
                result = "Dexterity";
                    break;
            case CRITICAL:
                result = "Critical";
                    break;
            case ACCURACY:
                result = "Accuracy";
                    break;
            case NANO_ATTACK:
                result = "Nano Attack";
                    break;
            case NANO_DEFENSE:
                result = "Nano Defense";
                    break;
            case ANY_ACCESSORY_CORE:
                result = "Any Accessory Core";
                    break;
        }
        
        return result;
    }
    
    // returns array of enum values for ValidAccessorySlotCoreTypes as array of Strings 
    public static String[] validAccessorySlotCoreTypesValuesAsStrings()
    {
        String[] array = new String[StaticMethods.getNumberOfEnumElements(ValidAccessorySlotCoreTypes.values())];
        
        for(int i = 0; i < ValidAccessorySlotCoreTypes.values().length; i++)
        {
            array[i] = getAccessorySlotCoreTypeStringUsingEnum(ValidAccessorySlotCoreTypes.values()[i]);
        }

        return array;
    }

    // returns ValidAccessorySlotCoreTypes enum form of String passed so long as String is valid 
    public static ValidAccessorySlotCoreTypes getAccessorySlotCoreTypesEnumUsingString(String argument)
    {
        ValidAccessorySlotCoreTypes result = null;
        
        if(StaticMethods.isStringValid(validAccessorySlotCoreTypesValuesAsStrings(), argument))
        {
            result = ValidAccessorySlotCoreTypes.valueOf(StaticMethods.stringToEnum(argument));
        }
        
        return result;
    }
    
    // HashMap creation and population through static means 
    private static final HashMap<ValidAccessorySlotCoreTypes, String> accessorySlotCoreTypesHashMap =
        new HashMap<ValidAccessorySlotCoreTypes, String>();
        static 
        {
            for (ValidAccessorySlotCoreTypes enchantment : ValidAccessorySlotCoreTypes.values()) 
            {
                accessorySlotCoreTypesHashMap.put(enchantment, getAccessorySlotCoreTypeStringUsingEnum(enchantment));
            }
        }
    
    // return valid weapon slot/core type as String based on String passed 
    public static String getAccessorySlotCoreTypeAsString(String argument) 
    {
        return accessorySlotCoreTypesHashMap.get(getAccessorySlotCoreTypesEnumUsingString(argument));
    }
    
    // return valid weapon slot/core type as Enum based on String passed 
    public static ValidAccessorySlotCoreTypes getAccessorySlotCoreTypeAsEnum(String argument) 
    {
        ValidAccessorySlotCoreTypes result = null;
        
        for(ValidAccessorySlotCoreTypes key : accessorySlotCoreTypesHashMap.keySet())
        {
            if(key == getAccessorySlotCoreTypesEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 
    
    // EMD: ACCESSORIES SUBCLASS
    
    // END: GENERICOBJECT SUBCLASSES STRINGAND VALIDATION AND ENUM RETRIEVAL 
    /*******************************************************************************/

    
    // START: VALIDATING SUPPLIED SLOT TYPE AGAINST ACCEPTED SLOT TYPES 
    /*******************************************************************************/
    
    // validates argument representing slot/core type and returns the appropriate result 
    public String validateSlotCoreType(String slotCoreType)
    {
        if(slotCoreType != null)
        {
            switch(ValidSubclassNames.valueOf(StaticMethods.stringToEnum(subclassName)))
            {
                case WEAPONS:
                    slotCoreType = getWeaponSlotCoreTypeAsString(slotCoreType);
                        break;
                case ARMORS: 
                    if(StaticMethods.getResistancesForArmorsClassAsValidString(slotCoreType) == null){
                        slotCoreType = getArmorSlotCoreTypeAsString(slotCoreType);}
                            else{slotCoreType = StaticMethods.getResistancesForArmorsClassAsValidString(slotCoreType);}
                                break;
                case ACCESSORIES: 
                    slotCoreType = getAccessorySlotCoreTypeAsString(slotCoreType);
                        break;
            }
        }

        return slotCoreType;
    }
    
    // return Object containing enum form of ANY enum class value based off String
    public Object getValidSubclassEnum(String argument)
    {
        Object validType = null;
        
        if(argument != null)
        {
            argument = StaticMethods.stringToEnum(argument);
            boolean isNotNull = false;

            for(ValidSubclassNames element: ValidSubclassNames.values())
            {
                if(isNotNull != true)
                {
                    switch(element)
                    {
                        case WEAPONS: 
                            validType = getWeaponSlotCoreTypeAsEnum(argument);
                                break;
                        case ARMORS: 
                            if(StaticMethods.getResistancesForArmorsClassAsValidEnum(argument) == null){
                                validType = getArmorSlotCoreTypeAsEnum(argument);}
                                    else{validType = StaticMethods.getResistancesForArmorsClassAsValidEnum(argument);}
                                        break;
                        case ACCESSORIES: 
                            validType = getAccessorySlotCoreTypeAsEnum(argument);
                                break;
                    }
                    if(validType != null){isNotNull = true;}
                } else
                {
                    break;
                }
            }
        }
        
        return validType;
    }
    
    // if core type matches a type considered valid for subclass (based on subclass
    // name) then return the core type 
    public String getSubclassIfCoreTypeIsValid(String coreType)
    { 
        String resultingSubclass = null;
    
        if(coreType != null)
        {
            switch(ValidSubclassNames.valueOf(StaticMethods.stringToEnum(subclassName)))
            {
                case WEAPONS:
                    if(getWeaponSlotCoreTypeAsString(coreType) != null)
                        {resultingSubclass = "weapons";}
                            break;
                case ARMORS: 
                    if(StaticMethods.getResistancesForArmorsClassAsValidEnum(coreType) == null){
                        if(getArmorSlotCoreTypeAsString(coreType) != null)
                            {resultingSubclass = "armors";}}
                    else{resultingSubclass = "armors";}
                                break;
                case ACCESSORIES: 
                    if(getAccessorySlotCoreTypeAsString(coreType) != null)
                        {resultingSubclass = "accessories";}
                            break;
            }
        }
        
        return resultingSubclass;
    }
    
    // if slot for object accepts "Any _ Core" for subclass outfit (based on the
    // subclass name) then compare it against "Any _ Core" type for core type 
    public boolean isCoreTypeValidForAnyCoreSlotTypeOfObject(Object object, String coreType)
    {
        boolean result = false;
        
        // Example: if slot type is "Any Weapon Core" then accept any valid weapon core 
        // if subclassName is "Weapons" and core type is Attack, determine if the 
            // core type is a valid type for weapons and if so then store core in slot 
        if(object == getAnyCoreTypeAsEnumBasedOnSubclassName(getSubclassIfCoreTypeIsValid((coreType))))
        {
            result = true;
        }
        
        return result;
    }
    
    /* core validation requirements 
        -if core has core type "Any Core" then store core in slot
        -compare core type against slot type and if there is a 
         match then equip core else reject core 
        -if slot type is "Any _ Core" then accept any core
         that object CAN have if core is valid (see subclassName) */
    
    public Cores validateCoreUsingSlotType(Cores core, String slotType)
    {
        Cores holdCore = null;
        
        if(core != null && slotType != null)
        {
            if(getAnyCoreTypeEnumUsingString(core.getCoreType()) == ValidAnyCoreTypes.ANY_CORE)
            {
                holdCore = core;
            }
            else if(getValidSubclassEnum(core.getCoreType()) == getValidSubclassEnum(slotType))
            {
                holdCore = core;
            }
            else if(isCoreTypeValidForAnyCoreSlotTypeOfObject(getAnyCoreTypeEnumUsingString(
                anyCoreType), core.getCoreType()))
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

    public void setSlotOneCore(Cores slotOneCore)
    {
        this.slotOneCore = validateCoreUsingSlotType(slotOneCore, slotOneType);		
    }

    public Cores getSlotOneCore()
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

    public void setSlotTwoCore(Cores slotTwoCore)
    {
        this.slotTwoCore = validateCoreUsingSlotType(slotTwoCore, slotTwoType);
    }

    public Cores getSlotTwoCore()
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

    public void setSlotThreeCore(Cores slotThreeCore)
    {
        this.slotThreeCore = validateCoreUsingSlotType(slotThreeCore, slotThreeType);
    }

    public Cores getSlotThreeCore()
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

    public void setSlotFourCore(Cores slotFourCore)
    {
        this.slotFourCore = validateCoreUsingSlotType(slotFourCore, slotFourType);
    }

    public Cores getSlotFourCore()
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

    public void setSlotFiveCore(Cores slotFiveCore)
    {
        this.slotFiveCore = validateCoreUsingSlotType(slotFiveCore, slotFiveType);
    }

    public Cores getSlotFiveCore()
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

    public void setSlotSixCore(Cores slotSixCore)
    {
        this.slotFiveCore = validateCoreUsingSlotType(slotSixCore, slotSixType);
    }

    public Cores getSlotSixCore()
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

    public void setSlotSevenCore(Cores slotFiveCore)
    {
        this.slotFiveCore = validateCoreUsingSlotType(slotSevenCore, slotSevenType);
    }

    public Cores getSlotSevenCore()
    {
        return slotSevenCore;
    }
    
    // END: SLOT TYPES AND SLOT CORES WITH VALIDATION
    /*******************************************************************************/
    
    
    
    // START: SETTING AND GETTING SLOTS AND CORES INFORMATION
    /*******************************************************************************/

    // set max number of slots outfit can have 
    public void setMaxNumberOfSlotTypes(int maxNumberOfSlots)
    {
        this.maxNumberOfSlots = maxNumberOfSlots;
    }

    // get max number of slots outfit can have 
    public int getMaxNumberOfSlotTypes()
    {
        return maxNumberOfSlots;
    }
    
    // get all slots that outfit can possibly have
    public String[] getAllSlots()
    {
        String[] allSlots = {getSlotOneType(), getSlotTwoType(), getSlotThreeType(),
            getSlotFourType(), getSlotFiveType(), getSlotSixType(), getSlotSevenType()};
                return allSlots;
    }
    
    // get number of slots that exist (slots that are not null)
    public int getNumberOfExistingSlots()
    {
        int numberOfExistingSlots = 0;
        
        for(String element : getAllSlots())
        {
            if(element != null)
            {
                numberOfExistingSlots++;
            }
        }
        
        return numberOfExistingSlots;
    }
    
    // get all slot types that exist from exisitng cores 
    public String[] getExistingSlots()
    {
        String[] existingSlots = new String[maxNumberOfSlots];
        
        int counter = 0;
        
        for(String element : getAllSlots())
        {
            if(element != null)
            {
                existingSlots[counter] = element;
                    counter++;
            }
        }
        
        return existingSlots;
    }
    
    // get all cores that outfit can possible have 
    public Cores[] getAllSlotCores()
    {
        Cores[] allSlotCores = {getSlotOneCore(), getSlotTwoCore(), getSlotThreeCore(), 
            getSlotFourCore(), getSlotFiveCore(), getSlotSixCore(), getSlotSevenCore()};
                return allSlotCores;
    }
     
    // get number of cores that exist (cores that are not null)
    public int getNumberOfExistingCores()
    {
        int numberOfExistingCores = 0;
        
        for(Cores element : getAllSlotCores())
        {
            if(element != null)
            {
                numberOfExistingCores++;
            }
        }
        
        return numberOfExistingCores;
    } 
    
    // get all slot cores that exist from existing slots 
    public Cores[] getExistingCores()
    {
        Cores[] existingCores = new Cores[maxNumberOfSlots];
        
        int counter = 0;
        
        for(Cores element : getAllSlotCores())
        {
            if(element != null && element.getCoreType() != null)
            {
                existingCores[counter] = element;
                    counter++;
            }
        }
        
        return existingCores;
    }
    
    // END: SETTING MAX NUMBER OF SLOT TYPES ALLOWED AND RETURNING CORES 
    /*******************************************************************************/

 
    
    // START: CORE PENALTY CALCULATION
    /*******************************************************************************/
    
    // gets core size enum from enum class CoreSizes in public class Cores
    public Cores.ValidCoreSizes getCoreSizeEnumUsingString(String size)
    {
        Cores.ValidCoreSizes sizeEnum = null;
        
        if(size != null)
        {
            sizeEnum = Cores.ValidCoreSizes.valueOf(StaticMethods.stringToEnum(size));
        }
        
        return sizeEnum;
    }
    
    // gets core tier enum from enum class CoreTiers in public class Cores
    public Cores.ValidCoreTiers getCoreTierEnumUsingString(String tier)
    {
        Cores.ValidCoreTiers result = null;
        
        if(tier != null)
        {
            result = Cores.ValidCoreTiers.valueOf(StaticMethods.stringToEnum(tier));
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
        HashSet<String> typesOfEquippedCores = new HashSet<String>();

        for(Cores element : getExistingCores())
        {
            if(element != null && element.getCoreType() != null)
            {
                typesOfEquippedCores.add(element.getCoreType());
            }
        }
        
        return typesOfEquippedCores;
    }
    
    // count and return the number of cores that have the same type as type supplied 
    public double countNumberOfSameCoreTypeCores(String coreType)
    {
        double counter = 0;

        for(Cores element : getExistingCores())
        {
            if(element != null)
            {
                if(StaticMethods.getStatAsValidEnum(coreType) == StaticMethods.getStatAsValidEnum(
                    element.getCoreType()))
                {
                    counter++;
                }
            }
        }

        return counter;
    }
    
    // count and return number of cores belonging to core type for specified size 
    public double countDesiredCoresBySize(String coreType, String size)
    {
        double counter = 0;

        for(Cores element : getExistingCores())
        {
            if(element != null)
            {
                if(StaticMethods.getStatAsValidEnum(element.getCoreType()) == StaticMethods.
                    getStatAsValidEnum(coreType))
                {
                    if(getCoreTierEnumUsingString(size) == getCoreTierEnumUsingString(element.
                        getCoreType()))
                    {
                        counter++;
                    }
                }
            }
        }
        
        return counter;
    }

    // count and return number of cores belonging to core type for specified tier
    public double countDesiredCoresByTier(String typeOfCore, String tier)
    {
        double counter = 0;

        for(Cores element : getExistingCores())
        {
            if(element != null) 
            {
                if(StaticMethods.getStatAsValidEnum(element.getCoreType()) == StaticMethods.
                    getStatAsValidEnum(typeOfCore))
                {
                    if(getCoreTierEnumUsingString(tier) == getCoreTierEnumUsingString(element.
                        getCoreTier()))
                    {
                        counter++;
                    }
                }
            }
        }
        
        return counter;
    }
    
    // calculate penalty incurred for outfit that has cores equipped 
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
            for(Cores core : getExistingCores())
            {
                if(core != null)
                {
                    if(!core.getSpecialCoreState())
                    {
                        if(StaticMethods.getStatAsValidEnum(core.getCoreType()) 
                            == StaticMethods.getStatAsValidEnum(element))
                        {
                            core.setCurrentCorePoints(core.getCurrentCorePoints() - 
                                (core.getMaxCorePoints() * corePenaltyCalculation(element)));
                        }
                    }
                    else
                    {
                        core.setCurrentCorePoints(core.getCurrentCorePoints() - 
                            ((core.getMaxCorePoints() * corePenaltyCalculation(element)) / 2.25));
                    }
                }                
            }
        }
    }

    // END: CORE PENALTY CALCULATION
    /*******************************************************************************/
    
    
    
    // START: TOTAL FOR ATTRIBUTES WITH CORES SUPPLIED
    /*******************************************************************************/
    
    // add values of all cores that have same type as argument using for loop 
    public double addSumOfCoresForType(String type)
    {
        double coreSum = 0.0;
        
        if(StaticMethods.getStatAsValidEnum(type) != null)
        {
            for(Cores element : getExistingCores())
            {
                if(element != null)
                {
                    if(getValidSubclassEnum(type) == getValidSubclassEnum(element.getCoreType()))
                    {
                        coreSum +=  element.getCurrentCorePoints();
                    }
                }
            }
        }
        
        return coreSum;
    }

    // factor in durability effect of outfit on value supplied before rtuning it 
    public double outfitDurabilityEffect(double value, double durability)
    {
        // Note: if accounts for resistances, if-else for resistances and attributes 
        if(value < 0)
        {
            value = (-1 * value) - ((1.0 - durability) * value);
        }
        else
        {
            value = value - ((1.0 - durability) * value);
        }

        return value;
    }
    
    // get total value provided by oufit for specified statName 
    public double getTotalOutfitValue(double stat, String statName)
    {
        return outfitDurabilityEffect((stat + addSumOfCoresForType(statName)), 
            getDurabilityValue());
    }
    
    // END: TOTAL FOR ATTRIBUTES WITH CORES SUPPLIED
    /*******************************************************************************/
}