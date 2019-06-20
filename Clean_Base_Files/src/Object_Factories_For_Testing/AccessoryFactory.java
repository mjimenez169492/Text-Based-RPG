package Object_Factories_For_Testing;

import Generic_Object.Accessory;

public class AccessoryFactory 
{
    public Accessory getAccessoryExampleOne()
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
    
    public Accessory getAccessoryExampleTwo()
    {
        Accessory accessory = new Accessory();
        
        accessory.setName("Training ring");
        accessory.setBriefDescription("Brass ring.");
        accessory.setMainClass("Accessory");
        accessory.setAccessoryCategory("Slot Two");
        accessory.setAccessorySuperType("Combat Oriented");
        accessory.setAccessorySubType("Unique effects");
        
        accessory.setUseSpeed(1.12);
        accessory.setBuyPrice(22);
        accessory.setSellPrice(35);
        accessory.setStealRate(3);
        accessory.setPilferRate(10);
        accessory.setDropRate(50);
        
        accessory.setMaxHealth(100);
        accessory.setMaxStamina(28);
        accessory.setMaxNano(33);
        
        accessory.setAttack(7);
        accessory.setDefense(7);
        accessory.setDexterity(-5);
        accessory.setCritical(3);
        accessory.setAccuracy(100);
        accessory.setNanoAttack(3);
        accessory.setNanoDefense(5);
        accessory.setLuck(1);
        
        accessory.setCurrentHealthRegeneration(0);
        accessory.setCurrentStaminaRegeneration(0);
        accessory.setCurrentNanoRegeneration(0);
        
        accessory.setExpMultiplier(1.11);
        accessory.setExpGrowthRateBonus(1.15);
        accessory.setSkillPointBonus(0);
        
        accessory.setMaxDurability(31);
        accessory.setCurrentDurability(31);
        
        accessory.setMaxNumberOfOutfitSlots(2);
        
        accessory.setSlotOneType("Dexterity");
        accessory.setSlotOneCore(null);
        
        accessory.addStatusEffectNegatedByName("Sleep");
        
        return accessory;
    }
    
    public Accessory getAccessoryExampleThree()
    {
        Accessory accessory = new Accessory();
        
        accessory.setName("Hat");
        accessory.setBriefDescription("Ill suited for combat.");
        accessory.setMainClass("Accessory");
        accessory.setAccessoryCategory("Slot Two");
        accessory.setAccessorySuperType("Combat Oriented");
        accessory.setAccessorySubType("Unique effects");
        
        accessory.setUseSpeed(1.12);
        accessory.setBuyPrice(0);
        accessory.setSellPrice(0);
        accessory.setStealRate(0);
        accessory.setPilferRate(0);
        accessory.setDropRate(0);
        
        accessory.setMaxHealth(150);
        accessory.setMaxStamina(0);
        accessory.setMaxNano(0);
        
        accessory.setAttack(0);
        accessory.setDefense(0);
        accessory.setDexterity(0);
        accessory.setCritical(0);
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
        
        accessory.setMaxDurability(20);
        accessory.setCurrentDurability(20);
        
        accessory.setMaxNumberOfOutfitSlots(1);
        
        accessory.setSlotOneType("Dexterity");
        accessory.setSlotOneCore(null);
        
        accessory.addStatusEffectNegatedByName("Bleed");
        
        return accessory;
    }
}
