package Player_Entity;

/* 
    Inventory contains information relating to storing and manipulating objects 
    that can be found in the game world. It is possible for every member of the
    player party to access the contents of the inventory if the player commands
    the character to do so. The inventory is cannot store objects that are made
    from classes outside of the GenericObject class hierarchy.
*/

import Generic_Object.*;        // asterisk (*) imports all classes in package Generic_Object
import Commonly_Used_Methods.StaticMethods;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

public class Inventory
{
    // max amount of objects that can be "stacked" for object group in inventory 
    // Ex: maxWeaponGroupSize = 5 so weapon group "Sword" can only have 5 swords 
    public int itemGroupMaxSize, coreGroupMaxSize, weaponGroupMaxSize, armorGroupMaxSize, 
        accessoryGroupMaxSize;
    
    // limits number of different object groups that can exist at any one time 
    private int objectGroupsLimit; 
    
    // stores objects such that they are sorted by insertion order 
    LinkedHashMap<GenericObject, ArrayList<GenericObject>> inventory = new LinkedHashMap<>();

    /* above is the same as: 
        LinkedHashMap<GenericObject, ArrayList<GenericObject>> inventory = new 
            LinkedHashMap<GenericObject, ArrayList<GenericObject>>();         */

    public Inventory()
    {
        // empty constructor 
    }
    
    
    
    // START: LIMITING ASPECTS OF OBJECT GROUPS INVENTORY
    /*******************************************************************************/
    
    // START: LIMITING OBJECT GROUP SIZE 
    
    public int validateGroupSizeLimit(int groupSizeLimit)
    {
        if(groupSizeLimit < 0)
        {
            groupSizeLimit = 0;
        }
        else if(groupSizeLimit > 30)
        {
            groupSizeLimit = 30;
        }

        return groupSizeLimit;
    }

    public void setItemGroupMaxSize(int itemGroupMaxSize)
    {
        this.itemGroupMaxSize = validateGroupSizeLimit(itemGroupMaxSize);
    }
    
    public int getItemGroupMaxSize()
    {
        return itemGroupMaxSize;
    }
    
    public void setCoreGroupMaxSize(int coreGroupMaxSize)
    {
        this.coreGroupMaxSize = validateGroupSizeLimit(coreGroupMaxSize);
    }
    
    public int getCoreGroupMaxSize()
    {
        return coreGroupMaxSize;
    }
    
    public void setWeaponGroupMaxSize(int weaponGroupMaxSize)
    {
        this.weaponGroupMaxSize = validateGroupSizeLimit(weaponGroupMaxSize);
    }
    
    public int getWeaponGroupMaxSize()
    {
        return weaponGroupMaxSize;
    }
    
    public void setArmorGroupMaxSize(int armorGroupMaxSize)
    {
        this.armorGroupMaxSize = validateGroupSizeLimit(armorGroupMaxSize);
    }
    
    public int getArmorGroupMaxSize()
    {
        return armorGroupMaxSize;
    }
    
    public void setAccessoryGroupMaxSize(int accessoryGroupMaxSize)
    {
        this.accessoryGroupMaxSize = validateGroupSizeLimit(accessoryGroupMaxSize);
    }
    
    public int getAccessoryGroupMaxSize()
    {
        return accessoryGroupMaxSize;
    }
    
    // END: LIMITING OBJECT GROUP SIZE 

    
    // START: LIMITING NUMBER OF OBJECT GROUPS 

    // set number of object groups allowed in inventory at any one time 
    public void setObjectGroupsLimit(int objectGroupsLimit)
    {
        if(objectGroupsLimit < 0)
        {
            objectGroupsLimit = 0;
        }
        else if(objectGroupsLimit > 50)
        {
            objectGroupsLimit = 50;
        }

        this.objectGroupsLimit = objectGroupsLimit;
    }

    // get number of object groups allowed in inventory at any one time 
    public int getObjectGroupsLimit()
    {
        return objectGroupsLimit;
    }

    // END: LIMITING ASPECTS OF OBJECT GROUPS INVENTORY
    /*******************************************************************************/

    
    
    // START: LIMIT OBJECT GROUP SIZE BY OBJECT 
    /*******************************************************************************/
    
    // returns limit for number of objects allowed in object group using object class 
    // Valid classes: GenericObject, Items, Cores, Weapons, Armors, Accessories
    public int limitObjectGroupSize(GenericObject object)
    {        
        int groupSizeLimit = 0;
        
        if(object.getClass() == Item.class)
        {
            groupSizeLimit = itemGroupMaxSize;
        }
        else if(object.getClass() == Core.class)
        {
            groupSizeLimit = coreGroupMaxSize;
        }
        else if(object.getClass() == Weapon.class)
        {
            groupSizeLimit = weaponGroupMaxSize;
        }
        else if(object.getClass() == Armor.class)
        {
            groupSizeLimit = armorGroupMaxSize;
        }
        else if(object.getClass() == Accessory.class)
        {
            groupSizeLimit = accessoryGroupMaxSize;
        }        
        
        return groupSizeLimit;
    }
    
