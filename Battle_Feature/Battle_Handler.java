package Battle_Feature;

/*
    BattleHandler manages what occurs after a battle once a battle concludes

the flow of a battle particularly what occurs before
    a battle begins as well as 
*/

import Player_Entity.PlayerEntity;
import Player_Entity.Party;
import Generic_Character.GenericCharacter;
import java.util.PriorityQueue;

public class BattleHandler 
{
    // START: UNIQUE END BATTLE CONDITIONS 
    /*******************************************************************************/

    // Note: no aftermath logic for battle between non-player parties 
    public void uniqueEndBattleConditions(Battle battle, Party partyOne, Party partyTwo)
    {
        if(battle.endBattleEarlyTrigger())
        {
            /* Non-Player Party Logic: end battle script */
        }
        else if(battle.partiesTied())
        {
            /* Non-Player Party Logic: winning party is selected randomly */
        }
        
    }
    
    public void uniqueEndBattleConditions(Battle battle, PlayerEntity playerEntity, 
        Party partyTwo)
    {
        if(battle.endBattleEarlyTrigger())
        {
            /* Player Entity Logic: end battle script and proceed with game */
        }
        else if(battle.partiesTied())
        {
            /* Player Party Logic: Game Over...*/
        }
        
    }
    
    // END: UNIQUE END BATTLE CONDITIONS 
    /*******************************************************************************/

    
    
    // START: AFTER BATTLE RESULTS USING END BATTLE CONDITIONS  
    /*******************************************************************************/
    
    // Note: no aftermath logic for battle between non-player parties 
    public void afterBattleConditions(Battle battle, PriorityQueue<GenericCharacter> 
        charactersInBattle, Party partyOne, Party partyTwo)
    {
        if(battle.partyOneEscape())
        {
            /* Non-Player Party Logic: end battle */
        }
        else if(battle.partyTwoEscape())
        {
            /* Non-Player Party Logic: end battle */
        }
        else if(battle.partyOneLoss())
        {
            /* Non-Player Party Logic: end battle */
        }
        else if(battle.partyTwoLoss())
        {
            /* Non-Player Party Logic: end battle */
        }
        else if(battle.partyOneWin())
        {
           /* Non-Player Party Logic: end battle */
        }
        else if(battle.partyTwoWin())
        {
            /* Non-Player Party Logic: end battle */
        }
    }
    
    public void afterBattleConditions(Battle battle, PriorityQueue<GenericCharacter> 
        charactersInBattle, PlayerEntity playerEntity, Party opposingParty)
    {
        if(battle.playerPartyGameOver())
        {
            /* Player Party Logic: 
                "THE GAME IS OVER...." 
                    game cannot continue for character central to plot has died 
                        create custom game over method: gameOver() */
        }
        else if(battle.playerPartyEscape())
        {
            /* Player Party Logic: 
                "The party has fled successfully!"
                    show battle results, level screen, skills level screen, 
                    and objects gained as a result of battle
                        Note: battle is treated as a LOSS for player
                        
                BattleResults battleResults = new BattleResults();
                    battleResults.resultsScreen(allPqContents, playerEntity, 
                        opposingParty); */
        }
        else if(battle.playerPartyLoss())
        {
            /* Player Party Logic: 
                depends on type of battle being fought (losing in unwinnable battles is acceptable)
                    usually a game over upon loss ("THE GAME IS OVER.... scenario") 
                        game cannot continue for party central to plot has been defeated  
                            create custom game over method: gameOver()?
            
                    if(battle.unwinnableBattle()}
                    {
                        // set health of all party members to 1 and proceed through game
                    }
                    else
                    {
                        // gameOver() 
                    } */
        }
        else if(battle.playerPartyWin())
        {
            /* Player Party Logic: 
                show battle results, level screen, skills level screen, and 
                objects gained as a result of battle 
                    Need to determine which party members are not KO and those
                    still in battle (non-escapees) for both parties 
                        party members still in battle and not KO get full exp  
                        and skill points while those KO get nothing
            
                BattleResults battleResults = new BattleResults();
                    battleResults.resultsScreen(allPqContents, playerEntity, 
                        opposingParty); */
        }
    }
    
    // END: AFTER BATTLE RESULTS USING END BATTLE CONDITIONS  
    /*******************************************************************************/

    
    
    // START: OUTCOME BY PLAYER EXISTENCE AND BY PRIORITY
    /*******************************************************************************/

    public void battleOutcome(Battle battle, PriorityQueue<GenericCharacter> charactersInBattle, 
        Party partyOne, Party partyTwo)
    {
        if(battle.endBattleEarlyTrigger() || battle.partiesTied())
        {
            uniqueEndBattleConditions(battle, partyOne, partyTwo);
        }
        else
        {
            afterBattleConditions(battle, charactersInBattle, partyOne, partyTwo);
        }
    }
    
    public void battleOutcome(Battle battle, PriorityQueue<GenericCharacter> charactersInBattle, 
        PlayerEntity playerEntity, Party opposingParty)
    {
        if(battle.endBattleEarlyTrigger() || battle.partiesTied())
        {
            uniqueEndBattleConditions(battle, playerEntity, opposingParty);
        }
        else
        {
            afterBattleConditions(battle, charactersInBattle, playerEntity, opposingParty);
        }
    }
    
    // END: OUTCOME BY PLAYER EXISTENCE AND BY PRIORITY
    /*******************************************************************************/

    
    
    // START: BATTLE BY BATTLE TYPE SELECTION
    /*******************************************************************************/

    public enum BattleTypes
    {
        STANDARD, TIMED, ROUND;
    }
    
    public void battleSelection(BattleTypes battleType, Battle battle, Party partyOne,
        Party partyTwo)
    {
        switch(battleType)
        {
            case STANDARD:
                battle.standardBattle(battle, partyOne, partyTwo);
                    break;
            case TIMED:
                // method for battles lasting real life minutes does not exist 
                    break;
            case ROUND:
                // method for battles lasting certain # of rounds does not exist 
                    break;
        }
    }
    
    // END: BATTLE BY BATTLE TYPE SELECTION
    /*******************************************************************************/

    
    
    // START: OUTCOME BY PLAYER EXISTENCE AND BY PRIORITY
    /*******************************************************************************/
    
    public void battleHandler(BattleTypes battleType, PriorityQueue<GenericCharacter> 
        charactersInBattle, Party partyOne, Party partyTwo)
    {
        Battle battle = new Battle();
        
        battleSelection(battleType, battle, partyOne, partyTwo);
        
        battleOutcome(battle, charactersInBattle, partyOne, partyTwo);
    }
    
    public void battleHandler(BattleTypes battleType, PriorityQueue<GenericCharacter> 
        charactersInBattle, PlayerEntity playerEntity, Party opposingParty)
    {
        Battle battle = new Battle();
        
        battleSelection(battleType, battle, playerEntity.getParty(), opposingParty);
        
        battleOutcome(battle, charactersInBattle, playerEntity, opposingParty);
    }
    
    // END: OUTCOME BY PLAYER EXISTENCE AND BY PRIORITY
    /*******************************************************************************/
}
