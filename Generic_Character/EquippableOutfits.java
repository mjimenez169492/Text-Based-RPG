package Generic_Character;

/*
    EquippableOutfits allows characters to equip outfits ranging from weapons,
    armors, to accessories. The effect provided by outfits upon being equipped 
    must be added to the current values of the wearer's attributes/resistances 
    in order to calculate "getOutfit_" methods where "_" is a stand-in for all
    attributes/resistances that exist. 
*/

import Generic_Object.Accessories;
import Generic_Object.Armors;
import Generic_Object.Weapons;
import Move_Creation.StatusEffect;
 
public class EquippableOutfits extends AttributesAndResistances
{
    // determines whether weapons/armors/accessories can be equipped or 
    // unequipped from wearer at current time 
    private boolean weaponChangeState, bodyArmorChangeState, legArmorChangeState, 
        footArmorChangeState, accessoryOneChangeState, accessoryTwoChangeState;

    // weapon that a character wields mid-battle 
    private Weapons weapon;
    
    // armors that cover the body, legs, and feet of the wearer 
    private Armors bodyArmor, legArmor, footArmor;   
    
    // accessory slots that can provide a number of effects once equipped 
    private Accessories accessoryOne, accessoryTwo;
    
    
    
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
    
    // END: DETERMINING WHETHER OUTFITS CAN BE CHANGED 
    /*******************************************************************************/



    // START: SETTING CHARACTER OUTFITS
    /*******************************************************************************/

    public void setWeapon(Weapons weapon)
    {
        if(this.weapon == null)
        {
            this.weapon = weapon; 
        }
    }
    
    public void setBodyArmor(Armors bodyArmor)
    {
        if(this.bodyArmor == null)
        {
            this.bodyArmor = bodyArmor; 
        }        
    }

    public Armors getBodyArmor()
    {
        return bodyArmor; 
    } 

    public void setLegArmor(Armors legArmor)
    {
        if(this.legArmor == null)
        {
            this.legArmor = legArmor; 
        }
    }

    public Armors getLegArmor()
    {
        return legArmor; 
    } 

    public void setFootArmor(Armors footArmor)
    {
        if(this.footArmor == null)
        {
            this.footArmor = footArmor; 
        }
    }

    public Armors getFootArmor()
    {
        return footArmor; 
    } 

    public enum SetArmorByCategory
    {
        BODY_ARMOR, LEG_ARMOR, FOOT_ARMOR, UNEQUIPPABLE;
    }
    
    // Note: ONLY use method in inventory screen (Or something...IDK)
    /*
    public void equipArmor(Armors armor)
    {
        if(armor != null && SetArmorByCategory.valueOf(armor.getCategory()) 
            != SetArmorByCategory.UNEQUIPPABLE)
        {
            switch(SetArmorByCategory.valueOf(armor.getCategory()))
            {
                case BODY_ARMOR: 
                    setBodyArmor(armor);
                        break; 
                case LEG_ARMOR: 
                    setLegArmor(armor);
                        break; 
                case FOOT_ARMOR: 
                    setFootArmor(armor);
                        break; 
            }
        }
    }
    */
    
    public void setAccessoryOne(Accessories accessoryOne)
    {
        if(this.accessoryOne == null)
        {
            this.accessoryOne = accessoryOne; 
        }
    }
    
    public Accessories getAccessoryOne()
    {
        return accessoryOne; 
    } 
    
    public void setAccessoryTwo(Accessories accessoryTwo)
    {
        if(this.accessoryTwo == null)
        {
            this.accessoryTwo = accessoryTwo; 
        }
    }

    public Accessories getAccessoryTwo()
    {
        return accessoryTwo; 
    } 

    // END: SETTING CHARACTER OUTFITS
    /*******************************************************************************/

    
    
    // START: GETTING CHARACTER OUTFITS
    /*******************************************************************************/

    public Weapons getWeapon()
    {
        return weapon; 
    } 
    
    public Armors[] getCharacterArmors()
    {
        Armors[] characterArmors = {bodyArmor, legArmor, footArmor};
            return characterArmors;
    }

