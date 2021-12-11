import java.util.ArrayList;

public class Tester
{
	public static void main( String[] args )
	{
		Dog  d = new Dog () ;
		Cat  c = new Cat () ;
		Bird b = new Bird() ;
		Fish f = new Fish() ;
		Fox  x = new Fox () ;
		
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(d);
		animals.add(c);
		animals.add(b);
		animals.add(f);
		animals.add(x);

		for (Animal a:animals) {
			a.PrintDetails(a);
		}
		}
}
