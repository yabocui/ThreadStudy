package JUC.CallalbeTest;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("线程" + Thread.currentThread().getName() + "打印：" + "This is very good!");
        return "very good";
    }
}
