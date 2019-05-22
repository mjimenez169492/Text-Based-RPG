package Battle_Feature;

/*
    Battle concerns creating objects/methods relating to the concept of battle 
    commonly found in various RPGs (Role Playing Games). Battles occur between
    AT MOST two parties consisting of characters which may be under AI control
    (low level AI script based on certain conditions) or under player control. 
    A battle between two parties has a success state and a fail state with the
    criteria for meeting each varying based on the type of battle initiated.
*/

import Generic_Character.*;
import java.security.SecureRandom;
import java.util.PriorityQueue;	
import Player_Entity.Party;
import java.util.ArrayList;

public class Battle
{
    // keeps track of the number of rounds that have passed in battle 
    private double round;
    
    // denotes whether battle is winnable or not from the start
    private boolean unwinnableBattle;
    
    // variables denoting conditions for party win/loss/escape/ending battle early 
    private boolean playerGameOver, endBattleEarlyTrigger, partiesTied, partyTwoEscape, 
        partyOneEscape, playerPartyEscape, partyTwoLoss, partyOneLoss, 
        playerPartyLoss, partyTwoWin, partyOneWin, playerPartyWin;

    // boolean array holds booleans that can end the battle if one of them is true 
    // Note: "final" array references cannot be changed but elements can be modified 
    private final boolean[] endBattleConditions = {playerGameOver, endBattleEarlyTrigger, 
        partiesTied, partyTwoEscape, partyOneEscape, playerPartyEscape, partyTwoLoss, 
        partyOneLoss, playerPartyLoss, partyTwoWin, partyOneWin, playerPartyWin};
    
    // holds chaarcters that have fled from battle (no post battle reward)
    private final ArrayList<GenericCharacter> escapedCharacters = new ArrayList<>();

    // holds characters defeated in battle (post battle reward if battle is won )
    private final ArrayList<GenericCharacter> defeatedCharacters = new ArrayList<>();

    /* Note: priority queues contain comparator that sorts characters such 
             that characters with the highest battle dexterity comes first */

    // priority queue representing the current round of a battle which consists 
    // of characters belonging to the party objects supplied to battle method
    private final PriorityQueue<GenericCharacter> currentRound = new PriorityQueue<>( 
        (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
        getBattleDexterity()));

    // priority queue representing the next round of a battle which is filled 
    // with characters from priority queue currentRound as battle progresses 
    private final PriorityQueue<GenericCharacter> nextRound = new PriorityQueue<>( 
        (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
        getBattleDexterity()));

    // priority queue allPqContents is meant to contain all characters stored 
    // in priority queues currentRound and nextRound as battle progresses 
    private final PriorityQueue<GenericCharacter> allPqContents = new PriorityQueue<>(
        (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
        getBattleDexterity()));		
    
    public Battle()
    {
        // empty constructor
    }
    
    
    
    // START: COUNTING ROUNDS IN BATTLE 
    /*******************************************************************************/

    public void setRoundCount(double round)
    {
        if(round < 1)
        {
            round = 1;
        }
        else if(round > 128)
        {
            round = 128;
        }

        this.round = round;
    }

    public void incrementRoundCount()
    {
        setRoundCount(getRoundCount() + 1);
    }
    
    public double getRoundCount()
    {
        return round;
    }
    
    // END: END BATTLE CONDITIONS
    /*******************************************************************************/

    
    
    // START: UNWINNABLE BATTLE BOOLEANS 
    /*******************************************************************************/

    public void unwinnableBattle(boolean unwinnableBattle)
    {
        this.unwinnableBattle = unwinnableBattle;
    }
    
    public boolean unwinnableBattle()
    {
        return unwinnableBattle;
    }
    
    // START: UNWINNABLE BATTLE BOOLEANS 
    /*******************************************************************************/

    
    
    // START: END BATTLE CONDITIONS 
    /*******************************************************************************/

    public void playerPartyGameOver(boolean playerGameOver)
    {
        this.playerGameOver = playerGameOver;
    }
    
    public boolean playerPartyGameOver()
    {
        return playerGameOver;
    }
    
    public void endBattleEarlyTrigger(boolean endBattleEarlyTrigger)
    {
        this.endBattleEarlyTrigger = endBattleEarlyTrigger;
    }
    
