import javax.lang.model.util.ElementScanner6;

/*
 * @Austin Bennett
 * <p> PigDice
 * <p> Project 3
 * <p> This class handles the nitty gritty details of the game.
 */

//
// The rules to the dice game Pig
//
// Number of Players: 2 + 
// Game Duration: 30 mins
// Players Aged: 6 +
//
// You will need: 2 dice and paper to score on.
//
// To Play: The players take turns to roll both dice, 
// they can roll as many times as they want in one turn.
//
// A player scores the sum of the two dice thrown and 
// gradually reaches a higher score as they continue to roll.
//
// If a single number 1 is thrown on either die, the score 
// for that whole turn is lost. However a double 1 counts as 25.
// The first player to 100 wins unless a player scores more 
// subsequently in the same round. This means that everyone in 
// the game must have the same number of turns.
//

// this class manages the state of the dice and the scoring
public class PigDice
{
	// keep track of total and round scores as well as the two dice.
	private int _totalScore = 0;
	private int _roundScore = 0;
	private Die _die1;
	private Die _die2;

	public PigDice()
	{
		_die1 = new Die(); // makes the new die
		_die2 = new Die();
		
	}

	// accessor for total score
	public int currentTotal()
	{
		return _totalScore;
	}

	// accessor for this round score
	public int currentRound()
	{
		return _roundScore;
	}

	// accessor to see if the user has rolled a single "1" and loses turn
	public boolean piggedOut()
	{
		if(singleOneRolled()) {
			_roundScore = 0;
			return true;
		} else
			return false;
	}

	// mutator that simulates rolling two dice and evaluating the resulting score
	public void rollDice()
	{
		// Roll the die
		_die1.roll();
		_die2.roll();

		// Evalulate
		_roundScore += evaluate();
	}

	// accessor for a formatted string of what the last roll looked like
	public String lastRoll()
	{
		return "D1 (" + _die1.faceValue() + "), D2 (" + _die2.faceValue() + ")";
	}

	public int evaluate()
	{
		if(doubleOnesRolled()) //checks if there has been a double 1
			return 25;
		else
			return _die1.faceValue() + _die2.faceValue();
	}

	private boolean singleOneRolled() // checks if there has been a single 1 rolled
	{
        if (_die1.faceValue() == 1 && _die2.faceValue() != 1 || _die2.faceValue() == 1 && _die1.faceValue() != 1) {
			return true;
		} else
			return false;
	}

	private boolean doubleOnesRolled() // checks if there has been a double 1 rolled
	{
		if (_die1.faceValue() == 1 && _die2.faceValue() == 1)
			return true;
		else
			return false;
	}

	//
	// mutator to end a round and keep the add this round to the total
	// also returns the total value of the round and resets the round total for next time
	//
	public int save()
	{
        _totalScore += _roundScore;
		int x = _roundScore;
		_roundScore = 0;
		return x;
	}
}
