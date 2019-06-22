/*
    StaticMethods contains static methods commonly used by methods in other 
    classes within this project. 
*/

package Commonly_Used_Methods;

import Move_Creation.StatusEffect;

public class StaticMethods 
{    
    // START: COMMONLY USED METHODS
    /*******************************************************************************/	
    
    // prepares string for conversion into an Enum constant 
    public static String prepareStringForEnumConversion(String argument)
    {
        // make String uppercase and replace all whitespaces and non-visible 
        // characters with underscores (Ex: "A dog" -> "A_DOG")
        return argument.replaceAll("\\s", "_").toUpperCase();
    } 
    
    // returns true if strings representing status effect names are identical
    public static boolean sameStatusEffectName(String statusName, StatusEffect statusTwo)
    {
        boolean result = false;
        
        if(StaticMethods.getStatusEffectEnum(statusName) == StaticMethods.getStatusEffectEnum(statusTwo.getName()))
        {
            result = true;
        }
        
        return result;
    }
    
    // END: COMMONLY USED METHODS
    /*******************************************************************************/	


    
    // START: ATTRIBUTES ENUM CLASS
    /*******************************************************************************/	
    
    // enum class containing enums representing attributes tied to a GenericCharacter object 
    public static enum Attributes
    {
        MAX_HEALTH("Max Health"), MAX_STAMINA("Max Stamina"), MAX_NANO("Max Nano"), 
        ATTACK("Attack"), DEFENSE("Defense"), DEXTERITY("Dexterity"), CRITICAL("Critical"), 
        ACCURACY("Accuracy"), NANO_ATTACK("Nano Attack"), NANO_DEFENSE("Nano Defense"), LUCK("Luck");
        
        private String attribute;
        
        Attributes(String attribute)
        {
            this.attribute = attribute;
        }
        
        public String getEnumAsString()
        {
            return attribute;
        }
    }
    
    // returns string tied to Attributes enum constant 
    public static String getAttributeString(String argument) 
    {
        return Attributes.valueOf(prepareStringForEnumConversion(argument)).getEnumAsString();
    }
    
    // returns Attributes enum constant associated with the string supplied
    public static Attributes getAttributeEnum(String argument) 
    {
        return Attributes.valueOf(prepareStringForEnumConversion(argument));
    }
    
    // END: ATTRIBUTES ENUM CLASS
    /*******************************************************************************/	

    
    
    // START: ENCHANTMENTS ENUM CLASS
    /*******************************************************************************/	
    
    // enum class containing enums representing enchantments that can damage GenericCharacter objects 
    public static enum Enchantments
    {
        NONE("None"), FIRE("Fire"), WATER("Water"), ICE("Ice"), ELECTRICITY("Electricity"), 
        POISON("Poison"), SONIC("Sonic"), PLASMA("Plasma"), WIND("Wind"); 
        
        private String enchantment;
        
        Enchantments(String enchantment)
        {
            this.enchantment = enchantment;
        }
        
        public String getEnumAsString()
        {
            return enchantment;
        }
    }
    
    // returns string tied to Enchantments enum constant 
    public static String getEnchantmentString(String argument) 
    {
        return Enchantments.valueOf(prepareStringForEnumConversion(argument)).getEnumAsString();
    }
    
    // returns Enchantments enum constant associated with the string supplied
    public static Enchantments getEnchantmentEnum(String argument) 
    {
        return Enchantments.valueOf(prepareStringForEnumConversion(argument));
    }
    
    // END: ENCHANTMENTS ENUM CLASS
    /*******************************************************************************/	

    
    
    // START: STATUS EFFECTS ENUM CLASSES 
    /*******************************************************************************/	
    
    // CURRENT HEALTH STATUS EFFECTS
    
    // enum class containing enums representing status effects targeting current health 
    public static enum CurrentHealthStatusEffects
    {
        ABLAZE("Ablaze"), BLEED("Bleed"), POISON("Poison"); 
        
        private String currentHealthStatusEffect;
        
        CurrentHealthStatusEffects(String currentHealthStatusEffect)
        {
            this.currentHealthStatusEffect = currentHealthStatusEffect;
        }
        
        public String getEnumAsString()
        {
            return currentHealthStatusEffect;
        }
    }
    
    // returns string tied to CurrentHealthStatusEffects enum constant 
    public static String getCurrentHealthStatusEffectString(String argument) 
    {
        return CurrentHealthStatusEffects.valueOf(prepareStringForEnumConversion(argument)).getEnumAsString();
    }
    
