/*
 * Last Modified 2018.
 * The
 */

public class HandValueTest
{
        public static void main(String[] args)
        {
                String[] arr1 = {"7C","QH","2C","JC","9H"};
                String[] arr2 = {"AS","3H", "KH", "7H", "KS"};
                String[] arr3 = {"AS","3H","KH","7H", "2D"};
                String[] arr4 = {"2S", "3H", "KH", "3S", "4H"};
                String[] arr5 = {"6C","7C", "8C", "9C", "8S"};
                String[] arr6 = {"7H","9S", "8C", "7C", "8H"};
                String[] arr7 = {"5H", "5S", "5C", "JD", "5D"};

                CardsScore a = new CardsScore(arr1);

                CardsScore b = new CardsScore(arr2);

                CardsScore c = new CardsScore(arr3);

                CardsScore d = new CardsScore(arr4);

                CardsScore e = new CardsScore(arr5);

                CardsScore f = new CardsScore(arr6);

                CardsScore g = new CardsScore(arr7);

                System.out.println("a");
                System.out.println(a.getTotalScoresInt());
                System.out.println(a.getPairsScoresInt());
                System.out.println(a.getFifteensScoresInt());
                System.out.println(a.getFlushesScoresInt());
                System.out.println(a.getRunsScoresInt());
                System.out.println(a.getOneForHisNobScoresInt());

                System.out.println("b");
                System.out.println(b.getTotalScoresInt());
                System.out.println(b.getPairsScoresInt());
                System.out.println(b.getFifteensScoresInt());
                System.out.println(b.getFlushesScoresInt());
                System.out.println(b.getRunsScoresInt());
                System.out.println(b.getOneForHisNobScoresInt());

                System.out.println("c");
                System.out.println(c.getTotalScoresInt());
                System.out.println(c.getPairsScoresInt());
                System.out.println(c.getFifteensScoresInt());
                System.out.println(c.getFlushesScoresInt());
                System.out.println(c.getRunsScoresInt());
                System.out.println(c.getOneForHisNobScoresInt());

                System.out.println("d");
                System.out.println(d.getTotalScoresInt());
                System.out.println(d.getPairsScoresInt());
                System.out.println(d.getFifteensScoresInt());
                System.out.println(d.getFlushesScoresInt());
                System.out.println(d.getRunsScoresInt());
                System.out.println(d.getOneForHisNobScoresInt());

                System.out.println("e");
                System.out.println(e.getTotalScoresInt());
                System.out.println(e.getPairsScoresInt());
                System.out.println(e.getFifteensScoresInt());
                System.out.println(e.getFlushesScoresInt());
                System.out.println(e.getRunsScoresInt());
                System.out.println(e.getOneForHisNobScoresInt());

                System.out.println("f");
                System.out.println(f.getTotalScoresInt());
                System.out.println(f.getPairsScoresInt());
                System.out.println(f.getFifteensScoresInt());
                System.out.println(f.getFlushesScoresInt());
                System.out.println(f.getRunsScoresInt());
                System.out.println(f.getOneForHisNobScoresInt());

                System.out.println("g");
                System.out.println(g.getTotalScoresInt());
                System.out.println(g.getPairsScoresInt());
                System.out.println(g.getFifteensScoresInt());
                System.out.println(g.getFlushesScoresInt());
                System.out.println(g.getRunsScoresInt());
                System.out.println(g.getOneForHisNobScoresInt());
        }
}
