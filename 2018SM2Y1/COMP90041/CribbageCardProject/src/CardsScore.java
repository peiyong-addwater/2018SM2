import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 This is a final (constant and unchangeable) class which provide a
 data structure for the cards in the game Cribbage.
 To successfully compile and run this java class file, the Combinations.java
 file and the CribbageRank.java file
 are required.
 This class for cards and scores will generate the rank,
 suit of the cards (provided by CribbageRank.java)
 and the possible combinations (provided by Combinations.java) in the process.
 This data structure holds the scores from 15s, pairs, runs,
 flushes and one for his nob.
 */
public final class CardsScore
{
        //private String[] cardStrings;
        //Initialize all five kinds of scores with zero.
        private int fifteensScoresInt = 0;
        private int pairsScoresInt = 0;
        private int runsScoresInt = 0;
        private int flushesScoresInt = 0;
        private int oneForHisNobScoresInt = 0;
        private int totalScoresInt = 0;
        


        /**
         * Create a Cards instance and get its parameters
         * from the input String[]
         */
        public CardsScore(String[] cardStrings)
        {
                /*
                Firstly, we need to separate rank and suit from the
                input strings representing cards.
                Each card is represented by a two-character string,
                such as "AC", of which A means Ace(ranks 1),
                and C means club, and "4D", of which 4 means rank 4,
                and D means diamond.

                 */
                String[] rankOfCardStrings = this.getRanksOfCards(cardStrings);
                String[] suitOfCardStrings = this.getSuitOfCards(cardStrings);
                String[][] combinationOfCardsStrings =
                        Combinations.combinations(rankOfCardStrings);
                this.oneForHisNobScoresInt =
                        this.oneForHisNob(suitOfCardStrings,rankOfCardStrings);
                this.flushesScoresInt =
                        this.flushes(suitOfCardStrings);
                this.pairsScoresInt =
                        this.pairs(combinationOfCardsStrings);
                this.fifteensScoresInt =
                        this.fifteens(combinationOfCardsStrings);
                this.runsScoresInt = this.runs(rankOfCardStrings,
                        combinationOfCardsStrings);
                this.totalScoresInt =
                        this.fifteensScoresInt+
                                this.oneForHisNobScoresInt+
                                this.flushesScoresInt+
                                this.pairsScoresInt+
                                this.runsScoresInt;
        }

        /**
         * This is a private method to get the ranks of input cards
         * @param cardStrings an array of strings holds the cards
         * @return ranks string
         */
        private String[] getRanksOfCards(String[] cardStrings)
        {
                String[] rankOfCardStrings = new String[cardStrings.length];
                for (int i=0; i<cardStrings.length; i++)
                {
                        rankOfCardStrings[i] =
                                Character.toString(cardStrings[i].charAt(0));
                }
                return rankOfCardStrings;
        }

        /**
         * This is a private method to get the suits of input cards
         * @param cardStrings an array of strings holds the cards
         * @return suits string
         */
        private String[] getSuitOfCards(String[] cardStrings)
        {
                String[] suitOfCardStrings = new String[cardStrings.length];
                for (int i=0; i<cardStrings.length; i++)
                {
                        suitOfCardStrings[i] =
                                Character.toString(cardStrings[i].charAt(1));
                }
                return suitOfCardStrings;
        }


        /**
         * Following private method calculate scores from "one for his nob"
         * One point will be assigned to oneForHisNobScoresInt if the hand
         * contains the jack (J) of the same suit
         * as the start card
         * @param suitStrings an array of strings
         *                    holds the suits of input cards.
         * @param rankStrings an array of strings
         *                    holds the ranks of input cards.
         * @return 1 if there exists one for his nob and 0 vice versa.
         */
        private int oneForHisNob(String[] suitStrings, String[] rankStrings)
        {
                for(int i = 0; i < suitStrings.length-1; i++)
                {
                        boolean suitCheck1Bool=
                                suitStrings[i].equals
                                        (suitStrings[suitStrings.length-1]);
                        boolean rankCheck1Bool =
                                rankStrings[i].charAt(0) ==
                                        CribbageRank.JACK.abbrev();
                        boolean suitRankBool =
                                suitCheck1Bool && rankCheck1Bool;
                        if(suitRankBool)
                        {
                                return 1;
                        }
                }
                return 0;
        }

