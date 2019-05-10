package Generic_Object;

/*
    Armors extends OutfitMethods meaning that Armors is a subclass of superclass 
    OutfitMethods. Armors defines methods relating to armor creation. 
*/

import Generic_Object.OutfitMethods;
import Commonly_Used_Methods.StaticMethods;
import java.util.ArrayList;
import java.util.HashMap;

public class Armor extends OutfitMethods
{
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
        new HashMap<>();
    
    // holds armor rating assigned to a piece of armor
    private String armorPiercingResistance;
    
    // subclass constructor with method(s) invoked upon object creation 
    public Armor()
    {
        // need to set subclass name to enable slot/core equip feature for object 
        setSubclassName("Armors");
        
        // set up hashmap for easy value retrieval 
        initializeAttributesAndResistancesHashMap();
    }



    // START: ARMOR CATEGORY, SUPERTYPE, AND SUBTYPE
    /*******************************************************************************/

    public enum ArmorCategory
    { 
        BODY_ARMOR("Body Armor"), LEG_ARMOR("Leg Armor"), FOOT_ARMOR("Foot Armor");
        
        private String armorCategory;
        
        ArmorCategory(String armorCategory)
        {
            this.armorCategory = armorCategory;
        }
        
        public String getEnumAsString()
        {
            return armorCategory;
        }
    } 
    
