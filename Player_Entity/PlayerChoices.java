package Player_Entity;

/*
    PlayerChoices concerns storing and managing the choices that players make in 
    a playthrough of the game. The game will use these choices todetermine which
    events occur (if at all) in the future. 
*/

import java.util.HashMap;

public class PlayerChoices
{
    // Note: an event is an interactive scenario a party can partake in 
    // stores event name as key and eventLine (parts of event) HashMap as value 
    private final HashMap<String, HashMap<String, Boolean>> events = new HashMap<>();
    
    // Note: an event line is a series of an events/choices that occur in an event 
    // stores choice that can be made as key and boolean signifying result of choice 
    private final HashMap<String, Boolean> eventLine = new HashMap<>();
    
    public PlayerChoices()
    {
        // empty constructor 
    }
    
    
    
    // START: EVENT AND CHOICE MANAGEMENT
    /*******************************************************************************/
    
    // add choice and result of choice taken for specified event 
    public void addEventChoice(String event, String choice, Boolean choiceResult)
    {
        eventLine.put(choice, choiceResult);
        events.put(event, eventLine);
    }
    
    // get result of choice for the given event 
    public boolean getChoiceForEvent(String event, String choice)
    {
        boolean result = false;
        
        if(events.containsKey(event))
        {
            result = events.get(event).get(choice);
        }
        
        return result;
    }
    
    // gets whether player has taken part in specified event or not 
    public boolean doesEventExist(String event)
    {
        boolean result = false;
        
        if(events.containsKey(event))
        {
            result = true;
        }
        
        return result;
    }
    
    // gets whether player has made a specific choice in an event or not 
    public boolean doesChoiceExist(String event, String choice)
    {
        boolean result = false;
        
        if(events.containsKey(event))
        {
            if(events.get(event).containsKey(choice))
            {
                result = true;
            }
        }
        
        return result;
    }
    
    // END: EVENT AND CHOICE MANAGEMENT
    /*******************************************************************************/
}