    public boolean endBattleEarlyTrigger()
    {
        return endBattleEarlyTrigger;
    }
    
    public void partiesTied(boolean partiesTied)
    {
        this.partiesTied = partiesTied;
    }
    
    public boolean partiesTied()
    {
        return partiesTied;
    }
    
    public void partyTwoEscape(boolean partyTwoEscape)
    {
        this.partyTwoEscape = partyTwoEscape;
    }
    
    public boolean partyTwoEscape()
    {
        return partyTwoEscape;
    }
    
    public void partyOneEscape(boolean partyOneEscape)
    {
        this.partyOneEscape = partyOneEscape;
    }
    
    public boolean partyOneEscape()
    {
        return partyOneEscape;
    }
    
    public void playerPartyEscape(boolean playerPartyEscape)
    {
        this.playerPartyEscape = playerPartyEscape;
    }
    
    public boolean playerPartyEscape()
    {
        return playerPartyEscape;
    }
    
    public void partyTwoLoss(boolean partyTwoLoss)
    {
        this.partyTwoLoss = partyTwoLoss;
    }
    
    public boolean partyTwoLoss()
    {
        return partyTwoLoss;
    }
    
    public void partyOneLoss(boolean partyOneLoss)
    {
        this.partyOneLoss = partyOneLoss;
    }
    
    public boolean partyOneLoss()
    {
        return partyOneLoss;
    }
    
    public void playerPartyLoss(boolean playerPartyLoss)
    {
        this.playerPartyLoss = playerPartyLoss;
    }
    
    public boolean playerPartyLoss()
    {
        return playerPartyLoss;
    }
    
    public void partyTwoWin(boolean partyTwoWin)
    {
        this.partyTwoWin = partyTwoWin;
    }
    
    public boolean partyTwoWin()
    {
        return partyTwoWin;
    }
    
    public void partyOneWin(boolean partyOneWin)
    {
        this.partyOneWin = partyOneWin;
    }
    
    public boolean partyOneWin()
    {
        return partyOneWin;
    }
    
    public void playerPartyWin(boolean playerPartyWin)
    {
        this.playerPartyWin = playerPartyWin;
    }
    
    public boolean playerPartyWin()
    {
        return playerPartyWin;
    }
    
    // END: END BATTLE CONDITIONS 
    /*******************************************************************************/

   
    
    // START: DETERMINING EXISTENCE OF PLAYER PARTY AND GETTING PARTY OBJECTS 
    /*******************************************************************************/
    
    public boolean playerPartyExists(Party partyOne, Party partyTwo)
    {
        // if one party is the player party then return true 
        boolean result = (partyOne.playerParty() || partyTwo.playerParty());
            return result;
    }
    
    public Party getPlayerParty(Party partyOne, Party partyTwo)
    {
        Party result = null;
        
        if(partyOne.playerParty())
        {
            result = partyOne;
        }
        else if(partyTwo.playerParty())
        {
            result = partyTwo;
        }
        
        return result;
    }
    
    public Party getPartyOpposingPlayer(Party partyOne, Party partyTwo)
    {
        Party result = null;
        
        if(!partyOne.playerParty())
        {
            result = partyOne;
        }
        else if(!partyTwo.playerParty())
        {
            result = partyTwo;
        }
        
        return result;
    }
    
    // END: DETERMINING EXISTENCE OF PLAYER PARTY AND GETTING PARTY OBJECTS 
    /*******************************************************************************/

    
    
    // START: BATTLE LOGIC
    /*******************************************************************************/

    // returns whether party is suitable for battle 
    public boolean validParty(Party party)
    {
        boolean result = false;
        
        if(party != null && !party.getPartyMembers().isEmpty())
        {
            result = true;
        }
        
        return result;
    }
    
    // allows characters from two different parties to battle one another 
    // Note: Battle object is passed to get access to boolean conditions
    public void standardBattle(Battle battle, Party partyOne, Party partyTwo)
    {
        // proceed only if both parties supplied are considered valid 
        if(validParty(partyOne) && validParty(partyTwo))
        {
            // reset end battle triggers, instance variables, and set up current round 
            preBattleSetUp(currentRound, partyOne, partyTwo);

            // loop until an end battle loop condition is met 
            while(!endBattleLoop())
            {
                // commence battle between two parties filled with characters 
                standardBattleLogic(allPqContents, currentRound, nextRound, getRoundCount(), 
                    partyOne, partyTwo);
            } 
            
            // after battle, perform appropriate action based on boolean priority 
            // and whether a party under player control is involved in the battle 
                // battleResults(battle, partyOne, partyTwo);
        }
    }
    
