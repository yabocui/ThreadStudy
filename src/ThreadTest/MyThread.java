package ThreadTest;

public class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("线程："+Thread.currentThread().getName()+" is running");
    }

    public MyThread(String threadName){
        super(threadName);
    }
}
