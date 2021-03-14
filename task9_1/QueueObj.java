package task9_1;

import task9_1.ICharQ;

abstract class QueueObj implements ICharQ {
    protected char q[];
    protected int putloc, getloc;

    public QueueObj(int size) {
        q = new char[size+1];
        putloc = getloc = 0;
    }

    public QueueObj(QueueObj obj) {
        this.q = new char[obj.q.length];
        this.putloc = obj.putloc;
        this.getloc = obj.getloc;
    }

/*     abstract void put(char ch);
    abstract char get();
    abstract int getLength();
    abstract void reset(); */
    abstract void copyFromQueue(QueueObj obj);
}

class LinearFixedQueue extends QueueObj implements ICharQ {
    public LinearFixedQueue(int size) {
        super(size);
    }
    public LinearFixedQueue(LinearFixedQueue obj) {
        super(obj);
    }

    public void put(char ch)
        throws QueueFullException {
        if (putloc>q.length-1) {
            System.out.println("Out of range -- putloc exedeed queue length");
            return;
        }
        else if (putloc<0) {
            System.out.println("Out of range -- putloc is negative");
            return;
        }
        else if (putloc==q.length-1) {
            System.out.println("Queue is full");
            return;
        }

        putloc++;
        q[putloc] = ch;
    }

    public char get()
        throws QueueEmptyException {
        if (getloc>q.length-1) {
            System.out.println("Out of range -- getloc exedeed queue length");
            return (char) -999;
        }
        else if (getloc<0) {
            System.out.println("Out of range -- getloc is negative");
            return (char) -1;
        }
        else if (getloc==putloc) {
            System.out.println("Queue is empty");
            return (char) 0;
        }
        
        getloc++;
        return q[getloc];
    }

    public int getLength() {
        return q.length;
    }

    public void reset() {
        q = new char[q.length];
        putloc = getloc = 0;
    }

