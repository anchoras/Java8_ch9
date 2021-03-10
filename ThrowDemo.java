/*
    demo program shows basic example of using THROW operator
*/


class ThrowDemo {
    public static void main(String args[]) {
        try {
            for(int i=0; i<3; i++) {
                try {
                    System.out.println("Before THROW operator");
                    throw new ArithmeticException();
                }
                catch (ArithmeticException exc) {
                    System.out.println("Inner CATCHing arithmetic exception");
                }
            }
        }
        catch (ArithmeticException exc) {
            System.out.println("Outer CATCHing arithmetic exception");
        }
        System.out.println("After CATCH block");
    }
}