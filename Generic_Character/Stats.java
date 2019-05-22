package Generic_Character;

/*
    Stats contains information relating to the attributes and resistances of 
    a GenericCharacter object which are used represent characteristics which
    may be used in/out of battle.
*/

public class Stats
{
    // variables concerning max gauges 
    private double maxHealth, maxNano, maxStamina;
    
    // attributes tied to object 
    private double attack, defense, dexterity, critical, accuracy, nanoAttack, 
        nanoDefense, luck;

    // damage related resistances (reduce damage received from enchantment)
    private double fireResistance, waterResistance, iceResistance, 
        electricityResistance, poisonResistance, sonicResistance, 
        plasmaResistance, windResistance;						

    // unique status effect resistances 
    private double dryResistance, wetResistance, coldResistance, 
        conductiveResistance, sicknessResistance, hypersensitiveResistance, 
        coatedResistance, lightweightResistance, irradiatedResistance;				

    // current health status effect resistances 
    private double ablazeResistance, bleedResistance, toxicResistance;						

    // attribute status effect resistances 
    private double attackDownResistance, defenseDownResistance, shutdownResistance, 
        dexterityDownResistance, criticalDownResistance, accuracyDownResistance, 
        blindResistance, darknessResistance, nanoAttackDownResistance, 
        nanoDefenseDownResistance;			

    // behavior status effect resistances 
    private double confusedResistance, enamoredResistance, berserkResistance;					

    // turn behavior status effect resistances 
    private double flinchedResistance, stunnedResistance, scaredResistance, 
        boundResistance, sleepResistance, trancedResistance, shockedResistance, 
        slowedResistance, stoppedResistance, nullifyPositiveEffectsResistance;

    public Stats()
    {
        // empty constructor
    }
    
    
    
    // START: CHARACTER ATTRIBUTES
    /*******************************************************************************/

    // GAUGES
    
    public double validateMaxGauges(double maxGauge)
    {
        if(maxGauge < 0) 
        {
            maxGauge = 0;
        }
        else if(maxGauge > 9999)
        {
            maxGauge = 9999;
        }

        return maxGauge;
    }

    public void setMaxHealth(double maxHealth) 
    {
        this.maxHealth = validateMaxGauges(maxHealth); 
    } 

    public double getMaxHealth()
    {
        return maxHealth; 
    } 

    public void setMaxNano(double maxNano) 
    {
        this.maxNano = validateMaxGauges(maxNano); 
    } 

    public double getMaxNano()
    {
        return maxNano; 
    } 

    public void setMaxStamina(double maxStamina) 
    {
        this.maxStamina = validateMaxGauges(maxStamina); 
    } 

    public double getMaxStamina()
    {
        return maxStamina; 
    } 
    
    // GAUGES
    
    
    // NON-GAUGES

    public double validateAttribute(double attribute)
    {
        if(attribute < 0) 
        {
            attribute = 0; 
        }
        else if(attribute > 999)
        {
            attribute = 999;
        }

        return attribute;
    }

    public void setAttack(double attack)
    {
        this.attack = validateAttribute(attack);
    }

    public double getAttack()
    {
        return attack; 
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

    public void setCritical(double critical)
    {
        this.critical = validateAttribute(critical);
    }

    public double getCritical()
    {
        return critical; 
    } 

    public void setAccuracy(double accuracy)
    {
        this.accuracy = validateAttribute(accuracy);
    }

    public double getAccuracy()
    {
        return accuracy; 
    } 

    public void setNanoAttack(double nanoAttack)
    {
        this.nanoAttack = validateAttribute(nanoAttack);
    }

    public double getNanoAttack()
    {
        return nanoAttack; 
    } 

    public void setNanoDefense(double nanoDefense)
    {
        this.nanoDefense = validateAttribute(nanoDefense);
    }

    public double getNanoDefense()
    {
        return nanoDefense; 
    } 

    public void setLuck(double luck)
    {
        this.luck = validateAttribute(luck);
    }

    public double getLuck()
    {
        return luck; 
    } 

    // NON-GAUGES
    
    // END: CHARACTER ATTRIBUTES
    /*******************************************************************************/


    // START: CHARACTER RESISTANTCES 
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

        return resistance;
    }

    // ENCHANTMENT DAMAGE RESISTANCES 

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

    // ENCHANTMENT DAMAGE RESISTANCE 


    // STATUS EFFECT RELATED

    // UNIQUE STATUS EFFECTS 

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

    // UNIQUE STATUS EFFECTS 


    // CURRENT HEALTH BASED 

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

    // CURRENT HEALTH BASED 


    // ATTRIBUTE BASED 

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

    // ATTRIBUTE BASED


    // BEHAVIOR BASED

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

    // BEHAVIOR BASED 


    // TURN BEHAVIOR BASED

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

    // TURN BEHAVIOR BASED 

    // STATUS EFFECT RELATED

    // END: CHARACTER RESISTANTCES: STATUS EFFECT RELATED
    /*******************************************************************************/	
}
