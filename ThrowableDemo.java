/*
    demo shows basics of using THROWABLE
*/


class excTest {
    static void genException() {
        int nums[] = new int[4];
        System.out.println("Before generating of exception");
        nums[7] = 10;
    }
}

class ThrowableDemo {
    public static void main(String args[]) {
        try {
            excTest.genException();
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Standart message: ");
            System.out.println(exc);
            System.out.println("\nCall stack: ");
            exc.printStackTrace();
            System.out.println("\nLocalized: ");
            exc.getLocalizedMessagegit();
        }
        System.out.println("After CATCH operator");
    }
}