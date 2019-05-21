package Object_Factories;

import Generic_Object.Item;
import Move_Creation.Moves;
import java.security.SecureRandom;

public class ItemFactory 
{
    // START: ITEM EXAMPLE
    /*******************************************************************************/

    public Item getItemExample()
    {
        Item item = new Item();
        
        item.setName("Example");
        item.setBriefDescription("An example of what an item object would"
            + "look like.");
        item.setMainClass("Item");
        item.setItemCategory("Other");
        item.setItemSuperType("Key Item");
        item.setSubType("Quest");
        
        item.setUseSpeed(1.10);
        item.setBuyPrice(100);
        item.setSellPrice(50);
        item.setStealRate(5.2);
        item.setPilferRate(0);
        item.setDropRate(7.7);
        
        item.setMove(null);
        
        return item;
    }
    
    public String randomNumberOfLetters(String[] array)
    {
        SecureRandom rand = new SecureRandom();
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < (rand.nextInt(25) + 1); i++)
        {
            builder.append(array[i]);
        }
        
        return builder.toString();
    }
    
    public double randomNumber()
    {
        SecureRandom rand = new SecureRandom();

        return (double)(rand.nextInt(50) + 1);
    }
    
    public Item getRandomItem()
    {
        String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
            "k", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", 
            "X", "Y", "z"};
        
        Item item = new Item();
        
        item.setName(randomNumberOfLetters(array));
        item.setBriefDescription(randomNumberOfLetters(array));
        item.setMainClass("Item");
        item.setItemCategory("Other");
        item.setItemSuperType("Key Item");
        item.setSubType("Quest");
        
        item.setUseSpeed(randomNumber());
        item.setBuyPrice(randomNumber());
        item.setSellPrice(randomNumber());
        item.setStealRate(randomNumber());
        item.setPilferRate(randomNumber());
        item.setDropRate(randomNumber());
        
        item.setMove(null);
        
        return item;
    }
    
    // END: ITEM EXAMPLE
    /*******************************************************************************/

    
    
    // START: TUTORIAL AREA ITEMS (ASSUME LV 1)
    /*******************************************************************************/

    /* Items
        Recovery
            "World's Greatest Coffee"
            Loman Series Health Tonic
            Sample Plant Extract
        Damage
            Makeshift Shrapnel Grenade
            Throwing Pen
            Plastic Dart
        Other
            Sample Smoke Grenade
            Sample Poison Grenade
            Broken AIMS Component
    */
    
    // RECOVERY 
    public Item getWorldsGreatestCupOfCoffee()
    {
        Item item = new Item();
        
        // description
        item.setName("\"World's Greatest Coffee\"");
        item.setBriefDescription("Unknown effect on current health of user.");
        item.setMainClass("Item");
        item.setItemCategory("Recovery");
        item.setItemSuperType("Gauge");
        item.setSubType("Health Points");
        
        // additional description
        item.setUseSpeed(1.2);
        item.setBuyPrice(0);
        item.setSellPrice(15);
        item.setStealRate(0);
        item.setPilferRate(0);
        item.setDropRate(12.5);
        
        // damages user by 10 points just for fun
        item.setMove(null);
        
        return item;
    }
    
    public Item getLomanSeriesHealthWeb()
    {
        Item item = new Item();
        
        // description 
        item.setName("Loman Series Health Tonic");
        item.setBriefDescription("Restores 15 health points for all party members.");
        item.setMainClass("Item");
        item.setItemCategory("Recovery");
        item.setItemSuperType("Gauge");
        item.setSubType("Health Points");
        
        // additional description 
        item.setUseSpeed(1.2);
        item.setBuyPrice(60);
        item.setSellPrice(30);
        item.setStealRate(6.7);
        item.setPilferRate(0);
        item.setDropRate(10.5);
        
        item.setMove(null);
        
        return item;
    }
    
    public Item getExperimentalExtract()
    {
        Item item = new Item();
        
        // description 
        item.setName("Experimental Extract");
        item.setBriefDescription("Recovers 6 points for all gauges upon use. "
            + "Boosts attack and defense.");
        item.setMainClass("Item");
        item.setItemCategory("Recovery");
        item.setItemSuperType("Gauge");
        item.setSubType("Multiple Effects");
        
        // additional description
        item.setUseSpeed(1.20);
        item.setBuyPrice(0);
        item.setSellPrice(0);
        item.setStealRate(0);
        item.setPilferRate(0);
        item.setDropRate(0);
        
        item.setMove(null);
        
        return item;
    }
    
    // RECOVERY
    
    // DAMAGE 
    public Item getMakeshiftShrapnelGrenade()
    {
        Item item = new Item();
        
        // description
        item.setName("Makeshift Shrapnel Grenade");
        item.setBriefDescription("Deals significant damage to all opposing targets.");
        item.setMainClass("Item");
        item.setItemCategory("Damage");
        item.setItemSuperType("Gauge");
        item.setSubType("Health Points");
        
        // additional description
        item.setUseSpeed(0.9);
        item.setBuyPrice(100);
        item.setSellPrice(75);
        item.setStealRate(4.2);
        item.setPilferRate(0);
        item.setDropRate(7.8);
        
        item.setMove(null);
        
        return item;
    }
    
    public Item getThrowingKnife()
    {
        Item item = new Item();
        
        // description 
        item.setName("Throwing Knife");
        item.setBriefDescription("Knife designed to be thrown with the amount "
            + "of damage depending on the strength of the user");
        item.setMainClass("Item");
        item.setItemCategory("Damage");
        item.setItemSuperType("Gauge");
        item.setSubType("Health & Stamina");
        
        // additional description 
        item.setUseSpeed(1.0);
        item.setBuyPrice(25);
        item.setSellPrice(10);
        item.setStealRate(8.8);
        item.setPilferRate(0);
        item.setDropRate(5.0);
        
        item.setMove(null);
        
        return item;
    }
    
    public Item getSmallDart()
    {
        Item item = new Item();
        
        // description
        item.setName("Small Dart");
        item.setBriefDescription("Wrist launched dart that deals moderate damage "
            + "to the target's stamina gauge.");
        item.setMainClass("Item");
        item.setItemCategory("Damage");
        item.setItemSuperType("Gauge");
        item.setSubType("Stamina Points");
        
        // additional description
        item.setUseSpeed(1.0);
        item.setBuyPrice(40);
        item.setSellPrice(15);
        item.setStealRate(6.2);
        item.setPilferRate(0);
        item.setDropRate(4.0);
        
        item.setMove(null);
        
        return item;
    }
    
    // OTHER
    public Item getSampleSmokeGrenade()
    {
        Item item = new Item();
        
        item.setName("Sample Smoke Grenade");
        item.setBriefDescription("Reduces accuracy and evasion of all opposing "
            + "combatants in battle.");
        item.setMainClass("Item");
        item.setItemCategory("Other");
        item.setItemSuperType("Status Effect");
        item.setSubType("Status Dealing");
        
        item.setUseSpeed(1.0);
        item.setBuyPrice(50);
        item.setSellPrice(235);
        item.setStealRate(6.2);
        item.setPilferRate(0);
        item.setDropRate(4.0);
        
        item.setMove(null);
        
        return item;
    }
    
    public Item getSamplePoisonGrenade()
    {
        Item item = new Item();
        
        item.setName("Sample Smoke Grenade");
        item.setBriefDescription("Chance of inflicting poison on all opposing "
            + "combatants in battle.");
        item.setMainClass("Item");
        item.setItemCategory("Other");
        item.setItemSuperType("Status Effect");
        item.setSubType("Status Dealing");
        
        item.setUseSpeed(1.0);
        item.setBuyPrice(60);
        item.setSellPrice(35);
        item.setStealRate(6.2);
        item.setPilferRate(0);
        item.setDropRate(4.0);
        
        item.setMove(null);
        
        return item;
    }
    
    public Item getAimsComponentFragment()
    {
        Item item = new Item();
        
        item.setName("AIMS Component Fragment");
        item.setBriefDescription("Fragment of a components meant to be added "
            + "to the AIMS Apparatus.");
        item.setMainClass("Item");
        item.setItemCategory("Key Item");
        item.setItemSuperType("Status Effect");
        item.setSubType("Plot");
        
        item.setUseSpeed(0);
        item.setBuyPrice(0);
        item.setSellPrice(0);
        item.setStealRate(0);
        item.setPilferRate(0);
        item.setDropRate(0);
        
        item.setMove(null);
        
        return item;
    }
    
    // END: TUTORIAL AREA ITEMS (ASSUME LV 1)
    /*******************************************************************************/


}
