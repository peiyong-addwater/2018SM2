
import javax.crypto.Mac;

//import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class Movie
{
    private  String title;
    private  int rank;
    private  double runTime;


    public Movie()
    {
        title="default";
        rank = 0;
        runTime = 0.0;
    }

    public Movie(String t, int r, double rt)
    {
        this.title = t;
        this.rank = r;
        this.runTime = rt;
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
        Movie m1 = new Movie();
        Movie m2 = new Movie();
        m1.title = "sfadf";
        m2.title = "adfadf";
        m1.rank = 1;
        m2.rank = 2;

        System.out.println(m1.toString());

        System.out.println(m2.toString());
        boolean res = equals(m1, m2);
        System.out.println(res);


    }
}