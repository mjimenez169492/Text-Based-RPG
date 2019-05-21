package Object_Factories;

import Player_Entity.PlayerEntity;
import Generic_Object.GenericObject;
import java.security.SecureRandom;
import Generic_Character.GenericCharacter;

public class PlayerEntityFactory 
{
    public PlayerEntity getPlayerEntityExample()
    {
        PlayerEntity playerEntity = new PlayerEntity();
        
        GenericCharacterFactory characterOne = new GenericCharacterFactory();
        GenericCharacter charOne = characterOne.getExampleCharacter();
        charOne.getGeneralFeatures().setName("dv");
            playerEntity.getParty().addToParty(charOne);
        
        GenericCharacterFactory characterTwo = new GenericCharacterFactory();
        GenericCharacter charTwo = characterTwo.getExampleCharacter();
        charTwo.getGeneralFeatures().setName("ppp dwwd");
            playerEntity.getParty().addToParty(charTwo);
        
        GenericCharacterFactory characterThree = new GenericCharacterFactory();
        GenericCharacter charThree = characterThree.getExampleCharacter();
        charTwo.getGeneralFeatures().setName("12345678901234567890123456");
            playerEntity.getParty().addToParty(charThree);
        
        GenericCharacterFactory characterFour = new GenericCharacterFactory();
        GenericCharacter charFour = characterFour.getExampleCharacter();
        charFour.getGeneralFeatures().setName("thte wdhd eh");
            playerEntity.getParty().addToParty(charFour);
        
        //GenericCharacterFactory characterFive = new GenericCharacterFactory();
        
        //    playerEntity.getParty().addToParty(characterFive.getExampleCharacter());
            
        playerEntity.getCurrentLocation().setStoryPart("Tutorial");
        playerEntity.getCurrentLocation().setCentralHub("Lowlands");
        playerEntity.getCurrentLocation().setMajorLocation("Bunker 627");
        playerEntity.getCurrentLocation().setMinorLocation("Entrance");
        playerEntity.getCurrentLocation().setIntraLocation("Training Area");
        
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
        
        addObject(playerEntity, itemFactory.getRandomItem());
        addObject(playerEntity, itemFactory.getSmallDart());
        addObject(playerEntity, itemFactory.getThrowingKnife());
        addObject(playerEntity, itemFactory.getLomanSeriesHealthWeb());
        addObject(playerEntity, itemFactory.getItemExample());
        
        addObject(playerEntity, weaponFactory.getTrainingKnife());
        addObject(playerEntity, weaponFactory.getTrainingSword());
        addObject(playerEntity, weaponFactory.getWeaponExample());
        
        addObject(playerEntity, armorFactory.getArmorExample());
        
        addObject(playerEntity, coreFactory.getCoreExample());
        
        //addObject(playerEntity, accessoryFactory.getAccessoryExample());
        
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
    
    
    
    
}
