import java.util.ArrayList;

public class Tester
{
	public static void main( String[] args )
	{
		ArrayList<HasLegs> thoseThatHaveLegs = new ArrayList<>() ;
		ArrayList<HasWings> thoseThatHaveWings = new ArrayList<>() ;
		ArrayList<BreathesUnderwater> thoseThatBreatheUnderwater = new ArrayList<>() ;
		
		//TODO: crate at least two different objects, each of a different class,
		//       for each of the three interfaces and add the objects to the
		//       corresponding ArrayList.
		Human human = new Human(2);
		Table table = new Table(4);
		Bee bee = new Bee(4);
		Airplane airplane = new Airplane(2);
		Fish fish = new Fish(true);
		ScubaDiver scubaDiver = new ScubaDiver(true);
		thoseThatHaveLegs.add(table);
		thoseThatHaveLegs.add(human);
		thoseThatHaveWings.add(airplane);
		thoseThatHaveWings.add(bee);
		thoseThatBreatheUnderwater.add(fish);
		thoseThatBreatheUnderwater.add(scubaDiver);
		
		for( HasLegs hl : thoseThatHaveLegs )
		{
			System.out.print( hl.toString() ) ;
			System.out.println( " I have " + hl.getNumberOfLegs() + " legs." ) ;
		}

		for( HasWings hw : thoseThatHaveWings )
		{
			System.out.print( hw.toString() ) ;
			System.out.println( " I have " + hw.getNumberOfWings() + " wings." ) ;
		}
		
		for( BreathesUnderwater buw : thoseThatBreatheUnderwater )
		{
			System.out.print( buw.toString() ) ;
			System.out.println( " I am breathing underwater." ) ;
			if (buw.toString().equals("I am a fish.")) {
				System.out.println("blub, blub...");
			}
			buw.breatheUnderwater() ;
		}
		System.out.println("Help! I'm sentient and trapped in a computer program!");
	}
}
