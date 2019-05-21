package Object_Factories;

import Player_Entity.PlayerEntity;
import Generic_Object.GenericObject;
import java.security.SecureRandom;

public class PlayerEntityFactory 
{
    public PlayerEntity getPlayerEntityExample()
    {
        PlayerEntity playerEntity = new PlayerEntity();
        
        GenericCharacterFactory characterOne = new GenericCharacterFactory();
        
            playerEntity.getParty().addToParty(characterOne.getExampleCharacter());
        
        GenericCharacterFactory characterTwo = new GenericCharacterFactory();
        
            playerEntity.getParty().addToParty(characterTwo.getExampleCharacter());
        
        GenericCharacterFactory characterThree = new GenericCharacterFactory();
        
            playerEntity.getParty().addToParty(characterThree.getExampleCharacter());
        
        GenericCharacterFactory characterFour = new GenericCharacterFactory();
        
            playerEntity.getParty().addToParty(characterFour.getExampleCharacter());
        
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
