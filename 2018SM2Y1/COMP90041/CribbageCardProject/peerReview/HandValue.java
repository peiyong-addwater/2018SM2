import java.util.Arrays;
public class HandValue {

    /*
    This is the main function.
     */
    public static void main(String[ ] args){

        /*
        Construct a String[] to store the input
         */

        String[] cards=new String[5];
        for (int i=0; i<5; i++)
            cards[i]=args[i];
        getScore(cards);

    }

    public static int score=0;

   /*
   getScore is a function to calculate the total hand value using 5 rules.
    */

    public static void getScore(String[] cards){

        Fifteens(cards);
        Pairs(cards);
        Runs(cards);           /*   use five rules to calculate the score  */
        Flushes(cards);
        OneForHisNob(cards);

        System.out.print(score);  /*  print out the result hand value  */

    }

    /*    Fifteens is the function to calculate the score according to the 15s rule   */

    public static void Fifteens(String[] cards){

        /*
        For two elements plus to 15.
         */
        for(int i=0; i<4;i++)
            for (int j=4; j>i; j--)
                if (getValue(cards[i])+getValue(cards[j])==15)
                    score=score+2;
        /*
        For three cards plus to 15 and one element is the first one.
         */
        for(int m=1; m<4; m++)
            for (int n=4; n>m; n--)
                if (getValue(cards[m])+getValue(cards[n])+getValue(cards[0])==15)
                    score=score+2;
        /*
        For three cards plus to 15 and one element is the second one.
         */
        for(int m=2; m<4; m++)
            for (int n=4; n>m; n--)
                if (getValue(cards[m])+getValue(cards[n])+getValue(cards[1])==15)
                    score=score+2;
        /*
        For last three cards plus to 15.
         */
        if (getValue(cards[2])+getValue(cards[3])+getValue(cards[4])==15)
            score=score+2;

        /*
        For four cards plus to 15 and one element is the first one.
         */
        if (getValue(cards[0])+getValue(cards[1])+getValue(cards[2])+getValue(cards[3])==15)
            score=score+2;
        if (getValue(cards[0])+getValue(cards[1])+getValue(cards[3])+getValue(cards[4])==15)
            score=score+2;
        if (getValue(cards[0])+getValue(cards[1])+getValue(cards[3])+getValue(cards[4])==15)
            score=score+2;
        if (getValue(cards[0])+getValue(cards[2])+getValue(cards[3])+getValue(cards[4])==15)
            score=score+2;
        if (getValue(cards[1])+getValue(cards[2])+getValue(cards[3])+getValue(cards[4])==15)
            score=score+2;

        /*
        For five cards plus to 15 and one element is the first one.
         */
        if (getValue(cards[0])+getValue(cards[1])+getValue(cards[2])+getValue(cards[3])+getValue(cards[4])==15)
            score=score+2;


    }

    /*    Pairs is the function to calculate the score according to the Pairs rule   */

    public static void Pairs(String[] cards){

        /*
        First calculate how many pairs, then each pairs get 3 scores.
         */
        for (int p=0; p<4; p++)
            for(int q=p+1; q<5; q++)
                if (cards[p].charAt(0)==cards[q].charAt(0))
                    score=score+2;


    }

    /*    Runs is the function to calculate the score according to the Runs rule   */

