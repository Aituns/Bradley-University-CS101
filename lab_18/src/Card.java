public class Card
{
    public enum SuitT
    {
        CLUBS ("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");

        private final String description;

        private SuitT(String value) { description = value; }

        public String getDescription() { return description; }
    }

    public enum FaceT
    {
        ACE ("Ace", 1),
        TWO ("Two", 2),
        THREE ("Three", 3),
        FOUR ("Four", 4),
        FIVE ("Five", 5),
        SIX ("Six", 6),
        SEVEN ("Seven", 7),
        EIGHT ("Eight", 8),
        NINE ("Nine", 9),
        TEN ("Ten", 10),
        JACK ("Jack", 11),
        QUEEN ("Queen", 12),
        KING ("King", 13);

        private final String description;
        private final int value;
        
        private FaceT(String desc, int val)
        {
            description = desc;
            value = val;
        }

        public String getDescription() { return description; }
        public int getValue() { return value; }
    }
    
    private SuitT suit;
    private FaceT faceValue;
    

    public Card(SuitT suit, FaceT face)
    {
        this.suit = suit;
        this.faceValue = face;
    }
    
    public String toString()
    {
        return faceValue.getDescription() + " of " + this.suit.getDescription();
    }
}
