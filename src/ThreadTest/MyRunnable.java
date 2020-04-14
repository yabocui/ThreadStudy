package ThreadTest;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程："+Thread.currentThread().getName()+" is running");
    }
}
