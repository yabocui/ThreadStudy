package JUC.CollectionTest;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
//        List list = new ArrayList();
//
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(8));
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }

//
//        List list = new Vector();
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                list.add("A");
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }


//        List list = Collections.synchronizedList(new ArrayList<>());
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                list.add("A");
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }

        List list = new CopyOnWriteArrayList();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add("A");
                System.out.println(list);
            }, String.valueOf(i)).start();
        }




    }
}
