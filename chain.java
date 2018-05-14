/*
	public class chain centers around a mechanic known as "chain" where the defense 
	and nano defense of a character/enemy can be reduced throughout the battle if 
	the "chain" rises closer to the chain gauge as a result of consecutive hits
*/

public class chain
{
	/*
		current chain drains by half if character/enemy receives no damage for a turn 
		
		current chain does NOT increase due to damage received by status effects 
		
		attacks, whether physical or nano attack, can increase the current chain  
		
		current chain affects defense and nano defense of character/enemy by reducing
		defense/nano defense values temporarily based on value of current chain 
		
		once current chain value reaches chainGauge value, stun victim for two turns, 
		 and reduce currentChain to 0 
	*/
	
	private int chainGauge;							// holds value of a character's chain gauge 
													// (chain gauge can range from 100 to 500)
	private int currentChain;						// value of the current chain 
	private double chainDefenseFactor;				// used to calculate character's chainDefense 
	private int holdIntegers; 						// hold int value after a double is casted
													// to an integer (truncates decimal places) 
	private double tenthsPlace;						// acquired by dividing a double and an int 
	private final double divideResultBy = 1.4;		// holds value chainPenalty will be divided by 
	private final double defenseMultiplier = 0.15;	// holds value chainDefense will be multiplied by 
	
	private double chainEffect;						// holds percentage effect chain has on attribute
	private double chainPenalty;					// store penalty chain has on character attribute 
	private double chainDefense;					// reduces value chainPenalty will be reduced by 
	private int chainResult;						// hold result of chainPenalty - chainDefense 
	
	// constructor for creating chain objects 
	public chain()
	{
		// empty constructor 
	}
	
	// set max value for chain gauge 
	public void setChainGauge(int chainGauge)
	{
		if(chainGauge < 0)
		{
			chainGauge = 0;
		}
		else if(chainGauge > 500)
		{
			chainGauge = 500;
		}
		
		this.chainGauge = chainGauge;
	}
	
	// get max value for chain gauge
	public int getChainGauge()
	{
		return chainGauge;
	}
	
	// set value of current change 
	public void setCurrentChain(int currentChain)
	{
		if(currentChain < 0)
		{
			currentChain = 0;
		}
		else if(currentChain > chainGauge)
		{
			currentChain = chainGauge;
		}
		
		this.currentChain = currentChain;
	}
	
	// get value of current change 
	public int getCurrentChain()
	{
		return currentChain;
	}
	
	// halve the value of the current chain (decimals are truncated so (1 / 2) is 0
	public void halveCurrentChain()
	{
		setCurrentChain(getCurrentChain() / 2);
	}
	
	// set defense factor which reduces the value of chain penalty 
	public void setChainDefenseFactor(double chainDefenseFactor)
	{
		if(chainDefenseFactor < 0.00)
		{
			chainDefenseFactor = 0.00;
		}
		else if(chainDefenseFactor > 0.60)
		{
			chainDefenseFactor = 0.60;
		}
		
		this.chainDefenseFactor = chainDefenseFactor;
	}
	
	// get defense factor which reduces the value of chain penalty 
	public double getChainDefenseFactor()
	{
		return chainDefenseFactor;
	}
	
	// method returns penalty to defense/nano defense attribute due to current chain
	public int getChainPenalty(int attribute)
	{
		// store result of calculation in chain effect 
		/* Note: value of current chain and chain gauge are casted to double in order
				 to perform division which will not result in 1 like in int division */
		chainEffect = ((double) getCurrentChain() / (double) getChainGauge()) * divideResultBy;
		
		// chainPenalty is based on value of attribute and value of chainEffect
		chainPenalty = attribute * chainEffect;
		
		// round chainPenalty based on tenths position
		chainPenalty = roundTenths(chainPenalty);
		
		// round value gotten through multiplication based on tenths position 
		chainDefense = roundTenths(chainPenalty * getChainDefenseFactor());
		
		// cast difference of double values into an int 
		chainResult = (int)(chainPenalty - chainDefense);
		
		// return the value in chainResult
		return chainResult;
	}
	
	// method rounds value passed to it based on tenths position and returns it
	public double roundTenths(double value)
	{
		// cast to int to store integers in holdIntegers and truncate decimal places 
		holdIntegers = (int)value;
		
		// store decimal places after subtraction in tenthsPlace
		tenthsPlace = value - holdIntegers;
		
		// round tenthsPlace according to if-else statement below 
		if(tenthsPlace < 0.5)
		{
			tenthsPlace = 0;
		}
		else if(tenthsPlace >= 0.5)
		{
			tenthsPlace = 1;
		}
		
		// add tenthsPlace to holdIntegers
		holdIntegers += tenthsPlace;
		
		// return value stored in holdIntegers
		return holdIntegers;
	}
}