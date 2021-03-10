/*
    demo program shows basic example of using THROW operator
*/


class Rethrow {
    public static void getException() {
        int numsNumer[] = { 4, 8, 16, 32, 64, 128, 512 };
        int numsDenum[] = { 2, 0, 4, 4, 0, 8, 16, 2 };

        for(int i=0; i<numsDenum.length; i++) {
            try {
                System.out.println(numsNumer[i] + "/" + numsDenum[i] +
                                    " = " + numsNumer[i]/numsDenum[i]);
            }
            catch (ArithmeticException exc) {
                System.out.println("Dividing by zero");
            }
            catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("Out of array range");
                throw exc;
            }
        }
        System.out.println("After CATCH block");
    }
}

class ThrowDemo {
    public static void main(String args[]) {
        try {
            Rethrow.getException();
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("CATHing in main");
        }
    }
}