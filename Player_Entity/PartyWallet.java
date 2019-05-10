package Player_Entity;

/*
    PartyWallet holds all the money gained by the player party so long as the 
    wallet is big enough to hold it. It is possible to increase the amount of 
    money the player party can have by improving the qualitites of the wallet 
    currently in use or by purchasing a new wallet. 
*/

import Commonly_Used_Methods.StaticMethods;

public class PartyWallet 
{
    // holds wallet size and wallet tier 
    private String size, tier;

    // hold max money wallet can hold and current money held within wallet 
    private double walletCapacity, currentMoney; 

    public PartyWallet()
    {
        // empty constructor
    }
    
    
    
    // START: WALLET ATTRIBUTES
    /*******************************************************************************/
    
    // WALLET SIZE
    
    public enum WalletSizes
    {
        SMALL("Small"), MEDIUM("Medium"), LARGE("Large");
        
        private String walletSize;
        
        WalletSizes(String walletSize)
        {
            this.walletSize = walletSize;
        }
        
        public String getEnumAsString()
        {
            return walletSize;
        }
    }
    
    public void setSize(String size)
    {
        this.size = WalletSizes.valueOf(StaticMethods.stringToEnum(size)).
            getEnumAsString();
    }
    
    public String getSizeString()
    {
        return size;
    }
    
    public WalletSizes getSizeEnum()
    {
        return WalletSizes.valueOf(StaticMethods.stringToEnum(size));
    }
    
    // WALLET SIZE 
    
    
    // WAALET TIER
    
    public enum WalletTiers
    {
        TIER_1("Tier 1"), TIER_2("Tier 2"), TIER_3("Tier 3"), TIER_4("Tier 4"), 
        TIER_5("Tier 5");
        
        private String walletTier;
        
        WalletTiers(String walletTier)
        {
            this.walletTier = walletTier;
        }
        
        public String getEnumAsString()
        {
            return walletTier;
        }
    }
    
    public void setTier(String tier)
    {
        this.tier = WalletTiers.valueOf(StaticMethods.stringToEnum(tier)).getEnumAsString();
    }
    
    public String getTierString()
    {
        return tier;
    }
    
    public WalletTiers getTierEnum()
    {
        return WalletTiers.valueOf(StaticMethods.stringToEnum(tier));
    }
    
    // WALLET TIER
        
    // END: WALLET ATTRIBUTES
    /*******************************************************************************/


    
    // START: ESSENTIAL WALLET METHODS  
    /*******************************************************************************/

    // returns double representing max money wallet can hold 
    public double walletSizeEffect()
    {
        double points = 0;
        
        switch(getSizeEnum())
        {
            case SMALL:
                points = 500;
                    break;
            case MEDIUM:
                points = 2500;
                    break;
            case LARGE:
                points = 4500;
                    break;
        }
        
        return points;
    }
    
    // returns double representing multiplier for wallet
    public double walletTierEffect()
    {
        double points = 0;
        
        switch(getTierEnum())
        {
            case TIER_1:
                points = 0.65;
                    break;
            case TIER_2:
                points = 0.90;
                    break;
            case TIER_3:
                points = 1.10;
                    break;
            case TIER_4:
                points = 1.35;
                    break;
            case TIER_5:
                points = 1.55;
                    break;
        }
        
        return points;
    }
    
    // increase wallet capacity once wallet size or wallet tier is upgraded
    public void addToWalletCapacity()
    {
        walletCapacity += walletSizeEffect() * walletTierEffect();
    }
    
    // update wallet capacity based on wallet size and wallet tier 
    public void updateWalletCapacity()
    {
        if(walletCapacity == 0){
            setSize("Small");   
            setTier("Tier 1");
            addToWalletCapacity();
        }else{
            addToWalletCapacity();
        }
    }
    
    // return capacity for wallet 
    public double getWalletCapacity()
    {
        return walletCapacity; 
    }
    
    // upgrade capacity of wallet from tier to size without supplying arguments 
    public void upgradeWallet()
    {
        // if wallet size is max size then assign true 
        boolean maxWalletSize = (getSizeEnum() == WalletSizes.LARGE);
        
        // if wallet size is max tier then assign true 
        boolean maxWalletTier = (getTierEnum() == WalletTiers.TIER_5);
        
        // if wallet has reached max wallet level then assign true 
        boolean maxWalletLevel = (maxWalletSize == maxWalletTier);
        
        // proceed if wallet has not been upgraded to max level 
        if(!maxWalletLevel)
        {
            // check wallet tier over wallet size since wallet tier has priority 
            // if wallet tier is not max tier then increment tier else increment
            // wallet size and reset wallet tier to tier 1 
            if(getTierEnum() != WalletTiers.TIER_5)
            {
                for(int i = 0; i < WalletTiers.values().length; i++){
                    if(getTierEnum() == WalletTiers.values()[i]){
                        setSize(WalletTiers.values()[i+1].getEnumAsString());
                            updateWalletCapacity();
                                break;
                    }
                }
            }
            else 
            {
                for(int i = 0; i < WalletSizes.values().length; i++){
                    if(getSizeEnum() == WalletSizes.values()[i]){
                        setSize(WalletSizes.values()[i+1].getEnumAsString());
                            setTier("Tier 1");
                                updateWalletCapacity();
                                    break;
                    }
                }
            }
        }
    }
    
    // downgrade capacity of wallet from size to tier without supplying arguments 
    public void downgradeWallet()
    {
        // if wallet size is min size then assign true 
        boolean minWalletSize = (getSizeEnum() == WalletSizes.SMALL);
        
        // if wallet size is min tier then assign true 
        boolean minWalletTier = (getTierEnum() == WalletTiers.TIER_1);
        
        // if wallet has reached min wallet level then assign true 
        boolean minWalletLevel = (minWalletSize == minWalletTier);
        
        // proceed if wallet is not min wallet level 
        if(!minWalletLevel)
        {
            // check wallet tier over wallet size since wallet tier has priority 
            // if wallet tier is not min tier then decrement tier else decrement
            // wallet size and set wallet tier to tier 5 
            if(getTierEnum() != WalletTiers.TIER_1)
            {
                for(int i = 0; i < WalletTiers.values().length; i++){
                    if(getTierEnum() == WalletTiers.values()[i]){
                        setSize(WalletTiers.values()[i-1].getEnumAsString());
                            updateWalletCapacity();
                                break;
                    }
                }
            }
            else 
            {
                for(int i = 0; i < WalletSizes.values().length; i++){
                    if(getSizeEnum() == WalletSizes.values()[i]){
                        setSize(WalletSizes.values()[i-1].getEnumAsString());
                            setTier("Tier 5");
                                updateWalletCapacity();
                                    break;
                    }
                }
            }
        }
    }
    
    public void setCurrentMoney(double currentMoney)
    {
        if(currentMoney < 0.00)
        {
            currentMoney = 0.00;
        }
        else if(currentMoney > walletCapacity)
        {
            currentMoney = walletCapacity;
        }

        this.currentMoney = currentMoney;
    }

    public double getCurrentMoney()
    {
        return currentMoney;
    }

    // returns amount of money that could not be added to wallet 
    public double getMoneyNotAddedToWallet(double money)
    {
        // asiign money not added to party wallet to result
        double result = (currentMoney + money) - walletCapacity; 
        
        // if sum of currentMoney and money to be added to party wallet does not
        // exceed wallet capacity once added then assign result with 0 
        if(result < 0)
        {
            result = 0;
        }
        
        return result;
    }
    
    // END: ESSENTIAL WALLET METHODS  
    /*******************************************************************************/
}