    // returns CurrentHealthStatusEffects enum constant associated with the string supplied
    public static CurrentHealthStatusEffects getCurrentHealthStatusEffectEnum(String argument) 
    {
        return CurrentHealthStatusEffects.valueOf(prepareStringForEnumConversion(argument));
    }
    
    // CURRENT HEALTH STATUS EFFECTS


    // ATTRIBUTE STATUS EFFECTS 
    
    // enum class containing enums representing status effects targeting attributes 
    public static enum AttributeStatusEffects
    {
        ATTACK_DOWN("Attack Down"), DEFENSE_DOWN("Defense Down"), SHUTDOWN("Shutdown"), 
        DEXTERITY_DOWN("Dexterity Down"), CRITICAL_DOWN("Critical Down"), ACCURACY_DOWN
        ("Accuracy Down"), BLIND("Blind"), NANO_ATTACK_DOWN("Nano Attack Down"), 
        NANO_DEFENSE_DOWN("Nano Defense Down");
        
        private String attributeStatusEffect;
        
        AttributeStatusEffects(String attributeStatusEffect)
        {
            this.attributeStatusEffect = attributeStatusEffect;
        }
        
        public String getEnumAsString()
        {
            return attributeStatusEffect;
        }
    }

    // returns string tied to AttributeStatusEffects enum constant 
    public static String getAttributeStatusEffectString(String argument) 
    {
        return AttributeStatusEffects.valueOf(prepareStringForEnumConversion(argument)).getEnumAsString();
    }
    
    // returns AttributeStatusEffects enum constant associated with the string supplied
    public static AttributeStatusEffects getAttributeStatusEffectEnum(String argument) 
    {
        return AttributeStatusEffects.valueOf(prepareStringForEnumConversion(argument));
    }

    // ATTRIBUTE STATUS EFFECTS 


    // BEHAVIOR STATUS EFFECTS 
    
    // enum class containing enums representing status effects targeting character behavior 
    public static enum BehaviorStatusEffects
    {
        CONFUSED("Confused"), ENAMORED("Enamored"), BERSERK("Berserk");
        
        private String behaviorStatusEffect;
        
        BehaviorStatusEffects(String behaviorStatusEffect)
        {
            this.behaviorStatusEffect = behaviorStatusEffect;
        }
        
        public String getEnumAsString()
        {
            return behaviorStatusEffect;
        }
    }
    
    // returns string tied to BehaviorStatusEffects enum constant 
    public static String getBehaviorStatusEffectString(String argument) 
    {
        return BehaviorStatusEffects.valueOf(prepareStringForEnumConversion(argument)).getEnumAsString();
    }
    
    // returns BehaviorStatusEffects enum constant associated with the string supplied
    public static BehaviorStatusEffects getBehaviorStatusEffectEnum(String argument) 
    {
        return BehaviorStatusEffects.valueOf(prepareStringForEnumConversion(argument));
    }
    
    // returns an array of strings corresponding to BehaviorStatusEffects enum constants 
    public static String[] behaviorStatusEffectValueStrings()
    {
        String[] array = new String[BehaviorStatusEffects.values().length];
        
        for(int i = 0; i < array.length; i++)
        {
            array[i] = BehaviorStatusEffects.values()[i].getEnumAsString();
        }

        return array;
    }

    // BEHAVIOR STATUS EFFECTS 

    
    // TURN BEHAVIOR STATUS EFFECTS 

    // enum class containing enums representing status effects targeting character turn behavior 
    public static enum TurnBehaviorStatusEffects
    {
        FLINCHED("Flinched"), STUNNED("Stunned"), SCARED("Scared"), BOUND("Bound"), 
        SLEEP("Sleep"), TRANCED("Tranced"), SHOCKED("Shocked"), SLOWED("Slowed"), 
        STOPPED("Stopped");
        
        private String turnBehaviorStatusEffects;
        
        TurnBehaviorStatusEffects(String turnBehaviorStatusEffects)
        {
            this.turnBehaviorStatusEffects = turnBehaviorStatusEffects;
        }
        
        public String getEnumAsString()
        {
            return turnBehaviorStatusEffects;
        }
    }

    // returns string tied to TurnBehaviorStatusEffects enum constant 
    public static String getTurnBehaviorStatusEffectString(String argument) 
    {
        return TurnBehaviorStatusEffects.valueOf(prepareStringForEnumConversion(argument)).getEnumAsString();
    }
    
    // returns TurnBehaviorStatusEffects enum constant associated with the string supplied
    public static TurnBehaviorStatusEffects getTurnBehaviorStatusEffectEnum(String argument) 
    {
        return TurnBehaviorStatusEffects.valueOf(prepareStringForEnumConversion(argument));
    }
    
