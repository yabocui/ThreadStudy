package ThreadTest;

public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(new MyRunnable(), "AAA");
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程：" + Thread.currentThread().getName() + " is running");
            }
        }, "BBB");
        thread2.start();

        Thread thread3 = new Thread(() -> {
            System.out.println("线程：" + Thread.currentThread().getName() + " is running");
        }, "CCC");
        thread3.start();

        MyThread thread4=new MyThread("DDD");
        thread4.start();

        System.out.println("线程" + Thread.currentThread().getName() + " is running");
    }
}
