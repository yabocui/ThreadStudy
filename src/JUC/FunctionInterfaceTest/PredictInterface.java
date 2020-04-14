package JUC.FunctionInterfaceTest;

import java.util.function.Predicate;

public class PredictInterface {

    public static void main(String[] args) {
        Predicate<String> predicate=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

        System.out.println(predicate.test("haha"));

        Predicate<String> predicate1=(s)->{
            return true;
        };
        System.out.println(predicate1.test("bb"));
    }

}