    // returns an array of strings corresponding to TurnBehaviorStatusEffects enum constants 
    public static String[] turnBehaviorStatusEffectValueStrings()
    {
        String[] array = new String[TurnBehaviorStatusEffects.values().length];
        
        for(int i = 0; i < array.length; i++)
        {
            array[i] = TurnBehaviorStatusEffects.values()[i].getEnumAsString();
        }

        return array;
    }

    // TURN BEHAVIOR STATUS EFFECTS 

    
    // ALL STATUS EFFECTS 
    
    // enum class containing enums representing all status effects that can be inflicted 
    public static enum AllStatusEffects
    {
        // no status effect selected 
        NONE("None"),
        
        // unique
        ABLAZE("Ablaze"), BLEED("Bleed"), POISON("Poison"),
        
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
	
        // stamina style move omission
        OMIT_UNIVERSAL_STAMINA_MOVES("Omit Universal Stamina Moves"), 
        OMIT_HAND_TO_HAND_STAMINA_MOVES("Omit Hand To Hand Stamina Moves"), 
        OMIT_ONE_HANDED_STAMINA_MOVES("Omit One Handed Stamina Moves"), 
        OMIT_TWO_HANDED_STAMINA_MOVES("Omit Two Handed Stamina Moves"), 
        OMIT_DUAL_WIELDED_STAMINA_MOVES("Omit Dual Wielded Stamina Moves"), 
        
        // nano style move omission
        OMIT_UNIVERSAL_NANO_MOVES("Omit Universal Nano Moves"), 
        OMIT_HAND_TO_HAND_NANO_MOVES("Omit Hand To Hand Nano Moves"), 
        OMIT_ONE_HANDED_NANO_MOVES("Omit One Handed Nano Moves"), 
        OMIT_TWO_HANDED_NANO_MOVES("Omit Two Handed Nano Moves"), 
        OMIT_DUAL_WIELDED_NANO_MOVES("Omit Dual Wielded Nano Moves"), 
        
        // special style move omission
        OMIT_TECHNIQUES_MOVES("Omit Techniques Moves"), 
        OMIT_OTHER_MOVES("Omit Other Moves"), 
        
        // stamina technique move omission
        OMIT_UNIVERSAL_HAND_TO_HAND_STAMINA_MOVES("Omit Universal Hand To Hand Stamina Moves"), 
        OMIT_CLOSE_QUARTERS_COMBAT_STAMINA_MOVES("Omit Close Quarters Combat Stamina Moves"), 
        OMIT_UNIVERSAL_ONE_HANDED_STAMINA_MOVES("Omit Universal One Handed Stamina Moves"), 
        OMIT_SWORD_STAMINA_MOVES("Omit Sword Stamina Moves"), 
        OMIT_KNIFE_STAMINA_MOVES("Omit Knife Stamina Moves"), 
        OMIT_OTHER_ONE_HANDED_STAMINA_MOVES("Omit Other One Handed Stamina Moves"), 
        OMIT_UNIVERSAL_TWO_HANDED_STAMINA_MOVES("Omit Universal Two Handed Stamina Moves"), 
        OMIT_GREAT_SWORD_STAMINA_MOVES("Omit Great Sword Stamina Moves"), 
        OMIT_SPEAR_STAMINA_MOVES("Omit Spear Stamina Moves"), 
        OMIT_OTHER_TWO_HANDED_STAMINA_MOVES("Omit Other Two Handed Stamina Moves"), 
        OMIT_UNIVERSAL_DUAL_WIELDED_STAMINA_MOVES("Omit Universal Dual Wielded Stamina Moves"), 
        OMIT_BLADES_STAMINA_MOVES("Omit Blades Stamina Moves"), 
        OMIT_OTHER_DUAL_WIELDED_STAMINA_MOVES("Omit Other Dual Wielded Stamina Moves"), 

