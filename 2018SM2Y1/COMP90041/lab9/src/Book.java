public class Book extends LibraryItem
{
        private String author;
        private final int daysBorrow = 21;

        public Book(int circulationCodeInt, String titleString) {
                super(circulationCodeInt, titleString);
        }
}