        /**
         * Following private method calculate scores for "flushes"
         * If all four hand cards share the same suit,
         * player will get 4 points,
         * if the start card shares the same suit
         * as all of the four hand cards,
         * the player get one more points.
         * We use initialScoreInt as an intermediate variable.
         * Initially it is set to 1.
         * And then we check whether card number 2, 3, 4, 5
         * has the same suit as card 1.
         * Every time we have a positive result we will add 1 to initialScore.
         * Then we check whether initialScoreInt is <4, ==4 or >4.
         * If it is smaller than 4, flushesScoresInt
         * will remain zero as initialized. If  initialScoreInt=4,
         * flushesScoresInt will be set to 4 and if it
         * is 5 flushesScoresInt will be set to 5.
         * @param suitStrings an array of strings holding
         *                    the suits of input cards
         * @return score for flushes
         */
        private int flushes(String[] suitStrings)
        {
                String suitOneString = suitStrings[0];
                int initialScoreInt = 1;
                for (int i = 1; i < suitStrings.length; i++)
                {
                        if(suitOneString.equals(suitStrings[i]))
                        {
                                initialScoreInt++;
                        }
                }
                if (initialScoreInt >= 4)
                {
                        return initialScoreInt;
                }
                else {
                        return 0;
                }
        }

        /**
         * Following private method calculates the
         * scores from pairs in the five input cards
         * if there are 3 or more cards share the same rank,
         * the total number of pairs
         * will be $C^2_{number of cards in the same rank}$
         * for example, 3 cards shares the same rank and there
         * will be $C^2_3 = 3$ pairs
         * 4 cards shares the same rank and there
         * will be $C^2_4 = 6$ pairs
         * @param ranksComboStrings the combination of ranks
         * @return scores for pairs
         */
        private int pairs(String[][] ranksComboStrings)
        {
                int pairsCountHolderInt = 0;
                // counts the number of pairs
                for (String [] ranksStrings: ranksComboStrings)
                {
                        boolean lengthCheckBool =
                                ranksStrings.length == 2;
                        /* pairs means the length of the combination
                        result must be two. */

                        if (lengthCheckBool)
                        {
                                boolean pairCheckBool =
                                ranksStrings[0].equals(ranksStrings[1]);
                                if(pairCheckBool)
                                {
                                        pairsCountHolderInt++;
                                }
                        }
                }
                return pairsCountHolderInt * 2;
                //each pair gets 2 points of score
        }

        /**
         * This private method calculates the scores for 15s in the input
         * five cards. Each combination that the face values of the cards
         * sums up to 15 gets two points of score.
         * @param ranksComboStrings an 2-d array holds the combinations of
         *                          cards
         * @return scores for 15s
         */
        private int fifteens(String[][] ranksComboStrings)
        {
                int comboCountInt = 0;
                for (String[] ranksStrings:ranksComboStrings)
                {
                        int faceValueCountInt = 0;
                        for (String faceValueString:ranksStrings)
                        {
                                faceValueCountInt = faceValueCountInt+
                                        stringToCribbageRankObjFaceValue
                                                (faceValueString);
                        }
                        if(faceValueCountInt==15)
                        {
                                comboCountInt++;
                        }
                }
                return  comboCountInt*2;
        }

        /**
         * Check if there's a run of 3 or more continuous cards in ranks (no
         * need to consider suit)
         * @param ranksString ranks of cards
         * @param ranksComboStrings combination of ranks
         * @return scores for runs.
         */
        private int runs(String[] ranksString, String[][] ranksComboStrings)
        {
                int[] longestRunLengthInts = new int[ranksString.length+1];
                for (String[] ranksFromComboString: ranksComboStrings)
                {
                        if(ranksFromComboString.length > 2)
                        {
                                int[] rankValueArrayInts =
                                        constructIntArrayForRuns
                                                (ranksFromComboString);
                                boolean checkDupBool =
                                        checkDuplicate(rankValueArrayInts);
                                boolean checkContinuousBool =
                                        isContinuousArray(rankValueArrayInts);
                                if (checkContinuousBool && checkDupBool)
                                {
                                        longestRunLengthInts
                                                [ranksFromComboString.length]
                                                = longestRunLengthInts
                                                [ranksFromComboString.length]
                                                + 1;

                                }
                        }
                }
                for (int i = ranksString.length; i>0; i--)
                {
                        if (longestRunLengthInts[i]>0)
                        {
                                return longestRunLengthInts[i]*i;
                        }
                }
                return 0;
        }

        /**
         * This is a private method to check whether a int array is
         * continuous or not. If it is continuous, the difference between
         * its max and min values should equal to array length - 1
         * @param arrayInts an array of integers
         * @return true for continuous and false if not continuous
         */
        private boolean isContinuousArray(int[] arrayInts)
        {
                Arrays.sort(arrayInts);
                int highLowDiffInt =
                        Math.abs(arrayInts[arrayInts.length-1]-arrayInts[0]);
                int lengthMinusOneInt = arrayInts.length-1;
                boolean checkBool = highLowDiffInt == lengthMinusOneInt;
                return checkBool;
                // true for a continuous array and false vice versa
        }

