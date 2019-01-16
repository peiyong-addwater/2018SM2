//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class BackgammonBoard {
    public static final int POINTS_ON_BOARD = 24;
    public static final int LAST_POINT = 23;
    public static final int MAX_MOVE = 6;
    public static final int MIN_MOVE = 1;
    private int[] points = new int[24];
    private int blacksOnBar = 0;
    private int whitesOnBar = 0;
    private static int bug = 0;

    public BackgammonBoard() {
    }

    public static void setBug(int bug) {
        bug = bug;
    }

    public int getPointCount(int point) {
        return this.validPoint(point) ? Math.abs(this.points[point]) : 0;
    }

    public boolean getPointBlack(int point) {
        if (this.validPoint(point)) {
            return this.points[point] <= 0;
        } else {
            return true;
        }
    }

    public void setPoint(int point, int count, boolean black) {
        if (count >= 0 && this.validPoint(point)) {
            this.points[point] = count * (black ? -1 : 1);
        }

    }

    public void move(int fromPoint, int toPoint) {
        int distance = Math.abs(toPoint - fromPoint);
        if ((distance >= 1 && distance <= 6 || bug == 1) && (this.validPoint(fromPoint) && this.validPoint(toPoint) || bug == 8)) {
            int fromCount = this.getPointCount(fromPoint);
            boolean fromBlack = this.getPointBlack(fromPoint);
            int toCount = this.getPointCount(toPoint);
            boolean toBlack = this.getPointBlack(toPoint);
            if ((fromCount > 0 || bug == 2) && (fromBlack && (toPoint < fromPoint || bug == 2) || !fromBlack && (toPoint > fromPoint || bug == 3)) && (fromBlack == toBlack || toCount <= 1 || bug == 4)) {
                if (toCount == 1 & fromBlack != toBlack) {
                    if (toBlack) {
                        if (bug != 9) {
                            ++this.blacksOnBar;
                        }
                    } else if (bug != 10) {
                        ++this.whitesOnBar;
                    }
                } else if (bug != 7) {
                    ++toCount;
                }

                if (bug != 5) {
                    toBlack = fromBlack;
                }

                this.setPoint(toPoint, toCount, toBlack);
                if (bug != 6) {
                    this.setPoint(fromPoint, fromCount - 1, fromBlack);
                }
            }
        }

    }

    public int getBarBlackCount() {
        return this.blacksOnBar;
    }

    public int getBarWhiteCount() {
        return this.whitesOnBar;
    }

    private boolean validPoint(int point) {
        return point >= 0 && point <= 23;
    }
}
