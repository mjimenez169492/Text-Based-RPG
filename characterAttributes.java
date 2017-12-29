/*	
	interface regarding character and enemy stats
	classes that implement 'characterStats' must implement all
	methods or they must be declared an abstract class 
*/

public interface characterAttributes
{	
/* character name */
	
	// method to set character name (fits both 1st and last names)
	void setName(String firstLastname); 
	
	// method to retrieve character name 
	String getName(); 
	
/* character stat information */ 
	
	// method to set Max Hit Points takes argument to set MaxHP
	void setMaxHP(int maxHitPoints); 
	
	// method to retrieve MaxHP 
	int getMaxHP(); 
	
	// method to set Current Hit Points
	void setCurrentHP(int currentHitPoints); 
	
	// method to retrieve Current Hit points 
	int getCurrentHP(); 
	
	// method to set level
	void setLevel(int charlevel);
	
	// method to get level
	int getLevel();
	
	// method to set Experience 
	void setExperience(int charExperience);
	
	// method to get experience
	int getExperience();
	
	// method to set attack power 
	void setAttack(int charAttack);
	
	// method to get attack power 
	int getAttack();
	
	// method to set defense power 
	void setDefense(int charDefense);
	
	// method to get defense power 
	int getDefense();
	
	// method to set stamina 
	void setMagic(int charMagic);
	
	// method to get stamina 
	int getMagic();
	
	// method to set stamina 
	void setStamina(int charStamina);
	
	// method to get stamina 
	int getStamina();
	
	// method to set agility
	void setDexterity(int charDexterity);
	
	// method to get agility 
	int getDexterity();
	
	// method to set critical probability
	void setCritical(int charCritical);
	
	// method to get critical probability
	int getCritical();
	
	// method to set hit chance while attacking
	void setHitChance(int hitchance);
	
	// method to get attack hit chance 
	int getHitChance();

	// method to set magic attack power 
	void setMagicAttack(int charMagicAttack);
	
	// method to get magic attack power 
	int getMagicAttack();
	
	// method to set magic defense power 
	void setMagicDefense(int charMagicDefense);
	
	// method to get magic defense power 
	int getMagicDefense();
	
	// method to set evasion 
	void setEvasion(int charEvasion);
	
	// method to get evasion 
	int getEvasion();
	
	// method to set magic evasion 
	void setMagicEvasion(int charMagicEvasion);
	
	// method to get magic evasion
	int getMagicEvasion();
	
	// method to set luck (unique bonuses to each stat)
	void setLuck(int charLuck);
	
	// method to get luck (unique bonuses to each stat)
	int getLuck();
	
/* character resistance information */
	
	// method to set fire resistance
	void setFireResistance(int resistFire);
	
	// method to get fire resistance
	int getFireResistance();
	
	// method to set water resistance
	void setWaterResistance(int resistWater);
	
	// method to get water resistance
	int getWaterResistance();
	
	// method to set ice resistance
	void setIceResistance(int resistIce);
	
	// method to get ice resistance
	int getIceResistance();
	
	// method to set lightning resistance
	void setLightningResistance(int resistLightning);
	
	// method to get lightning resistance
	int getLightningResistance();

	// method to set poison resistance
	void setPoisonResistance(int resistPoison);
	
	// method to get poison resistance
	int getPoisonResistance();

	// method to set sonic resistance
	void setSonicResistance(int resistSonic);
	
	// method to get sonic resistance
	int getSonicResistance();

	// method to set energy resistance
	void setEnergyResistance(int resistEnergy);
	
	// method to get energy resistance
	int getEnergyResistance();

	// method to set nano resistance
	void setNanoResistance(int resistNano);
	
	// method to get nano resistance
	int getNanoResistance();
	
	// method to set character/enemy status in and outside of battle
	//private String status; 			// sets character status 

	
	
}