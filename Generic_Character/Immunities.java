package Generic_Character;

/*
    Immunities determines what a character is immune to both in and outside 
    of battle. Immunities range vastly for some immunities relate to a move
    style (meaning attacks from move style fails) to the ever dreaded knock 
    out ("KO") state (not being KO'ed once current hp is reduced to 0).
*/

import Universally_Used_Methods.StaticMethods;
import java.util.HashMap;

public class Immunities extends RetrievingEnchantmentAndStatusResistances
{
    // START: IMMUNITIES LOGIC 
    /*******************************************************************************/
    
    // contains skills that are considered valid 
    public enum ImmunityTypes 
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
            HEAL("Heal"), 

            // location: at gauge application step (negative output negated)
            DAMAGE("Damage"), 

            // location: involved in battle class for determining fail states 
            IMMORTAL_STATE("Immortal State"), FRAGILE_STATE("Fragile State"), 

            // location: at parry/counter screen (UNUSED FOR NOW...)
            PARRY("Parry"), COUNTER("Counter"); 

        private String immunityType;
        
        ImmunityTypes(String immunityType)
        {
            this.immunityType = immunityType;
        }
        
        public String getEnumAsString()
        {
            return immunityType;
        }
    } 
    
    // immunityTypesImmunityStates HashMap creation and population through static means 
    private static final HashMap<ImmunityTypes, Boolean> immunityTypesImmunityStates = new HashMap<>();
        static 
        {
            for(ImmunityTypes immunityType : ImmunityTypes.values()) 
            {
                immunityTypesImmunityStates.put(immunityType, false);
            }
        }
    
    // get ImmunityTypes enum based on String argument passed 
    public ImmunityTypes getImmunityTypeEnum(String argument)
    {
        return ImmunityTypes.valueOf(StaticMethods.stringToEnum(argument));
    }
        
    // get boolean tied to immunity type specified by argument 
    public boolean getImmunityTypeState(String argument)
    {
        return immunityTypesImmunityStates.get(getImmunityTypeEnum(argument));
    }
    
    // update value for desired key of HashMap immunityTypesImmunityStates
    public void updateImmunityTypeStateForKey(String argument, boolean state)
    {
        immunityTypesImmunityStates.put(getImmunityTypeEnum(argument), state);
    }
    
    // END: IMMUNITIES LOGIC 
    /*******************************************************************************/
}