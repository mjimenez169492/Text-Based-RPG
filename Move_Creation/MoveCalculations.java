package Move_Creation;

/*
    MoveCalculations contains code relating to the creation of calculations 
    or formulas used to produce desired outputs for a Moves object. Aspects
    of a moves object, such as the number of times a subject may be subject
    to move, and whether or not the move is capable of affecting targets at 
    all (based on GenericCharacter objects immunities), must be provided in
    order to properly design move formulas. 
*/

import Generic_Character.GenericCharacter;
import Player_Entity.Party;
import java.util.Scanner;
import Move_Creation.Moves;
import Move_Creation.StatusEffect;

import java.security.SecureRandom;
import java.util.PriorityQueue;	
import java.util.ArrayList;
import java.util.Comparator;

public class MoveCalculations 
{
    boolean cancelMove;
    
    
    
    // START: MOVE USE STATES
    /*******************************************************************************/
    
    public void cancelMove(boolean cancelMove)
    {
        this.cancelMove = cancelMove;
    }
    
    public boolean cancelMove()
    {
        return cancelMove;
    }
    
    // END: MOVE USE STATES
    /*******************************************************************************/

    

    // START: BASE OUTPUT CALCULATIONS 
    /*******************************************************************************/

    public double checkOutput(double argument)
    {
        if(argument < 0)
        {
            argument = 0;
        }
        else if(argument > 15000)
        {
            argument = 15000;
        }

        return Math.floor(argument);
    }

    public double outputCalculator(double attack, double dexterity, double level)
    {
        double userOutput = attack + (attack * (((dexterity + level) / 16.0) / 
            Math.sqrt(attack / 2)));
                return userOutput;
    }
    
    public double defenseCalculator(double defense, double dexterity, double level)
    {
        double targetDefense = defense + (defense * (((dexterity + level) / 20.0) / 
            Math.sqrt(defense)));
                return targetDefense;
    }
    
    public double trueOutputValue(double userOutput, double targetDefense)
    {
        return checkOutput((userOutput - targetDefense));
    }
    
    public double staminaOutput(GenericCharacter user, GenericCharacter target)
    {
        double userOutput = outputCalculator((user.getTotalAttack() * 1.04), 
            (user.getTotalDexterity() * 1.06), (user.getLevel() * 1.25));
        
        double targetDefense = outputCalculator((target.getTotalDefense() * 0.98), 
            (target.getTotalDexterity() * 0.96), (target.getLevel() * 1.20));

        return trueOutputValue(userOutput, targetDefense);
    }
    
    public double nanoOutput(GenericCharacter user, GenericCharacter target)
    {
        double userOutput = outputCalculator((user.getTotalNanoAttack() * 1.12), 
            (user.getTotalDexterity() * 1.08), (user.getLevel() * 1.40));
        
        double targetDefense = outputCalculator((target.getTotalNanoDefense() * 0.94), 
            (target.getTotalDexterity() * 0.98), (target.getLevel() * 1.25));

        return trueOutputValue(userOutput, targetDefense);
    }
    
    // END: BASE OUTPUT CALCULATIONS 
    /*******************************************************************************/

    
    
    // START: OUTPUT BY WEAPON CALCULATIONS 
    /*******************************************************************************/
    
    // STAMINA OUTPUT 
    
    public double staminaOutputByWeaponWielded(GenericCharacter user, GenericCharacter target)
    {
        double output = staminaOutput(user, target);
        
        if(user.getWeapon() != null)
        {
            switch(user.getWeapon().getSuperTypeEnum())
            {
                case CLOSE_QUARTERS_COMBAT:
                    output = (output * 0.81) + 2;
                        break;
                case SWORD:
                    output = (output * 0.96) + 4;
                        break;
                case KNIFE:
                    output = (output * 0.89) + 2;
                        break;
                case OTHER_ONE_HANDED:
                    output = (output * 0.85) + 2;
                        break; 
                case GREAT_SWORD:
                    output = (output * 1.13) + 7;
                        break
                case SPEAR:
                    output = (output * 1.07) + 6;
                        break;
                case OTHER_TWO_HANDED:
                    output = (output * 1.02) + 5;
                        break;
                case BLADES:
                    output = (output * 0.84) + 2;
                        break;
                case OTHER_DUAL_WIELDED: 
                    output = (output * 0.79) + 1;
                        break;
                default:
                    break;
            }
        }
        else
        {
            output = (output * 0.75) + 1;
        }
        
        return output;
    }
    
    // STAMINA OUTPUT 
    
    
    // NANO OUTPUT 
    
    public double nanoOutputByWeaponWielded(GenericCharacter user, GenericCharacter target)
    {
        double output = nanoOutput(user, target);
        
        if(user.getWeapon() != null)
        {
            switch(user.getWeapon().getSuperTypeEnum())
            {
                case CLOSE_QUARTERS_COMBAT:
                    output = (output * 1.07) + 6;
                        break;
                case SWORD:
                    output = (output * 0.84) + 2;
                        break;
                case KNIFE:
                    output = (output * 1.02) + 5;
                        break;
                case OTHER_ONE_HANDED:
                    output = (output * 0.96) + 4;
                        break; 
                case GREAT_SWORD:
                    output = (output * 0.75) + 1;
                        break
                case SPEAR:
                    output = (output * 0.89) + 2;
                        break;
                case OTHER_TWO_HANDED:
                    output = (output * 0.85) + 2;
                        break;
                case BLADES:
                    output = (output * 0.81) + 2;
                        break;
                case OTHER_DUAL_WIELDED: 
                    output = (output * 0.79) + 1;
                        break;
                default:
                    break;
            }
        }
        else
        {
            output = (output * 1.13) + 7;
        }
        
        return output;
    }
    
    // NANO OUTPUT 
    
    // END: OUTPUT BY WEAPON CALCULATIONS 
    /*******************************************************************************/

    
    
    // START: BASE ACCURACY CALCULATIONS 
    /*******************************************************************************/

    public double checkAccuracy(double argument)
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
    
    public double accuracyEvasionCalculator(double valueOne, double valueTwo, 
        double levelValue)
    {
        double result = Math.sqrt((valueOne + valueTwo) / (101 - levelValue)); 
            result = Math.sqrt(result) * 100;
                return result;
    }
    
    public double trueAccuracyValue(double userAccuracy, double targetEvasion)
    {
        return checkAccuracy((Math.sqrt(userAccuracy / (targetEvasion + 1)) * 100));
    }
    
