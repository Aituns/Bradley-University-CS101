/***************************************************************
<Austin Bennett>
<Rational.java>
<Project 4 - Rational Class>
<This class will reduce a rational. add, subtract, multiply, or multiply it against another rational. output the fraction to a string>
***************************************************************/

import java.lang.Math.*;

public class Rational implements Comparable
{
	// Initializing Variables
	long _numer;
	long _denom;

	// Default Contructor
	public Rational()
	{
		_numer = 0;
		_denom = 1;
	}

	// Overloaded Contructor for only one arguement
	public Rational(long a)
	{
		_numer = a;
		_denom = 1;
	}

	// Overloaded Contructor to create and reduce the given fraction
	public Rational(long a, long b) throws ArithmeticException
	{
		// Checks for stupid humans making a bad rational
		if (a == 0 || b == 0)
		{
			_numer = 0;
			_denom = 1;
		} 
		else 
		{ // reduces the fraction
			long temp = gcd(a, b);
			_numer = a / temp;
			if(b == 0) // Checks for stupid humans having a zero denominator
				throw new ArithmeticException("Denominator cannot be zero");
			_denom = b / temp;
			if (_numer < 0 || _denom < 0) 
			{ // Properly writes negative fractions
				_numer = Math.abs(_numer);
				_denom = Math.abs(_denom);
				_numer = 0 - _numer;
			}
		}
	}

	// Accesor for the _denom variable
	public long getDenominator()
	{
		return _denom;
	}

	// Accessor for the _numer variable
	public long getNumerator()
	{	
		return _numer;
	}

	// Handles Adding the two rationals
	public Rational add(Rational r)
	{
		// Makes sure user is actually adding a real number
		if (r == null)
			return new Rational(_numer, _denom);
		else 
		{
			// a/b + c/d = a*d + b*c / b*d
			long numerator = _numer * r.getDenominator() + _denom * r.getNumerator();
			long denominator = _denom * r.getDenominator();
			return new Rational(numerator, denominator);
		}
	}

	// Handles Subtracting the two rationals
	public Rational subtract(Rational r)
	{
		// Makes sure user is actually subtracting a real number
		if (r == null)
			return new Rational(_numer, _denom);
		else 
		{
			// a/b - c/d = a*d - b*c / b*d
			long numerator = _numer * r.getDenominator() - _denom * r.getNumerator();
			long denominator = _denom * r.getDenominator();
			return new Rational(numerator, denominator);
		}
	}

	// Handles Multiplying the two rationals
	public Rational multiply(Rational r)
	{
		// Makes sure user is actually multiplying by a real number
		if (r == null)
			return new Rational(0, 0);
		else 
		{
			// a/b * c/d = a*c / b*d
			long numerator = _numer * r.getNumerator();
			long denominator = _denom * r.getDenominator();
			return new Rational(numerator, denominator);
		}
	}

	// Handles Dividing the two rationals
	public Rational divide(Rational r)
	{	
		// Makes sure user is actually dividing by a real number
		if (r == null)
			throw new ArithmeticException();
		else 
		{
			// a/b / c/d = a*d / b*c
			long numerator = _numer * r.getDenominator(); 
			long denominator = _denom * r.getNumerator();
			return new Rational(numerator, denominator);
		}	
	}

	//
	// Find the Greatest Common Divisor of Two Integers
	//
	public long gcd(long p, long q)
	{
		if (q == 0)
			return p;
		else
			return gcd(q, p % q); // recursive function to find the gcd

	}
	public String toString()
	{
		if (_denom == 1 || _denom == -1) return "" + _numer;
		return _numer + "/" + _denom;
	}

	
	public int compareTo(Object obj)
	{
      if (obj == null) return -1;
		if (!(obj instanceof Rational)) return 1;
		if (this.equals((Rational)(obj))) return 0;
		return (this.subtract((Rational)(obj)).getNumerator() > 0 ? 1 : -1);
	}

	// Returns true if and only if obj are the same number or reference the same object
	public boolean equals(Object obj)
	{
		if (obj == null) return false;
		if (obj == this) return true;
		if (this.subtract((Rational)obj).getNumerator() == 0) return true;
		return false;
	}
	
}