    public void standardBattleLogic(PriorityQueue<GenericCharacter> allPqContents, PriorityQueue
        <GenericCharacter> currentRound, PriorityQueue<GenericCharacter> nextRound, double 
        roundCount, Party partyOne, Party partyTwo)
    {
        // proceed if currentRound is not empty else refill currentRound
        if(!currentRound.isEmpty())
        {
            // fill allPqContents with characters that have not escaped battle 
            clearAndFillAllPqContents(allPqContents, currentRound, nextRound);
            
            // execute turn logic for character at head of currentRound 
            characterTurnLogic(allPqContents, currentRound, nextRound, 
                roundCount, partyOne, partyTwo);
        } 
        else 
        {
            fillCurrentRoundAndClearNextRound(currentRound, nextRound);
        }

        // fill allPqContents with characters that have not escaped battle 
        clearAndFillAllPqContents(allPqContents, currentRound, nextRound);

        // check end battle loop variables to see if a condition was met 
        checkEndBattleLoopVariables(allPqContents, partyOne, partyTwo);

        // increment round count by one 
        incrementRoundCount();
    }
    
    // END: BATTLE LOGIC
    /*******************************************************************************/

    
    
    // START: RESETTING BATTLE LOOP CONDITIONS AND END BATTLE LOOP 
    /*******************************************************************************/
    
    public void resetBattleLoopConditions()
    {
        unwinnableBattle = false;
        
        for(boolean element: endBattleConditions)
        {
            element = false;
        }
    }
    
    public boolean endBattleLoop()
    {
        boolean result = false;

        for(boolean element : endBattleConditions)
        {
            if(element)
            {
                result = true;
                    break;
            }
        }

        return result;
    }
    
    // END: RESETTING BATTLE LOOP CONDITIONS AND END BATTLE LOOP 
    /*******************************************************************************/

    
    
    // START: PRE-BATTLE SET UP 
    /*******************************************************************************/

    public void resetAllInstanceVariables()
    {
        // reset booleans representing end battle conditions 
        resetBattleLoopConditions();

        // reset priority queues 
        currentRound.clear();
        nextRound.clear();
        
        // reset ArrayLists 
        escapedCharacters.clear();
        defeatedCharacters.clear();
    }
    
    public void preparePartiesForBattle(Party partyOne, Party partyTwo)
    {
        partyOne.resetEndBattle();
        partyOne.setBattleDexterity();
        
        partyTwo.resetEndBattle();
        partyTwo.setBattleDexterity();
    }
    
    public void putCharactersInCurrentRound(PriorityQueue<GenericCharacter> currentRound, 
        Party partyOne, Party partyTwo)
    {
        for(GenericCharacter element : partyOne.getPartyMembers())
        {
            currentRound.add(element);
        }
        
        for(GenericCharacter element : partyTwo.getPartyMembers())
        {
            currentRound.add(element);
        }
    }
    
    public void preBattleSetUp(PriorityQueue<GenericCharacter> currentRound, 
        Party partyOne, Party partyTwo)
    {
        setRoundCount(1);
        
        resetAllInstanceVariables();
        
        preparePartiesForBattle(partyOne, partyTwo);
        
        putCharactersInCurrentRound(currentRound, partyOne, partyTwo);
    }
    
    // END: SETTING UP BATTLE FOR ROUND ONE AND BEYOND 
    /*******************************************************************************/
    
    
    
    // START: APPLYING START/END OF TURN EFFECTS BY CHARACTER
    /*******************************************************************************/

    public void resetDamagedIfDamaged(GenericCharacter character)
    {
        if(character.getGeneralFeatures().damaged())
        {
            character.getGeneralFeatures().damaged(false);
        }
    }
    
