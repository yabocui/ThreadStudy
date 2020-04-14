package JUC.CyclicBarrierTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("收集齐了7颗龙珠，神龙出现");
        });

        for (int i = 0; i < 7; i++) {
            final int tmp = i;
            new Thread(()->{
                System.out.println("收集到第"+tmp+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
