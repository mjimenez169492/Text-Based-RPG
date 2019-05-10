package Generic_Character;

/*
    RetrievingEnchantmentAndStatusResistances concerns setting/maintaining a 
    HashMap containing all "getTotal_" methods for every relevant resistance
    acharacter has. For status resistances, the features immune response and
    nano response are accounted for.

    Non-Organism Calculation:            total resistance = getTotal_
    Organism Calculation:                total resistance = getTotal_ + immune 
    Organism Calculation (nanomachines): total resistance = getTotal_ + immune + nano.

    Feature: Immune Response 
        How character reacts upon being afflicted with a status effect. Each 
        time a status effect successfully lands, character becomes even more
        vulnerable to future applications. After a brief period of time, the 
        immune response against future status effects will variably increase
        until either: 1) another status effect successfully lands, or 2) the
        immune response reaches the max value immune response can reach.
 
    Feature: Nano Response 
        How characters with nanomachines (characters that can use nano moves
        adeptly) reach upon being targeted and afflicted with status effects.
        
        Targeted (i.e. status receiver): 
            1) improves chance of negating status effect outright 
            2) chance of afflicting USER with status effect automatically 
                1. improved odds if status was successfully inflicted 

        Afflicted (i.e. status of USER (not target) lands successfully)
            On every EVEN turn, there is a chance (where chance is described
            as (rand.nextInt(nanoResponse) > (rand.nextInt(100)) for 
                1) nothing happening, 
                2) status effect afflicted being removed immediately 
                3) 1-2 status effects being removed randomly 
                4) turn count for status effects being reduced by 1-3
*/

import Universally_Used_Methods.StaticMethods;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

public class RetrievingEnchantmentAndStatusResistances extends TotalAttributesAndResistances
{
    // HashMap containing all enchantment resistances 
    private final HashMap<String, Double> totalEnchantmentResistancesHashMap = 
        new HashMap<String, Double>();
    
    // HashMap containing all status resistances
    private final HashMap<String, ArrayList<Double>> totalStatusResistancesHashMap = 
        new HashMap<String, ArrayList<Double>>();
    
    
    
    // START: STORING AND RETRIEVING TOTAL ENCHANTMENTS 
    /*******************************************************************************/
    
    public void updateEnchantMentResistancesHashMap()
    {
        Object[] array = {getAllTotalEnchantmentResistancesWithNames()};
        
        for(int i = 0; i < array.length; i+=2)
        {
            totalEnchantmentResistancesHashMap.put((String)array[i], (Double)array[i+1]);
        }
    }
    
    public double getEnchantmentResistanceValueForKey(String key)
    {
        double holdDouble = 0.0;
        
        if(StaticMethods.getEnchantmentAsString(key) != null)
        {
            holdDouble = (double)totalEnchantmentResistancesHashMap.get(key);
        }
        
        return holdDouble;
    }
    
    // END: STORING AND RETRIEVING TOTAL ENCHANTMENTS 
    /*******************************************************************************/

    /* Status Effect Resistances have layout: (resistance name, resistance total, immune response, nano response) 
       immune response refers to a natural resistance to a status effect and future application attempts 
       nano response refers to a stronger resistance to status effects and future application attempts 
       immune and nano responses are covered in public class ResistanceHashMaps	*/
    
    // START: STORING AND RETRIEVING TOTAL RESISTANCES 
    /*******************************************************************************/
    
    public Object[][] getArrayCotainingResistances()
    {
        Object[] arrayOfArrays [] = {
            getAllTotalUniqueStatusEffectResistancesWithNames(),
            getAllTotalUniqueStatusEffectResistancesWithNames(),
            getAllTotalAttributeStatusEffectResistancesWithNames(),
            getAllTotalBehaviorStatusEffectResistancesWithNames(),
            getAllTotalTurnBehaviorStatusEffectResistancesWithNames(), 
            getAllTotalNullifyStatusEffectResistancesWithNames()};
                return arrayOfArrays;
    }
    
    public ArrayList<Object> getResistancesArrayList()
    {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for(Object[] arrayWithinArray : getArrayCotainingResistances())
        {
            for(Object element : arrayWithinArray)
            {
                arrayList.add(element);
            }
        }
        
        return arrayList;
    }
    
    // method includes an ArrayList<Double> which is used to store the total value
    // for an attribute/resistance, 0.0 for the initial immune response, and 0.0 
    // for the initial nano response 
    public void updateTotalStatusResistancesHashMap(ArrayList<Object> suppliedArrayList)
    {
        for(int i = 0; i < suppliedArrayList.size(); i += 2)
        {
            ArrayList<Double> doublesArrayList = new ArrayList<Double>();
            
            doublesArrayList.add((double)suppliedArrayList.get(i+1));
            doublesArrayList.add(0.0);
            doublesArrayList.add(0.0);
            
            totalStatusResistancesHashMap.put((String)suppliedArrayList.get(i), doublesArrayList);
        }
    }
    