    public double staminaAccuracy(GenericCharacter user, GenericCharacter target)
    {
        double userAccuracy = accuracyEvasionCalculator((user.getTotalAttack() 
            * 1.04), (user.getTotalAccuracy() * 1.08), user.getLevel());
                
        double targetEvasion = accuracyEvasionCalculator(target.getTotalDefense(), 
            target.getTotalDexterity(), target.getLevel());

        return trueAccuracyValue(userAccuracy, targetEvasion);
    }
    
    // Note: for status moves as well 
    public double nanoAccuracy(GenericCharacter user, GenericCharacter target)
    {
        double userAccuracy = accuracyEvasionCalculator((user.getTotalNanoAttack()
            * 1.12), (user.getTotalAccuracy() * 1.06), user.getLevel());
                
        double targetEvasion = accuracyEvasionCalculator((target.getTotalNanoDefense()
            * 0.96), (target.getTotalDexterity() * 0.94), target.getLevel());
        
        return trueAccuracyValue(userAccuracy, targetEvasion);
    }
    
    // END: BASE ACCURACY CALCULATIONS 
    /*******************************************************************************/
    
    
    
    // START: ACCURACY BY WEAPON CALCULATIONS 
    /*******************************************************************************/
    
    // STAMINA ACCURACY 
    
    public double staminaAccuracyByWeaponWielded(GenericCharacter user, GenericCharacter target, 
        Moves move)
    {
        double accuracy = staminaAccuracy(user, target);
        
        if(user.getWeapon() != null)
        {
            switch(user.getWeapon().getSuperTypeEnum())
            {
                case CLOSE_QUARTERS_COMBAT:
                    accuracy *= 1.03;
                        break;
                case SWORD:
                    accuracy *= 0.96;
                case KNIFE:
                    accuracy *= 1.01;
                        break;
                case OTHER_ONE_HANDED:
                    accuracy *= 0.98;
                        break; 
                case GREAT_SWORD:
                    accuracy *= 0.90;
                        break
                case SPEAR:
                    accuracy *= 0.96;
                        break;
                case OTHER_TWO_HANDED:
                    accuracy *= 0.93;
                        break;
                case BLADES:
                    accuracy *= 0.88;
                        break;
                case OTHER_DUAL_WIELDED: 
                    accuracy *= 0.86;
                        break;
                default:
                    break;
            }
        }
        else
        {
            accuracy *= 1.06;
        }
        
        return accuracy += move.getAccuracyModifier();
    }
    
    // STAMINA OUTPUT 
    
    
    // NANO OUTPUT 
    
    public double nanoAccuracyByWeaponWielded(GenericCharacter user, GenericCharacter target,
        Moves move)
    {
        double accuracy = staminaAccuracy(user, target);
        
        if(user.getWeapon() != null)
        {
            switch(user.getWeapon().getSuperTypeEnum())
            {
                case CLOSE_QUARTERS_COMBAT:
                    accuracy *= 1.08;
                        break;
                case SWORD:
                    accuracy *= 0.93;
                case KNIFE:
                    accuracy *= 0.86;
                        break;
                case OTHER_ONE_HANDED:
                    accuracy *= 0.98;
                        break; 
                case GREAT_SWORD:
                    accuracy *= 1.06;
                        break
                case SPEAR:
                    accuracy *= 1.03;
                        break;
                case OTHER_TWO_HANDED:
                    accuracy *= 1.01;
                        break;
                case BLADES:
                    accuracy *= 0.98;
                        break;
                case OTHER_DUAL_WIELDED: 
                    accuracy *= 0.96;
                        break;
                default:
                    break;
            }
        }
        else
        {
            accuracy *= 1.13;
        }
        
        return accuracy += move.getAccuracyModifier();
    }
    
    // NANO OUTPUT 
    
    // END: ACCURACY BY WEAPON CALCULATIONS 
    /*******************************************************************************/

    
    // START: BASE CRITICAL CALCULATIONS
    /*******************************************************************************/
    
    public double checkCritical(double argument)
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
    
    public double criticalCalculator(double totalCritical, double luck)
    {
        double userCritical = Math.sqrt(totalCritical + luck);
            return userCritical;
    }
    
    public double criticalResistanceCalculator(double totalDefense, double 
        totalNanoDefense, double totalDexterity)
    {
        double targetCriticalResistance = (totalDefense + totalNanoDefense + 
            + totalDexterity);
                return targetCriticalResistance;
    }
    
    public double trueCritical(double userCritical, double targetCriticalResistance)
    {
        return checkCritical((userCritical / (targetCriticalResistance + 1)));
    }
    
    public double staminaCritical(GenericCharacter user, GenericCharacter target)
    {
        double userCritical = criticalCalculator((user.getTotalCritical() * 1.15), 
            (user.getLuck() + 1));
        
        double targetCriticalResistance = criticalResistanceCalculator((target.
            getTotalDefense() * 0.94), (target.getTotalNanoDefense() * 0.96), 
            (target.getTotalDexterity() * 0.92));
        
        return trueCritical(userCritical, targetCriticalResistance);
    }
    
    public double nanoCritical(GenericCharacter user, GenericCharacter target)
    {
        double userCritical = criticalCalculator((user.getTotalCritical() * 1.22), 
            (user.getLuck() + 3));
        
        double targetCriticalResistance = criticalResistanceCalculator((target.
            getTotalDefense() * 0.92), (target.getTotalNanoDefense() * 0.95), 
            (target.getTotalDexterity() * 0.88));
        
        return trueCritical(userCritical, targetCriticalResistance);
    }
    
    // END: BASE STRESS EFFECT CALCULATIONS
    /*******************************************************************************/
    
    
    
    // START: CRITICAL BY WEAPON CALCULATIONS 
    /*******************************************************************************/
    
    // STAMINA CRITICAL 
    
    public double staminaCriticalByWeaponWielded(GenericCharacter user, GenericCharacter target, 
        Moves move)
    {
        double critical = staminaCritical(user, target);
        
        if(user.getWeapon() != null)
        {
            switch(user.getWeapon().getSuperTypeEnum())
            {
                case CLOSE_QUARTERS_COMBAT:
                    critical *= 1.05;
                        break;
                case SWORD:
                    critical *= 1.20;
                case KNIFE:
                    critical *= 1.14;
                        break;
                case OTHER_ONE_HANDED:
                    critical *= 1.12;
                        break; 
                case GREAT_SWORD:
                    critical *= 1.40;
                        break
                case SPEAR:
                    critical *= 1.31;
                        break;
                case OTHER_TWO_HANDED:
                    critical *= 1.24;
                        break;
                case BLADES:
                    critical *= 1.24;
                        break;
                case OTHER_DUAL_WIELDED: 
                    critical *= 1.18;
                        break;
                default:
                    break;
            }
        }
        else
        {
            critical *= 1.00;
        }
        
        return critical += move.getCriticalModifier();
    }
    
