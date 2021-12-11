import java.util.ArrayList;

public class RationalTester
{
	private static final int CONSTRUCTOR           = 1;
	private static final int CONSTRUCTOR_LONG      = 2;
	private static final int GCD                   = 3;
	private static final int CONSTRUCTOR_LONG_LONG = 4;
	private static final int GET_DENOMINATOR       = 5;
	private static final int GET_NUMERATOR         = 6;
	private static final int ADD                   = 7;
	private static final int SUBTRACT              = 8;
	private static final int MULTIPLY              = 9;
	private static final int DIVIDE                = 10;

	private static final int TEST_MIN      = CONSTRUCTOR;
	private static final int TEST_MAX      = DIVIDE;
	private static final int MAX_NUM_TESTS = TEST_MAX + 1;
	private static int TEST                = 0;
	private static int TEST_CASE           = 0;
	private static int TEST_CASES_FAILED   = 0;
	private static boolean TEST_PASSED     = false;

	private static ArrayList<Integer> parseCommandLine(String[] args)
	{
		ArrayList<Integer> tests = new ArrayList<Integer>();
		boolean perform_all = false;

		for (int i = 0; i < args.length; i++)
		{
			if (args[i].equals("all"))
			{
				perform_all = true;
			}
		}

		if (perform_all)
		{
			System.out.println("All tests specified to be executed.");

			for (int i = TEST_MIN; i <= TEST_MAX; i++)
			{
				tests.add(new Integer(i));
			}
		}
		else
		{
			System.out.println(args.length +
			" command line arguments specified to be executed.");

			for (int i = 0; i < args.length; i++)
			{
				int test = new Integer(args[i]).intValue();

				System.out.print(test + " ");

				if (test >= TEST_MIN && test <= TEST_MAX)
				{
					tests.add(new Integer(test));
				}
			}
			System.out.println();
		}

		System.out.println(tests.size() +
		" valid tests specified to be executed.");

		return tests;
	}

	private static void dump_error_message(String message)
	{
		System.out.println("<" + TEST + "," + TEST_CASE + "> " + message);
		TEST_PASSED = false;
		TEST_CASES_FAILED++;
	}

	private static void checkContents(String contents, String test_contents)
	{
		if (!contents.equals(test_contents))
		{
			dump_error_message(" expected [" + test_contents + "] found [" + contents + "]");
		}
		TEST_CASE++;
	}

