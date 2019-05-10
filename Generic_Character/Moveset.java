package Generic_Character;

/*
    Moveset concerns storing moves or actions that a character can perform mid-
    battle. Moves held within a moveset can be sorted by personal preference by 
    selecting customize or in several predefined ways if the player desires. 
*/

import Move.Moves;        // asterisk (*) imports all classes in package Generic_Object
import Universally_Used_Methods.StaticMethods;
import java.util.LinkedHashSet;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Moveset extends Immunities
{
    // stores moves objects such that they are sorted by insertion order 
    LinkedHashSet<Moves> moveset = new LinkedHashSet<>();
 
    
    
    // START: ADDING/REMOVING MOVES AND RETRIEVING MOVELIST 
    /*******************************************************************************/

    public void addMove(Moves move)
    {
        if(move != null)
        {
            moveset.add(move);
        }        
    }
    
    public void removeMove(String moveName)
    {
        for(Moves move : moveset)
        {
            if(move.getName().equals(moveName))
            {
                moveset.remove(move);
            }
        }
    }
    
    public void removeMove(Moves move)
    {
        moveset.remove(move);
    }
    
    // gets moveset containing all moves avaialble to character player 
    public LinkedHashSet<Moves> getInventory()
    {
        return moveset;
    }
            
    // END: ADDING/REMOVING OBJECTS AND RETRIEVING INVENTORY 
    /*******************************************************************************/
    
    
    
    // START: PRINTING INVENTORY CONTENTS (NEED GUI LOGIC)
    /*******************************************************************************/

    /*
    
    // consider removing numbers on left side... 

    // prints contents of inventory like so: position #. objectName: # of objects 
    public void printInventory()
    {
            // initialize counter instance variable to 1 each time the method is called 
            counter = 1; 

            // if there is at least one object stores in inventory then enter the if 
            // statement else print out statement saying inventory is empty 
            if(inventory.size() != 0)
            {
                    // enhanced for loop creates linked hashmap object inventoryCopy with 
                    // a key and value type identical to the types of linked hashmap object 
                    // inventory; inventoryCopy iterates through inventory and 
                    // retrieves all entry sets (keys and values) of inventory 
                    for(Map.Entry<GenericObject, ArrayList<GenericObject>> inventoryCopy : inventory.entrySet()) 
                    {
                            // store name of the inventory object object in String variable objectName			
                            objectName = inventoryCopy.getKey().getName();

                            // convert counter to String in order to format it
                            convertCounter  = convertCounter.format("%d)", counter);

                            // format String such that entry set keys are four spaces after number
                            convertCounter  = convertCounter.format("%-4s", convertCounter);

                            // format objectName such that the string is aligned 20 spaces to the left
                            // using format modifier '-' with a specification of 20 before the s; if 
                            // the modifier is not included, the string will default to the right 
                            objectName = objectName.format("%s%-17s", convertCounter, objectName);

                            // get and store object group size (number of objects in object group)
                            arrayListTotal = inventoryCopy.getValue().size();

                            // notify user about what is about to be printed 
                            if(counter == 1)
                            {
                                    System.out.println("Contents of party inventory...");
                            }

                            // if-else statement displays inventory along with a counter 
                            // if remainder is 1, display object on left else display it on right 
                            if(counter % 2 == 1)
                            {
                                    System.out.printf("%s: %d", objectName, arrayListTotal);
                                            counter++;
                            }
                            else 
                            {
                                    System.out.printf("\t%s: %d\n", objectName, arrayListTotal);
                                            counter++;
                            }
                    }
            }
            else
            {
                    // print statement only if there are no objects in the inventory
                    System.out.println("There are no objects stored in the party inventory.");
            }

            // print new line to improve readability 
            System.out.println();
    }

    */
    // END: PRINTING INVENTORY CONTENTS (NEED GUI LOGIC)
    /*******************************************************************************/

    /*
        Sorting Inventory TreeMap
    
            Customize:          player personally customizes object position 
            General Sort:	sort all moves at once in ascending order
              - Name
              - Damage Type
              - Gauge Used
              - Enchantment
              - Target
              - Effect 
              - ADD PATHING STUFF
    */

    // START: CUSTOMIZE MOVE PLACEMENT BY SWAPPING TWO MOVES AT A TIME 
    /********************************************************************************/

    // places moves meant to be swapped in the supplied HashSet
    public void storeSelectedMoves(HashSet<Moves> movesToBeSwapped, int 
        moveSelected, int swapWithMoveAtPosition)
    {
        // start counting from first moveset move if moveset is not empty 
        int counter = 1;

        // enchanced for loop loops through contents of moveset
        for(Moves move : moveset) 
        {
            // if statement stores moves meant to be swapped  
            if(counter == moveSelected || counter == swapWithMoveAtPosition)
            {
                movesToBeSwapped.add(move);
            }
            
            counter++;
        }
    }
    
    // contains code relating to how moveset moves are awapped 
    public void customizeLogic(HashSet<Moves> movesToBeSwapped, LinkedHashSet<
        Moves> holdMoveList, int moveSelected, int swapWithMoveAtPosition)
    {
        // start counting from first moveset move if moveset is not empty 
        int counter = 1;
        
        // enchanced for loop loops through contents of holdMoveList 
        for(Moves move : holdMoveList)
        {
            // if statement concerns swapping moves selected for swapping (moveSelected) 
            // with move at location swapWithMoveAtPosition  
            if(counter == moveSelected || counter == swapWithMoveAtPosition)
            {
                // enhanced for loop loops through movesToBeSwapped to get desired move
                for(Moves element : movesToBeSwapped)
                {
                    // if moves do not match then add movesToBeSwapped move to moveset  
                    if(move.equals(element))
                    {
                        moveset.add(element);
                    }
                }
            }
            else
            {
                // insert entry set into inventory
                moveset.add(move);
            }

            // increment counter by one 
            counter++;
        }
    }
    
    // allows players to "customize" move positions in moveset by allowing them
    // to swap one move with another if possible (typing or w/mouse) 
    public void customize(int entrySelected, int swapWithEntryAtPosition)
    {
        // customize move positions only if there is more than one move
        if(moveset.size() >  1)
        {
            // proceed if entrySelected is within bounds of moveset
            if(entrySelected >= 1 && entrySelected <= moveset.size())
            {
                // proceed if swapWithEntryAtPosition is within bounds of moveset
                if(swapWithEntryAtPosition >= 1 && swapWithEntryAtPosition <= moveset.size())
                {
                    // proceed if user did not decide to swap entry set with itself 
                    if(entrySelected != swapWithEntryAtPosition)
                    {
                        // TreeMap meant to temporarily store entries meant to be swapped 
                        HashSet<Moves> entriesToBeSwapped = new HashSet<>();

                        // store moves meant to be swapped in supplied HashSet 
                        storeSelectedMoves(entriesToBeSwapped, entrySelected, swapWithEntryAtPosition);
                        
                        // store moveLsit collection in holdMoveList before moveset is cleared 
                        LinkedHashSet<Moves> holdMoveList = new LinkedHashSet<>(moveset);

                        // moveset is cleared so entries can be placed properly 
                        moveset.clear();
                        
                        // customize moveset move positions using HashSets/LinkedHashSets supplied 
                        customizeLogic(entriesToBeSwapped, holdMoveList, entrySelected, swapWithEntryAtPosition);
                    }
                }
            }
        }
    }

    // END: CUSTOMIZE MOVE PLACEMENT BY SWAPPING TWO MOVES AT A TIME 
    /********************************************************************************/
    
    /*	To create a custom comparator data structure using some form of ordering: 
            Override existing comparator 
            Comparator must have the same type as the key in TreeMap NOT value
            Comparator curly braces ( {} ) must end with a semicolon symbol (;) */
    
    // START: METHODS USED BY COMPARATORS
    /********************************************************************************/

    /* compareTo() is not used for String comparison due to how sorting is handled 
       compareTo() sorting: number, Uppercase, lowercase -> 1Apple, Apple, Bee, apple */

    // compare two strings and determine whether they are the same or different regardless
    // of case (i.e. "example" would be considered the same as "Example") 
    // method used in comparators for TreeMaps involving string comparison between keys
    public int compareStrings(String argumentOne, String arguementTwo)
    {
            // code compares names without regard to case and stores result of comparison 
            // (1, 0, -1) in stringComparisonResult (1 & -1 is different while 0 is same)
            int stringComparisonResult = String.CASE_INSENSITIVE_ORDER.compare(argumentOne, arguementTwo);

            // if strings are identical, set stringComparisonResult to 1 in order to place 
            // entry after the entry it is being compared to since order does not matter
            if(stringComparisonResult == 0)
            {
                // if stringComparisonResult was not changed here, the key of the entry 
                // that is being compared to the key of entry that exists in the TreeMap 
                // would "merge/disappear" or not be added to the TreeMap along with its 
                // value resulting in data loss 
                stringComparisonResult = 1;
            }

            return stringComparisonResult;
    }

    // compare int values and return whether arguments are the same or different 
    public int compareIntegers(int argumentOne, int arguementTwo)
    {
        int numberComparisonResult = 0;
        
        // place arguementTwo after argumentOne if it is less than argumentOne 
        // else put arguementTwo before argumentOne 
        if (argumentOne >= arguementTwo)
        {
            numberComparisonResult = -1;
        } 
        else
        {
            numberComparisonResult = 1;
        }

        return numberComparisonResult;
    }

    // compare double values and return whether arguments are the same or different 
    public int compareDoubles(double argumentOne, double arguementTwo)
    {
        int numberComparisonResult = 0;
        
        // place arguementTwo after argumentOne if it is less than argumentOne 
        // else put arguementTwo before argumentOne 
        if (argumentOne >= arguementTwo)
        {
            numberComparisonResult = -1;
        } 
        else
        {
            numberComparisonResult = 1;
        }

        return numberComparisonResult;
    }

    // END: METHODS USED BY COMPARATORS
    /********************************************************************************/

    
    
    // START: COMPARATORS USING MOVES METHODS TO SORT DATA STRUCTURES 
    /********************************************************************************/

    /* Note: String comparators order "Tree"-like data structures in ascending 
             order: number -> A -> Z. Double comparators order by double value */
    
    /* Both examples below mean the same thing 
    
       Anonymouse inner class example: 
        public Comparator<GenericObject> sortByName = new Comparator<GenericObject>() 
        {
            @Override 
            public int compare(GenericObject objectOne, GenericObject objectTwo) 
            {
                return compareStrings(objectOne.getName(), objectTwo.getName());
            }
        }; 
        
       Lambda Expression
        public Comparator<GenericObject> sortByName = (GenericObject objectOne, GenericObject 
            objectTwo) -> compareStrings(objectOne.getName(), objectTwo.getName()); 
    */
    
    public Comparator<Moves> sortByName = (Moves moveOne, Moves moveTwo) -> 
        compareStrings(moveOne.getName(), moveTwo.getName()); 

    public Comparator<Moves> sortByDamageType = (Moves moveOne, Moves moveTwo) -> 
        compareStrings(moveOne.getDamageTypeAsString(), moveTwo.getDamageTypeAsString()); 
    
    public Comparator<Moves> sortByGaugeUsed = (Moves moveOne, Moves moveTwo) -> 
        compareStrings(moveOne.getGaugeUsedAsString(), moveTwo.getName()); 
    
    public Comparator<Moves> sortByEnchantment = (Moves moveOne, Moves moveTwo) -> 
        compareStrings(moveOne.getEnchantment(), moveTwo.getEnchantment()); 
    
    public Comparator<Moves> sortByTarget = (Moves moveOne, Moves moveTwo) -> 
        compareStrings(moveOne.getTargetAsString(), moveTwo.getTargetAsString()); 
    
    public Comparator<Moves> sortByEffect = (Moves moveOne, Moves moveTwo) -> 
        compareStrings(moveOne.getEffectAsString(), moveTwo.getEffectAsString()); 

    // END: COMPARATORS USING MOVES METHODS TO SORT DATA STRUCTURES 
    /********************************************************************************/
						
						
    
    // START: METHODS USED THROUGHOUT GENERAL SORT
    /********************************************************************************/

    // fills TreeMap with every inventory entry set 
    public void fillTreeSetForGeneralSort(TreeSet<Moves> sortMoveListBy)
    {
        for(Moves element : sortMoveListBy)
        {
            sortMoveListBy.add(element);
        }
    }

    // fills inventory with contents of sorted TreeMap
    public void fillMoveListAfterGeneralSort(TreeSet<Moves> sortMoveListBy)
    {
        for(Moves element : sortMoveListBy)
        {
            moveset.add(element);
        }
    }

    // all objects in moveset are sorted according to comparator supplied 
    public void generalSort(Comparator<Moves> comparator)
    {
        // sortMoveListBy sorts all moveset moves according to comparator  
        TreeSet<Moves> sortMoveListBy = new TreeSet<>(comparator);

        // fill empty TreeSet with contents of moveset 
        fillTreeSetForGeneralSort(sortMoveListBy);

        // clear moveset to properly fill it in later  
        moveset.clear();

        // fill moveset with contents of sorted TreeSet sortMoveListBy
        fillMoveListAfterGeneralSort(sortMoveListBy);
    }

    // END: METHODS USED THROUGHOUT GENERAL SORT
    /********************************************************************************/

    
    
    // START: GENERAL SORT SORTS ALL MOVELIST MOVES IN A PREDEFINED WAY
    /********************************************************************************/

    /* Note: methods sort all objects in inventory in ascending order according 
             to comparator supplied to generalSort() */
    
    public void generalSortByName()
    {
        generalSort(sortByName);
    }

    public void generalSortByDamageType()
    {
        generalSort(sortByDamageType);
    }

    public void generalSortByGaugeUsed()
    {
        generalSort(sortByGaugeUsed);
    }

    public void generalSortByEnchantment()
    {
        generalSort(sortByEnchantment);
    }

    public void generalSortByTarget()
    {
        generalSort(sortByTarget);
    }

    public void generalSortByEffect()
    {
        generalSort(sortByEffect);
    }

    // END: GENERAL SORT SORTS ALL MOVELIST MOVES IN A PREDEFINED WAY
    /********************************************************************************/
    
    
    
    // START: DISPLAY STAMINA/NANO MOVES AVAILABLE TO GENERICHARACTER
    /********************************************************************************/

    
    
    
    
    
    
    // method adds moves from desired ArrayLists to ArrayList meant to hold available moves 
    public void addArrayContents(ArrayList<Moves> arrayList, ArrayList<Moves> availableMoves)
    {
        for(Moves move: availableMoves)
        {
            arrayList.add(move);
        }
    }
    
    
    // START: STORING UNIVERSAL STAMINA/NANO MOVES AVAILABLE TO CHARACTER
    /********************************************************************************/
    
    // store universal stamina moves in ArrayList 
    public void storeUniversalStaminaMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
            getSkill()) == Moves.Skills.UNIVERSAL_MOVES_STAMINA)).forEachOrdered((move) 
            -> { arrayList.add(move);
        }); 
    }
    
    // store universal nano moves in ArrayList 
    public void storeUniversalNanoMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
            getSkill()) == Moves.Skills.UNIVERSAL_MOVES_NANO)).forEachOrdered(
            (move) -> { arrayList.add(move);
        }); 
    }
    
    // store universal stamina/nano moves based on status and Moves.Approaches 
    // Note: StringBuilder is used for concatenation since it is generally 
    //       faster than "a" + "b" and method concat() 
    public void addAvailableUniversalMoves(GenericCharacter character, ArrayList
        <Moves> arrayList, Moves.Approaches staminaOrNano)
    {
        // store moves that have a chance of being omitted by status effects 
        // Ex: if "Ommit Universal Stamina Moves" ("Stamina" is String of enum) 
        //     then ommit moves where getSkill() is "Universal Moves Stamina" 
        String ommitUniversal = new StringBuilder("Omit Universal ").append(
            staminaOrNano.getEnumAsString()).append(" Moves").toString();

        // if status effect does not exist then add moves to ArrayList 
        if(!character.statusExists(ommitUniversal))
        {
            // add stamina/nano moves to ArrayList depending on staminaOrNano
            if(staminaOrNano == Moves.Approaches.STAMINA)
            {
                storeUniversalStaminaMoves(arrayList);
            }
            else if(staminaOrNano == Moves.Approaches.NANO)
            {
                storeUniversalNanoMoves(arrayList);
            }
        }
    }
    
    // END: STORING UNIVERSAL STAMINA/NANO MOVES AVAILABLE TO CHARACTER
    /********************************************************************************/

    
    
    // START: STORING UNIVERSAL STAMINA/NANO MOVES AVAILABLE TO CHARACTER
    /********************************************************************************/
    
    // store close quarters combat stamina moves in ArrayList 
    public void storeHandToHandStaminaMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (Moves.getStyleEnumUsingString(move.
            getStyle()) == Moves.Styles.HAND_TO_HAND_STAMINA)).forEachOrdered((move) 
            -> { arrayList.add(move);
        }); 
    }
    
    // store close quarters combat nano moves in ArrayList 
    public void storeHandToHandNanoMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (Moves.getStyleEnumUsingString(move.
            getStyle()) == Moves.Styles.HAND_TO_HAND_NANO)).forEachOrdered((move) 
            -> { arrayList.add(move);
        }); 
    }
    
    // store close quarters combat stamina moves in ArrayList 
    public void storeCloseQuartersCombatStaminaMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
            getSkill()) == Moves.Skills.CLOSE_QUARTERS_COMBAT_STAMINA)).forEachOrdered((move) 
            -> { arrayList.add(move);
        }); 
    }
    
    // store close quarters combat nano moves in ArrayList 
    public void storeCloseQuartersCombatNanoMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
            getSkill()) == Moves.Skills.CLOSE_QUARTERS_COMBAT_NANO)).forEachOrdered((move) 
            -> { arrayList.add(move);
        }); 
    }
    
    // return enum which will be used to get moves tied to desired hand to hand style 
    public Moves.Styles handToHandStyle(GenericCharacter character, Moves.
        Approaches staminaOrNano)
    {
        // used to determine what moves to get 
        String handToHand = new StringBuilder("Hand To Hand").append(" ").
            append(staminaOrNano.getEnumAsString()).toString();
        
        // used to get desired moves 
        Moves.Styles handToHandSkills = Moves.Styles.valueOf(StaticMethods.
            stringToEnum(handToHand));
        
        return handToHandSkills;
    }
    
    // return enum which will be used to get moves tied to weapon super type 
    public Moves.Skills weaponSuperType(GenericCharacter character, Moves.
        Approaches staminaOrNano)
    {
        // used to determine what moves are tied to weapon super type  
        String weaponSuperType = new StringBuilder(character.getWeapon().getSuperType()).
            append(" ").append(staminaOrNano.getEnumAsString()).toString(); 

        // used to get moves tied to weapon super type
        Moves.Skills weaponSuperTypeSkills = Moves.Skills.valueOf(StaticMethods.
            stringToEnum(weaponSuperType));
        
        return weaponSuperTypeSkills;
    }
    
    // return String indicating status effect name which will ommit moves 
    public String ommitMoves(String argument)
    {
        argument = new StringBuilder("Ommit ").append(argument).append(" Moves").toString(); 
            return argument;
    }
    
    // adds Hand To Hand moves available to unaremed characters in battle 
    // to ArrayList based on status effects, and enum specified 
    public void addHandToHandMoves(GenericCharacter character, ArrayList
        <Moves> arrayList, Moves.Approaches staminaOrNano)
    {
        // used to get desired "Hand To Hand" moves 
        Moves.Styles handToHandSkills = handToHandStyle(character, staminaOrNano);
        
        // proceed if character can perform Hand To Hand moves
        // Ex: if "Ommit Hand To Hand Stamina Moves" then ommit moves with 
        //     category "Hand To Hand Stamina"  
        if(!character.statusExists(ommitMoves(handToHandSkills.getEnumAsString())))
        {
            // store universal moves tied to weapon category in ArrayList 
            if(staminaOrNano == Moves.Approaches.STAMINA)
            {
                storeHandToHandStaminaMoves(arrayList);
            }
            else if(staminaOrNano == Moves.Approaches.NANO)
            {
                storeHandToHandNanoMoves(arrayList);
            }
        }
    }
    
    // adds Hand To Hand moves available to unaremed characters in battle 
    // to ArrayList based on status effects, and enum specified 
    public void addCloseQuartersCombatMoves(GenericCharacter character, ArrayList
        <Moves> arrayList, Moves.Approaches staminaOrNano)
    {
        if(character.getWeapon() != null)
        {
            // used to get moves tied to weapon super type 
            Moves.Skills weaponSuperTypeSkills = weaponSuperType(character, staminaOrNano);

            // proceed if character can perform weapon moves for weapon super type 
            // Ex: if "Ommit Sword Stamina Moves" then ommit moves with super type 
            //     "Sword Stamina" 
            if(!character.statusExists(ommitMoves(weaponSuperTypeSkills.getEnumAsString())))
            {
                // store moves tied to weapon super type in ArrayList 
                if(staminaOrNano == Moves.Approaches.STAMINA)
                {
                    storeCloseQuartersCombatStaminaMoves(arrayList);
                }
                else if(staminaOrNano == Moves.Approaches.NANO)
                {
                    storeCloseQuartersCombatNanoMoves(arrayList);
                }
            }
        }
    }
    
    // END: STORING UNIVERSAL STAMINA/NANO MOVES AVAILABLE TO CHARACTER
    /********************************************************************************/


    
    // START: STORING MOVES AVAILABLE TO CHARACTER BASED ON WEAPON WIELDED
    /********************************************************************************/

    // store universal weapon stamina moves in arrayList using weapon category 
    public void storeWeaponCategoryStaminaMoves(ArrayList<Moves> arrayList, Moves.Styles weaponStyle)
    {
        switch (weaponStyle) 
        {
            case ONE_HANDED_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.UNIVERSAL_ONE_HANDED_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case TWO_HANDED_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.UNIVERSAL_TWO_HANDED_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case DUAL_WIELDED_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.UNIVERSAL_DUAL_WIELDED_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            default:
                break;
        }
    }
    
    // store universal weapon nano moves in arrayList using weapon category 
    public void storeWeaponCategoryNanoMoves(ArrayList<Moves> arrayList, Moves.Styles weaponStyle)
    {
        switch (weaponStyle) 
        {
            case ONE_HANDED_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.UNIVERSAL_ONE_HANDED_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case TWO_HANDED_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.UNIVERSAL_TWO_HANDED_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case DUAL_WIELDED_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.UNIVERSAL_DUAL_WIELDED_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            default:
                break;
        }
    }
    
    // add moves from ArrayList created in addMovesBasedOnStatus() to ArrayList 
    // passed to method addMovesBasedOnStatus() based on availability status 
    public void addMovesByAvailability(ArrayList<Moves> movesOfDesiredSkill, ArrayList<Moves> arrayList, 
        Moves.MoveAvailabilityStatuses availabilityStatus)
    {
        movesOfDesiredSkill.stream().filter((element) -> (Moves.getMoveAvailabilityStatusEnumUsingString(
            element.getMoveAvailabilityStatus()) == availabilityStatus)).forEachOrdered(
            (element) -> {arrayList.add(element);
        });
    }
    
    // add moves based on skills desired and add/ommit moves based on statuses 
    // Note: parameter at end of method is a "var args" indicating that method
    //       accepts a variable number of arguments which will be stored in an
    //       array of type MoveAvailabilityStatuses
    public void addMovesToArrayList(GenericCharacter character, ArrayList<Moves> arrayList, 
        Moves.Skills desiredSkills, Moves.MoveAvailabilityStatuses...availabilityStatusArray)
    {
        ArrayList<Moves> movesOfDesiredSkill = new ArrayList<>();
        
        // add reference to moves of desired skill to movesOfDesiredSkill for addition/retrieval 
        moveset.stream().filter((element) -> (Moves.getSkillEnumUsingString(element.getSkill()) 
            == desiredSkills)).forEachOrdered((element) -> {movesOfDesiredSkill.add(element);
        });
        
        // add moves of desired skill that will not be ommitted by special status effects
        addMovesByAvailability(movesOfDesiredSkill, arrayList, Moves.MoveAvailabilityStatuses.NONE);
        
        // for loop accounts for MoveAvailabilityStatuses statuses supplied 
        for(Moves.MoveAvailabilityStatuses element : availabilityStatusArray)
        {
            // if statement adds moves that exist if status is active ONLY
            // else statement adds moves that exist if status is INACTIVE 
            if(character.statusExists(element.getEnumAsString()))
            {
                addMovesByAvailability(movesOfDesiredSkill, arrayList, element);
            }
            else
            {
                String newEnumAsString = new StringBuilder("Not ").append(element.getEnumAsString()).toString();

                Moves.MoveAvailabilityStatuses newEnum = Moves.MoveAvailabilityStatuses.
                    valueOf(StaticMethods.stringToEnum(newEnumAsString));

                addMovesByAvailability(movesOfDesiredSkill, arrayList, newEnum);
            }
        }
    }
    
    // store weapon specific stamina moves in arrayList using weapon super type 
    public void storeWeaponSuperTypeStaminaMoves(ArrayList<Moves> arrayList, Moves.Skills weaponSkill)
    {
        switch(weaponSkill) 
        {
            case CLOSE_QUARTERS_COMBAT_STAMINA:
                addMovesToArrayList(character, arrayList, Moves.Skills.CLOSE_QUARTERS_COMBAT_STAMINA,
                    Moves.MoveAvailabilityStatuses.NONE, ...); // .. other stuff once made (change rest of stuff below after move formulas...)
                }); break;
            case SWORD_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.SWORD_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case KNIFE_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.KNIFE_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case OTHER_ONE_HANDED_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.OTHER_ONE_HANDED_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case GREAT_SWORD_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.GREAT_SWORD_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case SPEAR_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.SPEAR_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case OTHER_TWO_HANDED_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.OTHER_TWO_HANDED_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case BLADES_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.BLADES_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case OTHER_DUAL_WIELDED_STAMINA:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.OTHER_DUAL_WIELDED_STAMINA)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            default:
                break;
        }
    }
    
    // store weapon specific nano moves in arrayList using weapon super type 
    public void storeWeaponSuperTypeNanoMoves(ArrayList<Moves> arrayList, Moves.Skills weaponSkill)
    {
        switch(weaponSkill) 
        {
            case CLOSE_QUARTERS_COMBAT_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.CLOSE_QUARTERS_COMBAT_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case SWORD_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.SWORD_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case KNIFE_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.KNIFE_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case OTHER_ONE_HANDED_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.OTHER_ONE_HANDED_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case GREAT_SWORD_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.GREAT_SWORD_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case SPEAR_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.SPEAR_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case OTHER_TWO_HANDED_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.OTHER_TWO_HANDED_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case BLADES_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.BLADES_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            case OTHER_DUAL_WIELDED_NANO:
                moveset.stream().filter((move) -> (Moves.getSkillEnumUsingString(move.
                    getSkill()) == Moves.Skills.OTHER_DUAL_WIELDED_NANO)).forEachOrdered((move) -> { 
                    arrayList.add(move);
                }); break;
            default:
                break;
        }
    }
    
    // return enum which will be used to get moves tied to weapon category  
    public Moves.Styles weaponCategory(GenericCharacter character, Moves.
        Approaches staminaOrNano)
    {
        // used to determine what moves are tied to weapon category  
        String weaponCategory = new StringBuilder(character.getWeapon().getCategory()).
            append(" ").append(staminaOrNano.getEnumAsString()).toString(); 
        
        // used to get moves tied to weapon category 
        Moves.Styles weaponCategorySkills = Moves.Styles.valueOf(StaticMethods.
            stringToEnum(weaponCategory));
        
        return weaponCategorySkills;
    }
    
    // adds moves available to characters in battle to ArrayList based on 
    // weapon wielded, status effects, and enum supplied  
    public void addAvailableWeaponMoves(GenericCharacter character, 
        ArrayList<Moves> arrayList, Moves.Approaches staminaOrNano)
    {   
        // used to get moves tied to weapon category 
        Moves.Styles weaponCategorySkills = weaponCategory(character, staminaOrNano);

        // proceed if character can perform moves for weapon category 
        // Ex: if "Ommit One Handed Stamina Moves" then ommit moves with 
        //     category "One Handed Stamina"  
        if(!character.statusExists(ommitMoves(weaponCategorySkills.getEnumAsString())))
        {
            // store universal moves tied to weapon category in ArrayList 
            if(staminaOrNano == Moves.Approaches.STAMINA)
            {
                storeWeaponCategoryStaminaMoves(arrayList, weaponCategorySkills);
            }
            else if(staminaOrNano == Moves.Approaches.NANO)
            {
                storeWeaponCategoryNanoMoves(arrayList, weaponCategorySkills);
            }
            
            // used to get moves tied to weapon super type 
            Moves.Skills weaponSuperTypeSkills = weaponSuperType(character, staminaOrNano);
            
            // proceed if character can perform weapon moves for weapon super type 
            // Ex: if "Ommit Sword Stamina Moves" then ommit moves with super type 
            //     "Sword Stamina" 
            if(!character.statusExists(ommitMoves(weaponSuperTypeSkills.getEnumAsString())))
            {
                // store moves tied to weapon super type in ArrayList 
                if(staminaOrNano == Moves.Approaches.STAMINA)
                {
                    storeWeaponSuperTypeStaminaMoves(arrayList, weaponSuperTypeSkills);
                }
                else if(staminaOrNano == Moves.Approaches.NANO)
                {
                    storeWeaponSuperTypeNanoMoves(arrayList, weaponSuperTypeSkills);
                }
            }
        }
    }
    
    // END: STORING MOVES AVAILABLE TO CHARACTER BASED ON WEAPON WIELDED
    /********************************************************************************/

    
    
    // START: DISPLAY STAMINA/NANO MOVES AVAILABLE TO GENERICHARACTER
    /********************************************************************************/

    
    // account for skill ommission for BOTH stamina and nano moves in stringbuilder 
        // Moves.Approaches staminaOrNano
    
    // gets all stamina/nano moves available to a character based upon the
    // final argument supplied which specifies moves desired 
    public ArrayList<Moves> getAvailableMoves(GenericCharacter character, 
        Moves.Approaches staminaOrNano)
    {
        ArrayList<Moves> arrayList = new ArrayList<>();

        addAvailableUniversalMoves(character, arrayList, staminaOrNano);
        
        // accounts for whether character is wielding a weapon or not 
        if(character.getWeapon() == null)
        {
            
        }
        else
        {
            // add stamina/nano moves to ArrayList depending on staminaOrNano
            if(staminaOrNano == Moves.Approaches.STAMINA)
            {
                
            }
            else if(staminaOrNano == Moves.Approaches.NANO)
            {
                // add Moves available to the character based off weapon wielded to the ArrayList 
                addAvailableMoveStyleMoves(character, arrayList, staminaOrNanoMovesChoice);

            }
            
        }

        return arrayList;
    }

    // method displays Moves available to the genericCharacter object (NAMES ONLY AT THIS TIME)
    public void displayMoves(ArrayList<Moves> arrayList)
    {
            for(Moves move: arrayList)
            {
                    System.out.println(move.getMoveStyle());
            }
    }

    // method displays stamina/nano Moves available to the genericCharacter object 
    public void displayStaminaNanoMoves(genericCharacter character, String universalStaminaOrNano, 
            int staminaOrNanoMovesChoice)
    {
            displayMoves(returnAvailableStaminaNanoMoves(character, universalStaminaOrNano, 
                    staminaOrNanoMovesChoice));
    } 

    // END: DISPLAY STAMINA/NANO MOVES AVAILABLE TO GENERICHARACTER
    /********************************************************************************/

    
    
    // START: DISPLAY SPECIAL MOVES AVAILABLE TO GENERICHARACTER
    /********************************************************************************/

    // method attempts to add Moves belonging to special ArrayList to first ArrayList 
    public void addAvailableSpecialMoves(genericCharacter character, ArrayList<Moves> arrayList, 
            ArrayList<Moves> special, String specialMoveContainer)
    {
            // store move container name that has a chance of having all its Moves omitted by status effect 
            specialMoveContainer = new StringBuilder("omit").append(specialMoveContainer).append("Moves").toString();

            // if character does not have status effect, add Moves to the supplied ArrayList 
            if(!character.doesStatusExist(specialMoveContainer))
            {
                    addArrayContents(arrayList, special);
            }
    }

    // method displays all stamina Moves available to genericCharacter object 
    public ArrayList<Moves> returnAvailableSpecialMoves(genericCharacter character)
    {
            // temporary ArrayList meant to hold Moves 
            ArrayList<Moves> arrayList = new ArrayList<Moves>();

            // add special Moves to the temporary ArrayList before returning it 
            addAvailableSpecialMoves(character, arrayList, returnMoveContainerSpecial("GENERALPURPOSE"), "GeneralPurpose");	
            addAvailableSpecialMoves(character, arrayList, returnMoveContainerSpecial("OTHERMOVES"), "Other");

            return arrayList;
    }

    // method displays special Moves available to the genericCharacter object 
    public void displayAvailableSpecialMoves(genericCharacter character)
    {
            displayMoves(returnAvailableSpecialMoves(character));
    } 

    // END: DISPLAY SPECIAL MOVES AVAILABLE TO GENERICHARACTER
    /********************************************************************************/

	
	
	
    // START: DISPLAY AVAILABLE MOVES 
    /********************************************************************************/

    // display certain Moves depending on the choice of the player 
    public void displayMoves(genericCharacter character, int choice)
    {
            switch(choice)
            {
                    case 1:
                            displayStaminaNanoMoves(character, "Stamina", 1);
                                    break;
                    case 2:
                            displayStaminaNanoMoves(character, "Nano", 2);
                                    break;
                    case 3:
                            displayAvailableSpecialMoves(character);
                                    break;
                    case 4:
                            displayAvailableCombinations(character);
                                    break;
            }
    }

    // END: DISPLAY AVAILABLE MOVES 
    /********************************************************************************/






    // START: DISPLAY ALL MOVES 
    /********************************************************************************/

    // Enum class useful to returning all Moves tied to a particular move style 
    enum allMovesByMoveStyle
    {
            UNIVERSAL, HANDTOHAND, ONEHANDED, TWOHANDED, DUALWIELDED, TECHNIQUES;
    }

    // method returns all Moves tied to a particular move style 
    public ArrayList<Moves> returnAllMovesByMoveStyle(String argument)
    {
            // prepare String for Enum switch case so it can properly act as a condition 
            allMovesByMoveStyle allMoves = allMovesByMoveStyle.valueOf(prepareStringForEnum(argument));

            // ArrayList used for temporary storage of ArrayList move belongs to 
            ArrayList<Moves> arrayList = null;

            // switch case determines what ArrayLists have their contents added to arrayList
            switch(allMoves)
            {
                    case UNIVERSAL: 
                            addArrayContents(arrayList, allUniversalMoves);
                            addArrayContents(arrayList, allUniversalMovesNano);
                                    break; 
                    case HANDTOHAND: 
                            addArrayContents(arrayList, allHandToHandMoves);
                            addArrayContents(arrayList, allHandToHandMovesNano);
                                    break; 
                    case ONEHANDED: 
                            addArrayContents(arrayList, allOneHandedMoves);
                            addArrayContents(arrayList, allOneHandedMovesNano);
                                    break; 
                    case TWOHANDED: 
                            addArrayContents(arrayList, allTwoHandedMoves);
                            addArrayContents(arrayList, allTwoHandedMovesNano);
                                    break; 
                    case DUALWIELDED: 
                            addArrayContents(arrayList, allDualWieldedMoves);
                            addArrayContents(arrayList, allDualWieldedMovesNano);
                                    break; 
                    case TECHNIQUES: 
                            addArrayContents(arrayList, allTechniques);
                                    break; 
            }

            return arrayList;
    }

    // method displays all Moves tied to a particular move style 
    public void returnAllDesiredMoves(int choice)
    {
            // switch case determines what move style Moves are returned 
            switch(choice)
            {
                    case 1: 
                            returnAllMovesByMoveStyle("Universal");
                                    break; 
                    case 2: 
                            returnAllMovesByMoveStyle("Hand To Hand");
                                    break; 
                    case 3: 
                            returnAllMovesByMoveStyle("One Handed");
                                    break; 
                    case 4: 
                            returnAllMovesByMoveStyle("Two Handed");
                                    break; 
                    case 5: 
                            returnAllMovesByMoveStyle("Dual Wielded");
                                    break; 
                    case 6: 
                            returnAllMovesByMoveStyle("Techniques");
                                    break; 
            }
    }

	
	// END: DISPLAY ALL MOVES 
    /********************************************************************************/





    // need sorting ArrayList 
    // displaying all Moves by general location
    //
	
    
    
    
    
}