    public void setArmorCategory(String argument)
    {
        super.setCategory(ArmorCategory.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public ArmorCategory getArmorCategoryEnum()
    {
        return ArmorCategory.valueOf(StaticMethods.stringToEnum(super.getCategory()));
    }
    
    public enum ArmorSuperTypes 
    {
        CLOSE_QUARTERS_COMBAT("Close Quarters Combat"), SWORD("Sword"), KNIFE("Knife"), 
        OTHER_ONE_HANDED("Other One Handed"), GREAT_SWORD("Great Sword"), SPEAR("Spear"), 
        OTHER_TWO_HANDED("Other Two Handed"), BLADES("Blades"), OTHER_DUAL_WIELDED
        ("Other Dual Wielded");
        
        private String amorSuperType;
        
        ArmorSuperTypes(String amorSuperType)
        {
            this.amorSuperType = amorSuperType;
        }
        
        public String getEnumAsString()
        {
            return amorSuperType;
        }
    } 
    
    public void setArmorSuperType(String argument)
    {
        super.setSuperType(ArmorSuperTypes.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public ArmorSuperTypes getArmorSuperTypeEnum()
    {
        return ArmorSuperTypes.valueOf(StaticMethods.stringToEnum(super.getSuperType()));
    }
    
    public enum ArmorSubTypes 
    {
        MAKESHIFT("Makeshift"), JUNKER("Junker"), NUMIN("Numin"), Z_SERIES("Z Series"), 
        ESCALADE("Escalade"), TERRA_NOVA("Terra Nova"), ETERNAL("Eternal"), NIM("Nim"),	
        PROTOTYPE("Prototype"), UNKNOWN("Uknown"), LOST("Lost"), LEGENDARY("Legendary");
        
        private String armorSubType;
        
        ArmorSubTypes(String armorSubType)
        {
            this.armorSubType = armorSubType;
        }
        
        public String getEnumAsString()
        {
            return armorSubType;
        }
    } 
    
    public void setArmorSubType(String argument)
    {
        super.setSubType(ArmorSubTypes.valueOf(StaticMethods.stringToEnum(argument)).
            getEnumAsString());
    }
    
    public ArmorSubTypes getWeaponSubTypeEnum()
    {
        return ArmorSubTypes.valueOf(StaticMethods.stringToEnum(super.getSubType()));
    }
    
    // END: ARMOR CATEGORY, SUPERTYPE, AND SUBTYPE
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


    
    // START: TOTAL ARMOR RESISTANCES WITH CORES AND DURABILITY SUPPLIED
    /*******************************************************************************/

    // START: ENCHANTMENT RELATED

    public double getTotalFireResistance()
    {
        return totalOutfitValue(getFireResistance(), "Fire");
    }

    public double getTotalWaterResistance()
    {
        return totalOutfitValue(getWaterResistance(), "Water");
    }

    public double getTotalIceResistance()
    {
        return totalOutfitValue(getIceResistance(), "Ice");
    }

    public double getTotalElectricityResistance()
    {
        return totalOutfitValue(getElectricityResistance(), "Electricity");
    }

    public double getTotalPoisonResistance()
    {
        return totalOutfitValue(getPoisonResistance(), "Poison");
    }

    public double getTotalSonicResistance()
    {
        return totalOutfitValue(getSonicResistance(), "Sonic");
    }

    public double getTotalPlasmaResistance()
    {
        return totalOutfitValue(getPlasmaResistance(), "Plasma");
    }

    public double getTotalWindResistance()
    {
        return totalOutfitValue(getWindResistance(), "Wind");
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
        return totalOutfitValue(getDryResistance(), "Dry");
    }

    public double getTotalWetResistance() 
    {
        return totalOutfitValue(getWetResistance(), "Wet");
    }

    public double getTotalColdResistance()
    {
        return totalOutfitValue(getColdResistance(), "Cold ");
    }

    public double getTotalConductiveResistance()
    {
        return totalOutfitValue(getConductiveResistance(), "Conductive");
    }

    public double getTotalSicknessResistance()
    {
        return totalOutfitValue(getSicknessResistance(), "Sickness");
    }

    public double getTotalHypersensitiveResistance()
    {
        return totalOutfitValue(getHypersensitiveResistance(), "Hypersensitive");
    }

    public double getTotalCoatedResistance()
    {
        return totalOutfitValue(getCoatedResistance(), "Coated");
    }

    public double getTotalLightweightResistance()
    {
        return totalOutfitValue(getLightweightResistance(), "Lightweight");
    }

    public double getTotalIrradiatedResistance()
    {
        return totalOutfitValue(getIrradiatedResistance(), "Irradiated");
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
        return totalOutfitValue(getAblazeResistance(), "Ablaze");
    }

    public double getTotalBleedResistance()
    {
        return totalOutfitValue(getBleedResistance(), "Bleed");
    }

    public double getTotalToxicResistance()
    {
        return totalOutfitValue(getToxicResistance(), "Toxic");
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
        return totalOutfitValue(getAttackDownResistance(), "Attack Down");
    }

    public double getTotalDefenseDownResistance()
    {
        return totalOutfitValue(getDefenseDownResistance(), "Defense Down");
    }

    public double getTotalShutdownResistance()
    {
        return totalOutfitValue(getShutdownResistance(), "Shutdown");
    }

    public double getTotalDexterityDownResistance()
    {
        return totalOutfitValue(getDexterityDownResistance(), "Dexterity Down");
    }

    public double getTotalCriticalDownResistance()
    {
        return totalOutfitValue(getCriticalDownResistance(), "Critical Down");
    }

    public double getTotalAccuracyDownResistance()
    {
        return totalOutfitValue(getAccuracyDownResistance(), "Accuracy Down");
    }

    public double getTotalBlindResistance()
    {
        return totalOutfitValue(getBleedResistance(), "Bleed");
    }

    public double getTotalDarknessResistance()
    {
        return totalOutfitValue(getDarknessResistance(), "Darkness");
    }

    public double getTotalNanoAttackDownResistance()
    {
        return totalOutfitValue(getNanoAttackDownResistance(), "Nano Attack Down");
    }

    public double getTotalNanoDefenseDownResistance()
    {
        return totalOutfitValue(getNanoDefenseDownResistance(), "Nano Defense Down");
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
        return totalOutfitValue(getConfusedResistance(), "Confused");
    }

    public double getTotalEnamoredResistance()
    {
        return totalOutfitValue(getEnamoredResistance(), "Enamored");
    }

    public double getTotalBerserkResistance()
    {
        return totalOutfitValue(getBerserkResistance(), "Berserk");
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
        return totalOutfitValue(getFlinchedResistance(), "Flinched");
    }

    public double getTotalStunnedResistance()
    {
        return totalOutfitValue(getStunnedResistance(), "Stunned");
    }

    public double getTotalScaredResistance()
    {
        return totalOutfitValue(getScaredResistance(), "Scared");
    }

    public double getTotalBoundResistance()
    {
        return totalOutfitValue(getBoundResistance(), "Bound");
    }

    public double getTotalSleepResistance()
    {
        return totalOutfitValue(getSleepResistance(), "Sleep");
    }

    public double getTotalTrancedResistance()
    {
        return totalOutfitValue(getTrancedResistance(), "Tranced");
    }

    public double getTotalShockedResistance()
    {
        return totalOutfitValue(getShockedResistance(), "Shocked");
    }

    public double getTotalSlowedResistance()
    {
        return totalOutfitValue(getSlowedResistance(), "Slowed");
    }

    public double getTotalStoppedResistance()
    {
        return totalOutfitValue(getStoppedResistance(), "Stopped");
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
        return totalOutfitValue(getNullifyStatusEffectsResistance(), "Nullify Status Effects");
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
    
    public Object[][] getArrayContainingResistances()
    {
        Object[] arrayOfArrays [] = {getAllTotalEnchantmentResistancesWithNames(), 
            getAllTotalUniqueStatusEffectResistancesWithNames(),
            getAllTotalAttributeStatusEffectResistancesWithNames(),
            getAllTotalBehaviorStatusEffectResistancesWithNames(),
            getAllTotalTurnBehaviorStatusEffectResistancesWithNames(), 
            getAllTotalNullifyStatusEffectResistancesWithNames()};
                return arrayOfArrays;
    }
    
    public ArrayList<Object> getAttributesAndResistancesArrayList()
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
    
    public final void initializeAttributesAndResistancesHashMap()
    {
        ArrayList<Object> arrayList = getAttributesAndResistancesArrayList();
        
        for(int i = 0; i < arrayList.size(); i+=2)
        {
            attributesAndResistancesHashMap.put((String)arrayList.get(i), 
                (Double)arrayList.get(i+1));
        }
    }
    
    public double validateResistanceValues(double argument)
    {
        if(argument < 0)
        {
            argument = 0;
        } 
        else if(argument > 100)
        {
            argument = 100;
        }
        
        return argument;
    }
    
    public void alterValueForKey(String key, Double value)
    {
        attributesAndResistancesHashMap.put(key, validateResistanceValues(value));
    }
    
    public HashMap<String, Double> getHashMap()
    {
        return attributesAndResistancesHashMap;
    }
    
    public double getResistanceValueForKey(String resistance)
    {
        return (double)attributesAndResistancesHashMap.get(resistance);
    }
    
    // END: STORING AND RETRIEVING OUTFIT ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/

    

    // START: ARMOR RATING
    /*******************************************************************************/

    public enum ArmorPiercingResistances
    {
        NONE("None"), LOWEST("Lowest"), VERY_LOW("Very Low"), LOW("Low"), MEDIUM("Medium"), 
        HIGH("High"), VERY_HIGH("Very High"), HIGHEST("Highest"), IMPENETRABLE("Impenetrable");
        
        private String armorPiercingResistances;
        
        ArmorPiercingResistances(String armorPiercingResistances)
        {
            this.armorPiercingResistances = armorPiercingResistances;
        }
        
        public String getEnumAsString()
        {
            return armorPiercingResistances;
        }
    }
    
    public void setArmorPiercingResistance(String armorPiercingResistance)
    {
        this.armorPiercingResistance = ArmorPiercingResistances.valueOf(StaticMethods.
            stringToEnum(armorPiercingResistance)).getEnumAsString();
    }
    
    public String getArmorPiercingResistanceString()
    {
        return armorPiercingResistance;
    }
    
    public ArmorPiercingResistances getArmorPiercingResistanceEnum()
    {
        return ArmorPiercingResistances.valueOf(StaticMethods.stringToEnum(armorPiercingResistance));
    }
    
    // END: ARMOR RATING
    /*******************************************************************************/
}