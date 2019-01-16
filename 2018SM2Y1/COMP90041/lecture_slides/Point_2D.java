package cardemo;

public class Point_2D
{

    private int x;
    private int y;

    public Point_2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public String toString()
    {
        return "[x=" + x + ", y=" + y + "]";
    }

}
