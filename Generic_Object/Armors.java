package Generic_Object;

/*
    Armors extends OutfitMethods meaning that Armors is a subclass of superclass 
    OutfitMethods. Armors defines methods relating to armor creation. 
*/

import Generic_Object.OutfitMethods;
import Universally_Used_Methods.StaticMethods;
import java.util.ArrayList;
import java.util.HashMap;

public class Armors extends OutfitMethods
{
    // attributes which armor can affect once it is equipped
    private double maxHealth, maxStamina, maxNano, defense, dexterity, nanoDefense;					

    // enchantment related resistances (as in they reduce damage received from attacks of that resistance type)
    private double fireResistance, waterResistance, iceResistance, electricityResistance, 
        poisonResistance, sonicResistance, plasmaResistance, windResistance;

    // status effect related resistances (as in ability to resist/negate status effects)
    private double dryResistance, wetResistance, coldResistance, conductiveResistance, 
        sicknessResistance, hypersensitiveResistance, coatedResistance, lightweightResistance, 
        irradiatedResistance;				

    private double ablazeResistance, bleedResistance, toxicResistance;						

    private double attackDownResistance, defenseDownResistance, shutdownResistance, 
        dexterityDownResistance, criticalDownResistance, accuracyDownResistance, 
        blindResistance, darknessResistance, nanoAttackDownResistance, nanoDefenseDownResistance;			

    private double confusedResistance, enamoredResistance, berserkResistance;					

    private double flinchedResistance, stunnedResistance, scaredResistance, boundResistance, 
        sleepResistance, trancedResistance, shockedResistance, slowedResistance, stoppedResistance, 
        nullifyStatusEffectsResistance;
    
    // HashMap containing all attributes and resistances tied to Armors object 
    private final HashMap<String, Double> attributesAndResistancesHashMap = 
        new HashMap<String, Double>();
    
    // holds armor rating assigned to a piece of armor
    private String armorPiercingResistance;
    
    // subclass constructor with method(s) invoked upon object creation 
    public Armors()
    {
        // need to set subclass name to enable slot/core equip feature for object 
        setSubclassName("Armors");
    }



    // START: ARMOR ATTRIBUTES
    /*******************************************************************************/

    public double validateAttribute(double attribute)
    {
        if(attribute < -125)
        {
            attribute = -125;
        }
        else if(attribute > 125)
        {
            attribute = 125;
        }

        return attribute;
    }

    public void setMaxHealth(double maxHealth)
    {
        this.maxHealth = validateAttribute(maxHealth);
    }

    public double getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxStamina(double maxStamina)
    {
        this.maxStamina = validateAttribute(maxStamina);
    }

    public double getMaxStamina()
    {
        return maxStamina;
    }
    
    public void setMaxNano(double maxNano)
    {
        this.maxNano = validateAttribute(maxNano);
    }

    public double getMaxNano()
    {
        return maxNano;
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

    public void setNanoDefense(double nanoDefense)
    {
        this.nanoDefense = validateAttribute(nanoDefense);
    }

    public double getNanoDefense()
    {
        return nanoDefense;
    }

    // END: ARMOR ATTRIBUTES
    /*******************************************************************************/



    // START: ARMOR RESISTANTCES 
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

        return Math.floor(resistance);
    }

    // START: DAMAGE RELATED

    public void setFireResistance(double fireResistance)
    {
        this.fireResistance = validateResistance(fireResistance);
    }

    public double getFireResistance()
    {
        return fireResistance;
    }

    public void setWaterResistance(double waterResistance)
    {
        this.waterResistance = validateResistance(waterResistance);
    }

    public double getWaterResistance()
    {
        return waterResistance;
    }

    public void setIceResistance(double iceResistance)
    {
        this.iceResistance = validateResistance(iceResistance);
    }

    public double getIceResistance()
    {
        return iceResistance;
    }

    public void setElectricityResistance(double electricityResistance)
    {
        this.electricityResistance = validateResistance(electricityResistance);
    }

    public double getElectricityResistance()
    {
        return electricityResistance;
    }

    public void setPoisonResistance(double poisonResistance)
    {
        this.poisonResistance = validateResistance(poisonResistance);
    }

    public double getPoisonResistance()
    {
        return poisonResistance;
    }

    public void setSonicResistance(double sonicResistance)
    {
        this.sonicResistance = validateResistance(sonicResistance);
    }

    public double getSonicResistance()
    {
        return sonicResistance;
    }

