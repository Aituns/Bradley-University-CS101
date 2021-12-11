/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
import java.util.Map;

public class AccountTester extends Tester
{
	public AccountTester()
	{
		super();
	}

	public void runAll() 
	{
		//
		// Run tests and report
		//
		_testErrorMap.put("constructor", testConstructor());
		_testErrorMap.put("overloaded constructor", testOverloadedConstructor());
		_testErrorMap.put("linking", testLinking());
		_testErrorMap.put("deposit", testDeposit());
		_testErrorMap.put("withdrawal", testWithdrawal());

		//
		// Report results
		//
		System.out.println("\nAccount Testing Summary: ");
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

		System.out.println("\tSavings");
		Savings s = new Savings();
		if (s.getLink() != null)
		{
			emitError("Constructor error [savings]; link null expected");
			errors++;
		}
		if (s.getBalance() > 0)
		{
			emitError("Constructor error [savings]; 0 balance expected");
			errors++;
		}
		if (!s.getName().equals(""))
		{
			emitError("Constructor error [savings]; empty name (\"\") expected");
			errors++;
		}

		System.out.println("\tChecking");
		Checking c = new Checking();
		if (c.getLink() != null)
		{
			emitError("Constructor error [checking]; link null expected");
			errors++;
		}
		if (c.getBalance() > 0)
		{
			emitError("Constructor error [checking]; 0 balance expected");
			errors++;
		}
		if (!c.getName().equals(""))
		{
			emitError("Constructor error [checking]; empty name (\"\") expected");
			errors++;
		}

		System.out.println("\tCapped Checking");
		c = new CappedChecking();
		if (c.getLink() != null)
		{
			emitError("Constructor error [capped checking]; link null expected");
			errors++;
		}
		if (c.getBalance() > 0)
		{
			emitError("Constructor error [capped checking]; 0 balance expected");
			errors++;
		}
		if (!c.getName().equals(""))
		{
			emitError("Constructor error [capped checking]; empty name (\"\") expected");
			errors++;
		}

		return errors;
	}

	int testOverloadedConstructor()
	{
		System.out.println("Test overloaded constructor...");

		int errors = 0;

		System.out.println("\tSavings");
		String name = "savings";
		Savings s = new Savings(name);
		if (s.getLink() != null)
		{
			emitError("Overloaded constructor error [savings]; link null expected");
			errors++;
		}
		if (s.getBalance() > 0)
		{
			emitError("Overloaded constructor error [savings]; 0 balance expected");
			errors++;
		}
		if (!s.getName().equals(name))
		{
			emitError("Overloaded constructor error [savings]; name (" + name +  ") expected");
			errors++;
		}

		System.out.println("\tChecking");
		name = "checking";
		Checking c = new Checking(name);
		if (c.getLink() != null)
		{
			emitError("Overloaded constructor error [checking]; link null expected");
			errors++;
		}
		if (c.getBalance() > 0)
		{
			emitError("Overloaded constructor error [checking]; 0 balance expected");
			errors++;
		}
		if (!c.getName().equals(name))
		{
			emitError("Overloaded constructor error [checking]; name (" + name + ") expected");
			errors++;
		}

		System.out.println("\tCapped Checking");
		name = "capped-checking";
		c = new CappedChecking(name);
		if (c.getLink() != null)
		{
			emitError("Overloaded constructor error [capped checking]; link null expected");
			errors++;
		}
		if (c.getBalance() > 0)
		{
			emitError("Overloaded constructor error [capped checking]; 0 balance expected");
			errors++;
		}
		if (!c.getName().equals(name))
		{
			emitError("Overloaded constructor error [capped checking]; name (" + name + ") expected");
			errors++;
		}

		return errors;
	}