    public Accessories[] getCharacterAccessories()
    {
        Accessories[] characterAccessories = {accessoryOne, accessoryTwo};
            return characterAccessories;
    }
    
    // END: GETTING CHARACTER OUTFITS
    /*******************************************************************************/

    
    
    // START: CALCULATING IMPACT OF CHARACTER OUTFITS ON CHARACTER
    /*******************************************************************************/
    
    // returns effect armors and accessories have on attributes of wearer 
    public double armorAccessoryEffect(ArmorAccessorySwitches choice, double gauge)
    {
        for(Armors element : getCharacterArmors())
        {
            if(element != null)
            {
                gauge += armorAccessorySwitch(choice, element);
            }
        }

        for(Accessories element : getCharacterAccessories())
        {
            if(element != null)
            {
                gauge += armorAccessorySwitch(choice, element);
            }
        }

       return gauge;
    }
    
    // enum class denoting switch conditions to return desired attribute 
    public enum ArmorAccessorySwitches
    {
        GET_MAX_HEALTH, GET_MAX_STAMINA, GET_MAX_NANO, GET_DEFENSE, GET_DEXTERITY, 
        GET_NANO_DEFENSE;
    }
    
    // overloaded method returns desired value from equipped armors 
    public double armorAccessorySwitch(ArmorAccessorySwitches choice, Armors object)
    {
        double holdEquipValue = 0;
        
        switch(choice)
        {
            case GET_MAX_HEALTH:
                holdEquipValue = object.getTotalMaxHealth();
                    break;
            case GET_MAX_STAMINA:
                holdEquipValue = object.getTotalMaxStamina();
                    break;
            case GET_MAX_NANO:
                holdEquipValue = object.getTotalMaxNano();
                    break;
            case GET_DEFENSE:
                holdEquipValue = object.getTotalDefense();
                    break;
            case GET_DEXTERITY:
                holdEquipValue = object.getTotalDexterity();
                    break;
            case GET_NANO_DEFENSE:
                holdEquipValue = object.getTotalNanoDefense();
                    break;
        }

        return holdEquipValue;
    }

    // overloaded method return desired value from equipped accessories 
    public double armorAccessorySwitch(ArmorAccessorySwitches choice, Accessories object)
    {		
        double holdEquipValue = 0;
        
        switch(choice)
        {
            case GET_MAX_HEALTH:
                holdEquipValue = object.getTotalMaxHealth();
                    break;
            case GET_MAX_STAMINA:
                holdEquipValue = object.getTotalMaxStamina();
                    break;
            case GET_MAX_NANO:
                holdEquipValue = object.getTotalMaxNano();
                    break;
            case GET_DEFENSE:
                holdEquipValue = object.getTotalDefense();
                    break;
            case GET_DEXTERITY:
                holdEquipValue = object.getTotalDexterity();
                    break;
            case GET_NANO_DEFENSE:
                holdEquipValue = object.getTotalNanoDefense();
                    break;
        }

        return holdEquipValue;
    }
    
    //  returns effect weapons and accessories have on an attribute 
    public double weaponAccessoryEffect(WeaponAccessorySwitches choice, double attribute)
    {
        if(weapon != null)
        {
            attribute += weaponAccessorySwitch(choice, weapon);
        }

        for(Accessories element : getCharacterAccessories())
        {
            if(element != null)
            {
                attribute += weaponAccessorySwitch(choice, element);
            }
        }
        
        return attribute;
    }

    // enum class denoting switch conditions to return desired attribute 
    public enum WeaponAccessorySwitches
    {
        GET_ATTACK, GET_CRITICAL, GET_ACCURACY, GET_NANO_ATTACK;
    }
    
