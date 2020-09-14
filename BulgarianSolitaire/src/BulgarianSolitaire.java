import java.util.ArrayList;
import java.util.Collections;

public class BulgarianSolitaire 
{
	private ArrayList<Integer> board;

	/**
	 * Constructs a board with random size
	 *  and random card values.
	 */
	public BulgarianSolitaire()
	{
		board = new ArrayList<>();
		int cards = 45;

		while(cards > 0)
		{
			int rand = (int) (Math.random() * cards + 1);			// random between 1 and the number of cards, inclusive
			board.add(rand);
			cards -= rand;											// decrements the cards count by rand
		}

		Collections.shuffle(board);
	}

	/**
	 * For a user input board.
	 *
	 * @param board
	 */
	public BulgarianSolitaire(ArrayList<Integer> board)
	{
		this.board = board;
	}

	/**
	 * Decrements each card value in board by 1.
	 *  If the new value of a card is 0, that card
	 *  is removed from the board.
	 */
	public void move()
	{
        int count = board.size();									// saves the size of the board into a count variable

        for (int i = 0; i < board.size(); i++)
        {
        	board.set(i, board.get(i) - 1);							// sets the card at the position to the card - 1
        	if(board.get(i) == 0)									// if that card is now 0
        	{
        		board.remove(i);									// remove the card
        		i--;												// decrement the position to compensate for remove method
        	}
        }

        board.add(count);											// add the count to the end of the array list
	}

	/**
	 * Checks to see if the end game sequence has been reached.
	 *  Sequence is reached when board has the same cards as the
	 *  certain sequence.
	 *
	 * @return
	 */
	public boolean gameOver()
	{
        if(board.size() != 9)										// if the board size is not 9
            return false;
        for (int i = 0; i < 9; i++)
        {
            if(board.get(i) != i + 1)								// if the card at the index does not equal the value of the card + 1
                return false;
        }

        return true;
	}

	/**
	 * @return String display of the card values in the board
	 */
	public String toString()
	{
        return board.toString();
	}
}
