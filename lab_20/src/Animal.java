import javax.management.RuntimeErrorException;

public abstract class Animal
{
	//TODO: private member variables
	private String _soundMade;
	private String _type;
	private boolean _hasLegs;
	private boolean _hasWings;
	private boolean _hasGills;
	
	public Animal( String soundMade, boolean hasLegs, boolean hasWings, boolean hasGills, String type)
	{
		_soundMade = soundMade;
		_hasLegs = hasLegs;
		_hasWings = hasWings;
		_hasGills = hasGills;
		_type = type;
	}

	public String getType() 
	{
		return _type;
	}
	
	public String getSoundMade()
	{
		return _soundMade;
	}

	public boolean hasLegs()
	{
		return _hasLegs;
	}

	public boolean hasWings()
	{
		return _hasWings;
	}

	public boolean hasGills()
	{
		return _hasGills;
	}
	public abstract int numberOfLegs();
	public abstract int numberOfWings();
	public abstract void breatheUnderwater();

	public void PrintDetails(Animal a) {
		String type = getType();
		try {
			int legs = numberOfLegs();
			System.out.println("A " + type + " has " + legs + " legs");
		} catch(RuntimeException e) {}
		try {
			int wings = numberOfWings();
			System.out.println("A " + type + " has " + wings + " wings");
		} catch(RuntimeException e) {}
		try {
			breatheUnderwater();
		} catch(RuntimeException e) {}
		try {
			String sound = getSoundMade();
			System.out.println("A " + type + " makes the sound " + sound);
		} catch (RuntimeException e) {}
	}
}