	public static void main(String args[])
	{
		ArrayList<Integer> tests = parseCommandLine(args);
		boolean[] TestResults = new boolean[MAX_NUM_TESTS];

		// initialize test results array
		for (int i = 0; i <= TEST_MAX; i++)
		{
			TestResults[i] = false;
		}

		int total_test_cases = 0;
		int total_failed_test_cases = 0;

		for (int i = TEST_MIN; i <= TEST_MAX; i++)
		{
			TEST_PASSED = true;
			TEST_CASES_FAILED = 0;

			if (tests.contains(new Integer(i)))
			{
				TEST = i;
				TEST_CASE = 1;

				System.out.println("\nTest " + TEST + " started");

				switch(i)
				{
				case CONSTRUCTOR:
					testConstructor();
					break;

				case CONSTRUCTOR_LONG:
					testConstructorLong();
					break;

				case GCD:
					testGCD();
					break;

				case CONSTRUCTOR_LONG_LONG:
					testConstructorLongLong();
					break;

				case GET_DENOMINATOR:
				{
					int[] requiredPassedTests = { CONSTRUCTOR, CONSTRUCTOR_LONG, CONSTRUCTOR_LONG_LONG, GCD };
					for (int rpt = TEST_MIN; rpt < requiredPassedTests.length; rpt++)
					{
						if (!TestResults[rpt])
						{
							dump_error_message("Cannot perform this test since test " + rpt + " failed.");
							break;
						}
					}
					testGetDenominator();
				}
				break;

				case GET_NUMERATOR:
				{
					int[] requiredPassedTests = { CONSTRUCTOR, CONSTRUCTOR_LONG, CONSTRUCTOR_LONG_LONG, GCD, GET_DENOMINATOR };
					for (int rpt = TEST_MIN; rpt < requiredPassedTests.length; rpt++)
					{
						if (!TestResults[rpt])
						{
							dump_error_message("Cannot perform this test since test " + rpt + " failed.");
							break;
						}
					}

					testGetNumerator();
				}
				break;

				case ADD:
				{
					int[] requiredPassedTests = { CONSTRUCTOR, CONSTRUCTOR_LONG, CONSTRUCTOR_LONG_LONG, GCD };

					for (int rpt = TEST_MIN; rpt < requiredPassedTests.length; rpt++)
					{
						if (!TestResults[rpt])
						{
							dump_error_message("Cannot perform this test since test " + rpt + " failed.");
							break;
						}
					}
					testAdd();
				}
				break;

				case SUBTRACT:
				{
					int[] requiredPassedTests = { CONSTRUCTOR, CONSTRUCTOR_LONG, CONSTRUCTOR_LONG_LONG, GCD };
					for (int rpt = TEST_MIN; rpt < requiredPassedTests.length; rpt++)
					{
						if (!TestResults[rpt])
						{
							dump_error_message("Cannot perform this test since test " + rpt + " failed.");
							break;
						}
					}
					testSubtract();
				}
				break;

				case MULTIPLY:
				{
					int[] requiredPassedTests = { CONSTRUCTOR, CONSTRUCTOR_LONG, CONSTRUCTOR_LONG_LONG, GCD };

					for (int rpt = TEST_MIN; rpt < requiredPassedTests.length; rpt++)
					{
						if (!TestResults[rpt])
						{
							dump_error_message("Cannot perform this test since test " + rpt + " failed.");
							break;
						}
					}
					testMultiply();
				}
				break;

				case DIVIDE:
				{
					int[] requiredPassedTests = { CONSTRUCTOR, CONSTRUCTOR_LONG, CONSTRUCTOR_LONG_LONG, GCD };

					for (int rpt = TEST_MIN; rpt < requiredPassedTests.length; rpt++)
					{
						if (!TestResults[rpt])
						{
							dump_error_message("Cannot perform this test since test " + rpt + " failed.");
							break;
						}
					}
					testDivide();
				}
				break;

				default:
					System.out.println("Unrecognized test " + i);
				}

				System.out.println("Test " + TEST + " " + (TEST_PASSED ? "passed" : "failed"));

				TestResults[TEST] = TEST_PASSED;

				System.out.println("Test " + TEST + " " + "Failed (" + TEST_CASES_FAILED
						+ " / " + TEST_CASE + ") test cases");
				total_test_cases += TEST_CASE;
				total_failed_test_cases += TEST_CASES_FAILED;

				TEST_CASES_FAILED = 0;
				TEST_CASE = 0;

				System.out.println("Test " + TEST + " ended");
			}
		}

		int failed_count = 0;
		int passed_count = 0;
		for (int i = TEST_MIN; i <= TEST_MAX && i < TestResults.length; i++)
		{
			if (tests.contains(new Integer(i)))
			{
				if (TestResults[i])
				{
					passed_count++;
				}
				else
				{
					failed_count++;
				}
			}
		}

		System.out.println("\nFailed " + total_failed_test_cases + " / " + total_test_cases + " test cases");
		System.out.println("Passed: " + passed_count + " / " + tests.size() + " tests");
		System.out.println("Failed: " + failed_count + " / " + tests.size() + " tests");
	}

	private static void testConstructor()
	{
		Rational test_rational = new Rational();
		checkContents(test_rational.toString(), "0");
	}

	private static void testConstructorLong()
	{
		for (int i = 0; i < 100; i++)
		{
			Rational test_rational = new Rational(i);
			checkContents(test_rational.toString(), (new Integer(i)).toString());
		}
	}

