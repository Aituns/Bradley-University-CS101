public class PairOfDice {
    Die die1 = new Die();
    Die die2 = new Die(3);
    int _sides;
    
    public void PairOfDice() {
        _sides = 6;
    }

    public void PairOfDice(int sides) {
        _sides = sides;
    }

    public void roll() {
        die1.roll();
        die2.roll();
    }

    public int getRoll() {
        return die1.getRoll() + die2.getRoll();
    }    
}