package JUC.CompletableFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName()+"这是一个新的线程");
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"没有返回值");
//        });
//        try {
//            completableFuture.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"这个是主线程打印的");

        CompletableFuture<Integer> completableFuture1 =CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t completableFuture1,我要睡觉了");

            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"\t completableFuture1,我睡醒了");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            int age=10/0;
            return 102;
        });

        CompletableFuture<Integer> test=completableFuture1.thenApplyAsync((s)->{
             System.out.println(Thread.currentThread().getName()+"这是一个新的线程");
        return 5;
    });
//
//        test.get();

        System.out.println("This is main method");

        Thread.sleep(10000);
//
//        System.out.println((t,u)->{
//            System.out.println("**********"+t);
//            System.out.println("^^^^^^^^^^^^^^^^^"+u);
//        });
    }
}
