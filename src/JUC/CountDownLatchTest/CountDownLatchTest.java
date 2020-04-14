package JUC.CountDownLatchTest;


import java.util.concurrent.CountDownLatch;

//班级里一共有7个人，班长要在其他6个人都走了以后再锁门
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            final int tmp=i;
            new Thread(() -> {
                System.out.println("同学" + tmp + "离开");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("班长锁门");
    }

}
