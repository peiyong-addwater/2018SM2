package cardemo;

/**
 * This is a class that keep track of a car
 *
 * @author Thomas Christy
 * @since August 2018
 */
public class Car
{

    private int x, y;
    private Point_2D location;
    private static int count;
    private final int id;
    private final int numOfWheels = 4;

    /**
     * Construct a new object of type Car
     *
     * @param x
     * @param y
     */
    public Car(int x, int y)
    {
        this.x = x;
        this.y = y;

        this.location = new Point_2D(x, y); // added to instance location

        count++;
        id = count;
    }

    /**
     * NOTES for additional enum code: Added this move method to take the new
     * Direction enum. Using the enum deltaX and deltaY we increment the values
     * for x and y either positively or negatively according to the enum value
     * returned
     *
     * @param dir
     */
    public void move(Direction dir)
    {
        this.x += dir.deltaX();
        this.y += dir.deltaY();
    }

    public Car(Point_2D location)
    {
        this.location = location;

        this.x = location.getX();// added to instance x
        this.y = location.getY();// added to instance y

        count++;
        id = count;
    }

    /**
     * This is how you add details to a method to be displayed in the JavaDoc
     * API
     *
     * @return
     */
    public int getX()
    {
        return x;
    }

    /**
     * something else here for the JavaDoc
     *
     * @param x
     */
    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Point_2D getLocation()
    {
        return location;
    }

    public void setLocation(Point_2D location)
    {
        this.location = location;
    }

    public int getNumOfWheels()
    {
        return this.numOfWheels;
    }

    // added get id to allow prompt in carDemo to prompt for the correct car
    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {

        return id + " " + location;
    }
}
