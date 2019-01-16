import java.util.*;
public class lab41
{
    public static void printMovies ()
    {
            List <String> movie = new ArrayList<String>();
            movie.add(0, "Star Wars");
            movie.add(1, "The Empire Strikes Back");
            movie.add(2, "Return of the Jedi");
            movie.add(3, "Star Trek: The Motion Picture");
            movie.add(4, "Star Wreck");
            for (int i=0;i<movie.size();i++)
            {
                int frontIndex = i + 1;
                System.out.print(frontIndex);
                System.out.print(". ");
                System.out.println(movie.get(i));
            }
    }
    
    public static void printMovies (int rank, String movieName)
    {
        System.out.print(rank);
        System.out.print(". ");
        System.out.println(movieName);
    }

    public static void printMovies(String movieList)
    {
        String[] movies = movieList.split(",");
        for (int j=0;j<movies.length;j++)
        {
            int indexFront = j+1;
            System.out.print(indexFront);
            System.out.print(". ");
            System.out.println(movies[j]);
        }
    }

    public static void main(String [] args)
    {
        printMovies();
        System.out.println();
        printMovies(1, "Star Trek The Motion Picture");
        printMovies(4,"Star Wars Revenge of the Sith");
        printMovies("Star Wars,Star Trek: The Motion Picture,Interstellar,Oblivion,Star Trek Beyound");
    }
}