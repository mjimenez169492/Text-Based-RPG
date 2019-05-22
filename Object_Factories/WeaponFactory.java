package Object_Factories;

import Generic_Object.Weapon;
import Move_Creation.StatusEffect;

public class WeaponFactory 
{
    public Weapon getWeaponExample()
    {
        Weapon weapon = new Weapon();
        
        weapon.setName("Training Stick");
        weapon.setBriefDescription("A stick provided solely for the purpose of "
            + "training; a joke weapon.");
        weapon.setMainClass("Weapon");
        weapon.setWeaponCategory("One Handed");
        weapon.setWeaponSuperType("Other One Handed");
        weapon.setWeaponSubType("Improvised");
        
        weapon.setUseSpeed(1.00);
        weapon.setBuyPrice(0);
        weapon.setSellPrice(-1);
        weapon.setStealRate(100);
        weapon.setPilferRate(100);
        weapon.setDropRate(100);
        
        weapon.setMaxHealth(5);
        weapon.setMaxStamina(5);
        weapon.setMaxNano(5);
        
        weapon.setAttack(3);
        weapon.setDefense(0);
        weapon.setDexterity(2);
        weapon.setCritical(1);
        weapon.setAccuracy(0);
        weapon.setNanoAttack(0);
        weapon.setNanoDefense(0);
        weapon.setLuck(0);
        
        weapon.setCurrentHealthRegeneration(0);
        weapon.setCurrentStaminaRegeneration(0);
        weapon.setCurrentNanoRegeneration(0);
        
        weapon.setExpMultiplier(1.00);
        weapon.setExpGrowthRateBonus(1.00);
        weapon.setSkillPointBonus(0);
        
        weapon.setMaxDurability(10);
        weapon.setCurrentDurability(10);
        
        weapon.setMaxNumberOfOutfitSlots(1);
        
        weapon.setSlotOneType("Attack");
        weapon.setSlotOneCore(null);
        
        weapon.setEnchantment("None");
        
        weapon.setMaxNumberOfStatusEffects(3);
        
        weapon.addStatusEffect(null);
        
        return weapon;
    }
    
    // START: TUTORIAL AREA WEAPONS (ASSUME LV 1)
    /*******************************************************************************/

    /*
        Training Sword
        Rusty Sword 
        Small Dagger
        Broken Spear
    */
    
    public Weapon getTrainingSword()
    {
        Weapon weapon = new Weapon();
        
        weapon.setName("Training Sword");
        weapon.setBriefDescription("Sword exclusively for training purposes.");
        weapon.setMainClass("Weapon");
        weapon.setWeaponCategory("One Handed");
        weapon.setWeaponSuperType("Sword");
        weapon.setWeaponSubType("Standard");
        
        weapon.setUseSpeed(1.00);
        weapon.setBuyPrice(0);
        weapon.setSellPrice(-1);
        weapon.setStealRate(100);
        weapon.setPilferRate(100);
        weapon.setDropRate(100);
        
        weapon.setMaxHealth(11);
        weapon.setMaxStamina(12);
        weapon.setMaxNano(33);
        
        weapon.setAttack(33);
        weapon.setDefense(0);
        weapon.setDexterity(22);
        weapon.setCritical(13);
        weapon.setAccuracy(0);
        weapon.setNanoAttack(30);
        weapon.setNanoDefense(30);
        weapon.setLuck(0);
        
        weapon.setCurrentHealthRegeneration(0);
        weapon.setCurrentStaminaRegeneration(0);
        weapon.setCurrentNanoRegeneration(0);
        
        weapon.setExpMultiplier(1.00);
        weapon.setExpGrowthRateBonus(1.00);
        weapon.setSkillPointBonus(0);
        
        weapon.setMaxDurability(10);
        weapon.setCurrentDurability(10);
        
        weapon.setMaxNumberOfOutfitSlots(1);
        
        weapon.setSlotOneType("Attack");
        weapon.setSlotOneCore(null);
        
        weapon.setEnchantment("None");
        
        weapon.setMaxNumberOfStatusEffects(3);
        
        weapon.addStatusEffect(null);
        
        return weapon;
    }
    
    public Weapon getTrainingKnife()
    {
        Weapon weapon = new Weapon();
        
        weapon.setName("Training Knife");
        weapon.setBriefDescription("Training knife suited for training");
        weapon.setMainClass("Weapon");
        weapon.setWeaponCategory("One Handed");
        weapon.setWeaponSuperType("Knife");
        weapon.setWeaponSubType("Standard");
        
        weapon.setUseSpeed(1.00);
        weapon.setBuyPrice(0);
        weapon.setSellPrice(-1);
        weapon.setStealRate(100);
        weapon.setPilferRate(100);
        weapon.setDropRate(100);
        
        weapon.setMaxHealth(5);
        weapon.setMaxStamina(5);
        weapon.setMaxNano(5);
        
        weapon.setAttack(3);
        weapon.setDefense(0);
        weapon.setDexterity(2);
        weapon.setCritical(1);
        weapon.setAccuracy(0);
        weapon.setNanoAttack(0);
        weapon.setNanoDefense(0);
        weapon.setLuck(0);
        
        weapon.setCurrentHealthRegeneration(0);
        weapon.setCurrentStaminaRegeneration(0);
        weapon.setCurrentNanoRegeneration(0);
        
        weapon.setExpMultiplier(1.00);
        weapon.setExpGrowthRateBonus(1.00);
        weapon.setSkillPointBonus(0);
        
        weapon.setMaxDurability(10);
        weapon.setCurrentDurability(10);
        
        weapon.setMaxNumberOfOutfitSlots(1);
        
        weapon.setSlotOneType("Attack");
        weapon.setSlotOneCore(null);
        
        weapon.setEnchantment("None");
        
        weapon.setMaxNumberOfStatusEffects(3);
        
        weapon.addStatusEffect(null);
        
        return weapon;
    }
    
    // END: TUTORIAL AREA WEAPONS (ASSUME LV 1)
    /*******************************************************************************/

    
}
