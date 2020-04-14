package JUC.SaleTickets;

//资源类
public class Tickets {

    private int tickets=100;

    synchronized  public   void sale(){
        if (tickets>0){
            System.out.println("线程："+Thread.currentThread().getName()+"卖出第"+tickets+"张票");
            tickets--;
        }
    }
}
