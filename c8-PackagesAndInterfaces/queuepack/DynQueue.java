package queuepack;

//A dynamic queue
class DynQueue implements ICharQ {
    private char[] q; // this array holds the queue
    private int putloc, getloc; // the put and get indeces

    // Construct an empty queue given its size
    public DynQueue(int size) {
        q = new char[size]; // allocate memory for queue
        putloc = getloc = 0;
    }

    // Put a character into the queue
    public void put(char ch) {
        if (putloc == q.length) {
            // increse queue size
            char[] t = new char[q.length * 2];
            // copy elements into new queue
            for (int i = 0; i < q.length; i++)
                t[i] = q[i];
            q = t;
        }
        q[putloc++] = ch;
    }

    // Get a character fron the queue
    public char get() {
        if (getloc == putloc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        return q[getloc++];
    }

}