/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
public class Checking // TODO: refine this to establish proper relationships among accounts.
{
	//
    // TODO: Constructors and other required methods.
    //
	
	@Override
    public boolean link(Account linkAcct)
    {
    	if (linkAcct == null) return false;
    	
		if (linkAcct instanceof Checking) return false;
		
		return super.link(linkAcct);
    }
	
    @Override
    public boolean equals(Object obj)
    {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof Checking)) return false;

    	return super.equals(obj);
    }
	
    @Override
    public String toString()
    {
    	return "Checking " + super.toString();
    }
}