    // STAMINA OUTPUT 
    
    
    // NANO OUTPUT 
    
    public double nanoCriticalByWeaponWielded(GenericCharacter user, GenericCharacter target,
        Moves move)
    {
        double critical = nanoCritical(user, target, m);
        
        if(user.getWeapon() != null)
        {
            switch(user.getWeapon().getSuperTypeEnum())
            {
                case CLOSE_QUARTERS_COMBAT:
                    critical *= 1.08;
                        break;
                case SWORD:
                    critical *= 1.19;
                case KNIFE:
                    critical *= 1.14;
                        break;
                case OTHER_ONE_HANDED:
                    critical *= 1.10;
                        break; 
                case GREAT_SWORD:
                    critical *= 1.24;
                        break
                case SPEAR:
                    critical *= 1.24;
                        break;
                case OTHER_TWO_HANDED:
                    critical *= 1.20;
                        break;
                case BLADES:
                    critical *= 1.40;
                        break;
                case OTHER_DUAL_WIELDED: 
                    critical *= 1.31;
                        break;
                default:
                    break;
            }
        }
        else
        {
            critical *= 1.05;
        }
        
        return critical += move.getAccuracyModifier();
    }
    
    // NANO OUTPUT 
    
    // END: CRITICAL BY WEAPON CALCULATIONS 
    /*******************************************************************************/

    
    
    // START: UNIVERSAL WEAPON AND MOVE ENCHANTMENT FOR DAMAGE MOVES
    /*******************************************************************************/
    
    public double enchantmentCalculation(double baseEnchantment, double enchantmentResistance)
    {
        if(enchantmentResistance < 0)
        {
            // increase baseEnchantmentBonus if (-) enchantment resistance 
            baseEnchantment -= baseEnchantment + (baseEnchantment 
                * (((-1) * enchantmentResistance) / 100));
        }
        else if(enchantmentResistance >= 0)
        {
            // decrease baseEnchantmentBonus if (+) enchantment resistance 
            baseEnchantment += baseEnchantment - (baseEnchantment 
                * (enchantmentResistance / 100));
        }
        
        return baseEnchantment;
    }

    public double weaponEnchantment(GenericCharacter user, GenericCharacter target, 
        double ouputValue)
    {
        double result = 0.0;

        if(user.getWeapon() != null)
        {
            result += enchantmentCalculation((ouputValue * 0.36), target.
                getEnchantmentResistanceValueForKey(user.getWeapon().getEnchantment()));
        }

        return result;
    }

    public double moveEnchantment(GenericCharacter target, String moveEnchantmentName, 
        double ouputValue)
    {
        ouputValue += enchantmentCalculation((ouputValue * 0.45), target.
            getEnchantmentResistanceValueForKey(moveEnchantmentName));
                return ouputValue;
    }
    
    public double totalEnchantment(GenericCharacter user, GenericCharacter target, 
        Moves move, double ouputValue)
    {
        double result = 0.0;
        
        if(!target.getImmunityTypeState("Enchantment"))
        {
            if(move.getClassificationEnum() == Moves.Classifications.DAMAGE)
            {
                result += weaponEnchantment(user, target, ouputValue);
                result += moveEnchantment(target, move.getEnchantment(), ouputValue);
            }
        }
        
        return result; 
    }
    
    // END: WEAPON AND MOVE ENCHANTMENT BONUS
    /*******************************************************************************/
    
    
    
    // START: CRITICAL HIT BONUS 
    /*******************************************************************************/
    
    public double applyCritical(GenericCharacter user, GenericCharacter target, 
        double critical, double output)
    {
        SecureRandom rand = new SecureRandom();

        if(!user.equals(target))
        {
            if(critical >= (rand.nextInt(100) + 1))
            {
                output += (output * 2.67);
            }
        }
        else
        {
            if((critical * 1.55) >= (rand.nextInt(100) + 1))
            {
                output += (output * 3.21);
            }
        }

        return output;
    }
    
    // START: CRITICAL HIT BONUS 
    /*******************************************************************************/

    
    
    // START: STATES AFFECTING TOTAL OUTPUT VALUES 
    /*******************************************************************************/
    
    // Note: check for state AFTER total output is calculated 
    public double defendEffect(GenericCharacter target, Moves.Gauges gaugeTargeted, 
        double output)
    {
        if(target.statusExists("Defend"))
        {
            switch(gaugeTargeted)
            {
                case CURRENT_HEALTH:
                    output *= 0.5;
                case CURRENT_STAMINA:
                    output *= 0.3;
                case CURRENT_NANO:
                    output *= 0.85;
            }
        }
        
        return output;
    }
    
    // Note: check for state AFTER total output is calculated 
    public double nanoArmorEffect(GenericCharacter target, Moves.Gauges gaugeTargeted, 
        double output)
    {
        if(target.statusExists("Nano Armor"))
        {
            switch(gaugeTargeted)
            {
                case CURRENT_HEALTH:
                    output *= 0.15;
                case CURRENT_STAMINA:
                    output *= 0.25;
                case CURRENT_NANO:
                    output *= 0.70;
            }
        }
        
        return output;
    }
    
    // Note: check for state AFTER total output is calculated 
    public double statesReducingOutput(GenericCharacter target, Moves.Gauges gaugeTargeted, 
        double output)
    {
        output = defendEffect(target, gaugeTargeted, output);
        output = nanoArmorEffect(target, gaugeTargeted, output);
        return output;
    }
    
    // END: STATES AFFECTING TOTAL OUTPUT VALUES 
    /*******************************************************************************/
    
    
    
    // START: MOVE VARIANCE CALCULATION
    /*******************************************************************************/
    
    public double outputVarianceCalculation(double variance)
    {
        SecureRandom rand = new SecureRandom();
        
        int varianceAsInt = Math.abs((int)(variance * 100));
        
        varianceAsInt = (rand.nextInt(varianceAsInt) + 1);
        
        variance = (double)varianceAsInt / 100;
        
        return variance;
    }
    
    // Note: output will ALWAYS serve as base value for variance
    public double applyOutputVariance(double variance, double output)
    {
        double resultingVariance = (output * (outputVarianceCalculation(variance)));
        
        if(variance < 0.00)
        {
            output -= resultingVariance;
        }
        else
        {
            output += resultingVariance;
        }
        
        return output;
    }
    
    // END: MOVE VARIANCE CALCULATION
    /*******************************************************************************/
    
    
    
    // START: STAMINA/NANO MOVE OUTPUT/EFFECT ON DESIRED TARGET 
    /*******************************************************************************/
    
