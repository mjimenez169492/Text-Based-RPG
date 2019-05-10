package Generic_Character;

/*
    TotalAttributesAndResistances concerns "getTotal_" methods where "_" is 
    a stand-in for almost every attribute/resistence tied to a character. A
    "getTotal_" calculates the total value of a stat (where stat is defined
    as a part of a collective known as stats (which itself is comprised of 
    attributes/resistances)) with equipped outfits, their cores, stress and
    status effects involving the particular stat taken into account. 
*/

public class TotalAttributesAndResistances extends EquippableOutfits
{   
    // START: RETURN TOTAL ATTRIBUTES 
    /*******************************************************************************/

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

    public double getTotalAttribute(double attributeValueWithOutfits, String attributeName)
    {
        // validation must be performed before stress penalty can be applied to ensure 
        // that a value meant to be retrieved has stress penalty applied to it correctly
        return getStressPenalty(validateTotalAttribute(attributeValueWithOutfits + 
            (attributeValueWithOutfits * getEffectOfStatusEffects(attributeName))));	
    }
    
    public double getTotalMaxHealth()
    {
        return getTotalAttribute(getMaxHealthWithOutfits(), "Max Health");
    }
    
    public double getTotalMaxStamina()
    {
        return getTotalAttribute(getMaxStaminaWithOutfits(), "Max Stamina");
    }
    
    public double getTotalMaxNano()
    {
        return getTotalAttribute(getMaxNanoWithOutfits(), "Max Nano");
    }
    
    public double getTotalAttack()
    {
        return getTotalAttribute(getAttackWithOutfits(), "Attack");
    }

    public double getTotalDefense()
    {
        return getTotalAttribute(getDefenseWithOutfits(), "Defense");
    }

    public double getTotalDexterity()
    {
        return getTotalAttribute(getDexterityWithOutfits(), "Dexterity");
    }

    public double getTotalCritical()
    {
        return getTotalAttribute(getCriticalWithOutfits(), "Critical");
    }

    public double getTotalAccuracy()
    {
        return getTotalAttribute(getAccuracyWithOutfits(), "Accuracy");
    }

    public double getTotalNanoAttack()
    {
        return getTotalAttribute(getNanoAttackWithOutfits(), "Nano Attack");
    }

    public double getTotalNanoDefense()
    {
        return getTotalAttribute(getNanoDefenseWithOutfits(), "Nano Defense");
    }
    
    public Object[] getAllTotalAttributesWithNames()
    {
        Object[] array = {"Max Health", getTotalMaxHealth(), "Max Stamina", 
            getTotalMaxStamina(), "Max Nano", getTotalMaxNano(), "Defense", 
            getTotalDefense(), "Dexterity", getTotalDexterity(), "Nano Defense",
            getTotalNanoDefense()};
                return array;
    }

    // END: RETURN TOTAL ATTRIBUTES 
    /*******************************************************************************/
    
    
    
    // START: RETURN TOTAL RESISTANCES
    /*******************************************************************************/

    public double getTotalResistance(double resistanceValueWithOutfits, String resistanceName)
    {
        // validation must be performed before stress penalty can be applied to ensure 
        // that a value meant to be retrieved has stress penalty applied to it correctly
        return getStressPenalty(validateResistance(resistanceValueWithOutfits + 
            getEffectOfStatusEffects(resistanceName)));	
    }

    // START: ENCHANTMENT RELATED
    /*----------------------------------------------------------------------------*/

    public double getTotalFireResistance()
    {
        return getTotalResistance(getFireResistanceWithOutfits(), "Fire");
    }

    public double getTotalWaterResistance()
    {
        return getTotalResistance(getWaterResistanceWithOutfits(), "Water");	
    }

    public double getTotalIceResistance()
    {
        return getTotalResistance(getIceResistanceWithOutfits(), "Ice");	
    }

    public double getTotalElectricityResistance()
    {
        return getTotalResistance(getElectricityResistanceWithOutfits(), "Electricity");	
    }

    public double getTotalPoisonResistance()
    {
        return getTotalResistance(getPoisonResistanceWithOutfits(), "Poison");	
    }

    public double getTotalSonicResistance()
    {
        return getTotalResistance(getSonicResistanceWithOutfits(), "Sonic");	
    }

    public double getTotalPlasmaResistance()
    {
        return getTotalResistance(getPlasmaResistanceWithOutfits(), "Plasma");	
    }

    public double getTotalWindResistance()
    {
        return getTotalResistance(getWindResistanceWithOutfits(), "Wind");	
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
        return getTotalResistance(getDryResistanceWithOutfits(), "Dry");	
    }

    public double getTotalWetResistance()
    {
        return getTotalResistance(getWetResistanceWithOutfits(), "Wet");	
    }

    public double getTotalColdResistance()
    {
        return getTotalResistance(getColdResistanceWithOutfits(), "Cold");	
    }

    public double getTotalConductiveResistance()
    {
        return getTotalResistance(getConductiveResistanceWithOutfits(), "Conductive");	
    }

    public double getTotalSicknessResistance()
    {
        return getTotalResistance(getSicknessResistanceWithOutfits(), "Sickness");	
    }