        // nano technique move omission
        OMIT_UNIVERSAL_HAND_TO_HAND_NANO_MOVES("Omit Universal Hand To Hand Nano Moves"), 
        OMIT_CLOSE_QUARTERS_COMBAT_NANO_MOVES("Omit Close Quarters Combat Nano Moves"), 
        OMIT_UNIVERSAL_ONE_HANDED_NANO_MOVES("Omit Universal One Handed Nano Moves"), 
        OMIT_SWORD_NANO_MOVES("Omit Sword Nano Moves"), 
        OMIT_KNIFE_NANO_MOVES("Omit Knife Nano Moves"), 
        OMIT_OTHER_ONE_HANDED_NANO_MOVES("Omit Other One Handed Nano Moves"), 
        OMIT_UNIVERSAL_TWO_HANDED_NANO_MOVES("Omit Universal Two Handed Nano Moves"), 
        OMIT_GREAT_SWORD_NANO_MOVES("Omit Great Sword Nano Moves"), 
        OMIT_SPEAR_NANO_MOVES("Omit Spear Nano Moves"), 
        OTHER_TWO_HANDED_NANO_MOVES("Omit Other Two Handed Nano Moves"), 
        OMIT_UNIVERSAL_DUAL_WIELDED_NANO_MOVES("Omit Universal Dual Wielded Nano Moves"), 
        OMIT_BLADES_NANO_MOVES("Omit Blades Nano Moves"), 
        OMIT_OTHER_DUAL_WIELDED_NANO_MOVES("Omit Other Dual Wielded Nano Moves"),

        // special technique move omission
        OMIT_GENERAL_PURPOSE_MOVES("Omit General Purpose Moves"); 

        private String allStatusEffects;
        
        AllStatusEffects(String allStatusEffects)
        {
            this.allStatusEffects = allStatusEffects;
        }
        
        public String getEnumAsString()
        {
            return allStatusEffects;
        }
    }
    
    // returns string tied to AllStatusEffects enum constant 
    public static String getStatusEffectString(String argument)
    {
        return AllStatusEffects.valueOf(StaticMethods.prepareStringForEnumConversion(argument)).getEnumAsString();
    }
    
    // returns AllStatusEffects enum constant associated with the string supplied
    public static AllStatusEffects getStatusEffectEnum(String argument)
    {
        return AllStatusEffects.valueOf(StaticMethods.prepareStringForEnumConversion(argument));
    }
    
    // ALL STATUS EFFECTS 
    
    // END: STATUS EFFECTS ENUM CLASSES 
    /*******************************************************************************/	
    
    
    
    // START: ALL STATS AND ARMOR RESISTANCES 
    /*******************************************************************************/	
    
    // enum class containing enums representing all resistances covered by armor pieces 
    public static enum ArmorResistances
    {
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
        STOPPED("Stopped");
		
        private String armorResistances;
        
        ArmorResistances(String armorResistances)
        {
            this.armorResistances = armorResistances;
        }
        
        public String getEnumAsString()
        {
            return armorResistances;
        }
    }
    
    // returns string tied to ArmorResistances enum constant 
    public static String getArmorResistanceString(String argument)
    {
        return ArmorResistances.valueOf(StaticMethods.prepareStringForEnumConversion(argument)).getEnumAsString();
    }
    
    // returns ArmorResistances enum constant associated with the string supplied
    public static ArmorResistances getArmorResistanceEnum(String argument)
    {
        return ArmorResistances.valueOf(StaticMethods.prepareStringForEnumConversion(argument));
    }
    
    // END: ALL STATS AND ARMOR RESISTANCES 
    /*******************************************************************************/	

    
    
    // START: COMPARATOR LOGIC FOR ORDERING STRINGS
    /*******************************************************************************/

    /*	To create a custom comparator: 
            Override existing comparator 
            Comparator must have the same type as the key in TreeMap 
            Comparator {} must end with a semicolon symbol (;)
                    SORTING is done by key NOT by value */

    /* Note on why compareTo() is not used...
       compareTo() sorting: number, Uppercase, lowercase -> 1Apple, Apple, Bee, apple */

    // compare two strings and determine whether they are the same or different regardless
    // of case (i.e. "example" would be considered the same as "Example") 
    // method used in comparators for TreeMaps involving string comparison between keys
    public static int compareStrings(String argumentOne, String arguementTwo)
    {
        // code compares names without regard to case and stores result of comparison 
        // (1, 0, -1) in variable stringComparisonResult (1, -1 is different & 0 is same)
        int stringComparisonResult = String.CASE_INSENSITIVE_ORDER.compare(argumentOne, arguementTwo);

        // if strings are identical, set stringComparisonResult to 1 in order to place 
        // entry after the entry it is being compared to since order does not matter 
        // as they are the same String wise 
        if(stringComparisonResult == 0)
        {
                // if stringComparisonResult was not changed here, the key of the entry 
                // that is being compared to the key of entry that exists in the TreeMap 
                // would "merge/disappear" or not be added to the TreeMap along with its 
                // value resulting in data loss 
                stringComparisonResult = 1;
        }

        // return value held in stringComparisonResult
        return stringComparisonResult;
    }
    
    // END: COMPARATOR LOGIC FOR ORDERING STRINGS
    /*******************************************************************************/    
}