    public double positiveOrNegativeOutput(Moves move, double output)
    {
        if(move.getClassificationEnum() == Moves.Classifications.DAMAGE)
        {
            output *= -1;
        }
        
        return output;
    }
    
    public double totalOutput(GenericCharacter user, GenericCharacter target, 
        Moves move, double output, double critical)
    {
        output = moveEnchantment(user, move.getEnchantment(), output);

        output = weaponEnchantment(user, target, output);

        output = applyCritical(user, target, critical, output);

        output = applyOutputVariance(move.getOutputVariance(), output); 
        
        output = statesReducingOutput(target, move.getGaugeTargetedEnum(), output);
        
        output = positiveOrNegativeOutput(move, output);
        
        return output;
    }
    
    // END: STAMINA/NANO MOVE OUTPUT/EFFECT ON DESIRED TARGET 
    /*******************************************************************************/
    
    
    
    // START: APPLYING GAUGE EFFECTS TO USER/TARGET GAUGES 
    /*******************************************************************************/
    
    public void applyValueToGauge(GenericCharacter character, double output, Moves.
        Gauges choice)
    {
        if(character != null)
        {
            switch(choice)
            {
                case CURRENT_HEALTH:
                    character.setCurrentHealth(character.getCurrentHealth() + output);
                        break;
                case CURRENT_STAMINA:
                    character.setCurrentStamina(character.getCurrentStamina() + output);
                        break;
                case CURRENT_NANO:
                    character.setCurrentNano(character.getCurrentNano() + output);
                        break;
            }
        }
    }

    public void applyMoveCost(GenericCharacter user, Moves move)
    {
        // decrease gauge of user used to power move using move cost 
        applyValueToGauge(user, move.getMoveCost(), move.getGaugeUsedEnum());
    }
    
    // apply effects that using a move has on the user and on target 
    public void applyTotalOutputToTarget(GenericCharacter target, Moves move, double output)
    {
        if(output < 0)
        {
            if(!target.getImmunityTypeState("Damage"))
            {
                applyValueToGauge(target, output, move.getGaugeTargetedEnum());
            }
        }
        else if(output >= 0)
        {
            if(!target.getImmunityTypeState("Heal"))
            {
                applyValueToGauge(target, output, move.getGaugeTargetedEnum());
            }
        }
    }
    
    // END: APPLYING GAUGE EFFECTS TO USER/TARGET GAUGES 
    /*******************************************************************************/
    
    
    
    // START: ADDING/REMOVING STATUS EFFECTS 
    /*******************************************************************************/

    public int statusEffectResistance(GenericCharacter target, StatusEffect status)
    {
        int result = 0;

        if(!target.accessoryNegatesStatus(status))
        {
            if(target.getNanomachineState())
            {
                // store sum of target's resistance, immune and nano response 
                result = (int)target.getOrganismWithNanoTotalResistance(status.getName());
            }
            else
            {
                // store sum of target's resistance and immune response
                result = (int)target.getOrganismTotalResistance(status.getName());
            }
        }
        else
        {
            result = 100;
        }
        
        return result;
    }

    public void addStatusToTarget(GenericCharacter target, StatusEffect status)
    {
        int statusResistance = (int)statusEffectResistance(target, status);

        if(statusResistance < 100)
        {
            SecureRandom rand = new SecureRandom();
            
            int randStatusInflictRate = (rand.nextInt(status.getInflictRate()) + 1);

            int randStatusResistance = (rand.nextInt(statusResistance) + 1);

            if(randStatusInflictRate > randStatusResistance)
            {
                target.addStatus(status);

                target.updateImmuneResponseValueForKey(status.getName(), target.
                    getStatusImmuneResponseForKey(status.getName()) + (rand.
                    nextInt(3)) + 1);

                if(target.getNanomachineState())
                {
                    target.updateNanoResponseValueForKey(status.getName(), target.
                        getStatusNanoResponseForKey(status.getName()) + (rand.
                        nextInt(5)) + 3);
                }
            }
        }
    }

    public void addArrayListOfStatusesToTarget(GenericCharacter target, ArrayList
        <StatusEffect> statuses)
    {
        for(StatusEffect element : statuses)
        {
            addStatusToTarget(target, element);
        }
    }
    
    public void addWeaponStatuses(GenericCharacter user, GenericCharacter target)
    {
        if(user.getWeapon() != null && !user.getWeapon().getWeaponStatuses().isEmpty())
        {
            addArrayListOfStatusesToTarget(target, user.getWeapon().getWeaponStatuses());
        }
    }
    
    public void addMoveStatuses(GenericCharacter target, Moves move)
    {
        if(target != null && move.getStatusesMoveAdds() != null && !move.getStatusesMoveAdds().isEmpty())
        {
            addArrayListOfStatusesToTarget(target, move.getStatusesMoveAdds());
        }
    }
    
    public void applyStatuses(GenericCharacter user, GenericCharacter target, Moves move)
    {
        if(!target.getImmunityTypeState("Status"))
        {
            addWeaponStatuses(user, target);
            addMoveStatuses(target, move);
        }
    }
    
    // END: ADDING/REMOVING STATUS EFFECTS 
    /*******************************************************************************/



    // START: BASE STRESS EFFECT CALCULATIONS
    /*******************************************************************************/

    public double totalStressEffect(GenericCharacter character, double moveStressEffect)
    {
        double totalStressEffect = 0;
        
        if(character.getWeapon() != null)
        {
            totalStressEffect = character.getWeapon().getStressEffectUponAttack();
        }
        
        return (totalStressEffect + moveStressEffect);
    }
    
    // END: BASE STRESS EFFECT CALCULATIONS
    /*******************************************************************************/

    
    
    // START: ACCOUNTING FOR MOVE EFFECT ON DURABILITY
    /*******************************************************************************/

    public void applyUserWeaponDurabilityEffect(GenericCharacter user, Moves move)
    {
        if(user.getWeapon() != null)
        {
            user.getWeapon().setCurrentDurability(user.getWeapon().getMaxDurability() 
                + move.getUserWeaponDurabilityEffect());
        }
    }
    
