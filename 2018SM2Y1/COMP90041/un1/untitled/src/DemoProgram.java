public class DemoProgram {
        public static void main(String[] args){
                ClassA myObj1 = new ClassA();
                ClassA myObj2 = new ClassA();
                myObj1.a=2;
                System.out.println(myObj1.a);
                System.out.println(myObj2.a);
                myObj2.a = 2;
                ClassB.ResetA1(myObj1);
                System.out.println(myObj1.a);
                System.out.println(myObj2.a);
                ClassB.ResetA2(myObj2);
                System.out.println(myObj2.a);
                System.out.println(myObj1.a);
        }
}
