package Generic_Character;

import Move_Creation.StatusEffect;
import Generic_Object.OutfitMethods;
import Generic_Object.Accessory;
import Generic_Object.Armor;
import Generic_Object.Weapon;

/*
    EquippableOutfits allows characters to equip outfits ranging from weapons,
    armors, to accessories. The effect provided by outfits upon being equipped 
    must be added to the current values of the wearer's attributes/resistances 
    in order to calculate "getOutfit_" methods where "_" is a stand-in for all
    attributes/resistances that exist. 

    Note: asterisk (*) can be used with package Generic_Object to make imports 
          look cleaner by importing all classes (import Generic_Object.*;)
*/

public class EquippableOutfits
{
    // holding objects from other classes 
    private Stats stats;
    
    // determines whether outfit can be equipped/unequipped from wearer at current time 
    private boolean weaponChangeState, bodyArmorChangeState, legArmorChangeState, 
        footArmorChangeState, accessoryOneChangeState, accessoryTwoChangeState;

    // weapon that a character wields mid-battle 
    private Weapon weapon;
    
    // armors that cover the body, legs, and feet of the wearer 
    private Armor bodyArmor, legArmor, footArmor;   
    
    // accessory slots that can provide a number of effects once equipped 
    private Accessory accessoryOne, accessoryTwo;
    
    public EquippableOutfits(Stats stats)
    {
        this.stats = stats;
    }
    
    
    
    // START: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/
    
    public Stats getStats()
    {
        return stats;
    }
    
    // END: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/

    
    
    // START: DETERMINING WHETHER OUTFITS CAN BE CHANGED 
    /*******************************************************************************/
    
    public void setWeaponChangeState(boolean weaponChangeState)
    {
        this.weaponChangeState = weaponChangeState; 
    }

    public boolean getWeaponChangeState()
    {
        return weaponChangeState; 
    } 

    public void setBodyArmorChangeState(boolean bodyArmorChangeState)
    {
        this.bodyArmorChangeState = bodyArmorChangeState; 
    }

    public boolean getBodyArmorChangeState()
    {
        return bodyArmorChangeState; 
    } 

    public void setLegArmorChangeState(boolean legArmorChangeState)
    {
        this.legArmorChangeState = legArmorChangeState; 
    }

    public boolean getLegArmorChangeState()
    {
        return legArmorChangeState; 
    } 

    public void setFootArmorChangeState(boolean footArmorChangeState)
    {
        this.footArmorChangeState = footArmorChangeState; 
    }

    public boolean getFootArmorChangeState()
    {
        return footArmorChangeState; 
    } 

    public void setAccessoryOneChangeState(boolean accessoryOneChangeState)
    {
        this.accessoryOneChangeState = accessoryOneChangeState; 
    }

    public boolean getAccessoryOneChangeState()
    {
        return accessoryOneChangeState; 
    } 

    public void setAccessoryTwoChangeState(boolean accessoryTwoChangeState)
    {
        this.accessoryTwoChangeState = accessoryTwoChangeState; 
    }

    public boolean getAccessoryTwoChangeState()
    {
        return accessoryTwoChangeState; 
    } 

    public void allowAnyOutfitChange()
    {
        setWeaponChangeState(true);
        setBodyArmorChangeState(true);
        setLegArmorChangeState(true);
        setFootArmorChangeState(true);
        setAccessoryOneChangeState(true);
        setAccessoryTwoChangeState(true);
    }
    
    public void denyAnyOutfitChange()
    {
        setWeaponChangeState(false);
        setBodyArmorChangeState(false);
        setLegArmorChangeState(false);
        setFootArmorChangeState(false);
        setAccessoryOneChangeState(false);
        setAccessoryTwoChangeState(false);
    }
    
    public Object[] getOutfitChangeStates()
    {
        Object[] array = {"Weapon", weaponChangeState, "Body Armor", bodyArmorChangeState,
            "Leg Armor", legArmorChangeState, "Foot Armor", footArmorChangeState, "Accessory 1",
            accessoryOneChangeState, "Accessory 2", accessoryTwoChangeState};
                return array;
    }
    
