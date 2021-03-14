/*
    demo program for task 9.1
    custom exceptions for full queue and empty queue
*/

package task9_1;

import task9_1.ICharQ;


class QExcDemo {
    public static void main(String args[]) {
        LinearFixedQueue qLF = new LinearFixedQueue(10);
        char ch;
        int i;

        try {
            for(i=0; i<11; i++) {
                System.out.println("trying to save " + (char)('A'+i));
                qLF.put((char) ('A' + i));
                System.out.println("...ok");
            }
        }
        catch(QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();

        try {
            for(i=0; i<11; i++) {
                System.out.println("trying to get " + i + "-th letter");
                ch = qLF.get();
                System.out.println("...ok ch = " + ch);
            }
        }
        catch(QueueEmptyException exc) {
            System.out.println(exc);
        }
    }
}