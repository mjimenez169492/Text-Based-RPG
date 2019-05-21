package Object_Factories;

import Generic_Object.Armor;

public class ArmorFactory 
{
    public Armor getArmorExample()
    {
        Armor armor = new Armor();
        
        armor.setName("Training Suit");
        armor.setBriefDescription("A cheap plastic suit suited more for fashion "
            + "than for protection.");
        armor.setMainClass("Armor");
        armor.setArmorCategory("Body Armor");
        armor.setArmorSuperType("Combat");
        armor.setArmorSubType("Escalade");
        
        armor.setUseSpeed(1.00);
        armor.setBuyPrice(10);
        armor.setSellPrice(15);
        armor.setStealRate(0);
        armor.setPilferRate(11);
        armor.setDropRate(3);
        
        armor.setMaxHealth(15);
        armor.setMaxStamina(5);
        armor.setMaxNano(3);
        
        armor.setAttack(0);
        armor.setDefense(10);
        armor.setDexterity(-3);
        armor.setCritical(1);
        armor.setAccuracy(0);
        armor.setNanoAttack(0);
        armor.setNanoDefense(0);
        armor.setLuck(0);
        
        armor.setCurrentHealthRegeneration(0);
        armor.setCurrentStaminaRegeneration(0);
        armor.setCurrentNanoRegeneration(0);
        
        armor.setExpMultiplier(1.00);
        armor.setExpGrowthRateBonus(1.00);
        armor.setSkillPointBonus(0);
        
        armor.setMaxDurability(12);
        armor.setCurrentDurability(12);
        
        armor.setMaxNumberOfOutfitSlots(1);
        
        armor.setSlotOneType("Defense");
        armor.setSlotOneCore(null);
        
        // resistances 
        armor.setFireResistance(3);
        armor.setWaterResistance(0);
        armor.setIceResistance(0);
        armor.setElectricityResistance(0);
        armor.setPoisonResistance(0);
        armor.setSonicResistance(0);
        armor.setPlasmaResistance(0);
        armor.setWindResistance(0);
        
        armor.setDryResistance(0);
        armor.setWetResistance(0);
        armor.setColdResistance(0);
        armor.setConductiveResistance(0);
        armor.setSicknessResistance(0);
        armor.setHypersensitiveResistance(0);
        armor.setCoatedResistance(0);
        armor.setLightweightResistance(0);
        armor.setIrradiatedResistance(0);
        
        armor.setAblazeResistance(0);
        armor.setBleedResistance(0);
        armor.setToxicResistance(0);
        
        armor.setAttackDownResistance(0);
        armor.setDefenseDownResistance(0);
        armor.setShutdownResistance(0);
        armor.setDexterityDownResistance(0);
        armor.setCriticalDownResistance(0);
        armor.setAccuracyDownResistance(0);
        armor.setBlindResistance(0);
        armor.setDarknessResistance(0);
        armor.setNanoAttackDownResistance(0);
        armor.setNanoDefenseDownResistance(0);
        
        armor.setConfusedResistance(0);
        armor.setEnamoredResistance(0);
        armor.setBerserkResistance(0);
        
        armor.setFlinchedResistance(0);
        armor.setStunnedResistance(0);
        armor.setScaredResistance(0);
        armor.setBoundResistance(0);
        armor.setSleepResistance(0);
        armor.setTrancedResistance(0);
        armor.setShockedResistance(0);
        armor.setSlowedResistance(0);
        armor.setNullifyStatusEffectsResistance(0);
        
        armor.setArmorPiercingResistance("NONE");
        
        return armor;
    }
    
    // START: TUTORIAL AREA ARMORS (ASSUME LV 1)
    /*******************************************************************************/

    /* Casual T Shirt
        Casual Jeans
        Casual Shoes
        
        
    */
    
    
    // END: TUTORIAL AREA ARMORS (ASSUME LV 1)
    /*******************************************************************************/

}