    public enum ArrayListValues
    {
        TOTAL_RESISTANCE, IMMUNE_RESPONSE, NANO_RESPONSE;
    }
    
    public double getStatusResistanceValueForKey(String key, ArrayListValues choice)
    {
        double holdDouble = 0.0;
        
        if(StaticMethods.getStatusNameAsValidString(key) != null)
        {
            switch(choice)
            {
                case TOTAL_RESISTANCE:
                    holdDouble = (double)totalStatusResistancesHashMap.get(key).get(0);
                        break;
                case IMMUNE_RESPONSE:
                    holdDouble = (double)totalStatusResistancesHashMap.get(key).get(1);
                        break;
                case NANO_RESPONSE:
                    holdDouble = (double)totalStatusResistancesHashMap.get(key).get(2);
                        break;
            }
        }
        
        return holdDouble;
    }
    
    public double getTotalStatusResistanceForKey(String key)
    {
        return getStatusResistanceValueForKey(key, ArrayListValues.TOTAL_RESISTANCE);
    }
    
    public double getStatusImmuneResponseForKey(String key)
    {
        return getStatusResistanceValueForKey(key, ArrayListValues.IMMUNE_RESPONSE);
    }
    
    public double getStatusNanoResponseForKey(String key)
    {
        return getStatusResistanceValueForKey(key, ArrayListValues.NANO_RESPONSE);
    }
    
    // END: STORING AND RETRIEVING TOTAL ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/
    
    
    
    // START: RETRIEVING TOTAL RESISTANCE BASED ON CHARACTER TYPE 
    /*******************************************************************************/

    public double getNonOrganismTotalResistance(String key)
    {
        return getTotalStatusResistanceForKey(key);
    }
    
    public double getOrganismTotalResistance(String key)
    {
        return (getTotalStatusResistanceForKey(key) + getStatusImmuneResponseForKey(key));
    }
    
    public double getOrganismWithNanoTotalResistance(String key)
    {
        return (getTotalStatusResistanceForKey(key) + getStatusImmuneResponseForKey(key) +
            getStatusNanoResponseForKey(key));
    }
    
    // END: RETRIEVING TOTAL RESISTANCE BASED ON CHARACTER TYPE 
    /*******************************************************************************/

    
        
    // START: UPDATING ARRAYLIST VALUES FOR RESISTANCES HASHMAP 
    /*******************************************************************************/

    public void updateDesiredArrayListValueForKey(String key, ArrayListValues
        choice, double value)
    {
        if(StaticMethods.getStatusNameAsValidString(key) != null)
        {
            ArrayList<Double> arrayList = totalStatusResistancesHashMap.get(key);
            
            switch(choice)
            {
                case TOTAL_RESISTANCE:
                    arrayList.set(0, value);
                        break;
                case IMMUNE_RESPONSE:
                    arrayList.set(1, value);
                        break;
                case NANO_RESPONSE:
                    arrayList.set(2, value);
                        break;
            }
            
            totalStatusResistancesHashMap.put(key, arrayList);
        }
    }
    
    public void updateTotalResistanceValueForKey(String key, double value)
    {
        updateDesiredArrayListValueForKey(key, ArrayListValues.TOTAL_RESISTANCE, value);
    }

    public void updateImmuneResponseValueForKey(String key, double value)
    {
        updateDesiredArrayListValueForKey(key, ArrayListValues.IMMUNE_RESPONSE, value);
    }

    public void updateNanoResponseValueForKey(String key, double value)
    {
        updateDesiredArrayListValueForKey(key, ArrayListValues.NANO_RESPONSE, value);
    }
    
    // END: UPDATING ARRAYLIST VALUES FOR RESISTANCES HASHMAP 
    /*******************************************************************************/

    
    
    // START: RESETING IMMUNE AND NANO RESPONSES 
    /*******************************************************************************/	

    public void resetDesiredResponseValues(ArrayListValues responseType)
    {
        switch(responseType)
        {
            case IMMUNE_RESPONSE:
                for(HashMap.Entry<String, ArrayList<Double>> copy : totalStatusResistancesHashMap.entrySet()){
                    updateImmuneResponseValueForKey(copy.getKey(), 0);
                }
                    break;
            case NANO_RESPONSE:
                for(HashMap.Entry<String, ArrayList<Double>> copy : totalStatusResistancesHashMap.entrySet()){
                    updateNanoResponseValueForKey(copy.getKey(), 0);
                }
                    break;
        }
    }

