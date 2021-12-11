
public class Lab18
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();

        System.out.println("Original Deck:");
        System.out.println(deck);
        deck.shuffle();

        System.out.println("Shuffled Deck:");
        System.out.println(deck);
        
        Card[] hand = null;
        try
        {
            hand = deck.deal(50);
        }
        catch(DeckException e)
        {
        }

        System.out.println("Cards in the hand: ");
        for (Card card : hand)
        {
            System.out.println(card);
        }

        System.out.println();
        System.out.println("Cards remaining in the deck: ");
        System.out.println(deck);
    }
    
}
