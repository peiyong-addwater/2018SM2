// Purpose: to select a hand in cribbage to maximise the chances of having a
//          good hand once the start card is selected.
//          Points are scored for combinations of cards according to rules
//          including 15s, Pairs, Runs, Flushes, "One for his nob". I use
//          corresponding functions to calculate scores of each rules. To
//          better organize the input, i design a class called Card and an
//          extend class DistinctCard which is used to contain cards of
//          different values.
//          The main function is combination of input to select four cards
//          making a hand. And a for-loop is used to get the expectation of
//          scores when different start card is selected.
// main function
// use Card.java DistinctCard.java

import java.util.ArrayList;

public class SelectHand {
    static final int numOfHandCard = 4;

    private static Card[] transform(String[] args) { //transform the input
        Card[] cardSet = new Card[args.length];
        for (int i = 0; i < args.length; i++) {
            String str = args[i];
            String subStr = str.substring(0, 1);
            char tmpType = str.charAt(1);
            int tmpValue;
            switch (subStr) {
                case "A":
                    tmpValue = 1;
                    break;
                case "T":
                    tmpValue = 10;
                    break;
                case "J":
                    tmpValue = 11;
                    break;
                case "Q":
                    tmpValue = 12;
                    break;
                case "K":
                    tmpValue = 13;
                    break;
                default:
                    tmpValue = Integer.parseInt(subStr);
                    break;
            }
            cardSet[i] = new Card(tmpValue, tmpType);
        }
        return cardSet;
    }

    public static void main(String[] args) {
        Card[] bestChoice = new Card[numOfHandCard + 1];
        // hand card plus start card, 5 in total
        for (int i = 0; i < numOfHandCard + 1; i++) {        //initialize
            bestChoice[i] = new Card();
        }
        Card[] cardSet = transform(args);
        final char[] type = new char[]{'S', 'H', 'D', 'C'};
        int max = 0;
        // cope with 4 cards situation
        if (args.length == numOfHandCard) {
            Card.printCard(cardSet, numOfHandCard);
            return;
        }
        // cope with 5 or 6 cards situation
        for (int n = 15;
             n < 15 * Math.pow(2, args.length - numOfHandCard) + 1; ) {
//                use 4 bits to represent the hand card.
//                initial: binary form 1111. We have 4 card at least and every
//                time we get one more card, we multiply 15 by 2, so there are
//                one more bit to represent a card in combination
            int index = 0;
            int score = 0;
//            Card.printCard(cardSet);          // for debug
            Card[] currCardSet = new Card[numOfHandCard + 1];
            for (int i = 0; i < numOfHandCard + 1; i++) {       //  initialize
                currCardSet[i] = new Card();
            }
            String binStr = Integer.toBinaryString(n);
//                                        n has 4 ones in binary form
            for (int i = 0; i < binStr.length(); i++) {     // choose 4 cards
                if (binStr.charAt(binStr.length() - 1 - i) == '1') {
                    Card.copy(cardSet[i], currCardSet[index]);
                    index++;
                }
            }
//            Card.printCard(currCardSet);  //for debug

            for (int k = 1; k < 14; k++) {      // A to K
                for (char t : type) {           // type in { H S C D }
                    boolean flag = true;
                    Card startCard = new Card(k, t);
//                  exclude hand card
                    for (int l = 0; l < numOfHandCard; l++) {
                        if (startCard.getValue() == currCardSet[l].getValue()
                                && startCard.getType()
                                == currCardSet[l].getType())
                            flag = false;
                    }
                    if (flag) {
                        Card.copy(startCard, currCardSet[numOfHandCard]);
                        score += evaluate(currCardSet);
                    }
                }
            }

            if (max < score) {
                max = score;
                Card.copy(currCardSet, bestChoice);
            }
//             combination using bit operation
            int biRMost1 = n & (-n);
            //  find the rightmost 1 bit in binary string
            n = (n + biRMost1) | (((n ^ (n + biRMost1)) / biRMost1) >> 2);
            // by this formula we can find the minimum binary number
            // which has the same number of ones and larger than current n

        }

        Card.printCard(bestChoice, numOfHandCard);
    }