    // END: LIMIT OBJECT GROUP SIZE BY OBJECT 
    /*******************************************************************************/

    
    
    // START: DETERMINE IF OBJECT CAN BE ADDED TO INVENTORY BEFORE ADDING IT 
    /*******************************************************************************/
    
    // returns true only if object group exists within inventory
    public boolean doesObjectGroupExist(GenericObject object)
    {
        boolean result = false;
        
        ArrayList<GenericObject> objectGroup = inventory.get(object);
        
        if(objectGroup != null)
        {
            result = true;
        }
                
        return result;
    }
    
    // return true if object group can store another object 
    public boolean canObjectGroupStoreObject(GenericObject object)
    {
        boolean canStoreObject = false;
                
        ArrayList<GenericObject> objectGroup = inventory.get(object);
        
        if(objectGroup.size() != limitObjectGroupSize(object))
        {
            canStoreObject = true;
        }
        
        return canStoreObject;
    }
    
    // return true if inventory has not reached max group size 
    public boolean canInventoryStoreNewObjectGroup(GenericObject object)
    {
        boolean canCreateNewObjectGroup = false;
        
        if(inventory.size() != objectGroupsLimit)
        {
            canCreateNewObjectGroup = true;
        }
        
        return canCreateNewObjectGroup;
    }
    
    // returns true only if object can be properly placed within inventory 
    public boolean canAddObject(GenericObject object)
    {
        boolean result = false;
        
        if(object != null)
        {
            if(doesObjectGroupExist(object))
            {
                result = canObjectGroupStoreObject(object);
            }
            else
            {
                result = canInventoryStoreNewObjectGroup(object);
            }   
        }
        
        return result; 
    }
    
    // END: DETERMINE IF OBJECT CAN BE ADDED TO INVENTORY BEFORE ADDING IT 
    /*******************************************************************************/

    
    
    // START: ADDING/REMOVING OBJECTS AND RETRIEVING INVENTORY 
    /*******************************************************************************/

    // adds object to inventory based on certain conditions 
    public void addObject(GenericObject object)
    {
        // get GenericObject group (value) for object (key) and assign result to
        // objectGroup which will hold the existing ArrayList or null if the get
        // method does not return an existing ArrayList for the object  
        ArrayList<GenericObject> objectGroup = inventory.get(object);
        
        // if object group exists then attempt to add object to object group 
        if(objectGroup != null)
        {
            // if objectGroup size has not reached size limit allowed for object 
            // group then add object to group 
            if(objectGroup.size() != limitObjectGroupSize(object))
            {
                objectGroup.add(object);
            }
        }
        else
        {
            // else add new object group for object ONLY if inventory has space 
            if(inventory.size() != objectGroupsLimit)
            {
                // initialize objectGroup (which is null) as GenericObject ArrayList
                objectGroup = new ArrayList<>();
                
                // add object to newly created object group 
                objectGroup.add(object);

                // put object as key for inventory and object group as its value 
                inventory.put(object, objectGroup);
            }
        }
    }
    
    // removes object from object group in inventory if it exists 
    public void removeObject(GenericObject object)
    {
        ArrayList<GenericObject> objectGroup = inventory.get(object);

        // end method execution early if object object group does not exist 
        if(objectGroup == null) return;

        // remove object from object group causing object group size to decrement by one 
        objectGroup.remove(object);

        // if object group is empty, remove object group from inventory 
        if(objectGroup.isEmpty())
        {
            inventory.remove(object);
        }
    }
    
    // removes object group from inventory 
    public void removeObjectGroup(GenericObject object)
    {
        inventory.remove(object);
    }
    
    // gets inventory object containing all objects stored by the player party 
    public LinkedHashMap<GenericObject, ArrayList<GenericObject>> getInventory()
    {
        return inventory;
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
            Specific Sort:      sort certain objects in ascending order (place at top)
              - Objects
              - Items
              - Cores
              - Weapons
              - Armors
              - Accessories
                    - Name
                    - Class						 
                    - Category
                    - Super Type
                    - Sub Type
                    - Use Speed					
                    - Buy Price
                    - Sell Price
                    - Steal Rate
                    - Pilfer Rate
                    - Drop Rate 
                    - Highest Quantity
                    - Lowest Quantity
            General Sort:	sort all inventory objects at once in ascending order
              - Name
              - Class						
              - Category
              - Super Type
              - Sub Type
              - Use Speed					
              - Buy Price
              - Sell Price
              - Steal Rate
              - Pilfer Rate
              - Drop Rate 
              - Highest Quantity
              - Lowest Quantity
    */

    // START: CUSTOMIZE OBJECT PLACEMENT BY SWAPPING TWO ENTRY SETS AT A TIME 
    /********************************************************************************/

    // places entry sets meant to be swapped in the supplied TreeMap
    public void storeSelectedEntries(TreeMap<GenericObject, ArrayList<GenericObject>> 
        entriesToBeSwapped, int entrySelected, int swapWithEntryAtPosition)
    {
        // start counting from first inventory entry if inventory is not empty 
        int counter = 1;

        // enchanced for loop loops through contents of inventory
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.entrySet()) 
        {
            // if statement stores entry sets meant to be swapped  
            if(counter == entrySelected || counter == swapWithEntryAtPosition)
            {
                entriesToBeSwapped.put(entry.getKey(), entry.getValue());
            }
            
            counter++;
        }
    }
    
