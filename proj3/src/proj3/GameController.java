/*
 * @Austin Bennett
 * <p> GameController
 * <p> Project 3
 * <p> This class is in charge of running the game.
 */

/*
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
*/

import java.util.Scanner;

public class GameController {
	// central method to start and manage game play
	public void play() {
		//initialize variables
		Scanner kb = new Scanner(System.in);
		PigDice pd1;
		PigDice pd2;
		int maxScore = getInitialMax(kb);

		do { //the main loop of the game
			pd1 = new PigDice(); //makes new PigDice so that the score resets after each game
			pd2 = new PigDice();
			while (true) { //loops until there is a winner
				System.out.println("\nPLAYER 1"); //Player 1's turn
				takeTurn(kb, pd1);

				System.out.println("\nPLAYER 2"); //Player 2's turn
				takeTurn(kb, pd2);
				
				if (pd2.currentTotal() >= maxScore) //checks for a winner
					break;
				if (pd1.currentTotal() >= maxScore)
					break;

				System.out.println("\n\nPLAYER 1: " + pd1.currentTotal() + " -- Player 2: " + pd2.currentTotal() + "\n\n"); // prints totals
			}
			System.out.println("\n\nPLAYER 1: " + pd1.currentTotal() + " -- Player 2: " + pd2.currentTotal() + "\n\n");
			System.out.println("Do you want to play again? (Y/N)");
		} while (yesResponse(kb)); //gets response from user
	}

	//
	// Returns the initial max score (loops until a value between 1 <= score <= 100
	// is entered)
	//
	private int getInitialMax(Scanner kb)
	{
		while (true) {
			System.out.println("What score would you like to play to? (100 max)");
			int maxScore = Integer.parseInt(kb.nextLine());
			if (maxScore >= 1 && maxScore <= 100) //checks the input
				return maxScore;
		}
	}

	//
	// method for managing a single session of rolling dice
	//
	private void takeTurn(Scanner kb, PigDice pd) {
		String response;
		boolean keepRolling = true;

		do {
			// Roll the dice
			pd.rollDice();

			// Report the result
			System.out.println(pd.lastRoll() + " scored " + pd.evaluate() + " points.");

			// Did the player pig out?
			if (pd.piggedOut()) {
				System.out.println("You pigged out this turn.");
			} else {
				//
				// Roll again; see if the user wants to roll again to add to total or pass and
				// keep current points
				//
				System.out.println(
						"Your current roll is " + pd.currentRound() + " points. Keep rolling? Respond (Y/N) only.");

				if (!yesResponse(kb)) {
					keepRolling = false;
					int roundScore = pd.save();
					System.out.printf("Your total for the round was %d and your total score is %d.\r\n", roundScore,
							pd.currentTotal());
				}
			}

		} while (!pd.piggedOut() && keepRolling);
	}

	//
	// Returns true if the user enters a 'y' or 'Y'
	//
	final String _YES = "Y";
	public boolean yesResponse(Scanner kb) {
		return kb.nextLine().substring(0, 1).toUpperCase().equals(_YES);
	}
}