    public void applyMoveDurabilityEffectsOnTarget(GenericCharacter target, Moves move)
    {
        if(target.getWeapon() != null)
        {
            target.getWeapon().setCurrentDurability(target.getWeapon().getMaxDurability() 
                + move.getWeaponDurabilityEffect());
        }
        
        if(target.getBodyArmor() != null)
        {
            target.getBodyArmor().setCurrentDurability(target.getBodyArmor().getMaxDurability() 
                + move.getBodyArmorDurabilityEffect());
        }
        
        if(target.getLegArmor() != null)
        {
            target.getLegArmor().setCurrentDurability(target.getLegArmor().getMaxDurability() 
                + move.getLegArmorDurabilityEffect());
        }
        
        if(target.getFootArmor() != null)
        {
            target.getFootArmor().setCurrentDurability(target.getFootArmor().getMaxDurability() 
                + move.getFootArmorDurabilityEffect());
        }
        
        if(target.getAccessoryOne() != null)
        {
            target.getAccessoryOne().setCurrentDurability(target.getAccessoryOne().getMaxDurability() 
                + move.getAccessoryOneDurabilityEffect());
        }
        
        if(target.getAccessoryTwo() != null)
        {
            target.getAccessoryTwo().setCurrentDurability(target.getAccessoryTwo().getMaxDurability() 
                + move.getAccessoryTwoDurabilityEffect());
        }
    }
    
    public void applyMoveDurabilityEffects(GenericCharacter user, GenericCharacter target, 
        Moves move)
    {
        applyUserWeaponDurabilityEffect(user, move);
        applyMoveDurabilityEffectsOnTarget(target, move);
    }
    
    // END: ACCOUNTING FOR MOVE EFFECT ON DURABILITY
    /*******************************************************************************/

    
    
    // START: STAMINA/NANO MOVE OUTPUT/EFFECT ON DESIRED TARGET 
    /*******************************************************************************/
    
    // Note: 0 denotes move missed target
    public double outputBasedOnAccuracy(GenericCharacter user, GenericCharacter target, 
        Moves move, double accuracy, double output, double critical)
    {
        SecureRandom rand = new SecureRandom();
        
        if(accuracy >= (rand.nextInt(100) + 1))
        {
            output = totalOutput(user, target, move, output, critical);
        }
        else
        {
            output = 0.0;
        }

        return output;
    }
    
    public void targetDamaged(GenericCharacter target, double output)
    {
        if(output < 0)
        {
            target.setDamagedState(true);
        }
    }
    
    public void postOutputTasks(GenericCharacter user, GenericCharacter target, 
        Moves move, double output)
    {
        // if output is not 0 (has NOT missed), then account for move effects 
        if(output != 0.0)
        {
            // set damaged state to true if move hurts target (negative output)
            targetDamaged(user, output);
            
            // apply status effects to target using user weapon and move statuses 
            applyStatuses(user, target, move);
            
            // apply effect move has on durability of equipped outfits 
            applyMoveDurabilityEffects(user, target, move);
            
            // apply stress move and user's weapon have on target's stress gauge 
            target.setCurrentStress(target.getCurrentStress() + totalStressEffect(user,
                move.getStressEffect()));
            
            // apply effect move has on on target
            applyTotalOutputToTarget(target, move, output);
            
            // set battle dexterity of user based off move speed 
            user.setBattleDexterity(user, move.getMoveSpeed());
        }
    }
    
    public boolean moveAffectsTarget(GenericCharacter target, Moves move)
    {
        boolean result = false;
        
        if(!target.getImmunityTypeState(move.getApproachString()))
        {
            if(!target.getImmunityTypeState(move.getStyleString()))
            {
                if(!target.getImmunityTypeState(move.getTechniqueString()))
                {
                    result = true;
                }
            }
        }
        
        return result;
    }
    
    public void staminaNanoMove(GenericCharacter user, GenericCharacter target, 
        Moves move, double accuracy, double output, double critical, double 
        outputModifier)
    {
        applyMoveCost(user, move);
        
        if(moveAffectsTarget(target, move))
        {
            for(int i = 0; i < move.getTimesMoveAffectsTarget(); i++)
            {
                output = (outputBasedOnAccuracy(user, target, move, accuracy, 
                    output, critical) * outputModifier);

                postOutputTasks(user, target, move, output);
            }
        }
    }
    
    // END: STAMINA/NANO MOVE OUTPUT/EFFECT ON DESIRED TARGET 
    /*******************************************************************************/
    
    /* move selection and application
        move is chosen from move set
            user prompted to select target(s) that are NOT knocked out ("KO")or 
            not (can exit move selection here) based off of move.ValidTargets 
    
            move target by selection: 
                Standard Single 
                    pq contents have characters numbered 0 - pq.length for selection
                        ex: player/character selects target "Brad" that exists in the
                            pq by implicitly selecting the slot position that "Brad"
                            occupies within the pq (If "Brad" at slot 3 then object 
                            at slot 3 is retrieved)
                Standard Many
                    selection made by choosing one of the two parties supplied where 
                    opposing and user parties are numbered by priority based on move
                    effect (opposing party is 0 for damage and 1 for non-damage; user 
                    party is 0 for non-damage effects and 1 for damage effects) 
            move target NOT determined by manual selection: 
                Random Single 
                    pq contents have characters numbered 0 - pq.length and target of 
                    move is selected at random: int target = rand.nextInt(pq.length))
                Random Many
                    Random Party
                        user or opposing party is selected at random such that all its
                        members are made subject to move (0 for user party and 1 for 
                        opposing party such that: int targetParty = rand.nextInt(2) 
                        where rand.nextInt(n) returns numbers from (n - 1))
                    Random All
                        pq contents have characters numbered 0 - pq.length such that all 
                        characters may be made subject to move (characters belonging to
                        user party are less likely to be made subject to move than those 
                        in opposing party) 
            move targets "All" members and its variants
                All 
                    pq contents have characters numbered 0 - pq.length and all characters 
                    in pq are made subject to move 
                All Except User
                    pq contents have characters numbered 0 - pq.length and all characters 
                    in pq EXCEPT user is made subject to move 
            
            once move is confirmed (as in player accepts result) then stuff is supplied to 
            move in order for move to execute 
                upon move confirmation, move COST is taken ONLY once (this is done in order 
                to prevent moves that hit multiple targets from sapping points from gauge 
                that powers the move) 
    
            move is executed a per character basis
    */
    
    // START: COMPARATOR SORTING STRINGS
    /*******************************************************************************/
    
    // method used in comparators for TreeMaps involving string comparison between keys
    public int compareStrings(String argumentOne, String arguementTwo)
    {
        // code compares names without regard to case and stores result of comparison 
        // (1, 0, -1) in stringComparisonResult (1 & -1 is different while 0 is same)
        int stringComparisonResult = String.CASE_INSENSITIVE_ORDER.compare(argumentOne, arguementTwo);

        // if strings are identical, set stringComparisonResult to 1 in order to place 
        // entry after the entry it is being compared to since order does not matter
        if(stringComparisonResult == 0)
        {
            stringComparisonResult = 1;
        }

        return stringComparisonResult;
    }
    
