public class Player {
    public static void main(String[] args) throws Exception {
        Die die1 = new Die(); 
        Die die2 = new Die();
        PairOfDice pod1 = new PairOfDice();
        PairOfDice pod2 = new PairOfDice();


        die1.roll();
        System.out.println("1 Die: " + die1.toString());

        die2.roll();
        System.out.println("1 Die: " + die2.toString());

        pod1.roll();
        pod2.roll();
        System.out.println("2 Dice: " + pod1.getRoll());
        System.out.println("2 Dice: " + pod2.getRoll());   
    }
}