    // overloaded method returns desired value from equipped weapon 
    public double weaponAccessorySwitch(WeaponAccessorySwitches choice, Weapons object)
    {		
        double holdEquipValue = 0;

        switch(choice)
        {
            case GET_ATTACK:
                holdEquipValue = object.getTotalAttack();
                    break;
            case GET_CRITICAL:
                holdEquipValue = object.getTotalCritical();
                    break;
            case GET_ACCURACY:
                holdEquipValue = object.getTotalAccuracy();
                    break;
            case GET_NANO_ATTACK:
                holdEquipValue = object.getTotalNanoAttack();
                    break;
        }

        return holdEquipValue;
    }

    // overloaded method returns desired value from equipped accessories 
    public double weaponAccessorySwitch(WeaponAccessorySwitches choice, Accessories object)
    {		
        double holdEquipValue = 0;

        switch(choice)
        {
            case GET_ATTACK:
                holdEquipValue = object.getTotalAttack();
                    break;
            case GET_CRITICAL:
                holdEquipValue = object.getTotalCritical();
                    break;
            case GET_ACCURACY:
                holdEquipValue = object.getTotalAccuracy();
                    break;
            case GET_NANO_ATTACK:
                holdEquipValue = object.getTotalNanoAttack();
                    break;
        }

        return holdEquipValue;
    }	
    
    // returns effect that all outfits have on specific attributes
    public double allOutfitsEffect(AllOutfitsSwitches choice, double attribute)
    {
        if(weapon != null)
        {
            attribute += allOutfitsSwitch(choice, weapon);
        }

        for(Armors element : getCharacterArmors())
        {
            if(element != null)
            {
                attribute += allOutfitsSwitch(choice, element);
            }
        }

        for(Accessories element : getCharacterAccessories())
        {
            if(element != null)
            {
                attribute += allOutfitsSwitch(choice, element);
            }
        }

        return attribute;
    }

    // enum class denoting switch conditions to return desired attribute 
    public enum AllOutfitsSwitches
    {
        GET_MAX_NANO, GET_DEXTERITY; 
    }
    
    // overloaded method returns desired value from equipped weapon 
    public double allOutfitsSwitch(AllOutfitsSwitches choice, Weapons object)
    {	
        double holdEquipValue = 0;
        
        switch(choice)
        {
            case GET_MAX_NANO:
                holdEquipValue = object.getTotalMaxNano();
                    break;
            case GET_DEXTERITY:
                holdEquipValue = object.getTotalDexterity();
                    break;
        }

        return holdEquipValue;
    }

    // overloaded method returns desired value from equipped Armors 
    public double allOutfitsSwitch(AllOutfitsSwitches choice, Armors object)
    {		
        double holdEquipValue = 0;
        
        switch(choice)
        {
            case GET_MAX_NANO:
                holdEquipValue = object.getTotalMaxNano();
                    break;
            case GET_DEXTERITY:
                holdEquipValue = object.getTotalDexterity();
                    break;
        }

        return holdEquipValue;
    }

    // overloaded method returns desired value from equipped Accessories 
    public double allOutfitsSwitch(AllOutfitsSwitches choice, Accessories object)
    {		
        double holdEquipValue = 0;
        
        switch(choice)
        {
            case GET_MAX_NANO:
                holdEquipValue = object.getTotalMaxNano();
                    break;
            case GET_DEXTERITY:
                holdEquipValue = object.getTotalDexterity();
                    break;
        }

        return holdEquipValue;
    }	

    // END: CALCULATING IMPACT OF CHARACTER OUTFITS ON CHARACTER
    /*******************************************************************************/
    
    
    
    // START: ADDITIONAL EFFECTS PROVIDED BY ACCESSORIES
    /*******************************************************************************/

    // returns sum of all values for the desired skills using accessories 
    public int getAccessoryEffectOnSkillName(String skillName)
    {
        int sumOfEffectsOnSkill = 0;
        
        for(Accessories element : getCharacterAccessories())
        {
            if(element != null)
            {
                sumOfEffectsOnSkill += element.getSkillValue(skillName);
            }
        }
        
        return sumOfEffectsOnSkill;
    }
    