	public int testLinking()
	{
		System.out.println("Test account linking...");

		int errors = 0;
		//
		// Cannot link with null
		//
		System.out.println("\tnull Savings");
		Savings s = new Savings();
		if (s.getLink() != null)
		{
			emitError("Link error; null expected");
			errors++;
		}
		if (s.link(null))
		{
			emitError("Link error [savings]; null accepted");
			errors++;
		}

		System.out.println("\tnull Checking");
		Checking c = new Checking();
		if (c.getLink() != null)
		{
			emitError("Link error; null expected");
			errors++;
		}
		if (c.link(null))
		{
			emitError("Link error [checking]; null accepted");
			errors++;
		}

		//
		// Cannot link with same type
		//
		System.out.println("\tSame Type");
		if (s.link(new Savings()))
		{
			emitError("Link error; savings account cannot link with a savings account");
			errors++;
		}

		if (c.link(new Checking()))
		{
			emitError("Link error; checking account cannot link with checking account");
			errors++;
		}

		//
		// Cannot link with yourself
		//
		System.out.println("\tCyclic Linking");
		if (s.link(s))
		{
			emitError("Link error; savings account cannot link with itself");
			errors++;
		}

		if (c.link(c))
		{
			emitError("Link error; checking account cannot link with itself");
			errors++;
		}
		
		//
		// Check unlinking of non-linked accounts
		//
		System.out.println("\tUnlinking an unlinked account");
		
		s = new Savings();
		try { s.unlink(); } catch (NullPointerException e)
		{
			emitError("Link error; savings account unlink on unlinked account failed.");
			errors++;
		}

		c = new Checking();
		try { c.unlink(); } catch (NullPointerException e)
		{
			emitError("Link error; savings account unlink on unlinked account failed.");
			errors++;
		}

		//
		// Verify links are unlinked if new links are given
		//
		System.out.println("\tLink / Unlink");
		Savings s1 = new Savings();
		Savings s2 = new Savings();
		Checking c1 = new Checking();
		Checking c2 = new Checking();

		if (!s1.link(c1))
		{
			emitError("Link error; returned false when link should be successful");
			errors++;
		}
		if (!s1.link(c2))
		{
			emitError("Link error; returned false when link should be successful");
			errors++;
		}

		if (!s1.getLink().equals(c2))
		{
			emitError("Link error; unlinking 1");
			errors++;
		}
		if (!c2.getLink().equals(s1))
		{
			emitError("Link error; unlinking 2");
			errors++;
		}
		if (c1.getLink() != null)
		{
			emitError("Link error; unlinking 3");
			errors++;
		}

		s1 = new Savings();
		s2 = new Savings();
		c1 = new Checking();
		c2 = new Checking();

		c1.link(s1);
		c1.link(s2);

		if (!c1.getLink().equals(s2))
		{
			emitError("Link error; unlinking 4");
			errors++;
		}
		if (!s2.getLink().equals(c1))
		{
			emitError("Link error; unlinking 5");
			errors++;
		}
		if (s1.getLink() != null)
		{
			emitError("Link error; unlinking 6");
			errors++;
		}
		
		//
		// Long chaining test
		//
		System.out.println("\tChaining Link / Unlink test");
		s1 = new Savings();
		s2 = new Savings();
		c1 = new Checking();
		c2 = new Checking();
		Checking c3 = new Checking();
		
		c1.link(s1);
		s1.link(c2);
		c2.link(s2);
		s2.link(c3);
		if (c1.getLink() != null)
		{
			emitError("Link error; chain 1");
			errors++;
		}
		if (s1.getLink() != null)
		{
			emitError("Link error; chain 2");
			errors++;
		}
		if (c2.getLink() != null)
		{
			emitError("Link error; chain 3");
			errors++;
		}
		if (!s2.getLink().equals(c3))
		{
			emitError("Link error; chain 4");
			errors++;
		}
		if (!c3.getLink().equals(s2))
		{
			emitError("Link error; chain 5");
			errors++;
		}

		return errors;
	}

