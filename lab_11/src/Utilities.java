import java.math.BigInteger;

public class Utilities {
    
    public static int abs(int num) {
        if (num < 0) 
            num *= -1;
        return num;
    }

    public static int ceiling(double num) {
        double x = num % 1;
        if (x < .5)
            num -= x;
        else if (x >= .5)
            num += x;
        return (int) num;
    }

    public static BigInteger fact(int x) {
        BigInteger fact = new BigInteger("1");

        for (int i = 2; i <= x; i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        
        return fact;
    }

    public static String stars(int x) {
        String s = "";
        
        for (int i = 1; i <= x; ++i) {
            for (int j = 1; j <= i; ++j) {
                s += "*";
            }
            s += " ";
        }
            return s;
    }
}
