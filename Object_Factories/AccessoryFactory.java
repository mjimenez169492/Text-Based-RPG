package Object_Factories;

import Generic_Object.Accessory;

public class AccessoryFactory 
{
    public Accessory getAccessoryExample()
    {
        Accessory accessory = new Accessory();
        
        accessory.setName("Training Gloves");
        accessory.setBriefDescription("A tiny pair of boxing gloves. A nice gift");
        accessory.setMainClass("Accessory");
        accessory.setAccessoryCategory("Slot One");
        accessory.setAccessorySuperType("Combat Oriented");
        accessory.setAccessorySubType("Unique effects");
        
        accessory.setUseSpeed(1.00);
        accessory.setBuyPrice(10);
        accessory.setSellPrice(15);
        accessory.setStealRate(0);
        accessory.setPilferRate(11);
        accessory.setDropRate(3);
        
        accessory.setMaxHealth(15);
        accessory.setMaxStamina(5);
        accessory.setMaxNano(3);
        
        accessory.setAttack(0);
        accessory.setDefense(10);
        accessory.setDexterity(-3);
        accessory.setCritical(1);
        accessory.setAccuracy(0);
        accessory.setNanoAttack(0);
        accessory.setNanoDefense(0);
        accessory.setLuck(0);
        
        accessory.setCurrentHealthRegeneration(0);
        accessory.setCurrentStaminaRegeneration(0);
        accessory.setCurrentNanoRegeneration(0);
        
        accessory.setExpMultiplier(1.00);
        accessory.setExpGrowthRateBonus(1.00);
        accessory.setSkillPointBonus(0);
        
        accessory.setMaxDurability(12);
        accessory.setCurrentDurability(12);
        
        accessory.setMaxNumberOfOutfitSlots(1);
        
        accessory.setSlotOneType("Dexterity");
        accessory.setSlotOneCore(null);
        
        accessory.addStatusEffectNegatedByName("Sleep");
        accessory.addStatusEffectNegatedByName("Bleed");
        
        return accessory;
    }
    
    
    
    
}
