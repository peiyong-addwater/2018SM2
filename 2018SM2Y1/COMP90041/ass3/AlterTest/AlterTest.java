import javax.lang.model.util.ElementScanner6;

public class AlterTest
{
    public static BackgammonBoard assignPieces(BackgammonBoard testBoard)
    {
        //set white
        //int [] piecesOnBoard = []
        int i;
        for(i=0;i<24;i++)
        {
            if(i%2==0)
            {
                testBoard.setPoint(i, 2, true);
            }
            else
            {
                testBoard.setPoint(i, 2, false);
            }
        }
        return testBoard;
    }

    public static boolean hasBugOne(BackgammonBoard boardForOne)
    {
        //input must be a board with assigned pieces
        boardForOne.move(1, 11);
       // System.out.println(boardForOne.getPointCount(1));
        //System.out.println(boardForOne.getPointCount(11));
        if(boardForOne.getPointCount(11)==3)
        {
            //hasBug();
            return true;
        }
        //if has bug return true else return false
        return false;

    }

    public static boolean hasBugTwo(BackgammonBoard boardForTwo)
    {
        boardForTwo.move(2, 4);
       // boardForTwo.move(2, 0);
        //boardForTwo.move(2, 0);//this time there is no man on point 0
        //System.out.println(boardForTwo.getPointCount(0));
        if(boardForTwo.getPointCount(4)==3)
        {
            return true;//has bug 2
        }
        //has bug number 2
        return false;
    }

    public static boolean hasBugThree(BackgammonBoard boardForThree)
    {
        //this bug occurs when white moves inversely
        boardForThree.move(3, 1);
        if(boardForThree.getPointCount(1)==3)
        {
            return true;//has this bug
        }
        else{return false;}
    }

    public static boolean hasBugFour(BackgammonBoard boardForFour)
    {
        boardForFour.move(1, 2);
        if(boardForFour.getPointCount(1)==1)
        {return true;}
        
        return false;
    }


    public static boolean hasBugFive(BackgammonBoard boardForFive)
    {
        boardForFive.move(3, 7);
        //System.out.println(boardForFive.getPointBlack(3));
        boardForFive.move(3, 7);
       // System.out.println(boardForFive.getPointBlack(3));
        boardForFive.move(1, 3);
        //System.out.println(boardForFive.getPointBlack(3));
        boolean black = boardForFive.getPointBlack(3);
        if(black==true)
        {
            return true;//has bug five
        }
        return false;
    }

    public static boolean hasBugSix(BackgammonBoard boardForSix)
    {
        boardForSix.move(1, 3);
        if(boardForSix.getPointCount(1)==2)
        {
            return true;//has bug 6
        }
        return false;
    }

    public static boolean hasBugSeven(BackgammonBoard boardForSeven)
    {
        boardForSeven.move(3, 5);
        if(boardForSeven.getPointCount(5)==2)
        {
            return true;//has bug 7
        }
        return false;
    }

    public static boolean hasBugEight(BackgammonBoard boardForEight)
    {
        boardForEight.move(23, 24);
        if(boardForEight.getPointCount(23)==1)
        {
            return true;//has bug eight
        }
        return false;
    }


    public static boolean hasBugNine(BackgammonBoard boardForNine)
    {
        boardForNine.move(4, 2);
        boardForNine.move(3, 4);
        if(boardForNine.getBarBlackCount()==0)
        {
            return true;//has bug nine
        }
        return false;
    }


    public static boolean hasBugTen(BackgammonBoard boardForTen)
    {
        boardForTen.move(1, 3);
        boardForTen.move(2, 1);
        if(boardForTen.getBarWhiteCount()==0)
        {
            return true;
        }
        return false;
    }




    public static void hasBug()
    {
        System.out.println("BUG");
    }

    public static void noBug()
    {
        System.out.println("CORRECT");
    }

    


    public static void main(String [] args)
    {
        BackgammonBoard noBug = new BackgammonBoard();
        BackgammonBoard testBugOne = new BackgammonBoard();
        BackgammonBoard testBugTwo = new BackgammonBoard();
        BackgammonBoard testBugThree = new BackgammonBoard();
        BackgammonBoard testBugFour = new BackgammonBoard();
        BackgammonBoard testBugFive = new BackgammonBoard();
        BackgammonBoard testBugSix = new BackgammonBoard();
        BackgammonBoard testBugSeven = new BackgammonBoard();
        BackgammonBoard testBugEight = new BackgammonBoard();
        BackgammonBoard testBugNine = new BackgammonBoard();
        BackgammonBoard testBugTen = new BackgammonBoard();

        BackgammonBoard [] boardsForTest = {noBug,testBugOne,testBugTwo,testBugThree,testBugFour,testBugFive,testBugSix,testBugSeven,testBugEight,testBugNine,testBugTen};


        //initial pieces on board
        //int [] whiteMenOnPointsCount = {2,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,3,0,5,0,0,0,0,0};
        //int [] blackMenOnPointsCount = {0,0,0,0,0,5,0,3,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,2};
    
        //set all pieces
        for (int m=0; m<11; m++)
        {
            boardsForTest[m] = assignPieces(boardsForTest[m]);
        }

        
        //test all ten kinds of bugs
        if(hasBugOne(testBugOne))
        {
            hasBug();
            //System.out.println(1);
        }
        else if(hasBugTwo(testBugTwo))
        {
            hasBug();
            //System.out.println(2);
        }
        else if(hasBugThree(testBugThree))
        {
            hasBug();
            //System.out.println(3);
        }
        else if(hasBugFour(testBugFour))
        {
            hasBug();
            //System.out.println(4);
        }
        else if(hasBugFive(testBugFive))
        {
            hasBug();
            //System.out.println(5);
        }
        else if(hasBugSix(testBugSix))
        {
            hasBug();
            //System.out.println(6);
        }
        else if(hasBugSeven(testBugSeven))
        {
            hasBug();
            //System.out.println(7);
        }
        else if(hasBugEight(testBugEight))
        {
            hasBug();
            //System.out.println(8);
        }
        else if(hasBugNine(testBugNine))
        {
            hasBug();
            //System.out.println(9);
        }
        else if(hasBugTen(testBugTen))
        {
            hasBug();
            //System.out.println(10);
        }
        else 
        {
            noBug();
            //System.out.println(0);
        }
    } 
}