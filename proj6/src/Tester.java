import java.util.HashMap;
import java.util.Random;

public abstract class Tester
{
    protected HashMap<String, Integer> _testErrorMap;
    protected Random _rng;
	
    public Tester()
    {
    	_testErrorMap = new HashMap<String, Integer>();
    	_rng = new Random();
    	_rng.setSeed(0); // consistent testing
    }
    
    public abstract void runAll();
    
    public void emitError(String error)
    {
    	System.out.println(error);
    }
}