    public Comparator<GenericCharacter> sortByName = (GenericCharacter characterOne, 
        GenericCharacter characterTwo) -> compareStrings(characterOne.getName(), 
        characterTwo.getName()); 
    
    // START: COMPARATOR SORTING STRINGS
    /*******************************************************************************/


    
    // START: SORT NON-KO COMBATANTS BY PARTY AND BY NAME USING MOVE EFFECT 
    /*******************************************************************************/
    
    public void divideCharactersByParty(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, ArrayList<GenericCharacter> partyOne, ArrayList<GenericCharacter> 
        partyTwo, Moves move)
    {
        for(GenericCharacter element : charactersInBattle)
        {
            if(move.getClassificationEnum() == Moves.Classifications.DAMAGE)
            {
                if(!element.knockedOut())
                {
                    if(userParty.partyMemberExists(element))
                    {
                        partyOne.add(element);
                    }
                    else
                    {
                        partyTwo.add(element);
                    }
                }
            }
            else
            {
                if(userParty.partyMemberExists(element))
                {
                    partyOne.add(element);
                }
                else
                {
                    partyTwo.add(element);
                }
            }
        }
    }
    
    public void sortArrayListByName(PriorityQueue<GenericCharacter> priorityQueue, 
        ArrayList<GenericCharacter> arrayList)
    {
        for(GenericCharacter element : arrayList)
        {
            priorityQueue.add(element);
        }
        
        arrayList.clear();
        
        for(GenericCharacter element : priorityQueue)
        {
            arrayList.add(element);
        }
    }
    
    public void addContents(ArrayList<GenericCharacter> receiver, ArrayList
        <GenericCharacter> sender)
    {
        for(GenericCharacter element : sender)
        {
            receiver.add(element);
        }
    }
    
    public ArrayList<GenericCharacter> orderByMoveClassification(ArrayList<GenericCharacter> 
        userParty, ArrayList<GenericCharacter> opposingParty, ArrayList<GenericCharacter> 
        charactersSortedByName, Moves move)
    {
        if(move.getClassificationEnum() == Moves.Classifications.DAMAGE)
        {
            addContents(charactersSortedByName, opposingParty);
            addContents(charactersSortedByName, userParty);
        }
        else
        {
            addContents(charactersSortedByName, userParty);
            addContents(charactersSortedByName, opposingParty);
        }
        
        return charactersSortedByName;
    }
    
    public ArrayList<GenericCharacter> returnPqContentsSortedByPartyByName(PriorityQueue
        <GenericCharacter> priorityQueue, Party userParty, Moves move)
    {
        // knowing that pq will always be even (at least 1 user & 1 opposing party) 
        // we need to cut pq contents in half so that we can sort each half by name 
        // before characters are brought togther as dictated by move classification

        ArrayList<GenericCharacter> tempUserParty = new ArrayList<>();

        ArrayList<GenericCharacter> tempOpposingParty = new ArrayList<>();

        divideCharactersByParty(priorityQueue, userParty, tempUserParty, tempOpposingParty, move);
        
        PriorityQueue<GenericCharacter> pqSortsByName = new PriorityQueue<>(sortByName);

        sortArrayListByName(pqSortsByName, tempUserParty);
        
        sortArrayListByName(pqSortsByName, tempOpposingParty);
        
        ArrayList<GenericCharacter> bothParties = new ArrayList<>();

        return orderByMoveClassification(tempUserParty, tempOpposingParty, bothParties, move);
    }
    
    // END: SORT NON-KO COMBATANTS BY PARTY AND BY NAME USING MOVE EFFECT 
    /*******************************************************************************/

    
    
    // START: PERFORM MOVE
    /*******************************************************************************/
    
    public void performMoveSingleTarget(PriorityQueue<GenericCharacter> charactersInBattle, Party 
        userParty, Party targetParty, GenericCharacter user, GenericCharacter target, 
        Moves move)
    {
        double accuracy, output, critical;
        
        switch(Moves.getApproachEnumUsingString(move.getApproach()))
        {
            case STAMINA:
                accuracy = staminaAccuracy(user, target) * move.getOutputModifier();
                output = staminaOutput(user, target);
                critical = staminaCriitical(user, target, move.getCriticalModifier());
                
                moveLogic(charactersInBattle, userParty. targetParty, user, target, 
                    move, accuracy, output, critical);
                
            case NANO:
                
                
            case SPECIAL:
                
                
            case ITEM:
                // item here?
                
        }
    }
    
    public void performMovePartyTarget(PriorityQueue<GenericCharacter> charactersInBattle, Party 
        userParty, Party targetParty, GenericCharacter user, Party target, Moves move)
    {
        double accuracy, output, critical;
        
        switch(Moves.getApproachEnumUsingString(move.getApproach()))
        {
            case STAMINA:
                accuracy = staminaAccuracy(user, target) * move.getOutputModifier();
                output = staminaOutput(user, target);
                critical = staminaCriitical(user, target, move.getCriticalModifier());
                
                moveLogic(charactersInBattle, userParty. targetParty, user, target, 
                    move, accuracy, output, critical);
                
            case NANO:
                
                
            case SPECIAL:
                
                
            case ITEM:
                // item here?
                
        }
    }
    
    // END: PERFORM MOVE
    /*******************************************************************************/

    
    
    // START: SINGLE TARGET SELECTION FOR MOVE
    /*******************************************************************************/

    public void displaySingleTargetOptions(ArrayList<GenericCharacter> 
        activeCharacters)
    {
        for(int i = 0; i < activeCharacters.size() + 1; i++)
        {
            if(i != activeCharacters.size())
            {
                if((i % 2 == 0))
                {
                    System.out.printf("%-26s\t", activeCharacters.get(i).getName());
                }
                else if((i % 2 == 1))
                {
                    System.out.printf("%-26s\n", activeCharacters.get(i).getName());
                }
            }
            else
            {
                System.out.printf("-26%s", "Cancel Move");
            }
        }
    }
    
    public int checkTargetChoice(int maxNumberOfTargets, int choice)
    {
        if(choice < 0)
        {
            choice = 0;
        }
        else if(choice > maxNumberOfTargets)
        {
            choice = maxNumberOfTargets;
        }
        
        return choice;
    }
    
    public GenericCharacter singleTargetChoice(ArrayList<GenericCharacter> activeCharacters)
    {
        Scanner sc = new Scanner(System.in);
        
        GenericCharacter result = null;        
        
        int option = checkTargetChoice(activeCharacters.size() + 1, sc.nextInt());
        
        if(option <= activeCharacters.size())
        {
            result = activeCharacters.get(option);
        }
        
        return result;
    }
    
