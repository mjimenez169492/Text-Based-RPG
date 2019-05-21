package Generic_Object;

/*
    Weapons extends OutfitMethods meaning that Weapons is a subclass of superclass 
    OutfitMethods. Weapons defines methods relating to weapon creation. 
*/

import Commonly_Used_Methods.StaticMethods;
import Move_Creation.StatusEffect;
import java.util.ArrayList;

public class Weapon extends OutfitMethods
{
    // stores enchantment imbued onto weapon 
    private String enchantment;
    
    // sets max number of status effects that can be imbued on a weapon 
    private int maxNumberOfStatusEffects;
    
    // ArrayList stores status effects weapon can inflict on a target upon attack 
    private ArrayList<StatusEffect> weaponStatuses = new ArrayList<>();
    
    // subclass constructor with method(s) invoked upon object creation 
    public Weapon()
    {
        // need to set subclass name to enable slot/core equip feature for object 
        setSubclassName("Weapon");
    }
    
    
    
    // START: WEAPON CATEGORY, SUPERTYPE, AND SUBTYPE
    /*******************************************************************************/

    public enum WeaponCategory
    { 
        UNIVERSAL("Universal"), HAND_TO_HAND("Hand To Hand"), ONE_HANDED("One Handed"), 
        TWO_HANDED("Two Handed"), DUAL_WIELDED("Dual Wielded");
        
        private String weaponCategory;
        
        WeaponCategory(String weaponCategory)
        {
            this.weaponCategory = weaponCategory;
        }
        
        public String getEnumAsString()
        {
            return weaponCategory;
        }
    } 
    
    public void setWeaponCategory(String argument)
    {
        super.setCategory(WeaponCategory.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public WeaponCategory getWeaponCategoryEnum()
    {
        return WeaponCategory.valueOf(StaticMethods.stringToEnum(super.getCategory()));
    }
    
    public enum WeaponSuperTypes 
    {
        CLOSE_QUARTERS_COMBAT("Close Quarters Combat"), SWORD("Sword"), KNIFE("Knife"), 
        OTHER_ONE_HANDED("Other One Handed"), GREAT_SWORD("Great Sword"), SPEAR("Spear"), 
        OTHER_TWO_HANDED("Other Two Handed"), BLADES("Blades"), OTHER_DUAL_WIELDED
        ("Other Dual Wielded");
        
        private String weaponSuperType;
        
        WeaponSuperTypes(String weaponSuperType)
        {
            this.weaponSuperType = weaponSuperType;
        }
        
        public String getEnumAsString()
        {
            return weaponSuperType;
        }
    } 
    
    public void setWeaponSuperType(String argument)
    {
        super.setSuperType(WeaponSuperTypes.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public WeaponSuperTypes getWeaponSuperTypeEnum()
    {
        return WeaponSuperTypes.valueOf(StaticMethods.stringToEnum(super.getSuperType()));
    }
    
    public enum WeaponSubTypes 
    {
        IMPROVISED("Improvised"), MAKESHIFT("Makeshift"), JUNKER("Junker"), STANDARD("Standard"), 
        SOLID("Solid"), SEPARATOR("Separator"), OLD_STANDARD("Old Standard"), OLD_SOLID("Old Solid"), 
        OLD_SEPARATOR("Old Separator"), PROTOTYPE("Prototype"), UNKNOWN("Uknown"), OBSOLETE("Obsolete"), 
        FOREIGN_STANDARD("Foreign Standard"), FOREIGN_SOLID("Foreign Soldi"), FOREIGN_SEPARATOR("Foreign Separator"), 
        LOST("Lost"), LEGENDARY("Legendary");
        
        private String weaponSubType;
        
        WeaponSubTypes(String weaponSubType)
        {
            this.weaponSubType = weaponSubType;
        }
        
        public String getEnumAsString()
        {
            return weaponSubType;
        }
    } 
    
    public void setWeaponSubType(String argument)
    {
        super.setSubType(WeaponSubTypes.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public WeaponSubTypes getWeaponSubTypeEnum()
    {
        return WeaponSubTypes.valueOf(StaticMethods.stringToEnum(super.getSubType()));
    }
    
    // END: WEAPON CATEGORY, SUPERTYPE, AND SUBTYPE
    /*******************************************************************************/

    
    
    // START: WEAPON ENCHANTMENT
    /*******************************************************************************/

    // Note: enchantment is validated before enchantment is set 
    public void setEnchantment(String enchantment)
    {
        this.enchantment = StaticMethods.getEnchantmentString(enchantment);
    }
    
    public String getEnchantment()
    {
        return enchantment;
    }
    
    // END: WEAPON ENCHANTMENT
    /*******************************************************************************/

    

    // START: STATUS EFFECTS TIED TO WEAPON 
    /*******************************************************************************/

    public void setMaxNumberOfStatusEffects(int maxNumberOfStatusEffects)
    {
        this.maxNumberOfStatusEffects = maxNumberOfStatusEffects;
    }
    
    public int getMaxNumberOfStatusEffects()
    {
        return maxNumberOfStatusEffects;
    }
    
    public void addStatusEffect(StatusEffect status)
    {
        if(status != null && weaponStatuses.size() != maxNumberOfStatusEffects)
        {
            if(StaticMethods.getStatusEffectString(status.getName()) != null)
            {
                weaponStatuses.add(status);
            }
        }
    }

    public void removeWeaponStatus(String statusName)
    {
        if(statusName != null)
        {
            for(StatusEffect element : weaponStatuses)
            {
                if(statusName.equals((element.getName())))
                {
                    weaponStatuses.remove(element);
                }
            }
        }
    }

    public ArrayList<StatusEffect> getWeaponStatuses()
    {
        return weaponStatuses;
    }	
    
    // END: STATUS EFFECTS TIED TO WEAPON 
    /*******************************************************************************/
}
