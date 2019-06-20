package Object_Factories_For_Testing;

import Generic_Character.GenericCharacter;

public class GenericCharacterFactory 
{
    // example allies 
    public GenericCharacter getExampleCharacterOne()
    {
        GenericCharacter character = new GenericCharacter();
        
        character.getStats().setMaxHealth(24);
        character.getStats().setMaxStamina(15);
        character.getStats().setMaxNano(0);
        
        character.getStats().setAttack(5);
        character.getStats().setDefense(3);
        character.getStats().setDexterity(5);
        character.getStats().setCritical(1);
        character.getStats().setAccuracy(3);
        character.getStats().setNanoAttack(0);
        character.getStats().setNanoDefense(0);
        character.getStats().setLuck(2);
        
        character.getStats().setFireResistance(10);
        character.getStats().setWaterResistance(1);
        character.getStats().setIceResistance(2);
        character.getStats().setElectricityResistance(3);
        character.getStats().setPoisonResistance(0);
        character.getStats().setSonicResistance(0);
        character.getStats().setPlasmaResistance(4);
        character.getStats().setWindResistance(0);
        
        character.getStats().setDryResistance(6);
        character.getStats().setWetResistance(6);
        character.getStats().setColdResistance(6);
        character.getStats().setConductiveResistance(0);
        character.getStats().setSicknessResistance(0);
        character.getStats().setHypersensitiveResistance(0);
        character.getStats().setCoatedResistance(6);
        character.getStats().setLightweightResistance(0);
        character.getStats().setIrradiatedResistance(6);
        
        character.getStats().setAblazeResistance(0);
        character.getStats().setBleedResistance(7);
        character.getStats().setToxicResistance(7);
        
        character.getStats().setAttackDownResistance(0);
        character.getStats().setDefenseDownResistance(0);
        character.getStats().setShutdownResistance(8);
        character.getStats().setDexterityDownResistance(0);
        character.getStats().setCriticalDownResistance(0);
        character.getStats().setAccuracyDownResistance(0);
        character.getStats().setBlindResistance(0);
        character.getStats().setDarknessResistance(8);
        character.getStats().setNanoAttackDownResistance(0);
        character.getStats().setNanoDefenseDownResistance(0);
        
        character.getStats().setConfusedResistance(0);
        character.getStats().setEnamoredResistance(8);
        character.getStats().setBerserkResistance(0);
        
        character.getStats().setFlinchedResistance(0);
        character.getStats().setStunnedResistance(0);
        character.getStats().setScaredResistance(8);
        character.getStats().setBoundResistance(0);
        character.getStats().setSleepResistance(8);
        character.getStats().setTrancedResistance(0);
        character.getStats().setShockedResistance(0);
        character.getStats().setSlowedResistance(0);
        character.getStats().setStoppedResistance(0);
        
        character.getEquippableOutfits().setWeapon(new WeaponFactory().getTrainingKnife());
        character.getEquippableOutfits().setBodyArmor(new ArmorFactory().getBodyArmorExampleOne());
        character.getEquippableOutfits().setLegArmor(new ArmorFactory().getLegArmorExampleTwo());
        character.getEquippableOutfits().setFootArmor(new ArmorFactory().getFootArmorExampleOne());
        character.getEquippableOutfits().setAccessoryOne(null);
        character.getEquippableOutfits().setAccessoryTwo(null);
        
        // can be used to allow/deny all outfit changes at once 
            //character.getEquippableOutfits().allowAnyOutfitChange();
            //character.getEquippableOutfits().denyAnyOutfitChange();
        character.getEquippableOutfits().setWeaponChangeState(false);
        character.getEquippableOutfits().setBodyArmorChangeState(true);
        character.getEquippableOutfits().setLegArmorChangeState(true);
        character.getEquippableOutfits().setFootArmorChangeState(false);
        character.getEquippableOutfits().setAccessoryOneChangeState(true);
        character.getEquippableOutfits().setAccessoryTwoChangeState(true);
        
        character.getOppositionMethods().setDefeatExp(0);
        character.getOppositionMethods().setDefeatMoney(0);
        character.getOppositionMethods().setPersonalWalletMaxSize(10);
        character.getOppositionMethods().setPersonalWalletMoney(5);
        
        character.getOppositionMethods().setStealableObjectsMaxCapacity(3);
        character.getOppositionMethods().setPilferableObjectsMaxCapacity(4);
        character.getOppositionMethods().setDroppableObjectsMaxSize(2);
        
        character.getGeneralFeatures().playerControl(true);
        character.getGeneralFeatures().boss(false);
        character.getGeneralFeatures().damaged(false);
        character.getGeneralFeatures().nanomachines(false);
        character.getGeneralFeatures().endBattle(false);
        
        character.getGeneralFeatures().setName("Test Character");
        character.getGeneralFeatures().setType("Test");
        
        character.getGeneralFeatures().setLevel(1);
        character.getGeneralFeatures().setExperience(12);
        character.getGeneralFeatures().setExpScale(33);
        
        character.getGeneralFeatures().setCurrentHealth(character.getTotalStats().getTotalMaxHealth() - 16);
        character.getGeneralFeatures().setCurrentStamina(character.getTotalStats().getTotalMaxStamina() - 6);
        character.getGeneralFeatures().setCurrentNano(character.getTotalStats().getTotalMaxNano() - 12);
        
        character.getGeneralFeatures().setChanceToPreventEscape(0);
        
        return character;
    }
    
