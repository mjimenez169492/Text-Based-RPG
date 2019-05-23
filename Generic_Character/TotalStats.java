package Generic_Character;

import Commonly_Used_Methods.StaticMethods;
import java.util.ArrayList;

/*
    TotalStats concerns "getTotal_" methods where "_" stands for almost every 
    attribute/resistence tied to a GenericCharacter object. 
*/

public class TotalStats
{   
    // holding objects from other classes 
    private StatusEffectContainer statusEffectContainer;
    private EquippableOutfits equippableOutfits;
    
    public TotalStats(StatusEffectContainer statusEffectContainer, 
        EquippableOutfits equippableOutfits)
    {
        this.statusEffectContainer = statusEffectContainer;
        this.equippableOutfits = equippableOutfits;
    }
    
    
    
    // START: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/

    public StatusEffectContainer getStatusEffectContainer()
    {
        return statusEffectContainer;
    }
    
    public EquippableOutfits getEquippableOutfits()
    {
        return equippableOutfits;
    }
    
    // END: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/

    
    
    // START: RETURN TOTAL ATTRIBUTES 
    /*******************************************************************************/

    // MAX GAUGES
    
    public double validateTotalAttribute(double attribute)
    {
        if(attribute < 0) 
        {
            attribute = 0; 
        }
        else if(attribute > 9999)
        {
            attribute = 9999;
        }

        return attribute;
    }

    public double getTotalMaxGauge(double attributeWithOutfits, String attributeName)
    {
        // validation must be performed before stress penalty can be applied to ensure 
        // that a value meant to be retrieved has stress penalty applied to it correctly
        double attribute = validateTotalAttribute(attributeWithOutfits + (attributeWithOutfits 
            * getStatusEffectContainer().sumOfEffects(attributeName)));
        
        return attribute;	
    }
    
    public double getTotalMaxHealth()
    {
        return getTotalMaxGauge(getEquippableOutfits().getMaxHealthWithOutfits(), "Max Health");
    }
    
    public double getTotalMaxStamina()
    {
        return getTotalMaxGauge(getEquippableOutfits().getMaxStaminaWithOutfits(), "Max Stamina");
    }
    
    public double getTotalMaxNano()
    {
        return getTotalMaxGauge(getEquippableOutfits().getMaxNanoWithOutfits(), "Max Nano");
    }
    
    // MAX GAUGES
    
    
    // ATTRIBUTES
    
    public double getTotalAttribute(double attributeWithOutfits, String attributeName)
    {
        // validation must be performed before stress penalty can be applied to ensure 
        // that a value meant to be retrieved has stress penalty applied to it correctly
        double attribute = validateTotalAttribute(attributeWithOutfits + (attributeWithOutfits 
            * getStatusEffectContainer().sumOfEffects(attributeName)));
        
        return attribute;	
    }
    
    public double getTotalAttack()
    {
        return getTotalAttribute(getEquippableOutfits().getAttackWithOutfits(), "Attack");
    }

    public double getTotalDefense()
    {
        return getTotalAttribute(getEquippableOutfits().getDefenseWithOutfits(), "Defense");
    }

    public double getTotalDexterity()
    {
        return getTotalAttribute(getEquippableOutfits().getDexterityWithOutfits(), "Dexterity");
    }

    public double getTotalCritical()
    {
        return getTotalAttribute(getEquippableOutfits().getCriticalWithOutfits(), "Critical");
    }

    public double getTotalAccuracy()
    {
        return getTotalAttribute(getEquippableOutfits().getAccuracyWithOutfits(), "Accuracy");
    }

    public double getTotalNanoAttack()
    {
        return getTotalAttribute(getEquippableOutfits().getNanoAttackWithOutfits(), "Nano Attack");
    }

    public double getTotalNanoDefense()
    {
        return getTotalAttribute(getEquippableOutfits().getNanoDefenseWithOutfits(), "Nano Defense");
    }
    
    // ATTRIBUTES

    // END: RETURN TOTAL ATTRIBUTES 
    /*******************************************************************************/
    
    
    
    // START: RETURN TOTAL RESISTANCES
    /*******************************************************************************/

    public double validateResistance(double resistance)
    {
        if(resistance < -100) 
        {
            resistance = -100; 
        }
        else if(resistance > 100)
        {
            resistance = 100;
        }

        return resistance;
    }
    
    public double getTotalResistance(double resistanceWithOutfits, String resistanceName)
    {
        // validation must be performed before stress penalty can be applied to ensure 
        // that a value meant to be retrieved has stress penalty applied to it correctly
        double resistance = validateResistance(resistanceWithOutfits + getStatusEffectContainer().sumOfEffects(resistanceName));
            return resistance;	
    }

