import java.util.Random;

public class Die {
    
    private int _sides = 6;
    private int _roll;


    public int roll() {
        Random rnd = new Random();
        _roll = rnd.nextInt(_sides) + 1;
        return _roll;
    }
    
    public int getRoll() {
        return _roll;
    }

    public String toString()  {
        switch (_roll) {
            case 1: 
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4: 
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            default:
                return "roll the dice";
        }
    }
}