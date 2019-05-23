package Move_Creation;

/*
    Moves contains information used to create objects representing moves or
    actions that characters can perform themselves or with items in/outside 
    of battle.  
*/

// NOTE: OBJECTS CREATED ARE ADDED TO SPOT RESERVED FOR THEM IN THEIR RESPECITVE 
//       CLASSES (Items has itemMove example = move for item)
// if using item call item move like item.getItemMove()

import Commonly_Used_Methods.StaticMethods;
import Generic_Character.GenericCharacter;
import Player_Entity.Party;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Moves 
{
    // defining move for player 
    private String name, description;
    
    // defining move characteristics for move organization in movesets
    private String approach, style, technique;
    
    // defining gauge powering move and enchantment (for extra damage) of move
    private String gaugeUsed, enchantment;
    
    // defining gauges that move targets 
    private ArrayList<Gauges> gaugesTargeted = new ArrayList<>();
    
    // allow/disallow certain moves based on character status 
    private String moveAvailabilityStatus;
    
    // defining conditions in which move can/cannot be used 
    private boolean usableFromMainMenu, usableInBattle, usableIfKnockedDown, 
        usableIfGrabbed, usableIfAirborne; 
        
    // determines what is made subject to output of the move
    private String target; 
    
    // determines how many times target is made subject to move 
    private int timesMoveAffectsTarget;
    
    // defines output Strings relayed to player based on move behavior 
    private String moveUsedText, moveMissedText, moveFailedText;

    // move behavior against unique target states 
    private boolean parryable, counterable, guardable, grabBlockable; 
    
    // determine what status effects can be inflicted by move upon impact 
    private ArrayList<StatusEffect> statusesMoveAdds = new ArrayList<>();
    
    // defines whether move can land on target if target lacks specified Statuses 
    // Ex: move "Fearsome Fist" does not land if target has status "Airborne" 
    private ArrayList<String> statusesNegatingMove = new ArrayList<>();
    
    // determines what status effects are removed upon impact of the move 
    private ArrayList<String> statusesMoveRemove = new ArrayList<>();
    
    // defines effects that move can have on durability value of weapons or equipment 
    private double userWeaponDurabilityEffect, weaponDurabilityEffect, bodyArmorDurabilityEffect,
        legArmorDurabilityEffect, footArmorDurabilityEffect, accessoryOneDurabilityEffect, 
        accessoryTwoDurabilityEffect;
    
    // defines effect move has in order to give context to move output
    // Note: used for leveling up move since it indicates how move is "Mastered" 
    private String classification; 
    
    // custom values meant to be used for item moves ONLY 
    private double customAccuracy, customOutput, customCritical;
    
    // contains values altering certain values used in move calculations 
    private double stressEffect, moveCost, outputVariance, accuracyModifier, 
        outputModifier, criticalModifier, moveSpeed;
    
    // determines when a move is mastered ("Mastered" moves can be used in combinations)
    private double masteryValue, currentValue; 
    
    // indicates whether move is mastered
    private boolean moveMastery;

    
    
    // START: DEFINING MOVE FOR PLAYER 
    /*******************************************************************************/

    public String validateStringLength(String argument, int characterLength) 
    {
        if(argument != null && !argument.equals(""))
        {
            if(argument.length() > characterLength)
            { 
                argument = argument.substring(0, characterLength);
            }
        }

        return argument;
    }
    
    public void setName(String name)
    {
        this.name = validateStringLength(name, 26);
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setDescription(String description)
    {
        this.description = validateStringLength(description, 144);
    }
    
    public String getDescription()
    {
        return description;
    }
    
    // END: DEFINING MOVE FOR PLAYER 
    /*******************************************************************************/

    
    
    // START: DEFINING MOVE FOR MOVE ORGANIZATION IN MOVESET
    /*******************************************************************************/
    
    // SETTING/GETTING APPROACH
    
    public enum Approaches 
    { 
        STAMINA("Stamina"), NANO("Nano"), SPECIAL("Special"), ITEM("Item");
        
        private String approach;
        
        Approaches(String approach)
        {
            this.approach = approach;
        }
        
        public String getEnumAsString()
        {
            return approach;
        }
    } 
    
    public void setApproach(String approach)
    {
        this.approach = Approaches.valueOf(StaticMethods.stringToEnum(approach)).getEnumAsString();
    }
    
    public String getApproachString()
    {
        return approach;
    }
    
    public Approaches getApproachEnum()
    {
        return Approaches.valueOf(StaticMethods.stringToEnum(approach));
    }

    // SETTING/GETTING APPROACH
    
    
    // SETTING/GETTING STYLE
    
    public enum Styles 
    { 
        // stamina styles 
        UNIVERSAL_STAMINA("Universal Stamina"), HAND_TO_HAND_STAMINA("Hand To Hand Stamina"), 
        ONE_HANDED_STAMINA("One Handed Stamina"), TWO_HANDED_STAMINA("Two Handed Stamina"), 
        DUAL_WIELDED_STAMINA("Dual Wielded Stamina"), 
        
        // nano styles 
        UNIVERSAL_NANO("Universal Nano"), HAND_TO_HAND_NANO("Hand To Hand Nano"), 
        ONE_HANDED_NANO("One Handed Nano"), TWO_HANDED_NANO("Two Handed Nano"), 
        DUAL_WIELDED_NANO("Dual Wielded Nano"), TECHNIQUES("Techniques"), OTHER_MOVES("Other Moves"); 
        
        private String style;
        
        Styles(String style)
        {
            this.style = style;
        }
        
        public String getEnumAsString()
        {
            return style;
        }
    } 
    
    public void setStyle(String style)
    {
        this.style = Styles.valueOf(StaticMethods.stringToEnum(style)).getEnumAsString();
    }
    
    public String getStyleString()
    {
        return style;
    }
    
    public Styles getStyleEnum()
    {
        return Styles.valueOf(StaticMethods.stringToEnum(style));
    }
    
    // SETTING/GETTING STYLE
    
    
    // SETTING/GETTING TECHNIQUES 
    
    public enum Techniques 
    { 
        // stamina skills 
        UNIVERSAL_STAMINA("Universal Stamina"), UNIVERSAL_HAND_TO_HAND_STAMINA("Universal Hand To Hand Stamina"), 
        CLOSE_QUARTERS_COMBAT_STAMINA("Close Quarters Combat Stamina"), UNIVERSAL_ONE_HANDED_STAMINA("Universal One Handed Stamina"), 
        SWORD_STAMINA("Sword Stamina"), KNIFE_STAMINA("Knife Stamina"), OTHER_ONE_HANDED_STAMINA("Other One Handed Stamina"), 
        UNIVERSAL_TWO_HANDED_STAMINA("Universal Two Handed Stamina"), GREAT_SWORD_STAMINA("Great Sword Stamina"), SPEAR_STAMINA("Spear Stamina"), 
        OTHER_TWO_HANDED_STAMINA("Other Two Handed Stamina"), UNIVERSAL_DUAL_WIELDED_STAMINA("Universal Dual Wielded Stamina"), 
        BLADES_STAMINA("Blades Stamina"), OTHER_DUAL_WIELDED_STAMINA("Other Dual Wielded Stamina"), 
        
        // nano skills 
        UNIVERSAL_NANO("Universal Nano"), UNIVERSAL_HAND_TO_HAND_NANO("Universal Hand To Hand Nano"), 
        CLOSE_QUARTERS_COMBAT_NANO("Close Quarters Combat Nano"), UNIVERSAL_ONE_HANDED_NANO("Universal One Handed Nano"), 
        SWORD_NANO("Sword Nano"), KNIFE_NANO("Knife Nano"), OTHER_ONE_HANDED_NANO("Other One Handed Nano"), UNIVERSAL_TWO_HANDED_NANO("Universal Two Handed Nano"), 
        GREAT_SWORD_NANO("Great Sword Nano"), SPEAR_NANO("Spear Nano"), OTHER_TWO_HANDED_NANO("Other Two Handed Nano"), UNIVERSAL_DUAL_WIELDED_NANO(
        "Universal Dual Wielded Nano"), BLADES_NANO("Blades Nano"), OTHER_DUAL_WIELDED_NANO("Other Dual Wielded Nano"),
        
        // special skills
        GENERAL_PURPOSE("General Purpose"), OTHER_MOVES("Other Moves"); 

        private String technique;
        
        Techniques(String technique)
        {
            this.technique = technique;
        }
        
        public String getEnumAsString()
        {
            return technique;
        }
    } 
    
    public void setTechnique(String technique)
    {
        this.technique = Techniques.valueOf(StaticMethods.stringToEnum(technique)).getEnumAsString();
    }
    
    public String getTechniqueString()
    {
        return technique;
    }
    
    public Techniques getTechniqueEnum()
    {
        return Techniques.valueOf(StaticMethods.stringToEnum(technique));
    }
    
    // SETTING/GETTING TECHNIQUES 
    
    // END: DEFINING MOVE FOR MOVE ORGANIZATION IN CHARACTER MOVELIST
    /*******************************************************************************/

    
    
    // START: DEFINING DAMAGE TYPE AND GAUGE USED TO POWER MOVE
    /*******************************************************************************/
    
    public enum Gauges 
    { 
        CURRENT_HEALTH("Current Health"), CURRENT_STAMINA("Current Stamina"), 
        CURRENT_NANO("Current Nano"), NONE("None");
        
        private String gauges;
        
        Gauges(String gauges)
        {
            this.gauges = gauges;
        }
        
        public String getEnumAsString()
        {
            return gauges;
        }
    } 
    
    // GAUGE USED
    
    public void setGaugeUsed(String gaugeUsed)
    {
        this.gaugeUsed = Gauges.valueOf(StaticMethods.stringToEnum(gaugeUsed)).getEnumAsString();
    }
    
    public String getGaugeUsedString()
    {
        return gaugeUsed;
    }
    
    public Gauges getGaugeUsedEnum()
    {
        return Gauges.valueOf(StaticMethods.stringToEnum(gaugeUsed));
    }

    // GAUGE USED 
    
    
    // GAUGE TARGETED 
    
    public void addGaugeTargeted(String gaugeTargeted)
    {
        this.gaugesTargeted.add(Gauges.valueOf(StaticMethods.stringToEnum(gaugeTargeted)));
    }
    
    public ArrayList<Gauges> getGaugesTargeted()
    {
        return gaugesTargeted;
    }
    
    // GAUGE TARGETED
    
    // END: DEFINING DAMAGE TYPE AND GAUGE USED TO POWER MOVE
    /*******************************************************************************/
    
    
    
    // START: DEFINING MOVE ENCHANTMENT FOR BONUS DAMAGE
    /*******************************************************************************/

    public void setEnchantment(String enchantment)
    {
        this.enchantment = StaticMethods.getEnchantmentString(enchantment);
    }
    
    public String getEnchantmentString()
    {
        return enchantment;
    }
    
    // END: DEFINING MOVE ENCHANTMENT FOR BONUS DAMAGE
    /*******************************************************************************/

    
// note: Work in Progress
    // START: STATUS EFFECTS AFFECTING MOVE AVAILABILITY
    /*******************************************************************************/
    
    public enum MoveAvailabilityStatuses 
    { 
        // use to NOT add moves that have status effect requirements 
        VOID("Void"),
        
        NONE("None"), SHEATHED("Sheathed"), NOT_SHEATHED("Not Sheathed");
        
        private String moveAvailabilityStatus;
        
        MoveAvailabilityStatuses(String moveAvailabilityStatus)
        {
            this.moveAvailabilityStatus = moveAvailabilityStatus;
        }
        
        public String getEnumAsString()
        {
            return moveAvailabilityStatus;
        }
    } 
        
    public void setMoveAvailabilityStatus(String moveAvailabilityStatus)
    {
        this.moveAvailabilityStatus = Gauges.valueOf(StaticMethods.stringToEnum(moveAvailabilityStatus)).getEnumAsString();
    }
    
    public String getMoveAvailabilityStatusString()
    {
        return moveAvailabilityStatus;
    }
    
    public MoveAvailabilityStatuses getMoveAvailabilityStatusEnum()
    {
        return MoveAvailabilityStatuses.valueOf(StaticMethods.stringToEnum(moveAvailabilityStatus));
    }
    
    // END: STATUS EFFECTS AFFECTING MOVE AVAILABILITY
    /*******************************************************************************/

    
    
    // START: DEFINING CONDITIONS IN WHICH MOVE CAN/CANNOT BE USED 
    /*******************************************************************************/

    public void usableFromMainMenu(boolean usableFromMainMenu)
    {
        this.usableFromMainMenu = usableFromMainMenu;
    }
    
    public boolean usableFromMainMenu()
    {
        return usableFromMainMenu;
    }
    
    public void usableInBattle(boolean usableInBattle)
    {
        this.usableInBattle = usableInBattle;
    }
    
    public boolean usableInBattle()
    {
        return usableInBattle;
    }
    
    public void usableIfKnockedDown(boolean usableIfKnockedDown)
    {
        this.usableIfKnockedDown = usableIfKnockedDown;
    }
    
    public boolean usableIfKnockedDown()
    {
        return usableIfKnockedDown;
    }
    
    public void usableIfGrabbed(boolean usableIfGrabbed)
    {
        this.usableIfGrabbed = usableIfGrabbed;
    }
    
    public boolean usableIfGrabbed()
    {
        return usableIfGrabbed;
    }
    
    public void usableIfAirborne(boolean usableIfAirborne)
    {
        this.usableIfAirborne = usableIfAirborne;
    }
    
    public boolean usableIfAirborne()
    {
        return usableIfAirborne;
    }
    
    // END: DEFINING CONDITIONS IN WHICH MOVE CAN/CANNOT BE USED 
    /*******************************************************************************/

    
    
    // START: MOVE TARGETS AND TIMES MOVE AFFECTS TARGET 
    /*******************************************************************************/

    // MOVE TARGETS 
    
    public enum Targets
    {
        // move targets only user
        USER("User"), 

        // move targets one character
        ANY("Any"), ANY_EXCEPT_USER("Any Except User"), ANY_PARTY_MEMBER("Any Party Member"), 
        ANY_OPPOSING_PARTY_MEMBER("Any Opposing Party Member"), ANY_PARTY("Any Party"),

        // move targets all characters of one party
        USER_PARTY("User Party"), OPPOSING_PARTY("Opposing Party"), 

        // move targets a random character 
        RANDOM_ANY("Random Any"), RANDOM_ANY_EXCEPT_USER("Random Any Except User"), 
        RANDOM_ANY_PARTY_MEMBER("Random Any Party Member"), RANDOM_ANY_OPPOSING_PARTY_MEMBER
        ("Random Any Opposing Party Member"), 
        
        // move targets all characters in random party and all characters at random 
        RANDOM_ANY_PARTY("Random Any Party"), RANDOM_ALL("Random All"), 

        // move targets all characters with some exceptions 
        ALL("All"), ALL_EXCEPT_USER("All Except User");
        
        private String target;
        
        Targets(String target)
        {
            this.target = target;
        }
        
        public String getEnumAsString()
        {
            return target;
        }
    }
    
    public void setTarget(String target)
    {
        this.target = Targets.valueOf(StaticMethods.stringToEnum(target)).getEnumAsString();
    }
    
    public String getTargetString()
    {
        return target;
    }
    
    public Targets getTargetEnum()
    {
        return Targets.valueOf(StaticMethods.stringToEnum(target));
    }
    
    // MOVE TARGETS 
    
    
    // TIMES MOVE AFFECTS TARGET 
    
    public void setTimesMoveAffectsTarget(int timesMoveAffectsTarget)
    {
        if(timesMoveAffectsTarget < 1)
        {
            timesMoveAffectsTarget = 1;
        }
        else if(timesMoveAffectsTarget > 16)
        {
            timesMoveAffectsTarget = 16;
        }
        
        this.timesMoveAffectsTarget = timesMoveAffectsTarget;
    }
    
    public int getTimesMoveAffectsTarget()
    {
        return timesMoveAffectsTarget;
    }
    
    // TIMES MOVE AFFECTS TARGET
    
    // END: MOVE TARGETS AND TIMES TARGET IS STRUCK 
    /*******************************************************************************/

    

    // START: MOVE BEHAVIOR UPON USAGE 
    /*******************************************************************************/

    public void setMoveUsedText(String moveUsedText)
    {
        this.moveUsedText = validateStringLength(moveUsedText, 60);
    }
    
    public String getMoveUsedText()
    {
        return moveUsedText;
    }
    
    public void setMoveMissedText(String moveMissedText)
    {
        this.moveMissedText = validateStringLength(moveMissedText, 60);
    }
    
    public String getMoveMissedText()
    {
        return moveMissedText;
    }
    
    public void setMoveFailedText(String moveFailedText)
    {
        this.moveFailedText = validateStringLength(moveFailedText, 60);
    }
    
    public String getMoveFailedText()
    {
        return moveFailedText;
    }
    
    // END: MOVE BEHAVIOR UPON USAGE 
    /*******************************************************************************/
    
    
    
    // START: MOVE BEHAVIOR AGAINST UNIQUE TARGET STATE  
    /*******************************************************************************/
    
    public void parryable(boolean parryable)
    {
        this.parryable = parryable;
    }
    
    public boolean parryable()
    {
        return parryable;
    }
    
    public void counterable(boolean counterable)
    {
        this.counterable = counterable;
    }
    
    public boolean counterable()
    {
        return counterable;
    }
    
    public void guardable(boolean guardable)
    {
        this.guardable = guardable;
    }
    
    public boolean guardable()
    {
        return guardable;
    }
    
    public void grabBlockable(boolean grabBlockable)
    {
        this.grabBlockable = grabBlockable;
    }
    
    public boolean grabBlockable()
    {
        return grabBlockable;
    }
    
    // END: MOVE BEHAVIOR AGAINST UNIQUE TARGET STATE  
    /*******************************************************************************/


    
    // START: ARRAYLISTS DETERMINING ROLE OF MOVE IN STATUS MANAGEMENT
    /*******************************************************************************/

    public void addStatusMoveAdds(StatusEffect status)
    {
        if(status != null)
        {
            if(StaticMethods.getStatusEffectEnum(status.getName()) != null)
            {
                statusesMoveAdds.add(status);
            }
        }
    }
    
    public ArrayList<StatusEffect> getStatusesMoveAdds()
    {
        return statusesMoveAdds;
    }
    
    public void addStatusNegatingMove(String argument)
    {
        if(StaticMethods.getStatusEffectEnum(argument) != null)
        {
            statusesNegatingMove.add(argument);
        }
    }
    
    public ArrayList<String> getStatusesNegatingMove()
    {
        return statusesNegatingMove;
    }
    
    public void addStatusesMoveRemoves(String statusName)
    {
        if(StaticMethods.getStatusEffectEnum(statusName) != null)
        {
            statusesMoveRemove.add(statusName);
        }
    }
    
    public ArrayList<String> getStatusesMoveRemoves()
    {
        return statusesMoveRemove;
    }
    
    // END: ARRAYLISTS DETERMINING ROLE OF MOVE IN STATUS MANAGEMENT
    /*******************************************************************************/
    
    
    
    // START: DOUBLE EFFECT MOVE HAS ON DURABILITY VALUES OF USER AND TARGET  
    /*******************************************************************************/
    
    public double validateDurabilityEffect(double argument)
    {
        if(argument < 0.0)
        {
            argument = 0.0;
        }
        else if(argument > 100.0)
        {
            argument = 100.0;
        }
        
        return argument;
    }
    
    public void setUserWeaponDurabilityEffect(double userWeaponDurabilityEffect)
    {
        this.userWeaponDurabilityEffect = validateDurabilityEffect(userWeaponDurabilityEffect);
    }
    
    public double getUserWeaponDurabilityEffect()
    {
        return userWeaponDurabilityEffect;
    }
    
    public void setWeaponDurabilityEffect(double weaponDurabilityEffect)
    {
        this.weaponDurabilityEffect = validateDurabilityEffect(weaponDurabilityEffect);
    }
    
    public double getWeaponDurabilityEffect()
    {
        return weaponDurabilityEffect;
    }
    
    public void setBodyArmorDurabilityEffect(double bodyArmorDurabilityEffect)
    {
        this.bodyArmorDurabilityEffect = validateDurabilityEffect(bodyArmorDurabilityEffect);
    }
    
    public double getBodyArmorDurabilityEffect()
    {
        return bodyArmorDurabilityEffect;
    }
    
    public void setLegArmorDurabilityEffect(double legArmorDurabilityEffect)
    {
        this.legArmorDurabilityEffect = validateDurabilityEffect(legArmorDurabilityEffect);
    }
    
    public double getLegArmorDurabilityEffect()
    {
        return legArmorDurabilityEffect;
    }
    
    public void setFootArmorDurabilityEffect(double footArmorDurabilityEffect)
    {
        this.footArmorDurabilityEffect = validateDurabilityEffect(footArmorDurabilityEffect);
    }
    
    public double getFootArmorDurabilityEffect()
    {
        return footArmorDurabilityEffect;
    }
    
    public void setAccessoryOneDurabilityEffect(double accessoryOneDurabilityEffect)
    {
        this.accessoryOneDurabilityEffect = validateDurabilityEffect(accessoryOneDurabilityEffect);
    }
    
    public double getAccessoryOneDurabilityEffect()
    {
        return accessoryOneDurabilityEffect;
    }
    
    public void setAccessoryTwoDurabilityEffect(double accessoryTwoDurabilityEffect)
    {
        this.accessoryTwoDurabilityEffect = validateDurabilityEffect(accessoryTwoDurabilityEffect);
    }
    
    public double getAccessoryTwoDurabilityEffect()
    {
        return accessoryTwoDurabilityEffect;
    }
    
    // END: DOUBLE EFFECT MOVE HAS ON DURABILITY VALUES OF USER AND TARGET  
    /*******************************************************************************/

    
    
    // START: DEFINING EFFECT MOVE HAS ON TARGET BY GIVING CONTEXT TO OUTPUT
    /*******************************************************************************/
    
    public enum Classifications
    {
        DAMAGE("Damage"), RECOVERY("Recovery"), STATUS_EFFECT("Status Effect"), 
        ITEM("Item"), NONE("None"); 
        
        private String classification;
        
        Classifications(String classification)
        {
            this.classification = classification;
        }
        
        public String getEnumAsString()
        {
            return classification;
        }
    }
    
    public void setClassification(String classification)
    {
        this.classification = Classifications.valueOf(StaticMethods.stringToEnum(classification)).getEnumAsString();
    }
    
    public String getClassificationString()
    {
        return classification;
    }
    
    public Classifications getClassificationEnum()
    {
        return Classifications.valueOf(StaticMethods.stringToEnum(classification));
    }
    
    // END: DEFINING EFFECT MOVE HAS ON TARGET BY GIVING CONTEXT TO OUTPUT
    /*******************************************************************************/

    
    
    // START: CUSTOM VALUES FOR ITEM MOVES 
    /*******************************************************************************/

    public void setCustomAccuracy(double customAccuracy)
    {
        this.customAccuracy = lowerUpperBounds(-100, 100, customAccuracy);
    }
    
    public double getCustomAccuracy()
    {
        return customAccuracy;
    }
    
    public void setCustomOutput(double customOutput)
    {
        this.customOutput = lowerUpperBounds(-15000, 15000, customOutput);
    }
    
    public double getCustomOutput()
    {
        return customOutput;
    }
    
    public void setCustomCritical(double customCritical)
    {
        this.customCritical = lowerUpperBounds(-100, 100, customCritical);
    }
    
    public double getCustomCritical()
    {
        return customCritical;
    }
    
    // END: CUSTOM VALUES FOR ITEM MOVES 
    /*******************************************************************************/

    
    
    // START: DOUBLE VALUES RELATING TO MOVE USAGE (must pass moves object)
    /*******************************************************************************/
    
    public double lowerUpperBounds(double lower, double upper, double argument)
    {
        if(argument < lower)
        {
            argument = lower;
        }
        else if(argument > upper)
        {
            argument = upper;
        }
        
        return argument;
    }
    
    public void setMoveCost(double moveCost)
    {
        this.moveCost = lowerUpperBounds(0.0, 150.0, moveCost);
    }
    
    public double getMoveCost()
    {
        return moveCost;
    }
    
    public void setOutputVariance(double outputVariance)
    {
        this.outputVariance = lowerUpperBounds(-1.00, 1.00, outputVariance);
    }
    
    public double getOutputVariance()
    {
        return outputVariance;
    }

    public void setAccuracyModifier(double accuracyModifier)
    {
        this.accuracyModifier = lowerUpperBounds(-100.0, 100.0, accuracyModifier);
    }
    
    public double getAccuracyModifier()
    {
        return accuracyModifier;
    }
    
    public void setOutputModifier(double outputModifier)
    {
        this.outputModifier = lowerUpperBounds(-1.00, 2.50, outputModifier);
    }
    
    public double getOutputModifier()
    {
        return outputModifier;
    }
    
    public void setCriticalModifier(double criticalModifier)
    {
        this.criticalModifier = lowerUpperBounds(-100.00, 100.00, criticalModifier);
    }
    
    public double getCriticalModifier()
    {
        return criticalModifier;
    }
    
    public void setMoveSpeed(double moveSpeed)
    {
        this.moveSpeed = lowerUpperBounds(0.0, 1.5, moveSpeed);
    }
    
    public double getMoveSpeed()
    {
        return moveSpeed;
    }
    
    // START: DOUBLE VALUES RELATING TO MOVE USAGE 
    /*******************************************************************************/
    
    
    
    // START: DOUBLE VALUES RELATING TO MOVE USAGE 
    /*******************************************************************************/

    public void executeMove(PriorityQueue<GenericCharacter> charactersInBattle, Party 
        userParty, Party opposingParty, GenericCharacter user, Moves move)
    {
        MoveCalculations moveCalculation = new MoveCalculations();
        
        moveCalculation.executeMove(charactersInBattle, userParty, opposingParty, user, move);
    }
    
    // Note: move refers to moves object itself NOT another moves object 
    public void singleTargetMove(GenericCharacter user, GenericCharacter target, Moves move)
    {
        MoveCalculations moveCalculation = new MoveCalculations();
        
        moveCalculation.singleTargetMoveLogic(user, target, move);
    }
    
    // START: DOUBLE VALUES RELATING TO MOVE USAGE 
    /*******************************************************************************/

    


    // START: MOVE MASTERY
    /*******************************************************************************/

    public void setMasteryValue(double masteryValue)
    {
        this.masteryValue = lowerUpperBounds(0, 5000, masteryValue);
    }
    
    public double getMasteryValue()
    {
        return masteryValue;
    }
    
    public void setCurrentValue(double currentValue)
    {
        this.currentValue = lowerUpperBounds(0, masteryValue, currentValue);
    }
    
    public double getCurrentValue()
    {
        return currentValue;
    }
    
    public void setMoveMasteryState(boolean moveMastery)
    {
        this.moveMastery = moveMastery;
    }
    
    public boolean getMoveMasteryState()
    {
        return moveMastery;
    }
    
    // END: MOVE MASTERY
    /*******************************************************************************/
}