    public void setPlasmaResistance(double plasmaResistance)
    {
        this.plasmaResistance = validateResistance(plasmaResistance);
    }

    public double getPlasmaResistance()
    {
        return plasmaResistance;
    }

    public void setWindResistance(double windResistance)
    {
        this.windResistance = validateResistance(windResistance);
    }

    public double getWindResistance()
    {
        return windResistance;
    }

    // END: DAMAGE RELATED



    // START: STATUS EFFECT RELATED

    // START: UNIQUE 

    public void setDryResistance(double dryResistance)
    {
        this.dryResistance = validateResistance(dryResistance);
    }

    public double getDryResistance()
    {
        return dryResistance;
    }

    public void setWetResistance(double wetResistance)
    {
        this.wetResistance = validateResistance(wetResistance);
    }

    public double getWetResistance()
    {
        return wetResistance;
    }

    public void setColdResistance(double coldResistance)
    {
        this.coldResistance = validateResistance(coldResistance);
    }

    public double getColdResistance()
    {
        return coldResistance;
    }

    public void setConductiveResistance(double conductiveResistance)
    {
        this.conductiveResistance = validateResistance(conductiveResistance);
    }

    public double getConductiveResistance()
    {
        return conductiveResistance;
    }

    public void setSicknessResistance(double sicknessResistance)
    {
        this.sicknessResistance = validateResistance(sicknessResistance);
    }

    public double getSicknessResistance()
    {
        return sicknessResistance;
    }

    public void setHypersensitiveResistance(double hypersensitiveResistance)
    {
        this.hypersensitiveResistance = validateResistance(hypersensitiveResistance);
    }

    public double getHypersensitiveResistance()
    {
        return hypersensitiveResistance;
    }

    public void setCoatedResistance(double coatedResistance)
    {
        this.coatedResistance = validateResistance(coatedResistance);
    }

    public double getCoatedResistance()
    {
        return coatedResistance;
    }

    public void setLightweightResistance(double lightweightResistance)
    {
        this.lightweightResistance = validateResistance(lightweightResistance);
    }

    public double getLightweightResistance()
    {
        return lightweightResistance;
    }

    public void setIrradiatedResistance(double irradiatedResistance)
    {
        this.irradiatedResistance = validateResistance(irradiatedResistance);
    }

    public double getIrradiatedResistance()
    {
        return irradiatedResistance;
    }

    // END: UNIQUE 


    // START: CURRENT HP BASED 

    public void setAblazeResistance(double ablazeResistance)
    {
        this.ablazeResistance = validateResistance(ablazeResistance);
    }

    public double getAblazeResistance()
    {
        return ablazeResistance;
    }

    public void setBleedResistance(double bleedResistance)
    {
        this.bleedResistance = validateResistance(bleedResistance);
    }

    public double getBleedResistance()
    {
        return bleedResistance;
    }

    public void setToxicResistance(double toxicResistance)
    {
        this.toxicResistance = validateResistance(toxicResistance);
    }

    public double getToxicResistance()
    {
        return toxicResistance;
    }

    // END: CURRENT HP BASED 


    // START: ATTRIBUTE BASED 

    public void setAttackDownResistance(double attackDownResistance)
    {
        this.attackDownResistance = validateResistance(attackDownResistance);
    }

    public double getAttackDownResistance()
    {
        return attackDownResistance;
    }

    public void setDefenseDownResistance(double defenseDownResistance)
    {
        this.defenseDownResistance = validateResistance(defenseDownResistance);
    }

    public double getDefenseDownResistance()
    {
        return defenseDownResistance;
    }

    public void setShutdownResistance(double shutdownResistance)
    {
            this.shutdownResistance = validateResistance(shutdownResistance);
    }

    public double getShutdownResistance()
    {
        return shutdownResistance;
    }

    public void setDexterityDownResistance(double dexterityDownResistance)
    {
        this.dexterityDownResistance = validateResistance(dexterityDownResistance);
    }

    public double getDexterityDownResistance()
    {
        return dexterityDownResistance;
    }

    public void setCriticalDownResistance(double criticalDownResistance)
    {
        this.criticalDownResistance = validateResistance(criticalDownResistance);
    }

    public double getCriticalDownResistance()
    {
        return criticalDownResistance;
    }

    public void setAccuracyDownResistance(double accuracyDownResistance)
    {
        this.accuracyDownResistance = validateResistance(accuracyDownResistance);
    }

    public double getAccuracyDownResistance()
    {
        return accuracyDownResistance;
    }

