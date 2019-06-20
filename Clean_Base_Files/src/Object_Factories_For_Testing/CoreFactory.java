package Object_Factories_For_Testing;

import Generic_Object.Core;

public class CoreFactory 
{
    public Core getCoreExample()
    {
        Core core = new Core();
        
        core.setName("Core");
        core.setBriefDescription("A tiny pair of boxing gloves. A nice gift");
        core.setMainClass("Core");
        core.setCoreCategory("Standard");
        core.setCoreSuperType("Attribute");
        core.setCoreSubType("Attack");
        
        core.setUseSpeed(1.00);
        core.setBuyPrice(10);
        core.setSellPrice(15);
        core.setStealRate(0);
        core.setPilferRate(11);
        core.setDropRate(3);
        
        core.setSpecialCoreState(false);
        core.setCoreType("Attack");
        core.setCoreSize("Very Small");
        core.setCoreTier("Tier 1");
        core.setMaxCorePoints();
        core.setCurrentCorePoints(5.99);
        
        return core;
    }
}
