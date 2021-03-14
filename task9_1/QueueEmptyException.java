package task9_1;

class QueueEmptyException extends Exception {
    public String toString() {
        return "Queue is empty";
    }
}