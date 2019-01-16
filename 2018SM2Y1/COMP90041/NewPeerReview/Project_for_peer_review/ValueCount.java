public class ValueCount {
    private String[] Card;
    private String Num10 = "TJQK"; // This string is used to judge if the card is value 10.
    private String suit="CDHS";

    public ValueCount(String[] s) {
        Card = new String[5];
        Card = s;
    }

    public int ValuesCount() {
        int point = 0;

        //pairs?
        int pairs=0;
        for (int i = 0; i < Card.length; i++) {
            pairs += Pair(i);
        }

        //Runs?
        int run=0;
        run += run();

        //15?
        int Fifteen = 0;
        for (int i = 0; i < Card.length; i++) {
            int sum = 0;
            sum += Add(sum, i);
            for (int j = i + 1; j < Card.length; j++) {
                Fifteen += Addup(sum, j);
            }
        }

        //One for his nob?
        int nob=0;
        if (Nob()){
            nob = 1;
        }

        //Flush?
        int flush=0;
        flush += Flush();

        //out print.
        point = (2 * Fifteen) + (2 * pairs) + flush + nob + run;


        return point;
    }

    //Method for run calculation.
    private int run() {
        int[] num = new int[13];
        boolean IsRun = false;
        int count = 0, index=0, combination=1;
        for (String aCard : Card) {
            switch (aCard.substring(0, 1)) {
                case "A":
                    num[0]++;
                    continue;
                case "2":
                    num[1]++;
                    continue;
                case "3":
                    num[2]++;
                    continue;
                case "4":
                    num[3]++;
                    continue;
                case "5":
                    num[4]++;
                    continue;
                case "6":
                    num[5]++;
                    continue;
                case "7":
                    num[6]++;
                    continue;
                case "8":
                    num[7]++;
                    continue;
                case "9":
                    num[8]++;
                    continue;
                case "T":
                    num[9]++;
                    continue;
                case "J":
                    num[10]++;
                    continue;
                case "Q":
                    num[11]++;
                    continue;
                case "K":
                    num[12]++;
            }
        }

        for (int i = 1; i < 14; i++) {
            if (num[i-1]!=0){
                count++;
                index=i-1;
            }
            if (count>=3){
                IsRun=true;
            }
            if (i<13) {
                if (num[i] == 0 && IsRun) { //if there is a run already, break the recursion if the next num doesn't exist.
                    break;
                }
                if (num[i] == 0 && !IsRun) {
                    count = 0;
                    index = 0;
                }
            }
        }

        if (IsRun){
            for (int i = index-count+1; i < index+1; i++) {
                combination*=num[i];
            }
            return combination*count;
        }
        return 0;
    }

    //Method for One of his nob.
    private boolean Nob() {
        String Nob1="J" + Card[Card.length-1].substring(1,2);
        for (int i = 0; i < Card.length-1; i++) {
            if (Card[i].equals(Nob1)) {
                return true;
            }
        }
        return false;

    }

    //Method for Flush judgement.
    private int Flush() {
        for (int i = 0; i < Card.length; i++) {
            if (!suit.contains(Card[i].substring(1,2))){
                System.out.println("Error Input, Invalid Suit");
                System.exit(1);
            }
            if (i<Card.length-1) {
                if (!Card[0].substring(1,2).equals(Card[i].substring(1,2))){
                    return 0;
                }
            }
            if (i==(Card.length-1)) {
                if (Card[0].substring(1,2).equals(Card[i].substring(1,2))){
                    return 5;
                }
                else {return 4;}
            }
        }
        return 0;
    }

    //Method for Pairs Calculation.
    private int Pair(int i) {
        int count=0;
        for (int j = i+1; j < Card.length; j++) {
            if (Card[i].equals(Card[j])){
                System.out.println("Error Input, With Same Cards");
                System.exit(0);
            }
            if (Card[i].substring(0,1).equals(Card[j].substring(0,1)) && !Card[i].substring(1,2).equals(Card[j].substring(1,2))){
                count++;
            }
        }
        return count;
    }

    //Method for Add up Fifteen.
    private int Add ( int s, int a){
        if (Num10.contains(Card[a].substring(0, 1))) { //To make "T","J","Q","K" represent value of 10.
                s += 10;
        }
        if (Card[a].substring(0, 1).equals("A")) { //To make "A" represent value of 1.
                s += 1;
        }
        if (!(Num10.contains(Card[a].substring(0, 1))) && !(Card[a].substring(0, 1).equals("A"))){
                s += Integer.parseInt(Card[a].substring(0, 1));
        }
        return s;
        }

    private int Addup(int s,int a){
        int count=0;
        s=Add(s,a);
        int sum =s;
        if (sum==15){count++;}
        if (sum<15){
            for (int i = a+1; i < Card.length; i++) { //if the sum is under 15, continued to add up until sum >= 15.
                    s=sum;
                    count+= Addup(s,i);
            }
        }
        return count;
    }
}







