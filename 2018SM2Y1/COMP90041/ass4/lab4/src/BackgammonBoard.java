public class BackgammonBoard
{
        private static final int POINTS_ON_BOARD = 24;
        private static final int LAST_POINT = 23;
        private static final int FIRST_POINT = 0;
        private static final int MAX_MOVE = 6;
        private static final int MIN_MOVE = 1;
        private static final int WHITE_MEN = 1;
        private static final int BLACK_MEN = 2;
        private int[] manOnPoints = new int[POINTS_ON_BOARD];
        private int[] manOnBar = new int[3]; // 1 for white and 2 for black
        private int[] colorsOfMan = new int[POINTS_ON_BOARD];

        public BackgammonBoard() {}

        private boolean validPoint(int point)
        {
                return point >= FIRST_POINT && point <= LAST_POINT;
        }

        private int whiteAndBlack(boolean black)
        {
                if (black)
                {
                        return BLACK_MEN;
                }
                else
                {
                        return WHITE_MEN;
                }
        }

        private boolean validMove(int fromPoint, int toPoint)
        {
                if(!this.validPoint(fromPoint) || !this.validPoint(toPoint))
                {
                        return false;
                }
                else if (Math.abs(fromPoint-toPoint)>MAX_MOVE || Math.abs(fromPoint-toPoint)<MIN_MOVE)
                {
                        return false;
                }
                else if ((colorsOfMan[fromPoint] == BLACK_MEN && toPoint > fromPoint) || (colorsOfMan[fromPoint] == WHITE_MEN && toPoint < fromPoint))
                {
                        return false;
                }
                else if ((this.getPointBlack(fromPoint) && !this.getPointBlack(toPoint) && this.getPointCount(toPoint) >= 2) ||
                        (!this.getPointBlack(fromPoint) && this.getPointBlack(toPoint) && this.getPointCount(toPoint) >= 2))
                {
                        return false;
                }
                else if (this.getPointBlack(fromPoint) && manOnBar[BLACK_MEN]>0)
                {//you need to move pieces on the bars first
                        return false;
                }
                else if (!this.getPointBlack(fromPoint) && manOnBar[WHITE_MEN]>0)
                {
                        return false;
                }
                else
                {
                        return true;
                }
        }

        public int getPointCount(int point)
        {
                if (!this.validPoint(point))
                {
                        return -1;
                }
                return manOnPoints[point];
        }

        public void setPoint(int point, int count, boolean black)
        {
                if(!this.validPoint(point))
                {
                        return ;
                }
                else
                {
                        manOnPoints[point] = count;
                        colorsOfMan[point] = this.whiteAndBlack(black);
                }
        }

        public boolean getPointBlack(int point)
        {
                if(!this.validPoint(point))
                {
                        return false;
                }
                else
                {
                        return colorsOfMan[point] == BLACK_MEN;
                }
        }

        public int getBarBlackCount()
        {
                return manOnBar[BLACK_MEN];
        }

        public int getBarWhiteCount()
        {
                return manOnBar[WHITE_MEN];
        }

        public void move(int fromPoint, int toPoint)
        {
                if(!this.validMove(fromPoint,toPoint))
                {
                        return;
                }
                else if (this.getPointBlack(fromPoint) && !this.getPointBlack(toPoint) && this.getPointCount(toPoint) == 1)
                {
                        //black eats white and put the eaten piece on bar as
                        // well as change the dest. color to black
                        manOnPoints[fromPoint] = manOnPoints[fromPoint]-1;
                        colorsOfMan[toPoint] = BLACK_MEN;
                        manOnBar[WHITE_MEN] = manOnBar[WHITE_MEN] + 1;
                }
                else if (!this.getPointBlack(fromPoint) && this.getPointBlack(toPoint) && this.getPointCount(toPoint) == 1)
                {
                        //white piece drives one black piece to the bar
                        manOnPoints[fromPoint] = manOnPoints[fromPoint]-1;
                        colorsOfMan[toPoint] = WHITE_MEN;
                        manOnBar[BLACK_MEN] = manOnBar[BLACK_MEN] + 1;
                }
                else
                {
                        manOnPoints[fromPoint] = manOnPoints[fromPoint] - 1;
                        manOnPoints[toPoint] = manOnPoints[toPoint] + 1;
                        colorsOfMan[toPoint] = colorsOfMan[fromPoint];
                }
        }

}