	private static void testGCD()
	{
		long a;
		long b;
		long gcd_expected;
		long gcd_result;
		Rational test_rational = new Rational();

		//
		// Relatively Prime Tests
		//
		a = 2;    b = 3;    gcd_expected = 1;
		gcd_result = test_rational.gcd(a,b); 
		if (gcd_result != gcd_expected)
		{
			dump_error_message("Expected GCD " + gcd_expected + "; found " + gcd_result);
		}
		TEST_CASE++;

		a = 97;    gcd_expected = 1;
		for (int k = 2; k < 97; k++)
		{
			gcd_result = test_rational.gcd(a, k);
			if (gcd_result != gcd_expected)
			{
				dump_error_message("Expected GCD " + gcd_expected + "; found " + gcd_result);
			}
			TEST_CASE++;
		}

		a = 2;    gcd_expected = 1;
		for (int k = 97; k >= 2; k -= 2)
		{
			gcd_result = test_rational.gcd(k, a);
			if (gcd_result != gcd_expected)
			{
				dump_error_message("Expected GCD " + gcd_expected + "; found " + gcd_result);
			}
			TEST_CASE++;
		}

		//
		// gcd(a,b) > 1
		//
		for (int k = 2; k < 100; k++)
		{
			gcd_result = test_rational.gcd(k, k); 
			if (gcd_result != k)
			{
				dump_error_message("Expected GCD " + gcd_expected + "; found " + k);
			}
			TEST_CASE++;
		}

		a = 3;    gcd_expected = 3;
		for (int k = 3; k < 1000; k *= 3)
		{
			gcd_result = test_rational.gcd(a, k); 
			if (gcd_result != gcd_expected)
			{
				dump_error_message("Expected GCD " + gcd_expected + "; found " + gcd_result);
			}
			TEST_CASE++;
		}

		a = 7654321;    b = 56791;    gcd_expected = 19;
		gcd_result = test_rational.gcd(a, b); 
		if (gcd_result != gcd_expected)
		{
			dump_error_message("Expected GCD " + gcd_expected + "; found " + gcd_result);
		}
		TEST_CASE++;
	}

	private static void testConstructorLongLong()
	{
		for (int i = 1; i < 100; i++)
		{
			Rational test_rational = new Rational(i, i);
			checkContents(test_rational.toString(), "1");
		}

		for (int i = 1; i < 100; i += 2)
		{
			Rational test_rational = new Rational(i, i*2);
			checkContents(test_rational.toString(), "1/2");
		}

		for (int i = 1; i < 100; i += 2)
		{
			Rational test_rational = new Rational(2*i, i*3);
			checkContents(test_rational.toString(), "2/3");
		}

		for (int i = 1; i < 100; i++)
		{
			Rational test_rational = new Rational(i, -1);
			checkContents(test_rational.toString(), new Integer(-i).toString());
		}
	}

	private static void testGetDenominator()
	{		
		for (int k = 1; k < 100; k++)
		{
			long denom = new Rational(k).getDenominator();
			if (denom != 1)
			{
				dump_error_message("Expected Denominator 1; found " + denom);
			}
			TEST_CASE++;
		}

		for (int k = 1; k < 100; k += 2)
		{
			long denom = new Rational(k, 2).getDenominator();
			if (denom != 2)
			{
				dump_error_message("Expected Denominator " + "2" + "; found " + denom);
			}
			TEST_CASE++;
		}
	}

	private static void testGetNumerator()
	{
		for (int k = 1; k < 100; k++)
		{
			long numer = new Rational(k).getNumerator();
			if (numer != k)
			{
				dump_error_message("Expected Numerator " + k + "; found " + numer);
			}
			TEST_CASE++;
		}
	}

	private static void testAdd()
	{
		try
		{
           checkContents((new Rational(1)).add(null).toString(), "1");
		}
		catch(NullPointerException e1)
		{
            dump_error_message("Null pointer thrown in add; null not treated as zero.");     
		}
	
		for (int i = 1; i < 100; i++)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(-i);
			Rational sum = test_rational1.add(test_rational2);
			checkContents(sum.toString(), "0");
		}