    public void startOfTurnEffects(GenericCharacter character)
    {
        if(character != null && !character.getGeneralFeatures().knockedOut())
        {
            resetDamagedIfDamaged(character);
            character.getStatusEffectContainer().decrementStartOfTurnStatusEffectTurns();
            character.getStatusEffectContainer().removeStatusEffectIfZeroTurns();
        }
    }

    public void effectOfStatusEffectsOnCurrentGauges(GenericCharacter character)
    {
        character.getGeneralFeatures().setCurrentHealth(character.getGeneralFeatures().
            getCurrentHealth() + (character.getGeneralFeatures().getCurrentHealth() * 
            character.getStatusEffectContainer().sumOfEffects("Current Health")));
        
        character.getGeneralFeatures().setCurrentStamina(character.getGeneralFeatures().
            getCurrentStamina() + (character.getGeneralFeatures().getCurrentStamina() * 
            character.getStatusEffectContainer().sumOfEffects("Current Stamina")));
        
        character.getGeneralFeatures().setCurrentNano(character.getGeneralFeatures().
            getCurrentNano() + (character.getGeneralFeatures().getCurrentNano() * 
            character.getStatusEffectContainer().sumOfEffects("Current Nano")));
}
    
    public void endOfTurnEffects(GenericCharacter character)
    {
        if(character != null && !character.getGeneralFeatures().knockedOut())
        {
            effectOfStatusEffectsOnCurrentGauges(character);
            character.getStatusEffectContainer().decrementEndOfTurnStatusEffectTurns();
            character.getStatusEffectContainer().removeStatusEffectIfZeroTurns();
            character.getEquippableOutfits().applyCorePenaltyToEquippedOutfits();
        }	
    }

    // END: APPLYING START/END OF TURN EFFECTS BY CHARACTER 
    /*******************************************************************************/
    
    
    
    // START: MANAGING CURRENT/NEXT ROUND PRIORITY QUEUES AND ALLPQCONTENTS
    /*******************************************************************************/

    public void storeSecondPqContentsInFirstPq(PriorityQueue<GenericCharacter> firstPq, 
        PriorityQueue<GenericCharacter> secondPq)
    {
        for(GenericCharacter element : secondPq)
        {
            firstPq.add(element);
        }
    }

    public void fillCurrentRoundAndClearNextRound(PriorityQueue<GenericCharacter> currentRound, 
        PriorityQueue<GenericCharacter> nextRound)
    {
        storeSecondPqContentsInFirstPq(currentRound, nextRound);
        nextRound.clear();
    }
    
    public void clearAndFillAllPqContents(PriorityQueue<GenericCharacter> allPqContents, 
        PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> nextRound)
    {
        allPqContents.clear();
        storeSecondPqContentsInFirstPq(allPqContents, currentRound);
        storeSecondPqContentsInFirstPq(allPqContents, nextRound);
    }
    
    // END: MANAGING CURRENT/NEXT ROUND PRIORITY QUEUES AND ALLPQCONTENTS
    /*******************************************************************************/

    
    
    // START: CHARACTER TURN LOGIC 
    /*******************************************************************************/
    
    public void characterTurnLogic(PriorityQueue<GenericCharacter> allPqContents, 
        PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> 
        nextRound, double roundCount, Party partyOne, Party partyTwo)
    {
	// determine which party character belongs to before character makes move 
	if(partyOne.getPartyMembers().contains(currentRound.peek()))
	{
            // execute turn logic for character by passing character by reference 
            // Note: first party object supplied is considered as character's party
            executeTurnOrStoreForNextRound(allPqContents, currentRound, nextRound, 
                getRoundCount(), partyOne, partyTwo);
	}
	else
	{
            // execute turn logic for character by passing character by reference 
            // Note: first party object supplied is considered as character's party
            executeTurnOrStoreForNextRound(allPqContents, currentRound, nextRound, 
                getRoundCount(), partyTwo, partyOne);
	}
    }
    
    // END: CHARACTER TURN LOGIC 
    /*******************************************************************************/
    
    
    
    // START: SELECTING CHARACTER THAT WILL MAKE MOVE 
    /*******************************************************************************/
    
