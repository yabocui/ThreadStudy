package JUC.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {


    public static void main(String[] args) {
            ExecutorService executorService = Executors.newFixedThreadPool(3);

//        ExecutorService executorService = Executors.newCachedThreadPool();

//    ExecutorService executorService=Executors.newSingleThreadExecutor();

        for (int i = 0; i < 100; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"窗口开始办理业务");
            });
        }

        for (int i = 0; i < 100; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"窗口开始办理业务aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            });
        }
        executorService.shutdown();

    }

}