    public void setBlindResistance(double blindResistance)
    {
        this.blindResistance = validateResistance(blindResistance);
    }

    public double getBlindResistance()
    {
        return blindResistance;
    }

    public void setDarknessResistance(double darknessResistance)
    {
        this.darknessResistance = validateResistance(darknessResistance);
    }

    public double getDarknessResistance()
    {
        return darknessResistance;
    }

    public void setNanoAttackDownResistance(double nanoAttackDownResistance)
    {
        this.nanoAttackDownResistance = validateResistance(nanoAttackDownResistance);
    }

    public double getNanoAttackDownResistance()
    {
        return nanoAttackDownResistance;
    }

    public void setNanoDefenseDownResistance(double nanoDefenseDownResistance)
    {
        this.nanoDefenseDownResistance = validateResistance(nanoDefenseDownResistance);
    }

    public double getNanoDefenseDownResistance()
    {
        return nanoDefenseDownResistance;
    }

    // END: ATTRIBUTE BASED 


    // START: BEHAVIOR BASED 

    public void setConfusedResistance(double confusedResistance)
    {
        this.confusedResistance = validateResistance(confusedResistance);
    }

    public double getConfusedResistance()
    {
        return confusedResistance;
    }

    public void setEnamoredResistance(double enamoredResistance)
    {
        this.enamoredResistance = validateResistance(enamoredResistance);
    }

    public double getEnamoredResistance()
    {
        return enamoredResistance;
    }

    public void setBerserkResistance(double berserkResistance)
    {
        this.berserkResistance = validateResistance(berserkResistance);
    }

    public double getBerserkResistance()
    {
        return berserkResistance;
    }

    // END: BEHAVIOR BASED 


    // START: TURN BEHAVIOR BASED 

    public void setFlinchedResistance(double flinchedResistance)
    {
        this.flinchedResistance = validateResistance(flinchedResistance);
    }

    public double getFlinchedResistance()
    {
        return flinchedResistance;
    }

    public void setStunnedResistance(double stunnedResistance)
    {
        this.stunnedResistance = validateResistance(stunnedResistance);
    }

    public double getStunnedResistance()
    {
        return stunnedResistance;
    }

    public void setScaredResistance(double scaredResistance)
    {
        this.scaredResistance = validateResistance(scaredResistance);
    }

    public double getScaredResistance()
    {
        return scaredResistance;
    }

    public void setBoundResistance(double boundResistance)
    {
        this.boundResistance = validateResistance(boundResistance);
    }

    public double getBoundResistance()
    {
        return boundResistance;
    }

    public void setSleepResistance(double sleepResistance)
    {
        this.sleepResistance = validateResistance(sleepResistance);
    }

    public double getSleepResistance()
    {
        return sleepResistance;
    }

    public void setTrancedResistance(double trancedResistance)
    {
        this.trancedResistance = validateResistance(trancedResistance);
    }

    public double getTrancedResistance()
    {
        return trancedResistance;
    }

    public void setShockedResistance(double shockedResistance)
    {
        this.shockedResistance = validateResistance(shockedResistance);
    }

    public double getShockedResistance()
    {
        return shockedResistance;
    }

    public void setSlowedResistance(double slowedResistance)
    {
        this.slowedResistance = validateResistance(slowedResistance);
    }

    public double getSlowedResistance()
    {
        return slowedResistance;
    }

    public void setStoppedResistance(double stoppedResistance)
    {
        this.stoppedResistance = validateResistance(stoppedResistance);
    }

    public double getStoppedResistance()
    {
        return stoppedResistance;
    }

    public void setNullifyStatusEffectsResistance(double nullifyStatusEffectsResistance)
    {
        this.nullifyStatusEffectsResistance = validateResistance(nullifyStatusEffectsResistance);
    }

    public double getNullifyStatusEffectsResistance()
    {
        return nullifyStatusEffectsResistance;
    }

    // END: TURN BEHAVIOR BASED 

    // END: STATUS EFFECT RELATED

    // END: CHARACTER RESISTANTCES: STATUS EFFECT RELATED
    /*******************************************************************************/

    /*
        Note on "getTotal" methods below: 
            methods get total value for a object (like attack, nano, ect.) by adding 
            object's power and core points together only if the cores are the same 
            type as the String supplied as argument (if "Attack" is supplied then 
            add the current core points of the cores with core type "Attack") 
    */
    
