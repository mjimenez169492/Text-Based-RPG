package Object_Factories;

import Move_Creation.StatusEffect;

public class StatusEffectFactory 
{
    public StatusEffect getStatusEffectExample()
    {
        StatusEffect status = new StatusEffect();
        
        status.setName("Toxic");
        
        status.setTurns(3);
        
        status.permanent(false);
        
        status.setInflictionRate(50);
        
        status.decrementAtStartOfTurn(true);
        
        status.removeAfterKnockOut(true);
        
        status.removeAfterBattle(true);
        
        status.addStatNameAndDoubleEffect("Current Health", 0.25);
        status.addStatNameAndDoubleEffect("Attack", 0.50);
        status.addStatNameAndDoubleEffect("Defense", 1.00);
        
        return status;
    }
    
    
    
}