    public boolean accessoryNegatesStatus(StatusEffect status)
    {
        boolean result = false;
        
        for(Accessories element : getCharacterAccessories())
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

    
    
    // START: ACCOUNTING FOR CHARACTER MAX GAUGES WITH OUTFITS
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
        return validateWithOutfits(armorAccessoryEffect(ArmorAccessorySwitches.
            GET_MAX_HEALTH, getMaxHealth()));
    }

    public double getMaxStaminaWithOutfits()
    {
        return validateWithOutfits(armorAccessoryEffect(ArmorAccessorySwitches.
            GET_MAX_STAMINA, getMaxStamina()));
    }

    public double getMaxNanoWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitsSwitches.
            GET_MAX_NANO, getMaxNano()));
    }
    
    // END: ACCOUNTING FOR CHARACTER MAX GAUGES WITH OUTFITS
    /*******************************************************************************/



    // START: ACCOUNT FOR CHARACTER ATTRIBUTES WITH OUTFITS 
    /*******************************************************************************/
    
    public double getAttackWithOutfits()
    {
        return validateWithOutfits(weaponAccessoryEffect(WeaponAccessorySwitches.
            GET_ATTACK, getAttack()));
    }

    public double getDefenseWithOutfits()
    {
        return validateWithOutfits(armorAccessoryEffect(ArmorAccessorySwitches.
            GET_DEFENSE, getDefense()));
    }

    public double getDexterityWithOutfits()
    {
        return validateWithOutfits(allOutfitsEffect(AllOutfitsSwitches.
            GET_DEXTERITY, getDexterity()));
    }

    public double getCriticalWithOutfits()
    {
        return validateWithOutfits(weaponAccessoryEffect(WeaponAccessorySwitches.
            GET_CRITICAL, getCritical()));
    }

    public double getAccuracyWithOutfits()
    {
        return validateWithOutfits(weaponAccessoryEffect(WeaponAccessorySwitches.
            GET_ACCURACY, getAccuracy()));
    }

    public double getNanoAttackWithOutfits()
    {
        return validateWithOutfits(weaponAccessoryEffect(WeaponAccessorySwitches.
            GET_NANO_ATTACK, getNanoAttack()));
    }

    public double getNanoDefenseWithOutfits()
    {
        return validateWithOutfits(armorAccessoryEffect(ArmorAccessorySwitches.
            GET_NANO_DEFENSE, getNanoDefense()));
    }
    
    // END: ACCOUNT FOR CHARACTER ATTRIBUTES WITH OUTFITS 
    /*******************************************************************************/



    // START: ACCOUNT FOR CHARACTER RESISTANCES WITH OUTFITS 
    /*******************************************************************************/

    // adds outfit value to double value supplied based on the resistance name  
    public double resistanceWithOutfitResistance(double resistanceValue, String resistanceName)
    {
        for(Armors element : getCharacterArmors())
        {
            if(element != null)
            {
                resistanceValue += element.getOutfitValueForKey(resistanceName);
            }
        }

        return validateResistance(resistanceValue);
    }
    
    // START: DAMAGE RELATED
    /*----------------------------------------------------------------------------*/
    
    public double getFireResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getFireResistance(), "Fire");
    }

    public double getWaterResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getWaterResistance(), "Water");
    }

    public double getIceResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getIceResistance(), "Ice");
    }

    public double getElectricityResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getElectricityResistance(), "Electricity");
    }

    public double getPoisonResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getPoisonResistance(), "Poison");
    }

    public double getSonicResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getSonicResistance(), "Sonic");
    }

    public double getPlasmaResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getPlasmaResistance(), "Plasma");
    }

    public double getWindResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getWindResistance(), "Wind");
    }
    
    // END: DAMAGE RELATED
    /*----------------------------------------------------------------------------*/


    // START: STATUS EFFECT RELATED
    /*----------------------------------------------------------------------------*/

    // START: UNIQUE 
    
    public double getDryResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getDryResistance(), "Dry");
    }

    public double getWetResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getWetResistance(), "Wet");
    }

    public double getColdResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getColdResistance(), "Cold");
    }

    public double getConductiveResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getConductiveResistance(), "Conductive");
    }

    public double getSicknessResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getSicknessResistance(), "Sickness");
    }

    public double getHypersensitiveResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getHypersensitiveResistance(), "Hypersensitive");
    }

    public double getCoatedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getCoatedResistance(), "Coated");
    }

    public double getLightweightResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getLightweightResistance(), "Lightweight");
    }

    public double getIrradiatedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getIrradiatedResistance(), "Irradiated");
    }
    
    // END: UNIQUE 


    // START: CURRENT HEALTH BASED 
    
    public double getAblazeResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getAblazeResistance(), "Ablaze");
    }

    public double getBleedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getBleedResistance(), "Bleed");
    }

    public double getToxicResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getToxicResistance(), "Toxic");
    }
    
    // END: CURRENT HEALTH BASED 


    // START: ATTRIBUTE BASED 
    
    public double getAttackDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getAttackDownResistance(), "Attack Down");
    }

    public double getDefenseDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getDefenseDownResistance(), "Defense Down");
    }

    public double getShutdownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getShutdownResistance(), "Shutdown");
    }

    public double getDexterityDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getDexterityDownResistance(), "Dexterity Down");
    }

    public double getCriticalDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getCriticalDownResistance(), "Critical Down");
    }

    public double getAccuracyDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getAccuracyDownResistance(), "Accuracy Down");
    }

    public double getBlindResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getBlindResistance(), "Blind");
    }

    public double getDarknessResistanceWithOutfits()
{
        return resistanceWithOutfitResistance(getDarknessResistance(), "Darkness");
    }

    public double getNanoAttackDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getNanoAttackDownResistance(), "Nano Attack Down");
    }

    public double getNanoDefenseDownResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getNanoDefenseDownResistance(), "Nano Defense Down");
    }
    
    // END: ATTRIBUTE BASED 


    // START: BEHAVIOR BASED 
    
    public double getConfusedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getConfusedResistance(), "Confused");
    }

    public double getEnamoredResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getEnamoredResistance(), "Enamored");
    }

    public double getBerserkResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getBerserkResistance(), "Berserk");
    }
    
    // END: BEHAVIOR BASED 


    // START: TURN BEHAVIOR BASED 
    
    public double getFlinchedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getFlinchedResistance(), "Flinched");
    }

    public double getStunnedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStunnedResistance(), "Stunned");
    }

    public double getScaredResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getScaredResistance(), "Scared");
    }

    public double getBoundResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getBoundResistance(), "Bound");
    }

    public double getSleepResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getSleepResistance(), "Sleep");
    }

    public double getTrancedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getTrancedResistance(), "Tranced");
    }

    public double getShockedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getShockedResistance(), "Shocked");
    }

    public double getSlowedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getSlowedResistance(), "Slowed");
    }

    public double getStoppedResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getStoppedResistance(), "Stopped");
    }

    public double getNullifyPositiveEffectsResistanceWithOutfits()
    {
        return resistanceWithOutfitResistance(getNullifyPositiveEffectsResistance(), "Nullify Positive Effects");
    }
    
    // END: TURN BEHAVIOR BASED 

    // END: STATUS EFFECT RELATED
    /*----------------------------------------------------------------------------*/

    // END: ACCOUNT FOR CHARACTER RESISTANCES WITH OUTFITS
    /*******************************************************************************/
    
    
    
    // START: APPLY CORE PENALTY ON ALL OUTFITS
    /*******************************************************************************/

    public void applyCorePenaltyToEquippedOutfits()
    {
        if(weapon != null)
        {
            weapon.applyCorePenalty();
        }

        for(Armors element : getCharacterArmors())
        {
            if(element != null)
            {
                element.applyCorePenalty();
            }
        }
        
        for(Accessories element : getCharacterAccessories())
        {
            if(element != null)
            {
                element.applyCorePenalty();
            }
        }
    }
    
    // END: APPLY CORE PENALTY ON ALL OUTFITS
    /*******************************************************************************/
}