    // START: TOTAL ARMOR ATTRIBUTES WITH CORES AND DURABILITY SUPPLIED
    /*******************************************************************************/

    public double getTotalMaxHealth()
    {
        return getTotalOutfitValue(getMaxHealth(), "Max Health");
    }
    
    public double getTotalMaxStamina()
    {
        return getTotalOutfitValue(getMaxStamina(), "Stamina");
    }
    
    public double getTotalMaxNano()
    {
        return getTotalOutfitValue(getMaxNano(), "Nano");
    }

    public double getTotalDefense()
    {
        return getTotalOutfitValue(getDefense(), "Defense");
    }

    public double getTotalDexterity()
    {
        return getTotalOutfitValue(getDexterity(), "Dexterity");
    }

    public double getTotalNanoDefense()
    {
        return getTotalOutfitValue(getNanoDefense(), "Nano Defense");
    }

    public Object[] getAllTotalAttributesWithNames()
    {
        Object[] array = {"Max Health", getTotalMaxHealth(), "Max Stamina", 
            getTotalMaxStamina(), "Max Nano", getTotalMaxNano(), "Defense", 
            getTotalDefense(), "Dexterity", getTotalDexterity(), "Nano Defense",
            getTotalNanoDefense()};
                return array;
    }
    
    // END: TOTAL ARMOR ATTRIBUTES WITH CORES AND DURABILITY SUPPLIED
    /*******************************************************************************/


    
    // START: TOTAL ARMOR RESISTANCES WITH CORES AND DURABILITY SUPPLIED
    /*******************************************************************************/

    // START: ENCHANTMENT RELATED

    public double getTotalFireResistance()
    {
        return getTotalOutfitValue(getFireResistance(), "Fire");
    }

    public double getTotalWaterResistance()
    {
        return getTotalOutfitValue(getWaterResistance(), "Water");
    }

    public double getTotalIceResistance()
    {
        return getTotalOutfitValue(getIceResistance(), "Ice");
    }

    public double getTotalElectricityResistance()
    {
        return getTotalOutfitValue(getElectricityResistance(), "Electricity");
    }

    public double getTotalPoisonResistance()
    {
        return getTotalOutfitValue(getPoisonResistance(), "Poison");
    }

    public double getTotalSonicResistance()
    {
        return getTotalOutfitValue(getSonicResistance(), "Sonic");
    }

    public double getTotalPlasmaResistance()
    {
        return getTotalOutfitValue(getPlasmaResistance(), "Plasma");
    }