    public static void Runs(String[] cards) {

        /*
        First, turn the String to the array.
        Then, sort out the array.
         */
        int[] numbers;
        numbers = new int[5];

        for (int q = 0; q < 5; q++) {
            numbers[q] = toNumber(cards[q]);
        }

        Arrays.sort(numbers);

        /*
        First, think about the situation where there is no same number.
         */
        if (numbers[0] != numbers[1] && numbers[1] != numbers[2] && numbers[2] != numbers[3] && numbers[3] != numbers[4]) {
            if (numbers[1] - numbers[0] == 1 && numbers[2] - numbers[1] == 1) {
                if (numbers[3] - numbers[2] == 1) {
                    if (numbers[4] - numbers[3] == 1) {
                        score = score + 5;
                    } else
                        score = score + 4;
                } else
                    score = score + 3;
            } else if (numbers[1] - numbers[0] != 1) {
                if (numbers[2] - numbers[1] == 1 && numbers[3] - numbers[2] == 1) {
                    if (numbers[4] - numbers[3] == 1) {
                        score = score + 4;
                    } else
                        score = score + 3;
                }
            } else if (numbers[2] - numbers[1] != 1) {
                if (numbers[3] - numbers[2] == 1 && numbers[4] - numbers[3] == 1) {
                    score = score + 3;
                }
            }
        }


        /*
        Then, think about three kinds of situation where there are three same numbers.
         */
        if (numbers[0] == numbers[1] && numbers[1] == numbers[2] && numbers[2] != numbers[3] && numbers[3] != numbers[4]) {
            if (numbers[3] - numbers[2] == 1 && numbers[4] - numbers[3] == 1) {
                score = score + 9;
            }
        }

        if (numbers[0] != numbers[1] && numbers[1] == numbers[2] && numbers[2] == numbers[3] && numbers[3] != numbers[4]) {
            if (numbers[1] - numbers[0] == 1 && numbers[4] - numbers[3] == 1) {
                score = score + 9;
            }
        }

        if (numbers[0] != numbers[1] && numbers[1] != numbers[2] && numbers[2] == numbers[3] && numbers[3] == numbers[4]) {
            if (numbers[3] - numbers[2] == 1 && numbers[4] - numbers[3] == 1) {
                score = score + 9;
            }
        }


        /*
        Moreover, think about four kinds of situation where there is one pairs of two same numbers.
         */
        if (numbers[0] == numbers[1] && numbers[1] != numbers[2] && numbers[2] != numbers[3] && numbers[3] != numbers[4]) {
            if (numbers[2] - numbers[1] == 1 && numbers[3] - numbers[2] == 1) {
                if (numbers[4] - numbers[3] == 1) {
                    score = score + 8;
                } else
                    score = score + 6;
            }
            if (numbers[2] - numbers[1] != 1 && numbers[3] - numbers[2] == 1 && numbers[4] - numbers[3] == 1) {
                score = score + 3;
            }
        }

        if (numbers[0] != numbers[1] && numbers[1] == numbers[2] && numbers[2] != numbers[3] && numbers[3] != numbers[4]) {
            if (numbers[1] - numbers[0] == 1 && numbers[3] - numbers[2] == 1) {
                if (numbers[4] - numbers[3] == 1) {
                    score = score + 8;
                } else
                    score = score + 6;
            }
            if (numbers[1] - numbers[0] != 1 && numbers[3] - numbers[2] == 1 && numbers[4] - numbers[3] == 1) {
                score = score + 6;
            }
        }

        if (numbers[0] != numbers[1] && numbers[1] != numbers[2] && numbers[2] == numbers[3] && numbers[3] != numbers[4]) {
            if (numbers[1] - numbers[0] == 1 && numbers[2] - numbers[1] == 1) {
                if (numbers[4] - numbers[3] == 1) {
                    score = score + 8;
                } else
                    score = score + 6;
            }
            if (numbers[1] - numbers[0] != 1 && numbers[2] - numbers[1] == 1 && numbers[4] - numbers[3] == 1) {
                score = score + 6;
            }
        }

        if (numbers[0] != numbers[1] && numbers[1] != numbers[2] && numbers[2] != numbers[3] && numbers[3] == numbers[4]) {
            if (numbers[1] - numbers[0] == 1 && numbers[2] - numbers[1] == 1) {
                if (numbers[3] - numbers[2] == 1) {
                    score = score + 8;
                } else
                    score = score + 3;
            }
            if (numbers[1] - numbers[0] != 1 && numbers[2] - numbers[1] == 1 && numbers[3] - numbers[2] == 1) {
                score = score + 6;
            }
        }

        /*
        AT LAST, think about three kinds of situation where there are two pairs of two same numbers.
         */
        if (numbers[0] == numbers[1] && numbers[1] != numbers[2] && numbers[2] == numbers[3] && numbers[3] != numbers[4]) {
            if (numbers[2] - numbers[1] == 1 && numbers[4] - numbers[3] == 1) {
                score = score + 12;
            }
        }

        if (numbers[0] == numbers[1] && numbers[1] != numbers[2] && numbers[2] != numbers[3] && numbers[3] == numbers[4]) {
            if (numbers[2] - numbers[1] == 1 && numbers[3] - numbers[2] == 1) {
                score = score + 12;
            }
        }

        if (numbers[0] != numbers[1] && numbers[1] == numbers[2] && numbers[2] != numbers[3] && numbers[3] == numbers[4]) {
            if (numbers[1] - numbers[0] == 1 && numbers[3] - numbers[2] == 1) {
                score = score + 12;
            }
        }

    }






