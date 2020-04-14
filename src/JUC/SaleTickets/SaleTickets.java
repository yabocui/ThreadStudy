package JUC.SaleTickets;

//2个售票员卖出30张票
public class SaleTickets {
    public static void main(String[] args) {
//        Tickets tickets=new Tickets();
//        new Thread(()->{
//            for (int i=0;i<40;i++){
//                tickets.sale();
//            }
//        },"AAA").start();
//
//        new Thread(()->{
//            for (int i=0;i<40;i++){
//                tickets.sale();
//            }
//        },"BBB").start();


        TicketsNew ticketsNew=new TicketsNew();

        new Thread(()->{
            for (int i=0;i<40;i++){
                ticketsNew.sale();
            }
        },"AAA").start();

        new Thread(()->{
            for (int i=0;i<40;i++){
                ticketsNew.sale();
            }
        },"BBB").start();

    }

}
