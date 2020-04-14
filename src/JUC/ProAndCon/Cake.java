package JUC.ProAndCon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//蛋糕资源类
public class Cake {
    private int cakeNum = 0;

    private Lock lock=new ReentrantLock();

//    private Lock consumerLock=new ReentrantLock();

    private Condition condition=lock.newCondition();

//    private Condition consumerCondition=proLock.newCondition();

//    public synchronized void produceCake(int i) {
//        try {
//            while (cakeNum == 1) {
////                System.out.println("第 " + i + " 次开始生产蛋糕等待");
//                this.wait();
//            }
//            System.out.println("线程"+Thread.currentThread().getName()+"第 " + i + " 次开始生产蛋糕，蛋糕个数为："+cakeNum);
//            cakeNum++;
//            this.notifyAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public synchronized void consumeCake(int i) {
//        try {
//            while (cakeNum == 0) {
////                System.out.println("第 " + i + " 次开始消费蛋糕等待");
//                this.wait();
//            }
//            System.out.println("线程"+Thread.currentThread().getName()+"第 " + i + " 开始吃蛋糕，蛋糕个数为："+cakeNum);
//            cakeNum--;
//            this.notifyAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public  void produceCake(int i) {
        lock.lock();
        try {
            while (cakeNum == 1) {
//                System.out.println("第 " + i + " 次开始生产蛋糕等待");
                condition.await();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"第 " + i + " 次开始生产蛋糕，蛋糕个数为："+cakeNum);
            cakeNum++;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public synchronized void consumeCake(int i) {
        lock.lock();
        try {
            while (cakeNum == 0) {
//                System.out.println("第 " + i + " 次开始消费蛋糕等待");
                condition.await();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"第 " + i + " 开始吃蛋糕，蛋糕个数为："+cakeNum);
            cakeNum--;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
