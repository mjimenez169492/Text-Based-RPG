package Generic_Character;

import Commonly_Used_Methods.StaticMethods;

import java.util.ArrayList;

/*
    RetrieveResistances concerns setting/maintaining a HashMap containing all 
    "getTotal_" methods for every relevant resistance acharacter has. 
*/

public class RetrieveResistances
{
    // holding objects from other classes 
    private TotalStats totalStats;
    
    public RetrieveResistances(TotalStats totalStats)
    {
        this.totalStats = totalStats;
    }
    
    
    
    // START: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/
    
    public TotalStats getTotalStats()
    {
        return totalStats;
    }
    
    // END: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/

    
    
    // START: STORING AND RETRIEVING TOTAL ENCHANTMENTS 
    /*******************************************************************************/
    
    public double getEnchantmentResistanceValueForKey(String key)
    {
        double result = 0;
        
        Object[] array = {getTotalStats().getAllTotalEnchantmentResistancesWithNames()};
        
        for(int i = 0; i < array.length; i+=2)
        {
            if(StaticMethods.getEnchantmentEnum(key) != StaticMethods.Enchantments.NONE)
            {
                result = (double)array[i+1];
            }
        }
        
        return result;
    }
    
    // END: STORING AND RETRIEVING TOTAL ENCHANTMENTS 
    /*******************************************************************************/

    
    
    // START: STORING AND RETRIEVING TOTAL RESISTANCES 
    /*******************************************************************************/
    
    public Object[][] getArrayCotainingResistances()
    {
        Object[] arrayOfArrays [] = {
            getTotalStats().getAllTotalUniqueStatusEffectResistancesWithNames(),
            getTotalStats().getAllTotalUniqueStatusEffectResistancesWithNames(),
            getTotalStats().getAllTotalAttributeStatusEffectResistancesWithNames(),
            getTotalStats().getAllTotalBehaviorStatusEffectResistancesWithNames(),
            getTotalStats().getAllTotalTurnBehaviorStatusEffectResistancesWithNames(), 
            getTotalStats().getAllTotalNullifyStatusEffectResistancesWithNames()};
                return arrayOfArrays;
    }
    
    public ArrayList<Object> getResistancesArrayList()
    {
        ArrayList<Object> arrayList = new ArrayList<>();

        for(Object[] arrayWithinArray : getArrayCotainingResistances())
        {
            for(Object element : arrayWithinArray)
            {
                arrayList.add(element);
            }
        }
        
        return arrayList;
    }
    
    public double getTotalStatusResistanceForKey(String key)
    {
        double result = 0.0;
        
        ArrayList<Object> arrayList = getResistancesArrayList();
        
        for(int i = 0; i < getResistancesArrayList().size(); i += 2)
        {
            if(key.equals((String)arrayList.get(i)))
            {
                result = (double)arrayList.get(i + 1);
            }
        }
        
        return result;
    }

    // END: STORING AND RETRIEVING TOTAL ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/
}