    public void resetImmuneResponseValues()
    {
        resetDesiredResponseValues(ArrayListValues.IMMUNE_RESPONSE);
    }

    public void resetNanoResponseValues()
    {
        resetDesiredResponseValues(ArrayListValues.NANO_RESPONSE);
    }

    // END: RESETING IMMUNE AND NANO RESPONSES 
    /*******************************************************************************/	

    
    
    // START: MANAGING IMMUNE AND NANO RESPONSE VALUES 
    /*******************************************************************************/	

    public double lowerUpperBounds(double lower, double upper, double argument)
    {
        if(argument < lower)
        {
            argument = lower;
        }
        else if(argument > upper)
        {
            argument = upper;
        }

        return argument;
    }

    public double checkImmuneResponseBounds(double value)
    {
        return lowerUpperBounds(-15.0, 15.0, value);
    }

    public double checkNanoResponseBounds(double value)
    {
        return lowerUpperBounds(-25.0, 25.0, value);
    }

    public void updateAllImmuneResponses()
    {
        SecureRandom rand = new SecureRandom();
        
        for(HashMap.Entry<String, ArrayList<Double>> copy : totalStatusResistancesHashMap.entrySet())
        {
            if(getStatusImmuneResponseForKey(copy.getKey()) == 0.0)
            {
                updateImmuneResponseValueForKey(copy.getKey(), getStatusImmuneResponseForKey(
                    copy.getKey()) + 3);
            }
            else if(getStatusImmuneResponseForKey(copy.getKey()) < 0.0)
            {
                updateImmuneResponseValueForKey(copy.getKey(), getStatusImmuneResponseForKey(
                    copy.getKey()) + (rand.nextInt(3)) + 1);
            }
            else if(getStatusImmuneResponseForKey(copy.getKey()) > 0.0)
            {
                updateImmuneResponseValueForKey(copy.getKey(), getStatusImmuneResponseForKey(
                    copy.getKey()) - (rand.nextInt(5)));
            }
        }
    }

    public void updateAllNanoResponses()
    {
        SecureRandom rand = new SecureRandom();
        
        for(HashMap.Entry<String, ArrayList<Double>> copy : totalStatusResistancesHashMap.entrySet())
        {
            if(getStatusNanoResponseForKey(copy.getKey()) == 0.0)
            {
                updateNanoResponseValueForKey(copy.getKey(), getStatusNanoResponseForKey(
                    copy.getKey()) + 7);
            }
            else if(getStatusNanoResponseForKey(copy.getKey()) < 0.0)
            {
                updateNanoResponseValueForKey(copy.getKey(), getStatusNanoResponseForKey(
                    copy.getKey()) + (rand.nextInt(5) + 1));
            }
            else if(getStatusNanoResponseForKey(copy.getKey()) > 0.0)
            {
                updateNanoResponseValueForKey(copy.getKey(), getStatusNanoResponseForKey(
                    copy.getKey()) - (rand.nextInt(3)));
            }
        }
    }

    public void autoImmuneResponse(int roundCount)
    {
        if((roundCount % 2 == 0) && getStressValue() < 0.45)
        {
            updateAllImmuneResponses();
        }
    }

    public int returnLargestIntegerBasedOnRoundOfBattle(int roundCount)
    {
        int[] nanoResponseOccurence = new int[3];

        if(roundCount % 6 == 0){nanoResponseOccurence[0] = 6;}
            else{nanoResponseOccurence[0] = 0;}
        
        if(roundCount % 4 == 0){nanoResponseOccurence[0] = 4;}
            else{nanoResponseOccurence[1] = 0;}
        
        if(roundCount % 3 == 0){nanoResponseOccurence[0] = 3;}
            else{nanoResponseOccurence[2] = 0;}

        int largestValue = -1;

        for(int i = 0; i < nanoResponseOccurence.length; i++)
        {
            if(largestValue < nanoResponseOccurence[i])
            {
                largestValue = nanoResponseOccurence[i];
            }
        }

        return largestValue;
    }

    public void autoNanoResponse(int roundCount)
    {
        switch(returnLargestIntegerBasedOnRoundOfBattle(roundCount))
        {
            case 6:
                if(getStressValue() > 0.85){
                    updateAllNanoResponses();
                }
            case 4:
                if(getStressValue() > 0.55){
                    updateAllNanoResponses();
                }
            case 3:
                if(getStressValue() > 0.25){
                    updateAllNanoResponses();
                }
            default: 
                if(getStressValue() < 0.15){
                    updateAllNanoResponses();
                }
                    break;
        }
    }
}