    // account for cancelMove!!! after move execution
    public void postSingleTargetChoiceBehavior(GenericCharacter user, GenericCharacter 
        target, Moves move)
    {
        if(target == null)
        {
            cancelMove(true);
                return;
        }
        else
        {
            performMove(user, target, move);
        }
    } 
        
    public void userSelection(GenericCharacter user, Moves move)
    {
        ArrayList<GenericCharacter> activeCharacters = new ArrayList<>();
        
        activeCharacters.add(user);
        
        displaySingleTargetOptions(activeCharacters);
        
        GenericCharacter target = singleTargetChoice(activeCharacters);
        
        postSingleTargetChoiceBehavior(user, target, move);
    } 
    
    public void anySelection(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, GenericCharacter user, Moves move)
    {
        ArrayList<GenericCharacter> activeCharacters = returnPqContentsSortedByPartyByName
            (charactersInBattle, userParty, move);
        
        displaySingleTargetOptions(activeCharacters);
        
        GenericCharacter target = singleTargetChoice(activeCharacters);
        
        postSingleTargetChoiceBehavior(user, target, move);
    } 
        
    public void anyExceptUserSelection(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, GenericCharacter user, Moves move)
    {
        ArrayList<GenericCharacter> activeCharacters = returnPqContentsSortedByPartyByName
            (charactersInBattle, userParty, move);
        
        activeCharacters.remove(user);
        
        displaySingleTargetOptions(activeCharacters);
        
        GenericCharacter target = singleTargetChoice(activeCharacters);
        
        postSingleTargetChoiceBehavior(user, target, move);
    } 

    public void removeDuplicates(ArrayList<GenericCharacter> arrayList, Party party)
    {
        for(GenericCharacter element : arrayList)
        {
            if(party.partyMemberExists(element))
            {
                arrayList.remove(element);
            }
        }
    }
    
    public void anyPartyMemberSelection(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party opposingParty, GenericCharacter user, Moves move)
    {
        ArrayList<GenericCharacter> activeCharacters = returnPqContentsSortedByPartyByName
            (charactersInBattle, userParty, move);
        
        removeDuplicates(activeCharacters, opposingParty);
        
        displaySingleTargetOptions(activeCharacters);
        
        GenericCharacter target = singleTargetChoice(activeCharacters);
        
        postSingleTargetChoiceBehavior(user, target, move);
    } 
    
    public void anyOpposingPartyMemberSelection(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party opposingParty, GenericCharacter user, Moves move)
    {
        ArrayList<GenericCharacter> activeCharacters = returnPqContentsSortedByPartyByName
            (charactersInBattle, userParty, move);
        
        removeDuplicates(activeCharacters, userParty);
        
        displaySingleTargetOptions(activeCharacters);
        
        GenericCharacter target = singleTargetChoice(activeCharacters);
        
        postSingleTargetChoiceBehavior(user, target, move);
    } 
    
    // END: SINGLE TARGET SELECTION FOR MOVE
    /*******************************************************************************/
    
    
    
    // START: SINGLE PARTY TARGET SELECTION FOR MOVE
    /*******************************************************************************/
    
    public void displayAnyPartySelection(Moves move)
    {
        if(move.getClassificationEnum() == Moves.Classifications.DAMAGE)
        {
            System.out.printf("%-26s\t%-26s\n%-26s", "Opposing Party", "User Party", "Cancel Move");
        }
        else
        {
            System.out.printf("%-26s\t%-26s\n%-26s", "User Party", "Opposing Party", "Cancel Move");
        }
    }
    
    public Party anyPartyTargetChoice(Party userParty, Party targetParty,
        Moves move)
    {
        Scanner sc = new Scanner(System.in);
        
        Party result = null;
        
        if(move.getClassificationEnum() == Moves.Classifications.DAMAGE)
        {
            switch(checkTargetChoice(2, sc.nextInt()))
            {
                case 0:
                    result = targetParty;
                        break;
                case 1:
                    result = userParty;
                        break;
                default:
                    break;
            }
        }
        else
        {
            switch(checkTargetChoice(2, sc.nextInt()))
            {
                case 0:
                    result = userParty;
                        break;
                case 1:
                    result = targetParty;
                        break;
                default:
                    break;
            }
        }
        
        return result;
    }
    
    public void activePartyMembers(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party suppliedParty, ArrayList<GenericCharacter> arrayList, Moves move)
    {
        for(GenericCharacter element : charactersInBattle)
        {
            if(suppliedParty.partyMemberExists(element))
            {
                if(move.getClassificationEnum() == Moves.Classifications.DAMAGE)
                {
                    if(!element.knockedOut())
                    {
                        arrayList.add(element);
                    }
                }
                else
                {
                    arrayList.add(element);
                }
            }
        }
    }
    
    // account for cancelMove!!! after move execution
    public void postAnyPartyTargetChoiceBehavior(GenericCharacter user, ArrayList
        <GenericCharacter> activeTargetCharacters, Moves move)
    {
        if(activeTargetCharacters == null)
        {
            cancelMove(true);
                return;
        }
        else
        {
            performMove(user, activeTargetCharacters, move);
        }
    }
    
    public void anyPartySelection(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party targetParty, GenericCharacter user, Moves move)
    {
        displayAnyPartySelection(move);
        
        Party target = anyPartyTargetChoice(userParty, targetParty, move);
        
        ArrayList<GenericCharacter> activeTargetCombatants = new ArrayList<>();
        
        activePartyMembers(charactersInBattle, target, activeTargetCombatants, move);
        
        postAnyPartyTargetChoiceBehavior(user, activeTargetCombatants, move);
    } 
    
    public void displayPartyOwnershipSelection(String partyOwnership)
    {
        System.out.printf("%-26s\t%-26s", partyOwnership, "Cancel Move");
    }
    
    public Party singlePartyTargetChoice(Party party)
    {
        Scanner sc = new Scanner(System.in);
        
        Party result = null;
        
        if(checkTargetChoice(1, sc.nextInt()) == 0)
        {
            result = party;
        }
        
        return result;
    }
    
    public void userPartySelection(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, GenericCharacter user, Moves move)
    {
        displayPartyOwnershipSelection("User Party");
        
        Party target = singlePartyTargetChoice(userParty);
        
        ArrayList<GenericCharacter> activeTargetCombatants = new ArrayList<>();
        
        activePartyMembers(charactersInBattle, target, activeTargetCombatants, move);
        
        postAnyPartyTargetChoiceBehavior(user, activeTargetCombatants, move);
    } 

