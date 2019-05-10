package Generic_Character;

/*
    ExtraFeatures contains features currently being tested to see if they are 
    worthy of being part of the GenericCharacter class hierarchy. Many of the 
    features are intended to be used for creating objects meant to be fought.
*/

import Generic_Object.GenericObject;
import java.security.SecureRandom;
import java.util.ArrayList;

public class ExtraFeatures extends Moveset
{
    // variables concerning features useful for creation of enemy combatants 
    private int defeatExp;                      // exp received for beating object  
    private int defeatMoney;            	// money dropped upon defeating object 

    // trigger meant for ending a battle early once certain conditions are met 
    private boolean endBattleTrigger;		

    // variables holds max amount of money characters can hold on their person 
    // personal wallet funds cannot be accessed directly (must steak from self)
    private int personalWalletMaxSize;
    private int personalWallet;
    
    // variables holding the maximum size for each inventory-like ArrayList  
    private int stealableObjectsMaxCapacity, pilferableObjectsMaxCapacity, 
        droppableObjectsMaxCapacity;

    // ArrayLists hold objects that can be stolen, pilfered, or dropped 
    // objects in stealableObjects and pilferableObjects cannot be accessed 
    // directly (must use steal or pilfer depending on ArrayList) 
    private final ArrayList<GenericObject> stealableObjects = new ArrayList<GenericObject>();
    private final ArrayList<GenericObject> pilferableObjects = new ArrayList<GenericObject>();
    private final ArrayList<GenericObject> droppableObjects = new ArrayList<GenericObject>();

    
    
    // START: USEFUL ENEMY-RELATED METHODS 
    /*******************************************************************************/

    public void setDefeatExp(int defeatExp)
    {
        if (defeatExp < 0) 
        {
            defeatExp = 0; 
        }
        else if(defeatExp > 50000)
        {
            defeatExp = 50000;
        }

        this.defeatExp = defeatExp;
    }

    public int getDefeatExp()
    {
        return defeatExp;
    }

    public void setDefeatMoney(int defeatMoney)
    {
        if(defeatMoney < 0)
        {
                defeatMoney = 0;
        }
        else if(defeatMoney < 150000)
        {
                defeatMoney = 150000;
        }

        this.defeatMoney = defeatMoney; 
    }

    public int getDefeatMoney()
    {
        return defeatMoney; 
    } 

    // END: USEFUL ENEMY-RELATED METHODS 
    /*******************************************************************************/

    
    
    // START: TRACKING UNIQUE CONDITIONS 
    /*******************************************************************************/

    public void setEndBattleTrigger(boolean endBattleTrigger)
    {
        this.endBattleTrigger = endBattleTrigger;
    }

    public boolean getEndBattleTrigger()
    {
        return endBattleTrigger;
    }
    
    // END: TRACKING UNIQUE CONDITIONS 
    /*******************************************************************************/

    
    
    // START: PERSONAL WALLET (CAN ONLY BE ACCESSED BY STEALING FROM SELF)
    /*******************************************************************************/

    public void setPersonalWalletMaxSize(int personalWalletMaxSize)
    {
        this.personalWalletMaxSize = personalWalletMaxSize;
    }
    
    public int getPersonalWalletMaxSize()
    {
        return personalWalletMaxSize;
    }
    
    public void setPersonalWallet(int personalWallet)
    {
        if(personalWallet < 0)
        {
            personalWallet = 0;
        }
        else if(personalWallet > personalWalletMaxSize)
        {
            personalWallet = personalWalletMaxSize;
        }
        
        this.personalWallet = personalWallet;
    }
    
    public int getPersonalWallet()
    {
        return personalWallet;
    }
    
    // END: PERSONAL WALLET (CAN ONLY BE ACCESSED BY STEALING FROM SELF)
    /*******************************************************************************/
    


    // START: SETTING MAX SIZE FOR STEALABLE, PILFERABLE, AND DROPPABLE OBJECTS ARRAYLIST
    /*******************************************************************************/ 

