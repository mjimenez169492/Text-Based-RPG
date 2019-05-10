package Move_Creation;

public class ItemMoves 
{
    // grab from GenericObject subclass Items 
    private String mainClass, category, superType, subType;
    
    
    
    // START: DEFINING ITEM MOVE BY USING ITEMS OBJECT 
    /*******************************************************************************/

    public void setMainClass(String mainClass)
    {
        this.mainClass = mainClass;
    }
    
    public String getMainClass()
    {
        return mainClass;
    }
    
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public void setSuperType(String superType)
    {
        this.superType = superType;
    }
    
    public String getSuperType()
    {
        return superType;
    }
    
    public void setSubType(String subType)
    {
        this.subType = subType;
    }
    
    public String getSubType()
    {
        return subType;
    }
    
    // END: DEFINING ITEM MOVE BY USING ITEMS OBJECT 
    /*******************************************************************************/
}