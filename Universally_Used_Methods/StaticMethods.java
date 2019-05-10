package Universally_Used_Methods;

import java.util.HashMap;




public class StaticMethods 
{
    // START: ENUM CLASSES AND HASHMAPS FOR ATTRIBUTES, ENCHANTMENTS AND RESISTANCES
    /*******************************************************************************/	
    
    // START: METHOD USED THROUGHOUT THIS SECTION
    
    public static int getNumberOfEnumElements(Object[] array)
    {
        int counter = 0;
        
        for(Object element : array)
        {
            if(element != null)
            {
                counter++;
            }
        }
        
        return counter;
    }
    
    public static boolean isStringValid(String[] enumClassValuesAsStrings, String argument)
    {   
        boolean argumentExists = false;
        
        for(String element : enumClassValuesAsStrings)
        {  
            if(element.equals(argument))
            {
                argumentExists = true;
            }
        }
        
        return argumentExists;
    }
    
    // prepares a String for usage in Enum related methods (see valueOf())
    public static String stringToEnum(String argument)
    {
        // make String uppercase and replace all whitespaces and non-visible 
        // characters with underscores ("A dog" -> "A_DOG")
        return argument = argument.replaceAll("\\s","_").toUpperCase();
    } 
 
    // END: METHOD USED THROUGHOUT THIS SECTION
 
    
    // START: VALID ATTRIBUTES
    
    public static enum ValidAttributes
    {
        MAX_HEALTH, MAX_STAMINA, MAX_NANO, ATTACK, DEFENSE, DEXTERITY, 
        CRITICAL, ACCURACY, NANO_ATTACK, NANO_DEFENSE, LUCK;
    }
    
    public static String getAttributeStringUsingEnum(ValidAttributes argument)
    {
        String result = null;
        
        switch(argument)
        {
            case MAX_HEALTH: 
                result = "Current Health";
                    break; 
            case MAX_STAMINA: 
                result = "Current Stealth";
                    break; 
            case MAX_NANO: 
                result = "Current Nano";
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
            case LUCK:
                result = "Luck";
                    break; 
        }
        
        return result;
    }
    
    public static String[] validAttributesValuesAsStrings()
    {
        String[] array = new String[getNumberOfEnumElements(ValidAttributes.values())];
        
        for(int i = 0; i < ValidAttributes.values().length; i++)
        {
            array[i] = getAttributeStringUsingEnum(ValidAttributes.values()[i]);
        }

        return array;
    }
    
    public static ValidAttributes getAttributeEnumUsingString(String argument)
    {
        ValidAttributes result = null;

        if(isStringValid(validAttributesValuesAsStrings(), argument))
        {
            result = ValidAttributes.valueOf(stringToEnum(argument));
        }
        
        return result;
    }
         
    private static final HashMap<ValidAttributes, String> attributesHashMap =
        new HashMap<ValidAttributes, String>();
        static 
        {
            for (ValidAttributes attribute : ValidAttributes.values()) 
            {
                attributesHashMap.put(attribute, getAttributeStringUsingEnum(attribute));
            }
        }
        
    public static String getAttributeAsString(String argument) 
    {
        return attributesHashMap.get(getAttributeEnumUsingString(argument));
    }
    
