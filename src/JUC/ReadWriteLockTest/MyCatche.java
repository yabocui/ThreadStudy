package JUC.ReadWriteLockTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCatche {


    private List list = new ArrayList();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void addEle(String element) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 开始写数据:" + element);
            list.add(element);
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " 开始写入完成:" + element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void readEle() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 开始度数据:");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " 开始读取完成:");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

}