    private static int evaluate(Card[] originalCardSet) {
        Card[] orderedCardSet = new Card[originalCardSet.length];
        Card.copy(originalCardSet, orderedCardSet);
        Card.sort(orderedCardSet);
//        Card.printCard(cardSet);
        DistinctCard[] distinctCard = distinctTreat(orderedCardSet);
        //get distinct cards

        int scoreOfFifteens = fifteens(orderedCardSet);
        int scoreOfPair = pairs(distinctCard);
        int scoreOfRuns = runs(distinctCard);
        int scoreOfFlushes = flushes(originalCardSet);
        int scoreOfOne = oneForHisNob(originalCardSet);

//        DistinctCard.print(distinctCard);                   // for debug
//        System.out.printf("pairs = %d \n", scoreOfPair);
//        System.out.printf("runs = %d \n", scoreOfRuns);
//        System.out.printf("flushes = %d \n", scoreOfFlushes);
//        System.out.printf("One = %d \n", scoreOfOne);
//        System.out.printf("fifteens = %d \n", scoreOfFifteens);
//        System.out.printf("score = %d \n", score);
        return (scoreOfFifteens + scoreOfPair
                + scoreOfRuns + scoreOfFlushes + scoreOfOne);
    }


    private static DistinctCard[] distinctTreat(Card[] cardSet) {
        ArrayList arrayList = new ArrayList();
        DistinctCard tmpDistinctCard = new DistinctCard(0);
        for (int i = 0; i < numOfHandCard + 1; ) {
            // numOfHandCard==4 plus start card
            int count = 1;  //num of current card in same value
            int j = i + 1;
            tmpDistinctCard.setValue(cardSet[i].getValue());
            tmpDistinctCard.setType(cardSet[i].getType());
            while (j < 5 && cardSet[i].getValue() == cardSet[j].getValue()) {
                count++;
                j++;
            }
            arrayList.add(new DistinctCard(tmpDistinctCard.getValue(),
                    tmpDistinctCard.getType(), count));
            i = j;
        }
        int len = arrayList.size();
        DistinctCard[] distinctCard = new DistinctCard[len];
        arrayList.toArray(distinctCard);
        return distinctCard;
    }


    private static int fifteens(Card[] cardSet) {
        int pointer = 0;
        int count = (int) Math.pow(2, cardSet.length);
        for (int i = 0; i < count; i++) {
            int sum = 0;
            String binaryStr = Integer.toBinaryString(i);
            // permutation using binary string
            for (int j = 0; j < binaryStr.length(); j++)
                if (binaryStr.charAt(binaryStr.length() - 1 - j) == '1')
                    sum += cardSet[j].getValue() < 10 ?
                            cardSet[j].getValue() : 10;
            if (sum == 15) pointer += 2;
        }
        return pointer;

    }

    private static int pairs(DistinctCard[] distinctCard) {
        int numOfPair = 0;
        for (DistinctCard card : distinctCard) {
            int mode = card.getMode();
            numOfPair += (mode == 1 ?
                    0 : (mode == 2 ? 1 : (mode == 3 ? 3 : 6)));
            // two identical cards make one pair,
            // three identical cards make three pairs
        }                   // four identical cards make six pairs
        return 2 * numOfPair;
    }

    private static int runs(DistinctCard[] distinctCard) {
        int numOfRuns = 0;
        for (int i = 0; i < distinctCard.length; ) {
            int j = i + 1;
            int factor = distinctCard[i].getMode();
            //  get the number of duplicate cards
            int count = 1;                            //  num of current Runs
            while (j < distinctCard.length
                    && distinctCard[i].getValue() + count
                    == distinctCard[j].getValue()) {
                count++;
                factor *= distinctCard[j].getMode();
                j++;
            }
            if (count >= 3) {
                numOfRuns = count * factor;
                break;
            } else i = j;
        }
        return numOfRuns;
    }

    private static int flushes(Card[] cardSet) {
        int count = 1;
        final char type = cardSet[0].getType();

        for (int i = 1; i < numOfHandCard; i++) {
            // four cards in hand, and check whether all cards in hand
            // are of the same suit
            if (cardSet[i].getType() == type) count++;
        }
        if (count == numOfHandCard && cardSet[4].getType() == type)
            count++; // index of start card is 4
        if (count < numOfHandCard) return 0;
        else
            return count;
    }

    private static int oneForHisNob(Card[] cardSet) {
        final char typeOfStartCard = cardSet[4].getType();
        for (int i = 0; i < numOfHandCard; i++)
            if (cardSet[i].getType() == typeOfStartCard
                    && cardSet[i].getValue() == 11) // jack's value is 11
                return 1;
        return 0;
    }

}
