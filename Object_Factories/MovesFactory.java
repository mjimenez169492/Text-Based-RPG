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
        move.setMoveSpeed(0);
        
        move.setMasteryValue(0);
        move.setCurrentValue(0);
        move.setMoveMasteryState(false);
        
        return move;
    }
    
    // see "new 46" for moves object creation data
    public Moves getStandardAttack()
    {
        Moves move = new Moves();
        
        move.setName("Attack");
        move.setDescription("User damages the target.");
        
        move.setApproach("Stamina");
        move.setStyle("Universal Stamina");
        move.setTechnique("Universal Stamina");
        
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
        
        move.setMoveUsedText(" attacked!");
        move.setMoveMissedText("But the attack missed!");
        move.setMoveFailedText("But it failed!");
        
        move.parryable(false);
        move.counterable(false);
        move.guardable(false);
        move.grabBlockable(false);
        
        move.addStatusMoveAdds(null);
        move.addStatusNegatingMove("None");
        move.addStatusesMoveRemoves("None");
        
        move.setUserWeaponDurabilityEffect(0);
        move.setWeaponDurabilityEffect(0);
        move.setBodyArmorDurabilityEffect(0);
        move.setLegArmorDurabilityEffect(0);
        move.setFootArmorDurabilityEffect(0);
        move.setAccessoryOneDurabilityEffect(0);
        move.setAccessoryTwoDurabilityEffect(0);
        
        move.setClassification("Damage");
        
        move.setCustomAccuracy(0);
        move.setCustomOutput(0);
        move.setCustomCritical(0);
        
        move.setMoveCost(0);
        move.setOutputVariance(0.30);
        move.setAccuracyModifier(3);
        move.setOutputModifier(0.12);
        move.setCriticalModifier(15);
        move.setMoveSpeed(1.15);
        
        move.setMasteryValue(0);
        move.setCurrentValue(0);
        move.setMoveMasteryState(false);
        
        return move;
    }
    
}
