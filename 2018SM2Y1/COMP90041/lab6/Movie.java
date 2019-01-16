//package lab6;
import javax.crypto.Mac;

//import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class Movie
{
    private String title;
    private int rank;
    private double runTime;


    

    public Movie(String t, int r, double rt)
    {
        this.title = t;
        this.rank = r;
        this.runTime = rt;
    }

    public Movie(String title, int rank)
    {
        this.title = title;
        this.rank = rank;

        this.runTime = 0;
    }

    public Movie(String title, double runTime)
    {
        this.title = title;
        this.runTime = runTime;

        this.rank = 0;
    }

    public Movie(int rank, double runTime)
    {
        this.rank = rank;
        this.runTime = runTime;

        this.title = null;
    }

   // public void setTitle(String title)
    //{
     //     this.title=title; //final title cannot be assigned a value
    //}

    //public void setRank(int rank)
    //{
     //   this.rank = rank;
    //}

    //public void setRunTime(double runTime)
    //{
      //  this.runTime = runTime;
    //}

    public String getTitle()
    {
        return title;
    }

    public int getRank()
    {
        return rank;
    }

    public Double getRunTime()
    {
        return runTime;
    }

    public String toString()
    {
        String output = rank + ". " + title;
        return output;
    }

    public static boolean equals(Movie movie1, Movie movie2)
    {
        if(movie1.title==movie2.title)
        {
            if(movie1.rank==movie2.rank)
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String [] args)
    {
        Movie m1 = new Movie("title1",1,1223.0);
        Movie m2 = new Movie("title2",2,1230.3);
       

        System.out.println(m1.toString());

        System.out.println(m2.toString());
        boolean res = equals(m1, m2);
        System.out.println(res);


    }
}