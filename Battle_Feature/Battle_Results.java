package Battle_Feature;

/*
    
*/

public class Battle_Results 
{
    
    
    
    // START: GETTING OPPOSING CHARACTERS DEFEATED IN BATTLE 
    /*******************************************************************************/


    
        // INCOMPLETE
    public void uniqueAfterBattleConditions(Party partyOne, Party partyTwo)
    {
        if(endBattle)
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
        if(endBattle || partiesTied)
        {
            uniqueAfterBattleConditions(partyOne, partyTwo);
        }
        else if(playerPartyExists(partyOne, partyTwo))
        {
            playerAfterBattleConditions(allPqContents, getPlayerParty(partyOne,
                partyTwo), getPartyOpposingPlayer(partyOne, partyTwo));
        }
        else
        {
            afterBattleConditions(allPqContents, partyOne, partyTwo);
        }
    }
    
    // END: END BATTLE LOOP BOOLEAN MANAGEMENT 
    /*******************************************************************************/
}