        /*    Flushes is the function to calculate the score according to the Flushes rule   */

    public static void Flushes(String[] cards){

        /*
        If all the cards in the hand are of the same suit, get 4 scores.
        If the start card is also the same suit, get 5 scores.
         */
        if(cards[0].charAt(1)==cards[1].charAt(1) && cards[1].charAt(1)==cards[2].charAt(1) && cards[2].charAt(1)==cards[3].charAt(1)) {
            if (cards[3].charAt(1) == cards[4].charAt(1))
                score = score + 5;
            else
                score = score + 4;

        }



    }

    /*    OneForHisNob is the function to calculate the score according to the One for his nob rule  */

    public static void OneForHisNob(String[] cards){

        /*
        If the hand contains the jack of the same suit as the start card,get 1 score.
         */

        for (int i=0; i<4; i++)
            if(cards[i].charAt(0)=='J' && cards[i].charAt(1)==cards[4].charAt(1)){
                score=score+1;
            }


    }

    /*
    getValue is the function to get the face value of the cards.
     */
    public static int getValue(String n){
        int num=0;
        if(n.charAt(0)=='A')
            num=1;
        else if(n.charAt(0)=='2')
            num=2;
        else if(n.charAt(0)=='3')
            num=3;
        else if(n.charAt(0)=='4')
            num=4;
        else if(n.charAt(0)=='5')
            num=5;
        else if(n.charAt(0)=='6')
            num=6;
        else if(n.charAt(0)=='7')
            num=7;
        else if(n.charAt(0)=='8')
            num=8;
        else if(n.charAt(0)=='9')
            num=9;
        else if(n.charAt(0)=='T'||n.charAt(0)=='J'||n.charAt(0)=='Q'||n.charAt(0)=='K')
            num=10;
        else
            num=0;
        return num;

    }

    /*
    toNumber is the function to get the order of 13 kinds of cards, and it is used for sorting the input String.
     */
    public static int toNumber (String m) {
        int number=0;
        if(m.charAt(0)=='A')
            number=1;
        else if(m.charAt(0)=='2')
            number=2;
        else if(m.charAt(0)=='3')
            number=3;
        else if(m.charAt(0)=='4')
            number=4;
        else if(m.charAt(0)=='5')
            number=5;
        else if(m.charAt(0)=='6')
            number=6;
        else if(m.charAt(0)=='7')
            number=7;
        else if(m.charAt(0)=='8')
            number=8;
        else if(m.charAt(0)=='9')
            number=9;
        else if(m.charAt(0)=='T')
            number=10;
        else if(m.charAt(0)=='J')
            number=11;
        else if(m.charAt(0)=='Q')
            number=12;
        else if(m.charAt(0)=='K')
            number=13;
        else
            number=0;
        return number;
    }


}
