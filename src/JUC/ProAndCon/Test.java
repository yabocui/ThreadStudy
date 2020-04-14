package JUC.ProAndCon;


//实现生产一个蛋糕，一个人吃蛋糕，如果蛋糕个数为0就生产，如果蛋糕个数为1就吃
public class Test {
    public static void main(String[] args) {
        Cake cake = new Cake();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                cake.consumeCake(i);
            }
        }, "consumer1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                cake.consumeCake(i);
            }
        }, "consumer2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                cake.consumeCake(i);
            }
        }, "consumer3").start();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                cake.produceCake(i);
            }
        }, "producer").start();

    }
}
