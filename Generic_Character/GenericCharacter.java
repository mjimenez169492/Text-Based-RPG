package Generic_Character;

/* 
    GenericCharacter uses composition in order to form GenericCharacter objects
    representing characters that can battle in the game world. Classes involved
    in composition includes all classes in package Generic_Character. 
*/

public class GenericCharacter 
{
    // holds objects created using classes in package Generic_Character 
    StatusEffectContainer statusEffectContainer = new StatusEffectContainer();
    
    Stats stats = new Stats();
    
    EquippableOutfits equippableOutfits = new EquippableOutfits(stats);
    
    TotalStats totalStats = new TotalStats(statusEffectContainer, equippableOutfits);
    
    MoveImmunity moveImmunity = new MoveImmunity();
    
    SkillsForSkillPoints skillsForSkillPoints = new SkillsForSkillPoints();
    
    Moveset moveset = new Moveset(equippableOutfits.getWeapon(), statusEffectContainer);
    
    OppositionMethods oppositionMethods = new OppositionMethods();
    
    GeneralFeatures generalFeatures = new GeneralFeatures(totalStats);

    // considering that characters are composed of several components, it is 
    // recommended that programmers create objects by using patterns akin to
    // the java.beans pattern (object.setName("Tean"); object.setType("You"))
    // instead of the telescope pattern where constructor is supplied values: 
    // (GenericCharacter object = new GenericCharacter("Team", "You", ect.))
    public GenericCharacter()
    {
        // empty constructor
    }
    
    
    
    // START: GETTING OBJECTS CREATED USING OTHER CLASSES 
    /*******************************************************************************/

    public StatusEffectContainer getStatusEffectContainer()
    {
        return statusEffectContainer;
    }
    
    public Stats getStats()
    {
        return stats;
    }
    
    public EquippableOutfits getEquippableOutfits()
    {
        return equippableOutfits;
    }
    
    public TotalStats getTotalStats()
    {
        return totalStats;
    }
    
    public MoveImmunity getMoveImmunity()
    {
        return moveImmunity;
    }
    
    public SkillsForSkillPoints getSkillsForSkillPoints()
    {
        return skillsForSkillPoints;
    }
    
    public Moveset getMoveset()
    {
        return moveset;
    }
    
    public OppositionMethods getOppositionMethods()
    {
        return oppositionMethods;
    }
    
    public GeneralFeatures getGeneralFeatures()
    {
        return generalFeatures;
    }
    
    // END: GETTING OBJECTS CREATED USING OTHER CLASSES 
    /*******************************************************************************/
}
