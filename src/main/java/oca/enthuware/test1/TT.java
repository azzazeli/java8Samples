package oca.enthuware.test1;

public class TT extends Thread {
    TT(String t){
        super(t);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        TT t1 = new TT("min");
        t1.setPriority(MIN_PRIORITY);
        TT t2 = new TT("max");
        t2.setPriority(MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
