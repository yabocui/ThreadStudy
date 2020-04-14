package JUC.ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 2L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 9; i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"正在运行");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"运行结束");

            });
        }
        threadPool.shutdown();
    }
}
