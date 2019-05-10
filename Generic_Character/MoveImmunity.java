package Generic_Character;

import Commonly_Used_Methods.StaticMethods;

import java.util.HashMap;

/*
    MoveImmunity determines what a character is immune to in and outside of
    battle. Immunities range vastly for some immunities relating to a move
    style (meaning attacks from move style fails) to the ever dreaded knock 
    out ("KO") state (not being KO'ed once current hp is reduced to 0).
*/

public class MoveImmunity 
{
    // special immunities used in determining the outcomes of unique scenarios
    private boolean immortal, fragile, parry, counter;


    // immunityTypesAndImmunityStates HashMap holding immunities and their states 
    private final HashMap<Immunities, Boolean> immunityTypesAndImmunityStates = new HashMap<>();

    public MoveImmunity()
    {
        initializeImmunities();
    }
    
    
    
    // START: IMMUNITIES LOGIC 
    /*******************************************************************************/
    
    public enum Immunities 
    { 
        // UNUSED FOR NOW...
        
            // projectile based immunities (UNUSED FOR NOW...)
            BULLET("Bullet"), PLASMA("Plasma"), 
            DART("Dart"), EXPLOSION("Explosion"),
            FRAGMENTATION("Fragmentation"), PROJECTILE("Projectile"),
        
        // by move approach
        
            // move approach immunities
            STAMINA("Stamina"), NANO("Nano"), 
            SPECIAL("Special"), OTHER("Other"),
        
        // by move style    
            
            // stamina weapon style immunities
            CLOSE_QUARTERS_COMBAT_STAMINA("Close Quarters Combat Stamina"), SWORD_STAMINA("Sword Stamina"), 
            KNIFE_STAMINA("Knife Stamina"), GREAT_SWORD_STAMINA("Great Sword Stamina"), 
            SPEAR_STAMINA("Spear Stamina"), BLADES_STAMINA("Blades Stamina"), 

            // nano weapon style immunities
            CLOSE_QUARTERS_COMBAT_NANO("Close Quarters Combat Nano"), SWORD_NANO("Sword Nano"), 
            KNIFE_NANO("Knife Nano"), GREAT_SWORD_NANO("Great Sword Nano"), 
            SPEAR_NANO("Spear Nano"), BLADES_NANO("Blades Nano"), 
        
        // by move skill
            
            // stamina move skill immunities
            UNIVERSAL_STAMINA("Universal Stamina"), HAND_TO_HAND_STAMINA("Hand To Hand Stamina"),
            ONE_HANDED_STAMINA("One Handed Stamina"), TWO_HANDED_STAMINA("Two Handed Stamina"), 
            DUAL_WIELDED_STAMINA("Dual Wielded Stamina"), 

            // nano move skill immunities
            UNIVERSAL_NANO("Universal Nano"), HAND_TO_HAND_NANO("Hand To Hand Nano"),
            ONE_HANDED_NANO("One Handed Nano"), TWO_HANDED_NANO("Two Handed Nano"), 
            DUAL_WIELDED_NANO("Dual Wielded Nano"), 

            // special move skill immunities
            GENERAL_PURPOSE("General Purpose"), OTHER_MOVES("Other Moves"), 

        // by special move 
            
            // special move (active) immunity 
            STEAL("Steal"), PILFER("Pilfer"), 
            DISARM("Disarm"), STRIP_ARMOR("Strip Armor"),

            // special move (passive) immunity 
            TALK("Talk"), CHAT("Chat"), 
            BRIBE("Bribe"), BARTER("Barter"), 
            PLEAD("Plead"), TAUNT("Taunt"),
        
        // by uniqueness 
            
            // location: upon performing "Other Move"
            ITEM("Item"), 

            // location: at status application step 
            STATUS("Status"), 

            // location: at enchantment application step 
            ENCHANTMENT("Enchantment"), 

            // location: at gauge application step (positive output negated)
            RECOVERY("Recovery"), 

            // location: at gauge application step (negative output negated)
            DAMAGE("Damage");

        private String immunity;
        
        Immunities(String immunity)
        {
            this.immunity = immunity;
        }
        
        public String getEnumAsString()
        {
            return immunity;
        }
    } 
    
    public void initializeImmunities()
    {
        for(Immunities immunityType : Immunities.values()) 
        {
            immunityTypesAndImmunityStates.put(immunityType, false);
        }
    }
    
    public Immunities getImmunityEnum(String argument)
    {
        return Immunities.valueOf(StaticMethods.stringToEnum(argument));
    }
        
    public boolean immuneTo(String argument)
    {
        return immunityTypesAndImmunityStates.get(getImmunityEnum(argument));
    }
    
    public void updateStateForImmunity(String argument, boolean state)
    {
        immunityTypesAndImmunityStates.put(getImmunityEnum(argument), state);
    }
    
    // END: IMMUNITIES LOGIC 
    /*******************************************************************************/

            
    
    // START: SPECIAL IMMUNTITES
    /*******************************************************************************/

    // location: involved in determining fail states 
    
    public void immoral(boolean immortal)
    {
        this.immortal = immortal;
    }
    
    public boolean immortal()
    {
        return immortal;
    }
    
    public void fragile(boolean fragile)
    {
        this.fragile = fragile;
    }
    
    public boolean fragile()
    {
        return fragile;
    }
    
    // location: involved in determining fail states 
    
    
    // location: at parry/counter screen (UNUSED FOR NOW...)
    
    public void parry(boolean parry)
    {
        this.parry = parry;
    }
    
    public boolean parry()
    {
        return parry;
    }
    
    public void counter(boolean counter)
    {
        this.counter = counter;
    }
    
    public boolean counter()
    {
        return counter;
    }
    
    // location: at parry/counter screen (UNUSED FOR NOW...)
    
    // END: SPECIAL IMMUNTITES
    /*******************************************************************************/
}