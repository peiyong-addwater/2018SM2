import java.util.ArrayList;
import java.util.Arrays;

public class SelectHand {
    public static void main(String[] args) {
        String[] Handcards = new String[args.length]; // String s is used to store the input handcards.
        ArrayList Output = new ArrayList();
        int count = 0;
        for (int i=0; i<args.length;i++) {
            Handcards[i]=args[i];
        }

        switch (Handcards.length){
            case 6:
                Output = Method6(Handcards);
                break;
            case 5:
                Output = Method5(Handcards);
                break;
            case 4:
                for (int i = 0 ; i < Handcards.length;i++) {
                    Output.add(Handcards[i]);
                }
        }
        for (int i = 0; i < Output.size(); i++) {
            if (count<=2) {
                System.out.printf("%s ", Output.get(i));

            }
            if (count==3){
                System.out.printf("%s\n", Output.get(i));
            }
            count++;
        }
    }
    //If there are 6 specified Cards.
    private static ArrayList Method6(String[] s) {
        String[] AllCards = new String[] //String of all 52 Cards.
                {"AC","AD","AH","AS", "2C","2D","2H","2S","3C","3D","3H","3S","4C","4D","4H","4S","5C","5D","5H",
                 "5S", "6C","6D","6H","6S","7C","7D","7H","7S","8C","8D","8H","8S","9C","9D","9H","9S","TC","TD",
                 "TH","TS","JC","JD","JH","JS","QC","QD","QH","QS","KC","KD","KH","KS"};
        String[] Value = new String[5]; //String included one of the combinations and a possible StartCard.
        String[] test = new String[4]; //String of the combination.
        ArrayList Output = new ArrayList();
        int point, max = 0;
        //Combinations of Specified Cards.
        for (int i = 0; i < s.length-1; i++) { //every time choose 2 cards to drop and the other 4 is a combination.
            for (int j = i+1; j < s.length; j++) {
                point=0;
                int index=0;
                for (String value : s) {
                    if (!value.equals(s[i]) && !value.equals(s[j])) {
                        test[index] = value;
                        Value[index] = value;
                        index++;
                    }
                }
                //For each possible Start Card count the value.
                for (int k = 0; k < AllCards.length; k++) {
                    if (ValidStartCard(k,s)){ //if the Card is a valid StartCard then calculate the point of the combination with this Card.
                        Value[4] = AllCards[k];
                        ValueCount v = new ValueCount(Value);
                        point += v.ValuesCount();
                    }
                }

                if (point > max){ //The best combination is one which has the highest total point.
                    max = point;
                    Output.removeAll(Output);
                    Output.addAll(Arrays.asList(test));
                }

            }

        }

        return Output;
    }
    //If there are 5 specified Cards.
    private static ArrayList Method5(String[] s) {
        String[] AllCards = new String[] //String of all 52 Cards.
                {"AC","AD","AH","AS", "2C","2D","2H","2S","3C","3D","3H","3S","4C","4D","4H","4S","5C","5D","5H",
                 "5S","6C","6D","6H","6S","7C","7D","7H","7S","8C","8D","8H","8S","9C","9D","9H","9S","TC","TD",
                 "TH","TS","JC","JD","JH","JS","QC","QD","QH","QS","KC","KD","KH","KS"};
        String[] Value = new String[5]; //String included one of the combinations and possible StartCard.
        String[] test = new String[4]; //String of the combination.
        ArrayList Output = new ArrayList();
        int point, max = 0;
        //Combinations of Specified Cards.
        for (String value1 : s) { //every time choose 1 cards to drop and the other 4 form a combination.
            point = 0;
            int index = 0;
            for (String value : s) {
                if (!value.equals(value1)) {
                    test[index] = value;
                    Value[index] = value;
                    index++;
                }
            }
            //For each possible Start Card calculate the value.
            for (int k = 0; k < AllCards.length; k++) {
                if (ValidStartCard(k, s)) { //if the Card is a valid StartCard then calculate the point of the combination with this Card.
                    Value[4] = AllCards[k];
                    ValueCount v = new ValueCount(Value);
                    point += v.ValuesCount();
                }
            }

            if (point > max){
                max = point;
                Output.removeAll(Output);
                Output.addAll(Arrays.asList(test));
            }
        }
        return Output;
    }
    // Method to judge whether a Card can be the StartCard or not.
    private static boolean ValidStartCard(int j, String[] s) {
        String[] AllCards = new String[]
                {"AC","AD","AH","AS", "2C","2D","2H","2S","3C","3D","3H","3S","4C","4D","4H","4S","5C","5D","5H",
                 "5S","6C","6D","6H","6S","7C","7D","7H","7S","8C","8D","8H","8S","9C","9D","9H","9S","TC","TD",
                 "TH","TS","JC","JD","JH","JS","QC","QD","QH","QS","KC","KD","KH","KS"};
        for (String value : s) {
            if (AllCards[j].equals(value)) {
                return false;
            }
        }
        return true;
    }
}

