package JUC.FunctionInterfaceTest;

import java.util.function.Supplier;

public class SupplyInterface {
    public static void main(String[] args) {
        Supplier<String> supplier=new Supplier<String>() {
            @Override
            public String get() {
                return "good";
            }
        };
        System.out.println(supplier.get());


        Supplier<String> supplier1 =()->{
            return "good2";
        };

        System.out.println(supplier1.get());
    }
}
