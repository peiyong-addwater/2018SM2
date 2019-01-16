/*
 * Last Modified 2018.
 * Main class that receives 5 cards on the command
 * line and will print out only the number of points
 * the hand comprising the first four of those cards
 * would score if the fifth card were the start card
 */

public class HandValue
{
        public static void main(String[] args)
        {
                CardsScore cardsInputStrings = new CardsScore(args);
                System.out.println(cardsInputStrings.getTotalScoresInt());
        }
}
