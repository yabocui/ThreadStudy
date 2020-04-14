package JUC.StreamTest;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        User user1 = new User(1, "cui", 22);
        User user2 = new User(2, "ya", 23);
        User user3 = new User(3, "bo", 24);
        User user4 = new User(4, "huang", 25);
        User user5 = new User(5, "jie", 26);
        User user6 = new User(6, "jin", 27);
        User user7 = new User(7, "jun", 28);
        User user8 = new User(8, "bing", 20);

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8);

        list.stream().filter(s -> {
            return s.getId() % 2 == 0;
        }).filter((s)->{
            return s.getAge()>24;
        }).map((s)->{
            s.setName(s.getName().toUpperCase());
            return s;
        }).sorted((a,b)->{return 1;}).limit(1).forEach((s)->{
            System.out.println(s.getName());
        });

    }
}