    public void executeTurnOrStoreForNextRound(PriorityQueue<GenericCharacter> allPqContents, 
        PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> 
        nextRound, double roundCount, Party characterParty, Party opposingParty)
    {
	if(!currentRound.peek().getGeneralFeatures().knockedOut())
        {
            startOfTurnEffects(currentRound.peek()); 
            
            executeCharacterTurn(allPqContents, currentRound, nextRound, roundCount, 
                characterParty, opposingParty);
	}
        else
        {
            currentRound.peek().getStatusEffectContainer().removeStatusEffectsAfterKnockOut();
            currentRound.peek().getGeneralFeatures().setBattleDexterity(currentRound.peek()); 
            nextRound.add(currentRound.poll());
	}
    }
    
        // INCOMPLETE********
    // manage character behavior when it is time to make a turn based on character state 
    public void executeCharacterTurn(PriorityQueue<GenericCharacter> allPqContents, 
        PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> 
        nextRound, double roundCount, Party characterParty, Party opposingParty) 
    {
        if(currentRound.peek().getStatusEffectContainer().behaviorStatusExists())
        {
            // have code for behavior that takes control away from player/AI script 
                // CONFUSED("Confused"), ENAMORED("Enamored"), BERSERK("Berserk");
                    // consider switch case or something... 
        }
        else if(currentRound.peek().getStatusEffectContainer().turnBehaviorStatusExists())
        {
            // code checks object's status effects for skip turn status effects 
                // do nothing since turn is skipped 
        }
        else if(!currentRound.peek().getGeneralFeatures().playerControl())
        {
            // if character is not under player control then execute AI script 
                // currentRound.peek().getAiScript().executeAiPattern() 
//            s
        }
        else // object is under player control
        {
            // set battle dexterity for character using character AND move speed 
            // character.setBattleDexterity(currentRound.peek().getCommandList(allPqContents, 
            //      roundCount, characterParty, opposingParty, currentRound.peek()));
        }
        
        // setBattleDexterity as last opion BEFORE executing post move behavior 
    }

    // END: SELECTING CHARACTER THAT WILL MAKE MOVE 
    /*******************************************************************************/


    
    // START: POST MOVE BEHAVIOR AND ESCAPE BEHAVIOR  
    /*******************************************************************************/
    
    public boolean escapePossible(double originalPreventFlee, double reducedPreventFlee)
    {
        SecureRandom rand = new SecureRandom();

        boolean result = false;

        if((rand.nextInt((int)originalPreventFlee) + 1) > (rand.nextInt((int)reducedPreventFlee) + 1))
        {
            result = true;
        }

        return result;
    }

    public boolean escapeOutcome(GenericCharacter character, Party opposingParty)
    {
        boolean result = false;
        
        double escapeValue = 0.0;
        
        if(!opposingParty.boss())
        {
            escapeValue = opposingParty.getAverageActiveChanceToPreventEscape(escapedCharacters);

            if(character.getGeneralFeatures().getLevel() > opposingParty.getAverageActiveLevel(escapedCharacters))
            {
                escapeValue -= (escapeValue / 4);
            }
            else
            {
                escapeValue += (escapeValue / 5);
            }

            if(character.getTotalStats().getTotalDexterity() > opposingParty.getAverageActiveDexterity(escapedCharacters)){
                escapeValue -= (escapeValue / 3);
            }
            else
            {
                escapeValue += (escapeValue / 4);
            }

            result = escapePossible(opposingParty.getAverageActiveChanceToPreventEscape(
                escapedCharacters), escapeValue);
        }

        return result;
    }
    
    public void escapeAttemptBehavior(PriorityQueue<GenericCharacter> currentRound, 
        PriorityQueue<GenericCharacter> nextRound, Party opposingParty)
    {
        if(escapeOutcome(currentRound.peek(), opposingParty))
        {
            escapedCharacters.add(currentRound.poll());
        }
        else
        {
            endOfTurnEffects(currentRound.peek());
            currentRound.peek().getGeneralFeatures().setBattleDexterity(currentRound.peek()); 
            nextRound.add(currentRound.poll());
        } 
    }	

