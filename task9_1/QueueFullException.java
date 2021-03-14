package task9_1;

class QueueFullException extends Exception {
    int size;
    QueueFullException(int s) {
        size = s;
    }
    public String toString() {
        return "\nQueue is full. Max size of queue is: " + size;
    }
}