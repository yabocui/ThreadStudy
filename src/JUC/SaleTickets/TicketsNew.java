package JUC.SaleTickets;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源类
public class TicketsNew {

    private int tickets=30;
    private Lock lock=new ReentrantLock();

    public   void sale()  {
        lock.lock();
        if (tickets>0){
            System.out.println("线程："+Thread.currentThread().getName()+"卖出第"+tickets+"张票");
            tickets--;
        }
        lock.unlock();
    }

}
