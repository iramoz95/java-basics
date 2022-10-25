/*
Try This 11-1
Extend Thread.
*/
class MyThread extends Thread {
    // Construc a new thread
    MyThread(String name) {
        super(name);// name thread
    }

    // A factory method that creates and starts a thread
    public static MyThread createAndStart(String name) {
        MyThread myThrd = new MyThread(name);
        myThrd.start();// start the thread
        return myThrd;
    }

    // Entry of point of thread
    public void run() {
        System.out.println(getName() + " starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + getName() + ", count is " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(getName() + " interrupted.");
        }
        System.out.println(getName() + " terminating.");

    }
}

class ExtendThread {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");
        MyThread.createAndStart("Child #1");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Main thread ending.");
            }
        }
        System.out.println("Main thread ending.");
        ;
    }
}