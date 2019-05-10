package Commonly_Used_Methods;

import Move_Creation.StatusEffect;

public class StaticMethods 
{    
    // START: METHODS COMMONLY USED
    /*******************************************************************************/	
    
    // prepares a String for usage in Enum related methods (see valueOf())
    public static String stringToEnum(String argument)
    {
        // make String uppercase and replace all whitespaces and non-visible 
        // characters with underscores ("A dog" -> "A_DOG")
        return argument = argument.replaceAll("\\s","_").toUpperCase();
    } 
    
    public static int getNumberOfNonNullElements(Object[] array)
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
    
    // CANDIDATE FOR BINARY SEARCH IF ENUMS WERE SORTED...
    public static boolean stringValid(String[] enumClassValuesAsStrings, String argument)
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
    
    // CANDIDATE FOR BINARY SEARCH IF ENUMS WERE SORTED...
    public static String getString(String[] enumClassValuesAsStrings, String argument)
    {
        for(String element : enumClassValuesAsStrings)
        {  
            if(element.equals(argument))
            {
                argument = element;
            }
        }
        
        return argument;
    }
    
    public static boolean sameStatusEffectName(StatusEffect statusOne, StatusEffect statusTwo)
    {
        boolean result = false;
        
        if(StaticMethods.getStatusEffectEnum(statusOne.getName()) == 
            StaticMethods.getStatusEffectEnum(statusTwo.getName()))
        {
            result = true;
        }
        
        return result;
    }
    
    public static boolean sameStatusEffectName(String statusName, StatusEffect statusTwo)
    {
        boolean result = false;
        
        if(StaticMethods.getStatusEffectEnum(statusName) == StaticMethods.
            getStatusEffectEnum(statusTwo.getName()))
        {
            result = true;
        }
        
        return result;
    }
    
    // END: METHODS COMMONLY USED
    /*******************************************************************************/	


    
    // START: ATTRIBUTES ENUM CLASS
    /*******************************************************************************/	
    
    public static enum Attributes
    {
        MAX_HEALTH("Max Health"), MAX_STAMINA("Max Stamina"), MAX_NANO("Max Nano"), 
        ATTACK("Attack"), DEFENSE("Defense"), DEXTERITY("Dexterity"), CRITICAL("Critical"), 
        ACCURACY("Accuracy"), NANO_ATTACK("Nano Attack"), NANO_DEFENSE("Nano Defense"), 
        LUCK("Luck");
        
        private String attributes;
        
        Attributes(String attributes)
        {
            this.attributes = attributes;
        }
        
        public String getEnumAsString()
        {
            return attributes;
        }
    }
    
    public static String getAttributeString(String argument) 
    {
        return Attributes.valueOf(stringToEnum(argument)).getEnumAsString();
    }
    
    public static Attributes getAttributeEnum(String argument) 
    {
        return Attributes.valueOf(stringToEnum(argument));
    }
    
    public static String[] attributeValueStrings()
    {
        String[] array = new String[Attributes.values().length];
        
        for(int i = 0; i < Attributes.values().length; i++)
        {
            array[i] = Attributes.values()[i].getEnumAsString();
        }

        return array;
    }
    
    // END: ATTRIBUTES ENUM CLASS
    /*******************************************************************************/	

    
    
    // START: ENCHANTMENTS ENUM CLASS
    /*******************************************************************************/	
    
    public static enum Enchantments
    {
        FIRE("Fire"), WATER("Water"), ICE("Ice"), ELECTRICITY("Electricity"), 
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
    
    public static String getEnchantmentString(String argument) 
    {
        return Enchantments.valueOf(stringToEnum(argument)).getEnumAsString();
    }
    
    public static Enchantments getEnchantmentEnum(String argument) 
    {
        return Enchantments.valueOf(stringToEnum(argument));
    }
    
    public static String[] enchantmentValueStrings()
    {
        String[] array = new String[Enchantments.values().length];
        
        for(int i = 0; i < Enchantments.values().length; i++)
        {
            array[i] = Enchantments.values()[i].getEnumAsString();
        }

        return array;
    }
    
