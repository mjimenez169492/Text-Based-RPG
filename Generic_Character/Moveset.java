package Generic_Character;

import Commonly_Used_Methods.StaticMethods;
import Move_Creation.Moves;
import Generic_Object.Weapon;

import java.util.LinkedHashSet;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/*
    Moveset concerns storing moves or actions that a character can perform mid-
    battle. Moves held within a moveset can be sorted by personal preference by 
    selecting customize or in several predefined ways if the player desires. 
*/

public class Moveset 
{
    // holding objects from other classes 
    private Weapon weapon;
    private StatusEffectContainer statusEffectContainer;
    
    // stores moves objects such that they are sorted by insertion order 
    LinkedHashSet<Moves> moveset = new LinkedHashSet<>();
 
    public Moveset(Weapon weapon, StatusEffectContainer statusEffectContainer)
    {
        this.weapon = weapon;
        this.statusEffectContainer = statusEffectContainer;
    }
    
    
    
    // START: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/
    
    public Weapon getWeapon()
    {
        return weapon;
    }
    
    public StatusEffectContainer getStatusEffectContainer()
    {
        return statusEffectContainer;
    }
    
    // END: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/

    
    
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
    
    public LinkedHashSet<Moves> getMoveset()
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
        Sorting LinkedHashSet<Moves> moveset
    
            Customize:          player personally customizes object position 
            General Sort:	sort all moves at once in ascending order
              - Name
              - Approach
              - Style
              - Technique
              - Gauge Used
              - Enchantment
              - Target
              - Classification 
    */

    // START: CUSTOMIZE MOVE PLACEMENT BY SWAPPING TWO MOVES AT A TIME 
    /********************************************************************************/

