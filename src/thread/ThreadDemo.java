package thread;

/**
 * Created by zhenya on 05.02.2015.
 */

public class ThreadDemo extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            compute();
        }
    }

    public static void main(String[] args) {
        ThreadDemo thread1 = new ThreadDemo();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    compute();
                }
            }
        });
        //Set priorety
        if (args.length >= 1) thread1.setPriority(Integer.parseInt(args[0]));
        if (args.length >= 2) thread2.setPriority(Integer.parseInt(args[1]));
        //Start thread
        thread1.start();
        thread2.start();
        for (int i = 0; i < 5; i++) {
            compute();
        }
    }

    static ThreadLocal numcalls = new ThreadLocal();

    static synchronized void compute() {
        //Count number call out
        Integer n = (Integer) numcalls.get();
        if (n == null) {
            n = new Integer(1);
        } else {
            n = new Integer(n.intValue() + 1);
        }
        numcalls.set(n);
        //Print name thread
        System.out.println(Thread.currentThread().getName() + ": " + n);
        //Load task
        for(int i = 0, j = 0; i < 1000000; i++) {
            j += i;
        }
        try {
            Thread.sleep((int) (Math.random()*100+1));
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        Thread.yield();
    }
}