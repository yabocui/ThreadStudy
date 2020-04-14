package JUC.CallalbeTest;

import com.sun.org.apache.xpath.internal.functions.FuncTrue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new CallableTest());
        new Thread(futureTask, "AAA").start();
        new Thread(futureTask, "BBB").start();

        try {
            System.out.println(futureTask.get());
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        FutureTask futureTask1 = new FutureTask(() -> {
            System.out.println("测试成功");
            return "cuiybo";
        });

        new Thread(futureTask1, "BBB").start();

        try {
            System.out.println(futureTask1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