    public void setStealableObjectsMaxCapacity(int stealableObjectsMaxCapacity)
    {
        this.stealableObjectsMaxCapacity = stealableObjectsMaxCapacity;
    }

    public int getStealableObjectsMaxCapacity()
    {
        return stealableObjectsMaxCapacity;
    }

    public void setPilferableObjectsMaxCapacity(int pilferableObjectsMaxCapacity)
    {
        this.pilferableObjectsMaxCapacity = pilferableObjectsMaxCapacity;
    }

    public int getPilferableObjectsMaxCapacity()
    {
        return pilferableObjectsMaxCapacity;
    }

    public void setDroppableObjectsMaxSize(int droppableObjectsMaxCapacity)
    {
        this.droppableObjectsMaxCapacity = droppableObjectsMaxCapacity;
    }

    public int getDroppableObjectsMaxSize()
    {
        return droppableObjectsMaxCapacity;
    }

    // END: SETTING MAX SIZE FOR STEALABLE, PILFERABLE, AND DROPPABLE OBJECTS ARRAYLIST
    /*******************************************************************************/



    // START: ADDING/REMOVING STEALABLE, PILFERABLE, AND DROPPABLE OBJECTS
    /*******************************************************************************/

    public void addObjectToArrayList(ArrayList<GenericObject> arrayList, 
        int arrayListCapacity, GenericObject object)
    {
        if(object != null && arrayList.size() != arrayListCapacity)
        {
            arrayList.add(object);
        }
    }

    public void addToStealableObjects(GenericObject object)
    {
        addObjectToArrayList(stealableObjects, stealableObjectsMaxCapacity, object);
    }

    public void addToPilferableObjects(GenericObject object)
    {
        addObjectToArrayList(pilferableObjects, pilferableObjectsMaxCapacity, object);
    }

    public void addToDroppableObjects(GenericObject object)
    {
        addObjectToArrayList(droppableObjects, droppableObjectsMaxCapacity, object);
    }

    public void removeObjectFromArrayList(ArrayList<GenericObject> arrayList, String objectName)
    {
        for(GenericObject element : arrayList)
        {
            if(objectName.equals(element.getName()))
            {
                arrayList.remove(element);
            }
        }
    }

    public void removeFromStealableObjects(String objectName)
    {
        removeObjectFromArrayList(stealableObjects, objectName);
    }

    public void removeFromPilferableObjects(String objectName)
    {
        removeObjectFromArrayList(pilferableObjects, objectName);
    }

    public void removeFromDroppableObjects(String objectName)
    {
        removeObjectFromArrayList(droppableObjects, objectName);
    }
    
    public ArrayList<GenericObject> getStealableObjects()
    {
        return stealableObjects;
    }
    
    public ArrayList<GenericObject> getPilferableObjects()
    {
        return pilferableObjects;
    }
    
    public ArrayList<GenericObject> getDroppableObjects()
    {
        return droppableObjects;
    }

    // END: ADDING/REMOVING STEALABLE, PILFERABLE, AND DROPPABLE OBJECTS
    /*******************************************************************************/



    // START: DROPPABLE OBJECT BEHAVIOR
    /*******************************************************************************/

    // determine what objects exist in droppableObjects ArrayList after battle 
    public void updateDroppableObjectsArrayList()
    {
        SecureRandom rand = new SecureRandom();

        if(droppableObjects != null && !droppableObjects.isEmpty())
        {
            for(GenericObject element : droppableObjects)
            {
                int removeObjectRate = rand.nextInt((int)(element.getDropRate() * 100));
                int keepObjectRate = rand.nextInt((int)(element.getDropRate() * 100));
                int keepObjectBonus = rand.nextInt((int)((element.getDropRate() * 100) / 3));
                
                if(removeObjectRate >= keepObjectRate + keepObjectBonus)
                {
                    droppableObjects.remove(element);
                }
            }
        }
    }
    
    // END: DROPPABLE OBJECT BEHAVIOR
    /*******************************************************************************/
}