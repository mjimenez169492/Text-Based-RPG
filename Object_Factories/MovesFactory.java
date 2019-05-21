package Object_Factories;

import Move_Creation.Moves;

public class MovesFactory 
{
    public Moves getItemMoveHealExample()
    {
        Moves move = new Moves();
        
        move.setName("exampleMove");
        move.setDescription("What move description should look like");
        
        move.setApproach("Item");
        move.setStyle("Other Moves");
        move.setTechnique("Other Moves");
        
        move.setGaugeUsed("None");
        move.addGaugeTargeted("Current Health");
        
        move.setEnchantment("None");
        move.setMoveAvailabilityStatus("None");
        
        move.usableFromMainMenu(true);
        move.usableInBattle(true);
        move.usableIfKnockedDown(false);
        move.usableIfGrabbed(false);
        move.usableIfAirborne(false);
        
        move.setTarget("All");
        move.setTimesMoveAffectsTarget(1);
        
        move.setMoveUsedText(" used item!");
        move.setMoveMissedText(" item missed!");
        move.setMoveFailedText(" item failed!");
        
        move.parryable(false);
        move.counterable(false);
        move.guardable(false);
        move.grabBlockable(false);
        
        move.addStatusMoveAdds(new StatusEffectFactory().getStatusEffectExample());
        move.addStatusNegatingMove("None");
        move.addStatusesMoveRemoves("None");
        
        move.setUserWeaponDurabilityEffect(0);
        move.setWeaponDurabilityEffect(0);
        move.setBodyArmorDurabilityEffect(0);
        move.setLegArmorDurabilityEffect(0);
        move.setFootArmorDurabilityEffect(0);
        move.setAccessoryOneDurabilityEffect(0);
        move.setAccessoryTwoDurabilityEffect(0);
        
        move.setClassification("Item");
        
        move.setCustomAccuracy(100);
        move.setCustomOutput(12);
        move.setCustomCritical(1);
        
        move.setMoveCost(0);
        move.setOutputVariance(0);
        move.setAccuracyModifier(0);
        move.setOutputModifier(0);
        move.setCriticalModifier(0);
        move.setCriticalModifier(0);
        move.setStressEffect(0);
        move.setMoveSpeed(0);
        
        move.setMasteryValue(0);
        move.setCurrentValue(0);
        move.setMoveMasteryState(false);
        
        return move;
    }
    
    public Moves getItemMoveDamageExample()
    {
        Moves move = new Moves();
        
        move.setName("exampleMove");
        move.setDescription("What move description should look like");
        
        move.setApproach("Item");
        move.setStyle("Other Moves");
        move.setTechnique("Other Moves");
        
        move.setGaugeUsed("None");
        move.addGaugeTargeted("Current Health");
        
        move.setEnchantment("None");
        move.setMoveAvailabilityStatus("None");
        
        move.usableFromMainMenu(true);
        move.usableInBattle(true);
        move.usableIfKnockedDown(false);
        move.usableIfGrabbed(false);
        move.usableIfAirborne(false);
        
        move.setTarget("Any");
        move.setTimesMoveAffectsTarget(1);
        
        move.setMoveUsedText(" used item!");
        move.setMoveMissedText(" item missed!");
        move.setMoveFailedText(" item failed!");
        
        move.parryable(false);
        move.counterable(false);
        move.guardable(false);
        move.grabBlockable(false);
        
        move.addStatusMoveAdds(new StatusEffectFactory().getStatusEffectExample());
        move.addStatusNegatingMove("None");
        move.addStatusesMoveRemoves("None");
        
        move.setUserWeaponDurabilityEffect(0);
        move.setWeaponDurabilityEffect(0);
        move.setBodyArmorDurabilityEffect(0);
        move.setLegArmorDurabilityEffect(0);
        move.setFootArmorDurabilityEffect(0);
        move.setAccessoryOneDurabilityEffect(0);
        move.setAccessoryTwoDurabilityEffect(0);
        
        move.setClassification("Item");
        
        move.setCustomAccuracy(100);
        move.setCustomOutput(-12);
        move.setCustomCritical(1);
        
        move.setMoveCost(0);
        move.setOutputVariance(0);
        move.setAccuracyModifier(0);
        move.setOutputModifier(0);
        move.setCriticalModifier(0);
        move.setCriticalModifier(0);
        move.setStressEffect(0);
        move.setMoveSpeed(0);
        
        move.setMasteryValue(0);
        move.setCurrentValue(0);
        move.setMoveMasteryState(false);
        
        return move;
    }
    
    
}
