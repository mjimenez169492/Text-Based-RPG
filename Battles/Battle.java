package Battles;

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
    
    // variables denoting conditions for party win/loss/escape/ending battle early 
    private boolean playerGameOver, endBattleEarly, partiesTied, partyTwoEscape, 
        partyOneEscape, playerPartyEscape, partyTwoLoss, partyOneLoss, 
        playerPartyLoss, partyTwoWin, partyOneWin, playerPartyWin;

    // boolean array holds booleans that can end the battle if one of them is true 
    // Note: "final" array references cannot be changed but elements can be modified 
    private final boolean[] endBattleConditions = {playerGameOver, endBattleEarly, 
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
        (a, b) -> (b.getBattleDexterity()) - (a.getBattleDexterity()));

    // priority queue representing the next round of a battle which is filled 
    // with characters from priority queue currentRound as battle progresses 
    private final PriorityQueue<GenericCharacter> nextRound = new PriorityQueue<>( 
        (a, b) -> (b.getBattleDexterity()) - (a.getBattleDexterity()));

    // priority queue allPqContents is meant to contain all characters stored 
    // in priority queues currentRound and nextRound as battle progresses 
    private final PriorityQueue<GenericCharacter> allPqContents = new PriorityQueue<>(
        (a, b) -> (b.getBattleDexterity()) - (a.getBattleDexterity()));		
    
    
    
    // START: COUNTING ROUNDS IN BATTLE AND ENDING BATTLE LOOP 
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
    
    // END: COUNTING ROUNDS IN BATTLE AND ENDING BATTLE LOOP 
    /*******************************************************************************/

    
    
    // START: PRE-BATTLE SET UP 
    /*******************************************************************************/

    /* Enhanced For Loop and Functional Operation styles
        Enhanced For Loop Example: 
            for(Map.Entry<GenericCharacter, Party.ValidModes> entry : party.getPartyMembers().entrySet()){
                entry.getKey().setBattleDexterity(entry.getKey());
            }
        
        Functional Operation Example: 
            party.getPartyMembers().entrySet().forEach((entry) -> {
                entry.getKey().setBattleDexterity(entry.getKey());
            });     */
    
    public void resetEndBattleTriggersForCharacters(Party partyOne, Party partyTwo)
    {
        partyOne.getPartyMembers().entrySet().forEach((entry) -> {
            entry.getKey().setEndBattleTrigger(false);
        });
        
        partyTwo.getPartyMembers().entrySet().forEach((entry) -> {
            entry.getKey().setEndBattleTrigger(false);
        });
    }
    
    public void resetAllInstanceVariables()
    {
        // reset booleans representing end battle conditions 
        for(boolean element: endBattleConditions){
            element = false;
        }

        // reset priority queues 
        currentRound.clear();
        nextRound.clear();
        
        // reset ArrayLists 
        escapedCharacters.clear();
        defeatedCharacters.clear();
    }
        
    public void setBattleDexterityForCharacters(Party partyOne, Party partyTwo)
    {
        partyOne.getPartyMembers().entrySet().forEach((entry) -> {
            entry.getKey().setBattleDexterity(entry.getKey());
        });
        
        partyTwo.getPartyMembers().entrySet().forEach((entry) -> {
            entry.getKey().setBattleDexterity(entry.getKey());
        });
    }
    
    public void putCharactersInCurrentRound(PriorityQueue<GenericCharacter> currentRound, 
        Party partyOne, Party partyTwo)
    {
        partyOne.getPartyMembers().entrySet().forEach((entry) -> {
            currentRound.add(entry.getKey());
        });
        
        partyTwo.getPartyMembers().entrySet().forEach((entry) -> {
            currentRound.add(entry.getKey());
        });
    }
    
    public void setUpCurrentRound(PriorityQueue<GenericCharacter> currentRound, 
        Party partyOne, Party partyTwo)
    {
        setBattleDexterityForCharacters(partyOne, partyTwo);
        putCharactersInCurrentRound(currentRound, partyOne, partyTwo);	
    }

    public void preBattleSetUp(PriorityQueue<GenericCharacter> currentRound, 
        Party partyOne, Party partyTwo)
    {
        // set round to 1 at the start of each battle 
        setRoundCount(1);
        
        //reset all end battle triggers for both parties 
        resetEndBattleTriggersForCharacters(partyOne, partyTwo);

        // reset all instance variables before they are used in battle 
        resetAllInstanceVariables();

        // currentRound is filled with characters from parties supplied for battle 
        setUpCurrentRound(currentRound, partyOne, partyTwo);
    }
    
    // END: SETTING UP BATTLE FOR ROUND ONE AND BEYOND 
    /*******************************************************************************/
    
    
    
    // START: APPLYING START/END OF TURN EFFECTS BY CHARACTER
    /*******************************************************************************/

    public void reduceStressIfNotDamaged(GenericCharacter character)
    {
        if(!character.getDamagedState())
        {
            character.setCurrentStress(character.getCurrentStress() 
                - (character.getMaxStress() / 6));
        }
        else
        {
            character.setDamagedState(false);
        }
    }
    
    public void startOfTurnEffects(GenericCharacter character)
    {
        if(character != null && !character.knockedOut())
        {
            reduceStressIfNotDamaged(character);
            character.decrementStartOfTurnStatuses();
            character.removeStatusesIfZeroTurns();
        }
    }

    public void effectOfStatusEffectsOnCurrentGauges(GenericCharacter character)
    {
        character.setCurrentHealth(character.getCurrentHealth() + (character.getCurrentHealth() * character.getEffectOfStatusEffects("Current Health")));
        character.setCurrentStamina(character.getCurrentStamina() + (character.getCurrentStamina() * character.getEffectOfStatusEffects("Current Stamina")));
        character.setCurrentNano(character.getCurrentNano() + (character.getCurrentNano() * character.getEffectOfStatusEffects("Current Nano")));
}
    
    public void endOfTurnEffects(GenericCharacter character)
    {
        if(character != null && !character.knockedOut())
        {
            effectOfStatusEffectsOnCurrentGauges(character);
            character.decrementEndOfTurnStatuses();
            character.removeStatusesIfZeroTurns();
            character.applyCorePenaltyToEquippedOutfits();
        }	
    }

    // END: APPLYING START/END OF TURN EFFECTS BY CHARACTER 
    /*******************************************************************************/
    
    
    
    // START: MANAGING CURRENT AND NEXT ROUND PRIORITY QUEUES
    /*******************************************************************************/

    public void storeSecondPqContentsInFirstPq(PriorityQueue<GenericCharacter> firstPq, 
        PriorityQueue<GenericCharacter> secondPq)
    {
        secondPq.forEach((element) -> {
            firstPq.add(element);
        });
    }

    public void fillAllPqContents(PriorityQueue<GenericCharacter> allPqContents, 
        PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> nextRound)
    {
        allPqContents.clear();
        storeSecondPqContentsInFirstPq(allPqContents, currentRound);
        storeSecondPqContentsInFirstPq(allPqContents, nextRound);
    }

    public void fillCurrentRoundAndClearNextRound(PriorityQueue<GenericCharacter> currentRound, 
        PriorityQueue<GenericCharacter> nextRound)
    {
        storeSecondPqContentsInFirstPq(currentRound, nextRound);
        nextRound.clear();
    }

    // END: MANAGING CURRENT AND NEXT ROUND PRIORITY QUEUES
    /*******************************************************************************/

    
    
    // START: BATTLE LOGIC
    /*******************************************************************************/

    public void battleLogic(PriorityQueue<GenericCharacter> allPqContents, PriorityQueue<
        GenericCharacter> currentRound, PriorityQueue<GenericCharacter> nextRound, 
        double roundCount, Party partyOne, Party partyTwo)
    {
        // proceed if currentRound is not empty else refill currentRound
        if(!currentRound.isEmpty())
        {
            // fill allPqContents with characters that have not escaped battle 
            fillAllPqContents(allPqContents, currentRound, nextRound);
            
            // execute turn logic for character at head of currentRound 
            characterTurnLogic(allPqContents, currentRound, nextRound, 
                roundCount, partyOne, partyTwo);
        } 
        else 
        {
            fillCurrentRoundAndClearNextRound(currentRound, nextRound);
        }

        // fill allPqContents with characters that have not escaped battle 
        fillAllPqContents(allPqContents, currentRound, nextRound);

        // check end battle loop variables to see if a condition was met 
        checkEndBattleLoopVariables(allPqContents, partyOne, partyTwo);

        // increment round count by one 
        incrementRoundCount();
    }
    
    // END: BATTLE LOGIC
    /*******************************************************************************/

    
    
    // START: CHARACTER TURN LOGIC 
    /*******************************************************************************/
    
    public void characterTurnLogic(PriorityQueue<GenericCharacter> allPqContents, 
        PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> 
        nextRound, double roundCount, Party partyOne, Party partyTwo)
    {
	// determine which party character belongs to before character makes move 
	if(partyOne.getPartyMembers().containsKey(currentRound.peek()))
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
	if(!currentRound.peek().knockedOut()){
            startOfTurnEffects(currentRound.peek()); 
            executeCharacterTurn(allPqContents, currentRound, nextRound, roundCount, 
                characterParty, opposingParty);
	}else{
            currentRound.peek().removeStatusesAfterKnockOut();
            currentRound.peek().setBattleDexterity(currentRound.peek()); 
            nextRound.add(currentRound.poll());
	}
    }
    
        // INCOMPLETE********
    // manage character behavior when it is time to make a turn based on character state 
    public void executeCharacterTurn(PriorityQueue<GenericCharacter> allPqContents, 
        PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> 
        nextRound, double roundCount, Party characterParty, Party opposingParty) 
    {
            // need to set battle dexterity in each statement before moving on... 

        if(currentRound.peek().statusExists("Confused"))
        {
            // have code for random action here 
                // confusionMove() 
        }
        else if(/* insert code checking object's status effects for skip turn statuses */)
        {
            // code here regarding turn skipped
        }
        else if(!currentRound.peek().getPlayerControlState())
        {
            // execute ai pattern
        }
        else // object is under player control
        {
        // set battle dexterity for character using character AND move speed 
        // currentRound.peek() gets character for stuff so no GenericCharacter needed 
            // character.setBattleDexterity(currentRound.peek().getCommandList(allPqContents, 
            //      roundCount, characterParty, opposingParty, currentRound.peek()));
        }
        
        // execute post move behavior 
    }

    // END: SELECTING CHARACTER THAT WILL MAKE MOVE 
    /*******************************************************************************/


    
    // START: POST MOVE BEHAVIOR AND ESCAPE BEHAVIOR  
    /*******************************************************************************/
    
    public void postMoveBehavior(PriorityQueue<GenericCharacter> currentRound, PriorityQueue
        <GenericCharacter> nextRound, Party opposingParty)
    {
        if(currentRound.peek().getBattleDexterity() == Double.MAX_VALUE)
        {
            escapeAttemptBehavior(currentRound, nextRound, opposingParty);
        }
        else
        {
            if(!currentRound.peek().knockedOut())
            {
                endOfTurnEffects(currentRound.peek());
                nextRound.add(currentRound.poll());
            }
        }
    }

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
        
        if(!opposingParty.bossEntityPresent())
        {
            escapeValue = opposingParty.getAverageActiveChanceToPreventEscape(escapedCharacters);

            if(character.getLevel() > opposingParty.getAverageActiveLevel(escapedCharacters)){
                escapeValue -= (escapeValue / 4);
            }else{
                escapeValue += (escapeValue / 5);
            }

            if(character.getTotalDexterity() > opposingParty.getAverageActiveDexterity(escapedCharacters)){
                escapeValue -= (escapeValue / 3);
            }else{
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
            currentRound.peek().setBattleDexterity(currentRound.peek()); 
            endOfTurnEffects(currentRound.peek());
            nextRound.add(currentRound.poll());
        } 
    }	

    // END: POST MOVE BEHAVIOR AND ESCAPE BEHAVIOR 
    /*******************************************************************************/



    // START: DETERMINING EXISTENCE OF PLAYER PARTY AND GETTING PARTY OBJECTS 
    /*******************************************************************************/

    public boolean playerParty(Party party)
    {
        boolean result = false;
        
        if(party.getPlayerPartyState())
        {
            result = true;
        }
        
        return result;
    }
    
    public boolean playerPartyExist(Party partyOne, Party partyTwo)
    {
        boolean result = (playerParty(partyOne) == playerParty(partyTwo));
            return result;
    }
    
    public Party getPlayerParty(Party partyOne, Party partyTwo)
    {
        Party result = null;
        
        if(playerParty(partyOne))
        {
            result = partyOne;
        }
        else if(playerParty(partyTwo))
        {
            result = partyTwo;
        }
        
        return result;
    }
    
    public Party getOpposingParty(Party partyOne, Party partyTwo)
    {
        Party result = null;
        
        if(playerParty(partyOne))
        {
            result = partyTwo;
        }
        else
        {
            result = partyOne;
        }
        
        return result;
    }
    
    // END: DETERMINING EXISTENCE OF PLAYER PARTY AND GETTING PARTY OBJECTS 
    /*******************************************************************************/

    
    
    // START: BOOLEANS FOR SPECIAL CONDITIONS DETERMINING BATTLE OUTCOME 
    /*******************************************************************************/

    
    
    public void playerGameOverUponDeath(Party partyOne, Party partyTwo, boolean condition)
    {
        if(playerParty(partyOne))
        {
            condition = partyOne.partyMemberDead();
        }
        else if(playerParty(partyTwo))
        {
            condition = partyTwo.partyMemberDead();
        }
    }

    public void endBattleEarlyTrigger(Party partyOne, Party partyTwo, boolean condition)
    {
        if(partyOne.endBattleEarlyTrigger())
        {
            condition = true;
        }
        else if(partyTwo.endBattleEarlyTrigger())
        {
            condition = true;
        }
    }

    public void partiesTied(Party partyOne, Party partyTwo, boolean condition)
    {
        if(partyOne.partyKnockedOut() && partyTwo.partyKnockedOut())
        {
            condition = true;
        }
    }
    
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
                        if(!element.knockedOut()){ counter++; }
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

    public void partyEscape(PriorityQueue<GenericCharacter> allPqContents, 
        Party party, boolean condition)
    {
        condition = successfulPartyEscape(allPqContents, party);
    }
    
    public void playerPartyEscape(PriorityQueue<GenericCharacter> allPqContents, 
        Party partyOne, Party partyTwo, boolean condition)
    {
        if(playerParty(partyOne))
        {
            condition = successfulPartyEscape(allPqContents, partyOne);
        }
        else if(playerParty(partyTwo))
        {
            condition = successfulPartyEscape(allPqContents, partyTwo);
        }
    }
    
    // Note: in order to determine whether a party wins/loses one needs to know
    //       how many party members are still in battle as well as how many are
    //       not knocked out 
    
    public void partyLoss(PriorityQueue<GenericCharacter> allPqContents, Party party, 
        boolean condition)
    {
        if(remainingCombatantsKnockedOut(allPqContents, party))
        {
            condition = true;
        }
    }
    
    public void playerPartyLoss(PriorityQueue<GenericCharacter> allPqContents, Party party, 
        boolean condition)
    {
        if(playerParty(party))
        {
            partyLoss(allPqContents, party, condition);
        }
    }
    
    public void partyWin(boolean partyOneWin, boolean partyTwoLoss)
    {
        if(partyTwoLoss)
        {
            partyOneWin = true;
        }
    }
    
    public void playerPartyWin(Party party, boolean partyOneWin, boolean partyTwoLoss)
    {
        if(playerParty(party))
        {
           partyWin(partyOneWin, partyTwoLoss);
        }
    }
    
    // END: BOOLEANS FOR SPECIAL CONDITIONS DETERMINING BATTLE OUTCOME 
    /*******************************************************************************/
    
    
    
    // START: END BATTLE LOOP BOOLEAN MANAGEMENT 
    /*******************************************************************************/
    
    public void checkEndBattleLoopVariables(PriorityQueue<GenericCharacter> allPqContents, 
        Party partyOne, Party partyTwo)
    {
        playerGameOverUponDeath(partyOne, partyTwo, playerGameOver);
        endBattleEarlyTrigger(partyOne, partyTwo, endBattleEarly);
        partiesTied(partyOne, partyTwo, partiesTied);
        partyEscape(allPqContents, partyOne, partyOneEscape);
        partyEscape(allPqContents, partyTwo, partyTwoEscape);
        partyLoss(allPqContents, partyOne, partyOneLoss);
        partyLoss(allPqContents, partyTwo, partyTwoLoss);
        partyWin(partyOneWin, partyTwoLoss);
        partyWin(partyTwoWin, partyOneLoss);
    }
    
    public ArrayList<GenericCharacter> getDefeatedCharacters(PriorityQueue<GenericCharacter> 
        allPqContents, Party playerParty)
    {
        for(GenericCharacter element : allPqContents)
        {
            if(!playerParty.getPartyMembers().containsKey(element))
            {
                if(element.knockedOut())
                {
                    defeatedCharacters.add(element);
                }
                else if(element.statusExists("Surrender") || element.statusExists("Death"))
                {
                    defeatedCharacters.add(element);
                }
            }
        }
        
        return defeatedCharacters;
    }
         
        I// INCOMPLETE
    public void uniqueAfterBattleConditions(Party partyOne, Party partyTwo)
    {
        if(endBattleEarly)
        {
            /* Player Party Logic: 
                end battle method
               Non-Player Party Logic: 
                end battle method */
        }
        else if(partiesTied)
        {
            /* Player Party Logic: 
                set health for each party member to 1 
                    end battle method 
               Non-Player Party Logic: 
                  end battle method */
        }
        
    }
        
        I// INCOMPLETE 
    public void playerAfterBattleConditions(PriorityQueue<GenericCharacter> allPqContents, 
        Party playerParty, Party opposingParty)
    {
        if(playerGameOver)
        {
            /* Player Party Logic: 
                "THE GAME IS OVER...." 
                    game cannot continue for character central to plot has died 
                        create custom game over method: gameOver() */
        }
        else if(playerPartyEscape)
        {
            /* Player Party Logic: 
                "The party has fled successfully!"
                    exit battle method after showing battle results, level screen,
                    skills level screen, and objects gained as a result of battle
                        battle is treated as a LOSS for player */
        }
        else if(playerPartyLoss)
        {
            /* Player Party Logic: 
                depends on type of battle being fought (losing in unwinnable battles is acceptable)
                    usually a game over upon loss ("THE GAME IS OVER.... scenario") 
                        game cannot continue for party central to plot has been defeated  
                            create custom game over method: gameOver() */
        }
        else if(playerPartyWin)
        {
            /* Player Party Logic: 
                exit battle method after showing battle results, level screen,
                skills level screen, and objects gained as a result of battle 
                    Need to determine which party members are not KO and those
                    still in battle (non-escapees) for both parties 
                        party members still in battle and not KO get full exp  
                        and skill points while those KO get nothing
                battleResults(player party, getDefeatedCharacters(player party, 
                    allPqContents), allPqContents) */
        }
    }
    
        I// INCOMPLETE 
    public void afterBattleConditions(PriorityQueue<GenericCharacter> allPqContents, 
        Party partyOne, Party partyTwo)
    {
        if(partyOneEscape)
        {
            /* Non-Player Party Logic: 	
                end battle */
        }
        else if(partyTwoEscape)
        {
            /* Non-Player Party Logic: 	
                end battle */
        }
        else if(partyOneLoss)
        {
            /* Non-Player Party Logic: 	
                end battle */
        }
        else if(partyTwoLoss)
        {
            /* Non-Player Party Logic: 	
                end battle */
        }
        else if(partyOneWin)
        {
           /* Non-Player Party Logic: 	
            end battle */
        }
        else if(partyTwoWin)
        {
            /* Non-Player Party Logic: 	
                end battle */
        }
    }
    
    public void postBattleLogic(Party partyOne, Party partyTwo)
    {
        if(endBattleEarly || partiesTied)
        {
            uniqueAfterBattleConditions(partyOne, partyTwo);
        }
        else if(playerPartyExist(partyOne, partyTwo))
        {
            playerAfterBattleConditions(allPqContents, getPlayerParty(partyOne,
                partyTwo), getOpposingParty(partyOne, partyTwo));
        }
        else
        {
            afterBattleConditions(allPqContents, partyOne, partyTwo);
        }
    }
    
    // END: END BATTLE LOOP BOOLEAN MANAGEMENT 
    /*******************************************************************************/

    
    
    // START: BATTLE LOOPS 
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
    
        // time battles, win in a certain number of rounds battle 
    
    // allows characters from two different parties to battle one another 
    public void standardBattle(Party partyOne, Party partyTwo)
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
                battleLogic(allPqContents, currentRound, nextRound, getRoundCount(), 
                    partyOne, partyTwo);
            } 
            
            // after battle, perform appropriate action based on boolean priority 
            // and whether a party under player control is involved in the battle 
            postBattleLogic(partyOne, partyTwo);
        }
    }
    
    // END: BATTLE LOOPS 
    /*******************************************************************************/
}