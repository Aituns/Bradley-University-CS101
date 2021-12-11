/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
public class Account // TODO: refine this to establish proper relationships among accounts.
{
    protected double _balance;
    public double getBalance() { return _balance; }
    
    protected String _name;
    public String getName() { return _name; }
    
    protected Account _link;
    public Account getLink() { return _link; }

	//
    // TODO: Constructors and other required methods.
    //
    
    //
    // Link this account with the given account;
    //  Cannot link accounts if this equals linkAcct
    //  Otherwise:
    //     Unlink this account, if it is linked
    //     Link the new accounts in BOTH directions
    //
    public boolean link(Account linkAcct)
    {
		// TODO
    }

    //
    // Take $amt from this account, if available.
    //
    // Specifically,
    //   If amt is available in this account, withdraw
    //   If amt is not available,
    //      Determine if it is available, in total, from this and the linked account.
    //      If so, take from both.
    //      If not, throw an exception and leave account balances unmodified.
    // 
    public void withdraw(double amt) throws InsufficientFundsException
    {
        // TODO
    }
    
    //
    // Unlink the accounts in BOTH directions
    //
    public void unlink()
    {
		// TODO
    }
       
    @Override
    public boolean equals(Object obj)
    {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof Account)) return false;

    	Account that = (Account)obj;
    	
    	if (Math.abs(_balance - that._balance) > 0.001) return false; 

    	if (!_name.equals(that._name)) return false;
    	
    	if (_link != that._link) return false;
    	
    	return this == obj;
    }
    
    @Override
    public String toString()
    {
    	String retS = "";
    	
    	retS += "account: " + _name + "\n";
    	retS += "\tBalance: " + _balance + "\n";
    	retS += "\tLink account name: " + _link._name;
    	
    	return retS;
    }
}