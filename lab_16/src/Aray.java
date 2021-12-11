import java.lang.reflect.Array;
import java.util.Random;

public class Aray {
    //Returns the indexof the minimum value in the array.
    public static int findMin(int[] a) {
        int min = 101;
        int length = a.length;
        int index = 0;
        for (int i = 0; i < length; ++i) {
            if (a[i] < min)
                min = a[i];
                index = i;
        }
        return index;
    }

    //Returns the indexof the maximum value in the array.
    public static int findMax(int[] a) {
        int max = 0;
        int length = a.length;
        int index = 0;
        for (int i = 0; i < length; ++i) {
            if (a[i] > max)
                max = a[i];
                index = i;
        }
        return index;
    }

    //Returns the statistical mean of the values in the array.
    public static double mean (int[] a) {
        int sum = 0;
        int length = a.length;
        for (int i = 0; i < length; ++i) {
            sum += a[i];
        }
        return sum / length;
    }

    //Populates the array with a series of integer values between 0 and 100 (inclusive) that are randomly generated. 
    public static void populate(int[] a) {
        Random rnd = new Random();
        for (int i = 0; i < 100; ++i) {
            a[i] = rnd.nextInt(0, 101);
        }
    }
}