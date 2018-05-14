/*	
	interface concerns attributes and resistances characters and enemies should have. public 
	Classes that implement 'characterAttributes' must implement all of the methods 
	in this file or else they must be declared an abstract class. 
*/

public interface characterComponents
{	
/* character name */
	
	// method to set character name (fits both 1st and last names)
	void setName(String name); 
	
	// method to get character name 
	String getName(); 
	
/* character stats information */ 
	
	// method to set Max Hit Points 
	void setMaxHp(int maxHp); 
	
	// method to get MaxHP 
	int getMaxHp(); 
	
	// method to set Current Hit Points
	void setCurrentHp(int currentHp); 
	
	// method to get Current Hit points 
	int getCurrentHp(); 
	
	// method to set max nano 
	void setMaxNano(int maxNano); 
	
	// method to set current nano
	void setCurrentNano(int currentNano);
	
	// method to get current nano
	int getCurrentNano();
	
	// method to set max stamina
	void setMaxStamina(int maxStamina); 
	
	// method to get max stamina  
	int getMaxStamina(); 
	
	// method to set current stamina 
	void setCurrentStamina(int currentStamina);
	
	// method to get current stamina 
	int getCurrentStamina();
	
	// method to set attack  
	void setAttack(int attack);
	
	// method to get attack  
	int getAttack();
	
	// method to set defense  
	void setDefense(int defense);
	
	// method to get defense  
	int getDefense();
	
	// method to set dexterity
	void setDexterity(int dexterity);
	
	// method to get dexterity 
	int getDexterity();
	
	// method to set critical chance
	void setCritical(int critical);
	
	// method to get critical chance
	int getCritical();
	
	// method to set accuracy while attacking
	void setAccuracy(int accuracy);
	
	// method to get attack accuracy
	int getAccuracy();

	// method to set nano attack  
	void setNanoAttack(int nanoAttack);
	
	// method to get nano attack  
	int getNanoAttack();
	
	// method to set nano defense  
	void setNanoDefense(int nanoDefense);
	
	// method to get nano defense  
	int getNanoDefense();
	
	// method to set luck (unique stat)
	void setLuck(int luck);
	
	// method to get luck (unique stat)
	int getLuck();
	
/* character resistances information */
	
	// method to set fire resistance
	void setFireResistance(int fireResistance);
	
	// method to get fire resistance
	int getFireResistance();
	
	// method to set water resistance
	void setWaterResistance(int waterResistance);
	
	// method to get water resistance
	int getWaterResistance();
	
	// method to set ice resistance
	void setIceResistance(int iceResistance);
	
	// method to get ice resistance
	int getIceResistance();
	
	// method to set electricity resistance
	void setElectricityResistance(int electricityResistance);
	
	// method to get electricity resistance
	int getElectricityResistance();

	// method to set poison resistance
	void setPoisonResistance(int poisonResistance);
	
	// method to get poison resistance
	int getPoisonResistance();

	// method to set sonic resistance
	void setSonicResistance(int sonicResistance);
	
	// method to get sonic resistance
	int getSonicResistance();

	// method to set plasma (laser-based) resistance
	void setPlasmaResistance(int plasmaResistance);
	
	// method to get plasma (laser-based) resistance
	int getPlasmaResistance();

	// method to set wind resistance
	void setWindResistance(int windResistance);
	
	// method to get wind resistance
	int getWindResistance();
}