    public double getTotalWindResistance()
    {
        return getTotalOutfitValue(getWindResistance(), "Wind");
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

    

    // START: STATUS EFFECT RELATED

    // START: UNIQUE 

    public double getTotalDryResistance()
    {
        return getTotalOutfitValue(getDryResistance(), "Dry");
    }

    public double getTotalWetResistance() 
    {
        return getTotalOutfitValue(getWetResistance(), "Wet");
    }

    public double getTotalColdResistance()
    {
        return getTotalOutfitValue(getColdResistance(), "Cold ");
    }

    public double getTotalConductiveResistance()
    {
        return getTotalOutfitValue(getConductiveResistance(), "Conductive");
    }

    public double getTotalSicknessResistance()
    {
        return getTotalOutfitValue(getSicknessResistance(), "Sickness");
    }

    public double getTotalHypersensitiveResistance()
    {
        return getTotalOutfitValue(getHypersensitiveResistance(), "Hypersensitive");
    }

    public double getTotalCoatedResistance()
    {
        return getTotalOutfitValue(getCoatedResistance(), "Coated");
    }

    public double getTotalLightweightResistance()
    {
        return getTotalOutfitValue(getLightweightResistance(), "Lightweight");
    }

    public double getTotalIrradiatedResistance()
    {
        return getTotalOutfitValue(getIrradiatedResistance(), "Irradiated");
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
        return getTotalOutfitValue(getAblazeResistance(), "Ablaze");
    }

    public double getTotalBleedResistance()
    {
        return getTotalOutfitValue(getBleedResistance(), "Bleed");
    }

    public double getTotalToxicResistance()
    {
        return getTotalOutfitValue(getToxicResistance(), "Toxic");
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
        return getTotalOutfitValue(getAttackDownResistance(), "Attack Down");
    }

    public double getTotalDefenseDownResistance()
    {
        return getTotalOutfitValue(getDefenseDownResistance(), "Defense Down");
    }

    public double getTotalShutdownResistance()
    {
        return getTotalOutfitValue(getShutdownResistance(), "Shutdown");
    }

    public double getTotalDexterityDownResistance()
    {
        return getTotalOutfitValue(getDexterityDownResistance(), "Dexterity Down");
    }

    public double getTotalCriticalDownResistance()
    {
        return getTotalOutfitValue(getCriticalDownResistance(), "Critical Down");
    }

    public double getTotalAccuracyDownResistance()
    {
        return getTotalOutfitValue(getAccuracyDownResistance(), "Accuracy Down");
    }

    public double getTotalBlindResistance()
    {
        return getTotalOutfitValue(getBleedResistance(), "Bleed");
    }

    public double getTotalDarknessResistance()
    {
        return getTotalOutfitValue(getDarknessResistance(), "Darkness");
    }

    public double getTotalNanoAttackDownResistance()
    {
        return getTotalOutfitValue(getNanoAttackDownResistance(), "Nano Attack Down");
    }

    public double getTotalNanoDefenseDownResistance()
    {
        return getTotalOutfitValue(getNanoDefenseDownResistance(), "Nano Defense Down");
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
        return getTotalOutfitValue(getConfusedResistance(), "Confused");
    }

    public double getTotalEnamoredResistance()
    {
        return getTotalOutfitValue(getEnamoredResistance(), "Enamored");
    }

    public double getTotalBerserkResistance()
    {
        return getTotalOutfitValue(getBerserkResistance(), "Berserk");
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
        return getTotalOutfitValue(getFlinchedResistance(), "Flinched");
    }

    public double getTotalStunnedResistance()
    {
        return getTotalOutfitValue(getStunnedResistance(), "Stunned");
    }

    public double getTotalScaredResistance()
    {
        return getTotalOutfitValue(getScaredResistance(), "Scared");
    }

    public double getTotalBoundResistance()
    {
        return getTotalOutfitValue(getBoundResistance(), "Bound");
    }

    public double getTotalSleepResistance()
    {
        return getTotalOutfitValue(getSleepResistance(), "Sleep");
    }

    public double getTotalTrancedResistance()
    {
        return getTotalOutfitValue(getTrancedResistance(), "Tranced");
    }

    public double getTotalShockedResistance()
    {
        return getTotalOutfitValue(getShockedResistance(), "Shocked");
    }

    public double getTotalSlowedResistance()
    {
        return getTotalOutfitValue(getSlowedResistance(), "Slowed");
    }

    public double getTotalStoppedResistance()
    {
        return getTotalOutfitValue(getStoppedResistance(), "Stopped");
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
    
    public double getTotalNullifyPositiveEffectsResistance()
    {
        return getTotalOutfitValue(getNullifyStatusEffectsResistance(), "Nullify Status Effects");
    }
    
    public Object[] getAllTotalNullifyStatusEffectResistancesWithNames()
    {
        Object[] array = {"Nullify Status Effects", getTotalNullifyPositiveEffectsResistance()};
            return array;
    }
    
    // END: NULLIFY STATUS EFFECTS BASED 
    
    // END: STATUS EFFECT RELATED
    
    // END: TOTAL ARMOR RESISTANCES WITH CORES AND DURABILITY SUPPLIED
    /*******************************************************************************/
    
    
    
    // START: STORING AND RETRIEVING OUTFIT ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/
    
    public Object[][] getArrayCotainingResistances()
    {
        Object[] arrayOfArrays [] = {getAllTotalEnchantmentResistancesWithNames(), 
            getAllTotalUniqueStatusEffectResistancesWithNames(),
            getAllTotalUniqueStatusEffectResistancesWithNames(),
            getAllTotalAttributeStatusEffectResistancesWithNames(),
            getAllTotalBehaviorStatusEffectResistancesWithNames(),
            getAllTotalTurnBehaviorStatusEffectResistancesWithNames(), 
            getAllTotalNullifyStatusEffectResistancesWithNames()};
                return arrayOfArrays;
    }
    
    public ArrayList<Object> getAttributesAndResistancesArrayList()
    {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for(Object[] arrayWithinArray : getArrayCotainingResistances())
        {
            for(Object element : arrayWithinArray)
            {
                arrayList.add(element);
            }
        }
        
        return arrayList;
    }
    
    public void addArrayListElementsToHashMap(ArrayList<Object> arrayList)
    {
        for(int i = 0; i < arrayList.size(); i+=2)
        {
            attributesAndResistancesHashMap.put((String)arrayList.get(i), 
                (Double)arrayList.get(i+1));
        }
    }
    
    public void alterValueForKey(String key, Double value)
    {
        attributesAndResistancesHashMap.put(key, value);
    }
    
    public void updateOutfitValues()
    {
        addArrayListElementsToHashMap(getAttributesAndResistancesArrayList());
    }
    
    public HashMap<String, Double> getHashMap()
    {
        return attributesAndResistancesHashMap;
    }
    
    public double getOutfitValueForKey(String resistance)
    {
        double holdDouble = 0.0;
        
        if(StaticMethods.getResistancesForArmorsClassAsValidString(resistance) != null)
        {
            holdDouble = (double)attributesAndResistancesHashMap.get(resistance);
        }
        
        return holdDouble;
    }
    
    // END: STORING AND RETRIEVING OUTFIT ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/

    

    // START: ARMOR RATING
    /*******************************************************************************/

    public enum ArmorPiercingResistanceScale
    {
        NONE, LOWEST, VERY_LOW, LOW, MEDIUM, HIGH, VERY_HIGH, HIGHEST, IMPENETRABLE;
    }
    
    public static String getArmorPiercingResisanceStringUsingEnum(
        ArmorPiercingResistanceScale argument)
    {
        String result = null;
        
        switch(argument)
        {
            case NONE:
               result = "None"; 
                    break;
            case LOWEST:
               result = "Lowest"; 
                    break; 
            case VERY_LOW:
                result = "Very Low"; 
                    break;
            case LOW:
                result = "Low"; 
                    break;
            case MEDIUM:
                result = "Medium"; 
                    break;
            case HIGH:
                result = "High"; 
                    break;
            case VERY_HIGH:
                result = "Very High"; 
                    break;
            case HIGHEST:
                result = "Highest"; 
                    break;
            case IMPENETRABLE:
                result = "Impenetrable"; 
                    break;
        }
        
        return result;
    }
        
    public static String[] validAccessorySlotCoreTypesValuesAsStrings()
    {
        String[] array = new String[StaticMethods.getNumberOfEnumElements(ArmorPiercingResistanceScale.values())];
        
        for(int i = 0; i < ArmorPiercingResistanceScale.values().length; i++)
        {
            array[i] = getArmorPiercingResisanceStringUsingEnum(ArmorPiercingResistanceScale.values()[i]);
        }

        return array;
    }

    // gets enum form of String passed so long as it is considered valid 
    public static ArmorPiercingResistanceScale getArmorPiercingResistanceEnumUsingString(String argument)
    {
        ArmorPiercingResistanceScale result = null;
        
        if(StaticMethods.isStringValid(validAccessorySlotCoreTypesValuesAsStrings(), argument))
        {
            result = ArmorPiercingResistanceScale.valueOf(StaticMethods.stringToEnum(argument));
        }
        
        return result;
    }
    
    // HashMap creation and population through static means 
    private static final HashMap<ArmorPiercingResistanceScale, String> armorPiercingResistanceHashMap =
        new HashMap<ArmorPiercingResistanceScale, String>();
        static 
        {
            for (ArmorPiercingResistanceScale armorPiercingResistance : ArmorPiercingResistanceScale.values()) 
            {
                armorPiercingResistanceHashMap.put(armorPiercingResistance, 
                    getArmorPiercingResisanceStringUsingEnum(armorPiercingResistance));
            }
        }
    
    // return valid armor piercing resistance String based on String passed 
    public static String getArmorPiercingResistanceAsString(String argument) 
    {
        return armorPiercingResistanceHashMap.get(getArmorPiercingResistanceEnumUsingString(argument));
    }
    
    // return valid armor piercing resistance ArmorPiercingResistanceScale enum based on String passed 
    public static ArmorPiercingResistanceScale getArmorPiercingResistanceAsEnum(String argument) 
    {
        ArmorPiercingResistanceScale result = null;
        
        for(ArmorPiercingResistanceScale key : armorPiercingResistanceHashMap.keySet())
        {
            if(key == getArmorPiercingResistanceEnumUsingString(argument))
            {
                result = key;
            }
        }
        
        return result;
    } 
    
    public void setArmorPiercingResistance(String armorPiercingResistance)
    {
        this.armorPiercingResistance = getArmorPiercingResistanceAsString(armorPiercingResistance);
    }
    
    public String getArmorPiercingResistance()
    {
        return armorPiercingResistance;
    }
    
    // END: ARMOR RATING
    /*******************************************************************************/
}