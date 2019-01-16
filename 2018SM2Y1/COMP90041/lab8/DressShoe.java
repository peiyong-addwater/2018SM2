public class DressShoe extends Shoe
{
        private Heel heel;
        
        public DressShoe(String colour, String designer, float size, Heel heel)
        {
                super(colour, designer, size);
                this.heel = heel;

        }

        public void setHeel(Heel heel)
        {
                this.heel = heel;
        }

        public Heel getHeel()
        {
                return this.heel;
        }

}

enum Heel
{
       pump, heel, flat
}