    // START: ENCHANTMENT RELATED
    /*----------------------------------------------------------------------------*/

    public double getTotalFireResistance()
    {
        return getTotalResistance(getEquippableOutfits().getFireResistanceWithOutfits(), "Fire");
    }

    public double getTotalWaterResistance()
    {
        return getTotalResistance(getEquippableOutfits().getWaterResistanceWithOutfits(), "Water");	
    }

    public double getTotalIceResistance()
    {
        return getTotalResistance(getEquippableOutfits().getIceResistanceWithOutfits(), "Ice");	
    }

    public double getTotalElectricityResistance()
    {
        return getTotalResistance(getEquippableOutfits().getElectricityResistanceWithOutfits(), "Electricity");	
    }

    public double getTotalPoisonResistance()
    {
        return getTotalResistance(getEquippableOutfits().getPoisonResistanceWithOutfits(), "Poison");	
    }

    public double getTotalSonicResistance()
    {
        return getTotalResistance(getEquippableOutfits().getSonicResistanceWithOutfits(), "Sonic");	
    }

    public double getTotalPlasmaResistance()
    {
        return getTotalResistance(getEquippableOutfits().getPlasmaResistanceWithOutfits(), "Plasma");	
    }

    public double getTotalWindResistance()
    {
        return getTotalResistance(getEquippableOutfits().getWindResistanceWithOutfits(), "Wind");	
    }
    
    public Object[] getAllTotalEnchantmentResistancesWithNames()
    {
        Object[] array = {"Fire", getTotalFireResistance(), "Water", getTotalWaterResistance(), 
            "Ice", getTotalIceResistance(), "Electricity", getTotalElectricityResistance(), 
            "Poison", getTotalPoisonResistance(), "Sonic", getTotalSonicResistance(), "Plasma", 
            getTotalPlasmaResistance(), "Wind", getTotalWindResistance()};
                return array;
    }

    // END: ENCHANTMENT RELATED
    /*----------------------------------------------------------------------------*/


    // START: STATUS EFFECT RELATED
    /*----------------------------------------------------------------------------*/

    // START: UNIQUE 

    public double getTotalDryResistance()
    {
        return getTotalResistance(getEquippableOutfits().getDryResistanceWithOutfits(), "Dry");	
    }

    public double getTotalWetResistance()
    {
        return getTotalResistance(getEquippableOutfits().getWetResistanceWithOutfits(), "Wet");	
    }

    public double getTotalColdResistance()
    {
        return getTotalResistance(getEquippableOutfits().getColdResistanceWithOutfits(), "Cold");	
    }

    public double getTotalConductiveResistance()
    {
        return getTotalResistance(getEquippableOutfits().getConductiveResistanceWithOutfits(), "Conductive");	
    }

    public double getTotalSicknessResistance()
    {
        return getTotalResistance(getEquippableOutfits().getSicknessResistanceWithOutfits(), "Sickness");	
    }

    public double getTotalHypersensitiveResistance()
    {
        return getTotalResistance(getEquippableOutfits().getHypersensitiveResistanceWithOutfits(), "Hypersensitive");	
    }