    // END: ENCHANTMENTS ENUM CLASS
    /*******************************************************************************/	


    
    // START: UNIQUE STATUS EFFECTS ENUM CLASS
    /*******************************************************************************/	
    
    public static enum UniqueStatusEffects
    {
        DRY("Dry"), WET("Wet"), COLD("Cold"), CONDUCTIVE("Conductive"), SICKNESS("Sickness"), 
        HYPERSENSITIVE("Hypersensistive"), COATED("Coated"), LIGHTWEIGHT("Lightweight"), 
        IRRADIATED("Irradiated");
        
        private String uniqueStatusEffect;
        
        UniqueStatusEffects(String uniqueStatusEffect)
        {
            this.uniqueStatusEffect = uniqueStatusEffect;
        }
        
        public String getEnumAsString()
        {
            return uniqueStatusEffect;
        }
    }
    
    public static String getUniqueStatusEffectString(String argument) 
    {
        return UniqueStatusEffects.valueOf(stringToEnum(argument)).getEnumAsString();
    }
    
    public static UniqueStatusEffects getUniqueStatusEffectEnum(String argument) 
    {
        return UniqueStatusEffects.valueOf(stringToEnum(argument));
    }
    
    public static String[] uniqueStatusEffectValueStrings()
    {
        String[] array = new String[UniqueStatusEffects.values().length];
        
        for(int i = 0; i < UniqueStatusEffects.values().length; i++)
        {
            array[i] = UniqueStatusEffects.values()[i].getEnumAsString();
        }

        return array;
    }
    
    // END: UNIQUE STATUS EFFECTS ENUM CLASS
    /*******************************************************************************/	

    
    
    // START: STATUS EFFECTS ENUM CLASSES 
    /*******************************************************************************/	
    
    // CURRENT HEALTH STATUS EFFECTS
    
    public static enum CurrentHealthStatusEffects
    {
        ABLAZE("Ablaze"), BLEED("Bleed"), TOXIC("Toxic"); 
        
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
    
    public static String getCurrentHealthStatusEffectString(String argument) 
    {
        return CurrentHealthStatusEffects.valueOf(stringToEnum(argument)).getEnumAsString();
    }
    
    public static CurrentHealthStatusEffects getCurrentHealthStatusEffectEnum(String argument) 
    {
        return CurrentHealthStatusEffects.valueOf(stringToEnum(argument));
    }

    public static String[] currentHealthStatusEffectValueStrings()
    {
        String[] array = new String[CurrentHealthStatusEffects.values().length];
        
        for(int i = 0; i < CurrentHealthStatusEffects.values().length; i++)
        {
            array[i] = CurrentHealthStatusEffects.values()[i].getEnumAsString();
        }

        return array;
    }
    
    // CURRENT HEALTH STATUS EFFECTS


    // ATTRIBUTE STATUS EFFECTS 
    
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

    public static String getAttributeStatusEffectString(String argument) 
    {
        return AttributeStatusEffects.valueOf(stringToEnum(argument)).getEnumAsString();
    }
    
    public static AttributeStatusEffects getAttributeStatusEffectEnum(String argument) 
    {
        return AttributeStatusEffects.valueOf(stringToEnum(argument));
    }
    
    public static String[] attributeStatusEffectValueStrings()
    {
        String[] array = new String[AttributeStatusEffects.values().length];
        
        for(int i = 0; i < AttributeStatusEffects.values().length; i++)
        {
            array[i] = AttributeStatusEffects.values()[i].getEnumAsString();
        }

        return array;
    }

    // ATTRIBUTE STATUS EFFECTS 


    // BEHAVIOR STATUS EFFECTS 
    
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
    
    public static String getBehaviorStatusEffectString(String argument) 
    {
        return BehaviorStatusEffects.valueOf(stringToEnum(argument)).getEnumAsString();
    }
    
    public static BehaviorStatusEffects getBehaviorStatusEffectEnum(String argument) 
    {
        return BehaviorStatusEffects.valueOf(stringToEnum(argument));
    }
    
