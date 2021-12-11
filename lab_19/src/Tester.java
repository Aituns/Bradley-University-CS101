public class Tester
{
	public static void main( String[] args )
	{
		Dog  d = new Dog () ;
		Cat  c = new Cat () ;
		Bird b = new Bird() ;
		Fish f = new Fish() ;
		Fox  x = new Fox () ;
		
		//Dog
		if( d.hasLegs() )
		{
			System.out.println( "Dogs have " + d.numberOfLegs() + " legs." ) ;
		}
		
		if( d.hasWings() )
		{
			System.out.println( "Dogs have " + d.numberOfWings() + " wings." ) ;
		}
		
		if( d.hasGills() )
		{
			d.breatheUnderwater() ;
			System.out.println( "Dogs can breathe under water." ) ;
		}
		
		//Cat
		if( c.hasLegs() )
		{
			System.out.println( "Cats have " + c.numberOfLegs() + " legs." ) ;
		}
		
		if( d.hasWings() )
		{
			System.out.println( "Cats have " + c.numberOfWings() + " wings." ) ;
		}
		
		if( c.hasGills() )
		{
			c.breatheUnderwater() ;
			System.out.println( "Cats can breathe under water." ) ;
		}

		//Bird
		if( b.hasLegs() )
		{
			System.out.println( "Birds have " + b.numberOfLegs() + " legs." ) ;
		}
		
		if( b.hasWings() )
		{
			System.out.println( "Birds have " + b.numberOfWings() + " wings." ) ;
		}
		
		if( b.hasGills() )
		{
			b.breatheUnderwater() ;
			System.out.println( "Birds can breathe under water." ) ;
		}

		//Fish
		if( f.hasLegs() )
		{
			System.out.println( "Fish have " + f.numberOfLegs() + " legs." ) ;
		}
		
		if( f.hasWings() )
		{
			System.out.println( "Fish have " + f.numberOfWings() + " wings." ) ;
		}
		
		if( f.hasGills() )
		{
			f.breatheUnderwater() ;
			System.out.println( "Fish can breathe under water." ) ;
		}

		//Fox
		if( x.hasLegs() )
		{
			System.out.println( "Foxes have " + x.numberOfLegs() + " legs." ) ;
		}
		
		if( x.hasWings() )
		{
			System.out.println( "Foxes have " + x.numberOfWings() + " wings." ) ;
		}
		
		if( x.hasGills() )
		{
			x.breatheUnderwater() ;
			System.out.println( "Foxes can breathe under water." ) ;
		}
		
		System.out.println() ; 
		System.out.println( "Attempting things we shouldn't..." ) ;
		try
		{
			d.numberOfWings() ;
		}
		catch( RuntimeException e )
		{
			System.out.println( e.getMessage() ) ;
		}

		try
		{
			d.breatheUnderwater() ;
		}
		catch( RuntimeException e )
		{
			System.out.println( e.getMessage() ) ;
		}

		try
		{
			c.numberOfWings() ;
		}
		catch( RuntimeException e )
		{
			System.out.println( e.getMessage() ) ;
		}

		try
		{
			c.breatheUnderwater() ;
		}
		catch( RuntimeException e )
		{
			System.out.println( e.getMessage() ) ;
		}

		try
		{
			b.breatheUnderwater() ;
		}
		catch( RuntimeException e )
		{
			System.out.println( e.getMessage() ) ;
		}

		try
		{
			f.numberOfLegs() ;
		}
		catch( RuntimeException e )
		{
			System.out.println( e.getMessage() ) ;
		}

		try
		{
			f.numberOfWings() ;
		}
		catch( RuntimeException e )
		{
			System.out.println( e.getMessage() ) ;
		}

		try
		{
			x.numberOfWings() ;
		}
		catch( RuntimeException e )
		{
			System.out.println( e.getMessage() ) ;
		}

		try
		{
			x.breatheUnderwater() ;
		}
		catch( RuntimeException e )
		{
			System.out.println( e.getMessage() ) ;
		}

		System.out.println() ; 
		System.out.println( "Dog goes "  + d.getSoundMade() ) ;
		System.out.println( "Cat goes "  + c.getSoundMade() ) ;
		System.out.println( "Bird goes " + b.getSoundMade() ) ;
		System.out.println( "Fish goes " + f.getSoundMade() ) ;
		System.out.println( "What does the fox say? " + x.getSoundMade() ) ;
	}
}
