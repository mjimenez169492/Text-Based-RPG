package Player_Entity;

/*
    PartyLocation concerns showing the current location of the party in the game.
*/

public class CurrentLocation 
{
    /* Hierarchy of location by importance
        "Story Part" concerns a major part of story the party is in (like: "Underworld"))
        "Central Hub" concerns central location pivotal to story part (like: City Colnera)
        "Major Location" concerns very important place in central hub (like: Plaza Pontix)
        "Minor Location" concerns semi-important place in major location (like: Factory)
        "Intra Location" concerns specific location within minor location (like: Factory Hidden Room) */
    private String storyPart, centralHub, majorLocation, minorLocation, intraLocation;
    
    public void setStoryPart(String storyPart)
    {
        this.storyPart = storyPart;
    }
    
    public String getStoryPart()
    {
        return storyPart;
    }
    
    public void setCentralHub(String centralHub)
    {
        this.centralHub = centralHub;
    }
    
    public String getCentralHub()
    {
        return centralHub;
    }
    
    public void setMajorLocation(String majorLocation)
    {
        this.majorLocation = majorLocation;
    }
    
    public String getMajorLocation()
    {
        return majorLocation;
    }
    
    public void setMinorLocation(String minorLocation)
    {
        this.minorLocation = minorLocation;
    }
    
    public String getMinorLocation()
    {
        return minorLocation;
    }
    
    public void setIntraLocation(String intraLocation)
    {
        this.intraLocation = intraLocation;
    }
    
    public String getIntraLocation()
    {
        return intraLocation;
    }
}