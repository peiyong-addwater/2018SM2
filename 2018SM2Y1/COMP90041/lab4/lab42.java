public class lab42
{
    public static boolean isFavouriate(String movie)
    {
        String listOfFavourite = "Star Wars, Star Trek: The Motion Picture, Interstellar, Oblivion, Star Trek Beyound";
        return listOfFavourite.contains(movie);
    }

    

    public static void main(String[] args)
    {
        boolean result = isFavouriate("Star Trek The Beyound");
        System.out.println(result);
    }
}