    // contains code relating to how inventory entry sets are awapped 
    public void customizeLogic(TreeMap<GenericObject, ArrayList<GenericObject>> 
        entriesToBeSwapped, LinkedHashMap<GenericObject, ArrayList<GenericObject>> 
        holdInventory, int entrySelected, int swapWithEntryAtPosition)
    {
        // start counting from first inventory entry if inventory is not empty 
        int counter = 1;
        
        // enchanced for loop loops through contents of inventory 
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : holdInventory.entrySet())
        {
            // if statement concerns swapping entry selected for swapping (entrySelected) 
            // with entry at location swap location (swapWithEntryAtPosition) 
            if(counter == entrySelected || counter == swapWithEntryAtPosition)
            {
                // enhanced for loop loops through entriesMeantToBeSwapped to get desired entry 
                for(Map.Entry<GenericObject, ArrayList<GenericObject>> swap : entriesToBeSwapped.entrySet())
                {
                    // if keys do not match then place entry set in inventory  
                    if(!entry.getKey().equals(swap.getKey()))
                    {
                        inventory.put(swap.getKey(), swap.getValue());
                    }
                }
            }
            else
            {
                // insert entry set into inventory
                inventory.put(entry.getKey(), entry.getValue());
            }

            // increment counter by one 
            counter++;
        }
    }
    
    // allows players to "customize" object positions in inventory by allowing 
    // them to swap one entry set with another if possible (typing or w/mouse) 
    public void customize(int entrySelected, int swapWithEntryAtPosition)
    {
        // customize entry set positions only if there is more than one entry set
        if(inventory.size() >  1)
        {
            // proceed if entrySelected is within bounds of inventory
            if(entrySelected >= 1 && entrySelected <= inventory.size())
            {
                // proceed if swapWithEntryAtPosition is within bounds of inventory
                if(swapWithEntryAtPosition >= 1 && swapWithEntryAtPosition <= inventory.size())
                {
                    // proceed if user did not decide to swap entry set with itself 
                    if(entrySelected != swapWithEntryAtPosition)
                    {
                        // TreeMap meant to temporarily store entries meant to be swapped 
                        // NOTE: needs a dummy comparator or way to sort GenericObject objects in order
                        //       to sort objects without creating additional methods 
                        TreeMap<GenericObject, ArrayList<GenericObject>> entriesToBeSwapped = new TreeMap<>(sortByName);

                        // store entries meant to be swapped in supplied TreeMap 
                        storeSelectedEntries(entriesToBeSwapped, entrySelected, swapWithEntryAtPosition);
                        
                        // store inventory collection in holdInventory before inventory is cleared 
                        LinkedHashMap<GenericObject, ArrayList<GenericObject>> holdInventory = new LinkedHashMap<>(inventory);

                        // inventory is cleared so entries can be placed properly 
                        // if inventory is not cleared, entries selected will not 
                        // be swapped since key will be placed at key location 
                        // map keys: 6, 3, 2, 1 -> swap 3 with 1 -> 3 goes to key 3
                        inventory.clear();
                        
                        // customize inventory entries using maps supplied 
                        customizeLogic(entriesToBeSwapped, holdInventory, entrySelected, swapWithEntryAtPosition);
                    }
                }
            }
        }
    }

    // count position of object group in inventory from position 1
    public int objectGroupPosition(GenericObject object)
    {
        int counter = 1;
        
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.entrySet())
        {
            if(object.equals(entry.getKey()))
            {
                break;
            }
            else
            {
                counter++;
            }
        }
        
        return counter;
    }
    
    // END: CUSTOMIZE OBJECT PLACEMENT BY SWAPPING TWO ENTRY SETS AT A TIME 
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

    
    
    // START: COMPARATORS USING GENERICOBJECT MEDTHODS TO SORT DATA STRUCTURES 
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
    
    // START: STRING KEY COMPARATORS FOR SORTING 
    
    public Comparator<GenericObject> sortByName = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareStrings(objectOne.getName(), objectTwo.getName()); 

    public Comparator<GenericObject> sortByMainClass = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareStrings(objectOne.getMainClassString(), objectTwo.getMainClassString()); 

    public Comparator<GenericObject> sortByCategory = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareStrings(objectOne.getCategory(), objectTwo.getCategory()); 

    public Comparator<GenericObject> sortBySuperType = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareStrings(objectOne.getSuperType(), objectTwo.getSuperType()); 

    public Comparator<GenericObject> sortBySubType = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareStrings(objectOne.getSubType(), objectTwo.getSubType()); 

    // END: STRING KEY COMPARATORS FOR SORTING 

    // START: DOUBLE KEY COMPARATORS FOR SORTING 

    public Comparator<GenericObject> sortByUseSpeed = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareDoubles(objectOne.getUseSpeed(), objectTwo.getUseSpeed()); 

    public Comparator<GenericObject> sortByBuyPrice = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareDoubles(objectOne.getBuyPrice(), objectTwo.getBuyPrice()); 

    public Comparator<GenericObject> sortBySellPrice = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareDoubles(objectOne.getSellPrice(), objectTwo.getSellPrice()); 
    
    public Comparator<GenericObject> sortByStealRate = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareDoubles(objectOne.getStealRate(), objectTwo.getStealRate()); 
    
    public Comparator<GenericObject> sortByPilferRate = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareDoubles(objectOne.getPilferRate(), objectTwo.getPilferRate()); 

    public Comparator<GenericObject> sortByDropRate = (GenericObject objectOne, GenericObject 
        objectTwo) -> compareDoubles(objectOne.getDropRate(), objectTwo.getDropRate()); 

    // END: DOUBLE KEY COMPARATORS FOR SORTING 
    
    // END: KEY COMPARATORS SORT BY ASCENDING ORDER


    // START: VALUE COMPARATORS SORT BY DESCENDING ORDER (FOR KEY-VALUE SWAP OPERATIONS ONLY)

    public Comparator<ArrayList<GenericObject>> sortByHighestQuanity = (ArrayList<GenericObject> 
        arrayListOne, ArrayList<GenericObject> arrayListTwo) -> compareIntegers(arrayListOne.size(), 
        arrayListTwo.size()); 
    
    // multiply value of comparison by negative 1 (-1) to inverse order given by 
    // comparator sortByHighestQuanity to sort by lowest quantity instead 
    public Comparator<ArrayList<GenericObject>> sortByLowestQuanity = (ArrayList<GenericObject> 
        arrayListOne, ArrayList<GenericObject> arrayListTwo) -> -1 * compareIntegers(arrayListOne.
        size(), arrayListTwo.size()); 

    // END: VALUE COMPARATORS SORT BY DESCENDING ORDER (FOR KEY-VALUE SWAP OPERATIONS ONLY)
    
    // END: COMPARATORS USING GENERICOBJECT MEDTHODS TO SORT DATA STRUCTURES 
    /********************************************************************************/


    
    // START: METHODS USED THROUGHOUT SPECIFIC SORT
    /********************************************************************************/
    
    // START: SPECIFIC SORT BY KEY
    
    // enum class containing classes whose objects can be stored in inventory 
    public enum ClassesForSorting
    {
        ITEM("Item"), CORE("Core"), WEAPON("Weapon"), ARMOR("Armor"), 
        ACCESSORY("Accessory");
        
        private String classForSorting;
        
        ClassesForSorting(String classForSorting)
        {
            this.classForSorting = classForSorting;
        }
        
        public String getEnumAsString()
        {
            return classForSorting;
        }
    }
    
    public ClassesForSorting getClassForSortingEnum(String argument)
    {
        return ClassesForSorting.valueOf(StaticMethods.stringToEnum(argument));
    }
    
    // class belonging to GenericObject hierarchy MUST be supplied in order to 
    // determine whether inventory object belongs to a class meant for sorting
    public void specificSortLogic(TreeMap<GenericObject, ArrayList<GenericObject>> sortObjectsBy, 
        LinkedHashMap<GenericObject, ArrayList<GenericObject>> unsortedObjects, Class<? extends 
        GenericObject> hierarchy)
    {
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.entrySet())
        {
            if(entry.getKey().getClass() == hierarchy){
                sortObjectsBy.put(entry.getKey(), entry.getValue());
            }else{
                unsortedObjects.put(entry.getKey(), entry.getValue());
            }
        }
    }
    
    // sorts objects belonging to specified class while leaving other objects alone
    public void specificSortByClass(TreeMap<GenericObject, ArrayList<GenericObject>> sortObjectsBy, 
        LinkedHashMap<GenericObject, ArrayList<GenericObject>> unsortedObjects, ClassesForSorting choice)
    {
        // switch statement determines what class objects are stored/sorted 
        switch(choice)
        {
            case ITEM: 
                specificSortLogic(sortObjectsBy, unsortedObjects, Item.class);
                    break;
            case CORE: 
                specificSortLogic(sortObjectsBy, unsortedObjects, Core.class);
                    break;
            case WEAPON: 
                specificSortLogic(sortObjectsBy, unsortedObjects, Weapon.class);
                    break;
            case ARMOR: 
                specificSortLogic(sortObjectsBy, unsortedObjects, Armor.class);
                    break;
            case ACCESSORY: 
                specificSortLogic(sortObjectsBy, unsortedObjects, Accessory.class);
                    break;
        }
    }

    // fills inventory with sorted TreeMap unsorted linked hashmap entry sets 
    public void fillInventoryAfterSpecificSort(TreeMap<GenericObject, ArrayList<GenericObject>> 
        sortObjectsBy, LinkedHashMap<GenericObject, ArrayList<GenericObject>> unsortedObjects)
    {
        // enhanced for loop places sorted entry sets from TreeMap into inventory first 
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : sortObjectsBy.entrySet())
        {
            inventory.put(entry.getKey(), entry.getValue());
        }
        
        // enhanced for loop places unsorted entry sets of linkedHashMap into inventory  
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : unsortedObjects.entrySet())
        {
            inventory.put(entry.getKey(), entry.getValue());		
        }
    }
    
    // sort class objects specified and place them at the top of the inventory 
    public void specificSortByKey(Comparator<GenericObject> comparator, ClassesForSorting choice)
    {
        // sortObjectsBy will hold objects from specified class ONLY and sort them 
        // according to custom comparator given as argument implemented at the end 
        TreeMap<GenericObject, ArrayList<GenericObject>> sortObjectsBy = new TreeMap<>(comparator);

        // unsortedObjects stores entry sets of inventory not stored in sortObjectsBy
        LinkedHashMap<GenericObject, ArrayList<GenericObject>> unsortedObjects = new LinkedHashMap<>();			

        // place sorted objects in sortObjectsBy and unsorted objects in unsortedObjects 
        specificSortByClass(sortObjectsBy, unsortedObjects, choice);

        // inventory is cleared so entries can be placed properly 
        inventory.clear();
        
        // fill linkedHashMapInventory with objects after specific sort is done 
        fillInventoryAfterSpecificSort(sortObjectsBy, unsortedObjects);
    }

    // END: SPECIFIC SORT BY KEY
    
    
    // START: SPECIFIC SORT BY VALUE
    
    // store TreeMap (without comparator) objects in TreeMap (with comparator) 
    // such that keys are placed as value and values are placed as keys 
    public void specifiedKeyValueSwap(TreeMap<GenericObject, ArrayList<GenericObject>> 
        storeSpecifiedObjects, TreeMap<ArrayList<GenericObject>, GenericObject> sortObjectsBy)
    {
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : storeSpecifiedObjects.entrySet())
        {
            sortObjectsBy.put(entry.getValue(), entry.getKey());
        }
    }

    // fills inventory with sorted TreeMap unsorted linked hashmap entry sets after key/value swap
    public void fillInventoryAfterKeyValueSwap(TreeMap<ArrayList<GenericObject>, GenericObject> 
        sortedTreeMapEntries, LinkedHashMap<GenericObject, ArrayList<GenericObject>> unsortedLinkedHashMap)
    {
        // add entries sorted by value first by swapping keys/values
        for(Map.Entry<ArrayList<GenericObject>, GenericObject> entry : sortedTreeMapEntries.entrySet())
        {
            inventory.put(entry.getValue(), entry.getKey());
        }
        
        // add unsorted entries to linkedHashMapInventory 
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : unsortedLinkedHashMap.entrySet())
        {
            inventory.put(entry.getKey(), entry.getValue());		
        }
    }

    // sort specified class objects by desired quantity by swapping keys and values 
    public void specificSortByValue(Comparator<ArrayList<GenericObject>> comparator, ClassesForSorting choice)
    {
        /* steps: 
            1. store objects that need to be sorted and objects to be left unsorted 
            2. swap keys/values by using another TreeMap with quantity comparator 
            3. place contents of TreeMap with comparator in linkedHashMapInventory
               first and then place remaining entries from linked HashMap next  */
        
        // temporarily store objects belonging to specified class with no comparator
        // NOTE: needs a dummy comparator or way to sort GenericObject objects in order
        //       to sort objects without creating additional methods
        TreeMap<GenericObject, ArrayList<GenericObject>> storeSpecifiedObjects = new TreeMap<>(sortByName);

        // unsortedObjects stores entry sets of inventory not stored in sortObjectsBy
        LinkedHashMap<GenericObject, ArrayList<GenericObject>> unsortedObjects = new LinkedHashMap<>();
        
        // place sorted objects in storeSpecifiedObjects and unsorted objects in unsortedObjects 
        specificSortByClass(storeSpecifiedObjects, unsortedObjects, choice);
        
        // sortObjectsBy will hold objects from specified class ONLY and sort them 
        // according to custom comparator given as argument implemented at the end 
        TreeMap<ArrayList<GenericObject>, GenericObject> sortObjectsBy = new TreeMap<>(comparator);
        
        // swap keys/values of first TreeMap before placing them in second TreeMap 
        specifiedKeyValueSwap(storeSpecifiedObjects, sortObjectsBy);
        
        // inventory is cleared so entries can be placed properly 
        inventory.clear();
        
        // store contents of sorted TreeMap after swapping their keys/values and 
        // then store unsorted objects in linkedHashMapInventory 
        fillInventoryAfterKeyValueSwap(sortObjectsBy, unsortedObjects);
    }

    // END: SPECIFIC SORT BY VALUE
    
    // END: METHODS USED THROUGHOUT SPECIFIC SORT
    /********************************************************************************/

    
    
    // START: SPECIFIC SORT SORTS CERTAIN CLASS OBJECTS IN A PREDFINED WAY 
    /********************************************************************************/

    /* Note: methods sort objects from class specified by using the comparator 
             supplied to method specificSortByKey(). Sorted objects are placed
             at the top of linkedHashMapInventory. */
    
    // START: METHODS FOR SPECIFIED SORT OF KEYS
    
    public void specificSortByName(ClassesForSorting choice)
    {
        specificSortByKey(sortByName, choice);
    }

    public void specificSortByMainClass(ClassesForSorting choice)
    {
        specificSortByKey(sortByMainClass, choice);
    }

    public void specificSortByCategory(ClassesForSorting choice)
    {
        specificSortByKey(sortByCategory, choice);
    }

    public void specificSortBySuperType(ClassesForSorting choice)
    {
        specificSortByKey(sortBySuperType, choice);
    }

    public void specificSortBySubType(ClassesForSorting choice)
    {
        specificSortByKey(sortBySubType, choice);
    }

    public void specificSortByUseSpeed(ClassesForSorting choice)
    {
        specificSortByKey(sortByUseSpeed, choice);
    }

    public void specificSortByBuyPrice(ClassesForSorting choice)
    {
        specificSortByKey(sortByBuyPrice, choice);
    }

    public void specificSortBySellPrice(ClassesForSorting choice)
    {
        specificSortByKey(sortBySellPrice, choice);
    }

    public void specificSortByStealRate(ClassesForSorting choice)
    {
        specificSortByKey(sortByStealRate, choice);
    }
    
    public void specificSortByPilferRate(ClassesForSorting choice)
    {
        specificSortByKey(sortByDropRate, choice);
    }
    
    public void specificSortByDropRate(ClassesForSorting choice)
    {
        specificSortByKey(sortByDropRate, choice);
    }

    // END: METHODS FOR SPECIFIED SORT OF KEYS
    
    
    // START: METHODS FOR SPECIFIC SORT BY VALUES (KEY AND VALUE SWAPPING)
    
    public void specificSortByHighestQuantity(ClassesForSorting choice)
    {
        specificSortByValue(sortByHighestQuanity, choice);
    }
    
    // sorts objects from specfied class by lowest quantity and places them at 
    // the top of linkedHashMapInventory 
    public void specificSortByLowestQuantity(ClassesForSorting choice)
    {
        specificSortByValue(sortByLowestQuanity, choice);
    }
    
    // END: METHODS FOR SPECIFIC SORT BY VALUES (KEY AND VALUE SWAPPING)
    /*------------------------------------------------------------------------------*/	
    
    
    // START: SPECIFIC SORT CENTRAL METHOD 
    /*------------------------------------------------------------------------------*/	

    public enum SortingTypes
    {
        SORT_BY_NAME("Sort by Name"), SORT_BY_MAIN_CLASS("Sort by Main Class"), 
        SORT_BY_CATEGORY("Sort by Category"), SORT_BY_SUPER_TYPE("Sort by Super Type"), 
        SORT_BY_SUB_TYPE("Sort by Sub Type"), SORT_BY_USE_SPEED("Sort by Use Speed"), 
        SORT_BY_BUY_PRICE("Sort by Buy Price"), SORT_BY_SELL_PRICE("Sort by Sell Price"),
        SORT_BY_STEAL_RATE("Sort by Steal Rate"), SORT_BY_PILFER_RATE("Sort by Pilfer Rate"), 
        SORT_BY_DROP_RATE("Sort by Drop Rate"), SORT_BY_HIGHEST_QUANTITY("Sort by Highest Quantity"), 
        SORT_BY_LOWEST_QUANTITY("Sort by Lowest Quantity");
        
        private String sortingType;
        
        SortingTypes(String specificSortType)
        {
            this.sortingType = specificSortType;
        }
        
        public String getEnumAsString()
        {
            return sortingType;
        }
    }
    
    public SortingTypes getSortingTypeEnum(String argument)
    {
        return SortingTypes.valueOf(StaticMethods.stringToEnum(argument));
    }
    
    public String[] sortingTypesStrings()
    {
        String[] array = new String[SortingTypes.values().length];
        
        for(int i = 0; i < SortingTypes.values().length; i++)
        {
            array[i] = SortingTypes.values()[i].getEnumAsString();
        }
        
        return array;
    }
    
    public void specificSort(String objectClass, String sortingType)
    {
        ClassesForSorting classForSorting = getClassForSortingEnum(objectClass);
        
        SortingTypes sortType = getSortingTypeEnum(sortingType);
        
        switch(sortType)
        {
            case SORT_BY_NAME:
                specificSortByName(classForSorting);
                    break;
            case SORT_BY_MAIN_CLASS:
                specificSortByMainClass(classForSorting);
                    break;
            case SORT_BY_CATEGORY:
                specificSortByCategory(classForSorting);
                    break;
            case SORT_BY_SUPER_TYPE:
                specificSortBySuperType(classForSorting);
                    break;
            case SORT_BY_SUB_TYPE:
                specificSortBySubType(classForSorting);
                    break;
            case SORT_BY_USE_SPEED:
                specificSortByUseSpeed(classForSorting);
                    break;
            case SORT_BY_BUY_PRICE:
                specificSortByBuyPrice(classForSorting);
                    break;
            case SORT_BY_SELL_PRICE:
                specificSortBySellPrice(classForSorting);
                    break;
            case SORT_BY_STEAL_RATE:
                specificSortByStealRate(classForSorting);
                    break;
            case SORT_BY_PILFER_RATE:
                specificSortByPilferRate(classForSorting);
                    break;
            case SORT_BY_DROP_RATE:
                specificSortByDropRate(classForSorting);
                    break;    
            case SORT_BY_HIGHEST_QUANTITY:
                specificSortByHighestQuantity(classForSorting);
                    break;
            case SORT_BY_LOWEST_QUANTITY:
                specificSortByLowestQuantity(classForSorting);
                    break;
        }
    }
    
    // END: SPECIFIC SORT CENTRAL METHOD 
    /*------------------------------------------------------------------------------*/	
    
    // END: SPECIFIC SORT SORTS CERTAIN CLASS OBJECTS IN A PREDFINED WAY 
    /********************************************************************************/

    
    
    // START: METHODS USED THROUGHOUT GENERAL SORT
    /********************************************************************************/

    // START: GENERAL SORT USING KEYS 
    
    // fills TreeMap with every inventory entry set 
    public void fillTreeMapForGeneralSort(TreeMap<GenericObject, ArrayList<GenericObject>> sortInventoryBy)
    {
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.entrySet())
        {
            sortInventoryBy.put(entry.getKey(), entry.getValue());
        }
    }

    // fills inventory with contents of sorted TreeMap
    public void fillInventoryAfterGeneralSort(TreeMap<GenericObject, ArrayList<GenericObject>> sortInventoryBy)
    {
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : sortInventoryBy.entrySet())
        {
            inventory.put(entry.getKey(), entry.getValue());
        }
    }

    // all objects in inventory are sorted according to comparator supplied 
    public void generalSort(Comparator<GenericObject> comparator)
    {
        // sortInventoryBy sorts all inventory objects according to comparator  
        TreeMap<GenericObject, ArrayList<GenericObject>> sortInventoryBy = new TreeMap<>(comparator);

        // fill empty TreeMap with contents of inventory 
        fillTreeMapForGeneralSort(sortInventoryBy);

        // clear inventory to properly fill it in later  
        inventory.clear();

        // fill inventory with contents of sorted TreeMap sortObjectsBy
        fillInventoryAfterGeneralSort(sortInventoryBy);
    }

    // END: GENERAL SORT USING KEYS 
    
    
    // START: GENERAL SORT USING VALUES 
    
    // puts keys of inventory as values and inventory values as keys for TreeMap 
    public void generalSwapKeysAndValues(TreeMap<ArrayList<GenericObject>, GenericObject> sortInventoryBy)
    {
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.entrySet())
        {
            sortInventoryBy.put(entry.getValue(), entry.getKey());
        }		
    }

    // fill inventory with contents of sorted TreeMap by placing value of TreeMap 
    // as the key for inventory and the key as the value for inventory
    public void fillInventoryAfterGeneralSwap(TreeMap<ArrayList<GenericObject>, GenericObject> sortInventoryBy)
    {
        /* Note: since generalSwapKeysAndValues() swaps keys/values for TreeMap, this 
                 method "swaps back" keys/values before placement into inventory */
        for(Map.Entry<ArrayList<GenericObject>, GenericObject> sortInventoryByCopy : sortInventoryBy.entrySet())
        {
            inventory.put(sortInventoryByCopy.getValue(), sortInventoryByCopy.getKey());
        }
    }
    
    // sort all objects in inventory by quantity using entry set values 
    public void generalValueSort(Comparator<ArrayList<GenericObject>> comparator)
    {
        // sortInventoryBy will sort all objects in inventory according to comparator 
        TreeMap<ArrayList<GenericObject>, GenericObject> sortInventoryBy = new TreeMap<>(comparator);

        // put inventory key as value and inventroy value as key for sortInventoryBy
        generalSwapKeysAndValues(sortInventoryBy);

        // clear inventory to properly fill it in later  
        inventory.clear();

        // fill inventory with contents of sorted TreeMap sortInventoryBy
        fillInventoryAfterGeneralSwap(sortInventoryBy);
    }
    
    // END: GENERAL SORT USING VALUES 

    // END: METHODS USED THROUGHOUT GENERAL SORT
    /********************************************************************************/

    
    
    // START: GENERAL SORT SORTS ALL INVENTORY OBJECTS IN A PREDEFINED WAY
    /********************************************************************************/

    /* Note: methods sort all objects in inventory in ascending order according 
             to comparator supplied to generalSort() */
    
    // START: METHODS FOR GENERAL SORT BY KEYS

    public void generalSortByName()
    {
        generalSort(sortByName);
    }

    public void generalSortByMainClass()
    {
        generalSort(sortByMainClass);
    }

    public void generalSortByCategory()
    {
        generalSort(sortByCategory);
    }

    public void generalSortBySuperType()
    {
        generalSort(sortBySuperType);
    }

    public void generalSortBySubType()
    {
        generalSort(sortBySubType);
    }

    public void generalSortByUseSpeed()
    {
        generalSort(sortByUseSpeed);
    }

    public void generalSortByBuyPrice()
    {
        generalSort(sortByBuyPrice);
    }

    public void generalSortBySellPrice()
    {
        generalSort(sortBySellPrice);
    }

    public void generalSortByStealRate()
    {
        generalSort(sortByStealRate);
    }
    
    public void generalSortByPilferRate()
    {
        generalSort(sortByPilferRate);
    }
    
    public void generalSortByDropRate()
    {
        generalSort(sortByDropRate);
    }

    // END: METHODS FOR GENERAL SORT BY KEYS


    // START: METHODS FOR GENERAL SORT OF VALUES (INVOLVES KEY/VALUE SWAPPING)

    public void generalSortByHighestQuantity()
    {	
        generalValueSort(sortByHighestQuanity);
    }

    public void generalSortByLowestQuantity()
    {	
        generalValueSort(sortByLowestQuanity);
    }

    // END: METHODS FOR GENERAL SORT OF VALUES (INVOLVES KEY/VALUE SWAPPING)

    
    // START: GENERAL SORT FOR ALL OBJECTS 
    
    public void generalSort(String sortingType)
    {
        SortingTypes sortType = getSortingTypeEnum(sortingType);
        
        switch(sortType)
        {
            case SORT_BY_NAME:
                generalSortByName();
                    break;
            case SORT_BY_MAIN_CLASS:
                generalSortByMainClass();
                    break;
            case SORT_BY_CATEGORY:
                generalSortByCategory();
                    break;
            case SORT_BY_SUPER_TYPE:
                generalSortBySuperType();
                    break;
            case SORT_BY_SUB_TYPE:
                generalSortBySubType();
                    break;
            case SORT_BY_USE_SPEED:
                generalSortByUseSpeed();
                    break;
            case SORT_BY_BUY_PRICE:
                generalSortByBuyPrice();
                    break;
            case SORT_BY_SELL_PRICE:
                generalSortBySellPrice();
                    break;
            case SORT_BY_STEAL_RATE:
                generalSortByStealRate();
                    break;
            case SORT_BY_PILFER_RATE:
                generalSortByPilferRate();
                    break;
            case SORT_BY_DROP_RATE:
                generalSortByDropRate();
                    break;    
            case SORT_BY_HIGHEST_QUANTITY:
                generalSortByHighestQuantity();
                    break;
            case SORT_BY_LOWEST_QUANTITY:
                generalSortByLowestQuantity();
                    break;
        }
    }
    
    // END: SPECIFIC SORT CENTRAL METHOD 
    /*------------------------------------------------------------------------------*/	

    
    // END: GENERAL SORT FOR ALL OBJECTS 
    
    // END: GENERAL SORT SORTS ALL INVENTORY OBJECTS IN A PREDEFINED WAY
    /********************************************************************************/
    
    
    
    // START: RETRIEVING MAPS
    /*******************************************************************************/

    
    // END: RETRIEVING MAPS
    /*******************************************************************************/
}
