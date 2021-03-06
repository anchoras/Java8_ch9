/*
    demo program shows basics of error and exception catching in java
*/

class ExceptionsDemo {
    public static void main(String args[]) {
        int numsNumer[] = { 4, 8, 16, 32, 64, 128, 512 };
        int numsDenum[] = { 2, 0, 4, 4, 0, 8, 16, 2 };

        try {
            for(int i = 0; i<numsDenum.length; i++) {
                try {
                    System.out.println(numsNumer[i] + "/" + numsDenum[i] +
                                        " = " + numsNumer[i]/numsDenum[i]);
                }

                //catch (Throwable exc) {
                catch (ArithmeticException exc) {
                    System.out.println("Dividing by zero");
                }
            }
        }
        //catch (Throwable exc) {
        catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Out of array range");
        }
    }
}