	public int testDeposit()
	{
		System.out.println("Testing deposit...");

		int errors = 0;

		//
		// Simple test on a savings account
		//
		System.out.println("\tSimple Savings");
		Savings s = new Savings();
		double sum = 0;
		for (int i = 0; i < 100; i++)
		{
			int randValue = _rng.nextInt(999) + 1;
			sum += randValue;
			try {
				s.deposit(randValue);
			} catch (LinkAccountException e) {
				e.printStackTrace();
				errors++;
			}

			if (s.getBalance() != sum)
			{
				emitError("Simple Savings: Expected " + sum + " found " + s.getBalance());
				errors++;
			}
		}

		//
		// Simple test on a non-capped Checking account
		//
		System.out.println("\tSimple Checking");
		Checking c = new Checking();
		sum = 0;
		for (int i = 0; i < 100; i++)
		{
			int randValue = _rng.nextInt(999) + 1;
			sum += randValue;
			try {
				c.deposit(randValue);
			} catch (LinkAccountException e) {
				e.printStackTrace();
				errors++;
			}

			if (c.getBalance() != sum)
			{
				emitError("Simple Checking: Expected " + sum + " found " + c.getBalance());
				errors++;
			}
		}

		//
		// Capped checking account
		//
		System.out.println("\tCapped Checking (max not achieved)");
		CappedChecking cc = new CappedChecking();
		sum = 0;
		for (int i = 0; i < 100; i++)
		{
			int randValue = _rng.nextInt(999) + 1;

			if (cc.getBalance() + randValue > CappedChecking.MAX_AMOUNT) break;

			sum += randValue;
			try {
				cc.deposit(randValue);
			} catch (LinkAccountException e) {
				e.printStackTrace();
				errors++;
			}

			if (cc.getBalance() != sum)
			{
				emitError("Simple Savings: Expected " + sum + " found " + cc.getBalance());
				errors++;
			}
		}

		//
		// Capped checking account (with exceptions)
		//
		System.out.println("\tCapped Checking Eclipsing the Max");
		cc = new CappedChecking();
		try {
			cc.deposit(CappedChecking.MAX_AMOUNT);
		} catch (LinkAccountException e1) {
			e1.printStackTrace();
			errors++;
		}

		for (int i = 0; i < 10; i++)
		{
			int randValue = _rng.nextInt(999) + 1;

			try
			{
				cc.deposit(randValue);

				emitError("Capped Deposit: Expected LinkAccountError not thrown");
				errors++;
			}
			catch (LinkAccountException e) {}
		}

		//
		// Linked Savings and Checking
		//
		System.out.println("\tLinked Savings and Checking");
		s = new Savings();
		c = new Checking();

		s.link(c);

		double sSum = 0;
		double cSum = 0;
		for (int i = 0; i < 100; i++)
		{
			int cRandValue = _rng.nextInt(999) + 1;
			cSum += cRandValue;

			int sRandValue = _rng.nextInt(999) + 1;
			sSum += sRandValue;

			try {
				c.deposit(cRandValue);
				s.deposit(sRandValue);
			} catch (LinkAccountException e) {
				e.printStackTrace();
				errors++;
			}

			if (c.getBalance() != cSum)
			{
				emitError("Linked Savings and [Checking]: Expected " + cSum + " found " + c.getBalance());
				errors++;
			}

			if (s.getBalance() != sSum)
			{
				emitError("Linked [Savings] and Checking: Expected " + sSum + " found " + s.getBalance());
				errors++;
			}
		}

		//
		// Linked Savings and Checking (other direction)
		//
		System.out.println("\tLinked Savings and Checking");
		s = new Savings();
		c = new Checking();

		c.link(s);

		sSum = 0;
		cSum = 0;
		for (int i = 0; i < 100; i++)
		{
			int cRandValue = _rng.nextInt(999) + 1;
			cSum += cRandValue;

			int sRandValue = _rng.nextInt(999) + 1;
			sSum += sRandValue;

			try {
				c.deposit(cRandValue);
				s.deposit(sRandValue);
			} catch (LinkAccountException e) {
				e.printStackTrace();
				errors++;
			}

			if (c.getBalance() != cSum)
			{
				emitError("Linked Savings and [Checking]: Expected " + cSum + " found " + c.getBalance());
				errors++;
			}

			if (s.getBalance() != sSum)
			{
				emitError("Linked [Savings] and Checking: Expected " + sSum + " found " + s.getBalance());
				errors++;
			}
		}

		//
		// Linked Savings and Checking
		//
		System.out.println("\tLinked Savings and (Capped) Checking");
		s = new Savings();
		c = new CappedChecking();

		s.link(c);

		sSum = 0;
		cSum = 0;
		for (int i = 0; i < 100; i++)
		{
			int cRandValue = _rng.nextInt(999) + 1;
			int sRandValue = _rng.nextInt(999) + 1;

			if (c.getBalance() + cRandValue <= CappedChecking.MAX_AMOUNT)
			{
				cSum += cRandValue;
				sSum += sRandValue;

				try {
					c.deposit(cRandValue);
					s.deposit(sRandValue);
				} catch (LinkAccountException e) {
					e.printStackTrace();
					errors++;
				}

				if (c.getBalance() != cSum)
				{
					emitError("Linked Savings and [Checking]: Expected " + cSum + " found " + c.getBalance());
					errors++;
				}

				if (s.getBalance() != sSum)
				{
					emitError("Linked [Savings] and Checking: Expected " + sSum + " found " + s.getBalance());
					errors++;
				}
			}
			else if (c.getBalance() + cRandValue > CappedChecking.MAX_AMOUNT)
			{
				sSum += sRandValue + (c.getBalance() + cRandValue - CappedChecking.MAX_AMOUNT);

				try {
					c.deposit(cRandValue);
					s.deposit(sRandValue);
				} catch (LinkAccountException e) {
					e.printStackTrace();
					errors++;
				}

				if (c.getBalance() != CappedChecking.MAX_AMOUNT)
				{
					emitError("Linked Savings and [Checking]: Expected " + cSum + " found " + c.getBalance());
					errors++;
				}

				if (s.getBalance() != sSum)
				{
					emitError("Linked [Savings] and Checking: Expected " + sSum + " found " + s.getBalance());
					errors++;
				}
			}
			else if (c.getBalance() >= CappedChecking.MAX_AMOUNT)
			{
				sSum += sRandValue + cRandValue;

				try {
					c.deposit(cRandValue);
					s.deposit(sRandValue);
				} catch (LinkAccountException e) {
					e.printStackTrace();
					errors++;
				}

				if (c.getBalance() != CappedChecking.MAX_AMOUNT)
				{
					emitError("Linked Savings and [Checking]: Expected " + CappedChecking.MAX_AMOUNT + " found " + c.getBalance());
					errors++;
				}

				if (s.getBalance() != sSum)
				{
					emitError("Linked [Savings] and Checking: Expected " + sSum + " found " + s.getBalance());
					errors++;
				}
			}
			else
			{
				System.err.println("This shouldn't happen...");
			}
		}

		return errors;
	}


