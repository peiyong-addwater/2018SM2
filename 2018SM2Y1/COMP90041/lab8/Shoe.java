public class Shoe
{
        private String colour;
        private String designer;
        private float size;
        
        public Shoe(String colour, String designer, float size)
        {
                this.size = size;
                this.colour = colour;
                this.designer = designer;
        }

        public void setColour(String colour)
        {
                this.colour = colour;
        }

        public void setDesigner(String designer)
        {
                this.designer = designer;
        }

        public void setSize(float size)
        {
                this.size = size;
        }
        
        public String getColour()
        {
                return this.colour;
        }
        public String getDesigner()
        {
                return this.designer;
        }
        public float getSize()
        {
                return this.size;
        }




        
}