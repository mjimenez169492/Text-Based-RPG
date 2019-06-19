package GUI_Collection;

import static GUI_Collection.CommonGUIMethods.displayFrameWindow;
import Generic_Character.GenericCharacter;
import Move_Creation.StatusEffect;
import Move_Creation.MoveCalculations;
import Player_Entity.PlayerEntity;
import Player_Entity.Party;
import Object_Factories_For_Testing.MovesFactory;

import java.util.PriorityQueue;
import java.security.SecureRandom;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.DefaultListCellRenderer;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import javax.swing.text.DefaultCaret;

/*
    Battle concerns creating objects/methods relating to the concept of battle 
    commonly found in various RPGs (Role Playing Games). Battles occur between
    AT MOST two parties consisting of characters which may be under AI control
    (low level AI script based on certain conditions) or under player control. 
    A battle between two parties has a success state and a fail state with the
    criteria for meeting each varying based on the type of battle initiated.
*/

// START: NESTED CLASS BATTLE

    // By default (without static), instances of B contain a hidden reference to 
    // an instance of A (may need a different instance of Enum object per scope)
    public class Battle extends CommonGUIMethods
    {
        // keeps track of the number of rounds that have passed in battle 
        private static double round;

        // signify that turn is complete 
        private static boolean turnComplete;
        
        // denotes whether battle is winnable or not from the start
        private boolean unwinnableBattle;

        // variables denoting conditions for party win/loss/escape/ending battle early 
        private static boolean playerGameOver, endBattleEarlyTrigger, partiesTied, partyTwoEscape, 
            partyOneEscape, playerPartyEscape, partyTwoLoss, partyOneLoss, 
            playerPartyLoss, partyTwoWin, partyOneWin, playerPartyWin;

        // holds chaarcters that have fled from battle (no post battle reward)
        private static final ArrayList<GenericCharacter> escapedCharacters = new ArrayList<>();

        // holds characters defeated in battle (post battle reward if battle is won )
        private static final ArrayList<GenericCharacter> defeatedEnemies = new ArrayList<>();

        /* Note: priority queues contain comparator that sorts characters such 
                 that characters with the highest battle dexterity comes first */

        // priority queue representing the current round of a battle which consists 
        // of characters belonging to the party objects supplied to battle method
        private static final PriorityQueue<GenericCharacter> currentRound = new PriorityQueue<>( 
            (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
            getBattleDexterity()));

        // priority queue representing the next round of a battle which is filled 
        // with characters from priority queue currentRound as battle progresses 
        private static final PriorityQueue<GenericCharacter> nextRound = new PriorityQueue<>( 
            (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
            getBattleDexterity()));

        // priority queue allPqContents is meant to contain all characters stored 
        // in priority queues currentRound and nextRound as battle progresses 
        private static final PriorityQueue<GenericCharacter> allPqContents = new PriorityQueue<>(
            (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
            getBattleDexterity()));		

        

        // START: MISCELLANEOUS METHODS 
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

        public static double getRoundCount()
        {
            return round;
        }

        public void unwinnableBattle(boolean unwinnableBattle)
        {
            this.unwinnableBattle = unwinnableBattle;
        }
        
        public boolean unwinnableBattle()
        {
            return unwinnableBattle;
        }
        
        // defeatedCharacters

        // END: MISCELLANEOUS METHODS 
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

        public static Party getOpposingPlayer(GenericCharacter character, Party partyOne, 
            Party partyTwo)
        {
            Party result = null;

            if(partyOne.getPartyMembers().contains(character))
            {
                result = partyOne;
            }
            else if(partyTwo.getPartyMembers().contains(character))
            {
                result = partyTwo;
            }

            return result;
        }
        
        // store enemies defeated in battle (as in those that have not fled)
        public static void storeDefeatedEnemies(PriorityQueue<GenericCharacter> allCombatants,
            Party opposingParty, ArrayList<GenericCharacter> arrayList)
        {
            for(GenericCharacter element : allCombatants)
            {
                for(GenericCharacter innerElement : opposingParty.getPartyMembers())
                {
                    if(element.getGeneralFeatures().getName().equals(innerElement.getGeneralFeatures().getName()))
                    {
                        arrayList.add(element);
                    }
                }
            }
        }
        
        public static ArrayList<GenericCharacter> getDefeatedEnemies()
        {
            return defeatedEnemies;
        }
        
        // END: DETERMINING EXISTENCE OF PLAYER PARTY AND GETTING PARTY OBJECTS 
        /*******************************************************************************/



        // START: PRE-BATTLE SET UP 
        /*******************************************************************************/

        public void resetBattleLoopConditions()
        {
            unwinnableBattle = false;

            boolean[] endBattleConditions = {playerGameOver, endBattleEarlyTrigger, 
                partiesTied, partyTwoEscape, partyOneEscape, playerPartyEscape, partyTwoLoss, 
                partyOneLoss, playerPartyLoss, partyTwoWin, partyOneWin, playerPartyWin};
            
            for(boolean element: endBattleConditions)
            {
                element = false;
            }
        }
        
        public void resetAllInstanceVariables()
        {
            // reset booleans representing end battle conditions 
            resetBattleLoopConditions();

            // reset priority queues 
            currentRound.clear();
            nextRound.clear();

            // reset ArrayLists 
            escapedCharacters.clear();
            defeatedEnemies.clear();
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
            if(!character.getGeneralFeatures().knockedOut())
            {
                resetDamagedIfDamaged(character);
                character.getStatusEffectContainer().decrementStartOfTurnStatusEffectTurns();
                character.getStatusEffectContainer().removeStatusEffectIfZeroTurns();
            }
        }

        public static void effectOfStatusEffectsOnCurrentGauges(GenericCharacter character)
        {
            character.getGeneralFeatures().setCurrentHealth(character.getGeneralFeatures().
                getCurrentHealth() + (character.getGeneralFeatures().getCurrentHealth() * 
                character.getStatusEffectContainer().sumOfStatusEffectEffects("Current Health")));

            character.getGeneralFeatures().setCurrentStamina(character.getGeneralFeatures().
                getCurrentStamina() + (character.getGeneralFeatures().getCurrentStamina() * 
                character.getStatusEffectContainer().sumOfStatusEffectEffects("Current Stamina")));

            character.getGeneralFeatures().setCurrentNano(character.getGeneralFeatures().
                getCurrentNano() + (character.getGeneralFeatures().getCurrentNano() * 
                character.getStatusEffectContainer().sumOfStatusEffectEffects("Current Nano")));
    }

        public static void endOfTurnEffects(GenericCharacter character)
        {
            if(!character.getGeneralFeatures().knockedOut())
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

        public static void storeSecondPqContentsInFirstPq(PriorityQueue<GenericCharacter> firstPq, 
            PriorityQueue<GenericCharacter> secondPq)
        {
            for(GenericCharacter element : secondPq)
            {
                firstPq.add(element);
            }
        }

        public static void fillCurrentRoundAndClearNextRound(PriorityQueue<GenericCharacter> currentRound, 
            PriorityQueue<GenericCharacter> nextRound)
        {
            storeSecondPqContentsInFirstPq(currentRound, nextRound);
            nextRound.clear();
        }

        public static void clearAndFillAllPqContents(PriorityQueue<GenericCharacter> allPqContents, 
            PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> nextRound)
        {
            allPqContents.clear();
            storeSecondPqContentsInFirstPq(allPqContents, currentRound);
            storeSecondPqContentsInFirstPq(allPqContents, nextRound);
        }

        // END: MANAGING CURRENT/NEXT ROUND PRIORITY QUEUES AND ALLPQCONTENTS
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

        // sets up GUI meant to display battle to player
        public void setUpBattleGUI(JFrame frame, Party partyOne, Party partyTwo)
        {
            frame.setLayout(new GridBagLayout());
   
            // set up frame for battle GUI
            BattleGUI.topLayoutButtons(frame);

            BattleGUI.bottomLayoutButtons(frame);

            BattleGUI.addUsableButtons(frame);

            BattleGUI.addUnusableTurnTrackingJListTitles(frame);

            BattleGUI.addPartyMemberJLists(frame);

            // set up party JLists to show parties and their members in battle 
            BattleGUI.partyOneBottom.setModel(BattleGUI.partyMembersModel(BattleGUI.referencePartyOne));
            BattleGUI.partyTwoTop.setModel(BattleGUI.partyMembersModel(BattleGUI.referencePartyTwo));
            
            BattleGUI.addTurnTrackingJLists(frame);

            BattleGUI.currentRoundJList.setModel(BattleGUI.turnTrackingJListModel(currentRound));
            
            BattleGUI.addBattleLogJTextArea(frame);

            BattleGUI.addJListJTextAreaButtonTitles(frame);

            // designates buttons that allow player to perform actions in battle 
            BattleGUI.usableButtonActionListeners();

            displayFrameWindow(frame);
        }
        
        // account for current round in battle log
        public void appendRoundCountToBattleLog(double roundCount)
        {
            String round = String.format("%s %s: %d\n\n", desiredSpaces(5),
                "Round", (int)getRoundCount());
                    BattleGUI.battleLog.append(round);
        }
        
        // account for character in focus in battle log
        public void appendCharacterInFocusToBattleLog(GenericCharacter character)
        {
            String characterInFocus = String.format("%s %s: %s\n\n", desiredSpaces(11),
                "Turn", character.getGeneralFeatures().getName());
                    BattleGUI.battleLog.append(characterInFocus);
        }
        
        // allows characters from two different parties to battle one another 
        // Note: Battle object is passed to get access to boolean conditions
        public void standardBattle(PlayerEntity entityOne, PlayerEntity entityTwo, JFrame frame) 
        {
            // party references used to easily access parties in battle  
            BattleGUI.referencePartyOne = entityOne.getParty();
            BattleGUI.referencePartyTwo = entityTwo.getParty();
            
            // proceed only if both parties supplied are considered valid 
            if(validParty(BattleGUI.referencePartyOne) && validParty(BattleGUI.referencePartyTwo))
            {
                // reset end battle triggers, instance variables, and set up current round 
                preBattleSetUp(currentRound, BattleGUI.referencePartyOne, BattleGUI.referencePartyTwo);

                // set up battle gui before it is displayed 
                setUpBattleGUI(frame, BattleGUI.referencePartyOne, BattleGUI.referencePartyTwo);
   
                appendRoundCountToBattleLog(getRoundCount());
                
                // loop until an end battle loop condition is met 
                while(true)
                {
                    // commence battle between two parties filled with characters 
                    standardBattleLogic(allPqContents, currentRound, nextRound, getRoundCount(), 
                        BattleGUI.referencePartyOne, BattleGUI.referencePartyTwo);
                       
                    // fill allPqContents with characters that have not escaped battle 
                    clearAndFillAllPqContents(allPqContents, currentRound, nextRound);

                    // check end battle loop variables to see if a condition was met 
                    if(checkEndBattleLoopVariables(allPqContents, BattleGUI.referencePartyOne, BattleGUI.referencePartyTwo))
                    {
                        break;
                    }
                } 
                
                // add KO'ed opposition to defeated characters if player party exist
                if(playerPartyExists(BattleGUI.referencePartyOne, BattleGUI.referencePartyTwo))
                {
                    storeDefeatedEnemies(allPqContents, getPartyOpposingPlayer(BattleGUI.referencePartyOne, 
                        BattleGUI.referencePartyTwo), defeatedEnemies);
                }
                
                // pause post battle for approximately 3 seconds after battle as breather 
                try {
                    Thread.sleep(2750);
                } catch (InterruptedException ex) {}
                
                // signify that Gui is complete 
                guiComplete(true);

                // dipose of frame to end battle and use booleans tied to Battle
                // object to determine outcome post battle via battleHandler 
                frame.dispose();
                
                // after battle, perform appropriate action based on boolean priority 
                // and whether a party under player control is involved in the battle 
                    // Note: class should return value accessible to Battle Handler 
            }
        }

        public void standardBattleLogic(PriorityQueue<GenericCharacter> allPqContents, PriorityQueue
            <GenericCharacter> currentRound, PriorityQueue<GenericCharacter> nextRound, double 
            roundCount, Party partyOne, Party partyTwo)
        {
            // proceed if currentRound is not empty 
            if(!currentRound.isEmpty())
            {
                // fill allPqContents with characters that have not escaped battle 
                clearAndFillAllPqContents(allPqContents, currentRound, nextRound);
                
                // execute turn logic for character at head of currentRound 
                characterTurnLogic(allPqContents, currentRound, nextRound, 
                    roundCount, partyOne, partyTwo);
            } 
            // else refill currentRound and reload turn tracking JLists 
            else 
            {
                fillCurrentRoundAndClearNextRound(currentRound, nextRound);
                
                // update turn tracking JLists 
                BattleGUI.currentRoundJList.setModel(BattleGUI.turnTrackingJListModel(currentRound));
                BattleGUI.nextRoundJList.setModel(BattleGUI.turnTrackingJListModel(nextRound));
                
                // increment round count by one 
                incrementRoundCount();
                
                // account for current round in battle log
                appendRoundCountToBattleLog(getRoundCount());
            }
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
                appendCharacterInFocusToBattleLog(currentRound.peek());
                
                // force battle log to scroll down to bottom 
                BattleGUI.battleLog.setCaretPosition(BattleGUI.battleLog.getDocument().getLength());
                
                startOfTurnEffects(currentRound.peek()); 

                executeCharacterTurn(allPqContents, currentRound, nextRound, roundCount, 
                    characterParty, opposingParty);
            }
            else
            {
                currentRound.peek().getStatusEffectContainer().removeStatusEffectsAfterKnockOut();
                currentRound.peek().getGeneralFeatures().setBattleDexterity(currentRound.peek()); 
                nextRound.add(currentRound.poll());
                
                // update turn tracking JLists 
                BattleGUI.currentRoundJList.setModel(BattleGUI.turnTrackingJListModel(currentRound));
                BattleGUI.nextRoundJList.setModel(BattleGUI.turnTrackingJListModel(nextRound));
            }
        }

            // COMPLETE FOR CAPSTONE AND INCOMPLETE OTHERWISE********
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
                
                BattleGUI.disableUsableButtons();
                
                while(!turnComplete)
                {
                    System.out.print("");
                }
                
            }
            else // object is under player control
            {
                // at this point, character is deemed under player control so 
                // player can make character perform actions by selecting any 
                // enabled button that exist across bottom border of frame as
                // soon as battle shifts to player control.
                
                // battle advances ONLY after player has selected option that
                // character can perform. Once a move is performed, character 
                // has battle dexterity set character.setBattleDexterity(move
                // speed * character.getTotalDexterity()) and battle proceeds
                // by calling postMoveBehavior(PriorityQueue<GenericCharacter> 
                // currentRound, PriorityQueue <GenericCharacter> nextRound, 
                // Party opposingParty)
                
                //BattleMenu.enableUsableButtons();
                BattleGUI.attack.setEnabled(true);
                
                turnComplete = false;
                
                // set true elsewhere 
                while(!turnComplete)
                {
                    System.out.print("");
                }
                
                postMoveBehavior(currentRound, nextRound, opposingParty);
            }
        }

        // END: SELECTING CHARACTER THAT WILL MAKE MOVE 
        /*******************************************************************************/



        // START: POST MOVE BEHAVIOR AND ESCAPE BEHAVIOR  
        /*******************************************************************************/

        public static boolean escapePossible(double originalPreventFlee, double reducedPreventFlee)
        {
            SecureRandom rand = new SecureRandom();

            boolean result = false;

            if((rand.nextInt((int)originalPreventFlee) + 1) > (rand.nextInt((int)reducedPreventFlee) + 1))
            {
                result = true;
            }

            return result;
        }

        public static boolean escapeOutcome(GenericCharacter character, Party opposingParty)
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

        public static void escapeAttemptBehavior(PriorityQueue<GenericCharacter> currentRound, 
            PriorityQueue<GenericCharacter> nextRound, Party opposingParty)
        {
            if(escapeOutcome(currentRound.peek(), opposingParty))
            {
                escapedCharacters.add(currentRound.poll());
                
                BattleGUI.escapedCharactersJList.setModel(BattleGUI.escapedCharactersJListModel(escapedCharacters));
            }
            else
            {
                endOfTurnEffects(currentRound.peek());
                currentRound.peek().getGeneralFeatures().setBattleDexterity(currentRound.peek()); 
                nextRound.add(currentRound.poll());
                
                // update turn tracking JLists 
                BattleGUI.currentRoundJList.setModel(BattleGUI.turnTrackingJListModel(currentRound));
                BattleGUI.nextRoundJList.setModel(BattleGUI.turnTrackingJListModel(nextRound));
            } 
        }	

        // account for character escape behavior or battle behavior POST MOVE 
        public static void postMoveBehavior(PriorityQueue<GenericCharacter> currentRound, 
            PriorityQueue<GenericCharacter> nextRound, Party opposingParty)
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
                
                // update turn tracking JLists 
                BattleGUI.currentRoundJList.setModel(BattleGUI.turnTrackingJListModel(currentRound));
                BattleGUI.nextRoundJList.setModel(BattleGUI.turnTrackingJListModel(nextRound));
            }
        }

        // END: POST MOVE BEHAVIOR AND ESCAPE BEHAVIOR 
        /*******************************************************************************/



        // START: BOOLEANS FOR SPECIAL CONDITIONS DETERMINING BATTLE OUTCOME 
        /*******************************************************************************/

        // end battle loop condition 
        public boolean playerGameOverUponDeath(Party partyOne, Party partyTwo)
        {
            boolean result = false;
            
            if(playerPartyExists(partyOne, partyTwo))
            {
                result = getPlayerParty(partyOne, partyTwo).partyMemberDead();
            }
            
            return result;
        }

        // end battle loop condition 
        public boolean endBattleEarlyTrigger(Party partyOne, Party partyTwo)
        {
            boolean result = false;
            
            if(partyOne.endBattle() || partyTwo.endBattle())
            {
                result = true;
            }
            
            return result;
        }

        // end battle loop condition 
        public boolean partiesTied(Party partyOne, Party partyTwo)
        {
            boolean result = false;
            
            if(partyOne.partyKnockedOut() && partyTwo.partyKnockedOut())
            {
                result = true;
            }
            
            return result;
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
            ALL_CHARACTERS_IN_BATTLE, ALL_KO_CHARACTERS_IN_BATTLE;
        }

        public int countSpecificPartyCombatants(PriorityQueue<GenericCharacter> allPqContents, 
            Party party, SpecificCombatants choice)
        {
            int counter = 0;

            for(GenericCharacter character : allPqContents)
            {
                for(GenericCharacter element : party.getPartyMembers())
                {
                    if(character == element)
                    {
                        switch(choice)
                        {
                            case ALL_CHARACTERS_IN_BATTLE: 
                                counter++;
                                    break; 
                            case ALL_KO_CHARACTERS_IN_BATTLE: 
                                if(element.getGeneralFeatures().knockedOut())
                                { 
                                    counter++;
                                }
                                    break;
                        }
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
                ALL_KO_CHARACTERS_IN_BATTLE);
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
        public boolean partyTwoEscape(PriorityQueue<GenericCharacter> allPqContents, Party partyOne)
        {
            return successfulPartyEscape(allPqContents, partyOne);
        }

        // end battle loop condition 
        public boolean partyOneEscape(PriorityQueue<GenericCharacter> allPqContents, Party partyTwo)
        {
            return successfulPartyEscape(allPqContents, partyTwo);
        }

        // end battle loop condition 
        public boolean playerPartyEscape(PriorityQueue<GenericCharacter> allPqContents, Party partyOne, Party partyTwo)
        {
            boolean result = false;
            
            if(playerPartyExists(partyOne, partyTwo))
            {
                result = successfulPartyEscape(allPqContents, getPlayerParty(partyOne, partyTwo));
            }
            
            return result;
        }

        // Note: in order to determine whether a party wins/loses one needs to know
        //       how many party members are still in battle as well as how many are
        //       not knocked out 

        public boolean partyLoss(PriorityQueue<GenericCharacter> allPqContents, Party party)
        {
            boolean result = false;
            
            if(remainingCombatantsKnockedOut(allPqContents, party))
            {
                result = true;
            }
            
            return result;
        }

        // end battle loop condition 
        public boolean partyTwoLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyTwo)
        {
            return partyLoss(allPqContents, partyTwo);
        }

        // end battle loop condition 
        public boolean partyOneLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyOne)
        {
            return partyLoss(allPqContents, partyOne);
        }

        // end battle loop condition 
        public boolean playerPartyLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyOne, Party partyTwo)
        {
            boolean result = false;
            
            if(playerPartyExists(partyOne, partyTwo))
            {
                result = successfulPartyEscape(allPqContents, getPlayerParty(partyOne, partyTwo));
            }
            
            return result;
        }

        // end battle loop condition 
        public boolean partyTwoWin(boolean partyOneLoss, boolean partyTwoLoss)
        {
            boolean result = false;
            
            if(partyOneLoss && !partyTwoLoss)
            {
                result = true;
            }
            
            return result;
        }

        // end battle loop condition 
        public boolean partyOneWin(boolean partyOneLoss, boolean partyTwoLoss)
        {
            boolean result = false;
            
            if(!partyOneLoss && partyTwoLoss)
            {
                result = true;
            }
            
            return result;
        }

        // end battle loop condition 
        public boolean playerPartyWin(boolean partyOneWin, boolean partyTwoWin, Party partyOne, Party partyTwo)
        {
            boolean result = false;
            
            if((partyOneWin && partyOne.playerParty()) || (partyTwoWin && partyTwo.playerParty()))
            {
                result = true;
            }
            
            return result;
        }

        // END: BOOLEANS FOR SPECIAL CONDITIONS DETERMINING BATTLE OUTCOME 
        /*******************************************************************************/



        // START: END BATTLE LOOP BOOLEAN MANAGEMENT 
        /*******************************************************************************/

        public boolean checkEndBattleLoopVariables(PriorityQueue<GenericCharacter> allPqContents, 
            Party partyOne, Party partyTwo)
        {
            playerGameOver = playerGameOverUponDeath(partyOne, partyTwo);
            endBattleEarlyTrigger = endBattleEarlyTrigger(partyOne, partyTwo);
            partiesTied = partiesTied(partyOne, partyTwo);
            partyTwoEscape = partyTwoEscape(allPqContents, partyTwo);
            partyOneEscape = partyOneEscape(allPqContents, partyOne);
            playerPartyEscape = playerPartyEscape(allPqContents, partyOne, partyTwo);
            partyTwoLoss = partyTwoLoss(allPqContents, partyTwo);
            partyOneLoss = partyOneLoss(allPqContents, partyOne);
            playerPartyLoss = playerPartyLoss(allPqContents, partyOne, partyTwo);
            partyTwoWin = partyTwoWin(partyOneLoss, partyTwoLoss);
            partyOneWin = partyOneWin(partyOneWin, partyTwoLoss);
            playerPartyWin = playerPartyWin(partyOneWin, partyTwoWin, partyOne, partyTwo);
            
            boolean result = false;
            
            // boolean array holds booleans that can end the battle if one of them is true 
            boolean[] endBattleConditions = {playerGameOver, endBattleEarlyTrigger, 
                partiesTied, partyTwoEscape, partyOneEscape, playerPartyEscape, partyTwoLoss, 
                partyOneLoss, playerPartyLoss, partyTwoWin, partyOneWin, playerPartyWin};

            
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

        // END: END BATTLE LOOP BOOLEAN MANAGEMENT 
        /*******************************************************************************/
        
        public Battle(PlayerEntity entityOne, PlayerEntity entityTwo) 
        {
            BattleGUI.frame.setLayout(new GridBagLayout());
            
            standardBattle(entityOne, entityTwo, BattleGUI.frame);
        }

    static class BattleGUI
    {
        // frame has access to methods available to Battle and Battle.Battle 
        private static JFrame frame = new JFrame("Capstone RPG");

        // references to both parties in battle allow easy access to party members 
        private static Party referencePartyOne, referencePartyTwo;

        // When formatting text displayed under certain fonts, it is possible for 
        // text to be displayed "incorrectly" or in an unintended fashion since 
        // characters may not have the same width. Font "Monospaced" alleviates 
        // this problem by making letters the same width-wise
        private static Font buttonFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
        private static Font JListFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);

        // vertical padding in pixels for buttons and JList components 
        private static int buttonVerticalPadding = 0;
        private static int jListVerticalPadding = 0;

        // JList components track turn statesfor all characters in battle 
        private static JList currentRoundJList, nextRoundJList, escapedCharactersJList;

        // options available to player on their turn
        private static JButton attack, skills, items;

        // JLists show party information for both parties in battle 
        private static JList partyOneBottom, partyTwoTop;

        // text area meant to track events that occur in battle 
        private static JTextArea battleLog;

        // external frame meant to be called with usable button is selected 
        private static JFrame externalFrame = new JFrame();

        // booleans determining how external frame is set up component-wise 
        private static boolean attackFrameActive, skillsFrameActive, itemsFrameActive;

        // JList meant to store all non-KO characters involved in battle that have not escaped 
        private static JList allAvailableNonKoCombatantsJList = new JList();



        // START: ADDING BUTTON COMPONENTS TO FRAME
        /*******************************************************************************/

        public static void addButtonComponent(JButton button, int gridy, int gridx, double
            weighty, double weightx, int gridheight, int gridwidth, JFrame frame)
        {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();

            // button will expand horizontally to fill empty space 
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

            // row position 
            gridBagConstraints.gridy = gridy;

            // column of specified row position
            gridBagConstraints.gridx = gridx;

            // specified column length component takes up in frame height
            gridBagConstraints.weighty = weighty;

            // specified row length component takes up in frame width
            gridBagConstraints.weightx = weightx;

            // width of component in given row 
            gridBagConstraints.gridwidth = gridwidth;

            // vertical padding in pixels for component in given row 
            gridBagConstraints.ipady = buttonVerticalPadding;

            // specifies space component must leave at each edges; (Insets(int 
            // top, int left, int bottom, int right)
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);

            // add button to frame with positioning 
            frame.add(button, gridBagConstraints);
        }

        // END: ADDING BUTTON COMPONENTS TO FRAME
        /*******************************************************************************/



        // START: UNUSABLE BUTTONS USED TO PARSE OUT CURRENT LAYOUT 
        /*******************************************************************************/

        public static JButton buttonUsedForLayout()
        {
            JButton button = new JButton(" ");

            button.setBackground(Color.BLACK);

            button.setForeground(Color.WHITE);

            button.setFont(buttonFont);

            return button;
        }

        public static void topLayoutButtons(JFrame frame)
        {
            for(int i = 0; i < 6; i++)
            {
                addButtonComponent(buttonUsedForLayout(), 0, i, 0.11, 0.33, 1, 1, frame);
            }
        }

        // Note: for loop starts at position 4 (i.e. 3 for array) since there are 3 buttons 
        public static void bottomLayoutButtons(JFrame frame)
        {
            for(int i = 3; i < 7; i++)
            {
                addButtonComponent(buttonUsedForLayout(), 15, i, 0.11, 0.33, 1, 1, frame);
            }
        }

        // END: UNUSABLE BUTTONS USED TO PARSE OUT CURRENT LAYOUT 
        /*******************************************************************************/


        // START: ADD USABLE BUTTONS TO BOTTOM LEFT OF FRAME LAYOUT 
        /*******************************************************************************/

        public static JButton newUsableButton(String text)
        {
            JButton button = new JButton(text);

            button.setFont(buttonFont);

            return button;
        }

        public static void usableButtonPlacement(JButton button, int gridy, int gridx, JFrame frame)
        {
            // Note: if component width is 0, component occupies whole row 
            addButtonComponent(button, gridy, gridx, 0.11, 0.33, 1, 1, frame);
        }

        public static void addUsableButtons(JFrame frame)
        {
            attack = newUsableButton("Attack");
                usableButtonPlacement(attack, 15, 0, frame);

            skills = newUsableButton("Skills");
                usableButtonPlacement(skills, 15, 1, frame);

            items = newUsableButton("Items");
                usableButtonPlacement(items, 15, 2, frame);
        }

        public static void enableUsableButtons()
        {
            attack.setEnabled(true);
            skills.setEnabled(true);
            items.setEnabled(true);
        }

        public static void disableUsableButtons()
        {
            attack.setEnabled(false);
            skills.setEnabled(false);
            items.setEnabled(false);
        }

        // END: ADD USABLE BUTTONS TO BOTTOM LEFT OF FRAME LAYOUT 
        /*******************************************************************************/



        // START: PARTY ONE AND PARTY TWO JLISTS 
        /*******************************************************************************/

        public static JList setUpJList(JList jList)
        {
            jList = new JList();

            // set font for text that will be displayed in text area 
            jList.setFont(JListFont);

            // set color of text to white 
            jList.setForeground(Color.WHITE);

            // set color of background to black 
            jList.setBackground(Color.BLACK);

            return jList;
        }

        public static void addPartyMemberJListComponent(JList jList, int gridy, int gridx, 
            int gridheight, int gridwidth, JFrame frame)
        {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();

            // add JScrollPane to frame to enable vertical scrolling for JList  
            JScrollPane statsScroll = new JScrollPane(jList, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            // button will expand horizontally to fill empty space 
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            // row position 
            gridBagConstraints.gridy = gridy;

            // column of specified row position
            gridBagConstraints.gridx = gridx;

            // specified column length component takes up of frame height
            gridBagConstraints.weighty = 0.60;

            // specified row length component takes up of frame width
            gridBagConstraints.weightx = 0.60;

            // height of component in given column 
            gridBagConstraints.gridheight = 4;

            // width of component in given row 
            gridBagConstraints.gridwidth = gridwidth;

            // vertical padding in pixels for component in given row 
            gridBagConstraints.ipady = 150;

            // specifies space component must leave at each edges; (Insets(int 
            // top, int left, int bottom, int right)
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);

            // add button to frame with positioning 
            frame.add(statsScroll, gridBagConstraints);
        }

        public static void addPartyMemberJLists(JFrame frame)
        {
            partyOneBottom = setUpJList(partyOneBottom);
                addPartyMemberJListComponent(partyOneBottom, 11, 0, 4, 6, frame);

            partyTwoTop = setUpJList(partyTwoTop);
                addPartyMemberJListComponent(partyTwoTop, 1, 0, 4, 6, frame);
        }

        // END: PARTY ONE AND PARTY TWO JLISTS 
        /*******************************************************************************/


        // START: UNUSABLE TITLE BUTTONS FOR TURN TRACKING JLISTS 
        /*******************************************************************************/

        public static JButton newUnusableTitleButton(String text)
        {
            JButton button = new JButton(text);

            // gun metal blue color in hexadecimal 
            button.setBackground(Color.decode("#4d5461"));

            button.setForeground(Color.WHITE);

            button.setFont(buttonFont);

            return button;
        }

        public static void addUnusableTitleButton(String buttonName, int gridy, int gridx, int gridwidth, 
            JFrame frame)
        {
            addButtonComponent(newUnusableTitleButton(buttonName), gridy, gridx, 0.11, 0.25, 
                2, gridwidth, frame);
        }

        public static void addUnusableTurnTrackingJListTitles(JFrame frame)
        {
            String currentRoundTitle = String.format("%s", "Current Round Turn Order");
                addUnusableTitleButton(currentRoundTitle, 0, 6, 1, frame);

            String nextRoundTitle = String.format("%s", "Next Round Turn Order");
                addUnusableTitleButton(nextRoundTitle, 5, 6, 1, frame);

            String escapedCharactersTitle = String.format("%s", "Escaped Characters");
                addUnusableTitleButton(escapedCharactersTitle, 10, 6, 1, frame);
        }

        // END: UNUSABLE TITLE BUTTONS FOR TURN TRACKING JLISTS 
        /*******************************************************************************/



        // START: JLIST JTEXTAREA BUTTON TITLES 
        /*******************************************************************************/

        public static void addJListJTextAreaButtonTitles(JFrame frame)
        {
            String opposingPartyFormatted = String.format("%s", "Enemies");
                addUnusableTitleButton(opposingPartyFormatted, 5, 0, 1, frame);

            String playerPartyFormatted = String.format("%s", "Allies");
                addUnusableTitleButton(playerPartyFormatted, 10, 0, 1, frame);
        }

        // END: JLIST JTEXTAREA BUTTON TITLES 
        /*******************************************************************************/



        // START: ADDING JLISTS MEANT FOR TRACKING TURN BEHAVIOR 
        /*******************************************************************************/

        public static void addTurnTrackingJListComponent(JList jList, int gridy, int gridwidth, 
            JFrame frame)
        {
            // allign view of JList such that text is displayed at its center 
            DefaultListCellRenderer renderer = (DefaultListCellRenderer) jList.getCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);

            GridBagConstraints gridBagConstraints = new GridBagConstraints();

            // add JScrollPane to frame to enable vertical scrolling for JList  
            JScrollPane statsScroll = new JScrollPane(jList, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // button will expand horizontally to fill empty space 
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            // row position 
            gridBagConstraints.gridy = gridy;

            // column of specified row position
            gridBagConstraints.gridx = 6;

            // specified column length component takes up in frame height
            gridBagConstraints.weighty = 0.20;

            // specified row length component takes up in frame width
            gridBagConstraints.weightx = 0.20;

            // height of component in given column 
            gridBagConstraints.gridheight = 4;

            // width of component in given row 
            gridBagConstraints.gridwidth = gridwidth;

            // vertical padding in pixels for component in given row 
            gridBagConstraints.ipady = 150;

            // specifies space component must leave at each edges; (Insets(int 
            // top, int left, int bottom, int right)
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);

            // add button to frame with positioning 
            frame.add(statsScroll, gridBagConstraints);
        }

        public static void addTurnTrackingJLists(JFrame frame)
        {
            currentRoundJList = setUpJList(currentRoundJList);
                addTurnTrackingJListComponent(currentRoundJList, 1, 1, frame);

            nextRoundJList = setUpJList(nextRoundJList);
                addTurnTrackingJListComponent(nextRoundJList, 6, 1, frame);

            escapedCharactersJList = setUpJList(escapedCharactersJList);
                addTurnTrackingJListComponent(escapedCharactersJList, 11, 1, frame);
        }

        // END: ADDING JLISTS MEANT FOR TRACKING TURN BEHAVIOR 
        /*******************************************************************************/



        // START: ADDING JTEXTAREA AS BATTLE LOG FOR ALL BATTLE ACTIONS 
        /*******************************************************************************/

        public static void addBattleLogTextAreaComponent(JTextArea textArea, int gridy, int gridwidth, 
            JFrame frame)
        {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();

            // add JScrollPane to frame to enable vertical scrolling for JList  
            JScrollPane textAreaScroll = new JScrollPane(textArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            // button will expand horizontally to fill empty space 
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            // row position 
            gridBagConstraints.gridy = gridy;

            // column of specified row position
            gridBagConstraints.gridx = 0;

            // specified column length component takes up in frame height
            gridBagConstraints.weighty = 0.20;

            // specified row length component takes up in frame width
            gridBagConstraints.weightx = 0.20;

            // height of component in given column 
            gridBagConstraints.gridheight = 1;

            // width of component in given row 
            gridBagConstraints.gridwidth = gridwidth;

            // vertical padding in pixels for component in given row 
            gridBagConstraints.ipady = 100;

            // specifies space component must leave at each edges; (Insets(int 
            // top, int left, int bottom, int right)
            gridBagConstraints.insets = new Insets(4, 0, 4, 0);

            // add button to frame with positioning 
            frame.add(textAreaScroll, gridBagConstraints);
        }

        public static JTextArea setUpTextArea(JTextArea textArea)
        {
            textArea = new JTextArea();

            // set font for text that will be displayed in text area 
            textArea.setFont(JListFont);

            // set color of text to white 
            textArea.setForeground(Color.WHITE);

            // set color of background to black 
            textArea.setBackground(Color.BLACK);

            // text area where text is displayed cannot be editted 
            textArea.setEditable(true);

            // sentences "wrap" or go to next line if text area boundary is reached 
            textArea.setLineWrap(true);

            // sentences wrap to next line if word touches boundary 
            textArea.setWrapStyleWord(true);

            return textArea;
        }

        public static void addBattleLogJTextArea(JFrame frame)
        {
            battleLog = new JTextArea("Battle Log:\n\n");
                setUpTextArea(battleLog);
                    addBattleLogTextAreaComponent(battleLog, 9, 6, frame);
        }

        // END: ADDING JTEXTAREA AS BATTLE LOG FOR ALL BATTLE ACTIONS 
        /*******************************************************************************/




        // START: UPDATING PARTY MEMBER JLIST BY PARTY
        /*******************************************************************************/

        public static String desiredSpaces(int spaces)
        {
            StringBuilder builder = new StringBuilder();

            for(int i = 0; i < spaces; i++)
            {
                builder.append(" ");
            }

            return builder.toString();
        }

        // Note: spaces are used to make value Strings appear aligned 
        public static void appendGaugeValueToStringBuilder(StringBuilder builder, double valueAsDouble,
            String valueAsString)
        {
            if(valueAsDouble < 10)
            {
                builder.append(desiredSpaces(2));
            }
            else if(valueAsDouble < 100)
            {
                builder.append(desiredSpaces(1));
            }

            builder.append(valueAsString);
        }

        public static String formatCurrentMaxGauges(double currentValue, double maximumValue)
        {
            String curValue = String.valueOf(currentValue);

            String maxValue = String.valueOf(maximumValue);

            StringBuilder builder = new StringBuilder();

            appendGaugeValueToStringBuilder(builder, currentValue, curValue);

            builder.append(" / ");

            appendGaugeValueToStringBuilder(builder, maximumValue, maxValue);

            return builder.toString();
        }

        // format so all names up to 26 characters are correctly structured 
        public static String name(GenericCharacter character, int counter)
        {
            String formatName = String.format("%-26s %s %s: %-2s", character.getGeneralFeatures().getName(),
                desiredSpaces(13), "Member", String.valueOf(counter));
                    return formatName;
        }

        // add Health Points (HP) and current/max points 
        public static String health(GenericCharacter character)
        {
            String formatHealth = String.format("%-3s: %s", "HP", formatCurrentMaxGauges(character.
                getGeneralFeatures().getCurrentHealth(), character.getTotalStats().getTotalMaxHealth()));
                    return formatHealth;
        }

        // add Stamina Points (SP) and current/max points 
        public static String stamina(GenericCharacter character)
        {
            String formatStamina = String.format("%-3s: %s", "SP", formatCurrentMaxGauges(character.
                getGeneralFeatures().getCurrentStamina(), character.getTotalStats().getTotalMaxStamina()));
                    return formatStamina;
        }

        // add Nanomachine Points (NP) and current/max points
        public static String nano(GenericCharacter character)
        {
            String formatNano = String.format("%-3s: %s", "NP", formatCurrentMaxGauges(character.
                getGeneralFeatures().getCurrentNano(), character.getTotalStats().getTotalMaxNano()));
                    return formatNano;
        }

        public static String statusEffectString(GenericCharacter character)
        {
            StringBuilder builder = new StringBuilder("Status Effects: ");

            int counter = 0;

            for(StatusEffect status : character.getStatusEffectContainer().getStatusEffects())
            {
                // account for when one status effect exists (no , after it)
                if(character.getStatusEffectContainer().getStatusEffects().size() == 1)
                {
                    builder.append(status.getName());
                }
                // account for last status effect (no , after it)
                else if(counter == (character.getStatusEffectContainer().getStatusEffects().size() - 1))
                {
                    builder.append(status.getName());
                }
                // account for next status effect (, after it)
                else
                {
                    builder.append(status.getName());
                        builder.append(", ");
                            counter++;
                }
            }

            return builder.toString();
        }

        // Note: new line is called AFTER element is added to model 
        public static void addPartyMemberDetails(DefaultListModel<String> partyMemberModel, 
            GenericCharacter character, int counter)
        {
            // counter is used to identify number of party members in battle
            partyMemberModel.addElement(name(character, counter));
            partyMemberModel.addElement(health(character));
            partyMemberModel.addElement(stamina(character));
            partyMemberModel.addElement(nano(character));
            partyMemberModel.addElement(statusEffectString(character));
        }

        public static DefaultListModel<String> partyMembersModel(Party party)
        {
            DefaultListModel<String> partyMembers = new DefaultListModel<>();

            int counter = 1;

            for(GenericCharacter character : party.getPartyMembers())
            {
                if(party.getPartyMembers().size() == 1)
                {
                    addPartyMemberDetails(partyMembers, character, counter);
                }
                else if(counter == party.getPartyMembers().size())
                {
                    addPartyMemberDetails(partyMembers, character, counter);
                }
                else
                {
                    addPartyMemberDetails(partyMembers, character, counter);
                    partyMembers.addElement("\n\n");
                }

                counter++;
            }

            return partyMembers;
        }

        public static void setModelForPartyJLists()
        {
            partyOneBottom = new JList(partyMembersModel(referencePartyOne));
            partyTwoTop = new JList(partyMembersModel(referencePartyTwo));
        }

        // END: UPDATING PARTY MEMBER JLIST BY PARTY
        /*******************************************************************************/



        // START: UPDATING TRUN TRACKING JLISTS
        /*******************************************************************************/

        public static DefaultListModel<String> turnTrackingJListModel(PriorityQueue
            <GenericCharacter> priorityQueue)
        {
            DefaultListModel<String> model = new DefaultListModel<>();

            for(GenericCharacter element : priorityQueue)
            {
                model.addElement(element.getGeneralFeatures().getName());
            }

            return model;
        }

        public static DefaultListModel<String> escapedCharactersJListModel(ArrayList
            <GenericCharacter> escapedCharacters)
        {
            DefaultListModel<String> model = new DefaultListModel<>();

            for(GenericCharacter element : escapedCharacters)
            {
                model.addElement(element.getGeneralFeatures().getName());
            }

            return model;
        }

        // END: UPDATING TRUN TRACKING JLISTS
        /*******************************************************************************/



        // START: EXTERNAL FRAME STUFF BELOW!!!!

        // START: GETTING CHARACTER DISPLAYED IN JLIST 
        /*******************************************************************************/

        public static GenericCharacter findCharacterInParty(String characterName, Party party)
        {
            GenericCharacter character = null;

            for(GenericCharacter element : party.getPartyMembers())
            {
                if(characterName.equals(element.getGeneralFeatures().getName()))
                {
                    character = element;
                }
            }

            return character;
        }

        // Note: gets character REGARDLESS of whether character is KO or has escaped 
        //       so consider boolean condition for finding KO and non-KO combatants? 
        public static GenericCharacter getCharacter(Object name)
        {
            GenericCharacter character = findCharacterInParty(((String)name), referencePartyOne);

            if(character == null)
            {
                character = findCharacterInParty(((String)name), referencePartyTwo);
            }

            return character;
        }

        // END: GETTING CHARACTER DISPLAYED IN JLIST 
        /*******************************************************************************/



        // START: EXTERNAL FRAME ATTACK ACTION
        /*******************************************************************************/

        // ATTACK FRAME COMPONENTS 

        public static JButton attackDetailButtons(String text)
        {
            JButton button = new JButton(text);

            button.setBackground(Color.BLACK);

            button.setForeground(Color.WHITE);

            button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

            return button;
        }

        public static void addExternalAttackDetailsComponent(JButton button, int gridy, int gridx, double
            weighty, double weightx, int gridheight, int gridwidth, JFrame frame)
        {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();

            // button will expand horizontally to fill empty space 
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

            // row position 
            gridBagConstraints.gridy = gridy;

            // column of specified row position
            gridBagConstraints.gridx = gridx;

            // specified column length component takes up in frame height
            gridBagConstraints.weighty = weighty;

            // specified row length component takes up in frame width
            gridBagConstraints.weightx = weightx;

            // width of component in given row 
            gridBagConstraints.gridwidth = gridwidth;

            // vertical padding in pixels for component in given row 
            gridBagConstraints.ipady = 55;

            // specifies space component must leave at each edges; (Insets(int 
            // top, int left, int bottom, int right)
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);

            // add button to frame with positioning 
            frame.add(button, gridBagConstraints);
        }

        public static void addExternalAttackDetailsButtons(JButton button, int gridy, int gridx, 
            int gridheight, int gridwidth, JFrame frame)
        {
            // Note: if component width is 0, component occupies whole row 
            addExternalAttackDetailsComponent(button, gridy, gridx, 0.11, 0.33, gridheight, gridwidth, frame);
        }

        public static void addAttackDetailsButtons(JFrame externalFrame)
        {
            String formatAttackName = String.format("%-35s", "Attack");
                addExternalAttackDetailsButtons(attackDetailButtons(formatAttackName), 0, 0, 1, 1, externalFrame);

            String formatAttackOverview = String.format("%-35s", "Overview: Default Universal Move");
                addExternalAttackDetailsButtons(attackDetailButtons(formatAttackOverview), 1, 0, 1, 1, externalFrame);

            String formatAttackDescription = String.format("%-35s", "Description: damage single target.");
                addExternalAttackDetailsButtons(attackDetailButtons(formatAttackDescription), 2, 0, 1, 1, externalFrame);
        }

        public static void addAllAvailableCombatantsJListComponent(JList jList, int gridy, int gridx, 
            int gridheight, int gridwidth, JFrame frame)
        {
            // allign view of JList such that text is displayed at its center 
            DefaultListCellRenderer renderer = (DefaultListCellRenderer) jList.getCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);

            GridBagConstraints gridBagConstraints = new GridBagConstraints();

            // add JScrollPane to frame to enable vertical scrolling for JList  
            JScrollPane jListScroll = new JScrollPane(jList, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // button will expand horizontally to fill empty space 
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

            // row position 
            gridBagConstraints.gridy = gridy;

            // column of specified row position
            gridBagConstraints.gridx = gridx;

            // specified column length component takes up 
            gridBagConstraints.weighty = 0.20;

            // specified row length component takes up 
            gridBagConstraints.weightx = 0.20;

            // height of component in given column 
            gridBagConstraints.gridheight = gridheight;

            // width of component in given row 
            gridBagConstraints.gridwidth = gridwidth;

            // vertical and horizontal padding in pixels for component in given row 
            gridBagConstraints.ipady = 165;
            gridBagConstraints.ipadx = 165;

            // specifies space component must leave at each edges; (Insets(int 
            // top, int left, int bottom, int right)
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);

            // add button to frame with positioning 
            frame.add(jListScroll, gridBagConstraints);
        }

        public static void addAllAvailableNonKoCombatantsJList(JFrame frame)
        {
            allAvailableNonKoCombatantsJList = setUpJList(allAvailableNonKoCombatantsJList);
                addAllAvailableCombatantsJListComponent(allAvailableNonKoCombatantsJList, 
                    0, 1, 3, 2, frame);
        }

        public static DefaultListModel<String> allNonKoCombatantsModel(PriorityQueue
            <GenericCharacter> allPqContents)
        {
            DefaultListModel<String> model = new DefaultListModel<>();

            for(GenericCharacter element : allPqContents)
            {
                if(!element.getGeneralFeatures().knockedOut())
                {
                    String name = String.format("%s", element.getGeneralFeatures().
                        getName());

                    model.addElement(name);
                }
            }

            return model;
        }

        public static void addExternalAttackChoiceComponent(JButton button, int gridy, int gridx, double
            weighty, double weightx, int gridheight, int gridwidth, JFrame frame)
        {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();

            // button will expand horizontally to fill empty space 
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            // row position 
            gridBagConstraints.gridy = gridy;

            // column of specified row position
            gridBagConstraints.gridx = gridx;

            // specified column length component takes up in frame height
            gridBagConstraints.weighty = weighty;

            // specified row length component takes up in frame width
            gridBagConstraints.weightx = weightx;

            // height of component in given column 
            gridBagConstraints.gridheight = gridheight;

            // width of component in given row 
            gridBagConstraints.gridwidth = gridwidth;

            // specifies space component must leave at each edges; (Insets(int 
            // top, int left, int bottom, int right)
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);

            // add button to frame with positioning 
            frame.add(button, gridBagConstraints);
        }

        public static void addExternalAttackChoiceButtons(JButton button, int gridy, int gridx, JFrame frame)
        {
            // Note: if component width is 0, component occupies whole column/row 
            addExternalAttackChoiceComponent(button, gridy, gridx, 0.11, 0.33, 3, 1, frame);
        }

        public static void attackBattleLogEvent(String userName, String targetName, MoveCalculations 
            calculations, JTextArea battleLog)
        {
            String event = String.format("%s%s attacked %s!\n", desiredSpaces(18), userName, targetName);
                battleLog.append(event);

            // proceed if attack did not miss the target 
            if(!calculations.missed())
            {
                String result = String.format("%s%s dealt %d damage!\n", desiredSpaces(18), userName, 
                    (int)calculations.getOutput());
                        battleLog.append(result);

                // account for knock out after attack is made against target 
                if(getCharacter(targetName).getGeneralFeatures().knockedOut())
                {
                    String knockedOut = String.format("%s%s was knocked out!\n\n", desiredSpaces(18), targetName);
                        battleLog.append(knockedOut);
                }
                else
                {
                    battleLog.append("\n");
                }
            }
            // else account for move missing 
            else
            {
                String result = String.format("%s%s\n\n", desiredSpaces(18), "But the attack missed!");
                    battleLog.append(result);
            }
        }

        public static void addConfirmAttackActionListener(JButton button)
        {
            button.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // since user is character at head of current round, make 
                        // sure that character is treated as move user 
                        currentRoundJList.setSelectedIndex(0);

                        // store name of move user 
                        Object userName = currentRoundJList.getSelectedValue();

                        // store name of move target  
                        Object targetName = allAvailableNonKoCombatantsJList.getSelectedValue();
                        
                        // use factory object to call pre-made method for attack move
                        MovesFactory factory = new MovesFactory();

                        // create object meant for calculating outcome of move 
                        MoveCalculations calculation = new MoveCalculations();

                        // perform attack move on desired target 
                        calculation.singleTargetMoveLogic(getCharacter(userName), 
                            getCharacter(targetName), factory.getStandardAttack());

                        // attack text is appended to battle log 
                        attackBattleLogEvent((String)userName, (String)targetName,  
                            calculation, battleLog);

                        // reload party JLists to display results of action 
                        partyOneBottom.setModel(partyMembersModel(referencePartyOne));
                        partyTwoTop.setModel(partyMembersModel(referencePartyTwo));

                        // dispose of external frame upon attack
                        externalFrame.dispose();

                        // turn complete upon selecting attack
                        Battle.turnComplete = true;
                    }
                }); 
        }

        public static void addAttackChoiceButton(JFrame externalFrame)
        {
            JButton attackChoice = newUsableButton("Choice");
                addConfirmAttackActionListener(attackChoice);
                    addExternalAttackChoiceButtons(attackChoice, 0, 3, externalFrame);
        }

        public static void attackExternalFrame(JFrame externalFrame)
        {
            // add button for name. overview, and description and JList for 
            // all active characters 
            addAttackDetailsButtons(externalFrame);
            addAllAvailableNonKoCombatantsJList(externalFrame);
            addAttackChoiceButton(externalFrame);

            // create dummy priority queue that sorts accoring to style set for
            // priority queues created and managed in inner class Battle 
            PriorityQueue<GenericCharacter> storePqContents = new PriorityQueue<>( 
                (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
                getBattleDexterity()));

            // fill dummy priority queue with contents of turn tracking priority 
            // queues that exist in inner class Battle 
            Battle.clearAndFillAllPqContents(storePqContents, Battle.currentRound, Battle.nextRound);

            // fill JList with all non-ko characters that have not fled from battle 
            allAvailableNonKoCombatantsJList.setModel(allNonKoCombatantsModel(
                storePqContents)); 

            // set default target of move to 0 such that first character in 
            // JList is target of move to avoid passing null as target 
            allAvailableNonKoCombatantsJList.setSelectedIndex(0);
        }

        // ATTACK FRAME COMPONENTS 



        // SETTING UP EXTERNAL FRAME BASED ON BOOLEAN 

        public static void externalFrameByBoolean(JFrame externalFrame)
        {
            if(attackFrameActive)
            {
                attackExternalFrame(externalFrame);
            }
            else if(skillsFrameActive)
            {

            }
            else if(itemsFrameActive)
            {

            }
        }

        public static void externalFrameLocation()
        {
            // external frame is reset each time option is selected (better than 
            // creating new JFrames each time option is selected)
            externalFrame = new JFrame();

            // frame has components set up according to GridBagLayout scheme 
            externalFrame.getContentPane().setLayout(new GridBagLayout());

            // use location properties of original frame to position use frame
            Rectangle bounds = frame.getBounds();

            // calculation makes frame have location starting from bottom left 
            // of outer frame with y-axis position based on bounds.y multiplier 
            // (in this case 1.75) and outer multiplier (in this case 0.58); 
            externalFrame.setLocation(bounds.x, (int)((bounds.y * 1.75 + frame.
                getHeight()) * 0.58));

            // set up components for external frame so player can use it 
            externalFrameByBoolean(externalFrame);

            // external frame width equal to width of original frame and while height 
            // is calculated using original frame height as point of reference 
            externalFrame.setSize(frame.getWidth(), (int)(0.42 * frame.getHeight()));
            externalFrame.setVisible(true);

            // Note: externalFrame is NOT set to exit on close since doing so will 
            //       cause program to terminate early (disposing original frame 
            //       will dispose of this frame as well (Maybe?))
        }

        public static void usableButtonActionListeners()
        {
            attack.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // brings up external frame with all possible characters 
                        // in battle that can be attacked via JList and attack
                        // via JList popup menu with "target" command then show
                        // text of move being used in center JTextArea and results

                        // set other external frame variant to false 
                        skillsFrameActive = false;
                        itemsFrameActive = false;

                        // prevents creation of infinite exteral frames by disposing 
                        // of external frame if it is active before creating new one
                        // and reset appropriate boolean indicators 
                        externalFrame.dispose();

                        // indicate frame style that should be active
                        attackFrameActive = true;

                        // set up new external frame according to view/equip boolean 
                        externalFrameLocation();
                    }
                }); 

            skills.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // brings up external frame with all moves available to 
                        // character, and upon move selection show targets for 
                        // move and data about move stuff (output, ect.) and show
                        // result in JTextArea 
                    }
                }); 
                    // does not exist in this build due to time constraints 
                    skills.setEnabled(false);

            items.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // brings up external frame with items usable in battle
                        // with brief info on what item does and item selection 
                        // via popup command "use" brings up items targets in 
                        // battle and allows character to use item 
                    }
                }); 
                    // does not exist in this build due to time constraints 
                    items.setEnabled(false);
        }

        // SETTING UP EXTERNAL FRAME BASED ON BOOLEAN 

        // END: EXTERNAL FRAME STUF BELOW!!!!
        /*******************************************************************************/
    }
}