	public int testWithdrawal()
	{
		System.out.println("Testing withdrawal...");

		int errors = 0;

		//
		// Simple test on a savings account
		//
		System.out.println("\tSimple Savings");
		Savings s = new Savings();

		double balance = 10000;
		try { s.deposit(balance); } catch (LinkAccountException e1) { e1.printStackTrace(); errors++; }

		for (int i = 0; i < 100; i++)
		{
			int randValue = _rng.nextInt(999) + 1;

			if (balance - randValue < 0) break;

			balance -= randValue;
			try {
				s.withdraw(randValue);
			} catch (InsufficientFundsException e) {
				e.printStackTrace();
				errors++;
			}

			if (s.getBalance() != balance)
			{
				emitError("Simple Savings [savings]: Expected " + balance + " found " + s.getBalance());
				errors++;
			}
		}

		//
		// Simple test on a checking account
		//
		System.out.println("\tSimple Checking");
		Checking c = new Checking();

		balance = 10000;
		try { c.deposit(balance); } catch (LinkAccountException e) { e.printStackTrace(); errors++; }

		for (int i = 0; i < 100; i++)
		{
			int randValue = _rng.nextInt(999) + 1;

			if (balance - randValue < 0) break;

			balance -= randValue;
			try {
				c.withdraw(randValue);
			} catch (InsufficientFundsException e) {
				e.printStackTrace();
				errors++;
			}

			if (c.getBalance() != balance)
			{
				emitError("Simple Checking [withdraw]: Expected " + balance + " found " + s.getBalance());
				errors++;
			}
		}

		//
		// Simple test on capped checking account
		//
		System.out.println("\tCapped Checking");
		c = new CappedChecking();

		balance = CappedChecking.MAX_AMOUNT;
		try { c.deposit(CappedChecking.MAX_AMOUNT); } catch (LinkAccountException e) { e.printStackTrace(); errors++;}

		for (int i = 0; i < 100; i++)
		{
			int randValue = _rng.nextInt(999) + 1;

			if (balance - randValue < 0) break;

			balance -= randValue;
			try {
				c.withdraw(randValue);
			} catch (InsufficientFundsException e) {
				e.printStackTrace();
				errors++;
			}

			if (c.getBalance() != balance)
			{
				emitError("Simple Checking [withdraw]: Expected " + balance + " found " + s.getBalance());
				errors++;
			}
		}

		//
		// Insufficient Funds Tests
		//
		System.out.println("\tInsufficient Funds");

		// below 0 test
		s = new Savings();
		balance = 500;
		try { s.deposit(balance); } catch (LinkAccountException e) { e.printStackTrace(); errors++;}
		for (int i = 0; i < 100; i++)
		{
			int randValue = _rng.nextInt(999) + 1;

			if (balance - randValue < 0)
			{
				try
				{
					s.withdraw(randValue);
					emitError("Savings [withdraw]: Expected exception to be thrown");
					errors++;
				} catch (InsufficientFundsException e) {}
			}
		}
		
		// below MIN_AMOUNT test 
		s = new Savings();
		balance = 500;
		try { s.deposit(balance); } catch (LinkAccountException e) { e.printStackTrace(); errors++;}
		for (int i = 0; i < 20; i++)
		{
			int randValue = _rng.nextInt(999) + 1;

			if (balance - randValue < Savings.MIN_AMOUNT)
			{
				try
				{
					s.withdraw(randValue);
					emitError("Savings [withdraw]: Expected exception to be thrown");
					errors++;
				} catch (InsufficientFundsException e) {}
			}
		}
		
		c = new Checking();
		try { c.deposit(balance); } catch (LinkAccountException e) { e.printStackTrace(); errors++;}
		for (int i = 0; i < 100; i++)
		{
			int randValue = _rng.nextInt(999) + 1;

			if (balance - randValue < 0)
			{
				try
				{
					c.withdraw(randValue);
					emitError("Checking [withdraw]: Expected exception to be thrown");
					errors++;
				} catch (InsufficientFundsException e) {}
			}
		}

		c = new CappedChecking();
		try { c.deposit(balance); } catch (LinkAccountException e) { e.printStackTrace(); errors++;}
		for (int i = 0; i < 100; i++)
		{
			int randValue = _rng.nextInt(999) + 1;

			if (balance - randValue < 0)
			{
				try
				{
					c.withdraw(randValue);
					emitError("Capped Checking [withdraw]: Expected exception to be thrown");
					errors++;
				} catch (InsufficientFundsException e) {}
			}
		}

		//
		// Linked accounts withdrawal (basic savings and checking)
		//
		System.out.println("\tLinking Accounts");

		//
		// Test where MIN_AMOUNT maintained in Savings
		//
		s = new Savings();
		c = new Checking();
        s.link(c);
		
		try {
			s.deposit(100);
			c.deposit(1000);
		} catch (LinkAccountException e) { e.printStackTrace(); errors++;}
		
		try { s.withdraw(50); } catch (InsufficientFundsException e) { e.printStackTrace(); errors++;}
		
		if (!doubleEquals(s.getBalance(), 100))
		{
			emitError("Savings and Linked Checking [withdraw]: Expected " + 100 + " found " + s.getBalance());
			errors++;
		}
		if (!doubleEquals(c.getBalance(), 950))
		{
			emitError("Savings and Linked Checking [withdraw]: Expected " + 950 + " found " + c.getBalance());
			errors++;
		}

		//
		// Insufficient funds even when linked
		//
		s = new Savings();
		c = new Checking();
        s.link(c);
		
		try {
			s.deposit(1000);
			c.deposit(1000);
		} catch (LinkAccountException e) { e.printStackTrace(); errors++;}
		
		try { s.withdraw(2500); } catch (InsufficientFundsException e) { }
		
		if (!doubleEquals(s.getBalance(), 1000))
		{
			emitError("Savings and Linked Checking [withdraw]: Expected " + 1000 + " found " + s.getBalance());
			errors++;
		}
		if (!doubleEquals(c.getBalance(), 1000))
		{
			emitError("Savings and Linked Checking [withdraw]: Expected " + 1000 + " found " + c.getBalance());
			errors++;
		}
		
		// Insufficient 2
		s = new Savings();
		c = new Checking();
        s.link(c);
		
		try {
			s.deposit(1000);
			c.deposit(1000);
		} catch (LinkAccountException e) { e.printStackTrace(); errors++; }
		
		try { c.withdraw(2500); } catch (InsufficientFundsException e) { }
		
		if (!doubleEquals(s.getBalance(), 1000))
		{
			emitError("Savings and Linked Checking [withdraw]: Expected " + 1000 + " found " + s.getBalance());
			errors++;
		}
		if (!doubleEquals(c.getBalance(), 1000))
		{
			emitError("Savings and Linked Checking [withdraw]: Expected " + 1000 + " found " + c.getBalance());
			errors++;
		}
		
		//
		// Normal linked withdrawals (sequence)
		//
		s = new Savings();
		c = new Checking();
        s.link(c);

        int sBalance = 1000;
        int cBalance = 1000;
		try {
			s.deposit(sBalance);
			c.deposit(cBalance);
		} catch (LinkAccountException e) { e.printStackTrace(); }
				
		for (int i = 0; i < 100; i++)
		{
			int cRandValue = _rng.nextInt(100);
			
			// Normal withdrawal
			if (cBalance - cRandValue > 0)
			{
				cBalance -= cRandValue;
				try { c.withdraw(cRandValue); } catch (InsufficientFundsException e) { e.printStackTrace(); errors++; }
				
				if (!doubleEquals(c.getBalance(), cBalance))
				{
					emitError("Linked [withdraw] (1): Expected " + cBalance + " found " + c.getBalance());
					errors++;
				}
				if (!doubleEquals(s.getBalance(), sBalance))
				{
					emitError("Linked [withdraw] (2): Expected " + sBalance + " found " + s.getBalance());
					errors++;
				}
			}
			// Need to borrow from link (not exceeding the minimum)
			else if (cBalance - cRandValue < 0 && sBalance + (cBalance - cRandValue) >= Savings.MIN_AMOUNT)
			{
				sBalance += (cBalance - cRandValue);
				cBalance = 0;
				
				try { c.withdraw(cRandValue); } catch (InsufficientFundsException e) { e.printStackTrace(); errors++; }
				
				if (!doubleEquals(c.getBalance(), cBalance))
				{
					emitError("Linked [withdraw] (3): Expected " + cBalance + " found " + c.getBalance());
					errors++;
				}
				if (!doubleEquals(s.getBalance(), sBalance))
				{
					emitError("Linked [withdraw] (4): Expected " + sBalance + " found " + s.getBalance());
					errors++;
				}
			}
			// Need to borrow from link (exceeding the minimum)
			else
			{
				try { c.withdraw(cRandValue); } catch (InsufficientFundsException e) { }
				
				if (!doubleEquals(c.getBalance(), 0))
				{
					emitError("Linked [withdraw] (5): Expected " + cBalance + " found " + c.getBalance());
					errors++;
				}
				if (!doubleEquals(s.getBalance(), sBalance))
				{
					emitError("Linked [withdraw] (6): Expected " + sBalance + " found " + s.getBalance());
					errors++;
				}
			}
		}
		
		//
		// Normal linked withdrawals (sequence: savings)
		//
		s = new Savings();
		c = new Checking();
        s.link(c);

        sBalance = 1000;
        cBalance = 1000;
		try {
			s.deposit(sBalance);
			c.deposit(cBalance);
		} catch (LinkAccountException e) { e.printStackTrace(); }
				
		for (int i = 0; i < 100; i++)
		{
			int sRandValue = _rng.nextInt(100);
			
			// Normal withdrawal
			if (sBalance - sRandValue > Savings.MIN_AMOUNT)
			{
				sBalance -= sRandValue;
				try { s.withdraw(sRandValue); } catch (InsufficientFundsException e) { e.printStackTrace(); errors++; }
				
				if (!doubleEquals(c.getBalance(), cBalance))
				{
					emitError("Linked [withdraw] (7): Expected " + cBalance + " found " + c.getBalance());
					errors++;
				}
				if (!doubleEquals(s.getBalance(), sBalance))
				{
					emitError("Linked [withdraw] (8): Expected " + sBalance + " found " + s.getBalance());
					errors++;
				}
			}
			// Need to borrow from link (exceeding the minimum)
			else if (sBalance + cBalance - sRandValue < Savings.MIN_AMOUNT)
			{
				try { s.withdraw(sRandValue); } catch (InsufficientFundsException e) { }
				
				if (!doubleEquals(c.getBalance(), cBalance))
				{
					emitError("Linked [withdraw] (9): Expected " + cBalance + " found " + c.getBalance());
					errors++;
				}
				if (!doubleEquals(s.getBalance(), Savings.MIN_AMOUNT))
				{
					emitError("Linked [withdraw] (10): Expected " + Savings.MIN_AMOUNT + " found " + s.getBalance());
					errors++;
				}
			}
			
			// Need to borrow from link (not exceeding the minimum)
			else
			{
				cBalance -= Savings.MIN_AMOUNT - Math.abs(sBalance - sRandValue);
				sBalance = (int)Savings.MIN_AMOUNT;
				
				try { s.withdraw(sRandValue); } catch (InsufficientFundsException e) {
                    e.printStackTrace(); errors++;
                }
				
				if (!doubleEquals(c.getBalance(), cBalance))
				{
					emitError("Linked [withdraw] (11): Expected " + cBalance + " found " + c.getBalance());
					errors++;
				}
				if (!doubleEquals(s.getBalance(), sBalance))
				{
					emitError("Linked [withdraw] (12): Expected " + sBalance + " found " + s.getBalance());
					errors++;
				}
			}

		}
		
		return errors;
	}
	
	private static boolean doubleEquals(double a, double b)
	{
		return Math.abs(a - b ) < 0.0001;
	}
}