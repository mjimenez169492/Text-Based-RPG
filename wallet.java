/*
	public class partyWallet holds the money gained by the player party so long as it 
	has enough space to do so. Wallet object is expected to be a part of the party 
	menu GUI instead of being a part of a player character 
*/

public class wallet
{	
	// hold valid sizes for a wallet 
	private String[] walletSizes = {"Small", "Medium", "Large"};
	
	// hold valid tiers for a wallet 
	private String[] walletTiers	= {"Tier 1", "Tier 2", "Tier 3"};
	
	// store size of the wallet 
	private String walletSize;
	
	// store tier of the wallet
	private String walletTier;
	
	// hold the capacity of the wallet (how much money it can hold)
	private double walletCapacity;
	
	// money held within the wallet 
	private double money;		
	
	// constructor creates object of public class wallet if two String are supplied 
	public wallet(String walletSize, String walletTier)
	{
		/* 	Issue with: this.instance_variable = instance_variable; 
				if get method is called after object creation, value is called 
				without being appropriately checked with code in set methods */
		
		setWalletSize(walletSize);
		setWalletTier(walletTier);
	}
	
	
	
	
	
	
	// START: WALLET ATTRIBUTES
	/********************************************************************************/
	
	// set the size for the wallet 
	public void setWalletSize(String walletSize)
	{
		if(walletSize != null)
		{
			// for loop determines whether wallet size matches element in walletSizes array 
			for(String element : walletSizes)
			{
				// if wallet size is valid then assign boolean with true 
				if(walletSize.equals(element))
				{
					this.walletSize = walletSize;
						break;
				}
			}
		}
	}
	
	// get size of wallet
	public String getWalletSize()
	{
		return walletSize;
	}
	
	// set tier that wallet belongs to 
	public void setWalletTier(String walletTier)
	{
		if(walletTier != null)
		{
			// for loop determines whether wallet tier matches element in walletTier array 
			for(String element : walletTiers)
			{
				// if core tier is valid then assign boolean with true 
				if(walletTier.equals(element))
				{
					this.walletTier = walletTier;
						break;
				}
			}
		}
	}
	
	// get the tier for the wallet
	public String getWalletTier()
	{
		return walletTier;
	}
	
	// get the capacity of the wallet (how much money it can hold )
	public double getWalletCapacity()
	{
		// wallet capacity based on wallet size and wallet tier which should not be null 
		if(getWalletSize() != null && getWalletTier() != null)
		{
			if(getWalletSize().equals("Small"))
			{
				if(getWalletTier().equals("Tier 1"))
				{
					walletCapacity = 3000.0;
				}
				else if(getWalletTier().equals("Tier 2"))
				{
					walletCapacity = 6000.0;
				}
				else if(getWalletTier().equals("Tier 3"))
				{
					walletCapacity = 10000.0;
				}
			}
			else if(getWalletSize().equals("Medium"))
			{
				if(getWalletTier().equals("Tier 1"))
				{
					walletCapacity = 30000.0;
				}
				else if(getWalletTier().equals("Tier 2"))
				{
					walletCapacity = 60000.0;
				}
				else if(getWalletTier().equals("Tier 3"))
				{
					walletCapacity = 100000.0;
				}
			}
			else if(getWalletSize().equals("Large"))
			{
				if(getWalletTier().equals("Tier 1"))
				{
					walletCapacity = 300000.0;
				}
				else if(getWalletTier().equals("Tier 2"))
				{
					walletCapacity = 600000.0;
				}
				else if(getWalletTier().equals("Tier 3"))
				{
					walletCapacity = 1000000.0;
				}
			}
		}
		return walletCapacity;
	}
	
	// END: WALLET ATTRIBUTES
	/********************************************************************************/
	
	
	
	
	
	
	// START: MONEY RELATED METHODS
	/********************************************************************************/
	
	// set the amount of money that is inside the wallet 
	public void setMoney(double money)
	{
		if(money < 0.0)
		{
			money = 0.0;
		}
		else if(money > getWalletCapacity())
		{
			money = getWalletCapacity();
		}
		
		this.money = money;
	}
	
	// get the money that is inside the wallet 
	public double getMoney()
	{
		return money;
	}
	
	// END: MONEY RELATED METHODS
	/********************************************************************************/
}