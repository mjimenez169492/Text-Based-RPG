package Generic_Object;

/*
    Item extends GenericObject and defines methods related to creating items which 
    can positively or negatively effect users/targets both in and outside of battle. 
*/

import Commonly_Used_Methods.StaticMethods;
import Move_Creation.Moves;

public class Item extends GenericObject
{
    private Moves move;                   // DOES NOT EXIST YET 
    
    // create Items objects that can call upon GenericObject methods; Items objects 
    // can be customized further by calling upon methods created within this class 
    public Item() 
    {
        // empty constructor 
    }



    // START: ITEM CATEGORY, SUPERTYPE, AND SUBTYPE
    /*******************************************************************************/

    public enum ItemCategory
    { 
        RECOVERY("Recovery"), DAMAGE("Damage"), OTHER("Other");
        
        private String itemCategory;
        
        ItemCategory(String itemCategory)
        {
            this.itemCategory = itemCategory;
        }
        
        public String getEnumAsString()
        {
            return itemCategory;
        }
    } 
    
    public void setItemCategory(String argument)
    {
        super.setCategory(ItemCategory.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public ItemCategory getItemCategoryEnum()
    {
        return ItemCategory.valueOf(StaticMethods.stringToEnum(super.getCategory()));
    }
    
    public enum ItemSuperTypes 
    {
        GAUGE("Gauge"), STAT("Stat"), STATUS_EFFECT("Status Effect"), MULTIPLE_EFFECTS
        ("Multiple Effects"), KEY_ITEM("Key Item"), MISCELLANEOUS("Miscellaneous");
        
        private String itemSuperType;
        
        ItemSuperTypes(String itemSuperType)
        {
            this.itemSuperType = itemSuperType;
        }
        
        public String getEnumAsString()
        {
            return itemSuperType;
        }
    } 
    
    public void setItemSuperType(String argument)
    {
        super.setSuperType(ItemSuperTypes.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public ItemSuperTypes getItemSuperTypeEnum()
    {
        return ItemSuperTypes.valueOf(StaticMethods.stringToEnum(super.getSuperType()));
    }
    
    public enum ItemSubTypes 
    {
        // gauges 
        HEALTH_POINTS("Health Points"), STAMINA_POINTS("Stamina Points"), NANO_POINTS
        ("Nano Points"), HEALTH_AND_STAMINA("Health & Stamina"), HEALTH_AND_NANO
        ("Health & Nano"), STAMINA_AND_NANO("Stamina & Nano"), ALL_GAUGES("All Gauges"), 
        MULTIPLE_EFFECTS("Multiple Effects"), ALL_RECOVERY("All Recovery"), 
        
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
        
        // stress
        STRESS("Stress"), 
        
        // status related
        STATUS_DEALING("Status Dealing"), STATUS_REMOVING("Status Removing"), 
        
        // key items
        PLOT("Plot"), QUEST("Quest"), PERSONAL("Personal"), 
        
        // Miscellaneous
        SCRAP("Scrap"), COMPONENTS("Components"), OTHER("Other");
        
        private String itemSubType;
        
        ItemSubTypes(String itemSubType)
        {
            this.itemSubType = itemSubType;
        }
        
        public String getEnumAsString()
        {
            return itemSubType;
        }
    } 
    
    public void setItemSubType(String argument)
    {
        super.setSubType(ItemSubTypes.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public ItemSubTypes getItemSubTypeEnum()
    {
        return ItemSubTypes.valueOf(StaticMethods.stringToEnum(super.getSubType()));
    }
    
    public void setMove(Moves move)
    {
        this.move = move;
    }
    
    public Moves getMove()
    {
        return move;
    }
    
    // END: ITEN CATEGORY, SUPERTYPE, AND SUBTYPE
    /*******************************************************************************/
}