    // account for character escape behavior or general move behavior 
    public void postMoveBehavior(PriorityQueue<GenericCharacter> currentRound, PriorityQueue
        <GenericCharacter> nextRound, Party opposingParty)
    {
        // if accounts for escape attempt and else accounts for non-escape behavior
        if(currentRound.peek().getGeneralFeatures().getBattleDexterity() == Double.MAX_VALUE)
        {
            escapeAttemptBehavior(currentRound, nextRound, opposingParty);
        }
        else
        {
            // apply effects to non-knocked out characters ONLY 
            if(!currentRound.peek().getGeneralFeatures().knockedOut())
            {
                endOfTurnEffects(currentRound.peek());
            }
            
            currentRound.peek().getGeneralFeatures().setBattleDexterity(currentRound.peek()); 
            nextRound.add(currentRound.poll());
        }
    }
    
    // END: POST MOVE BEHAVIOR AND ESCAPE BEHAVIOR 
    /*******************************************************************************/


    
    // START: BOOLEANS FOR SPECIAL CONDITIONS DETERMINING BATTLE OUTCOME 
    /*******************************************************************************/
    
    // end battle loop condition 
    public void playerGameOverUponDeath(Party partyOne, Party partyTwo)
    {
        if(partyOne.playerParty() || partyTwo.playerParty())
        {
            playerGameOver = (partyOne.partyMemberDead() || partyTwo.partyMemberDead());
        }
    }

    // end battle loop condition 
    public void endBattleEarlyTrigger(Party partyOne, Party partyTwo)
    {
        if(partyOne.endBattle() || partyTwo.endBattle())
        {
            endBattleEarlyTrigger = true;
        }
    }

    // end battle loop condition 
    public void partiesTied(Party partyOne, Party partyTwo)
    {
        if(partyOne.partyKnockedOut() && partyTwo.partyKnockedOut())
        {
            partiesTied = true;
        }
    }
        
    /* Party Escape Logic (escaping is ONLY way out of priority queue)
        Party with one member conditions:
            must check against party that character belongs to 
                if all members of a party escape then priority queue must not 
                have any members of party in it 
                    escape successful!
        Party with many members conditions: 
            must check against party that character belongs too 
                if all members of a party escape then priority queue must not 
                have any members of party in it 
                    escape successful!
            number of members for party must at least be 1 less than party size 
                (1 escaped so for party of 4 there are 3 members still in battle)
                    if at least 1 escaped and rest of active combatants are KO or
                    if all party members manage to escape 
                        escape successful!
    */
    
    public enum SpecificCombatants
    {
        ALL_CHARACTERS_IN_BATTLE, ALL_NON_KO_CHARACTERS_IN_BATTLE;
    }    
    
    public int countSpecificPartyCombatants(PriorityQueue<GenericCharacter> allPqContents, 
        Party party, SpecificCombatants choice)
    {
        int counter = 0;

        for(GenericCharacter element : allPqContents)
        {
            if(party.partyMemberExists(element))
            {
                switch(choice)
                {
                    case ALL_CHARACTERS_IN_BATTLE: 
                        counter++;
                            break; 
                    case ALL_NON_KO_CHARACTERS_IN_BATTLE: 
                        if(!element.getGeneralFeatures().knockedOut())
                        { 
                            counter++;
                        }
                            break;
                }
            }
        }

        return counter;
    }

    public int countCombatantsInBattle(PriorityQueue<GenericCharacter> allPqContents, Party party)
    {
        return countSpecificPartyCombatants(allPqContents, party, SpecificCombatants.
            ALL_CHARACTERS_IN_BATTLE);
    }

    public int countCombatantsKnockedOut(PriorityQueue<GenericCharacter> allPqContents, Party party)
    {
        return countSpecificPartyCombatants(allPqContents, party, SpecificCombatants.
            ALL_NON_KO_CHARACTERS_IN_BATTLE);
    }
    
    public boolean remainingCombatantsKnockedOut(PriorityQueue<GenericCharacter> allPqContents, Party party)
    {
        return (countCombatantsInBattle(allPqContents, party) == countCombatantsKnockedOut(allPqContents, party));
    }
    
    public boolean successfulPartyEscape(PriorityQueue<GenericCharacter> allPqContents, Party party)
    {
        boolean result = false;

        // if statement accounts for when at least one character escaped 
        if(party.getPartyMembers().size() > countCombatantsInBattle(allPqContents, party))
        {
            /* Conditions for successful party escape: 
                if remaining combatants of party are knocked out in battle 
                if no more party combatants are in battle (all escaped) */
            if(remainingCombatantsKnockedOut(allPqContents, party))
            {
                result = true;
            }
        }

        return result;
    }