		for (int i = 1; i < 100; i++)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(i);
			Rational sum = test_rational1.add(test_rational2);
			checkContents(sum.toString(), new Integer(i * 2).toString());
		}

		for (int i = 3; i < 100; i += 2)
		{
			Rational test_rational1 = new Rational(1, i);
			Rational test_rational2 = new Rational(1, i);
			Rational sum = test_rational1.add(test_rational2);
			checkContents(sum.toString(), "2/" + new Integer(i).toString());
		}

		for (int i = 2; i < 100; i++)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(1, i);
			Rational sum = test_rational1.add(test_rational2);
			checkContents(sum.toString(), new Integer(i * i + 1).toString() + "/" + new Integer(i).toString());
		}
	}

	private static void testSubtract()
	{
		try
		{
           checkContents((new Rational(1)).subtract(null).toString(), "1");
		}
		catch(NullPointerException e1)
		{
            dump_error_message("Null pointer thrown in subtract; null not treated as zero.");     
		}

		for (int i = 1; i < 100; i++)
		{
			Rational test_rational1 = new Rational(-i);
			Rational test_rational2 = new Rational(i);
			Rational difference = test_rational1.subtract(test_rational2);
			checkContents(difference.toString(), new Integer (- 2 * i).toString());
		}

		for (int i = 1; i < 100; i++)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(-i);
			Rational difference = test_rational1.subtract(test_rational2);
			checkContents(difference.toString(), new Integer (2 * i).toString());
		}

		for (int i = 1; i < 100; i++)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(i);
			Rational difference = test_rational1.subtract(test_rational2);
			checkContents(difference.toString(), "0");
		}

		for (int i = 3; i < 100; i += 2)
		{
			Rational test_rational1 = new Rational(1, i);
			Rational test_rational2 = new Rational(1, i);
			Rational difference = test_rational1.subtract(test_rational2);
			checkContents(difference.toString(), "0");
		}

		for (int i = 2; i < 100; i++)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(1, i);
			Rational difference = test_rational1.subtract(test_rational2);
			checkContents(difference.toString(), new Integer(i * i - 1).toString() + "/" + new Integer(i).toString());
		}

		Rational test_rational1 = new Rational(3, 4);
		Rational test_rational2 = new Rational(7, 13);
		Rational difference = test_rational1.subtract(test_rational2);
		checkContents(difference.toString(), new Integer(11).toString() + "/" + new Integer(52).toString());

		test_rational1 = new Rational(4, 3);
		test_rational2 = new Rational(7, 13);
		difference = test_rational1.subtract(test_rational2);
		checkContents(difference.toString(), new Integer(31).toString() + "/" + new Integer(39).toString());

		test_rational1 = new Rational(4, 10);
		test_rational2 = new Rational(7, 15);
		difference = test_rational1.subtract(test_rational2);
		checkContents(difference.toString(), "-1/15");

		test_rational1 = new Rational(9, 10);
		test_rational2 = new Rational(7, 15);
		difference = test_rational1.subtract(test_rational2);
		checkContents(difference.toString(), "13/30");

		test_rational1 = new Rational(13, 10);
		test_rational2 = new Rational(7, 15);
		difference = test_rational1.subtract(test_rational2);
		checkContents(difference.toString(), "5/6");
	}

	private static void testMultiply()
	{
		try
		{
           checkContents((new Rational(1)).multiply(null).toString(), "0");
		}
		catch(NullPointerException e1)
		{
            dump_error_message("Null pointer thrown in multiply; null not treated as zero.");     
		}

		for (int i = 2; i < 100; i++)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(1, i);
			Rational product = test_rational1.multiply(test_rational2);
			checkContents(product.toString(), "1");
		}

		for (int i = 2; i < 100; i++)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(2, -i);
			Rational product = test_rational1.multiply(test_rational2);
			checkContents(product.toString(), "-2");
		}

		for (int i = 2; i < 100; i++)
		{
			Rational test_rational1 = new Rational(-i);
			Rational test_rational2 = new Rational(2, -i);
			Rational product = test_rational1.multiply(test_rational2);
			checkContents(product.toString(), "2");
		}

		int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };
		for (int i = 0; i < primes.length; i++)
		{
			for (int j = 0; j < primes.length; j++)
			{
				for (int k = 0; k < primes.length; k++)
				{
					for (int m = 0; m < primes.length; m++)
					{
						if (i != j &&
								i != k &&
								i != m &&
								j != k &&
								j != m &&
								k != m)
						{
							Rational test_rational1 = new Rational(primes[i], primes[j]);
							Rational test_rational2 = new Rational(primes[k], primes[m]);
							Rational product = test_rational1.multiply(test_rational2);
							checkContents(product.toString(), new Integer(primes[i] * primes[k]).toString() + "/" + new Integer(primes[j] * primes[m]).toString());
						}
					}
				}
			}
		}

		Rational test_rational1 = new Rational(3, 7);
		Rational test_rational2 = new Rational(7, 15);
		Rational product = test_rational1.multiply(test_rational2);
		checkContents(product.toString(), "1/5");

		test_rational1 = new Rational(9, 10);
		test_rational2 = new Rational(7, 15);
		product = test_rational1.multiply(test_rational2);
		checkContents(product.toString(), "21/50");

		test_rational1 = new Rational(17, 12);
		test_rational2 = new Rational(18, 5);
		product = test_rational1.multiply(test_rational2);
		checkContents(product.toString(), "51/10");
	}

	private static void testDivide()
	{
		try
		{
           new Rational(1).divide(null);
           dump_error_message("Expect an ArithmeticException to be thrown on null");
		}
		catch(NullPointerException e1)
		{
            dump_error_message("Null pointer thrown in divide; null not treated as zero.");     
		}
		catch(ArithmeticException e2)
		{
			// Good.
		}
		TEST_CASE++;

		for (int i = 2; i < 100; i++)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(1, i);
			Rational quotient = test_rational1.divide(test_rational2);
			checkContents(quotient.toString(), new Integer (i * i).toString());
		}

		for (int i = 1; i < 100; i += 2)
		{
			Rational test_rational1 = new Rational(i);
			Rational test_rational2 = new Rational(2, -i);
			Rational quotient = test_rational1.divide(test_rational2);
			checkContents(quotient.toString(), new Integer (-i * i).toString() + "/2");
		}

		for (int i = 1; i < 100; i += 2)
		{
			Rational test_rational1 = new Rational(-i);
			Rational test_rational2 = new Rational(2, -i);
			Rational quotient = test_rational1.divide(test_rational2);
			checkContents(quotient.toString(), new Integer (i * i).toString() + "/2");
		}

		int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };
		for (int i = 0; i < primes.length; i++)
		{
			for (int j = 0; j < primes.length; j++)
			{
				for (int k = 0; k < primes.length; k++)
				{
					for (int m = 0; m < primes.length; m++)
					{
						if (i != j &&
								i != k &&
								i != m &&
								j != k &&
								j != m &&
								k != m)
						{
							Rational test_rational1 = new Rational(primes[i], primes[j]);
							Rational test_rational2 = new Rational(primes[k], primes[m]);
							Rational quotient = test_rational1.divide(test_rational2);
							checkContents(quotient.toString(), new Integer(primes[i] * primes[m]).toString() + "/" + new Integer(primes[j] * primes[k]).toString());
						}
					}
				}
			}
		}

		Rational test_rational1 = new Rational(3, 7);
		Rational test_rational2 = new Rational(7, 15);
		Rational quotient = test_rational1.divide(test_rational2);
		checkContents(quotient.toString(), "45/49");

		test_rational1 = new Rational(9, 10);
		test_rational2 = new Rational(7, 15);
		quotient = test_rational1.divide(test_rational2);
		checkContents(quotient.toString(), "27/14");

		test_rational1 = new Rational(12, 17);
		test_rational2 = new Rational(18, 5);
		quotient = test_rational1.divide(test_rational2);
		checkContents(quotient.toString(), "10/51");
	}
}