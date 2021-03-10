/*
    demo shows basics of THROWS operator
*/


class ThrowsDemo {
    public static char promt(String str)
        throws java.io.IOException {
            System.out.println(str + ": ");
            return (char) System.in.read();
        }

    public static void main(String[] args) {
        char ch;

        try {
            ch = promt("Enter a letter");
        }
        catch(java.io.IOException  exc) {
            System.out.println("Exception of input-output");
            ch = 'X';
        }

        System.out.println("Key " + ch + " was pressed");
    }
}