    // end battle loop condition 
    public void partyTwoEscape(PriorityQueue<GenericCharacter> allPqContents, Party partyOne)
    {
        partyTwoEscape = successfulPartyEscape(allPqContents, partyOne);
    }
    
    // end battle loop condition 
    public void partyOneEscape(PriorityQueue<GenericCharacter> allPqContents, Party partyTwo)
    {
        partyOneEscape = successfulPartyEscape(allPqContents, partyTwo);
    }
    
    // end battle loop condition 
    public void playerPartyEscape(PriorityQueue<GenericCharacter> allPqContents, Party partyOne, Party partyTwo)
    {
        if(getPlayerParty(partyOne, partyTwo) != null)
        {
            playerPartyEscape = successfulPartyEscape(allPqContents, getPlayerParty(partyOne, partyTwo));
        }
    }
    
    // Note: in order to determine whether a party wins/loses one needs to know
    //       how many party members are still in battle as well as how many are
    //       not knocked out 
    
    public void partyLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyTwo,
        boolean condition)
    {
        if(remainingCombatantsKnockedOut(allPqContents, partyTwo))
        {
            condition = true;
        }
    }
    
    // end battle loop condition 
    public void partyTwoLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyTwo)
    {
        partyLoss(allPqContents, partyTwo, partyTwoLoss);
    }
    
    // end battle loop condition 
    public void partyOneLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyOne)
    {
        partyLoss(allPqContents, partyOne, partyOneLoss);
    }
    
    // end battle loop condition 
    public void playerPartyLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyOne, Party partyTwo)
    {
        if(getPlayerParty(partyOne, partyTwo) != null)
        {
            playerPartyEscape = successfulPartyEscape(allPqContents, getPlayerParty(partyOne, partyTwo));
        }
    }
    
    // end battle loop condition 
    public void partyTwoWin(boolean partyOneLoss, boolean partyTwoLoss)
    {
        if(partyOneLoss && !partyTwoLoss)
        {
            partyTwoWin = true;
        }
    }
    
    // end battle loop condition 
    public void partyOneWin(boolean partyOneWin, boolean partyTwoLoss)
    {
        if(!partyOneLoss && partyTwoLoss)
        {
            partyOneWin = true;
        }
    }
    
    // end battle loop condition 
    public void playerPartyWin(boolean partyOneWin, boolean partyTwoWin, Party partyOne, Party partyTwo)
    {
        if(partyOneWin && partyOne == getPlayerParty(partyOne, partyTwo))
        {
            playerPartyWin = true;
        }
        else if(partyTwoWin && partyTwo == getPlayerParty(partyOne, partyTwo))
        {
            playerPartyWin = true;
        }
    }
    
    // END: BOOLEANS FOR SPECIAL CONDITIONS DETERMINING BATTLE OUTCOME 
    /*******************************************************************************/
    
    
    
    // START: END BATTLE LOOP BOOLEAN MANAGEMENT 
    /*******************************************************************************/
    
    public void checkEndBattleLoopVariables(PriorityQueue<GenericCharacter> allPqContents, 
        Party partyOne, Party partyTwo)
    {
        playerGameOverUponDeath(partyOne, partyTwo);
        endBattleEarlyTrigger(partyOne, partyTwo);
        partiesTied(partyOne, partyTwo);
        partyTwoEscape(allPqContents, partyTwo);
        partyOneEscape(allPqContents, partyOne);
        playerPartyEscape(allPqContents, partyOne, partyTwo);
        partyTwoLoss(allPqContents, partyTwo);
        partyOneLoss(allPqContents, partyOne);
        playerPartyLoss(allPqContents, partyOne, partyTwo);
        partyTwoWin(partyOneLoss, partyTwoLoss);
        partyOneWin(partyOneWin, partyTwoLoss);
        playerPartyWin(partyOneWin, partyTwoWin, partyOne, partyTwo);
    }
    
    // END: END BATTLE LOOP BOOLEAN MANAGEMENT 
    /*******************************************************************************/
}
