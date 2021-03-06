package Generic_Character;

/*
    Stress concerns the mechanic known as "Stress" where almost all stats tied to 
    a character are negatively impacted the higher the current stress value is in
    relation to max stress. 

    Example: Attribute attack is 45, current stress is 19 and max stress is 30 so 
             the attack after stress is taken into account is approximately 29 
*/

public class Stress
{
    private double maxStress, currentStress, stressDefense;
    
    public Stress()
    {
        // empty constructor
    }

    
    
    // START: SETTING AND GETTING CURRENT AND MAX STRESS
    /*******************************************************************************/
    
    public void setMaxStress(double maxStress)
    {
        if(maxStress < 0)
        {
            maxStress = 0;
        }
        else if(maxStress > 500)
        {
            maxStress = 500;
        }

        this.maxStress = maxStress;
    }
    
    public double getMaxStress()
    {
        return maxStress;
    }
    
    public void setCurrentStress(double currentStress)
    {
        if(currentStress < 0)
        {
            currentStress = 0;
        }
        else if(currentStress > maxStress)
        {
            currentStress = maxStress;
        }

        this.currentStress = currentStress;
    }
    
    public double getCurrentStress()
    {
        return currentStress;
    }
    
    public double getStressValue()
    {
        return (getCurrentStress() / getMaxStress());
    }
	
    // END: SETTING AND GETTING CURRENT AND MAX STRESS
    /*******************************************************************************/



    // START: STRESS PENALTY CALCULATIONS
    /*******************************************************************************/

    // set special kind of defense that reduces effect of stress penalty 
    public void setStressDefense(double stressDefense)
    {
        if(stressDefense < 0.00)
        {
            stressDefense = 0.00;
        }
        else if(stressDefense > 0.75)
        {
            stressDefense = 0.75;
        }

        this.stressDefense = stressDefense;
    }
	
    // get special kind of defense that reduces effect of stress penalty 
    public double getStressDefense()
    {
        return stressDefense;
    }
	
    // returns penalty stress value has on negative values passed to method 
    public double negativeStressPenalty(double value)
    {
        // calculates effect stress gauge has on value passed (1.75 determines how much
        // is added/subtracted from original value so ONLY change this value if needed)
        return (value + ((value / (1.75 + getStressDefense())) * getStressValue()));
    }
    
    // returns penalty stress value has on positive values passed to method 
    public double positiveStressPenalty(double value)
    {
        // calculates effect stress gauge has on value passed (1.75 determines how much
        // is added/subtracted from original value so ONLY change this value if needed)
        return (value + ((value / (1.75 + getStressDefense())) * getStressValue() * -1));
    }
    
    // returns penalty stress value has on attribute or resistance passed
    public double getStressPenalty(double value)
    {
        if(value < 0)
        {
            value = negativeStressPenalty(value);
        }
        else
        {
            value = positiveStressPenalty(value);
        }

        return value;
    }
	
    // END: STRESS PENALTY CALCULATIONS
    /*******************************************************************************/
}