package JUC.FunctionInterfaceTest;

import java.util.function.Consumer;

public class ConsumerInterface {

    public static void main(String[] args) {


        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("haha");

        Consumer<String> consumer1=(s)->{
            System.out.println(s);
        };
        consumer1.accept("time");
    }
}
