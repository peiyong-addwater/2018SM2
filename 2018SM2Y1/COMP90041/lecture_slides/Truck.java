package cardemo;

public class Truck extends Car
{
    private final int numOfWheels = 6;
    private double weight;

    public Truck(int x, int y)
    {
        super(x, y);
        this.weight = 7.5;
        
    }
    
    public Truck(int x, int y, double weight)
    {
        super(x, y);
    }
    
   
    public double getWeight()
    {
        return this.weight;
    }
    
    @Override
    public int getNumOfWheels()
    {
        
        return this.numOfWheels;
    }
    
    public String toString()
    {
        return getId() + " # of wheels " + getNumOfWheels() + " " + getLocation();
    }
}