    public GenericCharacter getExampleCharacterTwo()
    {
        GenericCharacter character = new GenericCharacter();
        
        character.getStats().setMaxHealth(124);
        character.getStats().setMaxStamina(115);
        character.getStats().setMaxNano(0);
        
        character.getStats().setAttack(45);
        character.getStats().setDefense(43);
        character.getStats().setDexterity(45);
        character.getStats().setCritical(41);
        character.getStats().setAccuracy(43);
        character.getStats().setNanoAttack(0);
        character.getStats().setNanoDefense(0);
        character.getStats().setLuck(2);
        
        character.getStats().setFireResistance(10);
        character.getStats().setWaterResistance(51);
        character.getStats().setIceResistance(42);
        character.getStats().setElectricityResistance(33);
        character.getStats().setPoisonResistance(0);
        character.getStats().setSonicResistance(0);
        character.getStats().setPlasmaResistance(24);
        character.getStats().setWindResistance(0);
        
        character.getStats().setDryResistance(26);
        character.getStats().setWetResistance(26);
        character.getStats().setColdResistance(36);
        character.getStats().setConductiveResistance(0);
        character.getStats().setSicknessResistance(0);
        character.getStats().setHypersensitiveResistance(0);
        character.getStats().setCoatedResistance(46);
        character.getStats().setLightweightResistance(0);
        character.getStats().setIrradiatedResistance(6);
        
        character.getStats().setAblazeResistance(0);
        character.getStats().setBleedResistance(7);
        character.getStats().setToxicResistance(47);
        
        character.getStats().setAttackDownResistance(0);
        character.getStats().setDefenseDownResistance(0);
        character.getStats().setShutdownResistance(8);
        character.getStats().setDexterityDownResistance(0);
        character.getStats().setCriticalDownResistance(0);
        character.getStats().setAccuracyDownResistance(0);
        character.getStats().setBlindResistance(0);
        character.getStats().setDarknessResistance(8);
        character.getStats().setNanoAttackDownResistance(0);
        character.getStats().setNanoDefenseDownResistance(0);
        
        character.getStats().setConfusedResistance(0);
        character.getStats().setEnamoredResistance(58);
        character.getStats().setBerserkResistance(0);
        
        character.getStats().setFlinchedResistance(0);
        character.getStats().setStunnedResistance(0);
        character.getStats().setScaredResistance(58);
        character.getStats().setBoundResistance(0);
        character.getStats().setSleepResistance(8);
        character.getStats().setTrancedResistance(0);
        character.getStats().setShockedResistance(50);
        character.getStats().setSlowedResistance(0);
        character.getStats().setStoppedResistance(0);
        
        character.getEquippableOutfits().setWeapon(null);
        character.getEquippableOutfits().setBodyArmor(null);
        character.getEquippableOutfits().setLegArmor(null);
        character.getEquippableOutfits().setFootArmor(null);
        character.getEquippableOutfits().setAccessoryOne(null);
        character.getEquippableOutfits().setAccessoryTwo(null);
        
        // can be used to allow/deny all outfit changes at once 
            //character.getEquippableOutfits().allowAnyOutfitChange();
            //character.getEquippableOutfits().denyAnyOutfitChange();
        character.getEquippableOutfits().setWeaponChangeState(true);
        character.getEquippableOutfits().setBodyArmorChangeState(true);
        character.getEquippableOutfits().setLegArmorChangeState(true);
        character.getEquippableOutfits().setFootArmorChangeState(true);
        character.getEquippableOutfits().setAccessoryOneChangeState(true);
        character.getEquippableOutfits().setAccessoryTwoChangeState(true);
        
        character.getOppositionMethods().setDefeatExp(0);
        character.getOppositionMethods().setDefeatMoney(0);
        character.getOppositionMethods().setPersonalWalletMaxSize(10);
        character.getOppositionMethods().setPersonalWalletMoney(5);
        
        character.getOppositionMethods().setStealableObjectsMaxCapacity(3);
        character.getOppositionMethods().setPilferableObjectsMaxCapacity(4);
        character.getOppositionMethods().setDroppableObjectsMaxSize(2);
        
        character.getGeneralFeatures().playerControl(true);
        character.getGeneralFeatures().boss(false);
        character.getGeneralFeatures().damaged(false);
        character.getGeneralFeatures().nanomachines(false);
        character.getGeneralFeatures().endBattle(false);
        
        character.getGeneralFeatures().setName("Test Character Two");
        character.getGeneralFeatures().setType("Test");
        
        character.getGeneralFeatures().setLevel(1);
        character.getGeneralFeatures().setExperience(19);
        character.getGeneralFeatures().setExpScale(33);
        
        character.getGeneralFeatures().setCurrentHealth(character.getTotalStats().getTotalMaxHealth() - 116);
        character.getGeneralFeatures().setCurrentStamina(character.getTotalStats().getTotalMaxStamina() - 116);
        character.getGeneralFeatures().setCurrentNano(character.getTotalStats().getTotalMaxNano() - 112);
        
        character.getGeneralFeatures().setChanceToPreventEscape(0);
        
        return character;
    }
    
