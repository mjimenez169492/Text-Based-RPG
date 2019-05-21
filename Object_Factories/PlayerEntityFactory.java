package Object_Factories;

import Player_Entity.PlayerEntity;
import Generic_Object.GenericObject;

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
        
        playerEntity.getInventory().setObjectGroupsLimit(5);
        playerEntity.getInventory().setItemGroupMaxSize(5);
        playerEntity.getInventory().setCoreGroupMaxSize(5);
        playerEntity.getInventory().setWeaponGroupMaxSize(5);
        playerEntity.getInventory().setArmorGroupMaxSize(5);
        playerEntity.getInventory().setAccessoryGroupMaxSize(5);
        
        ItemFactory itemFactory = new ItemFactory();
        CoreFactory coreFactory = new CoreFactory();
        WeaponFactory weaponFactory = new WeaponFactory();
        ArmorFactory armorFactory = new ArmorFactory();
        AccessoryFactory accessoryFactory = new AccessoryFactory();
        
        addObject(playerEntity, itemFactory.getExperimentalExtract());
        addObject(playerEntity, itemFactory.getSmallDart());
        addObject(playerEntity, itemFactory.getThrowingKnife());
        addObject(playerEntity, itemFactory.getLomanSeriesHealthWeb());
        addObject(playerEntity, itemFactory.getItemExample());
        
        addObject(playerEntity, weaponFactory.getTrainingKnife());
        addObject(playerEntity, weaponFactory.getTrainingSword());
        addObject(playerEntity, weaponFactory.getWeaponExample());
        
        addObject(playerEntity, armorFactory.getArmorExample());
        
        addObject(playerEntity, coreFactory.getCoreExample());
        
        addObject(playerEntity, accessoryFactory.getAccessoryExample());
        
        playerEntity.getPartyWallet().updateWalletCapacity();
        
        return playerEntity;
    }
    
    // example 
    public void addObject(PlayerEntity entity, GenericObject object)
    {
        for(int i = 0; i < 5; i++)
        {
            entity.getInventory().addObject(object);
        }
    }
    
    
    
    
}
