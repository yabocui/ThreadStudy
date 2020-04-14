package JUC.FunctionInterfaceTest;

import java.util.function.Function;

public class FunctionInterface {

    public static void main(String[] args) {
        Function<Integer,String> function=new Function<Integer, String>() {
            @Override
            public String apply(Integer i) {
                return "cui";
            }
        };

        System.out.println(function.apply(3));

        Function function1=(s)->{
            return "yabo";
        };
        System.out.println(function1.apply(3));
    }
}
