package JUC.ThreadNotify;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        }, "线程B").start();


        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                shareResource.print5();
            }
        }, "线程A").start();

        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                shareResource.print15();
            }
        }, "线程C").start();

    }
}
