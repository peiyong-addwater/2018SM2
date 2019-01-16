public class Rectangle extends Shape {

        private Double width;
        private Double height;
        public Rectangle(Double width, Double height) {
            this.width = width;
            this.height = height;
        }
    
        @Override
        public Double perimeter() {
            return (2 * width) + (2 * height);
        }
    
        @Override
        public Double area() {
            return width * height;
        }
    
        @Override
        public String toString() {
            return String.format("%s(%s,%s)", super.toString(), this.width, this.height);
        }
    }