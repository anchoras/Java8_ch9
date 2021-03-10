/*
    demo program shows using FINALLY operator basics
*/


class UseFinally {
    static public void genException(int what) {
        int t;
        int nums[] = new int[2];

        System.out.println("What has been got:" + what);
        try {
            switch(what) {
                case 0:
                    t = 10/what;
                    return;
                case 1:
                    nums[4] = 4;
                    return;
                default:
                    System.out.println("Something went wrong...");
                    return;
            }
        }
        catch(ArithmeticException exc) {
            System.out.println("Dividing by zero");
        }
        catch(ArrayIndexOutOfBoundsException exc) {
            System.out.println("Out of array range");
        }
        finally {
            System.out.println("Ending TRY block");
        }
    }
}

class FinallyDemo {
    public static void main(String args[]) {
        for (int i=0; i<3; i++) {
            UseFinally.genException(i);
            System.out.println();
        }
    }
}