    public static String[] behaviorStatusEffectValueStrings()
    {
        String[] array = new String[BehaviorStatusEffects.values().length];
        
        for(int i = 0; i < BehaviorStatusEffects.values().length; i++)
        {
            array[i] = BehaviorStatusEffects.values()[i].getEnumAsString();
        }

        return array;
    }

    // BEHAVIOR STATUS EFFECTS 

    
    // TURN BEHAVIOR STATUS EFFECTS 

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

    public static String getTurnBehaviorStatusEffectString(String argument) 
    {
        return TurnBehaviorStatusEffects.valueOf(stringToEnum(argument)).getEnumAsString();
    }
    
    public static TurnBehaviorStatusEffects getTurnBehaviorStatusEffectEnum(String argument) 
    {
        return TurnBehaviorStatusEffects.valueOf(stringToEnum(argument));
    }
    
    public static String[] turnBehaviorStatusEffectValueStrings()
    {
        String[] array = new String[TurnBehaviorStatusEffects.values().length];
        
        for(int i = 0; i < TurnBehaviorStatusEffects.values().length; i++)
        {
            array[i] = TurnBehaviorStatusEffects.values()[i].getEnumAsString();
        }

        return array;
    }

    // TURN BEHAVIOR STATUS EFFECTS 

    
    // NULLIFY STATUS EFFECTS 
    
    public static enum NullifyStatusEffects
    {
        NULLIFY_STATUS_EFFECTS("Nullify Status Effects");
        
        private String nullifyStatusEffects;
        
        NullifyStatusEffects(String nullifyStatusEffects)
        {
            this.nullifyStatusEffects = nullifyStatusEffects;
        }
        
        public String getEnumAsString()
        {
            return nullifyStatusEffects;
        }
    }
    
    public static String getNullifyStatusEffectString(String argument) 
    {
        return NullifyStatusEffects.valueOf(stringToEnum(argument)).getEnumAsString();
    }
    
    public static NullifyStatusEffects getNullifyStatusEffectEnum(String argument) 
    {
        return NullifyStatusEffects.valueOf(stringToEnum(argument));
    }
    
    public static String[] nullifyStatusEffectValueStrings()
    {
        String[] array = new String[NullifyStatusEffects.values().length];
        
        for(int i = 0; i < NullifyStatusEffects.values().length; i++)
        {
            array[i] = NullifyStatusEffects.values()[i].getEnumAsString();
        }

        return array;
    }
    
    // NULLIFY STATUS EFFECTS 
    
    
    // ALL STATUS EFFECTS 
    
    public static enum AllStatusEffects
    {
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
    
    public static String getStatusEffectString(String argument)
    {
        return AllStatusEffects.valueOf(StaticMethods.stringToEnum(argument)).getEnumAsString();
    }
    
    public static AllStatusEffects getStatusEffectEnum(String argument)
    {
        return AllStatusEffects.valueOf(StaticMethods.stringToEnum(argument));
    }
    
    // ALL STATUS EFFECTS 
    
    // END: STATUS EFFECTS ENUM CLASSES 
    /*******************************************************************************/	
    
    
    
    // START: ALL STATS AND ARMOR RESISTANCES 
    /*******************************************************************************/	
    
    public static enum AllStats
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
        
        private String allStats;
        
        AllStats(String allStats)
        {
            this.allStats = allStats;
        }
        
        public String getEnumAsString()
        {
            return allStats;
        }
    }
    
    public static String getStatString(String argument)
    {
        return AllStats.valueOf(StaticMethods.stringToEnum(argument)).getEnumAsString();
    }
    
    public static AllStats getStatEnum(String argument)
    {
        return AllStats.valueOf(StaticMethods.stringToEnum(argument));
    }
    
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
        STOPPED("Stopped"),
		
        // nullify
        NULLIFY_STATUS_EFFECTS("Nullify Status Effects");
		
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
    
    public static String getArmorResistanceString(String argument)
    {
        return ArmorResistances.valueOf(StaticMethods.stringToEnum(argument)).getEnumAsString();
    }
    
    public static ArmorResistances getArmorResistanceEnum(String argument)
    {
        return ArmorResistances.valueOf(StaticMethods.stringToEnum(argument));
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
