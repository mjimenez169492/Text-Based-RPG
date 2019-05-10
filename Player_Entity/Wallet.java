package Player_Entity;

/*
    Wallet holds all of the money gained by a player party so long as the wallet 
    is big enough to hold it. It is possible to increase the amount of money the
    player party can have by improving the qualitites of wallet currently in use 
    or by purchasing a new wallet. 
*/

import Universally_Used_Methods.StaticMethods;

public class Wallet 
{
    // holds wallet size and wallet tier 
    private String size, tier;

    // hold max money wallet can hold and current money held within wallet 
    private double walletCapacity, currentMoney; 

    
    
    // START: WALLET ATTRIBUTES
    /*******************************************************************************/
    
    public enum ValidWalletSizes
    {
        SMALL, MEDIUM, LARGE;
    }
    
    public String getWalletSizeStringUsingString(String size)
    {
        if(size != null)
        {
            switch(ValidWalletSizes.valueOf(StaticMethods.stringToEnum(size)))
            {
                case SMALL:
                    size = "Small";
                        break;
                case MEDIUM:
                    size = "Medium";
                        break;
                case LARGE:
                    size = "Large";
                        break;
            }
        }
        
        return size;
    }
    
    public String getWalletSizeStringUsingEnum(ValidWalletSizes size)
    {
        String result = null;
        
        if(size != null)
        {
            switch(size)
            {
                case SMALL:
                    result = "Small";
                        break;
                case MEDIUM:
                    result = "Medium";
                        break;
                case LARGE:
                    result = "Large";
                        break;
            }
        }
        
        return result;
    }
    
    public ValidWalletSizes getWalletSizeEnumUsingString(String size)
    {
        ValidWalletSizes result = null;
        
        if(size != null)
        {
            result = ValidWalletSizes.valueOf(StaticMethods.stringToEnum(size));
        }
        
        return result;
    }
    
    public void setSize(String size)
    {
        this.size = getWalletSizeStringUsingString(size);
    }
    
    public String getSize()
    {
        return size;
    }
    
    public enum ValidWalletTiers
    {
        TIER_1, TIER_2, TIER_3, TIER_4, TIER_5;
    }
    
    public String getWalletTierStringUsingString(String tier)
    {
        if(tier != null)
        {
            switch(ValidWalletTiers.valueOf(StaticMethods.stringToEnum(tier)))
            {
                case TIER_1:
                    tier = "Tier 1";
                        break;
                case TIER_2:
                    tier = "Tier 2";
                        break;
                case TIER_3:
                    tier = "Tier 3";
                        break;
                case TIER_4:
                    tier = "Tier 4";
                        break;
                case TIER_5:
                    tier = "Tier 5";
                        break;
            }
        }
        
        return tier;
    }
    
    public String getWalletTierStringUsingEnum(ValidWalletTiers tier)
    {
        String result = null;
        
        if(tier != null)
        {
            switch(tier)
            {
                case TIER_1:
                    result = "Tier 1";
                        break;
                case TIER_2:
                    result = "Tier 2";
                        break;
                case TIER_3:
                    result = "Tier 3";
                        break;
                case TIER_4:
                    result = "Tier 4";
                        break;
                case TIER_5:
                    result = "Tier 5";
                        break;
            }
        }
        
        return result;
    }
    
    public ValidWalletTiers getWalletTierEnumUsingString(String size)
    {
        ValidWalletTiers result = null;
        
        if(size != null)
        {
            result = ValidWalletTiers.valueOf(StaticMethods.stringToEnum(size));
        }
        
        return result;
    }
    
    public void setTier(String tier)
    {
        this.tier = getWalletTierStringUsingString(tier);
    }
    
    public String getTier()
    {
        return tier;
    }
        
    // END: WALLET ATTRIBUTES
    /*******************************************************************************/


    
    // START: ESSENTIAL WALLET METHODS  
    /*******************************************************************************/

    // returns double representing max money wallet can hold 
    public double effectOfWalletSize()
    {
        double points = 0;
        
        switch(ValidWalletSizes.valueOf(StaticMethods.stringToEnum(size)))
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
    public double effectOfWalletTier()
    {
        double points = 0;
        
        switch(ValidWalletTiers.valueOf(StaticMethods.stringToEnum(tier)))
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
        walletCapacity += effectOfWalletSize() * effectOfWalletTier();
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
        boolean maxWalletSize = (getWalletSizeEnumUsingString(size) == ValidWalletSizes.LARGE);
        
        // if wallet size is max tier then assign true 
        boolean maxWalletTier = (getWalletTierEnumUsingString(tier) == ValidWalletTiers.TIER_5);
        
        // if wallet has reached max wallet level then assign true 
        boolean maxWalletLevel = (maxWalletSize == maxWalletTier);
        
        // proceed if wallet has not been upgraded to max level 
        if(!maxWalletLevel)
        {
            // check wallet tier over wallet size since wallet tier has priority 
            // if wallet tier is not max tier then increment tier else increment
            // wallet size and reset wallet tier to tier 1 
            if(getWalletTierEnumUsingString(tier) != ValidWalletTiers.TIER_5)
            {
                for(int i = 0; i < ValidWalletTiers.values().length; i++){
                    if(getWalletTierEnumUsingString(tier) == ValidWalletTiers.values()[i]){
                        setSize(getWalletTierStringUsingEnum(ValidWalletTiers.values()[i+1]));
                            updateWalletCapacity();
                                break;
                    }
                }
            }
            else 
            {
                for(int i = 0; i < ValidWalletSizes.values().length; i++){
                    if(getWalletSizeEnumUsingString(size) == ValidWalletSizes.values()[i]){
                        setSize(getWalletSizeStringUsingEnum(ValidWalletSizes.values()[i+1]));
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
        boolean minWalletSize = (getWalletSizeEnumUsingString(size) == ValidWalletSizes.SMALL);
        
        // if wallet size is min tier then assign true 
        boolean minWalletTier = (getWalletTierEnumUsingString(tier) == ValidWalletTiers.TIER_1);
        
        // if wallet has reached min wallet level then assign true 
        boolean minWalletLevel = (minWalletSize == minWalletTier);
        
        // proceed if wallet is not min wallet level 
        if(!minWalletLevel)
        {
            // check wallet tier over wallet size since wallet tier has priority 
            // if wallet tier is not min tier then decrement tier else decrement
            // wallet size and set wallet tier to tier 5 
            if(getWalletTierEnumUsingString(tier) != ValidWalletTiers.TIER_1)
            {
                for(int i = 0; i < ValidWalletTiers.values().length; i++){
                    if(getWalletTierEnumUsingString(tier) == ValidWalletTiers.values()[i]){
                        setSize(getWalletTierStringUsingEnum(ValidWalletTiers.values()[i-1]));
                            updateWalletCapacity();
                                break;
                    }
                }
            }
            else 
            {
                for(int i = 0; i < ValidWalletSizes.values().length; i++){
                    if(getWalletSizeEnumUsingString(size) == ValidWalletSizes.values()[i]){
                        setSize(getWalletSizeStringUsingEnum(ValidWalletSizes.values()[i-1]));
                            setTier("Tier 5");
                                updateWalletCapacity();
                                    break;
                    }
                }
            }
        }
    }
    
    // sets amount of money that exists in the wallet 
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

    // gets amount of money that exists in the wallet 
    public double getCurrentMoney()
    {
        return currentMoney;
    }

    // returns the amount of money that could not be added to the wallet 
    public double moneyNotAddedToWallet(double money)
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