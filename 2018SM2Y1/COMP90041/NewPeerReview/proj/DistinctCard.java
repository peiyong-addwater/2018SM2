// used to calculate Pairs and Runs easily

public class DistinctCard extends Card {
    private int mode = 1;  // the number of cards with identical value

    DistinctCard(int value) {
        super(value);
    }

    DistinctCard(int value, char type, int mode) {
        super(value, type);
        this.mode = mode;

    }

    int getMode() {
        return mode;
    }

    void setMode(int mode) {
        this.mode = mode;
    }

    // for debug
    public static void print(DistinctCard[] cards, int a) {
        for (int i = 0; i < a; i++) {
            System.out.printf("value= %d, mode = %d",
                    cards[i].getValue(), cards[i].getMode());
            System.out.println();
        }
    }
}