        /**
         * This is a private method to check whether there are duplicates in
         * an array
         * @param arrayInts an array of ints
         * @return true for no duplicates false for duplicates
         */
        private boolean checkDuplicate(int[] arrayInts)
        {
                HashSet<Integer> set = new HashSet<Integer>();
                for(int integer: arrayInts)
                {
                        set.add(integer);
                }
                boolean sizeLengthCheckBool;
                sizeLengthCheckBool = set.size()==arrayInts.length;
                return sizeLengthCheckBool;
                //true for no duplicates and false for duplicates
        }

        /**
         * This is a private method that takes an array of ranks as input and
         * returns an array of ints
         * This private method is for the method to calculate scores from runs
         * @param ranksStrings an array of strings holds the ranks of the cards
         * @return an array of integers in which J is 11, Q is 12 and King
         * is 13.
         */
        private int [] constructIntArrayForRuns(String[] ranksStrings)
        {
                int[] rankNumberInts = new int[ranksStrings.length];
                for(int i = 0; i < ranksStrings.length; i++)
                {
                        boolean checkJackBool;
                        checkJackBool =
                                Objects.equals(
                                        getCribbageRankObject(ranksStrings[i]),
                                        CribbageRank.JACK);
                        boolean checkQueenBool;
                        checkQueenBool =
                                Objects.equals(
                                        getCribbageRankObject(ranksStrings[i]),
                                        CribbageRank.QUEEN);
                        boolean checkKingBool;
                        checkKingBool =
                                Objects.equals(
                                        getCribbageRankObject(ranksStrings[i]),
                                        CribbageRank.KING);
                        if(checkJackBool)
                        {
                                rankNumberInts[i] = 11;
                        }
                        else if(checkKingBool)
                        {
                                rankNumberInts[i] = 13;
                        }
                        else if (checkQueenBool)
                        {
                                rankNumberInts[i] = 12;
                        }
                        else
                        {
                                rankNumberInts[i] =
                                        stringToCribbageRankObjFaceValue
                                                (ranksStrings[i]);
                        }
                }
                return rankNumberInts;
        }

        /**
         * This private method takes an string of
         * card rank abbreviation as input
         * and returns the face value of this rank by calling
         * the CribbageRank class.
         * @param rankString a string of card rank from the results
         *                   of Combinations.java
         * @return the face value of the card
         */
        private int stringToCribbageRankObjFaceValue(String rankString)
        {
                for (CribbageRank rankCribbageRank: CribbageRank.values())
                {
                        boolean checkAbbrevBool =
                                rankCribbageRank.abbrev()==
                                        rankString.charAt(0);
                        if (checkAbbrevBool)
                        {
                                return rankCribbageRank.faceValue();
                        }
                }
                return 0;
        }

        /**
         * This private method takes the rank of a card as input
         * and returns the enum object of a card
         * @param rankString a string that holds the rank of a card
         * @return an enum object of CribbageRank
         */
        private CribbageRank getCribbageRankObject(String rankString)
        {
                for(CribbageRank ranks: CribbageRank.values())
                {
                        boolean checkAbbrevBool =
                                ranks.abbrev()==rankString.charAt(0);
                        if(checkAbbrevBool)
                        {
                                return ranks;
                        }
                }
                return null;
        }

        //getters and setters
        /**
         * getter for the scores from 15s
         * @return 15s scores
         */
        public int getFifteensScoresInt()
        {
                return this.fifteensScoresInt;
        }

        /**
         * getter for the scores from pairs
         * @return scores for pairs
         */
        public int getPairsScoresInt()
        {
                return this.pairsScoresInt;
        }

        /**
         * getter for the scores from runs
         * @return scores for runs
         */
        public int getRunsScoresInt()
        {
                return this.runsScoresInt;
        }

        /**
         * getter for the scores from flushes
         * @return scores for flushes
         */
        public int getFlushesScoresInt()
        {
                return this.flushesScoresInt;
        }

        /**
         * getter for scores from one for his nobs
         * @return scores for one for his nobs
         */
        public int getOneForHisNobScoresInt()
        {
                return this.oneForHisNobScoresInt;
        }

        /**
         * getter for total scores
         * @return total scores
         */
        public int getTotalScoresInt()
        {
                return totalScoresInt;
        }
}