    // example enemy 
    public GenericCharacter getExampleCharacterThree()
    {
        GenericCharacter character = new GenericCharacter();
        
        character.getStats().setMaxHealth(23);
        character.getStats().setMaxStamina(15);
        character.getStats().setMaxNano(0);
        
        character.getStats().setAttack(5);
        character.getStats().setDefense(3);
        character.getStats().setDexterity(5);
        character.getStats().setCritical(1);
        character.getStats().setAccuracy(3);
        character.getStats().setNanoAttack(0);
        character.getStats().setNanoDefense(0);
        character.getStats().setLuck(2);
        
        character.getStats().setFireResistance(0);
        character.getStats().setWaterResistance(0);
        character.getStats().setIceResistance(0);
        character.getStats().setElectricityResistance(0);
        character.getStats().setPoisonResistance(0);
        character.getStats().setSonicResistance(0);
        character.getStats().setPlasmaResistance(0);
        character.getStats().setWindResistance(0);
        
        character.getStats().setDryResistance(0);
        character.getStats().setWetResistance(0);
        character.getStats().setColdResistance(0);
        character.getStats().setConductiveResistance(0);
        character.getStats().setSicknessResistance(0);
        character.getStats().setHypersensitiveResistance(0);
        character.getStats().setCoatedResistance(0);
        character.getStats().setLightweightResistance(0);
        character.getStats().setIrradiatedResistance(0);
        
        character.getStats().setAblazeResistance(0);
        character.getStats().setBleedResistance(0);
        character.getStats().setToxicResistance(0);
        
        character.getStats().setAttackDownResistance(0);
        character.getStats().setDefenseDownResistance(0);
        character.getStats().setShutdownResistance(0);
        character.getStats().setDexterityDownResistance(0);
        character.getStats().setCriticalDownResistance(0);
        character.getStats().setAccuracyDownResistance(0);
        character.getStats().setBlindResistance(0);
        character.getStats().setDarknessResistance(0);
        character.getStats().setNanoAttackDownResistance(0);
        character.getStats().setNanoDefenseDownResistance(0);
        
        character.getStats().setConfusedResistance(0);
        character.getStats().setEnamoredResistance(0);
        character.getStats().setBerserkResistance(0);
        
        character.getStats().setFlinchedResistance(0);
        character.getStats().setStunnedResistance(0);
        character.getStats().setScaredResistance(0);
        character.getStats().setBoundResistance(0);
        character.getStats().setSleepResistance(0);
        character.getStats().setTrancedResistance(0);
        character.getStats().setShockedResistance(0);
        character.getStats().setSlowedResistance(0);
        character.getStats().setStoppedResistance(0);
        
        // can be used to allow/deny all outfit changes at once 
            //character.getEquippableOutfits().allowAnyOutfitChange();
            //character.getEquippableOutfits().denyAnyOutfitChange();
        character.getEquippableOutfits().setWeaponChangeState(true);
        character.getEquippableOutfits().setBodyArmorChangeState(true);
        character.getEquippableOutfits().setLegArmorChangeState(true);
        character.getEquippableOutfits().setFootArmorChangeState(true);
        character.getEquippableOutfits().setAccessoryOneChangeState(true);
        character.getEquippableOutfits().setAccessoryTwoChangeState(true);
        
        character.getEquippableOutfits().setWeapon(null);
        character.getEquippableOutfits().setBodyArmor(null);
        character.getEquippableOutfits().setLegArmor(null);
        character.getEquippableOutfits().setFootArmor(null);
        character.getEquippableOutfits().setAccessoryOne(null);
        character.getEquippableOutfits().setAccessoryTwo(null);
        
        character.getOppositionMethods().setDefeatExp(0);
        character.getOppositionMethods().setDefeatMoney(0);
        character.getOppositionMethods().setPersonalWalletMaxSize(10);
        character.getOppositionMethods().setPersonalWalletMoney(5);
        
        character.getOppositionMethods().setStealableObjectsMaxCapacity(3);
        character.getOppositionMethods().setPilferableObjectsMaxCapacity(4);
        character.getOppositionMethods().setDroppableObjectsMaxSize(2);
        
        character.getGeneralFeatures().playerControl(true);
        character.getGeneralFeatures().boss(true);
        character.getGeneralFeatures().damaged(true);
        character.getGeneralFeatures().nanomachines(true);
        character.getGeneralFeatures().endBattle(true);
        
        character.getGeneralFeatures().setName("Test Enemy One");
        character.getGeneralFeatures().setType("Enemy");
        
        character.getGeneralFeatures().setLevel(1);
        character.getGeneralFeatures().setExperience(12);
        character.getGeneralFeatures().setExpScale(33);
        
        character.getGeneralFeatures().setCurrentHealth(character.getTotalStats().getTotalMaxHealth() - 5);
        character.getGeneralFeatures().setCurrentStamina(character.getTotalStats().getTotalMaxStamina() - 5);
        character.getGeneralFeatures().setCurrentNano(character.getTotalStats().getTotalMaxNano() - 5);
        
        character.getGeneralFeatures().setChanceToPreventEscape(0);
        
        return character;
    }
}
