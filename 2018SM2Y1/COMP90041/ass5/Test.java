public class Test {

        public static void main(String[] args){
            Shape circle = new Circle(1.0);
            Shape rectangle = new Rectangle(10.0, 8.0);
    
            System.out.println(circle.toString());
            System.out.println(rectangle.toString());
            System.out.println("Area of unit circle is "+circle.area() );
        }
    }