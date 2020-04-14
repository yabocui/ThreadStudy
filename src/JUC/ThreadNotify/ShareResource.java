package JUC.ThreadNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareResource {
    private int index = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (index != 1) {
                condition1.await();
            }
            System.out.println("线程"+Thread.currentThread().getName()+",打印5次");
            index=2;
            condition2.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (index != 2) {
                condition2.await();
            }
            System.out.println("线程"+Thread.currentThread().getName()+",打印10次");
            index=3;
            condition3.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (index != 3) {
                condition3.await();
            }
            System.out.println("线程"+Thread.currentThread().getName()+",打印15次");
            index=1;
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
