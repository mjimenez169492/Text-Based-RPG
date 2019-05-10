package Generic_Object;

/*
    Weapons extends OutfitMethods meaning that Weapons is a subclass of superclass 
    OutfitMethods. Weapons defines methods relating to weapon creation. 
*/

import Generic_Object.OutfitMethods;
import Universally_Used_Methods.StaticMethods;
import Move_Creation.StatusEffect;
import java.util.ArrayList;

public class Weapons extends OutfitMethods
{
    // effect of weapon on following attributes of wearer
    private double maxNano, attack, dexterity, critical, accuracy, nanoAttack, 
        stressEffectUponAttack;	

    // stores enchantment imbued onto weapon 
    private String enchantment;
    
    // sets max number of status effects that can be imbued on a weapon 
    private int maxNumberOfStatusEffects;
    
    // ArrayList stores status effects weapon can inflict on a target upon attack 
    private ArrayList<StatusEffect> weaponStatuses = new ArrayList<StatusEffect>();
    
    // subclass constructor with method(s) invoked upon object creation 
    public Weapons()
    {
        // need to set subclass name to enable slot/core equip feature for object 
        setSubclassName("Weapons");
    }



    // START: WEAPON ATTRIBUTES ADDED/SUBTRACTED FROM WIELDER
    /*******************************************************************************/

    public double validateAttribute(double value)
    {
        if(value < -350)
        {
            value = -350;
        }
        else if(value > 350)
        {
            value = 350;
        }

        return value;
    }

    public void setAttack(double attack)
    {		
        this.attack = validateAttribute(attack);
    }

    public void setMaxNano(double maxNano)
    {
        this.maxNano = validateAttribute(maxNano);
    }

    public double getMaxNano()
    {
        return maxNano;
    }
    
    public double getAttack()
    {
        return attack;
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

    public void setStressEffectUponAttack(double stressEffectUponAttack)
    {
        this.stressEffectUponAttack = validateAttribute(stressEffectUponAttack);
    }

    public double getStressEffectUponAttack()
    {
        return stressEffectUponAttack;
    }

    // END: WEAPON ATTRIBUTES ADDED/SUBTRACTED FROM WIELDER
    /*******************************************************************************/


    
    // START: WEAPON ENCHANTMENT
    /*******************************************************************************/

    // Note: enchantment is validated before enchantment is set 
    public void setEnchantment(String enchantment)
    {
        this.enchantment = StaticMethods.getEnchantmentAsString(enchantment);
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
            weaponStatuses.add(status);
        }
    }

    public void removeWeaponStatus(String statusName)
    {
        if(statusName != null)
        {
            for(StatusEffect element : weaponStatuses)
            {
                // Note: StaticMethods.getStatAsValidEnum(String argument) is used 
                //       to compare Strings since getStatAsValidEnum() accounts for 
                //       all status effects that could be inflicted 
                if(StaticMethods.getStatAsValidEnum(statusName) == StaticMethods.
                    getStatAsValidEnum(element.getName()))
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
    


    // START: TOTAL WEAPON ATTRIBUTES WITH CORES AND DURABILITY SUPPLIED
    /*******************************************************************************/

    /*  Note on "getTotal" methods below: 
            methods get total value for a object (like attack, nano, ect.) by adding 
            object's power and core points together only if the cores are the same 
            type as the String supplied as argument (if "Attack" is supplied then 
            add the current core points of cores with core type "Attack" to value) */

    public double getTotalMaxNano()
    {
        return getTotalOutfitValue(getMaxNano(), "Nano"); 
    }
    
    public double getTotalAttack()
    {
        return getTotalOutfitValue(getAttack(), "Attack"); 
    }

    public double getTotalDexterity()
    {
        return getTotalOutfitValue(getDexterity(), "Dexterity"); 
    }

    public double getTotalCritical()
    {
        return getTotalOutfitValue(getCritical(), "Critical"); 
    }

    public double getTotalAccuracy()
    {
        return getTotalOutfitValue(getAccuracy(), "Accuracy"); 
    }

    public double getTotalNanoAttack()
    {
        return getTotalOutfitValue(getNanoAttack(), "Nano Attack"); 
    }

    // END: TOTAL WEAPON ATTRIBUTES WITH CORES AND DURABILITY SUPPLIED
    /*******************************************************************************/
}