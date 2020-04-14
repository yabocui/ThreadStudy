package JUC.SemaphoreTest;


import java.util.concurrent.Semaphore;

//3个停车位6辆车要停进来
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);

        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+",我抢到车位了，我要在车里美美的睡3秒...");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+",我睡醒了，谁的好舒服，我要开走了");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }

}
