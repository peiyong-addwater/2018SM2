// Class Card to better organise the data
//
public class Card {
    private int value = 0;
    private char type = ' ';

    Card(int value, char type) {
        this.value = value;
        this.type = type;
    }

    Card() {
    }

    Card(int value) {
        this.value = value;
    }

    public static void copy(Card[] cards1, Card[] cards2) {
        System.arraycopy(cards1, 0, cards2, 0, cards1.length);
    }

    public static void copy(Card card1, Card card2) {
        card2.value = card1.value;
        card2.type = card1.type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public static void printCard(Card[] cards, int a) {
        String tmpVal = "";
        for (int i = 0; i < a; i++) {
            switch (cards[i].value) {
                case 1:
                    tmpVal = "A";
                    break;
                case 10:
                    tmpVal = "T";
                    break;
                case 11:
                    tmpVal = "J";
                    break;
                case 12:
                    tmpVal = "Q";
                    break;
                case 13:
                    tmpVal = "K";
                    break;
                default:
                    tmpVal = Integer.toString(cards[i].value);
                    break;
            }
            System.out.printf("%s%c", tmpVal, cards[i].getType());
            if (i != a - 1) System.out.print(" ");
//            System.out.println(" " + card.getType());
        }
        System.out.println();
    }

    public static void sort(Card[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            int min = cards[i].getValue();
            int minIndex = i;
            for (int j = i + 1; j < cards.length; j++)
                if (cards[j].getValue() < min) {
                    min = cards[j].getValue();
                    minIndex = j;
                }
            Card tmp = new Card(cards[i].getValue(), cards[i].getType());
            cards[i] = cards[minIndex];
            cards[minIndex] = tmp;
        }
    }

}

