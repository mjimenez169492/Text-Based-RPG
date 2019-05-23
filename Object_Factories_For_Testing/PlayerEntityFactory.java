package Object_Factories_For_Testing;

import Player_Entity.PlayerEntity;
import Generic_Object.GenericObject;
import java.security.SecureRandom;
import Generic_Character.GenericCharacter;

public class PlayerEntityFactory 
{
    public PlayerEntity getPlayerEntityExample()
    {
        PlayerEntity playerEntity = new PlayerEntity();
            playerEntity.getParty().playerParty(true);
        
        GenericCharacterFactory characterOne = new GenericCharacterFactory();
        GenericCharacter charOne = characterOne.getExampleCharacterOne();
            playerEntity.getParty().addToParty(charOne);
        
        GenericCharacterFactory characterTwo = new GenericCharacterFactory();
        GenericCharacter charTwo = characterTwo.getExampleCharacterTwo();
            playerEntity.getParty().addToParty(charTwo);
        
        SecureRandom rand = new SecureRandom();
        
        playerEntity.getInventory().setObjectGroupsLimit((rand.nextInt(30)+1));
        playerEntity.getInventory().setItemGroupMaxSize((rand.nextInt(30)+1));
        playerEntity.getInventory().setCoreGroupMaxSize((rand.nextInt(30)+1));
        playerEntity.getInventory().setWeaponGroupMaxSize((rand.nextInt(30)+1));
        playerEntity.getInventory().setArmorGroupMaxSize((rand.nextInt(30)+1));
        playerEntity.getInventory().setAccessoryGroupMaxSize((rand.nextInt(30)+1));
        
        ItemFactory itemFactory = new ItemFactory();
        CoreFactory coreFactory = new CoreFactory();
        WeaponFactory weaponFactory = new WeaponFactory();
        ArmorFactory armorFactory = new ArmorFactory();
        AccessoryFactory accessoryFactory = new AccessoryFactory();
        
        // add example items 
        addObject(playerEntity, itemFactory.getRandomItem());
        addObject(playerEntity, itemFactory.getHealingPotionOne());
        addObject(playerEntity, itemFactory.getHealingPotionMany());
        addObject(playerEntity, itemFactory.getThrowingKnife());
        addObject(playerEntity, itemFactory.getMakeshiftGrenade());
        
        // add example cores 
        addObject(playerEntity, coreFactory.getCoreExample());
        
        // add example weapons 
        addObject(playerEntity, weaponFactory.getTrainingKnife());
        addObject(playerEntity, weaponFactory.getTrainingSword());
        addObject(playerEntity, weaponFactory.getWeaponExample());
        
        // add example armors 
        addObject(playerEntity, armorFactory.getBodyArmorExampleOne());
        addObject(playerEntity, armorFactory.getBodyArmorExampleTwo());
        addObject(playerEntity, armorFactory.getLegArmorExampleOne());
        addObject(playerEntity, armorFactory.getLegArmorExampleTwo());
        addObject(playerEntity, armorFactory.getFootArmorExampleOne());
        addObject(playerEntity, armorFactory.getFootArmorExampleTwo());
        
        // add example accessories 
        addObject(playerEntity, accessoryFactory.getAccessoryExampleOne());
        addObject(playerEntity, accessoryFactory.getAccessoryExampleTwo());
        addObject(playerEntity, accessoryFactory.getAccessoryExampleThree());
        
        
        
        playerEntity.getPartyWallet().updateWalletCapacity();
        
        return playerEntity;
    }
    
    // example 
    public void addObject(PlayerEntity entity, GenericObject object)
    {
        SecureRandom rand = new SecureRandom();
        
        int value = (rand.nextInt(50) + 1);
        
        for(int i = 0; i < value; i++)
        {
            entity.getInventory().addObject(object);
        }
    }
    
    public PlayerEntity getPlayerEntityExampleTwo()
    {
        PlayerEntity playerEntity = new PlayerEntity();
        
        GenericCharacterFactory characterExample = new GenericCharacterFactory();
        GenericCharacter character = characterExample.getExampleCharacterThree();
            character.getGeneralFeatures().setName("ppp dwwd");
            character.getOppositionMethods().setDefeatExp(100);
            character.getOppositionMethods().setDefeatMoney(1000);
            character.getOppositionMethods().addDroppableObject(new WeaponFactory().getTrainingSword());
        
        // MAKE AI SCRIPT
        character.getGeneralFeatures().playerControl(true);
            playerEntity.getParty().addToParty(character);
        
        return playerEntity;
    }
}