    public void opposingPartySelection(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party opposingParty, GenericCharacter user, Moves move)
    {
        displayPartyOwnershipSelection("Opposing Party");
        
        Party target = singlePartyTargetChoice(opposingParty);
        
        ArrayList<GenericCharacter> activeTargetCombatants = new ArrayList<>();
        
        activePartyMembers(charactersInBattle, target, activeTargetCombatants, move);
        
        postAnyPartyTargetChoiceBehavior(user, activeTargetCombatants, move);

    } 
    
    // END: SINGLE PARTY TARGET SELECTION FOR MOVE
    /*******************************************************************************/
    
    
    
    
    
    left off here...
    
    
    // START: RANDOM SINGLE TARGET
    /*******************************************************************************/

    public GenericCharacter selectCharacterAtRandom(ArrayList<GenericCharacter> 
        activeCombatants)
    {
        SecureRandom rand = new SecureRandom();
        
        int result = rand.nextInt(activeCombatants.size());
        
        GenericCharacter character = null;
        
        for(int i = 0; i < activeCombatants.size(); i++)
        {
            if(result == i)
            {
                if(!activeCombatants.get(i).knockedOut())
                {
                    character = activeCombatants.get(i);
                }
            }
        }
        
        if(character == null)
        {
            selectCharacterAtRandom(activeCombatants);
        }
        
        return character;
    }
    
    public void randomAnyTarget(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party targetParty, GenericCharacter user, Moves move)
    {
        ArrayList<GenericCharacter> activeCombatants = new ArrayList<>(charactersInBattle);
        
        GenericCharacter target = selectCharacterAtRandom(activeCombatants);
        
        performMove(charactersInBattle, userParty, targetParty, user, target, move);
    } // account for cancelMove!!! after move execution
    
    public void randomAnyExceptUserTarget(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party targetParty, GenericCharacter user, Moves move)
    {
        ArrayList<GenericCharacter> activeCombatants = new ArrayList<>(charactersInBattle);
        
        activeCombatants.remove(user);
        
        GenericCharacter target = selectCharacterAtRandom(activeCombatants);
        
        performMove(charactersInBattle, userParty, targetParty, user, target, move);
    } // account for cancelMove!!! after move execution
    
    public void randomAnyPartyMemberTarget(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party targetParty, GenericCharacter user, Moves move)
    {
        ArrayList<GenericCharacter> activeCombatants = new ArrayList<>(charactersInBattle);
        
        removeDuplicates(activeCombatants, targetParty);
        
        GenericCharacter target = selectCharacterAtRandom(activeCombatants);
        
        performMove(charactersInBattle, userParty, targetParty, user, target, move);
    } // account for cancelMove!!! after move execution

    public void randomAnyOpposingPartyMemberTarget(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party targetParty, GenericCharacter user, Moves move)
    {
        ArrayList<GenericCharacter> activeCombatants = new ArrayList<>(charactersInBattle);
        
        removeDuplicates(activeCombatants, userParty);
        
        GenericCharacter target = selectCharacterAtRandom(activeCombatants);
        
        performMove(charactersInBattle, userParty, targetParty, user, target, move);
    } // account for cancelMove!!! after move execution
    
    // END: RANDOM SINGLE TARGET
    /*******************************************************************************/

    
    
    // START: RANDOM SINGLE PARTY AND RANDOM ALL
    /*******************************************************************************/

    public Party selectPartyAtRandom(Party userParty, Party targetParty)
    {
        SecureRandom rand = new SecureRandom();
        
        Party target = null;
        
        if(rand.nextInt(2) == 0)
        {
            target = userParty;
        }
        else
        {
            target = targetParty;
        }
        
        return target;
    }
    
    public void randomSingleParty(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party targetParty, GenericCharacter user, Moves move)
    {
        Party target = selectPartyAtRandom(userParty, targetParty);
        
        performMove(charactersInBattle, userParty, targetParty, user, target, move);
    } // account for cancelMove!!! after move execution
    
    // need to account for times struck in output portion... 
    public void randomAll(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party targetParty, GenericCharacter user, Moves move)
    {
        SecureRandom rand = new SecureRandom();
        
        for(GenericCharacter element : charactersInBattle)
        {
            if(!element.knockedOut())
            {
                if(userParty.partyMemberExists(element))
                {
                    if((rand.nextInt(100) + 1) <= 45)
                    {
                        performMove(charactersInBattle, userParty, targetParty, user, element, move);
                    }
                }
                else
                {
                    if((rand.nextInt(100) + 1) <= 75)
                    {
                        performMove(charactersInBattle, userParty, targetParty, user, element, move);
                    }
                }
            }
        }
    } // account for cancelMove!!! after move execution
    
    // END: RANDOM SINGLE PARTY AND RANDOM ALL
    /*******************************************************************************/

    
    
    // START: TARGET ALL VARIANTS
    /*******************************************************************************/

    public void allTargets(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party targetParty, GenericCharacter user, Moves move)
    {
        for(GenericCharacter element : charactersInBattle)
        {
            performMove(charactersInBattle, userParty, targetParty, user, element, move);
        }
    } // account for cancelMove!!! after move execution

    public void allTargetsExceptUser(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party targetParty, GenericCharacter user, Moves move)
    {
        for(GenericCharacter element : charactersInBattle)
        {
            if(!element.equals(user))
            {
               performMove(charactersInBattle, userParty, targetParty, user, element, move);
            }
        }
    } // account for cancelMove!!! after move execution
    
    // END: TARGET ALL VARIANTS
    /*******************************************************************************/

    
    
    // START: 
    /*******************************************************************************/
    
    // move this to command list for character in battle 
    public void moveLogic(PriorityQueue<GenericCharacter> charactersInBattle, 
        Party userParty, Party opposingParty, GenericCharacter user, Moves move)
    {
        switch(move.getTargetAsEnum())
        {
            case USER: 
                // logic for single move
            case ANY: 
            case ANY_EXCEPT_USER:
            case ANY_PARTY_MEMBER:
            case ANY_OPPOSING_PARTY_MEMBER:
            case ANY_PARTY:

            case USER_PARTY:
            case OPPOSING_PARTY:

            case RANDOM_ANY:
            case RANDOM_ANY_EXCEPT_USER:
            case RANDOM_ANY_PARTY_MEMBER: 
            case RANDOM_ANY_OPPOSING_PARTY_MEMBER: 
            case RANDOM_ANY_PARTY:
            case RANDOM_ALL: 

            case ALL: 
            case ALL_EXCEPT_USER: 
                
            
        }
    }
    
    
    // END: POST OUTPUT CALCULATION
    /*******************************************************************************/
}