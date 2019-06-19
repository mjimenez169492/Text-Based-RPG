package Player_Entity;

/*
    PlayerEntity is used to create objects that players have to manage in order 
    to progress through the game. PlayerEntity, like GenericCharacter, utilizes
    composition over inheritance to create objects that are easier to maintain.
*/


public class PlayerEntity 
{
    FormerPartyMemberTracker formerPartyMemberTracker = new FormerPartyMemberTracker();
    
    PlayerChoices playerChoices = new PlayerChoices();
    
    Party party = new Party();
    
    Inventory inventory = new Inventory();
    
    PartyWallet partyWallet = new PartyWallet();
    
    public PlayerEntity()
    {
        // empty constructor 
    }
    
    
    
    // START: GETTING OBJECTS CREATED USING OTHER CLASSES 
    /*******************************************************************************/

    public FormerPartyMemberTracker getFormerPartyMemberTracker()
    {
        return formerPartyMemberTracker;
    }
    
    public PlayerChoices getPlayerChoices()
    {
        return playerChoices;
    }
    
    public Party getParty()
    {
        return party;
    }
    
    public Inventory getInventory()
    {
        return inventory;
    }
    
    public PartyWallet getPartyWallet()
    {
        return partyWallet;
    }
    
    // END: GETTING OBJECTS CREATED USING OTHER CLASSES 
    /*******************************************************************************/
}
