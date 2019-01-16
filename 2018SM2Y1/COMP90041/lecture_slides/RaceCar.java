package cardemo;

public class RaceCar extends Car
{

    private String colour;

    public RaceCar(int x, int y)
    {
        this(x, y, 0);
        //super(x, y);
        
        colour = "Red";

    }
    
    public RaceCar(int x, int y, int z)
    {
         super(x, y);
         
    }

    public String getColour()
    {
        return colour;
    }
    
    public String toString()
    {
        return getId() + " colour " + this.colour + " " + getLocation();
    }
}
