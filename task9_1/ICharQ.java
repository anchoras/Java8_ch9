package task9_1;

public interface ICharQ {
    void put(char ch) throws QueueFullException;
    char get() throws QueueEmptyException;
    int getLength();
    void reset();
}