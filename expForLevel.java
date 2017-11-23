import java.util.Random;

public class expForLevel
{
	public static void main(String[] args)
	{
		genericCharacter character = new genericCharacter();
		increaseStats stats = new increaseStats();
		
		character.setName("apple");
		character.setMaxHP(22);
		character.setCurrentHP(22);
		character.setAttack(4);
		character.setDefense(3);
		character.setMagic(6);
		character.setStamina(8);
		character.setDexterity(4);
		character.setCritical(1);
		character.setHitChance(3);
		character.setMagicAttack(3);
		character.setMagicDefense(4);
		character.setEvasion(2);
		character.setMagicEvasion(1);
		character.setLuck(1); // hidden stat 
		
		int i = 1;
		
		while(i <= 99)
		{
			stats.randStatsUp(character);
			i++;
		}
		
		System.out.println("Max HP: "+character.getMaxHP());
		System.out.println("Attack: "+character.getAttack());
		System.out.println("Defense: "+character.getDefense());
		System.out.println("Magic: "+character.getMagic());
		System.out.println("Stamina: "+character.getStamina());
		System.out.println("Dexterity: "+character.getDexterity());
		System.out.println("Critical: "+character.getCritical());
		System.out.println("Hit Chance: "+character.getHitChance());
		System.out.println("M Attack: "+character.getMagicAttack());
		System.out.println("M Defense: "+character.getMagicDefense());
		System.out.println("Evasion: "+character.getEvasion());
		System.out.println("M Evasion: "+character.getMagicEvasion());
		System.out.println("Luck: "+character.getLuck());
	}
}