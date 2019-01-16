public class Circle extends Shape {

        private Double radius;
        public Circle(Double radius){
            this.radius = radius;
        }
    
        @Override
        public Double perimeter() {
            return 2 * Math.PI * radius;
        }
    
        @Override
        public Double area() {
            return Math.PI * (radius * radius);
        }
    
        @Override
        public String toString() {
            return String.format("%s(%s)", super.toString(), this.radius.toString());
        }
    }