    public double getTotalHypersensitiveResistance()
    {
        return getTotalResistance(getHypersensitiveResistanceWithOutfits(), "Hypersensitive");	
    }

    public double getTotalCoatedResistance()
    {
        return getTotalResistance(getCoatedResistanceWithOutfits(), "Coated");	
    }

    public double getTotalLightweightResistance()
    {
        return getTotalResistance(getLightweightResistanceWithOutfits(), "Lightweight");	
    }

    public double getTotalIrradiatedResistance()
    {
        return getTotalResistance(getIrradiatedResistanceWithOutfits(), "Irradiated");	
    }

    public Object[] getAllTotalUniqueStatusEffectResistancesWithNames()
    {
        Object[] array = {"Dry", getTotalMaxHealth(), "Wet", getTotalWetResistance(), 
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
        return getTotalResistance(getAblazeResistanceWithOutfits(), "Ablaze");	
    }

    public double getTotalBleedResistance()
    {
        return getTotalResistance(getBleedResistanceWithOutfits(), "Bleed");	
    }

    public double getTotalToxicResistance()
    {
        return getTotalResistance(getToxicResistanceWithOutfits(), "Toxic");	
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
        return getTotalResistance(getAttackDownResistanceWithOutfits(), "Attack Down");	
    }

    public double getTotalDefenseDownResistance()
    {
        return getTotalResistance(getDefenseDownResistanceWithOutfits(), "Defense Down");	
    }

    public double getTotalShutdownResistance()
    {
        return getTotalResistance(getShutdownResistanceWithOutfits(), "Shutdown");	
    }

    public double getTotalDexterityDownResistance()
    {
        return getTotalResistance(getDexterityDownResistanceWithOutfits(), "Dexterity Down");	
    }

    public double getTotalCriticalDownResistance()
    {
        return getTotalResistance(getCriticalDownResistanceWithOutfits(), "Critical Down");	
    }

    public double getTotalAccuracyDownResistance()
    {
        return getTotalResistance(getAccuracyDownResistanceWithOutfits(), "Accuracy Down");	
    }

    public double getTotalBlindResistance()
    {
        return getTotalResistance(getBlindResistanceWithOutfits(), "Blind");	
    }

    public double getTotalDarknessResistance()
    {
        return getTotalResistance(getDarknessResistanceWithOutfits(), "Darkness");	
    }

    public double getTotalNanoAttackDownResistance()
    {
        return getTotalResistance(getNanoAttackDownResistanceWithOutfits(), "Nano Attack Down");	
    }

    public double getTotalNanoDefenseDownResistance()
    {
        return getTotalResistance(getNanoDefenseDownResistanceWithOutfits(), "Nano Defense Dow");	
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
        return getTotalResistance(getConfusedResistanceWithOutfits(), "Confused");	
    }

    public double getTotalEnamoredResistance()
    {
        return getTotalResistance(getEnamoredResistanceWithOutfits(), "Enamored");	
    }

    public double getTotalBerserkResistance()
    {
        return getTotalResistance(getBerserkResistanceWithOutfits(), "Berserk");	
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
        return getTotalResistance(getFlinchedResistanceWithOutfits(), "Flinched");	
    }

    public double getTotalStunnedResistance()
    {
        return getTotalResistance(getStunnedResistanceWithOutfits(), "Stunned");	
    }

    public double getTotalScaredResistance()
    {
        return getTotalResistance(getScaredResistanceWithOutfits(), "Scared");	
    }

    public double getTotalBoundResistance()
    {
        return getTotalResistance(getBoundResistanceWithOutfits(), "Bound");	
    }

    public double getTotalSleepResistance()
    {
        return getTotalResistance(getSleepResistanceWithOutfits(), "Sleep");	
    }

    public double getTotalTrancedResistance()
    {
        return getTotalResistance(getTrancedResistanceWithOutfits(), "Tranced");	
    }

    public double getTotalShockedResistance()
    {
        return getTotalResistance(getShockedResistanceWithOutfits(), "Shocked");	
    }

    public double getTotalSlowedResistance()
    {
        return getTotalResistance(getSlowedResistanceWithOutfits(), "Slowed");	
    }

    public double getTotalStoppedResistance()
    {
        return getTotalResistance(getStoppedResistanceWithOutfits(), "Stopped");	
    }

    public double getTotalNullifyPositiveEffectsResistance()
    {
        return getTotalResistance(getNullifyPositiveEffectsResistanceWithOutfits(), "Nullify Positive Effects");	
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
    
    
    // START: NULLIFY STATUS EFFECTS BASED 
    
    public Object[] getAllTotalNullifyStatusEffectResistancesWithNames()
    {
        Object[] array = {"Nullify Status Effects", getTotalNullifyPositiveEffectsResistance()};
            return array;
    }
    
    // END: NULLIFY STATUS EFFECTS BASED 

    // END: STATUS EFFECT RELATED
    /*----------------------------------------------------------------------------*/

    // END: RETURN TOTAL RESISTANCES
    /*******************************************************************************/			
}