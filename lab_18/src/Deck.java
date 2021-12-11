import java.util.Random;

public class Deck
{
    private final int DECK_SIZE = 52;
    private Card[] _deck;

    // Top of the deck is index 0; bottom is index 51.
    private int currentTop;
    
    //
    // Allocates a default deck of 52 cards with four suits.
    //
    public Deck()
    {
        _deck = new Card[DECK_SIZE];
        currentTop = 0;
        
        int index = 0;
        for (Card.SuitT suit : Card.SuitT.values())
        {
            for (Card.FaceT face : Card.FaceT.values())
            {
                _deck[index++] = new Card(suit, face);
            }
        }
    }
    
    //
    // May assume a full deck.
    //
    // Shuffles by switching two random cards in the deck many times.
    //
    public void shuffle()
    {
        Random rng = new Random();
        
        final int ITERATIONS = 1000;
        for (int count = 0; count < ITERATIONS; count++) {
            int firstCard = rng.nextInt(52);
            int secondCard = rng.nextInt(52);
            Card tempCard = _deck[firstCard];
            _deck[firstCard] = _deck[secondCard];
            _deck[secondCard] = tempCard;	
        }
    }

    //
    // Computes the number of cards that remain in the deck:
    // deck count minus the current top index
    //
    public int cardsRemaining()
    {
        return DECK_SIZE - currentTop;
    }
    
    //
    // Returns the top card from the deck.
    //
    public Card deal() throws DeckException
    {
        if(currentTop >= DECK_SIZE) {
            throw new DeckException("Empty Deck");
        }
        currentTop++;
        return _deck[currentTop];
    }

    //
    // Returns the top card from the deck.
    //
    public Card[] deal(int numCards) throws DeckException
    {
        Card[] dealCard = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            Card card = deal();
            dealCard[i] = card;
        }
        return dealCard;
    }
    
    
    //
    // Builds and returns a meaningful representation of the cards that
    // remain in the deck.
    //
    public String toString()
    {
        String retStr = "";

        for (int i = currentTop; i < DECK_SIZE; i++) {
            retStr += _deck[i].toString() + ", ";
        }

        return retStr + "\n";
    }
}
