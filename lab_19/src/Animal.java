import javax.management.RuntimeErrorException;

public class Animal
{
	//TODO: private member variables
	private String _soundMade;
	private boolean _hasLegs;
	private boolean _hasWings;
	private boolean _hasGills;
	
	public Animal( String soundMade, boolean hasLegs, boolean hasWings, boolean hasGills )
	{
		_soundMade = soundMade;
		_hasLegs = hasLegs;
		_hasWings = hasWings;
		_hasGills = hasGills;
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

	public int numberOfLegs()
	{
		throw new RuntimeException("Unknown # of Legs");
	}

	public int numberOfWings()
	{
		throw new RuntimeException("Unknown # of Wings");
	}
	
	public void breatheUnderwater()
	{
		throw new RuntimeException("Unknown if animal can breathe underwater.");
	}
}
