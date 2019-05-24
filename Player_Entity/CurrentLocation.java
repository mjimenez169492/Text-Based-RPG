package Player_Entity;

/*
    FormerPartyMemberTracker concerns storing characters that were previously in 
    the player party in a HashMap in order to keep track of their state. 
*/

import Generic_Character.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

public class FormerPartyMemberTracker 
{
    private final HashMap<String, GenericCharacter> trackingFormerPartyMembers = new HashMap<>();

    public FormerPartyMemberTracker()
    {
        // empty constructor
    }
    
    
    
    // START: ADDING/REMOVING CHARACTERS FROM HASHMAP 
    /*******************************************************************************/

    public void addToCharacterStorage(GenericCharacter character)
    {
        if(character != null)
        {
            trackingFormerPartyMembers.put(character.getGeneralFeatures().getName(), character);
        }
    }
    
    public void addToCharacterStorage(ArrayList<GenericCharacter> characters)
    {
        for(GenericCharacter element : characters)
        {
            if(element != null)
            {
                trackingFormerPartyMembers.put(element.getGeneralFeatures().getName(), element);
            }
        }        
    }
    
    // Note: iterator is used to remove an element while iterating over collection 
    //       which is useful for avoiding a ConcurrentModificationException which
    //       occurs if collection is altered while it is being looped through 
    public GenericCharacter getAndRemoveCharacter(String characterName)
    {
        GenericCharacter character = null;
        
        if(characterName != null)
        {
            /* Note: Aside from importing iterator, iterator must be same type as  
                     object that the iterator is iterating to function properly */
            // iterator structure below must be the same (HashMap)
            Iterator<HashMap.Entry<String, GenericCharacter>> it = 
                trackingFormerPartyMembers.entrySet().iterator();
            
            // loop while there is still another element in collection 
            while(it.hasNext())
            {
                // cast out object from iterator and store it in entry 
                // Note: next() must be called to get next element in iteration
                //       which allows remove() to be called successfully 
                HashMap.Entry<String, GenericCharacter> entry = it.next();
                
                // if character exists in HashMap then get character and remove 
                // it from HashMap
                if(characterName.equals(entry.getKey()))
                {
                    character = entry.getValue();
                        it.remove();
                }
            }
        }
        
        return character;
    }
    
    // Note: NOT A LEGIT METHOD SO REPLACE IT LATER 
    public void printNamesOfStoredCharacters()
    {
        System.out.printf("%s\t",trackingFormerPartyMembers);
    }
    
    public HashMap<String, GenericCharacter> getFormerPartyMembers()
    {
        return trackingFormerPartyMembers;
    }
    
    // END: ADDING/REMOVING CHARACTERS FROM HASHMAP 
    /*******************************************************************************/
}