    // places moves meant to be swapped in the supplied HashSet
    public void storeSelectedMoves(HashSet<Moves> movesToBeSwapped, int 
        moveSelected, int swapWithMoveAtPosition)
    {
        // start counting from first moveset move 
        int counter = 1;

        for(Moves move : moveset) 
        {
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
        // start counting from first moveset move 
        int counter = 1;
        
        for(Moves move : holdMoveList)
        {
            // if statement concerns swapping moves selected for swapping (moveSelected) 
            // with move at location swapWithMoveAtPosition  
            if(counter == moveSelected || counter == swapWithMoveAtPosition)
            {
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
                // insert entry set into moveset
                moveset.add(move);
            }

            counter++;
        }
    }
    
    // allows players to "customize" move positions in moveset by allowing them
    // to swap one move with another if possible (typing or w/mouse) 
    public void customize(int entrySelected, int swapWithEntryAtPosition)
    {
        // customize move positions only if there is moreset is not empty
        if(!moveset.isEmpty())
        {
            // proceed if entrySelected is within bounds of moveset
            if(entrySelected > 0 && entrySelected <= moveset.size())
            {
                // proceed if swapWithEntryAtPosition is within bounds of moveset
                if(swapWithEntryAtPosition > 0 && swapWithEntryAtPosition <= moveset.size())
                {
                    // proceed if user did not decide to swap entry set with itself 
                    if(entrySelected != swapWithEntryAtPosition)
                    {
                        // HashSet meant to temporarily store moves meant to be swapped 
                        HashSet<Moves> entriesToBeSwapped = new HashSet<>();

                        // store moves meant to be swapped in supplied HashSet 
                        storeSelectedMoves(entriesToBeSwapped, entrySelected, swapWithEntryAtPosition);
                        
                        // store moveset in holdMoveset before moveset is cleared 
                        LinkedHashSet<Moves> holdMoveset = new LinkedHashSet<>(moveset);

                        // moveset is cleared so entries can be placed properly 
                        moveset.clear();
                        
                        // customize moveset move positions using HashSets/LinkedHashSets supplied 
                        customizeLogic(entriesToBeSwapped, holdMoveset, entrySelected, swapWithEntryAtPosition);
                    }
                }
            }
        }
    }

    // END: CUSTOMIZE MOVE PLACEMENT BY SWAPPING TWO MOVES AT A TIME 
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
        StaticMethods.compareStrings(moveOne.getName(), moveTwo.getName()); 

    public Comparator<Moves> sortByApproach = (Moves moveOne, Moves moveTwo) -> 
        StaticMethods.compareStrings(moveOne.getApproachString(), moveTwo.
        getApproachString()); 

    public Comparator<Moves> sortByStyle = (Moves moveOne, Moves moveTwo) -> 
        StaticMethods.compareStrings(moveOne.getStyleString(), moveTwo.
        getStyleString()); 
    
    public Comparator<Moves> sortByTechnique = (Moves moveOne, Moves moveTwo) -> 
        StaticMethods.compareStrings(moveOne.getTechniqueString(), moveTwo.
        getTechniqueString()); 
    
    public Comparator<Moves> sortByGaugeUsed = (Moves moveOne, Moves moveTwo) -> 
        StaticMethods.compareStrings(moveOne.getGaugeUsedString(), moveTwo.
        getGaugeUsedString()); 
    
    public Comparator<Moves> sortByEnchantment = (Moves moveOne, Moves moveTwo) -> 
        StaticMethods.compareStrings(moveOne.getEnchantmentString(), moveTwo.
        getEnchantmentString()); 
    
    public Comparator<Moves> sortByTarget = (Moves moveOne, Moves moveTwo) -> 
        StaticMethods.compareStrings(moveOne.getTargetString(), moveTwo.
        getTargetString()); 
    
    public Comparator<Moves> sortByClassification = (Moves moveOne, Moves moveTwo) -> 
        StaticMethods.compareStrings(moveOne.getClassificationString(), moveTwo.
        getClassificationString()); 

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

    // all objects in moveset are sorted by a comparator that sorts moves 
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

    /* Note: methods sort all objects in moveset in ascending order according 
             to comparator supplied to generalSort() */
    
    public void generalSortByName()
    {
        generalSort(sortByName);
    }

    public void generalSortByApproach()
    {
        generalSort(sortByApproach);
    }
    
    public void generalSortByStyle()
    {
        generalSort(sortByStyle);
    }
    
    public void generalSortByTechnique()
    {
        generalSort(sortByTechnique);
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

    public void generalSortByClassification()
    {
        generalSort(sortByClassification);
    }

    // END: GENERAL SORT SORTS ALL MOVELIST MOVES IN A PREDEFINED WAY
    /********************************************************************************/
    
    
    
    // START: COMMONLY USED METHODS
    /********************************************************************************/

    public void addArrayContents(ArrayList<Moves> receiver, ArrayList<Moves> sender)
    {
        for(Moves move: sender)
        {
            receiver.add(move);
        }
    }
    
    // END: COMMONLY USED METHODS
    /********************************************************************************/

    
    
    // START: STORING UNIVERSAL STAMINA/NANO MOVES AVAILABLE TO CHARACTER
    /********************************************************************************/
    
    public void storeUniversalStaminaMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
            UNIVERSAL_STAMINA)).forEachOrdered((move) -> { arrayList.add(move);
        }); 
    }
    
    public void storeUniversalNanoMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
            UNIVERSAL_NANO)).forEachOrdered((move) -> { arrayList.add(move);
        }); 
    }
    
    // return String indicating status effect name which will ommit moves 
    public String omitMoves(String argument)
    {
        argument = new StringBuilder("Omit ").append(argument).append(" Moves").toString(); 
            return argument;
    }
    
    // store universal stamina/nano moves based on status and Moves.Approaches 
    // Note: StringBuilder is used for concatenation since it is generally 
    //       faster than "a" + "b" and method concat() 
    public void addAvailableUniversalMoves(ArrayList<Moves> arrayList, Moves.Approaches 
        staminaOrNano)
    {
        // store moves that have a chance of being omitted by status effects 
        String omitUniversal = new StringBuilder("Universal ").append(staminaOrNano.
            getEnumAsString()).toString();
        
        // Ex: if "Omit Universal Stamina Moves" (staminaOrNano is "Stamina" enum) 
        //     then omit moves where getTechniqueEnum() is "Universal Stamina" 
        if(!getStatusEffectContainer().statusExists(omitMoves(omitUniversal)))
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
    
    public void storeHandToHandStaminaMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (move.getStyleEnum() == Moves.Styles.
            HAND_TO_HAND_STAMINA)).forEachOrdered((move) -> { arrayList.add(move);
        }); 
    }
    
    public void storeHandToHandNanoMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (move.getStyleEnum() == Moves.Styles.
            HAND_TO_HAND_NANO)).forEachOrdered((move) -> { arrayList.add(move);
        }); 
    }
    
    public void storeCloseQuartersCombatStaminaMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
            CLOSE_QUARTERS_COMBAT_STAMINA)).forEachOrdered((move) -> { arrayList.add(move);
        }); 
    }
    
    public void storeCloseQuartersCombatNanoMoves(ArrayList<Moves> arrayList)
    {
        moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
            CLOSE_QUARTERS_COMBAT_NANO)).forEachOrdered((move) -> { arrayList.add(move);
        }); 
    }
    
    // return enum which will be used to get moves tied to desired hand to hand style 
    public Moves.Styles handToHandStyle(Moves.Approaches staminaOrNano)
    {
        // Ex: "Hand to Hand Stamina" gets "Hand to Hand Stamina" moves
        String handToHand = new StringBuilder("Hand To Hand").append(" ").
            append(staminaOrNano.getEnumAsString()).toString();
        
        // create enum object that will be used to get desired moves 
        Moves.Styles handToHandSkills = Moves.Styles.valueOf(StaticMethods.
            stringToEnum(handToHand));
        
        return handToHandSkills;
    }
    
    // return enum which will be used to get moves tied to weapon super type 
    public Moves.Techniques weaponSuperType(Moves.Approaches staminaOrNano)
    {
        // Ex: "Sword Stamina" gets "Sword Stamina" moves
        String weaponSuperType = new StringBuilder(getWeapon().getSuperType()).
            append(" ").append(staminaOrNano.getEnumAsString()).toString(); 

        // create enum object that will be used to get desired moves 
        Moves.Techniques weaponSuperTypeTechniques = Moves.Techniques.valueOf(StaticMethods.
            stringToEnum(weaponSuperType));
        
        return weaponSuperTypeTechniques;
    }
    
    // adds Hand To Hand moves available to unaremed characters in battle 
    // to ArrayList based on status effects, and enum specified 
    public void addHandToHandMoves(ArrayList<Moves> arrayList, Moves.Approaches 
        staminaOrNano)
    {
        // used to get desired "Hand To Hand" moves 
        Moves.Styles handToHandSkills = handToHandStyle(staminaOrNano);
        
        // proceed if character can perform Hand To Hand moves
        // Ex: if "Ommit Hand To Hand Stamina Moves" then ommit moves with 
        //     category "Hand To Hand Stamina"  
        if(!getStatusEffectContainer().statusExists(omitMoves(handToHandSkills.getEnumAsString())))
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
        if(getWeapon() != null)
        {
            // used to get moves tied to weapon super type 
            Moves.Techniques weaponSuperTypeSkills = weaponSuperType(staminaOrNano);

            // proceed if character can perform weapon moves for weapon super type 
            // Ex: if "Ommit Sword Stamina Moves" then ommit moves with super type 
            //     "Sword Stamina" 
            if(!getStatusEffectContainer().statusExists(omitMoves(weaponSuperTypeSkills.getEnumAsString())))
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


    
    // START: STORING AND RETRIEVING AVAILABLE MOVES BASED ON WEAPON WIELDED
    /********************************************************************************/
    
    // BY WEAPON SUPERTYPE
    
    // add reference to moves of desired technique to desiredMovesByTechnique for addition/retrieval 
    public void addDesiredMoves(ArrayList<Moves> desiredMovesByTechnique, Moves.Techniques technique)
    {
        moveset.stream().filter((element) -> (element.getTechniqueEnum() == technique)).
            forEachOrdered((element) -> {desiredMovesByTechnique.add(element);
        });
    }
    
    // add moves from ArrayList created in addMovesBasedOnStatus() to ArrayList 
    // passed to method addMovesByAvailability() based on availability status 
    public void addMovesByAvailability(ArrayList<Moves> desiredMovesByTechnique, ArrayList
        <Moves> arrayList, Moves.MoveAvailabilityStatuses availabilityStatus)
    {
        desiredMovesByTechnique.stream().filter((element) -> (element.getMoveAvailabilityStatusEnum() 
            == availabilityStatus)).forEachOrdered((element) -> {arrayList.add(element);
        });
    }
    
    public void addAlwaysAvailableMoves(ArrayList<Moves> desiredMovesByTechnique, Moves.Techniques 
        technique, ArrayList<Moves> arrayList, Moves.MoveAvailabilityStatuses availabilityStatus)
    {
        // add moves desired by user based on technique enum passed 
        addDesiredMoves(desiredMovesByTechnique, technique);
        
        // add moves of desired technique that will not be ommitted by special status effects
        // in other words, moves that do not need a status to use will be added to arrayList
        addMovesByAvailability(desiredMovesByTechnique, arrayList, availabilityStatus);
    }
    
    public boolean elementExists(Moves.MoveAvailabilityStatuses[] array, Moves.MoveAvailabilityStatuses
        argument)
    {
        boolean result = false;
        
        for(Moves.MoveAvailabilityStatuses element : array)
        {
            if(element == argument)
            {
                result = true;
            }
        }
        
        return result;
    }
    
    // Note: can add additional Moves.MoveAvailabilityStatuses enums if needed 
    // store weapon specific stamina moves in arrayList using weapon super type 
    public void storeWeaponSuperTypeStaminaMoves(ArrayList<Moves> arrayList, Moves.Techniques 
        weaponTechnique)
    {
        switch(weaponTechnique) 
        {
            case CLOSE_QUARTERS_COMBAT_STAMINA:
                addMovesToArrayList(arrayList, Moves.Techniques.CLOSE_QUARTERS_COMBAT_STAMINA,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case SWORD_STAMINA:
                addMovesToArrayList(arrayList, Moves.Techniques.SWORD_STAMINA,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case KNIFE_STAMINA:
                addMovesToArrayList(arrayList, Moves.Techniques.KNIFE_STAMINA,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case OTHER_ONE_HANDED_STAMINA:
                addMovesToArrayList(arrayList, Moves.Techniques.OTHER_ONE_HANDED_STAMINA,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case GREAT_SWORD_STAMINA:
                addMovesToArrayList(arrayList, Moves.Techniques.GREAT_SWORD_STAMINA,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case SPEAR_STAMINA:
                addMovesToArrayList(arrayList, Moves.Techniques.SPEAR_STAMINA,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case OTHER_TWO_HANDED_STAMINA:
                addMovesToArrayList(arrayList, Moves.Techniques.OTHER_TWO_HANDED_STAMINA,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case BLADES_STAMINA:
                addMovesToArrayList(arrayList, Moves.Techniques.BLADES_STAMINA,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case OTHER_DUAL_WIELDED_STAMINA:
                addMovesToArrayList(arrayList, Moves.Techniques.OTHER_DUAL_WIELDED_STAMINA,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            default:
                break;
        }
    }
    
    // Note: can add additional Moves.MoveAvailabilityStatuses enums if needed 
    // store weapon specific nano moves in arrayList using weapon super type 
    public void storeWeaponSuperTypeNanoMoves(ArrayList<Moves> arrayList, Moves.Techniques 
        weaponTechnique)
    {
        switch(weaponTechnique) 
        {
            case CLOSE_QUARTERS_COMBAT_NANO:
                addMovesToArrayList(arrayList, Moves.Techniques.CLOSE_QUARTERS_COMBAT_NANO,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case SWORD_NANO:
                addMovesToArrayList(arrayList, Moves.Techniques.SWORD_NANO,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case KNIFE_NANO:
                addMovesToArrayList(arrayList, Moves.Techniques.KNIFE_NANO,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case OTHER_ONE_HANDED_NANO:
                addMovesToArrayList(arrayList, Moves.Techniques.OTHER_ONE_HANDED_NANO,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case GREAT_SWORD_NANO:
                addMovesToArrayList(arrayList, Moves.Techniques.GREAT_SWORD_NANO,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case SPEAR_NANO:
                addMovesToArrayList(arrayList, Moves.Techniques.SPEAR_NANO,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case OTHER_TWO_HANDED_NANO:
                addMovesToArrayList(arrayList, Moves.Techniques.OTHER_TWO_HANDED_NANO,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case BLADES_NANO:
                addMovesToArrayList(arrayList, Moves.Techniques.BLADES_NANO,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            case OTHER_DUAL_WIELDED_NANO:
                addMovesToArrayList(arrayList, Moves.Techniques.OTHER_DUAL_WIELDED_NANO,
                    Moves.MoveAvailabilityStatuses.VOID); 
                        break;
            default:
                break;
        }
    }
    
    // add moves based on techniques desired and add/ommit moves based on statuses 
    // Note: parameter at end of method is a "var args" indicating that method
    //       accepts a variable number of arguments which will be stored in an
    //       array of type MoveAvailabilityStatuses
    public void addMovesToArrayList(ArrayList<Moves> arrayList, Moves.Techniques technique, 
        Moves.MoveAvailabilityStatuses...availabilityStatusArray)
    {
        // temp arrayList holds all moves that have techinique specified by technique 
        ArrayList<Moves> desiredMovesByTechnique = new ArrayList<>();
        
        // methods adds all moves of desired technique to desiredMovesByTechnique and 
        // adds moves that are always available to character (as specified by NONE on
        // the end of Moves.MoveAvailabilityStatuses.) despite move status(es) to the 
        // supplied arrayList  
        addAlwaysAvailableMoves(desiredMovesByTechnique, technique, arrayList, 
            Moves.MoveAvailabilityStatuses.NONE);
        
        // if condition for terminating method early is NOT met then proceed 
        if(!elementExists(availabilityStatusArray, Moves.MoveAvailabilityStatuses.VOID))
        {
            // for loop accounts for MoveAvailabilityStatuses statuses array supplied 
            for(Moves.MoveAvailabilityStatuses element : availabilityStatusArray)
            {
                if(!getStatusEffectContainer().statusExists(element.getEnumAsString()))
                {
                    // if statement adds moves that exist if status is active ONLY
                    addMovesByAvailability(desiredMovesByTechnique, arrayList, element);
                }
                else
                {
                    // else statement add moves that exist if status is INACTIVE by using String
                    String newEnumAsString = new StringBuilder("Not ").append(element.getEnumAsString()).toString();

                    // String newEnumAsString is used to create a MoveAvailabilityStatuses enum
                    // called newEnum will be used to determine what moves to retrieve 
                    // Ex: if "Not Sheathed" then moves active when user does not have "Sheathe"
                    //     status effect will be added to arrayList 
                    Moves.MoveAvailabilityStatuses newEnum = Moves.MoveAvailabilityStatuses.
                        valueOf(StaticMethods.stringToEnum(newEnumAsString));

                    addMovesByAvailability(desiredMovesByTechnique, arrayList, newEnum);
                }
            }
        }
    }
    
    // BY WEAPON SUPERTYPE 
    
    
    // BY WEAPON CATEGORY
    
    // store universal weapon stamina moves in arrayList using weapon category 
    public void storeWeaponCategoryStaminaMoves(ArrayList<Moves> arrayList, Moves.Styles weaponStyle)
    {
        switch (weaponStyle) 
        {
            case ONE_HANDED_STAMINA:
                moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
                    UNIVERSAL_ONE_HANDED_STAMINA)).forEachOrdered((move) -> { arrayList.add(move);
                }); break;
            case TWO_HANDED_STAMINA:
                moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
                    UNIVERSAL_TWO_HANDED_STAMINA)).forEachOrdered((move) -> { arrayList.add(move);
                }); break;
            case DUAL_WIELDED_STAMINA:
                moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
                    UNIVERSAL_DUAL_WIELDED_STAMINA)).forEachOrdered((move) -> { arrayList.add(move);
                }); break;
            default:
                break;
        }
    }
    
    // store universal weapon nano moves in arrayList using weapon category 
    public void storeWeaponCategoryNanoMoves(ArrayList<Moves> arrayList, Moves.Styles 
        weaponStyle)
    {
        switch (weaponStyle) 
        {
            case ONE_HANDED_NANO:
                moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
                    UNIVERSAL_ONE_HANDED_NANO)).forEachOrdered((move) -> { arrayList.add(move);
                }); break;
            case TWO_HANDED_NANO:
                moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
                    UNIVERSAL_TWO_HANDED_NANO)).forEachOrdered((move) -> { arrayList.add(move);
                }); break;
            case DUAL_WIELDED_NANO:
                moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
                    UNIVERSAL_DUAL_WIELDED_NANO)).forEachOrdered((move) -> { arrayList.add(move);
                }); break;
            default:
                break;
        }
    }
    
    // return enum which will be used to get moves tied to weapon category  
    public Moves.Styles weaponCategory(Moves.Approaches staminaOrNano)
    {
        // used to determine what moves are tied to weapon category  
        String weaponCategory = new StringBuilder(getWeapon().getCategory()).
            append(" ").append(staminaOrNano.getEnumAsString()).toString(); 
        
        // used to get moves tied to weapon category 
        Moves.Styles weaponCategorySkills = Moves.Styles.valueOf(StaticMethods.
            stringToEnum(weaponCategory));
        
        return weaponCategorySkills;
    }
    
    // adds moves available to characters in battle to ArrayList based on 
    // weapon wielded, status effects, and enum supplied  
    public void addAvailableWeaponMoves(ArrayList<Moves> arrayList, Moves.Approaches 
        staminaOrNano)
    {   
        // used to get moves tied to weapon category 
        Moves.Styles weaponCategoryStyle = weaponCategory(staminaOrNano);

        // proceed if character can perform moves for weapon category 
        // Ex: if "Ommit One Handed Stamina Moves" then ommit moves with 
        //     category "One Handed Stamina"  
        if(!getStatusEffectContainer().statusExists(omitMoves(weaponCategoryStyle.getEnumAsString())))
        {
            // store universal moves tied to weapon category in ArrayList 
            if(staminaOrNano == Moves.Approaches.STAMINA)
            {
                storeWeaponCategoryStaminaMoves(arrayList, weaponCategoryStyle);
            }
            else if(staminaOrNano == Moves.Approaches.NANO)
            {
                storeWeaponCategoryNanoMoves(arrayList, weaponCategoryStyle);
            }
            
            // used to get moves tied to weapon super type 
            Moves.Techniques weaponSuperTypeTechniques = weaponSuperType(staminaOrNano);
            
            // proceed if character can perform weapon moves for weapon super type 
            // Ex: if "Ommit Sword Stamina Moves" then ommit moves with super type 
            //     "Sword Stamina" 
            if(!getStatusEffectContainer().statusExists(omitMoves(weaponSuperTypeTechniques.getEnumAsString())))
            {
                // store moves tied to weapon super type in ArrayList 
                if(staminaOrNano == Moves.Approaches.STAMINA)
                {
                    storeWeaponSuperTypeStaminaMoves(arrayList, weaponSuperTypeTechniques);
                }
                else if(staminaOrNano == Moves.Approaches.NANO)
                {
                    storeWeaponSuperTypeNanoMoves(arrayList, weaponSuperTypeTechniques);
                }
            }
        }
    }
    
    // BY WEAPON CATEGORY
    
    // stores and returns stamina/nano moves available to use from moveset
    public ArrayList<Moves> getAvailableStaminaNanoMoves(ArrayList<Moves> arrayList, 
        Moves.Approaches staminaOrNano)
    {
        addAvailableUniversalMoves(arrayList, staminaOrNano);
        
        // accounts for whether character is wielding a weapon or not 
        if(getWeapon() == null)
        {
            addHandToHandMoves(arrayList, staminaOrNano);
        }
        else
        {
            // add available moves to arrayList based off weapon wielded 
            addAvailableWeaponMoves(arrayList, staminaOrNano);
        }

        return arrayList;
    }
    
    // END: STORING AND RETRIEVING AVAILABLE MOVES BASED ON WEAPON WIELDED
    /********************************************************************************/

    
    
    // START: STORING AND RETRIEVING ALL SPECIAL MOVES 
    /********************************************************************************/
    
    // method attempts to add Moves belonging to special ArrayList to ArrayList 
    public ArrayList<Moves> getAvailableSpecialMoves(ArrayList<Moves> arrayList)
    {
        // if status effect does not exists, then add moves to the supplied ArrayList 
        if(!getStatusEffectContainer().statusExists(omitMoves("General Purpose")))
        {
            moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
                GENERAL_PURPOSE)).forEachOrdered((move) -> { arrayList.add(move);
            }); 
        }
        
        if(!getStatusEffectContainer().statusExists(omitMoves("Other")))
        {
            moveset.stream().filter((move) -> (move.getTechniqueEnum() == Moves.Techniques.
                OTHER_MOVES)).forEachOrdered((move) -> { arrayList.add(move);
            }); 
        }
        
        return arrayList;
    }
    
    // END: STORING AND RETRIEVING ALL SPECIAL MOVES 
    /********************************************************************************/

    
    
    
    
    
    
    
    
    
    
    
    // START: DETERMINING WHAT MOVES TO DISPLAY
    /********************************************************************************/
    
    /*
    public enum MovesByApproach
    {
        STAMINA("Stamina"), NANO("Nano"), SPECIAL("Special");
        
        private String moveByApproach;
        
        MovesByApproach(String moveByApproach)
        {
            this.moveByApproach = moveByApproach;
        }
        
        public String getEnumAsString()
        {
            return moveByApproach;
        }
    }
    
    public void displayMoveOptions()
    {
        
    }
    
    public void displayAvailableMoves()
    {
        ArrayList<Moves> availableMoves = new ArrayList<>();
        ArrayList<Moves> movesWithoutOmission = new ArrayList<>();
        
        switch()
        {
            case STAMINA:
            case NANO:
            case SPECIAL: 
            
            
        }
        
    }
    
     idea
        for displaying moves, need to display ALL moves
        in battle, need to display moves such that all UNAVAILABLE moves are
        "whited out" while those that are not are not
            get available moves and COMPARE them to unavailable moves 
                this is done at "Technique" level...
                    could get an element from returned arraylist and use the 
                    getTechniqueEnum() to get moves from moveset... 
    
        
    
    
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

    // method displays special Moves available to the genericCharacter object 
    public void displayAvailableSpecialMoves(genericCharacter character)
    {
            displayMoves(returnAvailableSpecialMoves(character));
    } 
    
    */
    
                // START: DISPLAY STAMINA/NANO MOVES AVAILABLE TO GENERICHARACTER
    /********************************************************************************/

    
    
                // END: DISPLAY STAMINA/NANO MOVES AVAILABLE TO GENERICHARACTER
    /********************************************************************************/

    

	
    // START: DISPLAY AVAILABLE MOVES 
    /********************************************************************************/
/*
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
*/
    
    // END: DISPLAY AVAILABLE MOVES 
    /********************************************************************************/

    
    
    // START: DISPLAY ALL MOVES 
    /********************************************************************************/

    
	
    // END: DISPLAY ALL MOVES 
    /********************************************************************************/


    
}