    // END: DETERMINING WHETHER OUTFITS CAN BE CHANGED 
    /*******************************************************************************/



    // START: SETTING CHARACTER OUTFITS
    /*******************************************************************************/

    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon; 
    }
    
    public void setBodyArmor(Armor bodyArmor)
    {
        this.bodyArmor = bodyArmor; 
    }

    public Armor getBodyArmor()
    {
        return bodyArmor; 
    } 

    public void setLegArmor(Armor legArmor)
    {
        this.legArmor = legArmor; 
    }

    public Armor getLegArmor()
    {
        return legArmor; 
    } 

    public void setFootArmor(Armor footArmor)
    {
        this.footArmor = footArmor; 
    }

    public Armor getFootArmor()
    {
        return footArmor; 
    } 
    
    public void setAccessoryOne(Accessory accessoryOne)
    {
        this.accessoryOne = accessoryOne;
    }
    
    public Accessory getAccessoryOne()
    {
        return accessoryOne; 
    } 
    
    public void setAccessoryTwo(Accessory accessoryTwo)
    {
        this.accessoryTwo = accessoryTwo; 
    }

    public Accessory getAccessoryTwo()
    {
        return accessoryTwo; 
    } 

    // END: SETTING CHARACTER OUTFITS
    /*******************************************************************************/

    
    
    // START: GETTING CHARACTER OUTFITS
    /*******************************************************************************/

    public Weapon getWeapon()
    {
        return weapon; 
    } 
    
    public Armor[] getCharacterArmors()
    {
        Armor[] characterArmors = {bodyArmor, legArmor, footArmor};
            return characterArmors;
    }
    
    public Accessory[] getCharacterAccessories()
    {
        Accessory[] characterAccessories = {accessoryOne, accessoryTwo};
            return characterAccessories;
    }
    
    // END: GETTING CHARACTER OUTFITS
    /*******************************************************************************/

    
    
    // START: CALCULATING IMPACT OF CHARACTER OUTFITS ON CHARACTER
    /*******************************************************************************/
    
    public enum AllOutfitSwitches
    {
        GET_TOTAL_MAX_HEALTH, GET_TOTAL_MAX_STAMINA, GET_TOTAL_MAX_NANO, GET_TOTAL_ATTACK, 
        GET_TOTAL_DEFENSE, GET_TOTAL_DEXTERITY, GET_TOTAL_CRITICAL, GET_TOTAL_ACCURACY, 
        GET_TOTAL_NANO_ATTACK, GET_TOTAL_NANO_DEFENSE;
    }
    
    public double allOutfitsEffectSwitch(AllOutfitSwitches choice, OutfitMethods object)
    {
        double result = 0;
        
        switch(choice)
        {
            case GET_TOTAL_MAX_HEALTH:
                result = object.getTotalMaxHealth();
                    break;
            case GET_TOTAL_MAX_STAMINA:
                result = object.getTotalMaxStamina();
                    break;
            case GET_TOTAL_MAX_NANO:
                result = object.getTotalMaxNano();
                    break;
            case GET_TOTAL_ATTACK:
                result = object.getTotalAttack();
                    break;
            case GET_TOTAL_DEFENSE:
                result = object.getTotalDefense();
                    break;
            case GET_TOTAL_DEXTERITY:
                result = object.getTotalDexterity();
                    break;
            case GET_TOTAL_CRITICAL: 
                result = object.getTotalCritical();
                    break;
            case GET_TOTAL_ACCURACY:
                result = object.getTotalAccuracy();
                    break;
            case GET_TOTAL_NANO_ATTACK: 
                result = object.getTotalNanoAttack();
                    break;
            case GET_TOTAL_NANO_DEFENSE:
                result = object.getTotalNanoDefense();
                    break;
        }

        return result;
    }

    public double allOutfitsEffect(AllOutfitSwitches choice, double argument)
    {
        if(weapon != null)
        {
            argument += allOutfitsEffectSwitch(choice, weapon);
        }

        for(Armor element : getCharacterArmors())
        {
            if(element != null)
            {
                argument += allOutfitsEffectSwitch(choice, element);
            }
        }

        for(Accessory element : getCharacterAccessories())
        {
            if(element != null)
            {
                argument += allOutfitsEffectSwitch(choice, element);
            }
        }

        return argument;
    }

    // END: CALCULATING IMPACT OF CHARACTER OUTFITS ON CHARACTER
    /*******************************************************************************/
    
    

    // START: ACCOUNT FOR CHARACTER ATTRIBUTES WITH OUTFITS 
    /*******************************************************************************/
    
    public double validateWithOutfits(double attribute)
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

    public double getMaxHealthWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_MAX_HEALTH, getStats().getMaxHealth()));
    }

    public double getMaxStaminaWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_MAX_STAMINA, getStats().getMaxStamina()));
    }

    public double getMaxNanoWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_MAX_NANO, getStats().getMaxNano()));
    }
    
    public double getAttackWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_ATTACK, getStats().getAttack()));
    }

    public double getDefenseWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_DEFENSE, getStats().getDefense()));
    }

    public double getDexterityWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_DEXTERITY, getStats().getDexterity()));
    }

    public double getCriticalWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_CRITICAL, getStats().getCritical()));
    }

    public double getAccuracyWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_ACCURACY, getStats().getAccuracy()));
    }

    public double getNanoAttackWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_NANO_ATTACK, getStats().getNanoAttack()));
    }

    public double getNanoDefenseWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitSwitches.
            GET_TOTAL_NANO_DEFENSE, getStats().getNanoDefense()));
    }
    
    // END: ACCOUNT FOR CHARACTER ATTRIBUTES WITH OUTFITS 
    /*******************************************************************************/



    // START: ACCOUNT FOR CHARACTER RESISTANCES WITH OUTFITS 
    /*******************************************************************************/

    public double resistanceWithOutfitResistance(double resistanceValue, String resistanceName)
    {
        for(Armor element : getCharacterArmors())
        {
            if(element != null)
            {
                resistanceValue += element.getResistanceValueForKey(resistanceName);
            }
        }
        
        return getStats().validateResistance(resistanceValue);
    }
    
    // ENCHANTMENT RESISTANCES

    public double getFireResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getFireResistance(), "Fire");
    }

    public double getWaterResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getWaterResistance(), "Water");
    }

    public double getIceResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getIceResistance(), "Ice");
    }

    public double getElectricityResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getElectricityResistance(), "Electricity");
    }

    public double getPoisonResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getPoisonResistance(), "Poison");
    }

    public double getSonicResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getSonicResistance(), "Sonic");
    }

    public double getPlasmaResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getPlasmaResistance(), "Plasma");
    }

    public double getWindResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getWindResistance(), "Wind");
    }
    
    // ENCHANTMENT RESISTANCES


    // STATUS EFFECT REISTANCES

    // UNIQUE STATUS EFFECTS 
    
    public double getDryResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getDryResistance(), "Dry");
    }

    public double getWetResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getWetResistance(), "Wet");
    }

    public double getColdResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getColdResistance(), "Cold");
    }

    public double getConductiveResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getConductiveResistance(), "Conductive");
    }

    public double getSicknessResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getSicknessResistance(), "Sickness");
    }

    public double getHypersensitiveResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getHypersensitiveResistance(), "Hypersensitive");
    }

    public double getCoatedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getCoatedResistance(), "Coated");
    }

    public double getLightweightResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getLightweightResistance(), "Lightweight");
    }

    public double getIrradiatedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getIrradiatedResistance(), "Irradiated");
    }
    
    // UNIQUE STATUS EFFECTS 


    // CURRENT HEALTH STATUS EFFECTS  
    
    public double getAblazeResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getAblazeResistance(), "Ablaze");
    }

    public double getBleedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getBleedResistance(), "Bleed");
    }

    public double getToxicResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getToxicResistance(), "Toxic");
    }
    
    // CURRENT HEALTH STATUS EFFECTS 


    // ATTRIBUTE STATUS EFFECTS 
    
    public double getAttackDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getAttackDownResistance(), "Attack Down");
    }

    public double getDefenseDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getDefenseDownResistance(), "Defense Down");
    }

    public double getShutdownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getShutdownResistance(), "Shutdown");
    }

    public double getDexterityDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getDexterityDownResistance(), "Dexterity Down");
    }

    public double getCriticalDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getCriticalDownResistance(), "Critical Down");
    }

    public double getAccuracyDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getAccuracyDownResistance(), "Accuracy Down");
    }

    public double getBlindResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getBlindResistance(), "Blind");
    }

    public double getDarknessResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getDarknessResistance(), "Darkness");
    }

    public double getNanoAttackDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getNanoAttackDownResistance(), "Nano Attack Down");
    }

    public double getNanoDefenseDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getNanoDefenseDownResistance(), "Nano Defense Down");
    }
    
    // ATTRIBUTE STATUS EFFECTS 


    // BEHAVIOR STATUS EFFECTS  
    
    public double getConfusedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getConfusedResistance(), "Confused");
    }

    public double getEnamoredResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getEnamoredResistance(), "Enamored");
    }

    public double getBerserkResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getBerserkResistance(), "Berserk");
    }
    
    // BEHAVIOR STATUS EFFECTS  


    // TURN BEHAVIOR STATUS EFFECTS 
    
    public double getFlinchedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getFlinchedResistance(), "Flinched");
    }

    public double getStunnedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getStunnedResistance(), "Stunned");
    }

    public double getScaredResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getScaredResistance(), "Scared");
    }

    public double getBoundResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getBoundResistance(), "Bound");
    }

    public double getSleepResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getSleepResistance(), "Sleep");
    }

    public double getTrancedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getTrancedResistance(), "Tranced");
    }

    public double getShockedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getShockedResistance(), "Shocked");
    }

    public double getSlowedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getSlowedResistance(), "Slowed");
    }

    public double getStoppedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStats().getStoppedResistance(), "Stopped");
    }
    
    // TURN BEHAVIOR STATUS EFFECTS 

    // STATUS EFFECT REISTANCES

    // END: ACCOUNT FOR CHARACTER RESISTANCES WITH OUTFITS
    /*******************************************************************************/
    
    
    
    // START: ADDITIONAL EFFECTS PROVIDED BY ACCESSORIES
    /*******************************************************************************/
    
    public int getAccessoryEffectOnSkillName(String skillName)
    {
        int sumOfEffectsOnSkill = 0;
        
        for(Accessory element : getCharacterAccessories())
        {
            if(element != null)
            {
                sumOfEffectsOnSkill += element.getSkillValueForKey(skillName);
            }
        }
        
        return sumOfEffectsOnSkill;
    }
    
    public boolean accessoryNegatesStatusEffect(StatusEffect status)
    {
        boolean result = false;
        
        for(Accessory element : getCharacterAccessories())
        {
            if(element != null && element.statusEffectNegated(status))
            {
                result = true;
                    break;
            }
        }
        
        return result;
    }
    
    // END: ADDITIONAL EFFECTS PROVIDED BY ACCESSORIES
    /*******************************************************************************/

    
    
    // START: APPLY CORE PENALTY TO ALL OUTFITS
    /*******************************************************************************/

    public void applyCorePenaltyToEquippedOutfits()
    {
        if(weapon != null)
        {
            weapon.applyCorePenalty();
        }

        for(Armor element : getCharacterArmors())
        {
            if(element != null)
            {
                element.applyCorePenalty();
            }
        }
        
        for(Accessory element : getCharacterAccessories())
        {
            if(element != null)
            {
                element.applyCorePenalty();
            }
        }
    }
    
    // END: APPLY CORE PENALTY TO ALL OUTFITS
    /*******************************************************************************/
}
