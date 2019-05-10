package Generic_Character;

import Commonly_Used_Methods.StaticMethods;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

/*
    RetrieveResistances concerns setting/maintaining a HashMap containing all 
    "getTotal_" methods for every relevant resistance acharacter has. For all 
    status resistances, immune response and nano response are accounted for.

    No Nanomachines Calculation : total resistance = getTotal_ + immune 
    Nanomachines Calculation    : total resistance = getTotal_ + immune + nano
    

                    PROPOSED UNIMPLEMENTED CODE LOGIC BELOW...



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

public class RetrieveResistances
{
    // holding objects from other classes 
    private Stress stress;
    private TotalStats totalStats;
    
    // HashMap containing all enchantment resistances 
    private final HashMap<String, Double> totalEnchantmentResistances = new HashMap<>();
    
    // HashMap containing all status resistances
    private final HashMap<String, ArrayList<Double>> totalStatusResistances = new HashMap<>();
    
    public RetrieveResistances(Stress stress, TotalStats totalStats)
    {
        this.stress = stress;
        this.totalStats = totalStats;
        updateEnchantmentResistances();
        initializeTotalStatusResistances();
    }
    
    
    
    // START: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/
    
    public Stress getStress()
    {
        return stress;
    }
    
    public TotalStats getTotalStats()
    {
        return totalStats;
    }
    
    // END: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/

    
    
    // START: STORING AND RETRIEVING TOTAL ENCHANTMENTS 
    /*******************************************************************************/
    
    // Note: perioducally update THIS
    public void updateEnchantmentResistances()
    {
        Object[] array = {getTotalStats().getAllTotalEnchantmentResistancesWithNames()};
        
        for(int i = 0; i < array.length - 1; i++)
        {
            totalEnchantmentResistances.put(array[i].toString(), (Double)array[i+1]);
        }
    }
    
    public double getEnchantmentResistanceValueForKey(String key)
    {
        return (double)totalEnchantmentResistances.get(StaticMethods.getEnchantmentString(key));
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
    
    // method includes an ArrayList<Double> which is used to store the total value
    // for attribute/resistance, 0.0 for immune response, and 0.0 for nano response 
    public void initializeTotalStatusResistances()
    {
        ArrayList<Object> arrayList = getResistancesArrayList();
        
        for(int i = 0; i < arrayList.size(); i += 2)
        {
            ArrayList<Double> doublesArrayList = new ArrayList<>();
            
            doublesArrayList.add((double)arrayList.get(i+1));
            doublesArrayList.add(0.0);
            doublesArrayList.add(0.0);
            
            totalStatusResistances.put((String)arrayList.get(i), doublesArrayList);
        }
    }
    
    public enum ResistanceValues
    {
        TOTAL_RESISTANCE, IMMUNE_RESPONSE, NANO_RESPONSE;
    }
    
    public double getStatusResistanceValueForKey(ResistanceValues choice, String key)
    {
        double holdDouble = 0.0;
        
        if(StaticMethods.getStatusEffectEnum(key) != null)
        {
            switch(choice)
            {
                case TOTAL_RESISTANCE:
                    holdDouble = (double)totalStatusResistances.get(key).get(0);
                        break;
                case IMMUNE_RESPONSE:
                    holdDouble = (double)totalStatusResistances.get(key).get(1);
                        break;
                case NANO_RESPONSE:
                    holdDouble = (double)totalStatusResistances.get(key).get(2);
                        break;
            }
        }
        
        return holdDouble;
    }
    
    public double getTotalStatusResistanceForKey(String key)
    {
        return getStatusResistanceValueForKey(ResistanceValues.TOTAL_RESISTANCE, key);
    }
    
    public double getStatusImmuneResponseForKey(String key)
    {
        return getStatusResistanceValueForKey(ResistanceValues.IMMUNE_RESPONSE, key);
    }
    
    public double getStatusNanoResponseForKey(String key)
    {
        return getStatusResistanceValueForKey(ResistanceValues.NANO_RESPONSE, key);
    }
    
    // Note: perioducally update THIS
    public void updateTotalStatusResistances()
    {
        ArrayList<Object> arrayList = getResistancesArrayList();
        
        for(int i = 0; i < arrayList.size(); i += 2)
        {
            ArrayList<Double> doublesArrayList = new ArrayList<>();
            String result = (String)arrayList.get(i);
            
            doublesArrayList.add((double)arrayList.get(i+1));
            doublesArrayList.add(getStatusImmuneResponseForKey(result));
            doublesArrayList.add(getStatusNanoResponseForKey(result));
            
            totalStatusResistances.put(result, doublesArrayList);
        }
    }
    
    // END: STORING AND RETRIEVING TOTAL ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/
    
    
    
    // START: RETRIEVING TOTAL RESISTANCE BASED ON NANOMACHINE PRESENCE
    /*******************************************************************************/

    public double getNonNanoTotalResistance(String key)
    {
        return (getTotalStatusResistanceForKey(key) + getStatusImmuneResponseForKey(key));
    }
    
    public double getNanoTotalResistance(String key)
    {
        return (getTotalStatusResistanceForKey(key) + getStatusImmuneResponseForKey(key) +
            getStatusNanoResponseForKey(key));
    }
    
    // END: RETRIEVING TOTAL RESISTANCE BASED ON NANOMACHINE PRESENCE
    /*******************************************************************************/

    
        
    // START: UPDATING ARRAYLIST VALUES FOR RESISTANCES HASHMAP 
    /*******************************************************************************/
    
    public void updateArrayListValueForKey(ResistanceValues choice, String key, double value)
    {
        if(StaticMethods.getStatusEffectEnum(key) != null)
        {
            ArrayList<Double> arrayList = totalStatusResistances.get(key);
            
            switch(choice)
            {
                case IMMUNE_RESPONSE:
                    arrayList.set(1, value);
                        break;
                case NANO_RESPONSE:
                    arrayList.set(2, value);
                        break;
            }
            
            totalStatusResistances.put(key, arrayList);
        }
    }
    
    public void updateImmuneResponseValueForKey(String key, double value)
    {
        updateArrayListValueForKey(ResistanceValues.IMMUNE_RESPONSE, key, value);
    }

    public void updateNanoResponseValueForKey(String key, double value)
    {
        updateArrayListValueForKey(ResistanceValues.NANO_RESPONSE, key, value);
    }
    
    // END: UPDATING ARRAYLIST VALUES FOR RESISTANCES HASHMAP 
    /*******************************************************************************/

    
    
    // START: RESETING IMMUNE AND NANO RESPONSES 
    /*******************************************************************************/	

    public void resetDesiredResponseValues(ResistanceValues responseType)
    {
        switch(responseType)
        {
            case IMMUNE_RESPONSE:
                for(HashMap.Entry<String, ArrayList<Double>> copy : totalStatusResistances.entrySet())
                {
                    updateImmuneResponseValueForKey(copy.getKey(), 0);
                }
                    break;
            case NANO_RESPONSE:
                for(HashMap.Entry<String, ArrayList<Double>> copy : totalStatusResistances.entrySet())
                {
                    updateNanoResponseValueForKey(copy.getKey(), 0);
                }
                    break;
        }
    }

    public void resetImmuneResponseValues()
    {
        resetDesiredResponseValues(ResistanceValues.IMMUNE_RESPONSE);
    }

    public void resetNanoResponseValues()
    {
        resetDesiredResponseValues(ResistanceValues.NANO_RESPONSE);
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
        return lowerUpperBounds(-12.5, 12.5, value);
    }

    public double checkNanoResponseBounds(double value)
    {
        return lowerUpperBounds(-25.0, 25.0, value);
    }

    public void updateAllImmuneResponses()
    {
        SecureRandom rand = new SecureRandom();
        
        for(HashMap.Entry<String, ArrayList<Double>> copy : totalStatusResistances.entrySet())
        {
            if(getStatusImmuneResponseForKey(copy.getKey()) == 0.0)
            {
                updateImmuneResponseValueForKey(copy.getKey(), getStatusImmuneResponseForKey(
                    copy.getKey()) + 2);
            }
            else if(getStatusImmuneResponseForKey(copy.getKey()) < 0.0)
            {
                updateImmuneResponseValueForKey(copy.getKey(), getStatusImmuneResponseForKey(
                    copy.getKey()) + (rand.nextInt(3)) + 1);
            }
            else if(getStatusImmuneResponseForKey(copy.getKey()) > 0.0)
            {
                updateImmuneResponseValueForKey(copy.getKey(), getStatusImmuneResponseForKey(
                    copy.getKey()) - (rand.nextInt(6)));
            }
        }
    }

    public void updateAllNanoResponses()
    {
        SecureRandom rand = new SecureRandom();
        
        for(HashMap.Entry<String, ArrayList<Double>> copy : totalStatusResistances.entrySet())
        {
            if(getStatusNanoResponseForKey(copy.getKey()) == 0.0)
            {
                updateNanoResponseValueForKey(copy.getKey(), getStatusNanoResponseForKey(
                    copy.getKey()) + 4);
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
        if((roundCount % 2 == 0) && getStress().getStressValue() < 0.45)
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
                if(getStress().getStressValue() > 0.85){
                    updateAllNanoResponses();
                }
            case 4:
                if(getStress().getStressValue() > 0.55){
                    updateAllNanoResponses();
                }
            case 3:
                if(getStress().getStressValue() > 0.25){
                    updateAllNanoResponses();
                }
            default: 
                if(getStress().getStressValue() < 0.15){
                    updateAllNanoResponses();
                }
                    break;
        }
    }
    
    // END: MANAGING IMMUNE AND NANO RESPONSE VALUES 
    /*******************************************************************************/	
}