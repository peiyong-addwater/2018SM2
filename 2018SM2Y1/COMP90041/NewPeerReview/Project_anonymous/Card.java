/** A playing card rank type designed for cribbage. 
 * 
 * provide the rank and suit of each cards 
 * 
 * 
 * @author Peter Schachte schachte@unimelb.edu.au
 */

public class Card {
	
	
	public CribbageRank rank = null;
	public char suit;
	
	//check the rank and suit for each card
	public Card(char r, char suit) {
		this.rank = CribbageRank.findByChar(r);
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return rank + "" + suit;
	}
	
}