    void copyFromQueue(QueueObj obj) {
        int sourceArrDataLength = obj.putloc-obj.getloc;
        System.out.println("obj sourceArrDataLength: " + sourceArrDataLength +
                            "\nobj putloc: " + obj.putloc + "\nobj getloc: " + obj.getloc);
        if((this.q.length-1)<sourceArrDataLength) {
            System.out.println("This static linear queue is shorter than source data array");
            return;
        }
        for(int i=0; i<sourceArrDataLength; i++)
            this.q[i] = obj.q[i];
        this.getloc = 0;
        this.putloc = sourceArrDataLength;
        System.out.println("this putloc: " + this.putloc);
    }
}
/*
class CircularFixedQueue extends QueueObj implements ICharQ {
    public CircularFixedQueue(int size) {
        super(size);
    }
    public CircularFixedQueue(LinearFixedQueue obj) {
        super(obj);
    }

    public void put(char ch) {
        if (putloc>q.length-1) {
            System.out.println("Out of range -- putloc exedeed queue length");
            return;
        }
        else if (putloc<0) {
            System.out.println("Out of range -- putloc is negative");
            return;
        }
        else if (((putloc+1)==getloc) | ((putloc==(q.length-1)) & (getloc==0))) {
            System.out.println("Queue is full");
            return;
        }

        putloc++;
        if(putloc==q.length)
            putloc = 0;
        q[putloc] = ch;
    }

    public char get() {
        if (getloc>q.length-1) {
            System.out.println("Out of range -- getloc exedeed queue length");
            return (char) -999;
        }
        else if (getloc<0) {
                System.out.println("Out of range -- getloc is negative");
            return (char) -1;
        }
        else if (getloc==putloc) {
            System.out.println("Queue is empty");
            return (char) 0;
        }

        getloc++;
        if(getloc==q.length)
            getloc = 0;
        return q[getloc];
    }

    public int getLength() {
        return q.length;
    }

    public void reset() {
        q = new char[q.length];
        putloc = getloc = 0;
    }

    void copyFromQueue(QueueObj obj) {
        int sourceArrDataLength;
        if(obj.putloc >= obj.getloc)
            sourceArrDataLength = obj.putloc-obj.getloc;
        else
            sourceArrDataLength = obj.q.length-(obj.getloc-obj.putloc);
        if(this.q.length<sourceArrDataLength) {
            System.out.println("This static circular queue is shorter than source data array");
            return;
        }
        for(int i=0; i<sourceArrDataLength; i++)
            this.q[i] = obj.q[i];
        this.getloc = 0;
        this.putloc = sourceArrDataLength; 
    }
}

class CircularDynamicQueue extends QueueObj implements ICharQ {
    public CircularDynamicQueue(int size) {
        super(size);
    }
    public CircularDynamicQueue(LinearFixedQueue obj) {
        super(obj);
    }

    public void put(char ch) {
        if (putloc>q.length-1) {
            System.out.println("Out of range -- putloc exedeed queue length");
            return;
        }
        else if (putloc<0) {
            System.out.println("Out of range -- putloc is negative");
            return;
        }
        else if (((putloc+1)==getloc) | ((putloc==(q.length-1)) & (getloc==0))) {
            char t[] = new char[q.length*2];
            for(int i=0; i<q.length; i++)
                t[i] = q[i];
            q = t;
        }

        putloc++;
        if(putloc==q.length)
            putloc = 0;
        q[putloc] = ch;
    }

    public char get() {
        if (getloc>q.length-1) {
            System.out.println("Out of range -- getloc exedeed queue length");
            return (char) -999;
        }
        else if (getloc<0) {
                System.out.println("Out of range -- getloc is negative");
            return (char) -1;
        }
        else if (getloc==putloc) {
            System.out.println("Queue is empty");
            return (char) 0;
        }

        getloc++;
        if(getloc==q.length)
            getloc = 0;
        return q[getloc];
    }

    public int getLength() {
        return q.length;
    }

    public void reset() {
        q = new char[q.length];
        putloc = getloc = 0;
    }

    void copyFromQueue(QueueObj obj) {
        int sourceArrDataLength;
        if(obj.putloc >= obj.getloc)
            sourceArrDataLength = obj.putloc-obj.getloc;
        else
            sourceArrDataLength = obj.q.length-(obj.getloc-obj.putloc);
        if(this.q.length<sourceArrDataLength) {
            System.out.println("This dynamic circular queue is shorter than source data array" +
                                "\nWidering this circular queue");
            char t[] = new char[this.q.length*2];
            for(int i=0; i<this.q.length; i++)
                t[i] = q[i];
            q = t;
        }
        for(int i=0; i<sourceArrDataLength; i++)
            this.q[i] = obj.q[i];
        this.getloc = 0;
        this.putloc = sourceArrDataLength; 
    }
}

class LinearDynamicQueue extends QueueObj implements ICharQ {
    public LinearDynamicQueue(int size) {
        super(size);
    }
    public LinearDynamicQueue(LinearFixedQueue obj) {
        super(obj);
    }

    public void put(char ch) {
        if (putloc>q.length-1) {
            System.out.println("Out of range -- putloc exedeed queue length more than by '1' ");
            return;
        }
        else if (putloc<0) {
            System.out.println("Out of range -- putloc is negative");
            return;
        }
        else if (putloc==q.length-1) {
            //System.out.println("Queue is full");
            // creating new array + copying existed into this new one:
            char t[] = new char[q.length*2];
            for(int i=0; i<q.length; i++)
                t[i] = q[i];
            q = t;
        }
            putloc++;
            q[putloc] = ch;
    }

    public char get() {
        if (getloc>q.length-1) {
            System.out.println("Out of range -- getloc exedeed queue length");
            return (char) -999;
        }
        else if (getloc<0) {
            System.out.println("Out of range -- getloc is negative");
            return (char) -1;
        }
        else if (getloc==putloc) {
            System.out.println("Queue is empty");
            return (char) 0;
        }

        getloc++;
        return q[getloc];
    }

    public int getLength() {
        return q.length;
    }

    public void reset() {
        q = new char[q.length];
        putloc = getloc = 0;
    }

    void copyFromQueue(QueueObj obj) {
        int sourceArrDataLength = obj.putloc-obj.getloc;
        if((this.q.length-1)<sourceArrDataLength) {
            System.out.println("This dynamic linear queue is shorter than source data array" +
                                "\nWidering this circular queue");
            char t[] = new char[this.q.length*2];
            for(int i=0; i<this.q.length; i++)
                t[i] = q[i];
            q = t;
        }
        for(int i=0; i<sourceArrDataLength; i++)
            this.q[i] = obj.q[i];
        this.getloc = 0;
        this.putloc = sourceArrDataLength; 
    }
}
*/