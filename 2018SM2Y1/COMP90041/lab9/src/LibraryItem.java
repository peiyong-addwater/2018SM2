public class LibraryItem
{
        private int circulationCodeInt;
        private String titleString;

        public LibraryItem(int circulationCodeInt, String titleString)
        {
                this.circulationCodeInt = circulationCodeInt;
                this.titleString = titleString;

        }

        public int getCirculationCodeInt()
        {
                return this.circulationCodeInt;
        }

        public String getTitleString()
        {
                return this.titleString;
        }


}
