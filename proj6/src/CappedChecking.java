/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
public class CappedChecking // TODO: refine this to establish proper relationships among accounts.
{
	//
    // TODO: Constructors and other required methods.
    //
	
    @Override
    public boolean equals(Object obj)
    {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof CappedChecking)) return false;

    	return super.equals(obj);
    }
	
    @Override
    public String toString()
    {
    	return "Capped-Checking " + super.toString();
    }
}
