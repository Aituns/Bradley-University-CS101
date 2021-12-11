/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
public class Main
{
	public static void main(String[] args)
    {
        AccountTester acctTester = new AccountTester();
        BankTester bankTester = new BankTester();

		System.out.println("\nAccount Tests:\n");
        acctTester.runAll();
        
		System.out.println("\nBank Tests:\n");
        bankTester.runAll();
	}
}
