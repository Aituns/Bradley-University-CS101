import java.util.ArrayList;
import java.util.Map;

public class BankTester extends Tester
{
	public BankTester()
	{
		super();
	}

	public void runAll() 
	{
		//
		// Run tests and report
		//
		_testErrorMap.put("constructor", testConstructor());
		_testErrorMap.put("addAccount", testAddAccount());
		_testErrorMap.put("filtering", testFiltered());

		//
		// Report results
		//
		System.out.println("\nBank Testing Summary: ");
		int sum = 0;
		for (Map.Entry<String, Integer> entry : _testErrorMap.entrySet())
		{
			System.out.println("\tTest " + entry.getKey() + ": " + entry.getValue() + " errors.");
			sum += entry.getValue();
		}

		System.out.println("\tTotal number of errors: " + sum);
	}
	
	public int testConstructor()
	{
		System.out.println("Test constructor...");

		int errors = 0;

		Bank b = new Bank();
		if (b.size() != 0)
		{
			emitError("Constructor error [bank]; size should be size zero");
			errors++;
		}
		if (b.getFiltered().size() != 0)
		{
			emitError("Constructor error [bank]; filtered should be size zero");
			errors++;
		}

		return errors;
	}
	
	//
	// Mixes the accounts...
	//
	private Bank constructBank(int numChecking, int numSavings, ArrayList<Account> savings, ArrayList<Account> checking, ArrayList<Account> accounts)
	{
		Bank bank = new Bank();

		int c = 0;
		int s = 0;
		while (c < numChecking && s < numSavings)
		{
			Account newAcct = null;
			if (_rng.nextBoolean())
			{
	         	newAcct = new Checking();
	           	checking.add(newAcct);
	           	c++;
			}
			else
			{
	         	newAcct = new Savings();
	           	savings.add(newAcct);
	           	s++;
			}
            accounts.add(newAcct);
           	bank.addAccount(newAcct);
		}
			
		for ( ; c < numChecking; c++)
		{
         	Account newAcct = new Checking();
            accounts.add(newAcct);
            checking.add(newAcct);
           	bank.addAccount(newAcct);
		}

		for (; s < numSavings; s++)
		{
         	Account newAcct = new Savings();
            accounts.add(newAcct);
         	savings.add(newAcct);
           	bank.addAccount(newAcct);
		}

		return bank;
	}
	
	public int testAddAccount()
	{
		System.out.println("Add accounts...");
		
		int errors = 0;

		//
		// Unique adds
		//
		ArrayList<Account> savings = new ArrayList<Account>();
		ArrayList<Account> checking = new ArrayList<Account>();
		ArrayList<Account> accounts = new ArrayList<Account>();
		Bank bank = constructBank(12, 16, savings, checking, accounts);
		
		if (bank.size() != 28)
		{
			emitError("Bank size: Expected " + 28 + " found " + bank.size());
			errors++;
		}
		
		//
		// Redundant adds
		//
		for (Account acct : accounts)
		{
			if (bank.addAccount(acct))
        	{
    			emitError("Add account succeeded when should have failed");
    			errors++;
        	}
		}

		return errors;
	}
	
	public int testFiltered()
	{
		System.out.println("Test filtering...");
		int errors = 0;

		//
		// Get a bank; then populate with values
		//
		int numSavings = 10;
		int numChecking = 10;
		ArrayList<Account> savings = new ArrayList<Account>();
		ArrayList<Account> checking = new ArrayList<Account>();
		ArrayList<Account> accounts = new ArrayList<Account>();
		Bank bank = constructBank(numChecking, numSavings, savings, checking, accounts);

		for (Account acct : accounts)
		{
			try { acct.deposit(1000); } catch (LinkAccountException e) { e.printStackTrace(); errors++; }
		}

		//
		// All savings should be satisfied
		//
		if (bank.size() != numSavings + numChecking)
		{
			emitError("Filtering: Expected " + (numSavings + numChecking) + " found " + bank.size());
			errors++;
		}
		ArrayList<Account> filtered = bank.getFiltered();
		if (filtered.size() != numSavings)
		{
			emitError("Filtering [filtered]: Expected " + numSavings + " found " + filtered.size());
			errors++;
		}

		//
		// Make the checking satisfied by adding dummy accounts
		//
		for (int i = 0; i < checking.size(); i++)
		{
			checking.get(i).link(savings.get(i));
		}
		filtered = bank.getFiltered();
		if (filtered.size() != accounts.size())
		{
			emitError("Filtering [filtered]: Expected " + accounts.size() + " found " + filtered.size());
			errors++;
		}
		
		
		return errors;
	}
}