    public double getTotalCoatedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getCoatedResistanceWithOutfits(), "Coated");	
    }

    public double getTotalLightweightResistance()
    {
        return getTotalResistance(getEquippableOutfits().getLightweightResistanceWithOutfits(), "Lightweight");	
    }

    public double getTotalIrradiatedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getIrradiatedResistanceWithOutfits(), "Irradiated");	
    }

    public Object[] getAllTotalUniqueStatusEffectResistancesWithNames()
    {
        Object[] array = {"Dry", getTotalDryResistance(), "Wet", getTotalWetResistance(), 
            "Cold", getTotalColdResistance(), "Conductive", getTotalConductiveResistance(),
            "Sickness", getTotalSicknessResistance(),"Hypersensitive", getTotalHypersensitiveResistance(),
            "Coated", getTotalCoatedResistance(), "Lightweight", getTotalLightweightResistance(),
            "Irradiated", getTotalIrradiatedResistance()};
                return array;
    }
    
    // END: UNIQUE 


    // START: CURRENT HEALTH BASED 

    public double getTotalAblazeResistance()
    {
        return getTotalResistance(getEquippableOutfits().getAblazeResistanceWithOutfits(), "Ablaze");	
    }

    public double getTotalBleedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getBleedResistanceWithOutfits(), "Bleed");	
    }

    public double getTotalToxicResistance()
    {
        return getTotalResistance(getEquippableOutfits().getToxicResistanceWithOutfits(), "Toxic");	
    }
    
    public Object[] getAllTotalCurrentHealthStatusEffectResistancesWithNames()
    {
        Object[] array = {"Ablaze", getTotalAblazeResistance(), "Bleed", getTotalBleedResistance(), 
            "Toxic", getTotalToxicResistance()};
                return array;
    }

    // END: CURRENT HEALTH BASED 


    // START: ATTRIBUTE BASED 

    public double getTotalAttackDownResistance()
    {
        return getTotalResistance(getEquippableOutfits().getAttackDownResistanceWithOutfits(), "Attack Down");	
    }

    public double getTotalDefenseDownResistance()
    {
        return getTotalResistance(getEquippableOutfits().getDefenseDownResistanceWithOutfits(), "Defense Down");	
    }

    public double getTotalShutdownResistance()
    {
        return getTotalResistance(getEquippableOutfits().getShutdownResistanceWithOutfits(), "Shutdown");	
    }

    public double getTotalDexterityDownResistance()
    {
        return getTotalResistance(getEquippableOutfits().getDexterityDownResistanceWithOutfits(), "Dexterity Down");	
    }

    public double getTotalCriticalDownResistance()
    {
        return getTotalResistance(getEquippableOutfits().getCriticalDownResistanceWithOutfits(), "Critical Down");	
    }

    public double getTotalAccuracyDownResistance()
    {
        return getTotalResistance(getEquippableOutfits().getAccuracyDownResistanceWithOutfits(), "Accuracy Down");	
    }

    public double getTotalBlindResistance()
    {
        return getTotalResistance(getEquippableOutfits().getBlindResistanceWithOutfits(), "Blind");	
    }

    public double getTotalDarknessResistance()
    {
        return getTotalResistance(getEquippableOutfits().getDarknessResistanceWithOutfits(), "Darkness");	
    }

    public double getTotalNanoAttackDownResistance()
    {
        return getTotalResistance(getEquippableOutfits().getNanoAttackDownResistanceWithOutfits(), "Nano Attack Down");	
    }

    public double getTotalNanoDefenseDownResistance()
    {
        return getTotalResistance(getEquippableOutfits().getNanoDefenseDownResistanceWithOutfits(), "Nano Defense Dow");	
    }
    
    public Object[] getAllTotalAttributeStatusEffectResistancesWithNames()
    {
        Object[] array = {"Attack Down", getTotalAttackDownResistance(), "Defense Down", getTotalDefenseDownResistance(), 
            "Shutdown", getTotalShutdownResistance(), "Dexterity Down", getTotalDexterityDownResistance(),
            "Critical Down", getTotalCriticalDownResistance(),"Accuracy Down", getTotalAccuracyDownResistance(),
            "Blind", getTotalBlindResistance(), "Nano Attack Down", getTotalNanoAttackDownResistance(),
            "Nano Defense Down", getTotalNanoDefenseDownResistance()};
                return array;
    }
    
    // END: ATTRIBUTE BASED 


    // START: BEHAVIOR BASED 

    public double getTotalConfusedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getConfusedResistanceWithOutfits(), "Confused");	
    }

    public double getTotalEnamoredResistance()
    {
        return getTotalResistance(getEquippableOutfits().getEnamoredResistanceWithOutfits(), "Enamored");	
    }

    public double getTotalBerserkResistance()
    {
        return getTotalResistance(getEquippableOutfits().getBerserkResistanceWithOutfits(), "Berserk");	
    }
    
    public Object[] getAllTotalBehaviorStatusEffectResistancesWithNames()
    {
        Object[] array = {"Confused", getTotalConfusedResistance(), "Enamored", getTotalEnamoredResistance(), 
            "Berserk", getTotalBerserkResistance()};
                return array;
    }

    // END: BEHAVIOR BASED 


    // START: TURN BEHAVIOR BASED 

    public double getTotalFlinchedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getFlinchedResistanceWithOutfits(), "Flinched");	
    }

    public double getTotalStunnedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getStunnedResistanceWithOutfits(), "Stunned");	
    }

    public double getTotalScaredResistance()
    {
        return getTotalResistance(getEquippableOutfits().getScaredResistanceWithOutfits(), "Scared");	
    }

    public double getTotalBoundResistance()
    {
        return getTotalResistance(getEquippableOutfits().getBoundResistanceWithOutfits(), "Bound");	
    }

    public double getTotalSleepResistance()
    {
        return getTotalResistance(getEquippableOutfits().getSleepResistanceWithOutfits(), "Sleep");	
    }

    public double getTotalTrancedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getTrancedResistanceWithOutfits(), "Tranced");	
    }

    public double getTotalShockedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getShockedResistanceWithOutfits(), "Shocked");	
    }

    public double getTotalSlowedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getSlowedResistanceWithOutfits(), "Slowed");	
    }

    public double getTotalStoppedResistance()
    {
        return getTotalResistance(getEquippableOutfits().getStoppedResistanceWithOutfits(), "Stopped");	
    }

    public Object[] getAllTotalTurnBehaviorStatusEffectResistancesWithNames()
    {
        Object[] array = {"Flinched", getTotalFlinchedResistance(), "Stunned", getTotalStunnedResistance(), 
            "Scared", getTotalScaredResistance(), "Bound", getTotalBoundResistance(),
            "Sleep", getTotalSleepResistance(),"Tranced", getTotalTrancedResistance(),
            "Shocked", getTotalShockedResistance(), "Slowed", getTotalSlowedResistance(),
            "Stopped", getTotalStoppedResistance()};
                return array;
    }

    // END: TURN BEHAVIOR BASED 

    // END: STATUS EFFECT RELATED
    /*----------------------------------------------------------------------------*/

    // END: RETURN TOTAL RESISTANCES
    /*******************************************************************************/			

    
    
    // START: STORING AND RETRIEVING TOTAL ATTRIBUTES 
    /*******************************************************************************/
        
    /*
    public Object[] getAllTotalAttributesWithNames()
    {
        Object[] array = {"Max Health", getTotalMaxHealth(), "Max Stamina", 
            getTotalMaxStamina(), "Max Nano", getTotalMaxNano(), "Defense", 
            getTotalDefense(), "Dexterity", getTotalDexterity(), "Nano Defense",
            getTotalNanoDefense()};
                return array;
    }
    */
    
    public Object[] getAllTotalAttributesWithNames()
    {
        Object[] characterAttributes = {"Max Health", getTotalMaxHealth(), "Max Stamina", 
            getTotalMaxStamina(), "Max Nano", getTotalMaxNano(), "Attack", getTotalAttack(), 
            "Defense", getTotalDefense(), "Dexterity", getTotalDexterity(), "Critical", 
            getTotalCritical(), "Accuracy", getTotalAccuracy(), "Nano Attack", getTotalNanoAttack(), 
            "Nano Defense", getTotalNanoDefense()};
                return characterAttributes;
    }
    
    // END: STORING AND RETRIEVING TOTAL ATTRIBUTES 
    /*******************************************************************************/

    
    
    // START: STORING AND RETRIEVING TOTAL ENCHANTMENTS 
    /*******************************************************************************/
    
    public double getEnchantmentResistanceValueForKey(String key)
    {
        double result = 0;
        
        Object[] array = {getAllTotalEnchantmentResistancesWithNames()};
        
        for(int i = 0; i < array.length; i+=2)
        {
            if(StaticMethods.getEnchantmentEnum(key) != StaticMethods.Enchantments.NONE)
            {
                result = (double)array[i+1];
            }
        }
        
        return result;
    }
    
    // END: STORING AND RETRIEVING TOTAL ENCHANTMENTS 
    /*******************************************************************************/

    
    
    // START: STORING AND RETRIEVING TOTAL RESISTANCES 
    /*******************************************************************************/
    
    public Object[][] getArrayContainingResistances()
    {
        Object[] arrayOfArrays [] = {
            getAllTotalUniqueStatusEffectResistancesWithNames(),
            getAllTotalCurrentHealthStatusEffectResistancesWithNames(),
            getAllTotalAttributeStatusEffectResistancesWithNames(),
            getAllTotalBehaviorStatusEffectResistancesWithNames(),
            getAllTotalTurnBehaviorStatusEffectResistancesWithNames()};
                return arrayOfArrays;
    }
    
    public ArrayList<Object> getAllTotalStatusEffectResistances()
    {
        ArrayList<Object> arrayList = new ArrayList<>();

        for(Object[] arrayWithinArray : getArrayContainingResistances())
        {
            for(Object element : arrayWithinArray)
            {
                arrayList.add(element);
            }
        }
        
        return arrayList;
    }
    
    public double getTotalStatusResistanceForKey(String key)
    {
        double result = 0.0;
        
        ArrayList<Object> arrayList = getAllTotalStatusEffectResistances();
        
        for(int i = 0; i < getAllTotalStatusEffectResistances().size(); i += 2)
        {
            if(key.equals((String)arrayList.get(i)))
            {
                result = (double)arrayList.get(i + 1);
            }
        }
        
        return result;
    }

    // END: STORING AND RETRIEVING TOTAL ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/
}
