import java.util.ArrayList;

public class SetTester
{
    private static final int CONSTRUCTOR = 1;
    private static final int CONSTRUCTOR_INT = 2;
    private static final int CONSTRUCTOR_INT_INT = 3;
    private static final int ADD_OBJECT = 4;
    private static final int ADD_ARRAY = 5;
    private static final int REMOVE_OBJECT = 6;
    private static final int REMOVE_ARRAY = 7;
    private static final int CONTAINS = 8;
    private static final int CLEAR = 9;
    private static final int ISEMPTY = 10;
    private static final int SIZE = 11;
    private static final int GET = 12;
    private static final int UNION = 13;
    private static final int INTERSECTION = 14;
    private static final int SUBSET = 15;
    private static final int SUPERSET = 16;
    private static final int BARRAGE = 17;

    private static final int TEST_MIN = CONSTRUCTOR;
    private static final int TEST_MAX = BARRAGE;
    private static final int MAX_NUM_TESTS = TEST_MAX + 1;
    private static int TEST = 0;
    private static int TEST_CASE = 0;
    private static int TEST_CASES_FAILED = 0;
    private static boolean TEST_PASSED = false;

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
            System.out.println(args.length
                    + " command line arguments specified to be executed.");

            for (int i = 0; i < args.length; i++)
            {
                if (args[i] != "")
                {
                    int test = new Integer(args[i]).intValue();

                    System.out.print(test + " ");

                    if (test >= TEST_MIN && test <= TEST_MAX)
                    {
                        tests.add(new Integer(test));
                    }
                }
            }
            System.out.println();
        }

        System.out.println(tests.size()
                + " valid tests specified to be executed.");

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

    public static void main(String[] args)
    {
        //
        // Uncomment the tests you want to run...
        //
        args = new String[TEST_MAX];

        for (int i = 0; i < TEST_MAX; i++)
        {
            args[i] = "";
        }

        args[0] = "1";
        args[1] = "2";
        args[2] = "3";
        args[3] = "4";
        args[4] = "5";
        args[5] = "6";
        args[6] = "7";
        args[7] = "8";
        args[8] = "9";
        args[9] = "10";
        args[10] = "11";
        args[11] = "12";
        args[12] = "13";
        args[13] = "14";
        args[14] = "15";
        args[15] = "16";
        args[16] = "17";

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
                TEST_CASE = 0;

                System.out.println("\nTest " + TEST + " started");

                switch (i)
                {
                    case CONSTRUCTOR:
                        testConstructor();
                        break;

                    case CONSTRUCTOR_INT:
                        testConstructorInt();
                        break;

                    case CONSTRUCTOR_INT_INT:
                        testConstructorIntInt();
                        break;

                    case ADD_OBJECT:
                        testAddObject();
                        break;

                    case ADD_ARRAY:
                        testAddArray();
                        break;

                    case REMOVE_OBJECT:
                        if (!TestResults[TEST_MIN + 2])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 2) + " failed");
                            break;
                        }
                        testRemoveObject();
                        break;

                    case REMOVE_ARRAY:
                        if (!TestResults[TEST_MIN + 2])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 2) + " failed");
                            break;
                        }
                        testRemoveArray();
                        break;

                    case CONTAINS:
                        if (!TestResults[TEST_MIN + 5])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 5) + " failed");
                            break;
                        }
                        testContains();
                        break;

                    case CLEAR:
                        if (!TestResults[TEST_MIN + 1])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 1) + " failed");
                            break;
                        }
                        if (!TestResults[TEST_MIN + 2])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 2) + " failed");
                            break;
                        }
                        testClear();
                        break;

                    case ISEMPTY:
                        if (!TestResults[TEST_MIN + 1])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 1) + " failed");
                            break;
                        }
                        if (!TestResults[TEST_MIN + 2])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 2) + " failed");
                            break;
                        }
                        if (!TestResults[TEST_MIN + 8])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 8) + " failed");
                            break;
                        }
                        testIsEmpty();
                        break;

                    case SIZE:
                        if (!TestResults[TEST_MIN + 2])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 2) + " failed");
                            break;
                        }
                        testSize();
                        break;

                    case GET:
                        if (!TestResults[TEST_MIN])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 11) + " failed");
                            break;
                        }
                        testGet();
                        break;

                    case UNION:
                        if (!TestResults[TEST_MIN + 2])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 2) + " failed");
                            break;
                        }
                        if (!TestResults[TEST_MIN + 4])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 4) + " failed");
                            break;
                        }
                        testUnion();
                        break;

                    case INTERSECTION:
                        if (!TestResults[TEST_MIN + 2])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 2) + " failed");
                            break;
                        }
                        if (!TestResults[TEST_MIN + 4])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 4) + " failed");
                            break;
                        }
                        testIntersection();
                        break;

                    case SUBSET:
                        if (!TestResults[TEST_MIN + 2])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 2) + " failed");
                            break;
                        }
                        if (!TestResults[TEST_MIN + 4])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 4) + " failed");
                            break;
                        }
                        testSubset();
                        break;

                    case SUPERSET:
                        if (!TestResults[TEST_MIN + 2])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 2) + " failed");
                            break;
                        }
                        if (!TestResults[TEST_MIN + 4])
                        {
                            dump_error_message("cannot perform this test since test " + (TEST_MIN + 4) + " failed");
                            break;
                        }
                        testSuperset();
                        break;

                    case BARRAGE:
                        testBarrage();
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
    	try
    	{
            Set test_set = new Set();
            checkContents(test_set.toString(), "");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testConstructorInt()
    {
    	try
    	{
    		Set test_set = new Set(10);
    		checkContents(test_set.toString(), "");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testConstructorIntInt()
    {
    	try
    	{
	        int low = 100, high = 110;
	        int num_elements = high - low + 1;
	        Set test_set = new Set(100, 110);
	
	        if (test_set.size() != num_elements)
	        {
	            dump_error_message("expected size " + num_elements + "; found size " + test_set.size());
	        }
	
	        test_set = new Set(100, 110);
	        checkContents(test_set.toString(), "100 101 102 103 104 105 106 107 108 109 110");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testAddObject()
    {
    	try
    	{
	        Set test_set = new Set();
	
	        test_set = new Set();
	        Integer test_int = null;
	        try
	        {
	            test_set.add(test_int);
	            checkContents(test_set.toString(), "");
	        } catch (NullPointerException e)
	        {
	            dump_error_message("null not handled in add()");
	        }
	
	        test_set = new Set();
	        test_set.add(new Integer(2));
	        checkContents(test_set.toString(), "2");
	
	        test_set = new Set();
	        test_set.add(new Integer(2));
	        test_set.add(new Integer(0));
	        checkContents(test_set.toString(), "0 2");
	
	        test_set = new Set();
	        test_set.add(new Integer(2));
	        test_set.add(new Integer(0));
	        test_set.add(new Integer(1));
	        checkContents(test_set.toString(), "0 1 2");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testAddArray()
    {
    	try
    	{
	        Integer[] vals = null;
	        Set test_set;
	
	        vals = null;
	        test_set = new Set();
	        try
	        {
	            test_set.add(vals);
	        } catch (NullPointerException e)
	        {
	            dump_error_message("null not handled in add([])");
	        }
	        checkContents(test_set.toString(), "");
	
	        vals = new Integer[10];
	        test_set = new Set();
	        test_set.add(vals);
	        checkContents(test_set.toString(), "");
	
	        vals = new Integer[10];
	        test_set = new Set();
	        for (int j = 20, k = 0; k < 10; j -= 2, k++)
	        {
	            vals[k] = new Integer(j);
	        }
	        test_set.add(vals);
	        checkContents(test_set.toString(), "2 4 6 8 10 12 14 16 18 20");
	
	        vals = new Integer[10];
	        test_set = new Set();
	        for (int j = 20, k = 0; k < 10; j -= 2, k++)
	        {
	            vals[k] = new Integer(j);
	        }
	        test_set.add(vals);
	        for (int j = 19, k = 0; k < 10; j -= 2, k++)
	        {
	            vals[k] = new Integer(j);
	        }
	        test_set.add(vals);
	        checkContents(test_set.toString(), "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testRemoveObject()
    {
    	try
    	{
	        TEST_CASE++;
	
	        Set test_set = new Set(0, 12);
	        Integer test_int = null;
	        try
	        {
	            test_set.remove(test_int);
	        }
	        catch(NullPointerException e)
	        {
	            dump_error_message("null not handled in remove()");
	        }
	        checkContents(test_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 12);
	        if (test_set.remove(new Integer(-1)) != null)
	        {
	            dump_error_message("remove() did not return null");
	        }
	        checkContents(test_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 12);
	        test_set.remove(new Integer(-1));
	        checkContents(test_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 12);
	        test_set.remove(new Integer(13));
	        checkContents(test_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 12);
	        test_set.remove(new Integer(12));
	        checkContents(test_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11");
	
	        test_set = new Set(0, 12);
	        test_set.remove(new Integer(0));
	        checkContents(test_set.toString(), "1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 12);
	        test_set.remove(new Integer(5));
	        checkContents(test_set.toString(), "0 1 2 3 4 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 12);
	        for (int j = 0; j <= 12; j++)
	        {
	            test_set.remove(new Integer(j));
	        }
	        checkContents(test_set.toString(), "");
	
	        test_set = new Set(0, 12);
	        for (int j = 12; j >= 0; j--)
	        {
	            test_set.remove(new Integer(j));
	        }
	        checkContents(test_set.toString(), "");
	
	        try
	        {
	            test_set = new Set(-2, 12);
	            Object o = test_set.remove(new Integer(-1));
	            if (!o.equals(new Integer(-1)))
	            {
	                dump_error_message("removed object not returned; expected -1 ; returned " + o);
	            }
	        }
	        catch (Exception e)
	        {
	            dump_error_message("Unexpected null returned; expected object -1");
	        }
	        checkContents(test_set.toString(), "-2 0 1 2 3 4 5 6 7 8 9 10 11 12");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testRemoveArray()
    {
    	try
    	{
	    	TEST_CASE++;
	
	        Set test_set;
	        Set remove_vals;
	
	        remove_vals = new Set();
	        test_set = new Set(0, 12);
	        test_set.remove(remove_vals);
	        checkContents(test_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        remove_vals = new Set(0, 12);
	        test_set = new Set(0, 12);
	        test_set.remove(remove_vals);
	        checkContents(test_set.toString(), "");
	
	        remove_vals = new Set(0, 4);
	        test_set = new Set(0, 12);
	        test_set.remove(remove_vals);
	        checkContents(test_set.toString(), "5 6 7 8 9 10 11 12");
	
	        remove_vals = new Set(7, 12);
	        test_set = new Set(0, 12);
	        test_set.remove(remove_vals);
	        checkContents(test_set.toString(), "0 1 2 3 4 5 6");
	
	        remove_vals = new Set(5, 9);
	        test_set = new Set(0, 12);
	        test_set.remove(remove_vals);
	        checkContents(test_set.toString(), "0 1 2 3 4 10 11 12");
	
	        remove_vals = new Set();
	        for (int j = 0; j < 5; j++)
	        {
	            remove_vals.add(new Integer(j * 2));
	        }
	        test_set = new Set(0, 12);
	        test_set.remove(remove_vals);
	        checkContents(test_set.toString(), "1 3 5 7 9 10 11 12");
	
	        remove_vals = new Set();
	        for (int j = 0; j < 5; j++)
	        {
	            remove_vals.add(new Integer(j * 2));
	        }
	        test_set = new Set(0, 12);
	        int removed = test_set.remove(remove_vals);
	        TEST_CASE++;
	        if (removed != 5)
	        {
	            dump_error_message("remove([]) did not return 5; found " + removed);
	        }
	        checkContents(test_set.toString(), "1 3 5 7 9 10 11 12");
	
	        remove_vals = new Set(15, 29);
	        test_set = new Set(0, 12);
	        removed = test_set.remove(remove_vals);
	        TEST_CASE++;
	        if (removed != 0)
	        {
	            dump_error_message("remove([]) did not return 0; found " + removed);
	        }
	        checkContents(test_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        remove_vals = new Set(-5, 14);
	        test_set = new Set(0, 12);
	        removed = test_set.remove(remove_vals);
	        TEST_CASE++;
	        if (removed != 13)
	        {
	            dump_error_message("remove([]) did not return 0; found " + removed);
	        }
	        checkContents(test_set.toString(), "");
	
	        remove_vals = null;
	        test_set = new Set(0, 12);
	        try
	        {
	            test_set.remove(remove_vals);
	        }
	        catch (NullPointerException e)
	        {
	            dump_error_message("null not handled in remove([])");
	        }
	        checkContents(test_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testContains()
    {
    	try
    	{
	        TEST_CASE++;
	
	        Set test_set = null;
	        Integer[] vals = null;
	        Integer test_val = null;
	
	        test_set = new Set();
	        if (test_set.contains(null))
	        {
	            dump_error_message("should not have found null");
	        }
	        TEST_CASE++;
	
	        test_set = new Set();
	        vals = new Integer[10];
	        for (int j = 0; j < vals.length; j++)
	        {
	            vals[j] = new Integer(j * 2 + 1);
	        }
	        test_set.add(vals);
	        test_val = new Integer(-1);
	        if (test_set.contains(test_val))
	        {
	            dump_error_message("should not have found " + test_val);
	        }
	        TEST_CASE++;
	
	        test_set = new Set();
	        vals = new Integer[10];
	        for (int j = 0; j < vals.length; j++)
	        {
	            vals[j] = new Integer(j * 2 + 1);
	        }
	        test_set.add(vals);
	        test_val = new Integer(200);
	        if (test_set.contains(test_val))
	        {
	            dump_error_message("should not have found " + test_val);
	        }
	        TEST_CASE++;
	
	        test_set = new Set();
	        vals = new Integer[10];
	        for (int j = 0; j < vals.length; j++)
	        {
	            vals[j] = new Integer(j * 2 + 1);
	        }
	        test_set.add(vals);
	        test_val = new Integer(1);
	        if (!test_set.contains(test_val))
	        {
	            dump_error_message("should have found " + test_val);
	        }
	        TEST_CASE++;
	
	        test_set = new Set();
	        vals = new Integer[10];
	        for (int j = 0; j < vals.length; j++)
	        {
	            vals[j] = new Integer(j * 2 + 1);
	        }
	        test_set.add(vals);
	        test_val = new Integer(19);
	        if (!test_set.contains(test_val))
	        {
	            dump_error_message("should have found " + test_val);
	        }
	        TEST_CASE++;
	
	        // check for not modifying the set
	        test_set = new Set();
	        vals = new Integer[10];
	        for (int j = 0; j < vals.length; j++)
	        {
	            vals[j] = new Integer(j * 2 + 1);
	        }
	        test_set.add(vals);
	        test_val = new Integer(19);
	        test_set.contains(test_val);
	        checkContents(test_set.toString(), "1 3 5 7 9 11 13 15 17 19");
	
	        test_set = new Set();
	        vals = new Integer[10];
	        for (int j = 0; j < vals.length; j++)
	        {
	            vals[j] = new Integer(j * 2 + 1);
	        }
	        test_set.add(vals);
	        test_val = new Integer(9);
	        if (!test_set.contains(test_val))
	        {
	            dump_error_message("should have found " + test_val);
	        }
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testClear()
    {
    	try
    	{
	        TEST_CASE++;
	
	        Set test_set = new Set();
	        test_set.clear();
	        checkContents(test_set.toString(), "");
	
	        test_set = new Set(0, 0);
	        test_set.clear();
	        checkContents(test_set.toString(), "");
	
	        test_set = new Set(100, 200);
	        test_set.clear();
	        checkContents(test_set.toString(), "");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testIsEmpty()
    {
    	try
    	{
	        TEST_CASE++;
	
	        Set test_set = new Set();
	        if (!test_set.isEmpty())
	        {
	            dump_error_message("set should be empty");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(100, 123);
	        if (test_set.isEmpty())
	        {
	            dump_error_message("set should not be empty");
	        }
	        TEST_CASE++;
	
	        // non-modification check
	        test_set = new Set(100, 110);
	        test_set.isEmpty();
	        checkContents(test_set.toString(), "100 101 102 103 104 105 106 107 108 109 110");
	
	        test_set = new Set(100, 123);
	        if (test_set.isEmpty())
	        {
	            dump_error_message("set should not be empty");
	        }
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testSize()
    {
    	try
    	{
	        Set test_set = new Set(100, 110);
	        test_set.isEmpty();
	        checkContents(test_set.toString(), "100 101 102 103 104 105 106 107 108 109 110");
	
	        TEST_CASE++;
	
	        test_set = new Set();
	        int sz = test_set.size();
	        if (sz != 0)
	        {
	            dump_error_message("set should be size 0; found " + sz);
	        }
	        TEST_CASE++;
	
	        test_set = new Set(100, 123);
	        sz = test_set.size();
	        if (sz != 24)
	        {
	            dump_error_message("set should be size 24; found " + sz);
	        }
	        TEST_CASE++;
	
	        // non-modification check
	        test_set = new Set(100, 110);
	        test_set.size();
	        checkContents(test_set.toString(), "100 101 102 103 104 105 106 107 108 109 110");
	        test_set = new Set(0, 0);
	        sz = test_set.size();
	        if (sz != 1)
	        {
	            dump_error_message("set should be size 24; found " + sz);
	        }
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testGet()
    {
    	try
    	{
	        TEST_CASE++;
	
	        Set test_set = new Set();
	
	        try
	        {
	            if (test_set.get(0) != null) dump_error_message("index out of bounds not handled");
	        }
	        catch(IndexOutOfBoundsException e)
	        {
	        }
	        TEST_CASE++;
	
	
	        Integer test_val;
	        Integer retrieved;
	
	        test_set = new Set(100, 123);
	        test_val = new Integer(100);
	        retrieved = (Integer)test_set.get(0);
	        if (!retrieved.equals(test_val))
	        {
	            dump_error_message("wrong value retrieved " + retrieved + " expected: " + test_val);
	        }
	        TEST_CASE++;
	
	        test_set = new Set(100, 123);
	        test_val = new Integer(112);
	        retrieved = (Integer)test_set.get(12);
	        if (!retrieved.equals(test_val))
	        {
	            dump_error_message("wrong value retrieved " + retrieved + " expected: " + test_val);
	        }
	        TEST_CASE++;
	
	        test_set = new Set(100, 123);
	        test_val = new Integer(123);
	        retrieved = (Integer)test_set.get(23);
	        if (!retrieved.equals(test_val))
	        {
	            dump_error_message("wrong value retrieved " + retrieved + " expected: " + test_val);
	        }
	        TEST_CASE++;
	
	        test_set = new Set(100, 123);
	        try
	        {
	            if (test_set.get(25) != null) dump_error_message("index out of bounds not handled");
	        }
	        catch(IndexOutOfBoundsException e)
	        {
	        }
	        TEST_CASE++;
	
	        // non-modification check
	        test_set = new Set(100, 110);
	        test_set.get(0);
	        checkContents(test_set.toString(), "100 101 102 103 104 105 106 107 108 109 110");
	
	        test_set = new Set(100, 123);
	        try
	        {
	            if (test_set.get(-1) != null) dump_error_message("index out of bounds not handled");
	        }
	        catch(IndexOutOfBoundsException e)
	        {
	        }
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testUnion()
    {
    	try
    	{
	        TEST_CASE++;
	
	        Set test_set;
	        Set union_set;
	
	        test_set = new Set(0, 12);
	        try
	        {
	            union_set = test_set.union(null);
	            checkContents(union_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	        }
	        catch(NullPointerException e)
	        {
	            dump_error_message("Null pointer exception thrown on union");
	        }
	        TEST_CASE++;
	
	        Set test_set2;
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(0, 12);
	        union_set = test_set.union(test_set2);
	        checkContents(union_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(4, 7);
	        test_set2 = new Set(0, 12);
	        union_set = test_set.union(test_set2);
	        checkContents(union_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(4, 7);
	        union_set = test_set.union(test_set2);
	        checkContents(union_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 1);
	        test_set2 = new Set(4, 5);
	        union_set = test_set.union(test_set2);
	        checkContents(union_set.toString(), "0 1 4 5");
	
	        test_set = new Set();
	        test_set2 = new Set();
	        union_set = test_set.union(test_set2);
	        checkContents(union_set.toString(), "");
	
	        test_set = new Set();
	        test_set2 = new Set(4, 7);
	        union_set = test_set.union(test_set2);
	        checkContents(union_set.toString(), "4 5 6 7");
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set();
	        union_set = test_set.union(test_set2);
	        checkContents(union_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(100, 105);
	        union_set = test_set.union(test_set2);
	        checkContents(union_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12 100 101 102 103 104 105");
	
	        // non-modification check
	        test_set = new Set(100, 110);
	        test_set2 = new Set(100, 105);
	        test_set.union(test_set2);
	        checkContents(test_set.toString(), "100 101 102 103 104 105 106 107 108 109 110");
	
	        Integer[] odds = new Integer[10];
	        Integer[] evens = new Integer[10];
	        for (int j = 0; j < odds.length && j < evens.length; j++)
	        {
	            evens[j] = new Integer(j * 2);
	            odds[j] = new Integer(j * 2 + 1);
	        }
	        test_set = new Set();
	        test_set.add(odds);
	        test_set2 = new Set();
	        test_set2.add(evens);
	        union_set = test_set.union(test_set2);
	        checkContents(union_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testIntersection()
    {
    	try
    	{
	        TEST_CASE++;
	
	        Set test_set = null;
	        Set intersection_set = null;
	
	        test_set = new Set(0, 12);
	        try
	        {
	            intersection_set = test_set.intersection(null);
	            checkContents(intersection_set.toString(), "");
	        }
	        catch(NullPointerException e)
	        {
	            dump_error_message("Null pointer exception thrown on intersection");
	        }
	        TEST_CASE++;
	
	        Set test_set2;
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(0, 12);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(0, 12);
	        intersection_set = test_set.intersection(test_set);
	        checkContents(intersection_set.toString(), "0 1 2 3 4 5 6 7 8 9 10 11 12");
	
	        test_set = new Set(4, 7);
	        test_set2 = new Set(0, 12);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "4 5 6 7");
	
	        test_set = new Set(0, 1);
	        test_set2 = new Set(4, 7);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "");
	
	        test_set = new Set(4, 7);
	        test_set2 = new Set(0, 12);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "4 5 6 7");
	
	        test_set = new Set(10, 20);
	        test_set2 = new Set(5, 15);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "10 11 12 13 14 15");
	
	        test_set = new Set(10, 20);
	        test_set2 = new Set(15, 25);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "15 16 17 18 19 20");
	
	        test_set = new Set();
	        test_set2 = new Set();
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "");
	
	        test_set = new Set();
	        test_set2 = new Set(4, 7);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "");
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set();
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "");
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(100, 105);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "");
	
	        Integer[] odds = new Integer[10];
	        Integer[] evens = new Integer[10];
	        for (int j = 0; j < odds.length && j < evens.length; j++)
	        {
	            evens[j] = new Integer(j * 2);
	            odds[j] = new Integer(j * 2 + 1);
	        }
	        test_set = new Set();
	        test_set.add(odds);
	        test_set2 = new Set();
	        test_set2.add(evens);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "");
	
	        // non-modification check
	        test_set = new Set(100, 110);
	        test_set2 = new Set(100, 105);
	        test_set.intersection(test_set2);
	        checkContents(test_set.toString(), "100 101 102 103 104 105 106 107 108 109 110");
	
	        Integer[] others = new Integer[10];
	        for (int j = 0; j < others.length && j < odds.length; j++)
	        {
	            others[j] = new Integer(j * 3);
	            odds[j] = new Integer(j * 2 + 1);
	        }
	        test_set = new Set();
	        test_set.add(others);
	        test_set2 = new Set();
	        test_set2.add(odds);
	        intersection_set = test_set.intersection(test_set2);
	        checkContents(intersection_set.toString(), "3 9 15");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testSubset()
    {
    	try
    	{
	        TEST_CASE++;
	
	        Set test_set;
	
	        test_set = new Set(0, 12);
	        try
	        {
	            if (!test_set.subset(null))
	            {
	                dump_error_message("null should be reported as subset");
	            }
	        }
	        catch(NullPointerException e)
	        {
	            dump_error_message("Null pointer exception thrown on subset");
	        }
	        TEST_CASE++;
	
	        Set test_set2;
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(0, 12);
	        if (!test_set.subset(test_set2))
	        {
	            dump_error_message("expected subset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(0, 12);
	        if (!test_set.subset(test_set))
	        {
	            dump_error_message("expected subset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(4, 7);
	        if (!test_set.subset(test_set2))
	        {
	            dump_error_message("expected subset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(10, 20);
	        test_set2 = new Set(5, 15);
	        if (test_set.subset(test_set2))
	        {
	            dump_error_message("did not expect subset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(10, 20);
	        test_set2 = new Set(15, 25);
	        if (test_set.subset(test_set2))
	        {
	            dump_error_message("did not expect subset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set();
	        test_set2 = new Set();
	        if (!test_set.subset(test_set2))
	        {
	            dump_error_message("expected subset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set();
	        test_set2 = new Set(4, 7);
	        if (test_set.subset(test_set2))
	        {
	            dump_error_message("did not expect subset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set();
	        if (!test_set.subset(test_set2))
	        {
	            dump_error_message("expected subset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(100, 105);
	        if (test_set.subset(test_set2))
	        {
	            dump_error_message("did not expect subset");
	        }
	        TEST_CASE++;
	
	        Integer[] odds = new Integer[10];
	        Integer[] evens = new Integer[10];
	        for (int j = 0; j < odds.length && j < evens.length; j++)
	        {
	            evens[j] = new Integer(j * 2);
	            odds[j] = new Integer(j * 2 + 1);
	        }
	        test_set = new Set();
	        test_set.add(odds);
	        test_set2 = new Set();
	        test_set2.add(evens);
	        if (test_set.subset(test_set2))
	        {
	            dump_error_message("did not expect subset");
	        }
	        TEST_CASE++;
	
	        // non-modification check
	        test_set = new Set(100, 110);
	        test_set2 = new Set(100, 105);
	        test_set.subset(test_set2);
	        checkContents(test_set.toString(), "100 101 102 103 104 105 106 107 108 109 110");
	
	        Integer[] others = new Integer[10];
	        for (int j = 0; j < others.length && j < odds.length; j++)
	        {
	            others[j] = new Integer(j * 3);
	            odds[j] = new Integer(j * 2 + 1);
	        }
	        test_set = new Set();
	        test_set.add(others);
	        test_set2 = new Set();
	        test_set2.add(odds);
	        if (test_set.subset(test_set2))
	        {
	            dump_error_message("did not expect subset");
	        }
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testSuperset()
    {
    	try
    	{
	        TEST_CASE++;
	
	        Set test_set;
	        test_set = new Set(0, 12);
	        try
	        {
	            if (test_set.superset(null))
	            {
	                dump_error_message("null should not be reported as superset");
	            }
	        }
	        catch(NullPointerException e)
	        {
	            dump_error_message("Null pointer exception thrown on superset");
	        }
	        TEST_CASE++;
	
	        Set test_set2;
	        test_set = new Set(0, 12);
	        test_set2 = new Set(0, 12);
	        if (!test_set.superset(test_set2))
	        {
	            dump_error_message("expected superset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(0, 12);
	        if (!test_set.superset(test_set))
	        {
	            dump_error_message("expected superset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(4, 7);
	        if (test_set.superset(test_set2))
	        {
	            dump_error_message("did not expect superset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(10, 20);
	        test_set2 = new Set(5, 15);
	        if (test_set.superset(test_set2))
	        {
	            dump_error_message("did not expect superset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(10, 20);
	        test_set2 = new Set(15, 25);
	        if (test_set.superset(test_set2))
	        {
	            dump_error_message("did not expect superset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set();
	        test_set2 = new Set();
	        if (!test_set.superset(test_set2))
	        {
	            dump_error_message("expected superset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set();
	        test_set2 = new Set(4, 7);
	        if (!test_set.superset(test_set2))
	        {
	            dump_error_message("expected superset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set();
	        if (test_set.superset(test_set2))
	        {
	            dump_error_message("did not expect superset");
	        }
	        TEST_CASE++;
	
	        test_set = new Set(0, 12);
	        test_set2 = new Set(100, 105);
	        if (test_set.superset(test_set2))
	        {
	            dump_error_message("did not expect superset");
	        }
	        TEST_CASE++;
	
	        Integer[] odds = new Integer[10];
	        Integer[] evens = new Integer[10];
	        for (int j = 0; j < odds.length && j < evens.length; j++)
	        {
	            evens[j] = new Integer(j * 2);
	            odds[j] = new Integer(j * 2 + 1);
	        }
	        test_set = new Set();
	        test_set.add(odds);
	        test_set2 = new Set();
	        test_set2.add(evens);
	        if (test_set.superset(test_set2))
	        {
	            dump_error_message("did not expect superset");
	        }
	        TEST_CASE++;
	
	        // non-modification check
	        test_set = new Set(100, 110);
	        test_set2 = new Set(100, 105);
	        test_set.superset(test_set2);
	        checkContents(test_set.toString(), "100 101 102 103 104 105 106 107 108 109 110");
	
	        Integer[] others = new Integer[10];
	        for (int j = 0; j < others.length && j < odds.length; j++)
	        {
	            others[j] = new Integer(j * 3);
	            odds[j] = new Integer(j * 2 + 1);
	        }
	        test_set = new Set();
	        test_set.add(others);
	        test_set2 = new Set();
	        test_set2.add(odds);
	        if (test_set.superset(test_set2))
	        {
	            dump_error_message("did not expect superset");
	        }
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }

    private static void testBarrage()
    {
    	try
    	{
	        Set test_set = new Set();
	
	        // add [0, 3, 6, 9] --> [0, 3, 6, 9]
	        for (int i = 0; i < 10; i += 3)
	        {
	            test_set.add(new Integer(i));
	        }
	
	        //    NOT remove [2, 4, 8], but remove [0, 6] --> [3, 9]
	        for (int i = 0; i < 10; i += 2)
	        {
	            test_set.remove(new Integer(i));
	        }
	
	        // add [0, 2, 4, 6, 8] --> [0, 2, 3, 4, 6, 8, 9]
	        for (int i = 0; i < 10; i += 2)
	        {
	            test_set.add(new Integer(i));
	        }
	
	        //    NOT remove [4, 8], but remove [0] --> [0, 2, 3, 6, 9]
	        for (int i = 0; i < 10; i += 4)
	        {
	            test_set.remove(new Integer(i));
	        }
	        checkContents(test_set.toString(), "2 3 6 9");
	
	        Set union_set = test_set.union(test_set);
	        checkContents(union_set.toString(), "2 3 6 9");
	        Set intersection_set = test_set.intersection(test_set);
	        checkContents(intersection_set.toString(), "2 3 6 9");
	
	        intersection_set.clear();
	        checkContents(intersection_set.toString(), "");
	
	        int removed = test_set.remove(union_set);
	        if (removed != 4)
	        {
	            dump_error_message("Expected to remove 4, not " + removed);
	        }
	        checkContents(test_set.toString(), "");
    	}
    	catch( Exception exc )
    	{
    		dump_error_message( "Unexpected exception caught: " ) ;
    		exc.printStackTrace( System.out ) ;
    	}
    }
}