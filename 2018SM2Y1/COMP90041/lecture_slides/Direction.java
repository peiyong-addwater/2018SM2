package cardemo;

/**
 * Original @author Peter Schachte <schachte@unimelb.edu.au>
 * Written for COPM90041 2018 by Thomas Christy This is an enum that provides a
 * nice method for selecting which direction a car can move, as discussed in
 * Lecture 9.  It simplifies the process greatly.  
 */
public enum Direction
{

    NORTH(0, -1), EAST(1, 0), WEST(-1, 0), SOUTH(0, 1);

    private int deltaX;
    private int deltaY;

    public int deltaX()
    {
        return deltaX;
    }

    public int deltaY()
    {
        return deltaY;
    }

    private Direction(int deltaX, int deltaY)
    {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public static Direction fromString(String text)
    {
        char dirChar = text.toUpperCase().charAt(0);
        for (Direction d : Direction.values())
        {
            if (dirChar == d.toString().charAt(0))
            {
                return d;
            }
        }
        return null;
    }

}
