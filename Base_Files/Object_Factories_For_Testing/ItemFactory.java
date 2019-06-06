package Object_Factories_For_Testing;

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
    public Item getHealingPotionOne()
    {
        Item item = new Item();
        
        // description
        item.setName("Healing Potion One");
        item.setBriefDescription("Recovers health of a single target.");
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
        item.setMove(new MovesFactory().getItemMoveHealOneExample());
        
        return item;
    }
    
    public Item getHealingPotionMany()
    {
        Item item = new Item();
        
        // description
        item.setName("Healing Potion Many");
        item.setBriefDescription("Recovers health of many targets at once.");
        item.setMainClass("Item");
        item.setItemCategory("Recovery");
        item.setItemSuperType("Gauge");
        item.setSubType("Health Points");
        
        // additional description
        item.setUseSpeed(1.25);
        item.setBuyPrice(0);
        item.setSellPrice(11);
        item.setStealRate(12);
        item.setPilferRate(12);
        item.setDropRate(15);
        
        // damages user by 10 points just for fun
        item.setMove(new MovesFactory().getItemMoveHealManyExample());
        
        return item;
    }
    
    // RECOVERY
    
    // DAMAGE 
    
    public Item getThrowingKnife()
    {
        Item item = new Item();
        
        // description 
        item.setName("Throwing Knife");
        item.setBriefDescription("Knife deals damage to a single character");
        item.setMainClass("Item");
        item.setItemCategory("Damage");
        item.setItemSuperType("Gauge");
        item.setSubType("Health & Stamina");
        
        // additional description 
        item.setUseSpeed(1.0);
        item.setBuyPrice(325);
        item.setSellPrice(310);
        item.setStealRate(83.8);
        item.setPilferRate(3);
        item.setDropRate(35.0);
        
        item.setMove(new MovesFactory().getItemMoveDamageOneExample());
        
        return item;
    }
    
    public Item getMakeshiftGrenade()
    {
        Item item = new Item();
        
        // description
        item.setName("Makeshift Grenade");
        item.setBriefDescription("Deals damage to all characters.");
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
        
        item.setMove(new MovesFactory().getItemMoveDamageManyExample());
        
        return item;
    }
    
    // END: TUTORIAL AREA ITEMS (ASSUME LV 1)
    /*******************************************************************************/
}