    public static ValidAttributes getAttributeAsEnum(String argument) 
    {
        ValidAttributes result = null;
        
        for(ValidAttributes key : attributesHashMap.keySet())
        {
            if(key == getAttributeEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 
    
    // END: VALID ATTRIBUTES 
    
    
    // START: VALID ENCHANTMENTS 
    
    public static enum ValidEnchantments
    {
        FIRE, WATER, ICE, ELECTRICITY, POISON, SONIC, PLASMA, WIND;
    }
    
    public static String getEnchantmentStringUsingEnum(ValidEnchantments argument)
    {
        String result = null;
        
        switch(argument)
        {
            case FIRE: 
                result = "Fire";
                    break; 
            case WATER: 
                result = "Water";
                    break; 
            case ICE: 
                result = "Ice";
                    break; 
            case ELECTRICITY:
                result = "Electricity";
                    break; 
            case POISON: 
                result = "Poison";
                    break; 
            case SONIC: 
                result = "Sonic";
                    break; 
            case PLASMA: 
                result = "Plasma";
                    break; 
            case WIND: 
                result = "Wind";
                    break; 
        }
        
        return result;
    }
    
    public static String[] validEnchantmentsValuesAsStrings()
    {
        String[] array = new String[getNumberOfEnumElements(ValidEnchantments.values())];
        
        for(int i = 0; i < ValidEnchantments.values().length; i++)
        {
            array[i] =  getEnchantmentStringUsingEnum(ValidEnchantments.values()[i]);
        }

        return array;
    }
    
    public static ValidEnchantments getEnchantmentEnumUsingString(String argument)
    {
        ValidEnchantments result = null;
        
        if(isStringValid(validEnchantmentsValuesAsStrings(), argument))
        {
            result = ValidEnchantments.valueOf(stringToEnum(argument));
        }
        
        return result;
    }
    
    private static final HashMap<ValidEnchantments, String> enchantmentsHashMap =
        new HashMap<ValidEnchantments, String>();
        static 
        {
            for (ValidEnchantments enchantment : ValidEnchantments.values()) 
            {
                enchantmentsHashMap.put(enchantment, getEnchantmentStringUsingEnum(enchantment));
            }
        }
        
    public static String getEnchantmentAsString(String argument) 
    {
        return enchantmentsHashMap.get(getEnchantmentEnumUsingString(argument));
    }
    
    public static ValidEnchantments getEnchantmentAsEnum(String argument) 
    {
        ValidEnchantments result = null;
        
        for(ValidEnchantments key : enchantmentsHashMap.keySet())
        {
            if(key == getEnchantmentEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 
    
    // END: VALID ENCHANTMENTS 

    
    // START: VALID UNIQUE STATUS EFFECTS 
    
    public static enum ValidUniqueStatusEffects
    {
        DRY, WET, COLD, CONDUCTIVE, SICKNESS, HYPERSENSITIVE, COATED, 
        LIGHTWEIGHT, IRRADIATED;
    }

    public static String getUniqueStatusEffectStringUsingEnum(ValidUniqueStatusEffects argument)
    {
        String result = null;
        
        switch(argument)
        {
            case DRY: 
                result = "Dry";
                    break; 
            case WET: 
                result = "Wet";
                    break; 
            case COLD: 
                result = "Cold";
                    break; 
            case CONDUCTIVE:
                result = "Conductive";
                    break; 
            case SICKNESS: 
                result = "Sickness";
                    break; 
            case HYPERSENSITIVE: 
                result = "Hypersensitive";
                    break; 
            case COATED: 
                result = "Coated";
                    break; 
            case LIGHTWEIGHT: 
                result = "Lightweight";
                    break; 
            case IRRADIATED:
                result = "Irradiated";
                    break; 
        }
        
        return result;
    }
    
    public static String[] validUniqueStatusEffectsValuesAsStrings()
    {
        String[] array = new String[getNumberOfEnumElements(ValidUniqueStatusEffects.values())];
        
        for(int i = 0; i < ValidUniqueStatusEffects.values().length; i++)
        {
            array[i] =  getUniqueStatusEffectStringUsingEnum(ValidUniqueStatusEffects.values()[i]);
        }

        return array;
    }

    public static ValidUniqueStatusEffects getUniqueStatusEffectEnumUsingString(String argument)
    {
        ValidUniqueStatusEffects result = null;
        
        if(isStringValid(validUniqueStatusEffectsValuesAsStrings(), argument))
        {
            result = ValidUniqueStatusEffects.valueOf(stringToEnum(argument));
        }
        
        return result;
    }
    
    private static final HashMap<ValidUniqueStatusEffects, String> uniqueStatusEffectsHashMap =
        new HashMap<ValidUniqueStatusEffects, String>();
        static 
        {
            for (ValidUniqueStatusEffects uniqueStatusEffect : ValidUniqueStatusEffects.values()) 
            {
                uniqueStatusEffectsHashMap.put(uniqueStatusEffect, 
                    getUniqueStatusEffectStringUsingEnum(uniqueStatusEffect));
            }
        }
        
    public static String getUniqueStatusEffectAsString(String argument) 
    {
        return uniqueStatusEffectsHashMap.get(getUniqueStatusEffectEnumUsingString(argument));
    }
    
    public static ValidUniqueStatusEffects getUniqueStatusEffectAsEnum(String argument) 
    {
        ValidUniqueStatusEffects result = null;
        
        for(ValidUniqueStatusEffects key : uniqueStatusEffectsHashMap.keySet())
        {
            if(key == getUniqueStatusEffectEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 
    
    // END: VALID UNIQUE STATUS EFFECTS
    
    
    // START: VALID CURRENT HEALTH STATUS EFFECTS
    
    public static enum ValidCurrentHealthStatusEffects
    {
        ABLAZE, BLEED, TOXIC;
    }
    
    public static String getCurrentHealthStatusEffectStringUsingEnum(
        ValidCurrentHealthStatusEffects argument)
    {
        String result = null; 
        
        switch(argument)
        {
            case ABLAZE: 
                result = "Ablaze";
                    break; 
            case BLEED: 
                result = "Bleed";
                    break; 
            case TOXIC: 
                result = "Toxic";
                    break; 
        }
        
        return result;
    }
    
    public static String[] validCurrentHealthStatusEffectsValuesAsStrings()
    {
        String[] array = new String[getNumberOfEnumElements(ValidCurrentHealthStatusEffects.values())];
        
        for(int i = 0; i < ValidCurrentHealthStatusEffects.values().length; i++)
        {
            array[i] =  getCurrentHealthStatusEffectStringUsingEnum(ValidCurrentHealthStatusEffects.values()[i]);
        }

        return array;
    }

    public static ValidCurrentHealthStatusEffects getCurrentHealthStatusEffectEnumUsingString(
        String argument)
    {
        ValidCurrentHealthStatusEffects result = null;
        
        if(isStringValid(validCurrentHealthStatusEffectsValuesAsStrings(), argument))
        {
            result = ValidCurrentHealthStatusEffects.valueOf(stringToEnum(argument));
        }
        
        return result;
    }
    
    private static final HashMap<ValidCurrentHealthStatusEffects, String> currentHealthStatusEffectsHashMap = 
        new HashMap<ValidCurrentHealthStatusEffects, String>();
        static 
        {
            for (ValidCurrentHealthStatusEffects currentHealthStatusEffect : ValidCurrentHealthStatusEffects.values()) 
            {
                currentHealthStatusEffectsHashMap.put(currentHealthStatusEffect, 
                    getCurrentHealthStatusEffectStringUsingEnum(currentHealthStatusEffect));
            }
        }
        
    public static String getCurrentHealthStatusEffectAsString(String argument) 
    {
        return currentHealthStatusEffectsHashMap.get(getCurrentHealthStatusEffectEnumUsingString(argument));
    }
    
    public static ValidCurrentHealthStatusEffects getCurrentHealthStatusEffectAsEnum(String argument) 
    {
        ValidCurrentHealthStatusEffects result = null;
        
        for(ValidCurrentHealthStatusEffects key : currentHealthStatusEffectsHashMap.keySet())
        {
            if(key == getCurrentHealthStatusEffectEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 

    // END: VALID CURRENT HEALTH STATUS EFFECTS


    // START: VALID ATTRIBUTE STATUS EFFECTS 
    
    public static enum ValidAttributeStatusEffects
    {
        ATTACK_DOWN, DEFENSE_DOWN, SHUTDOWN, DEXTERITY_DOWN, CRITICAL_DOWN,
        ACCURACY_DOWN, BLIND, NANO_ATTACK_DOWN, NANO_DEFENSE_DOWN;
    }

    public static String getAttributeStatusEffectStringUsingEnum(
        ValidAttributeStatusEffects argument)
    {
        String result = null;
        
        switch(argument)
        {
            case ATTACK_DOWN: 
                result = "Attack Down";
                    break; 
            case DEFENSE_DOWN: 
                result = "Defense Down";
                    break; 
            case SHUTDOWN: 
                result = "Shutdown";
                    break; 
            case DEXTERITY_DOWN:
                result = "Dxterity Down";
                    break; 
            case CRITICAL_DOWN: 
                result = "Critical Down";
                    break; 
            case ACCURACY_DOWN: 
                result = "Accuracy Down";
                    break; 
            case BLIND: 
                result = "Blind";
                    break; 
            case NANO_ATTACK_DOWN: 
                result = "Nano Attack Down";
                    break; 
            case NANO_DEFENSE_DOWN:
                result = "Nano Defense Down";
                    break; 
        }
        
        return result;
    }

    public static String[] validAttributeStatusEffectsValuesAsStrings()
    {
        String[] array = new String[getNumberOfEnumElements(ValidAttributeStatusEffects.values())];
        
        for(int i = 0; i < ValidAttributeStatusEffects.values().length; i++)
        {
            array[i] =  getAttributeStatusEffectStringUsingEnum(ValidAttributeStatusEffects.values()[i]);
        }

        return array;
    }

    public static ValidAttributeStatusEffects 
        getAttributeStatusEffectEnumUsingString(String argument)
    {
        ValidAttributeStatusEffects result = null;
        
        if(isStringValid(validAttributeStatusEffectsValuesAsStrings(), argument))
        {
            result = ValidAttributeStatusEffects.valueOf(stringToEnum(argument));
        }
        
        return result;
    }
    
    private static final HashMap<ValidAttributeStatusEffects, String> attributeStatusEffectsHashMap = 
        new HashMap<ValidAttributeStatusEffects, String>();
        static 
        {
            for (ValidAttributeStatusEffects attributeStatusEffect : ValidAttributeStatusEffects.values()) 
            {
                attributeStatusEffectsHashMap.put(attributeStatusEffect, 
                    getAttributeStatusEffectStringUsingEnum(attributeStatusEffect));
            }
        }
        
    public static String getAttributeStatusEffectAsString(String argument) 
    {
        return attributeStatusEffectsHashMap.get(getAttributeStatusEffectEnumUsingString(argument));
    }
    
    public static ValidAttributeStatusEffects getAttributeStatusEffectAsEnum(String argument) 
    {
        ValidAttributeStatusEffects result = null;
        
        for(ValidAttributeStatusEffects key : attributeStatusEffectsHashMap.keySet())
        {
            if(key == getAttributeStatusEffectEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 

    // END: VALID ATTRIBUTE STATUS EFFECTS 


    // START: VALID BEHAVIOR STATUS EFFECTS 
    
    public static enum ValidBehaviorStatusEffects
    {
        CONFUSED,  ENAMORED,  BERSERK;
    }
    
    public static String getBehaviorStatusEffectStringUsingEnum(
        ValidBehaviorStatusEffects argument)
    {
        String result = null;
                
        switch(argument)
        {
            case CONFUSED: 
                result = "Confused";
                    break; 
            case ENAMORED: 
                result = "Confused";
                    break; 
            case BERSERK: 
                result = "Berserk";
                    break; 
        }
        
        return result;
    }

    public static String[] validBehaviorStatusEffectsValuesAsStrings()
    {
        String[] array = new String[getNumberOfEnumElements(ValidBehaviorStatusEffects.values())];
        
        for(int i = 0; i < ValidBehaviorStatusEffects.values().length; i++)
        {
            array[i] =  getBehaviorStatusEffectStringUsingEnum(ValidBehaviorStatusEffects.values()[i]);
        }

        return array;
    }
    
     public static ValidBehaviorStatusEffects 
        getBehaviorStatusEffectEnumUsingString(String argument)
    {
        ValidBehaviorStatusEffects result = null;
        
        if(isStringValid(validBehaviorStatusEffectsValuesAsStrings(), argument))
        {
            result = ValidBehaviorStatusEffects.valueOf(stringToEnum(argument));
        }
        
        return result;
    }

    private static final HashMap<ValidBehaviorStatusEffects, String> behaviorStatusEffectsHashMap = 
        new HashMap<ValidBehaviorStatusEffects, String>();
        static 
        {
            for (ValidBehaviorStatusEffects behaviorStatusEffect : ValidBehaviorStatusEffects.values()) 
            {
                behaviorStatusEffectsHashMap.put(behaviorStatusEffect, 
                    getBehaviorStatusEffectStringUsingEnum(behaviorStatusEffect));
            }
        }
        
    public static String getBehaviorStatusEffectAsString(String argument) 
    {
        return behaviorStatusEffectsHashMap.get(getBehaviorStatusEffectEnumUsingString(argument));
    }
    
    public static ValidBehaviorStatusEffects getBehaviorStatusEffectAsEnum(String argument) 
    {
        ValidBehaviorStatusEffects result = null;
        
        for(ValidBehaviorStatusEffects key : behaviorStatusEffectsHashMap.keySet())
        {
            if(key == getBehaviorStatusEffectEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 

    // END: VALID BEHAVIOR STATUS EFFECTS 

    
    // START: VALID TURN BEHAVIOR STATUS EFFECTS 

    public static enum ValidTurnBehaviorStatusEffects
    {
        FLINCHED, STUNNED, SCARED, BOUND, SLEEP, TRANCED, SHOCKED, SLOWED, 
        STOPPED;
    }

    public static String getTurnBehaviorStatusEffectStringUsingEnum(
        ValidTurnBehaviorStatusEffects argument)
    {
        String result = null;
        
        switch(argument)
        {
            case FLINCHED: 
                result = "Flinched";
                    break; 
            case STUNNED: 
                result = "Stunned";
                    break; 
            case SCARED: 
                result = "Scared";
                    break; 
            case BOUND:
                result = "Bound";
                    break; 
            case SLEEP: 
                result = "Sleep";
                    break; 
            case TRANCED: 
                result = "Tranced";
                    break; 
            case SHOCKED: 
                result = "Shocked";
                    break; 
            case SLOWED: 
                result = "Slowed";
                    break; 
            case STOPPED:
                result = "Stopped";
                    break; 
            default:
                argument = null;
                    break; 
        }
        
        return result;
    }
    
    public static String[] validTurnBehaviorStatusEffectsValuesAsStrings()
    {
        String[] array = new String[getNumberOfEnumElements(ValidTurnBehaviorStatusEffects.values())];
        
        for(int i = 0; i < ValidTurnBehaviorStatusEffects.values().length; i++)
        {
            array[i] =  getTurnBehaviorStatusEffectStringUsingEnum(ValidTurnBehaviorStatusEffects.values()[i]);
        }

        return array;
    }

    public static ValidTurnBehaviorStatusEffects 
        getTurnBehaviorStatusEffectEnumUsingString(String argument)
    {
        ValidTurnBehaviorStatusEffects result = null;
        
        if(isStringValid(validTurnBehaviorStatusEffectsValuesAsStrings(), argument))
        {
            result = ValidTurnBehaviorStatusEffects.valueOf(stringToEnum(argument));
        }
        
        return result;
    }
    
    private static final HashMap<ValidTurnBehaviorStatusEffects, String> turnBehaviorStatusEffectsHashMap = 
        new HashMap<ValidTurnBehaviorStatusEffects, String>();
        static 
        {
            for (ValidTurnBehaviorStatusEffects turnBehaviorStatusEffect : ValidTurnBehaviorStatusEffects.values()) 
            {
                turnBehaviorStatusEffectsHashMap.put(turnBehaviorStatusEffect, 
                    getTurnBehaviorStatusEffectStringUsingEnum(turnBehaviorStatusEffect));
            }
        }
        
    public static String getTurnBehaviorStatusEffectAsString(String argument) 
    {
        return turnBehaviorStatusEffectsHashMap.get(getTurnBehaviorStatusEffectEnumUsingString(argument));
    }
    
    public static ValidTurnBehaviorStatusEffects getTurnBehaviorStatusEffectAsEnum(String argument) 
    {
        ValidTurnBehaviorStatusEffects result = null;
        
        for(ValidTurnBehaviorStatusEffects key : turnBehaviorStatusEffectsHashMap.keySet())
        {
            if(key == getTurnBehaviorStatusEffectEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 

    // END: VALID BEHAVIOR STATUS EFFECTS 

    
    // START: VALID NULLIFY STATUS EFFECTS 
    
    public static enum ValidNullifyStatusEffects
    {
        NULLIFY_STATUS_EFFECTS;
    }
    
    public static String getNullifyStatusEffectStringUsingEnum(
        ValidNullifyStatusEffects argument)
    {
        String result = null; 
        
        switch(argument)
        {
            case NULLIFY_STATUS_EFFECTS: 
                result = "Nullify Status Effects";
                    break; 
        }
        
        return result;
    }
    
    public static String[] validNullifyStatusEffectsValuesAsStrings()
    {
        String[] array = new String[getNumberOfEnumElements(ValidNullifyStatusEffects.values())];
        
        for(int i = 0; i < ValidNullifyStatusEffects.values().length; i++)
        {
            array[i] =  getNullifyStatusEffectStringUsingEnum(ValidNullifyStatusEffects.values()[i]);
        }

        return array;
    }

    public static ValidNullifyStatusEffects 
        getNullifyStatusEffectEnumUsingString(String argument)
    {
        ValidNullifyStatusEffects result = null;
        
        if(isStringValid(validNullifyStatusEffectsValuesAsStrings(), argument))
        {
            result = ValidNullifyStatusEffects.valueOf(stringToEnum(argument));
        }
        
        return result;
    }

    private static final HashMap<ValidNullifyStatusEffects, String> nullifyStatusEffectsHashMap = 
        new HashMap<ValidNullifyStatusEffects, String>();
        static 
        {
            for (ValidNullifyStatusEffects nullifyStatusEffect : ValidNullifyStatusEffects.values()) 
            {
                nullifyStatusEffectsHashMap.put(nullifyStatusEffect, 
                    getNullifyStatusEffectStringUsingEnum(nullifyStatusEffect));
            }
        }
        
    public static String getNullifyStatusEffectAsString(String argument) 
    {
        return nullifyStatusEffectsHashMap.get(getNullifyStatusEffectEnumUsingString(argument));
    }
    
    public static ValidNullifyStatusEffects getNullifyStatusEffectAsEnum(String argument) 
    {
        ValidNullifyStatusEffects result = null;
        
        for(ValidNullifyStatusEffects key : nullifyStatusEffectsHashMap.keySet())
        {
            if(key == getNullifyStatusEffectEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 
    
    // END: VALID NULLIFY STATUS EFFECTS 

    // END: ENUM CLASSES AND HASHMAPS FOR ATTRIBUTES, ENCHANTMENTS AND RESISTANCES
    /*******************************************************************************/	


    
    // START: HASHMAP STORING HASHMAPS FOR QUICK RETRIEVAL 
    /*******************************************************************************/	
    
    public enum ValidSections
    {
        ATTRIBUTES, ENCHANTMENTS, UNIQUE_STATUS_EFFECTS, CURRENT_HEALTH_STATUS_EFFECTS, 
        ATTRIBUTE_STATUS_EFFECTS, BEHAVIOR_STATUS_EFFECTS, TURN_BEHAVIOR_STATUS_EFFECTS, 
        NULLIFYY_STATUS_EFFECTS;
    }
    
    // ensures that String is a valid attribute, enchantment, or status effect/resistance for status effect 
    public static String getStatAsValidString(String argument)
    {
        String originalSuppliedArgument = argument;
        boolean argumentIsNotNull = false;
        boolean inCaseArgumentIsNull = false;
        
        for(ValidSections element: ValidSections.values())
        {
            if(argumentIsNotNull != true)
            {
                switch(element)
                {
                    case ATTRIBUTES: 
                        argument = getAttributeAsString(argument);
                            break;
                    case ENCHANTMENTS: 
                        argument = getEnchantmentAsString(argument);
                            break;
                    case UNIQUE_STATUS_EFFECTS: 
                        argument = getUniqueStatusEffectAsString(argument);
                            break;
                    case CURRENT_HEALTH_STATUS_EFFECTS: 
                        argument = getCurrentHealthStatusEffectAsString(argument);
                            break;
                    case ATTRIBUTE_STATUS_EFFECTS: 
                        argument = getAttributeStatusEffectAsString(argument);
                            break;
                    case BEHAVIOR_STATUS_EFFECTS: 
                        argument = getBehaviorStatusEffectAsString(argument);
                            break;
                    case TURN_BEHAVIOR_STATUS_EFFECTS: 
                        argument = getTurnBehaviorStatusEffectAsString(argument);
                            break;
                    case NULLIFYY_STATUS_EFFECTS: 
                        argument = getNullifyStatusEffectAsString(argument);
                            inCaseArgumentIsNull = true;
                                break;
                }
                if(argument != null){argumentIsNotNull = true;}
                    else if(!inCaseArgumentIsNull){argument = originalSuppliedArgument;}
                        else{argument = null;}
            } else
            {
                break;
            }
        }
        
        return argument;
    }
        
    // return enum form of attribute, enchantment, or status effect/resistance for status effect 
    public static Object getStatAsValidEnum(String argument)
    {
        boolean argumentIsNotNull = false;
        
        Object statEnumForm = null;
        
        for(ValidSections element: ValidSections.values())
        {
            if(argumentIsNotNull != true)
            {
                switch(element)
                {
                    case ATTRIBUTES: 
                        statEnumForm = getAttributeAsEnum(argument);
                            break;
                    case ENCHANTMENTS: 
                        statEnumForm = getEnchantmentAsEnum(argument);
                            break;
                    case UNIQUE_STATUS_EFFECTS: 
                        statEnumForm = getUniqueStatusEffectAsEnum(argument);
                            break;
                    case CURRENT_HEALTH_STATUS_EFFECTS: 
                        statEnumForm = getCurrentHealthStatusEffectAsEnum(argument);
                            break;
                    case ATTRIBUTE_STATUS_EFFECTS: 
                        statEnumForm = getAttributeStatusEffectAsEnum(argument);
                            break;
                    case BEHAVIOR_STATUS_EFFECTS: 
                        statEnumForm = getBehaviorStatusEffectAsEnum(argument);
                            break;
                    case TURN_BEHAVIOR_STATUS_EFFECTS: 
                        statEnumForm = getTurnBehaviorStatusEffectAsEnum(argument);
                            break;
                    case NULLIFYY_STATUS_EFFECTS: 
                        statEnumForm = getNullifyStatusEffectAsEnum(argument);
                            break;
                }
                if(statEnumForm != null){argumentIsNotNull = true;}
            } else
            {
                break;
            }
        }
        
        return statEnumForm;
    }
    
    // ensures that String for resistances only are validated (for Armors class)
    public static String getResistancesForArmorsClassAsValidString(String argument)
    {
        String originalSuppliedArgument = argument;
        boolean argumentIsNotNull = false;
        boolean inCaseArgumentIsNull = false;
        
        for(ValidSections element: ValidSections.values())
        {
            if(argumentIsNotNull != true)
            {
                switch(element)
                {
                    case ENCHANTMENTS: 
                        argument = getEnchantmentAsString(argument);
                            break;
                    case UNIQUE_STATUS_EFFECTS: 
                        argument = getUniqueStatusEffectAsString(argument);
                            break;
                    case CURRENT_HEALTH_STATUS_EFFECTS: 
                        argument = getCurrentHealthStatusEffectAsString(argument);
                            break;
                    case ATTRIBUTE_STATUS_EFFECTS: 
                        argument = getAttributeStatusEffectAsString(argument);
                            break;
                    case BEHAVIOR_STATUS_EFFECTS: 
                        argument = getBehaviorStatusEffectAsString(argument);
                            break;
                    case TURN_BEHAVIOR_STATUS_EFFECTS: 
                        argument = getTurnBehaviorStatusEffectAsString(argument);
                            break;
                    case NULLIFYY_STATUS_EFFECTS: 
                        argument = getNullifyStatusEffectAsString(argument);
                            inCaseArgumentIsNull = true;
                                break;
                }
                if(argument != null){argumentIsNotNull = true;}
                    else if(!inCaseArgumentIsNull){argument = originalSuppliedArgument;}
                        else{argument = null;}
            } else
            {
                break;
            }
        }
        
        return argument;
    }    
    
    // return enum form of attribute, enchantment, or resistance 
    public static Object getResistancesForArmorsClassAsValidEnum(String argument)
    {
        boolean argumentIsNotNull = false;
        
        Object statEnumForm = null;
        
        for(ValidSections element: ValidSections.values())
        {
            if(argumentIsNotNull != true)
            {
                switch(element)
                {
                    case ENCHANTMENTS: 
                        statEnumForm = getEnchantmentAsEnum(argument);
                            break;
                    case UNIQUE_STATUS_EFFECTS: 
                        statEnumForm = getUniqueStatusEffectAsEnum(argument);
                            break;
                    case CURRENT_HEALTH_STATUS_EFFECTS: 
                        statEnumForm = getCurrentHealthStatusEffectAsEnum(argument);
                            break;
                    case ATTRIBUTE_STATUS_EFFECTS: 
                        statEnumForm = getAttributeStatusEffectAsEnum(argument);
                            break;
                    case BEHAVIOR_STATUS_EFFECTS: 
                        statEnumForm = getBehaviorStatusEffectAsEnum(argument);
                            break;
                    case TURN_BEHAVIOR_STATUS_EFFECTS: 
                        statEnumForm = getTurnBehaviorStatusEffectAsEnum(argument);
                            break;
                    case NULLIFYY_STATUS_EFFECTS: 
                        statEnumForm = getNullifyStatusEffectAsEnum(argument);
                            break;
                }
                if(statEnumForm != null){argumentIsNotNull = true;}
            } else
            {
                break;
            }
        }
        
        return statEnumForm;
    }
    
    // ensures that String for resistances only are validated (for Armors class)
    public static String getStatusNameAsValidString(String argument)
    {
        String originalSuppliedArgument = argument;
        boolean argumentIsNotNull = false;
        boolean inCaseArgumentIsNull = false;
        
        for(ValidSections element: ValidSections.values())
        {
            if(argumentIsNotNull != true)
            {
                switch(element)
                {
                    case UNIQUE_STATUS_EFFECTS: 
                        argument = getUniqueStatusEffectAsString(argument);
                            break;
                    case CURRENT_HEALTH_STATUS_EFFECTS: 
                        argument = getCurrentHealthStatusEffectAsString(argument);
                            break;
                    case ATTRIBUTE_STATUS_EFFECTS: 
                        argument = getAttributeStatusEffectAsString(argument);
                            break;
                    case BEHAVIOR_STATUS_EFFECTS: 
                        argument = getBehaviorStatusEffectAsString(argument);
                            break;
                    case TURN_BEHAVIOR_STATUS_EFFECTS: 
                        argument = getTurnBehaviorStatusEffectAsString(argument);
                            break;
                    case NULLIFYY_STATUS_EFFECTS: 
                        argument = getNullifyStatusEffectAsString(argument);
                            inCaseArgumentIsNull = true;
                                break;
                }
                if(argument != null){argumentIsNotNull = true;}
                    else if(!inCaseArgumentIsNull){argument = originalSuppliedArgument;}
                        else{argument = null;}
            } else
            {
                break;
            }
        }
        
        return argument;
    }    
    
    // return enum form of attribute, enchantment, or resistance 
    public static Object getStatusNameAsValidEnum(String argument)
    {
        boolean argumentIsNotNull = false;
        
        Object statEnumForm = null;
        
        for(ValidSections element: ValidSections.values())
        {
            if(argumentIsNotNull != true)
            {
                switch(element)
                {
                    case UNIQUE_STATUS_EFFECTS: 
                        statEnumForm = getUniqueStatusEffectAsEnum(argument);
                            break;
                    case CURRENT_HEALTH_STATUS_EFFECTS: 
                        statEnumForm = getCurrentHealthStatusEffectAsEnum(argument);
                            break;
                    case ATTRIBUTE_STATUS_EFFECTS: 
                        statEnumForm = getAttributeStatusEffectAsEnum(argument);
                            break;
                    case BEHAVIOR_STATUS_EFFECTS: 
                        statEnumForm = getBehaviorStatusEffectAsEnum(argument);
                            break;
                    case TURN_BEHAVIOR_STATUS_EFFECTS: 
                        statEnumForm = getTurnBehaviorStatusEffectAsEnum(argument);
                            break;
                    case NULLIFYY_STATUS_EFFECTS: 
                        statEnumForm = getNullifyStatusEffectAsEnum(argument);
                            break;
                }
                if(statEnumForm != null){argumentIsNotNull = true;}
            } else
            {
                break;
            }
        }
        
        return statEnumForm;
    }
    
    // END: ENUM CLASSES WITH ATTRIBUTES AND RESISTANCES
    /*******************************************************************************/	
}